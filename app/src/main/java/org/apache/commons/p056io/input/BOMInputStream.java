package org.apache.commons.p056io.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.p056io.ByteOrderMark;

/* renamed from: org.apache.commons.io.input.BOMInputStream */
/* loaded from: classes4.dex */
public class BOMInputStream extends ProxyInputStream {
    public static final Comparator<ByteOrderMark> ByteOrderMarkLengthComparator = new Comparator<ByteOrderMark>() { // from class: org.apache.commons.io.input.BOMInputStream.1
        @Override // java.util.Comparator
        public int compare(ByteOrderMark byteOrderMark, ByteOrderMark byteOrderMark2) {
            int length = byteOrderMark.length();
            int length2 = byteOrderMark2.length();
            if (length > length2) {
                return -1;
            }
            return length2 > length ? 1 : 0;
        }
    };
    public final List<ByteOrderMark> boms;
    public ByteOrderMark byteOrderMark;
    public int fbIndex;
    public int fbLength;
    public int[] firstBytes;
    public final boolean include;
    public int markFbIndex;
    public boolean markedAtStart;

    public BOMInputStream(InputStream inputStream) {
        this(inputStream, false, ByteOrderMark.UTF_8);
    }

    public BOMInputStream(InputStream inputStream, boolean z) {
        this(inputStream, z, ByteOrderMark.UTF_8);
    }

    public BOMInputStream(InputStream inputStream, boolean z, ByteOrderMark... byteOrderMarkArr) {
        super(inputStream);
        if (byteOrderMarkArr == null || byteOrderMarkArr.length == 0) {
            throw new IllegalArgumentException("No BOMs specified");
        }
        this.include = z;
        Arrays.sort(byteOrderMarkArr, ByteOrderMarkLengthComparator);
        this.boms = Arrays.asList(byteOrderMarkArr);
    }

    public BOMInputStream(InputStream inputStream, ByteOrderMark... byteOrderMarkArr) {
        this(inputStream, false, byteOrderMarkArr);
    }

    private ByteOrderMark find() {
        for (ByteOrderMark byteOrderMark : this.boms) {
            if (matches(byteOrderMark)) {
                return byteOrderMark;
            }
        }
        return null;
    }

    private boolean matches(ByteOrderMark byteOrderMark) {
        for (int i = 0; i < byteOrderMark.length(); i++) {
            if (byteOrderMark.get(i) != this.firstBytes[i]) {
                return false;
            }
        }
        return true;
    }

    private int readFirstBytes() throws IOException {
        getBOM();
        int i = this.fbIndex;
        if (i < this.fbLength) {
            int[] iArr = this.firstBytes;
            this.fbIndex = i + 1;
            return iArr[i];
        }
        return -1;
    }

    public ByteOrderMark getBOM() throws IOException {
        if (this.firstBytes == null) {
            this.fbLength = 0;
            this.firstBytes = new int[this.boms.get(0).length()];
            int i = 0;
            while (true) {
                int[] iArr = this.firstBytes;
                if (i >= iArr.length) {
                    break;
                }
                iArr[i] = ((FilterInputStream) this).in.read();
                this.fbLength++;
                if (this.firstBytes[i] < 0) {
                    break;
                }
                i++;
            }
            ByteOrderMark find = find();
            this.byteOrderMark = find;
            if (find != null && !this.include) {
                if (find.length() < this.firstBytes.length) {
                    this.fbIndex = this.byteOrderMark.length();
                } else {
                    this.fbLength = 0;
                }
            }
        }
        return this.byteOrderMark;
    }

    public String getBOMCharsetName() throws IOException {
        getBOM();
        ByteOrderMark byteOrderMark = this.byteOrderMark;
        if (byteOrderMark == null) {
            return null;
        }
        return byteOrderMark.getCharsetName();
    }

    public boolean hasBOM() throws IOException {
        return getBOM() != null;
    }

    public boolean hasBOM(ByteOrderMark byteOrderMark) throws IOException {
        if (this.boms.contains(byteOrderMark)) {
            return this.byteOrderMark != null && getBOM().equals(byteOrderMark);
        }
        throw new IllegalArgumentException("Stream not configure to detect " + byteOrderMark);
    }

    @Override // org.apache.commons.p056io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.markFbIndex = this.fbIndex;
        this.markedAtStart = this.firstBytes == null;
        ((FilterInputStream) this).in.mark(i);
    }

    @Override // org.apache.commons.p056io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int readFirstBytes = readFirstBytes();
        return readFirstBytes >= 0 ? readFirstBytes : ((FilterInputStream) this).in.read();
    }

    @Override // org.apache.commons.p056io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // org.apache.commons.p056io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        int i4 = 0;
        while (i2 > 0 && i3 >= 0) {
            i3 = readFirstBytes();
            if (i3 >= 0) {
                bArr[i] = (byte) (i3 & 255);
                i2--;
                i4++;
                i++;
            }
        }
        int read = ((FilterInputStream) this).in.read(bArr, i, i2);
        if (read < 0) {
            if (i4 <= 0) {
                return -1;
            }
            return i4;
        }
        return i4 + read;
    }

    @Override // org.apache.commons.p056io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        this.fbIndex = this.markFbIndex;
        if (this.markedAtStart) {
            this.firstBytes = null;
        }
        ((FilterInputStream) this).in.reset();
    }

    @Override // org.apache.commons.p056io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long j2;
        int i = 0;
        while (true) {
            j2 = i;
            if (j <= j2 || readFirstBytes() < 0) {
                break;
            }
            i++;
        }
        return ((FilterInputStream) this).in.skip(j - j2) + j2;
    }
}
