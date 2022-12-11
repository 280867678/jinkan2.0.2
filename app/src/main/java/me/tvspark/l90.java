package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class l90<T, U> extends l60<U> implements n70<U> {
    public final s60<? super U, ? super T> Wwwwwwwwwwwwwwwwwwwwww;
    public final Callable<? extends U> Wwwwwwwwwwwwwwwwwwwwwww;
    public final h60<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U> implements j60<T>, p60 {
        public boolean Wwwwwwwwwwwwwwwwwwww;
        public p60 Wwwwwwwwwwwwwwwwwwwww;
        public final U Wwwwwwwwwwwwwwwwwwwwww;
        public final s60<? super U, ? super T> Wwwwwwwwwwwwwwwwwwwwwww;
        public final m60<? super U> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60<? super U> m60Var, U u, s60<? super U, ? super T> s60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = m60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = s60Var;
            this.Wwwwwwwwwwwwwwwwwwwwww = u;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwwww.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwww.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.Wwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onSuccess((U) this.Wwwwwwwwwwwwwwwwwwwwww);
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
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((U) this.Wwwwwwwwwwwwwwwwwwwwww, t);
            } catch (Throwable th) {
                this.Wwwwwwwwwwwwwwwwwwwww.dispose();
                onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
            }
        }
    }

    public l90(h60<T> h60Var, Callable<? extends U> callable, s60<? super U, ? super T> s60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = callable;
        this.Wwwwwwwwwwwwwwwwwwwwww = s60Var;
    }

    @Override // me.tvspark.l60
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60<? super U> m60Var) {
        try {
            U call = this.Wwwwwwwwwwwwwwwwwwwwwww.call();
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The initialSupplier returned a null value");
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60Var, call, this.Wwwwwwwwwwwwwwwwwwwwww));
        } catch (Throwable th) {
            EmptyDisposable.error(th, m60Var);
        }
    }

    @Override // me.tvspark.n70
    public d60<U> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new k90(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww);
    }
}
