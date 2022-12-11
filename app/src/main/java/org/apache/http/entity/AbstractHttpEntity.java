package org.apache.http.entity;

import java.io.IOException;
import me.tvspark.outline;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

/* loaded from: classes4.dex */
public abstract class AbstractHttpEntity implements HttpEntity {
    public static final int OUTPUT_BUFFER_SIZE = 4096;
    public boolean chunked;
    public Header contentEncoding;
    public Header contentType;

    @Override // org.apache.http.HttpEntity
    @Deprecated
    public void consumeContent() throws IOException {
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentType() {
        return this.contentType;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        return this.chunked;
    }

    public void setChunked(boolean z) {
        this.chunked = z;
    }

    public void setContentEncoding(String str) {
        setContentEncoding(str != null ? new BasicHeader("Content-Encoding", str) : null);
    }

    public void setContentEncoding(Header header) {
        this.contentEncoding = header;
    }

    public void setContentType(String str) {
        setContentType(str != null ? new BasicHeader("Content-Type", str) : null);
    }

    public void setContentType(Header header) {
        this.contentType = header;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('[');
        if (this.contentType != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Content-Type: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.contentType.getValue());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(',');
        }
        if (this.contentEncoding != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Content-Encoding: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.contentEncoding.getValue());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(',');
        }
        long contentLength = getContentLength();
        if (contentLength >= 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Content-Length: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(contentLength);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(',');
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Chunked: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.chunked);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(']');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
