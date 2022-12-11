package me.tvspark;

import com.google.common.collect.Synchronized$SynchronizedAsMapEntries;
import java.util.Collection;
import java.util.Map;

/* renamed from: me.tvspark.ey */
/* loaded from: classes4.dex */
public class C2091ey extends AbstractC2199hv<K, Collection<V>> {
    public final /* synthetic */ Synchronized$SynchronizedAsMapEntries.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Map.Entry Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2091ey(Synchronized$SynchronizedAsMapEntries.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Map.Entry entry) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = entry;
    }

    @Override // me.tvspark.AbstractC2199hv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public Object mo4974delegate() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2199hv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public Map.Entry<K, Collection<V>> mo4974delegate() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2199hv, java.util.Map.Entry
    public Object getValue() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) this.Wwwwwwwwwwwwwwwwwwwwwwww.getValue(), Synchronized$SynchronizedAsMapEntries.this.mutex);
    }
}
