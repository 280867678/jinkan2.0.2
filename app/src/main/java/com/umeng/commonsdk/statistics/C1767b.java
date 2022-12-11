package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.analytics.pro.C1572bc;
import com.umeng.analytics.pro.C1615d;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.C1724a;
import com.umeng.commonsdk.internal.C1726c;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.stateless.C1753a;
import com.umeng.commonsdk.stateless.C1754b;
import com.umeng.commonsdk.stateless.C1759d;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.C1786e;
import com.umeng.commonsdk.statistics.idtracking.C1791i;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.utils.C1847b;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.umeng.commonsdk.statistics.b */
/* loaded from: classes4.dex */
public class C1767b {

    /* renamed from: a */
    public static String f4020a = null;

    /* renamed from: b */
    public static String f4021b = "";

    /* renamed from: c */
    public static final String f4022c = "EnvelopeManager";

    /* renamed from: d */
    public static final String f4023d = "debug.umeng.umTaskId";

    /* renamed from: e */
    public static final String f4024e = "debug.umeng.umCaseId";

    /* renamed from: f */
    public static final String f4025f = "empty";

    /* renamed from: g */
    public static String f4026g = "";

    /* renamed from: h */
    public static String f4027h = "";

    /* renamed from: i */
    public static String f4028i;

    /* renamed from: k */
    public static boolean f4029k;

    /* renamed from: j */
    public int f4030j = 0;

