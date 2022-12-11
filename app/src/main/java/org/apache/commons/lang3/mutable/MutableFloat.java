package org.apache.commons.lang3.mutable;

/* loaded from: classes4.dex */
public class MutableFloat extends Number implements Comparable<MutableFloat>, Mutable<Number> {
    public static final long serialVersionUID = 5787169186L;
    public float value;

    public MutableFloat() {
    }

    public MutableFloat(float f) {
        this.value = f;
    }

    public MutableFloat(Number number) {
        this.value = number.floatValue();
    }

    public MutableFloat(String str) throws NumberFormatException {
        this.value = Float.parseFloat(str);
    }

    public void add(float f) {
        this.value += f;
    }

    public void add(Number number) {
        this.value = number.floatValue() + this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(MutableFloat mutableFloat) {
        return Float.compare(this.value, mutableFloat.value);
    }

    public void decrement() {
        this.value -= 1.0f;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableFloat) && Float.floatToIntBits(((MutableFloat) obj).value) == Float.floatToIntBits(this.value);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Number mo5179getValue() {
        return Float.valueOf(this.value);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value);
    }

    public void increment() {
        this.value += 1.0f;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return Float.isInfinite(this.value);
    }

    public boolean isNaN() {
        return Float.isNaN(this.value);
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public void setValue(float f) {
        this.value = f;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.floatValue();
    }

    public void subtract(float f) {
        this.value -= f;
    }

    public void subtract(Number number) {
        this.value -= number.floatValue();
    }

    public Float toFloat() {
        return Float.valueOf(floatValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
