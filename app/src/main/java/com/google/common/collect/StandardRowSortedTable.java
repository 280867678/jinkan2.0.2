package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import me.tvspark.AbstractC2503px;
import me.tvspark.AbstractC2684ut;
import me.tvspark.C2613sw;

/* loaded from: classes3.dex */
public class StandardRowSortedTable<R, C, V> extends StandardTable<R, C, V> implements AbstractC2503px<R, C, V> {
    public static final long serialVersionUID = 0;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends StandardTable<R, C, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwww implements SortedMap<R, Map<C, V>> {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            super();
        }

        @Override // me.tvspark.AbstractC2839yw
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public Set mo4480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new C2613sw(this);
        }

        @Override // java.util.SortedMap
        public Comparator<? super R> comparator() {
            return StandardRowSortedTable.this.sortedBackingMap().comparator();
        }

        @Override // java.util.SortedMap
        public R firstKey() {
            return (R) StandardRowSortedTable.this.sortedBackingMap().firstKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> headMap(R r) {
            if (r != null) {
                return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().headMap(r), StandardRowSortedTable.this.factory).mo4787rowMap();
            }
            throw null;
        }

        @Override // me.tvspark.AbstractC2839yw, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* renamed from: keySet */
        public Set mo4481keySet() {
            return (SortedSet) super.mo4481keySet();
        }

        @Override // java.util.SortedMap
        public R lastKey() {
            return (R) StandardRowSortedTable.this.sortedBackingMap().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> subMap(R r, R r2) {
            if (r != null) {
                if (r2 == null) {
                    throw null;
                }
                return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().subMap(r, r2), StandardRowSortedTable.this.factory).mo4787rowMap();
            }
            throw null;
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> tailMap(R r) {
            if (r != null) {
                return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().tailMap(r), StandardRowSortedTable.this.factory).mo4787rowMap();
            }
            throw null;
        }
    }

    public StandardRowSortedTable(SortedMap<R, Map<C, V>> sortedMap, AbstractC2684ut<? extends Map<C, V>> abstractC2684ut) {
        super(sortedMap, abstractC2684ut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SortedMap<R, Map<C, V>> sortedBackingMap() {
        return (SortedMap) this.backingMap;
    }

    @Override // com.google.common.collect.StandardTable
    /* renamed from: createRowMap  reason: collision with other method in class */
    public SortedMap<R, Map<C, V>> mo4743createRowMap() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: rowKeySet  reason: collision with other method in class */
    public SortedSet<R> mo4786rowKeySet() {
        return (SortedSet) mo4787rowMap().keySet();
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2128fy
    /* renamed from: rowMap  reason: collision with other method in class */
    public SortedMap<R, Map<C, V>> mo4787rowMap() {
        return (SortedMap) super.mo4787rowMap();
    }
}
