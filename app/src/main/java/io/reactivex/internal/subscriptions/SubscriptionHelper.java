package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.l70;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public enum SubscriptionHelper implements t51 {
    CANCELLED;

    public static boolean cancel(AtomicReference<t51> atomicReference) {
        t51 andSet;
        t51 t51Var = atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (t51Var == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == CANCELLED) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static void deferredRequest(AtomicReference<t51> atomicReference, AtomicLong atomicLong, long j) {
        t51 t51Var = atomicReference.get();
        if (t51Var != null) {
            t51Var.request(j);
        } else if (!validate(j)) {
        } else {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(atomicLong, j);
            t51 t51Var2 = atomicReference.get();
            if (t51Var2 == null) {
                return;
            }
            long andSet = atomicLong.getAndSet(0L);
            if (andSet == 0) {
                return;
            }
            t51Var2.request(andSet);
        }
    }

    public static boolean deferredSetOnce(AtomicReference<t51> atomicReference, AtomicLong atomicLong, t51 t51Var) {
        if (setOnce(atomicReference, t51Var)) {
            long andSet = atomicLong.getAndSet(0L);
            if (andSet == 0) {
                return true;
            }
            t51Var.request(andSet);
            return true;
        }
        return false;
    }

    public static boolean isCancelled(t51 t51Var) {
        return t51Var == CANCELLED;
    }

    public static boolean replace(AtomicReference<t51> atomicReference, t51 t51Var) {
        t51 t51Var2;
        do {
            t51Var2 = atomicReference.get();
            if (t51Var2 == CANCELLED) {
                if (t51Var == null) {
                    return false;
                }
                t51Var.cancel();
                return false;
            }
        } while (!atomicReference.compareAndSet(t51Var2, t51Var));
        return true;
    }

    public static void reportMoreProduced(long j) {
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("More produced than requested: ", j)));
    }

    public static void reportSubscriptionSet() {
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new IllegalStateException("Subscription already set!"));
    }

    public static boolean set(AtomicReference<t51> atomicReference, t51 t51Var) {
        t51 t51Var2;
        do {
            t51Var2 = atomicReference.get();
            if (t51Var2 == CANCELLED) {
                if (t51Var == null) {
                    return false;
                }
                t51Var.cancel();
                return false;
            }
        } while (!atomicReference.compareAndSet(t51Var2, t51Var));
        if (t51Var2 != null) {
            t51Var2.cancel();
            return true;
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<t51> atomicReference, t51 t51Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t51Var, "d is null");
        if (!atomicReference.compareAndSet(null, t51Var)) {
            t51Var.cancel();
            if (atomicReference.get() == CANCELLED) {
                return false;
            }
            reportSubscriptionSet();
            return false;
        }
        return true;
    }

    public static boolean validate(long j) {
        if (j <= 0) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("n > 0 required but it was ", j)));
            return false;
        }
        return true;
    }

    public static boolean validate(t51 t51Var, t51 t51Var2) {
        if (t51Var2 == null) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new NullPointerException("next is null"));
            return false;
        } else if (t51Var == null) {
            return true;
        } else {
            t51Var2.cancel();
            reportSubscriptionSet();
            return false;
        }
    }

    @Override // me.tvspark.t51
    public void cancel() {
    }

    @Override // me.tvspark.t51
    public void request(long j) {
    }
}
