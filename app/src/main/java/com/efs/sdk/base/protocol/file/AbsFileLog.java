package com.efs.sdk.base.protocol.file;

import com.efs.sdk.base.protocol.AbsLog;

/* loaded from: classes3.dex */
public abstract class AbsFileLog extends AbsLog {
    public AbsFileLog(String str) {
        super(str);
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public int getBodyType() {
        return 0;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getFilePath() {
        return null;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public byte getLogProtocol() {
        return (byte) 2;
    }
}
