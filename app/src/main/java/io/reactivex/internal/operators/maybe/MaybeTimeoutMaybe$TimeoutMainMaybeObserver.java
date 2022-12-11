package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.b60;
import me.tvspark.p60;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public final class MaybeTimeoutMaybe$TimeoutMainMaybeObserver<T, U> extends AtomicReference<p60> implements a60<T>, p60 {
    public static final long serialVersionUID = -5955289211445418871L;
    public final a60<? super T> actual;
    public final b60<? extends T> fallback;
    public final MaybeTimeoutMaybe$TimeoutOtherMaybeObserver<T, U> other = new MaybeTimeoutMaybe$TimeoutOtherMaybeObserver<>(this);
    public final MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver<T> otherObserver;

    public MaybeTimeoutMaybe$TimeoutMainMaybeObserver(a60<? super T> a60Var, b60<? extends T> b60Var) {
        this.actual = a60Var;
        this.fallback = b60Var;
        this.otherObserver = b60Var != null ? new MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver<>(a60Var) : null;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.other);
        MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver<T> maybeTimeoutMaybe$TimeoutFallbackMaybeObserver = this.otherObserver;
        if (maybeTimeoutMaybe$TimeoutFallbackMaybeObserver != null) {
            DisposableHelper.dispose(maybeTimeoutMaybe$TimeoutFallbackMaybeObserver);
        }
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // me.tvspark.a60
    public void onComplete() {
        DisposableHelper.dispose(this.other);
        if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
            this.actual.onComplete();
        }
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        DisposableHelper.dispose(this.other);
        if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
            this.actual.onError(th);
        } else {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this, p60Var);
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        DisposableHelper.dispose(this.other);
        if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
            this.actual.onSuccess(t);
        }
    }

    public void otherComplete() {
        if (DisposableHelper.dispose(this)) {
            b60<? extends T> b60Var = this.fallback;
            if (b60Var == null) {
                this.actual.onError(new TimeoutException());
            } else {
                b60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.otherObserver);
            }
        }
    }

    public void otherError(Throwable th) {
        if (DisposableHelper.dispose(this)) {
            this.actual.onError(th);
        } else {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }
}
