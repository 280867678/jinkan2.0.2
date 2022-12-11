package me.tvspark;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: me.tvspark.ax */
/* loaded from: classes4.dex */
public final class C1925ax<K, V> extends AbstractC2839yw<K, Collection<V>> {
    public final AbstractC2876zw<K, V> Wwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.ax$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2422nw<K, Collection<V>> {

        /* renamed from: me.tvspark.ax$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3469Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2271jt<K, Collection<V>> {
            public C3469Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // me.tvspark.AbstractC2271jt
            /* renamed from: apply */
            public Object mo4462apply(Object obj) {
                return C1925ax.this.Wwwwwwwwwwwwwwwwwwwww.mo4793get(obj);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC2422nw
        public Map<K, Collection<V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return C1925ax.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set) C1925ax.this.Wwwwwwwwwwwwwwwwwwwww.mo4794keySet(), (AbstractC2271jt) new C3469Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }

        @Override // me.tvspark.AbstractC2422nw, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            C1925ax c1925ax = C1925ax.this;
            c1925ax.Wwwwwwwwwwwwwwwwwwwww.mo4794keySet().remove(((Map.Entry) obj).getKey());
            return true;
        }
    }

    public C1925ax(AbstractC2876zw<K, V> abstractC2876zw) {
        if (abstractC2876zw != null) {
            this.Wwwwwwwwwwwwwwwwwwwww = abstractC2876zw;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2839yw
    public Set<Map.Entry<K, Collection<V>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.Wwwwwwwwwwwwwwwwwwwww.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.Wwwwwwwwwwwwwwwwwwwww.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        if (this.Wwwwwwwwwwwwwwwwwwwww.containsKey(obj)) {
            return this.Wwwwwwwwwwwwwwwwwwwww.mo4793get(obj);
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.Wwwwwwwwwwwwwwwwwwwww.isEmpty();
    }

    @Override // me.tvspark.AbstractC2839yw, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    /* renamed from: keySet */
    public Set<K> mo4481keySet() {
        return this.Wwwwwwwwwwwwwwwwwwwww.mo4794keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        if (this.Wwwwwwwwwwwwwwwwwwwww.containsKey(obj)) {
            return this.Wwwwwwwwwwwwwwwwwwwww.mo4778removeAll(obj);
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.Wwwwwwwwwwwwwwwwwwwww.mo4794keySet().size();
    }
}
