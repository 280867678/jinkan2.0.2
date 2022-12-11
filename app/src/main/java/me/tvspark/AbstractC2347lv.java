package me.tvspark;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Queue;

/* renamed from: me.tvspark.lv */
/* loaded from: classes4.dex */
public abstract class AbstractC2347lv<E> extends AbstractC2051dv<E> implements Queue<E> {
    @Override // me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract /* bridge */ /* synthetic */ Object mo4974delegate();

    @Override // me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public abstract /* bridge */ /* synthetic */ Collection mo4974delegate();

    @Override // me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract Queue<E> mo4974delegate();

    @Override // java.util.Queue
    public E element() {
        return mo4974delegate().element();
    }

    public abstract boolean offer(E e);

    @Override // java.util.Queue
    public E peek() {
        return mo4974delegate().peek();
    }

    @Override // java.util.Queue
    public E poll() {
        return mo4974delegate().poll();
    }

    @Override // java.util.Queue
    public E remove() {
        return mo4974delegate().remove();
    }

    public boolean standardOffer(E e) {
        try {
            return add(e);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public E standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    public E standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}
