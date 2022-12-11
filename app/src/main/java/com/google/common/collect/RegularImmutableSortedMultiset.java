package com.google.common.collect;

import java.util.Comparator;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2766wx;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    public final transient long[] cumulativeCounts;
    public final transient RegularImmutableSortedSet<E> elementSet;
    public final transient int length;
    public final transient int offset;
    public static final long[] ZERO_CUMULATIVE_COUNTS = {0};
    public static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());

    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i, int i2) {
        this.elementSet = regularImmutableSortedSet;
        this.cumulativeCounts = jArr;
        this.offset = i;
        this.length = i2;
    }

    public RegularImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
        this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
        this.offset = 0;
        this.length = 0;
    }

    private int getCount(int i) {
        long[] jArr = this.cumulativeCounts;
        int i2 = this.offset;
        return (int) (jArr[(i2 + i) + 1] - jArr[i2 + i]);
    }

    @Override // me.tvspark.AbstractC2090ex
    public int count(Object obj) {
        int indexOf = this.elementSet.indexOf(obj);
        if (indexOf >= 0) {
            return getCount(indexOf);
        }
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, me.tvspark.AbstractC2090ex
    /* renamed from: elementSet  reason: collision with other method in class */
    public ImmutableSortedSet<E> mo4975elementSet() {
        return this.elementSet;
    }

    @Override // me.tvspark.AbstractC2766wx
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> getEntry(int i) {
        return new Multisets$ImmutableEntry(this.elementSet.asList().get(i), getCount(i));
    }

    public ImmutableSortedMultiset<E> getSubMultiset(int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, this.length);
        return i == i2 ? ImmutableSortedMultiset.emptyMultiset(comparator()) : (i == 0 && i2 == this.length) ? this : new RegularImmutableSortedMultiset(this.elementSet.getSubSet(i, i2), this.cumulativeCounts, this.offset + i, i2 - i);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, me.tvspark.AbstractC2766wx
    /* renamed from: headMultiset */
    public ImmutableSortedMultiset<E> mo4721headMultiset(E e, BoundType boundType) {
        RegularImmutableSortedSet<E> regularImmutableSortedSet = this.elementSet;
        if (boundType != null) {
            return getSubMultiset(0, regularImmutableSortedSet.headIndex(e, boundType == BoundType.CLOSED));
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, me.tvspark.AbstractC2766wx
    /* renamed from: headMultiset  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ AbstractC2766wx mo4721headMultiset(Object obj, BoundType boundType) {
        return mo4721headMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.offset > 0 || this.length < this.cumulativeCounts.length - 1;
    }

    @Override // me.tvspark.AbstractC2766wx
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.length - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, me.tvspark.AbstractC2090ex
    public int size() {
        long[] jArr = this.cumulativeCounts;
        int i = this.offset;
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr[this.length + i] - jArr[i]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, me.tvspark.AbstractC2766wx
    /* renamed from: tailMultiset */
    public ImmutableSortedMultiset<E> mo4722tailMultiset(E e, BoundType boundType) {
        RegularImmutableSortedSet<E> regularImmutableSortedSet = this.elementSet;
        if (boundType != null) {
            return getSubMultiset(regularImmutableSortedSet.tailIndex(e, boundType == BoundType.CLOSED), this.length);
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, me.tvspark.AbstractC2766wx
    /* renamed from: tailMultiset  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ AbstractC2766wx mo4722tailMultiset(Object obj, BoundType boundType) {
        return mo4722tailMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }
}
