package com.umeng.commonsdk.statistics.idtracking;

import com.umeng.commonsdk.statistics.proto.C1810a;
import com.umeng.commonsdk.statistics.proto.C1817b;
import com.umeng.commonsdk.statistics.proto.C1824c;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.a */
/* loaded from: classes4.dex */
public abstract class AbstractC1782a {

    /* renamed from: a */
    public final int f4084a = 10;

    /* renamed from: b */
    public final int f4085b = 100;

    /* renamed from: c */
    public final String f4086c;

    /* renamed from: d */
    public List<C1810a> f4087d;

    /* renamed from: e */
    public C1817b f4088e;

    public AbstractC1782a(String str) {
        this.f4086c = str;
    }

    /* renamed from: g */
    private boolean m456g() {
        C1817b c1817b = this.f4088e;
        String m361b = c1817b == null ? null : c1817b.m361b();
        int m352h = c1817b == null ? 0 : c1817b.m352h();
        String m462a = m462a(mo436f());
        if (m462a == null || m462a.equals(m361b)) {
            return false;
        }
        if (c1817b == null) {
            c1817b = new C1817b();
        }
        c1817b.m363a(m462a);
        c1817b.m366a(System.currentTimeMillis());
        c1817b.m367a(m352h + 1);
        C1810a c1810a = new C1810a();
        c1810a.m402a(this.f4086c);
        c1810a.m396c(m462a);
        c1810a.m399b(m361b);
        c1810a.m405a(c1817b.m355e());
        if (this.f4087d == null) {
            this.f4087d = new ArrayList(2);
        }
        this.f4087d.add(c1810a);
        if (this.f4087d.size() > 10) {
            this.f4087d.remove(0);
        }
        this.f4088e = c1817b;
        return true;
    }

    /* renamed from: a */
    public String m462a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0 || "0".equals(trim) || "unknown".equals(trim.toLowerCase(Locale.US))) {
            return null;
        }
        return trim;
    }

    /* renamed from: a */
    public void m464a(C1817b c1817b) {
        this.f4088e = c1817b;
    }

    /* renamed from: a */
    public void m463a(C1824c c1824c) {
        this.f4088e = c1824c.m323c().get(this.f4086c);
        List<C1810a> m317h = c1824c.m317h();
        if (m317h == null || m317h.size() <= 0) {
            return;
        }
        if (this.f4087d == null) {
            this.f4087d = new ArrayList();
        }
        for (C1810a c1810a : m317h) {
            if (this.f4086c.equals(c1810a.f4150a)) {
                this.f4087d.add(c1810a);
            }
        }
    }

    /* renamed from: a */
    public void m461a(List<C1810a> list) {
        this.f4087d = list;
    }

    /* renamed from: a */
    public boolean m465a() {
        return m456g();
    }

    /* renamed from: b */
    public String m460b() {
        return this.f4086c;
    }

    /* renamed from: c */
    public boolean m459c() {
        C1817b c1817b = this.f4088e;
        return c1817b == null || c1817b.m352h() <= 100;
    }

    /* renamed from: d */
    public C1817b m458d() {
        return this.f4088e;
    }

    /* renamed from: e */
    public List<C1810a> m457e() {
        return this.f4087d;
    }

    /* renamed from: f */
    public abstract String mo436f();
}
