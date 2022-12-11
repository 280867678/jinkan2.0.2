package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2128fy;
import me.tvspark.AbstractC2271jt;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class Synchronized$SynchronizedTable<R, C, V> extends Synchronized$SynchronizedObject implements AbstractC2128fy<R, C, V> {

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2271jt<Map<R, V>, Map<R, V>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC2271jt
        /* renamed from: apply */
        public Object mo4462apply(Object obj) {
            return new Synchronized$SynchronizedMap((Map) obj, Synchronized$SynchronizedTable.this.mutex);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2271jt<Map<C, V>, Map<C, V>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC2271jt
        /* renamed from: apply */
        public Object mo4462apply(Object obj) {
            return new Synchronized$SynchronizedMap((Map) obj, Synchronized$SynchronizedTable.this.mutex);
        }
    }

    public Synchronized$SynchronizedTable(AbstractC2128fy<R, C, V> abstractC2128fy, Object obj) {
        super(abstractC2128fy, obj);
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: cellSet */
    public Set<AbstractC2128fy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R, C, V>> mo4633cellSet() {
        Synchronized$SynchronizedSet synchronized$SynchronizedSet;
        synchronized (this.mutex) {
            synchronized$SynchronizedSet = new Synchronized$SynchronizedSet(mo4780delegate().mo4633cellSet(), this.mutex);
        }
        return synchronized$SynchronizedSet;
    }

    @Override // me.tvspark.AbstractC2128fy
    public void clear() {
        synchronized (this.mutex) {
            mo4780delegate().clear();
        }
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: column */
    public Map<R, V> mo4736column(C c) {
        Synchronized$SynchronizedMap synchronized$SynchronizedMap;
        synchronized (this.mutex) {
            synchronized$SynchronizedMap = new Synchronized$SynchronizedMap(mo4780delegate().mo4736column(c), this.mutex);
        }
        return synchronized$SynchronizedMap;
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: columnKeySet */
    public Set<C> mo4635columnKeySet() {
        Synchronized$SynchronizedSet synchronized$SynchronizedSet;
        synchronized (this.mutex) {
            synchronized$SynchronizedSet = new Synchronized$SynchronizedSet(mo4780delegate().mo4635columnKeySet(), this.mutex);
        }
        return synchronized$SynchronizedSet;
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: columnMap */
    public Map<C, Map<R, V>> mo4741columnMap() {
        Synchronized$SynchronizedMap synchronized$SynchronizedMap;
        synchronized (this.mutex) {
            synchronized$SynchronizedMap = new Synchronized$SynchronizedMap(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4780delegate().mo4741columnMap(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()), this.mutex);
        }
        return synchronized$SynchronizedMap;
    }

    @Override // me.tvspark.AbstractC2128fy
    public boolean contains(Object obj, Object obj2) {
        boolean contains;
        synchronized (this.mutex) {
            contains = mo4780delegate().contains(obj, obj2);
        }
        return contains;
    }

    @Override // me.tvspark.AbstractC2128fy
    public boolean containsColumn(Object obj) {
        boolean containsColumn;
        synchronized (this.mutex) {
            containsColumn = mo4780delegate().containsColumn(obj);
        }
        return containsColumn;
    }

    @Override // me.tvspark.AbstractC2128fy
    public boolean containsRow(Object obj) {
        boolean containsRow;
        synchronized (this.mutex) {
            containsRow = mo4780delegate().containsRow(obj);
        }
        return containsRow;
    }

    @Override // me.tvspark.AbstractC2128fy
    public boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = mo4780delegate().containsValue(obj);
        }
        return containsValue;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate  reason: collision with other method in class */
    public AbstractC2128fy<R, C, V> mo4780delegate() {
        return (AbstractC2128fy) super.mo4780delegate();
    }

    @Override // me.tvspark.AbstractC2128fy
    public boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        synchronized (this.mutex) {
            equals = mo4780delegate().equals(obj);
        }
        return equals;
    }

    @Override // me.tvspark.AbstractC2128fy
    public V get(Object obj, Object obj2) {
        V v;
        synchronized (this.mutex) {
            v = mo4780delegate().get(obj, obj2);
        }
        return v;
    }

    @Override // me.tvspark.AbstractC2128fy
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = mo4780delegate().hashCode();
        }
        return hashCode;
    }

    @Override // me.tvspark.AbstractC2128fy
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = mo4780delegate().isEmpty();
        }
        return isEmpty;
    }

    @Override // me.tvspark.AbstractC2128fy
    public V put(R r, C c, V v) {
        V put;
        synchronized (this.mutex) {
            put = mo4780delegate().put(r, c, v);
        }
        return put;
    }

    @Override // me.tvspark.AbstractC2128fy
    public void putAll(AbstractC2128fy<? extends R, ? extends C, ? extends V> abstractC2128fy) {
        synchronized (this.mutex) {
            mo4780delegate().putAll(abstractC2128fy);
        }
    }

    @Override // me.tvspark.AbstractC2128fy
    public V remove(Object obj, Object obj2) {
        V remove;
        synchronized (this.mutex) {
            remove = mo4780delegate().remove(obj, obj2);
        }
        return remove;
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: row */
    public Map<C, V> mo4785row(R r) {
        Synchronized$SynchronizedMap synchronized$SynchronizedMap;
        synchronized (this.mutex) {
            synchronized$SynchronizedMap = new Synchronized$SynchronizedMap(mo4780delegate().mo4785row(r), this.mutex);
        }
        return synchronized$SynchronizedMap;
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: rowKeySet */
    public Set<R> mo4786rowKeySet() {
        Synchronized$SynchronizedSet synchronized$SynchronizedSet;
        synchronized (this.mutex) {
            synchronized$SynchronizedSet = new Synchronized$SynchronizedSet(mo4780delegate().mo4786rowKeySet(), this.mutex);
        }
        return synchronized$SynchronizedSet;
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: rowMap */
    public Map<R, Map<C, V>> mo4787rowMap() {
        Synchronized$SynchronizedMap synchronized$SynchronizedMap;
        synchronized (this.mutex) {
            synchronized$SynchronizedMap = new Synchronized$SynchronizedMap(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4780delegate().mo4787rowMap(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()), this.mutex);
        }
        return synchronized$SynchronizedMap;
    }

    @Override // me.tvspark.AbstractC2128fy
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = mo4780delegate().size();
        }
        return size;
    }

    @Override // me.tvspark.AbstractC2128fy
    /* renamed from: values */
    public Collection<V> mo4642values() {
        Collection<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        synchronized (this.mutex) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) mo4780delegate().mo4642values(), this.mutex);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }
}