    /* renamed from: a */
    private int m593a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String m607b = C1759d.m607b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&&");
        sb.append(str2);
        sb.append("_");
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(m607b);
        sb.append(".log");
        byte[] binary = envelope.toBinary();
        return (str.startsWith(C1543ak.f2967aD) || str.startsWith(C1543ak.f2966aC) || str.startsWith("a") || str.startsWith(C1543ak.f2971aH)) ? UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary) : C1759d.m615a(context, C1753a.f3990f, sb.toString(), binary);
    }

    /* renamed from: a */
    public static long m594a(Context context) {
        long j = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        boolean z = ULog.DEBUG;
        return j;
    }

    /* renamed from: a */
    private Envelope m589a(Context context, byte[] bArr) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int i = -1;
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e) {
            UMCrashManager.reportCrash(context, e);
        }
        return (i != 0 && (i == 1 || f4029k)) ? Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr) : Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    /* renamed from: a */
    private JSONObject m595a(int i, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    /* renamed from: a */
    public static JSONObject m592a(Context context, String str, boolean z) {
        SharedPreferences sharedPreferences;
        JSONObject jSONObject;
        int[] resolutionArray;
        String str2 = "2G/3G";
        try {
            sharedPreferences = PreferenceWrapper.getDefault(context);
            if (!TextUtils.isEmpty(f4028i)) {
                try {
                    jSONObject = new JSONObject(f4028i);
                } catch (Exception unused) {
                    jSONObject = null;
                }
            } else {
                UMUtils.saveSDKComponent();
                jSONObject = new JSONObject();
                jSONObject.put(C1543ak.f3045p, DeviceConfig.getAppMD5Signature(context));
                jSONObject.put(C1543ak.f3046q, DeviceConfig.getAppSHA1Key(context));
                jSONObject.put(C1543ak.f3047r, DeviceConfig.getAppHashKey(context));
                jSONObject.put("app_version", DeviceConfig.getAppVersionName(context));
                jSONObject.put("version_code", Integer.parseInt(DeviceConfig.getAppVersionCode(context)));
                jSONObject.put("idmd5", DeviceConfig.getDeviceIdUmengMD5(context));
                jSONObject.put(C1543ak.f3052w, DeviceConfig.getCPU());
                String mccmnc = DeviceConfig.getMCCMNC(context);
                if (!TextUtils.isEmpty(mccmnc)) {
                    jSONObject.put(C1543ak.f2938B, mccmnc);
                    f4021b = mccmnc;
                } else {
                    jSONObject.put(C1543ak.f2938B, "");
                }
                String subOSName = DeviceConfig.getSubOSName(context);
                if (!TextUtils.isEmpty(subOSName)) {
                    jSONObject.put(C1543ak.f2947K, subOSName);
                }
                String subOSVersion = DeviceConfig.getSubOSVersion(context);
                if (!TextUtils.isEmpty(subOSVersion)) {
                    jSONObject.put(C1543ak.f2948L, subOSVersion);
                }
                String deviceType = DeviceConfig.getDeviceType(context);
                if (!TextUtils.isEmpty(deviceType)) {
                    jSONObject.put(C1543ak.f2998ai, deviceType);
                }
                jSONObject.put(C1543ak.f3044o, DeviceConfig.getPackageName(context));
                jSONObject.put(C1543ak.f3050u, "Android");
                jSONObject.put("device_id", DeviceConfig.getDeviceId(context));
                jSONObject.put("device_model", Build.MODEL);
                jSONObject.put(C1543ak.f2941E, Build.BOARD);
                jSONObject.put(C1543ak.f2942F, Build.BRAND);
                jSONObject.put(C1543ak.f2943G, Build.TIME);
                jSONObject.put(C1543ak.f2944H, Build.MANUFACTURER);
                jSONObject.put(C1543ak.f2945I, Build.ID);
                jSONObject.put(C1543ak.f2946J, Build.DEVICE);
                jSONObject.put(C1543ak.f3054y, Build.VERSION.RELEASE);
                jSONObject.put(C1543ak.f3053x, "Android");
                if (DeviceConfig.getResolutionArray(context) != null) {
                    jSONObject.put(C1543ak.f3055z, resolutionArray[1] + "*" + resolutionArray[0]);
                }
                jSONObject.put(C1543ak.f2937A, DeviceConfig.getMac(context));
                jSONObject.put(C1543ak.f2949M, DeviceConfig.getTimeZone(context));
                String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                jSONObject.put(C1543ak.f2951O, localeInfo[0]);
                jSONObject.put("language", localeInfo[1]);
                jSONObject.put(C1543ak.f2952P, DeviceConfig.getNetworkOperatorName(context));
                jSONObject.put(C1543ak.f3048s, DeviceConfig.getAppName(context));
                String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    str2 = NetworkUtil.NETWORK_TYPE_WIFI;
                } else if (!str2.equals(networkAccessMode[0])) {
                    str2 = "unknow";
                }
                jSONObject.put(C1543ak.f2953Q, str2);
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject.put(C1543ak.f2954R, networkAccessMode[1]);
                }
                if (DeviceConfig.isHarmony(context)) {
                    jSONObject.put("others_OS", "harmony");
                } else {
                    jSONObject.put("others_OS", "Android");
                }
                if (FieldManager.allow(C1847b.f4257H)) {
                    jSONObject.put(C1543ak.f2955S, DeviceConfig.getIPAddress(context));
                }
                jSONObject.put(C1543ak.f2956T, DeviceConfig.getNetworkType(context));
                jSONObject.put(C1543ak.f3016b, "9.4.4");
                jSONObject.put(C1543ak.f3032c, SdkVersion.SDK_TYPE);
                jSONObject.put(C1543ak.f3033d, "1");
                if (!TextUtils.isEmpty(f4020a)) {
                    jSONObject.put(C1543ak.f3034e, f4020a);
                }
                jSONObject.put(C1543ak.f2999aj, Build.VERSION.SDK_INT);
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject.put(C1543ak.f2995af, UMUtils.VALUE_REC_VERSION_NAME);
                }
                try {
                    String uUIDForZid = UMUtils.getUUIDForZid(context);
                    if (TextUtils.isEmpty(uUIDForZid)) {
                        UMUtils.setUUIDForZid(context);
                        uUIDForZid = UMUtils.getUUIDForZid(context);
                    }
                    jSONObject.put("session_id", uUIDForZid);
                } catch (Throwable unused2) {
                }
                f4028i = jSONObject.toString();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        if (jSONObject == null) {
            return null;
        }
        try {
            jSONObject.put(C1543ak.f3000ak, UMUtils.getOaidRequiredTime(context));
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put(C1543ak.f2957U, sharedPreferences.getInt(StatTracer.KEY_CLIENT_REQUEST_SUCCESS, 0));
            jSONObject.put(C1543ak.f2958V, sharedPreferences.getInt(C1543ak.f2958V, 0));
            jSONObject.put(C1543ak.f2959W, sharedPreferences.getInt(StatTracer.KEY_CLIENT_REQUEST_LATENCY, 0));
            String zid = UMUtils.getZid(context);
            if (!TextUtils.isEmpty(zid)) {
                jSONObject.put(C1543ak.f3001al, zid);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                jSONObject.put(C1543ak.f3002am, UMUtils.VALUE_ASMS_VERSION);
            }
        } catch (Exception unused4) {
        }
        jSONObject.put("channel", UMUtils.getChannel(context));
        jSONObject.put("appkey", UMUtils.getAppkey(context));
        try {
            String deviceToken = UMUtils.getDeviceToken(context);
            if (!TextUtils.isEmpty(deviceToken)) {
                jSONObject.put(C1543ak.f2963a, deviceToken);
            }
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
        }
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(context, C1543ak.f3036g, null);
            if (!TextUtils.isEmpty(imprintProperty)) {
                jSONObject.put(C1543ak.f3036g, imprintProperty);
            }
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        try {
            jSONObject.put("wrapper_type", C1766a.f4017a);
            jSONObject.put("wrapper_version", C1766a.f4018b);
        } catch (Exception unused5) {
        }
        try {
            int targetSdkVersion = UMUtils.getTargetSdkVersion(context);
            boolean checkPermission = UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE");
            jSONObject.put(C1543ak.f2984aU, targetSdkVersion);
            jSONObject.put(C1543ak.f2985aV, checkPermission ? "yes" : "no");
        } catch (Throwable unused6) {
        }
        try {
            if (m586b()) {
                jSONObject.put("umTaskId", f4026g);
                jSONObject.put("umCaseId", f4027h);
            }
        } catch (Throwable unused7) {
        }
        if ((C1543ak.f2971aH.equals(str) || "a".equals(str)) && z) {
            try {
                int[] m585b = m585b(context);
                jSONObject.put(C1543ak.f3031bo, String.valueOf(m585b[0]) + String.valueOf(m585b[1]) + String.valueOf(m585b[2]));
            } catch (Throwable unused8) {
            }
        }
        try {
            Map<String, String> moduleTags = TagHelper.getModuleTags();
            if (moduleTags != null && moduleTags.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, String> entry : moduleTags.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put(C1543ak.f3005ap, jSONObject2);
            }
        } catch (Throwable unused9) {
        }
        try {
            String realTimeDebugKey = AnalyticsConfig.getRealTimeDebugKey();
            if (!TextUtils.isEmpty(realTimeDebugKey)) {
                jSONObject.put(C1543ak.f3030bn, realTimeDebugKey);
            }
        } catch (Throwable unused10) {
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(C1543ak.f2989aZ, C1724a.f3903e);
            if (!TextUtils.isEmpty(UMUtils.VALUE_ANALYTICS_VERSION)) {
                jSONObject3.put(C1543ak.f3017ba, UMUtils.VALUE_ANALYTICS_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_GAME_VERSION)) {
                jSONObject3.put(C1543ak.f3018bb, UMUtils.VALUE_GAME_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_PUSH_VERSION)) {
                jSONObject3.put(C1543ak.f3019bc, UMUtils.VALUE_PUSH_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_SHARE_VERSION)) {
                jSONObject3.put(C1543ak.f3020bd, UMUtils.VALUE_SHARE_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_APM_VERSION)) {
                jSONObject3.put(C1543ak.f3021be, UMUtils.VALUE_APM_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_VERIFY_VERSION)) {
                jSONObject3.put(C1543ak.f3022bf, UMUtils.VALUE_VERIFY_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_SMS_VERSION)) {
                jSONObject3.put(C1543ak.f3023bg, UMUtils.VALUE_SMS_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                jSONObject3.put(C1543ak.f3024bh, UMUtils.VALUE_REC_VERSION_NAME);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_VISUAL_VERSION)) {
                jSONObject3.put(C1543ak.f3025bi, UMUtils.VALUE_VISUAL_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                jSONObject3.put(C1543ak.f3026bj, UMUtils.VALUE_ASMS_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_LINK_VERSION)) {
                jSONObject3.put(C1543ak.f3027bk, UMUtils.VALUE_LINK_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_ABTEST_VERSION)) {
                jSONObject3.put(C1543ak.f3028bl, UMUtils.VALUE_ABTEST_VERSION);
            }
            jSONObject.put(C1543ak.f2988aY, jSONObject3);
        } catch (Throwable unused11) {
        }
        try {
            String apmFlag = UMUtils.getApmFlag();
            if (!TextUtils.isEmpty(apmFlag)) {
                jSONObject.put(C1543ak.f3029bm, apmFlag);
            }
        } catch (Throwable unused12) {
        }
        byte[] m487a = ImprintHandler.getImprintService(context).m487a();
        if (m487a != null && m487a.length > 0) {
            try {
                jSONObject.put(C1543ak.f2960X, Base64.encodeToString(m487a, 0));
            } catch (JSONException e3) {
                UMCrashManager.reportCrash(context, e3);
            }
        }
        if (jSONObject.length() > 0) {
            return new JSONObject().put("header", jSONObject);
        }
        return null;
    }

    /* renamed from: a */
    private JSONObject m588a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt("header") != null && (jSONObject.opt("header") instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt("header");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && (next instanceof String)) {
                    String str = next;
                    if (jSONObject2.opt(str) != null) {
                        try {
                            jSONObject3.put(str, jSONObject2.opt(str));
                            if (str.equals(C1615d.f3343i) && (jSONObject2.opt(str) instanceof Integer)) {
                                this.f4030j = ((Integer) jSONObject2.opt(str)).intValue();
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m596a() {
        if (f4028i != null) {
            f4028i = null;
            C1786e.m455a();
        }
    }

    /* renamed from: a */
    public static void m587a(boolean z) {
        f4029k = z;
    }

    /* renamed from: b */
    public static boolean m586b() {
        f4026g = UMUtils.getSystemProperty(f4023d, "");
        f4027h = UMUtils.getSystemProperty(f4024e, "");
        return (!TextUtils.isEmpty(f4026g) && !f4025f.equals(f4026g)) && (!TextUtils.isEmpty(f4027h) && !f4025f.equals(f4027h));
    }

    /* renamed from: b */
    public static int[] m585b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(C1726c.f3928a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(C1726c.f3929b, 0);
                iArr[1] = sharedPreferences.getInt(C1726c.f3930c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    /* renamed from: a */
    public JSONObject m591a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Envelope envelope;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("header", new JSONObject());
            try {
                if (m586b()) {
                    jSONObject.put("umTaskId", f4026g);
                    jSONObject.put("umCaseId", f4027h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                jSONObject3 = m588a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String)) {
                        String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused2) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt(C1791i.f4116a, sharedPreferences.getInt(C1791i.f4116a, 1) + 1).commit();
                }
                return m595a(113, jSONObject3);
            }
            String str3 = null;
            if (jSONObject3 != null) {
                Envelope m589a = m589a(context, jSONObject3.toString().getBytes());
                if (m589a == null) {
                    return m595a(111, jSONObject3);
                }
                envelope = m589a;
            } else {
                envelope = null;
            }
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return m595a(114, jSONObject3);
            }
            if (jSONObject3 != null) {
                str3 = jSONObject3.optJSONObject("header").optString("app_version");
            }
            int m593a = m593a(context, envelope, "z==1.2.0", str3, str);
            if (m593a != 0) {
                return m595a(m593a, jSONObject3);
            }
            if (ULog.DEBUG) {
                int length = jSONObject3.toString().getBytes().length;
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return m595a(110, new JSONObject());
        }
    }

    /* renamed from: a */
    public JSONObject m590a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        String str4;
        boolean z;
        String str5;
        Envelope envelope;
        JSONObject optJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            int length = jSONObject.toString().getBytes().length;
            int length2 = jSONObject2.toString().getBytes().length;
        }
        JSONObject jSONObject4 = null;
        if (context == null || jSONObject2 == null) {
            return m595a(110, (JSONObject) null);
        }
        try {
            if (!jSONObject2.has("analytics") || (optJSONObject = jSONObject2.optJSONObject("analytics")) == null || !optJSONObject.has(C1615d.f3348n)) {
                str4 = str2;
                z = false;
            } else {
                str4 = str2;
                z = true;
            }
            JSONObject m592a = m592a(context, str4, z);
            if (m592a != null && jSONObject != null) {
                m592a = m588a(m592a, jSONObject);
            }
            JSONObject jSONObject5 = m592a;
            if (jSONObject5 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String)) {
                        String str6 = next;
                        if (jSONObject2.opt(str6) != null) {
                            try {
                                jSONObject5.put(str6, jSONObject2.opt(str6));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            String str7 = "1.0.0";
            if (TextUtils.isEmpty(str2)) {
                str4 = C1543ak.f2970aG;
            }
            if (!TextUtils.isEmpty(str3)) {
                str7 = str3;
            }
            if (jSONObject5 != null) {
                String str8 = str4 + "==" + str7 + "&=";
                if (TextUtils.isEmpty(str8)) {
                    return m595a(101, jSONObject5);
                }
                if (str8.endsWith("&=")) {
                    str8 = str8.substring(0, str8.length() - 2);
                }
                str5 = str8;
            } else {
                str5 = null;
            }
            if (jSONObject5 != null) {
                try {
                    C1786e m453a = C1786e.m453a(context);
                    if (m453a != null) {
                        m453a.m450b();
                        String encodeToString = Base64.encodeToString(new C1572bc().m1216a(m453a.m448c()), 0);
                        if (!TextUtils.isEmpty(encodeToString)) {
                            JSONObject jSONObject6 = jSONObject5.getJSONObject("header");
                            jSONObject6.put(C1543ak.f2961Y, encodeToString);
                            jSONObject5.put("header", jSONObject6);
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            if (jSONObject5 != null && DataHelper.largeThanMaxSize(jSONObject5.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt(C1791i.f4116a, sharedPreferences.getInt(C1791i.f4116a, 1) + 1).commit();
                }
                return m595a(113, jSONObject5);
            }
            if (jSONObject5 != null) {
                Envelope m589a = m589a(context, jSONObject5.toString().getBytes());
                if (m589a == null) {
                    return m595a(111, jSONObject5);
                }
                envelope = m589a;
            } else {
                envelope = null;
            }
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return m595a(114, jSONObject5);
            }
            int m593a = m593a(context, envelope, str5, jSONObject5 != null ? jSONObject5.optJSONObject("header").optString("app_version") : null, str);
            if (m593a != 0) {
                return m595a(m593a, jSONObject5);
            }
            if (ULog.DEBUG) {
                int length3 = jSONObject5.toString().getBytes().length;
            }
            if (!str5.startsWith(C1543ak.f2967aD) && !str5.startsWith(C1543ak.f2966aC) && !str5.startsWith(C1543ak.f2971aH) && !str5.startsWith("a") && !C1754b.m645a()) {
                new C1754b(context);
                C1754b.m641b();
            }
            return jSONObject5;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            if (jSONObject != null) {
                try {
                    jSONObject3 = new JSONObject();
                } catch (Exception e) {
                    e = e;
                }
                try {
                    jSONObject3.put("header", jSONObject);
                } catch (JSONException unused3) {
                } catch (Exception e2) {
                    e = e2;
                    jSONObject4 = jSONObject3;
                    UMCrashManager.reportCrash(context, e);
                    return m595a(110, jSONObject4);
                }
                jSONObject4 = jSONObject3;
            }
            if (jSONObject4 == null) {
                jSONObject4 = new JSONObject();
            }
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (next2 != null && (next2 instanceof String)) {
                    String str9 = next2;
                    if (jSONObject2.opt(str9) != null) {
                        try {
                            jSONObject4.put(str9, jSONObject2.opt(str9));
                        } catch (Exception unused4) {
                        }
                    }
                }
            }
            return m595a(110, jSONObject4);
        }
    }
}
