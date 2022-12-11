package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.s60;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableCollect$CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements s51<T> {
    public static final long serialVersionUID = -3589550218733891694L;
    public final s60<? super U, ? super T> collector;
    public boolean done;

    /* renamed from: s */
    public t51 f4360s;

    /* renamed from: u */
    public final U f4361u;

    public FlowableCollect$CollectSubscriber(s51<? super U> s51Var, U u, s60<? super U, ? super T> s60Var) {
        super(s51Var);
        this.collector = s60Var;
        this.f4361u = u;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, me.tvspark.t51
    public void cancel() {
        super.cancel();
        this.f4360s.cancel();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        complete(this.f4361u);
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.done) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.done = true;
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            this.collector.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((U) this.f4361u, t);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            this.f4360s.cancel();
            onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4360s, t51Var)) {
            this.f4360s = t51Var;
            this.actual.onSubscribe(this);
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
