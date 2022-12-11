package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import me.tvspark.AbstractC2239iy;
import me.tvspark.AbstractC2689ux;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, AbstractC2689ux<E> {
    public final transient Comparator<? super E> comparator;
    public transient ImmutableSortedSet<E> descendingSet;

    /* loaded from: classes3.dex */
    public static class SerializedForm<E> implements Serializable {
        public static final long serialVersionUID = 0;
        public final Comparator<? super E> comparator;
        public final Object[] elements;

        public SerializedForm(Comparator<? super E> comparator, Object[] objArr) {
            this.comparator = comparator;
            this.elements = objArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.comparator);
            Object[] objArr = this.elements;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                for (Object obj : objArr) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj);
                }
            } else {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + objArr.length);
                System.arraycopy(objArr, 0, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, objArr.length);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += objArr.length;
            }
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4631Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> extends ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> {
        public final Comparator<? super E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparator<? super E> comparator) {
            if (comparator != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = comparator;
                return;
            }
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.common.collect.ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.common.collect.ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            super.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) obj);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> mo4630Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator<? extends E> it) {
            super.mo4630Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator) it);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
        public ImmutableSortedSet<E> mo4631Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ImmutableSortedSet<E> construct = ImmutableSortedSet.construct(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = construct.size();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            return construct;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.common.collect.ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.common.collect.ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
        public ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            super.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) obj);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4630Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator it) {
            super.mo4630Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it);
            return this;
        }
    }

    public ImmutableSortedSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> ImmutableSortedSet<E> construct(Comparator<? super E> comparator, int i, E... eArr) {
        if (i == 0) {
            return emptySet(comparator);
        }
        for (int i2 = 0; i2 < i; i2++) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) eArr[i2], i2);
        }
        Arrays.sort(eArr, 0, i, comparator);
        int i3 = 1;
        for (int i4 = 1; i4 < i; i4++) {
            Object obj = (Object) eArr[i4];
            if (comparator.compare(obj, (Object) eArr[i3 - 1]) != 0) {
                eArr[i3] = obj;
                i3++;
            }
        }
        Arrays.fill(eArr, i3, i, (Object) null);
        if (i3 < eArr.length / 2) {
            eArr = (E[]) Arrays.copyOf(eArr, i3);
        }
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(eArr, i3), comparator);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> collection) {
        return copyOf((Comparator) Ordering.natural(), (Collection) collection);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (comparator != null) {
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Comparator<?>) comparator, (Iterable<?>) iterable) && (iterable instanceof ImmutableSortedSet)) {
                ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
                if (!immutableSortedSet.isPartialView()) {
                    return immutableSortedSet;
                }
            }
            Object[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable<?>) iterable);
            return construct(comparator, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        throw null;
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return copyOf((Comparator) comparator, (Iterable) collection);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4630Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator) it);
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4631Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet copyOf(Comparable[] comparableArr) {
        return construct(Ordering.natural(), comparableArr.length, (Object[]) comparableArr.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        if (comparator == null) {
            comparator = Ordering.natural();
        }
        ImmutableList copyOf = ImmutableList.copyOf((Collection) sortedSet);
        return copyOf.isEmpty() ? emptySet(comparator) : new RegularImmutableSortedSet(copyOf, comparator);
    }

    public static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> comparator) {
        return Ordering.natural().equals(comparator) ? (RegularImmutableSortedSet<E>) RegularImmutableSortedSet.NATURAL_EMPTY_SET : new RegularImmutableSortedSet<>(ImmutableList.m3919of(), comparator);
    }

    public static <E extends Comparable<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> naturalOrder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(Ordering.natural());
    }

    /* renamed from: of */
    public static <E> ImmutableSortedSet<E> m3839of() {
        return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m3838of(Comparable comparable) {
        return new RegularImmutableSortedSet(ImmutableList.m3918of(comparable), Ordering.natural());
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m3837of(Comparable comparable, Comparable comparable2) {
        return construct(Ordering.natural(), 2, comparable, comparable2);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m3836of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return construct(Ordering.natural(), 3, comparable, comparable2, comparable3);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m3835of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return construct(Ordering.natural(), 4, comparable, comparable2, comparable3, comparable4);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m3834of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return construct(Ordering.natural(), 5, comparable, comparable2, comparable3, comparable4, comparable5);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    /* renamed from: of */
    public static ImmutableSortedSet m3833of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        int length = comparableArr.length + 6;
        Comparable[] comparableArr2 = new Comparable[length];
        comparableArr2[0] = comparable;
        comparableArr2[1] = comparable2;
        comparableArr2[2] = comparable3;
        comparableArr2[3] = comparable4;
        comparableArr2[4] = comparable5;
        comparableArr2[5] = comparable6;
        System.arraycopy(comparableArr, 0, comparableArr2, 6, comparableArr.length);
        return construct(Ordering.natural(), length, comparableArr2);
    }

    public static <E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> orderedBy(Comparator<E> comparator) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(comparator);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> reverseOrder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(Collections.reverseOrder());
    }

    public static int unsafeCompare(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    public E ceiling(E e) {
        return (E) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<? extends Object>) mo4505tailSet((ImmutableSortedSet<E>) e, true).iterator(), (Object) null);
    }

    @Override // java.util.SortedSet, me.tvspark.AbstractC2689ux
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public abstract ImmutableSortedSet<E> createDescendingSet();

    @Override // java.util.NavigableSet
    /* renamed from: descendingIterator */
    public abstract AbstractC2239iy<E> mo4723descendingIterator();

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet == null) {
            ImmutableSortedSet<E> createDescendingSet = createDescendingSet();
            this.descendingSet = createDescendingSet;
            createDescendingSet.descendingSet = this;
            return createDescendingSet;
        }
        return immutableSortedSet;
    }

    /* renamed from: first */
    public E mo4707first() {
        return mo4735iterator().next();
    }

    public E floor(E e) {
        return (E) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<? extends Object>) mo4501headSet((ImmutableSortedSet<E>) e, true).mo4723descendingIterator(), (Object) null);
    }

    /* renamed from: headSet */
    public ImmutableSortedSet<E> mo4502headSet(E e) {
        return mo4501headSet((ImmutableSortedSet<E>) e, false);
    }

    /* renamed from: headSet */
    public ImmutableSortedSet<E> mo4501headSet(E e, boolean z) {
        if (e != null) {
            return headSetImpl(e, z);
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        return mo4501headSet((ImmutableSortedSet<E>) obj, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return mo4502headSet((ImmutableSortedSet<E>) obj);
    }

    public abstract ImmutableSortedSet<E> headSetImpl(E e, boolean z);

    public E higher(E e) {
        return (E) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<? extends Object>) mo4505tailSet((ImmutableSortedSet<E>) e, false).iterator(), (Object) null);
    }

    public abstract int indexOf(Object obj);

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* renamed from: iterator  reason: collision with other method in class */
    public abstract AbstractC2239iy<E> mo4735iterator();

    /* renamed from: last */
    public E mo4709last() {
        return mo4723descendingIterator().next();
    }

    public E lower(E e) {
        return (E) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<? extends Object>) mo4501headSet((ImmutableSortedSet<E>) e, false).mo4723descendingIterator(), (Object) null);
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> subSet(E e, E e2) {
        return mo4503subSet((boolean) e, true, (boolean) e2, false);
    }

    /* renamed from: subSet */
    public ImmutableSortedSet<E> mo4503subSet(E e, boolean z, E e2, boolean z2) {
        if (e != null) {
            if (e2 == null) {
                throw null;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.comparator.compare(e, e2) <= 0);
            return subSetImpl(e, z, e2, z2);
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return mo4503subSet((boolean) obj, z, (boolean) obj2, z2);
    }

    public abstract ImmutableSortedSet<E> subSetImpl(E e, boolean z, E e2, boolean z2);

    /* renamed from: tailSet */
    public ImmutableSortedSet<E> mo4506tailSet(E e) {
        return mo4505tailSet((ImmutableSortedSet<E>) e, true);
    }

    /* renamed from: tailSet */
    public ImmutableSortedSet<E> mo4505tailSet(E e, boolean z) {
        if (e != null) {
            return tailSetImpl(e, z);
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        return mo4505tailSet((ImmutableSortedSet<E>) obj, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return mo4506tailSet((ImmutableSortedSet<E>) obj);
    }

    public abstract ImmutableSortedSet<E> tailSetImpl(E e, boolean z);

    public int unsafeCompare(Object obj, Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }
}
