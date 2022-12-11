package me.tvspark;

import java.util.NoSuchElementException;

/* renamed from: me.tvspark.ou */
/* loaded from: classes4.dex */
public abstract class AbstractC2457ou<T> extends AbstractC2239iy<T> {
    public T Wwwwwwwwwwwwwwwwwwwwwwww;

    public AbstractC2457ou(T t) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = t;
    }

    public abstract T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            try {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww;
            } finally {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        throw new NoSuchElementException();
    }
}
