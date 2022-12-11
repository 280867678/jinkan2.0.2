package me.tvspark;

import com.google.common.collect.BoundType;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import me.tvspark.AbstractC2090ex;

/* renamed from: me.tvspark.yx */
/* loaded from: classes4.dex */
public class C2840yx<E> extends AbstractC2201hx<E> implements SortedSet<E> {
    public final AbstractC2766wx<E> Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2840yx(AbstractC2766wx<E> abstractC2766wx) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2766wx;
    }

    @Override // me.tvspark.AbstractC2201hx
    public AbstractC2090ex Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.comparator();
    }

    @Override // java.util.SortedSet
    public E first() {
        AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> firstEntry = this.Wwwwwwwwwwwwwwwwwwwwwwww.firstEntry();
        if (firstEntry != null) {
            return firstEntry.getElement();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4721headMultiset(e, BoundType.OPEN).mo4975elementSet();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new C2127fx(this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4575entrySet().iterator());
    }

    @Override // java.util.SortedSet
    public E last() {
        AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> lastEntry = this.Wwwwwwwwwwwwwwwwwwwwwwww.lastEntry();
        if (lastEntry != null) {
            return lastEntry.getElement();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E e, E e2) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4623subMultiset(e, BoundType.CLOSED, e2, BoundType.OPEN).mo4975elementSet();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4722tailMultiset(e, BoundType.CLOSED).mo4975elementSet();
    }
}
