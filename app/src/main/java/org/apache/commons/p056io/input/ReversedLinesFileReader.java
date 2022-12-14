package org.apache.commons.p056io.input;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.p056io.Charsets;

/* renamed from: org.apache.commons.io.input.ReversedLinesFileReader */
/* loaded from: classes4.dex */
public class ReversedLinesFileReader implements Closeable {
    public final int avoidNewlineSplitBufferSize;
    public final int blockSize;
    public final int byteDecrement;
    public FilePart currentFilePart;
    public final Charset encoding;
    public final byte[][] newLineSequences;
    public final RandomAccessFile randomAccessFile;
    public final long totalBlockCount;
    public final long totalByteLength;
    public boolean trailingNewlineOfFileSkipped;

    /* renamed from: org.apache.commons.io.input.ReversedLinesFileReader$FilePart */
    /* loaded from: classes4.dex */
    public class FilePart {
        public int currentLastBytePos;
        public final byte[] data;
        public byte[] leftOver;

        /* renamed from: no */
        public final long f4549no;

        public FilePart(long j, int i, byte[] bArr) throws IOException {
            this.f4549no = j;
            this.data = new byte[(bArr != null ? bArr.length : 0) + i];
            long j2 = (j - 1) * ReversedLinesFileReader.this.blockSize;
            if (j > 0) {
                ReversedLinesFileReader.this.randomAccessFile.seek(j2);
                if (ReversedLinesFileReader.this.randomAccessFile.read(this.data, 0, i) != i) {
                    throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
                }
            }
            if (bArr != null) {
                System.arraycopy(bArr, 0, this.data, i, bArr.length);
            }
            this.currentLastBytePos = this.data.length - 1;
            this.leftOver = null;
        }

        private void createLeftOver() {
            int i = this.currentLastBytePos + 1;
            if (i > 0) {
                byte[] bArr = new byte[i];
                this.leftOver = bArr;
                System.arraycopy(this.data, 0, bArr, 0, i);
            } else {
                this.leftOver = null;
            }
            this.currentLastBytePos = -1;
        }

        private int getNewLineMatchByteCount(byte[] bArr, int i) {
            byte[][] bArr2;
            for (byte[] bArr3 : ReversedLinesFileReader.this.newLineSequences) {
                boolean z = true;
                for (int length = bArr3.length - 1; length >= 0; length--) {
                    int length2 = (i + length) - (bArr3.length - 1);
                    z &= length2 >= 0 && bArr[length2] == bArr3[length];
                }
                if (z) {
                    return bArr3.length;
                }
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String readLine() throws IOException {
            String str;
            boolean z = this.f4549no == 1;
            int i = this.currentLastBytePos;
            while (i > -1) {
                if (z || i >= ReversedLinesFileReader.this.avoidNewlineSplitBufferSize) {
                    int newLineMatchByteCount = getNewLineMatchByteCount(this.data, i);
                    if (newLineMatchByteCount > 0) {
                        int i2 = i + 1;
                        int i3 = (this.currentLastBytePos - i2) + 1;
                        if (i3 < 0) {
                            throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected negative line length=", i3));
                        }
                        byte[] bArr = new byte[i3];
                        System.arraycopy(this.data, i2, bArr, 0, i3);
                        str = new String(bArr, ReversedLinesFileReader.this.encoding);
                        this.currentLastBytePos = i - newLineMatchByteCount;
                        if (!z && this.leftOver != null) {
                            String str2 = new String(this.leftOver, ReversedLinesFileReader.this.encoding);
                            this.leftOver = null;
                            return str2;
                        }
                    }
                    i -= ReversedLinesFileReader.this.byteDecrement;
                    if (i < 0) {
                    }
                }
                createLeftOver();
            }
            str = null;
            return !z ? str : str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FilePart rollOver() throws IOException {
            if (this.currentLastBytePos > -1) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.currentLastBytePos);
                throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            long j = this.f4549no;
            if (j > 1) {
                ReversedLinesFileReader reversedLinesFileReader = ReversedLinesFileReader.this;
                return new FilePart(j - 1, reversedLinesFileReader.blockSize, this.leftOver);
            } else if (this.leftOver == null) {
                return null;
            } else {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected leftover of the last block: leftOverOfThisFilePart=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(new String(this.leftOver, ReversedLinesFileReader.this.encoding));
                throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            }
        }
    }

    @Deprecated
    public ReversedLinesFileReader(File file) throws IOException {
        this(file, 4096, Charset.defaultCharset());
    }

    public ReversedLinesFileReader(File file, int i, String str) throws IOException {
        this(file, i, Charsets.toCharset(str));
    }

    public ReversedLinesFileReader(File file, int i, Charset charset) throws IOException {
        int i2;
        this.trailingNewlineOfFileSkipped = false;
        this.blockSize = i;
        this.encoding = charset;
        Charset charset2 = Charsets.toCharset(charset);
        if (charset2.newEncoder().maxBytesPerChar() == 1.0f || charset2 == Charsets.UTF_8 || charset2 == Charset.forName("Shift_JIS") || charset2 == Charset.forName("windows-31j") || charset2 == Charset.forName("x-windows-949") || charset2 == Charset.forName("gbk") || charset2 == Charset.forName("x-windows-950")) {
            this.byteDecrement = 1;
        } else if (charset2 != Charsets.UTF_16BE && charset2 != Charsets.UTF_16LE) {
            if (charset2 == Charsets.UTF_16) {
                throw new UnsupportedEncodingException("For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)");
            }
            throw new UnsupportedEncodingException("Encoding " + charset + " is not supported yet (feel free to submit a patch)");
        } else {
            this.byteDecrement = 2;
        }
        byte[][] bArr = {"\r\n".getBytes(charset), "\n".getBytes(charset), StringUtils.f4552CR.getBytes(charset)};
        this.newLineSequences = bArr;
        this.avoidNewlineSplitBufferSize = bArr[0].length;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, Tailer.RAF_MODE);
        this.randomAccessFile = randomAccessFile;
        long length = randomAccessFile.length();
        this.totalByteLength = length;
        long j = i;
        int i3 = (int) (length % j);
        if (i3 > 0) {
            this.totalBlockCount = (length / j) + 1;
        } else {
            this.totalBlockCount = length / j;
            if (length > 0) {
                i2 = i;
                this.currentFilePart = new FilePart(this.totalBlockCount, i2, null);
            }
        }
        i2 = i3;
        this.currentFilePart = new FilePart(this.totalBlockCount, i2, null);
    }

    public ReversedLinesFileReader(File file, Charset charset) throws IOException {
        this(file, 4096, charset);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.randomAccessFile.close();
    }

    public String readLine() throws IOException {
        String readLine = this.currentFilePart.readLine();
        while (readLine == null) {
            FilePart rollOver = this.currentFilePart.rollOver();
            this.currentFilePart = rollOver;
            if (rollOver == null) {
                break;
            }
            readLine = rollOver.readLine();
        }
        if (!"".equals(readLine) || this.trailingNewlineOfFileSkipped) {
            return readLine;
        }
        this.trailingNewlineOfFileSkipped = true;
        return readLine();
    }
}
