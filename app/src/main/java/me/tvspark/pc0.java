package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class pc0<R> implements a60<R> {
    public final a60<? super R> Wwwwwwwwwwwwwwwwwwwwwww;
    public final AtomicReference<p60> Wwwwwwwwwwwwwwwwwwwwwwww;

    public pc0(AtomicReference<p60> atomicReference, a60<? super R> a60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = atomicReference;
        this.Wwwwwwwwwwwwwwwwwwwwwww = a60Var;
    }

    @Override // me.tvspark.a60
    public void onComplete() {
        this.Wwwwwwwwwwwwwwwwwwwwwww.onComplete();
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.replace(this.Wwwwwwwwwwwwwwwwwwwwwwww, p60Var);
    }

    @Override // me.tvspark.a60
    public void onSuccess(R r) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.onSuccess(r);
    }
}
