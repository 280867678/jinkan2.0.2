package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class ic0<T, U extends Collection<? super T>> extends x80<T, U> {
    public final Callable<U> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U extends Collection<? super T>> implements j60<T>, p60 {
        public p60 Wwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super U> Wwwwwwwwwwwwwwwwwwwwwww;
        public U Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super U> j60Var, U u) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = u;
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
            U u = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwww.onNext(u);
            this.Wwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.add(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
            }
        }
    }

    public ic0(h60<T> h60Var, int i) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    public ic0(h60<T> h60Var, Callable<U> callable) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = callable;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super U> j60Var) {
        try {
            U call = this.Wwwwwwwwwwwwwwwwwwwwwww.call();
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, call));
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            EmptyDisposable.error(th, j60Var);
        }
    }
}
