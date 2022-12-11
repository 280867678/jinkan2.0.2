package me.tvspark;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: me.tvspark.xw */
/* loaded from: classes4.dex */
public class C2802xw<K, V> extends AbstractCollection<V> {
    public final Map<K, V> Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2802xw(Map<K, V> map) {
        if (map != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = map;
            return;
        }
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return new C2163gw(this.Wwwwwwwwwwwwwwwwwwwwwwww.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        try {
            return super.remove(obj);
        } catch (UnsupportedOperationException unused) {
            for (Map.Entry<K, V> entry : this.Wwwwwwwwwwwwwwwwwwwwwwww.entrySet()) {
                if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, entry.getValue())) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.remove(entry.getKey());
                    return true;
                }
            }
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        try {
            if (collection == null) {
                throw null;
            }
            return super.removeAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet hashSet = new HashSet();
            for (Map.Entry<K, V> entry : this.Wwwwwwwwwwwwwwwwwwwwwwww.entrySet()) {
                if (collection.contains(entry.getValue())) {
                    hashSet.add(entry.getKey());
                }
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.keySet().removeAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        try {
            if (collection == null) {
                throw null;
            }
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet hashSet = new HashSet();
            for (Map.Entry<K, V> entry : this.Wwwwwwwwwwwwwwwwwwwwwwww.entrySet()) {
                if (collection.contains(entry.getValue())) {
                    hashSet.add(entry.getKey());
                }
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.keySet().retainAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.size();
    }
}
