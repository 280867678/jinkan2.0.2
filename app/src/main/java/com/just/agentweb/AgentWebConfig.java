package com.just.agentweb;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.stub.StubApp;
import java.io.File;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class AgentWebConfig {
    public static String AGENTWEB_FILE_PATH = null;
    public static final String AGENTWEB_NAME = "AgentWeb";
    public static final String AGENTWEB_VERSION = "AgentWeb/5.0.0";
    public static final int WEBVIEW_AGENTWEB_SAFE_TYPE = 2;
    public static final int WEBVIEW_CUSTOM_TYPE = 3;
    public static final int WEBVIEW_DEFAULT_TYPE = 1;
    public static final String FILE_CACHE_PATH = "agentweb-cache";
    public static final String AGENTWEB_CACHE_PATCH = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), File.separator, FILE_CACHE_PATH);
    public static boolean DEBUG = false;
    public static final boolean IS_KITKAT_OR_BELOW_KITKAT = false;
    public static volatile boolean IS_INITIALIZED = false;
    public static final String TAG = AgentWebConfig.class.getSimpleName();
    public static int MAX_FILE_LENGTH = 5242880;

    public static synchronized void clearDiskCache(Context context) {
        synchronized (AgentWebConfig.class) {
            try {
                AgentWebUtils.clearCacheFolder(new File(getCachePath(context)), 0);
                String externalCachePath = getExternalCachePath(context);
                if (!TextUtils.isEmpty(externalCachePath)) {
                    AgentWebUtils.clearCacheFolder(new File(externalCachePath), 0);
                }
            } catch (Throwable th) {
                if (LogUtils.isDebug()) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void createCookiesSyncInstance(Context context) {
    }

    public static void debug() {
        DEBUG = true;
        WebView.setWebContentsDebuggingEnabled(true);
    }

    public static String getCachePath(Context context) {
        return context.getCacheDir().getAbsolutePath() + AGENTWEB_CACHE_PATCH;
    }

    public static String getCookiesByUrl(String str) {
        if (CookieManager.getInstance() == null) {
            return null;
        }
        return CookieManager.getInstance().getCookie(str);
    }

    public static String getDatabasesCachePath(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getDir("database", 0).getPath();
    }

    public static ValueCallback<Boolean> getDefaultIgnoreCallback() {
        return new ValueCallback<Boolean>() { // from class: com.just.agentweb.AgentWebConfig.2
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(Boolean bool) {
                String str = AgentWebConfig.TAG;
                LogUtils.m3701i(str, "removeExpiredCookies:" + bool);
            }
        };
    }

    public static String getExternalCachePath(Context context) {
        return AgentWebUtils.getAgentWebFilePath(context);
    }

    public static synchronized void initCookiesManager(Context context) {
        synchronized (AgentWebConfig.class) {
            if (!IS_INITIALIZED) {
                createCookiesSyncInstance(context);
                IS_INITIALIZED = true;
            }
        }
    }

    public static void removeAllCookies() {
        removeAllCookies(null);
    }

    public static void removeAllCookies(@Nullable ValueCallback<Boolean> valueCallback) {
        if (valueCallback == null) {
            valueCallback = getDefaultIgnoreCallback();
        }
        CookieManager.getInstance().removeAllCookies(valueCallback);
        toSyncCookies();
    }

    public static void removeExpiredCookies() {
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null) {
            cookieManager.removeExpiredCookie();
            toSyncCookies();
        }
    }

    public static void removeSessionCookies() {
        removeSessionCookies(null);
    }

    public static void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        if (valueCallback == null) {
            valueCallback = getDefaultIgnoreCallback();
        }
        if (CookieManager.getInstance() == null) {
            valueCallback.onReceiveValue(new Boolean(false));
            return;
        }
        CookieManager.getInstance().removeSessionCookies(valueCallback);
        toSyncCookies();
    }

    public static void syncCookie(String str, String str2) {
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null) {
            cookieManager.setCookie(str, str2);
            toSyncCookies();
        }
    }

    public static void toSyncCookies() {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.just.agentweb.AgentWebConfig.1
            @Override // java.lang.Runnable
            public void run() {
                CookieManager.getInstance().flush();
            }
        });
    }
}
