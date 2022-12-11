package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import me.tvspark.AbstractC1998cw;
import me.tvspark.AbstractC2239iy;
import me.tvspark.AbstractC2876zw;
import me.tvspark.C2577rx;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements AbstractC1998cw<K, V> {
    public static final long serialVersionUID = 0;
    public transient ImmutableListMultimap<V, K> inverse;

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> extends ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> {
        public ImmutableListMultimap<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return ImmutableListMultimap.fromMapEntries(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.entrySet(), null);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, V v) {
            super.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>) k, (K) v);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
        public ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) {
            super.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>) obj, obj2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map.Entry entry) {
            super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry);
            return this;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, V... vArr) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>) k, (Iterable) Arrays.asList(vArr));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public ImmutableMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Iterable iterable) {
            super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>) obj, iterable);
            return this;
        }
    }

    public ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i) {
        super(immutableMap, i);
    }

    public static <K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> builder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable) iterable);
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(AbstractC2876zw<? extends K, ? extends V> abstractC2876zw) {
        if (abstractC2876zw.isEmpty()) {
            return m3906of();
        }
        if (abstractC2876zw instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) abstractC2876zw;
            if (!immutableListMultimap.isPartialView()) {
                return immutableListMultimap;
            }
        }
        return fromMapEntries(abstractC2876zw.mo4790asMap().entrySet(), null);
    }

    public static <K, V> ImmutableListMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return m3906of();
        }
        ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection.size());
        int i = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            Collection<? extends V> value = entry.getValue();
            ImmutableList copyOf = comparator == null ? ImmutableList.copyOf((Collection) value) : ImmutableList.sortedCopyOf(comparator, value);
            if (!copyOf.isEmpty()) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(key, copyOf);
                i = copyOf.size() + i;
            }
        }
        return new ImmutableListMultimap<>(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableListMultimap<V, K> invert() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = builder();
        AbstractC2239iy mo4735iterator = mo4768entries().mo4735iterator();
        while (mo4735iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) mo4735iterator.next();
            builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) entry.getValue(), entry.getKey());
        }
        ImmutableListMultimap<V, K> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.inverse = this;
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m3906of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m3905of(K k, V v) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = builder();
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k, (K) v);
        return builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m3904of(K k, V v, K k2, V v2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = builder();
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k, (K) v);
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k2, (K) v2);
        return builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m3903of(K k, V v, K k2, V v2, K k3, V v3) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = builder();
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k, (K) v);
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k2, (K) v2);
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k3, (K) v3);
        return builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m3902of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = builder();
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k, (K) v);
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k2, (K) v2);
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k3, (K) v3);
        builder.mo4604Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) k4, (K) v4);
        return builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m3901of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
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
                ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder2 = ImmutableList.builder();
                for (int i3 = 0; i3 < readInt2; i3++) {
                    builder2.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) objectInputStream.readObject());
                }
                builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readObject, builder2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
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

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2876zw) this, objectOutputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public /* bridge */ /* synthetic */ ImmutableCollection mo4793get(Object obj) {
        return mo4793get((ImmutableListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get  reason: collision with other method in class */
    public ImmutableList<V> mo4793get(K k) {
        ImmutableList<V> immutableList = (ImmutableList) this.map.mo4554get(k);
        return immutableList == null ? ImmutableList.m3919of() : immutableList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Collection mo4793get(Object obj) {
        return mo4793get((ImmutableListMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ List mo4793get(Object obj) {
        return mo4793get((ImmutableListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    /* renamed from: inverse */
    public ImmutableListMultimap<V, K> mo4598inverse() {
        ImmutableListMultimap<V, K> immutableListMultimap = this.inverse;
        if (immutableListMultimap == null) {
            ImmutableListMultimap<V, K> invert = invert();
            this.inverse = invert;
            return invert;
        }
        return immutableListMultimap;
    }

    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    @Deprecated
    /* renamed from: removeAll  reason: collision with other method in class */
    public ImmutableList<V> mo4778removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    @Deprecated
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ ImmutableCollection mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    @Deprecated
    /* renamed from: replaceValues  reason: collision with other method in class */
    public ImmutableList<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    @Deprecated
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    @Deprecated
    /* renamed from: replaceValues  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ List mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }
}
