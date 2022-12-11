package me.tvspark;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Map;

/* renamed from: me.tvspark.qv */
/* loaded from: classes4.dex */
public class C2538qv extends AbstractC2272ju<K, ImmutableSet<V>> {
    public final /* synthetic */ Map.Entry Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2538qv(ImmutableMap.MapViewOfValuesAsSingletonSets.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Map.Entry entry) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = entry;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, K] */
    @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
    public K getKey() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getKey();
    }

    @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
    public Object getValue() {
        return ImmutableSet.m3876of(this.Wwwwwwwwwwwwwwwwwwwwwwww.getValue());
    }
}
