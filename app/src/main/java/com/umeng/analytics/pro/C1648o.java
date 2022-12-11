package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C1517b;
import com.umeng.analytics.C1520c;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.common.C1687b;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.C1720a;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.C1847b;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import me.tvspark.outline;
import org.json.JSONArray;
import org.json.JSONObject;
import org.litepal.parser.LitePalParser;

/* renamed from: com.umeng.analytics.pro.o */
/* loaded from: classes4.dex */
public class C1648o {

    /* renamed from: a */
    public static Context f3553a = null;

    /* renamed from: l */
    public static final String f3554l = "first_activate_time";

    /* renamed from: m */
    public static final String f3555m = "ana_is_f";

    /* renamed from: n */
    public static final String f3556n = "thtstart";

    /* renamed from: o */
    public static final String f3557o = "dstk_last_time";

    /* renamed from: p */
    public static final String f3558p = "dstk_cnt";

    /* renamed from: q */
    public static final String f3559q = "gkvc";

    /* renamed from: r */
    public static final String f3560r = "ekvc";

    /* renamed from: t */
    public static final String f3561t = "-1";

    /* renamed from: x */
    public static final String f3562x = "com.umeng.umcrash.UMCrashUtils";

    /* renamed from: y */
    public static Class<?> f3563y;

    /* renamed from: z */
    public static Method f3564z;

    /* renamed from: b */
    public C1652c f3565b;

    /* renamed from: c */
    public SharedPreferences f3566c;

    /* renamed from: d */
    public String f3567d;

    /* renamed from: e */
    public String f3568e;

    /* renamed from: f */
    public int f3569f;

    /* renamed from: g */
    public JSONArray f3570g;

    /* renamed from: h */
    public final int f3571h;

    /* renamed from: i */
    public int f3572i;

    /* renamed from: j */
    public int f3573j;

    /* renamed from: k */
    public long f3574k;

    /* renamed from: s */
    public final long f3575s;

    /* renamed from: u */
    public boolean f3576u;

    /* renamed from: v */
    public boolean f3577v;

    /* renamed from: w */
    public Object f3578w;

    /* renamed from: com.umeng.analytics.pro.o$a */
    /* loaded from: classes4.dex */
    public static class C1650a {

        /* renamed from: A */
        public static final int f3579A = 8211;

        /* renamed from: B */
        public static final int f3580B = 8212;

        /* renamed from: C */
        public static final int f3581C = 8213;

        /* renamed from: D */
        public static final int f3582D = 8214;

        /* renamed from: E */
        public static final int f3583E = 8215;

        /* renamed from: a */
        public static final int f3584a = 4097;

        /* renamed from: b */
        public static final int f3585b = 4098;

        /* renamed from: c */
        public static final int f3586c = 4099;

        /* renamed from: d */
        public static final int f3587d = 4100;

        /* renamed from: e */
        public static final int f3588e = 4101;

        /* renamed from: f */
        public static final int f3589f = 4102;

        /* renamed from: g */
        public static final int f3590g = 4103;

        /* renamed from: h */
        public static final int f3591h = 4104;

        /* renamed from: i */
        public static final int f3592i = 4105;

        /* renamed from: j */
        public static final int f3593j = 4106;

        /* renamed from: k */
        public static final int f3594k = 4352;

        /* renamed from: l */
        public static final int f3595l = 4353;

        /* renamed from: m */
        public static final int f3596m = 4354;

        /* renamed from: n */
        public static final int f3597n = 4355;

        /* renamed from: o */
        public static final int f3598o = 4356;

        /* renamed from: p */
        public static final int f3599p = 8193;

        /* renamed from: q */
        public static final int f3600q = 8194;

        /* renamed from: r */
        public static final int f3601r = 8195;

        /* renamed from: s */
        public static final int f3602s = 8196;

        /* renamed from: t */
        public static final int f3603t = 8197;

        /* renamed from: u */
        public static final int f3604u = 8199;

        /* renamed from: v */
        public static final int f3605v = 8200;

        /* renamed from: w */
        public static final int f3606w = 8201;

        /* renamed from: x */
        public static final int f3607x = 8208;

        /* renamed from: y */
        public static final int f3608y = 8209;

        /* renamed from: z */
        public static final int f3609z = 8210;
    }

    /* renamed from: com.umeng.analytics.pro.o$b */
    /* loaded from: classes4.dex */
    public static class C1651b {

        /* renamed from: a */
        public static final C1648o f3610a = new C1648o();
    }

    /* renamed from: com.umeng.analytics.pro.o$c */
    /* loaded from: classes4.dex */
    public static class C1652c {

        /* renamed from: a */
        public ReportPolicy.ReportStrategy f3611a = null;

        /* renamed from: b */
        public int f3612b = -1;

        /* renamed from: c */
        public int f3613c = -1;

        /* renamed from: d */
        public int f3614d = -1;

        /* renamed from: e */
        public int f3615e = -1;

        /* renamed from: f */
        public ABTest f3616f;

        public C1652c() {
            this.f3616f = null;
            this.f3616f = ABTest.getService(C1648o.f3553a);
        }

        /* renamed from: b */
        private ReportPolicy.ReportStrategy m934b(int i, int i2) {
            if (i == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.f3611a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy : new ReportPolicy.ReportRealtime();
            } else if (i == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.f3611a;
                return reportStrategy2 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy2 : new ReportPolicy.ReportAtLaunch();
            } else if (i == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.f3611a;
                return reportStrategy3 instanceof ReportPolicy.ReportDaily ? reportStrategy3 : new ReportPolicy.ReportDaily(StatTracer.getInstance(C1648o.f3553a));
            } else if (i == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.f3611a;
                return reportStrategy4 instanceof ReportPolicy.ReportWifiOnly ? reportStrategy4 : new ReportPolicy.ReportWifiOnly(C1648o.f3553a);
            } else if (i == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.f3611a;
                if (!(reportStrategy5 instanceof ReportPolicy.ReportByInterval)) {
                    return new ReportPolicy.ReportByInterval(StatTracer.getInstance(C1648o.f3553a), i2);
                }
                ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval(i2);
                return reportStrategy5;
            } else if (i == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.f3611a;
                return reportStrategy6 instanceof ReportPolicy.SmartPolicy ? reportStrategy6 : new ReportPolicy.SmartPolicy(StatTracer.getInstance(C1648o.f3553a));
            } else if (i != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.f3611a;
                return reportStrategy7 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy7 : new ReportPolicy.ReportAtLaunch();
            } else {
                ReportPolicy.ReportStrategy reportStrategy8 = this.f3611a;
                if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                    ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval(i2);
                    return reportStrategy8;
                }
                ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
                reportQuasiRealtime.setReportInterval(i2);
                return reportQuasiRealtime;
            }
        }

