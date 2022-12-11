package com.google.common.collect;

import java.io.Serializable;
import me.tvspark.AbstractC2239iy;

/* loaded from: classes3.dex */
public final class ImmutableMapKeySet<K, V> extends IndexedImmutableSet<K> {
    public final ImmutableMap<K, V> map;

    /* loaded from: classes3.dex */
    public static class KeySetSerializedForm<K> implements Serializable {
        public static final long serialVersionUID = 0;
        public final ImmutableMap<K, ?> map;

        public KeySetSerializedForm(ImmutableMap<K, ?> immutableMap) {
            this.map = immutableMap;
        }

        public Object readResolve() {
            return this.map.mo4552keySet();
        }
    }

    public ImmutableMapKeySet(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.IndexedImmutableSet
    /* renamed from: get */
    public K mo4727get(int i) {
        return this.map.mo4551entrySet().asList().get(i).getKey();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // com.google.common.collect.IndexedImmutableSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* renamed from: iterator  reason: collision with other method in class */
    public AbstractC2239iy<K> mo4735iterator() {
        return this.map.keyIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.map.size();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new KeySetSerializedForm(this.map);
    }
}
