package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.Map;
import java.util.TreeMap;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("( ");
        for (Map.Entry<K, V> entry : entrySet()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('{');
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(entry.getKey());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(':');
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(entry.getValue());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("}, ");
        }
        if (!isEmpty()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.replace(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() - 2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length(), "");
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" )");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
