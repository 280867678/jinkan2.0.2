package org.fourthline.cling.support.connectionmanager;

import org.fourthline.cling.model.action.ActionException;
import org.fourthline.cling.model.types.ErrorCode;

/* loaded from: classes5.dex */
public class ConnectionManagerException extends ActionException {
    public ConnectionManagerException(int i, String str) {
        super(i, str);
    }

    public ConnectionManagerException(int i, String str, Throwable th) {
        super(i, str, th);
    }

    public ConnectionManagerException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ConnectionManagerException(ErrorCode errorCode, String str) {
        super(errorCode, str);
    }

    public ConnectionManagerException(ConnectionManagerErrorCode connectionManagerErrorCode) {
        super(connectionManagerErrorCode.getCode(), connectionManagerErrorCode.getDescription());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ConnectionManagerException(ConnectionManagerErrorCode connectionManagerErrorCode, String str) {
        super(r0, connectionManagerErrorCode.getDescription() + ". " + str + ".");
        int code = connectionManagerErrorCode.getCode();
    }
}
