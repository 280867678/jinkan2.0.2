package me.tvspark;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: me.tvspark.yw */
/* loaded from: classes4.dex */
public abstract class AbstractC2839yw<K, V> extends AbstractMap<K, V> {
    public transient Collection<V> Wwwwwwwwwwwwwwwwwwwwww;
    public transient Set<K> Wwwwwwwwwwwwwwwwwwwwwww;
    public transient Set<Map.Entry<K, V>> Wwwwwwwwwwwwwwwwwwwwwwww;

    public Collection<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new C2802xw(this);
    }

    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public Set<K> mo4480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new C2539qw(this);
    }

    public abstract Set<Map.Entry<K, V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (set == null) {
            Set<Map.Entry<K, V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    /* renamed from: keySet */
    public Set<K> mo4481keySet() {
        Set<K> set = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (set == null) {
            Set<K> mo4480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mo4480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwww = mo4480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return mo4480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (collection == null) {
            Collection<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return collection;
    }
}
