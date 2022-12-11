package org.apache.commons.p056io.input;

import java.io.Reader;
import java.io.Serializable;
import me.tvspark.outline;

/* renamed from: org.apache.commons.io.input.CharSequenceReader */
/* loaded from: classes4.dex */
public class CharSequenceReader extends Reader implements Serializable {
    public static final long serialVersionUID = 3724187752191401220L;
    public final CharSequence charSequence;
    public int idx;
    public int mark;

    public CharSequenceReader(String str) {
        this.charSequence = str == null ? "" : str;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.idx = 0;
        this.mark = 0;
    }

    @Override // java.io.Reader
    public void mark(int i) {
        this.mark = this.idx;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public int read() {
        if (this.idx >= this.charSequence.length()) {
            return -1;
        }
        CharSequence charSequence = this.charSequence;
        int i = this.idx;
        this.idx = i + 1;
        return charSequence.charAt(i);
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) {
        if (this.idx >= this.charSequence.length()) {
            return -1;
        }
        if (cArr == null) {
            throw new NullPointerException("Character array is missing");
        }
        if (i2 < 0 || i < 0 || i + i2 > cArr.length) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Array Size=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cArr.length);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", offset=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", length=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i2);
            throw new IndexOutOfBoundsException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int read = read();
            if (read == -1) {
                return i3;
            }
            cArr[i + i4] = (char) read;
            i3++;
        }
        return i3;
    }

    @Override // java.io.Reader
    public void reset() {
        this.idx = this.mark;
    }

    @Override // java.io.Reader
    public long skip(long j) {
        if (j >= 0) {
            if (this.idx >= this.charSequence.length()) {
                return -1L;
            }
            int min = (int) Math.min(this.charSequence.length(), this.idx + j);
            this.idx = min;
            return min - this.idx;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Number of characters to skip is less than zero: ", j));
    }

    public String toString() {
        return this.charSequence.toString();
    }
}
