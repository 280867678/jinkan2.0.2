package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2614sx;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedSetMultimap<K, V> extends Synchronized$SynchronizedMultimap<K, V> implements AbstractC2614sx<K, V> {
    public static final long serialVersionUID = 0;
    public transient Set<Map.Entry<K, V>> entrySet;

    public Synchronized$SynchronizedSetMultimap(AbstractC2614sx<K, V> abstractC2614sx, Object obj) {
        super(abstractC2614sx, obj);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate  reason: collision with other method in class */
    public AbstractC2614sx<K, V> mo4780delegate() {
        return (AbstractC2614sx) super.mo4780delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw
    /* renamed from: entries  reason: collision with other method in class */
    public Set<Map.Entry<K, V>> mo4768entries() {
        Set<Map.Entry<K, V>> set;
        synchronized (this.mutex) {
            if (this.entrySet == null) {
                this.entrySet = new Synchronized$SynchronizedSet(mo4780delegate().mo4768entries(), this.mutex);
            }
            set = this.entrySet;
        }
        return set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Collection mo4793get(Object obj) {
        return mo4793get((Synchronized$SynchronizedSetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get  reason: collision with other method in class */
    public Set<V> mo4793get(K k) {
        Synchronized$SynchronizedSet synchronized$SynchronizedSet;
        synchronized (this.mutex) {
            synchronized$SynchronizedSet = new Synchronized$SynchronizedSet(mo4780delegate().mo4793get((AbstractC2614sx<K, V>) k), this.mutex);
        }
        return synchronized$SynchronizedSet;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: removeAll  reason: collision with other method in class */
    public Set<V> mo4778removeAll(Object obj) {
        Set<V> mo4778removeAll;
        synchronized (this.mutex) {
            mo4778removeAll = mo4780delegate().mo4778removeAll(obj);
        }
        return mo4778removeAll;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((Synchronized$SynchronizedSetMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues  reason: collision with other method in class */
    public Set<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        Set<V> mo4779replaceValues;
        synchronized (this.mutex) {
            mo4779replaceValues = mo4780delegate().mo4779replaceValues((AbstractC2614sx<K, V>) k, (Iterable) iterable);
        }
        return mo4779replaceValues;
    }
}
