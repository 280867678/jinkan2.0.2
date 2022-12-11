package com.arialyy.aria.core.loader;

import android.os.Looper;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.inf.IThreadStateManager;
import com.arialyy.aria.core.listener.IEventListener;
import com.arialyy.aria.core.manager.ThreadTaskManager;
import com.arialyy.aria.core.task.IThreadTask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public abstract class AbsNormalLoader<T extends AbsTaskWrapper> implements ILoaderVisitor, ILoader {
    public IInfoTask mInfoTask;
    public IEventListener mListener;
    public TaskRecord mRecord;
    public IRecordHandler mRecordHandler;
    public IThreadStateManager mStateManager;
    public IThreadTaskBuilder mTTBuilder;
    public T mTaskWrapper;
    public File mTempFile;
    public ScheduledThreadPoolExecutor mTimer;
    public final String TAG = CommonUtil.getClassName((Class) getClass());
    public List<IThreadTask> mTask = new ArrayList();
    public long mUpdateInterval = 1000;
    public boolean isCancel = false;
    public boolean isStop = false;
    public boolean isRuning = false;

    public AbsNormalLoader(T t, IEventListener iEventListener) {
        this.mListener = iEventListener;
        this.mTaskWrapper = t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void closeTimer() {
        if (this.mTimer != null && !this.mTimer.isShutdown()) {
            this.mTimer.shutdown();
        }
    }

    private void resetState() {
        closeTimer();
        List<IThreadTask> list = this.mTask;
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i = 0; i < this.mTask.size(); i++) {
            this.mTask.get(i).breakTask();
        }
        this.mTask.clear();
    }

    private void startFlow() {
        if (isBreak()) {
            return;
        }
        Looper.prepare();
        Looper myLooper = Looper.myLooper();
        if (myLooper == Looper.getMainLooper()) {
            throw new IllegalThreadStateException("不能在主线程程序中调用Loader");
        }
        this.isRuning = true;
        resetState();
        onPostPre();
        handleTask(myLooper);
        Looper.loop();
    }

    @Override // com.arialyy.aria.core.loader.ILoader
    public final synchronized void cancel() {
        if (this.isCancel) {
            ALog.m4192d(this.TAG, String.format("任务【%s】正在删除，删除任务失败", this.mTaskWrapper.getKey()));
            return;
        }
        closeTimer();
        this.isCancel = true;
        onCancel();
        for (int i = 0; i < this.mTask.size(); i++) {
            IThreadTask iThreadTask = this.mTask.get(i);
            if (iThreadTask != null && !iThreadTask.isThreadComplete()) {
                iThreadTask.cancel();
            }
        }
        ThreadTaskManager.getInstance().removeTaskThread(this.mTaskWrapper.getKey());
        onPostCancel();
        onDestroy();
        this.mListener.onCancel();
    }

    public void checkComponent() {
        if (this.mRecordHandler != null) {
            if (this.mInfoTask == null) {
                throw new NullPointerException("文件信息组件为空");
            }
            if (this.mStateManager == null) {
                throw new NullPointerException("任务状态管理组件为空");
            }
            if (this.mTTBuilder == null) {
                throw new NullPointerException("线程任务组件为空");
            }
            return;
        }
        throw new NullPointerException("任务记录组件为空");
    }

    public long delayTimer() {
        return 1000L;
    }

    public abstract long getFileSize();

    @Override // com.arialyy.aria.core.loader.ILoader
    public String getKey() {
        return this.mTaskWrapper.getKey();
    }

    /* renamed from: getListener */
    public IEventListener mo4447getListener() {
        return this.mListener;
    }

    /* renamed from: getStateManager */
    public IThreadStateManager mo4448getStateManager() {
        return this.mStateManager;
    }

    public List<IThreadTask> getTaskList() {
        return this.mTask;
    }

    public abstract void handleTask(Looper looper);

    @Override // com.arialyy.aria.core.loader.ILoader
    public boolean isBreak() {
        if (this.isCancel || this.isStop) {
            String str = this.TAG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("isCancel = ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.isCancel);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", isStop = ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.isStop);
            ALog.m4192d(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            ALog.m4192d(this.TAG, String.format("任务【%s】已停止或取消了", this.mTaskWrapper.getKey()));
            return true;
        }
        return false;
    }

    @Override // com.arialyy.aria.core.loader.ILoader
    public synchronized boolean isRunning() {
        boolean z;
        if (ThreadTaskManager.getInstance().taskIsRunning(this.mTaskWrapper.getKey())) {
            if (this.isRuning) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    public void onCancel() {
    }

    public void onDestroy() {
        this.isRuning = false;
    }

    public void onPostCancel() {
    }

    public void onPostPre() {
    }

    public void onPostStop() {
    }

    public void onStop() {
    }

    public void retryTask() {
        ALog.m4185w(this.TAG, String.format("任务【%s】开始重试", this.mTaskWrapper.getKey()));
        startFlow();
    }

    @Override // java.lang.Runnable
    public void run() {
        checkComponent();
        if (isRunning()) {
            ALog.m4192d(this.TAG, String.format("任务【%s】正在执行，启动任务失败", this.mTaskWrapper.getKey()));
        } else {
            startFlow();
        }
    }

    public void setUpdateInterval(long j) {
        if (j < 0) {
            ALog.m4185w(this.TAG, "更新间隔不能小于0，默认为1000毫秒");
        } else {
            this.mUpdateInterval = j;
        }
    }

    public synchronized void startTimer() {
        if (isBreak()) {
            return;
        }
        ALog.m4192d(this.TAG, String.format("启动定时器，delayTimer = %s, updateInterval = %s", Long.valueOf(delayTimer()), Long.valueOf(this.mUpdateInterval)));
        closeTimer();
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
            this.mTimer = scheduledThreadPoolExecutor;
            scheduledThreadPoolExecutor.scheduleWithFixedDelay(new Runnable() { // from class: com.arialyy.aria.core.loader.AbsNormalLoader.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (AbsNormalLoader.this.mStateManager == null) {
                            ALog.m4191e(AbsNormalLoader.this.TAG, "stateManager is null");
                        } else {
                            if (!AbsNormalLoader.this.mStateManager.isComplete() && !AbsNormalLoader.this.mStateManager.isFail() && AbsNormalLoader.this.isRunning() && !AbsNormalLoader.this.isBreak()) {
                                if (AbsNormalLoader.this.mStateManager.getCurrentProgress() >= 0) {
                                    String str = AbsNormalLoader.this.TAG;
                                    AbsNormalLoader.this.mListener.onProgress(AbsNormalLoader.this.mStateManager.getCurrentProgress());
                                } else {
                                    String str2 = AbsNormalLoader.this.TAG;
                                }
                            }
                            ThreadTaskManager.getInstance().removeTaskThread(AbsNormalLoader.this.mTaskWrapper.getKey());
                            AbsNormalLoader.this.closeTimer();
                            AbsNormalLoader.this.onDestroy();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, delayTimer(), this.mUpdateInterval, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            ALog.m4191e(this.TAG, "启动定时器失败");
            e.printStackTrace();
        }
    }

    @Override // com.arialyy.aria.core.loader.ILoader
    public final synchronized void stop() {
        if (this.isStop) {
            return;
        }
        closeTimer();
        this.isStop = true;
        onStop();
        for (int i = 0; i < this.mTask.size(); i++) {
            IThreadTask iThreadTask = this.mTask.get(i);
            if (iThreadTask != null && !iThreadTask.isThreadComplete()) {
                iThreadTask.stop();
            }
        }
        ThreadTaskManager.getInstance().removeTaskThread(this.mTaskWrapper.getKey());
        onPostStop();
        onDestroy();
        this.mListener.onStop(getCurrentProgress());
    }
}
