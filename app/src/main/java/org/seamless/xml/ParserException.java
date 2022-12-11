package org.seamless.xml;

import me.tvspark.outline;
import org.xml.sax.SAXParseException;

/* loaded from: classes5.dex */
public class ParserException extends Exception {
    public ParserException() {
    }

    public ParserException(String str) {
        super(str);
    }

    public ParserException(String str, Throwable th) {
        super(str, th);
    }

    public ParserException(Throwable th) {
        super(th);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ParserException(SAXParseException sAXParseException) {
        super(r0.toString());
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(Line/Column: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(sAXParseException.getLineNumber());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(sAXParseException.getColumnNumber());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(sAXParseException.getMessage());
    }
}
