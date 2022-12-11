package com.google.common.collect;

import java.util.Comparator;
import java.util.NavigableSet;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2766wx;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class UnmodifiableSortedMultiset<E> extends Multisets$UnmodifiableMultiset<E> implements AbstractC2766wx<E> {
    public static final long serialVersionUID = 0;
    public transient UnmodifiableSortedMultiset<E> descendingMultiset;

    public UnmodifiableSortedMultiset(AbstractC2766wx<E> abstractC2766wx) {
        super(abstractC2766wx);
    }

    @Override // me.tvspark.AbstractC2766wx, me.tvspark.AbstractC2689ux
    public Comparator<? super E> comparator() {
        return mo4974delegate().comparator();
    }

    @Override // com.google.common.collect.Multisets$UnmodifiableMultiset
    /* renamed from: createElementSet */
    public NavigableSet<E> mo4799createElementSet() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((NavigableSet) mo4974delegate().mo4975elementSet());
    }

    @Override // com.google.common.collect.Multisets$UnmodifiableMultiset, me.tvspark.AbstractC2273jv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public AbstractC2766wx<E> mo4974delegate() {
        return (AbstractC2766wx) super.mo4974delegate();
    }

    @Override // me.tvspark.AbstractC2766wx
    /* renamed from: descendingMultiset */
    public AbstractC2766wx<E> mo4619descendingMultiset() {
        UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset = this.descendingMultiset;
        if (unmodifiableSortedMultiset == null) {
            UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset2 = new UnmodifiableSortedMultiset<>(mo4974delegate().mo4619descendingMultiset());
            unmodifiableSortedMultiset2.descendingMultiset = this;
            this.descendingMultiset = unmodifiableSortedMultiset2;
            return unmodifiableSortedMultiset2;
        }
        return unmodifiableSortedMultiset;
    }

    @Override // com.google.common.collect.Multisets$UnmodifiableMultiset, me.tvspark.AbstractC2273jv, me.tvspark.AbstractC2090ex
    /* renamed from: elementSet */
    public NavigableSet<E> mo4975elementSet() {
        return (NavigableSet) super.mo4975elementSet();
    }

    @Override // me.tvspark.AbstractC2766wx
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> firstEntry() {
        return mo4974delegate().firstEntry();
    }

    @Override // me.tvspark.AbstractC2766wx
    /* renamed from: headMultiset */
    public AbstractC2766wx<E> mo4721headMultiset(E e, BoundType boundType) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2766wx) mo4974delegate().mo4721headMultiset(e, boundType));
    }

    @Override // me.tvspark.AbstractC2766wx
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> lastEntry() {
        return mo4974delegate().lastEntry();
    }

    @Override // me.tvspark.AbstractC2766wx
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2766wx
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2766wx
    /* renamed from: subMultiset */
    public AbstractC2766wx<E> mo4623subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2766wx) mo4974delegate().mo4623subMultiset(e, boundType, e2, boundType2));
    }

    @Override // me.tvspark.AbstractC2766wx
    /* renamed from: tailMultiset */
    public AbstractC2766wx<E> mo4722tailMultiset(E e, BoundType boundType) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2766wx) mo4974delegate().mo4722tailMultiset(e, boundType));
    }
}
