package com.efs.sdk.launch;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.stub.StubApp;

/* loaded from: classes3.dex */
public class LaunchManager {
    public static final String APP_ATTACH_BASE_CONTEXT = "app_attachBaseContext";
    public static final String APP_CONSTRUCT = "app_<init>";
    public static final String APP_ON_CREATE = "app_onCreate";
    public static final String PAGE_ON_CREATE = "page_onCreate";
    public static final String PAGE_ON_RESUME = "page_onResume";
    public static final String PAGE_ON_RE_START = "page_onReStart";
    public static final String PAGE_ON_START = "page_onStart";
    public static final String PAGE_ON_STOP = "page_onStop";
    public static final String PAGE_ON_WINDOW = "page_on_window";

    /* renamed from: a */
    public static LaunchConfigManager f348a = null;

    /* renamed from: b */
    public static Context f349b = null;

    /* renamed from: c */
    public static EfsReporter f350c = null;

    /* renamed from: d */
    public static boolean f351d = false;
    public static boolean isDebug = true;

    public static LaunchConfigManager getLaunchConfigManager() {
        return f348a;
    }

    public static EfsReporter getReporter() {
        return f350c;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            try {
                if (isDebug) {
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (!C0792c.m3983e(origApplicationContext)) {
            boolean z = isDebug;
        } else if (isInit()) {
            boolean z2 = isDebug;
        } else {
            f349b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            f350c = efsReporter;
            f348a = new LaunchConfigManager(context, efsReporter);
            f351d = true;
            C0789a.m3996a(new Runnable() { // from class: com.efs.sdk.launch.LaunchManager.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        C0791b.m3993a(origApplicationContext, (String) null);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            });
        }
    }

    public static boolean isInit() {
        return f351d;
    }

    public static void onTraceApp(Application application, String str, boolean z) {
        if (application != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (str.equals(APP_ATTACH_BASE_CONTEXT) || Looper.getMainLooper() == Looper.myLooper()) {
                        C0791b.m3991a(str, z);
                        return;
                    } else {
                        boolean z2 = isDebug;
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        boolean z3 = isDebug;
    }

    public static void onTraceBegin(Context context, String str, long j) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    context.getApplicationContext();
                    if (Looper.getMainLooper() != Looper.myLooper()) {
                        boolean z = isDebug;
                        return;
                    } else if (str.length() > 10) {
                        boolean z2 = isDebug;
                        return;
                    } else {
                        C0791b.m3992a(str, j);
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        boolean z3 = isDebug;
    }

    public static void onTraceEnd(Context context, String str, long j) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    context.getApplicationContext();
                    if (Looper.getMainLooper() != Looper.myLooper()) {
                        boolean z = isDebug;
                        return;
                    } else if (str.length() > 10) {
                        boolean z2 = isDebug;
                        return;
                    } else {
                        C0791b.m3989b(str, j);
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        boolean z3 = isDebug;
    }

    public static void onTracePage(Activity activity, String str, boolean z) {
        if (activity != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    activity.getApplicationContext();
                    if (Looper.getMainLooper() != Looper.myLooper()) {
                        boolean z2 = isDebug;
                        return;
                    } else {
                        C0791b.m3995a(activity, str, z);
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        boolean z3 = isDebug;
    }

    public static void sendLaunchCache(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            C0791b.m3993a(context, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
