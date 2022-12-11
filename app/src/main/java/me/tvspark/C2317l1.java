package me.tvspark;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: me.tvspark.l1 */
/* loaded from: classes4.dex */
public final class C2317l1 extends FilterInputStream {
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2317l1(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) throws IOException {
        if (i >= 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwww += i;
        } else if (this.Wwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwww > 0) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to read all expected data, expected: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", but read: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwww);
            throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.Wwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwww, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int read;
        read = super.read(bArr, i, i2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(read);
        return read;
    }
}
