package org.apache.http.impl.p057io;

import java.io.IOException;
import org.apache.http.HttpRequest;
import org.apache.http.message.LineFormatter;
import org.apache.http.p058io.SessionOutputBuffer;

/* renamed from: org.apache.http.impl.io.DefaultHttpRequestWriter */
/* loaded from: classes4.dex */
public class DefaultHttpRequestWriter extends AbstractMessageWriter<HttpRequest> {
    public DefaultHttpRequestWriter(SessionOutputBuffer sessionOutputBuffer) {
        this(sessionOutputBuffer, null);
    }

    public DefaultHttpRequestWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter) {
        super(sessionOutputBuffer, lineFormatter);
    }

    @Override // org.apache.http.impl.p057io.AbstractMessageWriter
    public void writeHeadLine(HttpRequest httpRequest) throws IOException {
        this.lineFormatter.formatRequestLine(this.lineBuf, httpRequest.getRequestLine());
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
