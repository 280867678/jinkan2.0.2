package com.google.common.collect;

import java.io.Serializable;
import me.tvspark.AbstractC2164gx;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Multisets$ImmutableEntry<E> extends AbstractC2164gx<E> implements Serializable {
    public static final long serialVersionUID = 0;
    public final int count;
    public final E element;

    public Multisets$ImmutableEntry(E e, int i) {
        this.element = e;
        this.count = i;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "count");
    }

    @Override // me.tvspark.AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public final int getCount() {
        return this.count;
    }

    @Override // me.tvspark.AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public final E getElement() {
        return this.element;
    }

    public Multisets$ImmutableEntry<E> nextInBucket() {
        return null;
    }
}
