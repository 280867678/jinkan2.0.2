package com.arialyy.aria.exception;

/* loaded from: classes3.dex */
public class AriaSFTPException extends AriaException {
    public static final String SFTP_EXCEPTION = "Aria SFTP Exception:";

    public AriaSFTPException(String str, String str2) {
        super(str, String.format("%s\n%s", SFTP_EXCEPTION, str2));
    }

    public AriaSFTPException(String str, String str2, Exception exc) {
        super(str, str2, exc);
    }
}
