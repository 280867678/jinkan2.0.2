package com.arialyy.aria.core.command;

import com.arialyy.aria.core.queue.AbsTaskQueue;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;

/* loaded from: classes3.dex */
public final class ReStartCmd<T extends AbsTaskWrapper> extends AbsNormalCmd<T> {
    public ReStartCmd(T t, int i) {
        super(t, i);
    }

    @Override // com.arialyy.aria.core.command.ICmd
    public void executeCmd() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        if (task != null) {
            this.mQueue.cancelTask((AbsTaskQueue) task, 4);
            this.mQueue.startTask((AbsTaskQueue) task, 5);
        }
    }
}
