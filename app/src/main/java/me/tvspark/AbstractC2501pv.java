package me.tvspark;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2128fy;

/* renamed from: me.tvspark.pv */
/* loaded from: classes4.dex */
public abstract class AbstractC2501pv<R, C, V> extends AbstractC2310kv implements AbstractC2128fy<R, C, V> {
    /* renamed from: cellSet */
    public Set<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4633cellSet() {
        return mo4974delegate().mo4633cellSet();
    }

    public abstract void clear();

    /* renamed from: column */
    public Map<R, V> mo4736column(C c) {
        return mo4974delegate().mo4736column(c);
    }

    /* renamed from: columnKeySet */
    public Set<C> mo4635columnKeySet() {
        return mo4974delegate().mo4635columnKeySet();
    }

    /* renamed from: columnMap */
    public Map<C, Map<R, V>> mo4741columnMap() {
        return mo4974delegate().mo4741columnMap();
    }

    @Override // me.tvspark.AbstractC2128fy
    public boolean contains(Object obj, Object obj2) {
        return mo4974delegate().contains(obj, obj2);
    }

    @Override // me.tvspark.AbstractC2128fy
    public boolean containsColumn(Object obj) {
        return mo4974delegate().containsColumn(obj);
    }

    @Override // me.tvspark.AbstractC2128fy
    public boolean containsRow(Object obj) {
        return mo4974delegate().containsRow(obj);
    }

    @Override // me.tvspark.AbstractC2128fy
    public boolean containsValue(Object obj) {
        return mo4974delegate().containsValue(obj);
    }

    @Override // me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract /* bridge */ /* synthetic */ Object mo4974delegate();

    @Override // me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public abstract AbstractC2128fy<R, C, V> mo4974delegate();

    @Override // me.tvspark.AbstractC2128fy
    public boolean equals(Object obj) {
        return obj == this || mo4974delegate().equals(obj);
    }

    @Override // me.tvspark.AbstractC2128fy
    public V get(Object obj, Object obj2) {
        return mo4974delegate().get(obj, obj2);
    }

    @Override // me.tvspark.AbstractC2128fy
    public int hashCode() {
        return mo4974delegate().hashCode();
    }

    @Override // me.tvspark.AbstractC2128fy
    public boolean isEmpty() {
        return mo4974delegate().isEmpty();
    }

    public abstract V put(R r, C c, V v);

    public abstract void putAll(AbstractC2128fy<? extends R, ? extends C, ? extends V> abstractC2128fy);

    public abstract V remove(Object obj, Object obj2);

    /* renamed from: row */
    public Map<C, V> mo4785row(R r) {
        return mo4974delegate().mo4785row(r);
    }

    /* renamed from: rowKeySet */
    public Set<R> mo4786rowKeySet() {
        return mo4974delegate().mo4786rowKeySet();
    }

    /* renamed from: rowMap */
    public Map<R, Map<C, V>> mo4787rowMap() {
        return mo4974delegate().mo4787rowMap();
    }

    @Override // me.tvspark.AbstractC2128fy
    public int size() {
        return mo4974delegate().size();
    }

    /* renamed from: values */
    public Collection<V> mo4642values() {
        return mo4974delegate().mo4642values();
    }
}
