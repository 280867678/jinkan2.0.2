package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class MaybeDelayOtherPublisher$OtherSubscriber<T> extends AtomicReference<t51> implements s51<Object> {
    public static final long serialVersionUID = -1215060610805418006L;
    public final a60<? super T> actual;
    public Throwable error;
    public T value;

    public MaybeDelayOtherPublisher$OtherSubscriber(a60<? super T> a60Var) {
        this.actual = a60Var;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        Throwable th = this.error;
        if (th != null) {
            this.actual.onError(th);
            return;
        }
        T t = this.value;
        if (t != null) {
            this.actual.onSuccess(t);
        } else {
            this.actual.onComplete();
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        Throwable th2 = this.error;
        if (th2 == null) {
            this.actual.onError(th);
        } else {
            this.actual.onError(new CompositeException(th2, th));
        }
    }

    @Override // me.tvspark.s51
    public void onNext(Object obj) {
        t51 t51Var = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (t51Var != subscriptionHelper) {
            lazySet(subscriptionHelper);
            t51Var.cancel();
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
