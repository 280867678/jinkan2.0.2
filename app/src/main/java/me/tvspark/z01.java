package me.tvspark;

/* loaded from: classes4.dex */
public class z01 {
    public static z01[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new z01[1001];
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        new z01(-1, -2);
    }

    public z01(int i, int i2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
    }

    public static z01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (i != i2 || i < 0 || i > 1000) {
            return new z01(i, i2);
        }
        z01[] z01VarArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (z01VarArr[i] == null) {
            z01VarArr[i] = new z01(i, i);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
    }

    public z01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z01 z01Var) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Math.min(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Math.max(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z01 z01Var) {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!(i < i2 && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < i2)) {
            if (!(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return false;
            }
        }
        return true;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z01 z01Var) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1 || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof z01)) {
            return false;
        }
        z01 z01Var = (z01) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        return ((713 + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + ".." + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
