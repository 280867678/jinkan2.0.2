package com.arialyy.aria.exception;

/* loaded from: classes3.dex */
public class AriaM3U8Exception extends AriaException {
    public static final String M3U8_EXCEPTION = "Aria M3U8 Exception:";

    public AriaM3U8Exception(String str, String str2) {
        super(str, String.format("%s\n%s", M3U8_EXCEPTION, str2));
    }

    public AriaM3U8Exception(String str, String str2, Exception exc) {
        super(str, str2, exc);
    }
}
