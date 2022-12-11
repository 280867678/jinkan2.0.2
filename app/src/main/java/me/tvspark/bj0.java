package me.tvspark;

/* loaded from: classes4.dex */
public final class bj0 extends zi0 {
    public static final bj0 Wwwwwwwwwwwwwwwwwwww = null;
    public static final bj0 Wwwwwwwwwwwwwwwwwwwww = new bj0(1, 0);

    public bj0(int i, int i2) {
        super(i, i2, 1);
    }

    public Integer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.zi0
    public boolean equals(Object obj) {
        if (obj instanceof bj0) {
            if (!isEmpty() || !((bj0) obj).isEmpty()) {
                bj0 bj0Var = (bj0) obj;
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww != bj0Var.Wwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwww != bj0Var.Wwwwwwwwwwwwwwwwwwwwwww) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // me.tvspark.zi0
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.Wwwwwwwwwwwwwwwwwwwwwwww * 31) + this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.zi0
    public boolean isEmpty() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.zi0
    public String toString() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww + ".." + this.Wwwwwwwwwwwwwwwwwwwwwww;
    }
}
