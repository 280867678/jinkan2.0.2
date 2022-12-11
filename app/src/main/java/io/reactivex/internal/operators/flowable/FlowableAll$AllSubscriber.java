package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import me.tvspark.g70;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableAll$AllSubscriber<T> extends DeferredScalarSubscription<Boolean> implements s51<T> {
    public static final long serialVersionUID = -3521127104134758517L;
    public boolean done;
    public final g70<? super T> predicate;

    /* renamed from: s */
    public t51 f4356s;

    public FlowableAll$AllSubscriber(s51<? super Boolean> s51Var, g70<? super T> g70Var) {
        super(s51Var);
        this.predicate = g70Var;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, me.tvspark.t51
    public void cancel() {
        super.cancel();
        this.f4356s.cancel();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        complete(true);
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
            if (this.predicate.test(t)) {
                return;
            }
            this.done = true;
            this.f4356s.cancel();
            complete(false);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            this.f4356s.cancel();
            onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4356s, t51Var)) {
            this.f4356s = t51Var;
            this.actual.onSubscribe(this);
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
