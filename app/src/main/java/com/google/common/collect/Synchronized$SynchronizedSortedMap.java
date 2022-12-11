package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedMap;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedSortedMap<K, V> extends Synchronized$SynchronizedMap<K, V> implements SortedMap<K, V> {
    public static final long serialVersionUID = 0;

    public Synchronized$SynchronizedSortedMap(SortedMap<K, V> sortedMap, Object obj) {
        super(sortedMap, obj);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        Comparator<? super K> comparator;
        synchronized (this.mutex) {
            comparator = mo4780delegate().comparator();
        }
        return comparator;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMap, com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate */
    public SortedMap<K, V> mo4780delegate() {
        return (SortedMap) super.mo4780delegate();
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        K firstKey;
        synchronized (this.mutex) {
            firstKey = mo4780delegate().firstKey();
        }
        return firstKey;
    }

    public SortedMap<K, V> headMap(K k) {
        Synchronized$SynchronizedSortedMap synchronized$SynchronizedSortedMap;
        synchronized (this.mutex) {
            synchronized$SynchronizedSortedMap = new Synchronized$SynchronizedSortedMap(mo4780delegate().headMap(k), this.mutex);
        }
        return synchronized$SynchronizedSortedMap;
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        K lastKey;
        synchronized (this.mutex) {
            lastKey = mo4780delegate().lastKey();
        }
        return lastKey;
    }

    public SortedMap<K, V> subMap(K k, K k2) {
        Synchronized$SynchronizedSortedMap synchronized$SynchronizedSortedMap;
        synchronized (this.mutex) {
            synchronized$SynchronizedSortedMap = new Synchronized$SynchronizedSortedMap(mo4780delegate().subMap(k, k2), this.mutex);
        }
        return synchronized$SynchronizedSortedMap;
    }

    public SortedMap<K, V> tailMap(K k) {
        Synchronized$SynchronizedSortedMap synchronized$SynchronizedSortedMap;
        synchronized (this.mutex) {
            synchronized$SynchronizedSortedMap = new Synchronized$SynchronizedSortedMap(mo4780delegate().tailMap(k), this.mutex);
        }
        return synchronized$SynchronizedSortedMap;
    }
}
