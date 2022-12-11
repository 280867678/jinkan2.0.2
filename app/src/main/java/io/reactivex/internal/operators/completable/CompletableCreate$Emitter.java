package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.u50;
import me.tvspark.w60;

/* loaded from: classes4.dex */
public final class CompletableCreate$Emitter extends AtomicReference<p60> implements Object {
    public static final long serialVersionUID = -2467358622224974244L;
    public final u50 actual;

    public CompletableCreate$Emitter(u50 u50Var) {
        this.actual = u50Var;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public void onComplete() {
        p60 andSet;
        p60 p60Var = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (p60Var == disposableHelper || (andSet = getAndSet(disposableHelper)) == DisposableHelper.DISPOSED) {
            return;
        }
        try {
            this.actual.onComplete();
        } finally {
            if (andSet != null) {
                andSet.dispose();
            }
        }
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

    public void setCancellable(w60 w60Var) {
        setDisposable(new CancellableDisposable(w60Var));
    }

    public void setDisposable(p60 p60Var) {
        DisposableHelper.set(this, p60Var);
    }
}
