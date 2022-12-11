package com.tencent.bugly.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.C1082b;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.crashreport.biz.C1138f;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.strategy.C1145c;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.C1164h;
import com.tencent.bugly.crashreport.crash.C1172k;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.p042h5.C1166b;
import com.tencent.bugly.crashreport.crash.p042h5.H5JavaScriptInterface;
import com.tencent.bugly.proguard.C1187K;
import com.tencent.bugly.proguard.C1198W;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1200Y;
import com.tencent.bugly.proguard.C1208ca;
import java.net.InetAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class CrashReport {

    /* renamed from: a */
    public static Context f947a;

    /* loaded from: classes3.dex */
    public static class CrashHandleCallback extends BuglyStrategy.C1080a {
    }

    /* loaded from: classes3.dex */
    public static class UserStrategy extends BuglyStrategy {

        /* renamed from: s */
        public CrashHandleCallback f948s;

        public UserStrategy(Context context) {
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized int getCallBackType() {
            return this.f693q;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized boolean getCloseErrorCallback() {
            return this.f694r;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        /* renamed from: getCrashHandleCallback  reason: collision with other method in class */
        public synchronized CrashHandleCallback mo4835getCrashHandleCallback() {
            return this.f948s;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCallBackType(int i) {
            this.f693q = i;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCloseErrorCallback(boolean z) {
            this.f694r = z;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f948s = crashHandleCallback;
        }
    }

    /* loaded from: classes3.dex */
    public interface WebViewInterface {
        void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str);

        CharSequence getContentDescription();

        String getUrl();

        void loadUrl(String str);

        void setJavaScriptEnabled(boolean z);
    }

    public static void closeBugly() {
        if (C1082b.f701a && CrashModule.getInstance().hasInitialized() && f947a != null) {
            BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
            if (buglyBroadcastReceiver != null) {
                buglyBroadcastReceiver.unregister(f947a);
            }
            closeCrashReport();
            C1138f.m3462a(f947a);
            C1198W m3089c = C1198W.m3089c();
            if (m3089c == null) {
                return;
            }
            m3089c.m3090b();
        }
    }

    public static void closeCrashReport() {
        if (C1082b.f701a && CrashModule.getInstance().hasInitialized()) {
            C1164h.m3262g().m3268b();
        }
    }

    public static void closeNativeReport() {
        if (C1082b.f701a && CrashModule.getInstance().hasInitialized()) {
            C1164h.m3262g().m3264e();
        }
    }

    public static void enableBugly(boolean z) {
        C1082b.f701a = z;
    }

    public static void enableObtainId(Context context, boolean z) {
        if (C1082b.f701a && context != null) {
            C1140a.m3421a(context).m3412b(z);
        }
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (C1082b.f701a && context != null) {
            return C1140a.m3421a(context).m3417b();
        }
        return new HashSet();
    }

    public static String getAppChannel() {
        return (C1082b.f701a && CrashModule.getInstance().hasInitialized()) ? C1140a.m3421a(f947a).f1012I : "unknown";
    }

    public static String getAppID() {
        return (C1082b.f701a && CrashModule.getInstance().hasInitialized()) ? C1140a.m3421a(f947a).m3405e() : "unknown";
    }

    public static String getAppVer() {
        return (C1082b.f701a && CrashModule.getInstance().hasInitialized()) ? C1140a.m3421a(f947a).f1008E : "unknown";
    }

    public static String getBuglyVersion(Context context) {
        if (context == null) {
            C1199X.m3076e("Please call with context.", new Object[0]);
            return "unknown";
        }
        return C1140a.m3421a(context).m3388s();
    }

    public static Proxy getHttpProxy() {
        return C1200Y.m3074a();
    }

    public static Map<String, String> getSdkExtraData() {
        if (!C1082b.f701a) {
            return new HashMap();
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return C1140a.m3421a(f947a).f1050ka;
        }
        return null;
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!C1082b.f701a) {
            return new HashMap();
        }
        if (context != null) {
            return C1140a.m3421a(context).f1050ka;
        }
        C1199X.m3076e("Context should not be null.", new Object[0]);
        return null;
    }

    public static String getUserData(Context context, String str) {
        if (C1082b.f701a && context != null) {
            if (!C1208ca.m3012b(str)) {
                return C1140a.m3421a(context).m3420a(str);
            }
            return null;
        }
        return "unknown";
    }

    public static int getUserDatasSize(Context context) {
        if (C1082b.f701a && context != null) {
            return C1140a.m3421a(context).m3381z();
        }
        return -1;
    }

    public static String getUserId() {
        return (C1082b.f701a && CrashModule.getInstance().hasInitialized()) ? C1140a.m3421a(f947a).m3382y() : "unknown";
    }

    public static int getUserSceneTagId(Context context) {
        if (C1082b.f701a && context != null) {
            return C1140a.m3421a(context).m3429A();
        }
        return -1;
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        f947a = context;
        C1082b.m3632a(CrashModule.getInstance());
        C1082b.m3636a(context);
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f947a = context;
        C1082b.m3632a(CrashModule.getInstance());
        C1082b.m3635a(context, userStrategy);
    }

    public static void initCrashReport(Context context, String str, boolean z) {
        initCrashReport(context, str, z, null);
    }

    public static void initCrashReport(Context context, String str, boolean z, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f947a = context;
        C1082b.m3632a(CrashModule.getInstance());
        C1082b.m3634a(context, str, z, userStrategy);
    }

    public static boolean isLastSessionCrash() {
        if (C1082b.f701a && CrashModule.getInstance().hasInitialized()) {
            return C1164h.m3262g().m3261h();
        }
        return false;
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread());
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    public static void postCatchedException(Throwable th, Thread thread, boolean z) {
        if (C1082b.f701a && CrashModule.getInstance().hasInitialized()) {
            if (th == null) {
                C1199X.m3076e("throwable is null, just return", new Object[0]);
                return;
            }
            if (thread == null) {
                thread = Thread.currentThread();
            }
            C1164h.m3262g().m3271a(thread, th, false, (String) null, (byte[]) null, z);
        }
    }

    public static void postException(int i, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i, str, str2, str3, map);
    }

    public static void postException(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        if (C1082b.f701a && CrashModule.getInstance().hasInitialized()) {
            C1172k.m3210a(thread, i, str, str2, str3, map);
        }
    }

    public static void putSdkData(Context context, String str, String str2) {
        if (context == null || C1208ca.m3012b(str) || C1208ca.m3012b(str2)) {
            return;
        }
        String replace = str.replace("[a-zA-Z[0-9]]+", "");
        if (replace.length() > 100) {
            String.format("putSdkData key length over limit %d, will be cutted.", 50);
            replace = replace.substring(0, 50);
        }
        if (str2.length() > 500) {
            String.format("putSdkData value length over limit %d, will be cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        C1140a.m3421a(context).m3419a(replace, str2);
        C1199X.m3077d(String.format("[param] putSdkData data: %s - %s", replace, str2), new Object[0]);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (C1082b.f701a && context != null) {
            if (str == null) {
                C1199X.m3076e("putUserData args key should not be null or empty", new Object[0]);
            } else if (str2 == null) {
                C1199X.m3076e("putUserData args value should not be null", new Object[0]);
            } else {
                if (str2.length() > 200) {
                    C1199X.m3076e("user data value length over limit %d, it will be cutted!", 200);
                    str2 = str2.substring(0, 200);
                }
                C1140a m3421a = C1140a.m3421a(context);
                if (m3421a.m3417b().contains(str)) {
                    NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                    if (nativeCrashHandler != null) {
                        nativeCrashHandler.putKeyValueToNative(str, str2);
                    }
                    C1140a.m3421a(context).m3413b(str, str2);
                    C1199X.m3084a("replace KV %s %s", str, str2);
                } else if (m3421a.m3381z() >= 50) {
                    C1199X.m3076e("user data size is over limit %d, it will be cutted!", 50);
                } else {
                    if (str.length() > 50) {
                        C1199X.m3076e("user data key length over limit %d , will drop this new key %s", 50, str);
                        str = str.substring(0, 50);
                    }
                    NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
                    if (nativeCrashHandler2 != null) {
                        nativeCrashHandler2.putKeyValueToNative(str, str2);
                    }
                    C1140a.m3421a(context).m3413b(str, str2);
                    C1199X.m3077d("[param] set user data: %s - %s", str, str2);
                }
            }
        }
    }

    public static String removeUserData(Context context, String str) {
        if (C1082b.f701a && context != null) {
            if (C1208ca.m3012b(str)) {
                return null;
            }
            C1199X.m3077d("[param] remove user data: %s", str);
            return C1140a.m3421a(context).m3414b(str);
        }
        return "unknown";
    }

    public static void setAppChannel(Context context, String str) {
        if (!C1082b.f701a || context == null || str == null) {
            return;
        }
        C1140a.m3421a(context).f1012I = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler == null) {
            return;
        }
        nativeCrashHandler.setNativeAppChannel(str);
    }

    public static void setAppPackage(Context context, String str) {
        if (!C1082b.f701a || context == null || str == null) {
            return;
        }
        C1140a.m3421a(context).f1041g = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler == null) {
            return;
        }
        nativeCrashHandler.setNativeAppPackage(str);
    }

    public static void setAppVersion(Context context, String str) {
        if (!C1082b.f701a || context == null || str == null) {
            return;
        }
        C1140a.m3421a(context).f1008E = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler == null) {
            return;
        }
        nativeCrashHandler.setNativeAppVersion(str);
    }

    public static void setBuglyDbName(String str) {
        if (!C1082b.f701a) {
            return;
        }
        C1187K.f1394a = str;
    }

    public static void setContext(Context context) {
        f947a = context;
    }

    public static void setCrashFilter(String str) {
        if (!C1082b.f701a) {
            return;
        }
        C1164h.f1244n = str;
    }

    public static void setCrashRegularFilter(String str) {
        if (!C1082b.f701a) {
            return;
        }
        C1164h.f1245o = str;
    }

    public static void setHandleNativeCrashInJava(boolean z) {
        if (!C1082b.f701a) {
            return;
        }
        NativeCrashHandler.setShouldHandleInJava(z);
    }

    public static void setHttpProxy(String str, int i) {
        C1200Y.m3073a(str, i);
    }

    public static void setHttpProxy(InetAddress inetAddress, int i) {
        C1200Y.m3072a(inetAddress, i);
    }

    public static void setIsAppForeground(Context context, boolean z) {
        if (!C1082b.f701a) {
            return;
        }
        if (context == null) {
            C1199X.m3076e("Context should not be null.", new Object[0]);
            return;
        }
        Object[] objArr = new Object[0];
        if (z) {
            C1199X.m3084a("App is in foreground.", objArr);
        } else {
            C1199X.m3084a("App is in background.", objArr);
        }
        C1140a.m3421a(context).m3418a(z);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        if (!C1082b.f701a) {
            return;
        }
        if (context == null) {
            C1199X.m3076e("Context should not be null.", new Object[0]);
            return;
        }
        Object[] objArr = new Object[0];
        if (z) {
            C1199X.m3084a("This is a development device.", objArr);
        } else {
            C1199X.m3084a("This is not a development device.", objArr);
        }
        C1140a.m3421a(context).f1042ga = z;
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebView webView, boolean z, boolean z2) {
        if (webView == null) {
            return false;
        }
        return setJavascriptMonitor(new C1128a(webView), z, z2);
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z) {
        return setJavascriptMonitor(webViewInterface, z, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z, boolean z2) {
        if (webViewInterface == null) {
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            C1199X.m3081b("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        }
        C1199X.m3078c("Set Javascript exception monitor of webview.", new Object[0]);
        if (!C1082b.f701a) {
            return false;
        }
        C1199X.m3084a("URL of webview is %s", webViewInterface.getUrl());
        C1199X.m3078c("Enable the javascript needed by webview monitor.", new Object[0]);
        webViewInterface.setJavaScriptEnabled(true);
        H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(webViewInterface);
        if (h5JavaScriptInterface != null) {
            C1199X.m3078c("Add a secure javascript interface to the webview.", new Object[0]);
            webViewInterface.addJavascriptInterface(h5JavaScriptInterface, "exceptionUploader");
        }
        if (z) {
            C1199X.m3078c("Inject bugly.js(v%s) to the webview.", C1166b.m3241b());
            String m3242a = C1166b.m3242a();
            if (m3242a == null) {
                C1199X.m3081b("Failed to inject Bugly.js.", C1166b.m3241b());
                return false;
            }
            webViewInterface.loadUrl("javascript:" + m3242a);
        }
        return true;
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (C1082b.f701a && context != null && !C1208ca.m3012b(str) && !C1208ca.m3012b(str2)) {
            C1140a.m3421a(context).m3408c(str, str2);
        }
    }

    public static void setServerUrl(String str) {
        if (C1208ca.m3012b(str) || !C1208ca.m3006c(str)) {
            return;
        }
        C1145c.m3345a(str);
        StrategyBean.f1084a = str;
        StrategyBean.f1085b = str;
    }

    public static void setSessionIntervalMills(long j) {
        if (!C1082b.f701a) {
            return;
        }
        C1138f.m3452c(j);
    }

    public static void setUserId(Context context, String str) {
        if (C1082b.f701a && context != null) {
            if (TextUtils.isEmpty(str)) {
                C1199X.m3076e("userId should not be null", new Object[0]);
                return;
            }
            if (str.length() > 100) {
                String substring = str.substring(0, 100);
                C1199X.m3076e("userId %s length is over limit %d substring to %s", str, 100, substring);
                str = substring;
            }
            if (str.equals(C1140a.m3421a(context).m3382y())) {
                return;
            }
            C1140a.m3421a(context).m3400g(str);
            C1199X.m3077d("[user] set userId : %s", str);
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeUserId(str);
            }
            if (!CrashModule.getInstance().hasInitialized()) {
                return;
            }
            C1138f.m3440l();
        }
    }

    public static void setUserId(String str) {
        if (C1082b.f701a && CrashModule.getInstance().hasInitialized()) {
            setUserId(f947a, str);
        }
    }

    public static void setUserSceneTag(Context context, int i) {
        if (C1082b.f701a && context != null) {
            if (i <= 0) {
                C1199X.m3076e("setTag args tagId should > 0", new Object[0]);
            }
            C1140a.m3421a(context).m3416b(i);
            C1199X.m3077d("[param] set user scene tag: %d", Integer.valueOf(i));
        }
    }

    public static void startCrashReport() {
        if (C1082b.f701a && CrashModule.getInstance().hasInitialized()) {
            C1164h.m3262g().m3254o();
        }
    }

    public static void testANRCrash() {
        if (C1082b.f701a && CrashModule.getInstance().hasInitialized()) {
            C1199X.m3078c("start to create a anr crash for test!", new Object[0]);
            C1164h.m3262g().m3249t();
        }
    }

    public static void testJavaCrash() {
        if (C1082b.f701a && CrashModule.getInstance().hasInitialized()) {
            C1140a m3394m = C1140a.m3394m();
            if (m3394m != null) {
                m3394m.m3422a(24096);
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(false, false, false);
    }

    public static void testNativeCrash(boolean z, boolean z2, boolean z3) {
        if (C1082b.f701a && CrashModule.getInstance().hasInitialized()) {
            C1199X.m3078c("start to create a native crash for test!", new Object[0]);
            C1164h.m3262g().m3269a(z, z2, z3);
        }
    }
}
