package org.mozilla.javascript.tools.idswitch;

/* loaded from: classes5.dex */
public class IdValuePair {

    /* renamed from: id */
    public final String f4741id;
    public final int idLength;
    public int lineNumber;
    public final String value;

    public IdValuePair(String str, String str2) {
        this.idLength = str.length();
        this.f4741id = str;
        this.value = str2;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(int i) {
        this.lineNumber = i;
    }
}
