package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import me.tvspark.AbstractC2271jt;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Functions$ForMapWithDefault<K, V> implements AbstractC2271jt<K, V>, Serializable {
    public static final long serialVersionUID = 0;
    public final V defaultValue;
    public final Map<K, ? extends V> map;

    public Functions$ForMapWithDefault(Map<K, ? extends V> map, V v) {
        if (map != null) {
            this.map = map;
            this.defaultValue = v;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2271jt
    /* renamed from: apply */
    public V mo4462apply(K k) {
        V v = this.map.get(k);
        return (v != null || this.map.containsKey(k)) ? v : this.defaultValue;
    }

    @Override // me.tvspark.AbstractC2271jt
    public boolean equals(Object obj) {
        if (obj instanceof Functions$ForMapWithDefault) {
            Functions$ForMapWithDefault functions$ForMapWithDefault = (Functions$ForMapWithDefault) obj;
            return this.map.equals(functions$ForMapWithDefault.map) && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.defaultValue, functions$ForMapWithDefault.defaultValue);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.map, this.defaultValue});
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Functions.forMap(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.map);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", defaultValue=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.defaultValue);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
