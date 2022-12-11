package me.tvspark;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class u01<Key1, Key2, Value> {
    public Map<Key1, Map<Key2, Value>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new LinkedHashMap();

    public Value Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Key1 key1, Key2 key2) {
        Map<Key2, Value> map = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(key1);
        if (map == null) {
            return null;
        }
        return map.get(key2);
    }

    public Value Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Key1 key1, Key2 key2, Value value) {
        Value value2;
        Map<Key2, Value> map = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(key1);
        if (map == null) {
            map = new LinkedHashMap<>();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(key1, map);
            value2 = null;
        } else {
            value2 = map.get(key2);
        }
        map.put(key2, value);
        return value2;
    }
}
