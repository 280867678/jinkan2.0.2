package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedList<E> extends Synchronized$SynchronizedCollection<E> implements List<E> {
    public static final long serialVersionUID = 0;

    public Synchronized$SynchronizedList(List<E> list, Object obj) {
        super(list, obj);
    }

    @Override // java.util.List
    public void add(int i, E e) {
        synchronized (this.mutex) {
            mo4780delegate().add(i, e);
        }
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = mo4780delegate().addAll(i, collection);
        }
        return addAll;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate */
    public List<E> mo4780delegate() {
        return (List) super.mo4780delegate();
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        boolean equals;
        if (obj == this) {
            return true;
        }
        synchronized (this.mutex) {
            equals = mo4780delegate().equals(obj);
        }
        return equals;
    }

    @Override // java.util.List
    public E get(int i) {
        E e;
        synchronized (this.mutex) {
            e = mo4780delegate().get(i);
        }
        return e;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = mo4780delegate().hashCode();
        }
        return hashCode;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int indexOf;
        synchronized (this.mutex) {
            indexOf = mo4780delegate().indexOf(obj);
        }
        return indexOf;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        int lastIndexOf;
        synchronized (this.mutex) {
            lastIndexOf = mo4780delegate().lastIndexOf(obj);
        }
        return lastIndexOf;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return mo4780delegate().listIterator();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return mo4780delegate().listIterator(i);
    }

    @Override // java.util.List
    public E remove(int i) {
        E remove;
        synchronized (this.mutex) {
            remove = mo4780delegate().remove(i);
        }
        return remove;
    }

    @Override // java.util.List
    public E set(int i, E e) {
        E e2;
        synchronized (this.mutex) {
            e2 = mo4780delegate().set(i, e);
        }
        return e2;
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        List<E> synchronized$SynchronizedRandomAccessList;
        synchronized (this.mutex) {
            List<E> subList = mo4780delegate().subList(i, i2);
            Object obj = this.mutex;
            synchronized$SynchronizedRandomAccessList = subList instanceof RandomAccess ? new Synchronized$SynchronizedRandomAccessList<>(subList, obj) : new Synchronized$SynchronizedList<>(subList, obj);
        }
        return synchronized$SynchronizedRandomAccessList;
    }
}
