package me.tvspark;

import java.util.Collection;
import java.util.Map;
import me.tvspark.C2053dx;

/* renamed from: me.tvspark.cx */
/* loaded from: classes4.dex */
public class C1999cx extends AbstractC2164gx<K> {
    public final /* synthetic */ Map.Entry Wwwwwwwwwwwwwwwwwwwwwwww;

    public C1999cx(C2053dx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Map.Entry entry) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = entry;
    }

    @Override // me.tvspark.AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public int getCount() {
        return ((Collection) this.Wwwwwwwwwwwwwwwwwwwwwwww.getValue()).size();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, K] */
    @Override // me.tvspark.AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public K getElement() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getKey();
    }
}
