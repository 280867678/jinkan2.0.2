package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.v60;

/* loaded from: classes4.dex */
public final class FlowableRepeatUntil$RepeatSubscriber<T> extends AtomicInteger implements s51<T> {
    public static final long serialVersionUID = -7098360935104053232L;
    public final s51<? super T> actual;

    /* renamed from: sa */
    public final SubscriptionArbiter f4386sa;
    public final r51<? extends T> source;
    public final v60 stop;

    public FlowableRepeatUntil$RepeatSubscriber(s51<? super T> s51Var, v60 v60Var, SubscriptionArbiter subscriptionArbiter, r51<? extends T> r51Var) {
        this.actual = s51Var;
        this.f4386sa = subscriptionArbiter;
        this.source = r51Var;
        this.stop = v60Var;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        try {
            if (this.stop.getAsBoolean()) {
                this.actual.onComplete();
            } else {
                subscribeNext();
            }
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            this.actual.onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        this.actual.onNext(t);
        this.f4386sa.produced(1L);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        this.f4386sa.setSubscription(t51Var);
    }

    public void subscribeNext() {
        if (getAndIncrement() == 0) {
            int i = 1;
            do {
                this.source.subscribe(this);
                i = addAndGet(-i);
            } while (i != 0);
        }
    }
}
