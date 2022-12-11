package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.k60;
import me.tvspark.m60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class SingleObserveOn$ObserveOnSingleObserver<T> extends AtomicReference<p60> implements m60<T>, p60, Runnable {
    public static final long serialVersionUID = 3528003840217436037L;
    public final m60<? super T> actual;
    public Throwable error;
    public final k60 scheduler;
    public T value;

    public SingleObserveOn$ObserveOnSingleObserver(m60<? super T> m60Var, k60 k60Var) {
        this.actual = m60Var;
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

    @Override // me.tvspark.m60
    public void onError(Throwable th) {
        this.error = th;
        DisposableHelper.replace(this, this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
    }

    @Override // me.tvspark.m60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.setOnce(this, p60Var)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.m60
    public void onSuccess(T t) {
        this.value = t;
        DisposableHelper.replace(this, this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th = this.error;
        if (th != null) {
            this.actual.onError(th);
        } else {
            this.actual.onSuccess((T) this.value);
        }
    }
}
