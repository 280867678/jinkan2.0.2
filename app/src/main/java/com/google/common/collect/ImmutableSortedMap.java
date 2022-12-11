package com.google.common.collect;

import androidx.core.app.Person;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import me.tvspark.AbstractC2239iy;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
    public static final long serialVersionUID = 0;
    public transient ImmutableSortedMap<K, V> descendingMap;
    public final transient RegularImmutableSortedSet<K> keySet;
    public final transient ImmutableList<V> valueList;
    public static final Comparator<Comparable> NATURAL_ORDER = Ordering.natural();
    public static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = new ImmutableSortedMap<>(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.m3919of());

    /* loaded from: classes3.dex */
    public static class SerializedForm extends ImmutableMap.SerializedForm {
        public static final long serialVersionUID = 0;
        public final Comparator<Object> comparator;

        public SerializedForm(ImmutableSortedMap<?, ?> immutableSortedMap) {
            super(immutableSortedMap);
            this.comparator = immutableSortedMap.comparator();
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public Object readResolve() {
            return createMap(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.comparator));
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> extends ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> {
        public final Comparator<? super K> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public transient Object[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public transient Object[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparator<? super K> comparator) {
            super(4);
            if (comparator != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = comparator;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Object[4];
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Object[4];
                return;
            }
            throw null;
        }

        @Override // com.google.common.collect.ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public ImmutableMap mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i != 0) {
                if (i == 1) {
                    return ImmutableSortedMap.m3858of(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0], this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0]);
                }
                Object[] copyOf = Arrays.copyOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
                Arrays.sort(copyOf, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                Object[] objArr = new Object[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
                for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i2++) {
                    if (i2 > 0) {
                        int i3 = i2 - 1;
                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.compare(copyOf[i3], copyOf[i2]) == 0) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("keys required to be distinct but compared as equal: ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(copyOf[i3]);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" and ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(copyOf[i2]);
                            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                        }
                    }
                    objArr[Arrays.binarySearch(copyOf, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2], this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)] = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
                }
                return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.asImmutableList(copyOf), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww), ImmutableList.asImmutableList(objArr));
            }
            return ImmutableSortedMap.emptyMap(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // com.google.common.collect.ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
            Object[] objArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i > objArr.length) {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr.length, i);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, obj2);
            Object[] objArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            objArr2[i2] = obj;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2] = obj2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map.Entry entry) {
            super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4532Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable iterable) {
            super.mo4532Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map map) {
            super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map);
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Comparator<Map.Entry<K, V>> {
        public final /* synthetic */ Comparator Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparator comparator) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = comparator;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.compare(((Map.Entry) obj).getKey(), ((Map.Entry) obj2).getKey());
        }
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList) {
        this(regularImmutableSortedSet, immutableList, null);
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList, ImmutableSortedMap<K, V> immutableSortedMap) {
        this.keySet = regularImmutableSortedSet;
        this.valueList = immutableList;
        this.descendingMap = immutableSortedMap;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return copyOf(iterable, (Ordering) NATURAL_ORDER);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable, Comparator<? super K> comparator) {
        if (comparator != null) {
            return fromEntries(comparator, false, iterable);
        }
        throw null;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return copyOfInternal(map, (Ordering) NATURAL_ORDER);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        boolean z = false;
        if (map instanceof SortedMap) {
            Comparator<? super K> comparator2 = ((SortedMap) map).comparator();
            if (comparator2 != null) {
                z = comparator.equals(comparator2);
            } else if (comparator == NATURAL_ORDER) {
                z = true;
            }
        }
        if (z && (map instanceof ImmutableSortedMap)) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) map;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        return fromEntries(comparator, z, map.entrySet());
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> sortedMap) {
        Comparator<? super K> comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        if (sortedMap instanceof ImmutableSortedMap) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) sortedMap;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        return fromEntries(comparator, true, sortedMap.entrySet());
    }

    public static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> comparator) {
        return Ordering.natural().equals(comparator) ? m3864of() : new ImmutableSortedMap<>(ImmutableSortedSet.emptySet(comparator), ImmutableList.m3919of());
    }

    public static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> comparator, boolean z, Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable) iterable, (Object[]) ImmutableMap.EMPTY_ENTRY_ARRAY);
        return fromEntries(comparator, z, entryArr, entryArr.length);
    }

    public static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> comparator, boolean z, Map.Entry<K, V>[] entryArr, int i) {
        if (i != 0) {
            if (i == 1) {
                return m3858of(comparator, entryArr[0].getKey(), entryArr[0].getValue());
            }
            Object[] objArr = new Object[i];
            Object[] objArr2 = new Object[i];
            if (z) {
                for (int i2 = 0; i2 < i; i2++) {
                    K key = entryArr[i2].getKey();
                    V value = entryArr[i2].getValue();
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(key, value);
                    objArr[i2] = key;
                    objArr2[i2] = value;
                }
            } else {
                Arrays.sort(entryArr, 0, i, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator));
                Object key2 = entryArr[0].getKey();
                objArr[0] = key2;
                objArr2[0] = entryArr[0].getValue();
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr[0], objArr2[0]);
                int i3 = 1;
                while (i3 < i) {
                    Object key3 = entryArr[i3].getKey();
                    V value2 = entryArr[i3].getValue();
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(key3, value2);
                    objArr[i3] = key3;
                    objArr2[i3] = value2;
                    ImmutableMap.checkNoConflict(comparator.compare(key2, key3) != 0, Person.KEY_KEY, entryArr[i3 - 1], entryArr[i3]);
                    i3++;
                    key2 = key3;
                }
            }
            return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.asImmutableList(objArr), comparator), ImmutableList.asImmutableList(objArr2));
        }
        return emptyMap(comparator);
    }

    private ImmutableSortedMap<K, V> getSubMap(int i, int i2) {
        return (i == 0 && i2 == size()) ? this : i == i2 ? emptyMap(comparator()) : new ImmutableSortedMap<>(this.keySet.getSubSet(i, i2), this.valueList.mo4539subList(i, i2));
    }

    public static <K extends Comparable<?>, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> naturalOrder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(Ordering.natural());
    }

    /* renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m3864of() {
        return (ImmutableSortedMap<K, V>) NATURAL_EMPTY_MAP;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    /* renamed from: of */
    public static ImmutableSortedMap m3863of(Comparable comparable, Object obj) {
        return m3858of(Ordering.natural(), comparable, obj);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    /* renamed from: of */
    public static ImmutableSortedMap m3862of(Comparable comparable, Object obj, Comparable comparable2, Object obj2) {
        return ofEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    /* renamed from: of */
    public static ImmutableSortedMap m3861of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3) {
        return ofEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    /* renamed from: of */
    public static ImmutableSortedMap m3860of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4) {
        return ofEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3), ImmutableMap.entryOf(comparable4, obj4));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    /* renamed from: of */
    public static ImmutableSortedMap m3859of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5) {
        return ofEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3), ImmutableMap.entryOf(comparable4, obj4), ImmutableMap.entryOf(comparable5, obj5));
    }

    /* renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m3858of(Comparator<? super K> comparator, K k, V v) {
        ImmutableList m3918of = ImmutableList.m3918of(k);
        if (comparator != null) {
            return new ImmutableSortedMap<>(new RegularImmutableSortedSet(m3918of, comparator), ImmutableList.m3918of(v));
        }
        throw null;
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> ofEntries(Map.Entry<K, V>... entryArr) {
        return fromEntries(Ordering.natural(), false, entryArr, entryArr.length);
    }

    public static <K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> orderedBy(Comparator<K> comparator) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(comparator);
    }

    public static <K extends Comparable<?>, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> reverseOrder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(Ordering.natural().reverse());
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k) {
        return tailMap((ImmutableSortedMap<K, V>) k, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        return (K) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ceilingEntry(k));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return mo4610keySet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return isEmpty() ? ImmutableSet.m3877of() : new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet
            @Override // com.google.common.collect.ImmutableSet
            public ImmutableList<Map.Entry<K, V>> createAsList() {
                return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet.1
                    @Override // java.util.List
                    public Map.Entry<K, V> get(int i) {
                        return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.keySet.asList().get(i), ImmutableSortedMap.this.valueList.get(i));
                    }

                    @Override // com.google.common.collect.ImmutableCollection
                    public boolean isPartialView() {
                        return true;
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                    public int size() {
                        return ImmutableSortedMap.this.size();
                    }
                };
            }

            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
            /* renamed from: iterator  reason: collision with other method in class */
            public AbstractC2239iy<Map.Entry<K, V>> mo4735iterator() {
                return asList().mo4735iterator();
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet
            public ImmutableMap<K, V> map() {
                return ImmutableSortedMap.this;
            }
        };
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: createValues */
    public ImmutableCollection<V> mo4528createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    /* renamed from: descendingKeySet */
    public ImmutableSortedSet<K> mo4605descendingKeySet() {
        return this.keySet.descendingSet();
    }

    @Override // java.util.NavigableMap
    /* renamed from: descendingMap */
    public ImmutableSortedMap<K, V> mo4606descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.descendingMap;
        return immutableSortedMap == null ? isEmpty() ? emptyMap(Ordering.from(comparator()).reverse()) : new ImmutableSortedMap<>((RegularImmutableSortedSet) this.keySet.descendingSet(), this.valueList.reverse(), this) : immutableSortedMap;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    /* renamed from: entrySet */
    public ImmutableSet<Map.Entry<K, V>> mo4607entrySet() {
        return super.mo4551entrySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return mo4607entrySet().asList().get(0);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return mo4610keySet().mo4707first();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k) {
        return headMap((ImmutableSortedMap<K, V>) k, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        return (K) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floorEntry(k));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    /* renamed from: get */
    public V mo4554get(Object obj) {
        int indexOf = this.keySet.indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        return this.valueList.get(indexOf);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> headMap(K k) {
        return headMap((ImmutableSortedMap<K, V>) k, false);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> headMap(K k, boolean z) {
        RegularImmutableSortedSet<K> regularImmutableSortedSet = this.keySet;
        if (k != null) {
            return getSubMap(0, regularImmutableSortedSet.headIndex(k, z));
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    /* renamed from: headMap  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ NavigableMap mo4608headMap(Object obj, boolean z) {
        return headMap((ImmutableSortedMap<K, V>) obj, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    /* renamed from: headMap  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ SortedMap mo4609headMap(Object obj) {
        return headMap((ImmutableSortedMap<K, V>) obj);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k) {
        return tailMap((ImmutableSortedMap<K, V>) k, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        return (K) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(higherEntry(k));
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return this.keySet.isPartialView() || this.valueList.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    /* renamed from: keySet  reason: collision with other method in class */
    public ImmutableSortedSet<K> mo4610keySet() {
        return this.keySet;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return mo4607entrySet().asList().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return mo4610keySet().mo4709last();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k) {
        return headMap((ImmutableSortedMap<K, V>) k, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        return (K) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lowerEntry(k));
    }

    @Override // java.util.NavigableMap
    /* renamed from: navigableKeySet */
    public ImmutableSortedSet<K> mo4611navigableKeySet() {
        return this.keySet;
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.valueList.size();
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    /* renamed from: subMap */
    public ImmutableSortedMap<K, V> mo4613subMap(K k, K k2) {
        return subMap((boolean) k, true, (boolean) k2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        if (k != 0) {
            if (k2 == 0) {
                throw null;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator().compare(k, k2) <= 0, "expected fromKey <= toKey but %s > %s", k, k2);
            return headMap((ImmutableSortedMap<K, V>) k2, z2).tailMap((ImmutableSortedMap<K, V>) k, z);
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    /* renamed from: subMap  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ NavigableMap mo4612subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return subMap((boolean) obj, z, (boolean) obj2, z2);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> tailMap(K k) {
        return tailMap((ImmutableSortedMap<K, V>) k, true);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> tailMap(K k, boolean z) {
        RegularImmutableSortedSet<K> regularImmutableSortedSet = this.keySet;
        if (k != null) {
            return getSubMap(regularImmutableSortedSet.tailIndex(k, z), size());
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    /* renamed from: tailMap  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ NavigableMap mo4614tailMap(Object obj, boolean z) {
        return tailMap((ImmutableSortedMap<K, V>) obj, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    /* renamed from: tailMap  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ SortedMap mo4615tailMap(Object obj) {
        return tailMap((ImmutableSortedMap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, me.tvspark.AbstractC2648tu
    /* renamed from: values */
    public ImmutableCollection<V> mo4672values() {
        return this.valueList;
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        if (comparator != null) {
            return copyOfInternal(map, comparator);
        }
        throw null;
    }
}
