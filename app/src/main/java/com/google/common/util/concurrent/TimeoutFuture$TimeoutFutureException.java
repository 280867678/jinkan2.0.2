package com.google.common.util.concurrent;

import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public final class TimeoutFuture$TimeoutFutureException extends TimeoutException {
    public TimeoutFuture$TimeoutFutureException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
