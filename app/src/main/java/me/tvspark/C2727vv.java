package me.tvspark;

import com.google.common.collect.AbstractIterator;
import java.util.Iterator;

/* renamed from: me.tvspark.vv */
/* loaded from: classes4.dex */
public final class C2727vv extends AbstractIterator<T> {
    public final /* synthetic */ AbstractC2573rt Wwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Iterator Wwwwwwwwwwwwwwwwwwwwww;

    public C2727vv(Iterator it, AbstractC2573rt abstractC2573rt) {
        this.Wwwwwwwwwwwwwwwwwwwwww = it;
        this.Wwwwwwwwwwwwwwwwwwwww = abstractC2573rt;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @Override // com.google.common.collect.AbstractIterator
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        while (this.Wwwwwwwwwwwwwwwwwwwwww.hasNext()) {
            ?? next = this.Wwwwwwwwwwwwwwwwwwwwww.next();
            if (this.Wwwwwwwwwwwwwwwwwwwww.apply(next)) {
                return next;
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return null;
    }
}
