package com.efs.sdk.net.p017a.p018a;

import java.io.ByteArrayOutputStream;

/* renamed from: com.efs.sdk.net.a.a.h */
/* loaded from: classes3.dex */
public final class C0822h {

    /* renamed from: a */
    public final AbstractC0816f f446a;

    /* renamed from: b */
    public ByteArrayOutputStream f447b;

    /* renamed from: c */
    public C0810a f448c;

    /* renamed from: d */
    public final String f449d;

    public C0822h(AbstractC0816f abstractC0816f, String str) {
        this.f446a = abstractC0816f;
        this.f449d = str;
    }

    /* renamed from: a */
    public final boolean m3943a() {
        return this.f447b != null;
    }

    /* renamed from: b */
    public final void m3942b() {
        if (m3943a()) {
            return;
        }
        throw new IllegalStateException("No body found; has createBodySink been called?");
    }
}
