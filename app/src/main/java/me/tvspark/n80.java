package me.tvspark;

/* loaded from: classes4.dex */
public final class n80<T> extends x50<T> {
    public final d60<T> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<T>, t51 {
        public p60 Wwwwwwwwwwwwwwwwwwwwwww;
        public final s51<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51<? super T> s51Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = s51Var;
        }

        @Override // me.tvspark.t51
        public void cancel() {
            this.Wwwwwwwwwwwwwwwwwwwwwww.dispose();
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
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = p60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
        }

        @Override // me.tvspark.t51
        public void request(long j) {
        }
    }

    public n80(d60<T> d60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = d60Var;
    }

    @Override // me.tvspark.x50
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51<? super T> s51Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51Var));
    }
}
