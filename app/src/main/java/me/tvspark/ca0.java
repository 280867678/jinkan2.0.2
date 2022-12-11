package me.tvspark;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class ca0<T> extends d60<T> {
    public final Callable<? extends Throwable> Wwwwwwwwwwwwwwwwwwwwwwww;

    public ca0(Callable<? extends Throwable> callable) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = callable;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        try {
            Throwable call = this.Wwwwwwwwwwwwwwwwwwwwwwww.call();
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
            th = call;
        } catch (Throwable th) {
            th = th;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
        EmptyDisposable.error(th, j60Var);
    }
}
