package me.tvspark;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;

/* renamed from: me.tvspark.rw */
/* loaded from: classes4.dex */
public class C2576rw<K, V> extends C2613sw<K, V> implements NavigableSet<K> {
    public C2576rw(NavigableMap<K, V> navigableMap) {
        super(navigableMap);
    }

    @Override // me.tvspark.C2613sw, me.tvspark.C2539qw
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public Map mo4955Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return (NavigableMap) this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.NavigableSet
    public K ceiling(K k) {
        return (K) ((NavigableMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).ceilingKey(k);
    }

    @Override // java.util.NavigableSet
    public Iterator<K> descendingIterator() {
        return descendingSet().iterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<K> descendingSet() {
        return ((NavigableMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).descendingKeySet();
    }

    @Override // java.util.NavigableSet
    public K floor(K k) {
        return (K) ((NavigableMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).floorKey(k);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<K> headSet(K k, boolean z) {
        return ((NavigableMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).headMap(k, z).navigableKeySet();
    }

    @Override // java.util.NavigableSet
    public K higher(K k) {
        return (K) ((NavigableMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).higherKey(k);
    }

    @Override // java.util.NavigableSet
    public K lower(K k) {
        return (K) ((NavigableMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).lowerKey(k);
    }

    @Override // java.util.NavigableSet
    public K pollFirst() {
        return (K) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((NavigableMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).pollFirstEntry());
    }

    @Override // java.util.NavigableSet
    public K pollLast() {
        return (K) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((NavigableMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).pollLastEntry());
    }

    @Override // java.util.NavigableSet
    public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
        return ((NavigableMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).subMap(k, z, k2, z2).navigableKeySet();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<K> tailSet(K k, boolean z) {
        return ((NavigableMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).tailMap(k, z).navigableKeySet();
    }

    @Override // me.tvspark.C2613sw, me.tvspark.C2539qw
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
    public SortedMap mo4955Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return (NavigableMap) this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.C2613sw, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<K> headSet(K k) {
        return ((NavigableMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).headMap(k, false).navigableKeySet();
    }

    @Override // me.tvspark.C2613sw, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<K> subSet(K k, K k2) {
        return ((NavigableMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).subMap(k, true, k2, false).navigableKeySet();
    }

    @Override // me.tvspark.C2613sw, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<K> tailSet(K k) {
        return ((NavigableMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).tailMap(k, true).navigableKeySet();
    }
}
