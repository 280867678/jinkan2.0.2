package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedSortedSet<E> extends Synchronized$SynchronizedSet<E> implements SortedSet<E> {
    public static final long serialVersionUID = 0;

    public Synchronized$SynchronizedSortedSet(SortedSet<E> sortedSet, Object obj) {
        super(sortedSet, obj);
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator;
        synchronized (this.mutex) {
            comparator = mo4780delegate().comparator();
        }
        return comparator;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSet, com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate  reason: collision with other method in class */
    public SortedSet<E> mo4780delegate() {
        return (SortedSet) super.mo4780delegate();
    }

    @Override // java.util.SortedSet
    public E first() {
        E first;
        synchronized (this.mutex) {
            first = mo4780delegate().first();
        }
        return first;
    }

    public SortedSet<E> headSet(E e) {
        Synchronized$SynchronizedSortedSet synchronized$SynchronizedSortedSet;
        synchronized (this.mutex) {
            synchronized$SynchronizedSortedSet = new Synchronized$SynchronizedSortedSet(mo4780delegate().headSet(e), this.mutex);
        }
        return synchronized$SynchronizedSortedSet;
    }

    @Override // java.util.SortedSet
    public E last() {
        E last;
        synchronized (this.mutex) {
            last = mo4780delegate().last();
        }
        return last;
    }

    public SortedSet<E> subSet(E e, E e2) {
        Synchronized$SynchronizedSortedSet synchronized$SynchronizedSortedSet;
        synchronized (this.mutex) {
            synchronized$SynchronizedSortedSet = new Synchronized$SynchronizedSortedSet(mo4780delegate().subSet(e, e2), this.mutex);
        }
        return synchronized$SynchronizedSortedSet;
    }

    public SortedSet<E> tailSet(E e) {
        Synchronized$SynchronizedSortedSet synchronized$SynchronizedSortedSet;
        synchronized (this.mutex) {
            synchronized$SynchronizedSortedSet = new Synchronized$SynchronizedSortedSet(mo4780delegate().tailSet(e), this.mutex);
        }
        return synchronized$SynchronizedSortedSet;
    }
}
