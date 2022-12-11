package org.eclipse.jetty.p059io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import me.tvspark.outline;
import org.eclipse.jetty.p059io.AbstractBuffer;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.util.C3009IO;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* renamed from: org.eclipse.jetty.io.nio.DirectNIOBuffer */
/* loaded from: classes4.dex */
public class DirectNIOBuffer extends AbstractBuffer implements NIOBuffer {
    public static final Logger LOG = Log.getLogger(DirectNIOBuffer.class);
    public final ByteBuffer _buf;
    public ReadableByteChannel _in;
    public InputStream _inStream;
    public WritableByteChannel _out;
    public OutputStream _outStream;

    public DirectNIOBuffer(int i) {
        super(2, false);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        this._buf = allocateDirect;
        allocateDirect.position(0);
        ByteBuffer byteBuffer = this._buf;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public DirectNIOBuffer(File file) throws IOException {
        super(1, false);
        FileInputStream fileInputStream;
        FileChannel fileChannel = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileChannel = fileInputStream.getChannel();
                this._buf = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, file.length());
                setGetIndex(0);
                setPutIndex((int) file.length());
                this._access = 0;
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    LOG.ignore(e);
                }
                C3009IO.close((InputStream) fileInputStream);
            } catch (Throwable th) {
                th = th;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e2) {
                        LOG.ignore(e2);
                    }
                }
                C3009IO.close((InputStream) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public DirectNIOBuffer(ByteBuffer byteBuffer, boolean z) {
        super(z ? 0 : 2, false);
        if (byteBuffer.isDirect()) {
            this._buf = byteBuffer;
            setGetIndex(byteBuffer.position());
            setPutIndex(byteBuffer.limit());
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public byte[] array() {
        return null;
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public int capacity() {
        return this._buf.capacity();
    }

    @Override // org.eclipse.jetty.p059io.nio.NIOBuffer
    public ByteBuffer getByteBuffer() {
        return this._buf;
    }

    @Override // org.eclipse.jetty.p059io.nio.NIOBuffer
    public boolean isDirect() {
        return true;
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public byte peek(int i) {
        return this._buf.get(i);
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public int peek(int i, byte[] bArr, int i2, int i3) {
        if ((i + i3 <= capacity() || (i3 = capacity() - i) != 0) && i3 >= 0) {
            try {
                this._buf.position(i);
                this._buf.get(bArr, i2, i3);
                return i3;
            } finally {
                this._buf.position(0);
            }
        }
        return -1;
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public int poke(int i, Buffer buffer) {
        if (!isReadOnly()) {
            byte[] array = buffer.array();
            if (array != null) {
                return poke(i, array, buffer.getIndex(), buffer.length());
            }
            Buffer buffer2 = buffer.buffer();
            if (!(buffer2 instanceof DirectNIOBuffer)) {
                return super.poke(i, buffer);
            }
            ByteBuffer byteBuffer = ((DirectNIOBuffer) buffer2)._buf;
            ByteBuffer byteBuffer2 = this._buf;
            if (byteBuffer == byteBuffer2) {
                byteBuffer = byteBuffer2.duplicate();
            }
            try {
                this._buf.position(i);
                int remaining = this._buf.remaining();
                int length = buffer.length();
                if (length <= remaining) {
                    remaining = length;
                }
                byteBuffer.position(buffer.getIndex());
                byteBuffer.limit(buffer.getIndex() + remaining);
                this._buf.put(byteBuffer);
                return remaining;
            } finally {
                this._buf.position(0);
                byteBuffer.limit(byteBuffer.capacity());
                byteBuffer.position(0);
            }
        }
        throw new IllegalStateException(AbstractBuffer.__READONLY);
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public int poke(int i, byte[] bArr, int i2, int i3) {
        if (!isReadOnly()) {
            if (i < 0) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("index<0: ", i, "<0"));
            }
            if (i + i3 > capacity() && (i3 = capacity() - i) < 0) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("index>capacity(): ", i, ">");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(capacity());
                throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            try {
                this._buf.position(i);
                int remaining = this._buf.remaining();
                if (i3 > remaining) {
                    i3 = remaining;
                }
                if (i3 > 0) {
                    this._buf.put(bArr, i2, i3);
                }
                return i3;
            } finally {
                this._buf.position(0);
            }
        }
        throw new IllegalStateException(AbstractBuffer.__READONLY);
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public void poke(int i, byte b) {
        if (!isReadOnly()) {
            if (i < 0) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("index<0: ", i, "<0"));
            }
            if (i <= capacity()) {
                this._buf.put(i, b);
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("index>capacity(): ", i, ">");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(capacity());
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        throw new IllegalStateException(AbstractBuffer.__READONLY);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0044, code lost:
        r9._in = null;
        r9._inStream = r10;
     */
    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int readFrom(InputStream inputStream, int i) throws IOException {
        ReadableByteChannel readableByteChannel;
        ReadableByteChannel readableByteChannel2 = this._in;
        if (readableByteChannel2 == null || !readableByteChannel2.isOpen() || inputStream != this._inStream) {
            this._in = Channels.newChannel(inputStream);
            this._inStream = inputStream;
        }
        if (i < 0 || i > space()) {
            i = space();
        }
        int putIndex = putIndex();
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i3 >= i) {
                break;
            }
            try {
                try {
                    this._buf.position(putIndex);
                    this._buf.limit(putIndex + i2);
                    i5 = this._in.read(this._buf);
                    if (i5 >= 0) {
                        if (i5 > 0) {
                            putIndex += i5;
                            i3 += i5;
                            i2 -= i5;
                            setPutIndex(putIndex);
                            i4 = 0;
                        } else {
                            int i6 = i4 + 1;
                            if (i4 > 1) {
                                break;
                            }
                            i4 = i6;
                        }
                        if (inputStream.available() <= 0) {
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (IOException e) {
                    this._in = null;
                    this._inStream = inputStream;
                    throw e;
                }
            } finally {
                readableByteChannel = this._in;
                if (readableByteChannel != null && !readableByteChannel.isOpen()) {
                    this._in = null;
                    this._inStream = inputStream;
                }
                this._buf.position(0);
                ByteBuffer byteBuffer = this._buf;
                byteBuffer.limit(byteBuffer.capacity());
            }
        }
        if (i5 < 0 && i3 == 0) {
            return -1;
        }
        ReadableByteChannel readableByteChannel3 = this._in;
        if (readableByteChannel3 != null && !readableByteChannel3.isOpen()) {
            this._in = null;
            this._inStream = inputStream;
        }
        this._buf.position(0);
        ByteBuffer byteBuffer2 = this._buf;
        byteBuffer2.limit(byteBuffer2.capacity());
        return i3;
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public void writeTo(OutputStream outputStream) throws IOException {
        int write;
        WritableByteChannel writableByteChannel = this._out;
        if (writableByteChannel == null || !writableByteChannel.isOpen() || outputStream != this._outStream) {
            this._out = Channels.newChannel(outputStream);
            this._outStream = outputStream;
        }
        synchronized (this._buf) {
            loop0: while (true) {
                int i = 0;
                while (hasContent() && this._out.isOpen()) {
                    try {
                        this._buf.position(getIndex());
                        this._buf.limit(putIndex());
                        write = this._out.write(this._buf);
                        if (write < 0) {
                            break loop0;
                        } else if (write > 0) {
                            break;
                        } else {
                            int i2 = i + 1;
                            if (i > 1) {
                                break loop0;
                            }
                            i = i2;
                        }
                    } catch (IOException e) {
                        this._out = null;
                        this._outStream = null;
                        throw e;
                    }
                }
                skip(write);
            }
            if (this._out != null && !this._out.isOpen()) {
                this._out = null;
                this._outStream = null;
            }
            this._buf.position(0);
            this._buf.limit(this._buf.capacity());
        }
    }
}
