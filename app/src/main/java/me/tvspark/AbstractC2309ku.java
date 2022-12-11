package me.tvspark;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: me.tvspark.ku */
/* loaded from: classes4.dex */
public abstract class AbstractC2309ku<K, V> implements AbstractC2876zw<K, V> {
    public transient Map<K, Collection<V>> asMap;
    public transient Collection<Map.Entry<K, V>> entries;
    public transient Set<K> keySet;
    public transient AbstractC2090ex<K> keys;
    public transient Collection<V> values;

    /* renamed from: me.tvspark.ku$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractCollection<V> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractC2309ku.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC2309ku.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return AbstractC2309ku.this.mo4569valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractC2309ku.this.size();
        }
    }

    /* renamed from: me.tvspark.ku$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2309ku<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Set<Map.Entry<K, V>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2309ku abstractC2309ku) {
            super();
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

    /* renamed from: me.tvspark.ku$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC1962bx<K, V> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractC2309ku.this.mo4563entryIterator();
        }
    }

    @Override // me.tvspark.AbstractC2876zw
    /* renamed from: asMap */
    public Map<K, Collection<V>> mo4790asMap() {
        Map<K, Collection<V>> map = this.asMap;
        if (map == null) {
            Map<K, Collection<V>> createAsMap = createAsMap();
            this.asMap = createAsMap;
            return createAsMap;
        }
        return map;
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean containsEntry(Object obj, Object obj2) {
        Collection<V> collection = mo4790asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean containsValue(Object obj) {
        for (Collection<V> collection : mo4790asMap().values()) {
            if (collection.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract Map<K, Collection<V>> createAsMap();

    /* renamed from: createEntries */
    public abstract Collection<Map.Entry<K, V>> mo4647createEntries();

    public abstract Set<K> createKeySet();

    /* renamed from: createKeys */
    public abstract AbstractC2090ex<K> mo4560createKeys();

    /* renamed from: createValues */
    public abstract Collection<V> mo4648createValues();

    @Override // me.tvspark.AbstractC2876zw
    /* renamed from: entries */
    public Collection<Map.Entry<K, V>> mo4768entries() {
        Collection<Map.Entry<K, V>> collection = this.entries;
        if (collection == null) {
            Collection<Map.Entry<K, V>> mo4647createEntries = mo4647createEntries();
            this.entries = mo4647createEntries;
            return mo4647createEntries;
        }
        return collection;
    }

    /* renamed from: entryIterator */
    public abstract Iterator<Map.Entry<K, V>> mo4563entryIterator();

    @Override // me.tvspark.AbstractC2876zw
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2876zw)) {
            return false;
        }
        return mo4790asMap().equals(((AbstractC2876zw) obj).mo4790asMap());
    }

    @Override // me.tvspark.AbstractC2876zw
    public int hashCode() {
        return mo4790asMap().hashCode();
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // me.tvspark.AbstractC2876zw
    /* renamed from: keySet */
    public Set<K> mo4794keySet() {
        Set<K> set = this.keySet;
        if (set == null) {
            Set<K> createKeySet = createKeySet();
            this.keySet = createKeySet;
            return createKeySet;
        }
        return set;
    }

    @Override // me.tvspark.AbstractC2876zw
    /* renamed from: keys */
    public AbstractC2090ex<K> mo4566keys() {
        AbstractC2090ex<K> abstractC2090ex = this.keys;
        if (abstractC2090ex == null) {
            AbstractC2090ex<K> mo4560createKeys = mo4560createKeys();
            this.keys = mo4560createKeys;
            return mo4560createKeys;
        }
        return abstractC2090ex;
    }

    @Override // me.tvspark.AbstractC2876zw
    public abstract boolean put(K k, V v);

    @Override // me.tvspark.AbstractC2876zw
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        if (iterable != null) {
            if (iterable instanceof Collection) {
                Collection<? extends V> collection = (Collection) iterable;
                return !collection.isEmpty() && mo4793get(k).addAll(collection);
            }
            Iterator<? extends V> it = iterable.iterator();
            return it.hasNext() && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) mo4793get(k), (Iterator) it);
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean putAll(AbstractC2876zw<? extends K, ? extends V> abstractC2876zw) {
        boolean z = false;
        for (Map.Entry<? extends K, ? extends V> entry : abstractC2876zw.mo4768entries()) {
            z |= put(entry.getKey(), entry.getValue());
        }
        return z;
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean remove(Object obj, Object obj2) {
        Collection<V> collection = mo4790asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    @Override // me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public abstract Collection<V> mo4779replaceValues(K k, Iterable<? extends V> iterable);

    public String toString() {
        return mo4790asMap().toString();
    }

    /* renamed from: valueIterator */
    public Iterator<V> mo4569valueIterator() {
        return new C2163gw(mo4768entries().iterator());
    }

    @Override // me.tvspark.AbstractC2876zw
    /* renamed from: values */
    public Collection<V> mo4653values() {
        Collection<V> collection = this.values;
        if (collection == null) {
            Collection<V> mo4648createValues = mo4648createValues();
            this.values = mo4648createValues;
            return mo4648createValues;
        }
        return collection;
    }
}
