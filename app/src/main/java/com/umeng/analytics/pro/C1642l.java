package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.analytics.C1517b;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.C1616e;
import com.umeng.analytics.pro.C1636i;
import com.umeng.analytics.vshelper.AbstractC1684a;
import com.umeng.analytics.vshelper.C1685b;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.C1847b;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.pro.l */
/* loaded from: classes4.dex */
public class C1642l {

    /* renamed from: a */
    public static String f3526a;

    /* renamed from: b */
    public boolean f3535b;

    /* renamed from: c */
    public boolean f3536c;

    /* renamed from: f */
    public AbstractC1684a f3537f;

    /* renamed from: g */
    public Application.ActivityLifecycleCallbacks f3538g;

    /* renamed from: h */
    public final Map<String, Long> f3539h;

    /* renamed from: l */
    public boolean f3540l;

    /* renamed from: m */
    public int f3541m;

    /* renamed from: n */
    public int f3542n;

    /* renamed from: i */
    public static JSONArray f3529i = new JSONArray();

    /* renamed from: j */
    public static Object f3530j = new Object();

    /* renamed from: k */
    public static Application f3531k = null;

    /* renamed from: d */
    public static String f3527d = null;

    /* renamed from: e */
    public static int f3528e = -1;

    /* renamed from: o */
    public static boolean f3532o = true;

    /* renamed from: p */
    public static Object f3533p = new Object();

    /* renamed from: q */
    public static AbstractC1554ap f3534q = new C1685b();

    /* renamed from: com.umeng.analytics.pro.l$a */
    /* loaded from: classes4.dex */
    public static class C1644a {

        /* renamed from: a */
        public static final C1642l f3544a = new C1642l();
    }

