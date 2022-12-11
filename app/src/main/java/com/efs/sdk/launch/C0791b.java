package com.efs.sdk.launch;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.stub.StubApp;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.efs.sdk.launch.b */
/* loaded from: classes3.dex */
public final class C0791b {

    /* renamed from: a */
    public static long f357a;

    /* renamed from: b */
    public static long f358b;

    /* renamed from: c */
    public static long f359c;

    /* renamed from: d */
    public static long f360d;

    /* renamed from: e */
    public static long f361e;

    /* renamed from: f */
    public static boolean f362f;

    /* renamed from: g */
    public static boolean f363g;

    /* renamed from: h */
    public static boolean f364h;

    /* renamed from: i */
    public static long f365i;

    /* renamed from: j */
    public static long f366j;

    /* renamed from: k */
    public static int f367k;

    /* renamed from: l */
    public static List<EfsJSONLog> f368l = new ArrayList();

    /* renamed from: m */
    public static Map<String, Long[]> f369m = new HashMap();

    /* renamed from: a */
    public static void m3995a(Activity activity, String str, boolean z) {
        long currentTimeMillis;
        Context origApplicationContext;
        String name;
        int i;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        if (TextUtils.equals(str, LaunchManager.PAGE_ON_CREATE)) {
            if (!z) {
                return;
            }
            boolean z2 = LaunchManager.isDebug;
            f360d = System.currentTimeMillis();
        } else if (TextUtils.equals(str, LaunchManager.PAGE_ON_RE_START)) {
            if (!z || f367k != 0) {
                return;
            }
            boolean z3 = LaunchManager.isDebug;
            f361e = System.currentTimeMillis();
            f363g = true;
        } else if (TextUtils.equals(str, LaunchManager.PAGE_ON_START)) {
            if (!z) {
                return;
            }
            boolean z4 = LaunchManager.isDebug;
            f367k++;
            f364h = true;
        } else if (!TextUtils.equals(str, LaunchManager.PAGE_ON_RESUME)) {
            if (!TextUtils.equals(str, LaunchManager.PAGE_ON_STOP) || !z) {
                return;
            }
            boolean z5 = LaunchManager.isDebug;
            f367k--;
        } else if (z) {
        } else {
            boolean z6 = LaunchManager.isDebug;
            if (f362f) {
                f362f = false;
                long currentTimeMillis2 = System.currentTimeMillis();
                long j10 = currentTimeMillis2 - f359c;
                if (LaunchManager.isDebug) {
                    "loadTime is ".concat(String.valueOf(j10));
                }
                long j11 = currentTimeMillis2 - f357a;
                if (LaunchManager.isDebug) {
                    "======>>>>>> coldTime is ".concat(String.valueOf(j11));
                }
                int i2 = !C0792c.m3984d(StubApp.getOrigApplicationContext(activity.getApplicationContext())) ? 1 : 0;
                if (LaunchManager.isDebug) {
                    "type is ".concat(String.valueOf(i2));
                }
                m3994a(StubApp.getOrigApplicationContext(activity.getApplicationContext()), i2, activity.getClass().getName(), j11, f357a, f358b, f365i, f359c, f366j, currentTimeMillis2, j10, 0L, 0L, f369m);
            } else if (f367k == 1) {
                if (f363g) {
                    f363g = false;
                    j9 = System.currentTimeMillis() - f361e;
                    if (LaunchManager.isDebug) {
                        "======>>>>>> hotTime is ".concat(String.valueOf(j9));
                    }
                    origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
                    name = activity.getClass().getName();
                    i = 2;
                    j = 0;
                    j2 = 0;
                    j3 = 0;
                    j4 = 0;
                    j5 = 0;
                    j6 = 0;
                    j7 = 0;
                    j8 = 0;
                    currentTimeMillis = 0;
                } else if (f364h) {
                    currentTimeMillis = System.currentTimeMillis() - f360d;
                    if (LaunchManager.isDebug) {
                        "======>>>>>> warmTime is ".concat(String.valueOf(currentTimeMillis));
                    }
                    origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
                    name = activity.getClass().getName();
                    i = 3;
                    j = 0;
                    j2 = 0;
                    j3 = 0;
                    j4 = 0;
                    j5 = 0;
                    j6 = 0;
                    j7 = 0;
                    j8 = 0;
                    j9 = 0;
                }
                m3994a(origApplicationContext, i, name, j, j2, j3, j4, j5, j6, j7, j8, j9, currentTimeMillis, f369m);
            }
            f364h = false;
        }
    }

