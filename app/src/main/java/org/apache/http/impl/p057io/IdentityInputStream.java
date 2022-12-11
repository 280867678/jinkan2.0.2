package org.apache.http.impl.p057io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.p058io.BufferInfo;
import org.apache.http.p058io.SessionInputBuffer;
import org.apache.http.util.Args;

/* renamed from: org.apache.http.impl.io.IdentityInputStream */
/* loaded from: classes4.dex */
public class IdentityInputStream extends InputStream {
    public boolean closed = false;

    /* renamed from: in */
    public final SessionInputBuffer f4575in;

    public IdentityInputStream(SessionInputBuffer sessionInputBuffer) {
        this.f4575in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        SessionInputBuffer sessionInputBuffer = this.f4575in;
        if (sessionInputBuffer instanceof BufferInfo) {
            return ((BufferInfo) sessionInputBuffer).length();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.closed) {
            return -1;
        }
        return this.f4575in.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.closed) {
            return -1;
        }
        return this.f4575in.read(bArr, i, i2);
    }
}
