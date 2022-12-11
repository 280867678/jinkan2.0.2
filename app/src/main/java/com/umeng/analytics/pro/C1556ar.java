package com.umeng.analytics.pro;

import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.umeng.analytics.pro.ar */
/* loaded from: classes4.dex */
public class C1556ar {

    /* renamed from: a */
    public short[] f3125a;

    /* renamed from: b */
    public int f3126b = -1;

    public C1556ar(int i) {
        this.f3125a = new short[i];
    }

    /* renamed from: d */
    private void m1264d() {
        short[] sArr = this.f3125a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f3125a = sArr2;
    }

    /* renamed from: a */
    public short m1268a() {
        short[] sArr = this.f3125a;
        int i = this.f3126b;
        this.f3126b = i - 1;
        return sArr[i];
    }

    /* renamed from: a */
    public void m1267a(short s) {
        if (this.f3125a.length == this.f3126b + 1) {
            m1264d();
        }
        short[] sArr = this.f3125a;
        int i = this.f3126b + 1;
        this.f3126b = i;
        sArr[i] = s;
    }

    /* renamed from: b */
    public short m1266b() {
        return this.f3125a[this.f3126b];
    }

    /* renamed from: c */
    public void m1265c() {
        this.f3126b = -1;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<ShortStack vector:[");
        for (int i = 0; i < this.f3125a.length; i++) {
            if (i != 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
            }
            if (i == this.f3126b) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(">>");
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append((int) this.f3125a[i]);
            if (i == this.f3126b) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<<");
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]>");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
