package org.mozilla.javascript.v8dtoa;

import androidx.cardview.widget.RoundRectDrawableWithShadow;

/* loaded from: classes5.dex */
public class FastDtoa {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int kFastDtoaMaximalLength = 17;
    public static final int kTen4 = 10000;
    public static final int kTen5 = 100000;
    public static final int kTen6 = 1000000;
    public static final int kTen7 = 10000000;
    public static final int kTen8 = 100000000;
    public static final int kTen9 = 1000000000;
    public static final int maximal_target_exponent = -32;
    public static final int minimal_target_exponent = -60;

    public static long biggestPowerTen(int i, int i2) {
        int i3 = kTen9;
        int i4 = 1;
        switch (i2) {
            case 30:
            case 31:
            case 32:
                if (1000000000 <= i) {
                    i4 = 9;
                    break;
                }
            case 27:
            case 28:
            case 29:
                if (100000000 <= i) {
                    i4 = 8;
                    i3 = kTen8;
                    break;
                }
            case 24:
            case 25:
            case 26:
                if (10000000 <= i) {
                    i4 = 7;
                    i3 = kTen7;
                    break;
                }
            case 20:
            case 21:
            case 22:
            case 23:
                if (1000000 <= i) {
                    i4 = 6;
                    i3 = 1000000;
                    break;
                }
            case 17:
            case 18:
            case 19:
                if (100000 <= i) {
                    i4 = 5;
                    i3 = kTen5;
                    break;
                }
            case 14:
            case 15:
            case 16:
                if (10000 <= i) {
                    i4 = 4;
                    i3 = 10000;
                    break;
                }
            case 10:
            case 11:
            case 12:
            case 13:
                if (1000 <= i) {
                    i4 = 3;
                    i3 = 1000;
                    break;
                }
            case 7:
            case 8:
            case 9:
                if (100 <= i) {
                    i4 = 2;
                    i3 = 100;
                    break;
                }
            case 4:
            case 5:
            case 6:
                if (10 <= i) {
                    i3 = 10;
                    break;
                }
            case 1:
            case 2:
            case 3:
                if (1 <= i) {
                    i3 = 1;
                    i4 = 0;
                    break;
                }
            case 0:
                i4 = -1;
                i3 = 0;
                break;
            default:
                i3 = 0;
                i4 = 0;
                break;
        }
        return (i3 << 32) | (4294967295L & i4);
    }

    public static boolean digitGen(DiyFp diyFp, DiyFp diyFp2, DiyFp diyFp3, FastDtoaBuilder fastDtoaBuilder, int i) {
        FastDtoaBuilder fastDtoaBuilder2;
        long m13f;
        long j;
        long j2;
        long m13f2;
        long j3;
        DiyFp diyFp4 = new DiyFp(diyFp.m13f() - 1, diyFp.m14e());
        DiyFp diyFp5 = new DiyFp(diyFp3.m13f() + 1, diyFp3.m14e());
        DiyFp minus = DiyFp.minus(diyFp5, diyFp4);
        DiyFp diyFp6 = new DiyFp(1 << (-diyFp2.m14e()), diyFp2.m14e());
        int m13f3 = (int) ((diyFp5.m13f() >>> (-diyFp6.m14e())) & 4294967295L);
        long m13f4 = diyFp5.m13f() & (diyFp6.m13f() - 1);
        long biggestPowerTen = biggestPowerTen(m13f3, 64 - (-diyFp6.m14e()));
        int i2 = (int) ((biggestPowerTen >>> 32) & 4294967295L);
        int i3 = ((int) (biggestPowerTen & 4294967295L)) + 1;
        while (true) {
            if (i3 > 0) {
                fastDtoaBuilder.append((char) ((m13f3 / i2) + 48));
                m13f3 %= i2;
                i3--;
                long j4 = (m13f3 << (-diyFp6.m14e())) + m13f4;
                if (j4 < minus.m13f()) {
                    fastDtoaBuilder.point = (fastDtoaBuilder.end - i) + i3;
                    long m13f5 = DiyFp.minus(diyFp5, diyFp2).m13f();
                    fastDtoaBuilder2 = fastDtoaBuilder;
                    m13f = m13f5;
                    j = minus.m13f();
                    j2 = j4;
                    m13f2 = i2 << (-diyFp6.m14e());
                    j3 = 1;
                    break;
                }
                i2 /= 10;
            } else {
                long j5 = 1;
                while (true) {
                    long j6 = m13f4 * 5;
                    j5 *= 5;
                    minus.setF(minus.m13f() * 5);
                    minus.setE(minus.m14e() + 1);
                    diyFp6.setF(diyFp6.m13f() >>> 1);
                    diyFp6.setE(diyFp6.m14e() + 1);
                    fastDtoaBuilder.append((char) (((int) ((j6 >>> (-diyFp6.m14e())) & 4294967295L)) + 48));
                    m13f4 = j6 & (diyFp6.m13f() - 1);
                    i3--;
                    if (m13f4 < minus.m13f()) {
                        break;
                    }
                }
                fastDtoaBuilder.point = (fastDtoaBuilder.end - i) + i3;
                long m13f6 = minus.m13f();
                fastDtoaBuilder2 = fastDtoaBuilder;
                m13f = DiyFp.minus(diyFp5, diyFp2).m13f() * j5;
                j = m13f6;
                j2 = m13f4;
                m13f2 = diyFp6.m13f();
                j3 = j5;
            }
        }
        return roundWeed(fastDtoaBuilder2, m13f, j, j2, m13f2, j3);
    }

