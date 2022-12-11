package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes3.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Comparator<Comparable> NATURAL_ORDER = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public Comparator<? super K> comparator;
    public LinkedTreeMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww entrySet;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> header;
    public LinkedTreeMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww keySet;
    public int modCount;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> root;
    public int size;

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> implements Map.Entry<K, V> {
        public int Wwwwwwwwwwwwwwwww;
        public V Wwwwwwwwwwwwwwwwww;
        public final K Wwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwww = this;
            this.Wwwwwwwwwwwwwwwwwwwww = this;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, K k, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwww = k;
            this.Wwwwwwwwwwwwwwwww = 1;
            this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwww = this;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwww = this;
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
                V v = this.Wwwwwwwwwwwwwwwwww;
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
            return this.Wwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.Wwwwwwwwwwwwwwwwwww;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.Wwwwwwwwwwwwwwwwww;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.Wwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwww = v;
            return v2;
        }

        public String toString() {
            return this.Wwwwwwwwwwwwwwwwwww + "=" + this.Wwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements Iterator<T> {
        public int Wwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwww = null;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = linkedTreeMap.header.Wwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = linkedTreeMap.modCount;
        }

        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != linkedTreeMap.header) {
                if (linkedTreeMap.modCount != this.Wwwwwwwwwwwwwwwwwwwwww) {
                    throw new ConcurrentModificationException();
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww != LinkedTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                LinkedTreeMap.this.removeInternal(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
                this.Wwwwwwwwwwwwwwwwwwwwwww = null;
                this.Wwwwwwwwwwwwwwwwwwwwww = LinkedTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractSet<K> {

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends LinkedTreeMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwww;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractSet<Map.Entry<K, V>> {

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends LinkedTreeMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Map.Entry<K, V>> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> findByEntry;
            if ((obj instanceof Map.Entry) && (findByEntry = LinkedTreeMap.this.findByEntry((Map.Entry) obj)) != null) {
                LinkedTreeMap.this.removeInternal(findByEntry, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Comparator<Comparable> {
        @Override // java.util.Comparator
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z) {
        while (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
            int i = 0;
            int i2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwww : 0;
            int i3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwww : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwww;
                int i5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwww : 0;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
                    i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwww;
                }
                int i6 = i - i5;
                if (i6 != -1 && (i6 != 0 || z)) {
                    rotateRight(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                }
                rotateLeft(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww;
                int i7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwww : 0;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 != null) {
                    i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwww;
                }
                int i8 = i - i7;
                if (i8 != 1 && (i8 != 0 || z)) {
                    rotateLeft(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                }
                rotateRight(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    private void replaceInParent(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = null;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null) {
            this.root = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        } else {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
    }

    private void rotateLeft(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        replaceInParent(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        int i = 0;
        int max = Math.max(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwww : 0, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwww : 0) + 1;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww = max;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null) {
            i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwww;
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwww = Math.max(max, i) + 1;
    }

    private void rotateRight(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        replaceInParent(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i = 0;
        int max = Math.max(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwww : 0, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwww : 0) + 1;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww = max;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
            i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwww;
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwww = Math.max(max, i) + 1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.header;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.entrySet;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        LinkedTreeMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.entrySet = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> find(K k, boolean z) {
        int i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Comparator<? super K> comparator = this.comparator;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.root;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                Object obj = (K) wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwww;
                i = comparable != null ? comparable.compareTo(obj) : comparator.compare(k, obj);
                if (i == 0) {
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = i < 0 ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww : wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null) {
                    break;
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            }
        } else {
            i = 0;
        }
        if (!z) {
            return null;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = this.header;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, k, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwww);
            if (i < 0) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            rebalance(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, true);
        } else if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        } else {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, k, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwww);
            this.root = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        this.size++;
        this.modCount++;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> findByEntry(Map.Entry<?, ?> entry) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.Wwwwwwwwwwwwwwwwww, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> findByObject(Object obj) {
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
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.Wwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.keySet;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        LinkedTreeMap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.keySet = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> find = find(k, true);
            V v2 = find.Wwwwwwwwwwwwwwwwww;
            find.Wwwwwwwwwwwwwwwwww = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.Wwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    public void removeInternal(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        int i;
        if (z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = 0;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == null || wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 == null) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null) {
                replaceInParent(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = null;
            } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 != null) {
                replaceInParent(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = null;
            } else {
                replaceInParent(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null);
            }
            rebalance(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwww > wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwww) {
            do {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwww;
            } while (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null);
        } else {
            do {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwww;
            } while (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 != null);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        removeInternal(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, false);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 != null) {
            i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww8;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = null;
        } else {
            i = 0;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 != null) {
            i2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.Wwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww9;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = null;
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwww = Math.max(i, i2) + 1;
        replaceInParent(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
    }

    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> removeInternalByKey(Object obj) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> findByObject = findByObject(obj);
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
