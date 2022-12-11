package org.eclipse.jetty.p059io;

import java.io.IOException;

/* renamed from: org.eclipse.jetty.io.ByteArrayEndPoint */
/* loaded from: classes4.dex */
public class ByteArrayEndPoint implements ConnectedEndPoint {
    public boolean _closed;
    public Connection _connection;
    public boolean _growOutput;
    public ByteArrayBuffer _in;
    public byte[] _inBytes;
    public int _maxIdleTime;
    public boolean _nonBlocking;
    public ByteArrayBuffer _out;

    public ByteArrayEndPoint() {
    }

    public ByteArrayEndPoint(byte[] bArr, int i) {
        this._inBytes = bArr;
        this._in = new ByteArrayBuffer(bArr);
        this._out = new ByteArrayBuffer(i);
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public boolean blockReadable(long j) {
        return true;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public boolean blockWritable(long j) {
        return true;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public void close() throws IOException {
        this._closed = true;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public int fill(Buffer buffer) throws IOException {
        if (!this._closed) {
            ByteArrayBuffer byteArrayBuffer = this._in;
            if (byteArrayBuffer != null && byteArrayBuffer.length() > 0) {
                int put = buffer.put(this._in);
                this._in.skip(put);
                return put;
            }
            ByteArrayBuffer byteArrayBuffer2 = this._in;
            if (byteArrayBuffer2 != null && byteArrayBuffer2.length() == 0 && this._nonBlocking) {
                return 0;
            }
            close();
            return -1;
        }
        throw new IOException("CLOSED");
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public int flush(Buffer buffer) throws IOException {
        if (!this._closed) {
            if (this._growOutput && buffer.length() > this._out.space()) {
                this._out.compact();
                if (buffer.length() > this._out.space()) {
                    ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(buffer.length() + this._out.putIndex());
                    ByteArrayBuffer byteArrayBuffer2 = this._out;
                    byteArrayBuffer.put(byteArrayBuffer2.peek(0, byteArrayBuffer2.putIndex()));
                    if (this._out.getIndex() > 0) {
                        byteArrayBuffer.mark();
                        byteArrayBuffer.setGetIndex(this._out.getIndex());
                    }
                    this._out = byteArrayBuffer;
                }
            }
            int put = this._out.put(buffer);
            if (!buffer.isImmutable()) {
                buffer.skip(put);
            }
            return put;
        }
        throw new IOException("CLOSED");
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public int flush(Buffer buffer, Buffer buffer2, Buffer buffer3) throws IOException {
        if (!this._closed) {
            int i = 0;
            if (buffer != null && buffer.length() > 0) {
                i = flush(buffer);
            }
            if (buffer != null && buffer.length() != 0) {
                return i;
            }
            if (buffer2 != null && buffer2.length() > 0) {
                i += flush(buffer2);
            }
            return ((buffer2 == null || buffer2.length() == 0) && buffer3 != null && buffer3.length() > 0) ? i + flush(buffer3) : i;
        }
        throw new IOException("CLOSED");
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public void flush() throws IOException {
    }

    @Override // org.eclipse.jetty.p059io.ConnectedEndPoint
    public Connection getConnection() {
        return this._connection;
    }

    public ByteArrayBuffer getIn() {
        return this._in;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public String getLocalAddr() {
        return null;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public String getLocalHost() {
        return null;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public int getLocalPort() {
        return 0;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public int getMaxIdleTime() {
        return this._maxIdleTime;
    }

    public ByteArrayBuffer getOut() {
        return this._out;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public String getRemoteAddr() {
        return null;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public String getRemoteHost() {
        return null;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public int getRemotePort() {
        return 0;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public Object getTransport() {
        return this._inBytes;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public boolean isBlocking() {
        return !this._nonBlocking;
    }

    public boolean isGrowOutput() {
        return this._growOutput;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public boolean isInputShutdown() {
        return this._closed;
    }

    public boolean isNonBlocking() {
        return this._nonBlocking;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public boolean isOpen() {
        return !this._closed;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public boolean isOutputShutdown() {
        return this._closed;
    }

    public void reset() {
        this._closed = false;
        this._in.clear();
        this._out.clear();
        byte[] bArr = this._inBytes;
        if (bArr != null) {
            this._in.setPutIndex(bArr.length);
        }
    }

    @Override // org.eclipse.jetty.p059io.ConnectedEndPoint
    public void setConnection(Connection connection) {
        this._connection = connection;
    }

    public void setGrowOutput(boolean z) {
        this._growOutput = z;
    }

    public void setIn(ByteArrayBuffer byteArrayBuffer) {
        this._in = byteArrayBuffer;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public void setMaxIdleTime(int i) throws IOException {
        this._maxIdleTime = i;
    }

    public void setNonBlocking(boolean z) {
        this._nonBlocking = z;
    }

    public void setOut(ByteArrayBuffer byteArrayBuffer) {
        this._out = byteArrayBuffer;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public void shutdownInput() throws IOException {
        close();
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public void shutdownOutput() throws IOException {
        close();
    }
}
