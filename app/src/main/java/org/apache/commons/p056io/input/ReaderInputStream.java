package org.apache.commons.p056io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import me.tvspark.outline;

/* renamed from: org.apache.commons.io.input.ReaderInputStream */
/* loaded from: classes4.dex */
public class ReaderInputStream extends InputStream {
    public static final int DEFAULT_BUFFER_SIZE = 1024;
    public final CharsetEncoder encoder;
    public final CharBuffer encoderIn;
    public final ByteBuffer encoderOut;
    public boolean endOfInput;
    public CoderResult lastCoderResult;
    public final Reader reader;

    @Deprecated
    public ReaderInputStream(Reader reader) {
        this(reader, Charset.defaultCharset());
    }

    public ReaderInputStream(Reader reader, String str) {
        this(reader, str, 1024);
    }

    public ReaderInputStream(Reader reader, String str, int i) {
        this(reader, Charset.forName(str), i);
    }

    public ReaderInputStream(Reader reader, Charset charset) {
        this(reader, charset, 1024);
    }

    public ReaderInputStream(Reader reader, Charset charset, int i) {
        this(reader, charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE), i);
    }

    public ReaderInputStream(Reader reader, CharsetEncoder charsetEncoder) {
        this(reader, charsetEncoder, 1024);
    }

    public ReaderInputStream(Reader reader, CharsetEncoder charsetEncoder, int i) {
        this.reader = reader;
        this.encoder = charsetEncoder;
        CharBuffer allocate = CharBuffer.allocate(i);
        this.encoderIn = allocate;
        allocate.flip();
        ByteBuffer allocate2 = ByteBuffer.allocate(128);
        this.encoderOut = allocate2;
        allocate2.flip();
    }

    private void fillBuffer() throws IOException {
        CoderResult coderResult;
        if (!this.endOfInput && ((coderResult = this.lastCoderResult) == null || coderResult.isUnderflow())) {
            this.encoderIn.compact();
            int position = this.encoderIn.position();
            int read = this.reader.read(this.encoderIn.array(), position, this.encoderIn.remaining());
            if (read == -1) {
                this.endOfInput = true;
            } else {
                this.encoderIn.position(position + read);
            }
            this.encoderIn.flip();
        }
        this.encoderOut.compact();
        this.lastCoderResult = this.encoder.encode(this.encoderIn, this.encoderOut, this.endOfInput);
        this.encoderOut.flip();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.reader.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (!this.encoderOut.hasRemaining()) {
            fillBuffer();
            if (this.endOfInput && !this.encoderOut.hasRemaining()) {
                return -1;
            }
        }
        return this.encoderOut.get() & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (bArr != null) {
            if (i2 < 0 || i < 0 || i + i2 > bArr.length) {
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
            while (i2 > 0) {
                if (!this.encoderOut.hasRemaining()) {
                    fillBuffer();
                    if (this.endOfInput && !this.encoderOut.hasRemaining()) {
                        break;
                    }
                } else {
                    int min = Math.min(this.encoderOut.remaining(), i2);
                    this.encoderOut.get(bArr, i, min);
                    i += min;
                    i2 -= min;
                    i3 += min;
                }
            }
            if (i3 == 0 && this.endOfInput) {
                return -1;
            }
            return i3;
        }
        throw new NullPointerException("Byte array must not be null");
    }
}
