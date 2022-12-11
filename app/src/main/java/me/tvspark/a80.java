package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes4.dex */
public final class a80<T> implements j60<T>, p60 {
    public p60 Wwwwwwwwwwwwwwwwwwwww;
    public final r60 Wwwwwwwwwwwwwwwwwwwwww;
    public final x60<? super p60> Wwwwwwwwwwwwwwwwwwwwwww;
    public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

    public a80(j60<? super T> j60Var, x60<? super p60> x60Var, r60 r60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = x60Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = r60Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        try {
            this.Wwwwwwwwwwwwwwwwwwwwww.run();
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
        this.Wwwwwwwwwwwwwwwwwwwww.dispose();
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return this.Wwwwwwwwwwwwwwwwwwwww.isDisposed();
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
    }

    @Override // me.tvspark.j60
    public void onNext(T t) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwww.accept(p60Var);
            if (!DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwww, p60Var)) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = p60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            p60Var.dispose();
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            EmptyDisposable.error(th, this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }
}
