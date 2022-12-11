package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;
import me.tvspark.AbstractC2347lv;
import me.tvspark.C2649tv;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class EvictingQueue<E> extends AbstractC2347lv<E> implements Serializable {
    public static final long serialVersionUID = 0;
    public final Queue<E> delegate;
    public final int maxSize;

    public EvictingQueue(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 0, "maxSize (%s) must >= 0", i);
        this.delegate = new ArrayDeque(i);
        this.maxSize = i;
    }

    public static <E> EvictingQueue<E> create(int i) {
        return new EvictingQueue<>(i);
    }

    @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Queue
    public boolean add(E e) {
        if (e != null) {
            if (this.maxSize == 0) {
                return true;
            }
            if (size() == this.maxSize) {
                this.delegate.remove();
            }
            this.delegate.add(e);
            return true;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2051dv, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        if (size >= this.maxSize) {
            clear();
            int i = size - this.maxSize;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 0, "number to skip cannot be negative");
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) this, (Iterable) new C2649tv(collection, i));
        }
        return standardAddAll(collection);
    }

    @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Queue<E> mo4974delegate = mo4974delegate();
        if (obj != null) {
            return mo4974delegate.contains(obj);
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2347lv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public Queue<E> mo4974delegate() {
        return this.delegate;
    }

    @Override // me.tvspark.AbstractC2347lv, java.util.Queue
    public boolean offer(E e) {
        return add(e);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        Queue<E> mo4974delegate = mo4974delegate();
        if (obj != null) {
            return mo4974delegate.remove(obj);
        }
        throw null;
    }
}
