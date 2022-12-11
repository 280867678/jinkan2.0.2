package org.fourthline.cling.support.avtransport;

import org.fourthline.cling.model.action.ActionException;
import org.fourthline.cling.model.types.ErrorCode;

/* loaded from: classes5.dex */
public class AVTransportException extends ActionException {
    public AVTransportException(int i, String str) {
        super(i, str);
    }

    public AVTransportException(int i, String str, Throwable th) {
        super(i, str, th);
    }

    public AVTransportException(ErrorCode errorCode) {
        super(errorCode);
    }

    public AVTransportException(ErrorCode errorCode, String str) {
        super(errorCode, str);
    }

    public AVTransportException(AVTransportErrorCode aVTransportErrorCode) {
        super(aVTransportErrorCode.getCode(), aVTransportErrorCode.getDescription());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AVTransportException(AVTransportErrorCode aVTransportErrorCode, String str) {
        super(r0, aVTransportErrorCode.getDescription() + ". " + str + ".");
        int code = aVTransportErrorCode.getCode();
    }
}
