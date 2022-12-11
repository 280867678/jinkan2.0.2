package me.tvspark;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: me.tvspark.iv */
/* loaded from: classes4.dex */
public abstract class AbstractC2236iv<K, V> extends AbstractC2310kv implements AbstractC2876zw<K, V> {
    /* renamed from: asMap */
    public abstract Map<K, Collection<V>> mo4790asMap();

    public abstract void clear();

    @Override // me.tvspark.AbstractC2876zw
    public boolean containsEntry(Object obj, Object obj2) {
        return mo4974delegate().containsEntry(obj, obj2);
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean containsKey(Object obj) {
        return mo4974delegate().containsKey(obj);
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean containsValue(Object obj) {
        return mo4974delegate().containsValue(obj);
    }

    @Override // me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract /* bridge */ /* synthetic */ Object mo4974delegate();

    @Override // me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public abstract AbstractC2876zw<K, V> mo4974delegate();

    /* renamed from: entries */
    public abstract Collection<Map.Entry<K, V>> mo4768entries();

    @Override // me.tvspark.AbstractC2876zw
    public boolean equals(Object obj) {
        return obj == this || mo4974delegate().equals(obj);
    }

    /* renamed from: get */
    public abstract Collection<V> mo4793get(K k);

    @Override // me.tvspark.AbstractC2876zw
    public int hashCode() {
        return mo4974delegate().hashCode();
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean isEmpty() {
        return mo4974delegate().isEmpty();
    }

    /* renamed from: keySet */
    public abstract Set<K> mo4794keySet();

    /* renamed from: keys */
    public abstract AbstractC2090ex<K> mo4566keys();

    public abstract boolean put(K k, V v);

    public abstract boolean putAll(K k, Iterable<? extends V> iterable);

    public abstract boolean putAll(AbstractC2876zw<? extends K, ? extends V> abstractC2876zw);

    public abstract boolean remove(Object obj, Object obj2);

    /* renamed from: removeAll */
    public abstract Collection<V> mo4778removeAll(Object obj);

    /* renamed from: replaceValues */
    public abstract Collection<V> mo4779replaceValues(K k, Iterable<? extends V> iterable);

    @Override // me.tvspark.AbstractC2876zw
    public int size() {
        return mo4974delegate().size();
    }

    /* renamed from: values */
    public abstract Collection<V> mo4653values();
}
