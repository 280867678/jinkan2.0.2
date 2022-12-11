package me.tvspark;

/* loaded from: classes4.dex */
public final class fa0<T> extends d60<T> {
    public final T[] Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> extends v70<T> {
        public volatile boolean Wwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwww;
        public final T[] Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var, T[] tArr) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = tArr;
        }

        @Override // me.tvspark.t70
        public void clear() {
            this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.length;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwww = true;
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.t70
        public boolean isEmpty() {
            return this.Wwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwww.length;
        }

        @Override // me.tvspark.t70
        /* renamed from: poll */
        public T mo4868poll() {
            int i = this.Wwwwwwwwwwwwwwwwwwwwww;
            T[] tArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (i != tArr.length) {
                this.Wwwwwwwwwwwwwwwwwwwwww = i + 1;
                T t = tArr[i];
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "The array element is null");
                return t;
            }
            return null;
        }

        @Override // me.tvspark.p70
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                this.Wwwwwwwwwwwwwwwwwwwww = true;
                return 1;
            }
            return 0;
        }
    }

    public fa0(T[] tArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = tArr;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwwww);
        j60Var.onSubscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        T[] tArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        int length = tArr.length;
        for (int i = 0; i < length && !wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww; i++) {
            T t = tArr[i];
            if (t == null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.onError(new NullPointerException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("The ", i, "th element is null")));
                return;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww) {
            return;
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
    }
}
