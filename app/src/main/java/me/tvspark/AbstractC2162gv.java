package me.tvspark;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: me.tvspark.gv */
/* loaded from: classes4.dex */
public abstract class AbstractC2162gv<K, V> extends AbstractC2310kv implements Map<K, V> {
    public void clear() {
        mo4974delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return mo4974delegate().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return mo4974delegate().containsValue(obj);
    }

    @Override // me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public abstract /* bridge */ /* synthetic */ Object mo4974delegate();

    @Override // me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public abstract Map<K, V> mo4974delegate();

    public Set<Map.Entry<K, V>> entrySet() {
        return mo4974delegate().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || mo4974delegate().equals(obj);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return mo4974delegate().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return mo4974delegate().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return mo4974delegate().isEmpty();
    }

    public Set<K> keySet() {
        return mo4974delegate().keySet();
    }

    public V put(K k, V v) {
        return mo4974delegate().put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        mo4974delegate().putAll(map);
    }

    public V remove(Object obj) {
        return mo4974delegate().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return mo4974delegate().size();
    }

    public void standardClear() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) entrySet().iterator());
    }

    public boolean standardContainsKey(Object obj) {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) new C2126fw(entrySet().iterator()), obj);
    }

    public boolean standardContainsValue(Object obj) {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) new C2163gw(entrySet().iterator()), obj);
    }

    public boolean standardEquals(Object obj) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, obj);
    }

    public int standardHashCode() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) entrySet());
    }

    public boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    public void standardPutAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public V standardRemove(Object obj) {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.getKey(), obj)) {
                V value = next.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    public String standardToString() {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    /* renamed from: values */
    public Collection<V> mo4672values() {
        return mo4974delegate().values();
    }
}
