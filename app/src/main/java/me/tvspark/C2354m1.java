package me.tvspark;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* renamed from: me.tvspark.m1 */
/* loaded from: classes4.dex */
public class C2354m1 extends InputStream {
    public static final Queue<C2354m1> Wwwwwwwwwwwwwwwwwwwwww = C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
    public IOException Wwwwwwwwwwwwwwwwwwwwwww;
    public InputStream Wwwwwwwwwwwwwwwwwwwwwwww;

    @NonNull
    public static C2354m1 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull InputStream inputStream) {
        C2354m1 poll;
        synchronized (Wwwwwwwwwwwwwwwwwwwwww) {
            poll = Wwwwwwwwwwwwwwwwwwwwww.poll();
        }
        if (poll == null) {
            poll = new C2354m1();
        }
        poll.Wwwwwwwwwwwwwwwwwwwwwwww = inputStream;
        return poll;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
        synchronized (Wwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwww.offer(this);
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.read();
        } catch (IOException e) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.read(bArr);
        } catch (IOException e) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.read(bArr, i, i2);
        } catch (IOException e) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.skip(j);
        } catch (IOException e) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = e;
            return 0L;
        }
    }
}
