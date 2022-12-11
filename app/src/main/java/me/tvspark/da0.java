package me.tvspark;

/* loaded from: classes4.dex */
public final class da0<T> extends x80<T, T> {
    public final g70<? super T> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> extends u70<T, T> {
        public final g70<? super T> Wwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var, g70<? super T> g70Var) {
            super(j60Var);
            this.Wwwwwwwwwwwwwwwwwww = g70Var;
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.Wwwwwwwwwwwwwwwwwwww != 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(null);
                return;
            }
            try {
                if (!this.Wwwwwwwwwwwwwwwwwww.test(t)) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
            } catch (Throwable th) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            }
        }

        @Override // me.tvspark.t70
        /* renamed from: poll */
        public T mo4868poll() throws Exception {
            T mo4868poll;
            do {
                mo4868poll = this.Wwwwwwwwwwwwwwwwwwwwww.mo4868poll();
                if (mo4868poll == null) {
                    break;
                }
            } while (!this.Wwwwwwwwwwwwwwwwwww.test(mo4868poll));
            return mo4868poll;
        }

        @Override // me.tvspark.p70
        public int requestFusion(int i) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
    }

    public da0(h60<T> h60Var, g70<? super T> g70Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = g70Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww));
    }
}
