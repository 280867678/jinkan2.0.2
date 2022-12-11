package com.efs.sdk.base.protocol;

import com.efs.sdk.base.Constants;

/* loaded from: classes3.dex */
public abstract class AbsLog implements ILogProtocol {

    /* renamed from: cp */
    public String f338cp = Constants.CP_NONE;

    /* renamed from: de */
    public byte f339de = 1;
    public String logType;

    public AbsLog(String str) {
        this.logType = str;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLogType() {
        return this.logType;
    }

    public boolean isCp() {
        return !this.f338cp.equals(Constants.CP_NONE);
    }

    public boolean isDe() {
        return this.f339de != 1;
    }

    public void setCp(String str) {
        this.f338cp = str;
    }

    public void setDe(byte b) {
        this.f339de = b;
    }
}
