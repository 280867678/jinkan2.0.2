package com.tencent.smtt.utils;

/* loaded from: classes4.dex */
public class ByteUtils {
    public static void Word2Byte(byte[] bArr, int i, short s) {
        bArr[i] = (byte) (s >> 8);
        bArr[i + 1] = (byte) s;
    }

    /* renamed from: a */
    public static String m2212a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & 255) < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Long.toString(bArr[i] & 255, 16));
        }
        return stringBuffer.toString();
    }

    public static byte[] subByte(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        if (i < 0 || i + i2 > length) {
            return null;
        }
        if (i2 < 0) {
            i2 = bArr.length - i;
        }
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr2[i3] = bArr[i3 + i];
        }
        return bArr2;
    }
}
