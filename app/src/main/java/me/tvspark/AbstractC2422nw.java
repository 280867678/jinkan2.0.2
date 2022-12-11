package me.tvspark;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: me.tvspark.nw */
/* loaded from: classes4.dex */
public abstract class AbstractC2422nw<K, V> extends AbstractC2651tx<Map.Entry<K, V>> {
    public abstract Map<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), key);
            if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, entry.getValue())) {
                return false;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().containsKey(key);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (contains(obj)) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().keySet().remove(((Map.Entry) obj).getKey());
        }
        return false;
    }

    @Override // me.tvspark.AbstractC2651tx, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        try {
            if (collection != null) {
                return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) this, collection);
            }
            throw null;
        } catch (UnsupportedOperationException unused) {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) this, collection.iterator());
        }
    }

    @Override // me.tvspark.AbstractC2651tx, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        try {
            if (collection == null) {
                throw null;
            }
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet hashSet = new HashSet(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection.size()));
            for (Object obj : collection) {
                if (contains(obj)) {
                    hashSet.add(((Map.Entry) obj).getKey());
                }
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().keySet().retainAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().size();
    }
}
