package me.tvspark;

import java.math.RoundingMode;

/* renamed from: me.tvspark.wy */
/* loaded from: classes4.dex */
public final class C2767wy {

    /* renamed from: me.tvspark.wy$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
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
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i + i2);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        long j = i + i2;
        int i3 = (int) j;
        if (j == ((long) i3)) {
            return i3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("overflow: ");
        sb.append("checkedAdd");
        sb.append("(");
        sb.append(i);
        sb.append(", ");
        throw new ArithmeticException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, i2, ")"));
    }
}
