package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableCombineLatest$CombineLatestInnerSubscriber<T> extends AtomicReference<t51> implements s51<T> {
    public static final long serialVersionUID = -8730235182291002949L;
    public final int index;
    public final int limit;
    public final FlowableCombineLatest$CombineLatestCoordinator<T, ?> parent;
    public final int prefetch;
    public int produced;

    public FlowableCombineLatest$CombineLatestInnerSubscriber(FlowableCombineLatest$CombineLatestCoordinator<T, ?> flowableCombineLatest$CombineLatestCoordinator, int i, int i2) {
        this.parent = flowableCombineLatest$CombineLatestCoordinator;
        this.index = i;
        this.prefetch = i2;
        this.limit = i2 - (i2 >> 2);
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.parent.innerError(this.index, th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        this.parent.innerValue(this.index, t);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this, t51Var)) {
            t51Var.request(this.prefetch);
        }
    }

    public void requestOne() {
        int i = this.produced + 1;
        if (i != this.limit) {
            this.produced = i;
            return;
        }
        this.produced = 0;
        get().request(i);
    }
}
