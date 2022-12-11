package me.tvspark;

/* loaded from: classes4.dex */
public class o31 extends s31 {
    @Override // me.tvspark.n31
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        if (i2 >= 161) {
            return (((i2 - 161) * 94) + (bArr[i + 1] & 255)) - 161;
        }
        return -1;
    }
}
