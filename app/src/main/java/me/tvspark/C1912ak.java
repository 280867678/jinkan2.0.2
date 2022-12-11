package me.tvspark;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: me.tvspark.ak */
/* loaded from: classes4.dex */
public final class C1912ak extends InputStream {
    public long Wwwwwwwwwwwwwwwwwww;
    public final C1949bk Wwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwwwwwwwwww = false;
    public final byte[] Wwwwwwwwwwwwwwwwwwwwww = new byte[1];

    public C1912ak(AbstractC2863zj abstractC2863zj, C1949bk c1949bk) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2863zj;
        this.Wwwwwwwwwwwwwwwwwwwwwww = c1949bk;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.Wwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.close();
            this.Wwwwwwwwwwwwwwwwwwww = true;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.Wwwwwwwwwwwwwwwwwwwwww) == -1) {
            return -1;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwww[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!this.Wwwwwwwwwwwwwwwwwwww);
        if (!this.Wwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwww = true;
        }
        int read = this.Wwwwwwwwwwwwwwwwwwwwwwww.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.Wwwwwwwwwwwwwwwwwww += read;
        return read;
    }
}
