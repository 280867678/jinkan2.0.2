package com.tencent.smtt.sdk;

import java.util.Set;

/* loaded from: classes4.dex */
public class GeolocationPermissions {

    /* renamed from: a */
    public static GeolocationPermissions f1712a;

    /* renamed from: a */
    public static synchronized GeolocationPermissions m2851a() {
        GeolocationPermissions geolocationPermissions;
        synchronized (GeolocationPermissions.class) {
            if (f1712a == null) {
                f1712a = new GeolocationPermissions();
            }
            geolocationPermissions = f1712a;
        }
        return geolocationPermissions;
    }

    public static GeolocationPermissions getInstance() {
        return m2851a();
    }

    public void allow(String str) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.GeolocationPermissions.getInstance().allow(str);
        } else {
            m2294a.m2289c().m2250g(str);
        }
    }

    public void clear(String str) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.GeolocationPermissions.getInstance().clear(str);
        } else {
            m2294a.m2289c().m2253f(str);
        }
    }

    public void clearAll() {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.GeolocationPermissions.getInstance().clearAll();
        } else {
            m2294a.m2289c().m2233o();
        }
    }

    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.GeolocationPermissions.getInstance().getAllowed(str, valueCallback);
        } else {
            m2294a.m2289c().m2262c(str, valueCallback);
        }
    }

    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.GeolocationPermissions.getInstance().getOrigins(valueCallback);
        } else {
            m2294a.m2289c().m2269b(valueCallback);
        }
    }
}
