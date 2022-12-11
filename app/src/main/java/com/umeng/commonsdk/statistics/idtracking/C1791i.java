package com.umeng.commonsdk.statistics.idtracking;

import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.i */
/* loaded from: classes4.dex */
public class C1791i extends AbstractC1782a {

    /* renamed from: a */
    public static final String f4116a = "serial";

    public C1791i() {
        super(f4116a);
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractC1782a
    /* renamed from: f */
    public String mo436f() {
        return DeviceConfig.getSerial();
    }
}
