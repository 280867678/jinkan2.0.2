package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.outline;
import me.tvspark.uw0;
import me.tvspark.vw0;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

@ef0
/* loaded from: classes4.dex */
public final class Http2Writer implements Closeable {
    public static final Companion Companion = new Companion(null);
    public static final Logger logger = Logger.getLogger(Http2.class.getName());
    public final boolean client;
    public boolean closed;
    public final uw0 hpackBuffer;
    public final Hpack.Writer hpackWriter;
    public int maxFrameSize = 16384;
    public final vw0 sink;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }
    }

    public Http2Writer(vw0 vw0Var, boolean z) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vw0Var, "sink");
        this.sink = vw0Var;
        this.client = z;
        uw0 uw0Var = new uw0();
        this.hpackBuffer = uw0Var;
        this.hpackWriter = new Hpack.Writer(0, false, uw0Var, 3, null);
    }

    private final void writeContinuationFrames(int i, long j) throws IOException {
        while (j > 0) {
            long min = Math.min(this.maxFrameSize, j);
            j -= min;
            frameHeader(i, (int) min, 9, j == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, min);
        }
    }

    public final synchronized void applyAndAckSettings(Settings settings) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(settings, "peerSettings");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
        if (settings.getHeaderTableSize() != -1) {
            this.hpackWriter.resizeHeaderTable(settings.getHeaderTableSize());
        }
        frameHeader(0, 0, 4, 1);
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void connectionPreface() throws IOException {
        if (!this.closed) {
            if (!this.client) {
                return;
            }
            if (logger.isLoggable(Level.FINE)) {
                Logger logger2 = logger;
                logger2.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
            }
            this.sink.mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Http2.CONNECTION_PREFACE);
            this.sink.flush();
            return;
        }
        throw new IOException("closed");
    }

    public final synchronized void data(boolean z, int i, uw0 uw0Var, int i2) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        int i3 = 0;
        if (z) {
            i3 = 1;
        }
        dataFrame(i, i3, uw0Var, i2);
    }

    public final void dataFrame(int i, int i2, uw0 uw0Var, int i3) throws IOException {
        frameHeader(i, i3, 0, i2);
        if (i3 > 0) {
            vw0 vw0Var = this.sink;
            if (uw0Var != null) {
                vw0Var.write(uw0Var, i3);
            } else {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
        }
    }

    public final synchronized void flush() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public final void frameHeader(int i, int i2, int i3, int i4) throws IOException {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.INSTANCE.frameLog(false, i, i2, i3, i4));
        }
        boolean z = true;
        if (!(i2 <= this.maxFrameSize)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("FRAME_SIZE_ERROR length > ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.maxFrameSize);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(": ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i2);
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
        }
        if ((((int) IjkMediaMeta.AV_CH_WIDE_LEFT) & i) != 0) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("reserved bit set: ", i).toString());
        }
        Util.writeMedium(this.sink, i2);
        this.sink.mo4963writeByte(i3 & 255);
        this.sink.mo4963writeByte(i4 & 255);
        this.sink.mo4964writeInt(i & Integer.MAX_VALUE);
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(errorCode, "errorCode");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "debugData");
        if (this.closed) {
            throw new IOException("closed");
        }
        boolean z = false;
        if (!(errorCode.getHttpCode() != -1)) {
            throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
        }
        frameHeader(0, bArr.length + 8, 7, 0);
        this.sink.mo4964writeInt(i);
        this.sink.mo4964writeInt(errorCode.getHttpCode());
        if (bArr.length == 0) {
            z = true;
        }
        if (!z) {
            this.sink.mo4961write(bArr);
        }
        this.sink.flush();
    }

    public final synchronized void headers(boolean z, int i, List<Header> list) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "headerBlock");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long j = this.hpackBuffer.Wwwwwwwwwwwwwwwwwwwwwww;
        long min = Math.min(this.maxFrameSize, j);
        int i2 = (j > min ? 1 : (j == min ? 0 : -1));
        int i3 = i2 == 0 ? 4 : 0;
        if (z) {
            i3 |= 1;
        }
        frameHeader(i, (int) min, 1, i3);
        this.sink.write(this.hpackBuffer, min);
        if (i2 > 0) {
            writeContinuationFrames(i, j - min);
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean z, int i, int i2) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        frameHeader(0, 8, 6, z ? 1 : 0);
        this.sink.mo4964writeInt(i);
        this.sink.mo4964writeInt(i2);
        this.sink.flush();
    }

    public final synchronized void pushPromise(int i, int i2, List<Header> list) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "requestHeaders");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long j = this.hpackBuffer.Wwwwwwwwwwwwwwwwwwwwwww;
        int min = (int) Math.min(this.maxFrameSize - 4, j);
        int i3 = min + 4;
        long j2 = min;
        int i4 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        frameHeader(i, i3, 5, i4 == 0 ? 4 : 0);
        this.sink.mo4964writeInt(i2 & Integer.MAX_VALUE);
        this.sink.write(this.hpackBuffer, j2);
        if (i4 > 0) {
            writeContinuationFrames(i, j - j2);
        }
    }

    public final synchronized void rstStream(int i, ErrorCode errorCode) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(errorCode, "errorCode");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(errorCode.getHttpCode() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        frameHeader(i, 4, 3, 0);
        this.sink.mo4964writeInt(errorCode.getHttpCode());
        this.sink.flush();
    }

    public final synchronized void settings(Settings settings) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(settings, "settings");
        if (this.closed) {
            throw new IOException("closed");
        }
        int i = 0;
        frameHeader(0, settings.size() * 6, 4, 0);
        while (i < 10) {
            if (settings.isSet(i)) {
                this.sink.mo4965writeShort(i != 4 ? i != 7 ? i : 4 : 3);
                this.sink.mo4964writeInt(settings.get(i));
            }
            i++;
        }
        this.sink.flush();
    }

    public final synchronized void windowUpdate(int i, long j) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(j != 0 && j <= 2147483647L)) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
        }
        frameHeader(i, 4, 8, 0);
        this.sink.mo4964writeInt((int) j);
        this.sink.flush();
    }
}
