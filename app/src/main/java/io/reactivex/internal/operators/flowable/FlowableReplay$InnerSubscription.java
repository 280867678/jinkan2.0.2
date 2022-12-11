package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.r80;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableReplay$InnerSubscription<T> extends AtomicLong implements t51, p60 {
    public static final long CANCELLED = Long.MIN_VALUE;
    public static final long serialVersionUID = -4453897557930727610L;
    public final s51<? super T> child;
    public boolean emitting;
    public Object index;
    public boolean missed;
    public final r80<T> parent;
    public final AtomicLong totalRequested = new AtomicLong();

    public FlowableReplay$InnerSubscription(r80<T> r80Var, s51<? super T> s51Var) {
        this.parent = r80Var;
        this.child = s51Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        dispose();
    }

    @Override // me.tvspark.p60
    public void dispose() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            throw null;
        }
    }

    public <U> U index() {
        return (U) this.index;
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get() == Long.MIN_VALUE;
    }

    public long produced(long j) {
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j);
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        long j2;
        if (SubscriptionHelper.validate(j)) {
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return;
                }
                if (j2 >= 0 && j == 0) {
                    return;
                }
            } while (!compareAndSet(j2, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, j)));
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.totalRequested, j);
            throw null;
        }
    }
}
