package com.tencent.smtt.sdk.p045ui.dialog;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* renamed from: com.tencent.smtt.sdk.ui.dialog.c */
/* loaded from: classes4.dex */
public class C1405c {

    /* renamed from: a */
    public static float f2265a = -1.0f;

    /* renamed from: b */
    public static int f2266b = -1;

    /* renamed from: c */
    public static int f2267c = -1;

    /* renamed from: a */
    public static int m2339a(Context context) {
        if (f2266b == -1) {
            m2337b(context);
        }
        return f2266b;
    }

    /* renamed from: a */
    public static int m2338a(Context context, float f) {
        return m2336b(context, (f * 160.0f) / 320.0f);
    }

    /* renamed from: b */
    public static int m2336b(Context context, float f) {
        if (f2265a == -1.0f) {
            m2337b(context);
        }
        return (int) ((f * f2265a) + 0.5f);
    }

    /* renamed from: b */
    public static void m2337b(Context context) {
        if (f2265a < 0.0f) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            f2265a = displayMetrics.density;
            f2266b = displayMetrics.heightPixels;
        }
    }
}
