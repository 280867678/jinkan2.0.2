package me.tvspark;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: me.tvspark.pw */
/* loaded from: classes4.dex */
public abstract class AbstractC2502pw<K, V> extends AbstractMap<K, V> {

    /* renamed from: me.tvspark.pw$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2422nw<K, V> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC2422nw
        public Map<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return AbstractC2502pw.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractC2502pw.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public abstract Iterator<Map.Entry<K, V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
