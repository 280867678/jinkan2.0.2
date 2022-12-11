package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.m60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.x60;

/* loaded from: classes4.dex */
public final class ConsumerSingleObserver<T> extends AtomicReference<p60> implements m60<T>, p60 {
    public static final long serialVersionUID = -7012088219455310787L;
    public final x60<? super Throwable> onError;
    public final x60<? super T> onSuccess;

    public ConsumerSingleObserver(x60<? super T> x60Var, x60<? super Throwable> x60Var2) {
        this.onSuccess = x60Var;
        this.onError = x60Var2;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // me.tvspark.m60
    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new CompositeException(th, th2));
        }
    }

    @Override // me.tvspark.m60
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this, p60Var);
    }

    @Override // me.tvspark.m60
    public void onSuccess(T t) {
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }
}
