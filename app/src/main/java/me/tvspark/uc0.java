package me.tvspark;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.k60;

/* loaded from: classes4.dex */
public final class uc0 extends k60 {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final TimeUnit Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = TimeUnit.SECONDS;
    public static final RxThreadFactory Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final RxThreadFactory Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AtomicReference<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>(Wwwwwwwwwwwwwwwwwwwwwwwwwwww);

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends wc0 {
        public long Wwwwwwwwwwwwwwwwwwwwww = 0;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
        public final AtomicBoolean Wwwwwwwwwwwwwwwwwwwww = new AtomicBoolean();
        public final o60 Wwwwwwwwwwwwwwwwwwwwwwww = new o60();

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = uc0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                while (true) {
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uc0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        break;
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.poll();
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        break;
                    }
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }

        @Override // me.tvspark.k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww ? EmptyDisposable.INSTANCE : this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, j, timeUnit, this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (this.Wwwwwwwwwwwwwwwwwwwww.compareAndSet(false, true)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.dispose();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = System.nanoTime() + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.offer(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    return;
                }
                throw null;
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwww.get();
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final Future<?> Wwwwwwwwwwwwwwwwwwww;
        public final ScheduledExecutorService Wwwwwwwwwwwwwwwwwwwww;
        public final o60 Wwwwwwwwwwwwwwwwwwwwww;
        public final ConcurrentLinkedQueue<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.Wwwwwwwwwwwwwwwwwwwwwww = new ConcurrentLinkedQueue<>();
            this.Wwwwwwwwwwwwwwwwwwwwww = new o60();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, uc0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = scheduledExecutorService;
            this.Wwwwwwwwwwwwwwwwwwww = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                long nanoTime = System.nanoTime();
                Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwwww.iterator();
                while (it.hasNext()) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
                    if (next.Wwwwwwwwwwwwwwwwwwwwww > nanoTime) {
                        return;
                    }
                    if (this.Wwwwwwwwwwwwwwwwwwwwwww.remove(next)) {
                        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next);
                    }
                }
            }
        }
    }

    static {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L, null);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.dispose();
        Future<?> future = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
        if (future != null) {
            future.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RxThreadFactory("RxCachedThreadScheduler", max);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
    }

    public uc0() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(60L, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(Wwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.dispose();
            Future<?> future = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
            if (scheduledExecutorService == null) {
                return;
            }
            scheduledExecutorService.shutdownNow();
        }
    }

    @Override // me.tvspark.k60
    public k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get());
    }
}
