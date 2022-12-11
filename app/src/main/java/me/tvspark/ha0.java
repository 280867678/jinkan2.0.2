package me.tvspark;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class ha0<T> extends d60<T> {
    public final TimeUnit Wwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwww;
    public final Future<? extends T> Wwwwwwwwwwwwwwwwwwwwwwww;

    public ha0(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = future;
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwww = timeUnit;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(j60Var);
        j60Var.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                T t = this.Wwwwwwwwwwwwwwwwwwwwww != null ? this.Wwwwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww) : this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "Future returned null");
                deferredScalarDisposable.complete(t);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                if (deferredScalarDisposable.isDisposed()) {
                    return;
                }
                j60Var.onError(th);
            }
        }
    }
}
