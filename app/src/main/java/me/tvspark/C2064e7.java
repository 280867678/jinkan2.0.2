package me.tvspark;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* renamed from: me.tvspark.e7 */
/* loaded from: classes4.dex */
public final class C2064e7 implements AbstractC2212i7 {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2752wj Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[65536];
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[4096];

    public C2064e7(AbstractC2752wj abstractC2752wj, long j, long j2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2752wj;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww - i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 < bArr.length - 524288) {
            bArr = new byte[i2 + 65536];
        }
        System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, bArr, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + i;
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 > bArr.length) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    @Override // me.tvspark.AbstractC2212i7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i != -1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
        }
    }

    @Override // me.tvspark.AbstractC2212i7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) throws IOException {
        int min = Math.min(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(min);
        int i2 = min;
        while (i2 < i && i2 != -1) {
            i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, -i2, Math.min(i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length + i2), i2, false);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
    }

    @Override // me.tvspark.AbstractC2212i7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i, i2, false);
    }

    @Override // me.tvspark.AbstractC2212i7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2, boolean z) throws IOException {
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, z)) {
            return false;
        }
        System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - i2, bArr, i, i2);
        return true;
    }

    @Override // me.tvspark.AbstractC2212i7
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) throws IOException {
        int min;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i5 = i3 - i4;
        if (i5 == 0) {
            min = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i4, i2, 0, true);
            if (min == -1) {
                return -1;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww += min;
        } else {
            min = Math.min(i2, i5);
        }
        System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, i, min);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww += min;
        return min;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2, int i3, boolean z) throws IOException {
        if (!Thread.interrupted()) {
            int read = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.read(bArr, i + i3, i2 - i3);
            if (read != -1) {
                return i3 + read;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedIOException();
    }

    @Override // me.tvspark.AbstractC2212i7
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2212i7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, false);
    }

    @Override // me.tvspark.AbstractC2212i7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z) throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        while (i2 < i) {
            i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, i2, z);
            if (i2 == -1) {
                return false;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + i2;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
        return true;
    }

    @Override // me.tvspark.AbstractC2212i7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2, boolean z) throws IOException {
        int min;
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i3 == 0) {
            min = 0;
        } else {
            min = Math.min(i3, i2);
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, bArr, i, min);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(min);
        }
        int i4 = min;
        while (i4 < i2 && i4 != -1) {
            i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i, i2, i4, z);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
        return i4 != -1;
    }

    @Override // me.tvspark.AbstractC2212i7
    public long getLength() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2212i7
    public long getPosition() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2212i7, me.tvspark.AbstractC2752wj
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i4 = 0;
        if (i3 != 0) {
            int min = Math.min(i3, i2);
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, bArr, i, min);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(min);
            i4 = min;
        }
        if (i4 == 0) {
            i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i, i2, 0, true);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
        return i4;
    }

    @Override // me.tvspark.AbstractC2212i7
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i, i2, false);
    }

    @Override // me.tvspark.AbstractC2212i7
    public int skip(int i) throws IOException {
        int min = Math.min(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(min);
        if (min == 0) {
            byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            min = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(min);
        return min;
    }
}
