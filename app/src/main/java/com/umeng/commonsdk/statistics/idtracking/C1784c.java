package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.c */
/* loaded from: classes4.dex */
public class C1784c extends AbstractC1782a {

    /* renamed from: a */
    public static final String f4091a = "idfa";

    /* renamed from: b */
    public Context f4092b;

    public C1784c(Context context) {
        super(f4091a);
        this.f4092b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractC1782a
    /* renamed from: f */
    public String mo436f() {
        return DeviceConfig.getIdfa(this.f4092b);
    }
}
