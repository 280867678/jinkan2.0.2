package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.g */
/* loaded from: classes4.dex */
public class C1789g extends AbstractC1782a {

    /* renamed from: a */
    public static final String f4109a = "mac";

    /* renamed from: b */
    public Context f4110b;

    public C1789g(Context context) {
        super(f4109a);
        this.f4110b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractC1782a
    /* renamed from: f */
    public String mo436f() {
        try {
            return DeviceConfig.getMac(this.f4110b);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                e.printStackTrace();
            }
            UMCrashManager.reportCrash(this.f4110b, e);
            return null;
        }
    }
}
