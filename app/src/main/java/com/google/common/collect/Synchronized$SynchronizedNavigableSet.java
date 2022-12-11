package com.google.common.collect;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedNavigableSet<E> extends Synchronized$SynchronizedSortedSet<E> implements NavigableSet<E> {
    public static final long serialVersionUID = 0;
    public transient NavigableSet<E> descendingSet;

    public Synchronized$SynchronizedNavigableSet(NavigableSet<E> navigableSet, Object obj) {
        super(navigableSet, obj);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e) {
        E ceiling;
        synchronized (this.mutex) {
            ceiling = mo4780delegate().ceiling(e);
        }
        return ceiling;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedSet, com.google.common.collect.Synchronized$SynchronizedSet, com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate */
    public NavigableSet<E> mo4780delegate() {
        return (NavigableSet) super.mo4780delegate();
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return mo4780delegate().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        synchronized (this.mutex) {
            if (this.descendingSet != null) {
                return this.descendingSet;
            }
            Synchronized$SynchronizedNavigableSet synchronized$SynchronizedNavigableSet = new Synchronized$SynchronizedNavigableSet(mo4780delegate().descendingSet(), this.mutex);
            this.descendingSet = synchronized$SynchronizedNavigableSet;
            return synchronized$SynchronizedNavigableSet;
        }
    }

    @Override // java.util.NavigableSet
    public E floor(E e) {
        E floor;
        synchronized (this.mutex) {
            floor = mo4780delegate().floor(e);
        }
        return floor;
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e, boolean z) {
        Synchronized$SynchronizedNavigableSet synchronized$SynchronizedNavigableSet;
        synchronized (this.mutex) {
            synchronized$SynchronizedNavigableSet = new Synchronized$SynchronizedNavigableSet(mo4780delegate().headSet(e, z), this.mutex);
        }
        return synchronized$SynchronizedNavigableSet;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> headSet(E e) {
        return headSet(e, false);
    }

    @Override // java.util.NavigableSet
    public E higher(E e) {
        E higher;
        synchronized (this.mutex) {
            higher = mo4780delegate().higher(e);
        }
        return higher;
    }

    @Override // java.util.NavigableSet
    public E lower(E e) {
        E lower;
        synchronized (this.mutex) {
            lower = mo4780delegate().lower(e);
        }
        return lower;
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        E pollFirst;
        synchronized (this.mutex) {
            pollFirst = mo4780delegate().pollFirst();
        }
        return pollFirst;
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        E pollLast;
        synchronized (this.mutex) {
            pollLast = mo4780delegate().pollLast();
        }
        return pollLast;
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        Synchronized$SynchronizedNavigableSet synchronized$SynchronizedNavigableSet;
        synchronized (this.mutex) {
            synchronized$SynchronizedNavigableSet = new Synchronized$SynchronizedNavigableSet(mo4780delegate().subSet(e, z, e2, z2), this.mutex);
        }
        return synchronized$SynchronizedNavigableSet;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> subSet(E e, E e2) {
        return subSet(e, true, e2, false);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e, boolean z) {
        Synchronized$SynchronizedNavigableSet synchronized$SynchronizedNavigableSet;
        synchronized (this.mutex) {
            synchronized$SynchronizedNavigableSet = new Synchronized$SynchronizedNavigableSet(mo4780delegate().tailSet(e, z), this.mutex);
        }
        return synchronized$SynchronizedNavigableSet;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> tailSet(E e) {
        return tailSet(e, true);
    }
}
