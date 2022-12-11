package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2614sx;
import me.tvspark.C2765ww;

/* loaded from: classes3.dex */
public class Multimaps$UnmodifiableSetMultimap<K, V> extends Multimaps$UnmodifiableMultimap<K, V> implements AbstractC2614sx<K, V> {
    public static final long serialVersionUID = 0;

    public Multimaps$UnmodifiableSetMultimap(AbstractC2614sx<K, V> abstractC2614sx) {
        super(abstractC2614sx);
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public AbstractC2614sx<K, V> mo4974delegate() {
        return (AbstractC2614sx) super.mo4974delegate();
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw
    /* renamed from: entries  reason: collision with other method in class */
    public Set<Map.Entry<K, V>> mo4768entries() {
        return new C2765ww(Collections.unmodifiableSet(mo4974delegate().mo4768entries()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Collection mo4793get(Object obj) {
        return mo4793get((Multimaps$UnmodifiableSetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get  reason: collision with other method in class */
    public Set<V> mo4793get(K k) {
        return Collections.unmodifiableSet(mo4974delegate().mo4793get((AbstractC2614sx<K, V>) k));
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: removeAll  reason: collision with other method in class */
    public Set<V> mo4778removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((Multimaps$UnmodifiableSetMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues  reason: collision with other method in class */
    public Set<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }
}
