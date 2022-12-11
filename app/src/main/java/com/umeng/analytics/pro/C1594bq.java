package com.umeng.analytics.pro;

import me.tvspark.outline;

/* renamed from: com.umeng.analytics.pro.bq */
/* loaded from: classes4.dex */
public final class C1594bq {

    /* renamed from: a */
    public final String f3228a;

    /* renamed from: b */
    public final byte f3229b;

    /* renamed from: c */
    public final int f3230c;

    public C1594bq() {
        this("", (byte) 0, 0);
    }

    public C1594bq(String str, byte b, int i) {
        this.f3228a = str;
        this.f3229b = b;
        this.f3230c = i;
    }

    /* renamed from: a */
    public boolean m1154a(C1594bq c1594bq) {
        return this.f3228a.equals(c1594bq.f3228a) && this.f3229b == c1594bq.f3229b && this.f3230c == c1594bq.f3230c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1594bq) {
            return m1154a((C1594bq) obj);
        }
        return false;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<TMessage name:'");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f3228a);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("' type: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append((int) this.f3229b);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" seqid:");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.f3230c, ">");
    }
}
