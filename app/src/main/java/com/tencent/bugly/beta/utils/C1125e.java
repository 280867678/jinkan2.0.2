package com.tencent.bugly.beta.utils;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.tencent.bugly.beta.utils.e */
/* loaded from: classes3.dex */
public class C1125e {

    /* renamed from: a */
    public static Handler f945a;

    /* renamed from: a */
    public static Handler m3491a() {
        if (f945a == null && Looper.getMainLooper() != null) {
            f945a = new Handler(Looper.getMainLooper());
        }
        return f945a;
    }

    /* renamed from: a */
    public static void m3490a(Runnable runnable) {
        if (m3491a() != null) {
            f945a.post(runnable);
        }
    }

    /* renamed from: a */
    public static void m3489a(Runnable runnable, long j) {
        if (m3491a() != null) {
            f945a.postDelayed(runnable, j);
        }
    }

    /* renamed from: b */
    public static void m3488b(Runnable runnable) {
        if (m3491a() != null) {
            f945a.removeCallbacks(runnable);
        }
    }
}
