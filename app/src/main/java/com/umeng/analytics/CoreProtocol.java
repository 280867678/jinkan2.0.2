package com.umeng.analytics;

import android.content.Context;
import com.stub.StubApp;
import com.umeng.analytics.pro.C1648o;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMSenderStateNotify;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class CoreProtocol implements UMLogDataProtocol, UMSenderStateNotify {

    /* renamed from: a */
    public static Context f2845a;

    /* renamed from: com.umeng.analytics.CoreProtocol$a */
    /* loaded from: classes4.dex */
    public static class C1511a {

        /* renamed from: a */
        public static final CoreProtocol f2846a = new CoreProtocol();
    }

    public CoreProtocol() {
    }

    public static CoreProtocol getInstance(Context context) {
        if (f2845a == null && context != null) {
            f2845a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return C1511a.f2846a;
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onConnectionAvailable() {
        C1648o.m985a(f2845a).m988a();
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onSenderIdle() {
        C1648o.m985a(f2845a).m976b();
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
        C1648o.m985a(f2845a).m984a(obj);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j) {
        return C1648o.m985a(f2845a).m987a(j);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i) {
        C1648o.m985a(f2845a).m983a(obj, i);
    }
}
