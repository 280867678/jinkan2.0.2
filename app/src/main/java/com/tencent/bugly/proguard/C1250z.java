package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.z */
/* loaded from: classes3.dex */
public final class C1250z extends AbstractC1228m implements Cloneable {

    /* renamed from: a */
    public static C1249y f1679a;

    /* renamed from: b */
    public static Map<String, String> f1680b;

    /* renamed from: c */
    public static final /* synthetic */ boolean f1681c = !C1250z.class.desiredAssertionStatus();

    /* renamed from: d */
    public String f1682d;

    /* renamed from: e */
    public long f1683e;

    /* renamed from: f */
    public byte f1684f;

    /* renamed from: g */
    public long f1685g;

    /* renamed from: h */
    public C1249y f1686h;

    /* renamed from: i */
    public String f1687i;

    /* renamed from: j */
    public int f1688j;

    /* renamed from: k */
    public Map<String, String> f1689k;

    public C1250z() {
        this.f1682d = "";
        this.f1683e = 0L;
        this.f1684f = (byte) 0;
        this.f1685g = 0L;
        this.f1686h = null;
        this.f1687i = "";
        this.f1688j = 0;
        this.f1689k = null;
    }

    public C1250z(String str, long j, byte b, long j2, C1249y c1249y, String str2, int i, Map<String, String> map) {
        this.f1682d = "";
        this.f1683e = 0L;
        this.f1684f = (byte) 0;
        this.f1685g = 0L;
        this.f1686h = null;
        this.f1687i = "";
        this.f1688j = 0;
        this.f1689k = null;
        this.f1682d = str;
        this.f1683e = j;
        this.f1684f = b;
        this.f1685g = j2;
        this.f1686h = c1249y;
        this.f1687i = str2;
        this.f1688j = i;
        this.f1689k = map;
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        this.f1682d = c1223k.m2937a(0, true);
        this.f1683e = c1223k.m2936a(this.f1683e, 1, true);
        this.f1684f = c1223k.m2942a(this.f1684f, 2, true);
        this.f1685g = c1223k.m2936a(this.f1685g, 3, false);
        if (f1679a == null) {
            f1679a = new C1249y();
        }
        this.f1686h = (C1249y) c1223k.m2933a((AbstractC1228m) f1679a, 4, false);
        this.f1687i = c1223k.m2937a(5, false);
        this.f1688j = c1223k.m2938a(this.f1688j, 6, false);
        if (f1680b == null) {
            HashMap hashMap = new HashMap();
            f1680b = hashMap;
            hashMap.put("", "");
        }
        this.f1689k = (Map) c1223k.m2932a((C1223k) f1680b, 7, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2902a(this.f1682d, 0);
        c1226l.m2906a(this.f1683e, 1);
        c1226l.m2911a(this.f1684f, 2);
        c1226l.m2906a(this.f1685g, 3);
        C1249y c1249y = this.f1686h;
        if (c1249y != null) {
            c1226l.m2905a((AbstractC1228m) c1249y, 4);
        }
        String str = this.f1687i;
        if (str != null) {
            c1226l.m2902a(str, 5);
        }
        c1226l.m2907a(this.f1688j, 6);
        Map<String, String> map = this.f1689k;
        if (map != null) {
            c1226l.m2900a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2855a(StringBuilder sb, int i) {
        C1219i c1219i = new C1219i(sb, i);
        c1219i.m2958a(this.f1682d, "eventType");
        c1219i.m2962a(this.f1683e, "eventTime");
        c1219i.m2967a(this.f1684f, "eventResult");
        c1219i.m2962a(this.f1685g, "eventElapse");
        c1219i.m2961a((AbstractC1228m) this.f1686h, "destAppInfo");
        c1219i.m2958a(this.f1687i, "strategyId");
        c1219i.m2963a(this.f1688j, "updateType");
        c1219i.m2956a((Map) this.f1689k, "reserved");
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (!f1681c) {
                throw new AssertionError();
            }
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C1250z c1250z = (C1250z) obj;
        return C1230n.m2884a(this.f1682d, c1250z.f1682d) && C1230n.m2885a(this.f1683e, c1250z.f1683e) && C1230n.m2887a(this.f1684f, c1250z.f1684f) && C1230n.m2885a(this.f1685g, c1250z.f1685g) && C1230n.m2884a(this.f1686h, c1250z.f1686h) && C1230n.m2884a(this.f1687i, c1250z.f1687i) && C1230n.m2886a(this.f1688j, c1250z.f1688j) && C1230n.m2884a(this.f1689k, c1250z.f1689k);
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
