package me.tvspark;

import com.google.common.collect.Ordering;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

/* renamed from: me.tvspark.mw */
/* loaded from: classes4.dex */
public abstract class AbstractC2385mw<K, V> extends AbstractC2162gv<K, V> implements NavigableMap<K, V> {
    public transient NavigableSet<K> Wwwwwwwwwwwwwwwwwwwwww;
    public transient Set<Map.Entry<K, V>> Wwwwwwwwwwwwwwwwwwwwwww;
    public transient Comparator<? super K> Wwwwwwwwwwwwwwwwwwwwwwww;

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k) {
        return AbstractC2383mu.this.floorEntry(k);
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        return AbstractC2383mu.this.floorKey(k);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        Comparator<? super K> comparator = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (comparator == null) {
            Comparator<? super K> comparator2 = AbstractC2383mu.this.comparator();
            if (comparator2 == null) {
                comparator2 = Ordering.natural();
            }
            Ordering reverse = Ordering.from(comparator2).reverse();
            this.Wwwwwwwwwwwwwwwwwwwwwwww = reverse;
            return reverse;
        }
        return comparator;
    }

    @Override // me.tvspark.AbstractC2162gv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public final Map<K, V> mo4974delegate() {
        return AbstractC2383mu.this;
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return AbstractC2383mu.this.navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return AbstractC2383mu.this;
    }

    @Override // me.tvspark.AbstractC2162gv, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (set == null) {
            C2348lw c2348lw = new C2348lw(this);
            this.Wwwwwwwwwwwwwwwwwwwwwww = c2348lw;
            return c2348lw;
        }
        return set;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return AbstractC2383mu.this.lastEntry();
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return AbstractC2383mu.this.lastKey();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k) {
        return AbstractC2383mu.this.ceilingEntry(k);
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        return AbstractC2383mu.this.ceilingKey(k);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(K k, boolean z) {
        return AbstractC2383mu.this.tailMap(k, z).descendingMap();
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> headMap(K k) {
        return headMap(k, false);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k) {
        return AbstractC2383mu.this.lowerEntry(k);
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        return AbstractC2383mu.this.lowerKey(k);
    }

    @Override // me.tvspark.AbstractC2162gv, java.util.Map
    public Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return AbstractC2383mu.this.firstEntry();
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return AbstractC2383mu.this.firstKey();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k) {
        return AbstractC2383mu.this.higherEntry(k);
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        return AbstractC2383mu.this.higherKey(k);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        NavigableSet<K> navigableSet = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (navigableSet == null) {
            C2576rw c2576rw = new C2576rw(this);
            this.Wwwwwwwwwwwwwwwwwwwwww = c2576rw;
            return c2576rw;
        }
        return navigableSet;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        return AbstractC2383mu.this.pollLastEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        return AbstractC2383mu.this.pollFirstEntry();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        return AbstractC2383mu.this.subMap(k2, z2, k, z).descendingMap();
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> subMap(K k, K k2) {
        return subMap(k, true, k2, false);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(K k, boolean z) {
        return AbstractC2383mu.this.headMap(k, z).descendingMap();
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> tailMap(K k) {
        return tailMap(k, true);
    }

    @Override // me.tvspark.AbstractC2310kv
    public String toString() {
        return standardToString();
    }

    @Override // me.tvspark.AbstractC2162gv, java.util.Map, me.tvspark.AbstractC2648tu
    /* renamed from: values */
    public Collection<V> mo4672values() {
        return new C2802xw(this);
    }
}
