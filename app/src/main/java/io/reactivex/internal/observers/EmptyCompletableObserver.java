package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.u50;

/* loaded from: classes4.dex */
public final class EmptyCompletableObserver extends AtomicReference<p60> implements u50, p60 {
    public static final long serialVersionUID = -7545121636549663526L;

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // me.tvspark.u50
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // me.tvspark.u50
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
    }

    @Override // me.tvspark.u50
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this, p60Var);
    }
}
