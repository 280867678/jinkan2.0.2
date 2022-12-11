package com.arialyy.aria.core.task;

import android.net.TrafficStats;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.inf.IThreadStateManager;
import com.arialyy.aria.core.listener.ISchedulers;
import com.arialyy.aria.core.manager.ThreadTaskManager;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.core.wrapper.ITaskWrapper;
import com.arialyy.aria.exception.AriaException;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.ErrorHelp;
import com.arialyy.aria.util.FileUtil;
import com.arialyy.aria.util.NetUtils;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class ThreadTask implements IThreadTask, IThreadTaskObserver {
    public IThreadTaskAdapter mAdapter;
    public SubThreadConfig mConfig;
    public AbsEntity mEntity;
    public long mLastRangeProgress;
    public long mLastSendProgressTime;
    public long mRangeProgress;
    public ThreadRecord mRecord;
    public Handler mStateHandler;
    public AbsTaskWrapper mTaskWrapper;
    public String mThreadName;
    public long updateInterval;
    public final int RETRY_NUM = 2;
    public final String TAG = CommonUtil.getClassName(ThreadTask.class);
    public int mFailTimes = 0;
    public boolean taskBreak = false;
    public boolean isDestroy = false;
    public boolean isCancel = false;
    public boolean isStop = false;
    public Thread mConfigThread = new Thread(new Runnable() { // from class: com.arialyy.aria.core.task.ThreadTask.1
        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            ThreadTask.this.writeConfig(false, ThreadTask.this.mRangeProgress);
        }
    });
    public long mLastSaveTime = System.currentTimeMillis();
    public ExecutorService mConfigThreadPool = Executors.newCachedThreadPool();
    public boolean isNotNetRetry = AriaConfig.getInstance().getAConfig().isNotNetRetry();

    public ThreadTask(SubThreadConfig subThreadConfig) {
        this.mConfig = subThreadConfig;
        AbsTaskWrapper absTaskWrapper = subThreadConfig.taskWrapper;
        this.mTaskWrapper = absTaskWrapper;
        this.mRecord = subThreadConfig.record;
        this.mStateHandler = subThreadConfig.stateHandler;
        this.mEntity = absTaskWrapper.mo4442getEntity();
        long j = this.mRecord.startLocation;
        this.mRangeProgress = j;
        this.mLastRangeProgress = j;
        this.updateInterval = subThreadConfig.updateInterval;
        checkFileExist();
    }

    private void checkFileExist() {
        if (!getConfig().tempFile.exists()) {
            FileUtil.createFile(getConfig().tempFile);
        }
    }

    private void handleBlockRecord() {
        SubThreadConfig subThreadConfig = this.mConfig;
        if (subThreadConfig.isBlock) {
            File file = subThreadConfig.tempFile;
            long length = file.length();
            long j = this.mRecord.blockLen;
            if (!file.exists()) {
                ALog.m4189i(this.TAG, String.format("分块文件【%s】不存在，该分块将重新开始", file.getName()));
                ThreadRecord threadRecord = this.mRecord;
                threadRecord.isComplete = false;
                threadRecord.startLocation = threadRecord.endLocation - j;
            } else if (length > j) {
                ALog.m4189i(this.TAG, String.format("分块【%s】错误，将重新下载该分块", file.getName()));
                FileUtil.deleteFile(file);
                ThreadRecord threadRecord2 = this.mRecord;
                threadRecord2.startLocation = threadRecord2.endLocation - threadRecord2.blockLen;
                threadRecord2.isComplete = false;
            } else {
                ThreadRecord threadRecord3 = this.mRecord;
                long j2 = threadRecord3.blockLen;
                if (length < j2) {
                    threadRecord3.startLocation = (threadRecord3.endLocation - j2) + length;
                    threadRecord3.isComplete = false;
                    updateState(6, null);
                    ALog.m4189i(this.TAG, String.format("修正分块【%s】记录，开始位置：%s，结束位置：%s", file.getName(), Long.valueOf(this.mRecord.startLocation), Long.valueOf(this.mRecord.endLocation)));
                } else {
                    ALog.m4189i(this.TAG, String.format("分块【%s】已完成，更新记录", file.getName()));
                    this.mRecord.isComplete = true;
                }
            }
            this.mRecord.update();
        }
    }

    private void retryBlockTask(boolean z) {
        if (!NetUtils.isConnected(AriaConfig.getInstance().getAPP()) && !this.isNotNetRetry) {
            ALog.m4185w(this.TAG, String.format("分块【%s】重试失败，网络未连接", getFileName()));
            sendFailMsg(null, false);
        } else if (this.mFailTimes >= 2 || !z || ((!NetUtils.isConnected(AriaConfig.getInstance().getAPP()) && !this.isNotNetRetry) || isBreak())) {
            ALog.m4191e(this.TAG, String.format("任务【%s】执行失败", getFileName()));
            sendFailMsg(null, z);
        } else {
            ALog.m4185w(this.TAG, String.format("分块【%s】第%s次重试", getFileName(), String.valueOf(this.mFailTimes)));
            this.mFailTimes++;
            handleBlockRecord();
            ThreadTaskManager.getInstance().retryThread(this);
        }
    }

    private void retryM3U8Peer(boolean z) {
        if (!NetUtils.isConnected(AriaConfig.getInstance().getAPP()) && !this.isNotNetRetry) {
            ALog.m4185w(this.TAG, String.format("ts切片【%s】重试失败，网络未连接", getFileName()));
            sendFailMsg(null, false);
        } else if (this.mFailTimes >= 2 || !z || ((!NetUtils.isConnected(AriaConfig.getInstance().getAPP()) && !this.isNotNetRetry) || isBreak())) {
            sendFailMsg(null, false);
        } else {
            ALog.m4185w(this.TAG, String.format("ts切片【%s】第%s重试", getFileName(), String.valueOf(this.mFailTimes)));
            this.mFailTimes++;
            FileUtil.deleteFile(this.mConfig.tempFile);
            FileUtil.createFile(this.mConfig.tempFile);
            ThreadTaskManager.getInstance().retryThread(this);
        }
    }

    private void sendFailMsg(AriaException ariaException, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(IThreadStateManager.DATA_RETRY, z);
        if (ariaException != null) {
            bundle.putSerializable(IThreadStateManager.DATA_ERROR_INFO, ariaException);
        }
        updateState(2, bundle);
    }

    private void sendM3U8Info(int i, Message message) {
        Bundle data = message.getData();
        if (i != 6) {
            message.obj = this;
        }
        if (i == 4 || i == 2) {
            data.putString(ISchedulers.DATA_M3U8_URL, getConfig().url);
            data.putString(ISchedulers.DATA_M3U8_PEER_PATH, getConfig().tempFile.getPath());
            data.putInt(ISchedulers.DATA_M3U8_PEER_INDEX, getConfig().peerIndex);
        }
    }

    private void sendRunningState() {
        Message obtainMessage = this.mStateHandler.obtainMessage();
        Bundle data = obtainMessage.getData();
        if (data == null) {
            data = new Bundle();
            obtainMessage.setData(data);
        }
        data.putString(IThreadStateManager.DATA_THREAD_NAME, getThreadName());
        data.putLong(IThreadStateManager.DATA_ADD_LEN, this.mRangeProgress - this.mLastRangeProgress);
        obtainMessage.what = 5;
        obtainMessage.obj = Long.valueOf(this.mRangeProgress);
        Thread thread = this.mStateHandler.getLooper().getThread();
        if (!thread.isAlive() || thread.isInterrupted()) {
            return;
        }
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeConfig(boolean z, long j) {
        ThreadRecord threadRecord = this.mRecord;
        if (threadRecord != null) {
            threadRecord.isComplete = z;
            SubThreadConfig subThreadConfig = this.mConfig;
            if (subThreadConfig.isBlock) {
                threadRecord.startLocation = subThreadConfig.tempFile.length();
            } else if (0 < j && j < threadRecord.endLocation) {
                threadRecord.startLocation = j;
            }
            this.mRecord.update();
        }
    }

    @Override // com.arialyy.aria.core.task.IThreadTask
    public void breakTask() {
        this.taskBreak = true;
        if (!this.mTaskWrapper.isSupportBP()) {
            ALog.m4189i(this.TAG, String.format("任务【%s】已中断", getFileName()));
            return;
        }
        long j = this.mRangeProgress;
        updateState(1, null);
        ALog.m4192d(this.TAG, String.format("任务【%s】thread__%s__中断【停止位置：%s】", getFileName(), Integer.valueOf(this.mRecord.threadId), Long.valueOf(j)));
        writeConfig(false, j);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: call */
    public IThreadTask call2() throws Exception {
        this.isDestroy = false;
        Process.setThreadPriority(10);
        TrafficStats.setThreadStatsTag(UUID.randomUUID().toString().hashCode());
        this.mAdapter.call(this);
        return this;
    }

    @Override // com.arialyy.aria.core.task.IThreadTask
    public void cancel() {
        this.isCancel = true;
        updateState(3, null);
        ALog.m4192d(this.TAG, String.format("任务【%s】thread__%s__取消", getFileName(), Integer.valueOf(this.mRecord.threadId)));
    }

    @Override // com.arialyy.aria.core.task.IThreadTask
    public boolean checkBlock() {
        SubThreadConfig subThreadConfig = this.mConfig;
        if (!subThreadConfig.isBlock) {
            return true;
        }
        File file = subThreadConfig.tempFile;
        if (file.exists() && file.length() == this.mRecord.blockLen) {
            return true;
        }
        ALog.m4189i(this.TAG, String.format("分块【%s】错误，blockFileLen: %s, threadRect: %s; 即将重新下载该分块，开始位置：%s，结束位置：%s", file.getName(), Long.valueOf(file.length()), Long.valueOf(this.mRecord.blockLen), Long.valueOf(this.mRecord.startLocation), Long.valueOf(this.mRecord.endLocation)));
        if (file.exists()) {
            FileUtil.deleteFile(file);
            ALog.m4189i(this.TAG, String.format("删除分块【%s】成功", file.getName()));
        }
        retryBlockTask(isBreak());
        return false;
    }

    @Override // com.arialyy.aria.core.task.IThreadTask
    public void destroy() {
        this.isDestroy = true;
    }

    public void fail(long j, AriaException ariaException, boolean z) {
        if (ariaException != null) {
            ariaException.printStackTrace();
        }
        boolean z2 = false;
        if (this.mTaskWrapper.getRequestType() == 7) {
            writeConfig(false, 0L);
            retryM3U8Peer(z);
        } else if (!this.mTaskWrapper.isSupportBP()) {
            ALog.m4191e(this.TAG, String.format("任务【%s】执行失败", getFileName()));
            ErrorHelp.saveError(this.TAG, "", ALog.getExceptionString(ariaException));
            sendFailMsg(null, z);
        } else {
            writeConfig(false, j);
            if (z && this.mConfig.startThreadNum != 1) {
                z2 = true;
            }
            retryBlockTask(z2);
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        ExecutorService executorService = this.mConfigThreadPool;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public SubThreadConfig getConfig() {
        return this.mConfig;
    }

    public AbsEntity getEntity() {
        return this.mEntity;
    }

    public String getFileName() {
        return this.mConfig.tempFile.getName();
    }

    public ITaskWrapper getTaskWrapper() {
        return this.mTaskWrapper;
    }

    @Override // com.arialyy.aria.core.task.IThreadTask
    public int getThreadId() {
        return this.mRecord.threadId;
    }

    @Override // com.arialyy.aria.core.task.IThreadTask
    public String getThreadName() {
        String str = this.mThreadName;
        if (str == null) {
            String threadName = CommonUtil.getThreadName(getEntity().getKey(), getThreadId());
            this.mThreadName = threadName;
            return threadName;
        }
        return str;
    }

    @Override // com.arialyy.aria.core.task.IThreadTaskObserver
    public long getThreadProgress() {
        return this.mRangeProgress;
    }

    @Override // com.arialyy.aria.core.task.IThreadTask
    public boolean isBreak() {
        return this.isCancel || this.isStop || this.taskBreak;
    }

    @Override // com.arialyy.aria.core.task.IThreadTask
    public boolean isDestroy() {
        return Thread.currentThread().isInterrupted();
    }

    @Override // com.arialyy.aria.core.task.IThreadTask
    public boolean isLive() {
        return !Thread.currentThread().isInterrupted() && !this.isDestroy;
    }

    @Override // com.arialyy.aria.core.task.IThreadTask
    public boolean isThreadComplete() {
        return this.mRecord.isComplete;
    }

    public void setAdapter(IThreadTaskAdapter iThreadTaskAdapter) {
        this.mAdapter = iThreadTaskAdapter;
        iThreadTaskAdapter.attach(this);
    }

    @Override // com.arialyy.aria.core.task.IThreadTask
    public void setMaxSpeed(int i) {
        IThreadTaskAdapter iThreadTaskAdapter = this.mAdapter;
        if (iThreadTaskAdapter != null) {
            iThreadTaskAdapter.setMaxSpeed(i);
        }
    }

    @Override // com.arialyy.aria.core.task.IThreadTask
    public void stop() {
        String str;
        String format;
        this.isStop = true;
        long j = this.mRangeProgress;
        updateState(1, null);
        if (this.mTaskWrapper.getRequestType() == 7) {
            writeConfig(false, getConfig().tempFile.length());
            str = this.TAG;
            format = String.format("任务【%s】已停止", getFileName());
        } else if (this.mTaskWrapper.isSupportBP()) {
            ALog.m4192d(this.TAG, String.format("任务【%s】thread__%s__停止【当前线程停止位置：%s】", getFileName(), Integer.valueOf(this.mRecord.threadId), Long.valueOf(j)));
            writeConfig(false, j);
            return;
        } else {
            str = this.TAG;
            format = String.format("任务【%s】已停止", getFileName());
        }
        ALog.m4189i(str, format);
    }

    @Override // com.arialyy.aria.core.task.IThreadTaskObserver
    public synchronized void updateCompleteState() {
        ALog.m4189i(this.TAG, String.format("任务【%s】线程__%s__完成", getTaskWrapper().getKey(), Integer.valueOf(this.mRecord.threadId)));
        writeConfig(true, this.mRecord.endLocation);
        sendRunningState();
        updateState(4, null);
    }

    @Override // com.arialyy.aria.core.task.IThreadTaskObserver
    public synchronized void updateFailState(AriaException ariaException, boolean z) {
        fail(this.mRangeProgress, ariaException, z);
    }

    @Override // com.arialyy.aria.core.task.IThreadTaskObserver
    public synchronized void updateProgress(long j) {
        this.mRangeProgress += j;
        Thread thread = this.mStateHandler.getLooper().getThread();
        if (thread.isAlive() && !thread.isInterrupted()) {
            if (System.currentTimeMillis() - this.mLastSendProgressTime > this.updateInterval) {
                sendRunningState();
                this.mLastRangeProgress = this.mRangeProgress;
                this.mLastSendProgressTime = System.currentTimeMillis();
            }
            if (System.currentTimeMillis() - this.mLastSaveTime > 5000 && this.mRangeProgress < this.mRecord.endLocation) {
                this.mLastSaveTime = System.currentTimeMillis();
                if (!this.mConfigThreadPool.isShutdown()) {
                    this.mConfigThreadPool.execute(this.mConfigThread);
                }
            }
        }
    }

    @Override // com.arialyy.aria.core.task.IThreadTaskObserver
    public synchronized void updateState(int i, Bundle bundle) {
        Message obtainMessage = this.mStateHandler.obtainMessage();
        if (bundle == null) {
            bundle = new Bundle();
        }
        obtainMessage.setData(bundle);
        bundle.putString(IThreadStateManager.DATA_THREAD_NAME, getThreadName());
        bundle.putLong(IThreadStateManager.DATA_THREAD_LOCATION, this.mRangeProgress);
        obtainMessage.what = i;
        if (getConfig().threadType == 3) {
            sendM3U8Info(i, obtainMessage);
        }
        Thread thread = this.mStateHandler.getLooper().getThread();
        if (thread.isAlive() && !thread.isInterrupted()) {
            obtainMessage.sendToTarget();
        }
    }
}
