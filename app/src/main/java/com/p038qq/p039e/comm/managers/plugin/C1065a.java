package com.p038qq.p039e.comm.managers.plugin;

import java.lang.reflect.Method;

/* renamed from: com.qq.e.comm.managers.plugin.a */
/* loaded from: classes3.dex */
public class C1065a {
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static Method Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: a */
    public static void m3659a(Throwable th, String str) {
        try {
            Exception exc = new Exception("插件错误：" + str, th);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                Method declaredMethod = Class.forName("com.tencent.bugly.crashreport.CrashReport").getDeclaredMethod("postCatchedException", Throwable.class);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.invoke(null, exc);
        } catch (Throwable unused) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }
    }
}
