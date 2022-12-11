package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2309ku;
import me.tvspark.AbstractC2422nw;
import me.tvspark.AbstractC2614sx;
import me.tvspark.AbstractC2839yw;
import me.tvspark.C2053dx;
import me.tvspark.C2539qw;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class AbstractMapBasedMultimap<K, V> extends AbstractC2309ku<K, V> implements Serializable {
    public static final long serialVersionUID = 2447537837011683357L;
    public transient Map<K, Collection<V>> map;
    public transient int totalSize;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwww extends AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww implements SortedSet<V> {
        public Wwwwwwwwwwwwwwwwwwww(K k, SortedSet<V> sortedSet, AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww) {
            super(k, sortedSet, wwwwwwwwwwwwwwwwwwwwwwww);
        }

        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public SortedSet<V> mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return (SortedSet) this.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.SortedSet
        public Comparator<? super V> comparator() {
            return mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().comparator();
        }

        @Override // java.util.SortedSet
        public V first() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().first();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> headSet(V v) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            K k = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            SortedSet<V> headSet = mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().headSet(v);
            AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwww == null) {
                wwwwwwwwwwwwwwwwwwwwwwww = this;
            }
            return new Wwwwwwwwwwwwwwwwwwww(k, headSet, wwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // java.util.SortedSet
        public V last() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().last();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> subSet(V v, V v2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            K k = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            SortedSet<V> subSet = mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().subSet(v, v2);
            AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwww == null) {
                wwwwwwwwwwwwwwwwwwwwwwww = this;
            }
            return new Wwwwwwwwwwwwwwwwwwww(k, subSet, wwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(V v) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            K k = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            SortedSet<V> tailSet = mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().tailSet(v);
            AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwww == null) {
                wwwwwwwwwwwwwwwwwwwwwwww = this;
            }
            return new Wwwwwwwwwwwwwwwwwwww(k, tailSet, wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwww extends AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww implements Set<V> {
        public Wwwwwwwwwwwwwwwwwwwww(K k, Set<V> set) {
            super(k, set, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwww, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) this.Wwwwwwwwwwwwwwwwwwwwwww, collection);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                int size2 = this.Wwwwwwwwwwwwwwwwwwwwwww.size();
                AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
                abstractMapBasedMultimap.totalSize = (size2 - size) + abstractMapBasedMultimap.totalSize;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwww extends AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwww implements NavigableSet<V> {
        public Wwwwwwwwwwwwwwwwwwwwww(K k, NavigableSet<V> navigableSet, AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww) {
            super(k, navigableSet, wwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public NavigableSet<V> mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return (NavigableSet) ((SortedSet) this.Wwwwwwwwwwwwwwwwwwwwwww);
        }

        public final NavigableSet<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NavigableSet<V> navigableSet) {
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            K k = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwww == null) {
                wwwwwwwwwwwwwwwwwwwwwwww = this;
            }
            return new Wwwwwwwwwwwwwwwwwwwwww(k, navigableSet, wwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // java.util.NavigableSet
        public V ceiling(V v) {
            return mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().ceiling(v);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().descendingSet());
        }

        @Override // java.util.NavigableSet
        public V floor(V v) {
            return mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().floor(v);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(V v, boolean z) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().headSet(v, z));
        }

        @Override // java.util.NavigableSet
        public V higher(V v) {
            return mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().higher(v);
        }

        @Override // java.util.NavigableSet
        public V lower(V v) {
            return mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().lower(v);
        }

        @Override // java.util.NavigableSet
        public V pollFirst() {
            return (V) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<Object>) iterator());
        }

        @Override // java.util.NavigableSet
        public V pollLast() {
            return (V) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<Object>) descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(V v, boolean z, V v2, boolean z2) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().subSet(v, z, v2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(V v, boolean z) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().tailSet(v, z));
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwww extends AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww implements List<V> {

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ListIterator<V> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                super();
            }

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
                super(((List) Wwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwww).listIterator(i));
            }

            public final ListIterator<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return (ListIterator) this.Wwwwwwwwwwwwwwwwwwwwwwww;
            }

            @Override // java.util.ListIterator
            public void add(V v) {
                boolean isEmpty = Wwwwwwwwwwwwwwwwwwwwwww.this.isEmpty();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().add(v);
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    Wwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().set(v);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwww(K k, List<V> list, AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww) {
            super(k, list, wwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // java.util.List
        public void add(int i, V v) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            boolean isEmpty = this.Wwwwwwwwwwwwwwwwwwwwwww.isEmpty();
            ((List) this.Wwwwwwwwwwwwwwwwwwwwwww).add(i, v);
            AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
            if (isEmpty) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = ((List) this.Wwwwwwwwwwwwwwwwwwwwwww).addAll(i, collection);
            if (addAll) {
                int size2 = this.Wwwwwwwwwwwwwwwwwwwwwww.size();
                AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
                abstractMapBasedMultimap.totalSize = (size2 - size) + abstractMapBasedMultimap.totalSize;
                if (size == 0) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
            return addAll;
        }

        @Override // java.util.List
        public V get(int i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return (V) ((List) this.Wwwwwwwwwwwwwwwwwwwwwww).get(i);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return ((List) this.Wwwwwwwwwwwwwwwwwwwwwww).indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return ((List) this.Wwwwwwwwwwwwwwwwwwwwwww).lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }

        @Override // java.util.List
        public V remove(int i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            V v = (V) ((List) this.Wwwwwwwwwwwwwwwwwwwwwww).remove(i);
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return v;
        }

        @Override // java.util.List
        public V set(int i, V v) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return (V) ((List) this.Wwwwwwwwwwwwwwwwwwwwwww).set(i, v);
        }

        @Override // java.util.List
        public List<V> subList(int i, int i2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            K k = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            List<V> subList = ((List) this.Wwwwwwwwwwwwwwwwwwwwwww).subList(i, i2);
            AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwww == null) {
                wwwwwwwwwwwwwwwwwwwwwwww = this;
            }
            return abstractMapBasedMultimap.wrapList(k, subList, wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwww extends AbstractCollection<V> {
        public final Collection<V> Wwwwwwwwwwwwwwwwwwwww;
        public final AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
        public Collection<V> Wwwwwwwwwwwwwwwwwwwwwww;
        public final K Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<V> {
            public final Collection<V> Wwwwwwwwwwwwwwwwwwwwwww;
            public final Iterator<V> Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = AbstractMapBasedMultimap.iteratorOrListIterator(Wwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwww);
            }

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator<V> it) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = it;
            }

            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                Wwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (Wwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwww) {
                    return;
                }
                throw new ConcurrentModificationException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.remove();
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                Wwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwww(K k, Collection<V> collection, AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = k;
            this.Wwwwwwwwwwwwwwwwwwwwwww = collection;
            this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwww == null ? null : wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else if (!this.Wwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            } else {
                AbstractMapBasedMultimap.this.map.remove(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Collection<V> collection;
            AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww != this.Wwwwwwwwwwwwwwwwwwwww) {
                    throw new ConcurrentModificationException();
                }
            } else if (!this.Wwwwwwwwwwwwwwwwwwwwwww.isEmpty() || (collection = (Collection) AbstractMapBasedMultimap.this.map.get(this.Wwwwwwwwwwwwwwwwwwwwwwww)) == null) {
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwww = collection;
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else {
                AbstractMapBasedMultimap.this.map.put(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            boolean isEmpty = this.Wwwwwwwwwwwwwwwwwwwwwww.isEmpty();
            boolean add = this.Wwwwwwwwwwwwwwwwwwwwwww.add(v);
            if (add) {
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.Wwwwwwwwwwwwwwwwwwwwwww.addAll(collection);
            if (addAll) {
                int size2 = this.Wwwwwwwwwwwwwwwwwwwwwww.size();
                AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
                abstractMapBasedMultimap.totalSize = (size2 - size) + abstractMapBasedMultimap.totalSize;
                if (size == 0) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
            return addAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
            AbstractMapBasedMultimap.this.totalSize -= size;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this.Wwwwwwwwwwwwwwwwwwwwwww.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this.Wwwwwwwwwwwwwwwwwwwwwww.containsAll(collection);
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this.Wwwwwwwwwwwwwwwwwwwwwww.equals(obj);
        }

        @Override // java.util.Collection
        public int hashCode() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this.Wwwwwwwwwwwwwwwwwwwwwww.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            boolean remove = this.Wwwwwwwwwwwwwwwwwwwwwww.remove(obj);
            if (remove) {
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.Wwwwwwwwwwwwwwwwwwwwwww.removeAll(collection);
            if (removeAll) {
                int size2 = this.Wwwwwwwwwwwwwwwwwwwwwww.size();
                AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
                abstractMapBasedMultimap.totalSize = (size2 - size) + abstractMapBasedMultimap.totalSize;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            if (collection != null) {
                int size = size();
                boolean retainAll = this.Wwwwwwwwwwwwwwwwwwwwwww.retainAll(collection);
                if (retainAll) {
                    int size2 = this.Wwwwwwwwwwwwwwwwwwwwwww.size();
                    AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
                    abstractMapBasedMultimap.totalSize = (size2 - size) + abstractMapBasedMultimap.totalSize;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                return retainAll;
            }
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this.Wwwwwwwwwwwwwwwwwwwwwww.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this.Wwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwww extends AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SortedSet<K> {
        public Wwwwwwwwwwwwwwwwwwwwwwwww(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public SortedMap<K, Collection<V>> mo4478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return (SortedMap) this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return mo4478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return mo4478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().firstKey();
        }

        @Override // java.util.SortedSet
        public SortedSet<K> headSet(K k) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwww(mo4478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return mo4478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().lastKey();
        }

        @Override // java.util.SortedSet
        public SortedSet<K> subSet(K k, K k2) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwww(mo4478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().subMap(k, k2));
        }

        @Override // java.util.SortedSet
        public SortedSet<K> tailSet(K k) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwww(mo4478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().tailMap(k));
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SortedMap<K, Collection<V>> {
        public SortedSet<K> Wwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwww(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public SortedMap<K, Collection<V>> mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return (SortedMap) this.Wwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2839yw
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
        public SortedSet<K> mo4480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwww(mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().firstKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, Collection<V>> headMap(K k) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwww(mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().headMap(k));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2839yw, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* renamed from: keySet  reason: collision with other method in class */
        public SortedSet<K> mo4481keySet() {
            SortedSet<K> sortedSet = this.Wwwwwwwwwwwwwwwwwww;
            if (sortedSet == null) {
                SortedSet<K> mo4480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mo4480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwwwwwww = mo4480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return mo4480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return sortedSet;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwww(mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().subMap(k, k2));
        }

        @Override // java.util.SortedMap
        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwww(mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().tailMap(k));
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwww implements RandomAccess {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, List<V> list, AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww) {
            super(k, list, wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwww implements NavigableSet<K> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public NavigableMap<K, Collection<V>> mo4478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return (NavigableMap) ((SortedMap) this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return mo4478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().ceilingKey(k);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) descendingSet()).iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().descendingMap());
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return mo4478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().floorKey(k);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().headMap(k, z));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwwww, java.util.SortedSet
        public SortedSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return mo4478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().higherKey(k);
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return mo4478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<Object>) iterator());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<Object>) descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().subMap(k, z, k2, z2));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwwww, java.util.SortedSet
        public SortedSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().tailMap(k, z));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwwww, java.util.SortedSet
        public SortedSet tailSet(Object obj) {
            return tailSet(obj, true);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwww implements NavigableMap<K, Collection<V>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public NavigableMap<K, Collection<V>> mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return (NavigableMap) ((SortedMap) this.Wwwwwwwwwwwwwwwwwwwww);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2839yw
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public Set mo4480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }

        public Map.Entry<K, Collection<V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> mo4791createCollection = AbstractMapBasedMultimap.this.mo4791createCollection();
            mo4791createCollection.addAll(next.getValue());
            it.remove();
            return new ImmutableEntry(next.getKey(), AbstractMapBasedMultimap.this.mo4496unmodifiableCollectionSubclass(mo4791createCollection));
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k) {
            Map.Entry<K, Collection<V>> ceilingEntry = mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().ceilingEntry(k);
            if (ceilingEntry == null) {
                return null;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ceilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) descendingMap()).navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> firstEntry = mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(firstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k) {
            Map.Entry<K, Collection<V>> floorEntry = mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().floorEntry(k);
            if (floorEntry == null) {
                return null;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().floorKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k, boolean z) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().headMap(k, z));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwww, java.util.SortedMap
        public SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k) {
            Map.Entry<K, Collection<V>> higherEntry = mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().higherEntry(k);
            if (higherEntry == null) {
                return null;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(higherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().higherKey(k);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwww, com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2839yw, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* renamed from: keySet */
        public NavigableSet<K> mo4481keySet() {
            SortedSet<K> sortedSet = this.Wwwwwwwwwwwwwwwwwww;
            if (sortedSet == null) {
                sortedSet = mo4480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwwwwwww = sortedSet;
            }
            return (NavigableSet) sortedSet;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> lastEntry = mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k) {
            Map.Entry<K, Collection<V>> lowerEntry = mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().lowerEntry(k);
            if (lowerEntry == null) {
                return null;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().lowerKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return mo4481keySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((AbstractC2839yw) descendingMap()).entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k, boolean z, K k2, boolean z2) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().subMap(k, z, k2, z2));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwww, java.util.SortedMap
        public SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().tailMap(k, z));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwww, java.util.SortedMap
        public SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2839yw
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
        public SortedSet mo4480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends C2539qw<K, Collection<V>> {

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<K> {
            public final /* synthetic */ Iterator Wwwwwwwwwwwwwwwwwwwwwww;
            public Map.Entry<K, Collection<V>> Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator it) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.Wwwwwwwwwwwwwwwwwwwwwww.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.Wwwwwwwwwwwwwwwwwwwwwww.next();
                this.Wwwwwwwwwwwwwwwwwwwwwwww = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww != null, "no calls to next() since the last call to remove()");
                Collection<V> value = this.Wwwwwwwwwwwwwwwwwwwwwwww.getValue();
                this.Wwwwwwwwwwwwwwwwwwwwwww.remove();
                AbstractMapBasedMultimap.this.totalSize -= value.size();
                value.clear();
                this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // me.tvspark.C2539qw, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || this.Wwwwwwwwwwwwwwwwwwwwwwww.keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.keySet().hashCode();
        }

        @Override // me.tvspark.C2539qw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.entrySet().iterator());
        }

        @Override // me.tvspark.C2539qw, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int i;
            Collection collection = (Collection) this.Wwwwwwwwwwwwwwwwwwwwwwww.remove(obj);
            if (collection != null) {
                i = collection.size();
                collection.clear();
                AbstractMapBasedMultimap.this.totalSize -= i;
            } else {
                i = 0;
            }
            return i > 0;
        }
    }

    /* loaded from: classes3.dex */
    public abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements Iterator<T> {
        public final Iterator<Map.Entry<K, Collection<V>>> Wwwwwwwwwwwwwwwwwwwwwwww;
        public K Wwwwwwwwwwwwwwwwwwwwwww = null;
        public Collection<V> Wwwwwwwwwwwwwwwwwwwwww = null;
        public Iterator<V> Wwwwwwwwwwwwwwwwwwwww = Iterators$EmptyModifiableIterator.INSTANCE;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = (Iterator<Map.Entry<K, V>>) AbstractMapBasedMultimap.this.map.entrySet().iterator();
        }

        public abstract T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, V v);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.hasNext() || this.Wwwwwwwwwwwwwwwwwwwww.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.Wwwwwwwwwwwwwwwwwwwww.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.Wwwwwwwwwwwwwwwwwwwwwwww.next();
                this.Wwwwwwwwwwwwwwwwwwwwwww = next.getKey();
                Collection<V> value = next.getValue();
                this.Wwwwwwwwwwwwwwwwwwwwww = value;
                this.Wwwwwwwwwwwwwwwwwwwww = value.iterator();
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.Wwwwwwwwwwwwwwwwwwwww.remove();
            if (this.Wwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.remove();
            }
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2839yw<K, Collection<V>> {
        public final transient Map<K, Collection<V>> Wwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<Map.Entry<K, Collection<V>>> {
            public Collection<V> Wwwwwwwwwwwwwwwwwwwwwww;
            public final Iterator<Map.Entry<K, Collection<V>>> Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwww.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Map.Entry<K, Collection<V>> next = this.Wwwwwwwwwwwwwwwwwwwwwwww.next();
                this.Wwwwwwwwwwwwwwwwwwwwwww = next.getValue();
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next);
            }

            @Override // java.util.Iterator
            public void remove() {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww != null, "no calls to next() since the last call to remove()");
                this.Wwwwwwwwwwwwwwwwwwwwwwww.remove();
                AbstractMapBasedMultimap.this.totalSize -= this.Wwwwwwwwwwwwwwwwwwwwwww.size();
                this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
                this.Wwwwwwwwwwwwwwwwwwwwwww = null;
            }
        }

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2422nw<K, Collection<V>> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // me.tvspark.AbstractC2422nw
            public Map<K, Collection<V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
            }

            @Override // me.tvspark.AbstractC2422nw, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwww.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }

            @Override // me.tvspark.AbstractC2422nw, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwww.entrySet(), obj)) {
                    return false;
                }
                AbstractMapBasedMultimap.this.removeValuesForKey(((Map.Entry) obj).getKey());
                return true;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map<K, Collection<V>> map) {
            this.Wwwwwwwwwwwwwwwwwwwww = map;
        }

        public Map.Entry<K, Collection<V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return new ImmutableEntry(key, AbstractMapBasedMultimap.this.wrapCollection(key, entry.getValue()));
        }

        @Override // me.tvspark.AbstractC2839yw
        public Set<Map.Entry<K, Collection<V>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.Wwwwwwwwwwwwwwwwwwwww == AbstractMapBasedMultimap.this.map) {
                AbstractMapBasedMultimap.this.clear();
                return;
            }
            Iterator<Map.Entry<K, Collection<V>>> it = this.Wwwwwwwwwwwwwwwwwwwww.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<K, Collection<V>> next = it.next();
                Collection<V> value = next.getValue();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(value != null, "no calls to next() since the last call to remove()");
                it.remove();
                AbstractMapBasedMultimap.this.totalSize -= value.size();
                value.clear();
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map<?, ?>) this.Wwwwwwwwwwwwwwwwwwwww, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.Wwwwwwwwwwwwwwwwwwwww.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Collection<V> collection = (Collection) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.wrapCollection(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.Wwwwwwwwwwwwwwwwwwwww.hashCode();
        }

        @Override // me.tvspark.AbstractC2839yw, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* renamed from: keySet */
        public Set<K> mo4481keySet() {
            return AbstractMapBasedMultimap.this.mo4794keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            Collection<V> remove = this.Wwwwwwwwwwwwwwwwwwwww.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> mo4791createCollection = AbstractMapBasedMultimap.this.mo4791createCollection();
            mo4791createCollection.addAll(remove);
            AbstractMapBasedMultimap.this.totalSize -= remove.size();
            remove.clear();
            return mo4791createCollection;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.Wwwwwwwwwwwwwwwwwwwww.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.Wwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Map.Entry<K, V>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) {
            return new ImmutableEntry(obj, obj2);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<V> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, V v) {
            return v;
        }
    }

    public AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map.isEmpty());
        this.map = map;
    }

    public static /* synthetic */ int access$208(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i + 1;
        return i;
    }

    public static /* synthetic */ int access$210(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i - 1;
        return i;
    }

    private Collection<V> getOrCreateCollection(K k) {
        Collection<V> collection = this.map.get(k);
        if (collection == null) {
            Collection<V> createCollection = createCollection(k);
            this.map.put(k, createCollection);
            return createCollection;
        }
        return collection;
    }

    public static <E> Iterator<E> iteratorOrListIterator(Collection<E> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeValuesForKey(Object obj) {
        Map<K, Collection<V>> map = this.map;
        Collection<V> collection = null;
        if (map != null) {
            try {
                collection = map.remove(obj);
            } catch (ClassCastException | NullPointerException unused) {
            }
            Collection<V> collection2 = collection;
            if (collection2 == null) {
                return;
            }
            int size = collection2.size();
            collection2.clear();
            this.totalSize -= size;
            return;
        }
        throw null;
    }

    /* renamed from: backingMap */
    public Map<K, Collection<V>> mo4489backingMap() {
        return this.map;
    }

    @Override // me.tvspark.AbstractC2876zw
    public void clear() {
        for (Collection<V> collection : this.map.values()) {
            collection.clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // me.tvspark.AbstractC2876zw
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // me.tvspark.AbstractC2309ku
    public Map<K, Collection<V>> createAsMap() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.map);
    }

    /* renamed from: createCollection */
    public abstract Collection<V> mo4791createCollection();

    public Collection<V> createCollection(K k) {
        return mo4791createCollection();
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: createEntries */
    public Collection<Map.Entry<K, V>> mo4647createEntries() {
        return this instanceof AbstractC2614sx ? new AbstractC2309ku.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this) : new AbstractC2309ku.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2309ku
    public Set<K> createKeySet() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.map);
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: createKeys */
    public AbstractC2090ex<K> mo4560createKeys() {
        return new C2053dx(this);
    }

    public final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        Map<K, Collection<V>> map = this.map;
        return map instanceof NavigableMap ? new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww((NavigableMap) this.map) : map instanceof SortedMap ? new Wwwwwwwwwwwwwwwwwwwwwwwwww((SortedMap) this.map) : new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.map);
    }

    public final Set<K> createMaybeNavigableKeySet() {
        Map<K, Collection<V>> map = this.map;
        return map instanceof NavigableMap ? new Wwwwwwwwwwwwwwwwwwwwwwwwwwww((NavigableMap) this.map) : map instanceof SortedMap ? new Wwwwwwwwwwwwwwwwwwwwwwwww((SortedMap) this.map) : new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.map);
    }

    /* renamed from: createUnmodifiableEmptyCollection */
    public Collection<V> mo4492createUnmodifiableEmptyCollection() {
        return (Collection<V>) mo4496unmodifiableCollectionSubclass(mo4791createCollection());
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: createValues */
    public Collection<V> mo4648createValues() {
        return new AbstractC2309ku.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: entries */
    public Collection<Map.Entry<K, V>> mo4768entries() {
        return super.mo4768entries();
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: entryIterator */
    public Iterator<Map.Entry<K, V>> mo4563entryIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: get */
    public Collection<V> mo4793get(K k) {
        Collection<V> collection = this.map.get(k);
        if (collection == null) {
            collection = createCollection(k);
        }
        return wrapCollection(k, collection);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    public boolean put(K k, V v) {
        Collection<V> collection = this.map.get(k);
        if (collection != null) {
            if (!collection.add(v)) {
                return false;
            }
            this.totalSize++;
            return true;
        }
        Collection<V> createCollection = createCollection(k);
        if (!createCollection.add(v)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.totalSize++;
        this.map.put(k, createCollection);
        return true;
    }

    @Override // me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: removeAll */
    public Collection<V> mo4778removeAll(Object obj) {
        Collection<V> remove = this.map.remove(obj);
        if (remove == null) {
            return mo4492createUnmodifiableEmptyCollection();
        }
        Collection mo4791createCollection = mo4791createCollection();
        mo4791createCollection.addAll(remove);
        this.totalSize -= remove.size();
        remove.clear();
        return (Collection<V>) mo4496unmodifiableCollectionSubclass(mo4791createCollection);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw, me.tvspark.AbstractC1998cw
    /* renamed from: replaceValues */
    public Collection<V> mo4779replaceValues(K k, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return mo4778removeAll(k);
        }
        Collection<V> orCreateCollection = getOrCreateCollection(k);
        Collection mo4791createCollection = mo4791createCollection();
        mo4791createCollection.addAll(orCreateCollection);
        this.totalSize -= orCreateCollection.size();
        orCreateCollection.clear();
        while (it.hasNext()) {
            if (orCreateCollection.add(it.next())) {
                this.totalSize++;
            }
        }
        return (Collection<V>) mo4496unmodifiableCollectionSubclass(mo4791createCollection);
    }

    public final void setMap(Map<K, Collection<V>> map) {
        this.map = map;
        this.totalSize = 0;
        for (Collection<V> collection : map.values()) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!collection.isEmpty());
            this.totalSize = collection.size() + this.totalSize;
        }
    }

    @Override // me.tvspark.AbstractC2876zw
    public int size() {
        return this.totalSize;
    }

    /* renamed from: unmodifiableCollectionSubclass */
    public <E> Collection<E> mo4496unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    @Override // me.tvspark.AbstractC2309ku
    /* renamed from: valueIterator */
    public Iterator<V> mo4569valueIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // me.tvspark.AbstractC2309ku, me.tvspark.AbstractC2876zw
    /* renamed from: values */
    public Collection<V> mo4653values() {
        return super.mo4653values();
    }

    public Collection<V> wrapCollection(K k, Collection<V> collection) {
        return new Wwwwwwwwwwwwwwwwwwwwwwww(k, collection, null);
    }

    public final List<V> wrapList(K k, List<V> list, AbstractMapBasedMultimap<K, V>.Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww) {
        return list instanceof RandomAccess ? new Wwwwwwwwwwwwwwwwwwwwwwwwwww(this, k, list, wwwwwwwwwwwwwwwwwwwwwwww) : new Wwwwwwwwwwwwwwwwwwwwwww(k, list, wwwwwwwwwwwwwwwwwwwwwwww);
    }
}
