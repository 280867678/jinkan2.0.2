package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes4.dex */
public final class Range<T> implements Serializable {
    public static final long serialVersionUID = 1;
    public final Comparator<T> comparator;
    public transient int hashCode;
    public final T maximum;
    public final T minimum;
    public transient String toString;

    /* loaded from: classes4.dex */
    public enum ComparableComparator implements Comparator {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public Range(T t, T t2, Comparator<T> comparator) {
        if (t == null || t2 == null) {
            throw new IllegalArgumentException("Elements in a range must not be null: element1=" + t + ", element2=" + t2);
        }
        this.comparator = comparator == null ? ComparableComparator.INSTANCE : comparator;
        if (this.comparator.compare(t, t2) < 1) {
            this.minimum = t;
            this.maximum = t2;
            return;
        }
        this.minimum = t2;
        this.maximum = t;
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<TT;>;>(TT;TT;)Lorg/apache/commons/lang3/Range<TT;>; */
    public static Range between(Comparable comparable, Comparable comparable2) {
        return between(comparable, comparable2, null);
    }

    public static <T> Range<T> between(T t, T t2, Comparator<T> comparator) {
        return new Range<>(t, t2, comparator);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<TT;>;>(TT;)Lorg/apache/commons/lang3/Range<TT;>; */
    /* renamed from: is */
    public static Range m45is(Comparable comparable) {
        return between(comparable, comparable, null);
    }

    /* renamed from: is */
    public static <T> Range<T> m44is(T t, Comparator<T> comparator) {
        return between(t, t, comparator);
    }

    public boolean contains(T t) {
        return t != null && this.comparator.compare(t, this.minimum) > -1 && this.comparator.compare(t, this.maximum) < 1;
    }

    public boolean containsRange(Range<T> range) {
        return range != null && contains(range.minimum) && contains(range.maximum);
    }

    public int elementCompareTo(T t) {
        if (t != null) {
            if (isAfter(t)) {
                return -1;
            }
            return isBefore(t) ? 1 : 0;
        }
        throw new NullPointerException("Element is null");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != Range.class) {
            return false;
        }
        Range range = (Range) obj;
        return this.minimum.equals(range.minimum) && this.maximum.equals(range.maximum);
    }

    public Comparator<T> getComparator() {
        return this.comparator;
    }

    public T getMaximum() {
        return this.maximum;
    }

    public T getMinimum() {
        return this.minimum;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = this.minimum.hashCode();
            int hashCode2 = this.maximum.hashCode() + ((hashCode + ((Range.class.hashCode() + 629) * 37)) * 37);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i;
    }

    public Range<T> intersectionWith(Range<T> range) {
        if (isOverlappedBy(range)) {
            if (equals(range)) {
                return this;
            }
            return between(getComparator().compare(this.minimum, range.minimum) < 0 ? range.minimum : this.minimum, getComparator().compare(this.maximum, range.maximum) < 0 ? this.maximum : range.maximum, getComparator());
        }
        throw new IllegalArgumentException(String.format("Cannot calculate intersection with non-overlapping range %s", range));
    }

    public boolean isAfter(T t) {
        return t != null && this.comparator.compare(t, this.minimum) < 0;
    }

    public boolean isAfterRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isAfter(range.maximum);
    }

    public boolean isBefore(T t) {
        return t != null && this.comparator.compare(t, this.maximum) > 0;
    }

    public boolean isBeforeRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isBefore(range.minimum);
    }

    public boolean isEndedBy(T t) {
        return t != null && this.comparator.compare(t, this.maximum) == 0;
    }

    public boolean isNaturalOrdering() {
        return this.comparator == ComparableComparator.INSTANCE;
    }

    public boolean isOverlappedBy(Range<T> range) {
        if (range == null) {
            return false;
        }
        return range.contains(this.minimum) || range.contains(this.maximum) || contains(range.minimum);
    }

    public boolean isStartedBy(T t) {
        return t != null && this.comparator.compare(t, this.minimum) == 0;
    }

    public String toString() {
        String str = this.toString;
        if (str == null) {
            StringBuilder sb = new StringBuilder(32);
            sb.append('[');
            sb.append(this.minimum);
            sb.append("..");
            sb.append(this.maximum);
            sb.append(']');
            String sb2 = sb.toString();
            this.toString = sb2;
            return sb2;
        }
        return str;
    }

    public String toString(String str) {
        return String.format(str, this.minimum, this.maximum, this.comparator);
    }
}
