package me.tvspark;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import me.tvspark.AbstractC2090ex;

/* renamed from: me.tvspark.lu */
/* loaded from: classes4.dex */
public abstract class AbstractC2346lu<E> extends AbstractCollection<E> implements AbstractC2090ex<E> {
    public transient Set<E> elementSet;
    public transient Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> entrySet;

    /* renamed from: me.tvspark.lu$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2238ix<E> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC2238ix
        public AbstractC2090ex<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return AbstractC2346lu.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> iterator() {
            return AbstractC2346lu.this.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractC2346lu.this.distinctElements();
        }
    }

    /* renamed from: me.tvspark.lu$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2201hx<E> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC2201hx
        public AbstractC2090ex<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return AbstractC2346lu.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return AbstractC2346lu.this.elementIterator();
        }
    }

    public int add(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(E e) {
        add(e, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection<? extends E> collection) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex) this, (Collection) collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract void clear();

    @Override // java.util.AbstractCollection, java.util.Collection, me.tvspark.AbstractC2090ex
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    /* renamed from: createElementSet */
    public Set<E> mo4951createElementSet() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> createEntrySet() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public abstract int distinctElements();

    public abstract Iterator<E> elementIterator();

    /* renamed from: elementSet */
    public Set<E> mo4975elementSet() {
        Set<E> set = this.elementSet;
        if (set == null) {
            Set<E> mo4951createElementSet = mo4951createElementSet();
            this.elementSet = mo4951createElementSet;
            return mo4951createElementSet;
        }
        return set;
    }

    public abstract Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> entryIterator();

    /* renamed from: entrySet */
    public Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> mo4575entrySet() {
        Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> set = this.entrySet;
        if (set == null) {
            Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }
        return set;
    }

    @Override // java.util.Collection, me.tvspark.AbstractC2090ex
    public final boolean equals(Object obj) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex<?>) this, obj);
    }

    @Override // java.util.Collection, me.tvspark.AbstractC2090ex
    public final int hashCode() {
        return mo4575entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return mo4575entrySet().isEmpty();
    }

    public int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, me.tvspark.AbstractC2090ex
    public final boolean remove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        if (collection instanceof AbstractC2090ex) {
            collection = ((AbstractC2090ex) collection).mo4975elementSet();
        }
        return mo4975elementSet().removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, collection);
    }

    public int setCount(E e, int i) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, e, i);
    }

    public boolean setCount(E e, int i, int i2) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, e, i, i2);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return mo4575entrySet().toString();
    }
}
