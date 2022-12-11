package com.google.common.collect;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import me.tvspark.AbstractC2421nv;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Maps$UnmodifiableNavigableMap<K, V> extends AbstractC2421nv<K, V> implements NavigableMap<K, V>, Serializable {
    public final NavigableMap<K, ? extends V> delegate;
    public transient Maps$UnmodifiableNavigableMap<K, V> descendingMap;

    public Maps$UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
        this.delegate = navigableMap;
    }

    public Maps$UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap, Maps$UnmodifiableNavigableMap<K, V> maps$UnmodifiableNavigableMap) {
        this.delegate = navigableMap;
        this.descendingMap = maps$UnmodifiableNavigableMap;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.delegate.ceilingEntry(k));
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        return this.delegate.ceilingKey(k);
    }

    @Override // me.tvspark.AbstractC2421nv, me.tvspark.AbstractC2162gv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public SortedMap<K, V> mo4974delegate() {
        return Collections.unmodifiableSortedMap(this.delegate);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((NavigableSet) this.delegate.descendingKeySet());
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        Maps$UnmodifiableNavigableMap<K, V> maps$UnmodifiableNavigableMap = this.descendingMap;
        if (maps$UnmodifiableNavigableMap == null) {
            Maps$UnmodifiableNavigableMap<K, V> maps$UnmodifiableNavigableMap2 = new Maps$UnmodifiableNavigableMap<>(this.delegate.descendingMap(), this);
            this.descendingMap = maps$UnmodifiableNavigableMap2;
            return maps$UnmodifiableNavigableMap2;
        }
        return maps$UnmodifiableNavigableMap;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.delegate.firstEntry());
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.delegate.floorEntry(k));
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        return this.delegate.floorKey(k);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(K k, boolean z) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((NavigableMap) this.delegate.headMap(k, z));
    }

    @Override // me.tvspark.AbstractC2421nv, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> headMap(K k) {
        return headMap(k, false);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.delegate.higherEntry(k));
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        return this.delegate.higherKey(k);
    }

    @Override // me.tvspark.AbstractC2162gv, java.util.Map
    public Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.delegate.lastEntry());
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.delegate.lowerEntry(k));
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        return this.delegate.lowerKey(k);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((NavigableSet) this.delegate.navigableKeySet());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((NavigableMap) this.delegate.subMap(k, z, k2, z2));
    }

    @Override // me.tvspark.AbstractC2421nv, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> subMap(K k, K k2) {
        return subMap(k, true, k2, false);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(K k, boolean z) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((NavigableMap) this.delegate.tailMap(k, z));
    }

    @Override // me.tvspark.AbstractC2421nv, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> tailMap(K k) {
        return tailMap(k, true);
    }
}
