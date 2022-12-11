package com.arialyy.aria.core.command;

import com.arialyy.aria.core.wrapper.AbsTaskWrapper;

/* loaded from: classes3.dex */
public final class StopAllCmd<T extends AbsTaskWrapper> extends AbsNormalCmd<T> {
    public StopAllCmd(T t, int i) {
        super(t, i);
    }

    @Override // com.arialyy.aria.core.command.ICmd
    public void executeCmd() {
        stopAll();
    }
}
