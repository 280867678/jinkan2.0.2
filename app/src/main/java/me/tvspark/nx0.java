package me.tvspark;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;

@ef0
/* loaded from: classes4.dex */
public class nx0 {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Companion = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static final nx0 NONE = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public long deadlineNanoTime;
    public boolean hasDeadline;
    public long timeoutNanos;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gi0 gi0Var) {
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends nx0 {
        @Override // me.tvspark.nx0
        public nx0 deadlineNanoTime(long j) {
            return this;
        }

        @Override // me.tvspark.nx0
        public void throwIfReached() {
        }

        @Override // me.tvspark.nx0
        public nx0 timeout(long j, TimeUnit timeUnit) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit");
            return this;
        }
    }

    public nx0 clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public nx0 clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final nx0 deadline(long j, TimeUnit timeUnit) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit");
        if (j > 0) {
            return deadlineNanoTime(timeUnit.toNanos(j) + System.nanoTime());
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("duration <= 0: ", j).toString());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public nx0 deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final void intersectWith(nx0 nx0Var, xg0<of0> xg0Var) {
        boolean hasDeadline;
        boolean hasDeadline2;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nx0Var, "other");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xg0Var, "block");
        long timeoutNanos = timeoutNanos();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Companion;
        long timeoutNanos2 = nx0Var.timeoutNanos();
        long timeoutNanos3 = timeoutNanos();
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            if (timeoutNanos2 == 0 || (timeoutNanos3 != 0 && timeoutNanos2 >= timeoutNanos3)) {
                timeoutNanos2 = timeoutNanos3;
            }
            timeout(timeoutNanos2, TimeUnit.NANOSECONDS);
            if (!hasDeadline()) {
                if (nx0Var.hasDeadline()) {
                    deadlineNanoTime(nx0Var.deadlineNanoTime());
                }
                try {
                    xg0Var.mo4969invoke();
                    if (!hasDeadline) {
                        return;
                    }
                    return;
                } finally {
                    timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (nx0Var.hasDeadline()) {
                        clearDeadline();
                    }
                }
            }
            long deadlineNanoTime = deadlineNanoTime();
            if (nx0Var.hasDeadline()) {
                deadlineNanoTime(Math.min(deadlineNanoTime(), nx0Var.deadlineNanoTime()));
            }
            try {
                xg0Var.mo4969invoke();
                if (!hasDeadline2) {
                    return;
                }
                return;
            } finally {
                timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (nx0Var.hasDeadline()) {
                    deadlineNanoTime(deadlineNanoTime);
                }
            }
        }
        throw null;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public nx0 timeout(long j, TimeUnit timeUnit) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit");
        if (j >= 0) {
            this.timeoutNanos = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("timeout < 0: ", j).toString());
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object obj) throws InterruptedIOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "monitor");
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            long j = 0;
            if (!hasDeadline && timeoutNanos == 0) {
                obj.wait();
                return;
            }
            long nanoTime = System.nanoTime();
            if (hasDeadline && timeoutNanos != 0) {
                timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - nanoTime);
            } else if (hasDeadline) {
                timeoutNanos = deadlineNanoTime() - nanoTime;
            }
            if (timeoutNanos > 0) {
                long j2 = timeoutNanos / StopWatch.NANO_2_MILLIS;
                Long.signum(j2);
                obj.wait(j2, (int) (timeoutNanos - (StopWatch.NANO_2_MILLIS * j2)));
                j = System.nanoTime() - nanoTime;
            }
            if (j >= timeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
