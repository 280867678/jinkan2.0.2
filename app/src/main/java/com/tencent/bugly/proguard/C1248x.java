package com.tencent.bugly.proguard;

/* renamed from: com.tencent.bugly.proguard.x */
/* loaded from: classes3.dex */
public final class C1248x extends AbstractC1228m implements Cloneable {

    /* renamed from: a */
    public static final /* synthetic */ boolean f1661a = !C1248x.class.desiredAssertionStatus();

    /* renamed from: b */
    public String f1662b;

    /* renamed from: c */
    public String f1663c;

    /* renamed from: d */
    public String f1664d;

    /* renamed from: e */
    public long f1665e;

    /* renamed from: f */
    public String f1666f;

    public C1248x() {
        this.f1662b = "";
        this.f1663c = "";
        this.f1664d = "";
        this.f1665e = 0L;
        this.f1666f = "";
    }

    public C1248x(String str, String str2, String str3, long j, String str4) {
        this.f1662b = "";
        this.f1663c = "";
        this.f1664d = "";
        this.f1665e = 0L;
        this.f1666f = "";
        this.f1662b = str;
        this.f1663c = str2;
        this.f1664d = str3;
        this.f1665e = j;
        this.f1666f = str4;
    }

    /* renamed from: a */
    public String m2858a() {
        return this.f1663c;
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        this.f1662b = c1223k.m2937a(0, true);
        this.f1663c = c1223k.m2937a(1, true);
        this.f1664d = c1223k.m2937a(2, false);
        this.f1665e = c1223k.m2936a(this.f1665e, 3, true);
        this.f1666f = c1223k.m2937a(4, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2902a(this.f1662b, 0);
        c1226l.m2902a(this.f1663c, 1);
        String str = this.f1664d;
        if (str != null) {
            c1226l.m2902a(str, 2);
        }
        c1226l.m2906a(this.f1665e, 3);
        String str2 = this.f1666f;
        if (str2 != null) {
            c1226l.m2902a(str2, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2855a(StringBuilder sb, int i) {
        C1219i c1219i = new C1219i(sb, i);
        c1219i.m2958a(this.f1662b, "apkMd5");
        c1219i.m2958a(this.f1663c, "apkUrl");
        c1219i.m2958a(this.f1664d, "manifestMd5");
        c1219i.m2962a(this.f1665e, "fileSize");
        c1219i.m2958a(this.f1666f, "signatureMd5");
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (!f1661a) {
                throw new AssertionError();
            }
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C1248x c1248x = (C1248x) obj;
        return C1230n.m2884a(this.f1662b, c1248x.f1662b) && C1230n.m2884a(this.f1663c, c1248x.f1663c) && C1230n.m2884a(this.f1664d, c1248x.f1664d) && C1230n.m2885a(this.f1665e, c1248x.f1665e) && C1230n.m2884a(this.f1666f, c1248x.f1666f);
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
