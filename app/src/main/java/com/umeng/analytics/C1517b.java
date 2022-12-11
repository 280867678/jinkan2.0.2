package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.filter.C1521a;
import com.umeng.analytics.filter.C1522b;
import com.umeng.analytics.pro.AbstractC1647n;
import com.umeng.analytics.pro.AbstractC1662t;
import com.umeng.analytics.pro.C1615d;
import com.umeng.analytics.pro.C1636i;
import com.umeng.analytics.pro.C1640j;
import com.umeng.analytics.pro.C1641k;
import com.umeng.analytics.pro.C1642l;
import com.umeng.analytics.pro.C1645m;
import com.umeng.analytics.pro.C1648o;
import com.umeng.analytics.pro.C1654p;
import com.umeng.analytics.pro.C1659s;
import com.umeng.analytics.pro.C1663u;
import com.umeng.analytics.pro.C1666v;
import com.umeng.analytics.pro.C1669y;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.C1847b;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.b */
/* loaded from: classes4.dex */
public class C1517b implements AbstractC1647n, AbstractC1662t {

    /* renamed from: A */
    public static final String f2860A = "umsp_2";

    /* renamed from: B */
    public static final String f2861B = "umsp_3";

    /* renamed from: C */
    public static final String f2862C = "umsp_4";

    /* renamed from: D */
    public static final String f2863D = "umsp_5";

    /* renamed from: a */
    public static Context f2864a = null;

    /* renamed from: h */
    public static final String f2865h = "sp_uapp";

    /* renamed from: i */
    public static final String f2866i = "prepp_uapp";

    /* renamed from: o */
    public static final int f2867o = 128;

    /* renamed from: p */
    public static final int f2868p = 256;

    /* renamed from: q */
    public static String f2869q = "";

    /* renamed from: r */
    public static String f2870r = "";

    /* renamed from: s */
    public static final String f2871s = "ekv_bl";

    /* renamed from: t */
    public static final String f2872t = "ekv_bl_ver";

    /* renamed from: v */
    public static final String f2873v = "ekv_wl";

    /* renamed from: w */
    public static final String f2874w = "ekv_wl_ver";

    /* renamed from: z */
    public static final String f2875z = "umsp_1";

    /* renamed from: b */
    public ISysListener f2876b;

    /* renamed from: c */
    public C1654p f2877c;

    /* renamed from: d */
    public C1666v f2878d;

    /* renamed from: e */
    public C1641k f2879e;

    /* renamed from: f */
    public C1663u f2880f;

    /* renamed from: g */
    public C1642l f2881g;

    /* renamed from: j */
    public boolean f2882j;

    /* renamed from: k */
    public volatile JSONObject f2883k;

    /* renamed from: l */
    public volatile JSONObject f2884l;

    /* renamed from: m */
    public volatile JSONObject f2885m;

    /* renamed from: n */
    public boolean f2886n;

    /* renamed from: u */
    public C1521a f2887u;

    /* renamed from: x */
    public C1522b f2888x;

    /* renamed from: y */
    public C1645m f2889y;

    /* renamed from: com.umeng.analytics.b$a */
    /* loaded from: classes4.dex */
    public static class C1519a {

