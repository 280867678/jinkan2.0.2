package com.arialyy.aria.core.command;

import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;

/* loaded from: classes3.dex */
public final class CancelCmd<T extends AbsTaskWrapper> extends AbsNormalCmd<T> {
    public boolean removeFile = false;

    public CancelCmd(T t, int i) {
        super(t, i);
    }

    @Override // com.arialyy.aria.core.command.ICmd
    public void executeCmd() {
        if (!this.canExeCmd) {
            return;
        }
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        if (task == null) {
            return;
        }
        this.mTaskWrapper.setRemoveFile(this.removeFile);
        removeTask();
    }
}
