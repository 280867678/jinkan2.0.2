package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import me.tvspark.g70;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableAny$AnySubscriber<T> extends DeferredScalarSubscription<Boolean> implements s51<T> {
    public static final long serialVersionUID = -2311252482644620661L;
    public boolean done;
    public final g70<? super T> predicate;

    /* renamed from: s */
    public t51 f4357s;

    public FlowableAny$AnySubscriber(s51<? super Boolean> s51Var, g70<? super T> g70Var) {
        super(s51Var);
        this.predicate = g70Var;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, me.tvspark.t51
    public void cancel() {
        super.cancel();
        this.f4357s.cancel();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (!this.done) {
            this.done = true;
            complete(false);
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
        try {
            if (!this.predicate.test(t)) {
                return;
            }
            this.done = true;
            this.f4357s.cancel();
            complete(true);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            this.f4357s.cancel();
            onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4357s, t51Var)) {
            this.f4357s = t51Var;
            this.actual.onSubscribe(this);
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
