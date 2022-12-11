package com.google.common.util.concurrent;

/* loaded from: classes3.dex */
public class ExecutionError extends Error {
    public static final long serialVersionUID = 0;

    public ExecutionError() {
    }

    public ExecutionError(Error error) {
        super(error);
    }

    public ExecutionError(String str) {
        super(str);
    }

    public ExecutionError(String str, Error error) {
        super(str, error);
    }
}
