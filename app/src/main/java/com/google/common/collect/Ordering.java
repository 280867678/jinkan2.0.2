package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.AbstractC2271jt;
import me.tvspark.C2763wu;
import me.tvspark.C2767wy;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public abstract class Ordering<T> implements Comparator<T> {
    public static final int LEFT_IS_GREATER = 1;
    public static final int RIGHT_IS_GREATER = -1;

    /* loaded from: classes3.dex */
    public static class IncomparableValueException extends ClassCastException {
        public static final long serialVersionUID = 0;
        public final Object value;

        public IncomparableValueException(Object obj) {
            super(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot compare value: ", obj));
            this.value = obj;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final Ordering<Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Ordering<Object> {
        public final ConcurrentMap<Object, Integer> Wwwwwwwwwwwwwwwwwwwwwww;
        public final AtomicInteger Wwwwwwwwwwwwwwwwwwwwwwww = new AtomicInteger(0);

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            MapMaker mapMaker = new MapMaker();
            mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MapMakerInternalMap.Strength.WEAK);
            this.Wwwwwwwwwwwwwwwwwwwwwww = mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public final Integer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            Integer num = this.Wwwwwwwwwwwwwwwwwwwwwww.get(obj);
            if (num == null) {
                Integer valueOf = Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwww.getAndIncrement());
                Integer putIfAbsent = this.Wwwwwwwwwwwwwwwwwwwwwww.putIfAbsent(obj, valueOf);
                return putIfAbsent != null ? putIfAbsent : valueOf;
            }
            return num;
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int identityHashCode = System.identityHashCode(obj);
            int identityHashCode2 = System.identityHashCode(obj2);
            if (identityHashCode != identityHashCode2) {
                return identityHashCode < identityHashCode2 ? -1 : 1;
            }
            int compareTo = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj).compareTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj2));
            if (compareTo == 0) {
                throw new AssertionError();
            }
            return compareTo;
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }
    }

    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    public static Ordering<Object> arbitrary() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> iterable) {
        return new CompoundOrdering(iterable);
    }

    public static <T> Ordering<T> explicit(T t, T... tArr) {
        return explicit(new Lists$OnePlusArrayList(t, tArr));
    }

    public static <T> Ordering<T> explicit(List<T> list) {
        return new ExplicitOrdering(list);
    }

    @Deprecated
    public static <T> Ordering<T> from(Ordering<T> ordering) {
        if (ordering != null) {
            return ordering;
        }
        throw null;
    }

    public static <T> Ordering<T> from(Comparator<T> comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.INSTANCE;
    }

    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    @Deprecated
    public int binarySearch(List<? extends T> list, T t) {
        return Collections.binarySearch(list, t, this);
    }

    @Override // java.util.Comparator
    public abstract int compare(T t, T t2);

    public <U extends T> Ordering<U> compound(Comparator<? super U> comparator) {
        if (comparator != null) {
            return new CompoundOrdering(this, comparator);
        }
        throw null;
    }

    public <E extends T> List<E> greatestOf(Iterable<E> iterable, int i) {
        return reverse().leastOf(iterable, i);
    }

    public <E extends T> List<E> greatestOf(Iterator<E> it, int i) {
        return reverse().leastOf(it, i);
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.sortedCopyOf(this, iterable);
    }

    public boolean isOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (compare(next, next2) > 0) {
                    return false;
                }
                next = next2;
            }
            return true;
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (compare(next, next2) >= 0) {
                    return false;
                }
                next = next2;
            }
            return true;
        }
        return true;
    }

    public <E extends T> List<E> leastOf(Iterable<E> iterable, int i) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= i * 2) {
                Object[] array = collection.toArray();
                Arrays.sort(array, this);
                if (array.length > i) {
                    array = Arrays.copyOf(array, i);
                }
                return Collections.unmodifiableList(Arrays.asList(array));
            }
        }
        return leastOf(iterable.iterator(), i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.google.common.collect.Ordering<T>, java.lang.Object, java.util.Comparator] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v22 */
    public <E extends T> List<E> leastOf(Iterator<E> it, int i) {
        int i2;
        int numberOfLeadingZeros;
        int i3 = i;
        if (it != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, "k");
            if (i3 == 0 || !it.hasNext()) {
                return Collections.emptyList();
            }
            if (i3 >= 1073741823) {
                ArrayList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it);
                Collections.sort(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.size() > i3) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.subList(i3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.size()).clear();
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.trimToSize();
                return Collections.unmodifiableList(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, "comparator");
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3 >= 0, "k must be nonnegative, was %s", i3);
            ?? r5 = new Object[i3 * 2];
            E e = null;
            int i4 = 0;
            while (it.hasNext()) {
                E next = it.next();
                if (i3 != 0) {
                    if (i4 == 0) {
                        r5[0] = next;
                        e = next;
                        i4 = 1;
                    } else {
                        if (i4 < i3) {
                            i2 = i4 + 1;
                            r5[i4] = next;
                            if (compare(next, e) > 0) {
                                e = next;
                            }
                        } else if (compare(next, e) < 0) {
                            i2 = i4 + 1;
                            r5[i4] = next;
                            int i5 = i3 * 2;
                            if (i2 == i5) {
                                int i6 = i5 - 1;
                                int i7 = i6 + 0;
                                RoundingMode roundingMode = RoundingMode.CEILING;
                                if (i7 <= 0) {
                                    throw new IllegalArgumentException("x (" + i7 + ") must be > 0");
                                }
                                switch (C2767wy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[roundingMode.ordinal()]) {
                                    case 1:
                                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((i7 > 0) & (((i7 + (-1)) & i7) == 0));
                                    case 2:
                                    case 3:
                                        numberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i7);
                                        break;
                                    case 4:
                                    case 5:
                                        numberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(i7 - 1);
                                        break;
                                    case 6:
                                    case 7:
                                    case 8:
                                        int numberOfLeadingZeros2 = Integer.numberOfLeadingZeros(i7);
                                        numberOfLeadingZeros = (31 - numberOfLeadingZeros2) + ((~(~(((-1257966797) >>> numberOfLeadingZeros2) - i7))) >>> 31);
                                        break;
                                    default:
                                        throw new AssertionError();
                                }
                                int i8 = numberOfLeadingZeros * 3;
                                int i9 = 0;
                                int i10 = 0;
                                int i11 = 0;
                                while (true) {
                                    if (i9 < i6) {
                                        int i12 = ((i9 + i6) + 1) >>> 1;
                                        ?? r12 = r5[i12];
                                        r5[i12] = r5[i6];
                                        int i13 = i9;
                                        int i14 = i13;
                                        while (i13 < i6) {
                                            if (compare(r5[i13], r12) < 0) {
                                                ?? r14 = r5[i14];
                                                r5[i14] = r5[i13];
                                                r5[i13] = r14;
                                                i14++;
                                            }
                                            i13++;
                                        }
                                        r5[i6] = r5[i14];
                                        r5[i14] = r12;
                                        if (i14 > i3) {
                                            i6 = i14 - 1;
                                        } else if (i14 < i3) {
                                            i9 = Math.max(i14, i9 + 1);
                                            i11 = i14;
                                        }
                                        i10++;
                                        if (i10 >= i8) {
                                            Arrays.sort(r5, i9, i6, this);
                                        }
                                    }
                                }
                                ?? r6 = r5[i11];
                                e = r6;
                                for (int i15 = i11 + 1; i15 < i3; i15++) {
                                    if (compare(r5[i15], e) > 0) {
                                        e = (E) r5[i15];
                                    }
                                }
                                i4 = i3;
                            }
                        } else {
                            continue;
                        }
                        i4 = i2;
                    }
                }
            }
            Arrays.sort(r5, 0, i4, this);
            if (i4 > i3) {
                Arrays.fill((Object[]) r5, i3, r5.length, (Object) null);
                ?? r2 = r5[i3 - 1];
            } else {
                i3 = i4;
            }
            return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf((Object[]) r5, i3)));
        }
        throw null;
    }

    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    /* renamed from: max */
    public <E extends T> E mo4728max(Iterable<E> iterable) {
        return (E) mo4729max(iterable.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E max(E e, E e2) {
        return compare(e, e2) >= 0 ? e : e2;
    }

    public <E extends T> E max(E e, E e2, E e3, E... eArr) {
        E e4 = (E) max(max(e, e2), e3);
        for (E e5 : eArr) {
            e4 = (E) max(e4, e5);
        }
        return e4;
    }

    /* renamed from: max */
    public <E extends T> E mo4729max(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) max(next, it.next());
        }
        return next;
    }

    /* renamed from: min */
    public <E extends T> E mo4730min(Iterable<E> iterable) {
        return (E) mo4731min(iterable.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E min(E e, E e2) {
        return compare(e, e2) <= 0 ? e : e2;
    }

    public <E extends T> E min(E e, E e2, E e3, E... eArr) {
        E e4 = (E) min(min(e, e2), e3);
        for (E e5 : eArr) {
            e4 = (E) min(e4, e5);
        }
        return e4;
    }

    /* renamed from: min */
    public <E extends T> E mo4731min(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) min(next, it.next());
        }
        return next;
    }

    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    public <T2 extends T> Ordering<Map.Entry<T2, ?>> onKeys() {
        return (Ordering<Map.Entry<T2, ?>>) onResultOf(Maps$EntryFunction.KEY);
    }

    public <F> Ordering<F> onResultOf(AbstractC2271jt<F, ? extends T> abstractC2271jt) {
        return new ByFunctionOrdering(abstractC2271jt, this);
    }

    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
        Object[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable<?>) iterable);
        Arrays.sort(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this);
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.asList(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }
}
