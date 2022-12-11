package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class jc0<T, U extends Collection<? super T>> extends l60<U> implements n70<U> {
    public final Callable<U> Wwwwwwwwwwwwwwwwwwwwwww;
    public final h60<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U extends Collection<? super T>> implements j60<T>, p60 {
        public p60 Wwwwwwwwwwwwwwwwwwwwww;
        public U Wwwwwwwwwwwwwwwwwwwwwww;
        public final m60<? super U> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60<? super U> m60Var, U u) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = m60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = u;
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
            U u = this.Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onSuccess(u);
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.add(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
            }
        }
    }

    public jc0(h60<T> h60Var, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    public jc0(h60<T> h60Var, Callable<U> callable) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = callable;
    }

    @Override // me.tvspark.l60
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60<? super U> m60Var) {
        try {
            U call = this.Wwwwwwwwwwwwwwwwwwwwwww.call();
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60Var, call));
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            EmptyDisposable.error(th, m60Var);
        }
    }

    @Override // me.tvspark.n70
    public d60<U> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new ic0(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
    }
}
