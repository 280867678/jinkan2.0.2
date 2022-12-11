package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes4.dex */
public final class hb0<T> extends z50<T> {
    public final h60<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<T>, p60 {
        public T Wwwwwwwwwwwwwwwwwwwwww;
        public p60 Wwwwwwwwwwwwwwwwwwwwwww;
        public final a60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a60<? super T> a60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = a60Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwwwwww.dispose();
            this.Wwwwwwwwwwwwwwwwwwwwwww = DisposableHelper.DISPOSED;
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww == DisposableHelper.DISPOSED;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwwwwwww = DisposableHelper.DISPOSED;
            T t = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (t == null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onSuccess(t);
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = DisposableHelper.DISPOSED;
            this.Wwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.Wwwwwwwwwwwwwwwwwwwwww = t;
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
            }
        }
    }

    public hb0(h60<T> h60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var;
    }

    @Override // me.tvspark.z50
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a60<? super T> a60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a60Var));
    }
}
