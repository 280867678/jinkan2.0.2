package me.tvspark;

import java.util.Iterator;

/* renamed from: me.tvspark.cv */
/* loaded from: classes4.dex */
public final class C1997cv extends AbstractC1960bv<T> {
    public final /* synthetic */ Iterable[] Wwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.cv$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2235iu<Iterator<? extends T>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            super(i);
        }

        @Override // me.tvspark.AbstractC2235iu
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return C1997cv.this.Wwwwwwwwwwwwwwwwwwwwwww[i].iterator();
        }
    }

    public C1997cv(Iterable[] iterableArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = iterableArr;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new C2875zv(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww.length));
    }
}
