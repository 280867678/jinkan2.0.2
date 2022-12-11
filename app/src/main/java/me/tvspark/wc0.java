package me.tvspark;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import me.tvspark.k60;

/* loaded from: classes4.dex */
public class wc0 extends k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements p60 {
    public volatile boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final ScheduledExecutorService Wwwwwwwwwwwwwwwwwwwwwwww;

    public wc0(ThreadFactory threadFactory) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = yc0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(threadFactory);
    }

    public ScheduledRunnable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, long j, TimeUnit timeUnit, h70 h70Var) {
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(runnable, h70Var);
        if (h70Var == null || h70Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(scheduledRunnable)) {
            try {
                scheduledRunnable.setFuture(j <= 0 ? this.Wwwwwwwwwwwwwwwwwwwwwwww.submit((Callable) scheduledRunnable) : this.Wwwwwwwwwwwwwwwwwwwwwwww.schedule((Callable) scheduledRunnable, j, timeUnit));
            } catch (RejectedExecutionException e) {
                h70Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(scheduledRunnable);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) e);
            }
            return scheduledRunnable;
        }
        return scheduledRunnable;
    }

    @Override // me.tvspark.k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, 0L, null);
    }

    @Override // me.tvspark.k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.Wwwwwwwwwwwwwwwwwwwwwww ? EmptyDisposable.INSTANCE : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, j, timeUnit, (h70) null);
    }

    @Override // me.tvspark.p60
    public void dispose() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.shutdownNow();
        }
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }
}
