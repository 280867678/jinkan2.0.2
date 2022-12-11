package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import me.tvspark.AbstractC2272ju;
import me.tvspark.AbstractC2648tu;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements AbstractC2648tu<K, V>, Serializable {
    public static final int ABSENT = -1;
    public static final int ENDPOINT = -2;
    public transient Set<Map.Entry<K, V>> entrySet;
    public transient int firstInInsertionOrder;
    public transient int[] hashTableKToV;
    public transient int[] hashTableVToK;
    public transient AbstractC2648tu<V, K> inverse;
    public transient Set<K> keySet;
    public transient K[] keys;
    public transient int lastInInsertionOrder;
    public transient int modCount;
    public transient int[] nextInBucketKToV;
    public transient int[] nextInBucketVToK;
    public transient int[] nextInInsertionOrder;
    public transient int[] prevInInsertionOrder;
    public transient int size;
    public transient Set<V> valueSet;
    public transient V[] values;

    /* loaded from: classes3.dex */
    public static class Inverse<K, V> extends AbstractMap<V, K> implements AbstractC2648tu<V, K>, Serializable {
        public final HashBiMap<K, V> forward;
        public transient Set<Map.Entry<V, K>> inverseEntrySet;

        public Inverse(HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.forward.inverse = this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.forward.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            return this.forward.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.inverseEntrySet;
            if (set == null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.forward);
                this.inverseEntrySet = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return set;
        }

        @Override // me.tvspark.AbstractC2648tu
        public K forcePut(V v, K k) {
            return this.forward.putInverse(v, k, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K get(Object obj) {
            return this.forward.getInverse(obj);
        }

        @Override // me.tvspark.AbstractC2648tu
        /* renamed from: inverse */
        public AbstractC2648tu<K, V> mo4713inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.forward.mo4672values();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K put(V v, K k) {
            return this.forward.putInverse(v, k, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K remove(Object obj) {
            return this.forward.removeInverse(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.size;
        }

        @Override // java.util.AbstractMap, java.util.Map, me.tvspark.AbstractC2648tu
        /* renamed from: values  reason: collision with other method in class */
        public Set<K> mo4672values() {
            return this.forward.keySet();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, T> extends AbstractSet<T> {
        public final HashBiMap<K, V> Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<T> {
            public int Wwwwwwwwwwwwwwwwwwwww;
            public int Wwwwwwwwwwwwwwwwwwwwww;
            public int Wwwwwwwwwwwwwwwwwwwwwww = -1;
            public int Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.firstInInsertionOrder;
                HashBiMap<K, V> hashBiMap = Wwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwww = hashBiMap.modCount;
                this.Wwwwwwwwwwwwwwwwwwwww = hashBiMap.size;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.modCount == this.Wwwwwwwwwwwwwwwwwwwwww) {
                    return this.Wwwwwwwwwwwwwwwwwwwwwwww != -2 && this.Wwwwwwwwwwwwwwwwwwwww > 0;
                }
                throw new ConcurrentModificationException();
            }

            @Override // java.util.Iterator
            public T next() {
                if (hasNext()) {
                    T t = (T) Wwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.nextInInsertionOrder[this.Wwwwwwwwwwwwwwwwwwwwwwww];
                    this.Wwwwwwwwwwwwwwwwwwwww--;
                    return t;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.modCount == this.Wwwwwwwwwwwwwwwwwwwwww) {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww != -1, "no calls to next() since the last call to remove()");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.removeEntry(this.Wwwwwwwwwwwwwwwwwwwwwww);
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.size) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwww = -1;
                    this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.modCount;
                    return;
                }
                throw new ConcurrentModificationException();
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(HashBiMap<K, V> hashBiMap) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = hashBiMap;
        }

        public abstract T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<T> iterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.size;
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, V> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwww
        public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return HashBiMap.this.values[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            int findEntryByValue = HashBiMap.this.findEntryByValue(obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (findEntryByValue != -1) {
                HashBiMap.this.removeEntryValueHashKnown(findEntryByValue, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, K> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwww
        public K Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return HashBiMap.this.keys[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            int findEntryByKey = HashBiMap.this.findEntryByKey(obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (findEntryByKey != -1) {
                HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> extends Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, Map.Entry<V, K>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        @Override // com.google.common.collect.HashBiMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int findEntryByValue = this.Wwwwwwwwwwwwwwwwwwwwwwww.findEntryByValue(key);
                return findEntryByValue != -1 && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.keys[findEntryByValue], value);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(key);
                int findEntryByValue = this.Wwwwwwwwwwwwwwwwwwwwwwww.findEntryByValue(key, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (findEntryByValue == -1 || !Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.keys[findEntryByValue], value)) {
                    return false;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwww.removeEntryValueHashKnown(findEntryByValue, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V, Map.Entry<K, V>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int findEntryByKey = HashBiMap.this.findEntryByKey(key);
                return findEntryByKey != -1 && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(value, HashBiMap.this.values[findEntryByKey]);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(key);
                int findEntryByKey = HashBiMap.this.findEntryByKey(key, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (findEntryByKey == -1 || !Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(value, HashBiMap.this.values[findEntryByKey])) {
                    return false;
                }
                HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> extends AbstractC2272ju<V, K> {
        public int Wwwwwwwwwwwwwwwwwwwwww;
        public final V Wwwwwwwwwwwwwwwwwwwwwww;
        public final HashBiMap<K, V> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HashBiMap<K, V> hashBiMap, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = hashBiMap;
            this.Wwwwwwwwwwwwwwwwwwwwwww = hashBiMap.values[i];
            this.Wwwwwwwwwwwwwwwwwwwwww = i;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int i = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (i != -1) {
                HashBiMap<K, V> hashBiMap = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (i <= hashBiMap.size && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, hashBiMap.values[i])) {
                    return;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.findEntryByValue(this.Wwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public V getKey() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public K getValue() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (i == -1) {
                return null;
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.keys[i];
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public K setValue(K k) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (i == -1) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.putInverse(this.Wwwwwwwwwwwwwwwwwwwwwww, k, false);
            }
            K k2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.keys[i];
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k2, k)) {
                return k;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.replaceKeyInEntry(this.Wwwwwwwwwwwwwwwwwwwwww, k, false);
            return k2;
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2272ju<K, V> {
        public int Wwwwwwwwwwwwwwwwwwwwwww;
        public final K Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = HashBiMap.this.keys[i];
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (i != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i <= hashBiMap.size && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hashBiMap.keys[i], this.Wwwwwwwwwwwwwwwwwwwwwwww)) {
                    return;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = HashBiMap.this.findEntryByKey(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public K getKey() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public V getValue() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (i == -1) {
                return null;
            }
            return HashBiMap.this.values[i];
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public V setValue(V v) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (i == -1) {
                return (V) HashBiMap.this.put(this.Wwwwwwwwwwwwwwwwwwwwwwww, v);
            }
            V v2 = HashBiMap.this.values[i];
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v2, v)) {
                return v;
            }
            HashBiMap.this.replaceValueInEntry(this.Wwwwwwwwwwwwwwwwwwwwwww, v, false);
            return v2;
        }
    }

    public HashBiMap(int i) {
        init(i);
    }

    private int bucket(int i) {
        return i & (this.hashTableKToV.length - 1);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    public static <K, V> HashBiMap<K, V> create(int i) {
        return new HashBiMap<>(i);
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }

    public static int[] createFilledWithAbsent(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void deleteFromTableKToV(int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.hashTableKToV;
        if (iArr[bucket] == i) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[bucket] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i3 = iArr[bucket];
        int i4 = this.nextInBucketKToV[i3];
        while (true) {
            int i5 = i4;
            int i6 = i3;
            i3 = i5;
            if (i3 == -1) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected to find entry with key ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.keys[i]);
                throw new AssertionError(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            } else if (i3 == i) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i6] = iArr3[i];
                iArr3[i] = -1;
                return;
            } else {
                i4 = this.nextInBucketKToV[i3];
            }
        }
    }

    private void deleteFromTableVToK(int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.hashTableVToK;
        if (iArr[bucket] == i) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[bucket] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i3 = iArr[bucket];
        int i4 = this.nextInBucketVToK[i3];
        while (true) {
            int i5 = i4;
            int i6 = i3;
            i3 = i5;
            if (i3 == -1) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected to find entry with value ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.values[i]);
                throw new AssertionError(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            } else if (i3 == i) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i6] = iArr3[i];
                iArr3[i] = -1;
                return;
            } else {
                i4 = this.nextInBucketVToK[i3];
            }
        }
    }

    private void ensureCapacity(int i) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr.length, i);
            this.keys = (K[]) Arrays.copyOf(this.keys, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.values = (V[]) Arrays.copyOf(this.values, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        if (this.hashTableKToV.length < i) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            this.hashTableVToK = createFilledWithAbsent(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            for (int i2 = 0; i2 < this.size; i2++) {
                int bucket = bucket(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.keys[i2]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i2] = iArr3[bucket];
                iArr3[bucket] = i2;
                int bucket2 = bucket(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.values[i2]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i2] = iArr5[bucket2];
                iArr5[bucket2] = i2;
            }
        }
    }

    public static int[] expandAndFillWithAbsent(int[] iArr, int i) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i);
        Arrays.fill(copyOf, length, i, -1);
        return copyOf;
    }

    private void insertIntoTableKToV(int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i] = iArr2[bucket];
        iArr2[bucket] = i;
    }

    private void insertIntoTableVToK(int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i] = iArr2[bucket];
        iArr2[bucket] = i;
    }

    private void moveEntryToIndex(int i, int i2) {
        int i3;
        int i4;
        if (i == i2) {
            return;
        }
        int i5 = this.prevInInsertionOrder[i];
        int i6 = this.nextInInsertionOrder[i];
        setSucceeds(i5, i2);
        setSucceeds(i2, i6);
        K[] kArr = this.keys;
        K k = kArr[i];
        V[] vArr = this.values;
        V v = vArr[i];
        kArr[i2] = k;
        vArr[i2] = v;
        int bucket = bucket(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(k));
        int[] iArr = this.hashTableKToV;
        if (iArr[bucket] == i) {
            iArr[bucket] = i2;
        } else {
            int i7 = iArr[bucket];
            int i8 = this.nextInBucketKToV[i7];
            while (true) {
                int i9 = i8;
                i3 = i7;
                i7 = i9;
                if (i7 == i) {
                    break;
                }
                i8 = this.nextInBucketKToV[i7];
            }
            this.nextInBucketKToV[i3] = i2;
        }
        int[] iArr2 = this.nextInBucketKToV;
        iArr2[i2] = iArr2[i];
        iArr2[i] = -1;
        int bucket2 = bucket(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(v));
        int[] iArr3 = this.hashTableVToK;
        if (iArr3[bucket2] == i) {
            iArr3[bucket2] = i2;
        } else {
            int i10 = iArr3[bucket2];
            int i11 = this.nextInBucketVToK[i10];
            while (true) {
                int i12 = i11;
                i4 = i10;
                i10 = i12;
                if (i10 == i) {
                    break;
                }
                i11 = this.nextInBucketVToK[i10];
            }
            this.nextInBucketVToK[i4] = i2;
        }
        int[] iArr4 = this.nextInBucketVToK;
        iArr4[i2] = iArr4[i];
        iArr4[i] = -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        init(16);
        for (int i = 0; i < readInt; i++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void removeEntry(int i, int i2, int i3) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i != -1);
        deleteFromTableKToV(i, i2);
        deleteFromTableVToK(i, i3);
        setSucceeds(this.prevInInsertionOrder[i], this.nextInInsertionOrder[i]);
        moveEntryToIndex(this.size - 1, i);
        K[] kArr = this.keys;
        int i4 = this.size;
        kArr[i4 - 1] = null;
        this.values[i4 - 1] = null;
        this.size = i4 - 1;
        this.modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceKeyInEntry(int i, K k, boolean z) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i != -1);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
        int findEntryByKey = findEntryByKey(k, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        int i2 = this.lastInInsertionOrder;
        int i3 = -2;
        if (findEntryByKey != -1) {
            if (!z) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Key already present in map: ", k));
            }
            i2 = this.prevInInsertionOrder[findEntryByKey];
            i3 = this.nextInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            if (i == this.size) {
                i = findEntryByKey;
            }
        }
        if (i2 == i) {
            i2 = this.prevInInsertionOrder[i];
        } else if (i2 == this.size) {
            i2 = findEntryByKey;
        }
        if (i3 == i) {
            findEntryByKey = this.nextInInsertionOrder[i];
        } else if (i3 != this.size) {
            findEntryByKey = i3;
        }
        setSucceeds(this.prevInInsertionOrder[i], this.nextInInsertionOrder[i]);
        deleteFromTableKToV(i, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.keys[i]));
        this.keys[i] = k;
        insertIntoTableKToV(i, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(k));
        setSucceeds(i2, i);
        setSucceeds(i, findEntryByKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceValueInEntry(int i, V v, boolean z) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i != -1);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(v);
        int findEntryByValue = findEntryByValue(v, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        if (findEntryByValue != -1) {
            if (!z) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Value already present in map: ", v));
            }
            removeEntryValueHashKnown(findEntryByValue, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            if (i == this.size) {
                i = findEntryByValue;
            }
        }
        deleteFromTableVToK(i, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.values[i]));
        this.values[i] = v;
        insertIntoTableVToK(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    private void setSucceeds(int i, int i2) {
        if (i == -2) {
            this.firstInInsertionOrder = i2;
        } else {
            this.nextInInsertionOrder[i] = i2;
        }
        if (i2 == -2) {
            this.lastInInsertionOrder = i;
        } else {
            this.prevInInsertionOrder[i2] = i;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map) this, objectOutputStream);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findEntryByKey(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return findEntryByValue(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.entrySet = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return set;
    }

    public int findEntry(Object obj, int i, int[] iArr, int[] iArr2, Object[] objArr) {
        int i2 = iArr[bucket(i)];
        while (i2 != -1) {
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr[i2], obj)) {
                return i2;
            }
            i2 = iArr2[i2];
        }
        return -1;
    }

    public int findEntryByKey(Object obj) {
        return findEntryByKey(obj, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj));
    }

    public int findEntryByKey(Object obj, int i) {
        return findEntry(obj, i, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    public int findEntryByValue(Object obj) {
        return findEntryByValue(obj, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj));
    }

    public int findEntryByValue(Object obj, int i) {
        return findEntry(obj, i, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    @Override // me.tvspark.AbstractC2648tu
    public V forcePut(K k, V v) {
        return put(k, v, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int findEntryByKey = findEntryByKey(obj);
        if (findEntryByKey == -1) {
            return null;
        }
        return this.values[findEntryByKey];
    }

    public K getInverse(Object obj) {
        int findEntryByValue = findEntryByValue(obj);
        if (findEntryByValue == -1) {
            return null;
        }
        return this.keys[findEntryByValue];
    }

    public void init(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "expectedSize");
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 1.0d);
        this.size = 0;
        this.keys = (K[]) new Object[i];
        this.values = (V[]) new Object[i];
        this.hashTableKToV = createFilledWithAbsent(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        this.hashTableVToK = createFilledWithAbsent(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        this.nextInBucketKToV = createFilledWithAbsent(i);
        this.nextInBucketVToK = createFilledWithAbsent(i);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i);
        this.nextInInsertionOrder = createFilledWithAbsent(i);
    }

    @Override // me.tvspark.AbstractC2648tu
    /* renamed from: inverse */
    public AbstractC2648tu<V, K> mo4713inverse() {
        AbstractC2648tu<V, K> abstractC2648tu = this.inverse;
        if (abstractC2648tu == null) {
            Inverse inverse = new Inverse(this);
            this.inverse = inverse;
            return inverse;
        }
        return abstractC2648tu;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.keySet = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        return put(k, v, false);
    }

    public V put(K k, V v, boolean z) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
        int findEntryByKey = findEntryByKey(k, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        if (findEntryByKey != -1) {
            V v2 = this.values[findEntryByKey];
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v2, v)) {
                return v;
            }
            replaceValueInEntry(findEntryByKey, v, z);
            return v2;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(v);
        int findEntryByValue = findEntryByValue(v, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        if (!z) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(findEntryByValue == -1, "Value already present: %s", v);
        } else if (findEntryByValue != -1) {
            removeEntryValueHashKnown(findEntryByValue, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i = this.size;
        kArr[i] = k;
        this.values[i] = v;
        insertIntoTableKToV(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        insertIntoTableVToK(this.size, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    public K putInverse(V v, K k, boolean z) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(v);
        int findEntryByValue = findEntryByValue(v, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        if (findEntryByValue != -1) {
            K k2 = this.keys[findEntryByValue];
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k2, k)) {
                return k;
            }
            replaceKeyInEntry(findEntryByValue, k, z);
            return k2;
        }
        int i = this.lastInInsertionOrder;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
        int findEntryByKey = findEntryByKey(k, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        if (!z) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(findEntryByKey == -1, "Key already present: %s", k);
        } else if (findEntryByKey != -1) {
            i = this.prevInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i2 = this.size;
        kArr[i2] = k;
        this.values[i2] = v;
        insertIntoTableKToV(i2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        insertIntoTableVToK(this.size, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        int i3 = i == -2 ? this.firstInInsertionOrder : this.nextInInsertionOrder[i];
        setSucceeds(i, this.size);
        setSucceeds(this.size, i3);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        int findEntryByKey = findEntryByKey(obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        if (findEntryByKey == -1) {
            return null;
        }
        V v = this.values[findEntryByKey];
        removeEntryKeyHashKnown(findEntryByKey, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        return v;
    }

    public void removeEntry(int i) {
        removeEntryKeyHashKnown(i, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.keys[i]));
    }

    public void removeEntryKeyHashKnown(int i, int i2) {
        removeEntry(i, i2, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.values[i]));
    }

    public void removeEntryValueHashKnown(int i, int i2) {
        removeEntry(i, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.keys[i]), i2);
    }

    public K removeInverse(Object obj) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        int findEntryByValue = findEntryByValue(obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        if (findEntryByValue == -1) {
            return null;
        }
        K k = this.keys[findEntryByValue];
        removeEntryValueHashKnown(findEntryByValue, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        return k;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map, me.tvspark.AbstractC2648tu
    /* renamed from: values  reason: collision with other method in class */
    public Set<V> mo4672values() {
        Set<V> set = this.valueSet;
        if (set == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.valueSet = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return set;
    }
}
