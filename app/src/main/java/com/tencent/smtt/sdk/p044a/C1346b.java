package com.tencent.smtt.sdk.p044a;

import me.tvspark.outline;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;

/* renamed from: com.tencent.smtt.sdk.a.b */
/* loaded from: classes4.dex */
public class C1346b {

    /* renamed from: a */
    public int f2049a;

    /* renamed from: b */
    public int f2050b;

    /* renamed from: c */
    public String f2051c;

    /* renamed from: d */
    public long f2052d;

    /* renamed from: a */
    public static C1346b m2659a(JSONObject jSONObject) {
        if (jSONObject != null) {
            C1346b c1346b = new C1346b();
            c1346b.f2049a = jSONObject.optInt("id", -1);
            c1346b.f2050b = jSONObject.optInt("cmd_id", -1);
            c1346b.f2051c = jSONObject.optString("ext_params", "");
            c1346b.f2052d = jSONObject.optLong("expiration", 0L) * 1000;
            return c1346b;
        }
        return null;
    }

    /* renamed from: a */
    public int m2660a() {
        return this.f2049a;
    }

    /* renamed from: b */
    public int m2658b() {
        return this.f2050b;
    }

    /* renamed from: c */
    public String m2657c() {
        return this.f2051c;
    }

    /* renamed from: d */
    public long m2656d() {
        return this.f2052d;
    }

    /* renamed from: e */
    public boolean m2655e() {
        return System.currentTimeMillis() > this.f2052d;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[id=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2049a);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", cmd=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2050b);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", extra='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2051c);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", expiration=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C1345a.m2661a(this.f2052d));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(']');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
