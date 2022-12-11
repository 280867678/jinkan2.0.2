package com.arialyy.aria.core.command;

import com.arialyy.aria.core.download.AbsGroupTaskWrapper;

/* loaded from: classes3.dex */
public final class DGSubStartCmd<T extends AbsGroupTaskWrapper> extends AbsGroupCmd<T> {
    public DGSubStartCmd(T t) {
        super(t);
    }

    @Override // com.arialyy.aria.core.command.ICmd
    public void executeCmd() {
        if (checkTask()) {
            this.tempTask.startSubTask(this.childUrl);
        }
    }
}
