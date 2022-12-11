package me.tvspark;

import java.util.HashMap;
import java.util.LinkedHashSet;

/* loaded from: classes4.dex */
public class fv0 {
    public static HashMap<Class<?>, LinkedHashSet<Class<?>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap<>();
    public static HashMap<Class<?>, HashMap<String, String>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap<>();

    static {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object.class, hv0.class);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object.class, gv0.class);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls, Class<?> cls2) {
        synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            LinkedHashSet<Class<?>> linkedHashSet = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cls);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet<>();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(cls, linkedHashSet);
            }
            linkedHashSet.add(cls2);
        }
    }
}
