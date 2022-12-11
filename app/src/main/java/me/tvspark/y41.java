package me.tvspark;

/* loaded from: classes4.dex */
public class y41 {
    public y41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public y41(String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = 0;
        for (y41 y41Var = this; y41Var != null; y41Var = y41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            i++;
        }
        return i;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51 c51Var, byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        for (y41 y41Var = this; y41Var != null; y41Var = y41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(y41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            i4 += y41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length + 6;
        }
        return i4;
    }

    public y41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a51 a51Var, int i, int i2) {
        y41 y41Var = new y41(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        byte[] bArr = new byte[i2];
        y41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        System.arraycopy(a51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, bArr, 0, i2);
        return y41Var;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51 c51Var, byte[] bArr, int i, int i2, int i3, z41 z41Var) {
        for (y41 y41Var = this; y41Var != null; y41Var = y41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            byte[] bArr2 = y41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int length = bArr2.length;
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(y41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(length);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, 0, length);
        }
    }
}
