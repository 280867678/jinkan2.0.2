package io.reactivex.internal.subscriptions;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class AsyncSubscription extends AtomicLong implements t51, p60 {
    public static final long serialVersionUID = 7028635084060361255L;
    public final AtomicReference<t51> actual;
    public final AtomicReference<p60> resource;

    public AsyncSubscription() {
        this.resource = new AtomicReference<>();
        this.actual = new AtomicReference<>();
    }

    public AsyncSubscription(p60 p60Var) {
        this();
        this.resource.lazySet(p60Var);
    }

    @Override // me.tvspark.t51
    public void cancel() {
        dispose();
    }

    @Override // me.tvspark.p60
    public void dispose() {
        SubscriptionHelper.cancel(this.actual);
        DisposableHelper.dispose(this.resource);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return this.actual.get() == SubscriptionHelper.CANCELLED;
    }

    public boolean replaceResource(p60 p60Var) {
        return DisposableHelper.replace(this.resource, p60Var);
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.actual, this, j);
    }

    public boolean setResource(p60 p60Var) {
        return DisposableHelper.set(this.resource, p60Var);
    }

    public void setSubscription(t51 t51Var) {
        SubscriptionHelper.deferredSetOnce(this.actual, this, t51Var);
    }
}
