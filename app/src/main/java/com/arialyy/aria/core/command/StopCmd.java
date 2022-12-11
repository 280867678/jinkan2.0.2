package com.arialyy.aria.core.command;

import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;

/* loaded from: classes3.dex */
public final class StopCmd<T extends AbsTaskWrapper> extends AbsNormalCmd<T> {
    public StopCmd(T t, int i) {
        super(t, i);
    }

    @Override // com.arialyy.aria.core.command.ICmd
    public void executeCmd() {
        if (!this.canExeCmd) {
            return;
        }
        if (getTask() != null || this.mTaskWrapper.mo4442getEntity().getState() == 4) {
            stopTask();
        } else {
            ALog.m4185w(this.TAG, "停止命令执行失败，【调度器中没有该任务】");
        }
    }
}
