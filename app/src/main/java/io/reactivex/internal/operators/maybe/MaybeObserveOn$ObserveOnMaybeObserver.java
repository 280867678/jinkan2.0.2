package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.k60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class MaybeObserveOn$ObserveOnMaybeObserver<T> extends AtomicReference<p60> implements a60<T>, p60, Runnable {
    public static final long serialVersionUID = 8571289934935992137L;
    public final a60<? super T> actual;
    public Throwable error;
    public final k60 scheduler;
    public T value;

    public MaybeObserveOn$ObserveOnMaybeObserver(a60<? super T> a60Var, k60 k60Var) {
        this.actual = a60Var;
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

    @Override // me.tvspark.a60
    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        this.error = th;
        DisposableHelper.replace(this, this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.setOnce(this, p60Var)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        this.value = t;
        DisposableHelper.replace(this, this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th = this.error;
        if (th != null) {
            this.error = null;
            this.actual.onError(th);
            return;
        }
        T t = this.value;
        if (t == null) {
            this.actual.onComplete();
            return;
        }
        this.value = null;
        this.actual.onSuccess(t);
    }
}
