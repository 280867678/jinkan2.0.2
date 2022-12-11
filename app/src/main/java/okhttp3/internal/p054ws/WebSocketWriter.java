package okhttp3.internal.p054ws;

import java.io.IOException;
import java.util.Random;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.kx0;
import me.tvspark.nx0;
import me.tvspark.uw0;
import me.tvspark.vw0;
import okio.ByteString;

@ef0
/* renamed from: okhttp3.internal.ws.WebSocketWriter */
/* loaded from: classes4.dex */
public final class WebSocketWriter {
    public boolean activeWriter;
    public final uw0 buffer = new uw0();
    public final FrameSink frameSink = new FrameSink();
    public final boolean isClient;
    public final uw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww maskCursor;
    public final byte[] maskKey;
    public final Random random;
    public final vw0 sink;
    public final uw0 sinkBuffer;
    public boolean writerClosed;

    @ef0
    /* renamed from: okhttp3.internal.ws.WebSocketWriter$FrameSink */
    /* loaded from: classes4.dex */
    public final class FrameSink implements kx0 {
        public boolean closed;
        public long contentLength;
        public int formatOpcode;
        public boolean isFirstFrame;

        public FrameSink() {
        }

        @Override // me.tvspark.kx0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.getBuffer().Wwwwwwwwwwwwwwwwwwwwwww, this.isFirstFrame, true);
                this.closed = true;
                WebSocketWriter.this.setActiveWriter(false);
                return;
            }
            throw new IOException("closed");
        }

        @Override // me.tvspark.kx0, java.io.Flushable
        public void flush() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.getBuffer().Wwwwwwwwwwwwwwwwwwwwwww, this.isFirstFrame, false);
                this.isFirstFrame = false;
                return;
            }
            throw new IOException("closed");
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final long getContentLength() {
            return this.contentLength;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }

        public final boolean isFirstFrame() {
            return this.isFirstFrame;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        public final void setContentLength(long j) {
            this.contentLength = j;
        }

        public final void setFirstFrame(boolean z) {
            this.isFirstFrame = z;
        }

        public final void setFormatOpcode(int i) {
            this.formatOpcode = i;
        }

        @Override // me.tvspark.kx0
        public nx0 timeout() {
            return WebSocketWriter.this.getSink().timeout();
        }

        @Override // me.tvspark.kx0
        public void write(uw0 uw0Var, long j) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "source");
            if (!this.closed) {
                WebSocketWriter.this.getBuffer().write(uw0Var, j);
                boolean z = this.isFirstFrame && this.contentLength != -1 && WebSocketWriter.this.getBuffer().Wwwwwwwwwwwwwwwwwwwwwww > this.contentLength - ((long) 8192);
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = WebSocketWriter.this.getBuffer().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 0 || z) {
                    return;
                }
                WebSocketWriter.this.writeMessageFrame(this.formatOpcode, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.isFirstFrame, false);
                this.isFirstFrame = false;
                return;
            }
            throw new IOException("closed");
        }
    }

    public WebSocketWriter(boolean z, vw0 vw0Var, Random random) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vw0Var, "sink");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(random, "random");
        this.isClient = z;
        this.sink = vw0Var;
        this.random = random;
        this.sinkBuffer = vw0Var.getBuffer();
        uw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.maskKey = this.isClient ? new byte[4] : null;
        this.maskCursor = this.isClient ? new uw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    private final void writeControlFrame(int i, ByteString byteString) throws IOException {
        if (!this.writerClosed) {
            int size = byteString.size();
            if (!(((long) size) <= 125)) {
                throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
            }
            this.sinkBuffer.mo4963writeByte(i | 128);
            if (this.isClient) {
                this.sinkBuffer.mo4963writeByte(size | 128);
                Random random = this.random;
                byte[] bArr = this.maskKey;
                if (bArr == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                random.nextBytes(bArr);
                this.sinkBuffer.mo4961write(this.maskKey);
                if (size > 0) {
                    uw0 uw0Var = this.sinkBuffer;
                    long j = uw0Var.Wwwwwwwwwwwwwwwwwwwwwww;
                    uw0Var.mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString);
                    uw0 uw0Var2 = this.sinkBuffer;
                    uw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.maskCursor;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    uw0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.maskCursor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                    WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            } else {
                this.sinkBuffer.mo4963writeByte(size);
                this.sinkBuffer.mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString);
            }
            this.sink.flush();
            return;
        }
        throw new IOException("closed");
    }

    public final boolean getActiveWriter() {
        return this.activeWriter;
    }

    public final uw0 getBuffer() {
        return this.buffer;
    }

    public final Random getRandom() {
        return this.random;
    }

    public final vw0 getSink() {
        return this.sink;
    }

    public final kx0 newMessageSink(int i, long j) {
        if (!this.activeWriter) {
            this.activeWriter = true;
            this.frameSink.setFormatOpcode(i);
            this.frameSink.setContentLength(j);
            this.frameSink.setFirstFrame(true);
            this.frameSink.setClosed(false);
            return this.frameSink;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?".toString());
    }

    public final void setActiveWriter(boolean z) {
        this.activeWriter = z;
    }

    public final void writeClose(int i, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (i != 0 || byteString != null) {
            if (i != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i);
            }
            uw0 uw0Var = new uw0();
            uw0Var.mo4965writeShort(i);
            if (byteString != null) {
                uw0Var.mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString);
            }
            byteString2 = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i, long j, boolean z, boolean z2) throws IOException {
        if (!this.writerClosed) {
            int i2 = 0;
            if (!z) {
                i = 0;
            }
            if (z2) {
                i |= 128;
            }
            this.sinkBuffer.mo4963writeByte(i);
            if (this.isClient) {
                i2 = 128;
            }
            if (j <= 125) {
                this.sinkBuffer.mo4963writeByte(((int) j) | i2);
            } else if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                this.sinkBuffer.mo4963writeByte(i2 | 126);
                this.sinkBuffer.mo4965writeShort((int) j);
            } else {
                this.sinkBuffer.mo4963writeByte(i2 | 127);
                this.sinkBuffer.Wwwwwwwwwwwwwwwwwwwwwwwww(j);
            }
            if (this.isClient) {
                Random random = this.random;
                byte[] bArr = this.maskKey;
                if (bArr == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                random.nextBytes(bArr);
                this.sinkBuffer.mo4961write(this.maskKey);
                if (j > 0) {
                    uw0 uw0Var = this.sinkBuffer;
                    long j2 = uw0Var.Wwwwwwwwwwwwwwwwwwwwwww;
                    uw0Var.write(this.buffer, j);
                    uw0 uw0Var2 = this.sinkBuffer;
                    uw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.maskCursor;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    uw0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.maskCursor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2);
                    WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            } else {
                this.sinkBuffer.write(this.buffer, j);
            }
            this.sink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        throw new IOException("closed");
    }

    public final void writePing(ByteString byteString) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "payload");
        writeControlFrame(9, byteString);
    }

    public final void writePong(ByteString byteString) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "payload");
        writeControlFrame(10, byteString);
    }
}
