package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.q80;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowablePublishMulticast$MulticastSubscription<T> extends AtomicLong implements t51 {
    public static final long serialVersionUID = 8664815189257569791L;
    public final s51<? super T> actual;
    public final q80<T> parent;

    public FlowablePublishMulticast$MulticastSubscription(s51<? super T> s51Var, q80<T> q80Var) {
        this.actual = s51Var;
        this.parent = q80Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        getAndSet(Long.MIN_VALUE);
        throw null;
    }

    public boolean isCancelled() {
        return get() == Long.MIN_VALUE;
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j);
            throw null;
        }
    }
}