    public C1642l() {
        this.f3539h = new HashMap();
        this.f3540l = false;
        this.f3535b = false;
        this.f3536c = false;
        this.f3541m = 0;
        this.f3542n = 0;
        this.f3537f = PageNameMonitor.getInstance();
        this.f3538g = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.l.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                C1642l.f3534q.mo833a(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow(C1847b.f4255F)) {
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (C1642l.f3533p) {
                        if (C1642l.f3532o) {
                            return;
                        }
                    }
                } else {
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
                    if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.MANUAL) {
                        return;
                    }
                    C1517b.m1468a().m1422i();
                    return;
                }
                C1642l.this.m1008c(activity);
                C1517b.m1468a().m1422i();
                C1642l.this.f3535b = false;
                C1642l.f3534q.mo827d(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FieldManager.allow(C1847b.f4255F)) {
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                    synchronized (C1642l.f3533p) {
                        if (C1642l.f3532o) {
                            boolean unused = C1642l.f3532o = false;
                        }
                    }
                } else {
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                }
                C1642l.this.m1020a(activity);
                C1642l.f3534q.mo828c(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (C1642l.this.f3541m <= 0) {
                        if (C1642l.f3527d == null) {
                            C1642l.f3527d = UUID.randomUUID().toString();
                        }
                        if (C1642l.f3528e == -1) {
                            C1642l.f3528e = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (C1642l.f3528e == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("activityName", activity.toString());
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            C1517b m1468a = C1517b.m1468a();
                            if (m1468a != null) {
                                m1468a.m1458a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) hashMap);
                            }
                            C1642l.f3528e = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, C1640j.f3500ar);
                            }
                        } else if (C1642l.f3528e == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("pairUUID", C1642l.f3527d);
                            hashMap2.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap2.put("activityName", activity.toString());
                            if (C1517b.m1468a() != null) {
                                C1517b.m1468a().m1458a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) hashMap2);
                            }
                        }
                    }
                    if (C1642l.this.f3542n < 0) {
                        C1642l.m1002e(C1642l.this);
                    } else {
                        C1642l.m1000f(C1642l.this);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                MobclickAgent.PageMode pageMode = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION;
                MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        C1642l.m1017a(C1642l.this);
                        return;
                    }
                    C1642l.m1011b(C1642l.this);
                    if (C1642l.this.f3541m > 0) {
                        return;
                    }
                    if (C1642l.f3528e == 0 && UMUtils.isMainProgress(activity)) {
                        return;
                    }
                    int i = C1642l.f3528e;
                    if (i != 1 && (i != 0 || UMUtils.isMainProgress(activity))) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("pairUUID", C1642l.f3527d);
                    hashMap.put("reason", "Normal");
                    hashMap.put("pid", Integer.valueOf(Process.myPid()));
                    hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                    hashMap.put("activityName", activity.toString());
                    C1517b m1468a = C1517b.m1468a();
                    if (m1468a != null) {
                        m1468a.m1458a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
                    }
                    if (C1642l.f3527d == null) {
                        return;
                    }
                    C1642l.f3527d = null;
                }
            }
        };
        synchronized (this) {
            if (f3531k != null) {
                m999g();
            }
        }
    }

    /* renamed from: a */
    public static /* synthetic */ int m1017a(C1642l c1642l) {
        int i = c1642l.f3542n;
        c1642l.f3542n = i - 1;
        return i;
    }

    /* renamed from: a */
    public static synchronized C1642l m1019a(Context context) {
        C1642l c1642l;
        Application application;
        synchronized (C1642l.class) {
            if (f3531k == null && context != null) {
                if (context instanceof Activity) {
                    application = ((Activity) context).getApplication();
                } else if (context instanceof Application) {
                    application = (Application) context;
                }
                f3531k = application;
            }
            c1642l = C1644a.f3544a;
        }
        return c1642l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1020a(Activity activity) {
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.MANUAL) {
                return;
            }
            synchronized (f3533p) {
                C1517b.m1468a().m1424h();
            }
        } else if (activity == null) {
        } else {
            String str = activity.getPackageName() + "." + activity.getLocalClassName();
            this.f3537f.activityResume(str);
            if (!this.f3535b) {
                m1013b(activity);
                synchronized (f3533p) {
                    C1517b.m1468a().m1424h();
                }
                return;
            }
            this.f3535b = false;
            if (TextUtils.isEmpty(f3526a)) {
                f3526a = str;
            } else if (f3526a.equals(str)) {
            } else {
                m1013b(activity);
                synchronized (f3533p) {
                    C1517b.m1468a().m1424h();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m1018a(Context context, String str) {
        if (f3528e != 1 || !UMUtils.isMainProgress(context)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("pairUUID", f3527d);
        hashMap.put("reason", str);
        if (f3527d != null) {
            f3527d = null;
        }
        if (context == null) {
            return;
        }
        hashMap.put("pid", Integer.valueOf(Process.myPid()));
        hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
        hashMap.put("Context", context.toString());
        C1517b.m1468a().m1458a(context, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    public static /* synthetic */ int m1011b(C1642l c1642l) {
        int i = c1642l.f3541m;
        c1642l.f3541m = i - 1;
        return i;
    }

    /* renamed from: b */
    private void m1013b(Activity activity) {
        f3526a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.f3539h) {
            this.f3539h.put(f3526a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m1008c(Activity activity) {
        long j;
        long j2;
        try {
            synchronized (this.f3539h) {
                if (f3526a == null && activity != null) {
                    f3526a = activity.getPackageName() + "." + activity.getLocalClassName();
                }
                j = 0;
                if (TextUtils.isEmpty(f3526a) || !this.f3539h.containsKey(f3526a)) {
                    j2 = 0;
                } else {
                    long longValue = this.f3539h.get(f3526a).longValue();
                    this.f3539h.remove(f3526a);
                    j = System.currentTimeMillis() - longValue;
                    j2 = longValue;
                }
            }
            synchronized (f3530j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(C1615d.f3356v, f3526a);
                    jSONObject.put("duration", j);
                    jSONObject.put(C1615d.f3358x, j2);
                    jSONObject.put("type", 0);
                    f3529i.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: c */
    public static void m1007c(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f3530j) {
                    jSONArray = f3529i.toString();
                    f3529i = new JSONArray();
                }
                if (jSONArray.length() <= 0) {
                    return;
                }
                jSONObject.put(C1616e.C1626d.C1627a.f3406c, new JSONArray(jSONArray));
                C1636i.m1056a(context).m1050a(C1663u.m899a().m887c(), jSONObject, C1636i.EnumC1638a.AUTOPAGE);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: e */
    public static /* synthetic */ int m1002e(C1642l c1642l) {
        int i = c1642l.f3542n;
        c1642l.f3542n = i + 1;
        return i;
    }

    /* renamed from: f */
    public static /* synthetic */ int m1000f(C1642l c1642l) {
        int i = c1642l.f3541m;
        c1642l.f3541m = i + 1;
        return i;
    }

    /* renamed from: g */
    private void m999g() {
        if (!this.f3540l) {
            this.f3540l = true;
            if (f3531k == null) {
                return;
            }
            f3531k.registerActivityLifecycleCallbacks(this.f3538g);
        }
    }

    /* renamed from: a */
    public boolean m1021a() {
        return this.f3540l;
    }

    /* renamed from: b */
    public void m1014b() {
        this.f3540l = false;
        if (f3531k != null) {
            f3531k.unregisterActivityLifecycleCallbacks(this.f3538g);
            f3531k = null;
        }
    }

    /* renamed from: b */
    public void m1012b(Context context) {
        synchronized (f3533p) {
            if (!f3532o) {
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: firstResumeCall = false，直接返回。");
                return;
            }
            f3532o = false;
            Activity globleActivity = DeviceConfig.getGlobleActivity(context);
            if (globleActivity == null) {
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 无前台Activity，直接退出。");
                return;
            }
            String localClassName = globleActivity.getLocalClassName();
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 补救成功，前台Activity名：" + localClassName);
            m1020a(globleActivity);
        }
    }

    /* renamed from: c */
    public void m1009c() {
        m1008c((Activity) null);
        m1014b();
    }
}
