package me.tvspark;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class ga0<T> extends d60<T> implements Callable<T> {
    public final Callable<? extends T> Wwwwwwwwwwwwwwwwwwwwwwww;

    public ga0(Callable<? extends T> callable) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.call();
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(j60Var);
        j60Var.onSubscribe(deferredScalarDisposable);
        if (deferredScalarDisposable.isDisposed()) {
            return;
        }
        try {
            T call = this.Wwwwwwwwwwwwwwwwwwwwwwww.call();
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) call, "Callable returned null");
            deferredScalarDisposable.complete(call);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            if (!deferredScalarDisposable.isDisposed()) {
                j60Var.onError(th);
            } else {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            }
        }
    }
}
