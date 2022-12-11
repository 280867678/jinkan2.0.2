package com.google.common.primitives;

import java.io.Serializable;
import java.math.BigInteger;
import me.tvspark.C1964bz;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {
    public static final long UNSIGNED_MASK = Long.MAX_VALUE;
    public final long value;
    public static final UnsignedLong ZERO = new UnsignedLong(0);
    public static final UnsignedLong ONE = new UnsignedLong(1);
    public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1);

    public UnsignedLong(long j) {
        this.value = j;
    }

    public static UnsignedLong fromLongBits(long j) {
        return new UnsignedLong(j);
    }

    public static UnsignedLong valueOf(long j) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j >= 0, "value (%s) is outside the range for an unsigned long value", j);
        return fromLongBits(j);
    }

    public static UnsignedLong valueOf(String str) {
        return valueOf(str, 10);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0059 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static UnsignedLong valueOf(String str, int i) {
        boolean z;
        if (str != null) {
            if (str.length() == 0) {
                throw new NumberFormatException("empty string");
            }
            if (i >= 2 && i <= 36) {
                int i2 = C1964bz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] - 1;
                long j = 0;
                for (int i3 = 0; i3 < str.length(); i3++) {
                    int digit = Character.digit(str.charAt(i3), i);
                    if (digit == -1) {
                        throw new NumberFormatException(str);
                    }
                    if (i3 > i2) {
                        if (j >= 0) {
                            long[] jArr = C1964bz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (j < jArr[i] || (j <= jArr[i] && digit <= C1964bz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i])) {
                                z = false;
                                if (!z) {
                                    throw new NumberFormatException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Too large for unsigned long: ", str));
                                }
                            }
                        }
                        z = true;
                        if (!z) {
                        }
                    }
                    j = (j * i) + digit;
                }
                return fromLongBits(j);
            }
            throw new NumberFormatException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("illegal radix: ", i));
        }
        throw null;
    }

    public BigInteger bigIntegerValue() {
        BigInteger valueOf = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        return this.value < 0 ? valueOf.setBit(63) : valueOf;
    }

    @Override // java.lang.Comparable
    public int compareTo(UnsignedLong unsignedLong) {
        if (unsignedLong != null) {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.value, unsignedLong.value);
        }
        throw null;
    }

    public UnsignedLong dividedBy(UnsignedLong unsignedLong) {
        long j = this.value;
        if (unsignedLong != null) {
            return fromLongBits(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, unsignedLong.value));
        }
        throw null;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long j = this.value;
        double d = Long.MAX_VALUE & j;
        return j < 0 ? d + 9.223372036854776E18d : d;
    }

    public boolean equals(Object obj) {
        return (obj instanceof UnsignedLong) && this.value == ((UnsignedLong) obj).value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long j = this.value;
        float f = (float) (Long.MAX_VALUE & j);
        return j < 0 ? f + 9.223372E18f : f;
    }

    public int hashCode() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.value);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public UnsignedLong minus(UnsignedLong unsignedLong) {
        long j = this.value;
        if (unsignedLong != null) {
            return fromLongBits(j - unsignedLong.value);
        }
        throw null;
    }

    public UnsignedLong mod(UnsignedLong unsignedLong) {
        long j = this.value;
        if (unsignedLong != null) {
            return fromLongBits(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, unsignedLong.value));
        }
        throw null;
    }

    public UnsignedLong plus(UnsignedLong unsignedLong) {
        long j = this.value;
        if (unsignedLong != null) {
            return fromLongBits(j + unsignedLong.value);
        }
        throw null;
    }

    public UnsignedLong times(UnsignedLong unsignedLong) {
        long j = this.value;
        if (unsignedLong != null) {
            return fromLongBits(j * unsignedLong.value);
        }
        throw null;
    }

    public String toString() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.value, 10);
    }

    public String toString(int i) {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.value, i);
    }

    public static UnsignedLong valueOf(BigInteger bigInteger) {
        if (bigInteger != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
            return fromLongBits(bigInteger.longValue());
        }
        throw null;
    }
}
