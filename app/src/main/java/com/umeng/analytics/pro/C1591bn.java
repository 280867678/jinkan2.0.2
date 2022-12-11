package com.umeng.analytics.pro;

import me.tvspark.outline;

/* renamed from: com.umeng.analytics.pro.bn */
/* loaded from: classes4.dex */
public class C1591bn {

    /* renamed from: a */
    public final String f3220a;

    /* renamed from: b */
    public final byte f3221b;

    /* renamed from: c */
    public final short f3222c;

    public C1591bn() {
        this("", (byte) 0, (short) 0);
    }

    public C1591bn(String str, byte b, short s) {
        this.f3220a = str;
        this.f3221b = b;
        this.f3222c = s;
    }

    /* renamed from: a */
    public boolean m1155a(C1591bn c1591bn) {
        return this.f3221b == c1591bn.f3221b && this.f3222c == c1591bn.f3222c;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<TField name:'");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f3220a);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("' type:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append((int) this.f3221b);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" field-id:");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (int) this.f3222c, ">");
    }
}
