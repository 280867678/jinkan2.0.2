package me.tvspark;

import java.util.Comparator;
import java.util.SortedSet;

/* renamed from: me.tvspark.ay */
/* loaded from: classes4.dex */
public interface AbstractC1926ay<K, V> extends AbstractC2614sx<K, V> {
    @Override // me.tvspark.AbstractC2614sx, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    SortedSet<V> mo4793get(K k);

    @Override // me.tvspark.AbstractC2614sx, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: removeAll */
    SortedSet<V> mo4778removeAll(Object obj);

    @Override // me.tvspark.AbstractC2614sx, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    SortedSet<V> mo4779replaceValues(K k, Iterable<? extends V> iterable);

    Comparator<? super V> valueComparator();
}
