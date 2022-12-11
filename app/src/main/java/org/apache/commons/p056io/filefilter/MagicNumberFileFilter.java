package org.apache.commons.p056io.filefilter;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import me.tvspark.outline;
import org.apache.commons.p056io.IOUtils;
import org.apache.commons.p056io.input.Tailer;

/* renamed from: org.apache.commons.io.filefilter.MagicNumberFileFilter */
/* loaded from: classes4.dex */
public class MagicNumberFileFilter extends AbstractFileFilter implements Serializable {
    public static final long serialVersionUID = -547733176983104172L;
    public final long byteOffset;
    public final byte[] magicNumbers;

    public MagicNumberFileFilter(String str) {
        this(str, 0L);
    }

    public MagicNumberFileFilter(String str, long j) {
        if (str != null) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("The magic number must contain at least one byte");
            }
            if (j < 0) {
                throw new IllegalArgumentException("The offset cannot be negative");
            }
            this.magicNumbers = str.getBytes(Charset.defaultCharset());
            this.byteOffset = j;
            return;
        }
        throw new IllegalArgumentException("The magic number cannot be null");
    }

    public MagicNumberFileFilter(byte[] bArr) {
        this(bArr, 0L);
    }

    public MagicNumberFileFilter(byte[] bArr, long j) {
        if (bArr != null) {
            if (bArr.length == 0) {
                throw new IllegalArgumentException("The magic number must contain at least one byte");
            }
            if (j < 0) {
                throw new IllegalArgumentException("The offset cannot be negative");
            }
            byte[] bArr2 = new byte[bArr.length];
            this.magicNumbers = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.byteOffset = j;
            return;
        }
        throw new IllegalArgumentException("The magic number cannot be null");
    }

    @Override // org.apache.commons.p056io.filefilter.AbstractFileFilter, org.apache.commons.p056io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        if (file != null && file.isFile() && file.canRead()) {
            RandomAccessFile randomAccessFile = null;
            try {
                byte[] bArr = new byte[this.magicNumbers.length];
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, Tailer.RAF_MODE);
                try {
                    randomAccessFile2.seek(this.byteOffset);
                    if (randomAccessFile2.read(bArr) != this.magicNumbers.length) {
                        IOUtils.closeQuietly(randomAccessFile2);
                        return false;
                    }
                    boolean equals = Arrays.equals(this.magicNumbers, bArr);
                    IOUtils.closeQuietly(randomAccessFile2);
                    return equals;
                } catch (IOException unused) {
                    randomAccessFile = randomAccessFile2;
                    IOUtils.closeQuietly(randomAccessFile);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    IOUtils.closeQuietly(randomAccessFile);
                    throw th;
                }
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return false;
    }

    @Override // org.apache.commons.p056io.filefilter.AbstractFileFilter
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("(");
        sb.append(new String(this.magicNumbers, Charset.defaultCharset()));
        sb.append(",");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, this.byteOffset, ")");
    }
}
