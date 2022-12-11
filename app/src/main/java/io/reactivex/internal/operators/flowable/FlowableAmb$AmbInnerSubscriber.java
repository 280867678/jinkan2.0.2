package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.j80;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableAmb$AmbInnerSubscriber<T> extends AtomicReference<t51> implements s51<T>, t51 {
    public static final long serialVersionUID = -1185974347409665484L;
    public final s51<? super T> actual;
    public final int index;
    public final AtomicLong missedRequested = new AtomicLong();
    public final j80<T> parent;
    public boolean won;

    public FlowableAmb$AmbInnerSubscriber(j80<T> j80Var, int i, s51<? super T> s51Var) {
        this.parent = j80Var;
        this.index = i;
        this.actual = s51Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.won) {
            this.actual.onComplete();
            return;
        }
        throw null;
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.won) {
            this.actual.onError(th);
            return;
        }
        throw null;
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.won) {
            this.actual.onNext(t);
            return;
        }
        throw null;
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        SubscriptionHelper.deferredSetOnce(this, this.missedRequested, t51Var);
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this, this.missedRequested, j);
    }
}
