package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2766wx;
import me.tvspark.C2763wu;
import me.tvspark.C2767wy;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements AbstractC2766wx<E> {
    public transient ImmutableSortedMultiset<E> descendingMultiset;

    /* loaded from: classes3.dex */
    public static final class SerializedForm<E> implements Serializable {
        public final Comparator<? super E> comparator;
        public final int[] counts;
        public final E[] elements;

        public SerializedForm(AbstractC2766wx<E> abstractC2766wx) {
            this.comparator = abstractC2766wx.comparator();
            int size = abstractC2766wx.mo4575entrySet().size();
            this.elements = (E[]) new Object[size];
            this.counts = new int[size];
            int i = 0;
            for (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : abstractC2766wx.mo4575entrySet()) {
                this.elements[i] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getElement();
                this.counts[i] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount();
                i++;
            }
        }

        public Object readResolve() {
            int length = this.elements.length;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.comparator);
            for (int i = 0; i < length; i++) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4626Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.elements[i], this.counts[i]);
            }
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4627Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> extends ImmutableMultiset.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> {
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public E[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Comparator<? super E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparator<? super E> comparator) {
            super(true);
            if (comparator != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = comparator;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (E[]) new Object[4];
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[4];
                return;
            }
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.common.collect.ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            mo4626Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) obj, 1);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public /* bridge */ /* synthetic */ ImmutableMultiset.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4626Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, int i) {
            mo4626Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) obj, i);
            return this;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i == 0) {
                return;
            }
            E[] eArr = (E[]) Arrays.copyOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
            Arrays.sort(eArr, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int i2 = 1;
            for (int i3 = 1; i3 < eArr.length; i3++) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compare((Object) eArr[i2 - 1], (Object) eArr[i3]) < 0) {
                    eArr[i2] = eArr[i3];
                    i2++;
                }
            }
            Arrays.fill(eArr, i2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, (Object) null);
            if (z) {
                int i4 = i2 * 4;
                int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i4 > i5 * 3) {
                    eArr = (E[]) Arrays.copyOf(eArr, C2767wy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5, (i5 / 2) + 1));
                }
            }
            int[] iArr = new int[eArr.length];
            for (int i6 = 0; i6 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww; i6++) {
                int binarySearch = Arrays.binarySearch(eArr, 0, i2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i6], this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                int[] iArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (iArr2[i6] >= 0) {
                    iArr[binarySearch] = iArr[binarySearch] + iArr2[i6];
                } else {
                    iArr[binarySearch] = ~iArr2[i6];
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = eArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.common.collect.ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
        public ImmutableMultiset.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            mo4626Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) obj, 1);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public ImmutableMultiset.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object[] objArr) {
            for (Object obj : objArr) {
                mo4626Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) obj, 1);
            }
            return this;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<? extends E> iterable) {
            if (iterable instanceof AbstractC2090ex) {
                for (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : ((AbstractC2090ex) iterable).mo4575entrySet()) {
                    mo4626Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getElement(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount());
                }
            } else {
                for (E e : iterable) {
                    mo4626Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) e, 1);
                }
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> mo4626Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(E e, int i) {
            if (e != null) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "occurrences");
                if (i == 0) {
                    return this;
                }
                int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                E[] eArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i2 == eArr.length) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
                } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (E[]) Arrays.copyOf(eArr, eArr.length);
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                E[] eArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                eArr2[i3] = e;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3] = i;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 1;
                return this;
            }
            throw null;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
        public ImmutableSortedMultiset<E> mo4627Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int i;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i2 >= i) {
                    break;
                }
                int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (iArr[i2] > 0) {
                    E[] eArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    eArr[i3] = eArr[i2];
                    iArr[i3] = iArr[i2];
                    i3++;
                }
                i2++;
            }
            Arrays.fill(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i3, i, (Object) null);
            Arrays.fill(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, i3, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, 0);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
            if (i3 == 0) {
                return ImmutableSortedMultiset.emptyMultiset(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet) ImmutableSortedSet.construct(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i3, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            long[] jArr = new long[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww + 1];
            int i4 = 0;
            while (i4 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                int i5 = i4 + 1;
                jArr[i5] = jArr[i4] + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4];
                i4 = i5;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            return new RegularImmutableSortedMultiset(regularImmutableSortedSet, jArr, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(comparator, immutableSortedMultiset.mo4575entrySet().asList()) : immutableSortedMultiset;
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable) iterable);
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4627Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        if (comparator != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator);
            while (it.hasNext()) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4626Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) it.next(), 1);
            }
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4627Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        throw null;
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] comparableArr) {
        return copyOf(Ordering.natural(), Arrays.asList(comparableArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(AbstractC2766wx<E> abstractC2766wx) {
        return copyOfSortedEntries(abstractC2766wx.comparator(), C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2766wx.mo4575entrySet()));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> comparator, Collection<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection.size());
        long[] jArr = new long[collection.size() + 1];
        int i = 0;
        for (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 : collection) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getElement());
            int i2 = i + 1;
            jArr[i2] = jArr[i] + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getCount();
            i = i2;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), comparator), jArr, 0, collection.size());
    }

    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        return Ordering.natural().equals(comparator) ? (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET : new RegularImmutableSortedMultiset(comparator);
    }

    public static <E extends Comparable<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> naturalOrder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(Ordering.natural());
    }

    /* renamed from: of */
    public static <E> ImmutableSortedMultiset<E> m3852of() {
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedMultiset m3851of(Comparable comparable) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.m3838of(comparable), new long[]{0, 1}, 0, 1);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedMultiset m3850of(Comparable comparable, Comparable comparable2) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedMultiset m3849of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedMultiset m3848of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedMultiset m3847of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedMultiset m3846of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        int length = comparableArr.length + 6;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(length, "initialArraySize");
        ArrayList arrayList = new ArrayList(length);
        Collections.addAll(arrayList, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        Collections.addAll(arrayList, comparableArr);
        return copyOf(Ordering.natural(), arrayList);
    }

    public static <E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> orderedBy(Comparator<E> comparator) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(comparator);
    }

    public static <E extends Comparable<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> reverseOrder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(Ordering.natural().reverse());
    }

    @Override // me.tvspark.AbstractC2766wx, me.tvspark.AbstractC2689ux
    public final Comparator<? super E> comparator() {
        return mo4975elementSet().comparator();
    }

    /* renamed from: descendingMultiset */
    public ImmutableSortedMultiset<E> mo4619descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset == null) {
            immutableSortedMultiset = isEmpty() ? emptyMultiset(Ordering.from(comparator()).reverse()) : new DescendingImmutableSortedMultiset<>(this);
            this.descendingMultiset = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    @Override // com.google.common.collect.ImmutableMultiset, me.tvspark.AbstractC2090ex
    /* renamed from: elementSet  reason: collision with other method in class */
    public abstract ImmutableSortedSet<E> mo4975elementSet();

    /* renamed from: headMultiset */
    public abstract ImmutableSortedMultiset<E> mo4721headMultiset(E e, BoundType boundType);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2766wx
    /* renamed from: headMultiset  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ AbstractC2766wx mo4721headMultiset(Object obj, BoundType boundType) {
        return mo4721headMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // me.tvspark.AbstractC2766wx
    @Deprecated
    public final AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2766wx
    @Deprecated
    public final AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2766wx
    /* renamed from: subMultiset */
    public ImmutableSortedMultiset<E> mo4623subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator().compare(e, e2) <= 0, "Expected lowerBound <= upperBound but %s > %s", e, e2);
        return mo4722tailMultiset((ImmutableSortedMultiset<E>) e, boundType).mo4721headMultiset((ImmutableSortedMultiset<E>) e2, boundType2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2766wx
    /* renamed from: subMultiset  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ AbstractC2766wx mo4623subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return mo4623subMultiset((BoundType) obj, boundType, (BoundType) obj2, boundType2);
    }

    /* renamed from: tailMultiset */
    public abstract ImmutableSortedMultiset<E> mo4722tailMultiset(E e, BoundType boundType);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2766wx
    /* renamed from: tailMultiset  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ AbstractC2766wx mo4722tailMultiset(Object obj, BoundType boundType) {
        return mo4722tailMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
