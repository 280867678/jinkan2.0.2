package me.tvspark;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: me.tvspark.ex */
/* loaded from: classes4.dex */
public interface AbstractC2090ex<E> extends Collection<E> {

    /* renamed from: me.tvspark.ex$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> {
        int getCount();

        E getElement();

        String toString();
    }

    int add(E e, int i);

    @Override // java.util.Collection, me.tvspark.AbstractC2090ex
    boolean contains(Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int count(Object obj);

    /* renamed from: elementSet */
    Set<E> mo4975elementSet();

    /* renamed from: entrySet */
    Set<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> mo4575entrySet();

    @Override // me.tvspark.AbstractC2090ex
    boolean equals(Object obj);

    @Override // me.tvspark.AbstractC2090ex
    int hashCode();

    @Override // java.util.Collection, java.lang.Iterable, me.tvspark.AbstractC2090ex
    Iterator<E> iterator();

    int remove(Object obj, int i);

    @Override // java.util.Collection
    boolean remove(Object obj);

    int setCount(E e, int i);

    boolean setCount(E e, int i, int i2);

    @Override // java.util.Collection, me.tvspark.AbstractC2090ex
    int size();
}
