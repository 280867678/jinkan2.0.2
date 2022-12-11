package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2648tu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends AbstractBiMap<K, V> {
    public static final long serialVersionUID = 0;
    public transient Class<K> keyType;
    public transient Class<V> valueType;

    public EnumBiMap(Class<K> cls, Class<V> cls2) {
        super(new EnumMap(cls), new EnumMap(cls2));
        this.keyType = cls;
        this.valueType = cls2;
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Class<K> cls, Class<V> cls2) {
        return new EnumBiMap<>(cls, cls2);
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Map<K, V> map) {
        EnumBiMap<K, V> create = create(inferKeyType(map), inferValueType(map));
        create.putAll(map);
        return create;
    }

    public static <K extends Enum<K>> Class<K> inferKeyType(Map<K, ?> map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap) map).keyType();
        }
        if (map instanceof EnumHashBiMap) {
            return ((EnumHashBiMap) map).keyType();
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!map.isEmpty());
        return map.keySet().iterator().next().getDeclaringClass();
    }

    public static <V extends Enum<V>> Class<V> inferValueType(Map<?, V> map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap) map).valueType;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!map.isEmpty());
        return map.values().iterator().next().getDeclaringClass();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyType = (Class) objectInputStream.readObject();
        this.valueType = (Class) objectInputStream.readObject();
        setDelegates(new EnumMap(this.keyType), new EnumMap(this.valueType));
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map) this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyType);
        objectOutputStream.writeObject(this.valueType);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map) this, objectOutputStream);
    }

    public K checkKey(K k) {
        if (k != null) {
            return k;
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap
    public /* bridge */ /* synthetic */ Object checkKey(Object obj) {
        return checkKey((EnumBiMap<K, V>) ((Enum) obj));
    }

    public V checkValue(V v) {
        if (v != null) {
            return v;
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap
    public /* bridge */ /* synthetic */ Object checkValue(Object obj) {
        return checkValue((EnumBiMap<K, V>) ((Enum) obj));
    }

    @Override // com.google.common.collect.AbstractBiMap, me.tvspark.AbstractC2162gv, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.AbstractBiMap, me.tvspark.AbstractC2162gv, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractBiMap, me.tvspark.AbstractC2162gv, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractBiMap, me.tvspark.AbstractC2648tu
    /* renamed from: inverse */
    public /* bridge */ /* synthetic */ AbstractC2648tu mo4713inverse() {
        return super.mo4713inverse();
    }

    @Override // com.google.common.collect.AbstractBiMap, me.tvspark.AbstractC2162gv, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public Class<K> keyType() {
        return this.keyType;
    }

    @Override // com.google.common.collect.AbstractBiMap, me.tvspark.AbstractC2162gv, java.util.Map
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    public Class<V> valueType() {
        return this.valueType;
    }

    @Override // com.google.common.collect.AbstractBiMap, me.tvspark.AbstractC2162gv, java.util.Map, me.tvspark.AbstractC2648tu
    /* renamed from: values */
    public /* bridge */ /* synthetic */ Set mo4672values() {
        return super.mo4672values();
    }
}
