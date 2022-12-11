package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import me.tvspark.OO000;

/* loaded from: classes3.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {
    public final OO000 Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public volatile byte[] Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class InvalidMarkException extends IOException {
        public static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull OO000 oo000) {
        super(inputStream);
        this.Wwwwwwwwwwwwwwwwwww = oo000;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = (byte[]) oo000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(65536, byte[].class);
    }

    public static IOException Wwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
            this.Wwwwwwwwwwwwwwwwwww.put(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
        }
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.Wwwwwwwwwwwwwwwwwwwww;
        if (i != -1) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwww - i;
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.Wwwwwwwwwwwwwwwwwwwwwww == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = (byte[]) this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = bArr2;
                    this.Wwwwwwwwwwwwwwwwwww.put(bArr);
                    bArr = bArr2;
                } else {
                    int i4 = this.Wwwwwwwwwwwwwwwwwwwww;
                    if (i4 > 0) {
                        System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
                    }
                }
                int i5 = this.Wwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwww = i5;
                this.Wwwwwwwwwwwwwwwwwwwww = 0;
                this.Wwwwwwwwwwwwwwwwwwwwwww = 0;
                int read = inputStream.read(bArr, i5, bArr.length - i5);
                int i6 = this.Wwwwwwwwwwwwwwwwwwww;
                if (read > 0) {
                    i6 += read;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww = i6;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.Wwwwwwwwwwwwwwwwwwwww = -1;
            this.Wwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwww = read2;
        }
        return read2;
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null || inputStream == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        return (this.Wwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwww) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
            this.Wwwwwwwwwwwwwwwwwww.put(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwww = Math.max(this.Wwwwwwwwwwwwwwwwwwwwww, i);
        this.Wwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        } else if (this.Wwwwwwwwwwwwwwwwwwww >= this.Wwwwwwwwwwwwwwwwwwwwwww && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream, bArr) == -1) {
            return -1;
        } else {
            if (bArr != this.Wwwwwwwwwwwwwwwwwwwwwwww && (bArr = this.Wwwwwwwwwwwwwwwwwwwwwwww) == null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwww <= 0) {
                return -1;
            }
            int i = this.Wwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwww = i + 1;
            return bArr[i] & 255;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (bArr2 == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        } else if (i2 == 0) {
            return 0;
        } else {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream == null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            if (this.Wwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwww) {
                int i5 = this.Wwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwww >= i2 ? i2 : this.Wwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwww;
                System.arraycopy(bArr2, this.Wwwwwwwwwwwwwwwwwwww, bArr, i, i5);
                this.Wwwwwwwwwwwwwwwwwwww += i5;
                if (i5 == i2 || inputStream.available() == 0) {
                    return i5;
                }
                i += i5;
                i3 = i2 - i5;
            } else {
                i3 = i2;
            }
            while (true) {
                int i6 = -1;
                if (this.Wwwwwwwwwwwwwwwwwwwww == -1 && i3 >= bArr2.length) {
                    i4 = inputStream.read(bArr, i, i3);
                    if (i4 == -1) {
                        if (i3 != i2) {
                            i6 = i2 - i3;
                        }
                        return i6;
                    }
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream, bArr2) == -1) {
                    if (i3 != i2) {
                        i6 = i2 - i3;
                    }
                    return i6;
                } else {
                    if (bArr2 != this.Wwwwwwwwwwwwwwwwwwwwwwww && (bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwww) == null) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    i4 = this.Wwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwww >= i3 ? i3 : this.Wwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwww;
                    System.arraycopy(bArr2, this.Wwwwwwwwwwwwwwwwwwww, bArr, i, i4);
                    this.Wwwwwwwwwwwwwwwwwwww += i4;
                }
                i3 -= i4;
                if (i3 == 0) {
                    return i2;
                }
                if (inputStream.available() == 0) {
                    return i2 - i3;
                }
                i += i4;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == this.Wwwwwwwwwwwwwwwwwwwww) {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.Wwwwwwwwwwwwwwwwwwww + " markLimit: " + this.Wwwwwwwwwwwwwwwwwwwwww);
        }
        this.Wwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (bArr == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        } else if (this.Wwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwww >= j) {
            this.Wwwwwwwwwwwwwwwwwwww = (int) (this.Wwwwwwwwwwwwwwwwwwww + j);
            return j;
        } else {
            long j2 = this.Wwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (this.Wwwwwwwwwwwwwwwwwwwww == -1 || j > this.Wwwwwwwwwwwwwwwwwwwwww) {
                return j2 + inputStream.skip(j - j2);
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream, bArr) == -1) {
                return j2;
            } else {
                if (this.Wwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwww >= j - j2) {
                    this.Wwwwwwwwwwwwwwwwwwww = (int) ((this.Wwwwwwwwwwwwwwwwwwww + j) - j2);
                    return j;
                }
                long j3 = (j2 + this.Wwwwwwwwwwwwwwwwwwwwwww) - this.Wwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
                return j3;
            }
        }
    }
}
