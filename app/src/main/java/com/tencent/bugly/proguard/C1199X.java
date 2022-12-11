package com.tencent.bugly.proguard;

import java.util.Locale;

/* renamed from: com.tencent.bugly.proguard.X */
/* loaded from: classes3.dex */
public class C1199X {

    /* renamed from: a */
    public static String f1448a = "CrashReportInfo";

    /* renamed from: b */
    public static String f1449b = "CrashReport";

    /* renamed from: c */
    public static boolean f1450c;

    /* renamed from: a */
    public static boolean m3087a(int i, String str, Object... objArr) {
        if (!f1450c) {
            return false;
        }
        m3075f(str, objArr);
        return i == 0 || i == 1 || i == 2 || i == 3 || i == 5;
    }

    /* renamed from: a */
    public static boolean m3086a(int i, Throwable th) {
        if (!f1450c) {
            return false;
        }
        return m3087a(i, C1208ca.m3010b(th), new Object[0]);
    }

    /* renamed from: a */
    public static boolean m3085a(Class cls, String str, Object... objArr) {
        return m3087a(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    /* renamed from: a */
    public static boolean m3084a(String str, Object... objArr) {
        return m3087a(1, str, objArr);
    }

    /* renamed from: a */
    public static boolean m3083a(Throwable th) {
        return m3086a(3, th);
    }

    /* renamed from: b */
    public static boolean m3082b(Class cls, String str, Object... objArr) {
        return m3087a(3, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    /* renamed from: b */
    public static boolean m3081b(String str, Object... objArr) {
        return m3087a(3, str, objArr);
    }

    /* renamed from: b */
    public static boolean m3080b(Throwable th) {
        return m3086a(2, th);
    }

    /* renamed from: c */
    public static boolean m3079c(Class cls, String str, Object... objArr) {
        return m3087a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    /* renamed from: c */
    public static boolean m3078c(String str, Object... objArr) {
        return m3087a(0, str, objArr);
    }

    /* renamed from: d */
    public static boolean m3077d(String str, Object... objArr) {
        return m3087a(5, str, objArr);
    }

    /* renamed from: e */
    public static boolean m3076e(String str, Object... objArr) {
        return m3087a(2, str, objArr);
    }

    /* renamed from: f */
    public static String m3075f(String str, Object... objArr) {
        return str == null ? "null" : (objArr == null || objArr.length == 0) ? str : String.format(Locale.US, str, objArr);
    }
}
