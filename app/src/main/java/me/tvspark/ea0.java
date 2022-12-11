package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class ea0<T, R> extends x80<T, R> {
    public final f70<? super T, ? extends Iterable<? extends R>> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R> implements j60<T>, p60 {
        public p60 Wwwwwwwwwwwwwwwwwwwwww;
        public final f70<? super T, ? extends Iterable<? extends R>> Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super R> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super R> j60Var, f70<? super T, ? extends Iterable<? extends R>> f70Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwwwww.dispose();
            this.Wwwwwwwwwwwwwwwwwwwwww = DisposableHelper.DISPOSED;
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwwww.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            p60 p60Var = this.Wwwwwwwwwwwwwwwwwwwwww;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (p60Var == disposableHelper) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = disposableHelper;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            p60 p60Var = this.Wwwwwwwwwwwwwwwwwwwwww;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (p60Var == disposableHelper) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = disposableHelper;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.Wwwwwwwwwwwwwwwwwwwwww == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                Iterator<? extends R> it = this.Wwwwwwwwwwwwwwwwwwwwwww.apply(t).iterator();
                j60<? super R> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                while (it.hasNext()) {
                    Object obj = (R) it.next();
                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "The iterator returned a null value");
                    j60Var.onNext(obj);
                }
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.Wwwwwwwwwwwwwwwwwwwwww.dispose();
                onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
            }
        }
    }

    public ea0(h60<T> h60Var, f70<? super T, ? extends Iterable<? extends R>> f70Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super R> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww));
    }
}
