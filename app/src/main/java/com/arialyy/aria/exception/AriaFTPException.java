package com.arialyy.aria.exception;

/* loaded from: classes3.dex */
public class AriaFTPException extends AriaException {
    public static final String FTP_EXCEPTION = "Aria FTP Exception:";

    public AriaFTPException(String str, String str2) {
        super(str, String.format("%s\n%s", FTP_EXCEPTION, str2));
    }

    public AriaFTPException(String str, String str2, Exception exc) {
        super(str, str2, exc);
    }
}
