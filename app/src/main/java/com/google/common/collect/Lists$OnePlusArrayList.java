package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;
import me.tvspark.C2767wy;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Lists$OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
    public static final long serialVersionUID = 0;
    public final E first;
    public final E[] rest;

    public Lists$OnePlusArrayList(E e, E[] eArr) {
        this.first = e;
        if (eArr != null) {
            this.rest = eArr;
            return;
        }
        throw null;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, size());
        return i == 0 ? this.first : this.rest[i - 1];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return C2767wy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.rest.length, 1);
    }
}
