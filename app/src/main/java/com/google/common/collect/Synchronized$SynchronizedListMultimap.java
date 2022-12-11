package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import me.tvspark.AbstractC1998cw;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedListMultimap<K, V> extends Synchronized$SynchronizedMultimap<K, V> implements AbstractC1998cw<K, V> {
    public static final long serialVersionUID = 0;

    public Synchronized$SynchronizedListMultimap(AbstractC1998cw<K, V> abstractC1998cw, Object obj) {
        super(abstractC1998cw, obj);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate  reason: collision with other method in class */
    public AbstractC1998cw<K, V> mo4780delegate() {
        return (AbstractC1998cw) super.mo4780delegate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Collection mo4793get(Object obj) {
        return mo4793get((Synchronized$SynchronizedListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get  reason: collision with other method in class */
    public List<V> mo4793get(K k) {
        List<V> synchronized$SynchronizedRandomAccessList;
        synchronized (this.mutex) {
            List<V> mo4793get = mo4780delegate().mo4793get((AbstractC1998cw<K, V>) k);
            Object obj = this.mutex;
            synchronized$SynchronizedRandomAccessList = mo4793get instanceof RandomAccess ? new Synchronized$SynchronizedRandomAccessList<>(mo4793get, obj) : new Synchronized$SynchronizedList<>(mo4793get, obj);
        }
        return synchronized$SynchronizedRandomAccessList;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: removeAll  reason: collision with other method in class */
    public List<V> mo4778removeAll(Object obj) {
        List<V> mo4778removeAll;
        synchronized (this.mutex) {
            mo4778removeAll = mo4780delegate().mo4778removeAll(obj);
        }
        return mo4778removeAll;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((Synchronized$SynchronizedListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues  reason: collision with other method in class */
    public List<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        List<V> mo4779replaceValues;
        synchronized (this.mutex) {
            mo4779replaceValues = mo4780delegate().mo4779replaceValues((AbstractC1998cw<K, V>) k, (Iterable) iterable);
        }
        return mo4779replaceValues;
    }
}
