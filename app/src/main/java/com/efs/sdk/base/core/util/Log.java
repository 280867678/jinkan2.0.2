package com.efs.sdk.base.core.util;

import com.efs.sdk.base.core.controller.ControllerCenter;

/* loaded from: classes3.dex */
public class Log {
    /* renamed from: d */
    public static void m4071d(String str) {
        m4069d("efs.base", str, null);
    }

    /* renamed from: d */
    public static void m4070d(String str, String str2) {
        m4069d(str, str2, null);
    }

    /* renamed from: d */
    public static void m4069d(String str, String str2, Throwable th) {
        if (!ControllerCenter.getGlobalEnvStruct().isDebug() || th == null) {
        }
    }

    /* renamed from: d */
    public static void m4068d(String str, Throwable th) {
        m4069d("efs.base", str, th);
    }

    /* renamed from: e */
    public static void m4067e(String str) {
        m4065e("efs.base", str, null);
    }

    /* renamed from: e */
    public static void m4066e(String str, String str2) {
        m4065e(str, str2, null);
    }

    /* renamed from: e */
    public static void m4065e(String str, String str2, Throwable th) {
        if (!ControllerCenter.getGlobalEnvStruct().isDebug() || th == null) {
        }
    }

    /* renamed from: e */
    public static void m4064e(String str, Throwable th) {
        m4065e("efs.base", str, th);
    }

    /* renamed from: i */
    public static void m4063i(String str) {
        m4061i("efs.base", str, null);
    }

    /* renamed from: i */
    public static void m4062i(String str, String str2) {
        m4061i(str, str2, null);
    }

    /* renamed from: i */
    public static void m4061i(String str, String str2, Throwable th) {
        if (!ControllerCenter.getGlobalEnvStruct().isDebug() || th == null) {
        }
    }

    /* renamed from: i */
    public static void m4060i(String str, Throwable th) {
        m4061i("efs.base", str, th);
    }

    /* renamed from: v */
    public static void m4059v(String str) {
        m4057v("efs.base", str, null);
    }

    /* renamed from: v */
    public static void m4058v(String str, String str2) {
        m4057v(str, str2, null);
    }

    /* renamed from: v */
    public static void m4057v(String str, String str2, Throwable th) {
        if (!ControllerCenter.getGlobalEnvStruct().isDebug() || th == null) {
        }
    }

    /* renamed from: v */
    public static void m4056v(String str, Throwable th) {
        m4057v("efs.base", str, th);
    }

    /* renamed from: w */
    public static void m4055w(String str) {
        m4053w("efs.base", str, null);
    }

    /* renamed from: w */
    public static void m4054w(String str, String str2) {
        m4053w(str, str2, null);
    }

    /* renamed from: w */
    public static void m4053w(String str, String str2, Throwable th) {
        if (!ControllerCenter.getGlobalEnvStruct().isDebug() || th == null) {
        }
    }

    /* renamed from: w */
    public static void m4052w(String str, Throwable th) {
        m4053w("efs.base", str, th);
    }
}
