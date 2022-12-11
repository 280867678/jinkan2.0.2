package com.umeng.analytics.vshelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.AbstractC1554ap;
import com.umeng.analytics.pro.C1648o;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.vshelper.b */
/* loaded from: classes4.dex */
public class C1685b implements AbstractC1554ap {

    /* renamed from: a */
    public static final String f3707a = "RealTimeDebugSwitch";

    /* renamed from: b */
    public static int f3708b;

    @Override // com.umeng.analytics.pro.AbstractC1554ap
    /* renamed from: a */
    public void mo835a() {
    }

    @Override // com.umeng.analytics.pro.AbstractC1554ap
    /* renamed from: a */
    public void mo834a(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    @Override // com.umeng.analytics.pro.AbstractC1554ap
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo833a(Activity activity, Bundle bundle) {
        String str;
        Uri uri;
        StringBuilder sb;
        StringBuilder sb2;
        String sb3;
        long longValue;
        int i;
        if (f3708b == 0) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null) {
                    String scheme = data.getScheme();
                    if (scheme == null || !scheme.startsWith("um.")) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("--->>> scheme: ");
                        sb4.append(scheme);
                        sb2 = sb4;
                    } else {
                        String queryParameter = data.getQueryParameter("debugkey");
                        String queryParameter2 = data.getQueryParameter(AnalyticsConfig.DEBUG_MODE_PERIOD);
                        if (TextUtils.isEmpty(queryParameter)) {
                            return;
                        }
                        if (!TextUtils.isEmpty(queryParameter2)) {
                            try {
                                longValue = Long.valueOf(queryParameter2).longValue();
                            } catch (Throwable unused) {
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("debugkey", queryParameter);
                            i = (longValue > 0L ? 1 : (longValue == 0L ? 0 : -1));
                            if (i >= 0) {
                                if (!AnalyticsConfig.isRealTimeDebugMode()) {
                                    sb3 = "--->>> Not currently in RealTimeDebug mode and doing nothing.";
                                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, sb3);
                                }
                                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> call turnOffRealTimeDebug because sendaging < 0");
                                AnalyticsConfig.turnOffRealTimeDebug();
                                Context origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
                                UMWorkDispatch.sendEvent(origApplicationContext, C1648o.C1650a.f3583E, CoreProtocol.getInstance(origApplicationContext), null);
                                return;
                            }
                            AnalyticsConfig.turnOnRealTimeDebug(hashMap);
                            if (i > 0) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put(AnalyticsConfig.RTD_START_TIME, System.currentTimeMillis());
                                    if (longValue < 60) {
                                        longValue = 60;
                                    }
                                    if (longValue > 240) {
                                        longValue = 240;
                                    }
                                    jSONObject.put(AnalyticsConfig.RTD_PERIOD, longValue);
                                    jSONObject.put("debugkey", queryParameter);
                                } catch (Throwable unused2) {
                                }
                                Context origApplicationContext2 = StubApp.getOrigApplicationContext(activity.getApplicationContext());
                                UMWorkDispatch.sendEvent(origApplicationContext2, C1648o.C1650a.f3582D, CoreProtocol.getInstance(origApplicationContext2), jSONObject);
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("--->>> turnOnRealTimeDebug[persistent] dk: ");
                                sb5.append(queryParameter);
                                sb5.append("; period: ");
                                sb5.append(longValue);
                                sb2 = sb5;
                            } else {
                                Context origApplicationContext3 = StubApp.getOrigApplicationContext(activity.getApplicationContext());
                                UMWorkDispatch.sendEvent(origApplicationContext3, C1648o.C1650a.f3583E, CoreProtocol.getInstance(origApplicationContext3), null);
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("--->>> turnOnRealTimeDebug[non-persistent] dk: ");
                                sb6.append(queryParameter);
                                sb2 = sb6;
                            }
                        }
                        longValue = 0;
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("debugkey", queryParameter);
                        i = (longValue > 0L ? 1 : (longValue == 0L ? 0 : -1));
                        if (i >= 0) {
                        }
                    }
                    sb3 = sb2.toString();
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, sb3);
                }
                str = "--->>> uri: ";
                sb = new StringBuilder();
                uri = data;
            } else {
                str = "--->>> intent: ";
                sb = new StringBuilder();
                uri = intent;
            }
            sb.append(str);
            sb.append(uri);
            sb2 = sb;
            sb3 = sb2.toString();
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, sb3);
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1554ap
    /* renamed from: b */
    public void mo832b() {
    }

    @Override // com.umeng.analytics.pro.AbstractC1554ap
    /* renamed from: b */
    public void mo831b(Activity activity) {
    }

    @Override // com.umeng.analytics.pro.AbstractC1554ap
    /* renamed from: b */
    public void mo830b(Activity activity, Bundle bundle) {
    }

    @Override // com.umeng.analytics.pro.AbstractC1554ap
    /* renamed from: c */
    public void mo829c() {
    }

    @Override // com.umeng.analytics.pro.AbstractC1554ap
    /* renamed from: c */
    public void mo828c(Activity activity) {
        f3708b++;
    }

    @Override // com.umeng.analytics.pro.AbstractC1554ap
    /* renamed from: d */
    public void mo827d(Activity activity) {
        f3708b--;
    }

    @Override // com.umeng.analytics.pro.AbstractC1554ap
    /* renamed from: e */
    public void mo826e(Activity activity) {
    }
}
