package me.tvspark;

import java.util.Comparator;
import java.util.SortedMap;

/* renamed from: me.tvspark.uw */
/* loaded from: classes4.dex */
public class C2688uw<K, V1, V2> extends C2650tw<K, V1, V2> implements SortedMap<K, V2> {
    public C2688uw(SortedMap<K, V1> sortedMap, AbstractC2459ow<? super K, ? super V1, V2> abstractC2459ow) {
        super(sortedMap, abstractC2459ow);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return ((SortedMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).comparator();
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return (K) ((SortedMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).firstKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V2> headMap(K k) {
        return new C2688uw(((SortedMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).headMap(k), this.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return (K) ((SortedMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).lastKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V2> subMap(K k, K k2) {
        return new C2688uw(((SortedMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).subMap(k, k2), this.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V2> tailMap(K k) {
        return new C2688uw(((SortedMap) this.Wwwwwwwwwwwwwwwwwwwwwwww).tailMap(k), this.Wwwwwwwwwwwwwwwwwwwwwww);
    }
}
