package com.efs.sdk.base.core.p013f;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p013f.C0759f;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.efs.sdk.base.core.f.d */
/* loaded from: classes3.dex */
public final class HandlerC0757d extends AbstractHandlerC0754a {

    /* renamed from: c */
    public AtomicInteger f301c = new AtomicInteger(0);

    /* renamed from: d */
    public AtomicInteger f302d = new AtomicInteger(0);

    /* renamed from: b */
    public AtomicInteger f300b = new AtomicInteger(0);

    /* renamed from: e */
    public AtomicInteger f303e = new AtomicInteger(0);

    /* renamed from: f */
    public AtomicInteger f304f = new AtomicInteger(0);

    @Override // com.efs.sdk.base.core.p013f.AbstractHandlerC0754a
    /* renamed from: a */
    public final void mo4073a() {
        C0759f c0759f;
        if ((this.f301c.get() == 0 && this.f302d.get() == 0 && this.f300b.get() == 0 && this.f304f.get() == 0 && this.f303e.get() == 0) || this.f292a == null || !ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
            return;
        }
        ControllerCenter controllerCenter = this.f292a;
        int i = this.f301c.get();
        int i2 = this.f302d.get();
        int i3 = this.f300b.get();
        int i4 = this.f304f.get();
        int i5 = this.f303e.get();
        c0759f = C0759f.C0760a.f309a;
        C0755b c0755b = new C0755b("efs_core", "lf_st", c0759f.f305a.f299c);
        c0755b.put("create_cnt", Integer.valueOf(i));
        c0755b.put("cache_cnt", Integer.valueOf(i2));
        c0755b.put("req_cnt", Integer.valueOf(i3));
        c0755b.put("err_cnt", Integer.valueOf(i4));
        c0755b.put("expire_cnt", Integer.valueOf(i5));
        this.f301c.addAndGet(i * (-1));
        this.f302d.addAndGet(i2 * (-1));
        this.f300b.addAndGet(i3 * (-1));
        this.f304f.addAndGet(i4 * (-1));
        this.f303e.addAndGet(i5 * (-1));
        controllerCenter.send(c0755b);
    }

    /* renamed from: b */
    public final void m4084b() {
        this.f301c.incrementAndGet();
    }

    /* renamed from: c */
    public final void m4083c() {
        this.f302d.incrementAndGet();
    }

    /* renamed from: d */
    public final void m4082d() {
        this.f303e.incrementAndGet();
    }

    /* renamed from: e */
    public final void m4081e() {
        this.f304f.incrementAndGet();
    }
}
