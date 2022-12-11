package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import me.tvspark.AbstractC1998cw;

/* loaded from: classes3.dex */
public class Multimaps$UnmodifiableListMultimap<K, V> extends Multimaps$UnmodifiableMultimap<K, V> implements AbstractC1998cw<K, V> {
    public static final long serialVersionUID = 0;

    public Multimaps$UnmodifiableListMultimap(AbstractC1998cw<K, V> abstractC1998cw) {
        super(abstractC1998cw);
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public AbstractC1998cw<K, V> mo4974delegate() {
        return (AbstractC1998cw) super.mo4974delegate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Collection mo4793get(Object obj) {
        return mo4793get((Multimaps$UnmodifiableListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get  reason: collision with other method in class */
    public List<V> mo4793get(K k) {
        return Collections.unmodifiableList(mo4974delegate().mo4793get((AbstractC1998cw<K, V>) k));
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: removeAll  reason: collision with other method in class */
    public List<V> mo4778removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((Multimaps$UnmodifiableListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.Multimaps$UnmodifiableMultimap, me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues  reason: collision with other method in class */
    public List<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }
}
