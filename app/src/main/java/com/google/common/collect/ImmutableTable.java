package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Tables;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.tvspark.AbstractC2128fy;
import me.tvspark.AbstractC2239iy;
import me.tvspark.AbstractC2537qu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class ImmutableTable<R, C, V> extends AbstractC2537qu<R, C, V> implements Serializable {

    /* loaded from: classes3.dex */
    public static final class SerializedForm implements Serializable {
        public static final long serialVersionUID = 0;
        public final int[] cellColumnIndices;
        public final int[] cellRowIndices;
        public final Object[] cellValues;
        public final Object[] columnKeys;
        public final Object[] rowKeys;

        public SerializedForm(Object[] objArr, Object[] objArr2, Object[] objArr3, int[] iArr, int[] iArr2) {
            this.rowKeys = objArr;
            this.columnKeys = objArr2;
            this.cellValues = objArr3;
            this.cellRowIndices = iArr;
            this.cellColumnIndices = iArr2;
        }

        public static SerializedForm create(ImmutableTable<?, ?, ?> immutableTable, int[] iArr, int[] iArr2) {
            return new SerializedForm(immutableTable.mo4786rowKeySet().toArray(), immutableTable.mo4635columnKeySet().toArray(), immutableTable.mo4642values().toArray(), iArr, iArr2);
        }

        public Object readResolve() {
            Object[] objArr = this.cellValues;
            if (objArr.length == 0) {
                return ImmutableTable.m3826of();
            }
            int i = 0;
            if (objArr.length == 1) {
                return ImmutableTable.m3825of(this.rowKeys[0], this.columnKeys[0], objArr[0]);
            }
            ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr.length);
            while (true) {
                Object[] objArr2 = this.cellValues;
                if (i >= objArr2.length) {
                    return RegularImmutableTable.forOrderedComponents(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), ImmutableSet.copyOf(this.rowKeys), ImmutableSet.copyOf(this.columnKeys));
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ImmutableTable.cellOf(this.rowKeys[this.cellRowIndices[i]], this.columnKeys[this.cellColumnIndices[i]], objArr2[i]));
                i++;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> {
        public final List<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    }

    public static <R, C, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> builder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();
    }

    public static <R, C, V> AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> cellOf(R r, C c, V v) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r, "rowKey");
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c, "columnKey");
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v, "value");
        return Tables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r, c, v);
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Iterable<? extends AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? extends R, ? extends C, ? extends V>> iterable) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = builder();
        for (AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? extends R, ? extends C, ? extends V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : iterable) {
            if (builder != null) {
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof Tables.ImmutableCell) {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRowKey(), "row");
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getColumnKey(), "column");
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getValue(), "value");
                    builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else {
                    builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(cellOf(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRowKey(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getColumnKey(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getValue()));
                }
            } else {
                throw null;
            }
        }
        int size = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
        return size != 0 ? size != 1 ? RegularImmutableTable.forCells(builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null, null) : new SingletonImmutableTable((AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable<Object>) builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) : m3826of();
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(AbstractC2128fy<? extends R, ? extends C, ? extends V> abstractC2128fy) {
        return abstractC2128fy instanceof ImmutableTable ? (ImmutableTable) abstractC2128fy : copyOf(abstractC2128fy.mo4633cellSet());
    }

    /* renamed from: of */
    public static <R, C, V> ImmutableTable<R, C, V> m3826of() {
        return (ImmutableTable<R, C, V>) SparseImmutableTable.EMPTY;
    }

    /* renamed from: of */
    public static <R, C, V> ImmutableTable<R, C, V> m3825of(R r, C c, V v) {
        return new SingletonImmutableTable(r, c, v);
    }

    @Override // me.tvspark.AbstractC2537qu
    /* renamed from: cellIterator  reason: collision with other method in class */
    public final AbstractC2239iy<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4632cellIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: cellSet */
    public ImmutableSet<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4633cellSet() {
        return (ImmutableSet) super.mo4633cellSet();
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: column */
    public ImmutableMap<R, V> mo4736column(C c) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c, "columnKey");
        return (ImmutableMap) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableMap) mo4741columnMap().mo4554get(c), ImmutableMap.m3900of());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: column  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Map mo4736column(Object obj) {
        return mo4736column((ImmutableTable<R, C, V>) obj);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: columnKeySet */
    public ImmutableSet<C> mo4635columnKeySet() {
        return mo4741columnMap().mo4552keySet();
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: columnMap */
    public abstract ImmutableMap<C, Map<R, V>> mo4741columnMap();

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean contains(Object obj, Object obj2) {
        return get(obj, obj2) != null;
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public boolean containsValue(Object obj) {
        return mo4642values().contains(obj);
    }

    @Override // me.tvspark.AbstractC2537qu
    /* renamed from: createCellSet */
    public abstract ImmutableSet<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4738createCellSet();

    public abstract SerializedForm createSerializedForm();

    @Override // me.tvspark.AbstractC2537qu
    /* renamed from: createValues */
    public abstract ImmutableCollection<V> mo4739createValues();

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    @Deprecated
    public final V put(R r, C c, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    @Deprecated
    public final void putAll(AbstractC2128fy<? extends R, ? extends C, ? extends V> abstractC2128fy) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    @Deprecated
    public final V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: row */
    public ImmutableMap<C, V> mo4785row(R r) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r, "rowKey");
        return (ImmutableMap) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableMap) mo4787rowMap().mo4554get(r), ImmutableMap.m3900of());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: row  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Map mo4785row(Object obj) {
        return mo4785row((ImmutableTable<R, C, V>) obj);
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: rowKeySet */
    public ImmutableSet<R> mo4786rowKeySet() {
        return mo4787rowMap().mo4552keySet();
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: rowMap */
    public abstract ImmutableMap<R, Map<C, V>> mo4787rowMap();

    @Override // me.tvspark.AbstractC2537qu
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // me.tvspark.AbstractC2537qu, me.tvspark.AbstractC2128fy
    /* renamed from: values */
    public ImmutableCollection<V> mo4642values() {
        return (ImmutableCollection) super.mo4642values();
    }

    @Override // me.tvspark.AbstractC2537qu
    public final Iterator<V> valuesIterator() {
        throw new AssertionError("should never be called");
    }

    public final Object writeReplace() {
        return createSerializedForm();
    }
}
