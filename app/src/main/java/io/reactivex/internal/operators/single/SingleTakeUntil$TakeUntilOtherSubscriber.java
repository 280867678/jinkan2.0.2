package io.reactivex.internal.operators.single;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class SingleTakeUntil$TakeUntilOtherSubscriber extends AtomicReference<t51> implements s51<Object> {
    public static final long serialVersionUID = 5170026210238877381L;
    public final SingleTakeUntil$TakeUntilMainObserver<?> parent;

    public SingleTakeUntil$TakeUntilOtherSubscriber(SingleTakeUntil$TakeUntilMainObserver<?> singleTakeUntil$TakeUntilMainObserver) {
        this.parent = singleTakeUntil$TakeUntilMainObserver;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.parent.otherError(new CancellationException());
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.parent.otherError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(Object obj) {
        if (SubscriptionHelper.cancel(this)) {
            onComplete();
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this, t51Var)) {
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
