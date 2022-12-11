package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import me.tvspark.l70;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.t60;

/* loaded from: classes4.dex */
public final class FlowableReduce$ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements s51<T> {
    public static final long serialVersionUID = -4663883003264602070L;
    public final t60<T, T, T> reducer;

    /* renamed from: s */
    public t51 f4384s;

    public FlowableReduce$ReduceSubscriber(s51<? super T> s51Var, t60<T, T, T> t60Var) {
        super(s51Var);
        this.reducer = t60Var;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, me.tvspark.t51
    public void cancel() {
        super.cancel();
        this.f4384s.cancel();
        this.f4384s = SubscriptionHelper.CANCELLED;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        t51 t51Var = this.f4384s;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (t51Var == subscriptionHelper) {
            return;
        }
        this.f4384s = subscriptionHelper;
        T t = this.value;
        if (t != null) {
            complete(t);
        } else {
            this.actual.onComplete();
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        t51 t51Var = this.f4384s;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (t51Var == subscriptionHelper) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.f4384s = subscriptionHelper;
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.f4384s == SubscriptionHelper.CANCELLED) {
            return;
        }
        T t2 = this.value;
        if (t2 == null) {
            this.value = t;
            return;
        }
        try {
            T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.reducer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t2, t);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "The reducer returned a null value");
            this.value = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            this.f4384s.cancel();
            onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4384s, t51Var)) {
            this.f4384s = t51Var;
            this.actual.onSubscribe(this);
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
