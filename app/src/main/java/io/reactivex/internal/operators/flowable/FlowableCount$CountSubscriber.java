package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableCount$CountSubscriber extends DeferredScalarSubscription<Long> implements s51<Object> {
    public static final long serialVersionUID = 4973004223787171406L;
    public long count;

    /* renamed from: s */
    public t51 f4364s;

    public FlowableCount$CountSubscriber(s51<? super Long> s51Var) {
        super(s51Var);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, me.tvspark.t51
    public void cancel() {
        super.cancel();
        this.f4364s.cancel();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        complete(Long.valueOf(this.count));
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(Object obj) {
        this.count++;
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4364s, t51Var)) {
            this.f4364s = t51Var;
            this.actual.onSubscribe(this);
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
