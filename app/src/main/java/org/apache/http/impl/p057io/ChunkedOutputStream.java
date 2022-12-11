package org.apache.http.impl.p057io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.p058io.SessionOutputBuffer;

/* renamed from: org.apache.http.impl.io.ChunkedOutputStream */
/* loaded from: classes4.dex */
public class ChunkedOutputStream extends OutputStream {
    public final byte[] cache;
    public int cachePosition;
    public boolean closed;
    public final SessionOutputBuffer out;
    public boolean wroteLastChunk;

    public ChunkedOutputStream(int i, SessionOutputBuffer sessionOutputBuffer) {
        this.cachePosition = 0;
        this.wroteLastChunk = false;
        this.closed = false;
        this.cache = new byte[i];
        this.out = sessionOutputBuffer;
    }

    @Deprecated
    public ChunkedOutputStream(SessionOutputBuffer sessionOutputBuffer) throws IOException {
        this(2048, sessionOutputBuffer);
    }

    @Deprecated
    public ChunkedOutputStream(SessionOutputBuffer sessionOutputBuffer, int i) throws IOException {
        this(i, sessionOutputBuffer);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            finish();
            this.out.flush();
        }
    }

    public void finish() throws IOException {
        if (!this.wroteLastChunk) {
            flushCache();
            writeClosingChunk();
            this.wroteLastChunk = true;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flushCache();
        this.out.flush();
    }

    public void flushCache() throws IOException {
        int i = this.cachePosition;
        if (i > 0) {
            this.out.writeLine(Integer.toHexString(i));
            this.out.write(this.cache, 0, this.cachePosition);
            this.out.writeLine("");
            this.cachePosition = 0;
        }
    }

    public void flushCacheWithAppend(byte[] bArr, int i, int i2) throws IOException {
        this.out.writeLine(Integer.toHexString(this.cachePosition + i2));
        this.out.write(this.cache, 0, this.cachePosition);
        this.out.write(bArr, i, i2);
        this.out.writeLine("");
        this.cachePosition = 0;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        if (!this.closed) {
            byte[] bArr = this.cache;
            int i2 = this.cachePosition;
            bArr[i2] = (byte) i;
            int i3 = i2 + 1;
            this.cachePosition = i3;
            if (i3 != bArr.length) {
                return;
            }
            flushCache();
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.closed) {
            byte[] bArr2 = this.cache;
            int length = bArr2.length;
            int i3 = this.cachePosition;
            if (i2 >= length - i3) {
                flushCacheWithAppend(bArr, i, i2);
                return;
            }
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.cachePosition += i2;
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }

    public void writeClosingChunk() throws IOException {
        this.out.writeLine("0");
        this.out.writeLine("");
    }
}
