package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import me.tvspark.nd0;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public abstract class FlowableRepeatWhen$WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements s51<T> {
    public static final long serialVersionUID = -5604623027276966720L;
    public final s51<? super T> actual;
    public final nd0<U> processor;
    public long produced;
    public final t51 receiver;

    public FlowableRepeatWhen$WhenSourceSubscriber(s51<? super T> s51Var, nd0<U> nd0Var, t51 t51Var) {
        this.actual = s51Var;
        this.processor = nd0Var;
        this.receiver = t51Var;
    }

    public final void again(U u) {
        long j = this.produced;
        if (j != 0) {
            this.produced = 0L;
            produced(j);
        }
        this.receiver.request(1L);
        this.processor.onNext(u);
    }

    @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, me.tvspark.t51
    public final void cancel() {
        super.cancel();
        this.receiver.cancel();
    }

    @Override // me.tvspark.s51
    public final void onNext(T t) {
        this.produced++;
        this.actual.onNext(t);
    }

    @Override // me.tvspark.s51
    public final void onSubscribe(t51 t51Var) {
        setSubscription(t51Var);
    }
}
