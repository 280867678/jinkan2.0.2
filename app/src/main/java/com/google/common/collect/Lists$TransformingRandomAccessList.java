package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import me.tvspark.AbstractC2202hy;
import me.tvspark.AbstractC2271jt;

/* loaded from: classes3.dex */
public class Lists$TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
    public static final long serialVersionUID = 0;
    public final List<F> fromList;
    public final AbstractC2271jt<? super F, ? extends T> function;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2202hy<F, T> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ListIterator listIterator) {
            super(listIterator);
        }

        @Override // me.tvspark.AbstractC2165gy
        public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(F f) {
            return Lists$TransformingRandomAccessList.this.function.mo4462apply(f);
        }
    }

    public Lists$TransformingRandomAccessList(List<F> list, AbstractC2271jt<? super F, ? extends T> abstractC2271jt) {
        if (list != null) {
            this.fromList = list;
            if (abstractC2271jt == null) {
                throw null;
            }
            this.function = abstractC2271jt;
            return;
        }
        throw null;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.fromList.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.function.mo4462apply((F) this.fromList.get(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.fromList.isEmpty();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<T> listIterator(int i) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.fromList.listIterator(i));
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int i) {
        return this.function.mo4462apply((F) this.fromList.remove(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.fromList.size();
    }
}
