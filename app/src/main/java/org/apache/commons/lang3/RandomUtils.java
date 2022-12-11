package org.apache.commons.lang3;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.util.Random;

/* loaded from: classes4.dex */
public class RandomUtils {
    public static final Random RANDOM = new Random();

    public static byte[] nextBytes(int i) {
        Validate.isTrue(i >= 0, "Count cannot be negative.", new Object[0]);
        byte[] bArr = new byte[i];
        RANDOM.nextBytes(bArr);
        return bArr;
    }

    public static double nextDouble(double d, double d2) {
        boolean z = true;
        Validate.isTrue(d2 >= d, "Start value must be smaller or equal to end value.", new Object[0]);
        if (d < RoundRectDrawableWithShadow.COS_45) {
            z = false;
        }
        Validate.isTrue(z, "Both range values must be non-negative.", new Object[0]);
        if (d == d2) {
            return d;
        }
        return (RANDOM.nextDouble() * (d2 - d)) + d;
    }

    public static float nextFloat(float f, float f2) {
        boolean z = true;
        Validate.isTrue(f2 >= f, "Start value must be smaller or equal to end value.", new Object[0]);
        if (f < 0.0f) {
            z = false;
        }
        Validate.isTrue(z, "Both range values must be non-negative.", new Object[0]);
        if (f == f2) {
            return f;
        }
        return (RANDOM.nextFloat() * (f2 - f)) + f;
    }

    public static int nextInt(int i, int i2) {
        boolean z = true;
        Validate.isTrue(i2 >= i, "Start value must be smaller or equal to end value.", new Object[0]);
        if (i < 0) {
            z = false;
        }
        Validate.isTrue(z, "Both range values must be non-negative.", new Object[0]);
        return i == i2 ? i : RANDOM.nextInt(i2 - i) + i;
    }

    public static long nextLong(long j, long j2) {
        boolean z = true;
        Validate.isTrue(j2 >= j, "Start value must be smaller or equal to end value.", new Object[0]);
        if (j < 0) {
            z = false;
        }
        Validate.isTrue(z, "Both range values must be non-negative.", new Object[0]);
        return j == j2 ? j : (long) nextDouble(j, j2);
    }
}
