package me.tvspark;

import com.google.common.collect.ImmutableEntry;
import com.google.common.collect.Tables;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2128fy;

/* renamed from: me.tvspark.qu */
/* loaded from: classes4.dex */
public abstract class AbstractC2537qu<R, C, V> implements AbstractC2128fy<R, C, V> {
    public transient Set<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> cellSet;
    public transient Collection<V> values;

    /* renamed from: me.tvspark.qu$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractCollection<V> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractC2537qu.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC2537qu.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return AbstractC2537qu.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractC2537qu.this.size();
        }
    }

    /* renamed from: me.tvspark.qu$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractSet<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractC2537qu.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
                Map map = (Map) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2537qu.this.mo4787rowMap(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRowKey());
                return map != null && C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map.entrySet(), new ImmutableEntry(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getColumnKey(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getValue()));
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> iterator() {
            return AbstractC2537qu.this.mo4632cellIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z;
            if (obj instanceof AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
                Map map = (Map) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2537qu.this.mo4787rowMap(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRowKey());
                if (map == null) {
                    return false;
                }
                Set entrySet = map.entrySet();
                ImmutableEntry immutableEntry = new ImmutableEntry(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getColumnKey(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getValue());
                if (entrySet != null) {
                    try {
                        z = entrySet.remove(immutableEntry);
                    } catch (ClassCastException | NullPointerException unused) {
                        z = false;
                    }
                    return z;
                }
                throw null;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractC2537qu.this.size();
        }
    }

    /* renamed from: me.tvspark.qu$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2165gy<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>, V> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2537qu abstractC2537qu, Iterator it) {
            super(it);
        }

        @Override // me.tvspark.AbstractC2165gy
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            return ((AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).getValue();
        }
    }

    /* renamed from: cellIterator */
    public abstract Iterator<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4632cellIterator();

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: cellSet */
    public Set<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4633cellSet() {
        Set<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> set = this.cellSet;
        if (set == null) {
            Set<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4738createCellSet = mo4738createCellSet();
            this.cellSet = mo4738createCellSet;
            return mo4738createCellSet;
        }
        return set;
    }

    @Override // me.tvspark.AbstractC2128fy
    public abstract void clear();

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: columnKeySet */
    public abstract Set<C> mo4635columnKeySet();

    @Override // me.tvspark.AbstractC2128fy
    public boolean contains(Object obj, Object obj2) {
        Map map = (Map) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4787rowMap(), obj);
        return map != null && C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map, obj2);
    }

    @Override // me.tvspark.AbstractC2128fy
    public boolean containsColumn(Object obj) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map<?, ?>) mo4741columnMap(), obj);
    }

    @Override // me.tvspark.AbstractC2128fy
    public boolean containsRow(Object obj) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map<?, ?>) mo4787rowMap(), obj);
    }

    @Override // me.tvspark.AbstractC2128fy
    public boolean containsValue(Object obj) {
        for (Map<C, V> map : mo4787rowMap().values()) {
            if (map.containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: createCellSet */
    public Set<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4738createCellSet() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* renamed from: createValues */
    public Collection<V> mo4739createValues() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2128fy
    public boolean equals(Object obj) {
        return Tables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, obj);
    }

    @Override // me.tvspark.AbstractC2128fy
    public V get(Object obj, Object obj2) {
        Map map = (Map) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4787rowMap(), obj);
        if (map != null) {
            try {
            } catch (ClassCastException | NullPointerException unused) {
                return null;
            }
        }
        return (V) map.get(obj2);
    }

    @Override // me.tvspark.AbstractC2128fy
    public int hashCode() {
        return mo4633cellSet().hashCode();
    }

    @Override // me.tvspark.AbstractC2128fy
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // me.tvspark.AbstractC2128fy
    public abstract V put(R r, C c, V v);

    @Override // me.tvspark.AbstractC2128fy
    public void putAll(AbstractC2128fy<? extends R, ? extends C, ? extends V> abstractC2128fy) {
        for (AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? extends R, ? extends C, ? extends V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : abstractC2128fy.mo4633cellSet()) {
            put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRowKey(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getColumnKey(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getValue());
        }
    }

    @Override // me.tvspark.AbstractC2128fy
    public abstract V remove(Object obj, Object obj2);

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: rowKeySet */
    public abstract Set<R> mo4786rowKeySet();

    public String toString() {
        return mo4787rowMap().toString();
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: values */
    public Collection<V> mo4642values() {
        Collection<V> collection = this.values;
        if (collection == null) {
            Collection<V> mo4739createValues = mo4739createValues();
            this.values = mo4739createValues;
            return mo4739createValues;
        }
        return collection;
    }

    public Iterator<V> valuesIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, mo4633cellSet().iterator());
    }
}
