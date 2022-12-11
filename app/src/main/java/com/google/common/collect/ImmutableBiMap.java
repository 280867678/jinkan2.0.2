package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.util.Collection;
import java.util.Map;
import me.tvspark.AbstractC2648tu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements AbstractC2648tu<K, V> {

    /* loaded from: classes3.dex */
    public static class SerializedForm extends ImmutableMap.SerializedForm {
        public static final long serialVersionUID = 0;

        public SerializedForm(ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public Object readResolve() {
            return createMap(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> extends ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(4);
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            super(i);
        }

        @Override // com.google.common.collect.ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> mo4532Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.mo4532Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public ImmutableBiMap<K, V> mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                return ImmutableBiMap.m3927of();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            return new RegularImmutableBiMap(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) {
            super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, obj2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map.Entry entry) {
            super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
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

    public static <K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> builder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();
    }

    public static <K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> builderWithExpectedSize(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "expectedSize");
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(i);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4532Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable) iterable);
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3927of() {
        return RegularImmutableBiMap.EMPTY;
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3926of(K k, V v) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, v);
        return new RegularImmutableBiMap(new Object[]{k, v}, 1);
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3925of(K k, V v, K k2, V v2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, v);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k2, v2);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2}, 2);
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3924of(K k, V v, K k2, V v2, K k3, V v3) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, v);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k2, v2);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k3, v3);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3}, 3);
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3923of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, v);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k2, v2);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k3, v3);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k4, v4);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3, k4, v4}, 4);
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m3922of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, v);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k2, v2);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k3, v3);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k4, v4);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k5, v5);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5}, 5);
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: createValues  reason: collision with other method in class */
    public final ImmutableSet<V> mo4528createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // me.tvspark.AbstractC2648tu
    @Deprecated
    public V forcePut(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2648tu
    /* renamed from: inverse */
    public abstract ImmutableBiMap<V, K> mo4713inverse();

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, me.tvspark.AbstractC2648tu
    /* renamed from: values  reason: collision with other method in class */
    public ImmutableSet<V> mo4672values() {
        return mo4713inverse().mo4552keySet();
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
