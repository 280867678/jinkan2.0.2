package me.tvspark;

import okio.ByteString;

/* loaded from: classes4.dex */
public final class rw0 {
    public static final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$jvm();
    public static final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$jvm();

    public static final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        int i;
        char charAt;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$receiver");
        int length = str.length();
        while (length > 0 && ((charAt = str.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i2 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char charAt2 = str.charAt(i6);
            if ('A' <= charAt2 && 'Z' >= charAt2) {
                i = charAt2 - 'A';
            } else if ('a' <= charAt2 && 'z' >= charAt2) {
                i = charAt2 - 'G';
            } else if ('0' <= charAt2 && '9' >= charAt2) {
                i = charAt2 + 4;
            } else if (charAt2 == '+' || charAt2 == '-') {
                i = 62;
            } else if (charAt2 == '/' || charAt2 == '_') {
                i = 63;
            } else {
                if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                    return null;
                }
            }
            i4 = (i4 << 6) | i;
            i3++;
            if (i3 % 4 == 0) {
                int i7 = i5 + 1;
                bArr[i5] = (byte) (i4 >> 16);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (i4 >> 8);
                bArr[i8] = (byte) i4;
                i5 = i8 + 1;
            }
        }
        int i9 = i3 % 4;
        if (i9 != 1) {
            if (i9 == 2) {
                bArr[i5] = (byte) ((i4 << 12) >> 16);
                i5++;
            } else if (i9 == 3) {
                int i10 = i4 << 6;
                int i11 = i5 + 1;
                bArr[i5] = (byte) (i10 >> 16);
                i5 = i11 + 1;
                bArr[i11] = (byte) (i10 >> 8);
            }
            if (i5 == i2) {
                return bArr;
            }
            byte[] bArr2 = new byte[i5];
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "src");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, "dest");
            System.arraycopy(bArr, 0, bArr2, 0, i5);
            return bArr2;
        }
        return null;
    }

    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, byte[] bArr2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "$receiver");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, "map");
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            byte b = bArr[i];
            int i4 = i3 + 1;
            byte b2 = bArr[i3];
            int i5 = i4 + 1;
            byte b3 = bArr[i4];
            int i6 = i2 + 1;
            bArr3[i2] = bArr2[(b & 255) >> 2];
            int i7 = i6 + 1;
            bArr3[i6] = bArr2[((b & 3) << 4) | ((b2 & 255) >> 4)];
            int i8 = i7 + 1;
            bArr3[i7] = bArr2[((b2 & 15) << 2) | ((b3 & 255) >> 6)];
            i2 = i8 + 1;
            bArr3[i8] = bArr2[b3 & 63];
            i = i5;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b4 = bArr[i];
            int i9 = i2 + 1;
            bArr3[i2] = bArr2[(b4 & 255) >> 2];
            int i10 = i9 + 1;
            bArr3[i9] = bArr2[(b4 & 3) << 4];
            byte b5 = (byte) 61;
            bArr3[i10] = b5;
            bArr3[i10 + 1] = b5;
        } else if (length2 == 2) {
            int i11 = i + 1;
            byte b6 = bArr[i];
            byte b7 = bArr[i11];
            int i12 = i2 + 1;
            bArr3[i2] = bArr2[(b6 & 255) >> 2];
            int i13 = i12 + 1;
            bArr3[i12] = bArr2[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            bArr3[i13] = bArr2[(b7 & 15) << 2];
            bArr3[i13 + 1] = (byte) 61;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr3, "$receiver");
        return new String(bArr3, ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
