package org.apache.commons.lang3.mutable;

/* loaded from: classes4.dex */
public class MutableDouble extends Number implements Comparable<MutableDouble>, Mutable<Number> {
    public static final long serialVersionUID = 1587163916;
    public double value;

    public MutableDouble() {
    }

    public MutableDouble(double d) {
        this.value = d;
    }

    public MutableDouble(Number number) {
        this.value = number.doubleValue();
    }

    public MutableDouble(String str) throws NumberFormatException {
        this.value = Double.parseDouble(str);
    }

    public void add(double d) {
        this.value += d;
    }

    public void add(Number number) {
        this.value = number.doubleValue() + this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(MutableDouble mutableDouble) {
        return Double.compare(this.value, mutableDouble.value);
    }

    public void decrement() {
        this.value -= 1.0d;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableDouble) && Double.doubleToLongBits(((MutableDouble) obj).value) == Double.doubleToLongBits(this.value);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) this.value;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Number mo5179getValue() {
        return Double.valueOf(this.value);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.value);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public void increment() {
        this.value += 1.0d;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return Double.isInfinite(this.value);
    }

    public boolean isNaN() {
        return Double.isNaN(this.value);
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) this.value;
    }

    public void setValue(double d) {
        this.value = d;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.doubleValue();
    }

    public void subtract(double d) {
        this.value -= d;
    }

    public void subtract(Number number) {
        this.value -= number.doubleValue();
    }

    public Double toDouble() {
        return Double.valueOf(doubleValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
