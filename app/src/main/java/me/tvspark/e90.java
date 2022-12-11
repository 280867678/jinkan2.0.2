package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes4.dex */
public final class e90<T> extends x80<T, Boolean> {
    public final g70<? super T> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<T>, p60 {
        public boolean Wwwwwwwwwwwwwwwwwwwww;
        public p60 Wwwwwwwwwwwwwwwwwwwwww;
        public final g70<? super T> Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super Boolean> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super Boolean> j60Var, g70<? super T> g70Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = g70Var;
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
            if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(false);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            try {
                if (!this.Wwwwwwwwwwwwwwwwwwwwwww.test(t)) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwww.dispose();
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(true);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
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

    public e90(h60<T> h60Var, g70<? super T> g70Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = g70Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super Boolean> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww));
    }
}
