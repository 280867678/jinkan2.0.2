package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.na */
/* loaded from: classes3.dex */
public final class C1231na extends AbstractC1228m {

    /* renamed from: a */
    public static Map<String, String> f1541a;

    /* renamed from: b */
    public static C1227la f1542b = new C1227la();

    /* renamed from: c */
    public static C1225ka f1543c = new C1225ka();

    /* renamed from: d */
    public static ArrayList<C1225ka> f1544d = new ArrayList<>();

    /* renamed from: e */
    public static ArrayList<C1225ka> f1545e = new ArrayList<>();

    /* renamed from: f */
    public static ArrayList<C1229ma> f1546f = new ArrayList<>();

    /* renamed from: g */
    public static Map<String, String> f1547g;

    /* renamed from: h */
    public static Map<String, String> f1548h;

    /* renamed from: i */
    public String f1552i = "";

    /* renamed from: j */
    public long f1553j = 0;

    /* renamed from: k */
    public String f1554k = "";

    /* renamed from: l */
    public String f1555l = "";

    /* renamed from: m */
    public String f1556m = "";

    /* renamed from: n */
    public String f1557n = "";

    /* renamed from: o */
    public String f1558o = "";

    /* renamed from: p */
    public Map<String, String> f1559p = null;

    /* renamed from: q */
    public String f1560q = "";

    /* renamed from: r */
    public C1227la f1561r = null;

    /* renamed from: s */
    public int f1562s = 0;

    /* renamed from: t */
    public String f1563t = "";

    /* renamed from: u */
    public String f1564u = "";

    /* renamed from: v */
    public C1225ka f1565v = null;

    /* renamed from: w */
    public ArrayList<C1225ka> f1566w = null;

    /* renamed from: x */
    public ArrayList<C1225ka> f1567x = null;

    /* renamed from: y */
    public ArrayList<C1229ma> f1568y = null;

    /* renamed from: z */
    public Map<String, String> f1569z = null;

    /* renamed from: A */
    public Map<String, String> f1549A = null;

    /* renamed from: B */
    public String f1550B = "";

    /* renamed from: C */
    public boolean f1551C = true;

    static {
        HashMap hashMap = new HashMap();
        f1541a = hashMap;
        hashMap.put("", "");
        f1544d.add(new C1225ka());
        f1545e.add(new C1225ka());
        f1546f.add(new C1229ma());
        HashMap hashMap2 = new HashMap();
        f1547g = hashMap2;
        hashMap2.put("", "");
        HashMap hashMap3 = new HashMap();
        f1548h = hashMap3;
        hashMap3.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        this.f1552i = c1223k.m2937a(0, true);
        this.f1553j = c1223k.m2936a(this.f1553j, 1, true);
        this.f1554k = c1223k.m2937a(2, true);
        this.f1555l = c1223k.m2937a(3, false);
        this.f1556m = c1223k.m2937a(4, false);
        this.f1557n = c1223k.m2937a(5, false);
        this.f1558o = c1223k.m2937a(6, false);
        this.f1559p = (Map) c1223k.m2932a((C1223k) f1541a, 7, false);
        this.f1560q = c1223k.m2937a(8, false);
        this.f1561r = (C1227la) c1223k.m2933a((AbstractC1228m) f1542b, 9, false);
        this.f1562s = c1223k.m2938a(this.f1562s, 10, false);
        this.f1563t = c1223k.m2937a(11, false);
        this.f1564u = c1223k.m2937a(12, false);
        this.f1565v = (C1225ka) c1223k.m2933a((AbstractC1228m) f1543c, 13, false);
        this.f1566w = (ArrayList) c1223k.m2932a((C1223k) f1544d, 14, false);
        this.f1567x = (ArrayList) c1223k.m2932a((C1223k) f1545e, 15, false);
        this.f1568y = (ArrayList) c1223k.m2932a((C1223k) f1546f, 16, false);
        this.f1569z = (Map) c1223k.m2932a((C1223k) f1547g, 17, false);
        this.f1549A = (Map) c1223k.m2932a((C1223k) f1548h, 18, false);
        this.f1550B = c1223k.m2937a(19, false);
        this.f1551C = c1223k.m2926a(this.f1551C, 20, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2902a(this.f1552i, 0);
        c1226l.m2906a(this.f1553j, 1);
        c1226l.m2902a(this.f1554k, 2);
        String str = this.f1555l;
        if (str != null) {
            c1226l.m2902a(str, 3);
        }
        String str2 = this.f1556m;
        if (str2 != null) {
            c1226l.m2902a(str2, 4);
        }
        String str3 = this.f1557n;
        if (str3 != null) {
            c1226l.m2902a(str3, 5);
        }
        String str4 = this.f1558o;
        if (str4 != null) {
            c1226l.m2902a(str4, 6);
        }
        Map<String, String> map = this.f1559p;
        if (map != null) {
            c1226l.m2900a((Map) map, 7);
        }
        String str5 = this.f1560q;
        if (str5 != null) {
            c1226l.m2902a(str5, 8);
        }
        C1227la c1227la = this.f1561r;
        if (c1227la != null) {
            c1226l.m2905a((AbstractC1228m) c1227la, 9);
        }
        c1226l.m2907a(this.f1562s, 10);
        String str6 = this.f1563t;
        if (str6 != null) {
            c1226l.m2902a(str6, 11);
        }
        String str7 = this.f1564u;
        if (str7 != null) {
            c1226l.m2902a(str7, 12);
        }
        C1225ka c1225ka = this.f1565v;
        if (c1225ka != null) {
            c1226l.m2905a((AbstractC1228m) c1225ka, 13);
        }
        ArrayList<C1225ka> arrayList = this.f1566w;
        if (arrayList != null) {
            c1226l.m2901a((Collection) arrayList, 14);
        }
        ArrayList<C1225ka> arrayList2 = this.f1567x;
        if (arrayList2 != null) {
            c1226l.m2901a((Collection) arrayList2, 15);
        }
        ArrayList<C1229ma> arrayList3 = this.f1568y;
        if (arrayList3 != null) {
            c1226l.m2901a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.f1569z;
        if (map2 != null) {
            c1226l.m2900a((Map) map2, 17);
        }
        Map<String, String> map3 = this.f1549A;
        if (map3 != null) {
            c1226l.m2900a((Map) map3, 18);
        }
        String str8 = this.f1550B;
        if (str8 != null) {
            c1226l.m2902a(str8, 19);
        }
        c1226l.m2898a(this.f1551C, 20);
    }
}
