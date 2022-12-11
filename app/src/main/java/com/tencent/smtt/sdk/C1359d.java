package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsPrivacyAccess;
import com.tencent.smtt.sdk.p044a.C1345a;
import com.tencent.smtt.sdk.p044a.C1346b;
import com.tencent.smtt.sdk.p044a.C1347c;
import com.tencent.smtt.sdk.p044a.C1348d;
import com.tencent.smtt.sdk.p044a.C1349e;
import com.tencent.smtt.sdk.p044a.C1354g;
import com.tencent.smtt.utils.C1429b;
import com.tencent.smtt.utils.C1467n;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.tencent.smtt.sdk.d */
/* loaded from: classes4.dex */
public class C1359d {

    /* renamed from: a */
    public static String f2095a = "EmergencyManager";

    /* renamed from: b */
    public static int f2096b = 0;

    /* renamed from: c */
    public static int f2097c = 1;

    /* renamed from: d */
    public static int f2098d = 2;

    /* renamed from: e */
    public static int f2099e = 3;

    /* renamed from: f */
    public static int f2100f = 4;

    /* renamed from: g */
    public static int f2101g = 5;

    /* renamed from: h */
    public static C1359d f2102h;

    /* renamed from: i */
    public long f2103i = 60000;

    /* renamed from: j */
    public long f2104j = 86400000;

    /* renamed from: k */
    public boolean f2105k = false;

