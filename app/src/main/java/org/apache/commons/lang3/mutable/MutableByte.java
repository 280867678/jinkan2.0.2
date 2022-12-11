package org.apache.commons.lang3.mutable;

/* loaded from: classes4.dex */
public class MutableByte extends Number implements Comparable<MutableByte>, Mutable<Number> {
    public static final long serialVersionUID = -1585823265;
    public byte value;

    public MutableByte() {
    }

    public MutableByte(byte b) {
        this.value = b;
    }

    public MutableByte(Number number) {
        this.value = number.byteValue();
    }

    public MutableByte(String str) throws NumberFormatException {
        this.value = Byte.parseByte(str);
    }

    public void add(byte b) {
        this.value = (byte) (this.value + b);
    }

    public void add(Number number) {
        this.value = (byte) (number.byteValue() + this.value);
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(MutableByte mutableByte) {
        byte b = mutableByte.value;
        byte b2 = this.value;
        if (b2 < b) {
            return -1;
        }
        return b2 == b ? 0 : 1;
    }

    public void decrement() {
        this.value = (byte) (this.value - 1);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableByte) && this.value == ((MutableByte) obj).byteValue();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Number mo5179getValue() {
        return Byte.valueOf(this.value);
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value = (byte) (this.value + 1);
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public void setValue(byte b) {
        this.value = b;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.byteValue();
    }

    public void subtract(byte b) {
        this.value = (byte) (this.value - b);
    }

    public void subtract(Number number) {
        this.value = (byte) (this.value - number.byteValue());
    }

    public Byte toByte() {
        return Byte.valueOf(byteValue());
    }

    public String toString() {
        return String.valueOf((int) this.value);
    }
}
