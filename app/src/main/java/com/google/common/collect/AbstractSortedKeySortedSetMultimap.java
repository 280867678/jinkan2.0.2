package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: classes3.dex */
public abstract class AbstractSortedKeySortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
    public AbstractSortedKeySortedSetMultimap(SortedMap<K, Collection<V>> sortedMap) {
        super(sortedMap);
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: asMap  reason: collision with other method in class */
    public SortedMap<K, Collection<V>> mo4790asMap() {
        return (SortedMap) super.mo4790asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: backingMap  reason: collision with other method in class */
    public SortedMap<K, Collection<V>> mo4489backingMap() {
        return (SortedMap) super.mo4489backingMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku
    public Set<K> createKeySet() {
        return createMaybeNavigableKeySet();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: keySet  reason: collision with other method in class */
    public SortedSet<K> mo4794keySet() {
        return (SortedSet) super.mo4794keySet();
    }
}
