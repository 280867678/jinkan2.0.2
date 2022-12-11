package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.d */
/* loaded from: classes4.dex */
public class C1785d extends AbstractC1782a {

    /* renamed from: a */
    public static final String f4093a = "idmd5";

    /* renamed from: b */
    public Context f4094b;

    public C1785d(Context context) {
        super("idmd5");
        this.f4094b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractC1782a
    /* renamed from: f */
    public String mo436f() {
        return DeviceConfig.getDeviceIdUmengMD5(this.f4094b);
    }
}
