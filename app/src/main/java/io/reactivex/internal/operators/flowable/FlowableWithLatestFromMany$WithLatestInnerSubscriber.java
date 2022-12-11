package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableWithLatestFromMany$WithLatestInnerSubscriber extends AtomicReference<t51> implements s51<Object>, p60 {
    public static final long serialVersionUID = 3256684027868224024L;
    public boolean hasValue;
    public final int index;
    public final FlowableWithLatestFromMany$WithLatestFromSubscriber<?, ?> parent;

    public FlowableWithLatestFromMany$WithLatestInnerSubscriber(FlowableWithLatestFromMany$WithLatestFromSubscriber<?, ?> flowableWithLatestFromMany$WithLatestFromSubscriber, int i) {
        this.parent = flowableWithLatestFromMany$WithLatestFromSubscriber;
        this.index = i;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return SubscriptionHelper.isCancelled(get());
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.parent.innerComplete(this.index, this.hasValue);
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.parent.innerError(this.index, th);
    }

    @Override // me.tvspark.s51
    public void onNext(Object obj) {
        if (!this.hasValue) {
            this.hasValue = true;
        }
        this.parent.innerNext(this.index, obj);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this, t51Var)) {
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
