package com.google.common.collect;

import com.google.common.collect.ImmutableSortedSet;
import java.lang.Comparable;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    public final DiscreteDomain<C> domain;

    public ContiguousSet(DiscreteDomain<C> discreteDomain) {
        super(Ordering.natural());
        this.domain = discreteDomain;
    }

    @Deprecated
    public static <E> ImmutableSortedSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> builder() {
        throw new UnsupportedOperationException();
    }

    public static ContiguousSet<Integer> closed(int i, int i2) {
        return create(Range.closed(Integer.valueOf(i), Integer.valueOf(i2)), DiscreteDomain.integers());
    }

    public static ContiguousSet<Long> closed(long j, long j2) {
        return create(Range.closed(Long.valueOf(j), Long.valueOf(j2)), DiscreteDomain.longs());
    }

    public static ContiguousSet<Integer> closedOpen(int i, int i2) {
        return create(Range.closedOpen(Integer.valueOf(i), Integer.valueOf(i2)), DiscreteDomain.integers());
    }

    public static ContiguousSet<Long> closedOpen(long j, long j2) {
        return create(Range.closedOpen(Long.valueOf(j), Long.valueOf(j2)), DiscreteDomain.longs());
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> range, DiscreteDomain<C> discreteDomain) {
        if (range != null) {
            if (discreteDomain == null) {
                throw null;
            }
            try {
                Range<C> intersection = !range.hasLowerBound() ? range.intersection(Range.atLeast(discreteDomain.minValue())) : range;
                if (!range.hasUpperBound()) {
                    intersection = intersection.intersection(Range.atMost(discreteDomain.maxValue()));
                }
                return intersection.isEmpty() || Range.compareOrThrow(range.lowerBound.leastValueAbove(discreteDomain), range.upperBound.greatestValueBelow(discreteDomain)) > 0 ? new EmptyContiguousSet(discreteDomain) : new RegularContiguousSet(intersection, discreteDomain);
            } catch (NoSuchElementException e) {
                throw new IllegalArgumentException(e);
            }
        }
        throw null;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<C> createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    public ContiguousSet<C> headSet(C c) {
        if (c != null) {
            return headSetImpl((ContiguousSet<C>) c, false);
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    /* renamed from: headSet */
    public /* bridge */ /* synthetic */ ImmutableSortedSet mo4502headSet(Object obj) {
        return headSet((ContiguousSet<C>) ((Comparable) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* renamed from: headSet */
    public /* bridge */ /* synthetic */ ImmutableSortedSet mo4501headSet(Object obj, boolean z) {
        return headSet((ContiguousSet<C>) ((Comparable) obj), z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* renamed from: headSet  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ NavigableSet mo4501headSet(Object obj, boolean z) {
        return headSet((ContiguousSet<C>) ((Comparable) obj), z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    /* renamed from: headSet  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ SortedSet mo4502headSet(Object obj) {
        return headSet((ContiguousSet<C>) ((Comparable) obj));
    }

    public abstract ContiguousSet<C> headSetImpl(C c, boolean z);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object obj, boolean z) {
        return headSetImpl((ContiguousSet<C>) ((Comparable) obj), z);
    }

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType boundType, BoundType boundType2);

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    /* renamed from: subSet */
    public ContiguousSet<C> mo4504subSet(C c, C c2) {
        if (c != null) {
            if (c2 == null) {
                throw null;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator().compare(c, c2) <= 0);
            return subSetImpl((boolean) c, true, (boolean) c2, false);
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* renamed from: subSet */
    public /* bridge */ /* synthetic */ ImmutableSortedSet mo4503subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return subSet((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* renamed from: subSet  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ NavigableSet mo4503subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return subSet((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
    }

    public abstract ContiguousSet<C> subSetImpl(C c, boolean z, C c2, boolean z2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object obj, boolean z, Object obj2, boolean z2) {
        return subSetImpl((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
    }

    public ContiguousSet<C> tailSet(C c) {
        if (c != null) {
            return tailSetImpl((ContiguousSet<C>) c, true);
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    /* renamed from: tailSet */
    public /* bridge */ /* synthetic */ ImmutableSortedSet mo4506tailSet(Object obj) {
        return tailSet((ContiguousSet<C>) ((Comparable) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* renamed from: tailSet */
    public /* bridge */ /* synthetic */ ImmutableSortedSet mo4505tailSet(Object obj, boolean z) {
        return tailSet((ContiguousSet<C>) ((Comparable) obj), z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* renamed from: tailSet  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ NavigableSet mo4505tailSet(Object obj, boolean z) {
        return tailSet((ContiguousSet<C>) ((Comparable) obj), z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    /* renamed from: tailSet  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ SortedSet mo4506tailSet(Object obj) {
        return tailSet((ContiguousSet<C>) ((Comparable) obj));
    }

    public abstract ContiguousSet<C> tailSetImpl(C c, boolean z);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object obj, boolean z) {
        return tailSetImpl((ContiguousSet<C>) ((Comparable) obj), z);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return range().toString();
    }

    public ContiguousSet<C> headSet(C c, boolean z) {
        if (c != null) {
            return headSetImpl((ContiguousSet<C>) c, z);
        }
        throw null;
    }

    public ContiguousSet<C> subSet(C c, boolean z, C c2, boolean z2) {
        if (c != null) {
            if (c2 == null) {
                throw null;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator().compare(c, c2) <= 0);
            return subSetImpl((boolean) c, z, (boolean) c2, z2);
        }
        throw null;
    }

    public ContiguousSet<C> tailSet(C c, boolean z) {
        if (c != null) {
            return tailSetImpl((ContiguousSet<C>) c, z);
        }
        throw null;
    }
}
