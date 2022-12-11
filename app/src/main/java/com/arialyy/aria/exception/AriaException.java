package com.arialyy.aria.exception;

/* loaded from: classes3.dex */
public class AriaException extends Exception {
    public String tag;

    public AriaException(String str, String str2) {
        super(str2);
        this.tag = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AriaException(String str, String str2, Exception exc) {
        super(String.format("%s, %s\n%s", r0));
        Object[] objArr = new Object[3];
        objArr[0] = str;
        String str3 = "";
        objArr[1] = str2 == null ? str3 : str2;
        objArr[2] = exc != null ? exc.getMessage() : str3;
        this.tag = str;
    }

    public String getTag() {
        return this.tag;
    }
}
