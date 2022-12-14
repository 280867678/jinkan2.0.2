package org.eclipse.jetty.p059io;

/* renamed from: org.eclipse.jetty.io.SimpleBuffers */
/* loaded from: classes4.dex */
public class SimpleBuffers implements Buffers {
    public final Buffer _buffer;
    public boolean _bufferOut;
    public final Buffer _header;
    public boolean _headerOut;

    public SimpleBuffers(Buffer buffer, Buffer buffer2) {
        this._header = buffer;
        this._buffer = buffer2;
    }

    @Override // org.eclipse.jetty.p059io.Buffers
    public Buffer getBuffer() {
        synchronized (this) {
            if (this._buffer != null && !this._bufferOut) {
                this._bufferOut = true;
                return this._buffer;
            } else if (this._buffer != null && this._header != null && this._header.capacity() == this._buffer.capacity() && !this._headerOut) {
                this._headerOut = true;
                return this._header;
            } else if (this._buffer != null) {
                return new ByteArrayBuffer(this._buffer.capacity());
            } else {
                return new ByteArrayBuffer(4096);
            }
        }
    }

    @Override // org.eclipse.jetty.p059io.Buffers
    public Buffer getBuffer(int i) {
        synchronized (this) {
            if (this._header != null && this._header.capacity() == i) {
                return getHeader();
            } else if (this._buffer == null || this._buffer.capacity() != i) {
                return null;
            } else {
                return getBuffer();
            }
        }
    }

    @Override // org.eclipse.jetty.p059io.Buffers
    public Buffer getHeader() {
        synchronized (this) {
            if (this._header != null && !this._headerOut) {
                this._headerOut = true;
                return this._header;
            } else if (this._buffer != null && this._header != null && this._header.capacity() == this._buffer.capacity() && !this._bufferOut) {
                this._bufferOut = true;
                return this._buffer;
            } else if (this._header != null) {
                return new ByteArrayBuffer(this._header.capacity());
            } else {
                return new ByteArrayBuffer(4096);
            }
        }
    }

    @Override // org.eclipse.jetty.p059io.Buffers
    public void returnBuffer(Buffer buffer) {
        synchronized (this) {
            buffer.clear();
            if (buffer == this._header) {
                this._headerOut = false;
            }
            if (buffer == this._buffer) {
                this._bufferOut = false;
            }
        }
    }
}
