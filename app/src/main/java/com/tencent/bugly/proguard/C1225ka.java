package com.tencent.bugly.proguard;

/* renamed from: com.tencent.bugly.proguard.ka */
/* loaded from: classes3.dex */
public final class C1225ka extends AbstractC1228m implements Cloneable {

    /* renamed from: a */
    public String f1525a = "";

    /* renamed from: b */
    public String f1526b = "";

    /* renamed from: c */
    public String f1527c = "";

    /* renamed from: d */
    public String f1528d = "";

    /* renamed from: e */
    public String f1529e = "";

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        this.f1525a = c1223k.m2937a(0, true);
        this.f1526b = c1223k.m2937a(1, false);
        this.f1527c = c1223k.m2937a(2, false);
        this.f1528d = c1223k.m2937a(3, false);
        this.f1529e = c1223k.m2937a(4, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2902a(this.f1525a, 0);
        String str = this.f1526b;
        if (str != null) {
            c1226l.m2902a(str, 1);
        }
        String str2 = this.f1527c;
        if (str2 != null) {
            c1226l.m2902a(str2, 2);
        }
        String str3 = this.f1528d;
        if (str3 != null) {
            c1226l.m2902a(str3, 3);
        }
        String str4 = this.f1529e;
        if (str4 != null) {
            c1226l.m2902a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2855a(StringBuilder sb, int i) {
    }
}
