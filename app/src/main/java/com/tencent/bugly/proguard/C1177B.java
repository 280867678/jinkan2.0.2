package com.tencent.bugly.proguard;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatJellybean;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.B */
/* loaded from: classes3.dex */
public final class C1177B extends AbstractC1228m implements Cloneable {

    /* renamed from: a */
    public static C1249y f1323a;

    /* renamed from: b */
    public static C1248x f1324b;

    /* renamed from: c */
    public static C1248x f1325c;

    /* renamed from: d */
    public static Map<String, String> f1326d;

    /* renamed from: e */
    public static final /* synthetic */ boolean f1327e = !C1177B.class.desiredAssertionStatus();

    /* renamed from: f */
    public String f1328f;

    /* renamed from: g */
    public String f1329g;

    /* renamed from: h */
    public long f1330h;

    /* renamed from: i */
    public int f1331i;

    /* renamed from: j */
    public C1249y f1332j;

    /* renamed from: k */
    public C1248x f1333k;

    /* renamed from: l */
    public byte f1334l;

    /* renamed from: m */
    public int f1335m;

    /* renamed from: n */
    public long f1336n;

    /* renamed from: o */
    public C1248x f1337o;

    /* renamed from: p */
    public String f1338p;

    /* renamed from: q */
    public Map<String, String> f1339q;

    /* renamed from: r */
    public String f1340r;

    /* renamed from: s */
    public int f1341s;

    /* renamed from: t */
    public long f1342t;

    /* renamed from: u */
    public int f1343u;

    public C1177B() {
        this.f1328f = "";
        this.f1329g = "";
        this.f1330h = 0L;
        this.f1331i = 0;
        this.f1332j = null;
        this.f1333k = null;
        this.f1334l = (byte) 0;
        this.f1335m = 0;
        this.f1336n = 0L;
        this.f1337o = null;
        this.f1338p = "";
        this.f1339q = null;
        this.f1340r = "";
        this.f1341s = 0;
        this.f1342t = 0L;
        this.f1343u = 0;
    }

    public C1177B(String str, String str2, long j, int i, C1249y c1249y, C1248x c1248x, byte b, int i2, long j2, C1248x c1248x2, String str3, Map<String, String> map, String str4, int i3, long j3, int i4) {
        this.f1328f = "";
        this.f1329g = "";
        this.f1330h = 0L;
        this.f1331i = 0;
        this.f1332j = null;
        this.f1333k = null;
        this.f1334l = (byte) 0;
        this.f1335m = 0;
        this.f1336n = 0L;
        this.f1337o = null;
        this.f1338p = "";
        this.f1339q = null;
        this.f1340r = "";
        this.f1341s = 0;
        this.f1342t = 0L;
        this.f1343u = 0;
        this.f1328f = str;
        this.f1329g = str2;
        this.f1330h = j;
        this.f1331i = i;
        this.f1332j = c1249y;
        this.f1333k = c1248x;
        this.f1334l = b;
        this.f1335m = i2;
        this.f1336n = j2;
        this.f1337o = c1248x2;
        this.f1338p = str3;
        this.f1339q = map;
        this.f1340r = str4;
        this.f1341s = i3;
        this.f1342t = j3;
        this.f1343u = i4;
    }

