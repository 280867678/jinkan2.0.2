package me.tvspark;

import java.util.Iterator;

/* renamed from: me.tvspark.gy */
/* loaded from: classes4.dex */
public abstract class AbstractC2165gy<F, T> implements Iterator<T> {
    public final Iterator<? extends F> Wwwwwwwwwwwwwwwwwwwwwwww;

    public AbstractC2165gy(Iterator<? extends F> it) {
        if (it != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = it;
            return;
        }
        throw null;
    }

    public abstract T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(F f);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.remove();
    }
}
