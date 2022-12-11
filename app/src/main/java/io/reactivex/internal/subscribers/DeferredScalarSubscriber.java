package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements s51<T> {
    public static final long serialVersionUID = 2984505488220891551L;
    public boolean hasValue;

    /* renamed from: s */
    public t51 f4473s;

    public DeferredScalarSubscriber(s51<? super R> s51Var) {
        super(s51Var);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, me.tvspark.t51
    public void cancel() {
        super.cancel();
        this.f4473s.cancel();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.hasValue) {
            complete(this.value);
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
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4473s, t51Var)) {
            this.f4473s = t51Var;
            this.actual.onSubscribe(this);
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
