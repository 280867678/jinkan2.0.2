package me.tvspark;

/* loaded from: classes4.dex */
public final class oa0<T> extends t50 implements n70<T> {
    public final h60<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<T>, p60 {
        public p60 Wwwwwwwwwwwwwwwwwwwwwww;
        public final u50 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u50 u50Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = u50Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwwwwww.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = p60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
        }
    }

    public oa0(h60<T> h60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var;
    }

    @Override // me.tvspark.t50
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u50 u50Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u50Var));
    }

    @Override // me.tvspark.n70
    public d60<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new na0(this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }
}
