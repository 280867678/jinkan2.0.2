package com.tencent.bugly.crashreport.crash.p042h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import com.umeng.analytics.pro.C1615d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import me.tvspark.outline;
import org.json.JSONObject;

/* renamed from: com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface */
/* loaded from: classes3.dex */
public class H5JavaScriptInterface {

    /* renamed from: a */
    public static HashSet<Integer> f1259a = new HashSet<>();

    /* renamed from: b */
    public String f1260b = null;

    /* renamed from: c */
    public Thread f1261c = null;

    /* renamed from: d */
    public String f1262d = null;

    /* renamed from: e */
    public Map<String, String> f1263e = null;

    /* renamed from: a */
    private C1165a m3245a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C1165a c1165a = new C1165a();
                String string2 = jSONObject.getString("projectRoot");
                c1165a.f1264a = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString(C1615d.f3292R);
                c1165a.f1265b = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString("url");
                c1165a.f1266c = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString("userAgent");
                c1165a.f1267d = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString("language");
                c1165a.f1268e = string6;
                if (string6 == null) {
                    return null;
                }
                String string7 = jSONObject.getString("name");
                c1165a.f1269f = string7;
                if (string7 == null || string7.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int indexOf = string.indexOf("\n");
                if (indexOf < 0) {
                    C1199X.m3076e("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                c1165a.f1271h = string.substring(indexOf + 1);
                String substring = string.substring(0, indexOf);
                c1165a.f1270g = substring;
                int indexOf2 = substring.indexOf(":");
                if (indexOf2 > 0) {
                    c1165a.f1270g = c1165a.f1270g.substring(indexOf2 + 1);
                }
                c1165a.f1272i = jSONObject.getString("file");
                if (c1165a.f1269f == null) {
                    return null;
                }
                long j = jSONObject.getLong("lineNumber");
                c1165a.f1273j = j;
                if (j < 0) {
                    return null;
                }
                long j2 = jSONObject.getLong("columnNumber");
                c1165a.f1274k = j2;
                if (j2 < 0) {
                    return null;
                }
                C1199X.m3078c("H5 crash information is following: ", new Object[0]);
                StringBuilder sb = new StringBuilder();
                sb.append("[projectRoot]: ");
                sb.append(c1165a.f1264a);
                C1199X.m3078c(sb.toString(), new Object[0]);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[context]: ");
                sb2.append(c1165a.f1265b);
                C1199X.m3078c(sb2.toString(), new Object[0]);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("[url]: ");
                sb3.append(c1165a.f1266c);
                C1199X.m3078c(sb3.toString(), new Object[0]);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("[userAgent]: ");
                sb4.append(c1165a.f1267d);
                C1199X.m3078c(sb4.toString(), new Object[0]);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[language]: ");
                sb5.append(c1165a.f1268e);
                C1199X.m3078c(sb5.toString(), new Object[0]);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("[name]: ");
                sb6.append(c1165a.f1269f);
                C1199X.m3078c(sb6.toString(), new Object[0]);
                StringBuilder sb7 = new StringBuilder();
                sb7.append("[message]: ");
                sb7.append(c1165a.f1270g);
                C1199X.m3078c(sb7.toString(), new Object[0]);
                StringBuilder sb8 = new StringBuilder();
                sb8.append("[stacktrace]: \n");
                sb8.append(c1165a.f1271h);
                C1199X.m3078c(sb8.toString(), new Object[0]);
                StringBuilder sb9 = new StringBuilder();
                sb9.append("[file]: ");
                sb9.append(c1165a.f1272i);
                C1199X.m3078c(sb9.toString(), new Object[0]);
                StringBuilder sb10 = new StringBuilder();
                sb10.append("[lineNumber]: ");
                sb10.append(c1165a.f1273j);
                C1199X.m3078c(sb10.toString(), new Object[0]);
                StringBuilder sb11 = new StringBuilder();
                sb11.append("[columnNumber]: ");
                sb11.append(c1165a.f1274k);
                C1199X.m3078c(sb11.toString(), new Object[0]);
                return c1165a;
            } catch (Throwable th) {
                if (!C1199X.m3080b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m3244a(Thread thread) {
        if (thread == null) {
            return null;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\n");
        for (int i = 2; i < thread.getStackTrace().length; i++) {
            StackTraceElement stackTraceElement = thread.getStackTrace()[i];
            if (!stackTraceElement.toString().contains("crashreport")) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.toString());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\n");
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    /* renamed from: a */
    public static Map<String, String> m3247a(CrashReport.WebViewInterface webViewInterface) {
        HashMap hashMap = new HashMap();
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append((Object) webViewInterface.getContentDescription());
        hashMap.put("[WebView] ContentDescription", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        return hashMap;
    }

    /* renamed from: a */
    public static void m3246a(C1165a c1165a, Thread thread, Map<String, String> map) {
        if (c1165a != null) {
            InnerApi.postH5CrashAsync(thread, c1165a.f1269f, c1165a.f1270g, c1165a.f1271h, map);
        }
    }

    public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface webViewInterface) {
        if (webViewInterface == null || f1259a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f1259a.add(Integer.valueOf(webViewInterface.hashCode()));
        Thread currentThread = Thread.currentThread();
        h5JavaScriptInterface.f1261c = currentThread;
        h5JavaScriptInterface.f1262d = m3244a(currentThread);
        h5JavaScriptInterface.f1263e = m3247a(webViewInterface);
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        C1199X.m3076e("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            C1199X.m3076e("Payload from JS is null.", new Object[0]);
            return;
        }
        String m3004c = C1208ca.m3004c(str.getBytes());
        String str2 = this.f1260b;
        if (str2 != null && str2.equals(m3004c)) {
            C1199X.m3076e("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f1260b = m3004c;
        C1199X.m3076e("Handling JS exception ...", new Object[0]);
        C1165a m3245a = m3245a(str);
        if (m3245a == null) {
            C1199X.m3076e("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(m3245a.m3243a());
        linkedHashMap.putAll(this.f1263e);
        linkedHashMap.put("Java Stack", this.f1262d);
        m3246a(m3245a, this.f1261c, linkedHashMap);
    }
}
