package com.efs.sdk.net.p017a;

import java.util.HashMap;

/* renamed from: com.efs.sdk.net.a.a */
/* loaded from: classes3.dex */
public final class C0809a {

    /* renamed from: c */
    public static C0809a f430c;

    /* renamed from: a */
    public HashMap<String, C0824b> f431a;

    /* renamed from: b */
    public HashMap<String, C0825c> f432b;

    public C0809a() {
        m3966b();
    }

    /* renamed from: a */
    public static C0809a m3968a() {
        if (f430c == null) {
            f430c = new C0809a();
        }
        return f430c;
    }

    /* renamed from: b */
    private void m3966b() {
        if (this.f431a == null) {
            this.f431a = new HashMap<>();
        }
        this.f431a.clear();
    }

    /* renamed from: a */
    public final C0824b m3967a(String str) {
        if (this.f431a == null) {
            m3966b();
        }
        C0824b c0824b = this.f431a.get(str);
        if (c0824b == null) {
            C0824b c0824b2 = new C0824b();
            c0824b2.f450a = str;
            c0824b2.f451b = System.currentTimeMillis();
            this.f431a.put(str, c0824b2);
            return c0824b2;
        }
        return c0824b;
    }

    /* renamed from: b */
    public final void m3965b(String str) {
        HashMap<String, C0824b> hashMap = this.f431a;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return;
        }
        this.f431a.remove(str);
    }

    /* renamed from: c */
    public final C0825c m3964c(String str) {
        if (this.f432b == null) {
            this.f432b = new HashMap<>();
        }
        if (this.f432b.containsKey(str)) {
            return this.f432b.get(str);
        }
        C0825c c0825c = new C0825c();
        c0825c.f485A = str;
        c0825c.f487C = System.currentTimeMillis();
        this.f432b.put(str, c0825c);
        return c0825c;
    }

    /* renamed from: d */
    public final void m3963d(String str) {
        HashMap<String, C0825c> hashMap = this.f432b;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return;
        }
        this.f432b.remove(str);
    }
}
