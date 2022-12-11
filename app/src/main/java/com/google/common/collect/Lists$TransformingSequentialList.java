package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;
import me.tvspark.AbstractC2202hy;
import me.tvspark.AbstractC2271jt;

/* loaded from: classes3.dex */
public class Lists$TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
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
            return Lists$TransformingSequentialList.this.function.mo4462apply(f);
        }
    }

    public Lists$TransformingSequentialList(List<F> list, AbstractC2271jt<? super F, ? extends T> abstractC2271jt) {
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

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public ListIterator<T> listIterator(int i) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.fromList.listIterator(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.fromList.size();
    }
}
