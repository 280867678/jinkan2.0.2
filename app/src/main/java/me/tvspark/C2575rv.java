package me.tvspark;

import java.util.Iterator;

/* renamed from: me.tvspark.rv */
/* loaded from: classes4.dex */
public final class C2575rv extends AbstractC1960bv<T> {
    public final /* synthetic */ AbstractC2573rt Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Iterable Wwwwwwwwwwwwwwwwwwwwwww;

    public C2575rv(Iterable iterable, AbstractC2573rt abstractC2573rt) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = iterable;
        this.Wwwwwwwwwwwwwwwwwwwwww = abstractC2573rt;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        Iterator it = this.Wwwwwwwwwwwwwwwwwwwwwww.iterator();
        AbstractC2573rt abstractC2573rt = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (it != null) {
            if (abstractC2573rt != null) {
                return new C2727vv(it, abstractC2573rt);
            }
            throw null;
        }
        throw null;
    }
}
