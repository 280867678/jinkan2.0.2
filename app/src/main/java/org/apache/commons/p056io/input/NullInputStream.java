package org.apache.commons.p056io.input;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.NullInputStream */
/* loaded from: classes4.dex */
public class NullInputStream extends InputStream {
    public boolean eof;
    public long mark;
    public final boolean markSupported;
    public long position;
    public long readlimit;
    public final long size;
    public final boolean throwEofException;

    public NullInputStream(long j) {
        this(j, true, false);
    }

    public NullInputStream(long j, boolean z, boolean z2) {
        this.mark = -1L;
        this.size = j;
        this.markSupported = z;
        this.throwEofException = z2;
    }

    private int doEndOfFile() throws EOFException {
        this.eof = true;
        if (!this.throwEofException) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // java.io.InputStream
    public int available() {
        long j = this.size - this.position;
        if (j <= 0) {
            return 0;
        }
        if (j <= 2147483647L) {
            return (int) j;
        }
        return Integer.MAX_VALUE;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.eof = false;
        this.position = 0L;
        this.mark = -1L;
    }

    public long getPosition() {
        return this.position;
    }

    public long getSize() {
        return this.size;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        if (!this.markSupported) {
            throw new UnsupportedOperationException("Mark not supported");
        }
        this.mark = this.position;
        this.readlimit = i;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.markSupported;
    }

    public int processByte() {
        return 0;
    }

    public void processBytes(byte[] bArr, int i, int i2) {
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.eof) {
            long j = this.position;
            if (j == this.size) {
                return doEndOfFile();
            }
            this.position = j + 1;
            return processByte();
        }
        throw new IOException("Read after end of file");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.eof) {
            long j = this.position;
            long j2 = this.size;
            if (j == j2) {
                return doEndOfFile();
            }
            long j3 = j + i2;
            this.position = j3;
            if (j3 > j2) {
                i2 -= (int) (j3 - j2);
                this.position = j2;
            }
            processBytes(bArr, i, i2);
            return i2;
        }
        throw new IOException("Read after end of file");
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        if (!this.markSupported) {
            throw new UnsupportedOperationException("Mark not supported");
        }
        if (this.mark < 0) {
            throw new IOException("No position has been marked");
        }
        if (this.position > this.mark + this.readlimit) {
            throw new IOException("Marked position [" + this.mark + "] is no longer valid - passed the read limit [" + this.readlimit + "]");
        }
        this.position = this.mark;
        this.eof = false;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (!this.eof) {
            long j2 = this.position;
            long j3 = this.size;
            if (j2 == j3) {
                return doEndOfFile();
            }
            long j4 = j2 + j;
            this.position = j4;
            if (j4 <= j3) {
                return j;
            }
            long j5 = j - (j4 - j3);
            this.position = j3;
            return j5;
        }
        throw new IOException("Skip after end of file");
    }
}
