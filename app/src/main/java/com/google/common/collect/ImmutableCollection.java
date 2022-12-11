package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import me.tvspark.AbstractC2239iy;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    public static final Object[] EMPTY_ARRAY = new Object[0];

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> {
        public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            if (i2 >= 0) {
                int i3 = i + (i >> 1) + 1;
                if (i3 < i2) {
                    i3 = Integer.highestOneBit(i2 - 1) << 1;
                }
                if (i3 >= 0) {
                    return i3;
                }
                return Integer.MAX_VALUE;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public abstract Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(E e);
    }

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> {
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        public Object[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "initialCapacity");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Object[i];
        }

        @Override // com.google.common.collect.ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(E e) {
            if (e != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1);
                Object[] objArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
                objArr[i] = e;
                return this;
            }
            throw null;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            Object[] objArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (objArr.length < i) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(objArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr.length, i));
            } else if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return;
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Object[]) objArr.clone();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        return isEmpty() ? ImmutableList.m3919of() : ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    public int copyIntoArray(Object[] objArr, int i) {
        AbstractC2239iy<E> mo4735iterator = mo4735iterator();
        while (mo4735iterator.hasNext()) {
            objArr[i] = mo4735iterator.next();
            i++;
        }
        return i;
    }

    public Object[] internalArray() {
        return null;
    }

    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* renamed from: iterator */
    public abstract AbstractC2239iy<E> mo4735iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        if (tArr != null) {
            int size = size();
            if (tArr.length < size) {
                Object[] internalArray = internalArray();
                if (internalArray != null) {
                    return (T[]) Arrays.copyOfRange(internalArray, internalArrayStart(), internalArrayEnd(), tArr.getClass());
                }
                tArr = (T[]) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) tArr, size);
            } else if (tArr.length > size) {
                tArr[size] = null;
            }
            copyIntoArray(tArr, 0);
            return tArr;
        }
        throw null;
    }

    public Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }
}
