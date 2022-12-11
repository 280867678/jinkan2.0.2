package org.fourthline.cling.model.action;

import org.fourthline.cling.model.types.ErrorCode;

/* loaded from: classes5.dex */
public class ActionException extends Exception {
    public int errorCode;

    public ActionException(int i, String str) {
        super(str);
        this.errorCode = i;
    }

    public ActionException(int i, String str, Throwable th) {
        super(str, th);
        this.errorCode = i;
    }

    public ActionException(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getDescription());
    }

    public ActionException(ErrorCode errorCode, String str) {
        this(errorCode, str, true);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ActionException(ErrorCode errorCode, String str, Throwable th) {
        this(r0, errorCode.getDescription() + ". " + str + ".", th);
        int code = errorCode.getCode();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ActionException(ErrorCode errorCode, String str, boolean z) {
        this(r0, str);
        int code = errorCode.getCode();
        if (z) {
            str = errorCode.getDescription() + ". " + str + ".";
        }
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
