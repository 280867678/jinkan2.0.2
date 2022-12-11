package com.tencent.bugly.proguard;

/* renamed from: com.tencent.bugly.proguard.ma */
/* loaded from: classes3.dex */
public final class C1229ma extends AbstractC1228m implements Cloneable {

    /* renamed from: a */
    public static byte[] f1535a;

    /* renamed from: b */
    public byte f1536b;

    /* renamed from: c */
    public String f1537c;

    /* renamed from: d */
    public byte[] f1538d;

    public C1229ma() {
        this.f1536b = (byte) 0;
        this.f1537c = "";
        this.f1538d = null;
    }

    public C1229ma(byte b, String str, byte[] bArr) {
        this.f1536b = (byte) 0;
        this.f1537c = "";
        this.f1538d = null;
        this.f1536b = b;
        this.f1537c = str;
        this.f1538d = bArr;
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        this.f1536b = c1223k.m2942a(this.f1536b, 0, true);
        this.f1537c = c1223k.m2937a(1, true);
        if (f1535a == null) {
            f1535a = r0;
            byte[] bArr = {0};
        }
        this.f1538d = c1223k.m2924a(f1535a, 2, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2911a(this.f1536b, 0);
        c1226l.m2902a(this.f1537c, 1);
        byte[] bArr = this.f1538d;
        if (bArr != null) {
            c1226l.m2897a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2855a(StringBuilder sb, int i) {
    }
}
