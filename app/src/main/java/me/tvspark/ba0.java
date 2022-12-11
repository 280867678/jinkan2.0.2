package me.tvspark;

import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes4.dex */
public final class ba0 extends d60<Object> implements r70<Object> {
    public static final d60<Object> Wwwwwwwwwwwwwwwwwwwwwwww = new ba0();

    @Override // me.tvspark.r70, java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super Object> j60Var) {
        EmptyDisposable.complete(j60Var);
    }
}
