package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicBoolean;
import me.tvspark.outline;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class BooleanSubscription extends AtomicBoolean implements t51 {
    public static final long serialVersionUID = -8127758972444290902L;

    @Override // me.tvspark.t51
    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("BooleanSubscription(cancelled=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(get());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
