package org.apache.commons.p056io.input;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* renamed from: org.apache.commons.io.input.CharSequenceInputStream */
/* loaded from: classes4.dex */
public class CharSequenceInputStream extends InputStream {
    public static final int BUFFER_SIZE = 2048;
    public static final int NO_MARK = -1;
    public final ByteBuffer bbuf;
    public final CharBuffer cbuf;
    public final CharsetEncoder encoder;
    public int mark_bbuf;
    public int mark_cbuf;

    public CharSequenceInputStream(CharSequence charSequence, String str) {
        this(charSequence, str, 2048);
    }

    public CharSequenceInputStream(CharSequence charSequence, String str, int i) {
        this(charSequence, Charset.forName(str), i);
    }

    public CharSequenceInputStream(CharSequence charSequence, Charset charset) {
        this(charSequence, charset, 2048);
    }

    public CharSequenceInputStream(CharSequence charSequence, Charset charset, int i) {
        CharsetEncoder onUnmappableCharacter = charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        this.encoder = onUnmappableCharacter;
        float maxBytesPerChar = onUnmappableCharacter.maxBytesPerChar();
        if (i < maxBytesPerChar) {
            throw new IllegalArgumentException("Buffer size " + i + " is less than maxBytesPerChar " + maxBytesPerChar);
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        this.bbuf = allocate;
        allocate.flip();
        this.cbuf = CharBuffer.wrap(charSequence);
        this.mark_cbuf = -1;
        this.mark_bbuf = -1;
    }

    private void fillBuffer() throws CharacterCodingException {
        this.bbuf.compact();
        CoderResult encode = this.encoder.encode(this.cbuf, this.bbuf, true);
        if (encode.isError()) {
            encode.throwException();
        }
        this.bbuf.flip();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.cbuf.remaining() + this.bbuf.remaining();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.mark_cbuf = this.cbuf.position();
        this.mark_bbuf = this.bbuf.position();
        this.cbuf.mark();
        this.bbuf.mark();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (!this.bbuf.hasRemaining()) {
            fillBuffer();
            if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
                return -1;
            }
        }
        return this.bbuf.get() & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (bArr != null) {
            if (i2 < 0 || i + i2 > bArr.length) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Array Size=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(bArr.length);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", offset=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", length=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i2);
                throw new IndexOutOfBoundsException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            int i3 = 0;
            if (i2 == 0) {
                return 0;
            }
            if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
                return -1;
            }
            while (i2 > 0) {
                if (!this.bbuf.hasRemaining()) {
                    fillBuffer();
                    if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
                        break;
                    }
                } else {
                    int min = Math.min(this.bbuf.remaining(), i2);
                    this.bbuf.get(bArr, i, min);
                    i += min;
                    i2 -= min;
                    i3 += min;
                }
            }
            if (i3 == 0 && !this.cbuf.hasRemaining()) {
                return -1;
            }
            return i3;
        }
        throw new NullPointerException("Byte array is null");
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.mark_cbuf != -1) {
            if (this.cbuf.position() != 0) {
                this.encoder.reset();
                this.cbuf.rewind();
                this.bbuf.rewind();
                this.bbuf.limit(0);
                while (this.cbuf.position() < this.mark_cbuf) {
                    this.bbuf.rewind();
                    this.bbuf.limit(0);
                    fillBuffer();
                }
            }
            if (this.cbuf.position() != this.mark_cbuf) {
                throw new IllegalStateException("Unexpected CharBuffer postion: actual=" + this.cbuf.position() + StringUtils.SPACE + "expected=" + this.mark_cbuf);
            }
            this.bbuf.position(this.mark_bbuf);
            this.mark_cbuf = -1;
            this.mark_bbuf = -1;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long j2 = 0;
        while (j > 0 && available() > 0) {
            read();
            j--;
            j2++;
        }
        return j2;
    }
}
