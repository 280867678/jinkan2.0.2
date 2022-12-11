package com.arialyy.aria.m3u8.vod;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.common.CompleteInfo;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.event.Event;
import com.arialyy.aria.core.event.EventMsgUtil;
import com.arialyy.aria.core.event.PeerIndexEvent;
import com.arialyy.aria.core.inf.IThreadStateManager;
import com.arialyy.aria.core.loader.IInfoTask;
import com.arialyy.aria.core.loader.IRecordHandler;
import com.arialyy.aria.core.loader.IThreadTaskBuilder;
import com.arialyy.aria.core.manager.ThreadTaskManager;
import com.arialyy.aria.core.processor.IVodTsUrlConverter;
import com.arialyy.aria.core.task.ThreadTask;
import com.arialyy.aria.exception.AriaException;
import com.arialyy.aria.exception.AriaM3U8Exception;
import com.arialyy.aria.m3u8.BaseM3U8Loader;
import com.arialyy.aria.m3u8.M3U8Listener;
import com.arialyy.aria.m3u8.M3U8TaskOption;
import com.arialyy.aria.m3u8.M3U8ThreadTaskAdapter;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public final class M3U8VodLoader extends BaseM3U8Loader {
    public int EXEC_MAX_NUM;
    public String mCacheDir;
    public PeerIndexEvent mCurrentEvent;
    public ArrayBlockingQueue<TempFlag> mFlagQueue;
    public ExecutorService mJumpThreadPool;
    public Looper mLooper;
    public M3U8TaskOption mM3U8Option;
    public Handler mStateHandler;
    public ReentrantLock LOCK = new ReentrantLock();
    public ReentrantLock EVENT_LOCK = new ReentrantLock();
    public ReentrantLock JUMP_LOCK = new ReentrantLock();
    public Condition mWaitCondition = this.LOCK.newCondition();
    public Condition mEventQueueCondition = this.EVENT_LOCK.newCondition();
    public Condition mJumpCondition = this.JUMP_LOCK.newCondition();
    public SparseArray<ThreadRecord> mBeforePeer = new SparseArray<>();
    public SparseArray<ThreadRecord> mAfterPeer = new SparseArray<>();
    public AtomicInteger afterPeerIndex = new AtomicInteger();
    public AtomicInteger beforePeerIndex = new AtomicInteger();
    public AtomicInteger mCompleteNum = new AtomicInteger();
    public AtomicInteger mCurrentFlagSize = new AtomicInteger();
    public boolean isJump = false;
    public boolean isDestroy = false;
    public Thread jumpThread = null;
    public ArrayBlockingQueue<PeerIndexEvent> mJumpQueue = new ArrayBlockingQueue<>(10);

    /* loaded from: classes3.dex */
    public static class TempFlag {
        public int threadId;
        public ThreadTask threadTask;

        public TempFlag() {
        }
    }

    public M3U8VodLoader(DTaskWrapper dTaskWrapper, M3U8Listener m3U8Listener) {
        super(dTaskWrapper, m3U8Listener);
        this.mM3U8Option = (M3U8TaskOption) dTaskWrapper.getM3u8Option();
        this.mFlagQueue = new ArrayBlockingQueue<>(this.mM3U8Option.getMaxTsQueueNum());
        this.EXEC_MAX_NUM = this.mM3U8Option.getMaxTsQueueNum();
        EventMsgUtil.getDefault().register(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTaskToQueue(ThreadRecord threadRecord) throws InterruptedException {
        ThreadTask createThreadTask = createThreadTask(this.mCacheDir, threadRecord, threadRecord.threadId);
        getTaskList().add(createThreadTask);
        getEntity().getM3U8Entity().setPeerIndex(threadRecord.threadId);
        TempFlag startThreadTask = startThreadTask(createThreadTask, threadRecord.threadId);
        if (startThreadTask != null) {
            this.mFlagQueue.put(startThreadTask);
        }
    }

    private ThreadTask createThreadTask(String str, ThreadRecord threadRecord, int i) {
        SubThreadConfig subThreadConfig = new SubThreadConfig();
        subThreadConfig.url = threadRecord.tsUrl;
        subThreadConfig.tempFile = new File(BaseM3U8Loader.getTsFilePath(str, threadRecord.threadId));
        subThreadConfig.isBlock = this.mRecord.isBlock;
        subThreadConfig.taskWrapper = this.mTaskWrapper;
        subThreadConfig.record = threadRecord;
        subThreadConfig.stateHandler = this.mStateHandler;
        subThreadConfig.peerIndex = i;
        subThreadConfig.threadType = SubThreadConfig.getThreadType(8);
        subThreadConfig.updateInterval = SubThreadConfig.getUpdateInterval(8);
        if (!subThreadConfig.tempFile.exists()) {
            FileUtil.createFile(subThreadConfig.tempFile);
        }
        ThreadTask threadTask = new ThreadTask(subThreadConfig);
        threadTask.setAdapter(new M3U8ThreadTaskAdapter(subThreadConfig));
        return threadTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ThreadRecord getThreadRecord() {
        ThreadRecord threadRecord;
        Exception e;
        ThreadRecord threadRecord2 = null;
        try {
            if (this.beforePeerIndex.get() == 0 && this.afterPeerIndex.get() < this.mAfterPeer.size()) {
                ThreadRecord valueAt = this.mAfterPeer.valueAt(this.afterPeerIndex.get());
                try {
                    this.afterPeerIndex.getAndIncrement();
                    threadRecord2 = valueAt;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return threadRecord;
                }
            }
        } catch (Exception e3) {
            threadRecord = threadRecord2;
            e = e3;
        }
        if (this.mBeforePeer.size() > 0) {
            if ((threadRecord2 != null && this.beforePeerIndex.get() == 0) || this.beforePeerIndex.get() >= this.mBeforePeer.size()) {
                return threadRecord2;
            }
            threadRecord = this.mBeforePeer.valueAt(this.beforePeerIndex.get());
            this.beforePeerIndex.getAndIncrement();
            return threadRecord;
        }
        return threadRecord2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleJump(PeerIndexEvent peerIndexEvent) {
        List<ThreadRecord> list;
        if (isBreak()) {
            ALog.m4191e(this.TAG, "任务已停止，处理跳转失败");
            return;
        }
        this.mCurrentEvent = peerIndexEvent;
        TaskRecord taskRecord = this.mRecord;
        if (taskRecord == null || (list = taskRecord.threadRecords) == null) {
            ALog.m4191e(this.TAG, "跳到指定位置失败，记录为空");
        } else if (peerIndexEvent.peerIndex >= list.size()) {
            ALog.m4191e(this.TAG, String.format("切片索引设置错误，切片最大索引为：%s，当前设置的索引为：%s", Integer.valueOf(this.mRecord.threadRecords.size()), Integer.valueOf(peerIndexEvent.peerIndex)));
        } else {
            ALog.m4189i(this.TAG, String.format("将优先下载索引【%s】之后的切片", Integer.valueOf(peerIndexEvent.peerIndex)));
            this.isJump = true;
            notifyWaitLock(false);
            this.mCurrentFlagSize.set(this.mFlagQueue.size());
            while (true) {
                try {
                    TempFlag poll = this.mFlagQueue.poll();
                    if (poll == null) {
                        break;
                    }
                    poll.threadTask.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ALog.m4192d(this.TAG, "完成停止队列中的切片任务");
        }
    }

    private void initData() {
        this.mCacheDir = getCacheDir();
        if (this.mM3U8Option.getJumpIndex() != 0) {
            this.mCurrentEvent = new PeerIndexEvent(((DTaskWrapper) this.mTaskWrapper).getKey(), this.mM3U8Option.getJumpIndex());
            resumeTask();
            return;
        }
        this.mCompleteNum.set(0);
        for (ThreadRecord threadRecord : this.mRecord.threadRecords) {
            if (!threadRecord.isComplete) {
                this.mAfterPeer.put(threadRecord.threadId, threadRecord);
            } else {
                this.mCompleteNum.getAndIncrement();
            }
        }
        mo4448getStateManager().updateStateCount();
        if (this.mCompleteNum.get() <= 0) {
            mo4447getListener().onStart(0L);
            return;
        }
        mo4447getListener().onResume((this.mCompleteNum.get() * 100) / this.mRecord.threadRecords.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyJumpQueue() {
        try {
            try {
                this.EVENT_LOCK.lock();
                this.mEventQueueCondition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.EVENT_LOCK.unlock();
        }
    }

    private synchronized void startJumpThread() {
        Thread thread = new Thread(new Runnable() { // from class: com.arialyy.aria.m3u8.vod.M3U8VodLoader.2
            @Override // java.lang.Runnable
            public void run() {
                while (!M3U8VodLoader.this.isBreak()) {
                    try {
                        M3U8VodLoader.this.EVENT_LOCK.lock();
                        PeerIndexEvent peerIndexEvent = null;
                        while (true) {
                            PeerIndexEvent peerIndexEvent2 = (PeerIndexEvent) M3U8VodLoader.this.mJumpQueue.poll(1L, TimeUnit.SECONDS);
                            if (peerIndexEvent2 == null) {
                                break;
                            }
                            peerIndexEvent = peerIndexEvent2;
                        }
                        if (peerIndexEvent != null) {
                            M3U8VodLoader.this.handleJump(peerIndexEvent);
                        }
                        M3U8VodLoader.this.mEventQueueCondition.await();
                        M3U8VodLoader.this.EVENT_LOCK.unlock();
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        });
        this.jumpThread = thread;
        thread.start();
    }

    private TempFlag startThreadTask(ThreadTask threadTask, int i) {
        if (isBreak()) {
            ALog.m4185w(this.TAG, "任务已停止，启动线程任务失败");
            return null;
        }
        ThreadTaskManager.getInstance().startThread(((DTaskWrapper) this.mTaskWrapper).getKey(), threadTask);
        mo4447getListener().onPeerStart(((DTaskWrapper) this.mTaskWrapper).getKey(), threadTask.getConfig().tempFile.getPath(), i);
        TempFlag tempFlag = new TempFlag();
        tempFlag.threadTask = threadTask;
        tempFlag.threadId = i;
        return tempFlag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startThreadTask() {
        ((VodRecordHandler) this.mRecordHandler).setOption(this.mM3U8Option);
        this.mRecord = this.mRecordHandler.getRecord(0L);
        this.mStateHandler = new Handler(this.mLooper, mo4448getStateManager().getHandlerCallback());
        mo4448getStateManager().setVodLoader(this);
        mo4448getStateManager().setLooper(this.mRecord, this.mLooper);
        initData();
        startTimer();
        new Thread(new Runnable() { // from class: com.arialyy.aria.m3u8.vod.M3U8VodLoader.1
            @Override // java.lang.Runnable
            public void run() {
                while (!M3U8VodLoader.this.isBreak()) {
                    try {
                        try {
                            M3U8VodLoader.this.JUMP_LOCK.lock();
                            if (M3U8VodLoader.this.isJump) {
                                M3U8VodLoader.this.mJumpCondition.await(5L, TimeUnit.SECONDS);
                                M3U8VodLoader.this.isJump = false;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            try {
                                M3U8VodLoader.this.LOCK.lock();
                                while (M3U8VodLoader.this.mFlagQueue.size() < M3U8VodLoader.this.EXEC_MAX_NUM && !M3U8VodLoader.this.isBreak() && M3U8VodLoader.this.mCompleteNum.get() != M3U8VodLoader.this.mRecord.threadRecords.size()) {
                                    ThreadRecord threadRecord = M3U8VodLoader.this.getThreadRecord();
                                    if (threadRecord != null && !threadRecord.isComplete) {
                                        M3U8VodLoader.this.addTaskToQueue(threadRecord);
                                    }
                                    ALog.m4192d(M3U8VodLoader.this.TAG, "记录为空或记录已完成");
                                }
                                if (M3U8VodLoader.this.mFlagQueue.size() > 0) {
                                    M3U8VodLoader.this.mWaitCondition.await();
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } finally {
                            M3U8VodLoader.this.LOCK.unlock();
                        }
                    } finally {
                        M3U8VodLoader.this.JUMP_LOCK.unlock();
                    }
                }
            }
        }).start();
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    public void addComponent(IThreadStateManager iThreadStateManager) {
        this.mStateManager = iThreadStateManager;
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    public void addComponent(IInfoTask iInfoTask) {
        this.mInfoTask = iInfoTask;
        final ArrayList arrayList = new ArrayList();
        this.mInfoTask.setCallback(new IInfoTask.Callback() { // from class: com.arialyy.aria.m3u8.vod.M3U8VodLoader.4
            @Override // com.arialyy.aria.core.loader.IInfoTask.Callback
            public void onFail(AbsEntity absEntity, AriaException ariaException, boolean z) {
                M3U8VodLoader.this.fail(ariaException, z);
            }

            @Override // com.arialyy.aria.core.loader.IInfoTask.Callback
            public void onSucceed(String str, CompleteInfo completeInfo) {
                M3U8VodLoader m3U8VodLoader;
                AriaM3U8Exception ariaM3U8Exception;
                List list;
                String bandWidthUrl;
                IVodTsUrlConverter vodUrlConverter = M3U8VodLoader.this.mM3U8Option.getVodUrlConverter();
                if (vodUrlConverter != null) {
                    if (TextUtils.isEmpty(M3U8VodLoader.this.mM3U8Option.getBandWidthUrl())) {
                        list = arrayList;
                        bandWidthUrl = M3U8VodLoader.this.getEntity().getUrl();
                    } else {
                        list = arrayList;
                        bandWidthUrl = M3U8VodLoader.this.mM3U8Option.getBandWidthUrl();
                    }
                    list.addAll(vodUrlConverter.convert(bandWidthUrl, (List) completeInfo.obj));
                } else {
                    arrayList.addAll((Collection) completeInfo.obj);
                }
                if (arrayList.isEmpty()) {
                    m3U8VodLoader = M3U8VodLoader.this;
                    ariaM3U8Exception = new AriaM3U8Exception(M3U8VodLoader.this.TAG, "获取地址失败");
                } else if (((String) arrayList.get(0)).startsWith("http")) {
                    M3U8VodLoader.this.mM3U8Option.setUrls(arrayList);
                    if (M3U8VodLoader.this.isStop) {
                        M3U8VodLoader.this.mo4447getListener().onStop(M3U8VodLoader.this.getEntity().getCurrentProgress());
                        return;
                    } else if (M3U8VodLoader.this.isCancel) {
                        M3U8VodLoader.this.mo4447getListener().onCancel();
                        return;
                    } else {
                        M3U8VodLoader.this.startThreadTask();
                        return;
                    }
                } else {
                    m3U8VodLoader = M3U8VodLoader.this;
                    ariaM3U8Exception = new AriaM3U8Exception(M3U8VodLoader.this.TAG, "地址错误，请使用IVodTsUrlConverter处理你的url信息");
                }
                m3U8VodLoader.fail(ariaM3U8Exception, false);
            }
        });
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    public void addComponent(IRecordHandler iRecordHandler) {
        this.mRecordHandler = iRecordHandler;
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    @Deprecated
    public void addComponent(IThreadTaskBuilder iThreadTaskBuilder) {
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoader
    public void checkComponent() {
        if (this.mRecordHandler != null) {
            if (this.mInfoTask == null) {
                throw new NullPointerException("文件信息组件为空");
            }
            if (mo4448getStateManager() == null) {
                throw new NullPointerException("任务状态管理组件为空");
            }
            return;
        }
        throw new NullPointerException("任务记录组件为空");
    }

    public void fail(AriaException ariaException, boolean z) {
        if (isBreak()) {
            return;
        }
        mo4447getListener().onFail(z, ariaException);
        onDestroy();
    }

    public SparseArray<ThreadRecord> getBeforePeer() {
        return this.mBeforePeer;
    }

    public int getCompleteNum() {
        return this.mCompleteNum.get();
    }

    public int getCurrentFlagSize() {
        this.mCurrentFlagSize.set(this.mFlagQueue.size());
        return this.mCurrentFlagSize.get();
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoader
    public long getFileSize() {
        return getEntity().getFileSize();
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoader
    /* renamed from: getListener  reason: collision with other method in class */
    public M3U8Listener mo4447getListener() {
        return (M3U8Listener) super.mo4447getListener();
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoader
    /* renamed from: getStateManager  reason: collision with other method in class */
    public VodStateManager mo4448getStateManager() {
        return (VodStateManager) this.mStateManager;
    }

    public File getTempFile() {
        return this.mTempFile;
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoader
    public void handleTask(Looper looper) {
        if (isBreak()) {
            return;
        }
        this.mLooper = looper;
        this.mInfoTask.run();
    }

    public boolean isJump() {
        return this.isJump;
    }

    @Event
    public synchronized void jumpPeer(PeerIndexEvent peerIndexEvent) {
        if (!peerIndexEvent.key.equals(((DTaskWrapper) this.mTaskWrapper).getKey())) {
            return;
        }
        if (isBreak()) {
            ALog.m4191e(this.TAG, "任务已停止，发送跳转事件失败");
            return;
        }
        if (this.jumpThread == null) {
            this.mJumpThreadPool = Executors.newSingleThreadExecutor();
            startJumpThread();
        }
        this.mJumpQueue.offer(peerIndexEvent);
        this.mJumpThreadPool.submit(new Runnable() { // from class: com.arialyy.aria.m3u8.vod.M3U8VodLoader.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(1000L);
                    M3U8VodLoader.this.notifyJumpQueue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void notifyWaitLock(boolean z) {
        TempFlag poll;
        try {
            try {
                this.LOCK.lock();
                if (z && (poll = this.mFlagQueue.poll(1L, TimeUnit.SECONDS)) != null) {
                    ALog.m4192d(this.TAG, String.format("切片【%s】完成", Integer.valueOf(poll.threadId)));
                }
                this.mWaitCondition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.LOCK.unlock();
        }
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoader
    public void onDestroy() {
        super.onDestroy();
        this.isDestroy = true;
        EventMsgUtil.getDefault().unRegister(this);
        ExecutorService executorService = this.mJumpThreadPool;
        if (executorService == null || executorService.isShutdown()) {
            return;
        }
        this.mJumpThreadPool.shutdown();
    }

    public synchronized void resumeTask() {
        SparseArray<ThreadRecord> sparseArray;
        int i;
        if (isBreak()) {
            ALog.m4191e(this.TAG, "任务已停止，恢复任务失败");
        } else if (this.mJumpQueue.size() > 0) {
            ALog.m4192d(this.TAG, "有新定位，取消上一次操作");
            notifyJumpQueue();
        } else {
            ALog.m4192d(this.TAG, "恢复切片任务");
            this.mBeforePeer.clear();
            this.mAfterPeer.clear();
            this.mFlagQueue.clear();
            this.afterPeerIndex.set(0);
            this.beforePeerIndex.set(0);
            this.mCompleteNum.set(0);
            for (ThreadRecord threadRecord : this.mRecord.threadRecords) {
                if (threadRecord.isComplete) {
                    this.mCompleteNum.getAndIncrement();
                } else {
                    if (threadRecord.threadId < this.mCurrentEvent.peerIndex) {
                        sparseArray = this.mBeforePeer;
                        i = threadRecord.threadId;
                    } else {
                        sparseArray = this.mAfterPeer;
                        i = threadRecord.threadId;
                    }
                    sparseArray.put(i, threadRecord);
                }
            }
            ALog.m4189i(this.TAG, String.format("beforeSize = %s, afterSize = %s, mCompleteNum = %s", Integer.valueOf(this.mBeforePeer.size()), Integer.valueOf(this.mAfterPeer.size()), this.mCompleteNum));
            ALog.m4189i(this.TAG, String.format("完成处理数据的操作，将优先下载【%s】之后的切片", Integer.valueOf(this.mCurrentEvent.peerIndex)));
            mo4448getStateManager().updateStateCount();
            this.JUMP_LOCK.lock();
            this.mJumpCondition.signalAll();
            this.JUMP_LOCK.unlock();
        }
    }

    public void setCompleteNum(int i) {
        this.mCompleteNum.set(i);
    }

    public void setCurrentFlagSize(int i) {
        this.mCurrentFlagSize.set(i);
    }
}
