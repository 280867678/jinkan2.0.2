package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import com.stub.StubApp;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.C1724a;
import com.umeng.commonsdk.internal.C1725b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import org.json.JSONObject;

/* renamed from: com.umeng.commonsdk.internal.utils.b */
/* loaded from: classes4.dex */
public class C1736b {

    /* renamed from: a */
    public static final String f3949a = "BatteryUtils";

    /* renamed from: b */
    public static boolean f3950b;

    /* renamed from: c */
    public static Context f3951c;

    /* renamed from: d */
    public BroadcastReceiver f3952d;

    /* renamed from: com.umeng.commonsdk.internal.utils.b$a */
    /* loaded from: classes4.dex */
    public static class C1738a {

        /* renamed from: a */
        public static final C1736b f3954a = new C1736b();
    }

    public C1736b() {
        this.f3952d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.b.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (!intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("le", intent.getIntExtra("level", 0));
                    } catch (Exception unused) {
                    }
                    try {
                        jSONObject.put("vol", intent.getIntExtra("voltage", 0));
                    } catch (Exception unused2) {
                    }
                    try {
                        jSONObject.put("temp", intent.getIntExtra("temperature", 0));
                        jSONObject.put("ts", System.currentTimeMillis());
                    } catch (Exception unused3) {
                    }
                    int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, 0);
                    int i = -1;
                    int i2 = 2;
                    if (intExtra != 1) {
                        if (intExtra == 2) {
                            i = 1;
                        } else if (intExtra == 4) {
                            i = 0;
                        } else if (intExtra == 5) {
                            i = 2;
                        }
                    }
                    try {
                        jSONObject.put("st", i);
                    } catch (Exception unused4) {
                    }
                    int intExtra2 = intent.getIntExtra("plugged", 0);
                    if (intExtra2 == 1) {
                        i2 = 1;
                    } else if (intExtra2 != 2) {
                        i2 = 0;
                    }
                    try {
                        jSONObject.put("ct", i2);
                        jSONObject.put("ts", System.currentTimeMillis());
                    } catch (Exception unused5) {
                    }
                    ULog.m535i(C1736b.f3949a, jSONObject.toString());
                    UMWorkDispatch.sendEvent(context, C1724a.f3906h, C1725b.m729a(C1736b.f3951c).m730a(), jSONObject.toString());
                    C1736b.this.m672c();
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(C1736b.f3951c, th);
                }
            }
        };
    }

    /* renamed from: a */
    public static C1736b m674a(Context context) {
        if (f3951c == null && context != null) {
            f3951c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return C1738a.f3954a;
    }

    /* renamed from: a */
    public synchronized boolean m675a() {
        return f3950b;
    }

    /* renamed from: b */
    public synchronized void m673b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f3951c.registerReceiver(this.f3952d, intentFilter);
            f3950b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f3951c, th);
        }
    }

    /* renamed from: c */
    public synchronized void m672c() {
        try {
            f3951c.unregisterReceiver(this.f3952d);
            f3950b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f3951c, th);
        }
    }
}
