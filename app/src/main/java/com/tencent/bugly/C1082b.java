package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.C1138f;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.strategy.C1145c;
import com.tencent.bugly.proguard.AbstractC1184I;
import com.tencent.bugly.proguard.C1183H;
import com.tencent.bugly.proguard.C1185J;
import com.tencent.bugly.proguard.C1195T;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1205ba;
import com.tencent.bugly.proguard.C1208ca;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.bugly.b */
/* loaded from: classes3.dex */
public class C1082b {

    /* renamed from: a */
    public static boolean f701a = true;

    /* renamed from: b */
    public static List<AbstractC1081a> f702b = new ArrayList();

    /* renamed from: c */
    public static boolean f703c;

    /* renamed from: d */
    public static C1185J f704d;

    /* renamed from: e */
    public static boolean f705e;

    /* renamed from: a */
    public static synchronized void m3636a(Context context) {
        synchronized (C1082b.class) {
            m3635a(context, (BuglyStrategy) null);
        }
    }

    /* renamed from: a */
    public static synchronized void m3635a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (C1082b.class) {
            if (f705e) {
                C1199X.m3076e("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
            } else {
                C1140a m3421a = C1140a.m3421a(context);
                if (m3631a(m3421a)) {
                    f701a = false;
                    return;
                }
                String m3405e = m3421a.m3405e();
                if (m3405e == null) {
                    return;
                }
                m3634a(context, m3405e, m3421a.f1032ba, buglyStrategy);
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m3634a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (C1082b.class) {
            if (f705e) {
                C1199X.m3076e("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context != null) {
                if (str == null) {
                    return;
                }
                f705e = true;
                if (z) {
                    f703c = true;
                    C1199X.f1450c = true;
                    C1199X.m3076e("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                    C1199X.m3081b("--------------------------------------------------------------------------------------------", new Object[0]);
                    C1199X.m3076e("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                    C1199X.m3076e("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                    C1199X.m3076e("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                    C1199X.m3076e("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                    C1199X.m3081b("--------------------------------------------------------------------------------------------", new Object[0]);
                    C1199X.m3077d("[init] Open debug mode of Bugly.", new Object[0]);
                }
                C1199X.m3078c(" crash report start initializing...", new Object[0]);
                C1199X.m3077d("[init] Bugly start initializing...", new Object[0]);
                C1199X.m3078c("[init] Bugly complete version: v%s", "3.2.41(1.5.0)");
                Context m3044a = C1208ca.m3044a(context);
                C1140a m3421a = C1140a.m3421a(m3044a);
                m3421a.m3425E();
                C1205ba.m3067a(m3044a);
                f704d = C1185J.m3165a(m3044a, f702b);
                C1195T.m3110a(m3044a);
                C1145c m3350a = C1145c.m3350a(m3044a, f702b);
                C1183H m3182a = C1183H.m3182a(m3044a);
                if (m3631a(m3421a)) {
                    f701a = false;
                    return;
                }
                m3421a.m3409c(str);
                C1199X.m3078c("[param] Set APP ID:%s", str);
                m3633a(buglyStrategy, m3421a);
                for (int i = 0; i < f702b.size(); i++) {
                    if (m3182a.m3185a(f702b.get(i).f700id)) {
                        f702b.get(i).init(m3044a, z, buglyStrategy);
                    }
                }
                C1138f.m3455b(m3044a, buglyStrategy);
                m3350a.m3352a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
                C1199X.m3077d("[init] Bugly initialization finished.", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static void m3633a(BuglyStrategy buglyStrategy, C1140a c1140a) {
        byte[] bArr;
        if (buglyStrategy == null) {
            return;
        }
        String appVersion = buglyStrategy.getAppVersion();
        if (!TextUtils.isEmpty(appVersion)) {
            if (appVersion.length() > 100) {
                String substring = appVersion.substring(0, 100);
                C1199X.m3076e("appVersion %s length is over limit %d substring to %s", appVersion, 100, substring);
                appVersion = substring;
            }
            c1140a.f1008E = appVersion;
            C1199X.m3078c("[param] Set App version: %s", buglyStrategy.getAppVersion());
        }
        try {
            if (buglyStrategy.isReplaceOldChannel()) {
                String appChannel = buglyStrategy.getAppChannel();
                if (!TextUtils.isEmpty(appChannel)) {
                    if (appChannel.length() > 100) {
                        String substring2 = appChannel.substring(0, 100);
                        C1199X.m3076e("appChannel %s length is over limit %d substring to %s", appChannel, 100, substring2);
                        appChannel = substring2;
                    }
                    f704d.m3166a(556, "app_channel", appChannel.getBytes(), (AbstractC1184I) null, false);
                    c1140a.f1012I = appChannel;
                }
            } else {
                Map<String, byte[]> m3169a = f704d.m3169a(556, (AbstractC1184I) null, true);
                if (m3169a != null && (bArr = m3169a.get("app_channel")) != null) {
                    c1140a.f1012I = new String(bArr);
                }
            }
            C1199X.m3078c("[param] Set App channel: %s", c1140a.f1012I);
        } catch (Exception e) {
            if (f703c) {
                e.printStackTrace();
            }
        }
        String appPackageName = buglyStrategy.getAppPackageName();
        if (!TextUtils.isEmpty(appPackageName)) {
            if (appPackageName.length() > 100) {
                String substring3 = appPackageName.substring(0, 100);
                C1199X.m3076e("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, substring3);
                appPackageName = substring3;
            }
            c1140a.f1041g = appPackageName;
            C1199X.m3078c("[param] Set App package: %s", buglyStrategy.getAppPackageName());
        }
        String deviceID = buglyStrategy.getDeviceID();
        if (deviceID != null) {
            if (deviceID.length() > 100) {
                String substring4 = deviceID.substring(0, 100);
                C1199X.m3076e("deviceId %s length is over limit %d substring to %s", deviceID, 100, substring4);
                deviceID = substring4;
            }
            c1140a.m3406d(deviceID);
            C1199X.m3078c("[param] Set device ID: %s", deviceID);
        }
        c1140a.f1047j = buglyStrategy.isUploadProcess();
        C1205ba.f1460c = buglyStrategy.isBuglyLogUpload();
    }

    /* renamed from: a */
    public static synchronized void m3632a(AbstractC1081a abstractC1081a) {
        synchronized (C1082b.class) {
            if (!f702b.contains(abstractC1081a)) {
                f702b.add(abstractC1081a);
            }
        }
    }

    /* renamed from: a */
    public static boolean m3631a(C1140a c1140a) {
        List<String> list = c1140a.f1019P;
        c1140a.getClass();
        return list != null && list.contains("bugly");
    }
}
