package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.k60;
import me.tvspark.p60;
import me.tvspark.u50;

/* loaded from: classes4.dex */
public final class CompletableObserveOn$ObserveOnCompletableObserver extends AtomicReference<p60> implements u50, p60, Runnable {
    public static final long serialVersionUID = 8571289934935992137L;
    public final u50 actual;
    public Throwable error;
    public final k60 scheduler;

    public CompletableObserveOn$ObserveOnCompletableObserver(u50 u50Var, k60 k60Var) {
        this.actual = u50Var;
        this.scheduler = k60Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // me.tvspark.u50
    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
    }

    @Override // me.tvspark.u50
    public void onError(Throwable th) {
        this.error = th;
        DisposableHelper.replace(this, this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
    }

    @Override // me.tvspark.u50
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.setOnce(this, p60Var)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th = this.error;
        if (th == null) {
            this.actual.onComplete();
            return;
        }
        this.error = null;
        this.actual.onError(th);
    }
}
