package me.tvspark;

import me.tvspark.AbstractC2090ex;

/* renamed from: me.tvspark.gx */
/* loaded from: classes4.dex */
public abstract class AbstractC2164gx<E> implements AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> {
    public boolean equals(Object obj) {
        if (obj instanceof AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return getCount() == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount() && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getElement(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getElement());
        }
        return false;
    }

    public int hashCode() {
        E element = getElement();
        return (element == null ? 0 : element.hashCode()) ^ getCount();
    }

    @Override // me.tvspark.AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public String toString() {
        String valueOf = String.valueOf(getElement());
        int count = getCount();
        if (count == 1) {
            return valueOf;
        }
        return valueOf + " x " + count;
    }
}
