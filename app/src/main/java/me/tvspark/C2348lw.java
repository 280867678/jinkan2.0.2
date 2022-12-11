package me.tvspark;

import java.util.Iterator;
import java.util.Map;

/* renamed from: me.tvspark.lw */
/* loaded from: classes4.dex */
public class C2348lw extends AbstractC2422nw<K, V> {
    public final /* synthetic */ AbstractC2385mw Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2348lw(AbstractC2385mw abstractC2385mw) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2385mw;
    }

    @Override // me.tvspark.AbstractC2422nw
    public Map<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return AbstractC2383mu.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
