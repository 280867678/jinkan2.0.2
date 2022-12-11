package me.tvspark;

/* loaded from: classes4.dex */
public class fj0 {
    public static final bj0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            bj0 bj0Var = bj0.Wwwwwwwwwwwwwwwwwwww;
            return bj0.Wwwwwwwwwwwwwwwwwwwww;
        }
        return new bj0(i, i2 - 1);
    }

    public static final zi0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        return new zi0(i, i2, -1);
    }

    public static final zi0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zi0 zi0Var, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zi0Var, "$this$step");
        boolean z = i > 0;
        Integer valueOf = Integer.valueOf(i);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(valueOf, "step");
        if (z) {
            int i2 = zi0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = zi0Var.Wwwwwwwwwwwwwwwwwwwwwww;
            if (zi0Var.Wwwwwwwwwwwwwwwwwwwwww <= 0) {
                i = -i;
            }
            return new zi0(i2, i3, i);
        }
        throw new IllegalArgumentException("Step must be positive, was: " + valueOf + '.');
    }
}
