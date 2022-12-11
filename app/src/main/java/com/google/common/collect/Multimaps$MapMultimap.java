package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2309ku;
import me.tvspark.AbstractC2614sx;
import me.tvspark.AbstractC2651tx;
import me.tvspark.AbstractC2876zw;
import me.tvspark.C1925ax;
import me.tvspark.C2053dx;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Multimaps$MapMultimap<K, V> extends AbstractC2309ku<K, V> implements AbstractC2614sx<K, V>, Serializable {
    public static final long serialVersionUID = 7845222491160860175L;
    public final Map<K, V> map;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2651tx<V> {
        public final /* synthetic */ Object Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: com.google.common.collect.Multimaps$MapMultimap$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C3455Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<V> {
            public int Wwwwwwwwwwwwwwwwwwwwwwww;

            public C3455Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww == 0) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                    if (Multimaps$MapMultimap.this.map.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww)) {
                        return true;
                    }
                }
                return false;
            }

            @Override // java.util.Iterator
            public V next() {
                if (hasNext()) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww++;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                    return Multimaps$MapMultimap.this.map.get(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                boolean z = true;
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww != 1) {
                    z = false;
                }
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, "no calls to next() since the last call to remove()");
                this.Wwwwwwwwwwwwwwwwwwwwwwww = -1;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                Multimaps$MapMultimap.this.map.remove(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = obj;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new C3455Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Multimaps$MapMultimap.this.map.containsKey(this.Wwwwwwwwwwwwwwwwwwwwwwww) ? 1 : 0;
        }
    }

    public Multimaps$MapMultimap(Map<K, V> map) {
        if (map != null) {
            this.map = map;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2876zw
    public void clear() {
        this.map.clear();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public boolean containsEntry(Object obj, Object obj2) {
        return this.map.entrySet().contains(new ImmutableEntry(obj, obj2));
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // me.tvspark.AbstractC2309ku
    public Map<K, Collection<V>> createAsMap() {
        return new C1925ax(this);
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: createEntries */
    public Collection<Map.Entry<K, V>> mo4647createEntries() {
        throw new AssertionError("unreachable");
    }

    @Override // me.tvspark.AbstractC2309ku
    public Set<K> createKeySet() {
        return this.map.keySet();
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: createKeys */
    public AbstractC2090ex<K> mo4560createKeys() {
        return new C2053dx(this);
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: createValues */
    public Collection<V> mo4648createValues() {
        return this.map.values();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: entries  reason: collision with other method in class */
    public Set<Map.Entry<K, V>> mo4768entries() {
        return this.map.entrySet();
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: entryIterator */
    public Iterator<Map.Entry<K, V>> mo4563entryIterator() {
        return this.map.entrySet().iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Collection mo4793get(Object obj) {
        return mo4793get((Multimaps$MapMultimap<K, V>) obj);
    }

    @Override // me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get  reason: collision with other method in class */
    public Set<V> mo4793get(K k) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public boolean put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public boolean putAll(AbstractC2876zw<? extends K, ? extends V> abstractC2876zw) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public boolean remove(Object obj, Object obj2) {
        return this.map.entrySet().remove(new ImmutableEntry(obj, obj2));
    }

    @Override // me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: removeAll  reason: collision with other method in class */
    public Set<V> mo4778removeAll(Object obj) {
        HashSet hashSet = new HashSet(2);
        if (!this.map.containsKey(obj)) {
            return hashSet;
        }
        hashSet.add(this.map.remove(obj));
        return hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((Multimaps$MapMultimap<K, V>) obj, iterable);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues  reason: collision with other method in class */
    public Set<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2876zw
    public int size() {
        return this.map.size();
    }
}
