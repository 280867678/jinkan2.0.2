package me.tvspark;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* renamed from: me.tvspark.ev */
/* loaded from: classes4.dex */
public abstract class AbstractConcurrentMapC2088ev<K, V> extends AbstractC2162gv<K, V> implements ConcurrentMap<K, V> {
    @Override // me.tvspark.AbstractC2162gv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract /* bridge */ /* synthetic */ Object mo4974delegate();

    @Override // me.tvspark.AbstractC2162gv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public abstract /* bridge */ /* synthetic */ Map mo4974delegate();

    @Override // me.tvspark.AbstractC2162gv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract ConcurrentMap<K, V> mo4974delegate();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k, V v) {
        return mo4974delegate().putIfAbsent(k, v);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        return mo4974delegate().remove(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k, V v) {
        return mo4974delegate().replace(k, v);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k, V v, V v2) {
        return mo4974delegate().replace(k, v, v2);
    }
}
