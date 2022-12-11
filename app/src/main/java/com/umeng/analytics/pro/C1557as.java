package com.umeng.analytics.pro;

/* renamed from: com.umeng.analytics.pro.as */
/* loaded from: classes4.dex */
public class C1557as extends C1566az {

    /* renamed from: a */
    public static final int f3127a = 0;

    /* renamed from: b */
    public static final int f3128b = 1;

    /* renamed from: c */
    public static final int f3129c = 2;

    /* renamed from: d */
    public static final int f3130d = 3;

    /* renamed from: e */
    public static final int f3131e = 4;

    /* renamed from: f */
    public static final int f3132f = 5;

    /* renamed from: g */
    public static final int f3133g = 6;

    /* renamed from: h */
    public static final int f3134h = 7;

    /* renamed from: j */
    public static final C1601bx f3135j = new C1601bx("TApplicationException");

    /* renamed from: k */
    public static final C1591bn f3136k = new C1591bn("message", (byte) 11, 1);

    /* renamed from: l */
    public static final C1591bn f3137l = new C1591bn("type", (byte) 8, 2);

    /* renamed from: m */
    public static final long f3138m = 1;

    /* renamed from: i */
    public int f3139i;

    public C1557as() {
        this.f3139i = 0;
    }

    public C1557as(int i) {
        this.f3139i = 0;
        this.f3139i = i;
    }

    public C1557as(int i, String str) {
        super(str);
        this.f3139i = 0;
        this.f3139i = i;
    }

    public C1557as(String str) {
        super(str);
        this.f3139i = 0;
    }

    /* renamed from: a */
    public static C1557as m1262a(AbstractC1596bs abstractC1596bs) throws C1566az {
        abstractC1596bs.mo1127j();
        String str = null;
        int i = 0;
        while (true) {
            C1591bn mo1125l = abstractC1596bs.mo1125l();
            byte b = mo1125l.f3221b;
            if (b == 0) {
                abstractC1596bs.mo1126k();
                return new C1557as(i, str);
            }
            short s = mo1125l.f3222c;
            if (s != 1) {
                if (s == 2 && b == 8) {
                    i = abstractC1596bs.mo1114w();
                    abstractC1596bs.mo1124m();
                }
                C1599bv.m1108a(abstractC1596bs, b);
                abstractC1596bs.mo1124m();
            } else {
                if (b == 11) {
                    str = abstractC1596bs.mo1111z();
                    abstractC1596bs.mo1124m();
                }
                C1599bv.m1108a(abstractC1596bs, b);
                abstractC1596bs.mo1124m();
            }
        }
    }

    /* renamed from: a */
    public int m1263a() {
        return this.f3139i;
    }

    /* renamed from: b */
    public void m1261b(AbstractC1596bs abstractC1596bs) throws C1566az {
        abstractC1596bs.mo1140a(f3135j);
        if (getMessage() != null) {
            abstractC1596bs.mo1145a(f3136k);
            abstractC1596bs.mo1139a(getMessage());
            abstractC1596bs.mo1134c();
        }
        abstractC1596bs.mo1145a(f3137l);
        abstractC1596bs.mo1147a(this.f3139i);
        abstractC1596bs.mo1134c();
        abstractC1596bs.mo1133d();
        abstractC1596bs.mo1135b();
    }
}
