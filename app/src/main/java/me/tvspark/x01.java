package me.tvspark;

import java.util.Arrays;

/* loaded from: classes4.dex */
public class x01 {
    public static int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[0];
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x01)) {
            return false;
        }
        x01 x01Var = (x01) obj;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != x01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return false;
        }
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i++) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] != x01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i2++) {
            i = (i * 31) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
        }
        return i;
    }

    public String toString() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return Arrays.toString(i == 0 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : Arrays.copyOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i));
    }
}
