package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.f */
/* loaded from: classes4.dex */
public class C1788f extends AbstractC1782a {

    /* renamed from: a */
    public static final String f4107a = "imei";

    /* renamed from: b */
    public Context f4108b;

    public C1788f(Context context) {
        super(f4107a);
        this.f4108b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractC1782a
    /* renamed from: f */
    public String mo436f() {
        return DeviceConfig.getImeiNew(this.f4108b);
    }
}
