package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class vb0<T, R> extends x80<T, R> {
    public final Callable<R> Wwwwwwwwwwwwwwwwwwwwww;
    public final t60<R, ? super T, R> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R> implements j60<T>, p60 {
        public boolean Wwwwwwwwwwwwwwwwwwww;
        public p60 Wwwwwwwwwwwwwwwwwwwww;
        public R Wwwwwwwwwwwwwwwwwwwwww;
        public final t60<R, ? super T, R> Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super R> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super R> j60Var, t60<R, ? super T, R> t60Var, R r) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = t60Var;
            this.Wwwwwwwwwwwwwwwwwwwwww = r;
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
                R Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, t);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "The accumulator returned a null value");
                this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.Wwwwwwwwwwwwwwwwwwwww.dispose();
                onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext((R) this.Wwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    public vb0(h60<T> h60Var, Callable<R> callable, t60<R, ? super T, R> t60Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = t60Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = callable;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super R> j60Var) {
        try {
            R call = this.Wwwwwwwwwwwwwwwwwwwwww.call();
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The seed supplied is null");
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, call));
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            EmptyDisposable.error(th, j60Var);
        }
    }
}
