package com.arialyy.aria.core.command;

import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;

/* loaded from: classes3.dex */
public final class AddCmd<T extends AbsTaskWrapper> extends AbsNormalCmd<T> {
    public AddCmd(T t, int i) {
        super(t, i);
    }

    @Override // com.arialyy.aria.core.command.ICmd
    public void executeCmd() {
        if (!this.canExeCmd) {
            return;
        }
        if (getTask() != null) {
            ALog.m4185w(this.TAG, "添加命令执行失败，【该任务已经存在】");
            return;
        }
        this.mTaskWrapper.mo4442getEntity().setState(3);
        createTask();
        sendWaitState();
    }
}
