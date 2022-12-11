package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.bugly.proguard.oa */
/* loaded from: classes3.dex */
public final class C1233oa extends AbstractC1228m implements Cloneable {

    /* renamed from: a */
    public static ArrayList<C1231na> f1570a;

    /* renamed from: b */
    public ArrayList<C1231na> f1571b = null;

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        if (f1570a == null) {
            f1570a = new ArrayList<>();
            f1570a.add(new C1231na());
        }
        this.f1571b = (ArrayList) c1223k.m2932a((C1223k) f1570a, 0, true);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2901a((Collection) this.f1571b, 0);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2855a(StringBuilder sb, int i) {
    }
}
