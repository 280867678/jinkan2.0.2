package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.l70;
import me.tvspark.r40;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public class SubscriptionArbiter extends AtomicInteger implements t51 {
    public static final long serialVersionUID = -2189523197179400958L;
    public t51 actual;
    public volatile boolean cancelled;
    public long requested;
    public boolean unbounded;
    public final AtomicReference<t51> missedSubscription = new AtomicReference<>();
    public final AtomicLong missedRequested = new AtomicLong();
    public final AtomicLong missedProduced = new AtomicLong();

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            drain();
        }
    }

    public final void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    public final void drainLoop() {
        int i = 1;
        t51 t51Var = null;
        long j = 0;
        do {
            t51 t51Var2 = this.missedSubscription.get();
            if (t51Var2 != null) {
                t51Var2 = this.missedSubscription.getAndSet(null);
            }
            long j2 = this.missedRequested.get();
            if (j2 != 0) {
                j2 = this.missedRequested.getAndSet(0L);
            }
            long j3 = this.missedProduced.get();
            if (j3 != 0) {
                j3 = this.missedProduced.getAndSet(0L);
            }
            t51 t51Var3 = this.actual;
            if (this.cancelled) {
                if (t51Var3 != null) {
                    t51Var3.cancel();
                    this.actual = null;
                }
                if (t51Var2 != null) {
                    t51Var2.cancel();
                }
            } else {
                long j4 = this.requested;
                if (j4 != Long.MAX_VALUE) {
                    j4 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        j4 -= j3;
                        if (j4 < 0) {
                            SubscriptionHelper.reportMoreProduced(j4);
                            j4 = 0;
                        }
                    }
                    this.requested = j4;
                }
                if (t51Var2 != null) {
                    if (t51Var3 != null) {
                        t51Var3.cancel();
                    }
                    this.actual = t51Var2;
                    if (j4 != 0) {
                        j = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j4);
                        t51Var = t51Var2;
                    }
                } else if (t51Var3 != null && j2 != 0) {
                    j = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j2);
                    t51Var = t51Var3;
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
        if (j != 0) {
            t51Var.request(j);
        }
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long j) {
        if (this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.missedProduced, j);
            drain();
            return;
        }
        long j2 = this.requested;
        if (j2 != Long.MAX_VALUE) {
            long j3 = j2 - j;
            if (j3 < 0) {
                SubscriptionHelper.reportMoreProduced(j3);
                j3 = 0;
            }
            this.requested = j3;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        drainLoop();
    }

    @Override // me.tvspark.t51
    public final void request(long j) {
        if (!SubscriptionHelper.validate(j) || this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.missedRequested, j);
            drain();
            return;
        }
        long j2 = this.requested;
        if (j2 != Long.MAX_VALUE) {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, j);
            this.requested = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == Long.MAX_VALUE) {
                this.unbounded = true;
            }
        }
        t51 t51Var = this.actual;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (t51Var == null) {
            return;
        }
        t51Var.request(j);
    }

    public final void setSubscription(t51 t51Var) {
        if (this.cancelled) {
            t51Var.cancel();
            return;
        }
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t51Var, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            t51 andSet = this.missedSubscription.getAndSet(t51Var);
            if (andSet != null) {
                andSet.cancel();
            }
            drain();
            return;
        }
        t51 t51Var2 = this.actual;
        if (t51Var2 != null) {
            t51Var2.cancel();
        }
        this.actual = t51Var;
        long j = this.requested;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (j == 0) {
            return;
        }
        t51Var.request(j);
    }
}
