package me.tvspark;

import java.util.Iterator;
import java.util.Map;

/* renamed from: me.tvspark.jw */
/* loaded from: classes4.dex */
public final class C2274jw extends AbstractC2239iy<Map.Entry<K, V>> {
    public final /* synthetic */ Iterator Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2274jw(Iterator it) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map.Entry) this.Wwwwwwwwwwwwwwwwwwwwwwww.next());
    }
}
