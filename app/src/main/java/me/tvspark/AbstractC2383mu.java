package me.tvspark;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

/* renamed from: me.tvspark.mu */
/* loaded from: classes4.dex */
public abstract class AbstractC2383mu<K, V> extends AbstractC2502pw<K, V> implements NavigableMap<K, V> {

    /* renamed from: me.tvspark.mu$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2385mw<K, V> {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }
    }

    public abstract Iterator<Map.Entry<K, V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k) {
        return tailMap(k, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        return (K) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tailMap(k, true).firstEntry());
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return ((AbstractC2385mw) descendingMap()).navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return (Map.Entry) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<? extends Object>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), (Object) null);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        Map.Entry<K, V> firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k) {
        return headMap(k, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        return (K) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headMap(k, true).lastEntry());
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> headMap(K k) {
        return headMap(k, false);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k) {
        return tailMap(k, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        return (K) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tailMap(k, false).firstEntry());
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set<K> keySet() {
        return new C2576rw(this);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return (Map.Entry) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<? extends Object>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), (Object) null);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        Map.Entry<K, V> lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k) {
        return headMap(k, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        return (K) C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headMap(k, false).lastEntry());
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return new C2576rw(this);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        return (Map.Entry) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<Object>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        return (Map.Entry) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<Object>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> subMap(K k, K k2) {
        return subMap(k, true, k2, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> tailMap(K k) {
        return tailMap(k, true);
    }
}
