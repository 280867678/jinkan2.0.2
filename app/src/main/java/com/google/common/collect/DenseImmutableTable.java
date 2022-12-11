package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import me.tvspark.AbstractC2128fy;
import me.tvspark.AbstractC2239iy;
import me.tvspark.C2763wu;

/* loaded from: classes3.dex */
public final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    public final int[] cellColumnIndices;
    public final int[] cellRowIndices;
    public final int[] columnCounts;
    public final ImmutableMap<C, Integer> columnKeyToIndex;
    public final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    public final int[] rowCounts;
    public final ImmutableMap<R, Integer> rowKeyToIndex;
    public final ImmutableMap<R, ImmutableMap<C, V>> rowMap;
    public final V[][] values;

    /* loaded from: classes3.dex */
    public final class Column extends ImmutableArrayMap<R, V> {
        public final int columnIndex;

        public Column(int i) {
            super(DenseImmutableTable.this.columnCounts[i]);
            this.columnIndex = i;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        /* renamed from: getValue */
        public V mo4510getValue(int i) {
            return (V) DenseImmutableTable.this.values[i][this.columnIndex];
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }
    }

    /* loaded from: classes3.dex */
    public final class ColumnMap extends ImmutableArrayMap<C, ImmutableMap<R, V>> {
        public ColumnMap() {
            super(DenseImmutableTable.this.columnCounts.length);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        /* renamed from: getValue */
        public ImmutableMap<R, V> mo4510getValue(int i) {
            return new Column(i);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class ImmutableArrayMap<K, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
        public final int size;

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractIterator<Map.Entry<K, V>> {
            public final int Wwwwwwwwwwwwwwwwwwwww;
            public int Wwwwwwwwwwwwwwwwwwwwww = -1;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                this.Wwwwwwwwwwwwwwwwwwwww = ImmutableArrayMap.this.keyToIndex().size();
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                Object mo4510getValue;
                do {
                    int i = this.Wwwwwwwwwwwwwwwwwwwwww + 1;
                    this.Wwwwwwwwwwwwwwwwwwwwww = i;
                    if (i >= this.Wwwwwwwwwwwwwwwwwwwww) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return null;
                    }
                    mo4510getValue = ImmutableArrayMap.this.mo4510getValue(i);
                } while (mo4510getValue == null);
                return new ImmutableEntry(ImmutableArrayMap.this.getKey(this.Wwwwwwwwwwwwwwwwwwwwww), mo4510getValue);
            }
        }

        public ImmutableArrayMap(int i) {
            this.size = i;
        }

        private boolean isFull() {
            return this.size == keyToIndex().size();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return isFull() ? keyToIndex().mo4552keySet() : super.createKeySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public AbstractC2239iy<Map.Entry<K, V>> entryIterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        /* renamed from: get */
        public V mo4554get(Object obj) {
            Integer mo4554get = keyToIndex().mo4554get(obj);
            if (mo4554get == null) {
                return null;
            }
            return mo4510getValue(mo4554get.intValue());
        }

        public K getKey(int i) {
            return keyToIndex().mo4552keySet().asList().get(i);
        }

        /* renamed from: getValue */
        public abstract V mo4510getValue(int i);

        public abstract ImmutableMap<K, Integer> keyToIndex();

        @Override // java.util.Map
        public int size() {
            return this.size;
        }
    }

    /* loaded from: classes3.dex */
    public final class Row extends ImmutableArrayMap<C, V> {
        public final int rowIndex;

        public Row(int i) {
            super(DenseImmutableTable.this.rowCounts[i]);
            this.rowIndex = i;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        /* renamed from: getValue */
        public V mo4510getValue(int i) {
            return (V) DenseImmutableTable.this.values[this.rowIndex][i];
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }
    }

    /* loaded from: classes3.dex */
    public final class RowMap extends ImmutableArrayMap<R, ImmutableMap<C, V>> {
        public RowMap() {
            super(DenseImmutableTable.this.rowCounts.length);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        /* renamed from: getValue */
        public ImmutableMap<C, V> mo4510getValue(int i) {
            return new Row(i);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }
    }

    public DenseImmutableTable(ImmutableList<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        this.values = (V[][]) ((Object[][]) Array.newInstance(Object.class, immutableSet.size(), immutableSet2.size()));
        this.rowKeyToIndex = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) immutableSet);
        this.columnKeyToIndex = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) immutableSet2);
        this.rowCounts = new int[this.rowKeyToIndex.size()];
        this.columnCounts = new int[this.columnKeyToIndex.size()];
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = immutableList.get(i);
            R rowKey = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRowKey();
            C columnKey = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getColumnKey();
            int intValue = this.rowKeyToIndex.mo4554get(rowKey).intValue();
            int intValue2 = this.columnKeyToIndex.mo4554get(columnKey).intValue();
            checkNoDuplicate(rowKey, columnKey, this.values[intValue][intValue2], wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getValue());
            this.values[intValue][intValue2] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getValue();
            int[] iArr3 = this.rowCounts;
            iArr3[intValue] = iArr3[intValue] + 1;
            int[] iArr4 = this.columnCounts;
            iArr4[intValue2] = iArr4[intValue2] + 1;
            iArr[i] = intValue;
            iArr2[i] = intValue2;
        }
        this.cellRowIndices = iArr;
        this.cellColumnIndices = iArr2;
        this.rowMap = new RowMap();
        this.columnMap = new ColumnMap();
    }

    @Override // com.google.common.collect.ImmutableTable, me.tvspark.AbstractC2128fy
    /* renamed from: columnMap */
    public ImmutableMap<C, Map<R, V>> mo4741columnMap() {
        return ImmutableMap.copyOf((Map) this.columnMap);
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, this.cellColumnIndices);
    }

    @Override // com.google.common.collect.ImmutableTable, me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public V get(Object obj, Object obj2) {
        Integer mo4554get = this.rowKeyToIndex.mo4554get(obj);
        Integer mo4554get2 = this.columnKeyToIndex.mo4554get(obj2);
        if (mo4554get == null || mo4554get2 == null) {
            return null;
        }
        return this.values[mo4554get.intValue()][mo4554get2.intValue()];
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> getCell(int i) {
        int i2 = this.cellRowIndices[i];
        int i3 = this.cellColumnIndices[i];
        return ImmutableTable.cellOf(mo4786rowKeySet().asList().get(i2), mo4635columnKeySet().asList().get(i3), this.values[i2][i3]);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public V getValue(int i) {
        return this.values[this.cellRowIndices[i]][this.cellColumnIndices[i]];
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
