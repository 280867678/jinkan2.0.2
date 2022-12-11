package com.efs.sdk.base.core.p013f;

import com.efs.sdk.base.core.controller.ControllerCenter;

/* renamed from: com.efs.sdk.base.core.f.f */
/* loaded from: classes3.dex */
public final class C0759f {

    /* renamed from: a */
    public C0756c f305a;

    /* renamed from: b */
    public ControllerCenter f306b;

    /* renamed from: c */
    public HandlerC0757d f307c;

    /* renamed from: d */
    public HandlerC0761g f308d;

    /* renamed from: com.efs.sdk.base.core.f.f$a */
    /* loaded from: classes3.dex */
    public static class C0760a {

        /* renamed from: a */
        public static final C0759f f309a = new C0759f((byte) 0);

        /* renamed from: a */
        public static /* synthetic */ C0759f m4074a() {
            return f309a;
        }
    }

    public C0759f() {
        this.f305a = new C0756c();
        this.f307c = new HandlerC0757d();
        this.f308d = new HandlerC0761g();
    }

    public /* synthetic */ C0759f(byte b) {
        this();
    }

    /* renamed from: a */
    public final C0755b m4076a(String str, int i) {
        C0755b c0755b = new C0755b("efs_core", str, this.f305a.f299c);
        c0755b.put("cver", Integer.valueOf(i));
        return c0755b;
    }

    /* renamed from: a */
    public final void m4078a(int i) {
        ControllerCenter controllerCenter = this.f306b;
        if (controllerCenter != null) {
            controllerCenter.send(m4076a("flow_limit", i));
        }
    }

    /* renamed from: a */
    public final void m4077a(int i, String str) {
        if (this.f306b != null || ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
            C0755b m4076a = m4076a("flow_limit_type", i);
            m4076a.put("code", str);
            this.f306b.send(m4076a);
        }
    }

    /* renamed from: a */
    public final void m4075a(String str, String str2, String str3) {
        this.f308d.m4072a(str, str2, str3);
    }
}
