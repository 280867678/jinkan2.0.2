package me.tvspark;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: me.tvspark.zw */
/* loaded from: classes4.dex */
public interface AbstractC2876zw<K, V> {
    /* renamed from: asMap */
    Map<K, Collection<V>> mo4790asMap();

    void clear();

    boolean containsEntry(Object obj, Object obj2);

    boolean containsKey(Object obj);

    boolean containsValue(Object obj);

    /* renamed from: entries */
    Collection<Map.Entry<K, V>> mo4768entries();

    boolean equals(Object obj);

    /* renamed from: get */
    Collection<V> mo4793get(K k);

    int hashCode();

    boolean isEmpty();

    /* renamed from: keySet */
    Set<K> mo4794keySet();

    /* renamed from: keys */
    AbstractC2090ex<K> mo4566keys();

    boolean put(K k, V v);

    boolean putAll(K k, Iterable<? extends V> iterable);

    boolean putAll(AbstractC2876zw<? extends K, ? extends V> abstractC2876zw);

    boolean remove(Object obj, Object obj2);

    /* renamed from: removeAll */
    Collection<V> mo4778removeAll(Object obj);

    /* renamed from: replaceValues */
    Collection<V> mo4779replaceValues(K k, Iterable<? extends V> iterable);

    int size();

    /* renamed from: values */
    Collection<V> mo4653values();
}
