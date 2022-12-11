package com.google.common.collect;

import java.util.Map;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedEntry<K, V> extends Synchronized$SynchronizedObject implements Map.Entry<K, V> {
    public static final long serialVersionUID = 0;

    public Synchronized$SynchronizedEntry(Map.Entry<K, V> entry, Object obj) {
        super(entry, obj);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate  reason: collision with other method in class */
    public Map.Entry<K, V> mo4780delegate() {
        return (Map.Entry) super.mo4780delegate();
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = mo4780delegate().equals(obj);
        }
        return equals;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        K key;
        synchronized (this.mutex) {
            key = mo4780delegate().getKey();
        }
        return key;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        V value;
        synchronized (this.mutex) {
            value = mo4780delegate().getValue();
        }
        return value;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = mo4780delegate().hashCode();
        }
        return hashCode;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        V value;
        synchronized (this.mutex) {
            value = mo4780delegate().setValue(v);
        }
        return value;
    }
}
