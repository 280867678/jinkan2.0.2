package me.tvspark;

import com.google.common.collect.StandardTable;
import java.util.Map;

/* renamed from: me.tvspark.cy */
/* loaded from: classes4.dex */
public class C2000cy extends AbstractC2199hv<C, V> {
    public final /* synthetic */ Map.Entry Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2000cy(StandardTable.Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww, Map.Entry entry) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = entry;
    }

    @Override // me.tvspark.AbstractC2199hv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public Object mo4974delegate() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2199hv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public Map.Entry<C, V> mo4974delegate() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2199hv, java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getKey(), entry.getKey()) && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getValue(), entry.getValue());
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [V, java.lang.Object] */
    @Override // me.tvspark.AbstractC2199hv, java.util.Map.Entry
    public V setValue(V v) {
        if (v != 0) {
            return mo4974delegate().setValue(v);
        }
        throw null;
    }
}
