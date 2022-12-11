package me.tvspark;

import java.util.Collection;

/* renamed from: me.tvspark.hx */
/* loaded from: classes4.dex */
public abstract class AbstractC2201hx<E> extends AbstractC2651tx<E> {
    public abstract AbstractC2090ex<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().containsAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().remove(obj, Integer.MAX_VALUE) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().mo4575entrySet().size();
    }
}
