package okhttp3.internal.http2;

import com.arialyy.aria.core.inf.IOptionConstant;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.kx0;
import me.tvspark.mx0;
import me.tvspark.nx0;
import me.tvspark.outline;
import me.tvspark.pf0;
import me.tvspark.sw0;
import me.tvspark.uw0;
import me.tvspark.ww0;
import okhttp3.Headers;
import okhttp3.internal.Util;

@ef0
/* loaded from: classes4.dex */
public final class Http2Stream {
    public static final Companion Companion = new Companion(null);
    public static final long EMIT_BUFFER_SIZE = 16384;
    public long bytesLeftInWriteWindow;
    public final Http2Connection connection;
    public ErrorCode errorCode;
    public IOException errorException;
    public boolean hasResponseHeaders;

    /* renamed from: id */
    public final int f4541id;
    public final FramingSink sink;
    public final FramingSource source;
    public long unacknowledgedBytesRead;
    public final ArrayDeque<Headers> headersQueue = new ArrayDeque<>();
    public final StreamTimeout readTimeout = new StreamTimeout();
    public final StreamTimeout writeTimeout = new StreamTimeout();

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public final class FramingSink implements kx0 {
        public boolean closed;
        public boolean finished;
        public final uw0 sendBuffer;
        public Headers trailers;

        public FramingSink(boolean z) {
            this.finished = z;
            this.sendBuffer = new uw0();
        }

        public /* synthetic */ FramingSink(Http2Stream http2Stream, boolean z, int i, gi0 gi0Var) {
            this((i & 1) != 0 ? false : z);
        }

        private final void emitFrame(boolean z) throws IOException {
            long min;
            boolean z2;
            synchronized (Http2Stream.this) {
                Http2Stream.this.getWriteTimeout$okhttp().enter();
                while (Http2Stream.this.getBytesLeftInWriteWindow() <= 0 && !this.finished && !this.closed && Http2Stream.this.getErrorCode$okhttp() == null) {
                    Http2Stream.this.waitForIo$okhttp();
                }
                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                Http2Stream.this.checkOutNotClosed$okhttp();
                min = Math.min(Http2Stream.this.getBytesLeftInWriteWindow(), this.sendBuffer.Wwwwwwwwwwwwwwwwwwwwwww);
                Http2Stream http2Stream = Http2Stream.this;
                http2Stream.setBytesLeftInWriteWindow$okhttp(http2Stream.getBytesLeftInWriteWindow() - min);
            }
            Http2Stream.this.getWriteTimeout$okhttp().enter();
            if (z) {
                try {
                    if (min == this.sendBuffer.Wwwwwwwwwwwwwwwwwwwwwww) {
                        z2 = true;
                        Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), z2, this.sendBuffer, min);
                        Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                    }
                } catch (Throwable th) {
                    Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                    throw th;
                }
            }
            z2 = false;
            Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), z2, this.sendBuffer, min);
            Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
        }

        @Override // me.tvspark.kx0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            boolean z;
            boolean z2 = !Thread.holdsLock(Http2Stream.this);
            if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z2) {
                synchronized (Http2Stream.this) {
                    z = this.closed;
                }
                if (z) {
                    return;
                }
                if (!Http2Stream.this.getSink$okhttp().finished) {
                    boolean z3 = this.sendBuffer.Wwwwwwwwwwwwwwwwwwwwwww > 0;
                    if (this.trailers != null) {
                        while (this.sendBuffer.Wwwwwwwwwwwwwwwwwwwwwww > 0) {
                            emitFrame(false);
                        }
                        Http2Connection connection = Http2Stream.this.getConnection();
                        int id = Http2Stream.this.getId();
                        Headers headers = this.trailers;
                        if (headers == null) {
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            throw null;
                        }
                        connection.writeHeaders$okhttp(id, true, Util.toHeaderList(headers));
                    } else if (z3) {
                        while (this.sendBuffer.Wwwwwwwwwwwwwwwwwwwwwww > 0) {
                            emitFrame(true);
                        }
                    } else {
                        Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.closed = true;
                }
                Http2Stream.this.getConnection().flush();
                Http2Stream.this.cancelStreamIfNecessary$okhttp();
                return;
            }
            throw new AssertionError("Assertion failed");
        }

        @Override // me.tvspark.kx0, java.io.Flushable
        public void flush() throws IOException {
            boolean z = !Thread.holdsLock(Http2Stream.this);
            if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z) {
                synchronized (Http2Stream.this) {
                    Http2Stream.this.checkOutNotClosed$okhttp();
                }
                while (this.sendBuffer.Wwwwwwwwwwwwwwwwwwwwwww > 0) {
                    emitFrame(false);
                    Http2Stream.this.getConnection().flush();
                }
                return;
            }
            throw new AssertionError("Assertion failed");
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        public final void setFinished(boolean z) {
            this.finished = z;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        @Override // me.tvspark.kx0
        public nx0 timeout() {
            return Http2Stream.this.getWriteTimeout$okhttp();
        }

        @Override // me.tvspark.kx0
        public void write(uw0 uw0Var, long j) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "source");
            boolean z = !Thread.holdsLock(Http2Stream.this);
            if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z) {
                this.sendBuffer.write(uw0Var, j);
                while (this.sendBuffer.Wwwwwwwwwwwwwwwwwwwwwww >= 16384) {
                    emitFrame(false);
                }
                return;
            }
            throw new AssertionError("Assertion failed");
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public final class FramingSource implements mx0 {
        public boolean closed;
        public boolean finished;
        public final long maxByteCount;
        public Headers trailers;
        public final uw0 receiveBuffer = new uw0();
        public final uw0 readBuffer = new uw0();

        public FramingSource(long j, boolean z) {
            this.maxByteCount = j;
            this.finished = z;
        }

        private final void updateConnectionFlowControl(long j) {
            boolean z = !Thread.holdsLock(Http2Stream.this);
            if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z) {
                Http2Stream.this.getConnection().updateConnectionFlowControl$okhttp(j);
                return;
            }
            throw new AssertionError("Assertion failed");
        }

        @Override // me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long j;
            synchronized (Http2Stream.this) {
                this.closed = true;
                j = this.readBuffer.Wwwwwwwwwwwwwwwwwwwwwww;
                uw0 uw0Var = this.readBuffer;
                uw0Var.skip(uw0Var.Wwwwwwwwwwwwwwwwwwwwwww);
                Http2Stream http2Stream = Http2Stream.this;
                if (http2Stream == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                }
                http2Stream.notifyAll();
            }
            if (j > 0) {
                updateConnectionFlowControl(j);
            }
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        public final uw0 getReadBuffer() {
            return this.readBuffer;
        }

        public final uw0 getReceiveBuffer() {
            return this.receiveBuffer;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        @Override // me.tvspark.mx0
        public long read(uw0 uw0Var, long j) throws IOException {
            IOException iOException;
            boolean z;
            long j2;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
            if (j >= 0) {
                do {
                    synchronized (Http2Stream.this) {
                        Http2Stream.this.getReadTimeout$okhttp().enter();
                        iOException = null;
                        if (Http2Stream.this.getErrorCode$okhttp() != null) {
                            IOException errorException$okhttp = Http2Stream.this.getErrorException$okhttp();
                            if (errorException$okhttp == null) {
                                ErrorCode errorCode$okhttp = Http2Stream.this.getErrorCode$okhttp();
                                if (errorCode$okhttp == null) {
                                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    throw null;
                                }
                                errorException$okhttp = new StreamResetException(errorCode$okhttp);
                            }
                            iOException = errorException$okhttp;
                        }
                        if (this.closed) {
                            throw new IOException("stream closed");
                        }
                        if (this.readBuffer.Wwwwwwwwwwwwwwwwwwwwwww > 0) {
                            j2 = this.readBuffer.read(uw0Var, Math.min(j, this.readBuffer.Wwwwwwwwwwwwwwwwwwwwwww));
                            Http2Stream http2Stream = Http2Stream.this;
                            http2Stream.setUnacknowledgedBytesRead$okhttp(http2Stream.getUnacknowledgedBytesRead() + j2);
                            if (iOException == null && Http2Stream.this.getUnacknowledgedBytesRead() >= Http2Stream.this.getConnection().getOkHttpSettings().getInitialWindowSize() / 2) {
                                Http2Stream.this.getConnection().writeWindowUpdateLater$okhttp(Http2Stream.this.getId(), Http2Stream.this.getUnacknowledgedBytesRead());
                                Http2Stream.this.setUnacknowledgedBytesRead$okhttp(0L);
                            }
                            z = false;
                        } else {
                            if (this.finished || iOException != null) {
                                z = false;
                            } else {
                                Http2Stream.this.waitForIo$okhttp();
                                z = true;
                            }
                            j2 = -1;
                        }
                        Http2Stream.this.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                    }
                } while (z);
                if (j2 != -1) {
                    updateConnectionFlowControl(j2);
                    return j2;
                } else if (iOException == null) {
                    return -1L;
                } else {
                    throw iOException;
                }
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("byteCount < 0: ", j).toString());
        }

        public final void receive$okhttp(ww0 ww0Var, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "source");
            boolean z4 = !Thread.holdsLock(Http2Stream.this);
            if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z4) {
                while (j > 0) {
                    synchronized (Http2Stream.this) {
                        z = this.finished;
                        z2 = false;
                        z3 = this.readBuffer.Wwwwwwwwwwwwwwwwwwwwwww + j > this.maxByteCount;
                    }
                    if (z3) {
                        ww0Var.skip(j);
                        Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        ww0Var.skip(j);
                        return;
                    } else {
                        long read = ww0Var.read(this.receiveBuffer, j);
                        if (read == -1) {
                            throw new EOFException();
                        }
                        j -= read;
                        synchronized (Http2Stream.this) {
                            if (this.readBuffer.Wwwwwwwwwwwwwwwwwwwwwww == 0) {
                                z2 = true;
                            }
                            this.readBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((mx0) this.receiveBuffer);
                            if (z2) {
                                Http2Stream http2Stream = Http2Stream.this;
                                if (http2Stream == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                                }
                                http2Stream.notifyAll();
                            }
                        }
                    }
                }
                return;
            }
            throw new AssertionError("Assertion failed");
        }

        public final void setClosed$okhttp(boolean z) {
            this.closed = z;
        }

        public final void setFinished$okhttp(boolean z) {
            this.finished = z;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        @Override // me.tvspark.mx0
        public nx0 timeout() {
            return Http2Stream.this.getReadTimeout$okhttp();
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public final class StreamTimeout extends sw0 {
        public StreamTimeout() {
        }

        public final void exitAndThrowIfTimedOut() throws IOException {
            if (!exit()) {
                return;
            }
            throw newTimeoutException(null);
        }

        @Override // me.tvspark.sw0
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // me.tvspark.sw0
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
        }
    }

    public Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, Headers headers) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(http2Connection, "connection");
        this.f4541id = i;
        this.connection = http2Connection;
        this.bytesLeftInWriteWindow = http2Connection.getPeerSettings().getInitialWindowSize();
        this.source = new FramingSource(this.connection.getOkHttpSettings().getInitialWindowSize(), z2);
        this.sink = new FramingSink(z);
        boolean isLocallyInitiated = isLocallyInitiated();
        if (headers == null) {
            if (!isLocallyInitiated) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else if (!(!isLocallyInitiated)) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
        } else {
            this.headersQueue.add(headers);
        }
    }

    private final boolean closeInternal(ErrorCode errorCode, IOException iOException) {
        boolean z = !Thread.holdsLock(this);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z) {
            synchronized (this) {
                if (this.errorCode != null) {
                    return false;
                }
                if (this.source.getFinished$okhttp() && this.sink.getFinished()) {
                    return false;
                }
                this.errorCode = errorCode;
                this.errorException = iOException;
                notifyAll();
                this.connection.removeStream$okhttp(this.f4541id);
                return true;
            }
        }
        throw new AssertionError("Assertion failed");
    }

    public final void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        boolean isOpen;
        boolean z = true;
        boolean z2 = !Thread.holdsLock(this);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z2) {
            synchronized (this) {
                if (this.source.getFinished$okhttp() || !this.source.getClosed$okhttp() || (!this.sink.getFinished() && !this.sink.getClosed())) {
                    z = false;
                }
                isOpen = isOpen();
            }
            if (z) {
                close(ErrorCode.CANCEL, null);
                return;
            } else if (isOpen) {
                return;
            } else {
                this.connection.removeStream$okhttp(this.f4541id);
                return;
            }
        }
        throw new AssertionError("Assertion failed");
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        if (!this.sink.getClosed()) {
            if (this.sink.getFinished()) {
                throw new IOException("stream finished");
            }
            if (this.errorCode == null) {
                return;
            }
            Throwable th = this.errorException;
            if (th == null) {
                ErrorCode errorCode = this.errorCode;
                if (errorCode == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                th = new StreamResetException(errorCode);
            }
            throw th;
        }
        throw new IOException("stream closed");
    }

    public final void close(ErrorCode errorCode, IOException iOException) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(errorCode, "rstStatusCode");
        if (!closeInternal(errorCode, iOException)) {
            return;
        }
        this.connection.writeSynReset$okhttp(this.f4541id, errorCode);
    }

    public final void closeLater(ErrorCode errorCode) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(errorCode, "errorCode");
        if (!closeInternal(errorCode, null)) {
            return;
        }
        this.connection.writeSynResetLater$okhttp(this.f4541id, errorCode);
    }

    public final void enqueueTrailers(Headers headers) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers, "trailers");
        synchronized (this) {
            boolean z = true;
            if (!(!this.sink.getFinished())) {
                throw new IllegalStateException("already finished".toString());
            }
            if (headers.size() == 0) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException("trailers.size() == 0".toString());
            }
            this.sink.setTrailers(headers);
        }
    }

    public final long getBytesLeftInWriteWindow() {
        return this.bytesLeftInWriteWindow;
    }

    public final Http2Connection getConnection() {
        return this.connection;
    }

    public final synchronized ErrorCode getErrorCode$okhttp() {
        return this.errorCode;
    }

    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.f4541id;
    }

    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    public final kx0 getSink() {
        synchronized (this) {
            if (!(this.hasResponseHeaders || isLocallyInitiated())) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
        }
        return this.sink;
    }

    public final FramingSink getSink$okhttp() {
        return this.sink;
    }

    public final mx0 getSource() {
        return this.source;
    }

    public final FramingSource getSource$okhttp() {
        return this.source;
    }

    public final long getUnacknowledgedBytesRead() {
        return this.unacknowledgedBytesRead;
    }

    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        return this.connection.getClient$okhttp() == ((this.f4541id & 1) == 1);
    }

    public final synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.source.getFinished$okhttp() || this.source.getClosed$okhttp()) && (this.sink.getFinished() || this.sink.getClosed())) {
            if (this.hasResponseHeaders) {
                return false;
            }
        }
        return true;
    }

    public final nx0 readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(ww0 ww0Var, int i) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "source");
        boolean z = !Thread.holdsLock(this);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z) {
            this.source.receive$okhttp(ww0Var, i);
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031 A[Catch: all -> 0x0048, TryCatch #0 {, blocks: (B:9:0x001b, B:13:0x0022, B:15:0x0031, B:16:0x0036, B:23:0x0028), top: B:8:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void receiveHeaders(Headers headers, boolean z) {
        boolean isOpen;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers, IOptionConstant.headers);
        boolean z2 = !Thread.holdsLock(this);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z2) {
            synchronized (this) {
                if (this.hasResponseHeaders && z) {
                    this.source.setTrailers(headers);
                    if (z) {
                        this.source.setFinished$okhttp(true);
                    }
                    isOpen = isOpen();
                    notifyAll();
                }
                this.hasResponseHeaders = true;
                this.headersQueue.add(headers);
                if (z) {
                }
                isOpen = isOpen();
                notifyAll();
            }
            if (isOpen) {
                return;
            }
            this.connection.removeStream$okhttp(this.f4541id);
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    public final synchronized void receiveRstStream(ErrorCode errorCode) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(errorCode, "errorCode");
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public final void setBytesLeftInWriteWindow$okhttp(long j) {
        this.bytesLeftInWriteWindow = j;
    }

    public final void setErrorCode$okhttp(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public final void setErrorException$okhttp(IOException iOException) {
        this.errorException = iOException;
    }

    public final void setUnacknowledgedBytesRead$okhttp(long j) {
        this.unacknowledgedBytesRead = j;
    }

    public final synchronized Headers takeHeaders() throws IOException {
        Headers removeFirst;
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            waitForIo$okhttp();
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (!(!this.headersQueue.isEmpty())) {
            Throwable th = this.errorException;
            if (th == null) {
                ErrorCode errorCode = this.errorCode;
                if (errorCode == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                th = new StreamResetException(errorCode);
            }
            throw th;
        }
        removeFirst = this.headersQueue.removeFirst();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) removeFirst, "headersQueue.removeFirst()");
        return removeFirst;
    }

    public final synchronized Headers trailers() throws IOException {
        Headers trailers;
        if (this.errorCode != null) {
            Throwable th = this.errorException;
            if (th == null) {
                ErrorCode errorCode = this.errorCode;
                if (errorCode == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                th = new StreamResetException(errorCode);
            }
            throw th;
        }
        if (!(this.source.getFinished$okhttp() && this.source.getReceiveBuffer().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && this.source.getReadBuffer().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
            throw new IllegalStateException("too early; can't read the trailers yet".toString());
        }
        trailers = this.source.getTrailers();
        if (trailers == null) {
            trailers = Util.EMPTY_HEADERS;
        }
        return trailers;
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void writeHeaders(List<Header> list, boolean z, boolean z2) throws IOException {
        boolean z3;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "responseHeaders");
        boolean z4 = !Thread.holdsLock(this);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z4) {
            synchronized (this) {
                this.hasResponseHeaders = true;
                if (z) {
                    this.sink.setFinished(true);
                }
            }
            if (!z2) {
                synchronized (this.connection) {
                    z3 = this.connection.getBytesLeftInWriteWindow() == 0;
                }
                z2 = z3;
            }
            this.connection.writeHeaders$okhttp(this.f4541id, z, list);
            if (!z2) {
                return;
            }
            this.connection.flush();
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    public final nx0 writeTimeout() {
        return this.writeTimeout;
    }
}
