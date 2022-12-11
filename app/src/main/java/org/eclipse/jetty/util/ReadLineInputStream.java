package org.eclipse.jetty.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class ReadLineInputStream extends BufferedInputStream {
    public boolean _seenCRLF;
    public boolean _skipLF;

    public ReadLineInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public ReadLineInputStream(InputStream inputStream, int i) {
        super(inputStream, i);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        if (this._skipLF) {
            this._skipLF = false;
            if (this._seenCRLF && read == 10) {
                read = super.read();
            }
        }
        return read;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        if (this._skipLF && i2 > 0) {
            this._skipLF = false;
            if (this._seenCRLF) {
                int read = super.read();
                if (read == -1) {
                    return -1;
                }
                if (read != 10) {
                    bArr[i] = (byte) (read & 255);
                    return super.read(bArr, i + 1, i2 - 1) + 1;
                }
            }
        }
        return super.read(bArr, i, i2);
    }

    public String readLine() throws IOException {
        mark(((BufferedInputStream) this).buf.length);
        while (true) {
            int read = super.read();
            int i = ((BufferedInputStream) this).markpos;
            if (i >= 0) {
                if (read == -1) {
                    ((BufferedInputStream) this).markpos = -1;
                    if (((BufferedInputStream) this).pos <= i) {
                        return null;
                    }
                    return new String(((BufferedInputStream) this).buf, i, ((BufferedInputStream) this).pos - i, StringUtil.__UTF8_CHARSET);
                } else if (read == 13) {
                    int i2 = ((BufferedInputStream) this).pos;
                    if (!this._seenCRLF || i2 >= ((BufferedInputStream) this).count) {
                        this._skipLF = true;
                    } else {
                        byte[] bArr = ((BufferedInputStream) this).buf;
                        int i3 = ((BufferedInputStream) this).pos;
                        if (bArr[i3] == 10) {
                            ((BufferedInputStream) this).pos = i3 + 1;
                        }
                    }
                    int i4 = ((BufferedInputStream) this).markpos;
                    ((BufferedInputStream) this).markpos = -1;
                    return new String(((BufferedInputStream) this).buf, i4, (i2 - i4) - 1, StringUtil.__UTF8_CHARSET);
                } else if (read == 10) {
                    if (!this._skipLF) {
                        ((BufferedInputStream) this).markpos = -1;
                        return new String(((BufferedInputStream) this).buf, i, (((BufferedInputStream) this).pos - i) - 1, StringUtil.__UTF8_CHARSET);
                    }
                    this._skipLF = false;
                    this._seenCRLF = true;
                    ((BufferedInputStream) this).markpos = i + 1;
                }
            } else {
                throw new IOException("Buffer size exceeded: no line terminator");
            }
        }
    }
}
