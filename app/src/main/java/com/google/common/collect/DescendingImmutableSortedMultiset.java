package com.google.common.collect;

import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2766wx;

/* loaded from: classes3.dex */
public final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    public final transient ImmutableSortedMultiset<E> forward;

    public DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> immutableSortedMultiset) {
        this.forward = immutableSortedMultiset;
    }

    @Override // me.tvspark.AbstractC2090ex
    public int count(Object obj) {
        return this.forward.count(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, me.tvspark.AbstractC2766wx
    /* renamed from: descendingMultiset */
    public ImmutableSortedMultiset<E> mo4619descendingMultiset() {
        return this.forward;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, me.tvspark.AbstractC2090ex
    /* renamed from: elementSet  reason: collision with other method in class */
    public ImmutableSortedSet<E> mo4975elementSet() {
        return this.forward.mo4975elementSet().descendingSet();
    }

    @Override // me.tvspark.AbstractC2766wx
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> firstEntry() {
        return this.forward.lastEntry();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> getEntry(int i) {
        return this.forward.mo4575entrySet().asList().reverse().get(i);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, me.tvspark.AbstractC2766wx
    /* renamed from: headMultiset */
    public ImmutableSortedMultiset<E> mo4721headMultiset(E e, BoundType boundType) {
        return this.forward.mo4722tailMultiset((ImmutableSortedMultiset<E>) e, boundType).mo4619descendingMultiset();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, me.tvspark.AbstractC2766wx
    /* renamed from: headMultiset  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ AbstractC2766wx mo4721headMultiset(Object obj, BoundType boundType) {
        return mo4721headMultiset((DescendingImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.forward.isPartialView();
    }

    @Override // me.tvspark.AbstractC2766wx
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> lastEntry() {
        return this.forward.firstEntry();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, me.tvspark.AbstractC2090ex
    public int size() {
        return this.forward.size();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, me.tvspark.AbstractC2766wx
    /* renamed from: tailMultiset */
    public ImmutableSortedMultiset<E> mo4722tailMultiset(E e, BoundType boundType) {
        return this.forward.mo4721headMultiset((ImmutableSortedMultiset<E>) e, boundType).mo4619descendingMultiset();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, me.tvspark.AbstractC2766wx
    /* renamed from: tailMultiset  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ AbstractC2766wx mo4722tailMultiset(Object obj, BoundType boundType) {
        return mo4722tailMultiset((DescendingImmutableSortedMultiset<E>) obj, boundType);
    }
}
