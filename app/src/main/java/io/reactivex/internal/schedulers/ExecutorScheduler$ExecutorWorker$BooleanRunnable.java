package io.reactivex.internal.schedulers;

import java.util.concurrent.atomic.AtomicBoolean;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class ExecutorScheduler$ExecutorWorker$BooleanRunnable extends AtomicBoolean implements Runnable, p60 {
    public static final long serialVersionUID = -2421395018820541164L;
    public final Runnable actual;

    public ExecutorScheduler$ExecutorWorker$BooleanRunnable(Runnable runnable) {
        this.actual = runnable;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        lazySet(true);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get()) {
            return;
        }
        this.actual.run();
    }
}
