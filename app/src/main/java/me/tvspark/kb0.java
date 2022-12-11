package me.tvspark;

/* loaded from: classes4.dex */
public final class kb0<T, U> extends x80<T, U> {
    public final f70<? super T, ? extends U> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U> extends u70<T, U> {
        public final f70<? super T, ? extends U> Wwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super U> j60Var, f70<? super T, ? extends U> f70Var) {
            super(j60Var);
            this.Wwwwwwwwwwwwwwwwwww = f70Var;
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            if (this.Wwwwwwwwwwwwwwwwwwww != 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(null);
                return;
            }
            try {
                U apply = this.Wwwwwwwwwwwwwwwwwww.apply(t);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper function returned a null value.");
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(apply);
            } catch (Throwable th) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            }
        }

        @Override // me.tvspark.t70
        /* renamed from: poll */
        public U mo4868poll() throws Exception {
            T mo4868poll = this.Wwwwwwwwwwwwwwwwwwwwww.mo4868poll();
            if (mo4868poll != null) {
                U apply = this.Wwwwwwwwwwwwwwwwwww.apply(mo4868poll);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper function returned a null value.");
                return apply;
            }
            return null;
        }

        @Override // me.tvspark.p70
        public int requestFusion(int i) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
    }

    public kb0(h60<T> h60Var, f70<? super T, ? extends U> f70Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super U> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww));
    }
}
