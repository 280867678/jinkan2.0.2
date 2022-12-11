package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.proguard.e */
/* loaded from: classes3.dex */
public class C1211e extends C1209d {

    /* renamed from: i */
    public static HashMap<String, byte[]> f1495i;

    /* renamed from: j */
    public static HashMap<String, HashMap<String, byte[]>> f1496j;

    /* renamed from: k */
    public C1215g f1497k;

    /* renamed from: l */
    public int f1498l = 0;

    public C1211e() {
        C1215g c1215g = new C1215g();
        this.f1497k = c1215g;
        c1215g.f1509d = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.C1209d
    /* renamed from: a */
    public void mo2991a() {
        super.mo2991a();
        this.f1497k.f1509d = (short) 3;
    }

    /* renamed from: a */
    public void m2990a(int i) {
        this.f1497k.f1512g = i;
    }

    /* renamed from: a */
    public void m2989a(C1223k c1223k) {
        this.f1497k.mo2857a(c1223k);
    }

    /* renamed from: a */
    public void m2988a(C1226l c1226l) {
        this.f1497k.mo2856a(c1226l);
    }

    @Override // com.tencent.bugly.proguard.C1209d, com.tencent.bugly.proguard.C1207c
    /* renamed from: a */
    public <T> void mo2987a(String str, T t) {
        if (!str.startsWith(".")) {
            super.mo2987a(str, (String) t);
            return;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("put name can not startwith . , now is ", str));
    }

    /* renamed from: a */
    public void m2986a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                C1223k c1223k = new C1223k(bArr, 4);
                c1223k.m2931a(this.f1483d);
                m2989a(c1223k);
                if (this.f1497k.f1509d == 3) {
                    C1223k c1223k2 = new C1223k(this.f1497k.f1515j);
                    c1223k2.m2931a(this.f1483d);
                    if (f1495i == null) {
                        HashMap<String, byte[]> hashMap = new HashMap<>();
                        f1495i = hashMap;
                        hashMap.put("", new byte[0]);
                    }
                    this.f1486f = c1223k2.m2929a((Map) f1495i, 0, false);
                    return;
                }
                C1223k c1223k3 = new C1223k(this.f1497k.f1515j);
                c1223k3.m2931a(this.f1483d);
                if (f1496j == null) {
                    f1496j = new HashMap<>();
                    HashMap<String, byte[]> hashMap2 = new HashMap<>();
                    hashMap2.put("", new byte[0]);
                    f1496j.put("", hashMap2);
                }
                this.f1480a = c1223k3.m2929a((Map) f1496j, 0, false);
                this.f1481b = new HashMap<>();
                return;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    /* renamed from: b */
    public void m2984b(String str) {
        this.f1497k.f1514i = str;
    }

    /* renamed from: b */
    public byte[] m2985b() {
        C1215g c1215g = this.f1497k;
        if (c1215g.f1509d != 2) {
            if (c1215g.f1513h == null) {
                c1215g.f1513h = "";
            }
            C1215g c1215g2 = this.f1497k;
            if (c1215g2.f1514i == null) {
                c1215g2.f1514i = "";
            }
        } else if (c1215g.f1513h.equals("")) {
            throw new IllegalArgumentException("servantName can not is null");
        } else {
            if (this.f1497k.f1514i.equals("")) {
                throw new IllegalArgumentException("funcName can not is null");
            }
        }
        C1226l c1226l = new C1226l(0);
        c1226l.m2903a(this.f1483d);
        c1226l.m2900a((Map) (this.f1497k.f1509d == 2 ? this.f1480a : this.f1486f), 0);
        this.f1497k.f1515j = C1230n.m2883a(c1226l.m2912a());
        C1226l c1226l2 = new C1226l(0);
        c1226l2.m2903a(this.f1483d);
        m2988a(c1226l2);
        byte[] m2883a = C1230n.m2883a(c1226l2.m2912a());
        int length = m2883a.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(m2883a).flip();
        return allocate.array();
    }

    /* renamed from: c */
    public void m2983c(String str) {
        this.f1497k.f1513h = str;
    }
}
