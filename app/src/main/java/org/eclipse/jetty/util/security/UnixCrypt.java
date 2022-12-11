package org.eclipse.jetty.util.security;

import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.PrintStream;
import java.lang.reflect.Array;
import me.tvspark.outline;
import org.apache.http.message.TokenParser;
import org.eclipse.jetty.http.HttpTokens;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.regexp.NativeRegExp;
import org.seamless.util.p061io.Base64Coder;

/* loaded from: classes5.dex */
public class UnixCrypt {

    /* renamed from: IP */
    public static final byte[] f4598IP = {HttpTokens.COLON, 50, 42, 34, NativeRegExp.REOP_STAR, 18, 10, 2, 60, NativeRegExp.REOP_MINIMALREPEAT, NativeRegExp.REOP_ASSERTNOTTEST, 36, NativeRegExp.REOP_OPT, 20, 12, 4, 62, NativeRegExp.REOP_ALTPREREQi, NativeRegExp.REOP_MINIMALPLUS, 38, NativeRegExp.REOP_RPAREN, NativeRegExp.REOP_CLASS, 14, 6, 64, 56, NativeRegExp.REOP_MINIMALQUANT, 40, 32, 24, 16, 8, NativeRegExp.REOP_END, NativeRegExp.REOP_ENDCHILD, NativeRegExp.REOP_ASSERT, 33, NativeRegExp.REOP_QUANT, NativeRegExp.REOP_FLAT1i, 9, 1, HttpTokens.SEMI_COLON, NativeRegExp.REOP_REPEAT, NativeRegExp.REOP_ASSERTTEST, 35, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_UCFLAT1i, 11, 3, Base64Coder.EQUALS_SIGN, NativeRegExp.REOP_ALTPREREQ, 45, 37, NativeRegExp.REOP_LPAREN, 21, 13, 5, 63, NativeRegExp.REOP_ALTPREREQ2, NativeRegExp.REOP_MINIMALOPT, 39, 31, 23, 15, 7};
    public static final byte[] ExpandTr = {32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, NativeRegExp.REOP_FLAT1i, 16, NativeRegExp.REOP_FLAT1i, 18, NativeRegExp.REOP_UCFLAT1i, 20, 21, 20, 21, NativeRegExp.REOP_CLASS, 23, 24, NativeRegExp.REOP_QUANT, 24, NativeRegExp.REOP_QUANT, NativeRegExp.REOP_STAR, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_OPT, NativeRegExp.REOP_LPAREN, NativeRegExp.REOP_OPT, NativeRegExp.REOP_LPAREN, NativeRegExp.REOP_RPAREN, 31, 32, 1};
    public static final byte[] PC1 = {NativeRegExp.REOP_END, NativeRegExp.REOP_ENDCHILD, NativeRegExp.REOP_ASSERT, 33, NativeRegExp.REOP_QUANT, NativeRegExp.REOP_FLAT1i, 9, 1, HttpTokens.COLON, 50, 42, 34, NativeRegExp.REOP_STAR, 18, 10, 2, HttpTokens.SEMI_COLON, NativeRegExp.REOP_REPEAT, NativeRegExp.REOP_ASSERTTEST, 35, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_UCFLAT1i, 11, 3, 60, NativeRegExp.REOP_MINIMALREPEAT, NativeRegExp.REOP_ASSERTNOTTEST, 36, 63, NativeRegExp.REOP_ALTPREREQ2, NativeRegExp.REOP_MINIMALOPT, 39, 31, 23, 15, 7, 62, NativeRegExp.REOP_ALTPREREQi, NativeRegExp.REOP_MINIMALPLUS, 38, NativeRegExp.REOP_RPAREN, NativeRegExp.REOP_CLASS, 14, 6, Base64Coder.EQUALS_SIGN, NativeRegExp.REOP_ALTPREREQ, 45, 37, NativeRegExp.REOP_LPAREN, 21, 13, 5, NativeRegExp.REOP_OPT, 20, 12, 4};
    public static final byte[] Rotates = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};
    public static final byte[] PC2 = {9, 18, 14, NativeRegExp.REOP_FLAT1i, 11, 24, 1, 5, NativeRegExp.REOP_CLASS, NativeRegExp.REOP_QUANT, 3, NativeRegExp.REOP_OPT, 15, 6, 21, 10, 35, 38, 23, NativeRegExp.REOP_UCFLAT1i, 12, 4, NativeRegExp.REOP_STAR, 8, NativeRegExp.REOP_ASSERTTEST, NativeRegExp.REOP_ALTPREREQi, 16, 7, NativeRegExp.REOP_PLUS, 20, 13, 2, 0, 0, NativeRegExp.REOP_ASSERT, NativeRegExp.REOP_MINIMALREPEAT, 31, 37, NativeRegExp.REOP_MINIMALOPT, NativeRegExp.REOP_ALTPREREQ2, 0, 0, NativeRegExp.REOP_RPAREN, 40, NativeRegExp.REOP_REPEAT, 45, 33, NativeRegExp.REOP_MINIMALQUANT, 0, 0, NativeRegExp.REOP_ASSERTNOTTEST, NativeRegExp.REOP_ENDCHILD, 39, 56, 34, NativeRegExp.REOP_ALTPREREQ, 0, 0, NativeRegExp.REOP_MINIMALPLUS, 42, 50, 36, NativeRegExp.REOP_LPAREN, 32};

    /* renamed from: S */
    public static final byte[][] f4599S = {new byte[]{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7, 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8, 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0, 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}, new byte[]{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10, 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5, 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15, 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}, new byte[]{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8, 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1, 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7, 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}, new byte[]{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15, 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9, 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4, 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}, new byte[]{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9, 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6, 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14, 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}, new byte[]{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11, 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8, 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6, 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}, new byte[]{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1, 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6, 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2, 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}, new byte[]{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7, 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2, 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8, 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}};
    public static final byte[] P32Tr = {16, 7, 20, 21, NativeRegExp.REOP_LPAREN, 12, NativeRegExp.REOP_OPT, NativeRegExp.REOP_FLAT1i, 1, 15, 23, NativeRegExp.REOP_STAR, 5, 18, 31, 10, 2, 8, 24, 14, 32, NativeRegExp.REOP_PLUS, 3, 9, NativeRegExp.REOP_UCFLAT1i, 13, NativeRegExp.REOP_RPAREN, 6, NativeRegExp.REOP_CLASS, 11, 4, NativeRegExp.REOP_QUANT};
    public static final byte[] CIFP = {1, 2, 3, 4, NativeRegExp.REOP_FLAT1i, 18, NativeRegExp.REOP_UCFLAT1i, 20, 5, 6, 7, 8, 21, NativeRegExp.REOP_CLASS, 23, 24, 9, 10, 11, 12, NativeRegExp.REOP_QUANT, NativeRegExp.REOP_STAR, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_OPT, 13, 14, 15, 16, NativeRegExp.REOP_LPAREN, NativeRegExp.REOP_RPAREN, 31, 32, 33, 34, 35, 36, NativeRegExp.REOP_ENDCHILD, 50, NativeRegExp.REOP_REPEAT, NativeRegExp.REOP_MINIMALREPEAT, 37, 38, 39, 40, NativeRegExp.REOP_ALTPREREQ, NativeRegExp.REOP_ALTPREREQi, NativeRegExp.REOP_ALTPREREQ2, 56, NativeRegExp.REOP_ASSERT, 42, NativeRegExp.REOP_ASSERTTEST, NativeRegExp.REOP_ASSERTNOTTEST, NativeRegExp.REOP_END, HttpTokens.COLON, HttpTokens.SEMI_COLON, 60, 45, NativeRegExp.REOP_MINIMALPLUS, NativeRegExp.REOP_MINIMALOPT, NativeRegExp.REOP_MINIMALQUANT, Base64Coder.EQUALS_SIGN, 62, 63, 64};
    public static final byte[] ITOA64 = {NativeRegExp.REOP_MINIMALPLUS, NativeRegExp.REOP_MINIMALOPT, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_ENDCHILD, 50, NativeRegExp.REOP_REPEAT, NativeRegExp.REOP_MINIMALREPEAT, NativeRegExp.REOP_ALTPREREQ, NativeRegExp.REOP_ALTPREREQi, NativeRegExp.REOP_ALTPREREQ2, 56, NativeRegExp.REOP_END, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, NativeJavaObject.CONVERSION_NONE, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    public static final byte[] A64TOI = new byte[128];
    public static final long[][] PC1ROT = (long[][]) Array.newInstance(long.class, 16, 16);
    public static final long[][][] PC2ROT = (long[][][]) Array.newInstance(long.class, 2, 16, 16);
    public static final long[][] IE3264 = (long[][]) Array.newInstance(long.class, 8, 16);
    public static final long[][] SPE = (long[][]) Array.newInstance(long.class, 8, 64);
    public static final long[][] CF6464 = (long[][]) Array.newInstance(long.class, 16, 16);

    static {
        int i = 64;
        int i2 = 2;
        int i3 = 3;
        byte[] bArr = new byte[64];
        byte[] bArr2 = new byte[64];
        for (int i4 = 0; i4 < 64; i4++) {
            A64TOI[ITOA64[i4]] = (byte) i4;
        }
        for (int i5 = 0; i5 < 64; i5++) {
            bArr[i5] = 0;
        }
        for (int i6 = 0; i6 < 64; i6++) {
            byte b = PC2[i6];
            if (b != 0) {
                byte[] bArr3 = Rotates;
                int i7 = (bArr3[0] - 1) + b;
                if (i7 % 28 < bArr3[0]) {
                    i7 -= 28;
                }
                int i8 = PC1[i7];
                if (i8 > 0) {
                    int i9 = i8 - 1;
                    i8 = ((i9 | 7) - (i9 & 7)) + 1;
                }
                bArr[i6] = (byte) i8;
            }
        }
        init_perm(PC1ROT, bArr, 8);
        for (int i10 = 0; i10 < 2; i10++) {
            for (int i11 = 0; i11 < 64; i11++) {
                bArr2[i11] = 0;
                bArr[i11] = 0;
            }
            for (int i12 = 0; i12 < 64; i12++) {
                byte b2 = PC2[i12];
                if (b2 != 0) {
                    bArr2[b2 - 1] = (byte) (i12 + 1);
                }
            }
            for (int i13 = 0; i13 < 64; i13++) {
                byte b3 = PC2[i13];
                if (b3 != 0) {
                    int i14 = b3 + i10;
                    if (i14 % 28 <= i10) {
                        i14 -= 28;
                    }
                    bArr[i13] = bArr2[i14];
                }
            }
            init_perm(PC2ROT[i10], bArr, 8);
        }
        for (int i15 = 0; i15 < 8; i15++) {
            int i16 = 0;
            while (i16 < 8) {
                int i17 = i16 < 2 ? 0 : f4598IP[ExpandTr[((i15 * 6) + i16) - 2] - 1];
                if (i17 > 32) {
                    i17 -= 32;
                } else if (i17 > 0) {
                    i17--;
                }
                if (i17 > 0) {
                    int i18 = i17 - 1;
                    i17 = ((i18 | 7) - (i18 & 7)) + 1;
                }
                bArr[(i15 * 8) + i16] = (byte) i17;
                i16++;
            }
        }
        init_perm(IE3264, bArr, 8);
        int i19 = 0;
        while (i19 < 64) {
            int i20 = f4598IP[CIFP[i19] - 1];
            if (i20 > 0) {
                int i21 = i20 - 1;
                i20 = ((i21 | 7) - (i21 & 7)) + 1;
            }
            i19++;
            bArr[i20 - 1] = (byte) i19;
        }
        init_perm(CF6464, bArr, 8);
        for (int i22 = 0; i22 < 48; i22++) {
            bArr[i22] = P32Tr[ExpandTr[i22] - 1];
        }
        int i23 = 0;
        while (i23 < 8) {
            int i24 = 0;
            while (i24 < i) {
                byte b4 = f4599S[i23][(((i24 >> 0) & 1) << 5) | (((i24 >> 1) & 1) << i3) | (((i24 >> 2) & 1) << i2) | (((i24 >> 3) & 1) << 1) | (((i24 >> 4) & 1) << 0) | (((i24 >> 5) & 1) << 4)];
                int i25 = (((b4 >> 0) & 1) << i3) | (((b4 >> 3) & 1) << 0) | (((b4 >> 2) & 1) << 1) | (((b4 >> 1) & 1) << i2);
                for (int i26 = 0; i26 < 32; i26++) {
                    bArr2[i26] = 0;
                }
                for (int i27 = 0; i27 < 4; i27++) {
                    bArr2[(i23 * 4) + i27] = (byte) ((i25 >> i27) & 1);
                }
                long j = 0;
                int i28 = 24;
                while (true) {
                    i28--;
                    if (i28 >= 0) {
                        j = bArr2[bArr[i28 + 24] - 1] | (bArr2[bArr[i28] - 1] << 32) | (j << 1);
                    }
                }
                SPE[i23][i24] = to_six_bit(j);
                i24++;
                i = 64;
                i2 = 2;
                i3 = 3;
            }
            i23++;
            i = 64;
            i2 = 2;
            i3 = 3;
        }
    }

    public static String crypt(String str, String str2) {
        byte[] bArr = new byte[13];
        if (str == null || str2 == null) {
            return "*";
        }
        int length = str.length();
        long j = 0;
        int i = 0;
        while (i < 8) {
            j = (j << 8) | (i < length ? str.charAt(i) * 2 : 0);
            i++;
        }
        long[] des_setkey = des_setkey(j);
        int i2 = 2;
        int i3 = 0;
        while (true) {
            i2--;
            if (i2 < 0) {
                break;
            }
            char charAt = i2 < str2.length() ? str2.charAt(i2) : '.';
            bArr[i2] = (byte) charAt;
            i3 = (i3 << 6) | (A64TOI[charAt] & 255);
        }
        long des_cipher = des_cipher(0L, i3, 25, des_setkey);
        int i4 = 12;
        bArr[12] = ITOA64[(((int) des_cipher) << 2) & 63];
        char c = 4;
        while (true) {
            des_cipher >>= c;
            i4--;
            if (i4 < 2) {
                return new String(bArr, 0, 13);
            }
            bArr[i4] = ITOA64[((int) des_cipher) & 63];
            c = 6;
        }
    }

    public static long des_cipher(long j, int i, int i2, long[] jArr) {
        int i3 = to_six_bit(i);
        long j2 = j & 6148914691236517205L;
        char c = 1;
        long j3 = (j & (-6148914694099828736L)) | ((j >> 1) & 1431655765);
        char c2 = TokenParser.f4579SP;
        long j4 = 4294967295L;
        long perm3264 = perm3264((int) (((((j2 << 32) | (j2 << 1)) & (-4294967296L)) | ((j3 | (j3 >> 32)) & 4294967295L)) >> 32), IE3264);
        long perm32642 = perm3264((int) (perm3264 & (-1)), IE3264);
        long j5 = perm3264;
        int i4 = i2;
        while (true) {
            i4--;
            if (i4 >= 0) {
                char c3 = 0;
                int i5 = 0;
                while (i5 < 8) {
                    int i6 = i5 << 1;
                    long j6 = i3;
                    long j7 = ((perm32642 >> c2) ^ perm32642) & j6 & j4;
                    long j8 = ((j7 | (j7 << c2)) ^ perm32642) ^ jArr[i6];
                    long[][] jArr2 = SPE;
                    long j9 = j5 ^ (((((((jArr2[c][(int) ((j8 >> 50) & 63)] ^ jArr2[c3][(int) ((j8 >> 58) & 63)]) ^ jArr2[2][(int) ((j8 >> 42) & 63)]) ^ jArr2[3][(int) ((j8 >> 34) & 63)]) ^ jArr2[4][(int) ((j8 >> 26) & 63)]) ^ jArr2[5][(int) ((j8 >> 18) & 63)]) ^ jArr2[6][(int) ((j8 >> 10) & 63)]) ^ jArr2[7][(int) ((j8 >> 2) & 63)]);
                    long j10 = ((j9 >> 32) ^ j9) & j6 & 4294967295L;
                    long j11 = jArr[i6 + 1] ^ ((j10 | (j10 << 32)) ^ j9);
                    perm32642 ^= jArr2[7][(int) ((j11 >> 2) & 63)] ^ ((((((jArr2[1][(int) ((j11 >> 50) & 63)] ^ jArr2[0][(int) ((j11 >> 58) & 63)]) ^ jArr2[2][(int) ((j11 >> 42) & 63)]) ^ jArr2[3][(int) ((j11 >> 34) & 63)]) ^ jArr2[4][(int) ((j11 >> 26) & 63)]) ^ jArr2[5][(int) ((j11 >> 18) & 63)]) ^ jArr2[6][(int) ((j11 >> 10) & 63)]);
                    i5++;
                    j4 = 4294967295L;
                    j5 = j9;
                    c3 = 0;
                    c = 1;
                    c2 = TokenParser.f4579SP;
                }
                long j12 = j5 ^ perm32642;
                perm32642 ^= j12;
                j5 = j12 ^ perm32642;
                c = 1;
                c2 = TokenParser.f4579SP;
            } else {
                return perm6464(((((j5 >> 35) & 252645135) | (((j5 & (-1)) << 1) & 4042322160L)) << 32) | (252645135 & (perm32642 >> 35)) | ((((-1) & perm32642) << 1) & 4042322160L), CF6464);
            }
        }
    }

    public static long[] des_setkey(long j) {
        long perm6464 = perm6464(j, PC1ROT);
        long[] jArr = new long[16];
        jArr[0] = perm6464 & (-217020518463700993L);
        for (int i = 1; i < 16; i++) {
            jArr[i] = perm6464;
            perm6464 = perm6464(perm6464, PC2ROT[Rotates[i] - 1]);
            jArr[i] = perm6464 & (-217020518463700993L);
        }
        return jArr;
    }

    public static void init_perm(long[][] jArr, byte[] bArr, int i) {
        for (int i2 = 0; i2 < i * 8; i2++) {
            int i3 = bArr[i2] - 1;
            if (i3 >= 0) {
                int i4 = i3 >> 2;
                int i5 = 1 << (i3 & 3);
                for (int i6 = 0; i6 < 16; i6++) {
                    int i7 = (i2 & 7) + ((7 - (i2 >> 3)) << 3);
                    if ((i6 & i5) != 0) {
                        long[] jArr2 = jArr[i4];
                        jArr2[i6] = jArr2[i6] | (1 << i7);
                    }
                }
            }
        }
    }

    public static void main(String[] strArr) {
        if (strArr.length != 2) {
            System.err.println("Usage - java org.eclipse.util.UnixCrypt <key> <salt>");
            System.exit(1);
        }
        PrintStream printStream = System.err;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Crypt=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(crypt(strArr[0], strArr[1]));
        printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public static long perm3264(int i, long[][] jArr) {
        long j = 0;
        int i2 = 4;
        while (true) {
            i2--;
            if (i2 >= 0) {
                int i3 = i & 255;
                i >>= 8;
                int i4 = i2 << 1;
                j = j | jArr[i4][i3 & 15] | jArr[i4 + 1][i3 >> 4];
            } else {
                return j;
            }
        }
    }

    public static long perm6464(long j, long[][] jArr) {
        long j2 = 0;
        int i = 8;
        while (true) {
            i--;
            if (i >= 0) {
                int i2 = (int) (255 & j);
                j >>= 8;
                int i3 = i << 1;
                j2 = j2 | jArr[i3][i2 & 15] | jArr[i3 + 1][i2 >> 4];
            } else {
                return j2;
            }
        }
    }

    public static int to_six_bit(int i) {
        return ((i >> 16) & TinkerReport.KEY_LOADED_EXCEPTION_DEX) | ((i << 26) & (-67108864)) | ((i << 12) & 16515072) | ((i >> 2) & 64512);
    }

    public static long to_six_bit(long j) {
        return ((j >> 16) & 1082331758844L) | ((j << 26) & (-288230371923853312L)) | ((j << 12) & 70931694147600384L) | ((j >> 2) & 277076930264064L);
    }
}
