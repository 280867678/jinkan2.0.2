package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.m60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.w60;

/* loaded from: classes4.dex */
public final class SingleCreate$Emitter<T> extends AtomicReference<p60> implements Object<T> {
    public static final long serialVersionUID = -2467358622224974244L;
    public final m60<? super T> actual;

    public SingleCreate$Emitter(m60<? super T> m60Var) {
        this.actual = m60Var;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public void onError(Throwable th) {
        p60 andSet;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        p60 p60Var = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (p60Var == disposableHelper || (andSet = getAndSet(disposableHelper)) == DisposableHelper.DISPOSED) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        try {
            this.actual.onError(th);
        } finally {
            if (andSet != null) {
                andSet.dispose();
            }
        }
    }

    public void onSuccess(T t) {
        p60 andSet;
        p60 p60Var = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (p60Var == disposableHelper || (andSet = getAndSet(disposableHelper)) == DisposableHelper.DISPOSED) {
            return;
        }
        try {
            if (t == null) {
                this.actual.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.actual.onSuccess(t);
            }
            if (andSet == null) {
                return;
            }
            andSet.dispose();
        } catch (Throwable th) {
            if (andSet != null) {
                andSet.dispose();
            }
            throw th;
        }
    }

    public void setCancellable(w60 w60Var) {
        setDisposable(new CancellableDisposable(w60Var));
    }

    public void setDisposable(p60 p60Var) {
        DisposableHelper.set(this, p60Var);
    }
}
