package me.tvspark;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* renamed from: me.tvspark.cu */
/* loaded from: classes4.dex */
public abstract class AbstractC1996cu<K, V> extends AbstractC2310kv implements AbstractC1922au<K, V> {
    @Override // me.tvspark.AbstractC1922au
    public ConcurrentMap<K, V> asMap() {
        return mo4974delegate().asMap();
    }

    @Override // me.tvspark.AbstractC1922au
    public void cleanUp() {
        mo4974delegate().cleanUp();
    }

    @Override // me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract /* bridge */ /* synthetic */ Object mo4974delegate();

    @Override // me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public abstract AbstractC1922au<K, V> mo4974delegate();

    @Override // me.tvspark.AbstractC1922au
    public V get(K k, Callable<? extends V> callable) throws ExecutionException {
        return mo4974delegate().get(k, callable);
    }

    @Override // me.tvspark.AbstractC1922au
    public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
        return mo4974delegate().getAllPresent(iterable);
    }

    @Override // me.tvspark.AbstractC1922au
    public V getIfPresent(Object obj) {
        return mo4974delegate().getIfPresent(obj);
    }

    @Override // me.tvspark.AbstractC1922au
    public void invalidate(Object obj) {
        mo4974delegate().invalidate(obj);
    }

    @Override // me.tvspark.AbstractC1922au
    public void invalidateAll() {
        mo4974delegate().invalidateAll();
    }

    @Override // me.tvspark.AbstractC1922au
    public void invalidateAll(Iterable<?> iterable) {
        mo4974delegate().invalidateAll(iterable);
    }

    @Override // me.tvspark.AbstractC1922au
    public void put(K k, V v) {
        mo4974delegate().put(k, v);
    }

    @Override // me.tvspark.AbstractC1922au
    public void putAll(Map<? extends K, ? extends V> map) {
        mo4974delegate().putAll(map);
    }

    @Override // me.tvspark.AbstractC1922au
    public long size() {
        return mo4974delegate().size();
    }

    @Override // me.tvspark.AbstractC1922au
    public C1959bu stats() {
        return mo4974delegate().stats();
    }
}
