package com.efs.sdk.base.core.p011e.p012a;

import com.efs.sdk.base.core.config.p008a.C0728b;
import com.efs.sdk.base.core.config.p008a.C0729c;
import com.efs.sdk.base.core.p010d.C0739b;

/* renamed from: com.efs.sdk.base.core.e.a.f */
/* loaded from: classes3.dex */
public final class C0748f extends AbstractC0743a {
    @Override // com.efs.sdk.base.core.p011e.p012a.AbstractC0743a
    /* renamed from: a */
    public final void mo4087a(C0739b c0739b) {
        Double d;
        C0729c m4127a = C0729c.m4127a();
        String str = c0739b.f278a.f271a;
        C0728b c0728b = m4127a.f248d;
        if (!(C0729c.f245a.nextDouble() * 100.0d <= ((!c0728b.f242e.containsKey(str) || (d = c0728b.f242e.get(str)) == null) ? 100.0d : d.doubleValue()))) {
            return;
        }
        m4089b(c0739b);
    }
}
