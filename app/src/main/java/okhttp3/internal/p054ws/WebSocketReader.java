package okhttp3.internal.p054ws;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.outline;
import me.tvspark.uw0;
import me.tvspark.ww0;
import okhttp3.internal.Util;
import okio.ByteString;

@ef0
/* renamed from: okhttp3.internal.ws.WebSocketReader */
/* loaded from: classes4.dex */
public final class WebSocketReader {
    public boolean closed;
    public final FrameCallback frameCallback;
    public long frameLength;
    public final boolean isClient;
    public boolean isControlFrame;
    public boolean isFinalFrame;
    public final uw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww maskCursor;
    public final byte[] maskKey;
    public int opcode;
    public final ww0 source;
    public final uw0 controlFrameBuffer = new uw0();
    public final uw0 messageFrameBuffer = new uw0();

    @ef0
    /* renamed from: okhttp3.internal.ws.WebSocketReader$FrameCallback */
    /* loaded from: classes4.dex */
    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    public WebSocketReader(boolean z, ww0 ww0Var, FrameCallback frameCallback) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "source");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(frameCallback, "frameCallback");
        this.isClient = z;
        this.source = ww0Var;
        this.frameCallback = frameCallback;
        uw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.maskKey = this.isClient ? null : new byte[4];
        this.maskCursor = !this.isClient ? new uw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    private final void readControlFrame() throws IOException {
        String str;
        long j = this.frameLength;
        if (j > 0) {
            this.source.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.controlFrameBuffer, j);
            if (!this.isClient) {
                uw0 uw0Var = this.controlFrameBuffer;
                uw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.maskCursor;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.maskCursor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L);
                WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                uw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.maskCursor;
                byte[] bArr = this.maskKey;
                if (bArr == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else {
                    webSocketProtocol.toggleMask(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, bArr);
                    this.maskCursor.close();
                }
            }
        }
        switch (this.opcode) {
            case 8:
                short s = 1005;
                uw0 uw0Var2 = this.controlFrameBuffer;
                long j2 = uw0Var2.Wwwwwwwwwwwwwwwwwwwwwww;
                if (j2 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j2 != 0) {
                    s = uw0Var2.readShort();
                    str = this.controlFrameBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwww();
                    String closeCodeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(s);
                    if (closeCodeExceptionMessage != null) {
                        throw new ProtocolException(closeCodeExceptionMessage);
                    }
                } else {
                    str = "";
                }
                this.frameCallback.onReadClose(s, str);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwww());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwww());
                return;
            default:
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unknown control opcode: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Util.toHexString(this.opcode));
                throw new ProtocolException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    private final void readHeader() throws IOException, ProtocolException {
        if (!this.closed) {
            long timeoutNanos = this.source.timeout().timeoutNanos();
            this.source.timeout().clearTimeout();
            try {
                int and = Util.and(this.source.readByte(), 255);
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                this.opcode = and & 15;
                boolean z = true;
                this.isFinalFrame = (and & 128) != 0;
                boolean z2 = (and & 8) != 0;
                this.isControlFrame = z2;
                if (z2 && !this.isFinalFrame) {
                    throw new ProtocolException("Control frames must be final.");
                }
                boolean z3 = (and & 64) != 0;
                boolean z4 = (and & 32) != 0;
                boolean z5 = (and & 16) != 0;
                if (z3 || z4 || z5) {
                    throw new ProtocolException("Reserved flags are unsupported.");
                }
                int and2 = Util.and(this.source.readByte(), 255);
                if ((and2 & 128) == 0) {
                    z = false;
                }
                if (z == this.isClient) {
                    throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                }
                long j = and2 & 127;
                this.frameLength = j;
                if (j == 126) {
                    this.frameLength = Util.and(this.source.readShort(), 65535);
                } else if (j == 127) {
                    long readLong = this.source.readLong();
                    this.frameLength = readLong;
                    if (readLong < 0) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Frame length 0x");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Util.toHexString(this.frameLength));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" > 0x7FFFFFFFFFFFFFFF");
                        throw new ProtocolException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    }
                }
                if (this.isControlFrame && this.frameLength > 125) {
                    throw new ProtocolException("Control frame must be less than 125B.");
                }
                if (!z) {
                    return;
                }
                ww0 ww0Var = this.source;
                byte[] bArr = this.maskKey;
                if (bArr != null) {
                    ww0Var.readFully(bArr);
                    return;
                } else {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
            } catch (Throwable th) {
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        }
        throw new IOException("closed");
    }

    private final void readMessage() throws IOException {
        while (!this.closed) {
            long j = this.frameLength;
            if (j > 0) {
                this.source.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.messageFrameBuffer, j);
                if (!this.isClient) {
                    uw0 uw0Var = this.messageFrameBuffer;
                    uw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.maskCursor;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.maskCursor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.messageFrameBuffer.Wwwwwwwwwwwwwwwwwwwwwww - this.frameLength);
                    WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                    uw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.maskCursor;
                    byte[] bArr = this.maskKey;
                    if (bArr == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    } else {
                        webSocketProtocol.toggleMask(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, bArr);
                        this.maskCursor.close();
                    }
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected continuation opcode. Got: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Util.toHexString(this.opcode));
                throw new ProtocolException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }
        throw new IOException("closed");
    }

    private final void readMessageFrame() throws IOException {
        int i = this.opcode;
        if (i != 1 && i != 2) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unknown opcode: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Util.toHexString(i));
            throw new ProtocolException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        readMessage();
        if (i == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwww());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    private final void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            }
            readControlFrame();
        }
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final ww0 getSource() {
        return this.source;
    }

    public final void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }

    public final void setClosed(boolean z) {
        this.closed = z;
    }
}
