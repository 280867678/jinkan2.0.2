package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2648tu;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class EnumHashBiMap<K extends Enum<K>, V> extends AbstractBiMap<K, V> {
    public static final long serialVersionUID = 0;
    public transient Class<K> keyType;

    public EnumHashBiMap(Class<K> cls) {
        super(new EnumMap(cls), new HashMap(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls.getEnumConstants().length)));
        this.keyType = cls;
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> cls) {
        return new EnumHashBiMap<>(cls);
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> map) {
        EnumHashBiMap<K, V> create = create(EnumBiMap.inferKeyType(map));
        create.putAll(map);
        return create;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyType = (Class) objectInputStream.readObject();
        setDelegates(new EnumMap(this.keyType), new HashMap((this.keyType.getEnumConstants().length * 3) / 2));
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map) this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyType);
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
        return checkKey((EnumHashBiMap<K, V>) ((Enum) obj));
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

    public V forcePut(K k, V v) {
        return (V) super.forcePut((EnumHashBiMap<K, V>) k, (K) v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, me.tvspark.AbstractC2648tu
    public /* bridge */ /* synthetic */ Object forcePut(Object obj, Object obj2) {
        return forcePut((EnumHashBiMap<K, V>) ((Enum) obj), (Enum) obj2);
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

    public V put(K k, V v) {
        return (V) super.put((EnumHashBiMap<K, V>) k, (K) v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, me.tvspark.AbstractC2162gv, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((EnumHashBiMap<K, V>) ((Enum) obj), (Enum) obj2);
    }

    @Override // com.google.common.collect.AbstractBiMap, me.tvspark.AbstractC2162gv, java.util.Map
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    @Override // com.google.common.collect.AbstractBiMap, me.tvspark.AbstractC2162gv, java.util.Map
    public /* bridge */ /* synthetic */ Object remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.common.collect.AbstractBiMap, me.tvspark.AbstractC2162gv, java.util.Map, me.tvspark.AbstractC2648tu
    /* renamed from: values */
    public /* bridge */ /* synthetic */ Set mo4672values() {
        return super.mo4672values();
    }
}
