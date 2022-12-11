package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class MaybeTimer$TimerDisposable extends AtomicReference<p60> implements p60, Runnable {
    public static final long serialVersionUID = 2875964065294031672L;
    public final a60<? super Long> actual;

    public MaybeTimer$TimerDisposable(a60<? super Long> a60Var) {
        this.actual = a60Var;
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
        this.actual.onSuccess(0L);
    }

    public void setFuture(p60 p60Var) {
        DisposableHelper.replace(this, p60Var);
    }
}
