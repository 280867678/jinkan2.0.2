package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;
import me.tvspark.C2767wy;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Lists$TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
    public static final long serialVersionUID = 0;
    public final E first;
    public final E[] rest;
    public final E second;

    public Lists$TwoPlusArrayList(E e, E e2, E[] eArr) {
        this.first = e;
        this.second = e2;
        if (eArr != null) {
            this.rest = eArr;
            return;
        }
        throw null;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        if (i != 0) {
            if (i == 1) {
                return this.second;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, size());
            return this.rest[i - 2];
        }
        return this.first;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return C2767wy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.rest.length, 2);
    }
}
