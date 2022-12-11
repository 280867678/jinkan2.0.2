package org.apache.commons.lang3.text;

import java.util.Map;

/* loaded from: classes4.dex */
public abstract class StrLookup<V> {
    public static final StrLookup<String> NONE_LOOKUP = new MapStrLookup(null);
    public static final StrLookup<String> SYSTEM_PROPERTIES_LOOKUP;

    /* loaded from: classes4.dex */
    public static class MapStrLookup<V> extends StrLookup<V> {
        public final Map<String, V> map;

        public MapStrLookup(Map<String, V> map) {
            this.map = map;
        }

        @Override // org.apache.commons.lang3.text.StrLookup
        public String lookup(String str) {
            V v;
            Map<String, V> map = this.map;
            if (map == null || (v = map.get(str)) == null) {
                return null;
            }
            return v.toString();
        }
    }

    static {
        StrLookup<String> strLookup;
        try {
            strLookup = new MapStrLookup<>(System.getProperties());
        } catch (SecurityException unused) {
            strLookup = NONE_LOOKUP;
        }
        SYSTEM_PROPERTIES_LOOKUP = strLookup;
    }

    public static <V> StrLookup<V> mapLookup(Map<String, V> map) {
        return new MapStrLookup(map);
    }

    public static StrLookup<?> noneLookup() {
        return NONE_LOOKUP;
    }

    public static StrLookup<String> systemPropertiesLookup() {
        return SYSTEM_PROPERTIES_LOOKUP;
    }

    public abstract String lookup(String str);
}
