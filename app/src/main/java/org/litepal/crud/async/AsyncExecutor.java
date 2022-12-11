package org.litepal.crud.async;

/* loaded from: classes5.dex */
public abstract class AsyncExecutor {
    public Runnable pendingTask;

    public void execute() {
        if (this.pendingTask != null) {
            new Thread(this.pendingTask).start();
        }
    }

    public void submit(Runnable runnable) {
        this.pendingTask = runnable;
    }
}
