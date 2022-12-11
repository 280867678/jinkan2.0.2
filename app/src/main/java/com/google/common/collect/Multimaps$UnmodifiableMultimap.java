package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2236iv;
import me.tvspark.AbstractC2271jt;
import me.tvspark.AbstractC2876zw;
import me.tvspark.C2728vw;
import me.tvspark.C2763wu;
import me.tvspark.C2765ww;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Multimaps$UnmodifiableMultimap<K, V> extends AbstractC2236iv<K, V> implements Serializable {
    public static final long serialVersionUID = 0;
    public final AbstractC2876zw<K, V> delegate;
    public transient Collection<Map.Entry<K, V>> entries;
    public transient Set<K> keySet;
    public transient AbstractC2090ex<K> keys;
    public transient Map<K, Collection<V>> map;
    public transient Collection<V> values;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2271jt<Collection<V>, Collection<V>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Multimaps$UnmodifiableMultimap multimaps$UnmodifiableMultimap) {
        }

        @Override // me.tvspark.AbstractC2271jt
        /* renamed from: apply */
        public Object mo4462apply(Object obj) {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) obj);
        }
    }

    public Multimaps$UnmodifiableMultimap(AbstractC2876zw<K, V> abstractC2876zw) {
        if (abstractC2876zw != null) {
            this.delegate = abstractC2876zw;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw
    /* renamed from: asMap */
    public Map<K, Collection<V>> mo4790asMap() {
        Map<K, Collection<V>> map = this.map;
        if (map == null) {
            Map<K, Collection<V>> unmodifiableMap = Collections.unmodifiableMap(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.delegate.mo4790asMap(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)));
            this.map = unmodifiableMap;
            return unmodifiableMap;
        }
        return map;
    }

    @Override // me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public AbstractC2876zw<K, V> mo4974delegate() {
        return this.delegate;
    }

    @Override // me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw
    /* renamed from: entries */
    public Collection<Map.Entry<K, V>> mo4768entries() {
        Collection<Map.Entry<K, V>> c2728vw;
        Collection<Map.Entry<K, V>> collection = this.entries;
        if (collection == null) {
            Collection<Map.Entry<K, V>> mo4768entries = this.delegate.mo4768entries();
            if (mo4768entries instanceof Set) {
                c2728vw = new C2765ww<>(Collections.unmodifiableSet((Set) mo4768entries));
            } else {
                c2728vw = new C2728vw<>(Collections.unmodifiableCollection(mo4768entries));
            }
            Collection<Map.Entry<K, V>> collection2 = c2728vw;
            this.entries = collection2;
            return collection2;
        }
        return collection;
    }

    @Override // me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public Collection<V> mo4793get(K k) {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) this.delegate.mo4793get(k));
    }

    @Override // me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw
    /* renamed from: keySet */
    public Set<K> mo4794keySet() {
        Set<K> set = this.keySet;
        if (set == null) {
            Set<K> unmodifiableSet = Collections.unmodifiableSet(this.delegate.mo4794keySet());
            this.keySet = unmodifiableSet;
            return unmodifiableSet;
        }
        return set;
    }

    @Override // me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw
    /* renamed from: keys */
    public AbstractC2090ex<K> mo4566keys() {
        AbstractC2090ex<K> abstractC2090ex = this.keys;
        if (abstractC2090ex == null) {
            abstractC2090ex = this.delegate.mo4566keys();
            if (!(abstractC2090ex instanceof Multisets$UnmodifiableMultiset) && !(abstractC2090ex instanceof ImmutableMultiset)) {
                if (abstractC2090ex == null) {
                    throw null;
                }
                abstractC2090ex = new Multisets$UnmodifiableMultiset(abstractC2090ex);
            }
            this.keys = abstractC2090ex;
        }
        return abstractC2090ex;
    }

    @Override // me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw
    public boolean put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw
    public boolean putAll(AbstractC2876zw<? extends K, ? extends V> abstractC2876zw) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: removeAll */
    public Collection<V> mo4778removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public Collection<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2236iv, me.tvspark.AbstractC2876zw
    /* renamed from: values */
    public Collection<V> mo4653values() {
        Collection<V> collection = this.values;
        if (collection == null) {
            Collection<V> unmodifiableCollection = Collections.unmodifiableCollection(this.delegate.mo4653values());
            this.values = unmodifiableCollection;
            return unmodifiableCollection;
        }
        return collection;
    }
}
