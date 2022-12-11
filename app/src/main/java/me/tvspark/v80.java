package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class v80<R> implements m60<R> {
    public final m60<? super R> Wwwwwwwwwwwwwwwwwwwwwww;
    public final AtomicReference<p60> Wwwwwwwwwwwwwwwwwwwwwwww;

    public v80(AtomicReference<p60> atomicReference, m60<? super R> m60Var) {
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
    public void onSuccess(R r) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.onSuccess(r);
    }
}
