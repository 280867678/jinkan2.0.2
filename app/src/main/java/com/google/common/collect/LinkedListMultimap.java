package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import me.tvspark.AbstractC1998cw;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2202hy;
import me.tvspark.AbstractC2272ju;
import me.tvspark.AbstractC2309ku;
import me.tvspark.AbstractC2651tx;
import me.tvspark.AbstractC2876zw;
import me.tvspark.C1925ax;
import me.tvspark.C2053dx;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class LinkedListMultimap<K, V> extends AbstractC2309ku<K, V> implements AbstractC1998cw<K, V>, Serializable {
    public static final long serialVersionUID = 0;
    public transient Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> head;
    public transient Map<K, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>> keyToKeyList;
    public transient int modCount;
    public transient int size;
    public transient Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> tail;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwww implements ListIterator<V> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwww;
        public final Object Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = obj;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) LinkedListMultimap.this.keyToKeyList.get(obj);
            this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? null : wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, int i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) LinkedListMultimap.this.keyToKeyList.get(obj);
            int i2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? 0 : wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
            if (i < i2 / 2) {
                this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? null : wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                while (true) {
                    int i3 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i3;
                }
            } else {
                this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? null : wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwww = i2;
                while (true) {
                    int i4 = i + 1;
                    if (i >= i2) {
                        break;
                    }
                    previous();
                    i = i4;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = obj;
            this.Wwwwwwwwwwwwwwwwwwwww = null;
        }

        @Override // java.util.ListIterator
        public void add(V v) {
            this.Wwwwwwwwwwwwwwwwwwww = LinkedListMultimap.this.addNode(this.Wwwwwwwwwwwwwwwwwwwwwwww, v, this.Wwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww++;
            this.Wwwwwwwwwwwwwwwwwwwww = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwww != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.Wwwwwwwwwwwwwwwwwwww != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            LinkedListMultimap.checkElement(this.Wwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww++;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.ListIterator
        public V previous() {
            LinkedListMultimap.checkElement(this.Wwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww--;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww != null, "no calls to next() since the last call to remove()");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwww != this.Wwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwww--;
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
            }
            LinkedListMultimap.this.removeNode(this.Wwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwww = null;
        }

        @Override // java.util.ListIterator
        public void set(V v) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww != null);
            this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = v;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwww implements ListIterator<Map.Entry<K, V>> {
        public int Wwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwww = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, size);
            if (i < size / 2) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = LinkedListMultimap.this.head;
                while (true) {
                    int i2 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    mo4654next();
                    i = i2;
                }
            } else {
                this.Wwwwwwwwwwwwwwwwwwwww = LinkedListMultimap.this.tail;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = size;
                while (true) {
                    int i3 = i + 1;
                    if (i >= size) {
                        break;
                    }
                    mo4655previous();
                    i = i3;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = null;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (LinkedListMultimap.this.modCount == this.Wwwwwwwwwwwwwwwwwwww) {
                return;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this.Wwwwwwwwwwwwwwwwwwwwwww != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this.Wwwwwwwwwwwwwwwwwwwww != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: next */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> mo4654next() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            LinkedListMultimap.checkElement(this.Wwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwww++;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.ListIterator
        /* renamed from: previous */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> mo4655previous() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            LinkedListMultimap.checkElement(this.Wwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwww--;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww != null, "no calls to next() since the last call to remove()");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwww != this.Wwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwww--;
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
            }
            LinkedListMultimap.this.removeNode(this.Wwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwww = LinkedListMultimap.this.modCount;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> extends AbstractC2272ju<K, V> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwww;
        public V Wwwwwwwwwwwwwwwwwwwwwww;
        public final K Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, V v) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = k;
            this.Wwwwwwwwwwwwwwwwwwwwwww = v;
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public K getKey() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public V getValue() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2272ju, java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = v;
            return v2;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww = null;
            wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = null;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<K> {
        public int Wwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwww;
        public final Set<K> Wwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = new HashSet(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LinkedListMultimap.this.mo4794keySet().size()));
            this.Wwwwwwwwwwwwwwwwwwwwwww = LinkedListMultimap.this.head;
            this.Wwwwwwwwwwwwwwwwwwwww = LinkedListMultimap.this.modCount;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (LinkedListMultimap.this.modCount == this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this.Wwwwwwwwwwwwwwwwwwwwwww != null;
        }

        @Override // java.util.Iterator
        public K next() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            LinkedListMultimap.checkElement(this.Wwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww);
            do {
                wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    break;
                }
            } while (!this.Wwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww));
            return this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.Iterator
        public void remove() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww != null, "no calls to next() since the last call to remove()");
            LinkedListMultimap.this.removeAllNodes(this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwww = LinkedListMultimap.this.modCount;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractSequentialList<V> {

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2202hy<Map.Entry<K, V>, V> {
            public final /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ListIterator listIterator, Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                super(listIterator);
                this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww;
            }

            @Override // me.tvspark.AbstractC2165gy
            public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
                return ((Map.Entry) obj).getValue();
            }

            @Override // me.tvspark.AbstractC2202hy, java.util.ListIterator
            public void set(V v) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww != null);
                wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = v;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, wwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2651tx<K> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedListMultimap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return !LinkedListMultimap.this.mo4778removeAll(obj).isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedListMultimap.this.keyToKeyList.size();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractSequentialList<Map.Entry<K, V>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<Map.Entry<K, V>> listIterator(int i) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractSequentialList<V> {
        public final /* synthetic */ Object Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) LinkedListMultimap.this.keyToKeyList.get(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return 0;
            }
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    public LinkedListMultimap() {
        this(12);
    }

    public LinkedListMultimap(int i) {
        this.keyToKeyList = CompactHashMap.createWithExpectedSize(i);
    }

    public LinkedListMultimap(AbstractC2876zw<? extends K, ? extends V> abstractC2876zw) {
        this(abstractC2876zw.mo4794keySet().size());
        putAll(abstractC2876zw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> addNode(K k, V v, Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Map<K, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>> map;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww<>(k, v);
        if (this.head != null) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.tail;
                wwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                wwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                this.tail = wwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.keyToKeyList.get(k);
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                    map = this.keyToKeyList;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(wwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                } else {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
            } else {
                this.keyToKeyList.get(k).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                wwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwww5 == null) {
                    this.keyToKeyList.get(k).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                } else {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww6 = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwww6 == null) {
                    this.head = wwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                } else {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
            this.size++;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        this.tail = wwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        this.head = wwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        map = this.keyToKeyList;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(wwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        map.put(k, wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.modCount++;
        this.size++;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public static void checkElement(Object obj) {
        if (obj != null) {
            return;
        }
        throw new NoSuchElementException();
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i) {
        return new LinkedListMultimap<>(i);
    }

    public static <K, V> LinkedListMultimap<K, V> create(AbstractC2876zw<? extends K, ? extends V> abstractC2876zw) {
        return new LinkedListMultimap<>(abstractC2876zw);
    }

    private List<V> getCopy(Object obj) {
        return Collections.unmodifiableList(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwww(obj)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = CompactLinkedHashMap.create();
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllNodes(Object obj) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) new Wwwwwwwwwwwwwwwwwwwwwwwwww(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNode(Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        } else {
            this.head = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
        } else {
            this.tail = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww == null && wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww == null) {
            this.keyToKeyList.remove(wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.modCount++;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.keyToKeyList.get(wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww--;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwww4 == null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
            } else {
                wwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwww6 = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwww5 == null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww6;
            } else {
                wwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww6;
            }
        }
        this.size--;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : mo4768entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: asMap */
    public /* bridge */ /* synthetic */ Map mo4790asMap() {
        return super.mo4790asMap();
    }

    @Override // me.tvspark.AbstractC2876zw
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean containsKey(Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public boolean containsValue(Object obj) {
        return mo4653values().contains(obj);
    }

    @Override // me.tvspark.AbstractC2309ku
    public Map<K, Collection<V>> createAsMap() {
        return new C1925ax(this);
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: createEntries  reason: collision with other method in class */
    public List<Map.Entry<K, V>> mo4647createEntries() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2309ku
    public Set<K> createKeySet() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: createKeys */
    public AbstractC2090ex<K> mo4560createKeys() {
        return new C2053dx(this);
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: createValues  reason: collision with other method in class */
    public List<V> mo4648createValues() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: entries  reason: collision with other method in class */
    public List<Map.Entry<K, V>> mo4768entries() {
        return (List) super.mo4768entries();
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: entryIterator */
    public Iterator<Map.Entry<K, V>> mo4563entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Collection mo4793get(Object obj) {
        return mo4793get((LinkedListMultimap<K, V>) obj);
    }

    @Override // me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get  reason: collision with other method in class */
    public List<V> mo4793get(K k) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: keySet */
    public /* bridge */ /* synthetic */ Set mo4794keySet() {
        return super.mo4794keySet();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: keys */
    public /* bridge */ /* synthetic */ AbstractC2090ex mo4566keys() {
        return super.mo4566keys();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public boolean put(K k, V v) {
        addNode(k, v, null);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean putAll(AbstractC2876zw abstractC2876zw) {
        return super.putAll(abstractC2876zw);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: removeAll  reason: collision with other method in class */
    public List<V> mo4778removeAll(Object obj) {
        List<V> copy = getCopy(obj);
        removeAllNodes(obj);
        return copy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo4779replaceValues(Object obj, Iterable iterable) {
        return mo4779replaceValues((LinkedListMultimap<K, V>) obj, iterable);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues  reason: collision with other method in class */
    public List<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        List<V> copy = getCopy(k);
        Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwww(k);
        Iterator<? extends V> it = iterable.iterator();
        while (wwwwwwwwwwwwwwwwwwwwwwwwww.hasNext() && it.hasNext()) {
            wwwwwwwwwwwwwwwwwwwwwwwwww.next();
            wwwwwwwwwwwwwwwwwwwwwwwwww.set(it.next());
        }
        while (wwwwwwwwwwwwwwwwwwwwwwwwww.hasNext()) {
            wwwwwwwwwwwwwwwwwwwwwwwwww.next();
            wwwwwwwwwwwwwwwwwwwwwwwwww.remove();
        }
        while (it.hasNext()) {
            wwwwwwwwwwwwwwwwwwwwwwwwww.add(it.next());
        }
        return copy;
    }

    @Override // me.tvspark.AbstractC2876zw
    public int size() {
        return this.size;
    }

    @Override // me.tvspark.AbstractC2309ku
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: values  reason: collision with other method in class */
    public List<V> mo4653values() {
        return (List) super.mo4653values();
    }
}
