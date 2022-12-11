package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5CoreServiceWorkerController;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.IconListener;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.TbsLog;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.smtt.sdk.y */
/* loaded from: classes4.dex */
public class C1417y {

    /* renamed from: a */
    public DexLoader f2342a;

    public C1417y(DexLoader dexLoader) {
        this.f2342a = dexLoader;
    }

    /* renamed from: a */
    public int m2283a(Context context, String str, Map<String, String> map, String str2, android.webkit.ValueCallback<String> valueCallback) {
        if (TbsDownloader.getOverSea(context)) {
            return -103;
        }
        DexLoader dexLoader = this.f2342a;
        if (str2 != null) {
            Object invokeStaticMethod = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, String.class}, context, str, str2);
            if (invokeStaticMethod != null) {
                return ((Integer) invokeStaticMethod).intValue();
            }
            return -104;
        }
        Object invokeStaticMethod2 = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class, android.webkit.ValueCallback.class}, context, str, map, valueCallback);
        if (invokeStaticMethod2 == null) {
            invokeStaticMethod2 = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class}, context, str, map);
        }
        if (invokeStaticMethod2 == null) {
            invokeStaticMethod2 = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class}, context, str);
        }
        if (invokeStaticMethod2 != null) {
            return ((Integer) invokeStaticMethod2).intValue();
        }
        return -104;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0075 A[RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IX5WebViewBase m2285a(Context context) {
        IX5WebViewBase iX5WebViewBase;
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new Class[]{Context.class}, context);
        try {
            if (invokeStaticMethod == null) {
                Object invokeStaticMethod2 = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof Throwable)) {
                    TbsCoreLoadStat.getInstance().m2814a(context, TbsListener.ErrorCode.THROWABLE_INITX5CORE, (Throwable) invokeStaticMethod2);
                }
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof String)) {
                    TbsCoreLoadStat.getInstance().m2814a(context, TbsListener.ErrorCode.THROWABLE_INITX5CORE, new Throwable((String) invokeStaticMethod2));
                }
                invokeStaticMethod = null;
                iX5WebViewBase = null;
            } else {
                iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod;
                if (iX5WebViewBase != null) {
                    try {
                        if (iX5WebViewBase.getView() == null) {
                            TbsCoreLoadStat.getInstance().m2814a(context, TbsListener.ErrorCode.THROWABLE_INITX5CORE, new Throwable("x5webview.getView is null!"));
                            invokeStaticMethod = null;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (invokeStaticMethod != null) {
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e = e2;
            iX5WebViewBase = null;
        }
        if (invokeStaticMethod != null) {
            return null;
        }
        return iX5WebViewBase;
    }

    /* renamed from: a */
    public InputStream m2275a(String str, boolean z) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[]{String.class, Boolean.TYPE}, str, Boolean.valueOf(z));
        if (invokeStaticMethod == null) {
            return null;
        }
        return (InputStream) invokeStaticMethod;
    }

    /* renamed from: a */
    public String m2280a(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    /* renamed from: a */
    public String m2276a(String str, String str2, String str3) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilComposeSearchUrl", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    /* renamed from: a */
    public void m2282a(Context context, boolean z) {
        TbsLog.m2148w("desktop", " tbsWizard clearAllX5Cache");
        if (z) {
            this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class}, context);
            return;
        }
        try {
            this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class, Boolean.TYPE}, context, Boolean.valueOf(z));
        } catch (Exception unused) {
            this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
            this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
            this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
            this.f2342a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
            this.f2342a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
            Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                this.f2342a.invokeMethod(invokeStaticMethod, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
            }
            Object invokeStaticMethod2 = this.f2342a.invokeStaticMethod("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
            if (invokeStaticMethod2 != null) {
                this.f2342a.invokeMethod(invokeStaticMethod2, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
            }
            this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
        }
    }

    /* renamed from: a */
    public void m2281a(android.webkit.ValueCallback<Map> valueCallback) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetOrigins", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
    }

    /* renamed from: a */
    public void m2279a(String str, long j) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageSetQuotaForOrigin", new Class[]{String.class, Long.TYPE}, str, Long.valueOf(j));
    }

    /* renamed from: a */
    public void m2278a(String str, android.webkit.ValueCallback<Long> valueCallback) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetUsageForOrigin", new Class[]{String.class, android.webkit.ValueCallback.class}, str, valueCallback);
    }

    /* renamed from: a */
    public void m2277a(String str, IconListener iconListener) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new Class[]{String.class, IconListener.class}, str, iconListener);
    }

    /* renamed from: a */
    public void m2273a(boolean z) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webview_setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    /* renamed from: a */
    public boolean m2287a() throws Throwable {
        Method method = this.f2342a.getClassLoader().loadClass("com.tencent.tbs.tbsshell.WebCoreProxy").getMethod("canUseX5", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        return invoke instanceof Boolean ? ((Boolean) invoke).booleanValue() : ((Boolean) invoke).booleanValue();
    }

    /* renamed from: a */
    public boolean m2284a(Context context, String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[]{Context.class, String.class}, context, str);
        if (invokeStaticMethod instanceof Boolean) {
            return ((Boolean) invokeStaticMethod).booleanValue();
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2274a(Map<String, String[]> map) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[]{Map.class}, map);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: a */
    public byte[] m2272a(byte[] bArr) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilDecode", new Class[]{String.class}, bArr);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (byte[]) invokeStaticMethod;
    }

    /* renamed from: a */
    public Uri[] m2286a(int i, Intent intent) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[]{Integer.TYPE, Intent.class}, Integer.valueOf(i), intent);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (Uri[]) invokeStaticMethod;
    }

    /* renamed from: b */
    public DexLoader m2271b() {
        return this.f2342a;
    }

    /* renamed from: b */
    public String m2266b(String str, String str2, String str3) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessFileName", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    /* renamed from: b */
    public void m2269b(android.webkit.ValueCallback<Set<String>> valueCallback) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetOrigins", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
    }

    /* renamed from: b */
    public void m2268b(String str) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new Class[]{String.class}, str);
    }

    /* renamed from: b */
    public void m2267b(String str, android.webkit.ValueCallback<Long> valueCallback) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetQuotaForOrigin", new Class[]{String.class, android.webkit.ValueCallback.class}, str, valueCallback);
    }

    /* renamed from: b */
    public boolean m2270b(Context context) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasUsernamePassword", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: c */
    public Object m2265c() {
        return this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0]);
    }

    /* renamed from: c */
    public void m2264c(Context context) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
    }

    /* renamed from: c */
    public void m2263c(String str) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new Class[]{String.class}, str);
    }

    /* renamed from: c */
    public void m2262c(String str, android.webkit.ValueCallback<Boolean> valueCallback) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetAllowed", new Class[]{String.class, android.webkit.ValueCallback.class}, str, valueCallback);
    }

    /* renamed from: d */
    public void m2259d(String str) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new Class[]{String.class}, str);
    }

    /* renamed from: d */
    public boolean m2261d() {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: d */
    public boolean m2260d(Context context) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasHttpAuthUsernamePassword", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: e */
    public void m2258e() {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
    }

    /* renamed from: e */
    public void m2257e(Context context) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
    }

    /* renamed from: e */
    public void m2256e(String str) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteOrigin", new Class[]{String.class}, str);
    }

    /* renamed from: f */
    public String m2255f() {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    /* renamed from: f */
    public void m2253f(String str) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClear", new Class[]{String.class}, str);
    }

    /* renamed from: f */
    public boolean m2254f(Context context) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: g */
    public Object m2252g() {
        return this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
    }

    /* renamed from: g */
    public void m2251g(Context context) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
    }

    /* renamed from: g */
    public void m2250g(String str) {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsAllow", new Class[]{String.class}, str);
    }

    /* renamed from: h */
    public IX5DateSorter m2248h(Context context) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDateSorter", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (IX5DateSorter) invokeStaticMethod;
    }

    /* renamed from: h */
    public String m2247h(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetFileExtensionFromUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    /* renamed from: h */
    public boolean m2249h() {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: i */
    public IX5WebChromeClient m2246i() {
        Object invokeStaticMethod;
        DexLoader dexLoader = this.f2342a;
        if (dexLoader == null || (invokeStaticMethod = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0])) == null) {
            return null;
        }
        return (IX5WebChromeClient) invokeStaticMethod;
    }

    /* renamed from: i */
    public String m2245i(Context context) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getDefaultUserAgent", new Class[]{Context.class}, context);
        if (invokeStaticMethod instanceof String) {
            return (String) invokeStaticMethod;
        }
        return null;
    }

    /* renamed from: i */
    public boolean m2244i(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasMimeType", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: j */
    public IX5WebViewClient m2243j() {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (IX5WebViewClient) invokeStaticMethod;
    }

    /* renamed from: j */
    public String m2242j(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    /* renamed from: k */
    public IX5WebViewClientExtension m2241k() {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (IX5WebViewClientExtension) invokeStaticMethod;
    }

    /* renamed from: k */
    public boolean m2240k(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: l */
    public String m2238l(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    /* renamed from: l */
    public void m2239l() {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
    }

    /* renamed from: m */
    public String m2236m(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    /* renamed from: m */
    public void m2237m() {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new Object[0]);
    }

    /* renamed from: n */
    public void m2235n() {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteAllData", null, new Object[0]);
    }

    /* renamed from: n */
    public boolean m2234n(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAssetUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: o */
    public void m2233o() {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClearAll", null, new Object[0]);
    }

    /* renamed from: o */
    public boolean m2232o(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsCookielessProxyUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: p */
    public void m2231p() {
        this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
    }

    /* renamed from: p */
    public boolean m2230p(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsFileUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: q */
    public IX5CoreServiceWorkerController m2229q() {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getServiceWorkerController", new Class[0], new Object[0]);
        if (invokeStaticMethod instanceof IX5CoreServiceWorkerController) {
            return (IX5CoreServiceWorkerController) invokeStaticMethod;
        }
        return null;
    }

    /* renamed from: q */
    public boolean m2228q(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAboutUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: r */
    public boolean m2227r(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: s */
    public boolean m2226s(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsJavaScriptUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: t */
    public boolean m2225t(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: u */
    public boolean m2224u(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: v */
    public boolean m2223v(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsNetworkUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: w */
    public boolean m2222w(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsContentUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: x */
    public boolean m2221x(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsValidUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: y */
    public String m2220y(String str) {
        Object invokeStaticMethod = this.f2342a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilStripAnchor", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }
}
