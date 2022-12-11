package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class MaybeTimeoutMaybe$TimeoutOtherMaybeObserver<T, U> extends AtomicReference<p60> implements a60<Object> {
    public static final long serialVersionUID = 8663801314800248617L;
    public final MaybeTimeoutMaybe$TimeoutMainMaybeObserver<T, U> parent;

    public MaybeTimeoutMaybe$TimeoutOtherMaybeObserver(MaybeTimeoutMaybe$TimeoutMainMaybeObserver<T, U> maybeTimeoutMaybe$TimeoutMainMaybeObserver) {
        this.parent = maybeTimeoutMaybe$TimeoutMainMaybeObserver;
    }

    @Override // me.tvspark.a60
    public void onComplete() {
        this.parent.otherComplete();
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        this.parent.otherError(th);
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this, p60Var);
    }

    @Override // me.tvspark.a60
    public void onSuccess(Object obj) {
        this.parent.otherComplete();
    }
}
