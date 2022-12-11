package me.tvspark;

import io.reactivex.internal.disposables.SequentialDisposable;

/* loaded from: classes4.dex */
public final class cc0<T> extends x80<T, T> {
    public final h60<? extends T> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<T> {
        public boolean Wwwwwwwwwwwwwwwwwwwww = true;
        public final SequentialDisposable Wwwwwwwwwwwwwwwwwwwwww = new SequentialDisposable();
        public final h60<? extends T> Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var, h60<? extends T> h60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = h60Var;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwww.subscribe(this);
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwww = false;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwww.update(p60Var);
        }
    }

    public cc0(h60<T> h60Var, h60<? extends T> h60Var2) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = h60Var2;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww);
        j60Var.onSubscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
