package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.AbstractC1081a;
import com.tencent.bugly.crashreport.biz.C1138f;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.proguard.C1185J;
import com.tencent.bugly.proguard.C1188L;
import com.tencent.bugly.proguard.C1198W;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import com.tencent.bugly.proguard.C1239ra;
import com.tencent.bugly.proguard.C1241sa;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.bugly.crashreport.common.strategy.c */
/* loaded from: classes3.dex */
public class C1145c {

    /* renamed from: a */
    public static int f1108a = 1000;

    /* renamed from: b */
    public static C1145c f1109b;

    /* renamed from: c */
    public static String f1110c;

    /* renamed from: d */
    public final List<AbstractC1081a> f1111d;

    /* renamed from: h */
    public Context f1115h;

    /* renamed from: g */
    public StrategyBean f1114g = null;

    /* renamed from: f */
    public final StrategyBean f1113f = new StrategyBean();

    /* renamed from: e */
    public final C1198W f1112e = C1198W.m3089c();

    public C1145c(Context context, List<AbstractC1081a> list) {
        this.f1115h = context;
        m3351a(context);
        this.f1111d = list;
    }

    /* renamed from: a */
    public static synchronized C1145c m3350a(Context context, List<AbstractC1081a> list) {
        C1145c c1145c;
        synchronized (C1145c.class) {
            if (f1109b == null) {
                f1109b = new C1145c(context, list);
            }
            c1145c = f1109b;
        }
        return c1145c;
    }

