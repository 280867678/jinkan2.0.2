package me.tvspark;

import com.google.common.collect.ImmutableEntry;
import java.util.Iterator;
import java.util.Map;

/* renamed from: me.tvspark.hw */
/* loaded from: classes4.dex */
public final class C2200hw extends AbstractC2165gy<K, Map.Entry<K, V>> {
    public final /* synthetic */ AbstractC2271jt Wwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2200hw(Iterator it, AbstractC2271jt abstractC2271jt) {
        super(it);
        this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC2271jt;
    }

    @Override // me.tvspark.AbstractC2165gy
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        return new ImmutableEntry(obj, this.Wwwwwwwwwwwwwwwwwwwwwww.mo4462apply(obj));
    }
}
