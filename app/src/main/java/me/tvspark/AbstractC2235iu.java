package me.tvspark;

import java.util.NoSuchElementException;

/* renamed from: me.tvspark.iu */
/* loaded from: classes4.dex */
public abstract class AbstractC2235iu<E> extends AbstractC2276jy<E> {
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    public AbstractC2235iu(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, i);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwww = 0;
    }

    public AbstractC2235iu(int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i2;
    }

    public abstract E Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i + 1;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwww - 1;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww - 1;
    }
}
