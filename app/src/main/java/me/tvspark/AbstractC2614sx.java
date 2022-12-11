package me.tvspark;

import java.util.Map;
import java.util.Set;

/* renamed from: me.tvspark.sx */
/* loaded from: classes4.dex */
public interface AbstractC2614sx<K, V> extends AbstractC2876zw<K, V> {
    @Override // me.tvspark.AbstractC2876zw
    /* renamed from: entries */
    Set<Map.Entry<K, V>> mo4768entries();

    @Override // me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    Set<V> mo4793get(K k);

    @Override // me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: removeAll */
    Set<V> mo4778removeAll(Object obj);

    @Override // me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    Set<V> mo4779replaceValues(K k, Iterable<? extends V> iterable);
}
