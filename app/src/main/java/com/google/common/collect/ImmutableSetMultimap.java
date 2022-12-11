package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2239iy;
import me.tvspark.AbstractC2614sx;
import me.tvspark.AbstractC2876zw;
import me.tvspark.C2577rx;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements AbstractC2614sx<K, V> {
    public static final long serialVersionUID = 0;
    public final transient ImmutableSet<V> emptySet;
    public transient ImmutableSet<Map.Entry<K, V>> entries;
    public transient ImmutableSetMultimap<V, K> inverse;

    /* loaded from: classes3.dex */
    public static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        public final transient ImmutableSetMultimap<K, V> multimap;

        public EntrySet(ImmutableSetMultimap<K, V> immutableSetMultimap) {
            this.multimap = immutableSetMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.multimap.containsEntry(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        /* renamed from: iterator  reason: collision with other method in class */
        public AbstractC2239iy<Map.Entry<K, V>> mo4735iterator() {
            return this.multimap.mo4563entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.multimap.size();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final C2577rx<ImmutableSetMultimap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ImmutableSetMultimap.class, "emptySet");
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> extends ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> {
        public ImmutableSetMultimap<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return ImmutableSetMultimap.fromMapEntries(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.entrySet(), null);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, V v) {
            super.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>) k, (K) v);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Collection<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return CompactHashSet.create();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) {
            super.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>) obj, obj2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map.Entry entry) {
            super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Iterable iterable) {
            super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>) obj, iterable);
            return this;
        }
    }

    public ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i, Comparator<? super V> comparator) {
        super(immutableMap, i);
        this.emptySet = emptySet(comparator);
    }

    public static <K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> builder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable) iterable);
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(AbstractC2876zw<? extends K, ? extends V> abstractC2876zw) {
        return copyOf(abstractC2876zw, null);
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(AbstractC2876zw<? extends K, ? extends V> abstractC2876zw, Comparator<? super V> comparator) {
        if (abstractC2876zw != null) {
            if (abstractC2876zw.isEmpty() && comparator == null) {
                return m3870of();
            }
            if (abstractC2876zw instanceof ImmutableSetMultimap) {
                ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) abstractC2876zw;
                if (!immutableSetMultimap.isPartialView()) {
                    return immutableSetMultimap;
                }
            }
            return fromMapEntries(abstractC2876zw.mo4790asMap().entrySet(), comparator);
        }
        throw null;
    }

    public static <V> ImmutableSet<V> emptySet(Comparator<? super V> comparator) {
        return comparator == null ? ImmutableSet.m3877of() : ImmutableSortedSet.emptySet(comparator);
    }

    public static <K, V> ImmutableSetMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return m3870of();
        }
        ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection.size());
        int i = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            ImmutableSet valueSet = valueSet(comparator, entry.getValue());
            if (!valueSet.isEmpty()) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(key, valueSet);
                i = valueSet.size() + i;
            }
        }
        return new ImmutableSetMultimap<>(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), i, comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableSetMultimap<V, K> invert() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = builder();
        AbstractC2239iy mo4735iterator = mo4768entries().mo4735iterator();
        while (mo4735iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) mo4735iterator.next();
            builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) entry.getValue(), entry.getKey());
        }
        ImmutableSetMultimap<V, K> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.inverse = this;
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m3870of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m3869of(K k, V v) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = builder();
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k, (K) v);
        return builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m3868of(K k, V v, K k2, V v2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = builder();
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k, (K) v);
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k2, (K) v2);
        return builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m3867of(K k, V v, K k2, V v2, K k3, V v3) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = builder();
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k, (K) v);
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k2, (K) v2);
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k3, (K) v3);
        return builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m3866of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = builder();
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k, (K) v);
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k2, (K) v2);
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k3, (K) v3);
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k4, (K) v4);
        return builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m3865of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = builder();
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k, (K) v);
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k2, (K) v2);
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k3, (K) v3);
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k4, (K) v4);
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k5, (K) v5);
        return builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = ImmutableMap.builder();
            int i = 0;
            for (int i2 = 0; i2 < readInt; i2++) {
                Object readObject = objectInputStream.readObject();
                int readInt2 = objectInputStream.readInt();
                if (readInt2 <= 0) {
                    throw new InvalidObjectException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid value count ", readInt2));
                }
                ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww valuesBuilder = valuesBuilder(comparator);
                for (int i3 = 0; i3 < readInt2; i3++) {
                    valuesBuilder.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) objectInputStream.readObject());
                }
                ImmutableSet mo4631Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = valuesBuilder.mo4631Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (mo4631Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() != readInt2) {
                    throw new InvalidObjectException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Duplicate key-value pairs exist for key ", readObject));
                }
                builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readObject, mo4631Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                i += readInt2;
            }
            try {
                ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, builder.mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                C2577rx<ImmutableMultimap> c2577rx = ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (c2577rx == null) {
                    throw null;
                }
                try {
                    c2577rx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(this, Integer.valueOf(i));
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, emptySet(comparator));
                    return;
                } catch (IllegalAccessException e) {
                    throw new AssertionError(e);
                }
            } catch (IllegalArgumentException e2) {
                throw ((InvalidObjectException) new InvalidObjectException(e2.getMessage()).initCause(e2));
            }
        }
        throw new InvalidObjectException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid key count ", readInt));
    }

    public static <V> ImmutableSet<V> valueSet(Comparator<? super V> comparator, Collection<? extends V> collection) {
        return comparator == null ? ImmutableSet.copyOf((Collection) collection) : ImmutableSortedSet.copyOf((Comparator) comparator, (Collection) collection);
    }

    public static <V> ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<V> valuesBuilder(Comparator<? super V> comparator) {
        return comparator == null ? new ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>() : new ImmutableSortedSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(valueComparator());
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2876zw) this, objectOutputStream);
    }

    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: entries  reason: collision with other method in class */
    public ImmutableSet<Map.Entry<K, V>> mo4768entries() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entries;
        if (immutableSet == null) {
            EntrySet entrySet = new EntrySet(this);
            this.entries = entrySet;
            return entrySet;
        }
        return immutableSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public /* bridge */ /* synthetic */ ImmutableCollection mo4793get(Object obj) {
        return mo4793get((ImmutableSetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get  reason: collision with other method in class */
    public ImmutableSet<V> mo4793get(K k) {
        return (ImmutableSet) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableSet) this.map.mo4554get(k), this.emptySet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Collection mo4793get(Object obj) {
        return mo4793get((ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Set mo4793get(Object obj) {
        return mo4793get((ImmutableSetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    /* renamed from: inverse  reason: collision with other method in class */
    public ImmutableSetMultimap<V, K> mo4598inverse() {
        ImmutableSetMultimap<V, K> immutableSetMultimap = this.inverse;
        if (immutableSetMultimap == null) {
            ImmutableSetMultimap<V, K> invert = invert();
            this.inverse = invert;
            return invert;
        }
        return immutableSetMultimap;
    }

    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    @Deprecated
    /* renamed from: removeAll  reason: collision with other method in class */
    public ImmutableSet<V> mo4778removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    @Deprecated
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ ImmutableCollection mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    @Deprecated
    /* renamed from: replaceValues  reason: collision with other method in class */
    public ImmutableSet<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    @Deprecated
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    @Deprecated
    /* renamed from: replaceValues  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Set mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    public Comparator<? super V> valueComparator() {
        ImmutableSet<V> immutableSet = this.emptySet;
        if (immutableSet instanceof ImmutableSortedSet) {
            return ((ImmutableSortedSet) immutableSet).comparator();
        }
        return null;
    }
}
