package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.proguard.AbstractC1184I;
import com.tencent.bugly.proguard.C1185J;
import com.tencent.bugly.proguard.C1208ca;
import java.util.Map;

/* loaded from: classes3.dex */
public class Bugly {

    /* renamed from: a */
    public static boolean f676a = false;
    public static Context applicationContext = null;
    public static boolean enable = true;

    public static synchronized String getAppChannel() {
        byte[] bArr;
        synchronized (Bugly.class) {
            C1140a m3394m = C1140a.m3394m();
            if (m3394m == null) {
                return null;
            }
            if (TextUtils.isEmpty(m3394m.f1012I)) {
                C1185J m3172a = C1185J.m3172a();
                if (m3172a == null) {
                    return m3394m.f1012I;
                }
                Map<String, byte[]> m3169a = m3172a.m3169a(556, (AbstractC1184I) null, true);
                if (m3169a != null && (bArr = m3169a.get("app_channel")) != null) {
                    return new String(bArr);
                }
            }
            return m3394m.f1012I;
        }
    }

    public static void init(Context context, String str, boolean z) {
        init(context, str, z, null);
    }

    public static synchronized void init(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (Bugly.class) {
            if (f676a) {
                return;
            }
            f676a = true;
            Context m3044a = C1208ca.m3044a(context);
            applicationContext = m3044a;
            if (m3044a == null) {
                return;
            }
            C1082b.m3632a(CrashModule.getInstance());
            C1082b.m3632a(Beta.getInstance());
            C1082b.f701a = enable;
            C1082b.m3634a(applicationContext, str, z, buglyStrategy);
        }
    }

    public static void putUserData(Context context, String str, String str2) {
        CrashReport.putUserData(context, str, str2);
    }

    public static void setAppChannel(Context context, String str) {
        CrashReport.setAppChannel(context, str);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        CrashReport.setIsDevelopmentDevice(context, z);
    }

    public static void setUserId(Context context, String str) {
        CrashReport.setUserId(context, str);
    }

    public static void setUserTag(Context context, int i) {
        CrashReport.setUserSceneTag(context, i);
    }
}
