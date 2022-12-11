package me.tvspark;

import java.util.Arrays;
import okhttp3.HttpUrl;
import org.apache.http.message.TokenParser;

/* loaded from: classes4.dex */
public class vy0 extends a01 {
    public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final a01[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public vy0(a01[] a01VarArr, int[] iArr) {
        super(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r2, a01VarArr.length * 2));
        int i = 1;
        for (a01 a01Var : a01VarArr) {
            i = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, a01Var);
        }
        for (int i2 : iArr) {
            i = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = a01VarArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
    }

    @Override // me.tvspark.a01
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
    }

    @Override // me.tvspark.a01
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
    }

    @Override // me.tvspark.a01
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0] == Integer.MAX_VALUE;
    }

    @Override // me.tvspark.a01
    public a01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
    }

    @Override // me.tvspark.a01
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vy0) || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != obj.hashCode()) {
            return false;
        }
        vy0 vy0Var = (vy0) obj;
        return Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, vy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, vy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public String toString() {
        String str;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[");
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length; i++) {
            if (i > 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
            }
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (iArr[i] == Integer.MAX_VALUE) {
                str = "$";
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(iArr[i]);
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] != null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(TokenParser.f4579SP);
                    str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i].toString();
                } else {
                    str = "null";
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
