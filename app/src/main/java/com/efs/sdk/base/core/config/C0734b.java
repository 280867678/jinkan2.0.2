package com.efs.sdk.base.core.config;

import android.content.Context;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.NetworkUtil;

/* renamed from: com.efs.sdk.base.core.config.b */
/* loaded from: classes3.dex */
public final class C0734b {

    /* renamed from: a */
    public C0725a f257a;

    /* renamed from: b */
    public Context f258b;

    /* renamed from: com.efs.sdk.base.core.config.b$a */
    /* loaded from: classes3.dex */
    public static class C0735a {

        /* renamed from: a */
        public static final C0734b f259a = new C0734b((byte) 0);

        /* renamed from: a */
        public static /* synthetic */ C0734b m4103a() {
            return f259a;
        }
    }

    public C0734b() {
        this.f258b = ControllerCenter.getGlobalEnvStruct().mAppContext;
    }

    public /* synthetic */ C0734b(byte b) {
        this();
    }

    /* renamed from: a */
    public final String m4104a() {
        return this.f257a.m4132b("net", NetworkUtil.NETWORK_CLASS_DISCONNECTED).toString();
    }
}
