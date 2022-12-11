package com.umeng.commonsdk.vchannel;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.C1724a;
import com.umeng.commonsdk.internal.C1725b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class Sender {
    public static long INTERVAL_THRESHOLD = 500;
    public static final String VCHANNEL_VERSION = "1.0.0";
    public static Map<String, String> customHeader;
    public static long lastTriggerTime;

    public static void handleEvent(Context context, C1849b c1849b) {
        if (context == null) {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> Sender:handleEvent: context is null.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(C1543ak.f2978aO, "1.0.0");
                if (customHeader != null && customHeader.size() > 0) {
                    for (String str : customHeader.keySet()) {
                        jSONObject.put(str, customHeader.get(str));
                    }
                }
            } catch (Throwable unused) {
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("analytics", c1849b.m208d());
            UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2, C1848a.f4317c, C1543ak.f2968aE, "1.0.0");
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void onEvent(Context context, String str, Map<String, Object> map) {
        if (context == null) {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: context is null.");
        } else if (TextUtils.isEmpty(str)) {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: eventID is null or an empty string.");
        } else if (map == null) {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: map is null.");
        } else if (!UMFrUtils.isOnline(context)) {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: Network unavailable.");
        } else if (System.currentTimeMillis() - lastTriggerTime < INTERVAL_THRESHOLD) {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: The interval between events is less than 500 milliseconds.");
        } else {
            C1849b c1849b = new C1849b(context);
            c1849b.m212a(str);
            c1849b.m213a(System.currentTimeMillis());
            c1849b.m211a(map);
            try {
                UMWorkDispatch.sendEvent(context, C1724a.f3913o, C1725b.m729a(context).m730a(), c1849b);
            } catch (Throwable unused) {
            }
            lastTriggerTime = System.currentTimeMillis();
        }
    }

    public static void setCustomHeader(Map<String, String> map) {
        if (map != null) {
            customHeader = map;
        }
    }
}
