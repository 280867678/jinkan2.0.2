package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {
    public static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
    public static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        if (comparable != null) {
            if (comparable != comparable2) {
                return comparable2.compareTo(comparable);
            }
            return 0;
        }
        throw null;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(E e, E e2) {
        return (E) NaturalOrdering.INSTANCE.min(e, e2);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(E e, E e2, E e3, E... eArr) {
        return (E) NaturalOrdering.INSTANCE.min(e, e2, e3, eArr);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: max */
    public <E extends Comparable> E mo4728max(Iterable<E> iterable) {
        return (E) NaturalOrdering.INSTANCE.mo4730min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: max */
    public <E extends Comparable> E mo4729max(Iterator<E> it) {
        return (E) NaturalOrdering.INSTANCE.mo4731min(it);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: max  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo4728max(Iterable iterable) {
        return mo4728max((Iterable<Comparable>) iterable);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: max  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo4729max(Iterator it) {
        return mo4729max((Iterator<Comparable>) it);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(E e, E e2) {
        return (E) NaturalOrdering.INSTANCE.max(e, e2);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(E e, E e2, E e3, E... eArr) {
        return (E) NaturalOrdering.INSTANCE.max(e, e2, e3, eArr);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: min */
    public <E extends Comparable> E mo4730min(Iterable<E> iterable) {
        return (E) NaturalOrdering.INSTANCE.mo4728max(iterable);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: min */
    public <E extends Comparable> E mo4731min(Iterator<E> it) {
        return (E) NaturalOrdering.INSTANCE.mo4729max(it);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: min  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo4730min(Iterable iterable) {
        return mo4730min((Iterable<Comparable>) iterable);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: min  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo4731min(Iterator it) {
        return mo4731min((Iterator<Comparable>) it);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return Ordering.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
