package com.wutka.dtd;

import java.io.IOException;

/* loaded from: classes4.dex */
public class DTDParseException extends IOException {
    public int column;
    public int lineNumber;
    public String uriID;

    public DTDParseException() {
        this.uriID = "";
        this.lineNumber = -1;
        this.column = -1;
    }

    public DTDParseException(String str) {
        super(str);
        this.uriID = "";
        this.lineNumber = -1;
        this.column = -1;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DTDParseException(String str, int i, int i2) {
        super(r0.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("At line ");
        stringBuffer.append(i);
        stringBuffer.append(", column ");
        stringBuffer.append(i2);
        stringBuffer.append(": ");
        stringBuffer.append(str);
        this.uriID = "";
        this.lineNumber = i;
        this.column = i2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DTDParseException(String str, String str2, int i, int i2) {
        super(r0.toString());
        String str3;
        StringBuffer stringBuffer = new StringBuffer();
        if (str == null || str.length() <= 0) {
            str3 = "At ";
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("URI ");
            stringBuffer2.append(str);
            stringBuffer2.append(" at ");
            str3 = stringBuffer2.toString();
        }
        stringBuffer.append(str3);
        stringBuffer.append("line ");
        stringBuffer.append(i);
        stringBuffer.append(", column ");
        stringBuffer.append(i2);
        stringBuffer.append(": ");
        stringBuffer.append(str2);
        this.uriID = "";
        if (str != null) {
            this.uriID = str;
        }
        this.lineNumber = i;
        this.column = i2;
    }

    public int getColumn() {
        return this.column;
    }

    public String getId() {
        return this.uriID;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }
}
