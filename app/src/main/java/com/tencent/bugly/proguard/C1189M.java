package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.AbstractC1081a;
import com.tencent.bugly.C1082b;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.info.C1141b;
import com.tencent.bugly.crashreport.common.strategy.C1145c;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.proguard.M */
/* loaded from: classes3.dex */
public class C1189M {
    /* renamed from: a */
    public static <T extends AbstractC1228m> T m3130a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                C1223k c1223k = new C1223k(bArr);
                c1223k.m2931a("utf-8");
                newInstance.mo2857a(c1223k);
                return newInstance;
            } catch (Throwable th) {
                if (!C1199X.m3083a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C1235pa m3136a(Context context, int i, byte[] bArr) {
        C1140a m3394m = C1140a.m3394m();
        StrategyBean m3342c = C1145c.m3344b().m3342c();
        if (m3394m == null || m3342c == null) {
            C1199X.m3081b("Can not create request pkg for parameters is invalid.", new Object[0]);
            return null;
        }
        try {
            C1235pa c1235pa = new C1235pa();
            synchronized (m3394m) {
                c1235pa.f1575c = m3394m.f1039f;
                c1235pa.f1576d = m3394m.m3405e();
                c1235pa.f1577e = m3394m.f1041g;
                c1235pa.f1578f = m3394m.f1008E;
                c1235pa.f1579g = m3394m.f1012I;
                c1235pa.f1580h = m3394m.f1051l;
                c1235pa.f1581i = i;
                if (bArr == null) {
                    bArr = "".getBytes();
                }
                c1235pa.f1582j = bArr;
                c1235pa.f1583k = m3394m.f1057o;
                c1235pa.f1584l = m3394m.f1059p;
                c1235pa.f1585m = new HashMap();
                c1235pa.f1586n = m3394m.m3386u();
                c1235pa.f1587o = m3342c.f1098o;
                c1235pa.f1589q = m3394m.m3395l();
                c1235pa.f1590r = C1141b.m3374c(context);
                c1235pa.f1591s = System.currentTimeMillis();
                c1235pa.f1593u = m3394m.m3390q();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(m3394m.m3395l());
                c1235pa.f1596x = sb.toString();
                c1235pa.f1597y = c1235pa.f1590r;
                m3394m.getClass();
                c1235pa.f1588p = "com.tencent.bugly";
                Map<String, String> map = c1235pa.f1585m;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(m3394m.m3389r());
                map.put("A26", sb2.toString());
                Map<String, String> map2 = c1235pa.f1585m;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(m3394m.m3426D());
                map2.put("A62", sb3.toString());
                Map<String, String> map3 = c1235pa.f1585m;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append(m3394m.m3428B());
                map3.put("A63", sb4.toString());
                Map<String, String> map4 = c1235pa.f1585m;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                sb5.append(m3394m.f1044ha);
                map4.put("F11", sb5.toString());
                Map<String, String> map5 = c1235pa.f1585m;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("");
                sb6.append(m3394m.f1042ga);
                map5.put("F12", sb6.toString());
                Map<String, String> map6 = c1235pa.f1585m;
                StringBuilder sb7 = new StringBuilder();
                sb7.append("");
                sb7.append(m3394m.f1010G);
                map6.put("D3", sb7.toString());
                if (C1082b.f702b != null) {
                    for (AbstractC1081a abstractC1081a : C1082b.f702b) {
                        if (abstractC1081a.versionKey != null && abstractC1081a.version != null) {
                            c1235pa.f1585m.put(abstractC1081a.versionKey, abstractC1081a.version);
                        }
                    }
                }
                c1235pa.f1585m.put("G15", C1208ca.m3011b("G15", ""));
                c1235pa.f1585m.put("D4", C1208ca.m3011b("D4", "0"));
            }
            Map<String, String> m3403f = m3394m.m3403f();
            if (m3403f != null) {
                for (Map.Entry<String, String> entry : m3403f.entrySet()) {
                    c1235pa.f1585m.put(entry.getKey(), entry.getValue());
                }
            }
            return c1235pa;
        } catch (Throwable th) {
            if (!C1199X.m3083a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static C1237qa m3131a(byte[] bArr, StrategyBean strategyBean, boolean z) {
        if (bArr != null) {
            try {
                C1211e c1211e = new C1211e();
                c1211e.mo2991a();
                c1211e.mo3002a("utf-8");
                c1211e.m2986a(bArr);
                Object m3000b = c1211e.m3000b("detail", new C1237qa());
                if (!C1237qa.class.isInstance(m3000b)) {
                    return null;
                }
                return (C1237qa) C1237qa.class.cast(m3000b);
            } catch (Throwable th) {
                if (!C1199X.m3083a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C1243ta m3135a(UserInfoBean userInfoBean, C1140a c1140a) {
        if (userInfoBean == null) {
            return null;
        }
        C1243ta c1243ta = new C1243ta();
        c1243ta.f1639b = userInfoBean.f954e;
        c1243ta.f1643f = userInfoBean.f959j;
        c1243ta.f1642e = userInfoBean.f952c;
        c1243ta.f1641d = userInfoBean.f953d;
        c1243ta.f1646i = userInfoBean.f964o == 1;
        int i = userInfoBean.f951b;
        if (i == 1) {
            c1243ta.f1640c = (byte) 1;
        } else if (i == 2) {
            c1243ta.f1640c = (byte) 4;
        } else if (i == 3) {
            c1243ta.f1640c = (byte) 2;
        } else if (i == 4) {
            c1243ta.f1640c = (byte) 3;
        } else if (i < 10 || i >= 20) {
            C1199X.m3081b("unknown uinfo type %d ", Integer.valueOf(userInfoBean.f951b));
            return null;
        } else {
            c1243ta.f1640c = (byte) i;
        }
        HashMap hashMap = new HashMap();
        c1243ta.f1644g = hashMap;
        if (userInfoBean.f965p >= 0) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(userInfoBean.f965p);
            hashMap.put("C01", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        if (userInfoBean.f966q >= 0) {
            Map<String, String> map = c1243ta.f1644g;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(userInfoBean.f966q);
            map.put("C02", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        Map<String, String> map2 = userInfoBean.f967r;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.f967r.entrySet()) {
                Map<String, String> map3 = c1243ta.f1644g;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("C03_");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(entry.getKey());
                map3.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), entry.getValue());
            }
        }
        Map<String, String> map4 = userInfoBean.f968s;
        if (map4 != null && map4.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.f968s.entrySet()) {
                Map<String, String> map5 = c1243ta.f1644g;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("C04_");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(entry2.getKey());
                map5.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString(), entry2.getValue());
            }
        }
        Map<String, String> map6 = c1243ta.f1644g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(!userInfoBean.f961l);
        map6.put("A36", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
        Map<String, String> map7 = c1243ta.f1644g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append(userInfoBean.f956g);
        map7.put("F02", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.toString());
        Map<String, String> map8 = c1243ta.f1644g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.append(userInfoBean.f957h);
        map8.put("F03", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.toString());
        Map<String, String> map9 = c1243ta.f1644g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.append(userInfoBean.f959j);
        map9.put("F04", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.toString());
        Map<String, String> map10 = c1243ta.f1644g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.append(userInfoBean.f958i);
        map10.put("F05", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.toString());
        Map<String, String> map11 = c1243ta.f1644g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10.append(userInfoBean.f962m);
        map11.put("F06", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10.toString());
        Map<String, String> map12 = c1243ta.f1644g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11.append(userInfoBean.f960k);
        map12.put("F10", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11.toString());
        C1199X.m3084a("summary type %d vm:%d", Byte.valueOf(c1243ta.f1640c), Integer.valueOf(c1243ta.f1644g.size()));
        return c1243ta;
    }

    /* renamed from: a */
    public static C1245ua m3132a(List<UserInfoBean> list, int i) {
        C1140a m3394m;
        if (list == null || list.size() == 0 || (m3394m = C1140a.m3394m()) == null) {
            return null;
        }
        m3394m.m3425E();
        C1245ua c1245ua = new C1245ua();
        c1245ua.f1651d = m3394m.f1043h;
        c1245ua.f1652e = m3394m.m3395l();
        ArrayList<C1243ta> arrayList = new ArrayList<>();
        for (UserInfoBean userInfoBean : list) {
            C1243ta m3135a = m3135a(userInfoBean, m3394m);
            if (m3135a != null) {
                arrayList.add(m3135a);
            }
        }
        c1245ua.f1653f = arrayList;
        HashMap hashMap = new HashMap();
        c1245ua.f1654g = hashMap;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(m3394m.f1055n);
        hashMap.put("A7", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        Map<String, String> map = c1245ua.f1654g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(m3394m.m3397j());
        map.put("A6", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        Map<String, String> map2 = c1245ua.f1654g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(m3394m.m3396k());
        map2.put("A5", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
        Map<String, String> map3 = c1245ua.f1654g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(m3394m.m3385v());
        map3.put("A2", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
        Map<String, String> map4 = c1245ua.f1654g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(m3394m.m3385v());
        map4.put("A1", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
        Map<String, String> map5 = c1245ua.f1654g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append(m3394m.f1059p);
        map5.put("A24", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.toString());
        Map<String, String> map6 = c1245ua.f1654g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.append(m3394m.m3383x());
        map6.put("A17", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.toString());
        Map<String, String> map7 = c1245ua.f1654g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.append(m3394m.m3398i());
        map7.put("A15", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.toString());
        Map<String, String> map8 = c1245ua.f1654g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.append(m3394m.m3393n());
        map8.put("A13", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.toString());
        Map<String, String> map9 = c1245ua.f1654g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10.append(m3394m.f1034ca);
        map9.put("F08", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10.toString());
        Map<String, String> map10 = c1245ua.f1654g;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11.append(m3394m.f1036da);
        map10.put("F09", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11.toString());
        Map<String, String> m3401g = m3394m.m3401g();
        if (m3401g != null && m3401g.size() > 0) {
            for (Map.Entry<String, String> entry : m3401g.entrySet()) {
                Map<String, String> map11 = c1245ua.f1654g;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("C04_");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12.append(entry.getKey());
                map11.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12.toString(), entry.getValue());
            }
        }
        if (i == 1) {
            c1245ua.f1650c = (byte) 1;
        } else if (i != 2) {
            C1199X.m3081b("unknown up type %d ", Integer.valueOf(i));
            return null;
        } else {
            c1245ua.f1650c = (byte) 2;
        }
        return c1245ua;
    }

    /* renamed from: a */
    public static byte[] m3134a(AbstractC1228m abstractC1228m) {
        try {
            C1226l c1226l = new C1226l();
            c1226l.m2903a("utf-8");
            abstractC1228m.mo2856a(c1226l);
            return c1226l.m2889b();
        } catch (Throwable th) {
            if (C1199X.m3083a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m3133a(Object obj) {
        try {
            C1211e c1211e = new C1211e();
            c1211e.mo2991a();
            c1211e.mo3002a("utf-8");
            c1211e.m2990a(1);
            c1211e.m2983c("RqdServer");
            c1211e.m2984b("sync");
            c1211e.mo2987a("detail", (String) obj);
            return c1211e.m2985b();
        } catch (Throwable th) {
            if (C1199X.m3083a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
