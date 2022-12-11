package me.tvspark;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: me.tvspark.fy */
/* loaded from: classes4.dex */
public interface AbstractC2128fy<R, C, V> {

    /* renamed from: me.tvspark.fy$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V> {
        C getColumnKey();

        R getRowKey();

        V getValue();
    }

    /* renamed from: cellSet */
    Set<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4633cellSet();

    void clear();

    /* renamed from: column */
    Map<R, V> mo4736column(C c);

    /* renamed from: columnKeySet */
    Set<C> mo4635columnKeySet();

    /* renamed from: columnMap */
    Map<C, Map<R, V>> mo4741columnMap();

    boolean contains(Object obj, Object obj2);

    boolean containsColumn(Object obj);

    boolean containsRow(Object obj);

    boolean containsValue(Object obj);

    boolean equals(Object obj);

    V get(Object obj, Object obj2);

    int hashCode();

    boolean isEmpty();

    V put(R r, C c, V v);

    void putAll(AbstractC2128fy<? extends R, ? extends C, ? extends V> abstractC2128fy);

    V remove(Object obj, Object obj2);

    /* renamed from: row */
    Map<C, V> mo4785row(R r);

    /* renamed from: rowKeySet */
    Set<R> mo4786rowKeySet();

    /* renamed from: rowMap */
    Map<R, Map<C, V>> mo4787rowMap();

    int size();

    /* renamed from: values */
    Collection<V> mo4642values();
}
