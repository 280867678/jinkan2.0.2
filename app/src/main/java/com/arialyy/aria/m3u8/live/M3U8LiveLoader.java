package com.arialyy.aria.m3u8.live;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.common.CompleteInfo;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.inf.IThreadStateManager;
import com.arialyy.aria.core.listener.IEventListener;
import com.arialyy.aria.core.loader.IInfoTask;
import com.arialyy.aria.core.loader.IRecordHandler;
import com.arialyy.aria.core.loader.IThreadTaskBuilder;
import com.arialyy.aria.core.manager.ThreadTaskManager;
import com.arialyy.aria.core.processor.ILiveTsUrlConverter;
import com.arialyy.aria.core.processor.ITsMergeHandler;
import com.arialyy.aria.core.task.ThreadTask;
import com.arialyy.aria.exception.AriaException;
import com.arialyy.aria.exception.AriaM3U8Exception;
import com.arialyy.aria.m3u8.BaseM3U8Loader;
import com.arialyy.aria.m3u8.IdGenerator;
import com.arialyy.aria.m3u8.M3U8InfoTask;
import com.arialyy.aria.m3u8.M3U8Listener;
import com.arialyy.aria.m3u8.M3U8TaskOption;
import com.arialyy.aria.m3u8.M3U8ThreadTaskAdapter;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.FileUtil;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public final class M3U8LiveLoader extends BaseM3U8Loader {
    public static int EXEC_MAX_NUM = 4;
    public ReentrantLock LOCK;
    public Condition mCondition;
    public ExtInfo mCurExtInfo;
    public M3U8InfoTask mInfoTask;
    public Handler mStateHandler;
    public ScheduledThreadPoolExecutor mTimer;
    public ArrayBlockingQueue<Long> mFlagQueue = new ArrayBlockingQueue<>(EXEC_MAX_NUM);
    public LinkedBlockingQueue<ExtInfo> mPeerQueue = new LinkedBlockingQueue<>();
    public List<String> mPeerUrls = new ArrayList();

    /* loaded from: classes3.dex */
    public static class ExtInfo {
        public String extInf;
        public String url;

        public ExtInfo(String str, String str2) {
            this.url = str;
            this.extInf = str2;
        }
    }

    public M3U8LiveLoader(DTaskWrapper dTaskWrapper, M3U8Listener m3U8Listener) {
        super(dTaskWrapper, m3U8Listener);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.LOCK = reentrantLock;
        this.mCondition = reentrantLock.newCondition();
        if (((M3U8TaskOption) dTaskWrapper.getM3u8Option()).isGenerateIndexFile()) {
            ALog.m4189i(this.TAG, "直播文件下载，创建索引文件的操作将导致只能同时下载一个切片");
            EXEC_MAX_NUM = 1;
        }
    }

    private void closeInfoTimer() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.mTimer;
        if (scheduledThreadPoolExecutor == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        this.mTimer.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ThreadTask createThreadTask(String str, int i, String str2) {
        ThreadRecord createThreadRecord = getRecordHandler().createThreadRecord(this.mRecord, str2, i);
        SubThreadConfig subThreadConfig = new SubThreadConfig();
        subThreadConfig.url = str2;
        subThreadConfig.tempFile = new File(BaseM3U8Loader.getTsFilePath(str, i));
        subThreadConfig.isBlock = this.mRecord.isBlock;
        subThreadConfig.taskWrapper = this.mTaskWrapper;
        subThreadConfig.record = createThreadRecord;
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
    public void fail(AriaM3U8Exception ariaM3U8Exception, boolean z) {
        mo4447getListener().onFail(z, ariaM3U8Exception);
        handleComplete();
    }

    private LiveRecordHandler getRecordHandler() {
        return (LiveRecordHandler) this.mRecordHandler;
    }

    private void handleComplete() {
        IEventListener mo4447getListener;
        AriaM3U8Exception ariaM3U8Exception;
        M3U8InfoTask m3U8InfoTask = this.mInfoTask;
        if (m3U8InfoTask != null) {
            m3U8InfoTask.setStop(true);
            closeInfoTimer();
            if (this.mM3U8Option.isGenerateIndexFile()) {
                if (!generateIndexFile(true)) {
                    mo4447getListener = mo4447getListener();
                    ariaM3U8Exception = new AriaM3U8Exception(this.TAG, "创建索引文件失败");
                    mo4447getListener.onFail(false, ariaM3U8Exception);
                    return;
                }
                mo4447getListener().onComplete();
            }
            if (this.mM3U8Option.isMergeFile() && !mergeFile()) {
                mo4447getListener = mo4447getListener();
                ariaM3U8Exception = new AriaM3U8Exception(this.TAG, "合并文件失败");
                mo4447getListener.onFail(false, ariaM3U8Exception);
                return;
            }
            mo4447getListener().onComplete();
        }
    }

    private boolean mergeFile() {
        String[] list;
        ITsMergeHandler mergeHandler = this.mM3U8Option.getMergeHandler();
        String cacheDir = getCacheDir();
        ArrayList arrayList = new ArrayList();
        for (String str : new File(cacheDir).list(new FilenameFilter() { // from class: com.arialyy.aria.m3u8.live.M3U8LiveLoader.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                return str2.endsWith(".ts");
            }
        })) {
            arrayList.add(cacheDir + "/" + str);
        }
        if (!(mergeHandler != null ? mergeHandler.merge(getEntity().getM3U8Entity(), arrayList) : FileUtil.mergeFile(getEntity().getFilePath(), arrayList))) {
            ALog.m4191e(this.TAG, "合并失败");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FileUtil.deleteFile((String) it.next());
        }
        FileUtil.deleteDir(new File(cacheDir));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void offerPeer(ExtInfo extInfo) {
        this.mPeerQueue.offer(extInfo);
    }

    private void startLoaderLiveInfo() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        this.mTimer = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(new Runnable() { // from class: com.arialyy.aria.m3u8.live.M3U8LiveLoader.5
            @Override // java.lang.Runnable
            public void run() {
                M3U8LiveLoader.this.mInfoTask.run();
            }
        }, 0L, this.mM3U8Option.getLiveUpdateInterval(), TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long startThreadTask(ThreadTask threadTask, int i) {
        ThreadTaskManager.getInstance().startThread(((DTaskWrapper) this.mTaskWrapper).getKey(), threadTask);
        ((M3U8Listener) mo4447getListener()).onPeerStart(((DTaskWrapper) this.mTaskWrapper).getKey(), threadTask.getConfig().tempFile.getPath(), i);
        return IdGenerator.getInstance().nextId();
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    public void addComponent(IThreadStateManager iThreadStateManager) {
        this.mStateManager = iThreadStateManager;
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    public void addComponent(IInfoTask iInfoTask) {
        M3U8InfoTask m3U8InfoTask = (M3U8InfoTask) iInfoTask;
        this.mInfoTask = m3U8InfoTask;
        m3U8InfoTask.setCallback(new IInfoTask.Callback() { // from class: com.arialyy.aria.m3u8.live.M3U8LiveLoader.3
            @Override // com.arialyy.aria.core.loader.IInfoTask.Callback
            public void onFail(AbsEntity absEntity, AriaException ariaException, boolean z) {
            }

            @Override // com.arialyy.aria.core.loader.IInfoTask.Callback
            public void onSucceed(String str, CompleteInfo completeInfo) {
                ALog.m4192d(M3U8LiveLoader.this.TAG, "更新直播的m3u8文件");
            }
        });
        this.mInfoTask.setOnGetPeerCallback(new M3U8InfoTask.OnGetLivePeerCallback() { // from class: com.arialyy.aria.m3u8.live.M3U8LiveLoader.4
            @Override // com.arialyy.aria.m3u8.M3U8InfoTask.OnGetLivePeerCallback
            public void onGetPeer(String str, String str2) {
                if (M3U8LiveLoader.this.mPeerUrls.contains(str)) {
                    return;
                }
                M3U8LiveLoader.this.mPeerUrls.add(str);
                ILiveTsUrlConverter liveTsUrlConverter = M3U8LiveLoader.this.mM3U8Option.getLiveTsUrlConverter();
                if (liveTsUrlConverter != null) {
                    str = liveTsUrlConverter.convert(TextUtils.isEmpty(M3U8LiveLoader.this.mM3U8Option.getBandWidthUrl()) ? M3U8LiveLoader.this.getEntity().getUrl() : M3U8LiveLoader.this.mM3U8Option.getBandWidthUrl(), str);
                }
                if (TextUtils.isEmpty(str) || !str.startsWith("http")) {
                    M3U8LiveLoader.this.fail(new AriaM3U8Exception(M3U8LiveLoader.this.TAG, String.format("ts地址错误，url：%s", str)), false);
                } else {
                    M3U8LiveLoader.this.offerPeer(new ExtInfo(str, str2));
                }
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
            if (this.mStateManager == null) {
                throw new NullPointerException("任务状态管理组件为空");
            }
            return;
        }
        throw new NullPointerException("任务记录组件为空");
    }

    public ExtInfo getCurExtInfo() {
        return this.mCurExtInfo;
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoader
    public long getFileSize() {
        return this.mTempFile.length();
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoader
    /* renamed from: getStateManager  reason: collision with other method in class */
    public LiveStateManager mo4448getStateManager() {
        return (LiveStateManager) super.mo4448getStateManager();
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoader
    public void handleTask(Looper looper) {
        if (isBreak()) {
            return;
        }
        getRecordHandler().setOption(this.mM3U8Option);
        this.mRecord = getRecordHandler().getRecord(0L);
        mo4448getStateManager().setLooper(this.mRecord, looper);
        mo4448getStateManager().setLoader(this);
        this.mStateHandler = new Handler(looper, mo4448getStateManager().getHandlerCallback());
        startLoaderLiveInfo();
        startTimer();
        new Thread(new Runnable() { // from class: com.arialyy.aria.m3u8.live.M3U8LiveLoader.1
            @Override // java.lang.Runnable
            public void run() {
                ExtInfo extInfo;
                String cacheDir = M3U8LiveLoader.this.getCacheDir();
                int i = 0;
                while (!M3U8LiveLoader.this.isBreak()) {
                    try {
                        try {
                            M3U8LiveLoader.this.LOCK.lock();
                            while (M3U8LiveLoader.this.mFlagQueue.size() < M3U8LiveLoader.EXEC_MAX_NUM && (extInfo = (ExtInfo) M3U8LiveLoader.this.mPeerQueue.poll()) != null) {
                                M3U8LiveLoader.this.mCurExtInfo = extInfo;
                                ThreadTask createThreadTask = M3U8LiveLoader.this.createThreadTask(cacheDir, i, extInfo.url);
                                M3U8LiveLoader.this.getTaskList().add(createThreadTask);
                                M3U8LiveLoader.this.mFlagQueue.offer(Long.valueOf(M3U8LiveLoader.this.startThreadTask(createThreadTask, createThreadTask.getConfig().peerIndex)));
                                i++;
                            }
                            if (M3U8LiveLoader.this.mFlagQueue.size() > 0) {
                                M3U8LiveLoader.this.mCondition.await();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } finally {
                        M3U8LiveLoader.this.LOCK.unlock();
                    }
                }
            }
        }).start();
    }

    public void notifyLock(boolean z, int i) {
        try {
            try {
                this.LOCK.lock();
                this.mFlagQueue.take().longValue();
                if (z) {
                    ALog.m4192d(this.TAG, String.format("切片【%s】下载成功", Integer.valueOf(i)));
                } else {
                    ALog.m4191e(this.TAG, String.format("切片【%s】下载失败", Integer.valueOf(i)));
                }
                this.mCondition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            this.LOCK.unlock();
        }
    }
}
