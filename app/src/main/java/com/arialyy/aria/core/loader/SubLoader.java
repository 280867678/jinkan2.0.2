package com.arialyy.aria.core.loader;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.common.CompleteInfo;
import com.arialyy.aria.core.inf.IThreadStateManager;
import com.arialyy.aria.core.loader.IInfoTask;
import com.arialyy.aria.core.manager.ThreadTaskManager;
import com.arialyy.aria.core.task.IThreadTask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.exception.AriaException;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class SubLoader implements ILoader, ILoaderVisitor {
    public IInfoTask infoTask;
    public IThreadStateManager mStateManager;
    public String parentKey;
    public TaskRecord record;
    public IRecordHandler recordHandler;
    public Handler schedulers;
    public IThreadTaskBuilder ttBuild;
    public AbsTaskWrapper wrapper;
    public String TAG = CommonUtil.getClassName(this);
    public boolean needGetInfo = true;
    public boolean isCancel = false;
    public boolean isStop = false;
    public List<IThreadTask> mTask = new ArrayList();

    public SubLoader(AbsTaskWrapper absTaskWrapper, Handler handler) {
        this.wrapper = absTaskWrapper;
        this.schedulers = handler;
    }

    private void checkComponent() {
        if (this.recordHandler != null) {
            if (this.infoTask == null) {
                throw new NullPointerException("文件信息组件为空");
            }
            if (this.ttBuild == null) {
                throw new NullPointerException("线程任务组件为空");
            }
            return;
        }
        throw new NullPointerException("任务记录组件为空");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerTask() {
        if (isBreak()) {
            return;
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            Looper.prepare();
            myLooper = Looper.myLooper();
        }
        TaskRecord record = this.recordHandler.getRecord(this.wrapper.mo4442getEntity().getFileSize());
        this.record = record;
        if (record.threadRecords != null && !TextUtils.isEmpty(record.filePath) && new File(this.record.filePath).exists() && !this.record.threadRecords.isEmpty() && this.record.threadRecords.get(0).isComplete) {
            String str = this.TAG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("子任务已完成，key：");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.wrapper.getKey());
            ALog.m4192d(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            sendNormalState(4);
            return;
        }
        List<IThreadTask> buildThreadTask = this.ttBuild.buildThreadTask(this.record, new Handler(myLooper, this.mStateManager.getHandlerCallback()));
        this.mStateManager.setLooper(this.record, myLooper);
        if (buildThreadTask == null || buildThreadTask.isEmpty()) {
            String str2 = this.TAG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("创建子任务的线程任务失败，key：");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.wrapper.getKey());
            ALog.m4191e(str2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            sendFailState(false);
        } else if (TextUtils.isEmpty(this.parentKey)) {
            ALog.m4191e(this.TAG, "parentKey为空");
            sendFailState(false);
        } else {
            sendNormalState(7);
            this.mTask.addAll(buildThreadTask);
            try {
                for (IThreadTask iThreadTask : this.mTask) {
                    ThreadTaskManager.getInstance().startThread(this.parentKey, iThreadTask);
                }
                sendNormalState(8);
                this.mStateManager.updateCurrentProgress(getWrapper().mo4442getEntity().getCurrentProgress());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Looper.loop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFailState(boolean z) {
        Message obtainMessage = this.schedulers.obtainMessage();
        Bundle data = obtainMessage.getData();
        if (data == null) {
            data = new Bundle();
        }
        data.putString(IThreadStateManager.DATA_THREAD_NAME, getKey());
        data.putBoolean(IThreadStateManager.DATA_RETRY, z);
        obtainMessage.what = 2;
        obtainMessage.setData(data);
        obtainMessage.sendToTarget();
    }

    private void sendNormalState(int i) {
        Message obtainMessage = this.schedulers.obtainMessage();
        Bundle data = obtainMessage.getData();
        if (data == null) {
            data = new Bundle();
        }
        data.putString(IThreadStateManager.DATA_THREAD_NAME, getKey());
        obtainMessage.what = i;
        obtainMessage.setData(data);
        obtainMessage.sendToTarget();
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    public void addComponent(IThreadStateManager iThreadStateManager) {
        this.mStateManager = iThreadStateManager;
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    public void addComponent(IInfoTask iInfoTask) {
        this.infoTask = iInfoTask;
        iInfoTask.setCallback(new IInfoTask.Callback() { // from class: com.arialyy.aria.core.loader.SubLoader.1
            @Override // com.arialyy.aria.core.loader.IInfoTask.Callback
            public void onFail(AbsEntity absEntity, AriaException ariaException, boolean z) {
                SubLoader.this.sendFailState(z);
            }

            @Override // com.arialyy.aria.core.loader.IInfoTask.Callback
            public void onSucceed(String str, CompleteInfo completeInfo) {
                SubLoader.this.handlerTask();
            }
        });
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    public void addComponent(IRecordHandler iRecordHandler) {
        this.recordHandler = iRecordHandler;
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    public void addComponent(IThreadTaskBuilder iThreadTaskBuilder) {
        this.ttBuild = iThreadTaskBuilder;
    }

    @Override // com.arialyy.aria.core.loader.ILoader
    public void cancel() {
        if (this.isCancel) {
            ALog.m4185w(this.TAG, "子任务已取消");
            return;
        }
        this.isCancel = true;
        for (IThreadTask iThreadTask : this.mTask) {
            iThreadTask.cancel();
        }
    }

    @Override // com.arialyy.aria.core.loader.ILoader
    public long getCurrentProgress() {
        return isRunning() ? this.mStateManager.getCurrentProgress() : getWrapper().mo4442getEntity().getCurrentProgress();
    }

    @Override // com.arialyy.aria.core.loader.ILoader
    public String getKey() {
        return CommonUtil.getThreadName(this.wrapper.getKey(), 0);
    }

    public TaskRecord getRecord() {
        return this.record;
    }

    public AbsTaskWrapper getWrapper() {
        return this.wrapper;
    }

    @Override // com.arialyy.aria.core.loader.ILoader
    public boolean isBreak() {
        if (this.isCancel || this.isStop) {
            String str = this.TAG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("isCancel = ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.isCancel);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", isStop = ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.isStop);
            ALog.m4192d(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            ALog.m4192d(this.TAG, String.format("任务【%s】已停止或取消了", this.wrapper.getKey()));
            return true;
        }
        return false;
    }

    @Override // com.arialyy.aria.core.loader.ILoader
    public boolean isRunning() {
        if (this.mTask.isEmpty()) {
            return false;
        }
        for (IThreadTask iThreadTask : this.mTask) {
            if (!iThreadTask.isBreak()) {
                return true;
            }
        }
        return false;
    }

    public void retryTask() {
        try {
            if (this.mTask.isEmpty()) {
                ALog.m4191e(this.TAG, "子任务的线程任务为空");
                return;
            }
            for (IThreadTask iThreadTask : this.mTask) {
                iThreadTask.call();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        checkComponent();
        if (isBreak()) {
            return;
        }
        if (this.needGetInfo) {
            this.infoTask.run();
        } else {
            handlerTask();
        }
    }

    public void setNeedGetInfo(boolean z) {
        this.needGetInfo = z;
    }

    public void setParentKey(String str) {
        this.parentKey = str;
    }

    @Override // com.arialyy.aria.core.loader.ILoader
    public void stop() {
        if (this.isStop) {
            ALog.m4185w(this.TAG, "子任务已停止");
            return;
        }
        this.isStop = true;
        for (IThreadTask iThreadTask : this.mTask) {
            iThreadTask.stop();
        }
    }
}
