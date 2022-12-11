package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C1517b;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.C1616e;
import com.umeng.analytics.pro.C1636i;
import com.umeng.analytics.pro.C1648o;
import com.umeng.analytics.pro.C1669y;
import com.umeng.analytics.process.UMProcessDBDatasSender;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.C1847b;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.pro.u */
/* loaded from: classes4.dex */
public class C1663u implements C1669y.AbstractC1670a {

    /* renamed from: a */
    public static final String f3638a = "session_start_time";

    /* renamed from: b */
    public static final String f3639b = "session_end_time";

    /* renamed from: c */
    public static final String f3640c = "session_id";

    /* renamed from: d */
    public static final String f3641d = "pre_session_id";

    /* renamed from: e */
    public static final String f3642e = "a_start_time";

    /* renamed from: f */
    public static final String f3643f = "a_end_time";

    /* renamed from: g */
    public static final String f3644g = "fg_count";

    /* renamed from: h */
    public static String f3645h = null;

    /* renamed from: i */
    public static Context f3646i = null;

    /* renamed from: j */
    public static boolean f3647j = false;

    /* renamed from: k */
    public static long f3648k = 0;

    /* renamed from: l */
    public static boolean f3649l = true;

    /* renamed from: m */
    public static long f3650m;

    /* renamed from: com.umeng.analytics.pro.u$a */
    /* loaded from: classes4.dex */
    public static class C1665a {

        /* renamed from: a */
        public static final C1663u f3651a = new C1663u();
    }

    public C1663u() {
        C1669y.m870a().m864a(this);
    }

