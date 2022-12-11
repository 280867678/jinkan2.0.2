package me.tvspark;

import me.tvspark.AbstractC2090ex;

/* renamed from: me.tvspark.ix */
/* loaded from: classes4.dex */
public abstract class AbstractC2238ix<E> extends AbstractC2651tx<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> {
    public abstract AbstractC2090ex<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj instanceof AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount() > 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().count(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getElement()) == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount();
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (obj instanceof AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            E e = (E) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getElement();
            int count = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount();
            if (count != 0) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().setCount(e, count, 0);
            }
        }
        return false;
    }
}
