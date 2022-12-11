package com.google.common.collect;

import java.util.Queue;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedQueue<E> extends Synchronized$SynchronizedCollection<E> implements Queue<E> {
    public static final long serialVersionUID = 0;

    public Synchronized$SynchronizedQueue(Queue<E> queue, Object obj) {
        super(queue, obj);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate */
    public Queue<E> mo4780delegate() {
        return (Queue) super.mo4780delegate();
    }

    @Override // java.util.Queue
    public E element() {
        E element;
        synchronized (this.mutex) {
            element = mo4780delegate().element();
        }
        return element;
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        boolean offer;
        synchronized (this.mutex) {
            offer = mo4780delegate().offer(e);
        }
        return offer;
    }

    @Override // java.util.Queue
    public E peek() {
        E peek;
        synchronized (this.mutex) {
            peek = mo4780delegate().peek();
        }
        return peek;
    }

    @Override // java.util.Queue
    public E poll() {
        E poll;
        synchronized (this.mutex) {
            poll = mo4780delegate().poll();
        }
        return poll;
    }

    @Override // java.util.Queue
    public E remove() {
        E remove;
        synchronized (this.mutex) {
            remove = mo4780delegate().remove();
        }
        return remove;
    }
}
