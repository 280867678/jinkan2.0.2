package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public abstract class kd0<T> implements j60<T>, p60 {
    public final AtomicReference<p60> Wwwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();

    @Override // me.tvspark.p60
    public final void dispose() {
        DisposableHelper.dispose(this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.p60
    public final boolean isDisposed() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.get() == DisposableHelper.DISPOSED;
    }

    @Override // me.tvspark.j60
    public final void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this.Wwwwwwwwwwwwwwwwwwwwwwww, p60Var);
    }
}
