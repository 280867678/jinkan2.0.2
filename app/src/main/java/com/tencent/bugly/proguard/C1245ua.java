package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.ua */
/* loaded from: classes3.dex */
public final class C1245ua extends AbstractC1228m implements Cloneable {

    /* renamed from: a */
    public static ArrayList<C1243ta> f1648a;

    /* renamed from: b */
    public static Map<String, String> f1649b;

    /* renamed from: c */
    public byte f1650c = 0;

    /* renamed from: d */
    public String f1651d = "";

    /* renamed from: e */
    public String f1652e = "";

    /* renamed from: f */
    public ArrayList<C1243ta> f1653f = null;

    /* renamed from: g */
    public Map<String, String> f1654g = null;

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        this.f1650c = c1223k.m2942a(this.f1650c, 0, true);
        this.f1651d = c1223k.m2937a(1, false);
        this.f1652e = c1223k.m2937a(2, false);
        if (f1648a == null) {
            f1648a = new ArrayList<>();
            f1648a.add(new C1243ta());
        }
        this.f1653f = (ArrayList) c1223k.m2932a((C1223k) f1648a, 3, false);
        if (f1649b == null) {
            HashMap hashMap = new HashMap();
            f1649b = hashMap;
            hashMap.put("", "");
        }
        this.f1654g = (Map) c1223k.m2932a((C1223k) f1649b, 4, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2911a(this.f1650c, 0);
        String str = this.f1651d;
        if (str != null) {
            c1226l.m2902a(str, 1);
        }
        String str2 = this.f1652e;
        if (str2 != null) {
            c1226l.m2902a(str2, 2);
        }
        ArrayList<C1243ta> arrayList = this.f1653f;
        if (arrayList != null) {
            c1226l.m2901a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f1654g;
        if (map != null) {
            c1226l.m2900a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2855a(StringBuilder sb, int i) {
    }
}
