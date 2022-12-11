package com.google.common.collect;

import com.google.common.collect.RegularImmutableMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    public static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap<>();
    public final transient Object[] alternatingKeysAndValues;
    public final transient RegularImmutableBiMap<V, K> inverse;
    public final transient int[] keyHashTable;
    public final transient int keyOffset;
    public final transient int size;

    /* JADX WARN: Multi-variable type inference failed */
    public RegularImmutableBiMap() {
        this.keyHashTable = null;
        this.alternatingKeysAndValues = new Object[0];
        this.keyOffset = 0;
        this.size = 0;
        this.inverse = this;
    }

    public RegularImmutableBiMap(int[] iArr, Object[] objArr, int i, RegularImmutableBiMap<V, K> regularImmutableBiMap) {
        this.keyHashTable = iArr;
        this.alternatingKeysAndValues = objArr;
        this.keyOffset = 1;
        this.size = i;
        this.inverse = regularImmutableBiMap;
    }

    public RegularImmutableBiMap(Object[] objArr, int i) {
        this.alternatingKeysAndValues = objArr;
        this.size = i;
        this.keyOffset = 0;
        int chooseTableSize = i >= 2 ? ImmutableSet.chooseTableSize(i) : 0;
        this.keyHashTable = RegularImmutableMap.createHashTable(objArr, i, chooseTableSize, 0);
        this.inverse = new RegularImmutableBiMap<>(RegularImmutableMap.createHashTable(objArr, i, chooseTableSize, 1), objArr, i, this);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new RegularImmutableMap.EntrySet(this, this.alternatingKeysAndValues, this.keyOffset, this.size);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new RegularImmutableMap.KeySet(this, new RegularImmutableMap.KeysOrValuesAsList(this.alternatingKeysAndValues, this.keyOffset, this.size));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    /* renamed from: get */
    public V mo4554get(Object obj) {
        return (V) RegularImmutableMap.get(this.keyHashTable, this.alternatingKeysAndValues, this.size, this.keyOffset, obj);
    }

    @Override // com.google.common.collect.ImmutableBiMap, me.tvspark.AbstractC2648tu
    /* renamed from: inverse */
    public ImmutableBiMap<V, K> mo4713inverse() {
        return this.inverse;
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.size;
    }
}
