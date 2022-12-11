package me.tvspark;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.k60;

/* loaded from: classes4.dex */
public final class tc0 extends k60 {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final RxThreadFactory Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
    public final AtomicReference<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends wc0 {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2] = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tc0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i == 0) {
                return tc0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1 + j;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[(int) (j % i)];
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public volatile boolean Wwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;
        public final j70 Wwwwwwwwwwwwwwwwwwwwww;
        public final j70 Wwwwwwwwwwwwwwwwwwwwwwww = new j70();
        public final o60 Wwwwwwwwwwwwwwwwwwwwwww = new o60();

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            j70 j70Var = new j70();
            this.Wwwwwwwwwwwwwwwwwwwwww = j70Var;
            j70Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable) {
            return this.Wwwwwwwwwwwwwwwwwwww ? EmptyDisposable.INSTANCE : this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, 0L, (TimeUnit) null, this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.Wwwwwwwwwwwwwwwwwwww ? EmptyDisposable.INSTANCE : this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, j, timeUnit, this.Wwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.Wwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwww.dispose();
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwww;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int intValue = Integer.getInteger("rx2.computation-threads", 0).intValue();
        if (intValue > 0 && intValue <= availableProcessors) {
            availableProcessors = intValue;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = availableProcessors;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new RxThreadFactory("RxComputationShutdown"));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.dispose();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())));
    }

    public tc0() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.dispose();
            }
        }
    }

    @Override // me.tvspark.k60
    public k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // me.tvspark.k60
    public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, long j, TimeUnit timeUnit) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            try {
                return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j <= 0 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww.submit(runnable) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww.schedule(runnable, j, timeUnit));
            } catch (RejectedExecutionException e) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) e);
                return EmptyDisposable.INSTANCE;
            }
        }
        throw null;
    }

    @Override // me.tvspark.k60
    public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            try {
                return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Future<?>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww.scheduleAtFixedRate(runnable, j, j2, timeUnit));
            } catch (RejectedExecutionException e) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) e);
                return EmptyDisposable.INSTANCE;
            }
        }
        throw null;
    }
}
