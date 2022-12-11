package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.qa */
/* loaded from: classes3.dex */
public final class C1237qa extends AbstractC1228m {

    /* renamed from: a */
    public static byte[] f1601a;

    /* renamed from: b */
    public static Map<String, String> f1602b;

    /* renamed from: c */
    public byte f1603c = 0;

    /* renamed from: d */
    public int f1604d = 0;

    /* renamed from: e */
    public byte[] f1605e = null;

    /* renamed from: f */
    public String f1606f = "";

    /* renamed from: g */
    public long f1607g = 0;

    /* renamed from: h */
    public String f1608h = "";

    /* renamed from: i */
    public String f1609i = "";

    /* renamed from: j */
    public Map<String, String> f1610j = null;

    static {
        f1601a = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        f1602b = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        this.f1603c = c1223k.m2942a(this.f1603c, 0, true);
        this.f1604d = c1223k.m2938a(this.f1604d, 1, true);
        this.f1605e = c1223k.m2924a(f1601a, 2, false);
        this.f1606f = c1223k.m2937a(3, false);
        this.f1607g = c1223k.m2936a(this.f1607g, 4, false);
        this.f1608h = c1223k.m2937a(5, false);
        this.f1609i = c1223k.m2937a(6, false);
        this.f1610j = (Map) c1223k.m2932a((C1223k) f1602b, 7, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2911a(this.f1603c, 0);
        c1226l.m2907a(this.f1604d, 1);
        byte[] bArr = this.f1605e;
        if (bArr != null) {
            c1226l.m2897a(bArr, 2);
        }
        String str = this.f1606f;
        if (str != null) {
            c1226l.m2902a(str, 3);
        }
        c1226l.m2906a(this.f1607g, 4);
        String str2 = this.f1608h;
        if (str2 != null) {
            c1226l.m2902a(str2, 5);
        }
        String str3 = this.f1609i;
        if (str3 != null) {
            c1226l.m2902a(str3, 6);
        }
        Map<String, String> map = this.f1610j;
        if (map != null) {
            c1226l.m2900a((Map) map, 7);
        }
    }
}
