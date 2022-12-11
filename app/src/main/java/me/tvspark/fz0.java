package me.tvspark;

/* loaded from: classes4.dex */
public class fz0 extends my0 {
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final iz0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public fz0(fz0 fz0Var, sy0 sy0Var) {
        super(fz0Var, sy0Var, fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fz0Var, sy0Var);
    }

    public fz0(fz0 fz0Var, sy0 sy0Var, a01 a01Var) {
        super(fz0Var, sy0Var, a01Var, fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fz0Var, sy0Var);
    }

    public fz0(fz0 fz0Var, sy0 sy0Var, iz0 iz0Var) {
        super(fz0Var, sy0Var, fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = iz0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fz0Var, sy0Var);
    }

    public fz0(sy0 sy0Var, int i, a01 a01Var) {
        super(sy0Var, i, a01Var, g01.Wwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fz0 fz0Var, sy0 sy0Var) {
        return fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww || ((sy0Var instanceof bz0) && ((bz0) sy0Var).Wwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.my0
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0 my0Var) {
        boolean z = true;
        if (this == my0Var) {
            return true;
        }
        if (!(my0Var instanceof fz0)) {
            return false;
        }
        fz0 fz0Var = (fz0) my0Var;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return false;
        }
        iz0 iz0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        iz0 iz0Var2 = fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (iz0Var != null) {
            z = iz0Var.equals(iz0Var2);
        } else if (iz0Var2 != null) {
            z = false;
        }
        if (z) {
            return super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0Var);
        }
        return false;
    }

    @Override // me.tvspark.my0
    public int hashCode() {
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(7, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww ? 1 : 0), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww), 6);
    }
}
