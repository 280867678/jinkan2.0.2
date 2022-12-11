package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.bugly.proguard.la */
/* loaded from: classes3.dex */
public final class C1227la extends AbstractC1228m implements Cloneable {

    /* renamed from: a */
    public static ArrayList<String> f1532a;

    /* renamed from: b */
    public String f1533b = "";

    /* renamed from: c */
    public ArrayList<String> f1534c = null;

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        this.f1533b = c1223k.m2937a(0, true);
        if (f1532a == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f1532a = arrayList;
            arrayList.add("");
        }
        this.f1534c = (ArrayList) c1223k.m2932a((C1223k) f1532a, 1, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2902a(this.f1533b, 0);
        ArrayList<String> arrayList = this.f1534c;
        if (arrayList != null) {
            c1226l.m2901a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2855a(StringBuilder sb, int i) {
    }
}
