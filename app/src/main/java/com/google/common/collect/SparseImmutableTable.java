package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import me.tvspark.AbstractC2128fy;
import me.tvspark.AbstractC2239iy;
import me.tvspark.C2763wu;

/* loaded from: classes3.dex */
public final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    public static final ImmutableTable<Object, Object, Object> EMPTY = new SparseImmutableTable(ImmutableList.m3919of(), ImmutableSet.m3877of(), ImmutableSet.m3877of());
    public final int[] cellColumnInRowIndices;
    public final int[] cellRowIndices;
    public final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    public final ImmutableMap<R, ImmutableMap<C, V>> rowMap;

    /* JADX WARN: Multi-variable type inference failed */
    public SparseImmutableTable(ImmutableList<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        ImmutableMap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) immutableSet);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        AbstractC2239iy<R> mo4735iterator = immutableSet.mo4735iterator();
        while (mo4735iterator.hasNext()) {
            linkedHashMap.put(mo4735iterator.next(), new LinkedHashMap());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        AbstractC2239iy<C> mo4735iterator2 = immutableSet2.mo4735iterator();
        while (mo4735iterator2.hasNext()) {
            linkedHashMap2.put(mo4735iterator2.next(), new LinkedHashMap());
        }
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = immutableList.get(i);
            R rowKey = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRowKey();
            C columnKey = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getColumnKey();
            V value = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getValue();
            iArr[i] = ((Integer) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(rowKey)).intValue();
            Map map = (Map) linkedHashMap.get(rowKey);
            iArr2[i] = map.size();
            checkNoDuplicate(rowKey, columnKey, map.put(columnKey, value), value);
            ((Map) linkedHashMap2.get(columnKey)).put(rowKey, value);
        }
        this.cellRowIndices = iArr;
        this.cellColumnInRowIndices = iArr2;
        ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry.getKey(), ImmutableMap.copyOf((Map) entry.getValue()));
        }
        this.rowMap = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(linkedHashMap2.size());
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry2.getKey(), ImmutableMap.copyOf((Map) entry2.getValue()));
        }
        this.columnMap = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // com.google.common.collect.ImmutableTable, me.tvspark.AbstractC2128fy
    /* renamed from: columnMap */
    public ImmutableMap<C, Map<R, V>> mo4741columnMap() {
        return ImmutableMap.copyOf((Map) this.columnMap);
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        ImmutableMap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) mo4635columnKeySet());
        int[] iArr = new int[mo4633cellSet().size()];
        AbstractC2239iy<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4735iterator = mo4633cellSet().mo4735iterator();
        int i = 0;
        while (mo4735iterator.hasNext()) {
            iArr[i] = ((Integer) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(mo4735iterator.next().getColumnKey())).intValue();
            i++;
        }
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, iArr);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> getCell(int i) {
        Map.Entry<R, ImmutableMap<C, V>> entry = this.rowMap.mo4551entrySet().asList().get(this.cellRowIndices[i]);
        Map.Entry<C, V> entry2 = entry.getValue().mo4551entrySet().asList().get(this.cellColumnInRowIndices[i]);
        return ImmutableTable.cellOf(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public V getValue(int i) {
        int i2 = this.cellRowIndices[i];
        return this.rowMap.values().asList().get(i2).values().asList().get(this.cellColumnInRowIndices[i]);
    }

    @Override // com.google.common.collect.ImmutableTable, me.tvspark.AbstractC2128fy
    /* renamed from: rowMap */
    public ImmutableMap<R, Map<C, V>> mo4787rowMap() {
        return ImmutableMap.copyOf((Map) this.rowMap);
    }

    @Override // me.tvspark.AbstractC2128fy
    public int size() {
        return this.cellRowIndices.length;
    }
}
