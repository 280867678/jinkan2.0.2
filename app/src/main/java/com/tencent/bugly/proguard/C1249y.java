package com.tencent.bugly.proguard;

/* renamed from: com.tencent.bugly.proguard.y */
/* loaded from: classes3.dex */
public final class C1249y extends AbstractC1228m implements Cloneable {

    /* renamed from: a */
    public static final /* synthetic */ boolean f1667a = !C1249y.class.desiredAssertionStatus();

    /* renamed from: b */
    public String f1668b;

    /* renamed from: c */
    public byte f1669c;

    /* renamed from: d */
    public int f1670d;

    /* renamed from: e */
    public String f1671e;

    /* renamed from: f */
    public int f1672f;

    /* renamed from: g */
    public String f1673g;

    /* renamed from: h */
    public long f1674h;

    /* renamed from: i */
    public String f1675i;

    /* renamed from: j */
    public String f1676j;

    /* renamed from: k */
    public String f1677k;

    /* renamed from: l */
    public String f1678l;

    public C1249y() {
        this.f1668b = "";
        this.f1669c = (byte) 0;
        this.f1670d = 0;
        this.f1671e = "";
        this.f1672f = 0;
        this.f1673g = "";
        this.f1674h = 0L;
        this.f1675i = "";
        this.f1676j = "";
        this.f1677k = "";
        this.f1678l = "";
    }

    public C1249y(String str, byte b, int i, String str2, int i2, String str3, long j, String str4, String str5, String str6, String str7) {
        this.f1668b = "";
        this.f1669c = (byte) 0;
        this.f1670d = 0;
        this.f1671e = "";
        this.f1672f = 0;
        this.f1673g = "";
        this.f1674h = 0L;
        this.f1675i = "";
        this.f1676j = "";
        this.f1677k = "";
        this.f1678l = "";
        this.f1668b = str;
        this.f1669c = b;
        this.f1670d = i;
        this.f1671e = str2;
        this.f1672f = i2;
        this.f1673g = str3;
        this.f1674h = j;
        this.f1675i = str4;
        this.f1676j = str5;
        this.f1677k = str6;
        this.f1678l = str7;
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        this.f1668b = c1223k.m2937a(0, true);
        this.f1669c = c1223k.m2942a(this.f1669c, 1, true);
        this.f1670d = c1223k.m2938a(this.f1670d, 2, true);
        this.f1671e = c1223k.m2937a(3, false);
        this.f1672f = c1223k.m2938a(this.f1672f, 4, false);
        this.f1673g = c1223k.m2937a(5, false);
        this.f1674h = c1223k.m2936a(this.f1674h, 6, false);
        this.f1675i = c1223k.m2937a(7, false);
        this.f1676j = c1223k.m2937a(8, false);
        this.f1677k = c1223k.m2937a(9, false);
        this.f1678l = c1223k.m2937a(10, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2902a(this.f1668b, 0);
        c1226l.m2911a(this.f1669c, 1);
        c1226l.m2907a(this.f1670d, 2);
        String str = this.f1671e;
        if (str != null) {
            c1226l.m2902a(str, 3);
        }
        c1226l.m2907a(this.f1672f, 4);
        String str2 = this.f1673g;
        if (str2 != null) {
            c1226l.m2902a(str2, 5);
        }
        c1226l.m2906a(this.f1674h, 6);
        String str3 = this.f1675i;
        if (str3 != null) {
            c1226l.m2902a(str3, 7);
        }
        String str4 = this.f1676j;
        if (str4 != null) {
            c1226l.m2902a(str4, 8);
        }
        String str5 = this.f1677k;
        if (str5 != null) {
            c1226l.m2902a(str5, 9);
        }
        String str6 = this.f1678l;
        if (str6 != null) {
            c1226l.m2902a(str6, 10);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2855a(StringBuilder sb, int i) {
        C1219i c1219i = new C1219i(sb, i);
        c1219i.m2958a(this.f1668b, "appId");
        c1219i.m2967a(this.f1669c, "platformId");
        c1219i.m2963a(this.f1670d, "versionCode");
        c1219i.m2958a(this.f1671e, "versionName");
        c1219i.m2963a(this.f1672f, "buildNo");
        c1219i.m2958a(this.f1673g, "iconUrl");
        c1219i.m2962a(this.f1674h, "apkId");
        c1219i.m2958a(this.f1675i, "channelId");
        c1219i.m2958a(this.f1676j, "md5");
        c1219i.m2958a(this.f1677k, "sdkVer");
        c1219i.m2958a(this.f1678l, "bundleId");
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (!f1667a) {
                throw new AssertionError();
            }
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C1249y c1249y = (C1249y) obj;
        return C1230n.m2884a(this.f1668b, c1249y.f1668b) && C1230n.m2887a(this.f1669c, c1249y.f1669c) && C1230n.m2886a(this.f1670d, c1249y.f1670d) && C1230n.m2884a(this.f1671e, c1249y.f1671e) && C1230n.m2886a(this.f1672f, c1249y.f1672f) && C1230n.m2884a(this.f1673g, c1249y.f1673g) && C1230n.m2885a(this.f1674h, c1249y.f1674h) && C1230n.m2884a(this.f1675i, c1249y.f1675i) && C1230n.m2884a(this.f1676j, c1249y.f1676j) && C1230n.m2884a(this.f1677k, c1249y.f1677k) && C1230n.m2884a(this.f1678l, c1249y.f1678l);
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
