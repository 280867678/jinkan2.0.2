package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMRTLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.pro.q */
/* loaded from: classes4.dex */
public class C1655q {
    /* renamed from: a */
    public static long m925a(JSONArray jSONArray) {
        return jSONArray.toString().getBytes().length;
    }

    /* renamed from: a */
    public static long m924a(JSONObject jSONObject) {
        return jSONObject.toString().getBytes().length;
    }

    /* renamed from: a */
    public static JSONObject m926a(Context context, long j, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!jSONObject.has("content")) {
                return jSONObject2;
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("content");
            if (jSONObject3.has("analytics")) {
                JSONObject jSONObject4 = jSONObject3.getJSONObject("analytics");
                if (jSONObject4.has("ekv")) {
                    jSONObject4.remove("ekv");
                }
                if (jSONObject4.has(C1615d.f3294T)) {
                    jSONObject4.remove(C1615d.f3294T);
                }
                if (jSONObject4.has("error")) {
                    jSONObject4.remove("error");
                }
                jSONObject3.put("analytics", jSONObject4);
            }
            jSONObject2.put("content", jSONObject3);
            if (jSONObject.has("header")) {
                jSONObject2.put("header", jSONObject.getJSONObject("header"));
            }
            if (m924a(jSONObject2) <= j) {
                return jSONObject2;
            }
            jSONObject2 = null;
            C1636i.m1056a(context).m1026i();
            C1636i.m1056a(context).m1027h();
            C1636i.m1056a(context).m1036b(true, false);
            C1636i.m1056a(context).m1057a();
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> u-app packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }
}
