package me.tvspark;

import org.mozilla.javascript.Token;

/* loaded from: classes4.dex */
public class l31 extends k31 {
    @Override // me.tvspark.k31
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i) {
        int i2;
        if ((bArr[i] & 255) != 130 || (i2 = bArr[i + 1] & 255) < 159 || i2 > 241) {
            return -1;
        }
        return i2 - Token.LETEXPR;
    }
}
