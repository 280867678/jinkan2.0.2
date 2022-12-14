package org.eclipse.jetty.server;

import java.io.IOException;
import javax.servlet.ServletInputStream;
import org.eclipse.jetty.http.HttpParser;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.EofException;

/* loaded from: classes4.dex */
public class HttpInput extends ServletInputStream {
    public final AbstractHttpConnection _connection;
    public final HttpParser _parser;

    public HttpInput(AbstractHttpConnection abstractHttpConnection) {
        this._connection = abstractHttpConnection;
        this._parser = (HttpParser) abstractHttpConnection.getParser();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this._parser.available();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) < 0) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        Buffer blockForContent = this._parser.blockForContent(this._connection.getMaxIdleTime());
        if (blockForContent != null) {
            return blockForContent.get(bArr, i, i2);
        }
        if (this._connection.isEarlyEOF()) {
            throw new EofException("early EOF");
        }
        return -1;
    }
}
