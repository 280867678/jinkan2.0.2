package com.arialyy.aria.core.task;

import com.arialyy.aria.core.download.AbsGroupTaskWrapper;
import com.arialyy.aria.core.group.AbsGroupLoaderUtil;

/* loaded from: classes3.dex */
public abstract class AbsGroupTask<TASK_ENTITY extends AbsGroupTaskWrapper> extends AbsTask<TASK_ENTITY> {
    /* JADX WARN: Type inference failed for: r0v2, types: [com.arialyy.aria.core.common.AbsEntity] */
    @Override // com.arialyy.aria.core.task.ITask
    public String getKey() {
        return ((AbsGroupTaskWrapper) this.mTaskWrapper).mo4442getEntity().getKey();
    }

    public void startSubTask(String str) {
        if (getUtil() != null) {
            ((AbsGroupLoaderUtil) getUtil()).startSubTask(str);
        }
    }

    public void stopSubTask(String str) {
        if (getUtil() != null) {
            ((AbsGroupLoaderUtil) getUtil()).stopSubTask(str);
        }
    }
}
