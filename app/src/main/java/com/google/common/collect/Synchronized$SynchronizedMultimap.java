package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2165gy;
import me.tvspark.AbstractC2876zw;
import me.tvspark.C2091ey;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedMultimap<K, V> extends Synchronized$SynchronizedObject implements AbstractC2876zw<K, V> {
    public static final long serialVersionUID = 0;
    public transient Map<K, Collection<V>> asMap;
    public transient Collection<Map.Entry<K, V>> entries;
    public transient Set<K> keySet;
    public transient AbstractC2090ex<K> keys;
    public transient Collection<V> valuesCollection;

    public Synchronized$SynchronizedMultimap(AbstractC2876zw<K, V> abstractC2876zw, Object obj) {
        super(abstractC2876zw, obj);
    }

    @Override // me.tvspark.AbstractC2876zw
    /* renamed from: asMap */
    public Map<K, Collection<V>> mo4790asMap() {
        Map<K, Collection<V>> map;
        synchronized (this.mutex) {
            if (this.asMap == null) {
                final Map<K, Collection<V>> mo4790asMap = mo4780delegate().mo4790asMap();
                final Object obj = this.mutex;
                this.asMap = new Synchronized$SynchronizedMap<K, Collection<V>>(mo4790asMap, obj) { // from class: com.google.common.collect.Synchronized$SynchronizedAsMap
                    public static final long serialVersionUID = 0;
                    public transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;
                    public transient Collection<Collection<V>> asMapValues;

                    @Override // com.google.common.collect.Synchronized$SynchronizedMap, java.util.Map
                    public boolean containsValue(Object obj2) {
                        return mo4748values().contains(obj2);
                    }

                    @Override // com.google.common.collect.Synchronized$SynchronizedMap, java.util.Map
                    public Set<Map.Entry<K, Collection<V>>> entrySet() {
                        Set<Map.Entry<K, Collection<V>>> set;
                        synchronized (this.mutex) {
                            if (this.asMapEntrySet == null) {
                                final Set<Map.Entry<K, V>> entrySet = mo4780delegate().entrySet();
                                final Object obj2 = this.mutex;
                                this.asMapEntrySet = new Synchronized$SynchronizedSet<Map.Entry<K, Collection<V>>>(entrySet, obj2) { // from class: com.google.common.collect.Synchronized$SynchronizedAsMapEntries
                                    public static final long serialVersionUID = 0;

                                    /* loaded from: classes3.dex */
                                    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2165gy<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>> {
                                        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator it) {
                                            super(it);
                                        }

                                        @Override // me.tvspark.AbstractC2165gy
                                        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
                                            return new C2091ey(this, (Map.Entry) obj);
                                        }
                                    }

                                    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, java.util.Collection, java.util.Set
                                    public boolean contains(Object obj3) {
                                        boolean contains;
                                        synchronized (this.mutex) {
                                            contains = !(obj3 instanceof Map.Entry) ? false : mo4780delegate().contains(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map.Entry) obj3));
                                        }
                                        return contains;
                                    }

                                    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, java.util.Collection, java.util.Set
                                    public boolean containsAll(Collection<?> collection) {
                                        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                        synchronized (this.mutex) {
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection<?>) mo4780delegate(), collection);
                                        }
                                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                    }

                                    @Override // com.google.common.collect.Synchronized$SynchronizedSet, java.util.Collection, java.util.Set
                                    public boolean equals(Object obj3) {
                                        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        if (obj3 == this) {
                                            return true;
                                        }
                                        synchronized (this.mutex) {
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) mo4780delegate(), obj3);
                                        }
                                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    }

                                    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                                    public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                                        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(super.iterator());
                                    }

                                    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, java.util.Collection, java.util.Set
                                    public boolean remove(Object obj3) {
                                        boolean remove;
                                        synchronized (this.mutex) {
                                            remove = !(obj3 instanceof Map.Entry) ? false : mo4780delegate().remove(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map.Entry) obj3));
                                        }
                                        return remove;
                                    }

                                    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, java.util.Collection, java.util.Set
                                    public boolean removeAll(Collection<?> collection) {
                                        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                        synchronized (this.mutex) {
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) mo4780delegate().iterator(), collection);
                                        }
                                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                    }

                                    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, java.util.Collection, java.util.Set
                                    public boolean retainAll(Collection<?> collection) {
                                        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        synchronized (this.mutex) {
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) mo4780delegate().iterator(), collection);
                                        }
                                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    }

                                    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, java.util.Collection, java.util.Set
                                    public Object[] toArray() {
                                        Object[] objArr;
                                        synchronized (this.mutex) {
                                            Set<Map.Entry<K, Collection<V>>> mo4780delegate = mo4780delegate();
                                            objArr = new Object[mo4780delegate.size()];
                                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable<?>) mo4780delegate, objArr);
                                        }
                                        return objArr;
                                    }

                                    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, java.util.Collection, java.util.Set
                                    public <T> T[] toArray(T[] tArr) {
                                        T[] tArr2;
                                        synchronized (this.mutex) {
                                            tArr2 = (T[]) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection<?>) mo4780delegate(), (Object[]) tArr);
                                        }
                                        return tArr2;
                                    }
                                };
                            }
                            set = this.asMapEntrySet;
                        }
                        return set;
                    }

                    @Override // com.google.common.collect.Synchronized$SynchronizedMap, java.util.Map
                    /* renamed from: get  reason: collision with other method in class */
                    public Collection<V> mo4746get(Object obj2) {
                        Collection<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        synchronized (this.mutex) {
                            Collection collection = (Collection) super.mo4746get(obj2);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = collection == null ? null : Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection, this.mutex);
                        }
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }

                    @Override // com.google.common.collect.Synchronized$SynchronizedMap, java.util.Map
                    /* renamed from: values */
                    public Collection<Collection<V>> mo4748values() {
                        Collection<Collection<V>> collection;
                        synchronized (this.mutex) {
                            if (this.asMapValues == null) {
                                final Collection<V> values = mo4780delegate().values();
                                final Object obj2 = this.mutex;
                                this.asMapValues = new Synchronized$SynchronizedCollection<Collection<V>>(values, obj2) { // from class: com.google.common.collect.Synchronized$SynchronizedAsMapValues
                                    public static final long serialVersionUID = 0;

                                    /* loaded from: classes3.dex */
                                    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2165gy<Collection<V>, Collection<V>> {
                                        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator it) {
                                            super(it);
                                        }

                                        @Override // me.tvspark.AbstractC2165gy
                                        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
                                            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) obj, Synchronized$SynchronizedAsMapValues.this.mutex);
                                        }
                                    }

                                    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                                    public Iterator<Collection<V>> iterator() {
                                        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(super.iterator());
                                    }
                                };
                            }
                            collection = this.asMapValues;
                        }
                        return collection;
                    }
                };
            }
            map = this.asMap;
        }
        return map;
    }

    @Override // me.tvspark.AbstractC2876zw
    public void clear() {
        synchronized (this.mutex) {
            mo4780delegate().clear();
        }
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean containsEntry(Object obj, Object obj2) {
        boolean containsEntry;
        synchronized (this.mutex) {
            containsEntry = mo4780delegate().containsEntry(obj, obj2);
        }
        return containsEntry;
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = mo4780delegate().containsKey(obj);
        }
        return containsKey;
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = mo4780delegate().containsValue(obj);
        }
        return containsValue;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate  reason: collision with other method in class */
    public AbstractC2876zw<K, V> mo4780delegate() {
        return (AbstractC2876zw) super.mo4780delegate();
    }

    @Override // me.tvspark.AbstractC2876zw
    /* renamed from: entries */
    public Collection<Map.Entry<K, V>> mo4768entries() {
        Collection<Map.Entry<K, V>> collection;
        synchronized (this.mutex) {
            if (this.entries == null) {
                this.entries = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) mo4780delegate().mo4768entries(), this.mutex);
            }
            collection = this.entries;
        }
        return collection;
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean equals(Object obj) {
        boolean equals;
        if (obj == this) {
            return true;
        }
        synchronized (this.mutex) {
            equals = mo4780delegate().equals(obj);
        }
        return equals;
    }

    /* renamed from: get */
    public Collection<V> mo4793get(K k) {
        Collection<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        synchronized (this.mutex) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) mo4780delegate().mo4793get(k), this.mutex);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2876zw
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = mo4780delegate().hashCode();
        }
        return hashCode;
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = mo4780delegate().isEmpty();
        }
        return isEmpty;
    }

    @Override // me.tvspark.AbstractC2876zw
    /* renamed from: keySet */
    public Set<K> mo4794keySet() {
        Set<K> set;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set) mo4780delegate().mo4794keySet(), this.mutex);
            }
            set = this.keySet;
        }
        return set;
    }

    @Override // me.tvspark.AbstractC2876zw
    /* renamed from: keys */
    public AbstractC2090ex<K> mo4566keys() {
        AbstractC2090ex<K> abstractC2090ex;
        synchronized (this.mutex) {
            if (this.keys == null) {
                AbstractC2090ex<K> mo4566keys = mo4780delegate().mo4566keys();
                Object obj = this.mutex;
                if (!(mo4566keys instanceof Synchronized$SynchronizedMultiset) && !(mo4566keys instanceof ImmutableMultiset)) {
                    mo4566keys = new Synchronized$SynchronizedMultiset(mo4566keys, obj);
                }
                this.keys = mo4566keys;
            }
            abstractC2090ex = this.keys;
        }
        return abstractC2090ex;
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean put(K k, V v) {
        boolean put;
        synchronized (this.mutex) {
            put = mo4780delegate().put(k, v);
        }
        return put;
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        boolean putAll;
        synchronized (this.mutex) {
            putAll = mo4780delegate().putAll(k, iterable);
        }
        return putAll;
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean putAll(AbstractC2876zw<? extends K, ? extends V> abstractC2876zw) {
        boolean putAll;
        synchronized (this.mutex) {
            putAll = mo4780delegate().putAll(abstractC2876zw);
        }
        return putAll;
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean remove(Object obj, Object obj2) {
        boolean remove;
        synchronized (this.mutex) {
            remove = mo4780delegate().remove(obj, obj2);
        }
        return remove;
    }

    /* renamed from: removeAll */
    public Collection<V> mo4778removeAll(Object obj) {
        Collection<V> mo4778removeAll;
        synchronized (this.mutex) {
            mo4778removeAll = mo4780delegate().mo4778removeAll(obj);
        }
        return mo4778removeAll;
    }

    /* renamed from: replaceValues */
    public Collection<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        Collection<V> mo4779replaceValues;
        synchronized (this.mutex) {
            mo4779replaceValues = mo4780delegate().mo4779replaceValues(k, iterable);
        }
        return mo4779replaceValues;
    }

    @Override // me.tvspark.AbstractC2876zw
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = mo4780delegate().size();
        }
        return size;
    }

    @Override // me.tvspark.AbstractC2876zw
    /* renamed from: values */
    public Collection<V> mo4653values() {
        Collection<V> collection;
        synchronized (this.mutex) {
            if (this.valuesCollection == null) {
                this.valuesCollection = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) mo4780delegate().mo4653values(), this.mutex);
            }
            collection = this.valuesCollection;
        }
        return collection;
    }
}
