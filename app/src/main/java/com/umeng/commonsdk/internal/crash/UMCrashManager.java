package com.umeng.commonsdk.internal.crash;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.C1724a;
import com.umeng.commonsdk.internal.C1725b;
import com.umeng.commonsdk.stateless.C1753a;
import com.umeng.commonsdk.stateless.C1759d;
import com.umeng.commonsdk.statistics.UMServerURL;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class UMCrashManager {
    public static final String CM_VERSION = "2.0";
    public static boolean isReportCrash;
    public static Object mObject = new Object();

    public static void buildEnvelope(Context context, Object obj) {
        UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> UMCrashManager.buildEnvelope enter.");
        try {
            synchronized (mObject) {
                if (context == null || obj == null) {
                    return;
                }
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    String str2 = context.getFilesDir() + File.separator + C1753a.f3990f;
                    File file = new File(str2);
                    if (!file.isDirectory()) {
                        file.mkdir();
                    }
                    C1759d.m616a(context, str2, C1543ak.f2969aF, 10);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(C1543ak.f2977aN, "2.0");
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("content", str);
                        jSONObject2.put("ts", System.currentTimeMillis());
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("crash", jSONObject2);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("tp", jSONObject3);
                        UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject4, UMServerURL.PATH_INNER_CRASH, C1543ak.f2969aF, "2.0");
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void reportCrash(Context context, Throwable th) {
        synchronized (mObject) {
            if (!isReportCrash) {
                isReportCrash = true;
                UMWorkDispatch.sendEvent(context, C1724a.f3919u, C1725b.m729a(context).m730a(), C1732a.m712a(th));
            }
        }
    }
}
