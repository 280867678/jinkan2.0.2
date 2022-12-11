package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class MaybeTimeoutPublisher$TimeoutOtherMaybeObserver<T, U> extends AtomicReference<t51> implements s51<Object> {
    public static final long serialVersionUID = 8663801314800248617L;
    public final MaybeTimeoutPublisher$TimeoutMainMaybeObserver<T, U> parent;

    public MaybeTimeoutPublisher$TimeoutOtherMaybeObserver(MaybeTimeoutPublisher$TimeoutMainMaybeObserver<T, U> maybeTimeoutPublisher$TimeoutMainMaybeObserver) {
        this.parent = maybeTimeoutPublisher$TimeoutMainMaybeObserver;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.parent.otherComplete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.parent.otherError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(Object obj) {
        get().cancel();
        this.parent.otherComplete();
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this, t51Var)) {
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