    /* renamed from: a */
    public C1248x m3190a() {
        return this.f1333k;
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        this.f1328f = c1223k.m2937a(0, true);
        this.f1329g = c1223k.m2937a(1, true);
        this.f1330h = c1223k.m2936a(this.f1330h, 2, true);
        this.f1331i = c1223k.m2938a(this.f1331i, 3, true);
        if (f1323a == null) {
            f1323a = new C1249y();
        }
        this.f1332j = (C1249y) c1223k.m2933a((AbstractC1228m) f1323a, 4, true);
        if (f1324b == null) {
            f1324b = new C1248x();
        }
        this.f1333k = (C1248x) c1223k.m2933a((AbstractC1228m) f1324b, 5, true);
        this.f1334l = c1223k.m2942a(this.f1334l, 6, true);
        this.f1335m = c1223k.m2938a(this.f1335m, 7, false);
        this.f1336n = c1223k.m2936a(this.f1336n, 8, false);
        if (f1325c == null) {
            f1325c = new C1248x();
        }
        this.f1337o = (C1248x) c1223k.m2933a((AbstractC1228m) f1325c, 9, false);
        this.f1338p = c1223k.m2937a(10, false);
        if (f1326d == null) {
            HashMap hashMap = new HashMap();
            f1326d = hashMap;
            hashMap.put("", "");
        }
        this.f1339q = (Map) c1223k.m2932a((C1223k) f1326d, 11, false);
        this.f1340r = c1223k.m2937a(12, false);
        this.f1341s = c1223k.m2938a(this.f1341s, 13, false);
        this.f1342t = c1223k.m2936a(this.f1342t, 14, false);
        this.f1343u = c1223k.m2938a(this.f1343u, 15, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2902a(this.f1328f, 0);
        c1226l.m2902a(this.f1329g, 1);
        c1226l.m2906a(this.f1330h, 2);
        c1226l.m2907a(this.f1331i, 3);
        c1226l.m2905a((AbstractC1228m) this.f1332j, 4);
        c1226l.m2905a((AbstractC1228m) this.f1333k, 5);
        c1226l.m2911a(this.f1334l, 6);
        c1226l.m2907a(this.f1335m, 7);
        c1226l.m2906a(this.f1336n, 8);
        C1248x c1248x = this.f1337o;
        if (c1248x != null) {
            c1226l.m2905a((AbstractC1228m) c1248x, 9);
        }
        String str = this.f1338p;
        if (str != null) {
            c1226l.m2902a(str, 10);
        }
        Map<String, String> map = this.f1339q;
        if (map != null) {
            c1226l.m2900a((Map) map, 11);
        }
        String str2 = this.f1340r;
        if (str2 != null) {
            c1226l.m2902a(str2, 12);
        }
        c1226l.m2907a(this.f1341s, 13);
        c1226l.m2906a(this.f1342t, 14);
        c1226l.m2907a(this.f1343u, 15);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2855a(StringBuilder sb, int i) {
        C1219i c1219i = new C1219i(sb, i);
        c1219i.m2958a(this.f1328f, NotificationCompatJellybean.KEY_TITLE);
        c1219i.m2958a(this.f1329g, "newFeature");
        c1219i.m2962a(this.f1330h, "publishTime");
        c1219i.m2963a(this.f1331i, "publishType");
        c1219i.m2961a((AbstractC1228m) this.f1332j, "appBasicInfo");
        c1219i.m2961a((AbstractC1228m) this.f1333k, "apkBaseInfo");
        c1219i.m2967a(this.f1334l, "updateStrategy");
        c1219i.m2963a(this.f1335m, "popTimes");
        c1219i.m2962a(this.f1336n, "popInterval");
        c1219i.m2961a((AbstractC1228m) this.f1337o, "diffApkInfo");
        c1219i.m2958a(this.f1338p, "netType");
        c1219i.m2956a((Map) this.f1339q, "reserved");
        c1219i.m2958a(this.f1340r, "strategyId");
        c1219i.m2963a(this.f1341s, NotificationCompat.CATEGORY_STATUS);
        c1219i.m2962a(this.f1342t, "updateTime");
        c1219i.m2963a(this.f1343u, "updateType");
    }

    /* renamed from: b */
    public long m3189b() {
        return this.f1330h;
    }

    /* renamed from: c */
    public Map<String, String> m3188c() {
        return this.f1339q;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (!f1327e) {
                throw new AssertionError();
            }
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C1177B c1177b = (C1177B) obj;
        return C1230n.m2884a(this.f1328f, c1177b.f1328f) && C1230n.m2884a(this.f1329g, c1177b.f1329g) && C1230n.m2885a(this.f1330h, c1177b.f1330h) && C1230n.m2886a(this.f1331i, c1177b.f1331i) && C1230n.m2884a(this.f1332j, c1177b.f1332j) && C1230n.m2884a(this.f1333k, c1177b.f1333k) && C1230n.m2887a(this.f1334l, c1177b.f1334l) && C1230n.m2886a(this.f1335m, c1177b.f1335m) && C1230n.m2885a(this.f1336n, c1177b.f1336n) && C1230n.m2884a(this.f1337o, c1177b.f1337o) && C1230n.m2884a(this.f1338p, c1177b.f1338p) && C1230n.m2884a(this.f1339q, c1177b.f1339q) && C1230n.m2884a(this.f1340r, c1177b.f1340r) && C1230n.m2886a(this.f1341s, c1177b.f1341s) && C1230n.m2885a(this.f1342t, c1177b.f1342t) && C1230n.m2886a(this.f1343u, c1177b.f1343u);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
