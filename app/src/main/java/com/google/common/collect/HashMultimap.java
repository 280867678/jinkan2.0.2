package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2876zw;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class HashMultimap<K, V> extends HashMultimapGwtSerializationDependencies<K, V> {
    public static final int DEFAULT_VALUES_PER_KEY = 2;
    public static final long serialVersionUID = 0;
    public transient int expectedValuesPerKey;

    public HashMultimap() {
        this(12, 2);
    }

    public HashMultimap(int i, int i2) {
        super(CompactHashMap.createWithExpectedSize(i));
        this.expectedValuesPerKey = 2;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 >= 0);
        this.expectedValuesPerKey = i2;
    }

    public static <K, V> HashMultimap<K, V> create() {
        return new HashMultimap<>();
    }

    public static <K, V> HashMultimap<K, V> create(int i, int i2) {
        return new HashMultimap<>(i, i2);
    }

    public static <K, V> HashMultimap<K, V> create(AbstractC2876zw<? extends K, ? extends V> abstractC2876zw) {
        return new HashMultimap<>(abstractC2876zw);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.expectedValuesPerKey = 2;
        int readInt = objectInputStream.readInt();
        setMap(CompactHashMap.createWithExpectedSize(12));
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, objectInputStream, readInt);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2876zw) this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: asMap */
    public /* bridge */ /* synthetic */ Map mo4790asMap() {
        return super.mo4790asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: createCollection  reason: collision with other method in class */
    public Set<V> mo4791createCollection() {
        return CompactHashSet.createWithExpectedSize(this.expectedValuesPerKey);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: entries */
    public /* bridge */ /* synthetic */ Set mo4768entries() {
        return super.mo4768entries();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Set mo4793get(Object obj) {
        return super.mo4793get((HashMultimap<K, V>) obj);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: keySet */
    public /* bridge */ /* synthetic */ Set mo4794keySet() {
        return super.mo4794keySet();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: keys */
    public /* bridge */ /* synthetic */ AbstractC2090ex mo4566keys() {
        return super.mo4566keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean putAll(AbstractC2876zw abstractC2876zw) {
        return super.putAll(abstractC2876zw);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: removeAll */
    public /* bridge */ /* synthetic */ Set mo4778removeAll(Object obj) {
        return super.mo4778removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Set mo4779replaceValues(Object obj, Iterable iterable) {
        return super.mo4779replaceValues((HashMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // me.tvspark.AbstractC2309ku
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: values */
    public /* bridge */ /* synthetic */ Collection mo4653values() {
        return super.mo4653values();
    }

    public HashMultimap(AbstractC2876zw<? extends K, ? extends V> abstractC2876zw) {
        super(CompactHashMap.createWithExpectedSize(abstractC2876zw.mo4794keySet().size()));
        this.expectedValuesPerKey = 2;
        putAll(abstractC2876zw);
    }
}
