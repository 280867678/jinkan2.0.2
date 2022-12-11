package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.C */
/* loaded from: classes3.dex */
public final class C1178C extends AbstractC1228m implements Cloneable {

    /* renamed from: a */
    public static Map<String, String> f1344a;

    /* renamed from: b */
    public static final /* synthetic */ boolean f1345b = !C1178C.class.desiredAssertionStatus();

    /* renamed from: c */
    public int f1346c;

    /* renamed from: d */
    public String f1347d;

    /* renamed from: e */
    public long f1348e;

    /* renamed from: f */
    public Map<String, String> f1349f;

    public C1178C() {
        this.f1346c = 0;
        this.f1347d = "";
        this.f1348e = 0L;
        this.f1349f = null;
    }

    public C1178C(int i, String str, long j, Map<String, String> map) {
        this.f1346c = 0;
        this.f1347d = "";
        this.f1348e = 0L;
        this.f1349f = null;
        this.f1346c = i;
        this.f1347d = str;
        this.f1348e = j;
        this.f1349f = map;
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        this.f1346c = c1223k.m2938a(this.f1346c, 0, false);
        this.f1347d = c1223k.m2937a(1, false);
        this.f1348e = c1223k.m2936a(this.f1348e, 2, false);
        if (f1344a == null) {
            HashMap hashMap = new HashMap();
            f1344a = hashMap;
            hashMap.put("", "");
        }
        this.f1349f = (Map) c1223k.m2932a((C1223k) f1344a, 3, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2907a(this.f1346c, 0);
        String str = this.f1347d;
        if (str != null) {
            c1226l.m2902a(str, 1);
        }
        c1226l.m2906a(this.f1348e, 2);
        Map<String, String> map = this.f1349f;
        if (map != null) {
            c1226l.m2900a((Map) map, 3);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2855a(StringBuilder sb, int i) {
        C1219i c1219i = new C1219i(sb, i);
        c1219i.m2963a(this.f1346c, "flag");
        c1219i.m2958a(this.f1347d, "localStrategyId");
        c1219i.m2962a(this.f1348e, "localStrategyTime");
        c1219i.m2956a((Map) this.f1349f, "reserved");
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (!f1345b) {
                throw new AssertionError();
            }
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C1178C c1178c = (C1178C) obj;
        return C1230n.m2886a(this.f1346c, c1178c.f1346c) && C1230n.m2884a(this.f1347d, c1178c.f1347d) && C1230n.m2885a(this.f1348e, c1178c.f1348e) && C1230n.m2884a(this.f1349f, c1178c.f1349f);
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
