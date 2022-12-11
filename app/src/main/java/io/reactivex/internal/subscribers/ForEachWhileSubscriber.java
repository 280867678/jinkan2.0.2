package io.reactivex.internal.subscribers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.g70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.r60;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.x60;

/* loaded from: classes4.dex */
public final class ForEachWhileSubscriber<T> extends AtomicReference<t51> implements s51<T>, p60 {
    public static final long serialVersionUID = -4403180040475402120L;
    public boolean done;
    public final r60 onComplete;
    public final x60<? super Throwable> onError;
    public final g70<? super T> onNext;

    public ForEachWhileSubscriber(g70<? super T> g70Var, x60<? super Throwable> x60Var, r60 r60Var) {
        this.onNext = g70Var;
        this.onError = x60Var;
        this.onComplete = r60Var;
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
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.done) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new CompositeException(th, th2));
        }
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            if (this.onNext.test(t)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            dispose();
            onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this, t51Var)) {
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
