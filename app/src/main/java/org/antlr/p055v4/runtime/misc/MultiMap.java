package org.antlr.p055v4.runtime.misc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: org.antlr.v4.runtime.misc.MultiMap */
/* loaded from: classes4.dex */
public class MultiMap<K, V> extends LinkedHashMap<K, List<V>> {
    public List<Pair<K, V>> getPairs() {
        ArrayList arrayList = new ArrayList();
        for (K k : keySet()) {
            for (Object obj : (List) get(k)) {
                arrayList.add(new Pair(k, obj));
            }
        }
        return arrayList;
    }

    public void map(K k, V v) {
        List list = (List) get(k);
        if (list == null) {
            list = new ArrayList();
            super.put(k, list);
        }
        list.add(v);
    }
}
