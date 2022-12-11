package com.umeng.commonsdk.statistics.common;

import com.umeng.commonsdk.statistics.idtracking.C1783b;
import com.umeng.commonsdk.statistics.idtracking.C1784c;
import com.umeng.commonsdk.statistics.idtracking.C1788f;
import com.umeng.commonsdk.statistics.idtracking.C1789g;
import com.umeng.commonsdk.statistics.idtracking.C1790h;

/* loaded from: classes4.dex */
public enum DeviceTypeEnum {
    IMEI(C1788f.f4107a, C1788f.f4107a),
    OAID(C1790h.f4114d, C1790h.f4114d),
    ANDROIDID(C1783b.f4089a, C1783b.f4089a),
    MAC(C1789g.f4109a, C1789g.f4109a),
    SERIALNO("serial_no", "serial_no"),
    IDFA(C1784c.f4091a, C1784c.f4091a),
    DEFAULT("null", "null");
    
    public String description;
    public String deviceIdType;

    DeviceTypeEnum(String str, String str2) {
        this.deviceIdType = str;
        this.description = str2;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDeviceIdType() {
        return this.deviceIdType;
    }
}
