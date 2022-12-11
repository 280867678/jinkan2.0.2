package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.g70;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableRetryPredicate$RepeatSubscriber<T> extends AtomicInteger implements s51<T> {
    public static final long serialVersionUID = -7098360935104053232L;
    public final s51<? super T> actual;
    public final g70<? super Throwable> predicate;
    public long remaining;

    /* renamed from: sa */
    public final SubscriptionArbiter f4388sa;
    public final r51<? extends T> source;

    public FlowableRetryPredicate$RepeatSubscriber(s51<? super T> s51Var, long j, g70<? super Throwable> g70Var, SubscriptionArbiter subscriptionArbiter, r51<? extends T> r51Var) {
        this.actual = s51Var;
        this.f4388sa = subscriptionArbiter;
        this.source = r51Var;
        this.predicate = g70Var;
        this.remaining = j;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        long j = this.remaining;
        if (j != Long.MAX_VALUE) {
            this.remaining = j - 1;
        }
        if (j == 0) {
            this.actual.onError(th);
            return;
        }
        try {
            if (!this.predicate.test(th)) {
                this.actual.onError(th);
            } else {
                subscribeNext();
            }
        } catch (Throwable th2) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            this.actual.onError(new CompositeException(th, th2));
        }
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        this.actual.onNext(t);
        this.f4388sa.produced(1L);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        this.f4388sa.setSubscription(t51Var);
    }

    public void subscribeNext() {
        if (getAndIncrement() == 0) {
            int i = 1;
            while (!this.f4388sa.isCancelled()) {
                this.source.subscribe(this);
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }
}
