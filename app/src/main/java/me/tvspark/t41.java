package me.tvspark;

/* loaded from: classes4.dex */
public class t41 {
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public t41(int i, int i2, int i3, int i4, int[] iArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return i | (i2 << 4) | (((i4 << 4) | i3) << 8) | (((((i8 << 4) | i7) << 8) | ((i6 << 4) | i5)) << 16);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i >> this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] >> ((i & this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) << this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) & this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
