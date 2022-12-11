package org.eclipse.jetty.p059io.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import org.eclipse.jetty.p059io.AbstractConnection;
import org.eclipse.jetty.p059io.AsyncEndPoint;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.Connection;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Timeout;

/* renamed from: org.eclipse.jetty.io.nio.SslConnection */
/* loaded from: classes4.dex */
public class SslConnection extends AbstractConnection implements AsyncConnection {
    public static final NIOBuffer __ZERO_BUFFER = new IndirectNIOBuffer(0);
    public static final ThreadLocal<SslBuffers> __buffers = new ThreadLocal<>();
    public AsyncEndPoint _aEndp;
    public int _allocations;
    public boolean _allowRenegotiate;
    public SslBuffers _buffers;
    public AsyncConnection _connection;
    public final SSLEngine _engine;
    public boolean _handshook;
    public NIOBuffer _inbound;
    public boolean _ishut;
    public final Logger _logger;
    public boolean _oshut;
    public NIOBuffer _outbound;
    public final AtomicBoolean _progressed;
    public final SSLSession _session;
    public final SslEndPoint _sslEndPoint;
    public NIOBuffer _unwrapBuf;

    /* renamed from: org.eclipse.jetty.io.nio.SslConnection$1 */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C29631 {
        public static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;
        public static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$Status;

        static {
            int[] iArr = new int[SSLEngineResult.Status.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$Status = iArr;
            try {
                iArr[SSLEngineResult.Status.BUFFER_UNDERFLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.OK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[SSLEngineResult.HandshakeStatus.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = iArr2;
            try {
                iArr2[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* renamed from: org.eclipse.jetty.io.nio.SslConnection$SslBuffers */
    /* loaded from: classes4.dex */
    public static class SslBuffers {
        public final NIOBuffer _in;
        public final NIOBuffer _out;
        public final NIOBuffer _unwrap;

        public SslBuffers(int i, int i2) {
            this._in = new IndirectNIOBuffer(i);
            this._out = new IndirectNIOBuffer(i);
            this._unwrap = new IndirectNIOBuffer(i2);
        }
    }

    /* renamed from: org.eclipse.jetty.io.nio.SslConnection$SslEndPoint */
    /* loaded from: classes4.dex */
    public class SslEndPoint implements AsyncEndPoint {
        public SslEndPoint() {
        }

        @Override // org.eclipse.jetty.p059io.AsyncEndPoint
        public void asyncDispatch() {
            SslConnection.this._aEndp.asyncDispatch();
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public boolean blockReadable(long j) throws IOException {
            int i;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = j > 0 ? j + currentTimeMillis : Long.MAX_VALUE;
            while (true) {
                i = (currentTimeMillis > j2 ? 1 : (currentTimeMillis == j2 ? 0 : -1));
                if (i >= 0 || SslConnection.this.process(null, null)) {
                    break;
                }
                SslConnection.this._endp.blockReadable(j2 - currentTimeMillis);
                currentTimeMillis = System.currentTimeMillis();
            }
            return i < 0;
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public boolean blockWritable(long j) throws IOException {
            return SslConnection.this._endp.blockWritable(j);
        }

        @Override // org.eclipse.jetty.p059io.AsyncEndPoint
        public void cancelTimeout(Timeout.Task task) {
            SslConnection.this._aEndp.cancelTimeout(task);
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public void close() throws IOException {
            SslConnection.this._logger.debug("{} ssl endp.close", SslConnection.this._session);
            SslConnection.this._endp.close();
        }

        @Override // org.eclipse.jetty.p059io.AsyncEndPoint
        public void dispatch() {
            SslConnection.this._aEndp.dispatch();
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public int fill(Buffer buffer) throws IOException {
            int length = buffer.length();
            SslConnection.this.process(buffer, null);
            int length2 = buffer.length() - length;
            if (length2 != 0 || !isInputShutdown()) {
                return length2;
            }
            return -1;
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public int flush(Buffer buffer) throws IOException {
            int length = buffer.length();
            SslConnection.this.process(null, buffer);
            return length - buffer.length();
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public int flush(Buffer buffer, Buffer buffer2, Buffer buffer3) throws IOException {
            if (buffer == null || !buffer.hasContent()) {
                if (buffer2 != null && buffer2.hasContent()) {
                    return flush(buffer2);
                }
                if (buffer3 != null && buffer3.hasContent()) {
                    return flush(buffer3);
                }
                return 0;
            }
            return flush(buffer);
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public void flush() throws IOException {
            SslConnection.this.process(null, null);
        }

        @Override // org.eclipse.jetty.p059io.ConnectedEndPoint
        public Connection getConnection() {
            return SslConnection.this._connection;
        }

        public AsyncEndPoint getEndpoint() {
            return SslConnection.this._aEndp;
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public String getLocalAddr() {
            return SslConnection.this._aEndp.getLocalAddr();
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public String getLocalHost() {
            return SslConnection.this._aEndp.getLocalHost();
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public int getLocalPort() {
            return SslConnection.this._aEndp.getLocalPort();
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public int getMaxIdleTime() {
            return SslConnection.this._aEndp.getMaxIdleTime();
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public String getRemoteAddr() {
            return SslConnection.this._aEndp.getRemoteAddr();
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public String getRemoteHost() {
            return SslConnection.this._aEndp.getRemoteHost();
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public int getRemotePort() {
            return SslConnection.this._aEndp.getRemotePort();
        }

        public SSLEngine getSslEngine() {
            return SslConnection.this._engine;
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public Object getTransport() {
            return SslConnection.this._endp;
        }

        @Override // org.eclipse.jetty.p059io.AsyncEndPoint
        public boolean hasProgressed() {
            return SslConnection.this._progressed.getAndSet(false);
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public boolean isBlocking() {
            return false;
        }

        @Override // org.eclipse.jetty.p059io.AsyncEndPoint
        public boolean isCheckForIdle() {
            return SslConnection.this._aEndp.isCheckForIdle();
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public boolean isInputShutdown() {
            boolean z;
            synchronized (SslConnection.this) {
                z = SslConnection.this._endp.isInputShutdown() && (SslConnection.this._unwrapBuf == null || !SslConnection.this._unwrapBuf.hasContent()) && (SslConnection.this._inbound == null || !SslConnection.this._inbound.hasContent());
            }
            return z;
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public boolean isOpen() {
            return SslConnection.this._endp.isOpen();
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public boolean isOutputShutdown() {
            boolean z;
            synchronized (SslConnection.this) {
                if (!SslConnection.this._oshut && isOpen() && !SslConnection.this._engine.isOutboundDone()) {
                    z = false;
                }
                z = true;
            }
            return z;
        }

        @Override // org.eclipse.jetty.p059io.AsyncEndPoint
        public boolean isWritable() {
            return SslConnection.this._aEndp.isWritable();
        }

        @Override // org.eclipse.jetty.p059io.AsyncEndPoint
        public void onIdleExpired(long j) {
            SslConnection.this._aEndp.onIdleExpired(j);
        }

        @Override // org.eclipse.jetty.p059io.AsyncEndPoint
        public void scheduleTimeout(Timeout.Task task, long j) {
            SslConnection.this._aEndp.scheduleTimeout(task, j);
        }

        @Override // org.eclipse.jetty.p059io.AsyncEndPoint
        public void scheduleWrite() {
            SslConnection.this._aEndp.scheduleWrite();
        }

        @Override // org.eclipse.jetty.p059io.AsyncEndPoint
        public void setCheckForIdle(boolean z) {
            SslConnection.this._aEndp.setCheckForIdle(z);
        }

        @Override // org.eclipse.jetty.p059io.ConnectedEndPoint
        public void setConnection(Connection connection) {
            SslConnection.this._connection = (AsyncConnection) connection;
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public void setMaxIdleTime(int i) throws IOException {
            SslConnection.this._aEndp.setMaxIdleTime(i);
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public void shutdownInput() throws IOException {
            SslConnection.this._logger.debug("{} ssl endp.ishut!", SslConnection.this._session);
        }

        @Override // org.eclipse.jetty.p059io.EndPoint
        public void shutdownOutput() throws IOException {
            synchronized (SslConnection.this) {
                try {
                    SslConnection.this._logger.debug("{} ssl endp.oshut {}", SslConnection.this._session, this);
                    SslConnection.this._oshut = true;
                    SslConnection.this._engine.closeOutbound();
                } catch (Exception e) {
                    throw new IOException(e);
                }
            }
            flush();
        }

        public String toString() {
            NIOBuffer nIOBuffer = SslConnection.this._inbound;
            NIOBuffer nIOBuffer2 = SslConnection.this._outbound;
            NIOBuffer nIOBuffer3 = SslConnection.this._unwrapBuf;
            int i = -1;
            int length = nIOBuffer == null ? -1 : nIOBuffer.length();
            int length2 = nIOBuffer2 == null ? -1 : nIOBuffer2.length();
            if (nIOBuffer3 != null) {
                i = nIOBuffer3.length();
            }
            return String.format("SSL %s i/o/u=%d/%d/%d ishut=%b oshut=%b {%s}", SslConnection.this._engine.getHandshakeStatus(), Integer.valueOf(length), Integer.valueOf(length2), Integer.valueOf(i), Boolean.valueOf(SslConnection.this._ishut), Boolean.valueOf(SslConnection.this._oshut), SslConnection.this._connection);
        }
    }

    public SslConnection(SSLEngine sSLEngine, EndPoint endPoint) {
        this(sSLEngine, endPoint, System.currentTimeMillis());
    }

    public SslConnection(SSLEngine sSLEngine, EndPoint endPoint, long j) {
        super(endPoint, j);
        this._logger = Log.getLogger("org.eclipse.jetty.io.nio.ssl");
        this._allowRenegotiate = true;
        this._progressed = new AtomicBoolean();
        this._engine = sSLEngine;
        this._session = sSLEngine.getSession();
        this._aEndp = (AsyncEndPoint) endPoint;
        this._sslEndPoint = newSslEndPoint();
    }

    private void allocateBuffers() {
        synchronized (this) {
            int i = this._allocations;
            this._allocations = i + 1;
            if (i == 0 && this._buffers == null) {
                SslBuffers sslBuffers = __buffers.get();
                this._buffers = sslBuffers;
                if (sslBuffers == null) {
                    this._buffers = new SslBuffers(this._session.getPacketBufferSize() * 2, this._session.getApplicationBufferSize() * 2);
                }
                this._inbound = this._buffers._in;
                this._outbound = this._buffers._out;
                this._unwrapBuf = this._buffers._unwrap;
                __buffers.set(null);
            }
        }
    }

    private void closeInbound() {
        try {
            this._engine.closeInbound();
        } catch (SSLException e) {
            this._logger.debug(e);
        }
    }

    private ByteBuffer extractByteBuffer(Buffer buffer) {
        return buffer.buffer() instanceof NIOBuffer ? ((NIOBuffer) buffer.buffer()).getByteBuffer() : ByteBuffer.wrap(buffer.array());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0127, code lost:
        if (wrap(r2) != false) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008e A[Catch: IOException -> 0x01a5, all -> 0x01b2, TRY_LEAVE, TryCatch #1 {all -> 0x01b2, blocks: (B:20:0x0086, B:22:0x008e, B:110:0x01ac, B:111:0x01b1), top: B:19:0x0086 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x019f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean process(Buffer buffer, Buffer buffer2) throws IOException {
        int i;
        boolean z;
        int i2;
        int i3;
        EndPoint endPoint;
        Buffer buffer3 = buffer;
        Buffer buffer4 = buffer2;
        synchronized (this) {
            boolean z2 = false;
            try {
                allocateBuffers();
                if (buffer3 == null) {
                    this._unwrapBuf.compact();
                    buffer3 = this._unwrapBuf;
                } else if (buffer.capacity() < this._session.getApplicationBufferSize()) {
                    boolean process = process(null, buffer4);
                    if (this._unwrapBuf == null || !this._unwrapBuf.hasContent()) {
                        releaseBuffers();
                        return process;
                    }
                    this._unwrapBuf.skip(buffer3.put(this._unwrapBuf));
                    releaseBuffers();
                    return true;
                } else if (this._unwrapBuf != null && this._unwrapBuf.hasContent()) {
                    this._unwrapBuf.skip(buffer3.put(this._unwrapBuf));
                    releaseBuffers();
                    return true;
                }
                if (buffer4 == null) {
                    buffer4 = __ZERO_BUFFER;
                }
                boolean z3 = true;
                boolean z4 = false;
                while (z3) {
                    try {
                        try {
                            try {
                                try {
                                    if (this._inbound.space() > 0) {
                                        i = this._endp.fill(this._inbound);
                                        if (i > 0) {
                                            z = true;
                                            if (!this._outbound.hasContent()) {
                                                i2 = this._endp.flush(this._outbound);
                                                if (i2 > 0) {
                                                    z = true;
                                                }
                                            } else {
                                                i2 = 0;
                                            }
                                            this._logger.debug("{} {} {} filled={}/{} flushed={}/{}", this._session, this, this._engine.getHandshakeStatus(), Integer.valueOf(i), Integer.valueOf(this._inbound.length()), Integer.valueOf(i2), Integer.valueOf(this._outbound.length()));
                                            i3 = C29631.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[this._engine.getHandshakeStatus().ordinal()];
                                            if (i3 != 1) {
                                                throw new IllegalStateException();
                                            }
                                            if (i3 != 2) {
                                                if (i3 == 3) {
                                                    while (true) {
                                                        Runnable delegatedTask = this._engine.getDelegatedTask();
                                                        if (delegatedTask == null) {
                                                            break;
                                                        }
                                                        delegatedTask.run();
                                                        z = true;
                                                    }
                                                } else if (i3 != 4) {
                                                    if (i3 == 5) {
                                                        if (this._handshook && !this._allowRenegotiate) {
                                                            endPoint = this._endp;
                                                            endPoint.close();
                                                        } else if (!this._inbound.hasContent() && i == -1) {
                                                            this._endp.shutdownInput();
                                                        } else if (unwrap(buffer3)) {
                                                            z3 = true;
                                                        }
                                                    }
                                                } else if (this._handshook && !this._allowRenegotiate) {
                                                    endPoint = this._endp;
                                                    endPoint.close();
                                                }
                                                z3 = z;
                                            } else {
                                                if (buffer3.space() > 0 && this._inbound.hasContent() && unwrap(buffer3)) {
                                                    z = true;
                                                }
                                                if (buffer4.hasContent() && this._outbound.space() > 0 && wrap(buffer4)) {
                                                    z3 = true;
                                                }
                                                z3 = z;
                                            }
                                            if (this._endp.isOpen() && this._endp.isInputShutdown() && !this._inbound.hasContent()) {
                                                closeInbound();
                                            }
                                            if (this._endp.isOpen() && this._engine.isOutboundDone() && !this._outbound.hasContent()) {
                                                this._endp.shutdownOutput();
                                            }
                                            z4 |= z3;
                                        }
                                    } else {
                                        i = 0;
                                    }
                                    this._logger.debug("{} {} {} filled={}/{} flushed={}/{}", this._session, this, this._engine.getHandshakeStatus(), Integer.valueOf(i), Integer.valueOf(this._inbound.length()), Integer.valueOf(i2), Integer.valueOf(this._outbound.length()));
                                    i3 = C29631.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[this._engine.getHandshakeStatus().ordinal()];
                                    if (i3 != 1) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    z2 = z4;
                                    releaseBuffers();
                                    if (z2) {
                                        this._progressed.set(true);
                                    }
                                    throw th;
                                }
                                if (!this._outbound.hasContent()) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                this._logger.debug("{} {} {} filled={}/{} flushed={}/{}", this._session, this, this._engine.getHandshakeStatus(), Integer.valueOf(i), Integer.valueOf(this._inbound.length()), 0, Integer.valueOf(this._outbound.length()));
                                throw th;
                            }
                        } catch (IOException e) {
                            e = e;
                            this._endp.close();
                            throw e;
                        }
                        z = false;
                    } catch (IOException e2) {
                        e = e2;
                        i = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        i = 0;
                        this._logger.debug("{} {} {} filled={}/{} flushed={}/{}", this._session, this, this._engine.getHandshakeStatus(), Integer.valueOf(i), Integer.valueOf(this._inbound.length()), 0, Integer.valueOf(this._outbound.length()));
                        throw th;
                    }
                }
                if (buffer3 == this._unwrapBuf && this._unwrapBuf.hasContent() && !this._connection.isSuspended()) {
                    this._aEndp.dispatch();
                }
                releaseBuffers();
                if (z4) {
                    this._progressed.set(true);
                }
                return z4;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    private void releaseBuffers() {
        synchronized (this) {
            int i = this._allocations - 1;
            this._allocations = i;
            if (i == 0 && this._buffers != null && this._inbound.length() == 0 && this._outbound.length() == 0 && this._unwrapBuf.length() == 0) {
                this._inbound = null;
                this._outbound = null;
                this._unwrapBuf = null;
                __buffers.set(this._buffers);
                this._buffers = null;
            }
        }
    }

    private synchronized boolean unwrap(Buffer buffer) throws IOException {
        SSLEngineResult unwrap;
        int position;
        int position2;
        boolean z = false;
        if (!this._inbound.hasContent()) {
            return false;
        }
        ByteBuffer extractByteBuffer = extractByteBuffer(buffer);
        synchronized (extractByteBuffer) {
            ByteBuffer byteBuffer = this._inbound.getByteBuffer();
            synchronized (byteBuffer) {
                try {
                    try {
                        try {
                            extractByteBuffer.position(buffer.putIndex());
                            extractByteBuffer.limit(buffer.capacity());
                            int position3 = extractByteBuffer.position();
                            byteBuffer.position(this._inbound.getIndex());
                            byteBuffer.limit(this._inbound.putIndex());
                            int position4 = byteBuffer.position();
                            unwrap = this._engine.unwrap(byteBuffer, extractByteBuffer);
                            if (this._logger.isDebugEnabled()) {
                                this._logger.debug("{} unwrap {} {} consumed={} produced={}", this._session, unwrap.getStatus(), unwrap.getHandshakeStatus(), Integer.valueOf(unwrap.bytesConsumed()), Integer.valueOf(unwrap.bytesProduced()));
                            }
                            position = byteBuffer.position() - position4;
                            this._inbound.skip(position);
                            this._inbound.compact();
                            position2 = extractByteBuffer.position() - position3;
                            buffer.setPutIndex(buffer.putIndex() + position2);
                            byteBuffer.position(0);
                            byteBuffer.limit(byteBuffer.capacity());
                            extractByteBuffer.position(0);
                            extractByteBuffer.limit(extractByteBuffer.capacity());
                        } catch (Exception e) {
                            throw new IOException(e);
                        }
                    } catch (SSLException e2) {
                        this._logger.debug(String.valueOf(this._endp), e2);
                        this._endp.close();
                        throw e2;
                    }
                } catch (IOException e3) {
                    throw e3;
                }
            }
        }
        int i = C29631.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[unwrap.getStatus().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        this._logger.debug("{} wrap default {}", this._session, unwrap);
                        throw new IOException(unwrap.toString());
                    }
                    this._logger.debug("unwrap CLOSE {} {}", this, unwrap);
                    if (unwrap.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                        this._endp.close();
                    }
                } else if (unwrap.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                    this._handshook = true;
                }
            } else if (this._logger.isDebugEnabled()) {
                this._logger.debug("{} unwrap {} {}->{}", this._session, unwrap.getStatus(), this._inbound.toDetailString(), buffer.toDetailString());
            }
        } else if (this._endp.isInputShutdown()) {
            this._inbound.clear();
        }
        if (position > 0 || position2 > 0) {
            z = true;
        }
        return z;
    }

    private synchronized boolean wrap(Buffer buffer) throws IOException {
        boolean z;
        SSLEngineResult wrap;
        int position;
        int position2;
        ByteBuffer extractByteBuffer = extractByteBuffer(buffer);
        synchronized (extractByteBuffer) {
            this._outbound.compact();
            ByteBuffer byteBuffer = this._outbound.getByteBuffer();
            synchronized (byteBuffer) {
                z = false;
                try {
                    try {
                        extractByteBuffer.position(buffer.getIndex());
                        extractByteBuffer.limit(buffer.putIndex());
                        int position3 = extractByteBuffer.position();
                        byteBuffer.position(this._outbound.putIndex());
                        byteBuffer.limit(byteBuffer.capacity());
                        int position4 = byteBuffer.position();
                        wrap = this._engine.wrap(extractByteBuffer, byteBuffer);
                        if (this._logger.isDebugEnabled()) {
                            this._logger.debug("{} wrap {} {} consumed={} produced={}", this._session, wrap.getStatus(), wrap.getHandshakeStatus(), Integer.valueOf(wrap.bytesConsumed()), Integer.valueOf(wrap.bytesProduced()));
                        }
                        position = extractByteBuffer.position() - position3;
                        buffer.skip(position);
                        position2 = byteBuffer.position() - position4;
                        this._outbound.setPutIndex(this._outbound.putIndex() + position2);
                        byteBuffer.position(0);
                        byteBuffer.limit(byteBuffer.capacity());
                        extractByteBuffer.position(0);
                        extractByteBuffer.limit(extractByteBuffer.capacity());
                    } catch (IOException e) {
                        throw e;
                    }
                } catch (SSLException e2) {
                    this._logger.debug(String.valueOf(this._endp), e2);
                    this._endp.close();
                    throw e2;
                } catch (Exception e3) {
                    throw new IOException(e3);
                }
            }
        }
        int i = C29631.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[wrap.getStatus().ordinal()];
        if (i == 1) {
            throw new IllegalStateException();
        }
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    this._logger.debug("{} wrap default {}", this._session, wrap);
                    throw new IOException(wrap.toString());
                }
                this._logger.debug("wrap CLOSE {} {}", this, wrap);
                if (wrap.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                    this._endp.close();
                }
            } else if (wrap.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                this._handshook = true;
            }
        }
        if (position > 0 || position2 > 0) {
            z = true;
        }
        return z;
    }

    public AsyncEndPoint getSslEndPoint() {
        return this._sslEndPoint;
    }

    @Override // org.eclipse.jetty.p059io.Connection
    public Connection handle() throws IOException {
        try {
            allocateBuffers();
            boolean z = true;
            while (z) {
                z = this._engine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING ? process(null, null) : false;
                AsyncConnection asyncConnection = (AsyncConnection) this._connection.handle();
                if (asyncConnection != this._connection && asyncConnection != null) {
                    this._connection = asyncConnection;
                    z = true;
                }
                this._logger.debug("{} handle {} progress={}", this._session, this, Boolean.valueOf(z));
            }
            return this;
        } finally {
            releaseBuffers();
            if (!this._ishut && this._sslEndPoint.isInputShutdown() && this._sslEndPoint.isOpen()) {
                this._ishut = true;
                try {
                    this._connection.onInputShutdown();
                } catch (Throwable th) {
                    this._logger.warn("onInputShutdown failed", th);
                    try {
                        this._sslEndPoint.close();
                    } catch (IOException e) {
                        this._logger.ignore(e);
                    }
                }
            }
        }
    }

    public boolean isAllowRenegotiate() {
        return this._allowRenegotiate;
    }

    @Override // org.eclipse.jetty.p059io.Connection
    public boolean isIdle() {
        return false;
    }

    @Override // org.eclipse.jetty.p059io.Connection
    public boolean isSuspended() {
        return false;
    }

    public SslEndPoint newSslEndPoint() {
        return new SslEndPoint();
    }

    @Override // org.eclipse.jetty.p059io.Connection
    public void onClose() {
        Connection connection = this._sslEndPoint.getConnection();
        if (connection == null || connection == this) {
            return;
        }
        connection.onClose();
    }

    @Override // org.eclipse.jetty.p059io.AbstractConnection, org.eclipse.jetty.p059io.Connection
    public void onIdleExpired(long j) {
        try {
            this._logger.debug("onIdleExpired {}ms on {}", Long.valueOf(j), this);
            if (this._endp.isOutputShutdown()) {
                this._sslEndPoint.close();
            } else {
                this._sslEndPoint.shutdownOutput();
            }
        } catch (IOException e) {
            this._logger.warn(e);
            super.onIdleExpired(j);
        }
    }

    @Override // org.eclipse.jetty.p059io.nio.AsyncConnection
    public void onInputShutdown() throws IOException {
    }

    public void setAllowRenegotiate(boolean z) {
        this._allowRenegotiate = z;
    }

    @Override // org.eclipse.jetty.p059io.AbstractConnection
    public String toString() {
        return String.format("%s %s", super.toString(), this._sslEndPoint);
    }
}
