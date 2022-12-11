package com.google.common.base;

import java.io.Serializable;
import java.util.Map;
import me.tvspark.AbstractC2271jt;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Functions$FunctionForMapNoDefault<K, V> implements AbstractC2271jt<K, V>, Serializable {
    public static final long serialVersionUID = 0;
    public final Map<K, V> map;

    public Functions$FunctionForMapNoDefault(Map<K, V> map) {
        if (map != null) {
            this.map = map;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2271jt
    /* renamed from: apply */
    public V mo4462apply(K k) {
        V v = this.map.get(k);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v != null || this.map.containsKey(k), "Key '%s' not present in map", k);
        return v;
    }

    @Override // me.tvspark.AbstractC2271jt
    public boolean equals(Object obj) {
        if (obj instanceof Functions$FunctionForMapNoDefault) {
            return this.map.equals(((Functions$FunctionForMapNoDefault) obj).map);
        }
        return false;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Functions.forMap(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.map);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
