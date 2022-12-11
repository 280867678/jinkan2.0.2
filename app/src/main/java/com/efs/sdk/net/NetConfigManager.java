package com.efs.sdk.net;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.p020pa.config.ConfigManager;
import com.stub.StubApp;
import java.util.Map;
import java.util.Random;

/* loaded from: classes3.dex */
public class NetConfigManager {

    /* renamed from: a */
    public final String f408a = "NetConfigManager";

    /* renamed from: b */
    public final int f409b = 0;

    /* renamed from: c */
    public EfsReporter f410c;

    /* renamed from: d */
    public int f411d;

    /* renamed from: e */
    public int f412e;

    /* renamed from: f */
    public boolean f413f;

    /* renamed from: g */
    public Context f414g;

    public NetConfigManager(Context context, EfsReporter efsReporter) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor edit2;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit3;
        SharedPreferences.Editor edit4;
        SharedPreferences.Editor edit5;
        this.f411d = 0;
        this.f413f = false;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f414g = origApplicationContext;
        this.f410c = efsReporter;
        SharedPreferences sharedPreferences2 = origApplicationContext.getSharedPreferences("net_launch", 0);
        if (sharedPreferences2 != null) {
            this.f412e = sharedPreferences2.getInt("apm_netperf_sampling_rate_last", 0);
        }
        SharedPreferences sharedPreferences3 = this.f414g.getSharedPreferences("net_launch", 0);
        int i = sharedPreferences3 != null ? sharedPreferences3.getInt("apm_netperf_sampling_rate", -1) : -1;
        this.f410c.getAllSdkConfig(new String[]{"apm_netperf_sampling_rate"}, new IConfigCallback() { // from class: com.efs.sdk.net.NetConfigManager.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                SharedPreferences sharedPreferences4;
                SharedPreferences.Editor edit6;
                try {
                    Object obj = map.get("apm_netperf_sampling_rate");
                    if (obj == null || (sharedPreferences4 = NetConfigManager.this.f414g.getSharedPreferences("net_launch", 0)) == null || (edit6 = sharedPreferences4.edit()) == null) {
                        return;
                    }
                    edit6.putInt("apm_netperf_sampling_rate", Integer.parseInt(obj.toString()));
                    edit6.commit();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        if (i != -1) {
            this.f411d = i;
        }
        SharedPreferences sharedPreferences4 = this.f414g.getSharedPreferences("net_launch", 0);
        long j = sharedPreferences4 != null ? sharedPreferences4.getLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L) : 0L;
        boolean z = sharedPreferences4 != null ? sharedPreferences4.getBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
        int i2 = this.f411d;
        boolean z2 = true;
        if (i2 != 0) {
            boolean z3 = i2 != this.f412e;
            Long valueOf = Long.valueOf(j);
            int i3 = this.f411d;
            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
            Long valueOf3 = Long.valueOf(valueOf2.longValue() - valueOf.longValue());
            if (z && valueOf3.longValue() < 86400000 && !z3) {
                Log.m4070d("NetConfigManager", " check in allready");
            } else if (valueOf3.longValue() >= 86400000 || z3) {
                if (i3 != 0 && (i3 == 100 || new Random().nextInt(100) <= i3)) {
                    Log.m4070d("NetConfigManager", "random check in");
                } else {
                    Log.m4070d("NetConfigManager", "random not check in!");
                    z2 = false;
                }
                SharedPreferences sharedPreferences5 = this.f414g.getSharedPreferences("net_launch", 0);
                if (sharedPreferences5 != null && (edit2 = sharedPreferences5.edit()) != null) {
                    edit2.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, z2);
                    edit2.commit();
                }
                if (sharedPreferences5 != null && (edit = sharedPreferences5.edit()) != null) {
                    edit.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, valueOf2.longValue());
                    edit.commit();
                }
            } else {
                Log.m4070d("NetConfigManager", "un repeat check in 24 hour!");
            }
            this.f413f = z2;
            sharedPreferences = this.f414g.getSharedPreferences("net_launch", 0);
            if (sharedPreferences != null || (edit3 = sharedPreferences.edit()) == null) {
            }
            edit3.putInt("apm_netperf_sampling_rate_last", this.f411d);
            edit3.commit();
            return;
        }
        if (z && sharedPreferences4 != null && (edit5 = sharedPreferences4.edit()) != null) {
            edit5.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false);
            edit5.commit();
        }
        if (j != 0 && sharedPreferences4 != null && (edit4 = sharedPreferences4.edit()) != null) {
            edit4.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L);
            edit4.commit();
        }
        z2 = false;
        this.f413f = z2;
        sharedPreferences = this.f414g.getSharedPreferences("net_launch", 0);
        if (sharedPreferences != null) {
        }
    }

    public boolean enableTracer() {
        return this.f413f;
    }
}
