package me.tvspark;

import com.google.common.collect.BoundType;
import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import me.tvspark.AbstractC2090ex;

/* renamed from: me.tvspark.zu */
/* loaded from: classes4.dex */
public abstract class AbstractC2874zu<E> extends AbstractC2273jv<E> implements AbstractC2766wx<E> {
    public transient Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> Wwwwwwwwwwwwwwwwwwwwww;
    public transient NavigableSet<E> Wwwwwwwwwwwwwwwwwwwwwww;
    public transient Comparator<? super E> Wwwwwwwwwwwwwwwwwwwwwwww;

    @Override // me.tvspark.AbstractC2766wx, me.tvspark.AbstractC2689ux
    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (comparator == null) {
            Ordering reverse = Ordering.from(AbstractC2500pu.this.comparator()).reverse();
            this.Wwwwwwwwwwwwwwwwwwwwwwww = reverse;
            return reverse;
        }
        return comparator;
    }

    @Override // me.tvspark.AbstractC2273jv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public AbstractC2090ex<E> mo4974delegate() {
        return AbstractC2500pu.this;
    }

    @Override // me.tvspark.AbstractC2766wx
    /* renamed from: descendingMultiset */
    public AbstractC2766wx<E> mo4619descendingMultiset() {
        return AbstractC2500pu.this;
    }

    @Override // me.tvspark.AbstractC2273jv, me.tvspark.AbstractC2090ex
    /* renamed from: elementSet */
    public NavigableSet<E> mo4975elementSet() {
        NavigableSet<E> navigableSet = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (navigableSet == null) {
            C2877zx c2877zx = new C2877zx(this);
            this.Wwwwwwwwwwwwwwwwwwwwwww = c2877zx;
            return c2877zx;
        }
        return navigableSet;
    }

    @Override // me.tvspark.AbstractC2273jv, me.tvspark.AbstractC2090ex
    /* renamed from: entrySet */
    public Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> mo4575entrySet() {
        Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> set = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (set == null) {
            C2837yu c2837yu = new C2837yu(this);
            this.Wwwwwwwwwwwwwwwwwwwwww = c2837yu;
            return c2837yu;
        }
        return set;
    }

    @Override // me.tvspark.AbstractC2766wx
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> firstEntry() {
        return AbstractC2500pu.this.lastEntry();
    }

    @Override // me.tvspark.AbstractC2766wx
    /* renamed from: headMultiset */
    public AbstractC2766wx<E> mo4721headMultiset(E e, BoundType boundType) {
        return AbstractC2500pu.this.mo4722tailMultiset(e, boundType).mo4619descendingMultiset();
    }

    @Override // me.tvspark.AbstractC2766wx
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> lastEntry() {
        return AbstractC2500pu.this.firstEntry();
    }

    @Override // me.tvspark.AbstractC2766wx
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> pollFirstEntry() {
        return AbstractC2500pu.this.pollLastEntry();
    }

    @Override // me.tvspark.AbstractC2766wx
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> pollLastEntry() {
        return AbstractC2500pu.this.pollFirstEntry();
    }

    @Override // me.tvspark.AbstractC2766wx
    /* renamed from: subMultiset */
    public AbstractC2766wx<E> mo4623subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        return AbstractC2500pu.this.mo4623subMultiset(e2, boundType2, e, boundType).mo4619descendingMultiset();
    }

    @Override // me.tvspark.AbstractC2766wx
    /* renamed from: tailMultiset */
    public AbstractC2766wx<E> mo4722tailMultiset(E e, BoundType boundType) {
        return AbstractC2500pu.this.mo4721headMultiset(e, boundType).mo4619descendingMultiset();
    }

    @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }

    @Override // me.tvspark.AbstractC2310kv
    public String toString() {
        return mo4575entrySet().toString();
    }
}
