package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2128fy;
import me.tvspark.AbstractC2684ut;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class HashBasedTable<R, C, V> extends StandardTable<R, C, V> {
    public static final long serialVersionUID = 0;

    /* loaded from: classes3.dex */
    public static class Factory<C, V> implements AbstractC2684ut<Map<C, V>>, Serializable {
        public static final long serialVersionUID = 0;
        public final int expectedSize;

        public Factory(int i) {
            this.expectedSize = i;
        }

        @Override // me.tvspark.AbstractC2684ut
        /* renamed from: get  reason: collision with other method in class */
        public Map<C, V> mo4804get() {
            return new LinkedHashMap(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.expectedSize));
        }
    }

    public HashBasedTable(Map<R, Map<C, V>> map, Factory<C, V> factory) {
        super(map, factory);
    }

    public static <R, C, V> HashBasedTable<R, C, V> create() {
        return new HashBasedTable<>(new LinkedHashMap(), new Factory(0));
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, "expectedCellsPerRow");
        return new HashBasedTable<>(new LinkedHashMap(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)), new Factory(i2));
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(AbstractC2128fy<? extends R, ? extends C, ? extends V> abstractC2128fy) {
        HashBasedTable<R, C, V> create = create();
        create.putAll(abstractC2128fy);
        return create;
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: cellSet */
    public /* bridge */ /* synthetic */ Set mo4633cellSet() {
        return super.mo4633cellSet();
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2128fy
    /* renamed from: column */
    public /* bridge */ /* synthetic */ Map mo4736column(Object obj) {
        return super.mo4736column(obj);
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: columnKeySet */
    public /* bridge */ /* synthetic */ Set mo4635columnKeySet() {
        return super.mo4635columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2128fy
    /* renamed from: columnMap */
    public /* bridge */ /* synthetic */ Map mo4741columnMap() {
        return super.mo4741columnMap();
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean contains(Object obj, Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public V get(Object obj, Object obj2) {
        return (V) super.get(obj, obj2);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ void putAll(AbstractC2128fy abstractC2128fy) {
        super.putAll(abstractC2128fy);
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public V remove(Object obj, Object obj2) {
        return (V) super.remove(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2128fy
    /* renamed from: row */
    public /* bridge */ /* synthetic */ Map mo4785row(Object obj) {
        return super.mo4785row(obj);
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: rowKeySet */
    public /* bridge */ /* synthetic */ Set mo4786rowKeySet() {
        return super.mo4786rowKeySet();
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2128fy
    /* renamed from: rowMap */
    public /* bridge */ /* synthetic */ Map mo4787rowMap() {
        return super.mo4787rowMap();
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // me.tvspark.AbstractC2537qu
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: values */
    public /* bridge */ /* synthetic */ Collection mo4642values() {
        return super.mo4642values();
    }
}
