package com.umeng.commonsdk.framework;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.analytics.pro.C1551am;
import com.umeng.analytics.pro.C1553ao;
import com.umeng.analytics.pro.C1636i;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.internal.C1724a;
import com.umeng.commonsdk.internal.C1725b;
import com.umeng.commonsdk.statistics.C1767b;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class UMEnvelopeBuild {
    public static boolean transmissionSendFlag;

    public static JSONObject add2CacheTable(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        if (jSONObject == null || jSONObject2 == null) {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> [有状态]构建信封传入 header 或 body 字段为空，直接返回");
            return null;
        }
        C1636i m1056a = C1636i.m1056a(context);
        long currentTimeMillis = System.currentTimeMillis();
        UUID randomUUID = UUID.randomUUID();
        ContentValues contentValues = new ContentValues();
        contentValues.put(C1553ao.f3116e, str2);
        contentValues.put(C1553ao.f3117f, m1056a.m1034c(jSONObject.toString()));
        contentValues.put(C1553ao.f3118g, m1056a.m1034c(jSONObject2.toString()));
        contentValues.put(C1553ao.f3119h, String.valueOf(currentTimeMillis));
        contentValues.put(C1553ao.f3120i, randomUUID.toString());
        contentValues.put(C1553ao.f3121j, str);
        contentValues.put(C1553ao.f3122k, str3);
        C1551am.m1296a(context).m1293a(C1553ao.f3114c, contentValues);
        if (C1543ak.f2966aC.equalsIgnoreCase(str2)) {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> [有状态]inner业务，返回空 JSONObject。");
        } else if (C1543ak.f2965aB.equalsIgnoreCase(str2)) {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> [有状态]分享业务 返回body。");
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("header", new JSONObject());
                jSONObject3.put("share", jSONObject2.getJSONObject("share"));
                return jSONObject3;
            } catch (JSONException unused) {
            }
        } else if (!C1543ak.f3013ax.equalsIgnoreCase(str2)) {
            try {
                if ("st".equalsIgnoreCase(str2)) {
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 半开报文，返回body。");
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("header", new JSONObject());
                    jSONObject4.put("analytics", jSONObject2.getJSONObject("analytics"));
                    return jSONObject4;
                }
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 闭合报文，返回body。");
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("header", new JSONObject());
                jSONObject5.put("analytics", jSONObject2.getJSONObject("analytics"));
                return jSONObject5;
            } catch (JSONException unused2) {
                return jSONObject2;
            }
        }
        return new JSONObject();
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        return buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2, UMServerURL.PATH_ANALYTICS, jSONObject.has("st") ? C1543ak.f2971aH : jSONObject2.has(C1543ak.f3010au) ? C1543ak.f2966aC : "a", "9.4.4");
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> [有状态]业务发起构建普通有状态信封请求。");
        JSONObject jSONObject3 = null;
        if (TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("exception", 121);
                    return jSONObject4;
                } catch (JSONException unused) {
                    jSONObject3 = jSONObject4;
                    return jSONObject3;
                }
            } catch (JSONException unused2) {
            }
        } else if (UMUtils.isMainProgress(context)) {
            if (UMConfigure.needSendZcfgEnv(context)) {
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 未获取到，写入二级缓存");
                return add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
            }
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 已获取到，判断二级缓存是否为空");
            if (C1551am.m1296a(context).m1286c()) {
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存为空，直接打信封");
                return new C1767b().m590a(StubApp.getOrigApplicationContext(context.getApplicationContext()), jSONObject, jSONObject2, str, str2, str3);
            }
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存不为空，写入二级缓存");
            JSONObject add2CacheTable = add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
            if (!UMWorkDispatch.eventHasExist(C1724a.f3918t)) {
                UMWorkDispatch.sendEvent(context, C1724a.f3918t, C1725b.m729a(context).m730a(), null);
            }
            return add2CacheTable;
        } else {
            try {
                JSONObject jSONObject5 = new JSONObject();
                try {
                    jSONObject5.put("exception", 120);
                    return jSONObject5;
                } catch (JSONException unused3) {
                    jSONObject3 = jSONObject5;
                    return jSONObject3;
                }
            } catch (JSONException unused4) {
            }
        }
    }

    public static JSONObject buildZeroEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (!UMUtils.isMainProgress(context)) {
            JSONObject jSONObject3 = null;
            try {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("exception", 120);
                    return jSONObject4;
                } catch (JSONException unused) {
                    jSONObject3 = jSONObject4;
                    return jSONObject3;
                }
            } catch (JSONException unused2) {
            }
        } else {
            return new C1767b().m591a(StubApp.getOrigApplicationContext(context.getApplicationContext()), jSONObject, jSONObject2, str);
        }
    }

    public static long getLastInstantBuildTime(Context context) {
        if (context == null) {
            return 0L;
        }
        return UMFrUtils.getLastInstantBuildTime(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        if (context == null) {
            return 0L;
        }
        return UMFrUtils.getLastSuccessfulBuildTime(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public static synchronized boolean getTransmissionSendFlag() {
        boolean z;
        synchronized (UMEnvelopeBuild.class) {
            z = transmissionSendFlag;
        }
        return z;
    }

    public static String imprintProperty(Context context, String str, String str2) {
        return context == null ? str2 : ImprintHandler.getImprintService(StubApp.getOrigApplicationContext(context.getApplicationContext())).m475c().m467a(str, str2);
    }

    public static boolean isOnline(Context context) {
        return UMFrUtils.isOnline(context) && (UMConfigure.needSendZcfgEnv(context) ^ true);
    }

    public static boolean isReadyBuild(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        return isRet(context, uMBusinessType, false);
    }

    public static boolean isReadyBuildNew(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        if (!getTransmissionSendFlag()) {
            return false;
        }
        return isRet(context, uMBusinessType, false);
    }

    public static boolean isReadyBuildStateless() {
        return getTransmissionSendFlag();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(r5) == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
        r7 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isRet(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType, boolean z) {
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            boolean isOnline = UMFrUtils.isOnline(origApplicationContext);
            int envelopeFileNumber = UMFrUtils.envelopeFileNumber(origApplicationContext);
            if (isOnline) {
                if (uMBusinessType != UMLogDataProtocol.UMBusinessType.U_INTERNAL) {
                    if (C1720a.m756a()) {
                        UMWorkDispatch.sendDelayProcessMsg(C1720a.m749b());
                    } else if (!UMFrUtils.hasEnvelopeFile(origApplicationContext, uMBusinessType)) {
                    }
                    z = false;
                }
            }
            if (isOnline && envelopeFileNumber > 0) {
                C1720a.m745d();
            }
        }
        return z;
    }

    public static long maxDataSpace(Context context) {
        if (context == null) {
            return 0L;
        }
        return C1767b.m594a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public static synchronized void setTransmissionSendFlag(boolean z) {
        synchronized (UMEnvelopeBuild.class) {
            transmissionSendFlag = z;
        }
    }
}
