package org.fourthline.cling.support.contentdirectory;

import org.fourthline.cling.model.action.ActionException;
import org.fourthline.cling.model.types.ErrorCode;

/* loaded from: classes5.dex */
public class ContentDirectoryException extends ActionException {
    public ContentDirectoryException(int i, String str) {
        super(i, str);
    }

    public ContentDirectoryException(int i, String str, Throwable th) {
        super(i, str, th);
    }

    public ContentDirectoryException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ContentDirectoryException(ErrorCode errorCode, String str) {
        super(errorCode, str);
    }

    public ContentDirectoryException(ContentDirectoryErrorCode contentDirectoryErrorCode) {
        super(contentDirectoryErrorCode.getCode(), contentDirectoryErrorCode.getDescription());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ContentDirectoryException(ContentDirectoryErrorCode contentDirectoryErrorCode, String str) {
        super(r0, contentDirectoryErrorCode.getDescription() + ". " + str + ".");
        int code = contentDirectoryErrorCode.getCode();
    }
}
