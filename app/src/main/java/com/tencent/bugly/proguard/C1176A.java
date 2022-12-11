package com.tencent.bugly.proguard;

import com.umeng.analytics.pro.C1615d;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.bugly.proguard.A */
/* loaded from: classes3.dex */
public final class C1176A extends AbstractC1228m implements Cloneable {

    /* renamed from: a */
    public static ArrayList<C1250z> f1320a;

    /* renamed from: b */
    public static final /* synthetic */ boolean f1321b = !C1176A.class.desiredAssertionStatus();

    /* renamed from: c */
    public ArrayList<C1250z> f1322c;

    public C1176A() {
        this.f1322c = null;
    }

    public C1176A(ArrayList<C1250z> arrayList) {
        this.f1322c = null;
        this.f1322c = arrayList;
    }

    /* renamed from: a */
    public ArrayList<C1250z> m3191a() {
        return this.f1322c;
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        if (f1320a == null) {
            f1320a = new ArrayList<>();
            f1320a.add(new C1250z());
        }
        this.f1322c = (ArrayList) c1223k.m2932a((C1223k) f1320a, 0, true);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2901a((Collection) this.f1322c, 0);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2855a(StringBuilder sb, int i) {
        new C1219i(sb, i).m2957a((Collection) this.f1322c, C1615d.f3327ar);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (!f1321b) {
                throw new AssertionError();
            }
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return C1230n.m2884a(this.f1322c, ((C1176A) obj).f1322c);
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
