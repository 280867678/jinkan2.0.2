package com.efs.sdk.memoryinfo;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.observer.IConfigCallback;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/* renamed from: com.efs.sdk.memoryinfo.d */
/* loaded from: classes3.dex */
public final class C0800d implements UMMemoryMonitorApi {

    /* renamed from: A */
    public boolean f396A;

    /* renamed from: u */
    public boolean f397u;

    /* renamed from: v */
    public boolean f398v = true;

    /* renamed from: w */
    public C0794b f399w;

    /* renamed from: x */
    public WeakReference<Activity> f400x;

    /* renamed from: y */
    public boolean f401y;

    /* renamed from: z */
    public int f402z;

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final String getCurrentActivity() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f400x;
        return (weakReference == null || (activity = weakReference.get()) == null) ? "" : activity.getClass().getName();
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final boolean isEnable() {
        C0794b c0794b;
        return this.f398v && (c0794b = this.f399w) != null && c0794b.f373b;
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final boolean isForeground() {
        return this.f401y;
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void onActivityResumed(Activity activity) {
        if (!this.f398v) {
            return;
        }
        this.f400x = new WeakReference<>(activity);
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void onActivityStarted(Activity activity) {
        if (this.f398v && activity != null) {
            if (this.f396A) {
                this.f396A = false;
                return;
            }
            int i = this.f402z + 1;
            this.f402z = i;
            if (i != 1) {
                return;
            }
            this.f401y = true;
        }
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void onActivityStopped(Activity activity) {
        if (this.f398v && activity != null) {
            if (activity.isChangingConfigurations()) {
                this.f396A = true;
                return;
            }
            int i = this.f402z - 1;
            this.f402z = i;
            if (i != 0) {
                return;
            }
            this.f401y = false;
        }
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void setEnable(boolean z) {
        this.f398v = z;
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void start(Context context, EfsReporter efsReporter) {
        if ((this.f398v || IntegrationTestingUtil.isIntegrationTestingInPeriod()) && !this.f397u) {
            this.f397u = true;
            final C0794b c0794b = new C0794b(context, efsReporter);
            this.f399w = c0794b;
            c0794b.f372a.getAllSdkConfig(new String[]{"apm_memperf_sampling_rate", "apm_memperf_collect_interval", "apm_memperf_collect_max_period_sec"}, new IConfigCallback() { // from class: com.efs.sdk.memoryinfo.b.1
                @Override // com.efs.sdk.base.observer.IConfigCallback
                public final void onChange(Map<String, Object> map) {
                    Object obj;
                    boolean z;
                    Object obj2;
                    Object obj3;
                    try {
                        if (c0794b.f373b || (obj = map.get("apm_memperf_sampling_rate")) == null) {
                            return;
                        }
                        int parseInt = Integer.parseInt(obj.toString());
                        if (parseInt == 0 || (parseInt != 100 && new Random().nextInt(100) > parseInt)) {
                            z = false;
                            if ((z && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) || (obj2 = map.get("apm_memperf_collect_interval")) == null || (obj3 = map.get("apm_memperf_collect_max_period_sec")) == null) {
                                return;
                            }
                            final int parseInt2 = Integer.parseInt(obj2.toString());
                            final int parseInt3 = Integer.parseInt(obj3.toString());
                            final HandlerThread handlerThread = new HandlerThread("mem-info");
                            handlerThread.start();
                            final Handler handler = new Handler(handlerThread.getLooper()) { // from class: com.efs.sdk.memoryinfo.b.1.1
                                {
                                    C07951.this = this;
                                }

                                @Override // android.os.Handler
                                public final void handleMessage(Message message) {
                                    super.handleMessage(message);
                                    if (message.what == 1) {
                                        try {
                                            handlerThread.quit();
                                        } catch (Throwable unused) {
                                        }
                                    }
                                }
                            };
                            handler.post(new Runnable() { // from class: com.efs.sdk.memoryinfo.b.1.2
                                {
                                    C07951.this = this;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        String uuid = UUID.randomUUID().toString();
                                        int myPid = Process.myPid();
                                        final String lowerCase = UMUtils.MD5(myPid + uuid).toLowerCase();
                                        final C0794b c0794b2 = c0794b;
                                        final Handler handler2 = handler;
                                        final int i = parseInt2;
                                        final int i2 = parseInt3;
                                        final C0801e c0801e = new C0801e(c0794b2.mContext, c0794b2.f372a);
                                        final long elapsedRealtime = SystemClock.elapsedRealtime();
                                        handler2.post(new Runnable() { // from class: com.efs.sdk.memoryinfo.b.2
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                if (SystemClock.elapsedRealtime() - elapsedRealtime > i2 * 1000) {
                                                    handler2.sendEmptyMessage(1);
                                                    return;
                                                }
                                                try {
                                                    C0794b.m3981a(c0794b2, c0801e, lowerCase);
                                                } catch (Throwable th) {
                                                    C0803f.m3973a("collect ", th);
                                                }
                                                handler2.postDelayed(this, i * 1000);
                                            }
                                        });
                                    } catch (Throwable unused) {
                                        handler.sendEmptyMessage(1);
                                    }
                                }
                            });
                            c0794b.f373b = true;
                        }
                        z = true;
                        if (z) {
                        }
                        final int parseInt22 = Integer.parseInt(obj2.toString());
                        final int parseInt32 = Integer.parseInt(obj3.toString());
                        final HandlerThread handlerThread2 = new HandlerThread("mem-info");
                        handlerThread2.start();
                        final Handler handler2 = new Handler(handlerThread2.getLooper()) { // from class: com.efs.sdk.memoryinfo.b.1.1
                            {
                                C07951.this = this;
                            }

                            @Override // android.os.Handler
                            public final void handleMessage(Message message) {
                                super.handleMessage(message);
                                if (message.what == 1) {
                                    try {
                                        handlerThread2.quit();
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        };
                        handler2.post(new Runnable() { // from class: com.efs.sdk.memoryinfo.b.1.2
                            {
                                C07951.this = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    String uuid = UUID.randomUUID().toString();
                                    int myPid = Process.myPid();
                                    final String lowerCase = UMUtils.MD5(myPid + uuid).toLowerCase();
                                    final C0794b c0794b2 = c0794b;
                                    final Handler handler22 = handler2;
                                    final int i = parseInt22;
                                    final int i2 = parseInt32;
                                    final C0801e c0801e = new C0801e(c0794b2.mContext, c0794b2.f372a);
                                    final long elapsedRealtime = SystemClock.elapsedRealtime();
                                    handler22.post(new Runnable() { // from class: com.efs.sdk.memoryinfo.b.2
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            if (SystemClock.elapsedRealtime() - elapsedRealtime > i2 * 1000) {
                                                handler22.sendEmptyMessage(1);
                                                return;
                                            }
                                            try {
                                                C0794b.m3981a(c0794b2, c0801e, lowerCase);
                                            } catch (Throwable th) {
                                                C0803f.m3973a("collect ", th);
                                            }
                                            handler22.postDelayed(this, i * 1000);
                                        }
                                    });
                                } catch (Throwable unused) {
                                    handler2.sendEmptyMessage(1);
                                }
                            }
                        });
                        c0794b.f373b = true;
                    } catch (Throwable th) {
                        C0803f.m3973a("collect ", th);
                    }
                }
            });
        }
    }
}
