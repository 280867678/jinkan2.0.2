package com.tencent.bugly.proguard;

/* renamed from: com.tencent.bugly.proguard.D */
/* loaded from: classes3.dex */
public final class C1179D extends AbstractC1228m implements Cloneable {

    /* renamed from: a */
    public static C1241sa f1350a;

    /* renamed from: b */
    public static C1177B f1351b;

    /* renamed from: c */
    public static final /* synthetic */ boolean f1352c = !C1179D.class.desiredAssertionStatus();

    /* renamed from: d */
    public C1241sa f1353d = null;

    /* renamed from: e */
    public C1177B f1354e = null;

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        if (f1350a == null) {
            f1350a = new C1241sa();
        }
        this.f1353d = (C1241sa) c1223k.m2933a((AbstractC1228m) f1350a, 0, false);
        if (f1351b == null) {
            f1351b = new C1177B();
        }
        this.f1354e = (C1177B) c1223k.m2933a((AbstractC1228m) f1351b, 1, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        C1241sa c1241sa = this.f1353d;
        if (c1241sa != null) {
            c1226l.m2905a((AbstractC1228m) c1241sa, 0);
        }
        C1177B c1177b = this.f1354e;
        if (c1177b != null) {
            c1226l.m2905a((AbstractC1228m) c1177b, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2855a(StringBuilder sb, int i) {
        C1219i c1219i = new C1219i(sb, i);
        c1219i.m2961a((AbstractC1228m) this.f1353d, "baseStrategy");
        c1219i.m2961a((AbstractC1228m) this.f1354e, "grayStrategy");
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (!f1352c) {
                throw new AssertionError();
            }
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C1179D c1179d = (C1179D) obj;
        return C1230n.m2884a(this.f1353d, c1179d.f1353d) && C1230n.m2884a(this.f1354e, c1179d.f1354e);
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
