package me.tvspark;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: me.tvspark.q1 */
/* loaded from: classes4.dex */
public class C2508q1 extends FilterInputStream {
    public int Wwwwwwwwwwwwwwwwwwwwwwww = Integer.MIN_VALUE;

    public C2508q1(@NonNull InputStream inputStream) {
        super(inputStream);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww = (int) (i - j);
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1L) == -1) {
            return -1;
        }
        int read = super.read();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
            return -1;
        }
        int read = super.read(bArr, i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
            return 0L;
        }
        long skip = super.skip(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(skip);
        return skip;
    }
}
