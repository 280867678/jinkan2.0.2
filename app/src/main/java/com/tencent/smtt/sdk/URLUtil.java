package com.tencent.smtt.sdk;

/* loaded from: classes4.dex */
public final class URLUtil {
    public static String composeSearchUrl(String str, String str2, String str3) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.URLUtil.composeSearchUrl(str, str2, str3) : m2294a.m2289c().m2276a(str, str2, str3);
    }

    public static byte[] decode(byte[] bArr) throws IllegalArgumentException {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.URLUtil.decode(bArr) : m2294a.m2289c().m2272a(bArr);
    }

    public static final String guessFileName(String str, String str2, String str3) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.URLUtil.guessFileName(str, str2, str3) : m2294a.m2289c().m2266b(str, str2, str3);
    }

    public static String guessUrl(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.URLUtil.guessUrl(str) : m2294a.m2289c().m2236m(str);
    }

    public static boolean isAboutUrl(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.URLUtil.isAboutUrl(str) : m2294a.m2289c().m2228q(str);
    }

    public static boolean isAssetUrl(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.URLUtil.isAssetUrl(str) : m2294a.m2289c().m2234n(str);
    }

    public static boolean isContentUrl(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.URLUtil.isContentUrl(str) : m2294a.m2289c().m2222w(str);
    }

    @Deprecated
    public static boolean isCookielessProxyUrl(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.URLUtil.isCookielessProxyUrl(str) : m2294a.m2289c().m2232o(str);
    }

    public static boolean isDataUrl(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.URLUtil.isDataUrl(str) : m2294a.m2289c().m2227r(str);
    }

    public static boolean isFileUrl(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.URLUtil.isFileUrl(str) : m2294a.m2289c().m2230p(str);
    }

    public static boolean isHttpUrl(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.URLUtil.isHttpUrl(str) : m2294a.m2289c().m2225t(str);
    }

    public static boolean isHttpsUrl(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.URLUtil.isHttpsUrl(str) : m2294a.m2289c().m2224u(str);
    }

    public static boolean isJavaScriptUrl(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.URLUtil.isJavaScriptUrl(str) : m2294a.m2289c().m2226s(str);
    }

    public static boolean isNetworkUrl(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.URLUtil.isNetworkUrl(str) : m2294a.m2289c().m2223v(str);
    }

    public static boolean isValidUrl(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.URLUtil.isValidUrl(str) : m2294a.m2289c().m2221x(str);
    }

    public static String stripAnchor(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.URLUtil.stripAnchor(str) : m2294a.m2289c().m2220y(str);
    }
}
