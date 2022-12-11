package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableRepeat$RepeatSubscriber<T> extends AtomicInteger implements s51<T> {
    public static final long serialVersionUID = -7098360935104053232L;
    public final s51<? super T> actual;
    public long remaining;

    /* renamed from: sa */
    public final SubscriptionArbiter f4385sa;
    public final r51<? extends T> source;

    public FlowableRepeat$RepeatSubscriber(s51<? super T> s51Var, long j, SubscriptionArbiter subscriptionArbiter, r51<? extends T> r51Var) {
        this.actual = s51Var;
        this.f4385sa = subscriptionArbiter;
        this.source = r51Var;
        this.remaining = j;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        long j = this.remaining;
        if (j != Long.MAX_VALUE) {
            this.remaining = j - 1;
        }
        if (j != 0) {
            subscribeNext();
        } else {
            this.actual.onComplete();
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        this.actual.onNext(t);
        this.f4385sa.produced(1L);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        this.f4385sa.setSubscription(t51Var);
    }

    public void subscribeNext() {
        if (getAndIncrement() == 0) {
            int i = 1;
            while (!this.f4385sa.isCancelled()) {
                this.source.subscribe(this);
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }
}
