package org.apache.commons.lang3.math;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.math.BigInteger;
import org.apache.http.message.TokenParser;

/* loaded from: classes4.dex */
public final class Fraction extends Number implements Comparable<Fraction> {
    public static final long serialVersionUID = 65382027393090L;
    public final int denominator;
    public final int numerator;
    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ONE_HALF = new Fraction(1, 2);
    public static final Fraction ONE_THIRD = new Fraction(1, 3);
    public static final Fraction TWO_THIRDS = new Fraction(2, 3);
    public static final Fraction ONE_QUARTER = new Fraction(1, 4);
    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
    public static final Fraction ONE_FIFTH = new Fraction(1, 5);
    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
    public transient int hashCode = 0;
    public transient String toString = null;
    public transient String toProperString = null;

    public Fraction(int i, int i2) {
        this.numerator = i;
        this.denominator = i2;
    }

    public static int addAndCheck(int i, int i2) {
        long j = i + i2;
        if (j < -2147483648L || j > 2147483647L) {
            throw new ArithmeticException("overflow: add");
        }
        return (int) j;
    }

    private Fraction addSub(Fraction fraction, boolean z) {
        if (fraction != null) {
            if (this.numerator == 0) {
                return z ? fraction : fraction.negate();
            } else if (fraction.numerator == 0) {
                return this;
            } else {
                int greatestCommonDivisor = greatestCommonDivisor(this.denominator, fraction.denominator);
                if (greatestCommonDivisor == 1) {
                    int mulAndCheck = mulAndCheck(this.numerator, fraction.denominator);
                    int mulAndCheck2 = mulAndCheck(fraction.numerator, this.denominator);
                    return new Fraction(z ? addAndCheck(mulAndCheck, mulAndCheck2) : subAndCheck(mulAndCheck, mulAndCheck2), mulPosAndCheck(this.denominator, fraction.denominator));
                }
                BigInteger multiply = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf(fraction.denominator / greatestCommonDivisor));
                BigInteger multiply2 = BigInteger.valueOf(fraction.numerator).multiply(BigInteger.valueOf(this.denominator / greatestCommonDivisor));
                BigInteger add = z ? multiply.add(multiply2) : multiply.subtract(multiply2);
                int intValue = add.mod(BigInteger.valueOf(greatestCommonDivisor)).intValue();
                int greatestCommonDivisor2 = intValue == 0 ? greatestCommonDivisor : greatestCommonDivisor(intValue, greatestCommonDivisor);
                BigInteger divide = add.divide(BigInteger.valueOf(greatestCommonDivisor2));
                if (divide.bitLength() > 31) {
                    throw new ArithmeticException("overflow: numerator too large after multiply");
                }
                return new Fraction(divide.intValue(), mulPosAndCheck(this.denominator / greatestCommonDivisor, fraction.denominator / greatestCommonDivisor2));
            }
        }
        throw new IllegalArgumentException("The fraction must not be null");
    }

    public static Fraction getFraction(double d) {
        int i;
        int i2;
        int i3 = d < RoundRectDrawableWithShadow.COS_45 ? -1 : 1;
        double abs = Math.abs(d);
        if (abs > 2.147483647E9d || Double.isNaN(abs)) {
            throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
        }
        int i4 = (int) abs;
        double d2 = abs - i4;
        int i5 = (int) d2;
        double d3 = 1.0d;
        double d4 = d2 - i5;
        double d5 = Double.MAX_VALUE;
        int i6 = i3;
        int i7 = 1;
        int i8 = 0;
        int i9 = 0;
        int i10 = 1;
        int i11 = 1;
        while (true) {
            int i12 = (int) (d3 / d4);
            double d6 = d5;
            double d7 = d3 - (i12 * d4);
            int i13 = (i5 * i7) + i8;
            int i14 = (i5 * i9) + i10;
            d5 = Math.abs(d2 - (i13 / i14));
            i = i11 + 1;
            if (d6 <= d5 || i14 > 10000 || i14 <= 0) {
                break;
            }
            i2 = 25;
            if (i >= 25) {
                break;
            }
            i11 = i;
            int i15 = i9;
            i9 = i14;
            i5 = i12;
            i8 = i7;
            i7 = i13;
            i10 = i15;
            d3 = d4;
            d4 = d7;
        }
        if (i == i2) {
            throw new ArithmeticException("Unable to convert double to fraction");
        }
        return getReducedFraction(((i4 * i9) + i7) * i6, i9);
    }

    public static Fraction getFraction(int i, int i2) {
        if (i2 != 0) {
            if (i2 < 0) {
                if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE) {
                    throw new ArithmeticException("overflow: can't negate");
                }
                i = -i;
                i2 = -i2;
            }
            return new Fraction(i, i2);
        }
        throw new ArithmeticException("The denominator must not be zero");
    }

    public static Fraction getFraction(int i, int i2, int i3) {
        if (i3 != 0) {
            if (i3 < 0) {
                throw new ArithmeticException("The denominator must not be negative");
            }
            if (i2 < 0) {
                throw new ArithmeticException("The numerator must not be negative");
            }
            long j = i * i3;
            long j2 = i < 0 ? j - i2 : j + i2;
            if (j2 >= -2147483648L && j2 <= 2147483647L) {
                return new Fraction((int) j2, i3);
            }
            throw new ArithmeticException("Numerator too large to represent as an Integer.");
        }
        throw new ArithmeticException("The denominator must not be zero");
    }

    public static Fraction getFraction(String str) {
        if (str != null) {
            if (str.indexOf(46) >= 0) {
                return getFraction(Double.parseDouble(str));
            }
            int indexOf = str.indexOf(32);
            if (indexOf <= 0) {
                int indexOf2 = str.indexOf(47);
                return indexOf2 < 0 ? getFraction(Integer.parseInt(str), 1) : getFraction(Integer.parseInt(str.substring(0, indexOf2)), Integer.parseInt(str.substring(indexOf2 + 1)));
            }
            int parseInt = Integer.parseInt(str.substring(0, indexOf));
            String substring = str.substring(indexOf + 1);
            int indexOf3 = substring.indexOf(47);
            if (indexOf3 < 0) {
                throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
            }
            return getFraction(parseInt, Integer.parseInt(substring.substring(0, indexOf3)), Integer.parseInt(substring.substring(indexOf3 + 1)));
        }
        throw new IllegalArgumentException("The string must not be null");
    }

    public static Fraction getReducedFraction(int i, int i2) {
        if (i2 != 0) {
            if (i == 0) {
                return ZERO;
            }
            if (i2 == Integer.MIN_VALUE && (i & 1) == 0) {
                i /= 2;
                i2 /= 2;
            }
            if (i2 < 0) {
                if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE) {
                    throw new ArithmeticException("overflow: can't negate");
                }
                i = -i;
                i2 = -i2;
            }
            int greatestCommonDivisor = greatestCommonDivisor(i, i2);
            return new Fraction(i / greatestCommonDivisor, i2 / greatestCommonDivisor);
        }
        throw new ArithmeticException("The denominator must not be zero");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
        if (r3 != 1) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
        r0 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003a, code lost:
        if ((r0 & 1) != 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
        if (r0 <= 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
        r6 = -r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0044, code lost:
        r0 = (r7 - r6) / 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0048, code lost:
        if (r0 != 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004f, code lost:
        return (-r6) * (1 << r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0043, code lost:
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x003c, code lost:
        r0 = r0 / 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0035, code lost:
        r0 = -(r6 / 2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int greatestCommonDivisor(int i, int i2) {
        if (i == 0 || i2 == 0) {
            if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE) {
                throw new ArithmeticException("overflow: gcd is 2^31");
            }
            return Math.abs(i2) + Math.abs(i);
        } else if (Math.abs(i) == 1 || Math.abs(i2) == 1) {
            return 1;
        } else {
            if (i > 0) {
                i = -i;
            }
            if (i2 > 0) {
                i2 = -i2;
            }
            int i3 = 0;
            while (true) {
                int i4 = i & 1;
                if (i4 != 0 || (i2 & 1) != 0 || i3 >= 31) {
                    break;
                }
                i /= 2;
                i2 /= 2;
                i3++;
            }
            throw new ArithmeticException("overflow: gcd is 2^31");
        }
    }

    public static int mulAndCheck(int i, int i2) {
        long j = i * i2;
        if (j < -2147483648L || j > 2147483647L) {
            throw new ArithmeticException("overflow: mul");
        }
        return (int) j;
    }

    public static int mulPosAndCheck(int i, int i2) {
        long j = i * i2;
        if (j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: mulPos");
    }

    public static int subAndCheck(int i, int i2) {
        long j = i - i2;
        if (j < -2147483648L || j > 2147483647L) {
            throw new ArithmeticException("overflow: add");
        }
        return (int) j;
    }

    public Fraction abs() {
        return this.numerator >= 0 ? this : negate();
    }

    public Fraction add(Fraction fraction) {
        return addSub(fraction, true);
    }

    @Override // java.lang.Comparable
    public int compareTo(Fraction fraction) {
        int i;
        if (this == fraction) {
            return 0;
        }
        if ((this.numerator == fraction.numerator && this.denominator == fraction.denominator) || this.numerator * fraction.denominator == fraction.numerator * this.denominator) {
            return 0;
        }
        return i < 0 ? -1 : 1;
    }

    public Fraction divideBy(Fraction fraction) {
        if (fraction != null) {
            if (fraction.numerator == 0) {
                throw new ArithmeticException("The fraction to divide by must not be zero");
            }
            return multiplyBy(fraction.invert());
        }
        throw new IllegalArgumentException("The fraction must not be null");
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.numerator / this.denominator;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction fraction = (Fraction) obj;
        return getNumerator() == fraction.getNumerator() && getDenominator() == fraction.getDenominator();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.numerator / this.denominator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getProperNumerator() {
        return Math.abs(this.numerator % this.denominator);
    }

    public int getProperWhole() {
        return this.numerator / this.denominator;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = getDenominator() + ((getNumerator() + 629) * 37);
        }
        return this.hashCode;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.numerator / this.denominator;
    }

    public Fraction invert() {
        int i = this.numerator;
        if (i != 0) {
            if (i == Integer.MIN_VALUE) {
                throw new ArithmeticException("overflow: can't negate numerator");
            }
            int i2 = this.denominator;
            return i < 0 ? new Fraction(-i2, -i) : new Fraction(i2, i);
        }
        throw new ArithmeticException("Unable to invert zero.");
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.numerator / this.denominator;
    }

    public Fraction multiplyBy(Fraction fraction) {
        if (fraction != null) {
            int i = this.numerator;
            if (i == 0 || fraction.numerator == 0) {
                return ZERO;
            }
            int greatestCommonDivisor = greatestCommonDivisor(i, fraction.denominator);
            int greatestCommonDivisor2 = greatestCommonDivisor(fraction.numerator, this.denominator);
            return getReducedFraction(mulAndCheck(this.numerator / greatestCommonDivisor, fraction.numerator / greatestCommonDivisor2), mulPosAndCheck(this.denominator / greatestCommonDivisor2, fraction.denominator / greatestCommonDivisor));
        }
        throw new IllegalArgumentException("The fraction must not be null");
    }

    public Fraction negate() {
        int i = this.numerator;
        if (i != Integer.MIN_VALUE) {
            return new Fraction(-i, this.denominator);
        }
        throw new ArithmeticException("overflow: too large to negate");
    }

    public Fraction pow(int i) {
        if (i == 1) {
            return this;
        }
        if (i == 0) {
            return ONE;
        }
        if (i < 0) {
            return i == Integer.MIN_VALUE ? invert().pow(2).pow(-(i / 2)) : invert().pow(-i);
        }
        Fraction multiplyBy = multiplyBy(this);
        int i2 = i % 2;
        int i3 = i / 2;
        return i2 == 0 ? multiplyBy.pow(i3) : multiplyBy.pow(i3).multiplyBy(this);
    }

    public Fraction reduce() {
        int i = this.numerator;
        if (i == 0) {
            return equals(ZERO) ? this : ZERO;
        }
        int greatestCommonDivisor = greatestCommonDivisor(Math.abs(i), this.denominator);
        return greatestCommonDivisor == 1 ? this : getFraction(this.numerator / greatestCommonDivisor, this.denominator / greatestCommonDivisor);
    }

    public Fraction subtract(Fraction fraction) {
        return addSub(fraction, false);
    }

    public String toProperString() {
        String sb;
        if (this.toProperString == null) {
            int i = this.numerator;
            if (i == 0) {
                sb = "0";
            } else {
                int i2 = this.denominator;
                if (i == i2) {
                    sb = "1";
                } else if (i == i2 * (-1)) {
                    sb = "-1";
                } else {
                    if (i > 0) {
                        i = -i;
                    }
                    if (i < (-this.denominator)) {
                        int properNumerator = getProperNumerator();
                        if (properNumerator == 0) {
                            sb = Integer.toString(getProperWhole());
                        } else {
                            StringBuilder sb2 = new StringBuilder(32);
                            sb2.append(getProperWhole());
                            sb2.append(TokenParser.f4579SP);
                            sb2.append(properNumerator);
                            sb2.append('/');
                            sb2.append(getDenominator());
                            sb = sb2.toString();
                        }
                    } else {
                        StringBuilder sb3 = new StringBuilder(32);
                        sb3.append(getNumerator());
                        sb3.append('/');
                        sb3.append(getDenominator());
                        sb = sb3.toString();
                    }
                }
            }
            this.toProperString = sb;
        }
        return this.toProperString;
    }

    public String toString() {
        if (this.toString == null) {
            StringBuilder sb = new StringBuilder(32);
            sb.append(getNumerator());
            sb.append('/');
            sb.append(getDenominator());
            this.toString = sb.toString();
        }
        return this.toString;
    }
}
