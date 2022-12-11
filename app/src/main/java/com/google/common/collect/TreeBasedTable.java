package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import me.tvspark.AbstractC2128fy;
import me.tvspark.AbstractC2271jt;
import me.tvspark.AbstractC2684ut;
import me.tvspark.C1924aw;
import me.tvspark.C2612sv;
import me.tvspark.C2613sw;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    public static final long serialVersionUID = 0;
    public final Comparator<? super C> columnComparator;

    /* loaded from: classes3.dex */
    public static class Factory<C, V> implements AbstractC2684ut<TreeMap<C, V>>, Serializable {
        public static final long serialVersionUID = 0;
        public final Comparator<? super C> comparator;

        public Factory(Comparator<? super C> comparator) {
            this.comparator = comparator;
        }

        @Override // me.tvspark.AbstractC2684ut
        /* renamed from: get  reason: collision with other method in class */
        public TreeMap<C, V> mo4804get() {
            return new TreeMap<>(this.comparator);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends StandardTable<R, C, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements SortedMap<C, V> {
        public transient SortedMap<C, V> Wwwwwwwwwwwwwwwwwww;
        public final C Wwwwwwwwwwwwwwwwwwww;
        public final C Wwwwwwwwwwwwwwwwwwwww;

        /* JADX WARN: Multi-variable type inference failed */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R r, C c, C c2) {
            super(r);
            this.Wwwwwwwwwwwwwwwwwwwww = c;
            this.Wwwwwwwwwwwwwwwwwwww = c2;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c == 0 || c2 == 0 || comparator().compare(c, c2) <= 0);
        }

        public SortedMap<C, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            SortedMap<C, V> sortedMap = this.Wwwwwwwwwwwwwwwwwww;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.Wwwwwwwwwwwwwwwwwwwwwwww))) {
                this.Wwwwwwwwwwwwwwwwwww = (SortedMap) TreeBasedTable.this.backingMap.get(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
            return this.Wwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.collect.StandardTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null || !this.Wwwwwwwwwwwwwwwwwww.isEmpty()) {
                return;
            }
            TreeBasedTable.this.backingMap.remove(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwww = null;
        }

        @Override // com.google.common.collect.StandardTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Map Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            SortedMap<C, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                C c = this.Wwwwwwwwwwwwwwwwwwwww;
                if (c != null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.tailMap(c);
                }
                C c2 = this.Wwwwwwwwwwwwwwwwwwww;
                return c2 != null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.headMap(c2) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return null;
        }

        @Override // com.google.common.collect.StandardTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
        public SortedMap<C, V> mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return (SortedMap) super.mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            C c;
            C c2;
            return obj != null && ((c = this.Wwwwwwwwwwwwwwwwwwwww) == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c, obj) <= 0) && ((c2 = this.Wwwwwwwwwwwwwwwwwwww) == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2, obj) > 0);
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        @Override // com.google.common.collect.StandardTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj) && super.containsKey(obj);
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            if (mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null) {
                return mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().firstKey();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C c) {
            if (c != null) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c));
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, c);
            }
            throw null;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set keySet() {
            return new C2613sw(this);
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            if (mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null) {
                return mo4789Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.StandardTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, java.util.AbstractMap, java.util.Map
        public V put(C c, V v) {
            if (c != null) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c));
                return (V) super.put(c, v);
            }
            throw null;
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C c, C c2) {
            boolean z;
            if (c != null) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c)) {
                    if (c2 == null) {
                        throw null;
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2)) {
                        z = true;
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
                        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, c, c2);
                    }
                }
                z = false;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, c, c2);
            }
            throw null;
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C c) {
            if (c != null) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c));
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, c, this.Wwwwwwwwwwwwwwwwwwww);
            }
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractIterator<C> {
        public final /* synthetic */ Comparator Wwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ Iterator Wwwwwwwwwwwwwwwwwwwww;
        public C Wwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TreeBasedTable treeBasedTable, Iterator it, Comparator comparator) {
            this.Wwwwwwwwwwwwwwwwwwwww = it;
            this.Wwwwwwwwwwwwwwwwwwww = comparator;
        }

        @Override // com.google.common.collect.AbstractIterator
        public C Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            boolean z;
            while (this.Wwwwwwwwwwwwwwwwwwwww.hasNext()) {
                C c = (C) this.Wwwwwwwwwwwwwwwwwwwww.next();
                C c2 = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (c2 == null || this.Wwwwwwwwwwwwwwwwwwww.compare(c, c2) != 0) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (!z) {
                    this.Wwwwwwwwwwwwwwwwwwwwww = c;
                    return c;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = null;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2271jt<Map<C, V>, Iterator<C>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TreeBasedTable treeBasedTable) {
        }

        @Override // me.tvspark.AbstractC2271jt
        /* renamed from: apply */
        public Object mo4462apply(Object obj) {
            return ((Map) obj).keySet().iterator();
        }
    }

    public TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new Factory(comparator2));
        this.columnComparator = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(Ordering.natural(), Ordering.natural());
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        if (comparator != null) {
            if (comparator2 == null) {
                throw null;
            }
            return new TreeBasedTable<>(comparator, comparator2);
        }
        throw null;
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: cellSet */
    public /* bridge */ /* synthetic */ Set mo4633cellSet() {
        return super.mo4633cellSet();
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2128fy
    /* renamed from: column */
    public /* bridge */ /* synthetic */ Map mo4736column(Object obj) {
        return super.mo4736column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: columnKeySet */
    public /* bridge */ /* synthetic */ Set mo4635columnKeySet() {
        return super.mo4635columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2128fy
    /* renamed from: columnMap */
    public /* bridge */ /* synthetic */ Map mo4741columnMap() {
        return super.mo4741columnMap();
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ boolean contains(Object obj, Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.StandardTable
    public Iterator<C> createColumnKeyIterator() {
        Comparator<? super C> columnComparator = columnComparator();
        Collection<Map<C, V>> values = this.backingMap.values();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        if (values != null) {
            C2612sv c2612sv = new C2612sv(values, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2612sv, "iterators");
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(columnComparator, "comparator");
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, new C1924aw(c2612sv, columnComparator), columnComparator);
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ void putAll(AbstractC2128fy abstractC2128fy) {
        super.putAll(abstractC2128fy);
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ Object remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2128fy
    /* renamed from: row */
    public /* bridge */ /* synthetic */ Map mo4785row(Object obj) {
        return mo4785row((TreeBasedTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2128fy
    /* renamed from: row  reason: collision with other method in class */
    public SortedMap<C, V> mo4785row(R r) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r, null, null);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        return mo4786rowKeySet().comparator();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: rowKeySet  reason: collision with other method in class */
    public SortedSet<R> mo4786rowKeySet() {
        return super.mo4786rowKeySet();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, me.tvspark.AbstractC2128fy
    /* renamed from: rowMap  reason: collision with other method in class */
    public SortedMap<R, Map<C, V>> mo4787rowMap() {
        return super.mo4787rowMap();
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // me.tvspark.AbstractC2537qu
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: values */
    public /* bridge */ /* synthetic */ Collection mo4642values() {
        return super.mo4642values();
    }
}
