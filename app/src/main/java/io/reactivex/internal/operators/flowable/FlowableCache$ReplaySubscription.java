package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.k80;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableCache$ReplaySubscription<T> extends AtomicInteger implements t51 {
    public static final long CANCELLED = -1;
    public static final long serialVersionUID = -2557562030197141021L;
    public final s51<? super T> child;
    public Object[] currentBuffer;
    public int currentIndexInBuffer;
    public int index;
    public final AtomicLong requested = new AtomicLong();
    public final k80<T> state;

    public FlowableCache$ReplaySubscription(s51<? super T> s51Var, k80<T> k80Var) {
        this.child = s51Var;
        this.state = k80Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        if (this.requested.getAndSet(-1L) != -1) {
            throw null;
        }
    }

    public void replay() {
        if (getAndIncrement() == 0 && this.requested.get() >= 0) {
            throw null;
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        long j2;
        if (SubscriptionHelper.validate(j)) {
            do {
                j2 = this.requested.get();
                if (j2 == -1) {
                    return;
                }
            } while (!this.requested.compareAndSet(j2, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, j)));
            replay();
        }
    }
}
