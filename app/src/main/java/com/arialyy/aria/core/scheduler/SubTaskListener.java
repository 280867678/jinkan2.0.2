package com.arialyy.aria.core.scheduler;

import com.arialyy.aria.core.common.AbsNormalEntity;
import com.arialyy.aria.core.task.ITask;

/* loaded from: classes3.dex */
public class SubTaskListener<TASK extends ITask, SUB_ENTITY extends AbsNormalEntity> implements ISchedulerListener {
    public void onNoSupportBreakPoint(TASK task) {
    }

    public void onSubTaskCancel(TASK task, SUB_ENTITY sub_entity) {
    }

    public void onSubTaskComplete(TASK task, SUB_ENTITY sub_entity) {
    }

    @Deprecated
    public void onSubTaskFail(TASK task, SUB_ENTITY sub_entity) {
    }

    public void onSubTaskFail(TASK task, SUB_ENTITY sub_entity, Exception exc) {
    }

    public void onSubTaskPre(TASK task, SUB_ENTITY sub_entity) {
    }

    public void onSubTaskRunning(TASK task, SUB_ENTITY sub_entity) {
    }

    public void onSubTaskStart(TASK task, SUB_ENTITY sub_entity) {
    }

    public void onSubTaskStop(TASK task, SUB_ENTITY sub_entity) {
    }

    @Override // com.arialyy.aria.core.scheduler.ISchedulerListener
    public void setListener(Object obj) {
    }
}
