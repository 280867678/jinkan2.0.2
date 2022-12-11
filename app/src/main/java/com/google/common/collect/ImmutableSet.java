package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import me.tvspark.AbstractC2239iy;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    public static final int CUTOFF = 751619276;
    public static final double DESIRED_LOAD_FACTOR = 0.7d;
    public static final int MAX_TABLE_SIZE = 1073741824;
    public transient ImmutableList<E> asList;

    /* loaded from: classes3.dex */
    public static class SerializedForm implements Serializable {
        public static final long serialVersionUID = 0;
        public final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    public static <E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> builder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();
    }

    public static <E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> builderWithExpectedSize(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "expectedSize");
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(i);
    }

    public static int chooseTableSize(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * 0.7d < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z = false;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, "collection too large");
        return 1073741824;
    }

    public static <E> ImmutableSet<E> construct(int i, Object... objArr) {
        if (i != 0) {
            if (i == 1) {
                return m3876of(objArr[0]);
            }
            int chooseTableSize = chooseTableSize(i);
            Object[] objArr2 = new Object[chooseTableSize];
            int i2 = chooseTableSize - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object obj = objArr[i5];
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, i5);
                int hashCode = obj.hashCode();
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hashCode);
                while (true) {
                    int i6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & i2;
                    Object obj2 = objArr2[i6];
                    if (obj2 == null) {
                        objArr[i4] = obj;
                        objArr2[i6] = obj;
                        i3 += hashCode;
                        i4++;
                        break;
                    } else if (obj2.equals(obj)) {
                        break;
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                    }
                }
            }
            Arrays.fill(objArr, i4, i, (Object) null);
            if (i4 == 1) {
                return new SingletonImmutableSet(objArr[0], i3);
            }
            if (chooseTableSize(i4) < chooseTableSize / 2) {
                return construct(i4, objArr);
            }
            if (shouldTrim(i4, objArr.length)) {
                objArr = Arrays.copyOf(objArr, i4);
            }
            return new RegularImmutableSet(objArr, i3, objArr2, i2, i4);
        }
        return m3877of();
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? copyOf((Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return m3877of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return m3876of((Object) next);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) next);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4630Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator) it);
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4631Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        return length != 0 ? length != 1 ? construct(eArr.length, (Object[]) eArr.clone()) : m3876of((Object) eArr[0]) : m3877of();
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m3877of() {
        return RegularImmutableSet.EMPTY;
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m3876of(E e) {
        return new SingletonImmutableSet(e);
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m3875of(E e, E e2) {
        return construct(2, e, e2);
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m3874of(E e, E e2, E e3) {
        return construct(3, e, e2, e3);
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m3873of(E e, E e2, E e3, E e4) {
        return construct(4, e, e2, e3, e4);
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m3872of(E e, E e2, E e3, E e4, E e5) {
        return construct(5, e, e2, e3, e4, e5);
    }

    @SafeVarargs
    /* renamed from: of */
    public static <E> ImmutableSet<E> m3871of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }

    public static boolean shouldTrim(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList == null) {
            ImmutableList<E> createAsList = createAsList();
            this.asList = createAsList;
            return createAsList;
        }
        return immutableList;
    }

    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) this);
    }

    public boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* renamed from: iterator  reason: collision with other method in class */
    public abstract AbstractC2239iy<E> mo4735iterator();

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> extends ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Object[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(4);
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            super(i);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Object[ImmutableSet.chooseTableSize(i)];
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.common.collect.ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public /* bridge */ /* synthetic */ ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            return mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.common.collect.ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(E e) {
            if (e != null) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    int chooseTableSize = ImmutableSet.chooseTableSize(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    Object[] objArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (chooseTableSize <= objArr.length) {
                        int length = objArr.length - 1;
                        int hashCode = e.hashCode();
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hashCode);
                        while (true) {
                            int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & length;
                            Object[] objArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            Object obj = objArr2[i];
                            if (obj == null) {
                                objArr2[i] = e;
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww += hashCode;
                                super.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) e);
                                break;
                            } else if (obj.equals(e)) {
                                break;
                            } else {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
                            }
                        }
                        return this;
                    }
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                super.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) e);
                return this;
            }
            throw null;
        }

        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public ImmutableSet<E> mo4631Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ImmutableSet<E> construct;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i != 0) {
                if (i == 1) {
                    return ImmutableSet.m3876of(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0]);
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || ImmutableSet.chooseTableSize(i) != this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
                    construct = ImmutableSet.construct(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = construct.size();
                } else {
                    Object[] copyOf = ImmutableSet.shouldTrim(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) ? Arrays.copyOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Object[] objArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    construct = new RegularImmutableSet<>(copyOf, i2, objArr, objArr.length - 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                return construct;
            }
            return ImmutableSet.m3877of();
        }

        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> mo4630Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator<? extends E> it) {
            if (it != null) {
                while (it.hasNext()) {
                    mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) it.next());
                }
                return this;
            }
            throw null;
        }
    }
}
