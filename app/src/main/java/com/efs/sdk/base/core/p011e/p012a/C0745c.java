package com.efs.sdk.base.core.p011e.p012a;

import com.efs.sdk.base.core.p010d.C0739b;
import com.efs.sdk.base.core.util.C0775c;
import com.efs.sdk.base.core.util.Log;

/* renamed from: com.efs.sdk.base.core.e.a.c */
/* loaded from: classes3.dex */
public final class C0745c extends AbstractC0743a {
    /* renamed from: c */
    public static boolean m4088c(C0739b c0739b) {
        return c0739b.m4094b() || (1 == c0739b.f278a.f272b && !c0739b.f279b.f282a) || 1 == c0739b.f278a.f273c;
    }

    @Override // com.efs.sdk.base.core.p011e.p012a.AbstractC0743a
    /* renamed from: a */
    public final void mo4087a(C0739b c0739b) {
        if (m4088c(c0739b)) {
            m4089b(c0739b);
            return;
        }
        byte[] m4014a = C0775c.m4014a(c0739b.f280c);
        if (m4014a == null) {
            Log.m4054w("efs.base", "gzip error");
        } else {
            c0739b.m4095a(m4014a);
            c0739b.m4096a("gzip");
        }
        m4089b(c0739b);
    }
}
