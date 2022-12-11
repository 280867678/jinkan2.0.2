package com.efs.sdk.base.core.p011e.p012a;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p010d.C0739b;
import com.efs.sdk.base.core.p011e.C0749b;
import com.efs.sdk.base.processor.action.ILogEncryptAction;

/* renamed from: com.efs.sdk.base.core.e.a.d */
/* loaded from: classes3.dex */
public final class C0746d extends AbstractC0743a {

    /* renamed from: b */
    public ILogEncryptAction f287b;

    public C0746d() {
        this.f287b = ControllerCenter.getGlobalEnvStruct().getLogEncryptAction() == null ? new C0749b() : ControllerCenter.getGlobalEnvStruct().getLogEncryptAction();
    }

    @Override // com.efs.sdk.base.core.p011e.p012a.AbstractC0743a
    /* renamed from: a */
    public final void mo4087a(C0739b c0739b) {
        boolean z = false;
        if ((1 != c0739b.f278a.f275e) || "wa".equals(c0739b.f278a.f271a) || Constants.LOG_TYPE_STARTPERF.equals(c0739b.f278a.f271a) || ((1 == c0739b.f278a.f272b && !c0739b.f279b.f282a) || 1 == c0739b.f278a.f273c)) {
            z = true;
        }
        if (z) {
            m4089b(c0739b);
            return;
        }
        byte[] encrypt = this.f287b.encrypt(ControllerCenter.getGlobalEnvStruct().getSecret(), c0739b.f280c);
        if (encrypt != null) {
            c0739b.m4095a(encrypt);
            c0739b.m4098a(this.f287b.getDeVal());
        }
        m4089b(c0739b);
    }
}
