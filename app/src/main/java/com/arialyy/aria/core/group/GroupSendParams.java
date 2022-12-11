package com.arialyy.aria.core.group;

import com.arialyy.aria.core.common.AbsNormalEntity;
import com.arialyy.aria.core.task.AbsGroupTask;

/* loaded from: classes3.dex */
public final class GroupSendParams<GROUP_TASK extends AbsGroupTask, ENTITY extends AbsNormalEntity> {
    public ENTITY entity;
    public GROUP_TASK groupTask;

    public GroupSendParams() {
    }

    public GroupSendParams(GROUP_TASK group_task, ENTITY entity) {
        this.groupTask = group_task;
        this.entity = entity;
    }
}
