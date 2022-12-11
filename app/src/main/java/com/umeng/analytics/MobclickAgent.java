package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.C1640j;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.eclipse.jetty.server.AsyncContinuation;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class MobclickAgent {

    /* loaded from: classes4.dex */
    public enum EScenarioType {
        E_UM_NORMAL(0),
        E_UM_GAME(1);
        

        /* renamed from: a */
        public int f2850a;

        EScenarioType(int i) {
            this.f2850a = i;
        }

        public int toValue() {
            return this.f2850a;
        }
    }

    /* loaded from: classes4.dex */
    public enum PageMode {
        AUTO,
        MANUAL,
        LEGACY_AUTO,
        LEGACY_MANUAL
    }

    public static void clearPreProperties(Context context) {
        getAgent().m1425g(context);
    }

    public static void disable() {
        AnalyticsConfig.enable = false;
    }

    public static void disableExceptionCatch() {
        C1517b.m1468a().m1446a(false);
        AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    }

    public static void enableEncrypt(boolean z) {
    }

    public static C1517b getAgent() {
        return C1517b.m1468a();
    }

    public static JSONObject getPreProperties(Context context) {
        return getAgent().m1423h(context);
    }

    public static void init(Context context) {
        C1517b.m1468a().m1465a(context);
    }

    public static void onEvent(Context context, String str) {
        C1517b.m1468a().m1460a(context, str, (String) null, -1L, 1);
    }

    public static void onEvent(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            UMLog.m773aq(C1640j.f3510k, 0, "\\|");
        } else {
            C1517b.m1468a().m1460a(context, str, str2, -1L, 1);
        }
    }

    public static void onEvent(Context context, String str, Map<String, String> map) {
        if (map == null) {
            UMLog.m773aq(C1640j.f3482a, 0, "\\|");
        } else {
            C1517b.m1468a().m1457a(context, str, new HashMap(map), -1L);
        }
    }

    public static void onEventObject(Context context, String str, Map<String, Object> map) {
        if (map == null) {
            UMLog.m773aq(C1640j.f3482a, 0, "\\|");
        } else {
            C1517b.m1468a().m1457a(context, str, map, -1L);
        }
    }

    public static void onEventValue(Context context, String str, Map<String, String> map, int i) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("__ct__", Integer.valueOf(i));
        C1517b.m1468a().m1457a(context, str, hashMap, -1L);
    }

    public static void onGKVEvent(Context context, String str, HashMap<String, Object> hashMap) {
        C1517b.m1468a().m1459a(context, str, hashMap);
    }

    public static void onKillProcess(Context context) {
        C1517b.m1468a().m1434d(context);
    }

    public static void onPageEnd(String str) {
        if (!TextUtils.isEmpty(str)) {
            C1517b.m1468a().m1441b(str);
        } else {
            UMLog.m773aq(C1640j.f3459D, 0, "\\|");
        }
    }

    public static void onPageStart(String str) {
        if (!TextUtils.isEmpty(str)) {
            C1517b.m1468a().m1450a(str);
        } else {
            UMLog.m773aq(C1640j.f3458C, 0, "\\|");
        }
    }

    public static void onPause(Context context) {
        C1517b.m1468a().m1438c(context);
    }

    public static void onProfileSignIn(String str) {
        onProfileSignIn("_adhoc", str);
    }

    public static void onProfileSignIn(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = C1640j.f3519t;
        } else if (str2.length() > 64) {
            str3 = C1640j.f3520u;
        } else if (TextUtils.isEmpty(str)) {
            C1517b.m1468a().m1448a("_adhoc", str2);
            return;
        } else if (str.length() <= 32) {
            C1517b.m1468a().m1448a(str, str2);
            return;
        } else {
            str3 = C1640j.f3521v;
        }
        UMLog.m773aq(str3, 0, "\\|");
    }

    public static void onProfileSignOff() {
        C1517b.m1468a().m1420j();
    }

    public static void onResume(Context context) {
        if (context == null) {
            UMLog.m773aq(C1640j.f3513n, 0, "\\|");
        } else {
            C1517b.m1468a().m1444b(context);
        }
    }

    public static void registerPreProperties(Context context, JSONObject jSONObject) {
        getAgent().m1453a(context, jSONObject);
    }

    public static void reportError(Context context, String str) {
        try {
            Class<?> cls = Class.forName("com.umeng.umcrash.UMCrash");
            Method declaredMethod = cls.getDeclaredMethod("generateCustomLog", String.class, String.class);
            if (declaredMethod == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(cls, str, "DEFAULT");
        } catch (Throwable unused) {
        }
    }

    public static void reportError(Context context, Throwable th) {
        try {
            Class<?> cls = Class.forName("com.umeng.umcrash.UMCrash");
            Method declaredMethod = cls.getDeclaredMethod("generateCustomLog", Throwable.class, String.class);
            if (declaredMethod == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(cls, th, "DEFAULT");
        } catch (Throwable unused) {
        }
    }

    public static void setCatchUncaughtExceptions(boolean z) {
        C1517b.m1468a().m1446a(z);
    }

    public static void setCheckDevice(boolean z) {
    }

    public static void setDebugMode(boolean z) {
    }

    public static void setFirstLaunchEvent(Context context, List<String> list) {
        getAgent().m1454a(context, list);
    }

    public static void setGameScenarioType(Context context) {
        C1517b.m1468a().m1463a(context, EScenarioType.E_UM_GAME);
    }

    public static void setLatencyWindow(long j) {
    }

    public static void setLocation(double d, double d2) {
        C1517b.m1468a().m1467a(d, d2);
    }

    public static void setOpenGLContext(GL10 gl10) {
        C1517b.m1468a().m1447a(gl10);
    }

    public static void setPageCollectionMode(PageMode pageMode) {
        UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION = pageMode;
    }

    public static void setScenarioType(Context context, EScenarioType eScenarioType) {
    }

    public static void setSecret(Context context, String str) {
        C1517b.m1468a().m1437c(context, str);
    }

    public static void setSessionContinueMillis(long j) {
        if (j <= AsyncContinuation.DEFAULT_TIMEOUT) {
            j = 30000;
        }
        C1517b.m1468a().m1466a(j);
    }

    public static void setSysListener(ISysListener iSysListener) {
        C1517b.m1468a().m1452a(iSysListener);
    }

    public static void unregisterPreProperty(Context context, String str) {
        getAgent().m1427f(context, str);
    }
}
