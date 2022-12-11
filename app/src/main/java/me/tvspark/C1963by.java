package me.tvspark;

import com.google.common.collect.StandardTable;
import java.util.Map;

/* renamed from: me.tvspark.by */
/* loaded from: classes4.dex */
public class C1963by extends AbstractC2272ju<R, V> {
    public final /* synthetic */ StandardTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Map.Entry Wwwwwwwwwwwwwwwwwwwwwwww;

    public C1963by(StandardTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Map.Entry entry) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = entry;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [R, java.lang.Object] */
    @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
    public R getKey() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getKey();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [V, java.lang.Object] */
    @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
    public V getValue() {
        return ((Map) this.Wwwwwwwwwwwwwwwwwwwwwwww.getValue()).get(StandardTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwww);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [V, java.lang.Object] */
    @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
    public V setValue(V v) {
        Map map = (Map) this.Wwwwwwwwwwwwwwwwwwwwwwww.getValue();
        C c = StandardTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwww;
        if (v != 0) {
            return map.put(c, v);
        }
        throw null;
    }
}
