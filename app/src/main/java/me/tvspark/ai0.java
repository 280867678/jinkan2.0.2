package me.tvspark;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class ai0<T> implements Iterator<T>, pi0 {
    public final T[] Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;

    public ai0(T[] tArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr, "array");
        this.Wwwwwwwwwwwwwwwwwwwwwww = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwww.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
