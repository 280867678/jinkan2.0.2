package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import me.tvspark.AbstractC2239iy;
import me.tvspark.AbstractC2386mx;
import me.tvspark.AbstractC2420nu;
import me.tvspark.AbstractC2460ox;
import me.tvspark.C1997cv;
import me.tvspark.C2838yv;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class ImmutableRangeSet<C extends Comparable> extends AbstractC2420nu<C> implements Serializable {
    public transient ImmutableRangeSet<C> complement;
    public final transient ImmutableList<Range<C>> ranges;
    public static final ImmutableRangeSet<Comparable<?>> EMPTY = new ImmutableRangeSet<>(ImmutableList.m3919of());
    public static final ImmutableRangeSet<Comparable<?>> ALL = new ImmutableRangeSet<>(ImmutableList.m3918of(Range.all()));

    /* loaded from: classes3.dex */
    public final class AsSet extends ImmutableSortedSet<C> {
        public final DiscreteDomain<C> domain;
        public transient Integer size;

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractIterator<C> {
            public Iterator<C> Wwwwwwwwwwwwwwwwwwwww = C2838yv.Wwwwwwwwwwwwwwwwwwww;
            public final Iterator<Range<C>> Wwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                this.Wwwwwwwwwwwwwwwwwwwwww = ImmutableRangeSet.this.ranges.reverse().mo4735iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                while (!this.Wwwwwwwwwwwwwwwwwwwww.hasNext()) {
                    if (!this.Wwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return null;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwww = ContiguousSet.create(this.Wwwwwwwwwwwwwwwwwwwwww.next(), AsSet.this.domain).mo4723descendingIterator();
                }
                return this.Wwwwwwwwwwwwwwwwwwwww.next();
            }
        }

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractIterator<C> {
            public Iterator<C> Wwwwwwwwwwwwwwwwwwwww = C2838yv.Wwwwwwwwwwwwwwwwwwww;
            public final Iterator<Range<C>> Wwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                this.Wwwwwwwwwwwwwwwwwwwwww = ImmutableRangeSet.this.ranges.mo4735iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                while (!this.Wwwwwwwwwwwwwwwwwwwww.hasNext()) {
                    if (!this.Wwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return null;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwww = ContiguousSet.create(this.Wwwwwwwwwwwwwwwwwwwwww.next(), AsSet.this.domain).mo4735iterator();
                }
                return this.Wwwwwwwwwwwwwwwwwwwww.next();
            }
        }

        public AsSet(DiscreteDomain<C> discreteDomain) {
            super(Ordering.natural());
            this.domain = discreteDomain;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ImmutableRangeSet.this.contains((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> createDescendingSet() {
            return new DescendingImmutableSortedSet(this);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        /* renamed from: descendingIterator  reason: collision with other method in class */
        public AbstractC2239iy<C> mo4723descendingIterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public ImmutableSortedSet<C> headSetImpl(C c, boolean z) {
            return subSet(Range.upTo(c, BoundType.forBoolean(z)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object obj, boolean z) {
            return headSetImpl((AsSet) ((Comparable) obj), z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public int indexOf(Object obj) {
            if (contains(obj)) {
                Comparable comparable = (Comparable) obj;
                long j = 0;
                AbstractC2239iy mo4735iterator = ImmutableRangeSet.this.ranges.mo4735iterator();
                while (mo4735iterator.hasNext()) {
                    Range range = (Range) mo4735iterator.next();
                    if (range.contains(comparable)) {
                        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j + ContiguousSet.create(range, this.domain).indexOf(comparable));
                    }
                    j += ContiguousSet.create(range, this.domain).size();
                }
                throw new AssertionError("impossible");
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableRangeSet.this.ranges.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        /* renamed from: iterator  reason: collision with other method in class */
        public AbstractC2239iy<C> mo4735iterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer num = this.size;
            if (num == null) {
                long j = 0;
                AbstractC2239iy mo4735iterator = ImmutableRangeSet.this.ranges.mo4735iterator();
                while (mo4735iterator.hasNext()) {
                    j += ContiguousSet.create((Range) mo4735iterator.next(), this.domain).size();
                    if (j >= 2147483647L) {
                        break;
                    }
                }
                num = Integer.valueOf(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j));
                this.size = num;
            }
            return num.intValue();
        }

        public ImmutableSortedSet<C> subSet(Range<C> range) {
            return ImmutableRangeSet.this.m4587subRangeSet((Range) range).asSet(this.domain);
        }

        public ImmutableSortedSet<C> subSetImpl(C c, boolean z, C c2, boolean z2) {
            return (z || z2 || Range.compareOrThrow(c, c2) != 0) ? subSet(Range.range(c, BoundType.forBoolean(z), c2, BoundType.forBoolean(z2))) : ImmutableSortedSet.m3839of();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object obj, boolean z, Object obj2, boolean z2) {
            return subSetImpl((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
        }

        public ImmutableSortedSet<C> tailSetImpl(C c, boolean z) {
            return subSet(Range.downTo(c, BoundType.forBoolean(z)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object obj, boolean z) {
            return tailSetImpl((AsSet) ((Comparable) obj), z);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return ImmutableRangeSet.this.ranges.toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new AsSetSerializedForm(ImmutableRangeSet.this.ranges, this.domain);
        }
    }

    /* loaded from: classes3.dex */
    public static class AsSetSerializedForm<C extends Comparable> implements Serializable {
        public final DiscreteDomain<C> domain;
        public final ImmutableList<Range<C>> ranges;

        public AsSetSerializedForm(ImmutableList<Range<C>> immutableList, DiscreteDomain<C> discreteDomain) {
            this.ranges = immutableList;
            this.domain = discreteDomain;
        }

        public Object readResolve() {
            return new ImmutableRangeSet(this.ranges).asSet(this.domain);
        }
    }

    /* loaded from: classes3.dex */
    public final class ComplementRanges extends ImmutableList<Range<C>> {
        public final boolean positiveBoundedAbove;
        public final boolean positiveBoundedBelow;
        public final int size;

        public ComplementRanges() {
            this.positiveBoundedBelow = ((Range) ImmutableRangeSet.this.ranges.get(0)).hasLowerBound();
            this.positiveBoundedAbove = ((Range) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable<Object>) ImmutableRangeSet.this.ranges)).hasUpperBound();
            int size = ImmutableRangeSet.this.ranges.size() - 1;
            size = this.positiveBoundedBelow ? size + 1 : size;
            this.size = this.positiveBoundedAbove ? size + 1 : size;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        /* renamed from: get */
        public Range<C> mo4591get(int i) {
            Range range;
            Cut<C> cut;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.size);
            if (!this.positiveBoundedBelow) {
                range = ImmutableRangeSet.this.ranges.get(i);
            } else if (i == 0) {
                cut = Cut.belowAll();
                return Range.create(cut, (this.positiveBoundedAbove || i != this.size + (-1)) ? ((Range) ImmutableRangeSet.this.ranges.get(i + (!this.positiveBoundedBelow ? 1 : 0))).lowerBound : Cut.aboveAll());
            } else {
                range = ImmutableRangeSet.this.ranges.get(i - 1);
            }
            cut = range.upperBound;
            return Range.create(cut, (this.positiveBoundedAbove || i != this.size + (-1)) ? ((Range) ImmutableRangeSet.this.ranges.get(i + (!this.positiveBoundedBelow ? 1 : 0))).lowerBound : Cut.aboveAll());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }
    }

    /* loaded from: classes3.dex */
    public static final class SerializedForm<C extends Comparable> implements Serializable {
        public final ImmutableList<Range<C>> ranges;

        public SerializedForm(ImmutableList<Range<C>> immutableList) {
            this.ranges = immutableList;
        }

        public Object readResolve() {
            return this.ranges.isEmpty() ? ImmutableRangeSet.m3879of() : this.ranges.equals(ImmutableList.m3918of(Range.all())) ? ImmutableRangeSet.all() : new ImmutableRangeSet(this.ranges);
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<C extends Comparable<?>> {
        public final List<Range<C>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    }

    public ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        this.ranges = immutableList;
    }

    public ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        this.ranges = immutableList;
        this.complement = immutableRangeSet;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> all() {
        return ALL;
    }

    public static <C extends Comparable<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<C> builder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(AbstractC2460ox<C> abstractC2460ox) {
        if (abstractC2460ox != null) {
            if (abstractC2460ox.isEmpty()) {
                return m3879of();
            }
            if (abstractC2460ox.encloses(Range.all())) {
                return all();
            }
            if (abstractC2460ox instanceof ImmutableRangeSet) {
                ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) abstractC2460ox;
                if (!immutableRangeSet.isPartialView()) {
                    return immutableRangeSet;
                }
            }
            return new ImmutableRangeSet<>(ImmutableList.copyOf((Collection) abstractC2460ox.mo4585asRanges()));
        }
        throw null;
    }

    private ImmutableList<Range<C>> intersectRanges(final Range<C> range) {
        if (this.ranges.isEmpty() || range.isEmpty()) {
            return ImmutableList.m3919of();
        }
        if (range.encloses(span())) {
            return this.ranges;
        }
        final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = range.hasLowerBound() ? Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists$KeyPresentBehavior.FIRST_AFTER, SortedLists$KeyAbsentBehavior.NEXT_HIGHER) : 0;
        final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = (range.hasUpperBound() ? Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists$KeyPresentBehavior.FIRST_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_HIGHER) : this.ranges.size()) - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 0 ? ImmutableList.m3919of() : (ImmutableList<Range<C>>) new ImmutableList<Range<C>>() { // from class: com.google.common.collect.ImmutableRangeSet.1
            @Override // java.util.List
            /* renamed from: get */
            public Range<C> mo4588get(int i) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                return (i == 0 || i == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 + (-1)) ? ((Range) ImmutableRangeSet.this.ranges.get(i + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)).intersection(range) : (Range) ImmutableRangeSet.this.ranges.get(i + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            }
        };
    }

    /* renamed from: of */
    public static <C extends Comparable> ImmutableRangeSet<C> m3879of() {
        return EMPTY;
    }

    /* renamed from: of */
    public static <C extends Comparable> ImmutableRangeSet<C> m3878of(Range<C> range) {
        if (range != null) {
            return range.isEmpty() ? m3879of() : range.equals(Range.all()) ? all() : new ImmutableRangeSet<>(ImmutableList.m3918of(range));
        }
        throw null;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> iterable) {
        return copyOf(TreeRangeSet.create(iterable));
    }

    @Override // me.tvspark.AbstractC2420nu
    @Deprecated
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2420nu
    @Deprecated
    public void addAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2420nu
    @Deprecated
    public void addAll(AbstractC2460ox<C> abstractC2460ox) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: asDescendingSetOfRanges */
    public ImmutableSet<Range<C>> m4584asDescendingSetOfRanges() {
        return this.ranges.isEmpty() ? ImmutableSet.m3877of() : new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse());
    }

    @Override // me.tvspark.AbstractC2460ox
    /* renamed from: asRanges */
    public ImmutableSet<Range<C>> mo4585asRanges() {
        return this.ranges.isEmpty() ? ImmutableSet.m3877of() : new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering());
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> discreteDomain) {
        if (discreteDomain != null) {
            if (isEmpty()) {
                return ImmutableSortedSet.m3839of();
            }
            Range<C> canonical = span().canonical(discreteDomain);
            if (!canonical.hasLowerBound()) {
                throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
            }
            if (!canonical.hasUpperBound()) {
                try {
                    discreteDomain.maxValue();
                } catch (NoSuchElementException unused) {
                    throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
                }
            }
            return new AsSet(discreteDomain);
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2420nu
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // me.tvspark.AbstractC2460ox
    /* renamed from: complement */
    public ImmutableRangeSet<C> mo4586complement() {
        ImmutableRangeSet<C> m3879of;
        ImmutableRangeSet<C> immutableRangeSet = this.complement;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.ranges.isEmpty()) {
            m3879of = all();
        } else if (this.ranges.size() != 1 || !this.ranges.get(0).equals(Range.all())) {
            ImmutableRangeSet<C> immutableRangeSet2 = new ImmutableRangeSet<>(new ComplementRanges(), this);
            this.complement = immutableRangeSet2;
            return immutableRangeSet2;
        } else {
            m3879of = m3879of();
        }
        this.complement = m3879of;
        return m3879of;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2420nu
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    public ImmutableRangeSet<C> difference(AbstractC2460ox<C> abstractC2460ox) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(abstractC2460ox);
        return copyOf(create);
    }

    @Override // me.tvspark.AbstractC2420nu, me.tvspark.AbstractC2460ox
    public boolean encloses(Range<C> range) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_LOWER);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -1 && this.ranges.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).encloses(range);
    }

    @Override // me.tvspark.AbstractC2420nu
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // me.tvspark.AbstractC2420nu
    public /* bridge */ /* synthetic */ boolean enclosesAll(AbstractC2460ox abstractC2460ox) {
        return super.enclosesAll(abstractC2460ox);
    }

    @Override // me.tvspark.AbstractC2420nu
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public ImmutableRangeSet<C> intersection(AbstractC2460ox<C> abstractC2460ox) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(abstractC2460ox.mo4586complement());
        return copyOf(create);
    }

    @Override // me.tvspark.AbstractC2420nu
    public boolean intersects(Range<C> range) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 >= this.ranges.size() || !this.ranges.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).isConnected(range) || this.ranges.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).intersection(range).isEmpty()) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 > 0) {
                int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - 1;
                if (this.ranges.get(i).isConnected(range) && !this.ranges.get(i).intersection(range).isEmpty()) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // me.tvspark.AbstractC2420nu, me.tvspark.AbstractC2460ox
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    public boolean isPartialView() {
        return this.ranges.isPartialView();
    }

    @Override // me.tvspark.AbstractC2420nu
    public Range<C> rangeContaining(C c) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ranges, Range.lowerBoundFn(), Cut.belowValue(c), Ordering.natural(), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_LOWER);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -1) {
            Range<C> range = this.ranges.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            if (!range.contains(c)) {
                return null;
            }
            return range;
        }
        return null;
    }

    @Override // me.tvspark.AbstractC2420nu
    @Deprecated
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2420nu
    @Deprecated
    public void removeAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2420nu, me.tvspark.AbstractC2460ox
    @Deprecated
    public void removeAll(AbstractC2460ox<C> abstractC2460ox) {
        throw new UnsupportedOperationException();
    }

    public Range<C> span() {
        if (!this.ranges.isEmpty()) {
            Cut<C> cut = this.ranges.get(0).lowerBound;
            ImmutableList<Range<C>> immutableList = this.ranges;
            return Range.create(cut, immutableList.get(immutableList.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    /* renamed from: subRangeSet */
    public ImmutableRangeSet<C> m4587subRangeSet(Range<C> range) {
        if (!isEmpty()) {
            Range<C> span = span();
            if (range.encloses(span)) {
                return this;
            }
            if (range.isConnected(span)) {
                return new ImmutableRangeSet<>(intersectRanges(range));
            }
        }
        return m3879of();
    }

    public ImmutableRangeSet<C> union(AbstractC2460ox<C> abstractC2460ox) {
        Iterable[] iterableArr = {mo4585asRanges(), abstractC2460ox.mo4585asRanges()};
        for (int i = 0; i < 2; i++) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterableArr[i]);
        }
        return unionOf(new C1997cv(iterableArr));
    }

    public Object writeReplace() {
        return new SerializedForm(this.ranges);
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> iterable) {
        ArrayList arrayList = new ArrayList();
        for (Range<C> range : iterable) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true ^ range.isEmpty(), "range must not be empty, but was %s", range);
            arrayList.add(range);
        }
        ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList.size());
        Collections.sort(arrayList, Range.rangeLexOrdering());
        AbstractC2386mx Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList.iterator());
        while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hasNext()) {
            Range range2 = (Range) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.next();
            while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                Range<C> range3 = (Range) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.peek();
                if (range2.isConnected(range3)) {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(range2.intersection(range3).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", range2, range3);
                    range2 = range2.span((Range) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.next());
                }
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) range2);
        }
        ImmutableList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.isEmpty() ? m3879of() : (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.size() != 1 || !((Range) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable<Object>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)).equals(Range.all())) ? new ImmutableRangeSet<>(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) : all();
    }
}
