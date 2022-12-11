package com.efs.sdk.base.core.p006b;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p010d.C0739b;
import com.efs.sdk.base.core.p013f.C0759f;
import com.efs.sdk.base.core.util.C0763a;
import com.efs.sdk.base.core.util.C0769b;
import java.io.File;

/* renamed from: com.efs.sdk.base.core.b.d */
/* loaded from: classes3.dex */
public final class C0707d implements AbstractC0708e {
    @Override // com.efs.sdk.base.core.p006b.AbstractC0708e
    /* renamed from: a */
    public final void mo4159a(C0739b c0739b) {
        C0759f c0759f;
        C0759f c0759f2;
        if (c0739b.f280c == null) {
            return;
        }
        C0769b.m4033a(new File(C0763a.m4044f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()), C0769b.m4038a(c0739b)), c0739b.f280c);
        c0759f = C0759f.C0760a.f309a;
        c0759f.f307c.m4084b();
        c0759f2 = C0759f.C0760a.f309a;
        c0759f2.f307c.m4083c();
    }

    @Override // com.efs.sdk.base.core.p006b.AbstractC0708e
    /* renamed from: a */
    public final void mo4157a(File file) {
        C0769b.m4035a(file, C0763a.m4044f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()));
    }

    @Override // com.efs.sdk.base.core.p006b.AbstractC0708e
    /* renamed from: a */
    public final void mo4155a(String str) {
    }

    @Override // com.efs.sdk.base.core.p006b.AbstractC0708e
    /* renamed from: a */
    public final boolean mo4156a(File file, C0739b c0739b) {
        if (!file.exists()) {
            return false;
        }
        c0739b.f281d = file;
        c0739b.m4092c();
        c0739b.m4093b(1);
        return true;
    }
}
