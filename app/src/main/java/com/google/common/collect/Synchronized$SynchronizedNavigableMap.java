package com.google.common.collect;

import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedNavigableMap<K, V> extends Synchronized$SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
    public static final long serialVersionUID = 0;
    public transient NavigableSet<K> descendingKeySet;
    public transient NavigableMap<K, V> descendingMap;
    public transient NavigableSet<K> navigableKeySet;

    public Synchronized$SynchronizedNavigableMap(NavigableMap<K, V> navigableMap, Object obj) {
        super(navigableMap, obj);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k) {
        Map.Entry<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        synchronized (this.mutex) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map.Entry) mo4780delegate().ceilingEntry(k), this.mutex);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        K ceilingKey;
        synchronized (this.mutex) {
            ceilingKey = mo4780delegate().ceilingKey(k);
        }
        return ceilingKey;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedMap, com.google.common.collect.Synchronized$SynchronizedMap, com.google.common.collect.Synchronized$SynchronizedObject
    /* renamed from: delegate */
    public NavigableMap<K, V> mo4780delegate() {
        return (NavigableMap) super.mo4780delegate();
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        synchronized (this.mutex) {
            if (this.descendingKeySet != null) {
                return this.descendingKeySet;
            }
            Synchronized$SynchronizedNavigableSet synchronized$SynchronizedNavigableSet = new Synchronized$SynchronizedNavigableSet(mo4780delegate().descendingKeySet(), this.mutex);
            this.descendingKeySet = synchronized$SynchronizedNavigableSet;
            return synchronized$SynchronizedNavigableSet;
        }
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        synchronized (this.mutex) {
            if (this.descendingMap != null) {
                return this.descendingMap;
            }
            Synchronized$SynchronizedNavigableMap synchronized$SynchronizedNavigableMap = new Synchronized$SynchronizedNavigableMap(mo4780delegate().descendingMap(), this.mutex);
            this.descendingMap = synchronized$SynchronizedNavigableMap;
            return synchronized$SynchronizedNavigableMap;
        }
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        Map.Entry<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        synchronized (this.mutex) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map.Entry) mo4780delegate().firstEntry(), this.mutex);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k) {
        Map.Entry<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        synchronized (this.mutex) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map.Entry) mo4780delegate().floorEntry(k), this.mutex);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        K floorKey;
        synchronized (this.mutex) {
            floorKey = mo4780delegate().floorKey(k);
        }
        return floorKey;
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(K k, boolean z) {
        Synchronized$SynchronizedNavigableMap synchronized$SynchronizedNavigableMap;
        synchronized (this.mutex) {
            synchronized$SynchronizedNavigableMap = new Synchronized$SynchronizedNavigableMap(mo4780delegate().headMap(k, z), this.mutex);
        }
        return synchronized$SynchronizedNavigableMap;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> headMap(K k) {
        return headMap(k, false);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k) {
        Map.Entry<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        synchronized (this.mutex) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map.Entry) mo4780delegate().higherEntry(k), this.mutex);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        K higherKey;
        synchronized (this.mutex) {
            higherKey = mo4780delegate().higherKey(k);
        }
        return higherKey;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMap, java.util.Map
    public Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        Map.Entry<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        synchronized (this.mutex) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map.Entry) mo4780delegate().lastEntry(), this.mutex);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k) {
        Map.Entry<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        synchronized (this.mutex) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map.Entry) mo4780delegate().lowerEntry(k), this.mutex);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        K lowerKey;
        synchronized (this.mutex) {
            lowerKey = mo4780delegate().lowerKey(k);
        }
        return lowerKey;
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        synchronized (this.mutex) {
            if (this.navigableKeySet != null) {
                return this.navigableKeySet;
            }
            Synchronized$SynchronizedNavigableSet synchronized$SynchronizedNavigableSet = new Synchronized$SynchronizedNavigableSet(mo4780delegate().navigableKeySet(), this.mutex);
            this.navigableKeySet = synchronized$SynchronizedNavigableSet;
            return synchronized$SynchronizedNavigableSet;
        }
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        Map.Entry<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        synchronized (this.mutex) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map.Entry) mo4780delegate().pollFirstEntry(), this.mutex);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        Map.Entry<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        synchronized (this.mutex) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Map.Entry) mo4780delegate().pollLastEntry(), this.mutex);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        Synchronized$SynchronizedNavigableMap synchronized$SynchronizedNavigableMap;
        synchronized (this.mutex) {
            synchronized$SynchronizedNavigableMap = new Synchronized$SynchronizedNavigableMap(mo4780delegate().subMap(k, z, k2, z2), this.mutex);
        }
        return synchronized$SynchronizedNavigableMap;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> subMap(K k, K k2) {
        return subMap(k, true, k2, false);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(K k, boolean z) {
        Synchronized$SynchronizedNavigableMap synchronized$SynchronizedNavigableMap;
        synchronized (this.mutex) {
            synchronized$SynchronizedNavigableMap = new Synchronized$SynchronizedNavigableMap(mo4780delegate().tailMap(k, z), this.mutex);
        }
        return synchronized$SynchronizedNavigableMap;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> tailMap(K k) {
        return tailMap(k, true);
    }
}