    /* renamed from: a */
    public static synchronized C1359d m2614a() {
        C1359d c1359d;
        synchronized (C1359d.class) {
            if (f2102h == null) {
                f2102h = new C1359d();
            }
            c1359d = f2102h;
        }
        return c1359d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2612a(Context context, int i, List<C1346b> list) {
        String str;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C1354g m2632a = C1354g.m2632a();
        List<String> m2630a = m2632a.m2630a(context, "emergence_ids");
        HashSet hashSet = new HashSet();
        if (m2630a != null && !m2630a.isEmpty()) {
            for (String str3 : m2630a) {
                String[] m2626a = C1354g.m2626a(str3);
                if (m2626a != null && m2626a.length == 4) {
                    hashSet.add(Integer.valueOf(Integer.parseInt(m2626a[0])));
                }
            }
        }
        for (C1346b c1346b : list) {
            int m2658b = c1346b.m2658b();
            int m2660a = c1346b.m2660a();
            if (hashSet.contains(Integer.valueOf(m2660a))) {
                str = f2095a;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Command has been executed: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(c1346b.toString());
                str2 = ", ignored";
            } else if (c1346b.m2655e()) {
                str = f2095a;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Command is out of date: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(c1346b.toString());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", now: ");
                str2 = C1345a.m2661a(System.currentTimeMillis());
            } else {
                linkedHashMap.put(Integer.valueOf(m2658b), c1346b.m2657c());
                m2632a.m2628a(context, "emergence_ids", C1354g.m2625a(new String[]{String.valueOf(m2660a), String.valueOf(c1346b.m2658b()), String.valueOf(c1346b.m2657c()), String.valueOf(c1346b.m2656d())}));
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str2);
            TbsLog.m2161d(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        m2611a(context, Integer.valueOf(i), linkedHashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0055, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0036, code lost:
        if (r1 == 0) goto L5;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m2608b(final Context context) {
        int i;
        String[] m2626a;
        C1347c c1347c = new C1347c();
        c1347c.m2652a(C1429b.m2129a(context));
        c1347c.m2649b(C1429b.m2117d(context));
        if (TbsPrivacyAccess.AndroidVersion.isEnabled()) {
            i = C1429b.m2120b(context);
        } else {
            try {
                i = Integer.parseInt(TbsPrivacyAccess.getConfigurePrivacy(context, TbsPrivacyAccess.ConfigurablePrivacy.ANDROID_VERSION, "0"));
            } catch (Throwable unused) {
                i = 0;
            }
        }
        c1347c.m2653a(Integer.valueOf(i));
        String configurePrivacy = TbsPrivacyAccess.DeviceModel.isEnabled() ? C1429b.m2118c(context) : TbsPrivacyAccess.getConfigurePrivacy(context, TbsPrivacyAccess.ConfigurablePrivacy.DEVICE_MODEL, "");
        c1347c.m2647c(configurePrivacy);
        c1347c.m2646d("x5webview");
        c1347c.m2650b(Integer.valueOf(QbSdk.getTbsSdkVersion()));
        c1347c.m2648c(Integer.valueOf(QbSdk.getTbsVersion(context)));
        ArrayList arrayList = new ArrayList();
        for (String str : C1354g.m2632a().m2630a(context, "emergence_ids")) {
            try {
                if (!TextUtils.isEmpty(str) && (m2626a = C1354g.m2626a(str)) != null && m2626a.length == 4) {
                    int parseInt = Integer.parseInt(m2626a[0]);
                    if (System.currentTimeMillis() < Long.parseLong(m2626a[3])) {
                        arrayList.add(Integer.valueOf(parseInt));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        c1347c.m2651a(arrayList);
        new C1349e(context, C1467n.m2018a(context).m2009j(), c1347c.m2654a()).m2640a(new C1349e.AbstractC1352a() { // from class: com.tencent.smtt.sdk.d.1
            @Override // com.tencent.smtt.sdk.p044a.C1349e.AbstractC1352a
            /* renamed from: a */
            public void mo2605a(String str2) {
                C1359d c1359d;
                Context context2;
                int i2;
                ArrayList arrayList2;
                C1348d m2644a = C1348d.m2644a(str2);
                if (m2644a == null || m2644a.m2645a() != 0) {
                    c1359d = C1359d.this;
                    context2 = context;
                    i2 = C1359d.f2099e;
                    arrayList2 = new ArrayList();
                } else {
                    C1354g.m2632a().m2629a(context, "emergence_req_interval", m2644a.m2643b());
                    List<C1346b> m2642c = m2644a.m2642c();
                    if (m2642c != null) {
                        C1359d.this.m2612a(context, C1359d.f2096b, m2642c);
                        return;
                    }
                    c1359d = C1359d.this;
                    context2 = context;
                    i2 = C1359d.f2098d;
                    arrayList2 = new ArrayList();
                }
                c1359d.m2612a(context2, i2, arrayList2);
            }
        });
    }

    /* renamed from: a */
    public void m2613a(Context context) {
        if (!this.f2105k) {
            this.f2105k = true;
            C1354g m2632a = C1354g.m2632a();
            if (m2632a.m2624b()) {
                m2612a(context, f2100f, new ArrayList());
                return;
            }
            m2632a.m2631a(context);
            try {
                try {
                    long m2622b = C1354g.m2632a().m2622b(context, "emergence_timestamp");
                    long m2622b2 = C1354g.m2632a().m2622b(context, "emergence_req_interval");
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - m2622b;
                    long min = Math.min(Math.max(this.f2103i, m2622b2), this.f2104j);
                    if (j > min) {
                        String str = f2095a;
                        TbsLog.m2161d(str, "Emergency configuration is out of date, attempt to query again, " + (j / 1000) + " seconds has past");
                        C1354g.m2632a().m2629a(context, "emergence_timestamp", currentTimeMillis);
                        m2608b(context);
                    } else {
                        m2612a(context, f2097c, new ArrayList());
                        String str2 = f2095a;
                        TbsLog.m2161d(str2, "Emergency configuration is up to date, " + (j / 1000) + " seconds has past, need " + (Math.abs(j - min) / 1000) + " more seconds for an another request");
                    }
                } catch (Exception e) {
                    m2612a(context, f2101g, new ArrayList());
                    String str3 = f2095a;
                    TbsLog.m2161d(str3, "Unexpected exception happened when query emergency configuration: " + e.getMessage());
                }
            } finally {
                C1354g.m2632a().m2621c();
            }
        }
    }

    /* renamed from: a */
    public void m2611a(Context context, Integer num, Map<Integer, String> map) {
        C1414v m2601a;
        C1356c.m2620a().m2615b(context);
        TbsLog.m2158e(f2095a, "Dispatch emergency commands on tbs extension");
        QbSdk.m2834a(context, num, map);
        C1363g m2597a = C1363g.m2597a(true);
        if (m2597a == null || (m2601a = m2597a.m2601a()) == null) {
            return;
        }
        DexLoader m2302b = m2601a.m2302b();
        if (m2302b == null) {
            TbsLog.m2158e(f2095a, "Dex loader is null, cancel commands dispatching of tbs shell");
            return;
        }
        TbsLog.m2158e(f2095a, "Dispatch emergency commands on tbs shell");
        m2302b.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "dispatchEmergencyCommand", new Class[]{Integer.class, Map.class}, num, map);
    }
}
