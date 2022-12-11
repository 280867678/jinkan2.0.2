package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import me.tvspark.AbstractC2128fy;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    /* loaded from: classes3.dex */
    public final class CellSet extends IndexedImmutableSet<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> {
        public CellSet() {
        }

        public /* synthetic */ CellSet(RegularImmutableTable regularImmutableTable, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
                Object obj2 = RegularImmutableTable.this.get(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRowKey(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getColumnKey());
                return obj2 != null && obj2.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getValue());
            }
            return false;
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        /* renamed from: get  reason: collision with other method in class */
        public AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> mo4727get(int i) {
            return RegularImmutableTable.this.getCell(i);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableTable.this.size();
        }
    }

    /* loaded from: classes3.dex */
    public final class Values extends ImmutableList<V> {
        public Values() {
        }

        public /* synthetic */ Values(RegularImmutableTable regularImmutableTable, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this();
        }

        @Override // java.util.List
        public V get(int i) {
            return (V) RegularImmutableTable.this.getValue(i);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return RegularImmutableTable.this.size();
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Comparator<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> {
        public final /* synthetic */ Comparator Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ Comparator Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparator comparator, Comparator comparator2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = comparator;
            this.Wwwwwwwwwwwwwwwwwwwwwww = comparator2;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj2;
            Comparator comparator = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            int i = 0;
            int compare = comparator == null ? 0 : comparator.compare(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRowKey(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getRowKey());
            if (compare != 0) {
                return compare;
            }
            Comparator comparator2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (comparator2 != null) {
                i = comparator2.compare(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getColumnKey(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getColumnKey());
            }
            return i;
        }
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> iterable) {
        return forCellsInternal(iterable, null, null);
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> list, Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        if (list != null) {
            if (comparator != null || comparator2 != null) {
                Collections.sort(list, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, comparator2));
            }
            return forCellsInternal(list, comparator, comparator2);
        }
        throw null;
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> iterable, Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ImmutableList copyOf = ImmutableList.copyOf(iterable);
        for (AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : iterable) {
            linkedHashSet.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRowKey());
            linkedHashSet2.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getColumnKey());
        }
        return forOrderedComponents(copyOf, comparator == null ? ImmutableSet.copyOf((Collection) linkedHashSet) : ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator, linkedHashSet)), comparator2 == null ? ImmutableSet.copyOf((Collection) linkedHashSet2) : ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator2, linkedHashSet2)));
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        return ((long) immutableList.size()) > (((long) immutableSet.size()) * ((long) immutableSet2.size())) / 2 ? new DenseImmutableTable(immutableList, immutableSet, immutableSet2) : new SparseImmutableTable(immutableList, immutableSet, immutableSet2);
    }

    public final void checkNoDuplicate(R r, C c, V v, V v2) {
        if (v == null) {
            return;
        }
        throw new IllegalArgumentException(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Duplicate key: (row=%s, column=%s), values: [%s, %s].", r, c, v2, v));
    }

    @Override // com.google.common.collect.ImmutableTable, me.tvspark.AbstractC2537qu
    /* renamed from: createCellSet */
    public final ImmutableSet<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4738createCellSet() {
        return isEmpty() ? ImmutableSet.m3877of() : new CellSet(this, null);
    }

    @Override // com.google.common.collect.ImmutableTable, me.tvspark.AbstractC2537qu
    /* renamed from: createValues */
    public final ImmutableCollection<V> mo4739createValues() {
        return isEmpty() ? ImmutableList.m3919of() : new Values(this, null);
    }

    public abstract AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> getCell(int i);

    public abstract V getValue(int i);
}
