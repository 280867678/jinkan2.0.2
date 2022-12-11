package org.eclipse.jetty.util;

import androidx.core.view.PointerIconCompat;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class B64Code {
    public static final char __pad = '=';
    public static final char[] __rfc1421alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    public static final byte[] __rfc1421nibbles = new byte[256];

    static {
        for (int i = 0; i < 256; i++) {
            __rfc1421nibbles[i] = -1;
        }
        for (byte b = 0; b < 64; b = (byte) (b + 1)) {
            __rfc1421nibbles[(byte) __rfc1421alphabet[b]] = b;
        }
        __rfc1421nibbles[61] = 0;
    }

    public static String decode(String str, String str2) throws UnsupportedEncodingException {
        byte[] decode = decode(str);
        return str2 == null ? new String(decode) : new String(decode, str2);
    }

    public static void decode(String str, ByteArrayOutputStream byteArrayOutputStream) {
        int i;
        if (str == null) {
            return;
        }
        if (byteArrayOutputStream == null) {
            throw new IllegalArgumentException("No outputstream for decoded bytes");
        }
        byte[] bArr = new byte[4];
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            int i4 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt == '=') {
                return;
            }
            if (!Character.isWhitespace(charAt)) {
                byte[] bArr2 = __rfc1421nibbles;
                if (bArr2[charAt] < 0) {
                    throw new IllegalArgumentException("Not B64 encoded");
                }
                int i5 = i3 + 1;
                bArr[i3] = bArr2[charAt];
                if (i5 == 2) {
                    i = (bArr[1] >>> 4) | (bArr[0] << 2);
                } else if (i5 != 3) {
                    if (i5 == 4) {
                        byteArrayOutputStream.write((bArr[2] << 6) | bArr[3]);
                        i3 = 0;
                    }
                    i3 = i5;
                } else {
                    i = (bArr[1] << 4) | (bArr[2] >>> 2);
                }
                byteArrayOutputStream.write(i);
                i3 = i5;
            }
            i2 = i4;
        }
    }

    public static byte[] decode(String str) {
        if (str == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((str.length() * 4) / 3);
        decode(str, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] decode(char[] cArr) {
        byte b;
        int i;
        int i2;
        if (cArr == null) {
            return null;
        }
        int length = cArr.length;
        if (length % 4 != 0) {
            throw new IllegalArgumentException("Input block size is not 4");
        }
        int i3 = 1;
        int i4 = length - 1;
        while (i4 >= 0 && cArr[i4] == '=') {
            i4--;
        }
        int i5 = 0;
        if (i4 < 0) {
            return new byte[0];
        }
        int i6 = ((i4 + 1) * 3) / 4;
        byte[] bArr = new byte[i6];
        int i7 = (i6 / 3) * 3;
        int i8 = 0;
        while (i5 < i7) {
            try {
                int i9 = i8 + 1;
                try {
                    byte b2 = __rfc1421nibbles[cArr[i8]];
                    int i10 = i9 + 1;
                    try {
                        byte b3 = __rfc1421nibbles[cArr[i9]];
                        int i11 = i10 + 1;
                        try {
                            b = __rfc1421nibbles[cArr[i10]];
                            i = i11 + 1;
                        } catch (IndexOutOfBoundsException unused) {
                            i8 = i11;
                        }
                        try {
                            byte b4 = __rfc1421nibbles[cArr[i11]];
                            if (b2 < 0 || b3 < 0 || b < 0 || b4 < 0) {
                                throw new IllegalArgumentException("Not B64 encoded");
                            }
                            int i12 = i5 + 1;
                            bArr[i5] = (byte) ((b2 << 2) | (b3 >>> 4));
                            int i13 = i12 + 1;
                            int i14 = b3 << 4;
                            i2 = b >>> 2;
                            bArr[i12] = (byte) (i14 | i2);
                            bArr[i13] = (byte) ((b << 6) | b4);
                            i5 = i13 + 1;
                            i8 = i;
                        } catch (IndexOutOfBoundsException unused2) {
                            i8 = i;
                            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("char ", i8, " was not B64 encoded"));
                        }
                    } catch (IndexOutOfBoundsException unused3) {
                        i8 = i10;
                    }
                } catch (IndexOutOfBoundsException unused4) {
                    i8 = i9;
                }
            } catch (IndexOutOfBoundsException unused5) {
            }
        }
        if (i6 != i5) {
            int i15 = i6 % 3;
            try {
                try {
                    if (i15 == 1) {
                        i3 = i8 + 1;
                        byte b5 = __rfc1421nibbles[cArr[i8]];
                        int i16 = i3 + 1;
                        byte b6 = __rfc1421nibbles[cArr[i3]];
                        if (b5 < 0 || b6 < 0) {
                            throw new IllegalArgumentException("Not B64 encoded");
                        }
                        bArr[i5] = (byte) ((b6 >>> 4) | (b5 << 2));
                    } else if (i15 == 2) {
                        int i17 = i8 + 1;
                        byte b7 = __rfc1421nibbles[cArr[i8]];
                        int i18 = i17 + 1;
                        i3 = __rfc1421nibbles[cArr[i17]];
                        int i19 = i18 + 1;
                        byte b8 = __rfc1421nibbles[cArr[i18]];
                        if (b7 < 0 || i3 < 0 || b8 < 0) {
                            throw new IllegalArgumentException("Not B64 encoded");
                        }
                        bArr[i5] = (byte) ((b7 << 2) | (i3 >>> 4));
                        bArr[i5 + 1] = (byte) ((b8 >>> 2) | (i3 << 4));
                    }
                } catch (IndexOutOfBoundsException unused6) {
                    i8 = i3;
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("char ", i8, " was not B64 encoded"));
                }
            } catch (IndexOutOfBoundsException unused7) {
                i8 = i2;
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("char ", i8, " was not B64 encoded"));
            }
        }
        return bArr;
    }

    public static String encode(String str) {
        try {
            return encode(str, (String) null);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e.toString());
        }
    }

    public static String encode(String str, String str2) throws UnsupportedEncodingException {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        return new String(encode(str.getBytes(str2)));
    }

    public static void encode(int i, Appendable appendable) throws IOException {
        appendable.append(__rfc1421alphabet[(((-67108864) & i) >> 26) & 63]);
        appendable.append(__rfc1421alphabet[((66060288 & i) >> 20) & 63]);
        appendable.append(__rfc1421alphabet[((1032192 & i) >> 14) & 63]);
        appendable.append(__rfc1421alphabet[((i & 16128) >> 8) & 63]);
        appendable.append(__rfc1421alphabet[((i & TinkerReport.KEY_LOADED_EXCEPTION_DEX) >> 2) & 63]);
        appendable.append(__rfc1421alphabet[((i & 3) << 4) & 63]);
        appendable.append(__pad);
    }

    public static void encode(long j, Appendable appendable) throws IOException {
        int i = (int) ((j >> 32) & (-4));
        appendable.append(__rfc1421alphabet[(((-67108864) & i) >> 26) & 63]);
        appendable.append(__rfc1421alphabet[((66060288 & i) >> 20) & 63]);
        appendable.append(__rfc1421alphabet[((1032192 & i) >> 14) & 63]);
        appendable.append(__rfc1421alphabet[((i & 16128) >> 8) & 63]);
        appendable.append(__rfc1421alphabet[((i & TinkerReport.KEY_LOADED_EXCEPTION_DEX) >> 2) & 63]);
        appendable.append(__rfc1421alphabet[(((i & 3) << 4) + (((int) (j >> 28)) & 15)) & 63]);
        int i2 = 268435455 & ((int) j);
        appendable.append(__rfc1421alphabet[((264241152 & i2) >> 22) & 63]);
        appendable.append(__rfc1421alphabet[((4128768 & i2) >> 16) & 63]);
        appendable.append(__rfc1421alphabet[((64512 & i2) >> 10) & 63]);
        appendable.append(__rfc1421alphabet[((i2 & PointerIconCompat.TYPE_TEXT) >> 4) & 63]);
        appendable.append(__rfc1421alphabet[((i2 & 15) << 2) & 63]);
    }

    public static char[] encode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        char[] cArr = new char[((length + 2) / 3) * 4];
        int i = (length / 3) * 3;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            byte b = bArr[i2];
            int i5 = i4 + 1;
            byte b2 = bArr[i4];
            int i6 = i5 + 1;
            byte b3 = bArr[i5];
            int i7 = i3 + 1;
            char[] cArr2 = __rfc1421alphabet;
            cArr[i3] = cArr2[(b >>> 2) & 63];
            int i8 = i7 + 1;
            cArr[i7] = cArr2[((b << 4) & 63) | ((b2 >>> 4) & 15)];
            int i9 = i8 + 1;
            cArr[i8] = cArr2[((b2 << 2) & 63) | ((b3 >>> 6) & 3)];
            i3 = i9 + 1;
            cArr[i9] = cArr2[b3 & 63];
            i2 = i6;
        }
        if (length != i2) {
            int i10 = length % 3;
            if (i10 == 1) {
                byte b4 = bArr[i2];
                int i11 = i3 + 1;
                char[] cArr3 = __rfc1421alphabet;
                cArr[i3] = cArr3[(b4 >>> 2) & 63];
                int i12 = i11 + 1;
                cArr[i11] = cArr3[(b4 << 4) & 63];
                cArr[i12] = __pad;
                cArr[i12 + 1] = __pad;
            } else if (i10 == 2) {
                int i13 = i2 + 1;
                byte b5 = bArr[i2];
                byte b6 = bArr[i13];
                int i14 = i3 + 1;
                char[] cArr4 = __rfc1421alphabet;
                cArr[i3] = cArr4[(b5 >>> 2) & 63];
                int i15 = i14 + 1;
                cArr[i14] = cArr4[((b5 << 4) & 63) | ((b6 >>> 4) & 15)];
                cArr[i15] = cArr4[(b6 << 2) & 63];
                cArr[i15 + 1] = __pad;
            }
        }
        return cArr;
    }

    public static char[] encode(byte[] bArr, boolean z) {
        if (bArr == null) {
            return null;
        }
        if (!z) {
            return encode(bArr);
        }
        int length = bArr.length;
        int i = ((length + 2) / 3) * 4;
        char[] cArr = new char[((i / 76) * 2) + 2 + i];
        int i2 = (length / 3) * 3;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2) {
            int i6 = i3 + 1;
            byte b = bArr[i3];
            int i7 = i6 + 1;
            byte b2 = bArr[i6];
            int i8 = i7 + 1;
            byte b3 = bArr[i7];
            int i9 = i4 + 1;
            char[] cArr2 = __rfc1421alphabet;
            cArr[i4] = cArr2[(b >>> 2) & 63];
            int i10 = i9 + 1;
            cArr[i9] = cArr2[((b << 4) & 63) | ((b2 >>> 4) & 15)];
            int i11 = i10 + 1;
            cArr[i10] = cArr2[((b2 << 2) & 63) | ((b3 >>> 6) & 3)];
            i4 = i11 + 1;
            cArr[i11] = cArr2[b3 & 63];
            i5 += 4;
            if (i5 % 76 == 0) {
                int i12 = i4 + 1;
                cArr[i4] = '\r';
                i4 = i12 + 1;
                cArr[i12] = '\n';
            }
            i3 = i8;
        }
        if (length != i3) {
            int i13 = length % 3;
            if (i13 == 1) {
                byte b4 = bArr[i3];
                int i14 = i4 + 1;
                char[] cArr3 = __rfc1421alphabet;
                cArr[i4] = cArr3[(b4 >>> 2) & 63];
                int i15 = i14 + 1;
                cArr[i14] = cArr3[(b4 << 4) & 63];
                int i16 = i15 + 1;
                cArr[i15] = __pad;
                i4 = i16 + 1;
                cArr[i16] = __pad;
            } else if (i13 == 2) {
                int i17 = i3 + 1;
                byte b5 = bArr[i3];
                byte b6 = bArr[i17];
                int i18 = i4 + 1;
                char[] cArr4 = __rfc1421alphabet;
                cArr[i4] = cArr4[(b5 >>> 2) & 63];
                int i19 = i18 + 1;
                cArr[i18] = cArr4[((b5 << 4) & 63) | ((b6 >>> 4) & 15)];
                int i20 = i19 + 1;
                cArr[i19] = cArr4[(b6 << 2) & 63];
                i4 = i20 + 1;
                cArr[i20] = __pad;
            }
        }
        cArr[i4] = '\r';
        cArr[i4 + 1] = '\n';
        return cArr;
    }
}
