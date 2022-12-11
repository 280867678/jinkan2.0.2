package com.google.common.primitives;

import java.math.BigInteger;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {
    public final int value;
    public static final UnsignedInteger ZERO = fromIntBits(0);
    public static final UnsignedInteger ONE = fromIntBits(1);
    public static final UnsignedInteger MAX_VALUE = fromIntBits(-1);

    public UnsignedInteger(int i) {
        this.value = i & (-1);
    }

    public static UnsignedInteger fromIntBits(int i) {
        return new UnsignedInteger(i);
    }

    public static UnsignedInteger valueOf(long j) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((4294967295L & j) == j, "value (%s) is outside the range for an unsigned integer value", j);
        return fromIntBits((int) j);
    }

    public static UnsignedInteger valueOf(String str) {
        return valueOf(str, 10);
    }

    public static UnsignedInteger valueOf(String str, int i) {
        if (str != null) {
            long parseLong = Long.parseLong(str, i);
            if ((4294967295L & parseLong) == parseLong) {
                return fromIntBits((int) parseLong);
            }
            throw new NumberFormatException("Input " + str + " in base " + i + " is not in the range of an unsigned integer");
        }
        throw null;
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(longValue());
    }

    @Override // java.lang.Comparable
    public int compareTo(UnsignedInteger unsignedInteger) {
        if (unsignedInteger != null) {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.value ^ Integer.MIN_VALUE, unsignedInteger.value ^ Integer.MIN_VALUE);
        }
        throw null;
    }

    public UnsignedInteger dividedBy(UnsignedInteger unsignedInteger) {
        int i = this.value;
        if (unsignedInteger != null) {
            return fromIntBits((int) (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i) / Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(unsignedInteger.value)));
        }
        throw null;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return longValue();
    }

    public boolean equals(Object obj) {
        return (obj instanceof UnsignedInteger) && this.value == ((UnsignedInteger) obj).value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) longValue();
    }

    public int hashCode() {
        return this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.value);
    }

    public UnsignedInteger minus(UnsignedInteger unsignedInteger) {
        int i = this.value;
        if (unsignedInteger != null) {
            return fromIntBits(i - unsignedInteger.value);
        }
        throw null;
    }

    public UnsignedInteger mod(UnsignedInteger unsignedInteger) {
        int i = this.value;
        if (unsignedInteger != null) {
            return fromIntBits((int) (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i) % Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(unsignedInteger.value)));
        }
        throw null;
    }

    public UnsignedInteger plus(UnsignedInteger unsignedInteger) {
        int i = this.value;
        if (unsignedInteger != null) {
            return fromIntBits(i + unsignedInteger.value);
        }
        throw null;
    }

    public UnsignedInteger times(UnsignedInteger unsignedInteger) {
        int i = this.value;
        if (unsignedInteger != null) {
            return fromIntBits(i * unsignedInteger.value);
        }
        throw null;
    }

    public String toString() {
        return toString(10);
    }

    public String toString(int i) {
        return Long.toString(this.value & 4294967295L, i);
    }

    public static UnsignedInteger valueOf(BigInteger bigInteger) {
        if (bigInteger != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 32, "value (%s) is outside the range for an unsigned integer value", bigInteger);
            return fromIntBits(bigInteger.intValue());
        }
        throw null;
    }
}
