package org.fourthline.cling.support.renderingcontrol;

import org.fourthline.cling.model.action.ActionException;
import org.fourthline.cling.model.types.ErrorCode;

/* loaded from: classes5.dex */
public class RenderingControlException extends ActionException {
    public RenderingControlException(int i, String str) {
        super(i, str);
    }

    public RenderingControlException(int i, String str, Throwable th) {
        super(i, str, th);
    }

    public RenderingControlException(ErrorCode errorCode) {
        super(errorCode);
    }

    public RenderingControlException(ErrorCode errorCode, String str) {
        super(errorCode, str);
    }

    public RenderingControlException(RenderingControlErrorCode renderingControlErrorCode) {
        super(renderingControlErrorCode.getCode(), renderingControlErrorCode.getDescription());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RenderingControlException(RenderingControlErrorCode renderingControlErrorCode, String str) {
        super(r0, renderingControlErrorCode.getDescription() + ". " + str + ".");
        int code = renderingControlErrorCode.getCode();
    }
}
