package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2273jv;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Multisets$UnmodifiableMultiset<E> extends AbstractC2273jv<E> implements Serializable {
    public static final long serialVersionUID = 0;
    public final AbstractC2090ex<? extends E> delegate;
    public transient Set<E> elementSet;
    public transient Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> entrySet;

    public Multisets$UnmodifiableMultiset(AbstractC2090ex<? extends E> abstractC2090ex) {
        this.delegate = abstractC2090ex;
    }

    @Override // me.tvspark.AbstractC2273jv, me.tvspark.AbstractC2090ex
    public int add(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Queue
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2051dv, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
    public void clear() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: createElementSet */
    public Set<E> mo4799createElementSet() {
        return Collections.unmodifiableSet(this.delegate.mo4975elementSet());
    }

    @Override // me.tvspark.AbstractC2273jv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public AbstractC2090ex<E> mo4974delegate() {
        return (AbstractC2090ex<? extends E>) this.delegate;
    }

    @Override // me.tvspark.AbstractC2273jv, me.tvspark.AbstractC2090ex
    /* renamed from: elementSet */
    public Set<E> mo4975elementSet() {
        Set<E> set = this.elementSet;
        if (set == null) {
            Set<E> mo4799createElementSet = mo4799createElementSet();
            this.elementSet = mo4799createElementSet;
            return mo4799createElementSet;
        }
        return set;
    }

    @Override // me.tvspark.AbstractC2273jv, me.tvspark.AbstractC2090ex
    /* renamed from: entrySet */
    public Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> mo4575entrySet() {
        Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> set = this.entrySet;
        if (set == null) {
            Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> unmodifiableSet = Collections.unmodifiableSet(this.delegate.mo4575entrySet());
            this.entrySet = unmodifiableSet;
            return unmodifiableSet;
        }
        return set;
    }

    @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator) this.delegate.iterator());
    }

    @Override // me.tvspark.AbstractC2273jv, me.tvspark.AbstractC2090ex
    public int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2273jv, me.tvspark.AbstractC2090ex
    public int setCount(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2273jv, me.tvspark.AbstractC2090ex
    public boolean setCount(E e, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