        /* renamed from: a */
        public int m937a(int i) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(C1648o.f3553a, "test_report_interval", "-1")).intValue();
            return (intValue == -1 || intValue < 90 || intValue > 86400) ? i : intValue * 1000;
        }

        /* renamed from: a */
        public void m938a() {
            try {
                int[] m936a = m936a(-1, -1);
                this.f3612b = m936a[0];
                this.f3613c = m936a[1];
            } catch (Throwable unused) {
            }
        }

        /* renamed from: a */
        public int[] m936a(int i, int i2) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(C1648o.f3553a, C1720a.f3880q, "-1")).intValue();
            int intValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(C1648o.f3553a, C1720a.f3881r, "-1")).intValue();
            if (intValue == -1 || !ReportPolicy.isValid(intValue)) {
                return new int[]{i, i2};
            }
            if (6 == intValue) {
                if (intValue2 == -1 || intValue2 < 90 || intValue2 > 86400) {
                    intValue2 = 90;
                }
                return new int[]{intValue, intValue2 * 1000};
            } else if (11 != intValue) {
                return new int[]{i, i2};
            } else {
                if (intValue2 == -1 || intValue2 < 15 || intValue2 > 3600) {
                    intValue2 = 15;
                }
                return new int[]{intValue, intValue2 * 1000};
            }
        }

        /* renamed from: b */
        public void m935b() {
            ReportPolicy.ReportStrategy m934b;
            int i;
            String str;
            Defcon service = Defcon.getService(C1648o.f3553a);
            if (service.isOpen()) {
                ReportPolicy.ReportStrategy reportStrategy = this.f3611a;
                m934b = (reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid() ? this.f3611a : new ReportPolicy.DefconPolicy(StatTracer.getInstance(C1648o.f3553a), service);
            } else {
                boolean z = Integer.valueOf(UMEnvelopeBuild.imprintProperty(C1648o.f3553a, "integrated_test", "-1")).intValue() == 1;
                if (UMConfigure.isDebugLog() && z && !MLog.DEBUG) {
                    UMLog.mutlInfo(C1640j.f3466K, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z) {
                    m934b = new ReportPolicy.DebugPolicy(StatTracer.getInstance(C1648o.f3553a));
                } else if (!this.f3616f.isInTest() || !"RPT".equals(this.f3616f.getTestName())) {
                    int i2 = this.f3614d;
                    int i3 = this.f3615e;
                    int i4 = this.f3612b;
                    if (i4 != -1) {
                        i3 = this.f3613c;
                        i2 = i4;
                    }
                    m934b = m934b(i2, i3);
                } else {
                    if (this.f3616f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(C1648o.f3553a, "test_report_interval", "-1")).intValue() != -1) {
                            i = m937a(90000);
                        } else {
                            i = this.f3613c;
                            if (i <= 0) {
                                i = this.f3615e;
                            }
                        }
                    } else {
                        i = 0;
                    }
                    m934b = m934b(this.f3616f.getTestPolicy(), i);
                }
            }
            this.f3611a = m934b;
            if (UMConfigure.isDebugLog()) {
                try {
                    if (this.f3611a instanceof ReportPolicy.ReportAtLaunch) {
                        str = C1640j.f3464I;
                    } else if (this.f3611a instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(C1640j.f3465J, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) this.f3611a).getReportInterval() / 1000)});
                        return;
                    } else if (!(this.f3611a instanceof ReportPolicy.DebugPolicy)) {
                        if (!(this.f3611a instanceof ReportPolicy.ReportQuasiRealtime)) {
                            boolean z2 = this.f3611a instanceof ReportPolicy.DefconPolicy;
                            return;
                        }
                        String[] strArr = {String.valueOf(((ReportPolicy.ReportQuasiRealtime) this.f3611a).getReportInterval() / 1000)};
                        UMLog uMLog = UMConfigure.umDebugLog;
                        UMLog.mutlInfo(C1640j.f3468M, 3, "", new String[]{"@"}, strArr);
                        return;
                    } else {
                        str = C1640j.f3467L;
                    }
                    UMLog.mutlInfo(str, 3, "", null, null);
                } catch (Throwable unused) {
                }
            }
        }

        /* renamed from: c */
        public ReportPolicy.ReportStrategy m933c() {
            m935b();
            return this.f3611a;
        }
    }

    /* renamed from: com.umeng.analytics.pro.o$d */
    /* loaded from: classes4.dex */
    public static class C1653d {

        /* renamed from: a */
        public Map<String, Object> f3617a;

        /* renamed from: b */
        public String f3618b;

        /* renamed from: c */
        public String f3619c;

        /* renamed from: d */
        public long f3620d;

        public C1653d() {
            this.f3617a = null;
            this.f3618b = null;
            this.f3619c = null;
            this.f3620d = 0L;
        }

        public C1653d(String str, Map<String, Object> map, String str2, long j) {
            this.f3617a = null;
            this.f3618b = null;
            this.f3619c = null;
            this.f3620d = 0L;
            this.f3617a = map;
            this.f3618b = str;
            this.f3620d = j;
            this.f3619c = str2;
        }

        /* renamed from: a */
        public Map<String, Object> m932a() {
            return this.f3617a;
        }

        /* renamed from: b */
        public String m931b() {
            return this.f3619c;
        }

        /* renamed from: c */
        public String m930c() {
            return this.f3618b;
        }

        /* renamed from: d */
        public long m929d() {
            return this.f3620d;
        }
    }

    static {
        m952h();
    }

    public C1648o() {
        this.f3565b = null;
        this.f3566c = null;
        this.f3567d = null;
        this.f3568e = null;
        this.f3569f = 10;
        this.f3570g = new JSONArray();
        this.f3571h = 5000;
        this.f3572i = 0;
        this.f3573j = 0;
        this.f3574k = 0L;
        this.f3575s = Defcon.MILLIS_8_HOURS;
        this.f3576u = false;
        this.f3577v = false;
        this.f3578w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3553a);
            this.f3574k = sharedPreferences.getLong("thtstart", 0L);
            this.f3572i = sharedPreferences.getInt("gkvc", 0);
            this.f3573j = sharedPreferences.getInt("ekvc", 0);
            this.f3565b = new C1652c();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static C1648o m985a(Context context) {
        if (f3553a == null && context != null) {
            f3553a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return C1651b.f3610a;
    }

    /* renamed from: a */
    private JSONObject m978a(JSONObject jSONObject, long j) {
        try {
            if (C1655q.m924a(jSONObject) <= j) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put(C1615d.f3303aB, C1655q.m924a(jSONObject));
            jSONObject.put("header", jSONObject2);
            return C1655q.m926a(f3553a, j, jSONObject);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    /* renamed from: a */
    private void m981a(String str, String str2) {
        Method method;
        Class<?> cls = f3563y;
        if (cls == null || (method = f3564z) == null) {
            return;
        }
        try {
            method.invoke(cls, str, str2);
        } catch (Throwable unused) {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> reflect call setPuidAndProvider method of crash lib failed.");
        }
    }

    /* renamed from: a */
    private boolean m986a(long j, int i) {
        if (j != 0) {
            if (System.currentTimeMillis() - j <= Defcon.MILLIS_8_HOURS) {
                return i < 5000;
            }
            m944o();
            return true;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m980a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List asList = Arrays.asList("$$_onUMengEnterForeground", "$$_onUMengEnterBackground", "$$_onUMengEnterForegroundInitError");
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null && asList.contains(optJSONObject.optString("id"))) {
                    i++;
                }
            } catch (Throwable unused) {
            }
        }
        return i >= length;
    }

    /* renamed from: a */
    private boolean m979a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ekv");
        int length = optJSONArray.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(keys.next());
                    if (optJSONArray2 != null && m980a(optJSONArray2)) {
                        i++;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return i >= length;
    }

    /* renamed from: b */
    private JSONObject m971b(JSONObject jSONObject, long j) {
        try {
            if (C1655q.m924a(jSONObject) <= j) {
                return jSONObject;
            }
            jSONObject = null;
            C1636i.m1056a(f3553a).m1044a(true, false);
            C1636i.m1056a(f3553a).m1043b();
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    /* renamed from: b */
    private void m972b(JSONObject jSONObject) {
        JSONObject m1029f;
        if (C1636i.m1056a(UMGlobalContext.getAppContext(f3553a)).m1035c() || (m1029f = C1636i.m1056a(UMGlobalContext.getAppContext(f3553a)).m1029f()) == null) {
            return;
        }
        String optString = m1029f.optString("__av");
        String optString2 = m1029f.optString("__vc");
        try {
            if (TextUtils.isEmpty(optString)) {
                optString = UMUtils.getAppVersionName(f3553a);
            }
            jSONObject.put("app_version", optString);
            if (TextUtils.isEmpty(optString2)) {
                optString2 = UMUtils.getAppVersionCode(f3553a);
            }
            jSONObject.put("version_code", optString2);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    private void m967c(JSONObject jSONObject) {
        Context context;
        String str;
        try {
            if (!C1636i.m1056a(f3553a).m1030e()) {
                JSONObject m1028g = C1636i.m1056a(f3553a).m1028g();
                if (m1028g == null) {
                    return;
                }
                String optString = m1028g.optString("__av");
                str = m1028g.optString("__vc");
                if (TextUtils.isEmpty(optString)) {
                    optString = UMUtils.getAppVersionName(f3553a);
                }
                jSONObject.put("app_version", optString);
                if (TextUtils.isEmpty(str)) {
                    context = f3553a;
                }
                jSONObject.put("version_code", str);
            }
            jSONObject.put("app_version", UMUtils.getAppVersionName(f3553a));
            context = f3553a;
            str = UMUtils.getAppVersionCode(context);
            jSONObject.put("version_code", str);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    private boolean m966c(boolean z) {
        if (!m940s() && !AnalyticsConfig.isRealTimeDebugMode()) {
            if (this.f3565b == null) {
                this.f3565b = new C1652c();
            }
            this.f3565b.m938a();
            ReportPolicy.ReportStrategy m933c = this.f3565b.m933c();
            boolean shouldSendMessage = m933c.shouldSendMessage(z);
            if (shouldSendMessage) {
                if (((m933c instanceof ReportPolicy.ReportByInterval) || (m933c instanceof ReportPolicy.DebugPolicy) || (m933c instanceof ReportPolicy.ReportQuasiRealtime)) && m943p()) {
                    m965d();
                }
                if ((m933c instanceof ReportPolicy.DefconPolicy) && m943p()) {
                    m965d();
                }
                if (UMConfigure.isDebugLog()) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("数据发送策略 : ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(m933c.getClass().getSimpleName());
                    MLog.m580d(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
            }
            return shouldSendMessage;
        }
        return true;
    }

    /* renamed from: d */
    private void m963d(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has("analytics")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("analytics");
                if (jSONObject4.has("ekv")) {
                    str = "version_code";
                    jSONObject3.put("ekv", jSONObject4.getJSONArray("ekv"));
                    if (jSONObject3.length() > 0) {
                        MLog.m580d(AnalyticsConfig.isRealTimeDebugMode() ? "[埋点验证模式]事件:" + jSONObject3.toString() : "事件:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                } else {
                    str = "version_code";
                }
                if (jSONObject4.has(C1615d.f3294T)) {
                    jSONObject3.put(C1615d.f3294T, jSONObject4.getJSONArray(C1615d.f3294T));
                    if (jSONObject3.length() > 0) {
                        MLog.m580d(AnalyticsConfig.isRealTimeDebugMode() ? "[埋点验证模式]游戏事件:" + jSONObject3.toString() : "游戏事件:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has("error")) {
                    jSONObject3.put("error", jSONObject4.getJSONArray("error"));
                    if (jSONObject3.length() > 0) {
                        MLog.m580d(AnalyticsConfig.isRealTimeDebugMode() ? "[埋点验证模式]错误:" + jSONObject3.toString() : "错误:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(C1615d.f3348n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(C1615d.f3348n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            if (jSONObject5.has(C1615d.f3355u)) {
                                jSONObject5.remove(C1615d.f3355u);
                            }
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(C1615d.f3348n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        MLog.m580d(AnalyticsConfig.isRealTimeDebugMode() ? "[埋点验证模式]会话:" + jSONObject3.toString() : "会话:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(C1615d.f3283I)) {
                    jSONObject3.put(C1615d.f3283I, jSONObject4.getJSONObject(C1615d.f3283I));
                }
                if (jSONObject4.has(C1615d.f3286L)) {
                    jSONObject3.put(C1615d.f3286L, jSONObject4.getJSONObject(C1615d.f3286L));
                    if (jSONObject3.length() > 0) {
                        MLog.m580d(AnalyticsConfig.isRealTimeDebugMode() ? "[埋点验证模式]账号:" + jSONObject3.toString() : "账号:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            } else {
                str = "version_code";
            }
            if (jSONObject.has("dplus")) {
                jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
            }
            if (jSONObject.has("header") && jSONObject.has("header") && (jSONObject2 = jSONObject.getJSONObject("header")) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has("sdk_version")) {
                    jSONObject3.put("sdk_version", jSONObject2.getString("sdk_version"));
                }
                if (jSONObject2.has("device_id")) {
                    jSONObject3.put("device_id", jSONObject2.getString("device_id"));
                }
                if (jSONObject2.has("device_model")) {
                    jSONObject3.put("device_model", jSONObject2.getString("device_model"));
                }
                String str2 = str;
                if (jSONObject2.has(str2)) {
                    jSONObject3.put(LitePalParser.NODE_VERSION, jSONObject2.getInt(str2));
                }
                if (jSONObject2.has("appkey")) {
                    jSONObject3.put("appkey", jSONObject2.getString("appkey"));
                }
                if (jSONObject2.has("channel")) {
                    jSONObject3.put("channel", jSONObject2.getString("channel"));
                }
                if (jSONObject3.length() > 0) {
                    MLog.m580d("基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.m570e(th);
        }
    }

    /* renamed from: d */
    private boolean m962d(boolean z) {
        if (this.f3565b == null) {
            this.f3565b = new C1652c();
        }
        ReportPolicy.ReportStrategy m933c = this.f3565b.m933c();
        if (m933c instanceof ReportPolicy.DefconPolicy) {
            return z ? ((ReportPolicy.DefconPolicy) m933c).shouldSendMessageByInstant() : m933c.shouldSendMessage(false);
        }
        return true;
    }

    /* renamed from: e */
    private void m960e(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!m986a(this.f3574k, this.f3572i)) {
                    return;
                }
                this.f3572i++;
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!m986a(this.f3574k, this.f3573j)) {
                    return;
                }
                this.f3573j++;
            }
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                if (this.f3570g == null) {
                    this.f3570g = new JSONArray();
                }
                this.f3570g.put(jSONObject);
                C1636i.m1056a(f3553a).m1049a(this.f3570g);
                this.f3570g = new JSONArray();
                return;
            }
            if (this.f3570g.length() >= this.f3569f) {
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>>*** 超过10个事件，事件落库。");
                C1636i.m1056a(f3553a).m1049a(this.f3570g);
                this.f3570g = new JSONArray();
            }
            if (this.f3574k == 0) {
                this.f3574k = System.currentTimeMillis();
            }
            this.f3570g.put(jSONObject);
        } catch (Throwable th) {
            MLog.m570e(th);
        }
    }

    /* renamed from: e */
    private void m959e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has("analytics")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("analytics");
                if (jSONObject4.has(C1615d.f3348n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(C1615d.f3348n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(C1615d.f3348n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        MLog.m580d("本次启动会话:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(C1615d.f3286L)) {
                    jSONObject3.put(C1615d.f3286L, jSONObject4.getJSONObject(C1615d.f3286L));
                    if (jSONObject3.length() > 0) {
                        MLog.m580d("本次启动账号:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has("header") && jSONObject.has("header") && (jSONObject2 = jSONObject.getJSONObject("header")) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has("sdk_version")) {
                    jSONObject3.put("sdk_version", jSONObject2.getString("sdk_version"));
                }
                if (jSONObject2.has("device_id")) {
                    jSONObject3.put("device_id", jSONObject2.getString("device_id"));
                }
                if (jSONObject2.has("device_model")) {
                    jSONObject3.put("device_model", jSONObject2.getString("device_model"));
                }
                if (jSONObject2.has("version_code")) {
                    jSONObject3.put(LitePalParser.NODE_VERSION, jSONObject2.getInt("version_code"));
                }
                if (jSONObject2.has("appkey")) {
                    jSONObject3.put("appkey", jSONObject2.getString("appkey"));
                }
                if (jSONObject2.has("channel")) {
                    jSONObject3.put("channel", jSONObject2.getString("channel"));
                }
                if (jSONObject3.length() > 0) {
                    MLog.m580d("本次启动基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.m570e(th);
        }
    }

    /* renamed from: f */
    private void m957f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                long j = jSONObject.getLong("ts");
                m974b(f3553a);
                m965d();
                String[] m1415a = C1520c.m1415a(f3553a);
                if (m1415a == null || TextUtils.isEmpty(m1415a[0]) || TextUtils.isEmpty(m1415a[1])) {
                    return;
                }
                C1663u.m899a().m897a(f3553a, j);
                String m860c = C1669y.m870a().m860c(f3553a);
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + m860c);
                boolean m889b = C1663u.m899a().m889b(f3553a, j, false);
                C1520c.m1413b(f3553a);
                C1663u.m899a().m896a(f3553a, j, true);
                if (!m889b) {
                    return;
                }
                C1663u.m899a().m890b(f3553a, j);
            }
        } catch (Throwable th) {
            if (!MLog.DEBUG) {
                return;
            }
            MLog.m572e(" Excepthon  in  onProfileSignOff", th);
        }
    }

    /* renamed from: f */
    private void m956f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            if (!jSONObject.getJSONObject("header").has(C1615d.f3303aB)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has("analytics") && (optJSONObject = jSONObject.optJSONObject("analytics")) != null && optJSONObject.length() > 0 && optJSONObject.has(C1615d.f3348n)) {
                    C1636i.m1056a(f3553a).m1044a(true, false);
                }
                C1636i.m1056a(f3553a).m1043b();
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has("analytics")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("analytics");
                if (jSONObject2.has(C1615d.f3348n) && (optJSONObject2 = jSONObject2.getJSONArray(C1615d.f3348n).optJSONObject(0)) != null) {
                    String optString = optJSONObject2.optString("id");
                    if (!TextUtils.isEmpty(optString)) {
                        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                        C1636i.m1056a(f3553a).m1042b(optString);
                    }
                }
            }
            C1636i.m1056a(f3553a).m1043b();
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
            UMWorkDispatch.sendEvent(f3553a, C1650a.f3595l, CoreProtocol.getInstance(f3553a), null);
        } catch (Exception unused) {
        }
    }

    /* renamed from: g */
    private void m954g(Object obj) {
        try {
            m974b(f3553a);
            m965d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String string = jSONObject.getString(C1615d.f3287M);
                String string2 = jSONObject.getString("uid");
                long j = jSONObject.getLong("ts");
                String[] m1415a = C1520c.m1415a(f3553a);
                if (m1415a != null && string.equals(m1415a[0]) && string2.equals(m1415a[1])) {
                    return;
                }
                C1663u.m899a().m897a(f3553a, j);
                String m860c = C1669y.m870a().m860c(f3553a);
                boolean m889b = C1663u.m899a().m889b(f3553a, j, false);
                C1520c.m1414a(f3553a, string, string2);
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + m860c);
                C1663u.m899a().m896a(f3553a, j, true);
                if (!m889b) {
                    return;
                }
                C1663u.m899a().m890b(f3553a, j);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: g */
    private void m953g(JSONObject jSONObject) {
        Context context;
        JSONObject optJSONObject;
        try {
            if (jSONObject.getJSONObject("header").has(C1615d.f3303aB)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (!jSONObject.has("analytics")) {
                    return;
                }
                if (!jSONObject.getJSONObject("analytics").has(C1615d.f3348n)) {
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                    return;
                }
                C1636i.m1056a(f3553a).m1026i();
                C1636i.m1056a(f3553a).m1027h();
                C1636i.m1056a(f3553a).m1036b(true, false);
                context = f3553a;
            } else {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has("analytics") && (optJSONObject = jSONObject.optJSONObject("analytics")) != null && optJSONObject.length() > 0) {
                    if (optJSONObject.has(C1615d.f3348n)) {
                        C1636i.m1056a(f3553a).m1036b(true, false);
                    }
                    if (optJSONObject.has("ekv") || optJSONObject.has(C1615d.f3294T)) {
                        C1636i.m1056a(f3553a).m1027h();
                    }
                    if (optJSONObject.has("error")) {
                        C1636i.m1056a(f3553a).m1026i();
                    }
                }
                context = f3553a;
            }
            C1636i.m1056a(context).m1057a();
        } catch (Exception unused) {
        }
    }

    /* renamed from: h */
    public static void m952h() {
        try {
            Class<?> cls = Class.forName(f3562x);
            f3563y = cls;
            Method declaredMethod = cls.getDeclaredMethod("setPuidAndProvider", String.class, String.class);
            if (declaredMethod == null) {
                return;
            }
            f3564z = declaredMethod;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: h */
    private void m951h(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has("__ii")) {
                return;
            }
            String optString = jSONObject.optString("__ii");
            jSONObject.remove("__ii");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            C1636i.m1056a(f3553a).m1053a(optString, obj.toString(), 2);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: i */
    private void m950i() {
        JSONObject m975b = m975b(UMEnvelopeBuild.maxDataSpace(f3553a));
        if (m975b == null || m975b.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) m975b.opt("header");
        JSONObject jSONObject2 = (JSONObject) m975b.opt("content");
        if (f3553a == null || jSONObject == null || jSONObject2 == null) {
            return;
        }
        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
        JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(f3553a, jSONObject, jSONObject2);
        if (buildEnvelopeWithExtHeader == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        if (UMConfigure.isDebugLog()) {
            m959e(buildEnvelopeWithExtHeader);
        }
        m973b((Object) buildEnvelopeWithExtHeader);
    }

    /* renamed from: j */
    private void m949j() {
        JSONObject buildEnvelopeWithExtHeader;
        JSONObject m987a = m987a(UMEnvelopeBuild.maxDataSpace(f3553a));
        if (m987a == null || m987a.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) m987a.opt("header");
        JSONObject jSONObject2 = (JSONObject) m987a.opt("content");
        Context context = f3553a;
        if (context == null || jSONObject == null || jSONObject2 == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        if (UMConfigure.isDebugLog()) {
            m963d(buildEnvelopeWithExtHeader);
        }
        m984a((Object) buildEnvelopeWithExtHeader);
    }

    /* renamed from: k */
    private JSONObject m948k() {
        JSONObject m947l = m947l();
        if (m947l != null) {
            try {
                m947l.put("st", "1");
            } catch (Throwable unused) {
            }
        }
        return m947l;
    }

    /* renamed from: l */
    private JSONObject m947l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put("wrapper_version", AnalyticsConfig.mWrapperVersion);
                jSONObject.put("wrapper_type", AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(f3553a);
            jSONObject.put(C1615d.f3343i, verticalType);
            String str = "9.4.4";
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(f3553a);
                if (!TextUtils.isEmpty(gameSdkVersion)) {
                    str = gameSdkVersion;
                }
            }
            jSONObject.put("sdk_version", str);
            String MD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(f3553a));
            if (!TextUtils.isEmpty(MD5)) {
                jSONObject.put("secret", MD5);
            }
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f3553a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3553a);
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(f3553a, "ekv_bl_ver", "");
            if (!TextUtils.isEmpty(imprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(C1615d.f3325ap, "");
                } else {
                    jSONObject.put(C1615d.f3325ap, imprintProperty2);
                }
            }
            String imprintProperty3 = UMEnvelopeBuild.imprintProperty(f3553a, "ekv_wl_ver", "");
            if (!TextUtils.isEmpty(imprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(C1615d.f3326aq, "");
                } else {
                    jSONObject.put(C1615d.f3326aq, imprintProperty3);
                }
            }
            jSONObject.put(C1615d.f3317ah, "1.0.0");
            if (m940s()) {
                jSONObject.put(C1615d.f3319aj, "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(f3555m, 0L).commit();
                }
            }
            jSONObject.put(C1615d.f3346l, m946m());
            jSONObject.put(C1615d.f3347m, m945n());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(imprintProperty)) {
                        jSONObject.put(C1615d.f3346l, sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(C1615d.f3347m, sharedPreferences.getString("vers_date", format));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfig.getAppVersionName(f3553a)).putString("pre_date", format).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: m */
    private String m946m() {
        String str = null;
        try {
            str = UMEnvelopeBuild.imprintProperty(f3553a, "pr_ve", null);
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(this.f3567d)) {
                    return this.f3567d;
                }
                if (this.f3566c == null) {
                    this.f3566c = PreferenceWrapper.getDefault(f3553a);
                }
                String string = this.f3566c.getString("pre_version", "");
                String appVersionName = DeviceConfig.getAppVersionName(f3553a);
                if (TextUtils.isEmpty(string)) {
                    this.f3566c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
                    str = "0";
                } else {
                    String string2 = this.f3566c.getString("cur_version", "");
                    if (!appVersionName.equals(string2)) {
                        this.f3566c.edit().putString("pre_version", string2).putString("cur_version", appVersionName).commit();
                        str = string2;
                    } else {
                        str = string;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.f3567d = str;
        return str;
    }

    /* renamed from: n */
    private String m945n() {
        String str = null;
        try {
            str = UMEnvelopeBuild.imprintProperty(f3553a, "ud_da", null);
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(this.f3568e)) {
                    return this.f3568e;
                }
                if (this.f3566c == null) {
                    this.f3566c = PreferenceWrapper.getDefault(f3553a);
                }
                String string = this.f3566c.getString("pre_date", "");
                if (TextUtils.isEmpty(string)) {
                    string = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    this.f3566c.edit().putString("pre_date", string).commit();
                } else {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (!string.equals(format)) {
                        this.f3566c.edit().putString("pre_date", format).commit();
                        str = format;
                    }
                }
                str = string;
            }
        } catch (Throwable unused) {
        }
        this.f3568e = str;
        return str;
    }

    /* renamed from: o */
    private void m944o() {
        try {
            this.f3572i = 0;
            this.f3573j = 0;
            this.f3574k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(f3553a).edit().putLong(f3557o, System.currentTimeMillis()).putInt(f3558p, 0).commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: p */
    private boolean m943p() {
        try {
            if (!TextUtils.isEmpty(C1663u.m899a().m892b())) {
                m974b(f3553a);
            }
            if (this.f3570g.length() <= 0) {
                return false;
            }
            for (int i = 0; i < this.f3570g.length(); i++) {
                JSONObject optJSONObject = this.f3570g.optJSONObject(i);
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    String optString = optJSONObject.optString("__i");
                    if (TextUtils.isEmpty(optString) || "-1".equals(optString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* renamed from: q */
    private void m942q() {
        if (this.f3570g.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.f3570g.length(); i++) {
                try {
                    JSONObject jSONObject = this.f3570g.getJSONObject(i);
                    if (jSONObject != null && jSONObject.length() > 0) {
                        String optString = jSONObject.optString("__i");
                        String str = "-1";
                        if (TextUtils.isEmpty(optString) || str.equals(optString)) {
                            String m892b = C1663u.m899a().m892b();
                            if (!TextUtils.isEmpty(m892b)) {
                                str = m892b;
                            }
                            jSONObject.put("__i", str);
                        }
                    }
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
            this.f3570g = jSONArray;
        }
    }

    /* renamed from: r */
    private void m941r() {
        SharedPreferences sharedPreferences;
        try {
            if (!m940s() || f3553a == null || (sharedPreferences = PreferenceWrapper.getDefault(f3553a)) == null || sharedPreferences.getLong("first_activate_time", 0L) != 0) {
                return;
            }
            sharedPreferences.edit().putLong("first_activate_time", System.currentTimeMillis()).commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: s */
    private boolean m940s() {
        SharedPreferences sharedPreferences;
        try {
            if (f3553a == null || (sharedPreferences = PreferenceWrapper.getDefault(f3553a)) == null) {
                return false;
            }
            return sharedPreferences.getLong(f3555m, -1L) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00cb A[Catch: all -> 0x00d4, TryCatch #0 {all -> 0x00d4, blocks: (B:14:0x009f, B:17:0x00a8, B:18:0x00ad, B:20:0x00ba, B:22:0x00c0, B:23:0x00c5, B:25:0x00cb, B:26:0x00d0, B:29:0x00b1), top: B:13:0x009f }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject m987a(long j) {
        if (TextUtils.isEmpty(C1669y.m870a().m859d(f3553a))) {
            return null;
        }
        JSONObject m970b = m970b(false);
        int m922a = C1656r.m923a().m922a(f3553a);
        if (m970b.length() > 0) {
            if (m970b.length() == 1) {
                if (m970b.optJSONObject(C1615d.f3286L) != null && m922a != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(m970b.optString("userlevel")) && m922a != 3) {
                    return null;
                }
            } else if (m970b.length() == 2 && m970b.optJSONObject(C1615d.f3286L) != null && !TextUtils.isEmpty(m970b.optString("userlevel")) && m922a != 3) {
                return null;
            }
            String optString = m970b.optString(C1615d.f3348n);
            String optString2 = m970b.optString(C1615d.f3294T);
            String optString3 = m970b.optString("ekv");
            if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && m979a(m970b)) {
                return null;
            }
        } else if (m922a != 3) {
            return null;
        }
        JSONObject m947l = m947l();
        if (m947l != null) {
            m967c(m947l);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (m922a != 3) {
                if (m970b.length() > 0) {
                }
                if (m947l != null && m947l.length() > 0) {
                    jSONObject.put("header", m947l);
                }
                if (jSONObject2.length() > 0) {
                    jSONObject.put("content", jSONObject2);
                }
                return m978a(jSONObject, j);
            }
            m970b = new JSONObject();
            jSONObject2.put("analytics", m970b);
            if (m947l != null) {
                jSONObject.put("header", m947l);
            }
            if (jSONObject2.length() > 0) {
            }
            return m978a(jSONObject, j);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    /* renamed from: a */
    public void m988a() {
        if (f3553a != null) {
            synchronized (this.f3578w) {
                if (this.f3576u) {
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> network is now available, rebuild instant session data packet.");
                    UMWorkDispatch.sendEvent(f3553a, C1650a.f3595l, CoreProtocol.getInstance(f3553a), null);
                }
            }
            synchronized (this.f3578w) {
                if (this.f3577v) {
                    UMWorkDispatch.sendEvent(f3553a, C1650a.f3596m, CoreProtocol.getInstance(f3553a), null);
                }
            }
        }
    }

    /* renamed from: a */
    public void m984a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() <= 0) {
                    return;
                }
                if (jSONObject.has("exception") && 101 == jSONObject.getInt("exception")) {
                    return;
                }
                m953g(jSONObject);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public void m983a(Object obj, int i) {
        UMProcessDBHelper uMProcessDBHelper;
        String subProcessName;
        JSONArray jSONArray;
        if (!AnalyticsConfig.enable) {
            return;
        }
        try {
            switch (i) {
                case 4097:
                    if (!UMUtils.isMainProgress(f3553a)) {
                        uMProcessDBHelper = UMProcessDBHelper.getInstance(f3553a);
                        subProcessName = UMFrUtils.getSubProcessName(f3553a);
                        jSONArray = new JSONArray();
                        uMProcessDBHelper.insertEventsInSubProcess(subProcessName, jSONArray.put(obj));
                        return;
                    }
                    if (obj != null) {
                        m960e(obj);
                    }
                    if ("-1".equals(((JSONObject) obj).optString("__i"))) {
                        return;
                    }
                    m977a(false);
                    return;
                case 4098:
                    if (obj != null) {
                        m960e(obj);
                    }
                    if ("-1".equals(((JSONObject) obj).optString("__i"))) {
                        return;
                    }
                    m977a(false);
                    return;
                case 4099:
                    C1666v.m879a(f3553a);
                    return;
                case C1650a.f3587d /* 4100 */:
                    C1642l.m1007c(f3553a);
                    return;
                case C1650a.f3588e /* 4101 */:
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                    m982a((Object) null, true);
                    m954g(obj);
                    return;
                case C1650a.f3589f /* 4102 */:
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                    m982a((Object) null, true);
                    m957f(obj);
                    return;
                case C1650a.f3590g /* 4103 */:
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                    C1663u.m899a().m895a(f3553a, obj);
                    synchronized (this.f3578w) {
                        this.f3577v = true;
                    }
                    return;
                case C1650a.f3591h /* 4104 */:
                    C1663u.m899a().m885c(f3553a, obj);
                    return;
                case C1650a.f3592i /* 4105 */:
                    m965d();
                    return;
                case C1650a.f3593j /* 4106 */:
                    m951h(obj);
                    return;
                default:
                    switch (i) {
                        case 4352:
                            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                            C1663u.m899a().m888b(f3553a, obj);
                            synchronized (this.f3578w) {
                                this.f3576u = true;
                            }
                            return;
                        case C1650a.f3595l /* 4353 */:
                            m982a(obj, true);
                            return;
                        case C1650a.f3596m /* 4354 */:
                            m969c();
                            return;
                        case C1650a.f3597n /* 4355 */:
                            if (UMUtils.isMainProgress(f3553a)) {
                                if (obj == null) {
                                    return;
                                }
                                m960e(obj);
                                m965d();
                                return;
                            }
                            uMProcessDBHelper = UMProcessDBHelper.getInstance(f3553a);
                            subProcessName = UMFrUtils.getSubProcessName(f3553a);
                            jSONArray = new JSONArray();
                            uMProcessDBHelper.insertEventsInSubProcess(subProcessName, jSONArray.put(obj));
                            return;
                        case C1650a.f3598o /* 4356 */:
                            if (obj == null || f3563y == null || f3564z == null) {
                                return;
                            }
                            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_CHANGE_NOTIFY");
                            String str = "";
                            String str2 = "";
                            if (!(obj instanceof JSONObject)) {
                                return;
                            }
                            JSONObject jSONObject = (JSONObject) obj;
                            if (jSONObject.has("uid") && jSONObject.has(C1615d.f3287M)) {
                                str = jSONObject.getString(C1615d.f3287M);
                                str2 = jSONObject.getString("uid");
                            }
                            m981a(str2, str);
                            return;
                        default:
                            switch (i) {
                                case C1650a.f3601r /* 8195 */:
                                    C1517b.m1468a().m1451a(obj);
                                    return;
                                case C1650a.f3602s /* 8196 */:
                                    C1517b.m1468a().m1417m();
                                    return;
                                case C1650a.f3603t /* 8197 */:
                                    C1517b.m1468a().m1419k();
                                    return;
                                default:
                                    switch (i) {
                                        case C1650a.f3604u /* 8199 */:
                                        case C1650a.f3605v /* 8200 */:
                                            C1517b.m1468a().m1442b(obj);
                                            return;
                                        case C1650a.f3606w /* 8201 */:
                                            C1517b.m1468a().m1442b((Object) null);
                                            return;
                                        default:
                                            switch (i) {
                                                case C1650a.f3607x /* 8208 */:
                                                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                    Context context = f3553a;
                                                    UMWorkDispatch.sendEvent(context, C1650a.f3608y, CoreProtocol.getInstance(context), null);
                                                    Context context2 = f3553a;
                                                    UMWorkDispatch.sendEvent(context2, C1650a.f3596m, CoreProtocol.getInstance(context2), null);
                                                    return;
                                                case C1650a.f3608y /* 8209 */:
                                                    m982a(obj, false);
                                                    return;
                                                case C1650a.f3609z /* 8210 */:
                                                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                    if (!UMUtils.isMainProgress(f3553a) || (this.f3565b.m933c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                        return;
                                                    }
                                                    m977a(true);
                                                    return;
                                                default:
                                                    switch (i) {
                                                        case C1650a.f3581C /* 8213 */:
                                                            if (!FieldManager.allow(C1847b.f4254E)) {
                                                                return;
                                                            }
                                                            if (DeviceConfig.getGlobleActivity(f3553a) != null) {
                                                                C1663u.m891b(f3553a);
                                                            }
                                                            Context context3 = f3553a;
                                                            UMWorkDispatch.sendEventEx(context3, C1650a.f3581C, CoreProtocol.getInstance(context3), null, 5000L);
                                                            return;
                                                        case C1650a.f3582D /* 8214 */:
                                                            if (obj == null || !(obj instanceof JSONObject)) {
                                                                return;
                                                            }
                                                            String optString = ((JSONObject) obj).optString(AnalyticsConfig.RTD_START_TIME);
                                                            String optString2 = ((JSONObject) obj).optString(AnalyticsConfig.RTD_PERIOD);
                                                            String optString3 = ((JSONObject) obj).optString("debugkey");
                                                            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                                                                return;
                                                            }
                                                            C1687b.m815a(f3553a, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_START_TIME, optString);
                                                            C1687b.m815a(f3553a, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_PERIOD, optString2);
                                                            C1687b.m815a(f3553a, AnalyticsConfig.RTD_SP_FILE, "debugkey", optString3);
                                                            return;
                                                        case C1650a.f3583E /* 8215 */:
                                                            C1687b.m817a(f3553a, AnalyticsConfig.RTD_SP_FILE);
                                                            return;
                                                        default:
                                                            return;
                                                    }
                                            }
                                    }
                            }
                    }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m982a(Object obj, boolean z) {
        if (z) {
            if (!m962d(true)) {
                return;
            }
        } else if (!UMEnvelopeBuild.isOnline(f3553a) || !m962d(true)) {
            return;
        }
        m950i();
    }

    /* renamed from: a */
    public void m977a(boolean z) {
        String str;
        if (m966c(z)) {
            if (this.f3565b.m933c() instanceof ReportPolicy.ReportQuasiRealtime) {
                if (z) {
                    if (!UMEnvelopeBuild.isOnline(f3553a)) {
                        return;
                    }
                    str = "--->>> send session start in policy ReportQuasiRealtime.";
                } else if (!UMEnvelopeBuild.isReadyBuild(f3553a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    return;
                } else {
                    str = "--->>> send normal data in policy ReportQuasiRealtime.";
                }
            } else if (!UMEnvelopeBuild.isReadyBuild(f3553a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                return;
            } else {
                str = "--->>> constructMessage()";
            }
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, str);
            m949j();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00c4 A[Catch: all -> 0x00cd, TryCatch #0 {all -> 0x00cd, blocks: (B:34:0x00a1, B:35:0x00a6, B:37:0x00b3, B:39:0x00b9, B:40:0x00be, B:42:0x00c4, B:43:0x00c9, B:46:0x00aa), top: B:32:0x009f }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject m975b(long j) {
        if (TextUtils.isEmpty(C1669y.m870a().m859d(UMGlobalContext.getAppContext(f3553a)))) {
            return null;
        }
        JSONObject m1037b = C1636i.m1056a(UMGlobalContext.getAppContext(f3553a)).m1037b(false);
        String[] m1415a = C1520c.m1415a(f3553a);
        if (m1415a != null && !TextUtils.isEmpty(m1415a[0]) && !TextUtils.isEmpty(m1415a[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(C1615d.f3287M, m1415a[0]);
                jSONObject.put(C1615d.f3288N, m1415a[1]);
                if (jSONObject.length() > 0) {
                    m1037b.put(C1615d.f3286L, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int m922a = C1656r.m923a().m922a(f3553a);
        if (m1037b.length() == 1 && m1037b.optJSONObject(C1615d.f3286L) != null && m922a != 3) {
            return null;
        }
        C1656r.m923a().m918b(m1037b, f3553a);
        if (m1037b.length() <= 0 && m922a != 3) {
            return null;
        }
        JSONObject m948k = m948k();
        if (m948k != null) {
            m972b(m948k);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            if (m922a != 3) {
                if (m1037b.length() > 0) {
                }
                if (m948k != null && m948k.length() > 0) {
                    jSONObject2.put("header", m948k);
                }
                if (jSONObject3.length() > 0) {
                    jSONObject2.put("content", jSONObject3);
                }
                return m971b(jSONObject2, j);
            }
            m1037b = new JSONObject();
            jSONObject3.put("analytics", m1037b);
            if (m948k != null) {
                jSONObject2.put("header", m948k);
            }
            if (jSONObject3.length() > 0) {
            }
            return m971b(jSONObject2, j);
        } catch (Throwable unused2) {
            return jSONObject2;
        }
    }

    /* renamed from: b */
    public JSONObject m970b(boolean z) {
        JSONArray jSONArray;
        int i;
        JSONArray jSONArray2;
        JSONObject jSONObject = null;
        try {
            jSONObject = C1636i.m1056a(f3553a).m1046a(z);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            } else {
                try {
                    if (jSONObject.has(C1615d.f3348n)) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray(C1615d.f3348n);
                        JSONArray jSONArray4 = new JSONArray();
                        int i2 = 0;
                        while (i2 < jSONArray3.length()) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i2);
                            JSONArray optJSONArray = jSONObject2.optJSONArray("pages");
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray(C1615d.f3355u);
                            if (optJSONArray == null && optJSONArray2 != null) {
                                jSONObject2.put("pages", optJSONArray2);
                                jSONObject2.remove(C1615d.f3355u);
                            }
                            if (optJSONArray != null && optJSONArray2 != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    arrayList.add((JSONObject) optJSONArray.get(i3));
                                }
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    arrayList.add((JSONObject) optJSONArray2.get(i4));
                                }
                                JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                                jSONArraySortUtil.setCompareKey(C1615d.f3358x);
                                Collections.sort(arrayList, jSONArraySortUtil);
                                JSONArray jSONArray5 = new JSONArray();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    jSONArray5.put((JSONObject) it.next());
                                }
                                jSONObject2.put("pages", jSONArray5);
                                jSONObject2.remove(C1615d.f3355u);
                            }
                            if (jSONObject2.has("pages")) {
                                JSONArray optJSONArray3 = jSONObject2.optJSONArray("pages");
                                int i5 = 0;
                                while (i5 < optJSONArray3.length()) {
                                    JSONObject jSONObject3 = optJSONArray3.getJSONObject(i5);
                                    if (jSONObject3.has(C1615d.f3358x)) {
                                        jSONArray2 = jSONArray3;
                                        jSONObject3.put("ts", jSONObject3.getLong(C1615d.f3358x));
                                        jSONObject3.remove(C1615d.f3358x);
                                    } else {
                                        jSONArray2 = jSONArray3;
                                    }
                                    i5++;
                                    jSONArray3 = jSONArray2;
                                }
                                jSONArray = jSONArray3;
                                jSONObject2.put("pages", optJSONArray3);
                                i = optJSONArray3.length();
                            } else {
                                jSONArray = jSONArray3;
                                i = 0;
                            }
                            jSONObject2.put(C1615d.f3360z, i);
                            jSONArray4.put(jSONObject2);
                            i2++;
                            jSONArray3 = jSONArray;
                        }
                        jSONObject.put(C1615d.f3348n, jSONArray4);
                    }
                } catch (Exception e) {
                    MLog.m574e("merge pages error");
                    e.printStackTrace();
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3553a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("userlevel", string);
                }
            }
            String[] m1415a = C1520c.m1415a(f3553a);
            if (m1415a != null && !TextUtils.isEmpty(m1415a[0]) && !TextUtils.isEmpty(m1415a[1])) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(C1615d.f3287M, m1415a[0]);
                jSONObject4.put(C1615d.f3288N, m1415a[1]);
                if (jSONObject4.length() > 0) {
                    jSONObject.put(C1615d.f3286L, jSONObject4);
                }
            }
            if (ABTest.getService(f3553a).isInTest()) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(ABTest.getService(f3553a).getTestName(), ABTest.getService(f3553a).getGroupInfo());
                jSONObject.put(C1615d.f3285K, jSONObject5);
            }
            C1656r.m923a().m921a(jSONObject, f3553a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* renamed from: b */
    public void m976b() {
    }

    /* renamed from: b */
    public void m974b(Context context) {
        try {
            C1636i.m1056a(context).m1032d();
            m942q();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public void m973b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() <= 0) {
                    return;
                }
                if (jSONObject.has("exception") && 101 == jSONObject.getInt("exception")) {
                    return;
                }
                m956f(jSONObject);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: c */
    public void m969c() {
        m974b(f3553a);
        m965d();
        m977a(true);
    }

    /* renamed from: c */
    public void m968c(Object obj) {
        m974b(f3553a);
        m965d();
        if (m962d(false)) {
            m949j();
        }
    }

    /* renamed from: d */
    public void m965d() {
        try {
            if (this.f3570g.length() > 0) {
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>>*** flushMemoryData: 事件落库。");
                C1636i.m1056a(f3553a).m1049a(this.f3570g);
                this.f3570g = new JSONArray();
            }
            PreferenceWrapper.getDefault(f3553a).edit().putLong("thtstart", this.f3574k).putInt("gkvc", this.f3572i).putInt("ekvc", this.f3573j).commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    public void m964d(Object obj) {
        m941r();
        m946m();
        m945n();
        m977a(true);
    }

    /* renamed from: e */
    public void m961e() {
        if (m962d(false)) {
            m949j();
        }
    }

    /* renamed from: f */
    public long m958f() {
        SharedPreferences sharedPreferences;
        try {
            if (f3553a == null || (sharedPreferences = PreferenceWrapper.getDefault(f3553a)) == null) {
                return 0L;
            }
            long j = sharedPreferences.getLong("first_activate_time", 0L);
            if (j == 0) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    sharedPreferences.edit().putLong("first_activate_time", currentTimeMillis).commit();
                    return currentTimeMillis;
                } catch (Throwable unused) {
                }
            }
            return j;
        } catch (Throwable unused2) {
            return 0L;
        }
    }
}
