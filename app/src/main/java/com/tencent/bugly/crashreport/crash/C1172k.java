package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.info.C1141b;
import com.tencent.bugly.crashreport.common.strategy.C1145c;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C1198W;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1205ba;
import com.tencent.bugly.proguard.C1208ca;
import com.umeng.commonsdk.UMConfigure;
import java.util.LinkedHashMap;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.crashreport.crash.k */
/* loaded from: classes3.dex */
public class C1172k {

    /* renamed from: a */
    public static C1172k f1305a;

    /* renamed from: b */
    public C1145c f1306b;

    /* renamed from: c */
    public C1140a f1307c;

    /* renamed from: d */
    public C1161e f1308d;

    /* renamed from: e */
    public Context f1309e;

    public C1172k(Context context) {
        C1164h m3262g = C1164h.m3262g();
        if (m3262g == null) {
            return;
        }
        this.f1306b = C1145c.m3344b();
        this.f1307c = C1140a.m3421a(context);
        this.f1308d = m3262g.f1250r;
        this.f1309e = context;
        C1198W.m3089c().m3092a(new RunnableC1167i(this));
    }

    /* renamed from: a */
    public static C1172k m3213a(Context context) {
        if (f1305a == null) {
            f1305a = new C1172k(context);
        }
        return f1305a;
    }

    /* renamed from: a */
    public static void m3210a(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        C1198W.m3089c().m3092a(new RunnableC1168j(thread, i, str, str2, str3, map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3209b() {
        C1199X.m3084a("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.proguard.o");
            this.f1307c.getClass();
            C1208ca.m3030a(cls, "sdkPackageName", "com.tencent.bugly", (Object) null);
            C1199X.m3084a("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            C1199X.m3078c("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3208b(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        String str4;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        if (i == 4) {
            str4 = UMConfigure.WRAPER_TYPE_UNITY;
        } else if (i == 5 || i == 6) {
            str4 = "Cocos";
        } else if (i != 8) {
            C1199X.m3076e("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i));
            return;
        } else {
            str4 = "H5";
        }
        String str5 = str4;
        C1199X.m3081b("[ExtraCrashManager] %s Crash Happen", str5);
        try {
            if (!this.f1306b.m3341d()) {
                C1199X.m3076e("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean m3342c = this.f1306b.m3342c();
            if (!m3342c.f1089f && this.f1306b.m3341d()) {
                C1199X.m3081b("[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                String m3047a = C1208ca.m3047a();
                String str6 = this.f1307c.f1043h;
                String name = currentThread.getName();
                C1161e.m3293a(str5, m3047a, str6, name, str + "\n" + str2 + "\n" + str3, null);
                C1199X.m3081b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i == 5 || i == 6) {
                if (!m3342c.f1094k) {
                    C1199X.m3081b("[ExtraCrashManager] %s report is disabled.", str5);
                    C1199X.m3081b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (i == 8 && !m3342c.f1095l) {
                C1199X.m3081b("[ExtraCrashManager] %s report is disabled.", str5);
                C1199X.m3081b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            CrashDetailBean m3207c = m3207c(currentThread, i == 8 ? 5 : i, str, str2, str3, map);
            if (m3207c == null) {
                C1199X.m3081b("[ExtraCrashManager] Failed to package crash data.", new Object[0]);
                C1199X.m3081b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            String m3047a2 = C1208ca.m3047a();
            String str7 = this.f1307c.f1043h;
            String name2 = currentThread.getName();
            C1161e.m3293a(str5, m3047a2, str7, name2, str + "\n" + str2 + "\n" + str3, m3207c);
            if (!this.f1308d.m3286b(m3207c)) {
                this.f1308d.m3295a(m3207c, 3000L, false);
            }
            C1199X.m3081b("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!C1199X.m3080b(th)) {
                    th.printStackTrace();
                }
                C1199X.m3081b("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                C1199X.m3081b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }

    /* renamed from: c */
    private CrashDetailBean m3207c(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f1123C = C1141b.m3365h();
        crashDetailBean.f1124D = C1141b.m3361j();
        crashDetailBean.f1125E = C1141b.m3367g();
        crashDetailBean.f1126F = this.f1307c.m3385v();
        crashDetailBean.f1127G = this.f1307c.m3384w();
        crashDetailBean.f1128H = this.f1307c.m3383x();
        crashDetailBean.f1167w = C1208ca.m3043a(this.f1309e, C1164h.f1235e, C1164h.f1238h);
        crashDetailBean.f1146b = i;
        crashDetailBean.f1149e = this.f1307c.m3395l();
        C1140a c1140a = this.f1307c;
        crashDetailBean.f1150f = c1140a.f1008E;
        crashDetailBean.f1151g = c1140a.m3398i();
        crashDetailBean.f1157m = this.f1307c.m3382y();
        String str4 = "";
        crashDetailBean.f1158n = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str4, str);
        crashDetailBean.f1159o = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str4, str2);
        if (str3 != null) {
            String[] split = str3.split("\n");
            if (split.length > 0) {
                str4 = split[0];
            }
        } else {
            str3 = str4;
        }
        crashDetailBean.f1160p = str4;
        crashDetailBean.f1161q = str3;
        crashDetailBean.f1162r = System.currentTimeMillis();
        crashDetailBean.f1165u = C1208ca.m3004c(crashDetailBean.f1161q.getBytes());
        crashDetailBean.f1170z = C1208ca.m3046a(C1164h.f1236f, false);
        crashDetailBean.f1121A = this.f1307c.f1043h;
        crashDetailBean.f1122B = thread.getName() + "(" + thread.getId() + ")";
        crashDetailBean.f1129I = this.f1307c.m3389r();
        crashDetailBean.f1152h = this.f1307c.m3391p();
        C1140a c1140a2 = this.f1307c;
        crashDetailBean.f1134N = c1140a2.f1035d;
        crashDetailBean.f1135O = c1140a2.m3427C();
        if (!C1164h.m3262g().m3263f()) {
            this.f1308d.m3284c(crashDetailBean);
        }
        crashDetailBean.f1138R = this.f1307c.m3429A();
        crashDetailBean.f1139S = this.f1307c.m3387t();
        crashDetailBean.f1140T = this.f1307c.m3399h();
        crashDetailBean.f1141U = this.f1307c.m3401g();
        crashDetailBean.f1169y = C1205ba.m3063b();
        if (crashDetailBean.f1136P == null) {
            crashDetailBean.f1136P = new LinkedHashMap();
        }
        if (map != null) {
            crashDetailBean.f1136P.putAll(map);
        }
        return crashDetailBean;
    }
}
