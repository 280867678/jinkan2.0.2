package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class yb0<T> extends l60<T> {
    public final T Wwwwwwwwwwwwwwwwwwwwwww;
    public final h60<? extends T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<T>, p60 {
        public boolean Wwwwwwwwwwwwwwwwwwww;
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
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwwww.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.Wwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwww = true;
            T t = this.Wwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwww = null;
            if (t == null) {
                t = this.Wwwwwwwwwwwwwwwwwwwwwww;
            }
            if (t != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSuccess(t);
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(new NoSuchElementException());
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.Wwwwwwwwwwwwwwwwwwww) {
                return;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwwwwwwww = t;
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwww.dispose();
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
            }
        }
    }

    public yb0(h60<? extends T> h60Var, T t) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = t;
    }

    @Override // me.tvspark.l60
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60<? super T> m60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60Var, this.Wwwwwwwwwwwwwwwwwwwwwww));
    }
}
