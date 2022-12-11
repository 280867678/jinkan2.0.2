package me.tvspark;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.mozilla.javascript.regexp.NativeRegExp;

/* loaded from: classes4.dex */
public final class Illllllllllllll extends FilterInputStream {
    public static final int Wwwwwwwwwwwwwwwwwwww;
    public static final int Wwwwwwwwwwwwwwwwwwwww;
    public static final byte[] Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public final byte Wwwwwwwwwwwwwwwwwwwwwwww;

    static {
        byte[] bArr = {-1, ExifInterface.MARKER_APP1, 0, NativeRegExp.REOP_OPT, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        Wwwwwwwwwwwwwwwwwwwwww = bArr;
        int length = bArr.length;
        Wwwwwwwwwwwwwwwwwwwww = length;
        Wwwwwwwwwwwwwwwwwwww = length + 2;
    }

    public Illllllllllllll(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot add invalid orientation: ", i));
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww = (byte) i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int read = (i2 < 2 || i2 > (i = Wwwwwwwwwwwwwwwwwwww)) ? super.read() : i2 == i ? this.Wwwwwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwww[i2 - 2] & 255;
        if (read != -1) {
            this.Wwwwwwwwwwwwwwwwwwwwwww++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i5 = Wwwwwwwwwwwwwwwwwwww;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = Math.min(i5 - i4, i2);
            System.arraycopy(Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwww += i3;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = super.skip(j);
        if (skip > 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = (int) (this.Wwwwwwwwwwwwwwwwwwwwwww + skip);
        }
        return skip;
    }
}
