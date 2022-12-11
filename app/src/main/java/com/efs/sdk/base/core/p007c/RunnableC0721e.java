package com.efs.sdk.base.core.p007c;

import com.efs.sdk.base.core.p010d.C0739b;
import com.efs.sdk.base.http.HttpResponse;

/* renamed from: com.efs.sdk.base.core.c.e */
/* loaded from: classes3.dex */
public final class RunnableC0721e implements Runnable {

    /* renamed from: a */
    public C0739b f213a;

    /* renamed from: b */
    public AbstractC0718c f214b;

    /* renamed from: c */
    public String f215c;

    public RunnableC0721e(C0739b c0739b, AbstractC0718c abstractC0718c, String str) {
        this.f213a = c0739b;
        this.f214b = abstractC0718c;
        this.f215c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC0718c abstractC0718c;
        C0739b c0739b = this.f213a;
        HttpResponse httpResponse = (c0739b == null || (abstractC0718c = this.f214b) == null) ? new HttpResponse() : abstractC0718c.mo4080a(c0739b, true);
        HandlerC0719d.m4141a().m4140a(this.f215c, httpResponse.succ ? 0 : httpResponse.getHttpCode());
        this.f215c = null;
        this.f214b = null;
    }
}
