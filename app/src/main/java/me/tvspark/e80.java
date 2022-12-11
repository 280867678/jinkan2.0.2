package me.tvspark;

/* JADX WARN: Incorrect class signature, class is equals to this class: <T:Ljava/lang/Object;U:Ljava/lang/Object;V:Ljava/lang/Object;>Lme/tvspark/e80;Lme/tvspark/j60<TT;>;Lme/tvspark/e80<TU;TV;>; */
/* loaded from: classes4.dex */
public abstract class e80<T, U, V> extends f80 implements j60<T> {
    public Throwable Wwwwwwwwwwwwwwwwwww;
    public volatile boolean Wwwwwwwwwwwwwwwwwwww;
    public volatile boolean Wwwwwwwwwwwwwwwwwwwww;
    public final t70<U> Wwwwwwwwwwwwwwwwwwwwww;
    public final j60<? super V> Wwwwwwwwwwwwwwwwwwwwwww;

    public e80(j60<? super V> j60Var, t70<U> t70Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = j60Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = t70Var;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(U u, boolean z, p60 p60Var) {
        j60<? super V> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
        t70<U> t70Var = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.get() != 0 || !this.Wwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(0, 1)) {
            t70Var.offer(u);
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return;
            }
        } else if (t70Var.isEmpty()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, u);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1) == 0) {
                return;
            }
        } else {
            t70Var.offer(u);
        }
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t70Var, j60Var, z, p60Var, this);
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.get() == 0 && this.Wwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(0, 1);
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.addAndGet(i);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(U u, boolean z, p60 p60Var) {
        j60<? super V> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
        t70<U> t70Var = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.get() != 0 || !this.Wwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(0, 1)) {
            t70Var.offer(u);
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return;
            }
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, u);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1) == 0) {
                return;
            }
        }
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t70Var, j60Var, z, p60Var, this);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super V> j60Var, U u) {
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getAndIncrement() == 0;
    }
}
