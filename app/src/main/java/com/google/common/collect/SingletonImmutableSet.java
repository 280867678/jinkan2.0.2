package com.google.common.collect;

import me.tvspark.AbstractC2239iy;
import me.tvspark.C2801xv;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    public transient int cachedHashCode;
    public final transient E element;

    public SingletonImmutableSet(E e) {
        if (e != null) {
            this.element = e;
            return;
        }
        throw null;
    }

    public SingletonImmutableSet(E e, int i) {
        this.element = e;
        this.cachedHashCode = i;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.element.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i) {
        objArr[i] = this.element;
        return i + 1;
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> createAsList() {
        return ImmutableList.m3918of((Object) this.element);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.cachedHashCode;
        if (i == 0) {
            int hashCode = this.element.hashCode();
            this.cachedHashCode = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean isHashCodeFast() {
        return this.cachedHashCode != 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* renamed from: iterator  reason: collision with other method in class */
    public AbstractC2239iy<E> mo4735iterator() {
        return new C2801xv(this.element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('[');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.element.toString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(']');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
