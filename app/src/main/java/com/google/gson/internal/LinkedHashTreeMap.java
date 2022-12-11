package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes3.dex */
public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Comparator<Comparable> NATURAL_ORDER = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public Comparator<? super K> comparator;
    public LinkedHashTreeMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww entrySet;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> header;
    public LinkedHashTreeMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww keySet;
    public int modCount;
    public int size;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>[] table;
    public int threshold;

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> implements Map.Entry<K, V> {
        public int Wwwwwwwwwwwwwwww;
        public V Wwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwww;
        public final K Wwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwww = -1;
            this.Wwwwwwwwwwwwwwwwwwww = this;
            this.Wwwwwwwwwwwwwwwwwwwww = this;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww, K k, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwww = k;
            this.Wwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwww = 1;
            this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwww = this;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwww = this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.Wwwwwwwwwwwwwwwwwww;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.Wwwwwwwwwwwwwwwww;
                Object value = entry.getValue();
                if (v == null) {
                    if (value != null) {
                        return false;
                    }
                } else if (!v.equals(value)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.Wwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.Wwwwwwwwwwwwwwwww;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.Wwwwwwwwwwwwwwwwwww;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.Wwwwwwwwwwwwwwwww;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.Wwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwww = v;
            return v2;
        }

        public String toString() {
            return this.Wwwwwwwwwwwwwwwwwww + "=" + this.Wwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements Iterator<T> {
        public int Wwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwww = null;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = linkedHashTreeMap.header.Wwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = linkedHashTreeMap.modCount;
        }

        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != linkedHashTreeMap.header) {
                if (linkedHashTreeMap.modCount != this.Wwwwwwwwwwwwwwwwwwwwww) {
                    throw new ConcurrentModificationException();
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww != LinkedHashTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                LinkedHashTreeMap.this.removeInternal(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
                this.Wwwwwwwwwwwwwwwwwwwwwww = null;
                this.Wwwwwwwwwwwwwwwwwwwwww = LinkedHashTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractSet<K> {

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends LinkedHashTreeMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwww;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractSet<Map.Entry<K, V>> {

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends LinkedHashTreeMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Map.Entry<K, V>> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> findByEntry;
            if ((obj instanceof Map.Entry) && (findByEntry = LinkedHashTreeMap.this.findByEntry((Map.Entry) obj)) != null) {
                LinkedHashTreeMap.this.removeInternal(findByEntry, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = null;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = null;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = null;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww = 1;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i > 0) {
                int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if ((i2 & 1) == 0) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i - 1;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                }
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
            int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i4 > 0 && (i3 & 1) == 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 1;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4 - 1;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
            }
            int i5 = 4;
            while (true) {
                int i6 = i5 - 1;
                if ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & i6) == i6) {
                    int i7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i7 == 0) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwww + 1;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                    } else {
                        if (i7 == 1) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwww;
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww6;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwww + 1;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww6;
                        } else if (i7 != 2) {
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                    }
                    i5 *= 2;
                } else {
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Comparator<Comparable> {
        @Override // java.util.Comparator
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
        this.header = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[16];
        this.table = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
        this.threshold = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length / 4) + (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length / 2);
    }

    private void doubleCapacity() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>[] doubleCapacity = doubleCapacity(this.table);
        this.table = doubleCapacity;
        this.threshold = (doubleCapacity.length / 4) + (doubleCapacity.length / 2);
    }

    public static <K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>[] doubleCapacity(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        int length = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[length * 2];
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        for (int i = 0; i < length; i++) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i];
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = null;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = null;
                for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww4; wwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != null; wwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwwwwwwwww) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww6;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww7;
                }
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww6 != null) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwww = null;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwww;
                        while (true) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww9;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww8;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww10;
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww8 == null) {
                                break;
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwww;
                        }
                    } else {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww6;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = null;
                    }
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww6 == null) {
                        break;
                    }
                    if ((wwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwww & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = null;
                while (wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww11;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                }
                while (true) {
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww11 != null) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww12 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww11.Wwwwwwwwwwwwwwwwwwwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwww11.Wwwwwwwwwwwwwwwwwwwwwwww = null;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww13 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww11.Wwwwwwwwwwwwwwwwwwwwww;
                        while (true) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww14 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww13;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww12;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwww12 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww14;
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww12 == null) {
                                break;
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwww12.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwww13 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww12.Wwwwwwwwwwwwwwwwwwwwwww;
                        }
                    } else {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww11;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = null;
                    }
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww11 == null) {
                        break;
                    }
                    if ((wwwwwwwwwwwwwwwwwwwwwwwwwwwww11.Wwwwwwwwwwwwwwwwww & length) == 0) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwww11);
                    } else {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwww11);
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
                if (i2 > 0) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
                        throw new IllegalStateException();
                    }
                } else {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = null;
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2[i] = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                int i4 = i + length;
                if (i3 > 0) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
                        throw new IllegalStateException();
                    }
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2[i4] = wwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
            }
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2;
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z) {
        while (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
            int i = 0;
            int i2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwww : 0;
            int i3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwww : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwww;
                int i5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwww : 0;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
                    i = wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwww;
                }
                int i6 = i - i5;
                if (i6 != -1 && (i6 != 0 || z)) {
                    rotateRight(wwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                }
                rotateLeft(wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww;
                int i7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwww : 0;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww6 != null) {
                    i = wwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwww;
                }
                int i8 = i - i7;
                if (i8 != 1 && (i8 != 0 || z)) {
                    rotateLeft(wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                }
                rotateRight(wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    private void replaceInParent(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = null;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null) {
            int i = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.table;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i & (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length - 1)] = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        } else {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
    }

    private void rotateLeft(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        replaceInParent(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        int i = 0;
        int max = Math.max(wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwww : 0, wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwww : 0) + 1;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww = max;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null) {
            i = wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwww;
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwww = Math.max(max, i) + 1;
    }

    private void rotateRight(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        replaceInParent(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i = 0;
        int max = Math.max(wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwww : 0, wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwww : 0) + 1;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww = max;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
            i = wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwww;
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwww = Math.max(max, i) + 1;
    }

    public static int secondaryHash(int i) {
        int i2 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.header;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
        while (wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwww = null;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww = null;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.entrySet;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        LinkedHashTreeMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.entrySet = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> find(K k, boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Comparator<? super K> comparator = this.comparator;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.table;
        int secondaryHash = secondaryHash(k.hashCode());
        int length = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length - 1) & secondaryHash;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[length];
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                Object obj = (K) wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwww;
                int compareTo = comparable != null ? comparable.compareTo(obj) : comparator.compare(k, obj);
                if (compareTo == 0) {
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = compareTo < 0 ? wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww : wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == null) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                    i = compareTo;
                    break;
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
            }
        } else {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            i = 0;
        }
        if (!z) {
            return null;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = this.header;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, k, secondaryHash, wwwwwwwwwwwwwwwwwwwwwwwwwwwww5, wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwww);
            if (i < 0) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            } else {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
            rebalance(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
        } else if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        } else {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, k, secondaryHash, wwwwwwwwwwwwwwwwwwwwwwwwwwwww5, wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[length] = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 > this.threshold) {
            doubleCapacity();
        }
        this.modCount++;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> findByEntry(Map.Entry<?, ?> entry) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.Wwwwwwwwwwwwwwwww, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> findByObject(Object obj) {
        if (obj != 0) {
            try {
                return find(obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.Wwwwwwwwwwwwwwwww;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.keySet;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        LinkedHashTreeMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.keySet = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> find = find(k, true);
            V v2 = find.Wwwwwwwwwwwwwwwww;
            find.Wwwwwwwwwwwwwwwww = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.Wwwwwwwwwwwwwwwww;
        }
        return null;
    }

    public void removeInternal(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        int i;
        if (z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = null;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = null;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = 0;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == null || wwwwwwwwwwwwwwwwwwwwwwwwwwwww6 == null) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null) {
                replaceInParent(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = null;
            } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww6 != null) {
                replaceInParent(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = null;
            } else {
                replaceInParent(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, null);
            }
            rebalance(wwwwwwwwwwwwwwwwwwwwwwwwwwwww7, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwww > wwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwww) {
            do {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwww;
            } while (wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null);
        } else {
            do {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww6;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwww;
            } while (wwwwwwwwwwwwwwwwwwwwwwwwwwwww6 != null);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        removeInternal(wwwwwwwwwwwwwwwwwwwwwwwwwwwww3, false);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww8 != null) {
            i = wwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww8;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = null;
        } else {
            i = 0;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww9 != null) {
            i2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww9.Wwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww9;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww9.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = null;
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwww = Math.max(i, i2) + 1;
        replaceInParent(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
    }

    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> removeInternalByKey(Object obj) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }
}
