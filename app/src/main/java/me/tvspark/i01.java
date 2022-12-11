package me.tvspark;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class i01 extends a01 {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final a01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i01(a01 a01Var, int i) {
        super(r0);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (a01Var != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, a01Var), i), 2);
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, 0);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = a01Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public static i01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a01 a01Var, int i) {
        return (i == Integer.MAX_VALUE && a01Var == null) ? a01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : new i01(a01Var, i);
    }

    @Override // me.tvspark.a01
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return 1;
    }

    @Override // me.tvspark.a01
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.a01
    public a01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.a01
    public boolean equals(Object obj) {
        a01 a01Var;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i01) || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != obj.hashCode()) {
            return false;
        }
        i01 i01Var = (i01) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww && (a01Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null && a01Var.equals(i01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public String toString() {
        a01 a01Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String obj = a01Var != null ? a01Var.toString() : "";
        if (obj.length() == 0) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return i == Integer.MAX_VALUE ? "$" : String.valueOf(i);
        }
        return String.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + StringUtils.SPACE + obj;
    }
}
