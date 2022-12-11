package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.C1640j;
import com.umeng.common.C1687b;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Map;

/* loaded from: classes4.dex */
public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static final String DEBUG_KEY = "debugkey";
    public static final String DEBUG_MODE_PERIOD = "sendaging";
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";
    public static final String RTD_PERIOD = "period";
    public static final String RTD_SP_FILE = "um_rtd_conf";
    public static final String RTD_START_TIME = "startTime";

    /* renamed from: a */
    public static double[] f2837a = null;

    /* renamed from: b */
    public static String f2838b = null;

    /* renamed from: c */
    public static String f2839c = null;

    /* renamed from: d */
    public static String f2840d = null;

    /* renamed from: e */
    public static int f2841e = 0;
    public static boolean enable = true;

    /* renamed from: f */
    public static Object f2842f = new Object();

    /* renamed from: g */
    public static boolean f2843g = false;

    /* renamed from: h */
    public static String f2844h = "";
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;

    /* renamed from: a */
    public static void m1472a(Context context, int i) {
        f2841e = i;
        C1687b.m818a(context).m819a(f2841e);
    }

    /* renamed from: a */
    public static void m1471a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.m773aq(C1640j.f3456A, 0, "\\|");
            return;
        }
        f2840d = str;
        C1687b.m818a(context).m814a(f2840d);
    }

    /* renamed from: a */
    public static void m1470a(String str) {
        f2839c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static String getGameSdkVersion(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.analytics.game.GameSdkVersion");
            return (String) cls.getDeclaredField("SDK_VERSION").get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static double[] getLocation() {
        return f2837a;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f2842f) {
            str = f2844h;
        }
        return str;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f2840d)) {
            f2840d = C1687b.m818a(context).m811c();
        }
        return f2840d;
    }

    public static int getVerticalType(Context context) {
        if (f2841e == 0) {
            f2841e = C1687b.m818a(context).m810d();
        }
        return f2841e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z;
        synchronized (f2842f) {
            z = f2843g;
        }
        return z;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f2842f) {
            f2843g = false;
            f2844h = "";
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f2842f) {
            f2843g = true;
            if (map != null && map.containsKey("debugkey")) {
                f2844h = map.get("debugkey");
            }
        }
    }
}
