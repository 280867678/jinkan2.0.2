package com.tencent.bugly.beta.upgrade;

import android.text.TextUtils;
import com.tencent.bugly.beta.global.C1089a;
import com.tencent.bugly.beta.global.C1093e;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.proguard.AbstractC1192P;
import com.tencent.bugly.proguard.AbstractC1228m;
import com.tencent.bugly.proguard.C1176A;
import com.tencent.bugly.proguard.C1189M;
import com.tencent.bugly.proguard.C1195T;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1235pa;
import com.tencent.bugly.proguard.C1250z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.beta.upgrade.b */
/* loaded from: classes3.dex */
public class C1117b {

    /* renamed from: a */
    public static C1117b f869a = new C1117b();

    /* renamed from: a */
    public synchronized void m3579a(int i, int i2, byte[] bArr, C1116a c1116a, boolean z, String str) {
        C1140a m3394m = C1140a.m3394m();
        try {
            try {
                C1235pa m3136a = C1189M.m3136a(C1093e.f737b.f789v, i, bArr);
                if (m3136a != null) {
                    C1093e c1093e = C1093e.f737b;
                    m3136a.f1576d = c1093e.f791x;
                    if (!TextUtils.isEmpty(c1093e.f755R)) {
                        m3136a.f1579g = c1093e.f755R;
                    }
                    if (m3136a.f1585m != null) {
                        m3136a.f1585m.put("G6", c1093e.f792y);
                        m3136a.f1585m.put("G10", "1.5.0");
                        Map<String, String> map = m3136a.f1585m;
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append(c1093e.f738A);
                        map.put("G3", sb.toString());
                        m3136a.f1585m.put("G11", String.valueOf(c1093e.f793z));
                        m3136a.f1585m.put("G2", String.valueOf(C1089a.m3626a(C1093e.f737b.f789v)));
                        m3136a.f1585m.put("G12", String.valueOf(c1093e.f785r < 0 ? 0 : c1093e.f785r));
                        Map<String, String> map2 = m3136a.f1585m;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("");
                        sb2.append(m3394m.m3382y());
                        map2.put("A21", sb2.toString());
                        Map<String, String> map3 = m3136a.f1585m;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("");
                        sb3.append(m3394m.m3395l());
                        map3.put("A22", sb3.toString());
                        Map<String, String> map4 = m3136a.f1585m;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("");
                        sb4.append(c1093e.f749L);
                        map4.put("G13", sb4.toString());
                        Map<String, String> map5 = m3136a.f1585m;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("");
                        sb5.append(c1093e.f750M);
                        map5.put("G14", sb5.toString());
                        Map<String, String> map6 = m3136a.f1585m;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("");
                        sb6.append(c1093e.f752O);
                        map6.put("G15", sb6.toString());
                        Map<String, String> map7 = m3136a.f1585m;
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("");
                        sb7.append(m3394m.m3393n());
                        map7.put("G17", sb7.toString());
                        Map<String, String> map8 = m3136a.f1585m;
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("");
                        sb8.append(m3394m.m3429A());
                        map8.put("C01", sb8.toString());
                        Map<String, String> map9 = m3136a.f1585m;
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append("");
                        sb9.append(m3394m.m3382y());
                        map9.put("G18", sb9.toString());
                        Map<String, String> map10 = m3136a.f1585m;
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append("");
                        sb10.append(i2);
                        map10.put("strategyType", sb10.toString());
                        Map<String, String> map11 = m3136a.f1585m;
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append("");
                        sb11.append(z);
                        map11.put("strategyRequestManner", sb11.toString());
                        Map<String, String> m3399h = m3394m.m3399h();
                        if (m3399h != null && m3399h.size() > 0) {
                            for (Map.Entry<String, String> entry : m3399h.entrySet()) {
                                Map<String, String> map12 = m3136a.f1585m;
                                StringBuilder sb12 = new StringBuilder();
                                sb12.append("C03_");
                                sb12.append(entry.getKey());
                                map12.put(sb12.toString(), entry.getValue());
                            }
                        }
                        C1199X.m3084a("app version is: [%s.%s], [deviceId:%s], channel: [%s], buildNo: [%s], base tinkerId:[%s], patch tinkerId:[%s], patch version:[%s], strategyType:[%s]", c1093e.f738A, Integer.valueOf(c1093e.f793z), m3394m.m3395l(), m3136a.f1579g, Integer.valueOf(c1093e.f785r), c1093e.f749L, c1093e.f750M, c1093e.f752O, Integer.valueOf(i2));
                        HashMap hashMap = new HashMap();
                        StringBuilder sb13 = new StringBuilder();
                        sb13.append(C1093e.f737b.f745H.f864b);
                        sb13.append("");
                        hashMap.put("grayStrategyUpdateTime", sb13.toString());
                        if (z) {
                            C1195T.m3119a().m3117a(1002, m3136a.f1581i, C1189M.m3133a((Object) m3136a), str, str, c1116a, 0, 1, true, hashMap);
                        } else {
                            C1195T.m3119a().m3115a(1002, m3136a.f1581i, C1189M.m3133a((Object) m3136a), str, str, (AbstractC1192P) c1116a, false, (Map<String, String>) hashMap);
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (!C1199X.m3080b(th)) {
                    th.printStackTrace();
                }
                c1116a.mo3120a(i, null, 0L, 0L, false, "sendRequest failed");
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public synchronized void m3578a(C1176A c1176a, boolean z) {
        if (c1176a == null) {
            return;
        }
        try {
            m3579a(803, -1, C1189M.m3134a((AbstractC1228m) c1176a), new C1116a(2, 803, c1176a, Boolean.valueOf(z)), false, C1093e.f737b.f745H.f863a.f1629g);
        } catch (Throwable th) {
            if (!C1199X.m3083a(th)) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public synchronized void m3577a(C1250z c1250z, boolean z) {
        if (c1250z == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(c1250z);
        C1176A c1176a = new C1176A(arrayList);
        m3579a(803, -1, C1189M.m3134a((AbstractC1228m) c1176a), new C1116a(2, 803, c1176a, Boolean.valueOf(z)), false, C1093e.f737b.f745H.f863a.f1629g);
    }
}