    /* renamed from: a */
    public static void m3994a(Context context, int i, String str, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, Map<String, Long[]> map) {
        String str2;
        String str3;
        int i2;
        List<EfsJSONLog> list;
        Long valueOf;
        if (LaunchManager.isInit()) {
            LaunchConfigManager launchConfigManager = LaunchManager.getLaunchConfigManager();
            if ((launchConfigManager == null || !launchConfigManager.enableTracer()) && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                boolean z = LaunchManager.isDebug;
                return;
            }
            EfsJSONLog efsJSONLog = new EfsJSONLog(Constants.LOG_TYPE_STARTPERF);
            efsJSONLog.put("w_type", Integer.valueOf(i));
            efsJSONLog.put("w_url", str);
            efsJSONLog.put("l_version", "0.0.3.umeng");
            if (i == 0 || i == 1) {
                efsJSONLog.put("wl_avgv", Long.valueOf(j));
                efsJSONLog.put("wd_init", Long.valueOf(j2));
                efsJSONLog.put("wd_inittm", Long.valueOf(j3));
                efsJSONLog.put("wl_init", Long.valueOf(j4));
                efsJSONLog.put("wd_build", Long.valueOf(j3));
                efsJSONLog.put("wd_buildtm", Long.valueOf(j5));
                efsJSONLog.put("wl_build", Long.valueOf(j6));
                efsJSONLog.put("wd_page", Long.valueOf(j5));
                efsJSONLog.put("wd_pagetm", Long.valueOf(j7));
                efsJSONLog.put("wl_page", Long.valueOf(j8));
                if (map != null && !map.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, Long[]> entry : map.entrySet()) {
                        String key = entry.getKey();
                        Long[] value = entry.getValue();
                        if (key != null && value != null) {
                            try {
                                JSONArray jSONArray = new JSONArray();
                                jSONArray.put(value[0]);
                                jSONArray.put(value[1]);
                                jSONObject.put(key, jSONArray);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    efsJSONLog.put("userExtra", jSONObject);
                }
            } else {
                if (i == 2) {
                    valueOf = Long.valueOf(j9);
                } else if (i == 3) {
                    valueOf = Long.valueOf(j10);
                }
                efsJSONLog.put("wl_avgv", valueOf);
            }
            String m3988a = C0792c.m3988a(context);
            if (LaunchManager.isDebug) {
                "umid is ".concat(String.valueOf(m3988a));
            }
            if (m3988a != null && !TextUtils.isEmpty(m3988a)) {
                if (LaunchManager.isDebug) {
                    efsJSONLog.generateString();
                }
                EfsReporter reporter = LaunchManager.getReporter();
                if (reporter == null) {
                    return;
                }
                reporter.send(efsJSONLog);
                return;
            }
            List<EfsJSONLog> list2 = f368l;
            if (list2 == null || list2.size() >= 3) {
                boolean z2 = LaunchManager.isDebug;
                return;
            }
            f368l.add(efsJSONLog);
            if (!LaunchManager.isDebug) {
                return;
            }
            efsJSONLog.generateString();
        } else if (i == 0) {
            boolean z3 = LaunchManager.isDebug;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("w_type", i);
                jSONObject2.put("w_url", str);
                jSONObject2.put("l_version", "0.0.3.umeng");
                jSONObject2.put("wl_avgv", j);
                jSONObject2.put("wd_init", j2);
                jSONObject2.put("wd_inittm", j3);
                jSONObject2.put("wl_init", j4);
                jSONObject2.put("wd_build", j3);
                jSONObject2.put("wd_buildtm", j5);
                jSONObject2.put("wl_build", j6);
                jSONObject2.put("wd_page", j5);
                jSONObject2.put("wd_pagetm", j7);
                jSONObject2.put("wl_page", j8);
                if (map != null && !map.isEmpty()) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (Map.Entry<String, Long[]> entry2 : map.entrySet()) {
                        String key2 = entry2.getKey();
                        Long[] value2 = entry2.getValue();
                        if (key2 != null && value2 != null) {
                            try {
                                JSONArray jSONArray2 = new JSONArray();
                                jSONArray2.put(value2[0]);
                                jSONArray2.put(value2[1]);
                                jSONObject3.put(key2, jSONArray2);
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                    jSONObject2.put("userExtra", jSONObject3);
                }
                C0792c.m3987a(context, jSONObject2.toString());
                if (!LaunchManager.isDebug) {
                    return;
                }
                jSONObject2.toString();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            if (LaunchManager.isDebug) {
                str2 = "wl_page";
                str3 = "wd_pagetm";
                "no init, cache launch, type is ".concat(String.valueOf(i));
            } else {
                str2 = "wl_page";
                str3 = "wd_pagetm";
            }
            EfsJSONLog efsJSONLog2 = new EfsJSONLog(Constants.LOG_TYPE_STARTPERF);
            efsJSONLog2.put("w_type", Integer.valueOf(i));
            efsJSONLog2.put("w_url", str);
            efsJSONLog2.put("l_version", "0.0.3.umeng");
            if (i == 1) {
                efsJSONLog2.put("wl_avgv", Long.valueOf(j));
                efsJSONLog2.put("wd_init", Long.valueOf(j2));
                efsJSONLog2.put("wd_inittm", Long.valueOf(j3));
                efsJSONLog2.put("wl_init", Long.valueOf(j4));
                efsJSONLog2.put("wd_build", Long.valueOf(j3));
                efsJSONLog2.put("wd_buildtm", Long.valueOf(j5));
                efsJSONLog2.put("wl_build", Long.valueOf(j6));
                efsJSONLog2.put("wd_page", Long.valueOf(j5));
                efsJSONLog2.put(str3, Long.valueOf(j7));
                efsJSONLog2.put(str2, Long.valueOf(j8));
                if (map != null && !map.isEmpty()) {
                    JSONObject jSONObject4 = new JSONObject();
                    for (Map.Entry<String, Long[]> entry3 : map.entrySet()) {
                        String key3 = entry3.getKey();
                        Long[] value3 = entry3.getValue();
                        if (key3 != null && value3 != null) {
                            try {
                                JSONArray jSONArray3 = new JSONArray();
                                try {
                                    jSONArray3.put(value3[0]);
                                    try {
                                        jSONArray3.put(value3[1]);
                                        jSONObject4.put(key3, jSONArray3);
                                    } catch (Throwable unused3) {
                                    }
                                } catch (Throwable unused4) {
                                }
                            } catch (Throwable unused5) {
                            }
                        }
                    }
                    efsJSONLog2.put("userExtra", jSONObject4);
                }
            } else if (i != 2) {
                i2 = 3;
                if (i == 3) {
                    efsJSONLog2.put("wl_avgv", Long.valueOf(j10));
                }
                list = f368l;
                if (list != null || list.size() >= i2) {
                    boolean z4 = LaunchManager.isDebug;
                }
                f368l.add(efsJSONLog2);
                if (!LaunchManager.isDebug) {
                    return;
                }
                efsJSONLog2.generateString();
                return;
            } else {
                efsJSONLog2.put("wl_avgv", Long.valueOf(j9));
            }
            i2 = 3;
            list = f368l;
            if (list != null) {
            }
            boolean z42 = LaunchManager.isDebug;
        }
    }

    /* renamed from: a */
    public static void m3993a(Context context, String str) {
        boolean z = LaunchManager.isDebug;
        if (str == null || TextUtils.isEmpty(str)) {
            str = C0792c.m3988a(context);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(UMCrash.KEY_HEADER_UMID, str);
        if (LaunchManager.getReporter() != null) {
            LaunchManager.getReporter().addPublicParams(hashMap);
        }
        String m3986b = C0792c.m3986b(context);
        if (m3986b != null && !TextUtils.isEmpty(m3986b)) {
            try {
                JSONObject jSONObject = new JSONObject(m3986b);
                jSONObject.put(UMCrash.KEY_HEADER_UMID, str);
                if (m3990a(jSONObject)) {
                    C0792c.m3985c(context);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        List<EfsJSONLog> list = f368l;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (EfsJSONLog efsJSONLog : f368l) {
            if (efsJSONLog != null) {
                if (LaunchManager.isDebug) {
                    efsJSONLog.generateString();
                }
                EfsReporter reporter = LaunchManager.getReporter();
                if (reporter != null) {
                    reporter.send(efsJSONLog);
                }
            }
        }
        f368l.clear();
        f368l = null;
    }

    /* renamed from: a */
    public static void m3992a(String str, long j) {
        Map<String, Long[]> map = f369m;
        if (map == null || map.containsKey(str) || f369m.size() >= 10) {
            boolean z = LaunchManager.isDebug;
            return;
        }
        Long[] lArr = new Long[2];
        lArr[0] = Long.valueOf(j);
        f369m.put(str, lArr);
    }

    /* renamed from: a */
    public static void m3991a(String str, boolean z) {
        if (!TextUtils.equals(str, LaunchManager.APP_CONSTRUCT)) {
            if (!TextUtils.equals(str, LaunchManager.APP_ATTACH_BASE_CONTEXT)) {
                if (!TextUtils.equals(str, LaunchManager.APP_ON_CREATE) || z) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                f359c = currentTimeMillis;
                f366j = currentTimeMillis - f358b;
                boolean z2 = LaunchManager.isDebug;
            } else if (z) {
                f357a = System.currentTimeMillis();
                f362f = true;
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                f358b = currentTimeMillis2;
                f365i = currentTimeMillis2 - f357a;
                if (!LaunchManager.isDebug) {
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m3990a(JSONObject jSONObject) {
        try {
            EfsJSONLog efsJSONLog = new EfsJSONLog(Constants.LOG_TYPE_STARTPERF);
            efsJSONLog.put("w_type", jSONObject.opt("w_type"));
            efsJSONLog.put("w_url", jSONObject.opt("w_url"));
            efsJSONLog.put("l_version", jSONObject.opt("l_version"));
            efsJSONLog.put("wl_avgv", jSONObject.opt("wl_avgv"));
            efsJSONLog.put("wd_init", jSONObject.opt("wd_init"));
            efsJSONLog.put("wd_inittm", jSONObject.opt("wd_inittm"));
            efsJSONLog.put("wl_init", jSONObject.opt("wl_init"));
            efsJSONLog.put("wd_build", jSONObject.opt("wd_build"));
            efsJSONLog.put("wd_buildtm", jSONObject.opt("wd_buildtm"));
            efsJSONLog.put("wl_build", jSONObject.opt("wl_build"));
            efsJSONLog.put("wd_page", jSONObject.opt("wd_page"));
            efsJSONLog.put("wd_pagetm", jSONObject.opt("wd_pagetm"));
            efsJSONLog.put("wl_page", jSONObject.opt("wl_page"));
            efsJSONLog.put("userExtra", jSONObject.opt("userExtra"));
            if (LaunchManager.isDebug) {
                efsJSONLog.generateString();
            }
            EfsReporter reporter = LaunchManager.getReporter();
            if (reporter == null) {
                return false;
            }
            reporter.send(efsJSONLog);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static void m3989b(String str, long j) {
        Map<String, Long[]> map = f369m;
        if (map == null || !map.containsKey(str)) {
            boolean z = LaunchManager.isDebug;
            return;
        }
        Long[] lArr = f369m.get(str);
        lArr[1] = Long.valueOf(j);
        f369m.put(str, lArr);
    }
}
