package org.apache.http.impl.p057io;

import java.io.IOException;
import java.io.InputStream;
import me.tvspark.outline;
import org.apache.http.ConnectionClosedException;
import org.apache.http.p058io.BufferInfo;
import org.apache.http.p058io.SessionInputBuffer;
import org.apache.http.util.Args;

/* renamed from: org.apache.http.impl.io.ContentLengthInputStream */
/* loaded from: classes4.dex */
public class ContentLengthInputStream extends InputStream {
    public static final int BUFFER_SIZE = 2048;
    public final long contentLength;

    /* renamed from: in */
    public SessionInputBuffer f4574in;
    public long pos = 0;
    public boolean closed = false;

    public ContentLengthInputStream(SessionInputBuffer sessionInputBuffer, long j) {
        this.f4574in = null;
        this.f4574in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        this.contentLength = Args.notNegative(j, "Content length");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        SessionInputBuffer sessionInputBuffer = this.f4574in;
        if (sessionInputBuffer instanceof BufferInfo) {
            return Math.min(((BufferInfo) sessionInputBuffer).length(), (int) (this.contentLength - this.pos));
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            try {
                if (this.pos >= this.contentLength) {
                }
                do {
                } while (read(new byte[2048]) >= 0);
            } finally {
                this.closed = true;
            }
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.closed) {
            if (this.pos >= this.contentLength) {
                return -1;
            }
            int read = this.f4574in.read();
            long j = this.pos;
            if (read != -1) {
                this.pos = j + 1;
            } else if (j < this.contentLength) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Premature end of Content-Length delimited message body (expected: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.contentLength);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("; received: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.pos);
                throw new ConnectionClosedException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            return read;
        }
        throw new IOException("Attempted read from closed stream.");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.closed) {
            long j = this.pos;
            long j2 = this.contentLength;
            if (j >= j2) {
                return -1;
            }
            if (i2 + j > j2) {
                i2 = (int) (j2 - j);
            }
            int read = this.f4574in.read(bArr, i, i2);
            if (read != -1 || this.pos >= this.contentLength) {
                if (read > 0) {
                    this.pos += read;
                }
                return read;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Premature end of Content-Length delimited message body (expected: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.contentLength);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("; received: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.pos);
            throw new ConnectionClosedException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        throw new IOException("Attempted read from closed stream.");
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        int read;
        if (j <= 0) {
            return 0L;
        }
        byte[] bArr = new byte[2048];
        long min = Math.min(j, this.contentLength - this.pos);
        long j2 = 0;
        while (min > 0 && (read = read(bArr, 0, (int) Math.min(2048L, min))) != -1) {
            long j3 = read;
            j2 += j3;
            min -= j3;
        }
        return j2;
    }
}
