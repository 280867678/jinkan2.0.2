package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import me.tvspark.AbstractC2128fy;
import me.tvspark.AbstractC2271jt;
import me.tvspark.AbstractC2501pv;
import me.tvspark.AbstractC2503px;
import me.tvspark.C2311kw;
import me.tvspark.C2688uw;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class Tables {
    public static final AbstractC2271jt<? extends Map<?, ?>, ? extends Map<?, ?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes3.dex */
    public static final class ImmutableCell<R, C, V> extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> implements Serializable {
        public static final long serialVersionUID = 0;
        public final C columnKey;
        public final R rowKey;
        public final V value;

        public ImmutableCell(R r, C c, V v) {
            this.rowKey = r;
            this.columnKey = c;
            this.value = v;
        }

        @Override // me.tvspark.AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public C getColumnKey() {
            return this.columnKey;
        }

        @Override // me.tvspark.AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public R getRowKey() {
            return this.rowKey;
        }

        @Override // me.tvspark.AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public V getValue() {
            return this.value;
        }
    }

    /* loaded from: classes3.dex */
    public static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements AbstractC2503px<R, C, V> {
        public static final long serialVersionUID = 0;

        public UnmodifiableRowSortedMap(AbstractC2503px<R, ? extends C, ? extends V> abstractC2503px) {
            super(abstractC2503px);
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, me.tvspark.AbstractC2501pv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public AbstractC2503px<R, C, V> mo4974delegate() {
            return (AbstractC2503px) super.mo4974delegate();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, me.tvspark.AbstractC2501pv, me.tvspark.AbstractC2128fy
        /* renamed from: rowKeySet  reason: collision with other method in class */
        public SortedSet<R> mo4786rowKeySet() {
            return Collections.unmodifiableSortedSet(mo4974delegate().mo4786rowKeySet());
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, me.tvspark.AbstractC2501pv, me.tvspark.AbstractC2128fy
        /* renamed from: rowMap  reason: collision with other method in class */
        public SortedMap<R, Map<C, V>> mo4787rowMap() {
            return Collections.unmodifiableSortedMap(new C2688uw(mo4974delegate().mo4787rowMap(), new C2311kw(Tables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)));
        }
    }

    /* loaded from: classes3.dex */
    public static class UnmodifiableTable<R, C, V> extends AbstractC2501pv<R, C, V> implements Serializable {
        public static final long serialVersionUID = 0;
        public final AbstractC2128fy<? extends R, ? extends C, ? extends V> delegate;

        public UnmodifiableTable(AbstractC2128fy<? extends R, ? extends C, ? extends V> abstractC2128fy) {
            if (abstractC2128fy != null) {
                this.delegate = abstractC2128fy;
                return;
            }
            throw null;
        }

        @Override // me.tvspark.AbstractC2501pv, me.tvspark.AbstractC2128fy
        /* renamed from: cellSet */
        public Set<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4633cellSet() {
            return Collections.unmodifiableSet(super.mo4633cellSet());
        }

        @Override // me.tvspark.AbstractC2501pv, me.tvspark.AbstractC2128fy
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2501pv, me.tvspark.AbstractC2128fy
        /* renamed from: column */
        public Map<R, V> mo4736column(C c) {
            return Collections.unmodifiableMap(super.mo4736column(c));
        }

        @Override // me.tvspark.AbstractC2501pv, me.tvspark.AbstractC2128fy
        /* renamed from: columnKeySet */
        public Set<C> mo4635columnKeySet() {
            return Collections.unmodifiableSet(super.mo4635columnKeySet());
        }

        @Override // me.tvspark.AbstractC2501pv, me.tvspark.AbstractC2128fy
        /* renamed from: columnMap */
        public Map<C, Map<R, V>> mo4741columnMap() {
            return Collections.unmodifiableMap(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(super.mo4741columnMap(), Tables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }

        @Override // me.tvspark.AbstractC2501pv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate  reason: collision with other method in class */
        public AbstractC2128fy<R, C, V> mo4974delegate() {
            return (AbstractC2128fy<? extends R, ? extends C, ? extends V>) this.delegate;
        }

        @Override // me.tvspark.AbstractC2501pv, me.tvspark.AbstractC2128fy
        public V put(R r, C c, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2501pv, me.tvspark.AbstractC2128fy
        public void putAll(AbstractC2128fy<? extends R, ? extends C, ? extends V> abstractC2128fy) {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2501pv, me.tvspark.AbstractC2128fy
        public V remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2501pv, me.tvspark.AbstractC2128fy
        /* renamed from: row */
        public Map<C, V> mo4785row(R r) {
            return Collections.unmodifiableMap(super.mo4785row(r));
        }

        @Override // me.tvspark.AbstractC2501pv, me.tvspark.AbstractC2128fy
        /* renamed from: rowKeySet */
        public Set<R> mo4786rowKeySet() {
            return Collections.unmodifiableSet(super.mo4786rowKeySet());
        }

        @Override // me.tvspark.AbstractC2501pv, me.tvspark.AbstractC2128fy
        /* renamed from: rowMap */
        public Map<R, Map<C, V>> mo4787rowMap() {
            return Collections.unmodifiableMap(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(super.mo4787rowMap(), Tables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }

        @Override // me.tvspark.AbstractC2501pv, me.tvspark.AbstractC2128fy
        /* renamed from: values */
        public Collection<V> mo4642values() {
            return Collections.unmodifiableCollection(super.mo4642values());
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> implements AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> {
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return false;
            }
            AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getRowKey(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRowKey()) && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getColumnKey(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getColumnKey()) && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getValue(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getValue());
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{getRowKey(), getColumnKey(), getValue()});
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getRowKey());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getColumnKey());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getValue());
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2271jt<Map<Object, Object>, Map<Object, Object>> {
        @Override // me.tvspark.AbstractC2271jt
        /* renamed from: apply */
        public Map<Object, Object> mo4462apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    }

    public static <R, C, V> AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R r, C c, V v) {
        return new ImmutableCell(r, c, v);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2128fy<?, ?, ?> abstractC2128fy, Object obj) {
        if (obj == abstractC2128fy) {
            return true;
        }
        if (!(obj instanceof AbstractC2128fy)) {
            return false;
        }
        return abstractC2128fy.mo4633cellSet().equals(((AbstractC2128fy) obj).mo4633cellSet());
    }
}
