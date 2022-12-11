package com.tencent.smtt.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

/* renamed from: com.tencent.smtt.utils.i */
/* loaded from: classes4.dex */
public class C1460i {
    /* renamed from: a */
    public static Object m2052a(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            method.setAccessible(true);
            return method.invoke(null, objArr);
        } catch (Throwable th) {
            TbsLog.m2158e("997", String.valueOf(th));
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static Object m2051a(Object obj, String str) {
        return m2049a(obj, str, (Class<?>[]) null, new Object[0]);
    }

    /* renamed from: a */
    public static Object m2049a(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        StringWriter stringWriter;
        if (obj == null) {
            return null;
        }
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            if (objArr.length == 0) {
                objArr = null;
            }
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            TbsLog.m2158e("997", String.valueOf(th));
            if (th.getCause() != null && th.getCause().toString().contains("AuthenticationFail")) {
                return new String("AuthenticationFail");
            }
            if (str != null && (str.equalsIgnoreCase("canLoadX5Core") || str.equalsIgnoreCase("initTesRuntimeEnvironment"))) {
                return null;
            }
            th.printStackTrace(new PrintWriter(new StringWriter()));
            TbsLog.m2155i("ReflectionUtils", "invokeInstance -- exceptions:" + stringWriter.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static Object m2048a(String str, String str2) {
        try {
            return Class.forName(str).getMethod(str2, new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th) {
            TbsLog.m2158e("997", String.valueOf(th));
            return null;
        }
    }

    /* renamed from: a */
    public static Method m2050a(Object obj, String str, Class<?>... clsArr) {
        for (Class<?> cls = obj.getClass(); cls != Object.class && cls != null; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
