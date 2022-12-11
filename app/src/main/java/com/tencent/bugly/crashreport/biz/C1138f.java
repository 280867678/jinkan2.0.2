package com.tencent.bugly.crashreport.biz;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.stub.StubApp;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.strategy.C1145c;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C1198W;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import java.util.List;

/* renamed from: com.tencent.bugly.crashreport.biz.f */
/* loaded from: classes3.dex */
public class C1138f {

    /* renamed from: a */
    public static boolean f984a = false;

    /* renamed from: b */
    public static int f985b = 10;

    /* renamed from: c */
    public static long f986c = 300000;

    /* renamed from: d */
    public static long f987d = 30000;

    /* renamed from: e */
    public static long f988e = 0;

    /* renamed from: f */
    public static int f989f = 0;

    /* renamed from: g */
    public static long f990g = 0;

    /* renamed from: h */
    public static long f991h = 0;

    /* renamed from: i */
    public static C1132c f992i = null;

    /* renamed from: j */
    public static long f993j = 0;

    /* renamed from: k */
    public static Application.ActivityLifecycleCallbacks f994k = null;

    /* renamed from: l */
    public static Class<?> f995l = null;

    /* renamed from: m */
    public static boolean f996m = true;

    /* renamed from: a */
    public static void m3462a(Context context) {
        if (!f984a || context == null) {
            return;
        }
        m3448d(context);
        f984a = false;
    }

    /* renamed from: a */
    public static void m3460a(StrategyBean strategyBean, boolean z) {
        C1132c c1132c = f992i;
        if (c1132c != null && !z) {
            c1132c.m3469b();
        }
        if (strategyBean == null) {
            return;
        }
        long j = strategyBean.f1099p;
        if (j > 0) {
            f987d = j;
        }
        int i = strategyBean.f1104u;
        if (i > 0) {
            f985b = i;
        }
        long j2 = strategyBean.f1105v;
        if (j2 <= 0) {
            return;
        }
        f986c = j2;
    }

    /* renamed from: b */
    public static String m3454b(String str, String str2) {
        return C1208ca.m3047a() + "  " + str + "  " + str2 + "\n";
    }

    /* renamed from: b */
    public static void m3455b(Context context, BuglyStrategy buglyStrategy) {
        long j;
        if (f984a) {
            return;
        }
        boolean z = C1140a.m3421a(context).f1047j;
        f996m = z;
        f992i = new C1132c(context, z);
        f984a = true;
        if (buglyStrategy != null) {
            f995l = buglyStrategy.getUserInfoActivity();
            j = buglyStrategy.getAppReportDelay();
        } else {
            j = 0;
        }
        if (j <= 0) {
            m3450c(context, buglyStrategy);
        } else {
            C1198W.m3089c().m3091a(new RunnableC1136d(context, buglyStrategy), j);
        }
    }

    /* renamed from: b */
    public static boolean m3456b(Context context) {
        C1140a m3421a = C1140a.m3421a(context);
        List<UserInfoBean> m3471a = f992i.m3471a(m3421a.f1043h);
        if (m3471a == null) {
            return true;
        }
        for (int i = 0; i < m3471a.size(); i++) {
            UserInfoBean userInfoBean = m3471a.get(i);
            if (userInfoBean.f963n.equals(m3421a.f1008E) && userInfoBean.f951b == 1) {
                long m3018b = C1208ca.m3018b();
                if (m3018b <= 0) {
                    return true;
                }
                if (userInfoBean.f954e >= m3018b) {
                    if (userInfoBean.f955f <= 0) {
                        f992i.m3469b();
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: c */
    public static void m3452c(long j) {
        if (j < 0) {
            j = C1145c.m3344b().m3342c().f1099p;
        }
        f988e = j;
    }

    @TargetApi(14)
    /* renamed from: c */
    public static void m3451c(Context context) {
        Application application = StubApp.getOrigApplicationContext(context.getApplicationContext()) instanceof Application ? (Application) StubApp.getOrigApplicationContext(context.getApplicationContext()) : null;
        if (application == null) {
            return;
        }
        try {
            if (f994k == null) {
                f994k = new C1137e();
            }
            application.registerActivityLifecycleCallbacks(f994k);
        } catch (Exception e) {
            if (C1199X.m3080b(e)) {
                return;
            }
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static void m3450c(Context context, BuglyStrategy buglyStrategy) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (buglyStrategy != null) {
            z2 = buglyStrategy.recordUserInfoOnceADay();
            z = buglyStrategy.isEnableUserInfo();
        } else {
            z = true;
            z2 = false;
        }
        if (!z2) {
            z3 = z;
        } else if (!m3456b(context)) {
            return;
        }
        m3439m();
        if (z3) {
            m3451c(context);
        }
        if (f996m) {
            m3438n();
            f992i.m3480a();
            f992i.m3468b(21600000L);
        }
    }

    @TargetApi(14)
    /* renamed from: d */
    public static void m3448d(Context context) {
        Application application = StubApp.getOrigApplicationContext(context.getApplicationContext()) instanceof Application ? (Application) StubApp.getOrigApplicationContext(context.getApplicationContext()) : null;
        if (application == null) {
            return;
        }
        try {
            if (f994k == null) {
                return;
            }
            application.unregisterActivityLifecycleCallbacks(f994k);
        } catch (Exception e) {
            if (C1199X.m3080b(e)) {
                return;
            }
            e.printStackTrace();
        }
    }

    /* renamed from: i */
    public static /* synthetic */ int m3443i() {
        int i = f989f;
        f989f = i + 1;
        return i;
    }

    /* renamed from: l */
    public static void m3440l() {
        C1132c c1132c = f992i;
        if (c1132c != null) {
            c1132c.m3479a(2, false, 0L);
        }
    }

    /* renamed from: m */
    public static void m3439m() {
        StackTraceElement[] stackTrace;
        C1140a m3394m = C1140a.m3394m();
        if (m3394m == null) {
            return;
        }
        String str = null;
        boolean z = false;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getMethodName().equals("onCreate")) {
                str = stackTraceElement.getClassName();
            }
            if (stackTraceElement.getClassName().equals("android.app.Activity")) {
                z = true;
            }
        }
        if (str == null) {
            str = "unknown";
        } else if (z) {
            m3394m.m3418a(true);
        } else {
            str = NotificationCompat.WearableExtender.KEY_BACKGROUND;
        }
        m3394m.f1026W = str;
    }

    /* renamed from: n */
    public static void m3438n() {
        f991h = System.currentTimeMillis();
        f992i.m3479a(1, false, 0L);
        C1199X.m3078c("[session] launch app, new start", new Object[0]);
    }
}
