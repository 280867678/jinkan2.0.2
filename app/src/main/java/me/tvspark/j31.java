package me.tvspark;

/* loaded from: classes4.dex */
public class j31 extends k31 {
    @Override // me.tvspark.k31
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i) {
        int i2;
        if ((bArr[i] & 255) != 164 || (i2 = bArr[i + 1] & 255) < 161 || i2 > 243) {
            return -1;
        }
        return i2 - 161;
    }
}
