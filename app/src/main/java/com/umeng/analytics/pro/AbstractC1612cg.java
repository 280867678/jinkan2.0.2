package com.umeng.analytics.pro;

import me.tvspark.outline;

/* renamed from: com.umeng.analytics.pro.cg */
/* loaded from: classes4.dex */
public abstract class AbstractC1612cg {
    /* renamed from: a */
    public abstract int mo1094a(byte[] bArr, int i, int i2) throws C1613ch;

    /* renamed from: a */
    public void mo1095a(int i) {
    }

    /* renamed from: a */
    public abstract boolean mo1096a();

    /* renamed from: b */
    public abstract void mo1093b() throws C1613ch;

    /* renamed from: b */
    public void m1092b(byte[] bArr) throws C1613ch {
        mo1091b(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public abstract void mo1091b(byte[] bArr, int i, int i2) throws C1613ch;

    /* renamed from: c */
    public abstract void mo1090c();

    /* renamed from: d */
    public int m1088d(byte[] bArr, int i, int i2) throws C1613ch {
        int i3 = 0;
        while (i3 < i2) {
            int mo1094a = mo1094a(bArr, i + i3, i2 - i3);
            if (mo1094a <= 0) {
                throw new C1613ch(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot read. Remote side has closed. Tried to read ", i2, " bytes, but only got ", i3, " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)"));
            }
            i3 += mo1094a;
        }
        return i3;
    }

    /* renamed from: d */
    public void mo1089d() throws C1613ch {
    }

    /* renamed from: f */
    public byte[] mo1087f() {
        return null;
    }

    /* renamed from: g */
    public int mo1086g() {
        return 0;
    }

    /* renamed from: h */
    public int mo1085h() {
        return -1;
    }

    /* renamed from: i */
    public boolean m1084i() {
        return mo1096a();
    }
}
