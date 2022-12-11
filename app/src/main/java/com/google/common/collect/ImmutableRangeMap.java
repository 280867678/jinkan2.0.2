package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import me.tvspark.AbstractC2239iy;
import me.tvspark.AbstractC2423nx;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements AbstractC2423nx<K, V>, Serializable {
    public static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap<>(ImmutableList.m3919of(), ImmutableList.m3919of());
    public static final long serialVersionUID = 0;
    public final transient ImmutableList<Range<K>> ranges;
    public final transient ImmutableList<V> values;

    /* loaded from: classes3.dex */
    public static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        public static final long serialVersionUID = 0;
        public final ImmutableMap<Range<K>, V> mapOfRanges;

        public SerializedForm(ImmutableMap<Range<K>, V> immutableMap) {
            this.mapOfRanges = immutableMap;
        }

        public Object createRangeMap() {
            ArrayList arrayList = new ArrayList();
            AbstractC2239iy<Map.Entry<Range<K>, V>> mo4735iterator = this.mapOfRanges.mo4551entrySet().mo4735iterator();
            while (mo4735iterator.hasNext()) {
                Map.Entry<Range<K>, V> next = mo4735iterator.next();
                Range<K> key = next.getKey();
                V value = next.getValue();
                if (key == null) {
                    throw null;
                }
                if (value != null) {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!key.isEmpty(), "Range must not be empty, but was %s", key);
                    arrayList.add(new ImmutableEntry(key, value));
                } else {
                    throw null;
                }
            }
            Collections.sort(arrayList, Range.rangeLexOrdering().onKeys());
            ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList.size());
            ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList.size());
            for (int i = 0; i < arrayList.size(); i++) {
                Range range = (Range) ((Map.Entry) arrayList.get(i)).getKey();
                if (i > 0) {
                    Range range2 = (Range) ((Map.Entry) arrayList.get(i - 1)).getKey();
                    if (range.isConnected(range2) && !range.intersection(range2).isEmpty()) {
                        throw new IllegalArgumentException("Overlapping ranges: range " + range2 + " overlaps with entry " + range);
                    }
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) range);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ((Map.Entry) arrayList.get(i)).getValue());
            }
            return new ImmutableRangeMap(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }

        public Object readResolve() {
            return this.mapOfRanges.isEmpty() ? ImmutableRangeMap.m3881of() : createRangeMap();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K extends Comparable<?>, V> {
        public final List<Map.Entry<Range<K>, V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    }

    public ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    public static <K extends Comparable<?>, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> builder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(AbstractC2423nx<K, ? extends V> abstractC2423nx) {
        if (abstractC2423nx instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) abstractC2423nx;
        }
        Map<Range<K>, ? extends V> mo4580asMapOfRanges = abstractC2423nx.mo4580asMapOfRanges();
        ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4580asMapOfRanges.size());
        ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4580asMapOfRanges.size());
        for (Map.Entry<Range<K>, ? extends V> entry : mo4580asMapOfRanges.entrySet()) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) entry.getKey());
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) entry.getValue());
        }
        return new ImmutableRangeMap<>(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    /* renamed from: of */
    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> m3881of() {
        return (ImmutableRangeMap<K, V>) EMPTY;
    }

    /* renamed from: of */
    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> m3880of(Range<K> range, V v) {
        return new ImmutableRangeMap<>(ImmutableList.m3918of(range), ImmutableList.m3918of(v));
    }

    /* renamed from: asDescendingMapOfRanges */
    public ImmutableMap<Range<K>, V> m4579asDescendingMapOfRanges() {
        return this.ranges.isEmpty() ? ImmutableMap.m3900of() : new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse()), this.values.reverse());
    }

    @Override // me.tvspark.AbstractC2423nx
    /* renamed from: asMapOfRanges */
    public ImmutableMap<Range<K>, V> mo4580asMapOfRanges() {
        return this.ranges.isEmpty() ? ImmutableMap.m3900of() : new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering()), this.values);
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (obj instanceof AbstractC2423nx) {
            return mo4580asMapOfRanges().equals(((AbstractC2423nx) obj).mo4580asMapOfRanges());
        }
        return false;
    }

    public V get(K k) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ranges, Range.lowerBoundFn(), Cut.belowValue(k), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_LOWER);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -1 && this.ranges.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).contains(k)) {
            return this.values.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        return null;
    }

    public Map.Entry<Range<K>, V> getEntry(K k) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ranges, Range.lowerBoundFn(), Cut.belowValue(k), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_LOWER);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
            return null;
        }
        Range<K> range = this.ranges.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        if (!range.contains(k)) {
            return null;
        }
        return new ImmutableEntry(range, this.values.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
    }

    public int hashCode() {
        return mo4580asMapOfRanges().hashCode();
    }

    @Deprecated
    public void put(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void putAll(AbstractC2423nx<K, V> abstractC2423nx) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void putCoalescing(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    public Range<K> span() {
        if (!this.ranges.isEmpty()) {
            ImmutableList<Range<K>> immutableList = this.ranges;
            return Range.create(this.ranges.get(0).lowerBound, immutableList.get(immutableList.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    /* renamed from: subRangeMap */
    public ImmutableRangeMap<K, V> m4581subRangeMap(final Range<K> range) {
        if (range != null) {
            if (range.isEmpty()) {
                return m3881of();
            }
            if (this.ranges.isEmpty() || range.encloses(span())) {
                return this;
            }
            final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists$KeyPresentBehavior.FIRST_AFTER, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 >= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
                return m3881of();
            }
            final int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            return (ImmutableRangeMap<K, V>) new ImmutableRangeMap<K, V>(new ImmutableList<Range<K>>() { // from class: com.google.common.collect.ImmutableRangeMap.1
                @Override // java.util.List
                /* renamed from: get */
                public Range<K> mo4582get(int i2) {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i);
                    return (i2 == 0 || i2 == i + (-1)) ? ((Range) ImmutableRangeMap.this.ranges.get(i2 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)).intersection(range) : (Range) ImmutableRangeMap.this.ranges.get(i2 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                }

                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return i;
                }
            }, this.values.mo4539subList(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3)) { // from class: com.google.common.collect.ImmutableRangeMap.2
                @Override // com.google.common.collect.ImmutableRangeMap
                public /* bridge */ /* synthetic */ Map asDescendingMapOfRanges() {
                    return super.m4579asDescendingMapOfRanges();
                }

                @Override // com.google.common.collect.ImmutableRangeMap, me.tvspark.AbstractC2423nx
                /* renamed from: asMapOfRanges */
                public /* bridge */ /* synthetic */ Map mo4580asMapOfRanges() {
                    return super.mo4580asMapOfRanges();
                }

                @Override // com.google.common.collect.ImmutableRangeMap
                /* renamed from: subRangeMap */
                public ImmutableRangeMap<K, V> mo4583subRangeMap(Range<K> range2) {
                    return range.isConnected(range2) ? this.m4581subRangeMap((Range) range2.intersection(range)) : ImmutableRangeMap.m3881of();
                }
            };
        }
        throw null;
    }

    public String toString() {
        return mo4580asMapOfRanges().toString();
    }

    public Object writeReplace() {
        return new SerializedForm(mo4580asMapOfRanges());
    }
}
