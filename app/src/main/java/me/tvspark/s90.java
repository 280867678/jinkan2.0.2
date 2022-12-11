package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes4.dex */
public final class s90<T> extends x80<c60<T>, T> {

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<c60<T>>, p60 {
        public p60 Wwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
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
            if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(Object obj) {
            c60 c60Var = (c60) obj;
            if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                if (!c60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return;
                }
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            } else if (c60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                this.Wwwwwwwwwwwwwwwwwwwwww.dispose();
                onError(c60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            } else {
                if (!(c60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null)) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext((Object) c60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwww.dispose();
                onComplete();
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

    public s90(h60<c60<T>> h60Var) {
        super(h60Var);
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var));
    }
}
