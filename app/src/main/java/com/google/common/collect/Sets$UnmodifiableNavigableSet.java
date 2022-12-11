package com.google.common.collect;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import me.tvspark.AbstractC2458ov;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class Sets$UnmodifiableNavigableSet<E> extends AbstractC2458ov<E> implements NavigableSet<E>, Serializable {
    public static final long serialVersionUID = 0;
    public final NavigableSet<E> delegate;
    public transient Sets$UnmodifiableNavigableSet<E> descendingSet;
    public final SortedSet<E> unmodifiableDelegate;

    public Sets$UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        if (navigableSet != null) {
            this.delegate = navigableSet;
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(navigableSet);
            return;
        }
        throw null;
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e) {
        return this.delegate.ceiling(e);
    }

    @Override // me.tvspark.AbstractC2458ov, me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public SortedSet<E> mo4974delegate() {
        return this.unmodifiableDelegate;
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator) this.delegate.descendingIterator());
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        Sets$UnmodifiableNavigableSet<E> sets$UnmodifiableNavigableSet = this.descendingSet;
        if (sets$UnmodifiableNavigableSet == null) {
            Sets$UnmodifiableNavigableSet<E> sets$UnmodifiableNavigableSet2 = new Sets$UnmodifiableNavigableSet<>(this.delegate.descendingSet());
            this.descendingSet = sets$UnmodifiableNavigableSet2;
            sets$UnmodifiableNavigableSet2.descendingSet = this;
            return sets$UnmodifiableNavigableSet2;
        }
        return sets$UnmodifiableNavigableSet;
    }

    @Override // java.util.NavigableSet
    public E floor(E e) {
        return this.delegate.floor(e);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e, boolean z) {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((NavigableSet) this.delegate.headSet(e, z));
    }

    @Override // java.util.NavigableSet
    public E higher(E e) {
        return this.delegate.higher(e);
    }

    @Override // java.util.NavigableSet
    public E lower(E e) {
        return this.delegate.lower(e);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((NavigableSet) this.delegate.subSet(e, z, e2, z2));
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e, boolean z) {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((NavigableSet) this.delegate.tailSet(e, z));
    }
}
