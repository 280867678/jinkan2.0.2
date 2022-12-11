package me.tvspark;

import java.util.Map;

/* renamed from: me.tvspark.dw */
/* loaded from: classes4.dex */
public final class C2052dw extends AbstractC2272ju<K, V2> {
    public final /* synthetic */ AbstractC2459ow Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Map.Entry Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2052dw(Map.Entry entry, AbstractC2459ow abstractC2459ow) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = entry;
        this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC2459ow;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, K] */
    @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
    public K getKey() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getKey();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, V2] */
    @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
    public V2 getValue() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.getKey(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getValue());
    }
}
