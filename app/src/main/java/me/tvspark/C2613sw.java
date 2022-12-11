package me.tvspark;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* renamed from: me.tvspark.sw */
/* loaded from: classes4.dex */
public class C2613sw<K, V> extends C2539qw<K, V> implements SortedSet<K> {
    public C2613sw(SortedMap<K, V> sortedMap) {
        super(sortedMap);
    }

    @Override // me.tvspark.C2539qw
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
    public SortedMap<K, V> mo4955Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return (SortedMap) this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.SortedSet
    public Comparator<? super K> comparator() {
        return mo4955Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().comparator();
    }

    @Override // java.util.SortedSet
    public K first() {
        return mo4955Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().firstKey();
    }

    public SortedSet<K> headSet(K k) {
        return new C2613sw(mo4955Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().headMap(k));
    }

    @Override // java.util.SortedSet
    public K last() {
        return mo4955Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().lastKey();
    }

    public SortedSet<K> subSet(K k, K k2) {
        return new C2613sw(mo4955Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().subMap(k, k2));
    }

    public SortedSet<K> tailSet(K k) {
        return new C2613sw(mo4955Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().tailMap(k));
    }
}
