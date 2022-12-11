package com.jayway.jsonpath;

/* loaded from: classes3.dex */
public class InvalidJsonException extends JsonPathException {
    public final String json;

    public InvalidJsonException() {
        this.json = null;
    }

    public InvalidJsonException(String str) {
        super(str);
        this.json = null;
    }

    public InvalidJsonException(String str, Throwable th) {
        super(str, th);
        this.json = null;
    }

    public InvalidJsonException(Throwable th) {
        super(th);
        this.json = null;
    }

    public InvalidJsonException(Throwable th, String str) {
        super(th);
        this.json = str;
    }

    public String getJson() {
        return this.json;
    }
}
