package com.efs.sdk.base.core.p011e.p012a;

import com.efs.sdk.base.core.config.p008a.C0729c;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p006b.AbstractC0708e;
import com.efs.sdk.base.core.p006b.C0701a;
import com.efs.sdk.base.core.p006b.HandlerC0705c;
import com.efs.sdk.base.core.p010d.C0739b;
import com.efs.sdk.base.core.p013f.C0759f;

/* renamed from: com.efs.sdk.base.core.e.a.b */
/* loaded from: classes3.dex */
public final class C0744b extends AbstractC0743a {
    @Override // com.efs.sdk.base.core.p011e.p012a.AbstractC0743a
    /* renamed from: a */
    public final void mo4087a(C0739b c0739b) {
        AbstractC0708e m4162a;
        byte[] bArr;
        if (c0739b.f279b.f282a) {
            m4089b(c0739b);
            return;
        }
        C0701a m4163a = C0701a.C0703b.m4163a();
        if ("wa".equals(c0739b.f278a.f271a) || HandlerC0705c.m4161a().f191a) {
            if ((c0739b.f278a.f273c == 0 && ((bArr = c0739b.f280c) == null || bArr.length == 0)) || (m4162a = m4163a.f187c.m4162a(c0739b.f278a.f272b)) == null) {
                return;
            }
            m4162a.mo4159a(c0739b);
            return;
        }
        if (!m4163a.f185a) {
            C0759f m4074a = C0759f.C0760a.m4074a();
            int i = C0729c.m4127a().f248d.f238a;
            if (m4074a.f306b != null || ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                m4074a.f306b.send(m4074a.m4076a("disk_limit", i));
            }
        }
        m4163a.f185a = true;
    }
}
