package javax.xml.stream;

import me.tvspark.pe0;

/* loaded from: classes4.dex */
public class XMLStreamException extends Exception {
    public pe0 location;
    public Throwable nested;

    public XMLStreamException() {
    }

    public XMLStreamException(String str) {
        super(str);
    }

    public XMLStreamException(String str, Throwable th) {
        super(str);
        this.nested = th;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public XMLStreamException(String str, pe0 pe0Var) {
        super(r0.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ParseError at [row,col]:[");
        stringBuffer.append(pe0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        stringBuffer.append(",");
        stringBuffer.append(pe0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        stringBuffer.append("]\n");
        stringBuffer.append("Message: ");
        stringBuffer.append(str);
        this.location = pe0Var;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public XMLStreamException(String str, pe0 pe0Var, Throwable th) {
        super(r0.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ParseError at [row,col]:[");
        stringBuffer.append(pe0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        stringBuffer.append(",");
        stringBuffer.append(pe0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        stringBuffer.append("]\n");
        stringBuffer.append("Message: ");
        stringBuffer.append(str);
        this.nested = th;
        this.location = pe0Var;
    }

    public XMLStreamException(Throwable th) {
        this.nested = th;
    }

    public pe0 getLocation() {
        return this.location;
    }

    public Throwable getNestedException() {
        return this.nested;
    }
}
