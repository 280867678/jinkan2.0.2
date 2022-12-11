package me.tvspark;

import me.tvspark.l70;

/* loaded from: classes4.dex */
public final class v90<T, K> extends x80<T, T> {
    public final u60<? super K, ? super K> Wwwwwwwwwwwwwwwwwwwwww;
    public final f70<? super T, K> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, K> extends u70<T, T> {
        public boolean Wwwwwwwwwwwwwwww;
        public K Wwwwwwwwwwwwwwwww;
        public final u60<? super K, ? super K> Wwwwwwwwwwwwwwwwww;
        public final f70<? super T, K> Wwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var, f70<? super T, K> f70Var, u60<? super K, ? super K> u60Var) {
            super(j60Var);
            this.Wwwwwwwwwwwwwwwwwww = f70Var;
            this.Wwwwwwwwwwwwwwwwww = u60Var;
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            if (this.Wwwwwwwwwwwwwwwwwwww == 0) {
                try {
                    K apply = this.Wwwwwwwwwwwwwwwwwww.apply(t);
                    if (this.Wwwwwwwwwwwwwwww) {
                        u60<? super K, ? super K> u60Var = this.Wwwwwwwwwwwwwwwwww;
                        K k = this.Wwwwwwwwwwwwwwwww;
                        if (((l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) u60Var) != null) {
                            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, apply);
                            this.Wwwwwwwwwwwwwwwww = apply;
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                return;
                            }
                        } else {
                            throw null;
                        }
                    } else {
                        this.Wwwwwwwwwwwwwwww = true;
                        this.Wwwwwwwwwwwwwwwww = apply;
                    }
                } catch (Throwable th) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    return;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
        }

        @Override // me.tvspark.t70
        /* renamed from: poll */
        public T mo4868poll() throws Exception {
            T mo4868poll;
            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            do {
                mo4868poll = this.Wwwwwwwwwwwwwwwwwwwwww.mo4868poll();
                if (mo4868poll == null) {
                    return null;
                }
                K apply = this.Wwwwwwwwwwwwwwwwwww.apply(mo4868poll);
                if (!this.Wwwwwwwwwwwwwwww) {
                    this.Wwwwwwwwwwwwwwww = true;
                    this.Wwwwwwwwwwwwwwwww = apply;
                    return mo4868poll;
                }
                u60<? super K, ? super K> u60Var = this.Wwwwwwwwwwwwwwwwww;
                K k = this.Wwwwwwwwwwwwwwwww;
                if (((l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) u60Var) != null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, apply);
                    this.Wwwwwwwwwwwwwwwww = apply;
                } else {
                    throw null;
                }
            } while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return mo4868poll;
        }

        @Override // me.tvspark.p70
        public int requestFusion(int i) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
    }

    public v90(h60<T> h60Var, f70<? super T, K> f70Var, u60<? super K, ? super K> u60Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = u60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww));
    }
}
