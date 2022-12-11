package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedCollection<E> extends Synchronized$SynchronizedObject implements Collection<E> {
    public static final long serialVersionUID = 0;

    public Synchronized$SynchronizedCollection(Collection<E> collection, Object obj) {
        super(collection, obj);
    }

    @Override // java.util.Collection
    public boolean add(E e) {
        boolean add;
        synchronized (this.mutex) {
            add = mo4780delegate().add(e);
        }
        return add;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = mo4780delegate().addAll(collection);
        }
        return addAll;
    }

    @Override // java.util.Collection
    public void clear() {
        synchronized (this.mutex) {
            mo4780delegate().clear();
        }
    }

    public boolean contains(Object obj) {
        boolean contains;
        synchronized (this.mutex) {
            contains = mo4780delegate().contains(obj);
        }
        return contains;
    }

    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = mo4780delegate().containsAll(collection);
        }
        return containsAll;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate  reason: collision with other method in class */
    public Collection<E> mo4780delegate() {
        return (Collection) super.mo4780delegate();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = mo4780delegate().isEmpty();
        }
        return isEmpty;
    }

    public Iterator<E> iterator() {
        return mo4780delegate().iterator();
    }

    public boolean remove(Object obj) {
        boolean remove;
        synchronized (this.mutex) {
            remove = mo4780delegate().remove(obj);
        }
        return remove;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = mo4780delegate().removeAll(collection);
        }
        return removeAll;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = mo4780delegate().retainAll(collection);
        }
        return retainAll;
    }

    @Override // java.util.Collection
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = mo4780delegate().size();
        }
        return size;
    }

    public Object[] toArray() {
        Object[] array;
        synchronized (this.mutex) {
            array = mo4780delegate().toArray();
        }
        return array;
    }

    public <T> T[] toArray(T[] tArr) {
        T[] tArr2;
        synchronized (this.mutex) {
            tArr2 = (T[]) mo4780delegate().toArray(tArr);
        }
        return tArr2;
    }
}