        /* renamed from: a */
        public static final C1517b f2890a = new C1517b();
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f2864a = StubApp.getOrigApplicationContext(appContext.getApplicationContext());
        }
    }

    public C1517b() {
        this.f2877c = new C1654p();
        this.f2878d = new C1666v();
        this.f2879e = new C1641k();
        this.f2880f = C1663u.m899a();
        this.f2881g = null;
        this.f2882j = false;
        this.f2883k = null;
        this.f2884l = null;
        this.f2885m = null;
        this.f2886n = false;
        this.f2887u = null;
        this.f2888x = null;
        this.f2889y = null;
        this.f2877c.m928a(this);
    }

    /* renamed from: a */
    public static C1517b m1468a() {
        return C1519a.f2890a;
    }

    /* renamed from: a */
    private void m1456a(Context context, String str, Map<String, Object> map, long j, boolean z) {
        try {
            if (context == null) {
                MLog.m574e("context is null in onEventNoCheck, please check!");
                return;
            }
            if (f2864a == null) {
                f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!this.f2882j || !this.f2886n) {
                m1465a(f2864a);
            }
            if (m1436c(str)) {
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str2 = "";
            if (this.f2883k == null) {
                this.f2883k = new JSONObject();
            } else {
                str2 = this.f2883k.toString();
            }
            C1659s.m915a(f2864a).m912a(str, map, j, str2, z);
        } catch (Throwable th) {
            if (!MLog.DEBUG) {
                return;
            }
            MLog.m570e(th);
        }
    }

    /* renamed from: a */
    private void m1449a(String str, Object obj) {
        JSONArray jSONArray;
        try {
            if (this.f2883k == null) {
                this.f2883k = new JSONObject();
            }
            int i = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length > 10) {
                        return;
                    }
                    jSONArray = new JSONArray();
                    while (i < strArr.length) {
                        if (strArr[i] != null && !HelperUtils.checkStrLen(strArr[i], 256)) {
                            jSONArray.put(strArr[i]);
                        }
                        i++;
                    }
                } else if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    jSONArray = new JSONArray();
                    while (i < jArr.length) {
                        jSONArray.put(jArr[i]);
                        i++;
                    }
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    jSONArray = new JSONArray();
                    while (i < iArr.length) {
                        jSONArray.put(iArr[i]);
                        i++;
                    }
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    jSONArray = new JSONArray();
                    while (i < fArr.length) {
                        jSONArray.put(fArr[i]);
                        i++;
                    }
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    jSONArray = new JSONArray();
                    while (i < dArr.length) {
                        jSONArray.put(dArr[i]);
                        i++;
                    }
                } else if (!(obj instanceof short[])) {
                    return;
                } else {
                    short[] sArr = (short[]) obj;
                    jSONArray = new JSONArray();
                    while (i < sArr.length) {
                        jSONArray.put((int) sArr[i]);
                        i++;
                    }
                }
            } else if (!(obj instanceof List)) {
                if (!(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Short)) {
                    return;
                }
                this.f2883k.put(str, obj);
                return;
            } else {
                List list = (List) obj;
                jSONArray = new JSONArray();
                while (i < list.size()) {
                    Object obj2 = list.get(i);
                    if ((obj2 instanceof String) || (obj2 instanceof Long) || (obj2 instanceof Integer) || (obj2 instanceof Float) || (obj2 instanceof Double) || (obj2 instanceof Short)) {
                        jSONArray.put(list.get(i));
                    }
                    i++;
                }
            }
            this.f2883k.put(str, jSONArray);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private boolean m1440b(String str, Object obj) {
        int i;
        if (TextUtils.isEmpty(str)) {
            MLog.m574e("key is " + str + ", please check key, illegal");
            return false;
        }
        try {
            i = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            i = 0;
        }
        if (i > 128) {
            MLog.m574e("key length is " + i + ", please check key, illegal");
            return false;
        } else if (obj instanceof String) {
            if (((String) obj).getBytes("UTF-8").length <= 256) {
                return true;
            }
            MLog.m574e("value length is " + ((String) obj).getBytes("UTF-8").length + ", please check value, illegal");
            return false;
        } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float)) {
            return true;
        } else {
            MLog.m574e("value is " + obj + ", please check value, type illegal");
            return false;
        }
    }

    /* renamed from: c */
    private boolean m1436c(String str) {
        if (!this.f2887u.enabled() || !this.f2887u.matchHit(str)) {
            if (!this.f2888x.enabled()) {
                return false;
            }
            if (!this.f2888x.matchHit(str)) {
                return true;
            }
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> white list match! id = " + str);
            return false;
        }
        return true;
    }

    /* renamed from: i */
    private void m1421i(Context context) {
        try {
            if (context == null) {
                MLog.m574e("unexpected null context in getNativeSuperProperties");
                return;
            }
            if (f2864a == null) {
                f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (this.f2883k == null) {
                this.f2883k = new JSONObject();
            }
            if (this.f2884l == null) {
                this.f2884l = new JSONObject();
            }
            String string = sharedPreferences.getString(f2866i, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.f2885m = new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            if (this.f2885m != null) {
                return;
            }
            this.f2885m = new JSONObject();
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    public void m1467a(double d, double d2) {
        Context context = f2864a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.m574e("setLocation can not be called in child process");
            return;
        }
        if (AnalyticsConfig.f2837a == null) {
            AnalyticsConfig.f2837a = new double[2];
        }
        double[] dArr = AnalyticsConfig.f2837a;
        dArr[0] = d;
        dArr[1] = d2;
    }

    /* renamed from: a */
    public void m1466a(long j) {
        Context context = f2864a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.m574e("setSessionContinueMillis can not be called in child process");
            return;
        }
        AnalyticsConfig.kContinueSessionMillis = j;
        C1669y.m870a().m869a(AnalyticsConfig.kContinueSessionMillis);
    }

    /* renamed from: a */
    public void m1465a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f2864a == null) {
                f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (this.f2887u == null) {
                C1521a c1521a = new C1521a("ekv_bl", "ekv_bl_ver");
                this.f2887u = c1521a;
                c1521a.register(f2864a);
            }
            if (this.f2888x == null) {
                C1522b c1522b = new C1522b("ekv_wl", "ekv_wl_ver");
                this.f2888x = c1522b;
                c1522b.register(f2864a);
            }
            if (!UMUtils.isMainProgress(f2864a)) {
                return;
            }
            if (!this.f2882j) {
                this.f2882j = true;
                m1421i(f2864a);
            }
            synchronized (this) {
                if (!this.f2886n) {
                    C1642l m1019a = C1642l.m1019a(context);
                    this.f2881g = m1019a;
                    if (m1019a.m1021a()) {
                        this.f2886n = true;
                    }
                    this.f2889y = C1645m.m997a();
                    try {
                        C1645m.m996a(context);
                        this.f2889y.m993a(this);
                    } catch (Throwable unused) {
                    }
                }
            }
            if (UMConfigure.isDebugLog()) {
                UMLog.mutlInfo(C1640j.f3457B, 3, "", null, null);
            }
            UMWorkDispatch.registerConnStateObserver(CoreProtocol.getInstance(f2864a));
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    public void m1464a(Context context, int i) {
        if (context == null) {
            MLog.m574e("unexpected null context in setVerticalType");
            return;
        }
        if (f2864a == null) {
            f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("setVerticalType can not be called in child process");
            return;
        }
        if (!this.f2882j || !this.f2886n) {
            m1465a(f2864a);
        }
        AnalyticsConfig.m1472a(f2864a, i);
    }

    /* renamed from: a */
    public void m1463a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        String str;
        if (context == null) {
            str = "unexpected null context in setScenarioType";
        } else {
            if (f2864a == null) {
                f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (UMUtils.isMainProgress(f2864a)) {
                if (eScenarioType != null) {
                    m1464a(f2864a, eScenarioType.toValue());
                }
                if (this.f2882j && this.f2886n) {
                    return;
                }
                m1465a(f2864a);
                return;
            }
            str = "setScenarioType can not be called in child process";
        }
        MLog.m574e(str);
    }

    /* renamed from: a */
    public void m1462a(Context context, String str) {
        if (context == null) {
            UMLog.m773aq(C1640j.f3522w, 0, "\\|");
            return;
        }
        if (f2864a == null) {
            f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("reportError can not be called in child process");
        } else if (TextUtils.isEmpty(str)) {
            if (!UMConfigure.isDebugLog()) {
                return;
            }
            UMLog.m773aq(C1640j.f3523x, 0, "\\|");
        } else {
            try {
                if (!this.f2882j || !this.f2886n) {
                    m1465a(f2864a);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(C1615d.f3291Q, 2);
                jSONObject.put(C1615d.f3292R, str);
                jSONObject.put("__ii", this.f2880f.m887c());
                UMWorkDispatch.sendEvent(f2864a, C1648o.C1650a.f3593j, CoreProtocol.getInstance(f2864a), jSONObject);
            } catch (Throwable th) {
                if (!MLog.DEBUG) {
                    return;
                }
                MLog.m570e(th);
            }
        }
    }

    /* renamed from: a */
    public synchronized void m1461a(Context context, String str, Object obj) {
        JSONArray jSONArray;
        int i = 0;
        if (context == null) {
            UMLog.m773aq(C1640j.f3488af, 0, "\\|");
            return;
        }
        if (f2864a == null) {
            f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("registerSuperProperty can not be called in child process");
            return;
        }
        if (!this.f2882j || !this.f2886n) {
            m1465a(f2864a);
        }
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (!str.equals(f2875z) && !str.equals(f2860A) && !str.equals(f2861B) && !str.equals(f2862C) && !str.equals(f2863D)) {
                MLog.m574e("property name is " + str + ", please check key, must be correct!");
                return;
            } else if ((obj instanceof String) && !HelperUtils.checkStrLen(obj.toString(), 256)) {
                MLog.m574e("property value is " + obj + ", please check value, lawless!");
                return;
            } else {
                try {
                    if (this.f2883k == null) {
                        this.f2883k = new JSONObject();
                    }
                    if (obj.getClass().isArray()) {
                        if (obj instanceof String[]) {
                            String[] strArr = (String[]) obj;
                            if (strArr.length > 10) {
                                MLog.m574e("please check value, size is " + strArr.length + ", overstep 10!");
                                return;
                            }
                            jSONArray = new JSONArray();
                            while (i < strArr.length) {
                                if (strArr[i] != null && HelperUtils.checkStrLen(strArr[i], 256)) {
                                    jSONArray.put(strArr[i]);
                                    i++;
                                }
                                MLog.m574e("please check value, length is " + strArr[i].length() + ", overlength 256!");
                                return;
                            }
                        } else if (obj instanceof long[]) {
                            long[] jArr = (long[]) obj;
                            if (jArr.length > 10) {
                                MLog.m574e("please check value, size is " + jArr.length + ", overstep 10!");
                                return;
                            }
                            jSONArray = new JSONArray();
                            while (i < jArr.length) {
                                jSONArray.put(jArr[i]);
                                i++;
                            }
                        } else if (obj instanceof int[]) {
                            int[] iArr = (int[]) obj;
                            if (iArr.length > 10) {
                                MLog.m574e("please check value, size is " + iArr.length + ", overstep 10!");
                                return;
                            }
                            jSONArray = new JSONArray();
                            while (i < iArr.length) {
                                jSONArray.put(iArr[i]);
                                i++;
                            }
                        } else if (obj instanceof float[]) {
                            float[] fArr = (float[]) obj;
                            if (fArr.length > 10) {
                                MLog.m574e("please check value, size is " + fArr.length + ", overstep 10!");
                                return;
                            }
                            jSONArray = new JSONArray();
                            while (i < fArr.length) {
                                jSONArray.put(fArr[i]);
                                i++;
                            }
                        } else if (obj instanceof double[]) {
                            double[] dArr = (double[]) obj;
                            if (dArr.length > 10) {
                                MLog.m574e("please check value, size is " + dArr.length + ", overstep 10!");
                                return;
                            }
                            jSONArray = new JSONArray();
                            while (i < dArr.length) {
                                jSONArray.put(dArr[i]);
                                i++;
                            }
                        } else if (!(obj instanceof short[])) {
                            MLog.m574e("please check value, illegal type!");
                            return;
                        } else {
                            short[] sArr = (short[]) obj;
                            if (sArr.length > 10) {
                                MLog.m574e("please check value, size is " + sArr.length + ", overstep 10!");
                                return;
                            }
                            jSONArray = new JSONArray();
                            while (i < sArr.length) {
                                jSONArray.put((int) sArr[i]);
                                i++;
                            }
                        }
                        this.f2883k.put(str, jSONArray);
                    } else {
                        if (!(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Short)) {
                            MLog.m574e("please check value, illegal type!");
                            return;
                        }
                        this.f2883k.put(str, obj);
                    }
                } catch (Throwable unused) {
                }
                UMWorkDispatch.sendEvent(f2864a, C1648o.C1650a.f3601r, CoreProtocol.getInstance(f2864a), this.f2883k.toString());
                return;
            }
        }
        UMLog.m773aq(C1640j.f3489ag, 0, "\\|");
    }

    /* renamed from: a */
    public void m1460a(Context context, String str, String str2, long j, int i) {
        if (context == null) {
            return;
        }
        try {
            if (f2864a == null) {
                f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!this.f2882j || !this.f2886n) {
                m1465a(f2864a);
            }
            if (m1436c(str)) {
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str3 = "";
            if (this.f2883k == null) {
                this.f2883k = new JSONObject();
            } else {
                str3 = this.f2883k.toString();
            }
            C1659s.m915a(f2864a).m913a(str, str2, j, i, str3);
        } catch (Throwable th) {
            if (!MLog.DEBUG) {
                return;
            }
            MLog.m570e(th);
        }
    }

    /* renamed from: a */
    public void m1459a(Context context, String str, HashMap<String, Object> hashMap) {
        if (context == null) {
            return;
        }
        try {
            if (f2864a == null) {
                f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f2864a)) {
                MLog.m574e("onGKVEvent can not be called in child process");
                return;
            }
            if (!this.f2882j || !this.f2886n) {
                m1465a(f2864a);
            }
            String str2 = "";
            if (this.f2883k == null) {
                this.f2883k = new JSONObject();
            } else {
                str2 = this.f2883k.toString();
            }
            C1659s.m915a(f2864a).m911a(str, hashMap, str2);
        } catch (Throwable th) {
            if (!MLog.DEBUG) {
                return;
            }
            MLog.m570e(th);
        }
    }

    /* renamed from: a */
    public void m1458a(Context context, String str, Map<String, Object> map) {
        m1456a(context, str, map, -1L, true);
    }

    /* renamed from: a */
    public void m1457a(Context context, String str, Map<String, Object> map, long j) {
        try {
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m570e(th);
            }
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.m773aq(C1640j.f3502c, 0, "\\|");
        } else if (Arrays.asList(C1615d.f3307aF).contains(str)) {
            UMLog.m773aq(C1640j.f3501b, 0, "\\|");
        } else if (map.isEmpty()) {
            UMLog.m773aq(C1640j.f3503d, 0, "\\|");
        } else {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (Arrays.asList(C1615d.f3307aF).contains(entry.getKey())) {
                    UMLog.m773aq(C1640j.f3504e, 0, "\\|");
                    return;
                }
            }
            m1456a(context, str, map, j, false);
        }
    }

    /* renamed from: a */
    public void m1455a(Context context, Throwable th) {
        if (context == null || th == null) {
            UMLog.m773aq(C1640j.f3524y, 0, "\\|");
            return;
        }
        if (f2864a == null) {
            f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("reportError can not be called in child process");
            return;
        }
        try {
            if (!this.f2882j || !this.f2886n) {
                m1465a(f2864a);
            }
            m1462a(f2864a, DataHelper.convertExceptionToString(th));
        } catch (Exception e) {
            if (!MLog.DEBUG) {
                return;
            }
            MLog.m570e(e);
        }
    }

    /* renamed from: a */
    public synchronized void m1454a(Context context, List<String> list) {
        try {
        } catch (Throwable th) {
            MLog.m570e(th);
        }
        if (context == null) {
            UMLog.m773aq(C1640j.f3492aj, 0, "\\|");
            return;
        }
        if (f2864a == null) {
            f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("setFirstLaunchEvent can not be called in child process");
            return;
        }
        if (!this.f2882j || !this.f2886n) {
            m1465a(f2864a);
        }
        C1659s.m915a(f2864a).m908a(list);
    }

    /* renamed from: a */
    public synchronized void m1453a(Context context, JSONObject jSONObject) {
        String obj;
        Object obj2;
        if (context == null) {
            UMLog.m773aq(C1640j.f3494al, 0, "\\|");
            return;
        }
        if (f2864a == null) {
            f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("registerPreProperties can not be called in child process");
            return;
        }
        if (!this.f2882j || !this.f2886n) {
            m1465a(f2864a);
        }
        if (this.f2885m == null) {
            this.f2885m = new JSONObject();
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            UMLog.m773aq(C1640j.f3495am, 0, "\\|");
            return;
        }
        JSONObject jSONObject2 = null;
        try {
            jSONObject2 = new JSONObject(this.f2885m.toString());
        } catch (Exception unused) {
        }
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        if (keys != null) {
            while (keys.hasNext()) {
                try {
                    obj = keys.next().toString();
                    obj2 = jSONObject.get(obj);
                } catch (Exception unused2) {
                }
                if (!m1440b(obj, obj2)) {
                    return;
                }
                jSONObject2.put(obj, obj2);
                if (jSONObject2.length() > 10) {
                    MLog.m574e("please check propertics, size overlength!");
                    return;
                }
                continue;
            }
        }
        this.f2885m = jSONObject2;
        if (this.f2885m.length() > 0) {
            UMWorkDispatch.sendEvent(f2864a, C1648o.C1650a.f3604u, CoreProtocol.getInstance(f2864a), this.f2885m.toString());
        }
    }

    /* renamed from: a */
    public void m1452a(ISysListener iSysListener) {
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("setSysListener can not be called in child process");
        } else {
            this.f2876b = iSysListener;
        }
    }

    /* renamed from: a */
    public synchronized void m1451a(Object obj) {
        if (f2864a == null) {
            return;
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("registerSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (obj != null) {
            String str = (String) obj;
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f2864a).edit();
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString(f2865h, this.f2883k.toString()).commit();
            }
        }
    }

    /* renamed from: a */
    public void m1450a(String str) {
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("onPageStart can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.LEGACY_AUTO) {
                return;
            }
            this.f2878d.m878a(str);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m1448a(String str, String str2) {
        try {
            if (f2864a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f2864a)) {
                MLog.m574e("onProfileSignIn can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C1615d.f3287M, str);
            jSONObject.put("uid", str2);
            jSONObject.put("ts", currentTimeMillis);
            UMWorkDispatch.sendEvent(f2864a, C1648o.C1650a.f3588e, CoreProtocol.getInstance(f2864a), jSONObject);
            UMWorkDispatch.sendEvent(f2864a, C1648o.C1650a.f3598o, CoreProtocol.getInstance(f2864a), jSONObject);
        } catch (Throwable th) {
            if (!MLog.DEBUG) {
                return;
            }
            MLog.m572e(" Excepthon  in  onProfileSignIn", th);
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1662t
    /* renamed from: a */
    public void mo900a(Throwable th) {
        try {
            if (f2864a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f2864a)) {
                MLog.m574e("onAppCrash can not be called in child process");
            } else if (!AnalyticsConfig.enable) {
            } else {
                if (this.f2878d != null) {
                    this.f2878d.m877b();
                }
                C1642l.m1018a(f2864a, "onAppCrash");
                if (this.f2879e != null) {
                    this.f2879e.m877b();
                }
                if (this.f2881g != null) {
                    this.f2881g.m1009c();
                }
                if (this.f2880f != null) {
                    this.f2880f.m885c(f2864a, Long.valueOf(System.currentTimeMillis()));
                }
                if (th != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put(C1615d.f3291Q, 1);
                    jSONObject.put(C1615d.f3292R, DataHelper.convertExceptionToString(th));
                    C1636i.m1056a(f2864a).m1053a(this.f2880f.m887c(), jSONObject.toString(), 1);
                }
                C1648o.m985a(f2864a).m965d();
                C1666v.m879a(f2864a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    C1642l.m1007c(f2864a);
                }
                PreferenceWrapper.getDefault(f2864a).edit().commit();
            }
        } catch (Exception e) {
            if (!MLog.DEBUG) {
                return;
            }
            MLog.m572e("Exception in onAppCrash", e);
        }
    }

    /* renamed from: a */
    public void m1447a(GL10 gl10) {
        String[] gpu = UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            AnalyticsConfig.GPU_VENDER = gpu[0];
            AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    /* renamed from: a */
    public void m1446a(boolean z) {
        Context context = f2864a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.m574e("setCatchUncaughtExceptions can not be called in child process");
        } else if (AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW) {
        } else {
            AnalyticsConfig.CATCH_EXCEPTION = z;
        }
    }

    /* renamed from: b */
    public JSONObject m1445b() {
        return this.f2883k;
    }

    /* renamed from: b */
    public void m1444b(Context context) {
        String str;
        if (context == null) {
            str = "unexpected null context in onResume";
        } else if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
            return;
        } else {
            if (f2864a == null) {
                f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (UMUtils.isMainProgress(f2864a)) {
                if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
                    UMLog.m773aq(C1640j.f3514o, 2, "\\|");
                }
                try {
                    if (!this.f2882j || !this.f2886n) {
                        m1465a(context);
                    }
                    if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                        this.f2879e.m878a(context.getClass().getName());
                    }
                    m1424h();
                    if (!UMConfigure.isDebugLog() || !(context instanceof Activity)) {
                        return;
                    }
                    f2869q = context.getClass().getName();
                    return;
                } catch (Throwable th) {
                    MLog.m572e("Exception occurred in Mobclick.onResume(). ", th);
                    return;
                }
            }
            str = "onResume can not be called in child process";
        }
        MLog.m574e(str);
    }

    /* renamed from: b */
    public void m1443b(Context context, String str) {
        try {
            if (context == null) {
                UMLog.m773aq(C1640j.f3469N, 0, "\\|");
                return;
            }
            if (f2864a == null) {
                f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f2864a)) {
                MLog.m574e("onDeepLinkReceived can not be called in child process");
                return;
            }
            if (!this.f2882j || !this.f2886n) {
                m1465a(f2864a);
            }
            if (TextUtils.isEmpty(str)) {
                UMLog.m773aq(C1640j.f3470O, 0, "\\|");
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(C1615d.f3306aE, str);
            m1456a(f2864a, C1615d.f3305aD, (Map<String, Object>) hashMap, -1L, false);
        } catch (Throwable th) {
            if (!MLog.DEBUG) {
                return;
            }
            MLog.m570e(th);
        }
    }

    /* renamed from: b */
    public synchronized void m1442b(Object obj) {
        SharedPreferences.Editor remove;
        if (f2864a == null) {
            return;
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("updateNativePrePropertiesByCoreProtocol can not be called in child process");
            return;
        }
        SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f2864a).edit();
        if (obj == null) {
            if (edit != null) {
                remove = edit.remove(f2866i);
            }
        }
        String str = (String) obj;
        if (edit != null && !TextUtils.isEmpty(str)) {
            remove = edit.putString(f2866i, str);
        }
        remove.commit();
    }

    /* renamed from: b */
    public void m1441b(String str) {
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("onPageEnd can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.LEGACY_AUTO) {
                return;
            }
            this.f2878d.m876b(str);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public JSONObject m1439c() {
        return this.f2885m;
    }

    /* renamed from: c */
    public void m1438c(Context context) {
        if (context == null) {
            UMLog.m773aq(C1640j.f3515p, 0, "\\|");
        } else if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
        } else {
            if (f2864a == null) {
                f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f2864a)) {
                MLog.m574e("onPause can not be called in child process");
                return;
            }
            if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
                UMLog.m773aq(C1640j.f3516q, 2, "\\|");
            }
            try {
                if (!this.f2882j || !this.f2886n) {
                    m1465a(context);
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                    this.f2879e.m876b(context.getClass().getName());
                }
                m1422i();
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.m572e("Exception occurred in Mobclick.onRause(). ", th);
                }
            }
            if (!UMConfigure.isDebugLog() || !(context instanceof Activity)) {
                return;
            }
            f2870r = context.getClass().getName();
        }
    }

    /* renamed from: c */
    public void m1437c(Context context, String str) {
        if (context == null) {
            UMLog.m773aq(C1640j.f3525z, 0, "\\|");
            return;
        }
        if (f2864a == null) {
            f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("setSecret can not be called in child process");
            return;
        }
        if (!this.f2882j || !this.f2886n) {
            m1465a(f2864a);
        }
        AnalyticsConfig.m1471a(f2864a, str);
    }

    /* renamed from: d */
    public JSONObject m1435d() {
        return this.f2884l;
    }

    /* renamed from: d */
    public void m1434d(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f2864a == null) {
                f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f2864a)) {
                MLog.m574e("onKillProcess can not be called in child process");
                return;
            }
            if (this.f2881g != null) {
                this.f2881g.m1009c();
            }
            C1642l.m1018a(context, "onKillProcess");
            if (this.f2879e != null) {
                this.f2879e.m877b();
            }
            if (this.f2878d != null) {
                this.f2878d.m877b();
            }
            if (f2864a == null) {
                return;
            }
            if (this.f2880f != null) {
                this.f2880f.m885c(f2864a, Long.valueOf(System.currentTimeMillis()));
            }
            C1648o.m985a(f2864a).m965d();
            C1666v.m879a(f2864a);
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                C1642l.m1007c(f2864a);
            }
            PreferenceWrapper.getDefault(f2864a).edit().commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    public synchronized void m1433d(Context context, String str) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            UMLog.m773aq(C1640j.f3490ah, 0, "\\|");
            return;
        }
        if (f2864a == null) {
            f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("unregisterSuperProperty can not be called in child process");
            return;
        }
        if (!this.f2882j || !this.f2886n) {
            m1465a(f2864a);
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.m773aq(C1640j.f3489ag, 0, "\\|");
        } else if (!str.equals(f2875z) && !str.equals(f2860A) && !str.equals(f2861B) && !str.equals(f2862C) && !str.equals(f2863D)) {
            MLog.m574e("please check key or value, must be correct!");
        } else {
            if (this.f2883k == null) {
                this.f2883k = new JSONObject();
            }
            if (this.f2883k.has(str)) {
                this.f2883k.remove(str);
                UMWorkDispatch.sendEvent(f2864a, C1648o.C1650a.f3603t, CoreProtocol.getInstance(f2864a), str);
            }
        }
    }

    /* renamed from: e */
    public synchronized Object m1430e(Context context, String str) {
        if (context == null) {
            UMLog.m773aq(C1640j.f3491ai, 0, "\\|");
            return null;
        }
        if (f2864a == null) {
            f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("getSuperProperty can not be called in child process");
            return null;
        } else if (TextUtils.isEmpty(str)) {
            UMLog.m773aq(C1640j.f3489ag, 0, "\\|");
            return null;
        } else if (!str.equals(f2875z) && !str.equals(f2860A) && !str.equals(f2861B) && !str.equals(f2862C) && !str.equals(f2863D)) {
            MLog.m574e("please check key or value, must be correct!");
            return null;
        } else {
            if (this.f2883k == null) {
                this.f2883k = new JSONObject();
            } else if (this.f2883k.has(str)) {
                return this.f2883k.opt(str);
            }
            return null;
        }
    }

    /* renamed from: e */
    public synchronized String m1431e(Context context) {
        if (context == null) {
            UMLog.m773aq(C1640j.f3491ai, 0, "\\|");
            return null;
        }
        if (f2864a == null) {
            f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("getSuperProperties can not be called in child process");
            return null;
        } else if (this.f2883k != null) {
            return this.f2883k.toString();
        } else {
            this.f2883k = new JSONObject();
            return null;
        }
    }

    /* renamed from: e */
    public void m1432e() {
        this.f2884l = null;
    }

    /* renamed from: f */
    public String m1429f() {
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("getOnResumedActivityName can not be called in child process");
            return null;
        }
        return f2869q;
    }

    /* renamed from: f */
    public synchronized void m1428f(Context context) {
        if (context == null) {
            UMLog.m773aq(C1640j.f3490ah, 0, "\\|");
            return;
        }
        if (f2864a == null) {
            f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("clearSuperProperties can not be called in child process");
            return;
        }
        if (!this.f2882j || !this.f2886n) {
            m1465a(f2864a);
        }
        this.f2883k = new JSONObject();
        UMWorkDispatch.sendEvent(f2864a, C1648o.C1650a.f3602s, CoreProtocol.getInstance(f2864a), null);
    }

    /* renamed from: f */
    public synchronized void m1427f(Context context, String str) {
        if (context == null) {
            UMLog.m773aq(C1640j.f3496an, 0, "\\|");
            return;
        }
        if (f2864a == null) {
            f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("unregisterPreProperty can not be called in child process");
            return;
        }
        if (!this.f2882j || !this.f2886n) {
            m1465a(f2864a);
        }
        if (this.f2885m == null) {
            this.f2885m = new JSONObject();
        }
        if (str != null && str.length() > 0) {
            if (this.f2885m.has(str)) {
                this.f2885m.remove(str);
                UMWorkDispatch.sendEvent(f2864a, C1648o.C1650a.f3605v, CoreProtocol.getInstance(f2864a), this.f2885m.toString());
            } else if (UMConfigure.isDebugLog()) {
                UMLog.m773aq(C1640j.f3497ao, 0, "\\|");
            }
            return;
        }
        MLog.m574e("please check propertics, property is null!");
    }

    /* renamed from: g */
    public String m1426g() {
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("getOnPausedActivityName can not be called in child process");
            return null;
        }
        return f2870r;
    }

    /* renamed from: g */
    public synchronized void m1425g(Context context) {
        if (context == null) {
            UMLog.m773aq(C1640j.f3498ap, 0, "\\|");
            return;
        }
        if (f2864a == null) {
            f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("clearPreProperties can not be called in child process");
            return;
        }
        if (!this.f2882j || !this.f2886n) {
            m1465a(f2864a);
        }
        if (this.f2885m.length() > 0) {
            UMWorkDispatch.sendEvent(f2864a, C1648o.C1650a.f3606w, CoreProtocol.getInstance(f2864a), null);
        }
        this.f2885m = new JSONObject();
    }

    /* renamed from: h */
    public synchronized JSONObject m1423h(Context context) {
        if (context == null) {
            UMLog.m773aq(C1640j.f3499aq, 0, "\\|");
            return null;
        }
        if (f2864a == null) {
            f2864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("getPreProperties can not be called in child process");
            return null;
        }
        if (!this.f2882j || !this.f2886n) {
            m1465a(f2864a);
        }
        if (this.f2885m == null) {
            this.f2885m = new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (this.f2885m.length() > 0) {
            try {
                jSONObject = new JSONObject(this.f2885m.toString());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    /* renamed from: h */
    public void m1424h() {
        try {
            if (f2864a != null) {
                if (!UMUtils.isMainProgress(f2864a)) {
                    MLog.m574e("onStartSessionInternal can not be called in child process");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                UMWorkDispatch.sendEvent(f2864a, 4352, CoreProtocol.getInstance(f2864a), Long.valueOf(currentTimeMillis));
                UMWorkDispatch.sendEvent(f2864a, C1648o.C1650a.f3590g, CoreProtocol.getInstance(f2864a), Long.valueOf(currentTimeMillis));
            }
            if (this.f2876b == null) {
                return;
            }
            this.f2876b.onAppResume();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: i */
    public void m1422i() {
        try {
            if (f2864a != null) {
                if (!UMUtils.isMainProgress(f2864a)) {
                    MLog.m574e("onEndSessionInternal can not be called in child process");
                    return;
                }
                UMWorkDispatch.sendEvent(f2864a, C1648o.C1650a.f3591h, CoreProtocol.getInstance(f2864a), Long.valueOf(System.currentTimeMillis()));
                UMWorkDispatch.sendEvent(f2864a, C1648o.C1650a.f3587d, CoreProtocol.getInstance(f2864a), null);
                UMWorkDispatch.sendEvent(f2864a, 4099, CoreProtocol.getInstance(f2864a), null);
                UMWorkDispatch.sendEvent(f2864a, C1648o.C1650a.f3592i, CoreProtocol.getInstance(f2864a), null);
            }
        } catch (Throwable unused) {
        }
        ISysListener iSysListener = this.f2876b;
        if (iSysListener != null) {
            iSysListener.onAppPause();
        }
    }

    /* renamed from: j */
    public void m1420j() {
        try {
            if (f2864a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f2864a)) {
                MLog.m574e("onProfileSignOff can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", currentTimeMillis);
            UMWorkDispatch.sendEvent(f2864a, C1648o.C1650a.f3589f, CoreProtocol.getInstance(f2864a), jSONObject);
            UMWorkDispatch.sendEvent(f2864a, C1648o.C1650a.f3598o, CoreProtocol.getInstance(f2864a), jSONObject);
        } catch (Throwable th) {
            if (!MLog.DEBUG) {
                return;
            }
            MLog.m572e(" Excepthon  in  onProfileSignOff", th);
        }
    }

    /* renamed from: k */
    public synchronized void m1419k() {
        if (f2864a == null) {
            return;
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("unregisterSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (this.f2883k != null) {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f2864a).edit();
            edit.putString(f2865h, this.f2883k.toString());
            edit.commit();
        } else {
            this.f2883k = new JSONObject();
        }
    }

    /* renamed from: l */
    public synchronized JSONObject m1418l() {
        if (f2864a == null) {
            return null;
        }
        if (!UMUtils.isMainProgress(f2864a)) {
            MLog.m574e("getSuperPropertiesJSONObject can not be called in child process");
            return null;
        }
        if (this.f2883k == null) {
            this.f2883k = new JSONObject();
        }
        return this.f2883k;
    }

    /* renamed from: m */
    public synchronized void m1417m() {
        try {
            if (f2864a != null) {
                if (!UMUtils.isMainProgress(f2864a)) {
                    MLog.m574e("clearSuperPropertiesByCoreProtocol can not be called in child process");
                    return;
                }
                SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f2864a).edit();
                edit.remove(f2865h);
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1647n
    /* renamed from: n */
    public void mo989n() {
        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> onIntoBackground triggered.");
        if (!AnalyticsConfig.enable || !FieldManager.m790b()) {
            return;
        }
        if (!FieldManager.allow(C1847b.f4253D)) {
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> 退出发送策略: 云控控制字关闭。功能不生效");
        } else if (UMWorkDispatch.eventHasExist(C1648o.C1650a.f3609z)) {
        } else {
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> 退出时发送策略 被触发！");
            Context context = f2864a;
            UMWorkDispatch.sendEvent(context, C1648o.C1650a.f3609z, CoreProtocol.getInstance(context), null);
        }
    }
}
