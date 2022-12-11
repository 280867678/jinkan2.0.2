package com.arialyy.aria.core.scheduler;

import com.arialyy.aria.core.task.ITask;

/* loaded from: classes3.dex */
public class NormalTaskListener<TASK extends ITask> implements ISchedulerListener {
    public void onNoSupportBreakPoint(TASK task) {
    }

    public void onPre(TASK task) {
    }

    public void onTaskCancel(TASK task) {
    }

    public void onTaskComplete(TASK task) {
    }

    public void onTaskFail(TASK task) {
    }

    public void onTaskFail(TASK task, Exception exc) {
    }

    public void onTaskPre(TASK task) {
    }

    public void onTaskResume(TASK task) {
    }

    public void onTaskRunning(TASK task) {
    }

    public void onTaskStart(TASK task) {
    }

    public void onTaskStop(TASK task) {
    }

    public void onWait(TASK task) {
    }

    @Override // com.arialyy.aria.core.scheduler.ISchedulerListener
    public void setListener(Object obj) {
    }
}
