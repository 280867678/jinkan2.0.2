package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class PropertyUtils {

    /* renamed from: a */
    public static Class f2373a;

    /* renamed from: b */
    public static Method f2374b;

    static {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            f2373a = cls;
            f2374b = cls.getDeclaredMethod("get", String.class, String.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static String m2162a(String str, String str2) {
        Method method;
        Class cls = f2373a;
        if (cls == null || (method = f2374b) == null) {
            return str2;
        }
        try {
            return (String) method.invoke(cls, str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    public static String getQuickly(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : m2162a(str, str2);
    }
}
