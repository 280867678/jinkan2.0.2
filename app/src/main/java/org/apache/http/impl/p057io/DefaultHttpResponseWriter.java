package org.apache.http.impl.p057io;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.message.LineFormatter;
import org.apache.http.p058io.SessionOutputBuffer;

/* renamed from: org.apache.http.impl.io.DefaultHttpResponseWriter */
/* loaded from: classes4.dex */
public class DefaultHttpResponseWriter extends AbstractMessageWriter<HttpResponse> {
    public DefaultHttpResponseWriter(SessionOutputBuffer sessionOutputBuffer) {
        super(sessionOutputBuffer, null);
    }

    public DefaultHttpResponseWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter) {
        super(sessionOutputBuffer, lineFormatter);
    }

    @Override // org.apache.http.impl.p057io.AbstractMessageWriter
    public void writeHeadLine(HttpResponse httpResponse) throws IOException {
        this.lineFormatter.formatStatusLine(this.lineBuf, httpResponse.getStatusLine());
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
