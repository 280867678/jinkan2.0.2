package me.tvspark;

import java.util.Arrays;

/* loaded from: classes4.dex */
public class r01 {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public iz0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public r01[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ny0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public g01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g01 g01Var, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = g01Var;
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ")");
        }
    }

    public r01() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ny0(true);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r01) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(((r01) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    public int hashCode() {
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(7, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode()), 1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        sb.append(":");
        sb.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            sb.append("=>");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr != null) {
                sb.append(Arrays.toString(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr));
            } else {
                sb.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        return sb.toString();
    }

    public r01(ny0 ny0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ny0(true);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ny0Var;
    }
}
