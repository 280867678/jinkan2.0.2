package org.slf4j.helpers;

/* loaded from: classes5.dex */
public class FormattingTuple {
    public static FormattingTuple NULL = new FormattingTuple(null);
    public Object[] argArray;
    public String message;
    public Throwable throwable;

    public FormattingTuple(String str) {
        this(str, null, null);
    }

    public FormattingTuple(String str, Object[] objArr, Throwable th) {
        this.message = str;
        this.throwable = th;
        this.argArray = objArr;
    }

    public Object[] getArgArray() {
        return this.argArray;
    }

    public String getMessage() {
        return this.message;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }
}