    public static boolean dtoa(double d, FastDtoaBuilder fastDtoaBuilder) {
        return grisu3(d, fastDtoaBuilder);
    }

    public static boolean grisu3(double d, FastDtoaBuilder fastDtoaBuilder) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        DiyFp asNormalizedDiyFp = DoubleHelper.asNormalizedDiyFp(doubleToLongBits);
        DiyFp diyFp = new DiyFp();
        DiyFp diyFp2 = new DiyFp();
        DoubleHelper.normalizedBoundaries(doubleToLongBits, diyFp, diyFp2);
        DiyFp diyFp3 = new DiyFp();
        int cachedPower = CachedPowers.getCachedPower(asNormalizedDiyFp.m14e() + 64, -60, -32, diyFp3);
        return digitGen(DiyFp.times(diyFp, diyFp3), DiyFp.times(asNormalizedDiyFp, diyFp3), DiyFp.times(diyFp2, diyFp3), fastDtoaBuilder, cachedPower);
    }

    public static String numberToString(double d) {
        FastDtoaBuilder fastDtoaBuilder = new FastDtoaBuilder();
        if (numberToString(d, fastDtoaBuilder)) {
            return fastDtoaBuilder.format();
        }
        return null;
    }

    public static boolean numberToString(double d, FastDtoaBuilder fastDtoaBuilder) {
        fastDtoaBuilder.reset();
        if (d < RoundRectDrawableWithShadow.COS_45) {
            fastDtoaBuilder.append('-');
            d = -d;
        }
        return dtoa(d, fastDtoaBuilder);
    }

    public static boolean roundWeed(FastDtoaBuilder fastDtoaBuilder, long j, long j2, long j3, long j4, long j5) {
        long j6 = j - j5;
        long j7 = j + j5;
        long j8 = j3;
        while (j8 < j6 && j2 - j8 >= j4) {
            long j9 = j8 + j4;
            if (j9 >= j6 && j6 - j8 < j9 - j6) {
                break;
            }
            fastDtoaBuilder.decreaseLast();
            j8 = j9;
        }
        if (j8 < j7 && j2 - j8 >= j4) {
            long j10 = j8 + j4;
            if (j10 < j7 || j7 - j8 > j10 - j7) {
                return false;
            }
        }
        return 2 * j5 <= j8 && j8 <= j2 - (4 * j5);
    }

    public static boolean uint64_lte(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i != 0) {
            if (!(((j < 0) ^ (i < 0)) ^ (j2 < 0))) {
                return false;
            }
        }
        return true;
    }
}
