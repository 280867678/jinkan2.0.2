package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableTakeLastOne$TakeLastOneSubscriber<T> extends DeferredScalarSubscription<T> implements s51<T> {
    public static final long serialVersionUID = -5467847744262967226L;

    /* renamed from: s */
    public t51 f4402s;

    public FlowableTakeLastOne$TakeLastOneSubscriber(s51<? super T> s51Var) {
        super(s51Var);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, me.tvspark.t51
    public void cancel() {
        super.cancel();
        this.f4402s.cancel();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        T t = this.value;
        if (t != null) {
            complete(t);
        } else {
            this.actual.onComplete();
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.value = null;
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        this.value = t;
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4402s, t51Var)) {
            this.f4402s = t51Var;
            this.actual.onSubscribe(this);
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
