package com.jayway.jsonpath;

/* loaded from: classes3.dex */
public class InvalidPathException extends JsonPathException {
    public InvalidPathException() {
    }

    public InvalidPathException(String str) {
        super(str);
    }

    public InvalidPathException(String str, Throwable th) {
        super(str, th);
    }

    public InvalidPathException(Throwable th) {
        super(th);
    }
}
