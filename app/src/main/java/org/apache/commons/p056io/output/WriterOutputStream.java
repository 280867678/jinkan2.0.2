package org.apache.commons.p056io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* renamed from: org.apache.commons.io.output.WriterOutputStream */
/* loaded from: classes4.dex */
public class WriterOutputStream extends OutputStream {
    public static final int DEFAULT_BUFFER_SIZE = 1024;
    public final CharsetDecoder decoder;
    public final ByteBuffer decoderIn;
    public final CharBuffer decoderOut;
    public final boolean writeImmediately;
    public final Writer writer;

    @Deprecated
    public WriterOutputStream(Writer writer) {
        this(writer, Charset.defaultCharset(), 1024, false);
    }

    public WriterOutputStream(Writer writer, String str) {
        this(writer, str, 1024, false);
    }

    public WriterOutputStream(Writer writer, String str, int i, boolean z) {
        this(writer, Charset.forName(str), i, z);
    }

    public WriterOutputStream(Writer writer, Charset charset) {
        this(writer, charset, 1024, false);
    }

    public WriterOutputStream(Writer writer, Charset charset, int i, boolean z) {
        this(writer, charset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith("?"), i, z);
    }

    public WriterOutputStream(Writer writer, CharsetDecoder charsetDecoder) {
        this(writer, charsetDecoder, 1024, false);
    }

    public WriterOutputStream(Writer writer, CharsetDecoder charsetDecoder, int i, boolean z) {
        this.decoderIn = ByteBuffer.allocate(128);
        checkIbmJdkWithBrokenUTF16(charsetDecoder.charset());
        this.writer = writer;
        this.decoder = charsetDecoder;
        this.writeImmediately = z;
        this.decoderOut = CharBuffer.allocate(i);
    }

    public static void checkIbmJdkWithBrokenUTF16(Charset charset) {
        if (!"UTF-16".equals(charset.name())) {
            return;
        }
        byte[] bytes = "vés".getBytes(charset);
        CharsetDecoder newDecoder = charset.newDecoder();
        ByteBuffer allocate = ByteBuffer.allocate(16);
        CharBuffer allocate2 = CharBuffer.allocate(3);
        int length = bytes.length;
        int i = 0;
        while (i < length) {
            allocate.put(bytes[i]);
            allocate.flip();
            try {
                newDecoder.decode(allocate, allocate2, i == length + (-1));
                allocate.compact();
                i++;
            } catch (IllegalArgumentException unused) {
                throw new UnsupportedOperationException("UTF-16 requested when runninng on an IBM JDK with broken UTF-16 support. Please find a JDK that supports UTF-16 if you intend to use UF-16 with WriterOutputStream");
            }
        }
        allocate2.rewind();
        if (!"vés".equals(allocate2.toString())) {
            throw new UnsupportedOperationException("UTF-16 requested when runninng on an IBM JDK with broken UTF-16 support. Please find a JDK that supports UTF-16 if you intend to use UF-16 with WriterOutputStream");
        }
    }

    private void flushOutput() throws IOException {
        if (this.decoderOut.position() > 0) {
            this.writer.write(this.decoderOut.array(), 0, this.decoderOut.position());
            this.decoderOut.rewind();
        }
    }

    private void processInput(boolean z) throws IOException {
        CoderResult decode;
        this.decoderIn.flip();
        while (true) {
            decode = this.decoder.decode(this.decoderIn, this.decoderOut, z);
            if (!decode.isOverflow()) {
                break;
            }
            flushOutput();
        }
        if (decode.isUnderflow()) {
            this.decoderIn.compact();
            return;
        }
        throw new IOException("Unexpected coder result");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        processInput(true);
        flushOutput();
        this.writer.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flushOutput();
        this.writer.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            int min = Math.min(i2, this.decoderIn.remaining());
            this.decoderIn.put(bArr, i, min);
            processInput(false);
            i2 -= min;
            i += min;
        }
        if (this.writeImmediately) {
            flushOutput();
        }
    }
}
