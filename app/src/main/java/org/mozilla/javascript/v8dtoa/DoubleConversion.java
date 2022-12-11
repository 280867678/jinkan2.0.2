package org.mozilla.javascript.v8dtoa;

/* loaded from: classes5.dex */
public final class DoubleConversion {
    public static final int kDenormalExponent = -1074;
    public static final int kExponentBias = 1075;
    public static final long kExponentMask = 9218868437227405312L;
    public static final long kHiddenBit = 4503599627370496L;
    public static final int kPhysicalSignificandSize = 52;
    public static final long kSignMask = Long.MIN_VALUE;
    public static final long kSignificandMask = 4503599627370495L;
    public static final int kSignificandSize = 53;

    public static int doubleToInt32(double d) {
        int i = (int) d;
        if (i == d) {
            return i;
        }
        long doubleToLongBits = Double.doubleToLongBits(d);
        int exponent = exponent(doubleToLongBits);
        if (exponent <= -53 || exponent > 31) {
            return 0;
        }
        long significand = significand(doubleToLongBits);
        return sign(doubleToLongBits) * ((int) (exponent < 0 ? significand >> (-exponent) : significand << exponent));
    }

    public static int exponent(long j) {
        if (isDenormal(j)) {
            return -1074;
        }
        return ((int) ((j & 9218868437227405312L) >> 52)) - 1075;
    }

    public static boolean isDenormal(long j) {
        return (j & 9218868437227405312L) == 0;
    }

    public static int sign(long j) {
        return (j & Long.MIN_VALUE) == 0 ? 1 : -1;
    }

    public static long significand(long j) {
        long j2 = 4503599627370495L & j;
        return !isDenormal(j) ? j2 + 4503599627370496L : j2;
    }
}
