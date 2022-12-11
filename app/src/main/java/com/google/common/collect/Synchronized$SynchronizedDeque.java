package com.google.common.collect;

import java.util.Deque;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class Synchronized$SynchronizedDeque<E> extends Synchronized$SynchronizedQueue<E> implements Deque<E> {
    public static final long serialVersionUID = 0;

    public Synchronized$SynchronizedDeque(Deque<E> deque, Object obj) {
        super(deque, obj);
    }

    @Override // java.util.Deque
    public void addFirst(E e) {
        synchronized (this.mutex) {
            mo4780delegate().addFirst(e);
        }
    }

    @Override // java.util.Deque
    public void addLast(E e) {
        synchronized (this.mutex) {
            mo4780delegate().addLast(e);
        }
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedQueue, com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate */
    public Deque<E> mo4780delegate() {
        return (Deque) super.mo4780delegate();
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        Iterator<E> descendingIterator;
        synchronized (this.mutex) {
            descendingIterator = mo4780delegate().descendingIterator();
        }
        return descendingIterator;
    }

    @Override // java.util.Deque
    public E getFirst() {
        E first;
        synchronized (this.mutex) {
            first = mo4780delegate().getFirst();
        }
        return first;
    }

    @Override // java.util.Deque
    public E getLast() {
        E last;
        synchronized (this.mutex) {
            last = mo4780delegate().getLast();
        }
        return last;
    }

    @Override // java.util.Deque
    public boolean offerFirst(E e) {
        boolean offerFirst;
        synchronized (this.mutex) {
            offerFirst = mo4780delegate().offerFirst(e);
        }
        return offerFirst;
    }

    @Override // java.util.Deque
    public boolean offerLast(E e) {
        boolean offerLast;
        synchronized (this.mutex) {
            offerLast = mo4780delegate().offerLast(e);
        }
        return offerLast;
    }

    @Override // java.util.Deque
    public E peekFirst() {
        E peekFirst;
        synchronized (this.mutex) {
            peekFirst = mo4780delegate().peekFirst();
        }
        return peekFirst;
    }

    @Override // java.util.Deque
    public E peekLast() {
        E peekLast;
        synchronized (this.mutex) {
            peekLast = mo4780delegate().peekLast();
        }
        return peekLast;
    }

    @Override // java.util.Deque
    public E pollFirst() {
        E pollFirst;
        synchronized (this.mutex) {
            pollFirst = mo4780delegate().pollFirst();
        }
        return pollFirst;
    }

    @Override // java.util.Deque
    public E pollLast() {
        E pollLast;
        synchronized (this.mutex) {
            pollLast = mo4780delegate().pollLast();
        }
        return pollLast;
    }

    @Override // java.util.Deque
    public E pop() {
        E pop;
        synchronized (this.mutex) {
            pop = mo4780delegate().pop();
        }
        return pop;
    }

    @Override // java.util.Deque
    public void push(E e) {
        synchronized (this.mutex) {
            mo4780delegate().push(e);
        }
    }

    @Override // java.util.Deque
    public E removeFirst() {
        E removeFirst;
        synchronized (this.mutex) {
            removeFirst = mo4780delegate().removeFirst();
        }
        return removeFirst;
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(Object obj) {
        boolean removeFirstOccurrence;
        synchronized (this.mutex) {
            removeFirstOccurrence = mo4780delegate().removeFirstOccurrence(obj);
        }
        return removeFirstOccurrence;
    }

    @Override // java.util.Deque
    public E removeLast() {
        E removeLast;
        synchronized (this.mutex) {
            removeLast = mo4780delegate().removeLast();
        }
        return removeLast;
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(Object obj) {
        boolean removeLastOccurrence;
        synchronized (this.mutex) {
            removeLastOccurrence = mo4780delegate().removeLastOccurrence(obj);
        }
        return removeLastOccurrence;
    }
}
