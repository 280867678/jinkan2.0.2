package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class GeneralRange<T> implements Serializable {
    public final Comparator<? super T> comparator;
    public final boolean hasLowerBound;
    public final boolean hasUpperBound;
    public final BoundType lowerBoundType;
    public final T lowerEndpoint;
    public transient GeneralRange<T> reverse;
    public final BoundType upperBoundType;
    public final T upperEndpoint;

    /* JADX WARN: Multi-variable type inference failed */
    public GeneralRange(Comparator<? super T> comparator, boolean z, T t, BoundType boundType, boolean z2, T t2, BoundType boundType2) {
        if (comparator != null) {
            this.comparator = comparator;
            this.hasLowerBound = z;
            this.hasUpperBound = z2;
            this.lowerEndpoint = t;
            if (boundType == null) {
                throw null;
            }
            this.lowerBoundType = boundType;
            this.upperEndpoint = t2;
            if (boundType2 == null) {
                throw null;
            }
            this.upperBoundType = boundType2;
            if (z) {
                comparator.compare(t, t);
            }
            if (z2) {
                comparator.compare(t2, t2);
            }
            if (!z || !z2) {
                return;
            }
            int compare = comparator.compare(t, t2);
            boolean z3 = true;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t, t2);
            if (compare != 0) {
                return;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((boundType != BoundType.OPEN) | (boundType2 == BoundType.OPEN ? false : z3));
            return;
        }
        throw null;
    }

    public static <T> GeneralRange<T> all(Comparator<? super T> comparator) {
        BoundType boundType = BoundType.OPEN;
        return new GeneralRange<>(comparator, false, null, boundType, false, null, boundType);
    }

    public static <T> GeneralRange<T> downTo(Comparator<? super T> comparator, T t, BoundType boundType) {
        return new GeneralRange<>(comparator, true, t, boundType, false, null, BoundType.OPEN);
    }

    public static <T extends Comparable> GeneralRange<T> from(Range<T> range) {
        T t = null;
        T lowerEndpoint = range.hasLowerBound() ? range.lowerEndpoint() : null;
        BoundType lowerBoundType = range.hasLowerBound() ? range.lowerBoundType() : BoundType.OPEN;
        if (range.hasUpperBound()) {
            t = range.upperEndpoint();
        }
        return new GeneralRange<>(Ordering.natural(), range.hasLowerBound(), lowerEndpoint, lowerBoundType, range.hasUpperBound(), t, range.hasUpperBound() ? range.upperBoundType() : BoundType.OPEN);
    }

    public static <T> GeneralRange<T> range(Comparator<? super T> comparator, T t, BoundType boundType, T t2, BoundType boundType2) {
        return new GeneralRange<>(comparator, true, t, boundType, true, t2, boundType2);
    }

    public static <T> GeneralRange<T> upTo(Comparator<? super T> comparator, T t, BoundType boundType) {
        return new GeneralRange<>(comparator, false, null, BoundType.OPEN, true, t, boundType);
    }

    public Comparator<? super T> comparator() {
        return this.comparator;
    }

    public boolean contains(T t) {
        return !tooLow(t) && !tooHigh(t);
    }

    public boolean equals(Object obj) {
        if (obj instanceof GeneralRange) {
            GeneralRange generalRange = (GeneralRange) obj;
            return this.comparator.equals(generalRange.comparator) && this.hasLowerBound == generalRange.hasLowerBound && this.hasUpperBound == generalRange.hasUpperBound && getLowerBoundType().equals(generalRange.getLowerBoundType()) && getUpperBoundType().equals(generalRange.getUpperBoundType()) && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getLowerEndpoint(), generalRange.getLowerEndpoint()) && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getUpperEndpoint(), generalRange.getUpperEndpoint());
        }
        return false;
    }

    public BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    public T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    public BoundType getUpperBoundType() {
        return this.upperBoundType;
    }

    public T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    public boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    public boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType()});
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:
        if (r12.getUpperBoundType() == com.google.common.collect.BoundType.OPEN) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0046, code lost:
        if (r12.getLowerBoundType() == com.google.common.collect.BoundType.OPEN) goto L5;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GeneralRange<T> intersect(GeneralRange<T> generalRange) {
        boolean z;
        T t;
        BoundType boundType;
        BoundType boundType2;
        int compare;
        BoundType boundType3;
        if (generalRange != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.comparator.equals(generalRange.comparator));
            boolean z2 = this.hasLowerBound;
            T lowerEndpoint = getLowerEndpoint();
            BoundType lowerBoundType = getLowerBoundType();
            if (hasLowerBound()) {
                if (generalRange.hasLowerBound()) {
                    int compare2 = this.comparator.compare(getLowerEndpoint(), generalRange.getLowerEndpoint());
                    if (compare2 >= 0) {
                        if (compare2 == 0) {
                        }
                    }
                }
                z = z2;
                boolean z3 = this.hasUpperBound;
                T upperEndpoint = getUpperEndpoint();
                BoundType upperBoundType = getUpperBoundType();
                if (!hasUpperBound()) {
                    if (generalRange.hasUpperBound()) {
                        int compare3 = this.comparator.compare(getUpperEndpoint(), generalRange.getUpperEndpoint());
                        if (compare3 <= 0) {
                            if (compare3 == 0) {
                            }
                        }
                    }
                    boolean z4 = z3;
                    T t2 = upperEndpoint;
                    if (z || !z4 || ((compare = this.comparator.compare(lowerEndpoint, t2)) <= 0 && !(compare == 0 && lowerBoundType == (boundType3 = BoundType.OPEN) && upperBoundType == boundType3))) {
                        t = lowerEndpoint;
                        boundType = lowerBoundType;
                        boundType2 = upperBoundType;
                    } else {
                        boundType = BoundType.OPEN;
                        boundType2 = BoundType.CLOSED;
                        t = t2;
                    }
                    return new GeneralRange<>(this.comparator, z, t, boundType, z4, t2, boundType2);
                }
                z3 = generalRange.hasUpperBound;
                upperEndpoint = generalRange.getUpperEndpoint();
                upperBoundType = generalRange.getUpperBoundType();
                boolean z42 = z3;
                T t22 = upperEndpoint;
                if (z) {
                }
                t = lowerEndpoint;
                boundType = lowerBoundType;
                boundType2 = upperBoundType;
                return new GeneralRange<>(this.comparator, z, t, boundType, z42, t22, boundType2);
            }
            z2 = generalRange.hasLowerBound;
            lowerEndpoint = generalRange.getLowerEndpoint();
            lowerBoundType = generalRange.getLowerBoundType();
            z = z2;
            boolean z32 = this.hasUpperBound;
            T upperEndpoint2 = getUpperEndpoint();
            BoundType upperBoundType2 = getUpperBoundType();
            if (!hasUpperBound()) {
            }
            upperEndpoint2 = generalRange.getUpperEndpoint();
            upperBoundType2 = generalRange.getUpperBoundType();
            boolean z422 = z32;
            T t222 = upperEndpoint2;
            if (z) {
            }
            t = lowerEndpoint;
            boundType = lowerBoundType;
            boundType2 = upperBoundType2;
            return new GeneralRange<>(this.comparator, z, t, boundType, z422, t222, boundType2);
        }
        throw null;
    }

    public boolean isEmpty() {
        return (hasUpperBound() && tooLow(getUpperEndpoint())) || (hasLowerBound() && tooHigh(getLowerEndpoint()));
    }

    public GeneralRange<T> reverse() {
        GeneralRange<T> generalRange = this.reverse;
        if (generalRange == null) {
            GeneralRange<T> generalRange2 = new GeneralRange<>(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
            generalRange2.reverse = this;
            this.reverse = generalRange2;
            return generalRange2;
        }
        return generalRange;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.comparator);
        sb.append(":");
        sb.append(this.lowerBoundType == BoundType.CLOSED ? '[' : '(');
        sb.append(this.hasLowerBound ? this.lowerEndpoint : "-∞");
        sb.append(',');
        sb.append(this.hasUpperBound ? this.upperEndpoint : "∞");
        sb.append(this.upperBoundType == BoundType.CLOSED ? ']' : ')');
        return sb.toString();
    }

    public boolean tooHigh(T t) {
        boolean z = false;
        if (!hasUpperBound()) {
            return false;
        }
        int compare = this.comparator.compare(t, getUpperEndpoint());
        boolean z2 = compare > 0;
        boolean z3 = compare == 0;
        if (getUpperBoundType() == BoundType.OPEN) {
            z = true;
        }
        return (z3 & z) | z2;
    }

    public boolean tooLow(T t) {
        boolean z = false;
        if (!hasLowerBound()) {
            return false;
        }
        int compare = this.comparator.compare(t, getLowerEndpoint());
        boolean z2 = compare < 0;
        boolean z3 = compare == 0;
        if (getLowerBoundType() == BoundType.OPEN) {
            z = true;
        }
        return (z3 & z) | z2;
    }
}
