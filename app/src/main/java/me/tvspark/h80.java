package me.tvspark;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes4.dex */
public final class h80<T> implements j60<T> {
    public p60 Wwwwwwwwwwwwwwwwwwwwwww;
    public final x60<? super c60<Object>> Wwwwwwwwwwwwwwwwwwwwwwww;

    public h80(x60<? super c60<Object>> x60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = x60Var;
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.accept(c60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.accept(c60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th));
        } catch (Throwable th2) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new CompositeException(th, th2));
        }
    }

    @Override // me.tvspark.j60
    public void onNext(T t) {
        if (t == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.dispose();
            th = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else {
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.accept(c60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t));
                return;
            } catch (Throwable th) {
                th = th;
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.Wwwwwwwwwwwwwwwwwwwwwww.dispose();
            }
        }
        onError(th);
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwwww, p60Var)) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = p60Var;
        }
    }
}
