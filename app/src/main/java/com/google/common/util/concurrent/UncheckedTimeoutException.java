package com.google.common.util.concurrent;

/* loaded from: classes3.dex */
public class UncheckedTimeoutException extends RuntimeException {
    public static final long serialVersionUID = 0;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(String str) {
        super(str);
    }

    public UncheckedTimeoutException(String str, Throwable th) {
        super(str, th);
    }

    public UncheckedTimeoutException(Throwable th) {
        super(th);
    }
}
