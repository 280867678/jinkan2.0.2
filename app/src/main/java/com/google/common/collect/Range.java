package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import me.tvspark.AbstractC2271jt;
import me.tvspark.AbstractC2573rt;
import me.tvspark.AbstractC2800xu;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements AbstractC2573rt<C>, Serializable {
    public static final Range<Comparable> ALL = new Range<>(Cut.belowAll(), Cut.aboveAll());
    public static final long serialVersionUID = 0;
    public final Cut<C> lowerBound;
    public final Cut<C> upperBound;

    /* loaded from: classes3.dex */
    public static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        public static final Ordering<Range<?>> INSTANCE = new RangeLexOrdering();
        public static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Range<?> range, Range<?> range2) {
            return AbstractC2800xu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(range.lowerBound, range2.lowerBound).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(range.upperBound, range2.upperBound).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2271jt<Range, Cut> {
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        @Override // me.tvspark.AbstractC2271jt
        /* renamed from: apply */
        public Cut mo4462apply(Range range) {
            return range.upperBound;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2271jt<Range, Cut> {
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        @Override // me.tvspark.AbstractC2271jt
        /* renamed from: apply */
        public Cut mo4462apply(Range range) {
            return range.lowerBound;
        }
    }

    public Range(Cut<C> cut, Cut<C> cut2) {
        if (cut != null) {
            this.lowerBound = cut;
            if (cut2 == null) {
                throw null;
            }
            this.upperBound = cut2;
            if (cut.compareTo((Cut) cut2) <= 0 && cut != Cut.aboveAll() && cut2 != Cut.belowAll()) {
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid range: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(toString(cut, cut2));
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        throw null;
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) ALL;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c) {
        return create(Cut.belowValue(c), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c) {
        return create(Cut.belowAll(), Cut.aboveValue(c));
    }

    public static <T> SortedSet<T> cast(Iterable<T> iterable) {
        return (SortedSet) iterable;
    }

    public static <C extends Comparable<?>> Range<C> closed(C c, C c2) {
        return create(Cut.belowValue(c), Cut.aboveValue(c2));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c, C c2) {
        return create(Cut.belowValue(c), Cut.belowValue(c2));
    }

    public static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static <C extends Comparable<?>> Range<C> create(Cut<C> cut, Cut<C> cut2) {
        return new Range<>(cut, cut2);
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c, BoundType boundType) {
        int ordinal = boundType.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                throw new AssertionError();
            }
            return atLeast(c);
        }
        return greaterThan(c);
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        if (iterable != null) {
            if (iterable instanceof SortedSet) {
                SortedSet cast = cast(iterable);
                Comparator comparator = cast.comparator();
                if (Ordering.natural().equals(comparator) || comparator == null) {
                    return closed((Comparable) cast.first(), (Comparable) cast.last());
                }
            }
            Iterator<C> it = iterable.iterator();
            C next = it.next();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next);
            C c = next;
            Comparable comparable = c;
            while (it.hasNext()) {
                C next2 = it.next();
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next2);
                C c2 = next2;
                c = (Comparable) Ordering.natural().min(c, c2);
                comparable = (Comparable) Ordering.natural().max(comparable, c2);
            }
            return closed(c, comparable);
        }
        throw null;
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c) {
        return create(Cut.aboveValue(c), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c) {
        return create(Cut.belowAll(), Cut.belowValue(c));
    }

    public static <C extends Comparable<?>> AbstractC2271jt<Range<C>, Cut<C>> lowerBoundFn() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static <C extends Comparable<?>> Range<C> open(C c, C c2) {
        return create(Cut.aboveValue(c), Cut.belowValue(c2));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c, C c2) {
        return create(Cut.aboveValue(c), Cut.aboveValue(c2));
    }

    public static <C extends Comparable<?>> Range<C> range(C c, BoundType boundType, C c2, BoundType boundType2) {
        if (boundType != null) {
            if (boundType2 == null) {
                throw null;
            }
            return create(boundType == BoundType.OPEN ? Cut.aboveValue(c) : Cut.belowValue(c), boundType2 == BoundType.OPEN ? Cut.belowValue(c2) : Cut.aboveValue(c2));
        }
        throw null;
    }

    public static <C extends Comparable<?>> Ordering<Range<C>> rangeLexOrdering() {
        return (Ordering<Range<C>>) RangeLexOrdering.INSTANCE;
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c) {
        return closed(c, c);
    }

    public static String toString(Cut<?> cut, Cut<?> cut2) {
        StringBuilder sb = new StringBuilder(16);
        cut.describeAsLowerBound(sb);
        sb.append("..");
        cut2.describeAsUpperBound(sb);
        return sb.toString();
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c, BoundType boundType) {
        int ordinal = boundType.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                throw new AssertionError();
            }
            return atMost(c);
        }
        return lessThan(c);
    }

    public static <C extends Comparable<?>> AbstractC2271jt<Range<C>, Cut<C>> upperBoundFn() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Deprecated
    public boolean apply(C c) {
        return contains(c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2573rt
    @Deprecated
    public /* bridge */ /* synthetic */ boolean apply(Object obj) {
        return apply((Range<C>) ((Comparable) obj));
    }

    public Range<C> canonical(DiscreteDomain<C> discreteDomain) {
        if (discreteDomain != null) {
            Cut<C> canonical = this.lowerBound.canonical(discreteDomain);
            Cut<C> canonical2 = this.upperBound.canonical(discreteDomain);
            return (canonical == this.lowerBound && canonical2 == this.upperBound) ? this : create(canonical, canonical2);
        }
        throw null;
    }

    public boolean contains(C c) {
        if (c != null) {
            return this.lowerBound.isLessThan(c) && !this.upperBound.isLessThan(c);
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsAll(Iterable<? extends C> iterable) {
        if (iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext()) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet cast = cast(iterable);
            Comparator comparator = cast.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return contains((Comparable) cast.first()) && contains((Comparable) cast.last());
            }
        }
        for (C c : iterable) {
            if (!contains(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(Range<C> range) {
        return this.lowerBound.compareTo((Cut) range.lowerBound) <= 0 && this.upperBound.compareTo((Cut) range.upperBound) >= 0;
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean equals(Object obj) {
        if (obj instanceof Range) {
            Range range = (Range) obj;
            return this.lowerBound.equals(range.lowerBound) && this.upperBound.equals(range.upperBound);
        }
        return false;
    }

    public Range<C> gap(Range<C> range) {
        boolean z = this.lowerBound.compareTo((Cut) range.lowerBound) < 0;
        Range<C> range2 = z ? this : range;
        if (!z) {
            range = this;
        }
        return create(range2.upperBound, range.lowerBound);
    }

    public boolean hasLowerBound() {
        return this.lowerBound != Cut.belowAll();
    }

    public boolean hasUpperBound() {
        return this.upperBound != Cut.aboveAll();
    }

    public int hashCode() {
        return this.upperBound.hashCode() + (this.lowerBound.hashCode() * 31);
    }

    public Range<C> intersection(Range<C> range) {
        int compareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
        int compareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
        if (compareTo < 0 || compareTo2 > 0) {
            if (compareTo <= 0 && compareTo2 >= 0) {
                return range;
            }
            return create(compareTo >= 0 ? this.lowerBound : range.lowerBound, compareTo2 <= 0 ? this.upperBound : range.upperBound);
        }
        return this;
    }

    public boolean isConnected(Range<C> range) {
        return this.lowerBound.compareTo((Cut) range.upperBound) <= 0 && range.lowerBound.compareTo((Cut) this.upperBound) <= 0;
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public C lowerEndpoint() {
        return this.lowerBound.endpoint();
    }

    public Object readResolve() {
        return equals(ALL) ? all() : this;
    }

    public Range<C> span(Range<C> range) {
        int compareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
        int compareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
        if (compareTo > 0 || compareTo2 < 0) {
            if (compareTo >= 0 && compareTo2 <= 0) {
                return range;
            }
            return create(compareTo <= 0 ? this.lowerBound : range.lowerBound, compareTo2 >= 0 ? this.upperBound : range.upperBound);
        }
        return this;
    }

    public String toString() {
        return toString(this.lowerBound, this.upperBound);
    }

    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public C upperEndpoint() {
        return this.upperBound.endpoint();
    }
}
