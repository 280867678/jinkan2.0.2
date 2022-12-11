package me.tvspark;

import io.reactivex.disposables.RunnableDisposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.k60;

/* loaded from: classes4.dex */
public final class ad0 extends k60 {
    public static final ad0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ad0();

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements p60 {
        public volatile boolean Wwwwwwwwwwwwwwwwwwwww;
        public final PriorityBlockingQueue<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwww = new PriorityBlockingQueue<>();
        public final AtomicInteger Wwwwwwwwwwwwwwwwwwwwwww = new AtomicInteger();
        public final AtomicInteger Wwwwwwwwwwwwwwwwwwwwww = new AtomicInteger();

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = true;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.remove(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        @Override // me.tvspark.k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TimeUnit.MILLISECONDS));
        }

        public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, long j) {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                return EmptyDisposable.INSTANCE;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, Long.valueOf(j), this.Wwwwwwwwwwwwwwwwwwwwww.incrementAndGet());
            this.Wwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (this.Wwwwwwwwwwwwwwwwwwwwwww.getAndIncrement() != 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "run is null");
                return new RunnableDisposable(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            int i = 1;
            while (true) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww poll = this.Wwwwwwwwwwwwwwwwwwwwwwww.poll();
                if (poll == null) {
                    i = this.Wwwwwwwwwwwwwwwwwwwwwww.addAndGet(-i);
                    if (i == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!poll.Wwwwwwwwwwwwwwwwwwwww) {
                    poll.Wwwwwwwwwwwwwwwwwwwwwwww.run();
                }
            }
        }

        @Override // me.tvspark.k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, long j, TimeUnit timeUnit) {
            long millis = timeUnit.toMillis(j) + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TimeUnit.MILLISECONDS);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, this, millis), millis);
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwwww = true;
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Comparable<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        public volatile boolean Wwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwwww;
        public final Runnable Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, Long l, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = runnable;
            this.Wwwwwwwwwwwwwwwwwwwwwww = l.longValue();
            this.Wwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // java.lang.Comparable
        public int compareTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                int i = this.Wwwwwwwwwwwwwwwwwwwwww;
                int i2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww;
                if (i < i2) {
                    return -1;
                }
                return i > i2 ? 1 : 0;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final long Wwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
        public final Runnable Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = runnable;
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww) {
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TimeUnit.MILLISECONDS);
                long j = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (j > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    long j2 = j - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (j2 > 0) {
                        try {
                            Thread.sleep(j2);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) e);
                            return;
                        }
                    }
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwww.run();
            }
        }
    }

    @Override // me.tvspark.k60
    public k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.k60
    public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable) {
        runnable.run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // me.tvspark.k60
    public p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            runnable.run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) e);
        }
        return EmptyDisposable.INSTANCE;
    }
}
