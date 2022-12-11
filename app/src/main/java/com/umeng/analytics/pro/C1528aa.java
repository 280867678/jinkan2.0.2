package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;

/* renamed from: com.umeng.analytics.pro.aa */
/* loaded from: classes4.dex */
public class C1528aa {

    /* renamed from: a */
    public static AbstractC1671z f2910a;

    /* renamed from: b */
    public static boolean f2911b;

    /* renamed from: a */
    public static synchronized String m1399a(Context context) {
        synchronized (C1528aa.class) {
            try {
                if (context == null) {
                    throw new RuntimeException("Context is null");
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    throw new IllegalStateException("Cannot be called from the main thread");
                }
                m1398b(context);
                if (f2910a != null) {
                    try {
                        return f2910a.mo850a(context);
                    } catch (Exception unused) {
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: b */
    public static void m1398b(Context context) {
        if (f2910a != null || f2911b) {
            return;
        }
        synchronized (C1528aa.class) {
            if (f2910a == null && !f2911b) {
                f2910a = C1531ac.m1389a(context);
                f2911b = true;
            }
        }
    }
}
