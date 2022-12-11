package me.tvspark;

import java.util.Map;

/* renamed from: me.tvspark.hv */
/* loaded from: classes4.dex */
public abstract class AbstractC2199hv<K, V> extends AbstractC2310kv implements Map.Entry<K, V> {
    @Override // me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract Map.Entry<K, V> mo4974delegate();

    public boolean equals(Object obj) {
        return mo4974delegate().equals(obj);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return mo4974delegate().getKey();
    }

    public V getValue() {
        return mo4974delegate().getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return mo4974delegate().hashCode();
    }

    public V setValue(V v) {
        return mo4974delegate().setValue(v);
    }
}
