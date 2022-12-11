package me.tvspark;

/* loaded from: classes4.dex */
public final class jx0 {
    public static final jx0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new jx0();
    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public static final ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            ix0 ix0Var = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (ix0Var != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= 8192;
                return ix0Var;
            }
            return new ix0();
        }
    }

    public static final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0 ix0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var, "segment");
        if (ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null && ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            if (ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                long j = 8192;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + j > 65536) {
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += j;
                ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ix0Var;
                return;
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
