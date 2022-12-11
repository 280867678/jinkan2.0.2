package com.jayway.jsonpath;

/* loaded from: classes3.dex */
public class ValueCompareException extends JsonPathException {
    public ValueCompareException() {
    }

    public ValueCompareException(Object obj, Object obj2) {
        super(String.format("Can not compare a %1s with a %2s", obj.getClass().getName(), obj2.getClass().getName()));
    }

    public ValueCompareException(String str) {
        super(str);
    }

    public ValueCompareException(String str, Throwable th) {
        super(str, th);
    }
}
