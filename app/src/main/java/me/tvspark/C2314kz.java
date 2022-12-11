package me.tvspark;

import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Map;

/* renamed from: me.tvspark.kz */
/* loaded from: classes4.dex */
public final class C2314kz extends Ordering<K> {
    public final /* synthetic */ Map Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Comparator Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2314kz(Comparator comparator, Map map) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = comparator;
        this.Wwwwwwwwwwwwwwwwwwwwwww = map;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(K k, K k2) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.compare(this.Wwwwwwwwwwwwwwwwwwwwwww.get(k), this.Wwwwwwwwwwwwwwwwwwwwwww.get(k2));
    }
}
