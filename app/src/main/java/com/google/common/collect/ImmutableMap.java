package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import me.tvspark.AbstractC2239iy;
import me.tvspark.C2538qv;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    public static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    public transient ImmutableSet<Map.Entry<K, V>> entrySet;
    public transient ImmutableSet<K> keySet;
    public transient ImmutableSetMultimap<K, V> multimapView;
    public transient ImmutableCollection<V> values;

    /* loaded from: classes3.dex */
    public static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.1EntrySetImpl
                @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
                /* renamed from: iterator  reason: collision with other method in class */
                public AbstractC2239iy<Map.Entry<K, V>> mo4735iterator() {
                    return IteratorBasedImmutableMap.this.entryIterator();
                }

                @Override // com.google.common.collect.ImmutableMapEntrySet
                public ImmutableMap<K, V> map() {
                    return IteratorBasedImmutableMap.this;
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        /* renamed from: createValues */
        public ImmutableCollection<V> mo4528createValues() {
            return new ImmutableMapValues(this);
        }

        public abstract AbstractC2239iy<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        /* renamed from: entrySet */
        public /* bridge */ /* synthetic */ Set mo4607entrySet() {
            return super.mo4551entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        /* renamed from: keySet */
        public /* bridge */ /* synthetic */ Set mo4610keySet() {
            return super.mo4552keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map, me.tvspark.AbstractC2648tu
        /* renamed from: values */
        public /* bridge */ /* synthetic */ Collection mo4672values() {
            return super.values();
        }
    }

    /* loaded from: classes3.dex */
    public final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2239iy<Map.Entry<K, ImmutableSet<V>>> {
            public final /* synthetic */ Iterator Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MapViewOfValuesAsSingletonSets mapViewOfValuesAsSingletonSets, Iterator it) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                return new C2538qv(this, (Map.Entry) this.Wwwwwwwwwwwwwwwwwwwwwwww.next());
            }
        }

        public MapViewOfValuesAsSingletonSets() {
        }

        public /* synthetic */ MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(Object obj) {
            return ImmutableMap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return ImmutableMap.this.mo4552keySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public AbstractC2239iy<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, ImmutableMap.this.mo4551entrySet().mo4735iterator());
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        /* renamed from: get */
        public ImmutableSet<V> mo4554get(Object obj) {
            Object mo4554get = ImmutableMap.this.mo4554get(obj);
            if (mo4554get == null) {
                return null;
            }
            return ImmutableSet.m3876of(mo4554get);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isHashCodeFast() {
            return ImmutableMap.this.isHashCodeFast();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return ImmutableMap.this.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return ImmutableMap.this.size();
        }
    }

    /* loaded from: classes3.dex */
    public static class SerializedForm implements Serializable {
        public static final long serialVersionUID = 0;
        public final Object[] keys;
        public final Object[] values;

        public SerializedForm(ImmutableMap<?, ?> immutableMap) {
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            AbstractC2239iy<Map.Entry<?, ?>> mo4735iterator = immutableMap.mo4551entrySet().mo4735iterator();
            int i = 0;
            while (mo4735iterator.hasNext()) {
                Map.Entry<?, ?> next = mo4735iterator.next();
                this.keys[i] = next.getKey();
                this.values[i] = next.getValue();
                i++;
            }
        }

        public Object createMap(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Object, Object> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            int i = 0;
            while (true) {
                Object[] objArr = this.keys;
                if (i < objArr.length) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr[i], this.values[i]);
                    i++;
                } else {
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
        }

        public Object readResolve() {
            return createMap(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(this.keys.length));
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> {
        public Object[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Object[i * 2];
        }

        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> mo4532Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Collection) iterable).size() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            for (Map.Entry<? extends K, ? extends V> entry : iterable) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry);
            }
            return this;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, V v) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, v);
            Object[] objArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            objArr[i * 2] = k;
            objArr[(i * 2) + 1] = v;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            return this;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map.Entry<? extends K, ? extends V> entry) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry.getKey(), entry.getValue());
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map<? extends K, ? extends V> map) {
            return mo4532Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map.entrySet());
        }

        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public ImmutableMap<K, V> mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            return RegularImmutableMap.create(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            int i2 = i * 2;
            Object[] objArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 > objArr.length) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(objArr, ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr.length, i2));
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2239iy<K> {
        public final /* synthetic */ AbstractC2239iy Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ImmutableMap immutableMap, AbstractC2239iy abstractC2239iy) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2239iy;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) ((Map.Entry) this.Wwwwwwwwwwwwwwwwwwwwwwww.next()).getKey();
        }
    }

    public static <K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> builder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(4);
    }

    public static <K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> builderWithExpectedSize(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "expectedSize");
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(i);
    }

    public static void checkNoConflict(boolean z, String str, Map.Entry<?, ?> entry, Map.Entry<?, ?> entry2) {
        if (z) {
            return;
        }
        throw conflictException(str, entry, entry2);
    }

    public static IllegalArgumentException conflictException(String str, Object obj, Object obj2) {
        return new IllegalArgumentException("Multiple entries with same " + str + ": " + obj + " and " + obj2);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4532Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable);
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        }
        return copyOf(map.entrySet());
    }

    public static <K, V> Map.Entry<K, V> entryOf(K k, V v) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, v);
        return new AbstractMap.SimpleImmutableEntry(k, v);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3900of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3899of(K k, V v) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, v);
        return RegularImmutableMap.create(1, new Object[]{k, v});
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3898of(K k, V v, K k2, V v2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, v);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k2, v2);
        return RegularImmutableMap.create(2, new Object[]{k, v, k2, v2});
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3897of(K k, V v, K k2, V v2, K k3, V v3) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, v);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k2, v2);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k3, v3);
        return RegularImmutableMap.create(3, new Object[]{k, v, k2, v2, k3, v3});
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3896of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, v);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k2, v2);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k3, v3);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k4, v4);
        return RegularImmutableMap.create(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m3895of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, v);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k2, v2);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k3, v3);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k4, v4);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k5, v5);
        return RegularImmutableMap.create(5, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5});
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.m3870of();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.multimapView;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new MapViewOfValuesAsSingletonSets(this, null), size(), null);
        this.multimapView = immutableSetMultimap2;
        return immutableSetMultimap2;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return mo4554get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    public abstract ImmutableSet<K> createKeySet();

    /* renamed from: createValues */
    public abstract ImmutableCollection<V> mo4528createValues();

    @Override // java.util.Map
    /* renamed from: entrySet */
    public ImmutableSet<Map.Entry<K, V>> mo4551entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet == null) {
            ImmutableSet<Map.Entry<K, V>> createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }
        return immutableSet;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, obj);
    }

    @Override // java.util.Map
    /* renamed from: get */
    public abstract V mo4554get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v) {
        V mo4554get = mo4554get(obj);
        return mo4554get != null ? mo4554get : v;
    }

    @Override // java.util.Map
    public int hashCode() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) mo4551entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isHashCodeFast() {
        return false;
    }

    public abstract boolean isPartialView();

    public AbstractC2239iy<K> keyIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, mo4551entrySet().mo4735iterator());
    }

    @Override // java.util.Map
    /* renamed from: keySet */
    public ImmutableSet<K> mo4552keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet == null) {
            ImmutableSet<K> createKeySet = createKeySet();
            this.keySet = createKeySet;
            return createKeySet;
        }
        return immutableSet;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection == null) {
            ImmutableCollection<V> mo4528createValues = mo4528createValues();
            this.values = mo4528createValues;
            return mo4528createValues;
        }
        return immutableCollection;
    }

    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
