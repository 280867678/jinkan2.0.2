package org.apache.commons.p056io.output;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: org.apache.commons.io.output.BrokenOutputStream */
/* loaded from: classes4.dex */
public class BrokenOutputStream extends OutputStream {
    public final IOException exception;

    public BrokenOutputStream() {
        this(new IOException("Broken output stream"));
    }

    public BrokenOutputStream(IOException iOException) {
        this.exception = iOException;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        throw this.exception;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        throw this.exception;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        throw this.exception;
    }
}
