package org.mozilla.javascript.v8dtoa;

/* loaded from: classes5.dex */
public class DoubleHelper {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int kDenormalExponent = -1074;
    public static final int kExponentBias = 1075;
    public static final long kExponentMask = 9218868437227405312L;
    public static final long kHiddenBit = 4503599627370496L;
    public static final long kSignMask = Long.MIN_VALUE;
    public static final long kSignificandMask = 4503599627370495L;
    public static final int kSignificandSize = 52;

    public static DiyFp asDiyFp(long j) {
        return new DiyFp(significand(j), exponent(j));
    }

    public static DiyFp asNormalizedDiyFp(long j) {
        long significand = significand(j);
        int exponent = exponent(j);
        while ((4503599627370496L & significand) == 0) {
            significand <<= 1;
            exponent--;
        }
        return new DiyFp(significand << 11, exponent - 11);
    }

    public static int exponent(long j) {
        if (isDenormal(j)) {
            return -1074;
        }
        return ((int) (((j & 9218868437227405312L) >>> 52) & 4294967295L)) - 1075;
    }

    public static boolean isDenormal(long j) {
        return (j & 9218868437227405312L) == 0;
    }

    public static boolean isInfinite(long j) {
        return (j & 9218868437227405312L) == 9218868437227405312L && (j & 4503599627370495L) == 0;
    }

    public static boolean isNan(long j) {
        return (j & 9218868437227405312L) == 9218868437227405312L && (j & 4503599627370495L) != 0;
    }

    public static boolean isSpecial(long j) {
        return (j & 9218868437227405312L) == 9218868437227405312L;
    }

    public static void normalizedBoundaries(long j, DiyFp diyFp, DiyFp diyFp2) {
        long m13f;
        DiyFp asDiyFp = asDiyFp(j);
        int i = 1;
        boolean z = asDiyFp.m13f() == 4503599627370496L;
        diyFp2.setF((asDiyFp.m13f() << 1) + 1);
        diyFp2.setE(asDiyFp.m14e() - 1);
        diyFp2.normalize();
        if (!z || asDiyFp.m14e() == -1074) {
            m13f = asDiyFp.m13f();
        } else {
            m13f = asDiyFp.m13f();
            i = 2;
        }
        diyFp.setF((m13f << i) - 1);
        diyFp.setE(asDiyFp.m14e() - i);
        diyFp.setF(diyFp.m13f() << (diyFp.m14e() - diyFp2.m14e()));
        diyFp.setE(diyFp2.m14e());
    }

    public static int sign(long j) {
        return (j & Long.MIN_VALUE) == 0 ? 1 : -1;
    }

    public static long significand(long j) {
        long j2 = 4503599627370495L & j;
        return !isDenormal(j) ? j2 + 4503599627370496L : j2;
    }
}
