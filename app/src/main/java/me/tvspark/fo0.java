package me.tvspark;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class fo0 {
    public static fo0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Map<String, WeakReference<Object>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();

    public static fo0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            synchronized (fo0.class) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new fo0();
                }
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
