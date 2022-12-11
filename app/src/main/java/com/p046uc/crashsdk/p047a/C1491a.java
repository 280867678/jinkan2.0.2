package com.p046uc.crashsdk.p047a;

import com.p046uc.crashsdk.C1500b;
import com.p046uc.crashsdk.C1509g;
import com.p046uc.crashsdk.JNIBridge;

/* renamed from: com.uc.crashsdk.a.a */
/* loaded from: classes4.dex */
public final class C1491a {
    /* renamed from: a */
    public static void m1926a(String str) {
        C1509g.m1524M();
    }

    /* renamed from: a */
    public static void m1925a(String str, String str2) {
        C1509g.m1524M();
    }

    /* renamed from: a */
    public static void m1924a(String str, String str2, Throwable th) {
        if (!C1509g.m1524M() || th == null) {
        }
    }

    /* renamed from: b */
    public static void m1923b(String str) {
        C1509g.m1524M();
    }

    /* renamed from: b */
    public static void m1922b(String str, String str2) {
        if (C1500b.f2714d) {
            JNIBridge.nativeLog(4, str, str2);
        }
    }

    /* renamed from: c */
    public static void m1921c(String str, String str2) {
        if (C1500b.f2714d) {
            JNIBridge.nativeLog(5, str, str2);
        }
    }

    /* renamed from: d */
    public static void m1920d(String str, String str2) {
        if (C1500b.f2714d) {
            JNIBridge.nativeLog(6, str, str2);
        }
    }
}
