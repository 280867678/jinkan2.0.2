package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedMap<K, V> extends Synchronized$SynchronizedObject implements Map<K, V> {
    public static final long serialVersionUID = 0;
    public transient Set<Map.Entry<K, V>> entrySet;
    public transient Set<K> keySet;
    public transient Collection<V> values;

    public Synchronized$SynchronizedMap(Map<K, V> map, Object obj) {
        super(map, obj);
    }

    @Override // java.util.Map
    public void clear() {
        synchronized (this.mutex) {
            mo4780delegate().clear();
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = mo4780delegate().containsKey(obj);
        }
        return containsKey;
    }

    public boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = mo4780delegate().containsValue(obj);
        }
        return containsValue;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate  reason: collision with other method in class */
    public Map<K, V> mo4780delegate() {
        return (Map) super.mo4780delegate();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set;
        synchronized (this.mutex) {
            if (this.entrySet == null) {
                this.entrySet = new Synchronized$SynchronizedSet(mo4780delegate().entrySet(), this.mutex);
            }
            set = this.entrySet;
        }
        return set;
    }

    @Override // java.util.Map
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
    public V mo4746get(Object obj) {
        V v;
        synchronized (this.mutex) {
            v = mo4780delegate().get(obj);
        }
        return v;
    }

    @Override // java.util.Map
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = mo4780delegate().hashCode();
        }
        return hashCode;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = mo4780delegate().isEmpty();
        }
        return isEmpty;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        Set<K> set;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new Synchronized$SynchronizedSet(mo4780delegate().keySet(), this.mutex);
            }
            set = this.keySet;
        }
        return set;
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        V put;
        synchronized (this.mutex) {
            put = mo4780delegate().put(k, v);
        }
        return put;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        synchronized (this.mutex) {
            mo4780delegate().putAll(map);
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        V remove;
        synchronized (this.mutex) {
            remove = mo4780delegate().remove(obj);
        }
        return remove;
    }

    @Override // java.util.Map
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = mo4780delegate().size();
        }
        return size;
    }

    /* renamed from: values */
    public Collection<V> mo4748values() {
        Collection<V> collection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) mo4780delegate().values(), this.mutex);
            }
            collection = this.values;
        }
        return collection;
    }
}
