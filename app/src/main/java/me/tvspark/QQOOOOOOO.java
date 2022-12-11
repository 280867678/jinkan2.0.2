package me.tvspark;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.tvspark.QQOO;

/* loaded from: classes4.dex */
public class QQOOOOOOO<K extends QQOO, V> {
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(null);
    public final Map<K, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public List<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final K Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this(null);
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k;
        }

        @Nullable
        public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            List<V> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int size = list != null ? list.size() : 0;
            if (size > 0) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(size - 1);
            }
            return null;
        }
    }

    @Nullable
    public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(k);
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(k);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(k, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else {
            k.offer();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; !wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww); wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            z = true;
            sb.append('{');
            sb.append(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            sb.append(':');
            List<V> list = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            sb.append(list != null ? list.size() : 0);
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, V v) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(k);
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(k);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(k, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else {
            k.offer();
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(v);
    }

    @Nullable
    public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        while (true) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                V v = (V) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (v != null) {
                    return v;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                ((QQOO) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).offer();
            } else {
                return null;
            }
        }
    }
}
