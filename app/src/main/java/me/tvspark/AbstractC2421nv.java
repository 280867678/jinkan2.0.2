package me.tvspark;

import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;

/* renamed from: me.tvspark.nv */
/* loaded from: classes4.dex */
public abstract class AbstractC2421nv<K, V> extends AbstractC2162gv<K, V> implements SortedMap<K, V> {
    private int unsafeCompare(Object obj, Object obj2) {
        Comparator<? super K> comparator = comparator();
        return comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return mo4974delegate().comparator();
    }

    @Override // me.tvspark.AbstractC2162gv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract /* bridge */ /* synthetic */ Object mo4974delegate();

    @Override // me.tvspark.AbstractC2162gv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public abstract /* bridge */ /* synthetic */ Map mo4974delegate();

    @Override // me.tvspark.AbstractC2162gv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract SortedMap<K, V> mo4974delegate();

    @Override // java.util.SortedMap
    public K firstKey() {
        return mo4974delegate().firstKey();
    }

    public abstract SortedMap<K, V> headMap(K k);

    @Override // java.util.SortedMap
    public K lastKey() {
        return mo4974delegate().lastKey();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2162gv
    public boolean standardContainsKey(Object obj) {
        try {
            return unsafeCompare(tailMap(obj).firstKey(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    public SortedMap<K, V> standardSubMap(K k, K k2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(unsafeCompare(k, k2) <= 0, "fromKey must be <= toKey");
        return tailMap(k).headMap(k2);
    }

    public abstract SortedMap<K, V> subMap(K k, K k2);

    public abstract SortedMap<K, V> tailMap(K k);
}
