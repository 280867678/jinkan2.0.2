package me.tvspark;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public abstract class td0<T> implements s51<T>, p60 {
    public final AtomicReference<t51> Wwwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();

    @Override // me.tvspark.p60
    public final void dispose() {
        SubscriptionHelper.cancel(this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.p60
    public final boolean isDisposed() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // me.tvspark.s51
    public final void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this.Wwwwwwwwwwwwwwwwwwwwwwww, t51Var)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.get().request(Long.MAX_VALUE);
        }
    }
}
