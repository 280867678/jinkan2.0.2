package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.ta */
/* loaded from: classes3.dex */
public final class C1243ta extends AbstractC1228m {

    /* renamed from: a */
    public static Map<String, String> f1638a;

    /* renamed from: b */
    public long f1639b = 0;

    /* renamed from: c */
    public byte f1640c = 0;

    /* renamed from: d */
    public String f1641d = "";

    /* renamed from: e */
    public String f1642e = "";

    /* renamed from: f */
    public String f1643f = "";

    /* renamed from: g */
    public Map<String, String> f1644g = null;

    /* renamed from: h */
    public String f1645h = "";

    /* renamed from: i */
    public boolean f1646i = true;

    static {
        HashMap hashMap = new HashMap();
        f1638a = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        this.f1639b = c1223k.m2936a(this.f1639b, 0, true);
        this.f1640c = c1223k.m2942a(this.f1640c, 1, true);
        this.f1641d = c1223k.m2937a(2, false);
        this.f1642e = c1223k.m2937a(3, false);
        this.f1643f = c1223k.m2937a(4, false);
        this.f1644g = (Map) c1223k.m2932a((C1223k) f1638a, 5, false);
        this.f1645h = c1223k.m2937a(6, false);
        this.f1646i = c1223k.m2926a(this.f1646i, 7, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2906a(this.f1639b, 0);
        c1226l.m2911a(this.f1640c, 1);
        String str = this.f1641d;
        if (str != null) {
            c1226l.m2902a(str, 2);
        }
        String str2 = this.f1642e;
        if (str2 != null) {
            c1226l.m2902a(str2, 3);
        }
        String str3 = this.f1643f;
        if (str3 != null) {
            c1226l.m2902a(str3, 4);
        }
        Map<String, String> map = this.f1644g;
        if (map != null) {
            c1226l.m2900a((Map) map, 5);
        }
        String str4 = this.f1645h;
        if (str4 != null) {
            c1226l.m2902a(str4, 6);
        }
        c1226l.m2898a(this.f1646i, 7);
    }
}
