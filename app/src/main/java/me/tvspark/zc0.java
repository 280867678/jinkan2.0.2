package me.tvspark;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.RxThreadFactory;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.k60;

/* loaded from: classes4.dex */
public final class zc0 extends k60 {
    public static final ScheduledExecutorService Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final RxThreadFactory Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())));
    public final AtomicReference<ScheduledExecutorService> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public volatile boolean Wwwwwwwwwwwwwwwwwwwwww;
        public final o60 Wwwwwwwwwwwwwwwwwwwwwww = new o60();
        public final ScheduledExecutorService Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ScheduledExecutorService scheduledExecutorService) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = scheduledExecutorService;
        }

        @Override // me.tvspark.k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.Wwwwwwwwwwwwwwwwwwwwww) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(runnable, this.Wwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(scheduledRunnable);
            try {
                scheduledRunnable.setFuture(j <= 0 ? this.Wwwwwwwwwwwwwwwwwwwwwwww.submit((Callable) scheduledRunnable) : this.Wwwwwwwwwwwwwwwwwwwwwwww.schedule((Callable) scheduledRunnable, j, timeUnit));
                return scheduledRunnable;
            } catch (RejectedExecutionException e) {
                dispose();
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) e);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.Wwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwwww.dispose();
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwwww;
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public zc0() {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = atomicReference;
        atomicReference.lazySet(yc0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // me.tvspark.k60
    public k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get());
    }

    @Override // me.tvspark.k60
    public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        try {
            return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Future<?>) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get().scheduleAtFixedRate(runnable, j, j2, timeUnit));
        } catch (RejectedExecutionException e) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // me.tvspark.k60
    public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j <= 0 ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get().submit(runnable) : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get().schedule(runnable, j, timeUnit));
        } catch (RejectedExecutionException e) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) e);
            return EmptyDisposable.INSTANCE;
        }
    }
}
