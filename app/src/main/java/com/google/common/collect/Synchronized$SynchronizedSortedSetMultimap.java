package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import me.tvspark.AbstractC1926ay;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedSortedSetMultimap<K, V> extends Synchronized$SynchronizedSetMultimap<K, V> implements AbstractC1926ay<K, V> {
    public static final long serialVersionUID = 0;

    public Synchronized$SynchronizedSortedSetMultimap(AbstractC1926ay<K, V> abstractC1926ay, Object obj) {
        super(abstractC1926ay, obj);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate  reason: collision with other method in class */
    public AbstractC1926ay<K, V> mo4780delegate() {
        return (AbstractC1926ay) super.mo4780delegate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Collection mo4793get(Object obj) {
        return mo4793get((Synchronized$SynchronizedSortedSetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Set mo4793get(Object obj) {
        return mo4793get((Synchronized$SynchronizedSortedSetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public SortedSet<V> mo4793get(K k) {
        Synchronized$SynchronizedSortedSet synchronized$SynchronizedSortedSet;
        synchronized (this.mutex) {
            synchronized$SynchronizedSortedSet = new Synchronized$SynchronizedSortedSet(mo4780delegate().mo4793get((AbstractC1926ay<K, V>) k), this.mutex);
        }
        return synchronized$SynchronizedSortedSet;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: removeAll */
    public SortedSet<V> mo4778removeAll(Object obj) {
        SortedSet<V> mo4778removeAll;
        synchronized (this.mutex) {
            mo4778removeAll = mo4780delegate().mo4778removeAll(obj);
        }
        return mo4778removeAll;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((Synchronized$SynchronizedSortedSetMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Set mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((Synchronized$SynchronizedSortedSetMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public SortedSet<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        SortedSet<V> mo4779replaceValues;
        synchronized (this.mutex) {
            mo4779replaceValues = mo4780delegate().mo4779replaceValues((AbstractC1926ay<K, V>) k, (Iterable) iterable);
        }
        return mo4779replaceValues;
    }

    @Override // me.tvspark.AbstractC1926ay
    public Comparator<? super V> valueComparator() {
        Comparator<? super V> valueComparator;
        synchronized (this.mutex) {
            valueComparator = mo4780delegate().valueComparator();
        }
        return valueComparator;
    }
}
