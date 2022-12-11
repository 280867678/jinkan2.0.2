package com.p038qq.p039e.comm.util;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qq.e.comm.util.a */
/* loaded from: classes3.dex */
public class C1075a {
    public static final Map<String, Boolean> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class cls, String str, Class... clsArr) {
        String sb;
        if (cls == null) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append("#");
            sb2.append(str);
            for (Class cls2 : clsArr) {
                sb2.append("_");
                sb2.append(cls2.getName());
            }
            sb = sb2.toString();
        }
        Boolean bool = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(sb);
        if (bool == null) {
            try {
                cls.getDeclaredMethod(str, clsArr);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(sb, Boolean.TRUE);
                return true;
            } catch (NoSuchMethodException unused) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(sb, Boolean.FALSE);
                return false;
            }
        }
        return Boolean.TRUE.equals(bool);
    }

    /* renamed from: a */
    public static boolean m3641a(Object obj) {
        if (obj == null) {
            return false;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj.getClass(), "onRenderFail", new Class[0]);
    }

    /* renamed from: b */
    public static boolean m3640b(Object obj) {
        if (obj == null) {
            return false;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj.getClass(), "onRenderSuccess", new Class[0]);
    }
}
