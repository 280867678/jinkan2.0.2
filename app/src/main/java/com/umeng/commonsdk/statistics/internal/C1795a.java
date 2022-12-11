package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.umeng.commonsdk.statistics.internal.a */
/* loaded from: classes4.dex */
public class C1795a {

    /* renamed from: a */
    public static Context f4120a;

    /* renamed from: b */
    public String f4121b;

    /* renamed from: c */
    public String f4122c;

    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a */
    /* loaded from: classes4.dex */
    public static class C1797a {

        /* renamed from: a */
        public static final C1795a f4123a = new C1795a();
    }

    public C1795a() {
        this.f4121b = null;
        this.f4122c = null;
    }

    /* renamed from: a */
    public static C1795a m434a(Context context) {
        if (f4120a == null && context != null) {
            f4120a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return C1797a.f4123a;
    }

    /* renamed from: e */
    private void m428e(String str) {
        try {
            String replaceAll = str.replaceAll("&=", StringUtils.SPACE).replaceAll("&&", StringUtils.SPACE).replaceAll("==", "/");
            this.f4121b = replaceAll + "/Android/" + Build.DISPLAY + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE + StringUtils.SPACE + HelperUtils.getUmengMD5(UMUtils.getAppkey(f4120a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f4120a, th);
        }
    }

    /* renamed from: f */
    private void m427f(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] split = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(C1543ak.f2979aP);
            for (String str3 : split) {
                if (!TextUtils.isEmpty(str3)) {
                    String substring = str3.substring(0, 2);
                    if (substring.endsWith("=")) {
                        substring = substring.replace("=", "");
                    }
                    sb.append(substring);
                }
            }
            this.f4122c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f4120a, th);
        }
    }

    /* renamed from: a */
    public String m435a() {
        return this.f4122c;
    }

    /* renamed from: a */
    public boolean m433a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith("a");
        }
        return false;
    }

    /* renamed from: b */
    public String m432b() {
        return this.f4121b;
    }

    /* renamed from: b */
    public boolean m431b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith(C1543ak.f2971aH);
        }
        return false;
    }

    /* renamed from: c */
    public boolean m430c(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith(C1543ak.f2967aD);
        }
        return false;
    }

    /* renamed from: d */
    public void m429d(String str) {
        String substring = str.substring(0, str.indexOf(95));
        m427f(substring);
        m428e(substring);
    }
}
