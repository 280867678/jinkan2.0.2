package me.tvspark;

import java.util.Map;

/* renamed from: me.tvspark.ew */
/* loaded from: classes4.dex */
public final class C2089ew implements AbstractC2271jt<Map.Entry<K, V1>, Map.Entry<K, V2>> {
    public final /* synthetic */ AbstractC2459ow Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2089ew(AbstractC2459ow abstractC2459ow) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2459ow;
    }

    @Override // me.tvspark.AbstractC2271jt
    /* renamed from: apply */
    public Object mo4462apply(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        AbstractC2459ow abstractC2459ow = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (abstractC2459ow != null) {
            if (entry != null) {
                return new C2052dw(entry, abstractC2459ow);
            }
            throw null;
        }
        throw null;
    }
}
