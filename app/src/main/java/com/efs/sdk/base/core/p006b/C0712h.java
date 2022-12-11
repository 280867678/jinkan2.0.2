package com.efs.sdk.base.core.p006b;

import com.efs.sdk.base.core.p006b.C0701a;
import com.efs.sdk.base.core.p007c.HandlerC0714b;
import com.efs.sdk.base.core.p010d.C0739b;
import com.efs.sdk.base.core.util.C0769b;
import java.io.File;

/* renamed from: com.efs.sdk.base.core.b.h */
/* loaded from: classes3.dex */
public final class C0712h implements AbstractC0709f {
    @Override // com.efs.sdk.base.core.p006b.AbstractC0709f
    /* renamed from: a */
    public final boolean mo4151a(File file) {
        C0701a unused;
        C0739b m4030b = C0769b.m4030b(file.getName());
        if (m4030b != null) {
            return !"wa".equals(m4030b.f278a.f271a) && !HandlerC0714b.m4150a().m4148a(m4030b.f278a.f271a, file.length());
        }
        unused = C0701a.C0703b.f189a;
        C0701a.m4165b(file);
        return true;
    }
}
