package me.tvspark;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public final class Illllllllllllllllll extends OutputStream {
    public int Wwwwwwwwwwwwwwwwwwwww;
    public OO000 Wwwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final OutputStream Wwwwwwwwwwwwwwwwwwwwwwww;

    public Illllllllllllllllll(@NonNull OutputStream outputStream, @NonNull OO000 oo000) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = outputStream;
        this.Wwwwwwwwwwwwwwwwwwwwww = oo000;
        this.Wwwwwwwwwwwwwwwwwwwwwww = (byte[]) oo000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(65536, byte[].class);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.Wwwwwwwwwwwwwwwwwwwwwwww.close();
            byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (bArr == null) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww.put(bArr);
            this.Wwwwwwwwwwwwwwwwwwwwwww = null;
        } catch (Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        int i = this.Wwwwwwwwwwwwwwwwwwwww;
        if (i > 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.write(this.Wwwwwwwwwwwwwwwwwwwwwww, 0, i);
            this.Wwwwwwwwwwwwwwwwwwwww = 0;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwww;
        int i3 = i2 + 1;
        this.Wwwwwwwwwwwwwwwwwwwww = i3;
        bArr[i2] = (byte) i;
        if (i3 != bArr.length || i3 <= 0) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.write(bArr, 0, i3);
        this.Wwwwwwwwwwwwwwwwwwwww = 0;
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            if (this.Wwwwwwwwwwwwwwwwwwwww == 0 && i4 >= this.Wwwwwwwwwwwwwwwwwwwwwww.length) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.Wwwwwwwwwwwwwwwwwwwwwww.length - this.Wwwwwwwwwwwwwwwwwwwww);
            System.arraycopy(bArr, i5, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, min);
            int i6 = this.Wwwwwwwwwwwwwwwwwwwww + min;
            this.Wwwwwwwwwwwwwwwwwwwww = i6;
            i3 += min;
            byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (i6 == bArr2.length && i6 > 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.write(bArr2, 0, i6);
                this.Wwwwwwwwwwwwwwwwwwwww = 0;
                continue;
            }
        } while (i3 < i2);
    }
}
