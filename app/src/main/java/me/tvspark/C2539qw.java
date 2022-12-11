package me.tvspark;

import java.util.Iterator;
import java.util.Map;

/* renamed from: me.tvspark.qw */
/* loaded from: classes4.dex */
public class C2539qw<K, V> extends AbstractC2651tx<K> {
    public final Map<K, V> Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2539qw(Map<K, V> map) {
        if (map != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = map;
            return;
        }
        throw null;
    }

    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public Map<K, V> mo4955Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        mo4955Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return mo4955Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return mo4955Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<K> iterator() {
        return new C2126fw(mo4955Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (contains(obj)) {
            mo4955Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().remove(obj);
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return mo4955Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().size();
    }
}
