package com.efs.sdk.memoryinfo;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.efs.sdk.memoryinfo.e */
/* loaded from: classes3.dex */
public class C0801e {

    /* renamed from: B */
    public final List<EfsJSONLog> f403B = new ArrayList();

    /* renamed from: C */
    public volatile boolean f404C;

    /* renamed from: a */
    public final EfsReporter f405a;

    public C0801e(final Context context, EfsReporter efsReporter) {
        this.f405a = efsReporter;
        String uMId = UMUtils.getUMId(context);
        this.f404C = !TextUtils.isEmpty(uMId);
        if (!this.f404C) {
            ImprintHandler.getImprintService(context).registImprintCallback(C1543ak.f3036g, new UMImprintChangeCallback() { // from class: com.efs.sdk.memoryinfo.e.1
                @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                public final void onImprintValueChanged(String str, String str2) {
                    try {
                        if (!C1543ak.f3036g.equals(str)) {
                            return;
                        }
                        HashMap hashMap = new HashMap(1);
                        hashMap.put(UMCrash.KEY_HEADER_UMID, str2);
                        C0801e.this.f405a.addPublicParams(hashMap);
                        synchronized (C0801e.class) {
                            C0801e.this.f404C = true;
                        }
                        for (EfsJSONLog efsJSONLog : C0801e.this.f403B) {
                            C0801e.this.m3980a(efsJSONLog);
                        }
                        C0801e.this.f403B.size();
                        boolean z = C0793a.DEBUG;
                        C0801e.this.f403B.clear();
                        ImprintHandler.getImprintService(context).unregistImprintCallback(C1543ak.f3036g, this);
                    } catch (Throwable th) {
                        C0803f.m3973a("umid ", th);
                    }
                }
            });
            return;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(UMCrash.KEY_HEADER_UMID, uMId);
        this.f405a.addPublicParams(hashMap);
    }

    /* renamed from: a */
    public final void m3980a(EfsJSONLog efsJSONLog) {
        try {
            this.f405a.send(efsJSONLog);
        } catch (Throwable th) {
            C0803f.m3973a("send", th);
        }
    }
}
