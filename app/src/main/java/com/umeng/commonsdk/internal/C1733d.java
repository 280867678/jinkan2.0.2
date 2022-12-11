package com.umeng.commonsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.net.MailTo;
import com.stub.StubApp;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.C1734a;
import com.umeng.commonsdk.internal.utils.C1739c;
import com.umeng.commonsdk.internal.utils.C1747i;
import com.umeng.commonsdk.internal.utils.C1748j;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.C1847b;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.umeng.commonsdk.internal.d */
/* loaded from: classes4.dex */
public class C1733d {
    /* renamed from: a */
    public static JSONObject m711a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a_pr", Build.PRODUCT);
            jSONObject.put("a_bl", Build.BOOTLOADER);
            jSONObject.put("a_rv", Build.getRadioVersion());
            jSONObject.put("a_fp", Build.FINGERPRINT);
            jSONObject.put("a_hw", Build.HARDWARE);
            jSONObject.put("a_host", Build.HOST);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < Build.SUPPORTED_32_BIT_ABIS.length; i++) {
                jSONArray.put(Build.SUPPORTED_32_BIT_ABIS[i]);
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("a_s32", jSONArray);
            }
            JSONArray jSONArray2 = new JSONArray();
            for (int i2 = 0; i2 < Build.SUPPORTED_64_BIT_ABIS.length; i2++) {
                jSONArray2.put(Build.SUPPORTED_64_BIT_ABIS[i2]);
            }
            if (jSONArray2.length() > 0) {
                jSONObject.put("a_s64", jSONArray2);
            }
            JSONArray jSONArray3 = new JSONArray();
            for (int i3 = 0; i3 < Build.SUPPORTED_ABIS.length; i3++) {
                jSONArray3.put(Build.SUPPORTED_ABIS[i3]);
            }
            if (jSONArray3.length() > 0) {
                jSONObject.put("a_sa", jSONArray3);
            }
            jSONObject.put("a_ta", Build.TAGS);
            jSONObject.put("a_uk", "unknown");
            jSONObject.put("a_user", Build.USER);
            jSONObject.put("a_cpu1", Build.CPU_ABI);
            jSONObject.put("a_cpu2", Build.CPU_ABI2);
            jSONObject.put("a_ra", Build.RADIO);
            if (Build.VERSION.SDK_INT >= 23) {
                jSONObject.put("a_bos", Build.VERSION.BASE_OS);
                jSONObject.put("a_pre", Build.VERSION.PREVIEW_SDK_INT);
                jSONObject.put("a_sp", Build.VERSION.SECURITY_PATCH);
            }
            jSONObject.put("a_cn", Build.VERSION.CODENAME);
            jSONObject.put("a_intl", Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m710a(Context context) {
        try {
            ULog.m535i("walle", "[internal] workEvent send envelope");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C1543ak.f2976aM, C1724a.f3903e);
            JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, m703d(context), UMServerURL.PATH_ANALYTICS, C1543ak.f2966aC, C1724a.f3903e);
            if (buildEnvelopeWithExtHeader == null || buildEnvelopeWithExtHeader.has("exception")) {
                return;
            }
            ULog.m535i("walle", "[internal] workEvent send envelope back, result is ok");
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
        }
    }

    /* renamed from: a */
    public static void m709a(Context context, JSONObject jSONObject) {
        PackageManager packageManager;
        if (context == null || (packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager()) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        m708a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
        m708a(jSONObject, MailTo.f53TO, packageManager.hasSystemFeature("android.hardware.touchscreen"));
        m708a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
        m708a(jSONObject, "ca", packageManager.hasSystemFeature("android.hardware.camera"));
        m708a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
    }

    /* renamed from: a */
    public static void m708a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, z ? 1 : 0);
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static JSONObject m707b() {
        try {
            C1739c.C1740a m669a = C1739c.m669a();
            if (m669a == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pro", m669a.f3955a);
                jSONObject.put("pla", m669a.f3956b);
                jSONObject.put("cpus", m669a.f3957c);
                jSONObject.put("fea", m669a.f3958d);
                jSONObject.put("imp", m669a.f3959e);
                jSONObject.put("arc", m669a.f3960f);
                jSONObject.put("var", m669a.f3961g);
                jSONObject.put("par", m669a.f3962h);
                jSONObject.put("rev", m669a.f3963i);
                jSONObject.put("har", m669a.f3964j);
                jSONObject.put("rev", m669a.f3965k);
                jSONObject.put("ser", m669a.f3966l);
                jSONObject.put("cur_cpu", C1739c.m666d());
                jSONObject.put("max_cpu", C1739c.m668b());
                jSONObject.put("min_cpu", C1739c.m667c());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    /* renamed from: b */
    public static void m706b(Context context) {
        ULog.m535i("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            m697j(context);
        }
    }

    /* renamed from: b */
    public static void m705b(Context context, JSONObject jSONObject) {
        if (context != null) {
            String m654a = C1748j.m654a(context);
            if (TextUtils.isEmpty(m654a)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(m654a);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                if (jSONObject2.has(C1748j.f3978d)) {
                    jSONObject.put(C1748j.f3978d, jSONObject2.opt(C1748j.f3978d));
                }
                if (jSONObject2.has(C1748j.f3977c)) {
                    jSONObject.put(C1748j.f3977c, jSONObject2.opt(C1748j.f3977c));
                }
                if (!jSONObject2.has(C1748j.f3976b)) {
                    return;
                }
                jSONObject.put(C1748j.f3976b, jSONObject2.opt(C1748j.f3976b));
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: c */
    public static void m704c(Context context) {
        ULog.m535i("walle", "[internal] begin by stateful--->>>");
        if (context == null || !UMEnvelopeBuild.getTransmissionSendFlag()) {
            return;
        }
        m697j(context);
    }

    /* renamed from: d */
    public static JSONObject m703d(Context context) {
        JSONArray m699h;
        JSONArray m696k;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            try {
                if (FieldManager.allow(C1847b.f4258I) && (m696k = m696k(origApplicationContext)) != null && m696k.length() > 0) {
                    jSONObject2.put("rs", m696k);
                }
            } catch (Exception e) {
                UMCrashManager.reportCrash(origApplicationContext, e);
            }
            try {
                JSONArray m695l = m695l(origApplicationContext);
                if (m695l != null && m695l.length() > 0) {
                    jSONObject2.put("by", m695l);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(origApplicationContext, e2);
            }
            try {
                m709a(origApplicationContext, jSONObject2);
            } catch (Exception e3) {
                UMCrashManager.reportCrash(origApplicationContext, e3);
            }
            try {
                m705b(origApplicationContext, jSONObject2);
            } catch (Exception e4) {
                UMCrashManager.reportCrash(origApplicationContext, e4);
            }
            try {
                JSONObject m711a = m711a();
                if (m711a != null && m711a.length() > 0) {
                    jSONObject2.put("build", m711a);
                }
            } catch (Exception e5) {
                UMCrashManager.reportCrash(origApplicationContext, e5);
            }
            try {
                JSONObject m702e = m702e(origApplicationContext);
                if (m702e != null && m702e.length() > 0) {
                    jSONObject2.put("scr", m702e);
                }
            } catch (Exception e6) {
                UMCrashManager.reportCrash(origApplicationContext, e6);
            }
            try {
                JSONObject m701f = m701f(origApplicationContext);
                if (m701f != null && m701f.length() > 0) {
                    jSONObject2.put("sinfo", m701f);
                }
            } catch (Exception e7) {
                UMCrashManager.reportCrash(origApplicationContext, e7);
            }
            try {
                JSONArray m700g = m700g(origApplicationContext);
                if (m700g != null && m700g.length() > 0) {
                    jSONObject2.put("input", m700g);
                }
            } catch (Exception e8) {
                UMCrashManager.reportCrash(origApplicationContext, e8);
            }
            try {
                if (FieldManager.allow(C1847b.f4282af) && (m699h = m699h(origApplicationContext)) != null && m699h.length() > 0) {
                    jSONObject2.put("appls", m699h);
                }
            } catch (Exception e9) {
                UMCrashManager.reportCrash(origApplicationContext, e9);
            }
            try {
                JSONObject m698i = m698i(origApplicationContext);
                if (m698i != null && m698i.length() > 0) {
                    jSONObject2.put("mem", m698i);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(origApplicationContext, e10);
            }
            try {
                JSONObject m707b = m707b();
                if (m707b != null && m707b.length() > 0) {
                    jSONObject2.put(C1543ak.f3052w, m707b);
                }
            } catch (Exception unused) {
            }
            try {
                jSONObject.put(C1543ak.f3010au, jSONObject2);
            } catch (JSONException e11) {
                UMCrashManager.reportCrash(origApplicationContext, e11);
            }
        }
        return jSONObject;
    }

    /* renamed from: e */
    public static JSONObject m702e(Context context) {
        DisplayMetrics displayMetrics;
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", C1734a.m687c(context));
                jSONObject.put("a_nav_h", C1734a.m684d(context));
                if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
                    jSONObject.put("a_den", displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                }
            } catch (Exception e) {
                UMCrashManager.reportCrash(context, e);
            }
        }
        return jSONObject;
    }

    /* renamed from: f */
    public static JSONObject m701f(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            String packageName = origApplicationContext.getPackageName();
            try {
                jSONObject.put("a_fit", C1734a.m692a(origApplicationContext, packageName));
                jSONObject.put("a_alut", C1734a.m689b(origApplicationContext, packageName));
                jSONObject.put("a_c", C1734a.m686c(origApplicationContext, packageName));
                jSONObject.put("a_uid", C1734a.m683d(origApplicationContext, packageName));
                if (C1734a.m694a()) {
                    jSONObject.put("a_root", 1);
                } else {
                    jSONObject.put("a_root", 0);
                }
                jSONObject.put("tf", C1734a.m691b());
                jSONObject.put("s_fs", C1734a.m693a(origApplicationContext));
                jSONObject.put("a_meid", DeviceConfig.getMeid(origApplicationContext));
                jSONObject.put("a_imsi", DeviceConfig.getImsi(origApplicationContext));
                jSONObject.put("st", C1734a.m688c());
                String simICCID = DeviceConfig.getSimICCID(origApplicationContext);
                if (!TextUtils.isEmpty(simICCID)) {
                    try {
                        jSONObject.put("a_iccid", simICCID);
                    } catch (Exception unused) {
                    }
                }
                String secondSimIMEi = DeviceConfig.getSecondSimIMEi(origApplicationContext);
                if (!TextUtils.isEmpty(secondSimIMEi)) {
                    try {
                        jSONObject.put("a_simei", secondSimIMEi);
                    } catch (Exception unused2) {
                    }
                }
                jSONObject.put("hn", C1734a.m685d());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e) {
                UMCrashManager.reportCrash(origApplicationContext, e);
            }
        }
        return jSONObject;
    }

    /* renamed from: g */
    public static JSONArray m700g(Context context) {
        Context origApplicationContext;
        List<InputMethodInfo> m680f;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (m680f = C1734a.m680f((origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())))) != null) {
            for (InputMethodInfo inputMethodInfo : m680f) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("a_id", inputMethodInfo.getId());
                    jSONObject.put("a_pn", inputMethodInfo.getPackageName());
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(origApplicationContext, th);
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: h */
    public static JSONArray m699h(Context context) {
        Context origApplicationContext;
        List<C1734a.C1735a> m679g;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (m679g = C1734a.m679g((origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())))) != null && !m679g.isEmpty()) {
            for (C1734a.C1735a c1735a : m679g) {
                if (c1735a != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_pn", c1735a.f3947a);
                        jSONObject.put("a_la", c1735a.f3948b);
                        jSONObject.put("ts", System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                    } catch (Exception e) {
                        UMCrashManager.reportCrash(origApplicationContext, e);
                    }
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: i */
    public static JSONObject m698i(Context context) {
        Context origApplicationContext;
        ActivityManager.MemoryInfo m678h;
        JSONObject jSONObject = new JSONObject();
        if (context != null && (m678h = C1734a.m678h((origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())))) != null) {
            try {
                jSONObject.put(C1543ak.f2971aH, m678h.totalMem);
                jSONObject.put("f", m678h.availMem);
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e) {
                UMCrashManager.reportCrash(origApplicationContext, e);
            }
        }
        return jSONObject;
    }

    /* renamed from: j */
    public static void m697j(Context context) {
        try {
            if (UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                UMWorkDispatch.sendEvent(context, 32769, C1725b.m729a(context).m730a(), null);
            }
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 冷启动：5秒后触发2号数据仓遗留信封检查动作。");
            UMWorkDispatch.sendEvent(context, C1724a.f3920v, C1725b.m729a(context).m730a(), null, 5000L);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    /* renamed from: k */
    public static JSONArray m696k(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        JSONArray jSONArray = null;
        if (context != null) {
            try {
                ActivityManager activityManager = (ActivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                if (activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null || runningServices.isEmpty()) {
                    return null;
                }
                for (int i = 0; i < runningServices.size(); i++) {
                    if (runningServices.get(i) != null && runningServices.get(i).service != null && runningServices.get(i).service.getClassName() != null && runningServices.get(i).service.getPackageName() != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("sn", runningServices.get(i).service.getClassName().toString());
                            jSONObject.put("pn", runningServices.get(i).service.getPackageName().toString());
                            if (jSONArray == null) {
                                jSONArray = new JSONArray();
                            }
                            jSONArray.put(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                }
                if (jSONArray == null) {
                    return jSONArray;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ts", System.currentTimeMillis());
                    jSONObject2.put("ls", jSONArray);
                } catch (JSONException unused2) {
                }
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("sers", jSONObject2);
                } catch (JSONException unused3) {
                }
                JSONArray jSONArray2 = new JSONArray();
                try {
                    jSONArray2.put(jSONObject3);
                    return jSONArray2;
                } catch (Throwable th) {
                    th = th;
                    jSONArray = jSONArray2;
                    UMCrashManager.reportCrash(context, th);
                    return jSONArray;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return null;
        }
    }

    /* renamed from: l */
    public static JSONArray m695l(Context context) {
        JSONArray jSONArray = new JSONArray();
        String m657a = C1747i.m657a(context);
        if (!TextUtils.isEmpty(m657a)) {
            try {
                jSONArray.put(new JSONObject(m657a));
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }
}
