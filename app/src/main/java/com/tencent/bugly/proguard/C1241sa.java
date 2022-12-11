package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.sa */
/* loaded from: classes3.dex */
public final class C1241sa extends AbstractC1228m implements Cloneable {

    /* renamed from: b */
    public static Map<String, String> f1624b;

    /* renamed from: d */
    public boolean f1626d = true;

    /* renamed from: e */
    public boolean f1627e = true;

    /* renamed from: f */
    public boolean f1628f = true;

    /* renamed from: g */
    public String f1629g = "";

    /* renamed from: h */
    public String f1630h = "";

    /* renamed from: i */
    public C1239ra f1631i = null;

    /* renamed from: j */
    public Map<String, String> f1632j = null;

    /* renamed from: k */
    public long f1633k = 0;

    /* renamed from: l */
    public String f1634l = "";

    /* renamed from: m */
    public String f1635m = "";

    /* renamed from: n */
    public int f1636n = 0;

    /* renamed from: o */
    public int f1637o = 0;

    /* renamed from: c */
    public static final /* synthetic */ boolean f1625c = !C1241sa.class.desiredAssertionStatus();

    /* renamed from: a */
    public static C1239ra f1623a = new C1239ra();

    static {
        HashMap hashMap = new HashMap();
        f1624b = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        this.f1626d = c1223k.m2926a(this.f1626d, 0, true);
        this.f1627e = c1223k.m2926a(this.f1627e, 1, true);
        this.f1628f = c1223k.m2926a(this.f1628f, 2, true);
        this.f1629g = c1223k.m2937a(3, false);
        this.f1630h = c1223k.m2937a(4, false);
        this.f1631i = (C1239ra) c1223k.m2933a((AbstractC1228m) f1623a, 5, false);
        this.f1632j = (Map) c1223k.m2932a((C1223k) f1624b, 6, false);
        this.f1633k = c1223k.m2936a(this.f1633k, 7, false);
        this.f1634l = c1223k.m2937a(8, false);
        this.f1635m = c1223k.m2937a(9, false);
        this.f1636n = c1223k.m2938a(this.f1636n, 10, false);
        this.f1637o = c1223k.m2938a(this.f1637o, 11, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2898a(this.f1626d, 0);
        c1226l.m2898a(this.f1627e, 1);
        c1226l.m2898a(this.f1628f, 2);
        String str = this.f1629g;
        if (str != null) {
            c1226l.m2902a(str, 3);
        }
        String str2 = this.f1630h;
        if (str2 != null) {
            c1226l.m2902a(str2, 4);
        }
        C1239ra c1239ra = this.f1631i;
        if (c1239ra != null) {
            c1226l.m2905a((AbstractC1228m) c1239ra, 5);
        }
        Map<String, String> map = this.f1632j;
        if (map != null) {
            c1226l.m2900a((Map) map, 6);
        }
        c1226l.m2906a(this.f1633k, 7);
        String str3 = this.f1634l;
        if (str3 != null) {
            c1226l.m2902a(str3, 8);
        }
        String str4 = this.f1635m;
        if (str4 != null) {
            c1226l.m2902a(str4, 9);
        }
        c1226l.m2907a(this.f1636n, 10);
        c1226l.m2907a(this.f1637o, 11);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2855a(StringBuilder sb, int i) {
        C1219i c1219i = new C1219i(sb, i);
        c1219i.m2954a(this.f1626d, "enable");
        c1219i.m2954a(this.f1627e, "enableUserInfo");
        c1219i.m2954a(this.f1628f, "enableQuery");
        c1219i.m2958a(this.f1629g, "url");
        c1219i.m2958a(this.f1630h, "expUrl");
        c1219i.m2961a((AbstractC1228m) this.f1631i, "security");
        c1219i.m2956a((Map) this.f1632j, "valueMap");
        c1219i.m2962a(this.f1633k, "strategylastUpdateTime");
        c1219i.m2958a(this.f1634l, "httpsUrl");
        c1219i.m2958a(this.f1635m, "httpsExpUrl");
        c1219i.m2963a(this.f1636n, "eventRecordCount");
        c1219i.m2963a(this.f1637o, "eventTimeInterval");
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (!f1625c) {
                throw new AssertionError();
            }
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C1241sa c1241sa = (C1241sa) obj;
        return C1230n.m2882a(this.f1626d, c1241sa.f1626d) && C1230n.m2882a(this.f1627e, c1241sa.f1627e) && C1230n.m2882a(this.f1628f, c1241sa.f1628f) && C1230n.m2884a(this.f1629g, c1241sa.f1629g) && C1230n.m2884a(this.f1630h, c1241sa.f1630h) && C1230n.m2884a(this.f1631i, c1241sa.f1631i) && C1230n.m2884a(this.f1632j, c1241sa.f1632j) && C1230n.m2885a(this.f1633k, c1241sa.f1633k) && C1230n.m2884a(this.f1634l, c1241sa.f1634l) && C1230n.m2884a(this.f1635m, c1241sa.f1635m) && C1230n.m2886a(this.f1636n, c1241sa.f1636n) && C1230n.m2886a(this.f1637o, c1241sa.f1637o);
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
