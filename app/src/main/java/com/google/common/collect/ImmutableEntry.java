package com.google.common.collect;

import java.io.Serializable;
import me.tvspark.AbstractC2272ju;

/* loaded from: classes3.dex */
public class ImmutableEntry<K, V> extends AbstractC2272ju<K, V> implements Serializable {
    public static final long serialVersionUID = 0;
    public final K key;
    public final V value;

    public ImmutableEntry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
    public final K getKey() {
        return this.key;
    }

    @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
