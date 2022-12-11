package org.mozilla.javascript;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.math.BigInteger;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class DToA {
    public static final int Bias = 1023;
    public static final int Bletch = 16;
    public static final int Bndry_mask = 1048575;
    public static final int DTOSTR_EXPONENTIAL = 3;
    public static final int DTOSTR_FIXED = 2;
    public static final int DTOSTR_PRECISION = 4;
    public static final int DTOSTR_STANDARD = 0;
    public static final int DTOSTR_STANDARD_EXPONENTIAL = 1;
    public static final int Exp_11 = 1072693248;
    public static final int Exp_mask = 2146435072;
    public static final int Exp_mask_shifted = 2047;
    public static final int Exp_msk1 = 1048576;
    public static final long Exp_msk1L = 4503599627370496L;
    public static final int Exp_shift = 20;
    public static final int Exp_shift1 = 20;
    public static final int Exp_shiftL = 52;
    public static final int Frac_mask = 1048575;
    public static final int Frac_mask1 = 1048575;
    public static final long Frac_maskL = 4503599627370495L;
    public static final int Int_max = 14;
    public static final int Log2P = 1;

    /* renamed from: P */
    public static final int f4668P = 53;
    public static final int Quick_max = 14;
    public static final int Sign_bit = Integer.MIN_VALUE;
    public static final int Ten_pmax = 22;
    public static final int n_bigtens = 5;
    public static final double[] tens = {1.0d, 10.0d, 100.0d, 1000.0d, 10000.0d, 100000.0d, 1000000.0d, 1.0E7d, 1.0E8d, 1.0E9d, 1.0E10d, 1.0E11d, 1.0E12d, 1.0E13d, 1.0E14d, 1.0E15d, 1.0E16d, 1.0E17d, 1.0E18d, 1.0E19d, 1.0E20d, 1.0E21d, 1.0E22d};
    public static final double[] bigtens = {1.0E16d, 1.0E32d, 1.0E64d, 1.0E128d, 1.0E256d};
    public static final int[] dtoaModes = {0, 0, 3, 2, 2};

    public static char BASEDIGIT(int i) {
        return (char) (i >= 10 ? i + 87 : i + 48);
    }

    /* JADX WARN: Code restructure failed: missing block: B:176:0x0446, code lost:
        if (r9 != 0) goto L336;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x05ee, code lost:
        if (r13 <= 0) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x05f0, code lost:
        r2 = r12.shiftLeft(1).compareTo(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x05f9, code lost:
        if (r2 > 0) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x05fb, code lost:
        if (r2 != 0) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x05ff, code lost:
        if ((r4 & 1) == 1) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0601, code lost:
        if (r46 == false) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0603, code lost:
        r0 = (char) (r4 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0608, code lost:
        if (r4 != '9') goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x060a, code lost:
        r49.append('9');
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0611, code lost:
        if (roundOff(r49) == false) goto L268;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x0613, code lost:
        r10 = r10 + 1;
        r49.append('1');
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x061c, code lost:
        return r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x061d, code lost:
        r5 = 1;
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0621, code lost:
        r49.append(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0625, code lost:
        return r10 + r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0620, code lost:
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x0273, code lost:
        r0 = r49.charAt(r49.length() - 1);
        r49.setLength(r49.length() - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x0286, code lost:
        if (r0 == '9') goto L353;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x028d, code lost:
        if (r49.length() != 0) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x028f, code lost:
        r10 = r10 + 1;
        r0 = '0';
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x0293, code lost:
        r49.append((char) (r0 + 1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x0299, code lost:
        return r10 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0427 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0649 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x065c  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0626  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x023e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int JS_dtoa(double d, int i, boolean z, int i2, boolean[] zArr, StringBuilder sb) {
        double d2;
        int[] iArr;
        long word1;
        double word0;
        int i3;
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        boolean z3;
        BigInteger bigInteger;
        int i8;
        int i9;
        int i10;
        boolean z4;
        int i11;
        int i12;
        int[] iArr2;
        int i13;
        boolean z5;
        double d3;
        int i14;
        int i15;
        int i16;
        boolean z6;
        char c;
        int i17;
        double d4;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        boolean z7;
        int i24;
        int i25;
        int hi0bits;
        int i26;
        int i27;
        int i28;
        int i29;
        BigInteger bigInteger4;
        char intValue;
        char c2;
        int compareTo;
        int i30;
        int i31;
        int i32;
        int compareTo2;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        char c3;
        double d5;
        int i39;
        int i40;
        boolean z8;
        int i41;
        long j;
        char c4;
        long j2;
        double d6;
        int i42;
        boolean z9;
        int i43 = i;
        int[] iArr3 = new int[1];
        int[] iArr4 = new int[1];
        boolean z10 = false;
        if ((word0(d) & Integer.MIN_VALUE) != 0) {
            zArr[0] = true;
            d2 = setWord0(d, word0(d) & Integer.MAX_VALUE);
        } else {
            d2 = d;
            zArr[0] = false;
        }
        if ((word0(d2) & Exp_mask) == 2146435072) {
            sb.append((word1(d2) == 0 && (word0(d2) & 1048575) == 0) ? "Infinity" : "NaN");
            return 9999;
        } else if (d2 == RoundRectDrawableWithShadow.COS_45) {
            sb.setLength(0);
            sb.append('0');
            return 1;
        } else {
            BigInteger d2b = d2b(d2, iArr3, iArr4);
            int word02 = (word0(d2) >>> 20) & Exp_mask_shifted;
            if (word02 != 0) {
                i3 = word02 - 1023;
                iArr = iArr3;
                word0 = setWord0(d2, (word0(d2) & 1048575) | Exp_11);
            } else {
                int i44 = iArr4[0] + iArr3[0] + 1074;
                if (i44 > 32) {
                    iArr = iArr3;
                    word1 = (word0(d2) << (64 - i44)) | (word1(d2) >>> (i44 - 32));
                } else {
                    iArr = iArr3;
                    word1 = word1(d2) << (32 - i44);
                }
                double d7 = word1;
                word0 = setWord0(d7, word0(d7) - 32505856);
                i3 = i44 - 1075;
                z10 = true;
            }
            double d8 = (i3 * 0.301029995663981d) + ((word0 - 1.5d) * 0.289529654602168d) + 0.1760912590558d;
            int i45 = (int) d8;
            if (d8 < RoundRectDrawableWithShadow.COS_45 && d8 != i45) {
                i45--;
            }
            if (i45 < 0 || i45 > 22) {
                i4 = i45;
                z2 = true;
            } else {
                if (d2 < tens[i45]) {
                    i45--;
                }
                i4 = i45;
                z2 = false;
            }
            int i46 = (iArr4[0] - i3) - 1;
            if (i46 >= 0) {
                i5 = 0;
            } else {
                i5 = -i46;
                i46 = 0;
            }
            if (i4 >= 0) {
                i46 += i4;
                i7 = i4;
                i6 = 0;
            } else {
                i5 -= i4;
                i6 = -i4;
                i7 = 0;
            }
            if (i43 < 0 || i43 > 9) {
                i43 = 0;
            }
            if (i43 > 5) {
                i43 -= 4;
                z3 = false;
            } else {
                z3 = true;
            }
            if (i43 != 0) {
                z4 = true;
                if (i43 != 1) {
                    if (i43 != 2) {
                        if (i43 == 3) {
                            z9 = false;
                        } else if (i43 != 4) {
                            if (i43 != 5) {
                                i10 = i2;
                                bigInteger = d2b;
                                i8 = i46;
                                i9 = 0;
                                i11 = 0;
                                if (i9 >= 0 || i9 > 14 || !z3) {
                                    i12 = i4;
                                    iArr2 = iArr4;
                                    i13 = i5;
                                    z5 = z10;
                                    d3 = d2;
                                    i14 = i9;
                                    i15 = i6;
                                    i16 = i7;
                                    z6 = z4;
                                    c = 0;
                                } else {
                                    if (i4 > 0) {
                                        double d9 = tens[i4 & 15];
                                        int i47 = i4 >> 4;
                                        if ((i47 & 16) != 0) {
                                            i47 &= 15;
                                            d6 = d2 / bigtens[4];
                                            i42 = 0;
                                            i39 = 3;
                                        } else {
                                            d6 = d2;
                                            i42 = 0;
                                            i39 = 2;
                                        }
                                        while (i47 != 0) {
                                            if ((i47 & 1) != 0) {
                                                i39++;
                                                d9 *= bigtens[i42];
                                            }
                                            i47 >>= 1;
                                            i42++;
                                        }
                                        d5 = d6 / d9;
                                    } else {
                                        int i48 = -i4;
                                        if (i48 != 0) {
                                            int i49 = i48 >> 4;
                                            d5 = tens[i48 & 15] * d2;
                                            int i50 = 0;
                                            i39 = 2;
                                            while (i49 != 0) {
                                                if ((i49 & 1) != 0) {
                                                    i39++;
                                                    d5 *= bigtens[i50];
                                                }
                                                i49 >>= 1;
                                                i50++;
                                            }
                                        } else {
                                            d5 = d2;
                                            i39 = 2;
                                        }
                                    }
                                    if (!z2 || d5 >= 1.0d || i9 <= 0) {
                                        i17 = i4;
                                        d3 = d2;
                                        i40 = i9;
                                        i14 = i40;
                                        z8 = false;
                                    } else if (i11 <= 0) {
                                        i17 = i4;
                                        d3 = d2;
                                        i40 = i9;
                                        i14 = i40;
                                        z8 = true;
                                    } else {
                                        i17 = i4 - 1;
                                        d5 *= 10.0d;
                                        int i51 = i39 + 1;
                                        d3 = d2;
                                        i14 = i9;
                                        i40 = i11;
                                        z8 = false;
                                        i12 = i4;
                                        i41 = i51;
                                        double d10 = (i41 * d5) + 7.0d;
                                        double word03 = setWord0(d10, word0(d10) - 54525952);
                                        if (i40 != 0) {
                                            d5 -= 5.0d;
                                            if (d5 > word03) {
                                                sb.append('1');
                                                return i17 + 1 + 1;
                                            }
                                            iArr2 = iArr4;
                                            if (d5 < (-word03)) {
                                                sb.setLength(0);
                                                sb.append('0');
                                                return 1;
                                            }
                                            z8 = true;
                                        } else {
                                            iArr2 = iArr4;
                                        }
                                        if (z8) {
                                            if (z4) {
                                                double d11 = (0.5d / tens[i40 - 1]) - word03;
                                                i13 = i5;
                                                z5 = z10;
                                                i15 = i6;
                                                i16 = i7;
                                                double d12 = d5;
                                                int i52 = 0;
                                                while (true) {
                                                    z6 = z4;
                                                    d5 = d12 - ((long) d12);
                                                    sb.append((char) (j2 + 48));
                                                    if (d5 < d11) {
                                                        return i17 + 1;
                                                    }
                                                    if (1.0d - d5 < d11) {
                                                        break;
                                                    }
                                                    i52++;
                                                    if (i52 >= i40) {
                                                        break;
                                                    }
                                                    d11 *= 10.0d;
                                                    d12 = d5 * 10.0d;
                                                    z4 = z6;
                                                }
                                            } else {
                                                i13 = i5;
                                                z5 = z10;
                                                i15 = i6;
                                                i16 = i7;
                                                z6 = z4;
                                                double d13 = word03 * tens[i40 - 1];
                                                double d14 = d5;
                                                int i53 = 1;
                                                while (true) {
                                                    d5 = d14 - ((long) d14);
                                                    sb.append((char) (j + 48));
                                                    if (i53 == i40) {
                                                        break;
                                                    }
                                                    i53++;
                                                    d14 = d5 * 10.0d;
                                                }
                                                if (d5 > d13 + 0.5d) {
                                                    while (true) {
                                                        char charAt = sb.charAt(sb.length() - 1);
                                                        sb.setLength(sb.length() - 1);
                                                        if (charAt != '9') {
                                                            c4 = charAt;
                                                            break;
                                                        } else if (sb.length() == 0) {
                                                            i17++;
                                                            c4 = '0';
                                                            break;
                                                        }
                                                    }
                                                    sb.append((char) (c4 + 1));
                                                    return i17 + 1;
                                                } else if (d5 < 0.5d - d13) {
                                                    stripTrailingZeroes(sb);
                                                    return i17 + 1;
                                                }
                                            }
                                            z8 = true;
                                        } else {
                                            i13 = i5;
                                            z5 = z10;
                                            i15 = i6;
                                            i16 = i7;
                                            z6 = z4;
                                        }
                                        c = 0;
                                        if (z8) {
                                            i18 = i40;
                                            d4 = d5;
                                            if (iArr[c] < 0 && i17 <= 14) {
                                                double d15 = tens[i17];
                                                if (i10 < 0 && i18 <= 0) {
                                                    if (i18 >= 0) {
                                                        double d16 = d15 * 5.0d;
                                                        if (d4 >= d16 && (z || d4 != d16)) {
                                                            sb.append('1');
                                                            return i17 + 1 + 1;
                                                        }
                                                    }
                                                    sb.setLength(0);
                                                    sb.append('0');
                                                    return 1;
                                                }
                                                int i54 = 1;
                                                while (true) {
                                                    long j3 = (long) (d4 / d15);
                                                    double d17 = d4 - (j3 * d15);
                                                    sb.append((char) (j3 + 48));
                                                    if (i54 == i18) {
                                                        int i55 = ((d17 + d17) > d15 ? 1 : ((d17 + d17) == d15 ? 0 : -1));
                                                        if (i55 > 0 || (i55 == 0 && ((j3 & 1) != 0 || z))) {
                                                            while (true) {
                                                                i38 = 1;
                                                                char charAt2 = sb.charAt(sb.length() - 1);
                                                                sb.setLength(sb.length() - 1);
                                                                if (charAt2 != '9') {
                                                                    c3 = charAt2;
                                                                    break;
                                                                } else if (sb.length() == 0) {
                                                                    i17++;
                                                                    c3 = '0';
                                                                    break;
                                                                }
                                                            }
                                                            sb.append((char) (c3 + 1));
                                                        } else {
                                                            i38 = 1;
                                                        }
                                                    } else {
                                                        i38 = 1;
                                                        d4 = d17 * 10.0d;
                                                        if (d4 == RoundRectDrawableWithShadow.COS_45) {
                                                            break;
                                                        }
                                                        i54++;
                                                    }
                                                }
                                                return i17 + i38;
                                            }
                                            BigInteger bigInteger5 = null;
                                            if (z6) {
                                                if (i43 < 2) {
                                                    i36 = z5 ? iArr[0] + 1075 : 54 - iArr2[0];
                                                    i34 = i15;
                                                    i35 = i34;
                                                    i33 = i16;
                                                } else {
                                                    int i56 = i18 - 1;
                                                    int i57 = i15;
                                                    if (i57 >= i56) {
                                                        i33 = i16;
                                                        i35 = i57 - i56;
                                                        i34 = i57;
                                                    } else {
                                                        int i58 = i56 - i57;
                                                        i33 = i16 + i58;
                                                        i34 = i58 + i57;
                                                        i35 = 0;
                                                    }
                                                    if (i18 < 0) {
                                                        i37 = i13 - i18;
                                                        i36 = 0;
                                                        int i59 = i13 + i36;
                                                        i21 = i8 + i36;
                                                        i13 = i59;
                                                        i22 = i33;
                                                        i19 = i35;
                                                        i23 = i37;
                                                        i20 = i34;
                                                        bigInteger5 = BigInteger.valueOf(1L);
                                                    } else {
                                                        i36 = i18;
                                                    }
                                                }
                                                i37 = i13;
                                                int i592 = i13 + i36;
                                                i21 = i8 + i36;
                                                i13 = i592;
                                                i22 = i33;
                                                i19 = i35;
                                                i23 = i37;
                                                i20 = i34;
                                                bigInteger5 = BigInteger.valueOf(1L);
                                            } else {
                                                i19 = i15;
                                                i20 = i19;
                                                i21 = i8;
                                                i22 = i16;
                                                i23 = i13;
                                            }
                                            if (i23 > 0 && i21 > 0) {
                                                int i60 = i23 >= i21 ? i23 : i21;
                                                i13 -= i60;
                                                i23 -= i60;
                                                i21 -= i60;
                                            }
                                            if (i20 > 0) {
                                                if (z6) {
                                                    if (i19 > 0) {
                                                        bigInteger5 = pow5mult(bigInteger5, i19);
                                                        bigInteger2 = bigInteger5.multiply(bigInteger);
                                                    } else {
                                                        bigInteger2 = bigInteger;
                                                    }
                                                    i20 -= i19;
                                                } else {
                                                    bigInteger2 = bigInteger;
                                                }
                                                bigInteger3 = pow5mult(bigInteger2, i20);
                                                BigInteger valueOf = BigInteger.valueOf(1L);
                                                if (i22 > 0) {
                                                    valueOf = pow5mult(valueOf, i22);
                                                }
                                                if (i43 < 2 || word1(d4) != 0 || (word0(d4) & 1048575) != 0 || (word0(d4) & 2145386496) == 0) {
                                                    z7 = false;
                                                } else {
                                                    i13++;
                                                    i21++;
                                                    z7 = true;
                                                }
                                                byte[] byteArray = valueOf.toByteArray();
                                                int i61 = i18;
                                                i25 = 0;
                                                int i62 = 0;
                                                for (i24 = 4; i25 < i24; i24 = 4) {
                                                    int i63 = i62 << 8;
                                                    double d18 = d4;
                                                    if (i25 < byteArray.length) {
                                                        i63 |= byteArray[i25] & 255;
                                                    }
                                                    i62 = i63;
                                                    i25++;
                                                    d4 = d18;
                                                }
                                                double d19 = d4;
                                                hi0bits = ((i22 == 0 ? 32 - hi0bits(i62) : 1) + i21) & 31;
                                                if (hi0bits != 0) {
                                                    hi0bits = 32 - hi0bits;
                                                }
                                                if (hi0bits > 4) {
                                                    if (hi0bits < 4) {
                                                        i26 = hi0bits + 28;
                                                    }
                                                    i27 = i13;
                                                    if (i27 > 0) {
                                                        bigInteger3 = bigInteger3.shiftLeft(i27);
                                                    }
                                                    if (i21 > 0) {
                                                        valueOf = valueOf.shiftLeft(i21);
                                                    }
                                                    if (z2 || bigInteger3.compareTo(valueOf) >= 0) {
                                                        i28 = i61;
                                                    } else {
                                                        i17--;
                                                        bigInteger3 = bigInteger3.multiply(BigInteger.valueOf(10L));
                                                        if (z6) {
                                                            bigInteger5 = bigInteger5.multiply(BigInteger.valueOf(10L));
                                                        }
                                                        i28 = i11;
                                                    }
                                                    if (i28 > 0 && i43 > 2) {
                                                        if (i28 < 0 || (compareTo2 = bigInteger3.compareTo(valueOf.multiply(BigInteger.valueOf(5L)))) < 0) {
                                                            i31 = 1;
                                                            i32 = 0;
                                                        } else if (compareTo2 != 0 || z) {
                                                            sb.append('1');
                                                            return i17 + 1 + 1;
                                                        } else {
                                                            i32 = 0;
                                                            i31 = 1;
                                                        }
                                                        sb.setLength(i32);
                                                        sb.append('0');
                                                        return i31;
                                                    }
                                                    char c5 = 1;
                                                    if (z6) {
                                                        if (i23 > 0) {
                                                            bigInteger5 = bigInteger5.shiftLeft(i23);
                                                        }
                                                        BigInteger shiftLeft = z7 ? bigInteger5.shiftLeft(1) : bigInteger5;
                                                        int i64 = 1;
                                                        while (true) {
                                                            BigInteger[] divideAndRemainder = bigInteger3.divideAndRemainder(valueOf);
                                                            bigInteger4 = divideAndRemainder[c5];
                                                            c2 = (char) (divideAndRemainder[0].intValue() + 48);
                                                            int compareTo3 = bigInteger4.compareTo(bigInteger5);
                                                            BigInteger subtract = valueOf.subtract(shiftLeft);
                                                            int compareTo4 = subtract.signum() <= 0 ? 1 : bigInteger4.compareTo(subtract);
                                                            if (compareTo4 == 0 && i43 == 0) {
                                                                i30 = 1;
                                                                if ((word1(d19) & 1) == 0) {
                                                                    if (c2 != '9') {
                                                                        if (compareTo3 > 0) {
                                                                            c2 = (char) (c2 + 1);
                                                                        }
                                                                        sb.append(c2);
                                                                        return i17 + 1;
                                                                    }
                                                                    sb.append('9');
                                                                    if (roundOff(sb)) {
                                                                        i17++;
                                                                        sb.append('1');
                                                                    }
                                                                    return i17 + 1;
                                                                }
                                                            } else {
                                                                i30 = 1;
                                                            }
                                                            if (compareTo3 < 0 || (compareTo3 == 0 && i43 == 0 && (word1(d19) & i30) == 0)) {
                                                                break;
                                                            } else if (compareTo4 > 0) {
                                                                if (c2 != '9') {
                                                                    sb.append((char) (c2 + 1));
                                                                    return i17 + 1;
                                                                }
                                                                sb.append('9');
                                                                if (roundOff(sb)) {
                                                                    i17++;
                                                                    sb.append('1');
                                                                }
                                                                return i17 + 1;
                                                            } else {
                                                                sb.append(c2);
                                                                if (i64 == i28) {
                                                                    i29 = 1;
                                                                    break;
                                                                }
                                                                bigInteger3 = bigInteger4.multiply(BigInteger.valueOf(10L));
                                                                if (bigInteger5 == shiftLeft) {
                                                                    bigInteger5 = shiftLeft.multiply(BigInteger.valueOf(10L));
                                                                    shiftLeft = bigInteger5;
                                                                } else {
                                                                    bigInteger5 = bigInteger5.multiply(BigInteger.valueOf(10L));
                                                                    shiftLeft = shiftLeft.multiply(BigInteger.valueOf(10L));
                                                                }
                                                                i64++;
                                                                c5 = 1;
                                                            }
                                                        }
                                                    } else {
                                                        i29 = 1;
                                                        int i65 = 1;
                                                        while (true) {
                                                            BigInteger[] divideAndRemainder2 = bigInteger3.divideAndRemainder(valueOf);
                                                            bigInteger4 = divideAndRemainder2[1];
                                                            intValue = (char) (divideAndRemainder2[0].intValue() + 48);
                                                            sb.append(intValue);
                                                            if (i65 >= i28) {
                                                                break;
                                                            }
                                                            i65++;
                                                            bigInteger3 = bigInteger4.multiply(BigInteger.valueOf(10L));
                                                        }
                                                        c2 = intValue;
                                                    }
                                                    compareTo = bigInteger4.shiftLeft(i29).compareTo(valueOf);
                                                    if (compareTo > 0 && !(compareTo == 0 && ((c2 & 1) == i29 || z))) {
                                                        stripTrailingZeroes(sb);
                                                    } else if (roundOff(sb)) {
                                                        sb.append('1');
                                                        return i17 + i29 + i29;
                                                    }
                                                    return i17 + i29;
                                                }
                                                i26 = hi0bits - 4;
                                                i13 += i26;
                                                i23 += i26;
                                                i21 += i26;
                                                i27 = i13;
                                                if (i27 > 0) {
                                                }
                                                if (i21 > 0) {
                                                }
                                                if (z2) {
                                                }
                                                i28 = i61;
                                                if (i28 > 0) {
                                                }
                                                char c52 = 1;
                                                if (z6) {
                                                }
                                                compareTo = bigInteger4.shiftLeft(i29).compareTo(valueOf);
                                                if (compareTo > 0) {
                                                }
                                                if (roundOff(sb)) {
                                                }
                                                return i17 + i29;
                                            }
                                            bigInteger2 = bigInteger;
                                            bigInteger3 = bigInteger2;
                                            BigInteger valueOf2 = BigInteger.valueOf(1L);
                                            if (i22 > 0) {
                                            }
                                            if (i43 < 2) {
                                            }
                                            z7 = false;
                                            byte[] byteArray2 = valueOf2.toByteArray();
                                            int i612 = i18;
                                            i25 = 0;
                                            int i622 = 0;
                                            while (i25 < i24) {
                                            }
                                            double d192 = d4;
                                            hi0bits = ((i22 == 0 ? 32 - hi0bits(i622) : 1) + i21) & 31;
                                            if (hi0bits != 0) {
                                            }
                                            if (hi0bits > 4) {
                                            }
                                            i13 += i26;
                                            i23 += i26;
                                            i21 += i26;
                                            i27 = i13;
                                            if (i27 > 0) {
                                            }
                                            if (i21 > 0) {
                                            }
                                            if (z2) {
                                            }
                                            i28 = i612;
                                            if (i28 > 0) {
                                            }
                                            char c522 = 1;
                                            if (z6) {
                                            }
                                            compareTo = bigInteger4.shiftLeft(i29).compareTo(valueOf2);
                                            if (compareTo > 0) {
                                            }
                                            if (roundOff(sb)) {
                                            }
                                            return i17 + i29;
                                        }
                                        sb.setLength(0);
                                    }
                                    i41 = i39;
                                    i12 = i17;
                                    double d102 = (i41 * d5) + 7.0d;
                                    double word032 = setWord0(d102, word0(d102) - 54525952);
                                    if (i40 != 0) {
                                    }
                                    if (z8) {
                                    }
                                    c = 0;
                                    if (z8) {
                                    }
                                }
                                i17 = i12;
                                d4 = d3;
                                i18 = i14;
                                if (iArr[c] < 0) {
                                }
                                BigInteger bigInteger52 = null;
                                if (z6) {
                                }
                                if (i23 > 0) {
                                    if (i23 >= i21) {
                                    }
                                    i13 -= i60;
                                    i23 -= i60;
                                    i21 -= i60;
                                }
                                if (i20 > 0) {
                                }
                                bigInteger3 = bigInteger2;
                                BigInteger valueOf22 = BigInteger.valueOf(1L);
                                if (i22 > 0) {
                                }
                                if (i43 < 2) {
                                }
                                z7 = false;
                                byte[] byteArray22 = valueOf22.toByteArray();
                                int i6122 = i18;
                                i25 = 0;
                                int i6222 = 0;
                                while (i25 < i24) {
                                }
                                double d1922 = d4;
                                hi0bits = ((i22 == 0 ? 32 - hi0bits(i6222) : 1) + i21) & 31;
                                if (hi0bits != 0) {
                                }
                                if (hi0bits > 4) {
                                }
                                i13 += i26;
                                i23 += i26;
                                i21 += i26;
                                i27 = i13;
                                if (i27 > 0) {
                                }
                                if (i21 > 0) {
                                }
                                if (z2) {
                                }
                                i28 = i6122;
                                if (i28 > 0) {
                                }
                                char c5222 = 1;
                                if (z6) {
                                }
                                compareTo = bigInteger4.shiftLeft(i29).compareTo(valueOf22);
                                if (compareTo > 0) {
                                }
                                if (roundOff(sb)) {
                                }
                                return i17 + i29;
                            }
                            z9 = true;
                        }
                        int i66 = i2 + i4 + 1;
                        i8 = i46;
                        i11 = i66 - 1;
                        z4 = z9;
                        i10 = i2;
                        bigInteger = d2b;
                        i9 = i66;
                        if (i9 >= 0) {
                        }
                        i12 = i4;
                        iArr2 = iArr4;
                        i13 = i5;
                        z5 = z10;
                        d3 = d2;
                        i14 = i9;
                        i15 = i6;
                        i16 = i7;
                        z6 = z4;
                        c = 0;
                        i17 = i12;
                        d4 = d3;
                        i18 = i14;
                        if (iArr[c] < 0) {
                        }
                        BigInteger bigInteger522 = null;
                        if (z6) {
                        }
                        if (i23 > 0) {
                        }
                        if (i20 > 0) {
                        }
                        bigInteger3 = bigInteger2;
                        BigInteger valueOf222 = BigInteger.valueOf(1L);
                        if (i22 > 0) {
                        }
                        if (i43 < 2) {
                        }
                        z7 = false;
                        byte[] byteArray222 = valueOf222.toByteArray();
                        int i61222 = i18;
                        i25 = 0;
                        int i62222 = 0;
                        while (i25 < i24) {
                        }
                        double d19222 = d4;
                        hi0bits = ((i22 == 0 ? 32 - hi0bits(i62222) : 1) + i21) & 31;
                        if (hi0bits != 0) {
                        }
                        if (hi0bits > 4) {
                        }
                        i13 += i26;
                        i23 += i26;
                        i21 += i26;
                        i27 = i13;
                        if (i27 > 0) {
                        }
                        if (i21 > 0) {
                        }
                        if (z2) {
                        }
                        i28 = i61222;
                        if (i28 > 0) {
                        }
                        char c52222 = 1;
                        if (z6) {
                        }
                        compareTo = bigInteger4.shiftLeft(i29).compareTo(valueOf222);
                        if (compareTo > 0) {
                        }
                        if (roundOff(sb)) {
                        }
                        return i17 + i29;
                    }
                    z4 = false;
                    i10 = i2 <= 0 ? 1 : i2;
                    bigInteger = d2b;
                    i8 = i46;
                    i9 = i10;
                    i11 = i9;
                    if (i9 >= 0) {
                    }
                    i12 = i4;
                    iArr2 = iArr4;
                    i13 = i5;
                    z5 = z10;
                    d3 = d2;
                    i14 = i9;
                    i15 = i6;
                    i16 = i7;
                    z6 = z4;
                    c = 0;
                    i17 = i12;
                    d4 = d3;
                    i18 = i14;
                    if (iArr[c] < 0) {
                    }
                    BigInteger bigInteger5222 = null;
                    if (z6) {
                    }
                    if (i23 > 0) {
                    }
                    if (i20 > 0) {
                    }
                    bigInteger3 = bigInteger2;
                    BigInteger valueOf2222 = BigInteger.valueOf(1L);
                    if (i22 > 0) {
                    }
                    if (i43 < 2) {
                    }
                    z7 = false;
                    byte[] byteArray2222 = valueOf2222.toByteArray();
                    int i612222 = i18;
                    i25 = 0;
                    int i622222 = 0;
                    while (i25 < i24) {
                    }
                    double d192222 = d4;
                    hi0bits = ((i22 == 0 ? 32 - hi0bits(i622222) : 1) + i21) & 31;
                    if (hi0bits != 0) {
                    }
                    if (hi0bits > 4) {
                    }
                    i13 += i26;
                    i23 += i26;
                    i21 += i26;
                    i27 = i13;
                    if (i27 > 0) {
                    }
                    if (i21 > 0) {
                    }
                    if (z2) {
                    }
                    i28 = i612222;
                    if (i28 > 0) {
                    }
                    char c522222 = 1;
                    if (z6) {
                    }
                    compareTo = bigInteger4.shiftLeft(i29).compareTo(valueOf2222);
                    if (compareTo > 0) {
                    }
                    if (roundOff(sb)) {
                    }
                    return i17 + i29;
                }
            }
            bigInteger = d2b;
            i8 = i46;
            i9 = -1;
            i10 = 0;
            z4 = true;
            i11 = -1;
            if (i9 >= 0) {
            }
            i12 = i4;
            iArr2 = iArr4;
            i13 = i5;
            z5 = z10;
            d3 = d2;
            i14 = i9;
            i15 = i6;
            i16 = i7;
            z6 = z4;
            c = 0;
            i17 = i12;
            d4 = d3;
            i18 = i14;
            if (iArr[c] < 0) {
            }
            BigInteger bigInteger52222 = null;
            if (z6) {
            }
            if (i23 > 0) {
            }
            if (i20 > 0) {
            }
            bigInteger3 = bigInteger2;
            BigInteger valueOf22222 = BigInteger.valueOf(1L);
            if (i22 > 0) {
            }
            if (i43 < 2) {
            }
            z7 = false;
            byte[] byteArray22222 = valueOf22222.toByteArray();
            int i6122222 = i18;
            i25 = 0;
            int i6222222 = 0;
            while (i25 < i24) {
            }
            double d1922222 = d4;
            hi0bits = ((i22 == 0 ? 32 - hi0bits(i6222222) : 1) + i21) & 31;
            if (hi0bits != 0) {
            }
            if (hi0bits > 4) {
            }
            i13 += i26;
            i23 += i26;
            i21 += i26;
            i27 = i13;
            if (i27 > 0) {
            }
            if (i21 > 0) {
            }
            if (z2) {
            }
            i28 = i6122222;
            if (i28 > 0) {
            }
            char c5222222 = 1;
            if (z6) {
            }
            compareTo = bigInteger4.shiftLeft(i29).compareTo(valueOf22222);
            if (compareTo > 0) {
            }
            if (roundOff(sb)) {
            }
            return i17 + i29;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0114, code lost:
        if (r7 > 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0120, code lost:
        if (r9 > 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x012d, code lost:
        if (r6.compareTo(r3) > 0) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0140 A[LOOP:0: B:40:0x00d8->B:53:0x0140, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String JS_dtobasestr(int i, double d) {
        boolean z;
        String bigInteger;
        BigInteger bigInteger2;
        if (2 > i || i > 36) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bad base: ", i));
        }
        if (Double.isNaN(d)) {
            return "NaN";
        }
        if (Double.isInfinite(d)) {
            return d > RoundRectDrawableWithShadow.COS_45 ? "Infinity" : "-Infinity";
        }
        int i2 = (d > RoundRectDrawableWithShadow.COS_45 ? 1 : (d == RoundRectDrawableWithShadow.COS_45 ? 0 : -1));
        if (i2 == 0) {
            return "0";
        }
        if (i2 >= 0) {
            z = false;
        } else {
            d = -d;
            z = true;
        }
        double floor = Math.floor(d);
        long j = (long) floor;
        if (j == floor) {
            if (z) {
                j = -j;
            }
            bigInteger = Long.toString(j, i);
        } else {
            long doubleToLongBits = Double.doubleToLongBits(floor);
            int i3 = ((int) (doubleToLongBits >> 52)) & Exp_mask_shifted;
            long j2 = doubleToLongBits & 4503599627370495L;
            long j3 = i3 == 0 ? j2 << 1 : j2 | 4503599627370496L;
            if (z) {
                j3 = -j3;
            }
            int i4 = i3 - 1075;
            BigInteger valueOf = BigInteger.valueOf(j3);
            if (i4 > 0) {
                valueOf = valueOf.shiftLeft(i4);
            } else if (i4 < 0) {
                valueOf = valueOf.shiftRight(-i4);
            }
            bigInteger = valueOf.toString(i);
        }
        if (d == floor) {
            return bigInteger;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bigInteger);
        sb.append('.');
        double d2 = d - floor;
        long doubleToLongBits2 = Double.doubleToLongBits(d);
        int i5 = (int) (doubleToLongBits2 >> 32);
        int i6 = (int) doubleToLongBits2;
        int[] iArr = new int[1];
        BigInteger d2b = d2b(d2, iArr, new int[1]);
        int i7 = -((i5 >>> 20) & Exp_mask_shifted);
        if (i7 == 0) {
            i7 = -1;
        }
        int i8 = i7 + 1076;
        BigInteger valueOf2 = BigInteger.valueOf(1L);
        if (i6 == 0 && (1048575 & i5) == 0 && (i5 & 2145386496) != 0) {
            i8++;
            bigInteger2 = BigInteger.valueOf(2L);
        } else {
            bigInteger2 = valueOf2;
        }
        BigInteger shiftLeft = d2b.shiftLeft(iArr[0] + i8);
        BigInteger shiftLeft2 = BigInteger.valueOf(1L).shiftLeft(i8);
        BigInteger valueOf3 = BigInteger.valueOf(i);
        boolean z2 = false;
        while (true) {
            BigInteger[] divideAndRemainder = shiftLeft.multiply(valueOf3).divideAndRemainder(shiftLeft2);
            BigInteger bigInteger3 = divideAndRemainder[1];
            int intValue = (char) divideAndRemainder[0].intValue();
            if (valueOf2 == bigInteger2) {
                bigInteger2 = valueOf2.multiply(valueOf3);
                valueOf2 = bigInteger2;
            } else {
                BigInteger multiply = valueOf2.multiply(valueOf3);
                bigInteger2 = bigInteger2.multiply(valueOf3);
                valueOf2 = multiply;
            }
            int compareTo = bigInteger3.compareTo(valueOf2);
            BigInteger subtract = shiftLeft2.subtract(bigInteger2);
            int compareTo2 = subtract.signum() <= 0 ? 1 : bigInteger3.compareTo(subtract);
            if (compareTo2 != 0 || (i6 & 1) != 0) {
                if (compareTo < 0 || (compareTo == 0 && (i6 & 1) == 0)) {
                    if (compareTo2 > 0) {
                        bigInteger3 = bigInteger3.shiftLeft(1);
                    }
                    z2 = true;
                    sb.append(BASEDIGIT(intValue));
                    if (!z2) {
                        return sb.toString();
                    }
                    shiftLeft = bigInteger3;
                }
                intValue++;
                z2 = true;
                sb.append(BASEDIGIT(intValue));
                if (!z2) {
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0045, code lost:
        if (r1 <= r13) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005f A[LOOP:0: B:25:0x005f->B:26:0x0066, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void JS_dtostr(StringBuilder sb, int i, int i2, double d) {
        boolean z;
        boolean[] zArr = new boolean[1];
        if (i == 2 && (d >= 1.0E21d || d <= -1.0E21d)) {
            i = 0;
        }
        int JS_dtoa = JS_dtoa(d, dtoaModes[i], i >= 2, i2, zArr, sb);
        int length = sb.length();
        if (JS_dtoa != 9999) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        if (i2 >= 0) {
                            i2 += JS_dtoa;
                        }
                        i2 = JS_dtoa;
                    } else if (i != 3) {
                        if (i != 4) {
                            z = false;
                            i2 = 0;
                            if (length < i2) {
                                do {
                                    sb.append('0');
                                } while (sb.length() != i2);
                                length = i2;
                            }
                            if (z) {
                                if (length != 1) {
                                    sb.insert(1, '.');
                                }
                                sb.append('e');
                                int i3 = JS_dtoa - 1;
                                if (i3 >= 0) {
                                    sb.append('+');
                                }
                                sb.append(i3);
                            } else if (JS_dtoa != length) {
                                if (JS_dtoa > 0) {
                                    sb.insert(JS_dtoa, '.');
                                } else {
                                    for (int i4 = 0; i4 < 1 - JS_dtoa; i4++) {
                                        sb.insert(0, '0');
                                    }
                                    sb.insert(1, '.');
                                }
                            }
                        } else if (JS_dtoa >= -5) {
                        }
                    }
                    z = false;
                    if (length < i2) {
                    }
                    if (z) {
                    }
                } else {
                    i2 = 0;
                }
                z = true;
                if (length < i2) {
                }
                if (z) {
                }
            } else {
                if (JS_dtoa < -5 || JS_dtoa > 21) {
                    z = true;
                    i2 = 0;
                    if (length < i2) {
                    }
                    if (z) {
                    }
                }
                i2 = JS_dtoa;
                z = false;
                if (length < i2) {
                }
                if (z) {
                }
            }
        }
        if (zArr[0]) {
            if (word0(d) == Integer.MIN_VALUE && word1(d) == 0) {
                return;
            }
            if ((word0(d) & Exp_mask) == 2146435072 && (word1(d) != 0 || (word0(d) & 1048575) != 0)) {
                return;
            }
            sb.insert(0, '-');
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BigInteger d2b(double d, int[] iArr, int[] iArr2) {
        byte[] bArr;
        int i;
        int i2;
        long doubleToLongBits = Double.doubleToLongBits(d);
        int i3 = (int) (doubleToLongBits >>> 32);
        int i4 = (int) doubleToLongBits;
        int i5 = 1048575 & i3;
        int i6 = (Integer.MAX_VALUE & i3) >>> 20;
        if (i6 != 0) {
            i5 |= 1048576;
        }
        if (i4 != 0) {
            bArr = new byte[8];
            i = lo0bits(i4);
            int i7 = i4 >>> i;
            if (i != 0) {
                stuffBits(bArr, 4, i7 | (i5 << (32 - i)));
                i5 >>= i;
            } else {
                stuffBits(bArr, 4, i7);
            }
            stuffBits(bArr, 0, i5);
            if (i5 != 0) {
                i2 = 2;
                if (i6 == 0) {
                    iArr[0] = ((i6 - 1023) - 52) + i;
                    iArr2[0] = 53 - i;
                } else {
                    iArr[0] = ((i6 - 1023) - 52) + 1 + i;
                    iArr2[0] = (i2 * 32) - hi0bits(i5);
                }
                return new BigInteger(bArr);
            }
        } else {
            bArr = new byte[4];
            int lo0bits = lo0bits(i5);
            i5 >>>= lo0bits;
            stuffBits(bArr, 0, i5);
            i = lo0bits + 32;
        }
        i2 = 1;
        if (i6 == 0) {
        }
        return new BigInteger(bArr);
    }

    public static int hi0bits(int i) {
        int i2;
        if (((-65536) & i) == 0) {
            i <<= 16;
            i2 = 16;
        } else {
            i2 = 0;
        }
        if (((-16777216) & i) == 0) {
            i2 += 8;
            i <<= 8;
        }
        if (((-268435456) & i) == 0) {
            i2 += 4;
            i <<= 4;
        }
        if (((-1073741824) & i) == 0) {
            i2 += 2;
            i <<= 2;
        }
        if ((Integer.MIN_VALUE & i) == 0) {
            i2++;
            if ((i & 1073741824) == 0) {
                return 32;
            }
        }
        return i2;
    }

    public static int lo0bits(int i) {
        int i2 = 0;
        if ((i & 7) != 0) {
            if ((i & 1) != 0) {
                return 0;
            }
            return (i & 2) != 0 ? 1 : 2;
        }
        if ((65535 & i) == 0) {
            i >>>= 16;
            i2 = 16;
        }
        if ((i & 255) == 0) {
            i2 += 8;
            i >>>= 8;
        }
        if ((i & 15) == 0) {
            i2 += 4;
            i >>>= 4;
        }
        if ((i & 3) == 0) {
            i2 += 2;
            i >>>= 2;
        }
        if ((i & 1) == 0) {
            i2++;
            if (((i >>> 1) & 1) == 0) {
                return 32;
            }
        }
        return i2;
    }

    public static BigInteger pow5mult(BigInteger bigInteger, int i) {
        return bigInteger.multiply(BigInteger.valueOf(5L).pow(i));
    }

    public static boolean roundOff(StringBuilder sb) {
        int length = sb.length();
        while (length != 0) {
            length--;
            char charAt = sb.charAt(length);
            if (charAt != '9') {
                sb.setCharAt(length, (char) (charAt + 1));
                sb.setLength(length + 1);
                return false;
            }
        }
        sb.setLength(0);
        return true;
    }

    public static double setWord0(double d, int i) {
        return Double.longBitsToDouble((Double.doubleToLongBits(d) & 4294967295L) | (i << 32));
    }

    public static void stripTrailingZeroes(StringBuilder sb) {
        int i;
        int length = sb.length();
        while (true) {
            i = length - 1;
            if (length <= 0 || sb.charAt(i) != '0') {
                break;
            }
            length = i;
        }
        sb.setLength(i + 1);
    }

    public static void stuffBits(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    public static int word0(double d) {
        return (int) (Double.doubleToLongBits(d) >> 32);
    }

    public static int word1(double d) {
        return (int) Double.doubleToLongBits(d);
    }
}
