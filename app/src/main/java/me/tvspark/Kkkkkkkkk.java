package me.tvspark;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public class Kkkkkkkkk implements Closeable {
    public int Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwww;
    public final Charset Wwwwwwwwwwwwwwwwwwwwwww;
    public final InputStream Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends ByteArrayOutputStream {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, (i <= 0 || ((ByteArrayOutputStream) this).buf[i + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i - 1, Kkkkkkkkk.this.Wwwwwwwwwwwwwwwwwwwwwww.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public Kkkkkkkkk(InputStream inputStream, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(Kkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww = inputStream;
        this.Wwwwwwwwwwwwwwwwwwwwwww = charset;
        this.Wwwwwwwwwwwwwwwwwwwwww = new byte[8192];
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        int i;
        int i2;
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwwwwwwwww != null) {
                if (this.Wwwwwwwwwwwwwwwwwwwww >= this.Wwwwwwwwwwwwwwwwwwww) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                for (int i3 = this.Wwwwwwwwwwwwwwwwwwwww; i3 != this.Wwwwwwwwwwwwwwwwwwww; i3++) {
                    if (this.Wwwwwwwwwwwwwwwwwwwwww[i3] == 10) {
                        if (i3 != this.Wwwwwwwwwwwwwwwwwwwww) {
                            i2 = i3 - 1;
                            if (this.Wwwwwwwwwwwwwwwwwwwwww[i2] == 13) {
                                String str = new String(this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, i2 - this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww.name());
                                this.Wwwwwwwwwwwwwwwwwwwww = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, i2 - this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww.name());
                        this.Wwwwwwwwwwwwwwwwwwwww = i3 + 1;
                        return str2;
                    }
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((this.Wwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwww) + 80);
                loop1: while (true) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.write(this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwww = -1;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    i = this.Wwwwwwwwwwwwwwwwwwwww;
                    while (i != this.Wwwwwwwwwwwwwwwwwwww) {
                        if (this.Wwwwwwwwwwwwwwwwwwwwww[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.Wwwwwwwwwwwwwwwwwwwww) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.write(this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, i - this.Wwwwwwwwwwwwwwwwwwwww);
                }
                this.Wwwwwwwwwwwwwwwwwwwww = i + 1;
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        InputStream inputStream = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwww;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.Wwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwww = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwwwwwwwww != null) {
                this.Wwwwwwwwwwwwwwwwwwwwww = null;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.close();
            }
        }
    }
}
