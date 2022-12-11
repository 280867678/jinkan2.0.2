package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import me.tvspark.AbstractC1926ay;

/* loaded from: classes3.dex */
public class Multimaps$UnmodifiableSortedSetMultimap<K, V> extends Multimaps$UnmodifiableSetMultimap<K, V> implements AbstractC1926ay<K, V> {
    public static final long serialVersionUID = 0;

    public Multimaps$UnmodifiableSortedSetMultimap(AbstractC1926ay<K, V> abstractC1926ay) {
        super(abstractC1926ay);
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableSetMultimap, com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public AbstractC1926ay<K, V> mo4974delegate() {
        return (AbstractC1926ay) super.mo4974delegate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimaps$UnmodifiableSetMultimap, com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Collection mo4793get(Object obj) {
        return mo4793get((Multimaps$UnmodifiableSortedSetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimaps$UnmodifiableSetMultimap, com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Set mo4793get(Object obj) {
        return mo4793get((Multimaps$UnmodifiableSortedSetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableSetMultimap, com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public SortedSet<V> mo4793get(K k) {
        return Collections.unmodifiableSortedSet(mo4974delegate().mo4793get((AbstractC1926ay<K, V>) k));
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableSetMultimap, com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: removeAll */
    public SortedSet<V> mo4778removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimaps$UnmodifiableSetMultimap, com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((Multimaps$UnmodifiableSortedSetMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimaps$UnmodifiableSetMultimap, com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Set mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((Multimaps$UnmodifiableSortedSetMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableSetMultimap, com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public SortedSet<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC1926ay
    public Comparator<? super V> valueComparator() {
        return mo4974delegate().valueComparator();
    }
}
