package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import me.tvspark.AbstractC2239iy;
import me.tvspark.C2274jw;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
    public final transient EnumMap<K, V> delegate;

    /* loaded from: classes3.dex */
    public static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        public static final long serialVersionUID = 0;
        public final EnumMap<K, V> delegate;

        public EnumSerializedForm(EnumMap<K, V> enumMap) {
            this.delegate = enumMap;
        }

        public Object readResolve() {
            return new ImmutableEnumMap(this.delegate);
        }
    }

    public ImmutableEnumMap(EnumMap<K, V> enumMap) {
        this.delegate = enumMap;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!enumMap.isEmpty());
    }

    public static <K extends Enum<K>, V> ImmutableMap<K, V> asImmutable(EnumMap<K, V> enumMap) {
        int size = enumMap.size();
        if (size != 0) {
            if (size != 1) {
                return new ImmutableEnumMap(enumMap);
            }
            Map.Entry entry = (Map.Entry) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable<Object>) enumMap.entrySet());
            return ImmutableMap.m3899of(entry.getKey(), entry.getValue());
        }
        return ImmutableMap.m3900of();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.delegate.containsKey(obj);
    }

    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    public AbstractC2239iy<Map.Entry<K, V>> entryIterator() {
        return new C2274jw(this.delegate.entrySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumMap) {
            obj = ((ImmutableEnumMap) obj).delegate;
        }
        return this.delegate.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    /* renamed from: get */
    public V mo4554get(Object obj) {
        return this.delegate.get(obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    public AbstractC2239iy<K> keyIterator() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator) this.delegate.keySet().iterator());
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new EnumSerializedForm(this.delegate);
    }
}
