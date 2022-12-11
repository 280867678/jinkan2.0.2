package com.tencent.bugly.proguard;

/* renamed from: com.tencent.bugly.proguard.ra */
/* loaded from: classes3.dex */
public final class C1239ra extends AbstractC1228m implements Cloneable {

    /* renamed from: a */
    public String f1620a = "";

    /* renamed from: b */
    public String f1621b = "";

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        this.f1620a = c1223k.m2937a(0, true);
        this.f1621b = c1223k.m2937a(1, true);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2902a(this.f1620a, 0);
        c1226l.m2902a(this.f1621b, 1);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2855a(StringBuilder sb, int i) {
    }
}
