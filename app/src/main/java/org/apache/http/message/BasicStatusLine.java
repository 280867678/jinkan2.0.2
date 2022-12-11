package org.apache.http.message;

import java.io.Serializable;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes4.dex */
public class BasicStatusLine implements StatusLine, Cloneable, Serializable {
    public static final long serialVersionUID = -2443303766890459269L;
    public final ProtocolVersion protoVersion;
    public final String reasonPhrase;
    public final int statusCode;

    public BasicStatusLine(ProtocolVersion protocolVersion, int i, String str) {
        this.protoVersion = (ProtocolVersion) Args.notNull(protocolVersion, "Version");
        this.statusCode = Args.notNegative(i, "Status code");
        this.reasonPhrase = str;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // org.apache.http.StatusLine
    public ProtocolVersion getProtocolVersion() {
        return this.protoVersion;
    }

    @Override // org.apache.http.StatusLine
    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    @Override // org.apache.http.StatusLine
    public int getStatusCode() {
        return this.statusCode;
    }

    public String toString() {
        return BasicLineFormatter.INSTANCE.formatStatusLine((CharArrayBuffer) null, this).toString();
    }
}
