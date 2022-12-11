package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class k90<T, U> extends x80<T, U> {
    public final s60<? super U, ? super T> Wwwwwwwwwwwwwwwwwwwwww;
    public final Callable<? extends U> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U> implements j60<T>, p60 {
        public boolean Wwwwwwwwwwwwwwwwwwww;
        public p60 Wwwwwwwwwwwwwwwwwwwww;
        public final U Wwwwwwwwwwwwwwwwwwwwww;
        public final s60<? super U, ? super T> Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super U> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super U> j60Var, U u, s60<? super U, ? super T> s60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
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
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext((U) this.Wwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
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

    public k90(h60<T> h60Var, Callable<? extends U> callable, s60<? super U, ? super T> s60Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = callable;
        this.Wwwwwwwwwwwwwwwwwwwwww = s60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super U> j60Var) {
        try {
            U call = this.Wwwwwwwwwwwwwwwwwwwwwww.call();
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The initialSupplier returned a null value");
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, call, this.Wwwwwwwwwwwwwwwwwwwwww));
        } catch (Throwable th) {
            EmptyDisposable.error(th, j60Var);
        }
    }
}
