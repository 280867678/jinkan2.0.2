package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.u50;

/* loaded from: classes4.dex */
public final class CompletableTimer$TimerDisposable extends AtomicReference<p60> implements p60, Runnable {
    public static final long serialVersionUID = 3167244060586201109L;
    public final u50 actual;

    public CompletableTimer$TimerDisposable(u50 u50Var) {
        this.actual = u50Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // java.lang.Runnable
    public void run() {
        this.actual.onComplete();
    }

    public void setFuture(p60 p60Var) {
        DisposableHelper.replace(this, p60Var);
    }
}
