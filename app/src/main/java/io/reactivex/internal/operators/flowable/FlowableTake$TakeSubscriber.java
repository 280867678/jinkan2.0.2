package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableTake$TakeSubscriber<T> extends AtomicBoolean implements s51<T>, t51 {
    public static final long serialVersionUID = -5636543848937116287L;
    public final s51<? super T> actual;
    public boolean done;
    public final long limit;
    public long remaining;
    public t51 subscription;

    public FlowableTake$TakeSubscriber(s51<? super T> s51Var, long j) {
        this.actual = s51Var;
        this.limit = j;
        this.remaining = j;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        this.subscription.cancel();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.actual.onComplete();
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (!this.done) {
            this.done = true;
            this.subscription.cancel();
            this.actual.onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (!this.done) {
            long j = this.remaining;
            long j2 = j - 1;
            this.remaining = j2;
            if (j <= 0) {
                return;
            }
            boolean z = j2 == 0;
            this.actual.onNext(t);
            if (!z) {
                return;
            }
            this.subscription.cancel();
            onComplete();
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.subscription, t51Var)) {
            this.subscription = t51Var;
            if (this.limit != 0) {
                this.actual.onSubscribe(this);
                return;
            }
            t51Var.cancel();
            this.done = true;
            EmptySubscription.complete(this.actual);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (!SubscriptionHelper.validate(j)) {
            return;
        }
        if (get() || !compareAndSet(false, true) || j < this.limit) {
            this.subscription.request(j);
        } else {
            this.subscription.request(Long.MAX_VALUE);
        }
    }
}
