package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC2162gv;
import me.tvspark.AbstractC2199hv;
import me.tvspark.AbstractC2384mv;
import me.tvspark.AbstractC2648tu;
import me.tvspark.C2126fw;
import me.tvspark.C2163gw;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class AbstractBiMap<K, V> extends AbstractC2162gv<K, V> implements AbstractC2648tu<K, V>, Serializable {
    public static final long serialVersionUID = 0;
    public transient Map<K, V> delegate;
    public transient Set<Map.Entry<K, V>> entrySet;
    public transient AbstractBiMap<V, K> inverse;
    public transient Set<K> keySet;
    public transient Set<V> valueSet;

    /* loaded from: classes3.dex */
    public static class Inverse<K, V> extends AbstractBiMap<K, V> {
        public static final long serialVersionUID = 0;

        public Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap, null);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            setInverse((AbstractBiMap) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(mo4713inverse());
        }

        @Override // com.google.common.collect.AbstractBiMap
        public K checkKey(K k) {
            return this.inverse.checkValue(k);
        }

        @Override // com.google.common.collect.AbstractBiMap
        public V checkValue(V v) {
            return this.inverse.checkKey(v);
        }

        @Override // com.google.common.collect.AbstractBiMap, me.tvspark.AbstractC2162gv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public /* bridge */ /* synthetic */ Object mo4974delegate() {
            return super.mo4974delegate();
        }

        public Object readResolve() {
            return mo4713inverse().mo4713inverse();
        }

        @Override // com.google.common.collect.AbstractBiMap, me.tvspark.AbstractC2162gv, java.util.Map, me.tvspark.AbstractC2648tu
        /* renamed from: values */
        public /* bridge */ /* synthetic */ Collection mo4672values() {
            return super.mo4672values();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2384mv<V> {
        public final Set<V> Wwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = AbstractBiMap.this.inverse.keySet();
        }

        @Override // me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public Object mo4974delegate() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public Set<V> mo4974delegate() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new C2163gw(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // me.tvspark.AbstractC2310kv
        public String toString() {
            return standardToString();
        }

        @Override // me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate  reason: collision with other method in class */
        public Collection mo4974delegate() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2384mv<K> {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public Set<K> mo4974delegate() {
            return AbstractBiMap.this.delegate.keySet();
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new C2126fw(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            AbstractBiMap.this.removeFromBothMaps(obj);
            return true;
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2384mv<Map.Entry<K, V>> {
        public final Set<Map.Entry<K, V>> Wwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = AbstractBiMap.this.delegate.entrySet();
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Set<Map.Entry<K, V>> set = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            return set.contains(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map.Entry) obj));
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public Object mo4974delegate() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public Set<Map.Entry<K, V>> mo4974delegate() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractBiMap.this.entrySetIterator();
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwww.contains(obj)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            AbstractBiMap.this.inverse.delegate.remove(entry.getValue());
            this.Wwwwwwwwwwwwwwwwwwwwwwww.remove(entry);
            return true;
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate  reason: collision with other method in class */
        public Collection mo4974delegate() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2199hv<K, V> {
        public final Map.Entry<K, V> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map.Entry<K, V> entry) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = entry;
        }

        @Override // me.tvspark.AbstractC2199hv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public Object mo4974delegate() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2199hv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate  reason: collision with other method in class */
        public Map.Entry<K, V> mo4974delegate() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2199hv, java.util.Map.Entry
        public V setValue(V v) {
            AbstractBiMap.this.checkValue(v);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v, getValue())) {
                return v;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!AbstractBiMap.this.containsValue(v), "value already present: %s", v);
            V value = this.Wwwwwwwwwwwwwwwwwwwwwwww.setValue(v);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.updateInverseMap(getKey(), true, value, v);
            return value;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<Map.Entry<K, V>> {
        public final /* synthetic */ Iterator Wwwwwwwwwwwwwwwwwwwwwww;
        public Map.Entry<K, V> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator it) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            Map.Entry<K, V> entry = (Map.Entry) this.Wwwwwwwwwwwwwwwwwwwwwww.next();
            this.Wwwwwwwwwwwwwwwwwwwwwwww = entry;
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry);
        }

        @Override // java.util.Iterator
        public void remove() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww != null, "no calls to next() since the last call to remove()");
            V value = this.Wwwwwwwwwwwwwwwwwwwwwwww.getValue();
            this.Wwwwwwwwwwwwwwwwwwwwwww.remove();
            AbstractBiMap.this.removeFromInverseMap(value);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
        }
    }

    public AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.delegate = map;
        this.inverse = abstractBiMap;
    }

    public /* synthetic */ AbstractBiMap(Map map, AbstractBiMap abstractBiMap, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this(map, abstractBiMap);
    }

    public AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        setDelegates(map, map2);
    }

    private V putInBothMaps(K k, V v, boolean z) {
        checkKey(k);
        checkValue(v);
        boolean containsKey = containsKey(k);
        if (!containsKey || !Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v, get(k))) {
            if (z) {
                mo4713inverse().remove(v);
            } else {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!containsValue(v), "value already present: %s", v);
            }
            V put = this.delegate.put(k, v);
            updateInverseMap(k, containsKey, put, v);
            return put;
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V removeFromBothMaps(Object obj) {
        V remove = this.delegate.remove(obj);
        removeFromInverseMap(remove);
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromInverseMap(V v) {
        this.inverse.delegate.remove(v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInverseMap(K k, boolean z, V v, V v2) {
        if (z) {
            removeFromInverseMap(v);
        }
        this.inverse.delegate.put(v2, k);
    }

    public K checkKey(K k) {
        return k;
    }

    public V checkValue(V v) {
        return v;
    }

    @Override // me.tvspark.AbstractC2162gv, java.util.Map
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override // me.tvspark.AbstractC2162gv, java.util.Map
    public boolean containsValue(Object obj) {
        return this.inverse.containsKey(obj);
    }

    @Override // me.tvspark.AbstractC2162gv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public Map<K, V> mo4974delegate() {
        return this.delegate;
    }

    @Override // me.tvspark.AbstractC2162gv, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            this.entrySet = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return set;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.delegate.entrySet().iterator());
    }

    @Override // me.tvspark.AbstractC2648tu
    public V forcePut(K k, V v) {
        return putInBothMaps(k, v, true);
    }

    @Override // me.tvspark.AbstractC2648tu
    /* renamed from: inverse */
    public AbstractC2648tu<V, K> mo4713inverse() {
        return this.inverse;
    }

    @Override // me.tvspark.AbstractC2162gv, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            this.keySet = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return set;
    }

    public AbstractBiMap<V, K> makeInverse(Map<V, K> map) {
        return new Inverse(map, this);
    }

    @Override // me.tvspark.AbstractC2162gv, java.util.Map
    public V put(K k, V v) {
        return putInBothMaps(k, v, false);
    }

    @Override // me.tvspark.AbstractC2162gv, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // me.tvspark.AbstractC2162gv, java.util.Map
    public V remove(Object obj) {
        if (containsKey(obj)) {
            return removeFromBothMaps(obj);
        }
        return null;
    }

    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        boolean z = true;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.delegate == null);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.inverse == null);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map.isEmpty());
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map2.isEmpty());
        if (map == map2) {
            z = false;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        this.delegate = map;
        this.inverse = makeInverse(map2);
    }

    public void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    @Override // me.tvspark.AbstractC2162gv, java.util.Map, me.tvspark.AbstractC2648tu
    /* renamed from: values  reason: collision with other method in class */
    public Set<V> mo4672values() {
        Set<V> set = this.valueSet;
        if (set == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            this.valueSet = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return set;
    }
}
