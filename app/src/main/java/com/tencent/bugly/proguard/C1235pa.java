package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.pa */
/* loaded from: classes3.dex */
public final class C1235pa extends AbstractC1228m {

    /* renamed from: a */
    public static byte[] f1573a;

    /* renamed from: b */
    public static Map<String, String> f1574b;

    /* renamed from: c */
    public int f1575c = 0;

    /* renamed from: d */
    public String f1576d = "";

    /* renamed from: e */
    public String f1577e = "";

    /* renamed from: f */
    public String f1578f = "";

    /* renamed from: g */
    public String f1579g = "";

    /* renamed from: h */
    public String f1580h = "";

    /* renamed from: i */
    public int f1581i = 0;

    /* renamed from: j */
    public byte[] f1582j = null;

    /* renamed from: k */
    public String f1583k = "";

    /* renamed from: l */
    public String f1584l = "";

    /* renamed from: m */
    public Map<String, String> f1585m = null;

    /* renamed from: n */
    public String f1586n = "";

    /* renamed from: o */
    public long f1587o = 0;

    /* renamed from: p */
    public String f1588p = "";

    /* renamed from: q */
    public String f1589q = "";

    /* renamed from: r */
    public String f1590r = "";

    /* renamed from: s */
    public long f1591s = 0;

    /* renamed from: t */
    public String f1592t = "";

    /* renamed from: u */
    public String f1593u = "";

    /* renamed from: v */
    public String f1594v = "";

    /* renamed from: w */
    public String f1595w = "";

    /* renamed from: x */
    public String f1596x = "";

    /* renamed from: y */
    public String f1597y = "";

    /* renamed from: z */
    public String f1598z = "";

    static {
        f1573a = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        f1574b = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        this.f1575c = c1223k.m2938a(this.f1575c, 0, true);
        this.f1576d = c1223k.m2937a(1, true);
        this.f1577e = c1223k.m2937a(2, true);
        this.f1578f = c1223k.m2937a(3, true);
        this.f1579g = c1223k.m2937a(4, false);
        this.f1580h = c1223k.m2937a(5, true);
        this.f1581i = c1223k.m2938a(this.f1581i, 6, true);
        this.f1582j = c1223k.m2924a(f1573a, 7, true);
        this.f1583k = c1223k.m2937a(8, false);
        this.f1584l = c1223k.m2937a(9, false);
        this.f1585m = (Map) c1223k.m2932a((C1223k) f1574b, 10, false);
        this.f1586n = c1223k.m2937a(11, false);
        this.f1587o = c1223k.m2936a(this.f1587o, 12, false);
        this.f1588p = c1223k.m2937a(13, false);
        this.f1589q = c1223k.m2937a(14, false);
        this.f1590r = c1223k.m2937a(15, false);
        this.f1591s = c1223k.m2936a(this.f1591s, 16, false);
        this.f1592t = c1223k.m2937a(17, false);
        this.f1593u = c1223k.m2937a(18, false);
        this.f1594v = c1223k.m2937a(19, false);
        this.f1595w = c1223k.m2937a(20, false);
        this.f1596x = c1223k.m2937a(21, false);
        this.f1597y = c1223k.m2937a(22, false);
        this.f1598z = c1223k.m2937a(23, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2907a(this.f1575c, 0);
        c1226l.m2902a(this.f1576d, 1);
        c1226l.m2902a(this.f1577e, 2);
        c1226l.m2902a(this.f1578f, 3);
        String str = this.f1579g;
        if (str != null) {
            c1226l.m2902a(str, 4);
        }
        c1226l.m2902a(this.f1580h, 5);
        c1226l.m2907a(this.f1581i, 6);
        c1226l.m2897a(this.f1582j, 7);
        String str2 = this.f1583k;
        if (str2 != null) {
            c1226l.m2902a(str2, 8);
        }
        String str3 = this.f1584l;
        if (str3 != null) {
            c1226l.m2902a(str3, 9);
        }
        Map<String, String> map = this.f1585m;
        if (map != null) {
            c1226l.m2900a((Map) map, 10);
        }
        String str4 = this.f1586n;
        if (str4 != null) {
            c1226l.m2902a(str4, 11);
        }
        c1226l.m2906a(this.f1587o, 12);
        String str5 = this.f1588p;
        if (str5 != null) {
            c1226l.m2902a(str5, 13);
        }
        String str6 = this.f1589q;
        if (str6 != null) {
            c1226l.m2902a(str6, 14);
        }
        String str7 = this.f1590r;
        if (str7 != null) {
            c1226l.m2902a(str7, 15);
        }
        c1226l.m2906a(this.f1591s, 16);
        String str8 = this.f1592t;
        if (str8 != null) {
            c1226l.m2902a(str8, 17);
        }
        String str9 = this.f1593u;
        if (str9 != null) {
            c1226l.m2902a(str9, 18);
        }
        String str10 = this.f1594v;
        if (str10 != null) {
            c1226l.m2902a(str10, 19);
        }
        String str11 = this.f1595w;
        if (str11 != null) {
            c1226l.m2902a(str11, 20);
        }
        String str12 = this.f1596x;
        if (str12 != null) {
            c1226l.m2902a(str12, 21);
        }
        String str13 = this.f1597y;
        if (str13 != null) {
            c1226l.m2902a(str13, 22);
        }
        String str14 = this.f1598z;
        if (str14 != null) {
            c1226l.m2902a(str14, 23);
        }
    }
}
