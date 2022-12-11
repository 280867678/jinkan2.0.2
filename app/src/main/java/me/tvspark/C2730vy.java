package me.tvspark;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.math.RoundingMode;

/* renamed from: me.tvspark.vy */
/* loaded from: classes4.dex */
public final class C2730vy {

    /* renamed from: me.tvspark.vy$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final /* synthetic */ int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        Math.log(2.0d);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double d) {
        if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d)) {
            if (d == RoundRectDrawableWithShadow.COS_45) {
                return true;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d), "not a normal value");
            int exponent = Math.getExponent(d);
            long doubleToRawLongBits = Double.doubleToRawLongBits(d) & 4503599627370495L;
            if (52 - Long.numberOfTrailingZeros(exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | 4503599627370496L) <= Math.getExponent(d)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002a, code lost:
        if (java.lang.Math.abs(r9 - r0) == 0.5d) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double d, RoundingMode roundingMode) {
        long j;
        double d2;
        if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d)) {
            boolean z = true;
            switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[roundingMode.ordinal()]) {
                case 1:
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d));
                    d2 = d;
                    break;
                case 2:
                    if (d < RoundRectDrawableWithShadow.COS_45 && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d)) {
                        j = ((long) d) - 1;
                        d2 = j;
                        break;
                    }
                    d2 = d;
                    break;
                case 3:
                    if (d > RoundRectDrawableWithShadow.COS_45 && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d)) {
                        j = ((long) d) + 1;
                        d2 = j;
                        break;
                    }
                    d2 = d;
                    break;
                case 4:
                    d2 = d;
                    break;
                case 5:
                    if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d)) {
                        d2 = ((long) d) + (d > RoundRectDrawableWithShadow.COS_45 ? 1 : -1);
                        break;
                    }
                    d2 = d;
                    break;
                case 6:
                    d2 = Math.rint(d);
                    break;
                case 7:
                    d2 = Math.rint(d);
                    if (Math.abs(d - d2) == 0.5d) {
                        d2 = Math.copySign(0.5d, d) + d;
                        break;
                    }
                    break;
                case 8:
                    d2 = Math.rint(d);
                    break;
                default:
                    throw new AssertionError();
            }
            boolean z2 = (-9.223372036854776E18d) - d2 < 1.0d;
            if (d2 >= 9.223372036854776E18d) {
                z = false;
            }
            if (z2 && z) {
                return (long) d2;
            }
            throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + roundingMode);
        }
        throw new ArithmeticException("input is infinite or NaN");
    }
}
