package org.apache.http.impl.p057io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.p058io.SessionOutputBuffer;
import org.apache.http.util.Args;

/* renamed from: org.apache.http.impl.io.IdentityOutputStream */
/* loaded from: classes4.dex */
public class IdentityOutputStream extends OutputStream {
    public boolean closed = false;
    public final SessionOutputBuffer out;

    public IdentityOutputStream(SessionOutputBuffer sessionOutputBuffer) {
        this.out = (SessionOutputBuffer) Args.notNull(sessionOutputBuffer, "Session output buffer");
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
            this.out.write(i);
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
            this.out.write(bArr, i, i2);
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }
}
