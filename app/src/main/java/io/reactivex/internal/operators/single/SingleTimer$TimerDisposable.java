package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.m60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class SingleTimer$TimerDisposable extends AtomicReference<p60> implements p60, Runnable {
    public static final long serialVersionUID = 8465401857522493082L;
    public final m60<? super Long> actual;

    public SingleTimer$TimerDisposable(m60<? super Long> m60Var) {
        this.actual = m60Var;
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