    /* renamed from: a */
    public static void m3351a(Context context) {
        String str;
        if (C1140a.m3421a(context) != null) {
            String str2 = C1140a.m3421a(context).f1040fa;
            if ("oversea".equals(str2)) {
                str = "https://astat.bugly.qcloud.com/rqd/async";
            } else if (!"na_https".equals(str2)) {
                return;
            } else {
                str = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
            StrategyBean.f1084a = str;
            StrategyBean.f1085b = str;
        }
    }

    /* renamed from: a */
    public static void m3345a(String str) {
        if (C1208ca.m3012b(str) || !C1208ca.m3006c(str)) {
            C1199X.m3076e("URL user set is invalid.", new Object[0]);
        } else {
            f1110c = str;
        }
    }

    /* renamed from: b */
    public static synchronized C1145c m3344b() {
        C1145c c1145c;
        synchronized (C1145c.class) {
            c1145c = f1109b;
        }
        return c1145c;
    }

    /* renamed from: a */
    public void m3352a(long j) {
        this.f1112e.m3091a(new C1144b(this), j);
    }

    /* renamed from: a */
    public void m3349a(StrategyBean strategyBean, boolean z) {
        C1199X.m3084a("[Strategy] Notify %s", C1138f.class.getName());
        C1138f.m3460a(strategyBean, z);
        for (AbstractC1081a abstractC1081a : this.f1111d) {
            try {
                C1199X.m3084a("[Strategy] Notify %s", abstractC1081a.getClass().getName());
                abstractC1081a.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!C1199X.m3080b(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public void m3346a(C1241sa c1241sa) {
        if (c1241sa == null) {
            return;
        }
        StrategyBean strategyBean = this.f1114g;
        if (strategyBean != null && c1241sa.f1633k == strategyBean.f1098o) {
            return;
        }
        StrategyBean strategyBean2 = new StrategyBean();
        strategyBean2.f1089f = c1241sa.f1626d;
        strategyBean2.f1091h = c1241sa.f1628f;
        strategyBean2.f1090g = c1241sa.f1627e;
        if (C1208ca.m3012b(f1110c) || !C1208ca.m3006c(f1110c)) {
            if (C1208ca.m3006c(c1241sa.f1629g)) {
                C1199X.m3084a("[Strategy] Upload url changes to %s", c1241sa.f1629g);
                strategyBean2.f1100q = c1241sa.f1629g;
            }
            if (C1208ca.m3006c(c1241sa.f1630h)) {
                C1199X.m3084a("[Strategy] Exception upload url changes to %s", c1241sa.f1630h);
                strategyBean2.f1101r = c1241sa.f1630h;
            }
        }
        C1239ra c1239ra = c1241sa.f1631i;
        if (c1239ra != null && !C1208ca.m3012b(c1239ra.f1620a)) {
            strategyBean2.f1102s = c1241sa.f1631i.f1620a;
        }
        long j = c1241sa.f1633k;
        if (j != 0) {
            strategyBean2.f1098o = j;
        }
        Map<String, String> map = c1241sa.f1632j;
        if (map != null && map.size() > 0) {
            Map<String, String> map2 = c1241sa.f1632j;
            strategyBean2.f1103t = map2;
            String str = map2.get("B11");
            if (str == null || !str.equals("1")) {
                strategyBean2.f1092i = false;
            } else {
                strategyBean2.f1092i = true;
            }
            String str2 = c1241sa.f1632j.get("B3");
            if (str2 != null) {
                strategyBean2.f1106w = Long.valueOf(str2).longValue();
            }
            long j2 = c1241sa.f1637o;
            strategyBean2.f1099p = j2;
            strategyBean2.f1105v = j2;
            String str3 = c1241sa.f1632j.get("B27");
            if (str3 != null && str3.length() > 0) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    if (parseInt > 0) {
                        strategyBean2.f1104u = parseInt;
                    }
                } catch (Exception e) {
                    if (!C1199X.m3080b(e)) {
                        e.printStackTrace();
                    }
                }
            }
            String str4 = c1241sa.f1632j.get("B25");
            if (str4 == null || !str4.equals("1")) {
                strategyBean2.f1094k = false;
            } else {
                strategyBean2.f1094k = true;
            }
        }
        C1199X.m3078c("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f1089f), Boolean.valueOf(strategyBean2.f1091h), Boolean.valueOf(strategyBean2.f1090g), Boolean.valueOf(strategyBean2.f1092i), Boolean.valueOf(strategyBean2.f1093j), Boolean.valueOf(strategyBean2.f1096m), Boolean.valueOf(strategyBean2.f1097n), Long.valueOf(strategyBean2.f1099p), Boolean.valueOf(strategyBean2.f1094k), Long.valueOf(strategyBean2.f1098o));
        this.f1114g = strategyBean2;
        if (!C1208ca.m3006c(c1241sa.f1629g)) {
            C1199X.m3084a("[Strategy] download url is null", new Object[0]);
            this.f1114g.f1100q = "";
        }
        if (!C1208ca.m3006c(c1241sa.f1630h)) {
            C1199X.m3084a("[Strategy] download crashurl is null", new Object[0]);
            this.f1114g.f1101r = "";
        }
        C1185J.m3172a().m3148b(2);
        C1188L c1188l = new C1188L();
        c1188l.f1399b = 2;
        c1188l.f1398a = strategyBean2.f1087d;
        c1188l.f1402e = strategyBean2.f1088e;
        c1188l.f1404g = C1208ca.m3036a(strategyBean2);
        C1185J.m3172a().m3144c(c1188l);
        m3349a(strategyBean2, true);
    }

    /* renamed from: c */
    public StrategyBean m3342c() {
        StrategyBean strategyBean = this.f1114g;
        if (strategyBean != null) {
            if (!C1208ca.m3006c(strategyBean.f1100q)) {
                this.f1114g.f1100q = StrategyBean.f1084a;
            }
            if (!C1208ca.m3006c(this.f1114g.f1101r)) {
                this.f1114g.f1101r = StrategyBean.f1085b;
            }
            return this.f1114g;
        }
        if (!C1208ca.m3012b(f1110c) && C1208ca.m3006c(f1110c)) {
            StrategyBean strategyBean2 = this.f1113f;
            String str = f1110c;
            strategyBean2.f1100q = str;
            strategyBean2.f1101r = str;
        }
        return this.f1113f;
    }

    /* renamed from: d */
    public synchronized boolean m3341d() {
        return this.f1114g != null;
    }

    /* renamed from: e */
    public StrategyBean m3340e() {
        byte[] bArr;
        List<C1188L> m3171a = C1185J.m3172a().m3171a(2);
        if (m3171a == null || m3171a.size() <= 0 || (bArr = m3171a.get(0).f1404g) == null) {
            return null;
        }
        return (StrategyBean) C1208ca.m3019a(bArr, StrategyBean.CREATOR);
    }
}
