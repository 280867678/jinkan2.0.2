package me.tvspark;

/* renamed from: me.tvspark.db */
/* loaded from: classes4.dex */
public final class C2031db {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2337ll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2337ll(0);
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el();

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        int i = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, 9);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += 9;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        if ((bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
            return (((bArr[0] & 56) >> 3) << 30) | ((bArr[0] & 3) << 28) | ((bArr[1] & 255) << 20) | (((bArr[2] & 248) >> 3) << 15) | ((bArr[2] & 3) << 13) | ((bArr[3] & 255) << 5) | ((bArr[4] & 248) >> 3);
        }
        return -9223372036854775807L;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return 0;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
