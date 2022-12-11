package com.tencent.smtt.sdk;

import android.content.Context;
import com.stub.StubApp;
import java.lang.reflect.Field;

@Deprecated
/* loaded from: classes4.dex */
public class CookieSyncManager {

    /* renamed from: a */
    public static android.webkit.CookieSyncManager f1707a;

    /* renamed from: b */
    public static CookieSyncManager f1708b;

    /* renamed from: c */
    public static boolean f1709c;

    public CookieSyncManager(Context context) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            return;
        }
        m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[]{Context.class}, context);
        f1709c = true;
    }

    public static synchronized CookieSyncManager createInstance(Context context) {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            f1707a = android.webkit.CookieSyncManager.createInstance(context);
            if (f1708b == null || !f1709c) {
                f1708b = new CookieSyncManager(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
            cookieSyncManager = f1708b;
        }
        return cookieSyncManager;
    }

    public static synchronized CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            if (f1708b == null) {
                throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
            }
            cookieSyncManager = f1708b;
        }
        return cookieSyncManager;
    }

    public void startSync() {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a != null && m2294a.m2291b()) {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
            return;
        }
        f1707a.startSync();
        try {
            Field declaredField = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
            declaredField.setAccessible(true);
            ((Thread) declaredField.get(f1707a)).setUncaughtExceptionHandler(new C1364h());
        } catch (Exception unused) {
        }
    }

    public void stopSync() {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            f1707a.stopSync();
        } else {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
        }
    }

    public void sync() {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            f1707a.sync();
        } else {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
        }
    }
}
