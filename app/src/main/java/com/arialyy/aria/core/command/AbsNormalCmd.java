package com.arialyy.aria.core.command;

import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.queue.AbsTaskQueue;
import com.arialyy.aria.core.queue.DGroupTaskQueue;
import com.arialyy.aria.core.queue.DTaskQueue;
import com.arialyy.aria.core.queue.UTaskQueue;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;

/* loaded from: classes3.dex */
public abstract class AbsNormalCmd<T extends AbsTaskWrapper> extends AbsCmd<T> {
    public boolean canExeCmd = true;
    public int taskType;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0043 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbsNormalCmd(T t, int i) {
        String str;
        AbsTaskQueue uTaskQueue;
        boolean z = true;
        this.taskType = i;
        this.mTaskWrapper = t;
        String className = CommonUtil.getClassName(this);
        this.TAG = className;
        if (i == 1) {
            if (!(t instanceof DTaskWrapper)) {
                str = "任务类型错误，任务类型应该为ICM.TASK_TYPE_DOWNLOAD";
                ALog.m4191e(className, str);
            }
            uTaskQueue = DTaskQueue.getInstance();
            this.mQueue = uTaskQueue;
            if (i != 1 && i != 3) {
                z = false;
            }
            this.isDownloadCmd = z;
        } else if (i == 3) {
            if (!(t instanceof DGTaskWrapper)) {
                str = "任务类型错误，任务类型应该为ICM.TASK_TYPE_DOWNLOAD_GROUP";
                ALog.m4191e(className, str);
            }
            uTaskQueue = DGroupTaskQueue.getInstance();
            this.mQueue = uTaskQueue;
            if (i != 1) {
                z = false;
            }
            this.isDownloadCmd = z;
        } else {
            if (i != 2) {
                str = "任务类型错误，任务类型应该为ICM.TASK_TYPE_DOWNLOAD、TASK_TYPE_DOWNLOAD_GROUP、TASK_TYPE_UPLOAD";
            } else if (t instanceof UTaskWrapper) {
                uTaskQueue = UTaskQueue.getInstance();
                this.mQueue = uTaskQueue;
                if (i != 1) {
                }
                this.isDownloadCmd = z;
            } else {
                str = "任务类型错误，任务类型应该为ICM.TASK_TYPE_UPLOAD";
            }
            ALog.m4191e(className, str);
        }
    }

    public AbsTask createTask() {
        return this.mQueue.mo4437createTask((AbsTaskQueue) this.mTaskWrapper);
    }

    public AbsTask createTask(AbsTaskWrapper absTaskWrapper) {
        return this.mQueue.mo4437createTask((AbsTaskQueue) absTaskWrapper);
    }

    public AbsTask getTask() {
        return this.mQueue.mo4434getTask(this.mTaskWrapper.mo4442getEntity().getKey());
    }

    public AbsTask getTask(String str) {
        return this.mQueue.mo4434getTask(str);
    }

    public void removeTask() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        this.mQueue.cancelTask((AbsTaskQueue) task);
    }

    public void removeTask(AbsTaskWrapper absTaskWrapper) {
        AbsTask task = getTask(absTaskWrapper.getKey());
        if (task == null) {
            task = createTask(absTaskWrapper);
        }
        this.mQueue.cancelTask((AbsTaskQueue) task);
    }

    public void resumeTask() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        this.mQueue.resumeTask((AbsTaskQueue) task);
    }

    public void sendWaitState() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        sendWaitState(task);
    }

    public void sendWaitState(AbsTask absTask) {
        if (absTask != null) {
            absTask.getTaskWrapper().setState(3);
            absTask.getOutHandler().obtainMessage(10, absTask).sendToTarget();
        }
    }

    public void startTask() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        this.mQueue.startTask((AbsTaskQueue) task);
    }

    public void stopAll() {
        this.mQueue.stopAllTask();
    }

    public void stopTask() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        this.mQueue.stopTask((AbsTaskQueue) task);
    }
}
