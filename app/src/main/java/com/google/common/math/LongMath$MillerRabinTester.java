package com.google.common.math;

import me.tvspark.C2841yy;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public enum LongMath$MillerRabinTester {
    SMALL { // from class: com.google.common.math.LongMath$MillerRabinTester.1
        @Override // com.google.common.math.LongMath$MillerRabinTester
        public long mulMod(long j, long j2, long j3) {
            return (j * j2) % j3;
        }

        @Override // com.google.common.math.LongMath$MillerRabinTester
        public long squareMod(long j, long j2) {
            return (j * j) % j2;
        }
    },
    LARGE { // from class: com.google.common.math.LongMath$MillerRabinTester.2
        private long plusMod(long j, long j2, long j3) {
            int i = (j > (j3 - j2) ? 1 : (j == (j3 - j2) ? 0 : -1));
            long j4 = j + j2;
            return i >= 0 ? j4 - j3 : j4;
        }

        private long times2ToThe32Mod(long j, long j2) {
            int i = 32;
            do {
                int min = Math.min(i, Long.numberOfLeadingZeros(j));
                j = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j << min, j2);
                i -= min;
            } while (i > 0);
            return j;
        }

        @Override // com.google.common.math.LongMath$MillerRabinTester
        public long mulMod(long j, long j2, long j3) {
            long j4 = j >>> 32;
            long j5 = j2 >>> 32;
            long j6 = j & 4294967295L;
            long j7 = j2 & 4294967295L;
            long times2ToThe32Mod = (j4 * j7) + times2ToThe32Mod(j4 * j5, j3);
            if (times2ToThe32Mod < 0) {
                times2ToThe32Mod = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(times2ToThe32Mod, j3);
            }
            Long.signum(j6);
            return plusMod(times2ToThe32Mod((j5 * j6) + times2ToThe32Mod, j3), Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j6 * j7, j3), j3);
        }

        @Override // com.google.common.math.LongMath$MillerRabinTester
        public long squareMod(long j, long j2) {
            long j3 = j >>> 32;
            long j4 = j & 4294967295L;
            long times2ToThe32Mod = times2ToThe32Mod(j3 * j3, j2);
            long j5 = j3 * j4 * 2;
            if (j5 < 0) {
                j5 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j5, j2);
            }
            return plusMod(times2ToThe32Mod(times2ToThe32Mod + j5, j2), Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j4 * j4, j2), j2);
        }
    };

    /* synthetic */ LongMath$MillerRabinTester(C2841yy c2841yy) {
        this();
    }

    private long powMod(long j, long j2, long j3) {
        long j4 = 1;
        while (j2 != 0) {
            if ((j2 & 1) != 0) {
                j4 = mulMod(j4, j, j3);
            }
            j = squareMod(j, j3);
            j2 >>= 1;
        }
        return j4;
    }

    public static boolean test(long j, long j2) {
        return (j2 <= 3037000499L ? SMALL : LARGE).testWitness(j, j2);
    }

    private boolean testWitness(long j, long j2) {
        long j3 = j2 - 1;
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j3);
        long j4 = j3 >> numberOfTrailingZeros;
        long j5 = j % j2;
        if (j5 == 0) {
            return true;
        }
        long powMod = powMod(j5, j4, j2);
        if (powMod == 1) {
            return true;
        }
        int i = 0;
        while (powMod != j3) {
            i++;
            if (i == numberOfTrailingZeros) {
                return false;
            }
            powMod = squareMod(powMod, j2);
        }
        return true;
    }

    public abstract long mulMod(long j, long j2, long j3);

    public abstract long squareMod(long j, long j2);
}
