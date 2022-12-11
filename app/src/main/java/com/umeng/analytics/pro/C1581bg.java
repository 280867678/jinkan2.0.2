package com.umeng.analytics.pro;

import java.io.Serializable;

/* renamed from: com.umeng.analytics.pro.bg */
/* loaded from: classes4.dex */
public class C1581bg implements Serializable {

    /* renamed from: a */
    public final boolean f3163a;

    /* renamed from: b */
    public final byte f3164b;

    /* renamed from: c */
    public final String f3165c;

    /* renamed from: d */
    public final boolean f3166d;

    public C1581bg(byte b) {
        this(b, false);
    }

    public C1581bg(byte b, String str) {
        this.f3164b = b;
        this.f3163a = true;
        this.f3165c = str;
        this.f3166d = false;
    }

    public C1581bg(byte b, boolean z) {
        this.f3164b = b;
        this.f3163a = false;
        this.f3165c = null;
        this.f3166d = z;
    }

    /* renamed from: a */
    public boolean m1184a() {
        return this.f3163a;
    }

    /* renamed from: b */
    public String m1183b() {
        return this.f3165c;
    }

    /* renamed from: c */
    public boolean m1182c() {
        return this.f3164b == 12;
    }

    /* renamed from: d */
    public boolean m1181d() {
        byte b = this.f3164b;
        return b == 15 || b == 13 || b == 14;
    }

    /* renamed from: e */
    public boolean m1180e() {
        return this.f3166d;
    }
}
