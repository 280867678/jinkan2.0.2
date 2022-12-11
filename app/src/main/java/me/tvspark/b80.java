package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes4.dex */
public final class b80<T> implements j60<T> {
    public p60 Wwwwwwwwwwwwwwwwwwwwwww;
    public final k70<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    public b80(k70<T> k70Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = k70Var;
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, this.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.j60
    public void onNext(T t) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((k70<T>) t, this.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwwww, p60Var)) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = p60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var);
        }
    }
}
