package me.tvspark;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* renamed from: me.tvspark.vw */
/* loaded from: classes4.dex */
public class C2728vw<K, V> extends AbstractC2051dv<Map.Entry<K, V>> {
    public final Collection<Map.Entry<K, V>> Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2728vw(Collection<Map.Entry<K, V>> collection) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = collection;
    }

    @Override // me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate */
    public Object mo4974delegate() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
    /* renamed from: delegate  reason: collision with other method in class */
    public Collection<Map.Entry<K, V>> mo4974delegate() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return new C2274jw(this.Wwwwwwwwwwwwwwwwwwwwwwww.iterator());
    }

    @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // me.tvspark.AbstractC2051dv, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }
}
