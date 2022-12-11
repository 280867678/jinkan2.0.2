package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.m60;
import me.tvspark.p60;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public final class SingleTakeUntil$TakeUntilMainObserver<T> extends AtomicReference<p60> implements m60<T>, p60 {
    public static final long serialVersionUID = -622603812305745221L;
    public final m60<? super T> actual;
    public final SingleTakeUntil$TakeUntilOtherSubscriber other = new SingleTakeUntil$TakeUntilOtherSubscriber(this);

    public SingleTakeUntil$TakeUntilMainObserver(m60<? super T> m60Var) {
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

    @Override // me.tvspark.m60
    public void onError(Throwable th) {
        this.other.dispose();
        p60 p60Var = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (p60Var == disposableHelper || getAndSet(disposableHelper) == DisposableHelper.DISPOSED) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        } else {
            this.actual.onError(th);
        }
    }

    @Override // me.tvspark.m60
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this, p60Var);
    }

    @Override // me.tvspark.m60
    public void onSuccess(T t) {
        this.other.dispose();
        p60 p60Var = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (p60Var == disposableHelper || getAndSet(disposableHelper) == DisposableHelper.DISPOSED) {
            return;
        }
        this.actual.onSuccess(t);
    }

    public void otherError(Throwable th) {
        p60 andSet;
        p60 p60Var = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (p60Var == disposableHelper || (andSet = getAndSet(disposableHelper)) == DisposableHelper.DISPOSED) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        if (andSet != null) {
            andSet.dispose();
        }
        this.actual.onError(th);
    }
}
