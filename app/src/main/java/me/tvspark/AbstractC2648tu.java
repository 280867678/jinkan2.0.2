package me.tvspark;

import java.util.Map;
import java.util.Set;

/* renamed from: me.tvspark.tu */
/* loaded from: classes4.dex */
public interface AbstractC2648tu<K, V> extends Map<K, V> {
    V forcePut(K k, V v);

    /* renamed from: inverse */
    AbstractC2648tu<V, K> mo4713inverse();

    @Override // me.tvspark.AbstractC2648tu
    /* renamed from: values */
    Set<V> mo4672values();
}
