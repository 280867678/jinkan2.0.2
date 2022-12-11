package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    public static final long serialVersionUID = 0;
    public final Ordering<? super T> forwardOrder;

    public ReverseOrdering(Ordering<? super T> ordering) {
        if (ordering != null) {
            this.forwardOrder = ordering;
            return;
        }
        throw null;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t, T t2) {
        return this.forwardOrder.compare(t2, t);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReverseOrdering)) {
            return false;
        }
        return this.forwardOrder.equals(((ReverseOrdering) obj).forwardOrder);
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: max */
    public <E extends T> E mo4728max(Iterable<E> iterable) {
        return (E) this.forwardOrder.mo4730min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(E e, E e2) {
        return (E) this.forwardOrder.min(e, e2);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(E e, E e2, E e3, E... eArr) {
        return (E) this.forwardOrder.min(e, e2, e3, eArr);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: max */
    public <E extends T> E mo4729max(Iterator<E> it) {
        return (E) this.forwardOrder.mo4731min(it);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: min */
    public <E extends T> E mo4730min(Iterable<E> iterable) {
        return (E) this.forwardOrder.mo4728max(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(E e, E e2) {
        return (E) this.forwardOrder.max(e, e2);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(E e, E e2, E e3, E... eArr) {
        return (E) this.forwardOrder.max(e, e2, e3, eArr);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: min */
    public <E extends T> E mo4731min(Iterator<E> it) {
        return (E) this.forwardOrder.mo4729max(it);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return (Ordering<? super T>) this.forwardOrder;
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }
}
