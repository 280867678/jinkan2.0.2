package com.umeng.analytics.pro;

/* renamed from: com.umeng.analytics.pro.cf */
/* loaded from: classes4.dex */
public final class C1611cf extends AbstractC1612cg {

    /* renamed from: a */
    public byte[] f3265a;

    /* renamed from: b */
    public int f3266b;

    /* renamed from: c */
    public int f3267c;

    public C1611cf() {
    }

    public C1611cf(byte[] bArr) {
        m1099a(bArr);
    }

    public C1611cf(byte[] bArr, int i, int i2) {
        m1098c(bArr, i, i2);
    }

    @Override // com.umeng.analytics.pro.AbstractC1612cg
    /* renamed from: a */
    public int mo1094a(byte[] bArr, int i, int i2) throws C1613ch {
        int mo1085h = mo1085h();
        if (i2 > mo1085h) {
            i2 = mo1085h;
        }
        if (i2 > 0) {
            System.arraycopy(this.f3265a, this.f3266b, bArr, i, i2);
            mo1095a(i2);
        }
        return i2;
    }

    @Override // com.umeng.analytics.pro.AbstractC1612cg
    /* renamed from: a */
    public void mo1095a(int i) {
        this.f3266b += i;
    }

    /* renamed from: a */
    public void m1099a(byte[] bArr) {
        m1098c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.AbstractC1612cg
    /* renamed from: a */
    public boolean mo1096a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.AbstractC1612cg
    /* renamed from: b */
    public void mo1093b() throws C1613ch {
    }

    @Override // com.umeng.analytics.pro.AbstractC1612cg
    /* renamed from: b */
    public void mo1091b(byte[] bArr, int i, int i2) throws C1613ch {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.AbstractC1612cg
    /* renamed from: c */
    public void mo1090c() {
    }

    /* renamed from: c */
    public void m1098c(byte[] bArr, int i, int i2) {
        this.f3265a = bArr;
        this.f3266b = i;
        this.f3267c = i + i2;
    }

    /* renamed from: e */
    public void m1097e() {
        this.f3265a = null;
    }

    @Override // com.umeng.analytics.pro.AbstractC1612cg
    /* renamed from: f */
    public byte[] mo1087f() {
        return this.f3265a;
    }

    @Override // com.umeng.analytics.pro.AbstractC1612cg
    /* renamed from: g */
    public int mo1086g() {
        return this.f3266b;
    }

    @Override // com.umeng.analytics.pro.AbstractC1612cg
    /* renamed from: h */
    public int mo1085h() {
        return this.f3267c - this.f3266b;
    }
}
