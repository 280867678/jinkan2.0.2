package com.efs.sdk.base.core.p011e.p012a;

import com.efs.sdk.base.core.p007c.HandlerC0714b;
import com.efs.sdk.base.core.p007c.HandlerC0719d;
import com.efs.sdk.base.core.p010d.C0739b;
import com.efs.sdk.base.core.p013f.C0759f;
import com.efs.sdk.base.http.HttpResponse;

/* renamed from: com.efs.sdk.base.core.e.a.e */
/* loaded from: classes3.dex */
public final class C0747e extends AbstractC0743a {
    @Override // com.efs.sdk.base.core.p011e.p012a.AbstractC0743a
    /* renamed from: a */
    public final void mo4087a(C0739b c0739b) {
        HttpResponse mo4080a;
        if (!c0739b.f279b.f282a) {
            m4089b(c0739b);
            return;
        }
        HandlerC0719d m4141a = HandlerC0719d.m4141a();
        if (!c0739b.f279b.f283b || HandlerC0714b.m4150a().m4148a(c0739b.f278a.f271a, c0739b.m4099a())) {
            C0759f.C0760a.m4074a().f307c.m4084b();
            C0759f.C0760a.m4074a().f307c.m4083c();
            mo4080a = m4141a.f207b.mo4080a(c0739b, false);
        } else {
            mo4080a = new HttpResponse();
            mo4080a.data = "flow_limit";
        }
        c0739b.f279b.f284c = mo4080a;
        m4089b(c0739b);
    }
}
