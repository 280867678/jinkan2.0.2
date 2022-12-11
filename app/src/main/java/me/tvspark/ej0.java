package me.tvspark;

/* loaded from: classes4.dex */
public final class ej0 extends cj0 {
    static {
        new ej0(1L, 0L);
    }

    public ej0(long j, long j2) {
        super(j, j2, 1L);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ej0) {
            if (!isEmpty() || !((ej0) obj).isEmpty()) {
                ej0 ej0Var = (ej0) obj;
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww != ej0Var.Wwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwww != ej0Var.Wwwwwwwwwwwwwwwwwwwwwww) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        long j2 = 31 * (j ^ (j >>> 32));
        long j3 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        return (int) (j2 + (j3 ^ (j3 >>> 32)));
    }

    public boolean isEmpty() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww + ".." + this.Wwwwwwwwwwwwwwwwwwwwwww;
    }
}
