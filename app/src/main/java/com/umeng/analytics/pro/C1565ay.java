package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;

/* renamed from: com.umeng.analytics.pro.ay */
/* loaded from: classes4.dex */
public class C1565ay {
    /* renamed from: a */
    public static AbstractC1564ax m1222a(Class<? extends AbstractC1564ax> cls, int i) {
        try {
            return (AbstractC1564ax) cls.getMethod("findByValue", Integer.TYPE).invoke(null, Integer.valueOf(i));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
