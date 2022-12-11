package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.u50;
import me.tvspark.v50;

/* loaded from: classes4.dex */
public final class CompletableSubscribeOn$SubscribeOnObserver extends AtomicReference<p60> implements u50, p60, Runnable {
    public static final long serialVersionUID = 7000911171163930287L;
    public final u50 actual;
    public final v50 source;
    public final SequentialDisposable task = new SequentialDisposable();

    public CompletableSubscribeOn$SubscribeOnObserver(u50 u50Var, v50 v50Var) {
        this.actual = u50Var;
        this.source = v50Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
        this.task.dispose();
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // me.tvspark.u50
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // me.tvspark.u50
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // me.tvspark.u50
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this, p60Var);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.source.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }
}
