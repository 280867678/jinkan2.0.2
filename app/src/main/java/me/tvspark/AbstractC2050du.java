package me.tvspark;

import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ExecutionException;

/* renamed from: me.tvspark.du */
/* loaded from: classes4.dex */
public interface AbstractC2050du<K, V> extends AbstractC1922au<K, V>, AbstractC2271jt<K, V> {
    @Deprecated
    /* renamed from: apply */
    V mo4462apply(K k);

    V get(K k) throws ExecutionException;

    ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException;

    V getUnchecked(K k);

    void refresh(K k);
}
