package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import me.tvspark.AbstractC1926ay;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class AbstractSortedSetMultimap<K, V> extends AbstractSetMultimap<K, V> implements AbstractC1926ay<K, V> {
    public static final long serialVersionUID = 430848587173315748L;

    public AbstractSortedSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: asMap */
    public Map<K, Collection<V>> mo4790asMap() {
        return super.mo4790asMap();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: createCollection */
    public abstract SortedSet<V> mo4791createCollection();

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: createUnmodifiableEmptyCollection */
    public SortedSet<V> mo4492createUnmodifiableEmptyCollection() {
        return (SortedSet<V>) mo4496unmodifiableCollectionSubclass((Collection) mo4791createCollection());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Collection mo4793get(Object obj) {
        return mo4793get((AbstractSortedSetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Set mo4793get(Object obj) {
        return mo4793get((AbstractSortedSetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public SortedSet<V> mo4793get(K k) {
        return (SortedSet) super.mo4793get((AbstractSortedSetMultimap<K, V>) k);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: removeAll */
    public SortedSet<V> mo4778removeAll(Object obj) {
        return (SortedSet) super.mo4778removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((AbstractSortedSetMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Set mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((AbstractSortedSetMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public SortedSet<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        return (SortedSet) super.mo4779replaceValues((AbstractSortedSetMultimap<K, V>) k, (Iterable) iterable);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: unmodifiableCollectionSubclass  reason: collision with other method in class */
    public <E> SortedSet<E> mo4496unmodifiableCollectionSubclass(Collection<E> collection) {
        return collection instanceof NavigableSet ? Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((NavigableSet) collection) : Collections.unmodifiableSortedSet((SortedSet) collection);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: values */
    public Collection<V> mo4653values() {
        return super.mo4653values();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> wrapCollection(K k, Collection<V> collection) {
        return collection instanceof NavigableSet ? new AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwww(k, (NavigableSet) collection, null) : new AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwww(k, (SortedSet) collection, null);
    }
}
