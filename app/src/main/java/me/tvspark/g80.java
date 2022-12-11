package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class g80<T> implements m60<T> {
    public final m60<? super T> Wwwwwwwwwwwwwwwwwwwwwww;
    public final AtomicReference<p60> Wwwwwwwwwwwwwwwwwwwwwwww;

    public g80(AtomicReference<p60> atomicReference, m60<? super T> m60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = atomicReference;
        this.Wwwwwwwwwwwwwwwwwwwwwww = m60Var;
    }

    @Override // me.tvspark.m60
    public void onError(Throwable th) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
    }

    @Override // me.tvspark.m60
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.replace(this.Wwwwwwwwwwwwwwwwwwwwwwww, p60Var);
    }

    @Override // me.tvspark.m60
    public void onSuccess(T t) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.onSuccess(t);
    }
}
