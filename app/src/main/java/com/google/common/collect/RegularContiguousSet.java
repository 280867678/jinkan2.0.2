package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Set;
import me.tvspark.AbstractC2239iy;
import me.tvspark.AbstractC2457ou;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    public static final long serialVersionUID = 0;
    public final Range<C> range;

    /* loaded from: classes3.dex */
    public static final class SerializedForm<C extends Comparable> implements Serializable {
        public final DiscreteDomain<C> domain;
        public final Range<C> range;

        public SerializedForm(Range<C> range, DiscreteDomain<C> discreteDomain) {
            this.range = range;
            this.domain = discreteDomain;
        }

        public /* synthetic */ SerializedForm(Range range, DiscreteDomain discreteDomain, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this(range, discreteDomain);
        }

        private Object readResolve() {
            return new RegularContiguousSet(this.range, this.domain);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2457ou<C> {
        public final C Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparable comparable) {
            super(comparable);
            this.Wwwwwwwwwwwwwwwwwwwwwww = (C) RegularContiguousSet.this.mo4707first();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // me.tvspark.AbstractC2457ou
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            Comparable comparable = (Comparable) obj;
            if (RegularContiguousSet.equalsOrThrow(comparable, this.Wwwwwwwwwwwwwwwwwwwwwww)) {
                return null;
            }
            return RegularContiguousSet.this.domain.previous(comparable);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2457ou<C> {
        public final C Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparable comparable) {
            super(comparable);
            this.Wwwwwwwwwwwwwwwwwwwwwww = (C) RegularContiguousSet.this.mo4709last();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // me.tvspark.AbstractC2457ou
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            Comparable comparable = (Comparable) obj;
            if (RegularContiguousSet.equalsOrThrow(comparable, this.Wwwwwwwwwwwwwwwwwwwwwww)) {
                return null;
            }
            return RegularContiguousSet.this.domain.next(comparable);
        }
    }

    public RegularContiguousSet(Range<C> range, DiscreteDomain<C> discreteDomain) {
        super(discreteDomain);
        this.range = range;
    }

    public static boolean equalsOrThrow(Comparable<?> comparable, Comparable<?> comparable2) {
        return comparable2 != null && Range.compareOrThrow(comparable, comparable2) == 0;
    }

    private ContiguousSet<C> intersectionInCurrentDomain(Range<C> range) {
        return this.range.isConnected(range) ? ContiguousSet.create(this.range.intersection(range), this.domain) : new EmptyContiguousSet(this.domain);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.range.contains((Comparable) obj);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection<?>) this, collection);
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<C> createAsList() {
        return this.domain.supportsFastOffset ? new ImmutableAsList<C>() { // from class: com.google.common.collect.RegularContiguousSet.3
            @Override // com.google.common.collect.ImmutableAsList
            /* renamed from: delegateCollection  reason: collision with other method in class */
            public ImmutableSortedSet<C> mo4710delegateCollection() {
                return RegularContiguousSet.this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.List
            /* renamed from: get */
            public C mo4711get(int i) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, size());
                RegularContiguousSet regularContiguousSet = RegularContiguousSet.this;
                return (C) regularContiguousSet.domain.offset(regularContiguousSet.mo4707first(), i);
            }
        } : super.createAsList();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* renamed from: descendingIterator  reason: collision with other method in class */
    public AbstractC2239iy<C> mo4723descendingIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4709last());
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RegularContiguousSet) {
            RegularContiguousSet regularContiguousSet = (RegularContiguousSet) obj;
            if (this.domain.equals(regularContiguousSet.domain)) {
                return mo4707first().equals(regularContiguousSet.mo4707first()) && mo4709last().equals(regularContiguousSet.mo4709last());
            }
        }
        return super.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    /* renamed from: first */
    public C mo4707first() {
        return this.range.lowerBound.leastValueAbove(this.domain);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) this);
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> headSetImpl(C c, boolean z) {
        return intersectionInCurrentDomain(Range.upTo(c, BoundType.forBoolean(z)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object obj, boolean z) {
        return headSetImpl((RegularContiguousSet<C>) ((Comparable) obj), z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(Object obj) {
        if (contains(obj)) {
            return (int) this.domain.distance(mo4707first(), (Comparable) obj);
        }
        return -1;
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet) {
        if (contiguousSet != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.domain.equals(contiguousSet.domain));
            if (contiguousSet.isEmpty()) {
                return contiguousSet;
            }
            Comparable comparable = (Comparable) Ordering.natural().max(mo4707first(), contiguousSet.mo4707first());
            Comparable comparable2 = (Comparable) Ordering.natural().min(mo4709last(), contiguousSet.mo4709last());
            return comparable.compareTo(comparable2) <= 0 ? ContiguousSet.create(Range.closed(comparable, comparable2), this.domain) : new EmptyContiguousSet(this.domain);
        }
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* renamed from: iterator  reason: collision with other method in class */
    public AbstractC2239iy<C> mo4735iterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4707first());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    /* renamed from: last */
    public C mo4709last() {
        return this.range.upperBound.greatestValueBelow(this.domain);
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range() {
        BoundType boundType = BoundType.CLOSED;
        return range(boundType, boundType);
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range(BoundType boundType, BoundType boundType2) {
        return Range.create(this.range.lowerBound.withLowerBoundType(boundType, this.domain), this.range.upperBound.withUpperBoundType(boundType2, this.domain));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long distance = this.domain.distance(mo4707first(), mo4709last());
        if (distance >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return ((int) distance) + 1;
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> subSetImpl(C c, boolean z, C c2, boolean z2) {
        return (c.compareTo(c2) != 0 || z || z2) ? intersectionInCurrentDomain(Range.range(c, BoundType.forBoolean(z), c2, BoundType.forBoolean(z2))) : new EmptyContiguousSet(this.domain);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object obj, boolean z, Object obj2, boolean z2) {
        return subSetImpl((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> tailSetImpl(C c, boolean z) {
        return intersectionInCurrentDomain(Range.downTo(c, BoundType.forBoolean(z)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object obj, boolean z) {
        return tailSetImpl((RegularContiguousSet<C>) ((Comparable) obj), z);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this.range, this.domain, null);
    }
}
