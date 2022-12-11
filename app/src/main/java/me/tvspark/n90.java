package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes4.dex */
public final class n90<T> extends l60<Long> implements n70<Long> {
    public final h60<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements j60<Object>, p60 {
        public long Wwwwwwwwwwwwwwwwwwwwww;
        public p60 Wwwwwwwwwwwwwwwwwwwwwww;
        public final m60<? super Long> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60<? super Long> m60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = m60Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwwwwww.dispose();
            this.Wwwwwwwwwwwwwwwwwwwwwww = DisposableHelper.DISPOSED;
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwwwwwww = DisposableHelper.DISPOSED;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onSuccess(Long.valueOf(this.Wwwwwwwwwwwwwwwwwwwwww));
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = DisposableHelper.DISPOSED;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(Object obj) {
            this.Wwwwwwwwwwwwwwwwwwwwww++;
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
            }
        }
    }

    public n90(h60<T> h60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var;
    }

    @Override // me.tvspark.l60
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60<? super Long> m60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60Var));
    }

    @Override // me.tvspark.n70
    public d60<Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new m90(this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }
}
