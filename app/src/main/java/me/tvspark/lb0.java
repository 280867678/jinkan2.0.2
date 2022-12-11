package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class lb0<T, R> extends x80<T, h60<? extends R>> {
    public final Callable<? extends h60<? extends R>> Wwwwwwwwwwwwwwwwwwwww;
    public final f70<? super Throwable, ? extends h60<? extends R>> Wwwwwwwwwwwwwwwwwwwwww;
    public final f70<? super T, ? extends h60<? extends R>> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R> implements j60<T>, p60 {
        public p60 Wwwwwwwwwwwwwwwwwwww;
        public final Callable<? extends h60<? extends R>> Wwwwwwwwwwwwwwwwwwwww;
        public final f70<? super Throwable, ? extends h60<? extends R>> Wwwwwwwwwwwwwwwwwwwwww;
        public final f70<? super T, ? extends h60<? extends R>> Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super h60<? extends R>> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super h60<? extends R>> j60Var, f70<? super T, ? extends h60<? extends R>> f70Var, f70<? super Throwable, ? extends h60<? extends R>> f70Var2, Callable<? extends h60<? extends R>> callable) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
            this.Wwwwwwwwwwwwwwwwwwwwww = f70Var2;
            this.Wwwwwwwwwwwwwwwwwwwww = callable;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwww.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwww.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            try {
                h60<? extends R> call = this.Wwwwwwwwwwwwwwwwwwwww.call();
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The onComplete publisher returned is null");
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(call);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            try {
                h60<? extends R> apply = this.Wwwwwwwwwwwwwwwwwwwwww.apply(th);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The onError publisher returned is null");
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(apply);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
            } catch (Throwable th2) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th2);
            }
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            try {
                h60<? extends R> apply = this.Wwwwwwwwwwwwwwwwwwwwwww.apply(t);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The onNext publisher returned is null");
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(apply);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
            }
        }
    }

    public lb0(h60<T> h60Var, f70<? super T, ? extends h60<? extends R>> f70Var, f70<? super Throwable, ? extends h60<? extends R>> f70Var2, Callable<? extends h60<? extends R>> callable) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = f70Var2;
        this.Wwwwwwwwwwwwwwwwwwwww = callable;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super h60<? extends R>> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww));
    }
}
