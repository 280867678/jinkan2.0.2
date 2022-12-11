package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableRepeatWhen$WhenReceiver<T, U> extends AtomicInteger implements s51<Object>, t51 {
    public static final long serialVersionUID = 2827772011130406689L;
    public final r51<T> source;
    public FlowableRepeatWhen$WhenSourceSubscriber<T, U> subscriber;
    public final AtomicReference<t51> subscription = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();

    public FlowableRepeatWhen$WhenReceiver(r51<T> r51Var) {
        this.source = r51Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        SubscriptionHelper.cancel(this.subscription);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.subscriber.cancel();
        this.subscriber.actual.onComplete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.subscriber.cancel();
        this.subscriber.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(Object obj) {
        if (getAndIncrement() == 0) {
            while (!SubscriptionHelper.isCancelled(this.subscription.get())) {
                this.source.subscribe(this.subscriber);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        SubscriptionHelper.deferredSetOnce(this.subscription, this.requested, t51Var);
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.subscription, this.requested, j);
    }
}
