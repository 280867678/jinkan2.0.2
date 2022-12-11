package com.arialyy.aria.exception;

/* loaded from: classes3.dex */
public class AriaHTTPException extends AriaException {
    public static final String HTTP_EXCEPTION = "Aria HTTP Exception:";

    public AriaHTTPException(String str, String str2) {
        super(str, String.format("%s\n%s", HTTP_EXCEPTION, str2));
    }

    public AriaHTTPException(String str, String str2, Exception exc) {
        super(str, str2, exc);
    }
}
