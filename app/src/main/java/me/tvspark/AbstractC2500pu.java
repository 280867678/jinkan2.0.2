package me.tvspark;

import com.google.common.collect.BoundType;
import com.google.common.collect.Multisets$ImmutableEntry;
import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import me.tvspark.AbstractC2090ex;

/* renamed from: me.tvspark.pu */
/* loaded from: classes4.dex */
public abstract class AbstractC2500pu<E> extends AbstractC2346lu<E> implements AbstractC2766wx<E> {
    public final Comparator<? super E> comparator;
    public transient AbstractC2766wx<E> descendingMultiset;

    /* renamed from: me.tvspark.pu$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2874zu<E> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return AbstractC2500pu.this.descendingIterator();
        }
    }

    public AbstractC2500pu() {
        this(Ordering.natural());
    }

    public AbstractC2500pu(Comparator<? super E> comparator) {
        if (comparator != null) {
            this.comparator = comparator;
            return;
        }
        throw null;
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public AbstractC2766wx<E> createDescendingMultiset() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2346lu
    /* renamed from: createElementSet */
    public NavigableSet<E> mo4951createElementSet() {
        return new C2877zx(this);
    }

    public abstract Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> descendingEntryIterator();

    public Iterator<E> descendingIterator() {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex) mo4619descendingMultiset());
    }

    /* renamed from: descendingMultiset */
    public AbstractC2766wx<E> mo4619descendingMultiset() {
        AbstractC2766wx<E> abstractC2766wx = this.descendingMultiset;
        if (abstractC2766wx == null) {
            AbstractC2766wx<E> createDescendingMultiset = createDescendingMultiset();
            this.descendingMultiset = createDescendingMultiset;
            return createDescendingMultiset;
        }
        return abstractC2766wx;
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    /* renamed from: elementSet */
    public NavigableSet<E> mo4975elementSet() {
        return (NavigableSet) super.mo4975elementSet();
    }

    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> firstEntry() {
        Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> entryIterator = entryIterator();
        if (entryIterator.hasNext()) {
            return entryIterator.next();
        }
        return null;
    }

    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> lastEntry() {
        Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> descendingEntryIterator = descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            return descendingEntryIterator.next();
        }
        return null;
    }

    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> pollFirstEntry() {
        Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> entryIterator = entryIterator();
        if (entryIterator.hasNext()) {
            AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> next = entryIterator.next();
            Multisets$ImmutableEntry multisets$ImmutableEntry = new Multisets$ImmutableEntry(next.getElement(), next.getCount());
            entryIterator.remove();
            return multisets$ImmutableEntry;
        }
        return null;
    }

    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> pollLastEntry() {
        Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> descendingEntryIterator = descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> next = descendingEntryIterator.next();
            Multisets$ImmutableEntry multisets$ImmutableEntry = new Multisets$ImmutableEntry(next.getElement(), next.getCount());
            descendingEntryIterator.remove();
            return multisets$ImmutableEntry;
        }
        return null;
    }

    /* renamed from: subMultiset */
    public AbstractC2766wx<E> mo4623subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        if (boundType != null) {
            if (boundType2 == null) {
                throw null;
            }
            return mo4722tailMultiset(e, boundType).mo4721headMultiset(e2, boundType2);
        }
        throw null;
    }
}
