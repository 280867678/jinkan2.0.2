package me.tvspark;

import com.google.common.collect.ArrayTable;

/* renamed from: me.tvspark.ru */
/* loaded from: classes4.dex */
public class C2574ru extends AbstractC2272ju<K, V> {
    public final /* synthetic */ ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2574ru(ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, K] */
    @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
    public K getKey() {
        ArrayTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.mo4552keySet().asList().get(this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [V, java.lang.Object] */
    @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
    public V getValue() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [V, java.lang.Object] */
    @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
    public V setValue(V v) {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, v);
    }
}
