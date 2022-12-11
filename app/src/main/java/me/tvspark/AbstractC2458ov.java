package me.tvspark;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;

/* renamed from: me.tvspark.ov */
/* loaded from: classes4.dex */
public abstract class AbstractC2458ov<E> extends AbstractC2384mv<E> implements SortedSet<E> {
    private int unsafeCompare(Object obj, Object obj2) {
        Comparator<? super E> comparator = comparator();
        return comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return mo4974delegate().comparator();
    }

    @Override // me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract /* bridge */ /* synthetic */ Object mo4974delegate();

    @Override // me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public abstract /* bridge */ /* synthetic */ Collection mo4974delegate();

    @Override // me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract /* bridge */ /* synthetic */ Set mo4974delegate();

    @Override // me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public abstract SortedSet<E> mo4974delegate();

    @Override // java.util.SortedSet
    public E first() {
        return mo4974delegate().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e) {
        return mo4974delegate().headSet(e);
    }

    @Override // java.util.SortedSet
    public E last() {
        return mo4974delegate().last();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2051dv
    public boolean standardContains(Object obj) {
        try {
            return unsafeCompare(tailSet(obj).first(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2051dv
    public boolean standardRemove(Object obj) {
        try {
            Iterator<E> it = tailSet(obj).iterator();
            if (it.hasNext() && unsafeCompare(it.next(), obj) == 0) {
                it.remove();
                return true;
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public SortedSet<E> standardSubSet(E e, E e2) {
        return tailSet(e).headSet(e2);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E e, E e2) {
        return mo4974delegate().subSet(e, e2);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e) {
        return mo4974delegate().tailSet(e);
    }
}
