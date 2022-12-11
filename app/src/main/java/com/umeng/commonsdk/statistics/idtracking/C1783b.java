package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.b */
/* loaded from: classes4.dex */
public class C1783b extends AbstractC1782a {

    /* renamed from: a */
    public static final String f4089a = "android_id";

    /* renamed from: b */
    public Context f4090b;

    public C1783b(Context context) {
        super(f4089a);
        this.f4090b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractC1782a
    /* renamed from: f */
    public String mo436f() {
        return DeviceConfig.getAndroidId(this.f4090b);
    }
}
