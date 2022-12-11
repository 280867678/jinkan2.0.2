package me.tvspark;

import java.util.ListIterator;

/* renamed from: me.tvspark.hy */
/* loaded from: classes4.dex */
public abstract class AbstractC2202hy<F, T> extends AbstractC2165gy<F, T> implements ListIterator<T> {
    public AbstractC2202hy(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    @Override // java.util.ListIterator
    public void add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return ((ListIterator) this.Wwwwwwwwwwwwwwwwwwwwwwww).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return ((ListIterator) this.Wwwwwwwwwwwwwwwwwwwwwwww).nextIndex();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ListIterator
    public final T previous() {
        return (T) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((ListIterator) this.Wwwwwwwwwwwwwwwwwwwwwwww).previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return ((ListIterator) this.Wwwwwwwwwwwwwwwwwwwwwwww).previousIndex();
    }

    public void set(T t) {
        throw new UnsupportedOperationException();
    }
}
