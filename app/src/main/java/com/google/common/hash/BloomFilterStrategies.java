package com.google.common.hash;

import com.google.common.hash.BloomFilter;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import me.tvspark.AbstractC2615sy;
import me.tvspark.C2841yy;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 { // from class: com.google.common.hash.BloomFilterStrategies.1
        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            long asLong = Hashing.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5 % Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            long asLong = Hashing.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            boolean z = false;
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                z |= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5 % Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return z;
        }
    },
    MURMUR128_MITZ_64 { // from class: com.google.common.hash.BloomFilterStrategies.2
        private long lowerEight(byte[] bArr) {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            byte[] bytesInternal = Hashing.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().hashObject(t, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            for (int i2 = 0; i2 < i; i2++) {
                if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Long.MAX_VALUE & lowerEight) % Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return false;
                }
                lowerEight += upperEight;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            byte[] bytesInternal = Hashing.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().hashObject(t, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            boolean z = false;
            for (int i2 = 0; i2 < i; i2++) {
                z |= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Long.MAX_VALUE & lowerEight) % Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                lowerEight += upperEight;
            }
            return z;
        }
    };

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final AbstractC2615sy Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AtomicLongArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
            if (r15 > 0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0059, code lost:
            if (r14 > 0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
            if (r14 < 0) goto L30;
         */
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            this(new long[r14]);
            boolean z;
            RoundingMode roundingMode = RoundingMode.CEILING;
            if (roundingMode != null) {
                long j2 = j / 64;
                long j3 = j - (j2 * 64);
                boolean z2 = false;
                int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
                if (i != 0) {
                    int i2 = ((int) ((j ^ 64) >> 63)) | 1;
                    switch (C2841yy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[roundingMode.ordinal()]) {
                        case 1:
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i == 0);
                        case 2:
                            z = false;
                            break;
                        case 3:
                            break;
                        case 4:
                            z = true;
                            break;
                        case 5:
                            break;
                        case 6:
                        case 7:
                        case 8:
                            long abs = Math.abs(j3);
                            int i3 = ((abs - (Math.abs(64L) - abs)) > 0L ? 1 : ((abs - (Math.abs(64L) - abs)) == 0L ? 0 : -1));
                            if (i3 == 0) {
                                z = (roundingMode == RoundingMode.HALF_UP) | ((roundingMode == RoundingMode.HALF_EVEN) & ((1 & j2) != 0));
                                break;
                            }
                            break;
                        default:
                            throw new AssertionError();
                    }
                    if (z) {
                        j2 += i2;
                    }
                }
                int i4 = (int) j2;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((long) i4) == j2 ? true : z2, "Out of range: %s", j2);
                return;
            }
            throw null;
        }

        public static long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = atomicLongArray.get(i);
            }
            return jArr;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            long j2;
            long j3;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j)) {
                return false;
            }
            int i = (int) (j >>> 6);
            long j4 = 1 << ((int) j);
            do {
                j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
                j3 = j2 | j4;
                if (j2 == j3) {
                    return false;
                }
            } while (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(i, j2, j3));
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.increment();
            return true;
        }

        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() * 64;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            return ((1 << ((int) j)) & this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get((int) (j >>> 6))) != 0;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return Arrays.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long[] jArr) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr.length > 0, "data length is zero!");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AtomicLongArray(jArr);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = LongAddables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4804get();
            long j = 0;
            for (long j2 : jArr) {
                j += Long.bitCount(j2);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(j);
        }
    }
}
