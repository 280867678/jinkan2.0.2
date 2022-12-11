package com.efs.sdk.memoryinfo;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.stub.StubApp;

/* renamed from: com.efs.sdk.memoryinfo.b */
/* loaded from: classes3.dex */
public final class C0794b {

    /* renamed from: a */
    public final EfsReporter f372a;

    /* renamed from: b */
    public boolean f373b = false;
    public final Context mContext;

    public C0794b(Context context, EfsReporter efsReporter) {
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f372a = efsReporter;
    }

    /* renamed from: a */
    public static /* synthetic */ void m3981a(C0794b c0794b, C0801e c0801e, String str) {
        C0799c c0799c = new C0799c(c0794b.mContext);
        EfsJSONLog efsJSONLog = new EfsJSONLog("memperf");
        efsJSONLog.put("w_pgid", str);
        efsJSONLog.put("crver", "0.0.2.umeng");
        efsJSONLog.put("k_st", c0799c.f388bg);
        efsJSONLog.put("w_url", c0799c.activity);
        efsJSONLog.put("wl_tpss", Long.valueOf(c0799c.f389n));
        efsJSONLog.put("wl_jpss", Long.valueOf(c0799c.f390o));
        efsJSONLog.put("wl_npss", Long.valueOf(c0799c.f391p));
        efsJSONLog.put("wl_heap", Long.valueOf(c0799c.f392q));
        efsJSONLog.put("wf_heap_used_rate", Float.valueOf(c0799c.f393r));
        efsJSONLog.put("wl_graphics", Long.valueOf(c0799c.f394s));
        efsJSONLog.put("wl_vmsize", Long.valueOf(c0799c.f395t));
        synchronized (C0801e.class) {
            if (c0801e.f404C) {
                c0801e.m3980a(efsJSONLog);
            } else {
                c0801e.f403B.add(efsJSONLog);
            }
        }
    }
}
