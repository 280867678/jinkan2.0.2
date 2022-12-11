package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.l70;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.u60;

/* loaded from: classes4.dex */
public final class FlowableRetryBiPredicate$RetryBiSubscriber<T> extends AtomicInteger implements s51<T> {
    public static final long serialVersionUID = -7098360935104053232L;
    public final s51<? super T> actual;
    public final u60<? super Integer, ? super Throwable> predicate;
    public int retries;

    /* renamed from: sa */
    public final SubscriptionArbiter f4387sa;
    public final r51<? extends T> source;

    public FlowableRetryBiPredicate$RetryBiSubscriber(s51<? super T> s51Var, u60<? super Integer, ? super Throwable> u60Var, SubscriptionArbiter subscriptionArbiter, r51<? extends T> r51Var) {
        this.actual = s51Var;
        this.f4387sa = subscriptionArbiter;
        this.source = r51Var;
        this.predicate = u60Var;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        try {
            u60<? super Integer, ? super Throwable> u60Var = this.predicate;
            int i = this.retries + 1;
            this.retries = i;
            Integer valueOf = Integer.valueOf(i);
            if (((l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) u60Var) != null) {
                if (!l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(valueOf, th)) {
                    this.actual.onError(th);
                    return;
                } else {
                    subscribeNext();
                    return;
                }
            }
            throw null;
        } catch (Throwable th2) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            this.actual.onError(new CompositeException(th, th2));
        }
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        this.actual.onNext(t);
        this.f4387sa.produced(1L);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        this.f4387sa.setSubscription(t51Var);
    }

    public void subscribeNext() {
        if (getAndIncrement() == 0) {
            int i = 1;
            while (!this.f4387sa.isCancelled()) {
                this.source.subscribe(this);
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }
}
