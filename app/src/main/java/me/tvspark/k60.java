package me.tvspark;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public abstract class k60 {
    public static final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* loaded from: classes4.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements p60 {

        /* loaded from: classes4.dex */
        public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public long Wwwwwwwwwwwwwwwwwww;
            public long Wwwwwwwwwwwwwwwwwwww;
            public long Wwwwwwwwwwwwwwwwwwwww;
            public final long Wwwwwwwwwwwwwwwwwwwwww;
            public final SequentialDisposable Wwwwwwwwwwwwwwwwwwwwwww;
            public final Runnable Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = runnable;
                this.Wwwwwwwwwwwwwwwwwwwwwww = sequentialDisposable;
                this.Wwwwwwwwwwwwwwwwwwwwww = j3;
                this.Wwwwwwwwwwwwwwwwwwww = j2;
                this.Wwwwwwwwwwwwwwwwwww = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.run();
                if (!this.Wwwwwwwwwwwwwwwwwwwwwww.isDisposed()) {
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TimeUnit.NANOSECONDS);
                    long j2 = k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    long j3 = this.Wwwwwwwwwwwwwwwwwwww;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + j2 >= j3) {
                        long j4 = this.Wwwwwwwwwwwwwwwwwwwwww;
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < j3 + j4 + j2) {
                            long j5 = this.Wwwwwwwwwwwwwwwwwww;
                            long j6 = this.Wwwwwwwwwwwwwwwwwwwww + 1;
                            this.Wwwwwwwwwwwwwwwwwwwww = j6;
                            j = (j6 * j4) + j5;
                            this.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            this.Wwwwwwwwwwwwwwwwwwwwwww.replace(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, TimeUnit.NANOSECONDS));
                        }
                    }
                    long j7 = this.Wwwwwwwwwwwwwwwwwwwwww;
                    j = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + j7;
                    long j8 = this.Wwwwwwwwwwwwwwwwwwwww + 1;
                    this.Wwwwwwwwwwwwwwwwwwwww = j8;
                    this.Wwwwwwwwwwwwwwwwwww = j - (j7 * j8);
                    this.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwww.replace(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, TimeUnit.NANOSECONDS));
                }
            }
        }

        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            long nanos = timeUnit.toNanos(j2);
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TimeUnit.NANOSECONDS);
            p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit.toNanos(j) + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, runnable, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, sequentialDisposable2, nanos), j, timeUnit);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == EmptyDisposable.INSTANCE) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            }
            sequentialDisposable.replace(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            return sequentialDisposable2;
        }

        public abstract p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, long j, TimeUnit timeUnit);
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable, p60 {
        public volatile boolean Wwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
        public final Runnable Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = runnable;
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwww.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.Wwwwwwwwwwwwwwwwwwwwww) {
                try {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.run();
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    this.Wwwwwwwwwwwwwwwwwwwwwww.dispose();
                    throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ Runnable Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60 k60Var, Runnable runnable, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = runnable;
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.run();
            } finally {
                this.Wwwwwwwwwwwwwwwwwwwwwww.dispose();
            }
        }
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public abstract Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, j2, timeUnit);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == EmptyDisposable.INSTANCE ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, long j, TimeUnit timeUnit) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, runnable, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2), j, timeUnit);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }
}
