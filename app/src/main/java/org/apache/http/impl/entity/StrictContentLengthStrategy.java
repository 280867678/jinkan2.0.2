package org.apache.http.impl.entity;

import me.tvspark.outline;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes4.dex */
public class StrictContentLengthStrategy implements ContentLengthStrategy {
    public static final StrictContentLengthStrategy INSTANCE = new StrictContentLengthStrategy();
    public final int implicitLen;

    public StrictContentLengthStrategy() {
        this(-1);
    }

    public StrictContentLengthStrategy(int i) {
        this.implicitLen = i;
    }

    @Override // org.apache.http.entity.ContentLengthStrategy
    public long determineLength(HttpMessage httpMessage) throws HttpException {
        Args.notNull(httpMessage, "HTTP message");
        Header firstHeader = httpMessage.getFirstHeader("Transfer-Encoding");
        if (firstHeader != null) {
            String value = firstHeader.getValue();
            if (!"chunked".equalsIgnoreCase(value)) {
                if (!"identity".equalsIgnoreCase(value)) {
                    throw new ProtocolException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unsupported transfer encoding: ", value));
                }
                return -1L;
            } else if (!httpMessage.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                return -2L;
            } else {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Chunked transfer encoding not allowed for ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(httpMessage.getProtocolVersion());
                throw new ProtocolException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }
        Header firstHeader2 = httpMessage.getFirstHeader("Content-Length");
        if (firstHeader2 == null) {
            return this.implicitLen;
        }
        String value2 = firstHeader2.getValue();
        try {
            long parseLong = Long.parseLong(value2);
            if (parseLong >= 0) {
                return parseLong;
            }
            throw new ProtocolException("Negative content length: " + value2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid content length: ", value2));
        }
    }
}
