package org.eclipse.jetty.p059io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* renamed from: org.eclipse.jetty.io.WriterOutputStream */
/* loaded from: classes4.dex */
public class WriterOutputStream extends OutputStream {
    public final byte[] _buf;
    public final String _encoding;
    public final Writer _writer;

    public WriterOutputStream(Writer writer) {
        this._buf = new byte[1];
        this._writer = writer;
        this._encoding = null;
    }

    public WriterOutputStream(Writer writer, String str) {
        this._buf = new byte[1];
        this._writer = writer;
        this._encoding = str;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this._writer.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this._writer.flush();
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        this._buf[0] = (byte) i;
        write(this._buf);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        Writer writer;
        String str;
        if (this._encoding == null) {
            writer = this._writer;
            str = new String(bArr);
        } else {
            writer = this._writer;
            str = new String(bArr, this._encoding);
        }
        writer.write(str);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        Writer writer;
        String str;
        if (this._encoding == null) {
            writer = this._writer;
            str = new String(bArr, i, i2);
        } else {
            writer = this._writer;
            str = new String(bArr, i, i2, this._encoding);
        }
        writer.write(str);
    }
}
