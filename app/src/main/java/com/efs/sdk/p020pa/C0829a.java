package com.efs.sdk.p020pa;

import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;

/* renamed from: com.efs.sdk.pa.a */
/* loaded from: classes3.dex */
public final class C0829a implements PAANRListener {

    /* renamed from: a */
    public PAFactory f499a;

    /* renamed from: b */
    public PATraceListener f500b;

    public C0829a(PAFactory pAFactory) {
        this.f499a = pAFactory;
        this.f500b = pAFactory.getTraceListener();
        boolean enableTracer = pAFactory.getConfigManager().enableTracer();
        if (enableTracer || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            C0843c.m3935a(this.f499a, "patracepv", null);
        }
        PATraceListener pATraceListener = this.f500b;
        if (pATraceListener != null) {
            pATraceListener.onCheck(enableTracer);
        }
    }

    @Override // com.efs.sdk.p020pa.PAANRListener
    public final void anrStack(String str) {
        if (str == null || str.length() <= 200) {
            return;
        }
        C0843c.m3935a(this.f499a, "patrace", str);
        PATraceListener pATraceListener = this.f500b;
        if (pATraceListener == null) {
            return;
        }
        pATraceListener.onAnrTrace();
    }

    @Override // com.efs.sdk.p020pa.PAANRListener
    public final void unexcept(Object obj) {
        PATraceListener pATraceListener = this.f500b;
        if (pATraceListener != null) {
            pATraceListener.onUnexcept(obj);
        }
    }
}
