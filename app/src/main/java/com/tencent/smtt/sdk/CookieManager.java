package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.C1460i;
import com.tencent.smtt.utils.TbsLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public class CookieManager {
    public static String LOGTAG = "CookieManager";

    /* renamed from: d */
    public static CookieManager f1692d;

    /* renamed from: a */
    public CopyOnWriteArrayList<C1275b> f1693a;

    /* renamed from: b */
    public String f1694b;

    /* renamed from: c */
    public EnumC1274a f1695c = EnumC1274a.MODE_NONE;

    /* renamed from: e */
    public boolean f1696e = false;

    /* renamed from: f */
    public boolean f1697f = false;

    /* renamed from: com.tencent.smtt.sdk.CookieManager$a */
    /* loaded from: classes4.dex */
    public enum EnumC1274a {
        MODE_NONE,
        MODE_KEYS,
        MODE_ALL
    }

    /* renamed from: com.tencent.smtt.sdk.CookieManager$b */
    /* loaded from: classes4.dex */
    public class C1275b {

        /* renamed from: a */
        public int f1702a;

        /* renamed from: b */
        public String f1703b;

        /* renamed from: c */
        public String f1704c;

        /* renamed from: d */
        public ValueCallback<Boolean> f1705d;

        public C1275b() {
        }
    }

    public static CookieManager getInstance() {
        if (f1692d == null) {
            synchronized (CookieManager.class) {
                if (f1692d == null) {
                    f1692d = new CookieManager();
                }
            }
        }
        return f1692d;
    }

    public static int getROMCookieDBVersion(Context context) {
        return context.getSharedPreferences("cookiedb_info", 4).getInt("db_version", -1);
    }

    public static void setROMCookieDBVersion(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("cookiedb_info", 4).edit();
        edit.putInt("db_version", i);
        edit.commit();
    }

    /* renamed from: a */
    public synchronized void m2854a() {
        this.f1697f = true;
        if (this.f1693a != null && this.f1693a.size() != 0) {
            C1416x m2294a = C1416x.m2294a();
            if (m2294a == null || !m2294a.m2291b()) {
                Iterator<C1275b> it = this.f1693a.iterator();
                while (it.hasNext()) {
                    C1275b next = it.next();
                    int i = next.f1702a;
                    if (i == 1) {
                        C1460i.m2049a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, next.f1703b, next.f1704c, next.f1705d);
                    } else if (i == 2) {
                        android.webkit.CookieManager.getInstance().setCookie(next.f1703b, next.f1704c);
                    }
                }
            } else {
                Iterator<C1275b> it2 = this.f1693a.iterator();
                while (it2.hasNext()) {
                    C1275b next2 = it2.next();
                    int i2 = next2.f1702a;
                    if (i2 == 1) {
                        setCookie(next2.f1703b, next2.f1704c, next2.f1705d);
                    } else if (i2 == 2) {
                        setCookie(next2.f1703b, next2.f1704c);
                    }
                }
            }
            this.f1693a.clear();
        }
    }

    /* renamed from: a */
    public synchronized void m2853a(Context context, boolean z, boolean z2) {
        int i;
        int m2575d;
        if (this.f1695c != EnumC1274a.MODE_NONE && context != null && TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME) && !this.f1696e) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = 0;
            String str = LOGTAG;
            TbsLog.m2155i(str, "compatiableCookieDatabaseIfNeed,isX5Inited:" + z + ",useX5:" + z2);
            if (!z && !QbSdk.getIsSysWebViewForcedByOuter() && !QbSdk.f1740a) {
                C1416x.m2294a().m2293a(context);
                return;
            }
            int i2 = 0;
            r4 = false;
            r4 = false;
            boolean z3 = false;
            if (QbSdk.getIsSysWebViewForcedByOuter() || QbSdk.f1740a) {
                z2 = false;
            }
            boolean canUseFunction = TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.USEX5_FILE_NAME);
            String str2 = LOGTAG;
            TbsLog.m2155i(str2, "usex5 : mUseX5LastProcess->" + canUseFunction + ",useX5:" + z2);
            TbsExtensionFunctionManager.getInstance().setFunctionEnable(context, TbsExtensionFunctionManager.USEX5_FILE_NAME, z2);
            if (canUseFunction == z2) {
                return;
            }
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            if (TextUtils.isEmpty(this.f1694b)) {
                tbsLogInfo.setErrorCode(701);
                i = 0;
            } else if (C1381p.m2503a().m2446j(context) > 0 && C1381p.m2503a().m2446j(context) < 36001) {
                return;
            } else {
                if (canUseFunction) {
                    m2575d = C1373k.m2575d(context);
                    if (m2575d > 0) {
                        i = getROMCookieDBVersion(context);
                        if (i <= 0) {
                            z3 = true;
                        }
                    }
                    i = 0;
                } else {
                    m2575d = C1373k.m2575d(context);
                    if (m2575d > 0) {
                        String m2462d = C1381p.m2503a().m2462d(context, "cookies_database_version");
                        if (!TextUtils.isEmpty(m2462d)) {
                            try {
                                i = Integer.parseInt(m2462d);
                            } catch (Exception unused) {
                            }
                        }
                    }
                    i = 0;
                }
                if (!z3 && (m2575d <= 0 || i <= 0)) {
                    tbsLogInfo.setErrorCode(702);
                } else if (i >= m2575d) {
                    tbsLogInfo.setErrorCode(703);
                } else {
                    C1373k.m2580a(context, this.f1695c, this.f1694b, z3, z2);
                    tbsLogInfo.setErrorCode(TbsListener.ErrorCode.INFO_COOKIE_SWITCH_TRANSFER);
                    j = System.currentTimeMillis() - currentTimeMillis;
                }
                i2 = m2575d;
            }
            tbsLogInfo.setFailDetail("x5->sys:" + canUseFunction + " from:" + i2 + " to:" + i + ",timeused:" + j);
            TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_COOKIE_DB_SWITCH, tbsLogInfo);
        }
    }

    public boolean acceptCookie() {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.CookieManager.getInstance().acceptCookie() : m2294a.m2289c().m2261d();
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            Object m2049a = C1460i.m2049a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", new Class[]{android.webkit.WebView.class}, webView.getView());
            if (m2049a == null) {
                return false;
            }
            return ((Boolean) m2049a).booleanValue();
        }
        Object invokeStaticMethod = m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, webView.getView());
        if (invokeStaticMethod == null) {
            return true;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public void flush() {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            C1460i.m2049a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
        } else {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
        }
    }

    public String getCookie(String str) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            try {
                return android.webkit.CookieManager.getInstance().getCookie(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return m2294a.m2289c().m2280a(str);
    }

    public boolean hasCookies() {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.CookieManager.getInstance().hasCookies() : m2294a.m2289c().m2249h();
    }

    @Deprecated
    public void removeAllCookie() {
        CopyOnWriteArrayList<C1275b> copyOnWriteArrayList = this.f1693a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.CookieManager.getInstance().removeAllCookie();
        } else {
            m2294a.m2289c().m2258e();
        }
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        CopyOnWriteArrayList<C1275b> copyOnWriteArrayList = this.f1693a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            C1460i.m2049a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        } else {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        }
    }

    @Deprecated
    public void removeExpiredCookie() {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
        } else {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        }
    }

    @Deprecated
    public void removeSessionCookie() {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.CookieManager.getInstance().removeSessionCookie();
        } else {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            C1460i.m2049a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        } else {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        }
    }

    public synchronized void setAcceptCookie(boolean z) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.CookieManager.getInstance().setAcceptCookie(z);
        } else {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            C1460i.m2049a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", new Class[]{android.webkit.WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        } else {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        }
    }

    public synchronized void setCookie(String str, String str2) {
        setCookie(str, str2, false);
    }

    public synchronized void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            if (!C1416x.m2294a().m2288d()) {
                C1275b c1275b = new C1275b();
                c1275b.f1702a = 1;
                c1275b.f1703b = str;
                c1275b.f1704c = str2;
                c1275b.f1705d = valueCallback;
                if (this.f1693a == null) {
                    this.f1693a = new CopyOnWriteArrayList<>();
                }
                this.f1693a.add(c1275b);
            }
            if (this.f1697f) {
                C1460i.m2049a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, str, str2, valueCallback);
            }
        } else {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, str, str2, valueCallback);
        }
    }

    public synchronized void setCookie(String str, String str2, boolean z) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            if (this.f1697f || z) {
                android.webkit.CookieManager.getInstance().setCookie(str, str2);
            }
            if (!C1416x.m2294a().m2288d()) {
                C1275b c1275b = new C1275b();
                c1275b.f1702a = 2;
                c1275b.f1703b = str;
                c1275b.f1704c = str2;
                c1275b.f1705d = null;
                if (this.f1693a == null) {
                    this.f1693a = new CopyOnWriteArrayList<>();
                }
                this.f1693a.add(c1275b);
            }
        } else {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class}, str, str2);
        }
    }

    public boolean setCookieCompatialbeMode(Context context, EnumC1274a enumC1274a, String str, boolean z) {
        System.currentTimeMillis();
        if (context == null || !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME)) {
            return false;
        }
        this.f1695c = enumC1274a;
        if (str != null) {
            this.f1694b = str;
        }
        if (this.f1695c == EnumC1274a.MODE_NONE || !z || C1416x.m2294a().m2288d()) {
            return true;
        }
        C1416x.m2294a().m2293a(context);
        return true;
    }

    public void setCookies(Map<String, String[]> map) {
        C1416x m2294a = C1416x.m2294a();
        if (!((m2294a == null || !m2294a.m2291b()) ? false : m2294a.m2289c().m2274a(map))) {
            for (String str : map.keySet()) {
                for (String str2 : map.get(str)) {
                    setCookie(str, str2);
                }
            }
        }
    }
}
