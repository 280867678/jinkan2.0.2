package org.apache.commons.p056io.input;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.BoundedInputStream */
/* loaded from: classes4.dex */
public class BoundedInputStream extends InputStream {

    /* renamed from: in */
    public final InputStream f4548in;
    public long mark;
    public final long max;
    public long pos;
    public boolean propagateClose;

    public BoundedInputStream(InputStream inputStream) {
        this(inputStream, -1L);
    }

    public BoundedInputStream(InputStream inputStream, long j) {
        this.pos = 0L;
        this.mark = -1L;
        this.propagateClose = true;
        this.max = j;
        this.f4548in = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        long j = this.max;
        if (j < 0 || this.pos < j) {
            return this.f4548in.available();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.propagateClose) {
            this.f4548in.close();
        }
    }

    public boolean isPropagateClose() {
        return this.propagateClose;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.f4548in.mark(i);
        this.mark = this.pos;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f4548in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        long j = this.max;
        if (j < 0 || this.pos < j) {
            int read = this.f4548in.read();
            this.pos++;
            return read;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.max;
        if (j < 0 || this.pos < j) {
            long j2 = this.max;
            int read = this.f4548in.read(bArr, i, (int) (j2 >= 0 ? Math.min(i2, j2 - this.pos) : i2));
            if (read == -1) {
                return -1;
            }
            this.pos += read;
            return read;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f4548in.reset();
        this.pos = this.mark;
    }

    public void setPropagateClose(boolean z) {
        this.propagateClose = z;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long j2 = this.max;
        if (j2 >= 0) {
            j = Math.min(j, j2 - this.pos);
        }
        long skip = this.f4548in.skip(j);
        this.pos += skip;
        return skip;
    }

    public String toString() {
        return this.f4548in.toString();
    }
}
