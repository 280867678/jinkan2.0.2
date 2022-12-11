package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class ib0<T> extends l60<T> {
    public final T Wwwwwwwwwwwwwwwwwwwwwww;
    public final h60<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<T>, p60 {
        public T Wwwwwwwwwwwwwwwwwwwww;
        public p60 Wwwwwwwwwwwwwwwwwwwwww;
        public final T Wwwwwwwwwwwwwwwwwwwwwww;
        public final m60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60<? super T> m60Var, T t) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = m60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = t;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwwwww.dispose();
            this.Wwwwwwwwwwwwwwwwwwwwww = DisposableHelper.DISPOSED;
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwwww == DisposableHelper.DISPOSED;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwwwwww = DisposableHelper.DISPOSED;
            T t = this.Wwwwwwwwwwwwwwwwwwwww;
            if (t != null) {
                this.Wwwwwwwwwwwwwwwwwwwww = null;
            } else {
                t = this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (t == null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(new NoSuchElementException());
                    return;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onSuccess(t);
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwww = DisposableHelper.DISPOSED;
            this.Wwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.Wwwwwwwwwwwwwwwwwwwww = t;
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
            }
        }
    }

    public ib0(h60<T> h60Var, T t) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = t;
    }

    @Override // me.tvspark.l60
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60<? super T> m60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60Var, this.Wwwwwwwwwwwwwwwwwwwwwww));
    }
}
