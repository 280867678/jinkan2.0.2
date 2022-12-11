package com.tencent.smtt.sdk;

import android.content.Context;

/* loaded from: classes4.dex */
public class WebViewDatabase {

    /* renamed from: a */
    public static WebViewDatabase f2035a;

    /* renamed from: b */
    public Context f2036b;

    public WebViewDatabase(Context context) {
        this.f2036b = context;
    }

    /* renamed from: a */
    public static synchronized WebViewDatabase m2666a(Context context) {
        WebViewDatabase webViewDatabase;
        synchronized (WebViewDatabase.class) {
            if (f2035a == null) {
                f2035a = new WebViewDatabase(context);
            }
            webViewDatabase = f2035a;
        }
        return webViewDatabase;
    }

    public static WebViewDatabase getInstance(Context context) {
        return m2666a(context);
    }

    public void clearFormData() {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.WebViewDatabase.getInstance(this.f2036b).clearFormData();
        } else {
            m2294a.m2289c().m2251g(this.f2036b);
        }
    }

    public void clearHttpAuthUsernamePassword() {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.WebViewDatabase.getInstance(this.f2036b).clearHttpAuthUsernamePassword();
        } else {
            m2294a.m2289c().m2257e(this.f2036b);
        }
    }

    @Deprecated
    public void clearUsernamePassword() {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.WebViewDatabase.getInstance(this.f2036b).clearUsernamePassword();
        } else {
            m2294a.m2289c().m2264c(this.f2036b);
        }
    }

    public boolean hasFormData() {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.WebViewDatabase.getInstance(this.f2036b).hasFormData() : m2294a.m2289c().m2254f(this.f2036b);
    }

    public boolean hasHttpAuthUsernamePassword() {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.WebViewDatabase.getInstance(this.f2036b).hasHttpAuthUsernamePassword() : m2294a.m2289c().m2260d(this.f2036b);
    }

    @Deprecated
    public boolean hasUsernamePassword() {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.WebViewDatabase.getInstance(this.f2036b).hasUsernamePassword() : m2294a.m2289c().m2270b(this.f2036b);
    }
}
