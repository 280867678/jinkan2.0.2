package me.tvspark;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: me.tvspark.tw */
/* loaded from: classes4.dex */
public class C2650tw<K, V1, V2> extends AbstractC2502pw<K, V2> {
    public final AbstractC2459ow<? super K, ? super V1, V2> Wwwwwwwwwwwwwwwwwwwwwww;
    public final Map<K, V1> Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2650tw(Map<K, V1> map, AbstractC2459ow<? super K, ? super V1, V2> abstractC2459ow) {
        if (map != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = map;
            if (abstractC2459ow == null) {
                throw null;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC2459ow;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2502pw
    public Iterator<Map.Entry<K, V2>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Iterator<Map.Entry<K, V1>> it = this.Wwwwwwwwwwwwwwwwwwwwwwww.entrySet().iterator();
        AbstractC2459ow<? super K, ? super V1, V2> abstractC2459ow = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (abstractC2459ow != null) {
            return new C2764wv(it, new C2089ew(abstractC2459ow));
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2502pw, java.util.AbstractMap, java.util.Map
    public void clear() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V2 get(Object obj) {
        V1 v1 = this.Wwwwwwwwwwwwwwwwwwwwwwww.get(obj);
        if (v1 != null || this.Wwwwwwwwwwwwwwwwwwwwwwww.containsKey(obj)) {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, v1);
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V2 remove(Object obj) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.containsKey(obj)) {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, (V1) this.Wwwwwwwwwwwwwwwwwwwwwwww.remove(obj));
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V2> values() {
        return new C2802xw(this);
    }
}
