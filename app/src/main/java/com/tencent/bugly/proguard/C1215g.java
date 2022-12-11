package com.tencent.bugly.proguard;

import androidx.core.app.NotificationCompat;
import com.umeng.analytics.pro.C1615d;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.proguard.g */
/* loaded from: classes3.dex */
public final class C1215g extends AbstractC1228m {

    /* renamed from: j */
    public byte[] f1515j;

    /* renamed from: l */
    public Map<String, String> f1517l;

    /* renamed from: m */
    public Map<String, String> f1518m;

    /* renamed from: c */
    public static final /* synthetic */ boolean f1508c = !C1215g.class.desiredAssertionStatus();

    /* renamed from: a */
    public static byte[] f1506a = null;

    /* renamed from: b */
    public static Map<String, String> f1507b = null;

    /* renamed from: d */
    public short f1509d = 0;

    /* renamed from: e */
    public byte f1510e = 0;

    /* renamed from: f */
    public int f1511f = 0;

    /* renamed from: g */
    public int f1512g = 0;

    /* renamed from: h */
    public String f1513h = null;

    /* renamed from: i */
    public String f1514i = null;

    /* renamed from: k */
    public int f1516k = 0;

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2857a(C1223k c1223k) {
        try {
            this.f1509d = c1223k.m2927a(this.f1509d, 1, true);
            this.f1510e = c1223k.m2942a(this.f1510e, 2, true);
            this.f1511f = c1223k.m2938a(this.f1511f, 3, true);
            this.f1512g = c1223k.m2938a(this.f1512g, 4, true);
            this.f1513h = c1223k.m2937a(5, true);
            this.f1514i = c1223k.m2937a(6, true);
            if (f1506a == null) {
                f1506a = new byte[]{0};
            }
            this.f1515j = c1223k.m2924a(f1506a, 7, true);
            this.f1516k = c1223k.m2938a(this.f1516k, 8, true);
            if (f1507b == null) {
                HashMap hashMap = new HashMap();
                f1507b = hashMap;
                hashMap.put("", "");
            }
            this.f1517l = (Map) c1223k.m2932a((C1223k) f1507b, 9, true);
            if (f1507b == null) {
                HashMap hashMap2 = new HashMap();
                f1507b = hashMap2;
                hashMap2.put("", "");
            }
            this.f1518m = (Map) c1223k.m2932a((C1223k) f1507b, 10, true);
        } catch (Exception e) {
            e.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RequestPacket decode error ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C1213f.m2972a(this.f1515j));
            printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            throw new RuntimeException(e);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2856a(C1226l c1226l) {
        c1226l.m2899a(this.f1509d, 1);
        c1226l.m2911a(this.f1510e, 2);
        c1226l.m2907a(this.f1511f, 3);
        c1226l.m2907a(this.f1512g, 4);
        c1226l.m2902a(this.f1513h, 5);
        c1226l.m2902a(this.f1514i, 6);
        c1226l.m2897a(this.f1515j, 7);
        c1226l.m2907a(this.f1516k, 8);
        c1226l.m2900a((Map) this.f1517l, 9);
        c1226l.m2900a((Map) this.f1518m, 10);
    }

    @Override // com.tencent.bugly.proguard.AbstractC1228m
    /* renamed from: a */
    public void mo2855a(StringBuilder sb, int i) {
        C1219i c1219i = new C1219i(sb, i);
        c1219i.m2955a(this.f1509d, "iVersion");
        c1219i.m2967a(this.f1510e, "cPacketType");
        c1219i.m2963a(this.f1511f, "iMessageType");
        c1219i.m2963a(this.f1512g, "iRequestId");
        c1219i.m2958a(this.f1513h, "sServantName");
        c1219i.m2958a(this.f1514i, "sFuncName");
        c1219i.m2953a(this.f1515j, "sBuffer");
        c1219i.m2963a(this.f1516k, "iTimeout");
        c1219i.m2956a((Map) this.f1517l, C1615d.f3292R);
        c1219i.m2956a((Map) this.f1518m, NotificationCompat.CATEGORY_STATUS);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (!f1508c) {
                throw new AssertionError();
            }
            return null;
        }
    }

    public boolean equals(Object obj) {
        C1215g c1215g = (C1215g) obj;
        return C1230n.m2886a(1, (int) c1215g.f1509d) && C1230n.m2886a(1, (int) c1215g.f1510e) && C1230n.m2886a(1, c1215g.f1511f) && C1230n.m2886a(1, c1215g.f1512g) && C1230n.m2884a((Object) 1, (Object) c1215g.f1513h) && C1230n.m2884a((Object) 1, (Object) c1215g.f1514i) && C1230n.m2884a((Object) 1, (Object) c1215g.f1515j) && C1230n.m2886a(1, c1215g.f1516k) && C1230n.m2884a((Object) 1, (Object) c1215g.f1517l) && C1230n.m2884a((Object) 1, (Object) c1215g.f1518m);
    }
}
