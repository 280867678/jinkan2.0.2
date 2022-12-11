package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2614sx;

/* loaded from: classes3.dex */
public abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements AbstractC2614sx<K, V> {
    public static final long serialVersionUID = 7431625294878419160L;

    public AbstractSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: asMap */
    public Map<K, Collection<V>> mo4790asMap() {
        return super.mo4790asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: createCollection  reason: collision with other method in class */
    public abstract Set<V> mo4791createCollection();

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: createUnmodifiableEmptyCollection  reason: collision with other method in class */
    public Set<V> mo4492createUnmodifiableEmptyCollection() {
        return Collections.emptySet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: entries  reason: collision with other method in class */
    public Set<Map.Entry<K, V>> mo4768entries() {
        return (Set) super.mo4768entries();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Collection mo4793get(Object obj) {
        return mo4793get((AbstractSetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get  reason: collision with other method in class */
    public Set<V> mo4793get(K k) {
        return (Set) super.mo4793get((AbstractSetMultimap<K, V>) k);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public boolean put(K k, V v) {
        return super.put(k, v);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: removeAll  reason: collision with other method in class */
    public Set<V> mo4778removeAll(Object obj) {
        return (Set) super.mo4778removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((AbstractSetMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues  reason: collision with other method in class */
    public Set<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        return (Set) super.mo4779replaceValues((AbstractSetMultimap<K, V>) k, (Iterable) iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: unmodifiableCollectionSubclass */
    public <E> Collection<E> mo4496unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> wrapCollection(K k, Collection<V> collection) {
        return new AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwww(k, (Set) collection);
    }
}
