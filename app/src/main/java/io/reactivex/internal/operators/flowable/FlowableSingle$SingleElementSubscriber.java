package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableSingle$SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements s51<T> {
    public static final long serialVersionUID = -5526049321428043809L;
    public final T defaultValue;
    public boolean done;

    /* renamed from: s */
    public t51 f4395s;

    public FlowableSingle$SingleElementSubscriber(s51<? super T> s51Var, T t) {
        super(s51Var);
        this.defaultValue = t;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, me.tvspark.t51
    public void cancel() {
        super.cancel();
        this.f4395s.cancel();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        T t = this.value;
        this.value = null;
        if (t == null) {
            t = this.defaultValue;
        }
        if (t == null) {
            this.actual.onComplete();
        } else {
            complete(t);
        }
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
        if (this.value == null) {
            this.value = t;
            return;
        }
        this.done = true;
        this.f4395s.cancel();
        this.actual.onError(new IllegalArgumentException("Sequence contains more than one element!"));
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4395s, t51Var)) {
            this.f4395s = t51Var;
            this.actual.onSubscribe(this);
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
