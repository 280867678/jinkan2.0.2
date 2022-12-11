package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import me.tvspark.AbstractC2051dv;
import me.tvspark.AbstractC2383mu;
import me.tvspark.AbstractC2386mx;
import me.tvspark.AbstractC2420nu;
import me.tvspark.AbstractC2460ox;
import me.tvspark.C2838yv;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class TreeRangeSet<C extends Comparable<?>> extends AbstractC2420nu<C> implements Serializable {
    public transient Set<Range<C>> asDescendingSetOfRanges;
    public transient Set<Range<C>> asRanges;
    public transient AbstractC2460ox<C> complement;
    public final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* loaded from: classes3.dex */
    public final class Complement extends TreeRangeSet<C> {
        public Complement() {
            super(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TreeRangeSet.this.rangesByLowerBound));
        }

        @Override // com.google.common.collect.TreeRangeSet, me.tvspark.AbstractC2420nu
        public void add(Range<C> range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, me.tvspark.AbstractC2460ox
        /* renamed from: complement */
        public AbstractC2460ox<C> mo4586complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.common.collect.TreeRangeSet, me.tvspark.AbstractC2420nu
        public boolean contains(C c) {
            return !TreeRangeSet.this.contains(c);
        }

        @Override // com.google.common.collect.TreeRangeSet, me.tvspark.AbstractC2420nu
        public void remove(Range<C> range) {
            TreeRangeSet.this.add(range);
        }
    }

    /* loaded from: classes3.dex */
    public final class SubRangeSet extends TreeRangeSet<C> {
        public final Range<C> restriction;

        public SubRangeSet(Range<C> range) {
            super(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Range.all(), range, TreeRangeSet.this.rangesByLowerBound));
            this.restriction = range;
        }

        @Override // com.google.common.collect.TreeRangeSet, me.tvspark.AbstractC2420nu
        public void add(Range<C> range) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
            super.add(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, me.tvspark.AbstractC2420nu
        public void clear() {
            TreeRangeSet.this.remove(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, me.tvspark.AbstractC2420nu
        public boolean contains(C c) {
            return this.restriction.contains(c) && TreeRangeSet.this.contains(c);
        }

        @Override // com.google.common.collect.TreeRangeSet, me.tvspark.AbstractC2420nu, me.tvspark.AbstractC2460ox
        public boolean encloses(Range<C> range) {
            Range rangeEnclosing;
            return !this.restriction.isEmpty() && this.restriction.encloses(range) && (rangeEnclosing = TreeRangeSet.this.rangeEnclosing(range)) != null && !rangeEnclosing.intersection(this.restriction).isEmpty();
        }

        @Override // com.google.common.collect.TreeRangeSet, me.tvspark.AbstractC2420nu
        public Range<C> rangeContaining(C c) {
            Range<C> rangeContaining;
            if (this.restriction.contains(c) && (rangeContaining = TreeRangeSet.this.rangeContaining(c)) != null) {
                return rangeContaining.intersection(this.restriction);
            }
            return null;
        }

        @Override // com.google.common.collect.TreeRangeSet, me.tvspark.AbstractC2420nu
        public void remove(Range<C> range) {
            if (range.isConnected(this.restriction)) {
                TreeRangeSet.this.remove(range.intersection(this.restriction));
            }
        }

        @Override // com.google.common.collect.TreeRangeSet
        public AbstractC2460ox<C> subRangeSet(Range<C> range) {
            return range.encloses(this.restriction) ? this : range.isConnected(this.restriction) ? new SubRangeSet(this.restriction.intersection(range)) : ImmutableRangeSet.m3879of();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<C extends Comparable<?>> extends AbstractC2383mu<Cut<C>, Range<C>> {
        public final NavigableMap<Cut<C>, Range<C>> Wwwwwwwwwwwwwwwwwwwww;
        public final NavigableMap<Cut<C>, Range<C>> Wwwwwwwwwwwwwwwwwwwwww;
        public final Range<C> Wwwwwwwwwwwwwwwwwwwwwww;
        public final Range<Cut<C>> Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public final /* synthetic */ Iterator Wwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator it) {
                this.Wwwwwwwwwwwwwwwwwwwwww = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                if (this.Wwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                    Range range = (Range) this.Wwwwwwwwwwwwwwwwwwwwww.next();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwww.lowerBound.compareTo(range.upperBound) < 0) {
                        Range intersection = range.intersection(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwww);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.contains(intersection.lowerBound)) {
                            return new ImmutableEntry(intersection.lowerBound, intersection);
                        }
                    }
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return null;
            }
        }

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public final /* synthetic */ Cut Wwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ Iterator Wwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator it, Cut cut) {
                this.Wwwwwwwwwwwwwwwwwwwwww = it;
                this.Wwwwwwwwwwwwwwwwwwwww = cut;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                if (this.Wwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                    Range range = (Range) this.Wwwwwwwwwwwwwwwwwwwwww.next();
                    if (!this.Wwwwwwwwwwwwwwwwwwwww.isLessThan(range.lowerBound)) {
                        Range intersection = range.intersection(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwww);
                        return new ImmutableEntry(intersection.lowerBound, intersection);
                    }
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return null;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Range<Cut<C>> range, Range<C> range2, NavigableMap<Cut<C>, Range<C>> navigableMap) {
            if (range != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = range;
                if (range2 == null) {
                    throw null;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww = range2;
                if (navigableMap == null) {
                    throw null;
                }
                this.Wwwwwwwwwwwwwwwwwwwwww = navigableMap;
                this.Wwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(navigableMap);
                return;
            }
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // me.tvspark.AbstractC2383mu
        public Iterator<Map.Entry<Cut<C>, Range<C>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                return C2838yv.Wwwwwwwwwwwwwwwwwwww;
            }
            Cut cut = (Cut) Ordering.natural().min(this.Wwwwwwwwwwwwwwwwwwwwwwww.upperBound, Cut.belowValue(this.Wwwwwwwwwwwwwwwwwwwwwww.upperBound));
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww.headMap(cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator());
        }

        @Override // me.tvspark.AbstractC2502pw
        public Iterator<Map.Entry<Cut<C>, Range<C>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            NavigableMap<Cut<C>, Range<C>> navigableMap;
            Cut<C> endpoint;
            if (this.Wwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                return C2838yv.Wwwwwwwwwwwwwwwwwwww;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww.upperBound.isLessThan(this.Wwwwwwwwwwwwwwwwwwwwwww.lowerBound)) {
                return C2838yv.Wwwwwwwwwwwwwwwwwwww;
            }
            boolean z = false;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww.lowerBound.isLessThan(this.Wwwwwwwwwwwwwwwwwwwwwww.lowerBound)) {
                navigableMap = this.Wwwwwwwwwwwwwwwwwwwww;
                endpoint = this.Wwwwwwwwwwwwwwwwwwwwwww.lowerBound;
            } else {
                navigableMap = this.Wwwwwwwwwwwwwwwwwwwwww;
                endpoint = this.Wwwwwwwwwwwwwwwwwwwwwwww.lowerBound.endpoint();
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww.lowerBoundType() == BoundType.CLOSED) {
                    z = true;
                }
            }
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(navigableMap.tailMap(endpoint, z).values().iterator(), (Cut) Ordering.natural().min(this.Wwwwwwwwwwwwwwwwwwwwwwww.upperBound, Cut.belowValue(this.Wwwwwwwwwwwwwwwwwwwwwww.upperBound)));
        }

        public final NavigableMap<Cut<C>, Range<C>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Range<Cut<C>> range) {
            return !range.isConnected(this.Wwwwwwwwwwwwwwwwwwwwwwww) ? ImmutableSortedMap.m3864of() : new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.intersection(range), this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return mo4795get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: get */
        public Range<C> mo4795get(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwww.contains(cut) && cut.compareTo(this.Wwwwwwwwwwwwwwwwwwwwwww.lowerBound) >= 0 && cut.compareTo(this.Wwwwwwwwwwwwwwwwwwwwwww.upperBound) < 0) {
                        if (cut.equals(this.Wwwwwwwwwwwwwwwwwwwwwww.lowerBound)) {
                            Map.Entry<Cut<C>, Range<C>> floorEntry = this.Wwwwwwwwwwwwwwwwwwwwww.floorEntry(cut);
                            Range<C> value = floorEntry == null ? null : floorEntry.getValue();
                            if (value != null && value.upperBound.compareTo(this.Wwwwwwwwwwwwwwwwwwwwwww.lowerBound) > 0) {
                                return value.intersection(this.Wwwwwwwwwwwwwwwwwwwwwww);
                            }
                        } else {
                            Range range = (Range) this.Wwwwwwwwwwwwwwwwwwwwww.get(cut);
                            if (range != null) {
                                return range.intersection(this.Wwwwwwwwwwwwwwwwwwwwwww);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Range.upTo((Cut) obj, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Range.range((Cut) obj, BoundType.forBoolean(z), (Cut) obj2, BoundType.forBoolean(z2)));
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Range.downTo((Cut) obj, BoundType.forBoolean(z)));
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<C extends Comparable<?>> extends AbstractC2383mu<Cut<C>, Range<C>> {
        public final Range<Cut<C>> Wwwwwwwwwwwwwwwwwwwwwww;
        public final NavigableMap<Cut<C>, Range<C>> Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public final /* synthetic */ AbstractC2386mx Wwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2386mx abstractC2386mx) {
                this.Wwwwwwwwwwwwwwwwwwwwww = abstractC2386mx;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                if (this.Wwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                    Range range = (Range) this.Wwwwwwwwwwwwwwwwwwwwww.next();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwww.lowerBound.isLessThan(range.upperBound)) {
                        return new ImmutableEntry(range.upperBound, range);
                    }
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return null;
            }
        }

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public final /* synthetic */ Iterator Wwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator it) {
                this.Wwwwwwwwwwwwwwwwwwwwww = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                if (this.Wwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                    Range range = (Range) this.Wwwwwwwwwwwwwwwwwwwwww.next();
                    if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwww.upperBound.isLessThan(range.upperBound)) {
                        return new ImmutableEntry(range.upperBound, range);
                    }
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return null;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = navigableMap;
            this.Wwwwwwwwwwwwwwwwwwwwwww = Range.all();
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = navigableMap;
            this.Wwwwwwwwwwwwwwwwwwwwwww = range;
        }

        @Override // me.tvspark.AbstractC2383mu
        public Iterator<Map.Entry<Cut<C>, Range<C>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            AbstractC2386mx Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator) (this.Wwwwwwwwwwwwwwwwwwwwwww.hasUpperBound() ? this.Wwwwwwwwwwwwwwwwwwwwwwww.headMap(this.Wwwwwwwwwwwwwwwwwwwwwww.upperEndpoint(), false) : this.Wwwwwwwwwwwwwwwwwwwwwwww).descendingMap().values().iterator());
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasNext() && this.Wwwwwwwwwwwwwwwwwwwwwww.upperBound.isLessThan(((Range) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.peek()).upperBound)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.next();
            }
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }

        @Override // me.tvspark.AbstractC2502pw
        public Iterator<Map.Entry<Cut<C>, Range<C>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Map.Entry<Cut<C>, Range<C>> lowerEntry;
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((this.Wwwwwwwwwwwwwwwwwwwwwww.hasLowerBound() && (lowerEntry = this.Wwwwwwwwwwwwwwwwwwwwwwww.lowerEntry(this.Wwwwwwwwwwwwwwwwwwwwwww.lowerEndpoint())) != null) ? this.Wwwwwwwwwwwwwwwwwwwwwww.lowerBound.isLessThan(lowerEntry.getValue().upperBound) ? this.Wwwwwwwwwwwwwwwwwwwwwwww.tailMap(lowerEntry.getKey(), true) : this.Wwwwwwwwwwwwwwwwwwwwwwww.tailMap(this.Wwwwwwwwwwwwwwwwwwwwwww.lowerEndpoint(), true) : this.Wwwwwwwwwwwwwwwwwwwwwwww).values().iterator());
        }

        public final NavigableMap<Cut<C>, Range<C>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Range<Cut<C>> range) {
            return range.isConnected(this.Wwwwwwwwwwwwwwwwwwwwwww) ? new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, range.intersection(this.Wwwwwwwwwwwwwwwwwwwwwww)) : ImmutableSortedMap.m3864of();
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return mo4796get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: get */
        public Range<C> mo4796get(Object obj) {
            Map.Entry<Cut<C>, Range<C>> lowerEntry;
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.Wwwwwwwwwwwwwwwwwwwwwww.contains(cut) && (lowerEntry = this.Wwwwwwwwwwwwwwwwwwwwwwww.lowerEntry(cut)) != null && lowerEntry.getValue().upperBound.equals(cut)) {
                        return lowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Range.upTo((Cut) obj, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.equals(Range.all()) ? this.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty() : !((AbstractIterator) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).hasNext();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.equals(Range.all()) ? this.Wwwwwwwwwwwwwwwwwwwwwwww.size() : Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Range.range((Cut) obj, BoundType.forBoolean(z), (Cut) obj2, BoundType.forBoolean(z2)));
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Range.downTo((Cut) obj, BoundType.forBoolean(z)));
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<C extends Comparable<?>> extends AbstractC2383mu<Cut<C>, Range<C>> {
        public final Range<Cut<C>> Wwwwwwwwwwwwwwwwwwwwww;
        public final NavigableMap<Cut<C>, Range<C>> Wwwwwwwwwwwwwwwwwwwwwww;
        public final NavigableMap<Cut<C>, Range<C>> Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public final /* synthetic */ AbstractC2386mx Wwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ Cut Wwwwwwwwwwwwwwwwwwwww;
            public Cut<C> Wwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Cut cut, AbstractC2386mx abstractC2386mx) {
                this.Wwwwwwwwwwwwwwwwwwwww = cut;
                this.Wwwwwwwwwwwwwwwwwwww = abstractC2386mx;
                this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                if (this.Wwwwwwwwwwwwwwwwwwwwww != Cut.belowAll()) {
                    if (this.Wwwwwwwwwwwwwwwwwwww.hasNext()) {
                        Range range = (Range) this.Wwwwwwwwwwwwwwwwwwww.next();
                        Range create = Range.create(range.upperBound, this.Wwwwwwwwwwwwwwwwwwwwww);
                        this.Wwwwwwwwwwwwwwwwwwwwww = range.lowerBound;
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwww.lowerBound.isLessThan(create.lowerBound)) {
                            return new ImmutableEntry(create.lowerBound, create);
                        }
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwww.lowerBound.isLessThan(Cut.belowAll())) {
                        Range create2 = Range.create(Cut.belowAll(), this.Wwwwwwwwwwwwwwwwwwwwww);
                        this.Wwwwwwwwwwwwwwwwwwwwww = Cut.belowAll();
                        return new ImmutableEntry(Cut.belowAll(), create2);
                    }
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return null;
            }
        }

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public final /* synthetic */ AbstractC2386mx Wwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ Cut Wwwwwwwwwwwwwwwwwwwww;
            public Cut<C> Wwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Cut cut, AbstractC2386mx abstractC2386mx) {
                this.Wwwwwwwwwwwwwwwwwwwww = cut;
                this.Wwwwwwwwwwwwwwwwwwww = abstractC2386mx;
                this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                Range create;
                Cut<C> aboveAll;
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwww.upperBound.isLessThan(this.Wwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwww != Cut.aboveAll()) {
                    if (this.Wwwwwwwwwwwwwwwwwwww.hasNext()) {
                        Range range = (Range) this.Wwwwwwwwwwwwwwwwwwww.next();
                        create = Range.create(this.Wwwwwwwwwwwwwwwwwwwwww, range.lowerBound);
                        aboveAll = range.upperBound;
                    } else {
                        create = Range.create(this.Wwwwwwwwwwwwwwwwwwwwww, Cut.aboveAll());
                        aboveAll = Cut.aboveAll();
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwww = aboveAll;
                    return new ImmutableEntry(create.lowerBound, create);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return null;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            Range<Cut<C>> all = Range.all();
            this.Wwwwwwwwwwwwwwwwwwwwwwww = navigableMap;
            this.Wwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(navigableMap);
            this.Wwwwwwwwwwwwwwwwwwwwww = all;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = navigableMap;
            this.Wwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(navigableMap);
            this.Wwwwwwwwwwwwwwwwwwwwww = range;
        }

        @Override // me.tvspark.AbstractC2383mu
        public Iterator<Map.Entry<Cut<C>, Range<C>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            NavigableMap<Cut<C>, Range<C>> navigableMap;
            Cut<C> belowAll;
            Cut<C> higherKey;
            AbstractC2386mx Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator) this.Wwwwwwwwwwwwwwwwwwwwwww.headMap(this.Wwwwwwwwwwwwwwwwwwwwww.hasUpperBound() ? this.Wwwwwwwwwwwwwwwwwwwwww.upperEndpoint() : Cut.aboveAll(), this.Wwwwwwwwwwwwwwwwwwwwww.hasUpperBound() && this.Wwwwwwwwwwwwwwwwwwwwww.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasNext()) {
                if (((Range) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.peek()).upperBound == Cut.aboveAll()) {
                    higherKey = ((Range) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.next()).lowerBound;
                    return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Cut) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(higherKey, Cut.aboveAll()), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                }
                navigableMap = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                belowAll = ((Range) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.peek()).upperBound;
            } else if (!this.Wwwwwwwwwwwwwwwwwwwwww.contains(Cut.belowAll()) || this.Wwwwwwwwwwwwwwwwwwwwwwww.containsKey(Cut.belowAll())) {
                return C2838yv.Wwwwwwwwwwwwwwwwwwww;
            } else {
                navigableMap = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                belowAll = Cut.belowAll();
            }
            higherKey = navigableMap.higherKey(belowAll);
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Cut) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(higherKey, Cut.aboveAll()), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }

        @Override // me.tvspark.AbstractC2502pw
        public Iterator<Map.Entry<Cut<C>, Range<C>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            NavigableMap<Cut<C>, Range<C>> navigableMap;
            Cut cut;
            if (this.Wwwwwwwwwwwwwwwwwwwwww.hasLowerBound()) {
                navigableMap = this.Wwwwwwwwwwwwwwwwwwwwwww.tailMap(this.Wwwwwwwwwwwwwwwwwwwwww.lowerEndpoint(), this.Wwwwwwwwwwwwwwwwwwwwww.lowerBoundType() == BoundType.CLOSED);
            } else {
                navigableMap = this.Wwwwwwwwwwwwwwwwwwwwwww;
            }
            AbstractC2386mx Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator) navigableMap.values().iterator());
            if (this.Wwwwwwwwwwwwwwwwwwwwww.contains(Cut.belowAll()) && (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasNext() || ((Range) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.peek()).lowerBound != Cut.belowAll())) {
                cut = Cut.belowAll();
            } else if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasNext()) {
                return C2838yv.Wwwwwwwwwwwwwwwwwwww;
            } else {
                cut = ((Range) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.next()).upperBound;
            }
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cut, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }

        public final NavigableMap<Cut<C>, Range<C>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Range<Cut<C>> range) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwww.isConnected(range)) {
                return ImmutableSortedMap.m3864of();
            }
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, range.intersection(this.Wwwwwwwwwwwwwwwwwwwwww));
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return mo4797get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: get */
        public Range<C> mo4797get(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut cut = (Cut) obj;
                    Map.Entry<Cut<C>, Range<C>> firstEntry = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Range.downTo(cut, BoundType.forBoolean(true))).firstEntry();
                    if (firstEntry != null && firstEntry.getKey().equals(cut)) {
                        return firstEntry.getValue();
                    }
                    return null;
                } catch (ClassCastException unused) {
                    return null;
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Range.upTo((Cut) obj, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Range.range((Cut) obj, BoundType.forBoolean(z), (Cut) obj2, BoundType.forBoolean(z2)));
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Range.downTo((Cut) obj, BoundType.forBoolean(z)));
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2051dv<Range<C>> implements Set<Range<C>> {
        public final Collection<Range<C>> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TreeRangeSet treeRangeSet, Collection<Range<C>> collection) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = collection;
        }

        @Override // me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public Object mo4974delegate() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate  reason: collision with other method in class */
        public Collection<Range<C>> mo4974delegate() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) this);
        }
    }

    public TreeRangeSet(NavigableMap<Cut<C>, Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> create = create();
        create.addAll(iterable);
        return create;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(AbstractC2460ox<C> abstractC2460ox) {
        TreeRangeSet<C> create = create();
        create.addAll(abstractC2460ox);
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Range<C> rangeEnclosing(Range<C> range) {
        if (range != null) {
            Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
            if (floorEntry != null && floorEntry.getValue().encloses(range)) {
                return floorEntry.getValue();
            }
            return null;
        }
        throw null;
    }

    private void replaceRangeWithSameLowerBound(Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    @Override // me.tvspark.AbstractC2420nu
    public void add(Range<C> range) {
        if (range != null) {
            if (range.isEmpty()) {
                return;
            }
            Cut<C> cut = range.lowerBound;
            Cut<C> cut2 = range.upperBound;
            Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(cut);
            if (lowerEntry != null) {
                Range<C> value = lowerEntry.getValue();
                if (value.upperBound.compareTo(cut) >= 0) {
                    if (value.upperBound.compareTo(cut2) >= 0) {
                        cut2 = value.upperBound;
                    }
                    cut = value.lowerBound;
                }
            }
            Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(cut2);
            if (floorEntry != null) {
                Range<C> value2 = floorEntry.getValue();
                if (value2.upperBound.compareTo(cut2) >= 0) {
                    cut2 = value2.upperBound;
                }
            }
            this.rangesByLowerBound.subMap(cut, cut2).clear();
            replaceRangeWithSameLowerBound(Range.create(cut, cut2));
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2420nu
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // me.tvspark.AbstractC2420nu
    public /* bridge */ /* synthetic */ void addAll(AbstractC2460ox abstractC2460ox) {
        super.addAll(abstractC2460ox);
    }

    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.asDescendingSetOfRanges;
        if (set == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, this.rangesByLowerBound.descendingMap().values());
            this.asDescendingSetOfRanges = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return set;
    }

    @Override // me.tvspark.AbstractC2460ox
    /* renamed from: asRanges */
    public Set<Range<C>> mo4585asRanges() {
        Set<Range<C>> set = this.asRanges;
        if (set == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, this.rangesByLowerBound.values());
            this.asRanges = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return set;
    }

    @Override // me.tvspark.AbstractC2420nu
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // me.tvspark.AbstractC2460ox
    /* renamed from: complement */
    public AbstractC2460ox<C> mo4586complement() {
        AbstractC2460ox<C> abstractC2460ox = this.complement;
        if (abstractC2460ox == null) {
            Complement complement = new Complement();
            this.complement = complement;
            return complement;
        }
        return abstractC2460ox;
    }

    @Override // me.tvspark.AbstractC2420nu
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // me.tvspark.AbstractC2420nu, me.tvspark.AbstractC2460ox
    public boolean encloses(Range<C> range) {
        if (range != null) {
            Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
            return floorEntry != null && floorEntry.getValue().encloses(range);
        }
        throw null;
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

    @Override // me.tvspark.AbstractC2420nu
    public boolean intersects(Range<C> range) {
        if (range != null) {
            Map.Entry<Cut<C>, Range<C>> ceilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
            if (ceilingEntry != null && ceilingEntry.getValue().isConnected(range) && !ceilingEntry.getValue().intersection(range).isEmpty()) {
                return true;
            }
            Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
            return lowerEntry != null && lowerEntry.getValue().isConnected(range) && !lowerEntry.getValue().intersection(range).isEmpty();
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2420nu, me.tvspark.AbstractC2460ox
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // me.tvspark.AbstractC2420nu
    public Range<C> rangeContaining(C c) {
        if (c != null) {
            Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(Cut.belowValue(c));
            if (floorEntry != null && floorEntry.getValue().contains(c)) {
                return floorEntry.getValue();
            }
            return null;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2420nu
    public void remove(Range<C> range) {
        if (range != null) {
            if (range.isEmpty()) {
                return;
            }
            Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
            if (lowerEntry != null) {
                Range<C> value = lowerEntry.getValue();
                if (value.upperBound.compareTo(range.lowerBound) >= 0) {
                    if (range.hasUpperBound() && value.upperBound.compareTo(range.upperBound) >= 0) {
                        replaceRangeWithSameLowerBound(Range.create(range.upperBound, value.upperBound));
                    }
                    replaceRangeWithSameLowerBound(Range.create(value.lowerBound, range.lowerBound));
                }
            }
            Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
            if (floorEntry != null) {
                Range<C> value2 = floorEntry.getValue();
                if (range.hasUpperBound() && value2.upperBound.compareTo(range.upperBound) >= 0) {
                    replaceRangeWithSameLowerBound(Range.create(range.upperBound, value2.upperBound));
                }
            }
            this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2420nu
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    @Override // me.tvspark.AbstractC2420nu, me.tvspark.AbstractC2460ox
    public /* bridge */ /* synthetic */ void removeAll(AbstractC2460ox abstractC2460ox) {
        super.removeAll(abstractC2460ox);
    }

    public Range<C> span() {
        Map.Entry<Cut<C>, Range<C>> firstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<Cut<C>, Range<C>> lastEntry = this.rangesByLowerBound.lastEntry();
        if (firstEntry != null) {
            return Range.create(firstEntry.getValue().lowerBound, lastEntry.getValue().upperBound);
        }
        throw new NoSuchElementException();
    }

    public AbstractC2460ox<C> subRangeSet(Range<C> range) {
        return range.equals(Range.all()) ? this : new SubRangeSet(range);
    }
}
