package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.ef0;
import me.tvspark.fj0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.mx0;
import me.tvspark.nx0;
import me.tvspark.outline;
import me.tvspark.uw0;
import me.tvspark.ww0;
import me.tvspark.zi0;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.ByteString;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

@ef0
/* loaded from: classes4.dex */
public final class Http2Reader implements Closeable {
    public static final Companion Companion = new Companion(null);
    public static final Logger logger;
    public final boolean client;
    public final ContinuationSource continuation;
    public final Hpack.Reader hpackReader;
    public final ww0 source;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final Logger getLogger() {
            return Http2Reader.logger;
        }

        public final int lengthWithoutPadding(int i, int i2, int i3) throws IOException {
            if ((i2 & 8) != 0) {
                i--;
            }
            if (i3 <= i) {
                return i - i3;
            }
            throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("PROTOCOL_ERROR padding ", i3, " > remaining length ", i));
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public static final class ContinuationSource implements mx0 {
        public int flags;
        public int left;
        public int length;
        public int padding;
        public final ww0 source;
        public int streamId;

        public ContinuationSource(ww0 ww0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "source");
            this.source = ww0Var;
        }

        private final void readContinuationHeader() throws IOException {
            int i = this.streamId;
            int readMedium = Util.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            int and = Util.and(this.source.readByte(), 255);
            this.flags = Util.and(this.source.readByte(), 255);
            if (Http2Reader.Companion.getLogger().isLoggable(Level.FINE)) {
                Http2Reader.Companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, and, this.flags));
            }
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = readInt;
            if (and == 9) {
                if (readInt != i) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
                return;
            }
            throw new IOException(and + " != TYPE_CONTINUATION");
        }

        @Override // me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        @Override // me.tvspark.mx0
        public long read(uw0 uw0Var, long j) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
            while (true) {
                int i = this.left;
                if (i != 0) {
                    long read = this.source.read(uw0Var, Math.min(j, i));
                    if (read == -1) {
                        return -1L;
                    }
                    this.left -= (int) read;
                    return read;
                }
                this.source.skip(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        public final void setFlags(int i) {
            this.flags = i;
        }

        public final void setLeft(int i) {
            this.left = i;
        }

        public final void setLength(int i) {
            this.length = i;
        }

        public final void setPadding(int i) {
            this.padding = i;
        }

        public final void setStreamId(int i) {
            this.streamId = i;
        }

        @Override // me.tvspark.mx0
        public nx0 timeout() {
            return this.source.timeout();
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public interface Handler {
        void ackSettings();

        void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j);

        void data(boolean z, int i, ww0 ww0Var, int i2) throws IOException;

        void goAway(int i, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i, int i2, List<Header> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<Header> list) throws IOException;

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i, long j);
    }

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) logger2, "Logger.getLogger(Http2::class.java.name)");
        logger = logger2;
    }

    public Http2Reader(ww0 ww0Var, boolean z) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "source");
        this.source = ww0Var;
        this.client = z;
        ContinuationSource continuationSource = new ContinuationSource(ww0Var);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource, 4096, 0, 4, null);
    }

    private final void readData(Handler handler, int i, int i2, int i3) throws IOException {
        if (i3 != 0) {
            int i4 = 0;
            boolean z = true;
            boolean z2 = (i2 & 1) != 0;
            if ((i2 & 32) == 0) {
                z = false;
            }
            if (z) {
                throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
            }
            if ((i2 & 8) != 0) {
                i4 = Util.and(this.source.readByte(), 255);
            }
            handler.data(z2, i3, this.source, Companion.lengthWithoutPadding(i, i2, i4));
            this.source.skip(i4);
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
    }

    private final void readGoAway(Handler handler, int i, int i2, int i3) throws IOException {
        if (i >= 8) {
            if (i3 != 0) {
                throw new IOException("TYPE_GOAWAY streamId != 0");
            }
            int readInt = this.source.readInt();
            int readInt2 = this.source.readInt();
            int i4 = i - 8;
            ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt2);
            if (fromHttp2 == null) {
                throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TYPE_GOAWAY unexpected error code: ", readInt2));
            }
            ByteString byteString = ByteString.EMPTY;
            if (i4 > 0) {
                byteString = this.source.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
            }
            handler.goAway(readInt, fromHttp2, byteString);
            return;
        }
        throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TYPE_GOAWAY length < 8: ", i));
    }

    private final List<Header> readHeaderBlock(int i, int i2, int i3, int i4) throws IOException {
        this.continuation.setLeft(i);
        ContinuationSource continuationSource = this.continuation;
        continuationSource.setLength(continuationSource.getLeft());
        this.continuation.setPadding(i2);
        this.continuation.setFlags(i3);
        this.continuation.setStreamId(i4);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler handler, int i, int i2, int i3) throws IOException {
        if (i3 != 0) {
            int i4 = 0;
            boolean z = (i2 & 1) != 0;
            if ((i2 & 8) != 0) {
                i4 = Util.and(this.source.readByte(), 255);
            }
            if ((i2 & 32) != 0) {
                readPriority(handler, i3);
                i -= 5;
            }
            handler.headers(z, i3, -1, readHeaderBlock(Companion.lengthWithoutPadding(i, i2, i4), i4, i2, i3));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
    }

    private final void readPing(Handler handler, int i, int i2, int i3) throws IOException {
        if (i == 8) {
            if (i3 != 0) {
                throw new IOException("TYPE_PING streamId != 0");
            }
            int readInt = this.source.readInt();
            int readInt2 = this.source.readInt();
            boolean z = true;
            if ((i2 & 1) == 0) {
                z = false;
            }
            handler.ping(z, readInt, readInt2);
            return;
        }
        throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TYPE_PING length != 8: ", i));
    }

    private final void readPriority(Handler handler, int i) throws IOException {
        int readInt = this.source.readInt();
        handler.priority(i, readInt & Integer.MAX_VALUE, Util.and(this.source.readByte(), 255) + 1, (readInt & ((int) IjkMediaMeta.AV_CH_WIDE_LEFT)) != 0);
    }

    private final void readPriority(Handler handler, int i, int i2, int i3) throws IOException {
        if (i == 5) {
            if (i3 == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            readPriority(handler, i3);
            return;
        }
        throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TYPE_PRIORITY length: ", i, " != 5"));
    }

    private final void readPushPromise(Handler handler, int i, int i2, int i3) throws IOException {
        if (i3 != 0) {
            int and = (i2 & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
            handler.pushPromise(i3, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Companion.lengthWithoutPadding(i - 4, i2, and), and, i2, i3));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }

    private final void readRstStream(Handler handler, int i, int i2, int i3) throws IOException {
        if (i == 4) {
            if (i3 == 0) {
                throw new IOException("TYPE_RST_STREAM streamId == 0");
            }
            int readInt = this.source.readInt();
            ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt);
            if (fromHttp2 == null) {
                throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TYPE_RST_STREAM unexpected error code: ", readInt));
            }
            handler.rstStream(i3, fromHttp2);
            return;
        }
        throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TYPE_RST_STREAM length: ", i, " != 4"));
    }

    private final void readSettings(Handler handler, int i, int i2, int i3) throws IOException {
        int readInt;
        if (i3 == 0) {
            if ((i2 & 1) != 0) {
                if (i != 0) {
                    throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                }
                handler.ackSettings();
                return;
            } else if (i % 6 != 0) {
                throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TYPE_SETTINGS length % 6 != 0: ", i));
            } else {
                Settings settings = new Settings();
                zi0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, i), 6);
                int i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                int i5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
                int i6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
                if (i6 < 0 ? i4 >= i5 : i4 <= i5) {
                    while (true) {
                        int and = Util.and(this.source.readShort(), 65535);
                        readInt = this.source.readInt();
                        if (and != 2) {
                            if (and == 3) {
                                and = 4;
                            } else if (and == 4) {
                                and = 7;
                                if (readInt < 0) {
                                    throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                }
                            } else if (and == 5 && (readInt < 16384 || readInt > 16777215)) {
                                break;
                            }
                        } else if (readInt != 0 && readInt != 1) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                        }
                        settings.set(and, readInt);
                        if (i4 == i5) {
                            break;
                        }
                        i4 += i6;
                    }
                    throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", readInt));
                }
                handler.settings(false, settings);
                return;
            }
        }
        throw new IOException("TYPE_SETTINGS streamId != 0");
    }

    private final void readWindowUpdate(Handler handler, int i, int i2, int i3) throws IOException {
        if (i == 4) {
            long and = Util.and(this.source.readInt(), 2147483647L);
            if (and == 0) {
                throw new IOException("windowSizeIncrement was 0");
            }
            handler.windowUpdate(i3, and);
            return;
        }
        throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TYPE_WINDOW_UPDATE length !=4: ", i));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public final boolean nextFrame(boolean z, Handler handler) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(handler, "handler");
        try {
            this.source.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(9L);
            int readMedium = Util.readMedium(this.source);
            if (readMedium > 16384) {
                throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("FRAME_SIZE_ERROR: ", readMedium));
            }
            int and = Util.and(this.source.readByte(), 255);
            if (z && and != 4) {
                throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected a SETTINGS frame but was ", and));
            }
            int and2 = Util.and(this.source.readByte(), 255);
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.INSTANCE.frameLog(true, readInt, readMedium, and, and2));
            }
            switch (and) {
                case 0:
                    readData(handler, readMedium, and2, readInt);
                    return true;
                case 1:
                    readHeaders(handler, readMedium, and2, readInt);
                    return true;
                case 2:
                    readPriority(handler, readMedium, and2, readInt);
                    return true;
                case 3:
                    readRstStream(handler, readMedium, and2, readInt);
                    return true;
                case 4:
                    readSettings(handler, readMedium, and2, readInt);
                    return true;
                case 5:
                    readPushPromise(handler, readMedium, and2, readInt);
                    return true;
                case 6:
                    readPing(handler, readMedium, and2, readInt);
                    return true;
                case 7:
                    readGoAway(handler, readMedium, and2, readInt);
                    return true;
                case 8:
                    readWindowUpdate(handler, readMedium, and2, readInt);
                    return true;
                default:
                    this.source.skip(readMedium);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readConnectionPreface(Handler handler) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(handler, "handler");
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.source.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Http2.CONNECTION_PREFACE.size());
        if (logger.isLoggable(Level.FINE)) {
            Logger logger2 = logger;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<< CONNECTION ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hex());
            logger2.fine(Util.format(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), new Object[0]));
        }
        if (!(!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Http2.CONNECTION_PREFACE, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected a connection header but was ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.utf8());
        throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
    }
}
