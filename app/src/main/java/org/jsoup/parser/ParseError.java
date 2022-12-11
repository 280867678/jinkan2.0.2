package org.jsoup.parser;

/* loaded from: classes5.dex */
public class ParseError {
    public String errorMsg;
    public int pos;

    public ParseError(int i, String str) {
        this.pos = i;
        this.errorMsg = str;
    }

    public ParseError(int i, String str, Object... objArr) {
        this.errorMsg = String.format(str, objArr);
        this.pos = i;
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }

    public int getPosition() {
        return this.pos;
    }

    public String toString() {
        return this.pos + ": " + this.errorMsg;
    }
}
