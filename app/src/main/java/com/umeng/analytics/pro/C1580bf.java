package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.umeng.analytics.pro.bf */
/* loaded from: classes4.dex */
public class C1580bf implements Serializable {

    /* renamed from: d */
    public static Map<Class<? extends AbstractC1558at>, Map<? extends AbstractC1570ba, C1580bf>> f3159d = new HashMap();

    /* renamed from: a */
    public final String f3160a;

    /* renamed from: b */
    public final byte f3161b;

    /* renamed from: c */
    public final C1581bg f3162c;

    public C1580bf(String str, byte b, C1581bg c1581bg) {
        this.f3160a = str;
        this.f3161b = b;
        this.f3162c = c1581bg;
    }

    /* renamed from: a */
    public static Map<? extends AbstractC1570ba, C1580bf> m1186a(Class<? extends AbstractC1558at> cls) {
        if (!f3159d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("IllegalAccessException for TBase class: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getName());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", message: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
                throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            } catch (InstantiationException e2) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("InstantiationException for TBase class: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(cls.getName());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", message: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e2.getMessage());
                throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            }
        }
        return f3159d.get(cls);
    }

    /* renamed from: a */
    public static void m1185a(Class<? extends AbstractC1558at> cls, Map<? extends AbstractC1570ba, C1580bf> map) {
        f3159d.put(cls, map);
    }
}
