package com.google.common.collect;

import com.google.common.collect.ImmutableTable;
import java.util.Map;
import me.tvspark.AbstractC2128fy;

/* loaded from: classes3.dex */
public class SingletonImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    public final C singleColumnKey;
    public final R singleRowKey;
    public final V singleValue;

    public SingletonImmutableTable(R r, C c, V v) {
        if (r != null) {
            this.singleRowKey = r;
            if (c == null) {
                throw null;
            }
            this.singleColumnKey = c;
            if (v == null) {
                throw null;
            }
            this.singleValue = v;
            return;
        }
        throw null;
    }

    public SingletonImmutableTable(AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRowKey(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getColumnKey(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getValue());
    }

    @Override // com.google.common.collect.ImmutableTable, me.tvspark.AbstractC2128fy
    /* renamed from: column */
    public ImmutableMap<R, V> mo4736column(C c) {
        if (c != null) {
            return containsColumn(c) ? ImmutableMap.m3899of(this.singleRowKey, (Object) this.singleValue) : ImmutableMap.m3900of();
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableTable, me.tvspark.AbstractC2128fy
    /* renamed from: column  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Map mo4736column(Object obj) {
        return mo4736column((SingletonImmutableTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableTable, me.tvspark.AbstractC2128fy
    /* renamed from: columnMap */
    public ImmutableMap<C, Map<R, V>> mo4741columnMap() {
        return ImmutableMap.m3899of(this.singleColumnKey, ImmutableMap.m3899of(this.singleRowKey, (Object) this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableTable, me.tvspark.AbstractC2537qu
    /* renamed from: createCellSet */
    public ImmutableSet<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4738createCellSet() {
        return ImmutableSet.m3876of(ImmutableTable.cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, new int[]{0}, new int[]{0});
    }

    @Override // com.google.common.collect.ImmutableTable, me.tvspark.AbstractC2537qu
    /* renamed from: createValues */
    public ImmutableCollection<V> mo4739createValues() {
        return ImmutableSet.m3876of(this.singleValue);
    }

    @Override // com.google.common.collect.ImmutableTable, me.tvspark.AbstractC2128fy
    /* renamed from: rowMap */
    public ImmutableMap<R, Map<C, V>> mo4787rowMap() {
        return ImmutableMap.m3899of(this.singleRowKey, ImmutableMap.m3899of(this.singleColumnKey, (Object) this.singleValue));
    }

    @Override // me.tvspark.AbstractC2128fy
    public int size() {
        return 1;
    }
}
