package io.reactivex.internal.subscribers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class SubscriberResourceWrapper<T> extends AtomicReference<p60> implements s51<T>, p60, t51 {
    public static final long serialVersionUID = -8612022020200669122L;
    public final s51<? super T> actual;
    public final AtomicReference<t51> subscription = new AtomicReference<>();

    public SubscriberResourceWrapper(s51<? super T> s51Var) {
        this.actual = s51Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        dispose();
    }

    @Override // me.tvspark.p60
    public void dispose() {
        SubscriptionHelper.cancel(this.subscription);
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return this.subscription.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        dispose();
        this.actual.onComplete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        dispose();
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        do {
            t51 t51Var2 = this.subscription.get();
            if (t51Var2 == SubscriptionHelper.CANCELLED) {
                t51Var.cancel();
                return;
            } else if (t51Var2 != null) {
                t51Var.cancel();
                SubscriptionHelper.reportSubscriptionSet();
                return;
            }
        } while (!this.subscription.compareAndSet(null, t51Var));
        this.actual.onSubscribe(this);
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            this.subscription.get().request(j);
        }
    }

    public void setResource(p60 p60Var) {
        DisposableHelper.set(this, p60Var);
    }
}
