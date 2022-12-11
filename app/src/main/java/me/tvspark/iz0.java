package me.tvspark;

import java.util.Arrays;

/* loaded from: classes4.dex */
public class iz0 {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final hz0[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public iz0(hz0[] hz0VarArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = hz0VarArr;
        int i = 0;
        for (hz0 hz0Var : hz0VarArr) {
            i = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, hz0Var);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, hz0VarArr.length);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof iz0)) {
            return false;
        }
        iz0 iz0Var = (iz0) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == iz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, iz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
