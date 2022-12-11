package me.tvspark;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class p90<T> extends d60<T> {
    public final Callable<? extends h60<? extends T>> Wwwwwwwwwwwwwwwwwwwwwwww;

    public p90(Callable<? extends h60<? extends T>> callable) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = callable;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        try {
            h60<? extends T> call = this.Wwwwwwwwwwwwwwwwwwwwwwww.call();
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "null publisher supplied");
            call.subscribe(j60Var);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            EmptyDisposable.error(th, j60Var);
        }
    }
}