    /* renamed from: a */
    public static long m898a(Context context) {
        try {
            return PreferenceWrapper.getDefault(context).getLong(f3644g, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* renamed from: a */
    public static C1663u m899a() {
        return C1665a.f3651a;
    }

    /* renamed from: a */
    private void m894a(Context context, String str, long j, long j2, long j3) {
        if (TextUtils.isEmpty(f3645h)) {
            f3645h = C1669y.m870a().m867a(f3646i);
        }
        if (TextUtils.isEmpty(str) || str.equals(f3645h)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C1616e.C1626d.C1627a.f3410g, j2);
            jSONObject.put(C1616e.C1626d.C1627a.f3411h, j3);
            JSONObject m1445b = C1517b.m1468a().m1445b();
            if (m1445b != null && m1445b.length() > 0) {
                jSONObject.put("__sp", m1445b);
            }
            JSONObject m1439c = C1517b.m1468a().m1439c();
            if (m1439c != null && m1439c.length() > 0) {
                jSONObject.put("__pp", m1439c);
            }
            C1636i.m1056a(context).m1050a(f3645h, jSONObject, C1636i.EnumC1638a.END);
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__e", j);
            C1636i.m1056a(context).m1050a(str, jSONObject2, C1636i.EnumC1638a.BEGIN);
            if (FieldManager.allow(C1847b.f4254E)) {
                f3650m = j3;
                m884d(context);
                UMWorkDispatch.sendEventEx(f3646i, C1648o.C1650a.f3581C, CoreProtocol.getInstance(f3646i), null, 0L);
            }
        } catch (Exception unused2) {
        }
        f3645h = str;
    }

    /* renamed from: a */
    private void m893a(String str, long j) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3646i);
        if (sharedPreferences == null) {
            return;
        }
        long j2 = sharedPreferences.getLong(f3639b, 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j);
            jSONObject.put(C1616e.C1626d.C1627a.f3410g, j2);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(C1615d.f3277C, location[0]);
                jSONObject2.put(C1615d.f3278D, location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(C1616e.C1626d.C1627a.f3408e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Method method = cls.getMethod("getUidRxBytes", Integer.TYPE);
            Method method2 = cls.getMethod("getUidTxBytes", Integer.TYPE);
            int i = f3646i.getApplicationInfo().uid;
            if (i == -1) {
                return;
            }
            long longValue = ((Long) method.invoke(null, Integer.valueOf(i))).longValue();
            long longValue2 = ((Long) method2.invoke(null, Integer.valueOf(i))).longValue();
            if (longValue > 0 && longValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(C1615d.f3282H, longValue);
                jSONObject3.put(C1615d.f3281G, longValue2);
                jSONObject.put(C1616e.C1626d.C1627a.f3407d, jSONObject3);
            }
            C1636i.m1056a(f3646i).m1050a(str, jSONObject, C1636i.EnumC1638a.NEWSESSION);
            C1666v.m879a(f3646i);
            C1642l.m1007c(f3646i);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public static void m891b(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3646i);
        if (sharedPreferences != null) {
            long j = sharedPreferences.getLong(f3644g, 0L);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                return;
            }
            edit.putLong(f3644g, j + 1);
            edit.commit();
        }
    }

    /* renamed from: d */
    private void m884d(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putLong(f3644g, 0L);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    private String m883e(Context context) {
        if (f3646i == null && context != null) {
            f3646i = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        String m859d = C1669y.m870a().m859d(f3646i);
        try {
            m882f(context);
            C1648o.m985a(f3646i).m964d((Object) null);
        } catch (Throwable unused) {
        }
        return m859d;
    }

    /* renamed from: f */
    private void m882f(Context context) {
        C1648o.m985a(context).m974b(context);
        C1648o.m985a(context).m965d();
    }

    /* renamed from: a */
    public String m896a(Context context, long j, boolean z) {
        String m862b = C1669y.m870a().m862b(context);
        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + m862b);
        if (TextUtils.isEmpty(m862b)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j);
            JSONObject m1445b = C1517b.m1468a().m1445b();
            if (m1445b != null && m1445b.length() > 0) {
                jSONObject.put("__sp", m1445b);
            }
            JSONObject m1439c = C1517b.m1468a().m1439c();
            if (m1439c != null && m1439c.length() > 0) {
                jSONObject.put("__pp", m1439c);
            }
            C1636i.m1056a(context).m1050a(m862b, jSONObject, C1636i.EnumC1638a.INSTANTSESSIONBEGIN);
            C1648o.m985a(context).m982a(jSONObject, z);
        } catch (Throwable unused) {
        }
        return m862b;
    }

    /* renamed from: a */
    public void m897a(Context context, long j) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3646i);
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putLong(f3638a, j);
        edit.commit();
    }

    /* renamed from: a */
    public void m895a(Context context, Object obj) {
        SharedPreferences.Editor edit;
        try {
            if (f3646i == null && context != null) {
                f3646i = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3646i);
            if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                return;
            }
            String string = sharedPreferences.getString(C1615d.f3335az, "");
            String appVersionName = UMUtils.getAppVersionName(f3646i);
            if (TextUtils.isEmpty(string)) {
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(C1615d.f3335az, appVersionName);
                edit.commit();
            } else if (!string.equals(appVersionName)) {
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                int i = sharedPreferences.getInt("versioncode", 0);
                String string2 = sharedPreferences.getString("pre_date", "");
                String string3 = sharedPreferences.getString("pre_version", "");
                String string4 = sharedPreferences.getString(C1615d.f3335az, "");
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(C1615d.f3335az, appVersionName);
                edit.putString("vers_date", string2);
                edit.putString("vers_pre_version", string3);
                edit.putString("cur_version", string4);
                edit.putInt("vers_code", i);
                edit.putString("vers_name", string);
                edit.commit();
                if (f3649l) {
                    f3649l = false;
                }
                if (!f3647j) {
                    return;
                }
                f3647j = false;
                m889b(f3646i, longValue, true);
                m890b(f3646i, longValue);
                return;
            }
            if (f3647j) {
                f3647j = false;
                if (f3649l) {
                    f3649l = false;
                }
                f3645h = m883e(context);
                MLog.m580d("创建新会话: " + f3645h);
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + f3645h);
                return;
            }
            f3645h = sharedPreferences.getString("session_id", null);
            edit.putLong(f3642e, longValue);
            edit.putLong(f3643f, 0L);
            edit.commit();
            MLog.m580d("延续上一个会话: " + f3645h);
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "Extend current session: " + f3645h);
            if (f3649l) {
                f3649l = false;
                if (FieldManager.allow(C1847b.f4254E)) {
                    UMWorkDispatch.sendEventEx(f3646i, C1648o.C1650a.f3581C, CoreProtocol.getInstance(f3646i), null, 0L);
                }
            }
            m882f(context);
            C1648o.m985a(f3646i).m977a(false);
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.C1669y.AbstractC1670a
    /* renamed from: a */
    public void mo852a(String str, long j, long j2, long j3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m893a(str, j);
    }

    @Override // com.umeng.analytics.pro.C1669y.AbstractC1670a
    /* renamed from: a */
    public void mo851a(String str, String str2, long j, long j2, long j3) {
        m894a(f3646i, str2, j, j2, j3);
        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = f3646i;
            UMWorkDispatch.sendEvent(context, 36945, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* renamed from: b */
    public String m892b() {
        return f3645h;
    }

    /* renamed from: b */
    public void m890b(Context context, long j) {
        if (PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            C1648o.m985a(f3646i).m968c((Object) null);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public void m888b(Context context, Object obj) {
        try {
            if (f3646i == null) {
                f3646i = UMGlobalContext.getAppContext(context);
            }
            long currentTimeMillis = obj == null ? System.currentTimeMillis() : ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3646i);
            if (sharedPreferences == null) {
                return;
            }
            f3648k = sharedPreferences.getLong(f3643f, 0L);
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime: " + f3648k);
            String string = sharedPreferences.getString(C1615d.f3335az, "");
            String appVersionName = UMUtils.getAppVersionName(f3646i);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                return;
            }
            if (TextUtils.isEmpty(string) || string.equals(appVersionName)) {
                if (!C1669y.m870a().m858e(f3646i)) {
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
                    f3647j = false;
                    return;
                }
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                f3647j = true;
                edit.putLong(f3638a, currentTimeMillis);
                edit.commit();
                m896a(f3646i, currentTimeMillis, false);
                return;
            }
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
            edit.putLong(f3638a, currentTimeMillis);
            edit.commit();
            C1648o.m985a(f3646i).m982a((Object) null, true);
            String m860c = C1669y.m870a().m860c(f3646i);
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + m860c);
            f3647j = true;
            m896a(f3646i, currentTimeMillis, true);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public boolean m889b(Context context, long j, boolean z) {
        SharedPreferences sharedPreferences;
        String m867a;
        long j2;
        boolean z2 = false;
        try {
            sharedPreferences = PreferenceWrapper.getDefault(context);
        } catch (Throwable unused) {
        }
        if (sharedPreferences == null || (m867a = C1669y.m870a().m867a(f3646i)) == null) {
            return false;
        }
        long j3 = sharedPreferences.getLong(f3642e, 0L);
        long j4 = sharedPreferences.getLong(f3643f, 0L);
        if (j3 > 0 && j4 == 0) {
            z2 = true;
            if (z) {
                if (f3648k == 0) {
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = " + j);
                    j2 = j;
                } else {
                    j2 = f3648k;
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = " + f3648k);
                }
                m885c(f3646i, Long.valueOf(j2));
            } else {
                m885c(f3646i, Long.valueOf(j));
                j2 = j;
            }
            JSONObject jSONObject = new JSONObject();
            if (z) {
                jSONObject.put(C1616e.C1626d.C1627a.f3410g, j2);
            } else {
                jSONObject.put(C1616e.C1626d.C1627a.f3410g, j);
            }
            JSONObject m1445b = C1517b.m1468a().m1445b();
            if (m1445b != null && m1445b.length() > 0) {
                jSONObject.put("__sp", m1445b);
            }
            JSONObject m1439c = C1517b.m1468a().m1439c();
            if (m1439c != null && m1439c.length() > 0) {
                jSONObject.put("__pp", m1439c);
            }
            if (FieldManager.allow(C1847b.f4254E)) {
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>>*** foregroundCount = " + f3650m);
                jSONObject.put(C1616e.C1626d.C1627a.f3411h, f3650m);
                f3650m = 0L;
            } else {
                jSONObject.put(C1616e.C1626d.C1627a.f3411h, 0L);
            }
            C1636i.m1056a(context).m1050a(m867a, jSONObject, C1636i.EnumC1638a.END);
            C1648o.m985a(f3646i).m961e();
        }
        return z2;
    }

    /* renamed from: c */
    public String m887c() {
        return m886c(f3646i);
    }

    /* renamed from: c */
    public String m886c(Context context) {
        try {
            if (f3645h == null) {
                return PreferenceWrapper.getDefault(context).getString("session_id", null);
            }
        } catch (Throwable unused) {
        }
        return f3645h;
    }

    /* renamed from: c */
    public void m885c(Context context, Object obj) {
        try {
            if (f3646i == null && context != null) {
                f3646i = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong(f3642e, 0L) == 0) {
                MLog.m574e("onPause called before onResume");
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + longValue);
            edit.putLong(f3643f, longValue);
            edit.putLong(f3639b, longValue);
            edit.commit();
        } catch (Throwable unused) {
        }
    }
}
