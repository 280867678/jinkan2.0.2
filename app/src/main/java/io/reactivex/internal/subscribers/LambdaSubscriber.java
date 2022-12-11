package io.reactivex.internal.subscribers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.r60;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.x60;

/* loaded from: classes4.dex */
public final class LambdaSubscriber<T> extends AtomicReference<t51> implements s51<T>, t51, p60 {
    public static final long serialVersionUID = -7251123623727029452L;
    public final r60 onComplete;
    public final x60<? super Throwable> onError;
    public final x60<? super T> onNext;
    public final x60<? super t51> onSubscribe;

    public LambdaSubscriber(x60<? super T> x60Var, x60<? super Throwable> x60Var2, r60 r60Var, x60<? super t51> x60Var3) {
        this.onNext = x60Var;
        this.onError = x60Var2;
        this.onComplete = r60Var;
        this.onSubscribe = x60Var3;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // me.tvspark.p60
    public void dispose() {
        cancel();
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        t51 t51Var = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (t51Var != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            }
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        t51 t51Var = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (t51Var == subscriptionHelper) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        lazySet(subscriptionHelper);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new CompositeException(th, th2));
        }
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (!isDisposed()) {
            try {
                this.onNext.accept(t);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                get().cancel();
                onError(th);
            }
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this, t51Var)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                t51Var.cancel();
                onError(th);
            }
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        get().request(j);
    }
}
