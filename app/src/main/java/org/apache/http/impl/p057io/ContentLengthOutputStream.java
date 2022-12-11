package org.apache.http.impl.p057io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.p058io.SessionOutputBuffer;
import org.apache.http.util.Args;

/* renamed from: org.apache.http.impl.io.ContentLengthOutputStream */
/* loaded from: classes4.dex */
public class ContentLengthOutputStream extends OutputStream {
    public final long contentLength;
    public final SessionOutputBuffer out;
    public long total = 0;
    public boolean closed = false;

    public ContentLengthOutputStream(SessionOutputBuffer sessionOutputBuffer, long j) {
        this.out = (SessionOutputBuffer) Args.notNull(sessionOutputBuffer, "Session output buffer");
        this.contentLength = Args.notNegative(j, "Content length");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.out.flush();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        if (!this.closed) {
            if (this.total >= this.contentLength) {
                return;
            }
            this.out.write(i);
            this.total++;
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
            long j = this.total;
            long j2 = this.contentLength;
            if (j >= j2) {
                return;
            }
            long j3 = j2 - j;
            if (i2 > j3) {
                i2 = (int) j3;
            }
            this.out.write(bArr, i, i2);
            this.total += i2;
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }
}
