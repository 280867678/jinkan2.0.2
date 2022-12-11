package com.google.common.collect;

import java.io.Serializable;

/* loaded from: classes3.dex */
public final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
    public static final NaturalOrdering INSTANCE = new NaturalOrdering();
    public static final long serialVersionUID = 0;
    public transient Ordering<Comparable> nullsFirst;
    public transient Ordering<Comparable> nullsLast;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        if (comparable != null) {
            if (comparable2 == null) {
                throw null;
            }
            return comparable.compareTo(comparable2);
        }
        throw null;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> nullsFirst() {
        Ordering<S> ordering = (Ordering<S>) this.nullsFirst;
        if (ordering == null) {
            Ordering<S> nullsFirst = super.nullsFirst();
            this.nullsFirst = nullsFirst;
            return nullsFirst;
        }
        return ordering;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> nullsLast() {
        Ordering<S> ordering = (Ordering<S>) this.nullsLast;
        if (ordering == null) {
            Ordering<S> nullsLast = super.nullsLast();
            this.nullsLast = nullsLast;
            return nullsLast;
        }
        return ordering;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return ReverseNaturalOrdering.INSTANCE;
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
