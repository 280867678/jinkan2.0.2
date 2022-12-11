package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.AbstractC1174m;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.C1164h;
import com.tencent.bugly.crashreport.crash.C1172k;
import com.tencent.bugly.proguard.C1183H;
import com.tencent.bugly.proguard.C1199X;

/* loaded from: classes3.dex */
public class CrashModule extends AbstractC1081a {
    public static final int MODULE_ID = 1004;

    /* renamed from: a */
    public static int f695a;

    /* renamed from: b */
    public static CrashModule f696b = new CrashModule();

    /* renamed from: c */
    public long f697c;

    /* renamed from: d */
    public BuglyStrategy.C1080a f698d;

    /* renamed from: e */
    public boolean f699e = false;

    /* renamed from: a */
    private synchronized void m3637a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
        if (!TextUtils.isEmpty(libBuglySOFilePath)) {
            C1140a.m3421a(context).f1015L = libBuglySOFilePath;
            C1199X.m3078c("setted libBugly.so file path :%s", libBuglySOFilePath);
        }
        if (buglyStrategy.mo4835getCrashHandleCallback() != null) {
            this.f698d = buglyStrategy.mo4835getCrashHandleCallback();
            C1199X.m3078c("setted CrashHanldeCallback", new Object[0]);
        }
        if (buglyStrategy.getAppReportDelay() > 0) {
            long appReportDelay = buglyStrategy.getAppReportDelay();
            this.f697c = appReportDelay;
            C1199X.m3078c("setted delay: %d", Long.valueOf(appReportDelay));
        }
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = f696b;
        crashModule.f700id = 1004;
        return crashModule;
    }

    @Override // com.tencent.bugly.AbstractC1081a
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.f699e;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0085 A[Catch: all -> 0x00af, TryCatch #0 {, blocks: (B:7:0x0003, B:10:0x0009, B:12:0x0039, B:14:0x0049, B:16:0x004f, B:17:0x0052, B:19:0x0057, B:22:0x005e, B:24:0x006e, B:27:0x0075, B:29:0x0085, B:30:0x008c, B:35:0x0080, B:36:0x0069), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008a  */
    @Override // com.tencent.bugly.AbstractC1081a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void init(Context context, boolean z, BuglyStrategy buglyStrategy) {
        if (context != null) {
            if (!this.f699e) {
                C1199X.m3078c("Initializing crash module.", new Object[0]);
                C1183H m3186a = C1183H.m3186a();
                int i = f695a + 1;
                f695a = i;
                m3186a.m3184a(1004, i);
                this.f699e = true;
                CrashReport.setContext(context);
                m3637a(context, buglyStrategy);
                C1164h m3276a = C1164h.m3276a(1004, context, z, this.f698d, (AbstractC1174m) null, (String) null);
                m3276a.m3251r();
                if (buglyStrategy != null) {
                    m3276a.m3277a(buglyStrategy.getCallBackType());
                    m3276a.m3270a(buglyStrategy.getCloseErrorCallback());
                }
                if (buglyStrategy != null && buglyStrategy.isEnableCatchAnrTrace()) {
                    m3276a.m3252q();
                }
                m3276a.m3278a();
                if (buglyStrategy != null && !buglyStrategy.isEnableNativeCrashMonitor()) {
                    C1199X.m3078c("[crash] Closed native crash monitor!", new Object[0]);
                    m3276a.m3264e();
                    if (buglyStrategy != null && !buglyStrategy.isEnableANRCrashMonitor()) {
                        C1199X.m3078c("[crash] Closed ANR monitor!", new Object[0]);
                        m3276a.m3266c();
                        m3276a.m3275a(buglyStrategy == null ? buglyStrategy.getAppReportDelay() : 0L);
                        m3276a.m3248u();
                        C1172k.m3213a(context);
                        BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
                        buglyBroadcastReceiver.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
                        buglyBroadcastReceiver.register(context);
                        C1183H m3186a2 = C1183H.m3186a();
                        int i2 = f695a - 1;
                        f695a = i2;
                        m3186a2.m3184a(1004, i2);
                    }
                    m3276a.m3253p();
                    m3276a.m3275a(buglyStrategy == null ? buglyStrategy.getAppReportDelay() : 0L);
                    m3276a.m3248u();
                    C1172k.m3213a(context);
                    BuglyBroadcastReceiver buglyBroadcastReceiver2 = BuglyBroadcastReceiver.getInstance();
                    buglyBroadcastReceiver2.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    buglyBroadcastReceiver2.register(context);
                    C1183H m3186a22 = C1183H.m3186a();
                    int i22 = f695a - 1;
                    f695a = i22;
                    m3186a22.m3184a(1004, i22);
                }
                m3276a.m3250s();
                if (buglyStrategy != null) {
                    C1199X.m3078c("[crash] Closed ANR monitor!", new Object[0]);
                    m3276a.m3266c();
                    m3276a.m3275a(buglyStrategy == null ? buglyStrategy.getAppReportDelay() : 0L);
                    m3276a.m3248u();
                    C1172k.m3213a(context);
                    BuglyBroadcastReceiver buglyBroadcastReceiver22 = BuglyBroadcastReceiver.getInstance();
                    buglyBroadcastReceiver22.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    buglyBroadcastReceiver22.register(context);
                    C1183H m3186a222 = C1183H.m3186a();
                    int i222 = f695a - 1;
                    f695a = i222;
                    m3186a222.m3184a(1004, i222);
                }
                m3276a.m3253p();
                m3276a.m3275a(buglyStrategy == null ? buglyStrategy.getAppReportDelay() : 0L);
                m3276a.m3248u();
                C1172k.m3213a(context);
                BuglyBroadcastReceiver buglyBroadcastReceiver222 = BuglyBroadcastReceiver.getInstance();
                buglyBroadcastReceiver222.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
                buglyBroadcastReceiver222.register(context);
                C1183H m3186a2222 = C1183H.m3186a();
                int i2222 = f695a - 1;
                f695a = i2222;
                m3186a2222.m3184a(1004, i2222);
            }
        }
    }

    @Override // com.tencent.bugly.AbstractC1081a
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        C1164h m3262g;
        if (strategyBean == null || (m3262g = C1164h.m3262g()) == null) {
            return;
        }
        m3262g.m3274a(strategyBean);
    }
}
