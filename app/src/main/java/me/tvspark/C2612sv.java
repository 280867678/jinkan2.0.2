package me.tvspark;

import java.util.Iterator;

/* renamed from: me.tvspark.sv */
/* loaded from: classes4.dex */
public final class C2612sv extends AbstractC1960bv<T> {
    public final /* synthetic */ AbstractC2271jt Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Iterable Wwwwwwwwwwwwwwwwwwwwwww;

    public C2612sv(Iterable iterable, AbstractC2271jt abstractC2271jt) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = iterable;
        this.Wwwwwwwwwwwwwwwwwwwwww = abstractC2271jt;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        Iterator it = this.Wwwwwwwwwwwwwwwwwwwwwww.iterator();
        AbstractC2271jt abstractC2271jt = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (abstractC2271jt != null) {
            return new C2764wv(it, abstractC2271jt);
        }
        throw null;
    }
}
