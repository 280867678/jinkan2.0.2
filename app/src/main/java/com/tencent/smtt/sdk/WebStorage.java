package com.tencent.smtt.sdk;

import java.util.Map;

/* loaded from: classes4.dex */
public class WebStorage {

    /* renamed from: a */
    public static WebStorage f1992a;

    @Deprecated
    /* loaded from: classes4.dex */
    public interface QuotaUpdater {
        void updateQuota(long j);
    }

    /* renamed from: a */
    public static synchronized WebStorage m2708a() {
        WebStorage webStorage;
        synchronized (WebStorage.class) {
            if (f1992a == null) {
                f1992a = new WebStorage();
            }
            webStorage = f1992a;
        }
        return webStorage;
    }

    public static WebStorage getInstance() {
        return m2708a();
    }

    public void deleteAllData() {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.WebStorage.getInstance().deleteAllData();
        } else {
            m2294a.m2289c().m2235n();
        }
    }

    public void deleteOrigin(String str) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.WebStorage.getInstance().deleteOrigin(str);
        } else {
            m2294a.m2289c().m2256e(str);
        }
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.WebStorage.getInstance().getOrigins(valueCallback);
        } else {
            m2294a.m2289c().m2281a(valueCallback);
        }
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.WebStorage.getInstance().getQuotaForOrigin(str, valueCallback);
        } else {
            m2294a.m2289c().m2267b(str, valueCallback);
        }
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.WebStorage.getInstance().getUsageForOrigin(str, valueCallback);
        } else {
            m2294a.m2289c().m2278a(str, valueCallback);
        }
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.WebStorage.getInstance().setQuotaForOrigin(str, j);
        } else {
            m2294a.m2289c().m2279a(str, j);
        }
    }
}
