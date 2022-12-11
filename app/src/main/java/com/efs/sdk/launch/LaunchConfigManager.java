package com.efs.sdk.launch;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.p020pa.config.ConfigManager;
import com.stub.StubApp;
import java.util.Map;
import java.util.Random;

/* loaded from: classes3.dex */
public class LaunchConfigManager {

    /* renamed from: a */
    public final String f340a = "LaunchConfigManager";

    /* renamed from: b */
    public final int f341b = 0;

    /* renamed from: c */
    public EfsReporter f342c;

    /* renamed from: d */
    public int f343d;

    /* renamed from: e */
    public int f344e;

    /* renamed from: f */
    public boolean f345f;

    /* renamed from: g */
    public Context f346g;

    public LaunchConfigManager(Context context, EfsReporter efsReporter) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor edit2;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit3;
        SharedPreferences.Editor edit4;
        SharedPreferences.Editor edit5;
        this.f343d = 100;
        this.f345f = false;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f346g = origApplicationContext;
        this.f342c = efsReporter;
        SharedPreferences sharedPreferences2 = origApplicationContext.getSharedPreferences("efs_launch", 0);
        if (sharedPreferences2 != null) {
            this.f344e = sharedPreferences2.getInt("apm_startperf_sampling_rate_last", 0);
        }
        SharedPreferences sharedPreferences3 = this.f346g.getSharedPreferences("efs_launch", 0);
        int i = sharedPreferences3 != null ? sharedPreferences3.getInt("apm_startperf_sampling_rate", -1) : -1;
        this.f342c.getAllSdkConfig(new String[]{"apm_startperf_sampling_rate"}, new IConfigCallback() { // from class: com.efs.sdk.launch.LaunchConfigManager.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                SharedPreferences sharedPreferences4;
                SharedPreferences.Editor edit6;
                try {
                    Object obj = map.get("apm_startperf_sampling_rate");
                    if (obj == null || (sharedPreferences4 = LaunchConfigManager.this.f346g.getSharedPreferences("efs_launch", 0)) == null || (edit6 = sharedPreferences4.edit()) == null) {
                        return;
                    }
                    edit6.putInt("apm_startperf_sampling_rate", Integer.parseInt(obj.toString()));
                    edit6.commit();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        if (i != -1) {
            this.f343d = i;
        }
        SharedPreferences sharedPreferences4 = this.f346g.getSharedPreferences("efs_launch", 0);
        long j = sharedPreferences4 != null ? sharedPreferences4.getLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L) : 0L;
        boolean z = sharedPreferences4 != null ? sharedPreferences4.getBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
        int i2 = this.f343d;
        boolean z2 = true;
        if (i2 != 0) {
            boolean z3 = i2 != this.f344e;
            Long valueOf = Long.valueOf(j);
            int i3 = this.f343d;
            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
            Long valueOf3 = Long.valueOf(valueOf2.longValue() - valueOf.longValue());
            if (z && valueOf3.longValue() < 86400000 && !z3) {
                boolean z4 = LaunchManager.isDebug;
            } else if (valueOf3.longValue() >= 86400000 || z3) {
                if (i3 != 0 && (i3 == 100 || new Random().nextInt(100) <= i3)) {
                    boolean z5 = LaunchManager.isDebug;
                } else {
                    boolean z6 = LaunchManager.isDebug;
                    z2 = false;
                }
                SharedPreferences sharedPreferences5 = this.f346g.getSharedPreferences("efs_launch", 0);
                if (sharedPreferences5 != null && (edit2 = sharedPreferences5.edit()) != null) {
                    edit2.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, z2);
                    edit2.commit();
                }
                if (sharedPreferences5 != null && (edit = sharedPreferences5.edit()) != null) {
                    edit.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, valueOf2.longValue());
                    edit.commit();
                }
            } else {
                boolean z7 = LaunchManager.isDebug;
            }
            this.f345f = z2;
            sharedPreferences = this.f346g.getSharedPreferences("efs_launch", 0);
            if (sharedPreferences != null || (edit3 = sharedPreferences.edit()) == null) {
            }
            edit3.putInt("apm_startperf_sampling_rate_last", this.f343d);
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
        this.f345f = z2;
        sharedPreferences = this.f346g.getSharedPreferences("efs_launch", 0);
        if (sharedPreferences != null) {
        }
    }

    public boolean enableTracer() {
        return this.f345f;
    }
}
