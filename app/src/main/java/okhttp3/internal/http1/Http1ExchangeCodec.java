package okhttp3.internal.http1;

import com.arialyy.aria.core.inf.IOptionConstant;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.kx0;
import me.tvspark.mx0;
import me.tvspark.nk0;
import me.tvspark.nx0;
import me.tvspark.outline;
import me.tvspark.uw0;
import me.tvspark.vw0;
import me.tvspark.ww0;
import me.tvspark.zw0;
import okhttp3.Address;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;

@ef0
/* loaded from: classes4.dex */
public final class Http1ExchangeCodec implements ExchangeCodec {
    public static final Companion Companion = new Companion(null);
    public static final int HEADER_LIMIT = 262144;
    public static final long NO_CHUNK_YET = -1;
    public static final int STATE_CLOSED = 6;
    public static final int STATE_IDLE = 0;
    public static final int STATE_OPEN_REQUEST_BODY = 1;
    public static final int STATE_OPEN_RESPONSE_BODY = 4;
    public static final int STATE_READING_RESPONSE_BODY = 5;
    public static final int STATE_READ_RESPONSE_HEADERS = 3;
    public static final int STATE_WRITING_REQUEST_BODY = 2;
    public final OkHttpClient client;
    public long headerLimit = 262144;
    public final RealConnection realConnection;
    public final vw0 sink;
    public final ww0 source;
    public int state;
    public Headers trailers;

    @ef0
    /* loaded from: classes4.dex */
    public abstract class AbstractSource implements mx0 {
        public boolean closed;
        public final zw0 timeout;

        public AbstractSource() {
            this.timeout = new zw0(Http1ExchangeCodec.this.source.timeout());
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final zw0 getTimeout() {
            return this.timeout;
        }

        @Override // me.tvspark.mx0
        public long read(uw0 uw0Var, long j) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
            try {
                return Http1ExchangeCodec.this.source.read(uw0Var, j);
            } catch (IOException e) {
                RealConnection realConnection = Http1ExchangeCodec.this.realConnection;
                if (realConnection == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                realConnection.noNewExchanges();
                responseBodyComplete$okhttp();
                throw e;
            }
        }

        public final void responseBodyComplete$okhttp() {
            if (Http1ExchangeCodec.this.state == 6) {
                return;
            }
            if (Http1ExchangeCodec.this.state == 5) {
                Http1ExchangeCodec.this.detachTimeout(this.timeout);
                Http1ExchangeCodec.this.state = 6;
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("state: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Http1ExchangeCodec.this.state);
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        @Override // me.tvspark.mx0
        public nx0 timeout() {
            return this.timeout;
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public final class ChunkedSink implements kx0 {
        public boolean closed;
        public final zw0 timeout;

        public ChunkedSink() {
            this.timeout = new zw0(Http1ExchangeCodec.this.sink.timeout());
        }

        @Override // me.tvspark.kx0, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.sink.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("0\r\n\r\n");
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }

        @Override // me.tvspark.kx0, java.io.Flushable
        public synchronized void flush() {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.sink.flush();
        }

        @Override // me.tvspark.kx0
        public nx0 timeout() {
            return this.timeout;
        }

        @Override // me.tvspark.kx0
        public void write(uw0 uw0Var, long j) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "source");
            if (!this.closed) {
                if (j == 0) {
                    return;
                }
                Http1ExchangeCodec.this.sink.mo4957Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                Http1ExchangeCodec.this.sink.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\r\n");
                Http1ExchangeCodec.this.sink.write(uw0Var, j);
                Http1ExchangeCodec.this.sink.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\r\n");
                return;
            }
            throw new IllegalStateException("closed".toString());
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public final class ChunkedSource extends AbstractSource {
        public long bytesRemainingInChunk = -1;
        public boolean hasMoreChunks = true;
        public final /* synthetic */ Http1ExchangeCodec this$0;
        public final HttpUrl url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChunkedSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl httpUrl) {
            super();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "url");
            this.this$0 = http1ExchangeCodec;
            this.url = httpUrl;
        }

        private final void readChunkSize() {
            if (this.bytesRemainingInChunk != -1) {
                this.this$0.source.Wwwwwwwwwwwwwwwwwwwwwwwww();
            }
            try {
                this.bytesRemainingInChunk = this.this$0.source.Wwwwwwwwwwwwwwwwwwwww();
                String Wwwwwwwwwwwwwwwwwwwwwwwww = this.this$0.source.Wwwwwwwwwwwwwwwwwwwwwwwww();
                if (Wwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String obj = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwww).toString();
                if (this.bytesRemainingInChunk >= 0) {
                    if (!(obj.length() > 0) || nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, ";", false, 2)) {
                        if (this.bytesRemainingInChunk != 0) {
                            return;
                        }
                        this.hasMoreChunks = false;
                        Http1ExchangeCodec http1ExchangeCodec = this.this$0;
                        http1ExchangeCodec.trailers = http1ExchangeCodec.readHeaders();
                        OkHttpClient okHttpClient = this.this$0.client;
                        if (okHttpClient == null) {
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            throw null;
                        }
                        CookieJar cookieJar = okHttpClient.cookieJar();
                        HttpUrl httpUrl = this.url;
                        Headers headers = this.this$0.trailers;
                        if (headers == null) {
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            throw null;
                        }
                        HttpHeaders.receiveHeaders(cookieJar, httpUrl, headers);
                        responseBodyComplete$okhttp();
                        return;
                    }
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + obj + '\"');
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                RealConnection realConnection = this.this$0.realConnection;
                if (realConnection == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else {
                    realConnection.noNewExchanges();
                    responseBodyComplete$okhttp();
                }
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, me.tvspark.mx0
        public long read(uw0 uw0Var, long j) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
            if (j >= 0) {
                if (!(!getClosed())) {
                    throw new IllegalStateException("closed".toString());
                }
                if (!this.hasMoreChunks) {
                    return -1L;
                }
                long j2 = this.bytesRemainingInChunk;
                if (j2 == 0 || j2 == -1) {
                    readChunkSize();
                    if (!this.hasMoreChunks) {
                        return -1L;
                    }
                }
                long read = super.read(uw0Var, Math.min(j, this.bytesRemainingInChunk));
                if (read != -1) {
                    this.bytesRemainingInChunk -= read;
                    return read;
                }
                RealConnection realConnection = this.this$0.realConnection;
                if (realConnection == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                realConnection.noNewExchanges();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                responseBodyComplete$okhttp();
                throw protocolException;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("byteCount < 0: ", j).toString());
        }
    }

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
    public final class FixedLengthSource extends AbstractSource {
        public long bytesRemaining;

        public FixedLengthSource(long j) {
            super();
            this.bytesRemaining = j;
            if (j == 0) {
                responseBodyComplete$okhttp();
            }
        }

        @Override // me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                RealConnection realConnection = Http1ExchangeCodec.this.realConnection;
                if (realConnection == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else {
                    realConnection.noNewExchanges();
                    responseBodyComplete$okhttp();
                }
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, me.tvspark.mx0
        public long read(uw0 uw0Var, long j) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
            if (j >= 0) {
                if (!(!getClosed())) {
                    throw new IllegalStateException("closed".toString());
                }
                long j2 = this.bytesRemaining;
                if (j2 == 0) {
                    return -1L;
                }
                long read = super.read(uw0Var, Math.min(j2, j));
                if (read != -1) {
                    long j3 = this.bytesRemaining - read;
                    this.bytesRemaining = j3;
                    if (j3 == 0) {
                        responseBodyComplete$okhttp();
                    }
                    return read;
                }
                RealConnection realConnection = Http1ExchangeCodec.this.realConnection;
                if (realConnection == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                realConnection.noNewExchanges();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                responseBodyComplete$okhttp();
                throw protocolException;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("byteCount < 0: ", j).toString());
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public final class KnownLengthSink implements kx0 {
        public boolean closed;
        public final zw0 timeout;

        public KnownLengthSink() {
            this.timeout = new zw0(Http1ExchangeCodec.this.sink.timeout());
        }

        @Override // me.tvspark.kx0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }

        @Override // me.tvspark.kx0, java.io.Flushable
        public void flush() {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.sink.flush();
        }

        @Override // me.tvspark.kx0
        public nx0 timeout() {
            return this.timeout;
        }

        @Override // me.tvspark.kx0
        public void write(uw0 uw0Var, long j) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "source");
            if (!this.closed) {
                Util.checkOffsetAndCount(uw0Var.Wwwwwwwwwwwwwwwwwwwwwww, 0L, j);
                Http1ExchangeCodec.this.sink.write(uw0Var, j);
                return;
            }
            throw new IllegalStateException("closed".toString());
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public final class UnknownLengthSource extends AbstractSource {
        public boolean inputExhausted;

        public UnknownLengthSource() {
            super();
        }

        @Override // me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (!this.inputExhausted) {
                responseBodyComplete$okhttp();
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, me.tvspark.mx0
        public long read(uw0 uw0Var, long j) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
            if (j >= 0) {
                if (!(!getClosed())) {
                    throw new IllegalStateException("closed".toString());
                }
                if (this.inputExhausted) {
                    return -1L;
                }
                long read = super.read(uw0Var, j);
                if (read != -1) {
                    return read;
                }
                this.inputExhausted = true;
                responseBodyComplete$okhttp();
                return -1L;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("byteCount < 0: ", j).toString());
        }
    }

    public Http1ExchangeCodec(OkHttpClient okHttpClient, RealConnection realConnection, ww0 ww0Var, vw0 vw0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "source");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vw0Var, "sink");
        this.client = okHttpClient;
        this.realConnection = realConnection;
        this.source = ww0Var;
        this.sink = vw0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void detachTimeout(zw0 zw0Var) {
        nx0 nx0Var = zw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        nx0 nx0Var2 = nx0.NONE;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nx0Var2, "delegate");
        zw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nx0Var2;
        nx0Var.clearDeadline();
        nx0Var.clearTimeout();
    }

    private final boolean isChunked(Request request) {
        return nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("chunked", request.header("Transfer-Encoding"), true);
    }

    private final boolean isChunked(Response response) {
        return nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("chunked", Response.header$default(response, "Transfer-Encoding", null, 2, null), true);
    }

    private final kx0 newChunkedSink() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        if (z) {
            this.state = 2;
            return new ChunkedSink();
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("state: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.state);
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
    }

    private final mx0 newChunkedSource(HttpUrl httpUrl) {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(this, httpUrl);
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("state: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.state);
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
    }

    private final mx0 newFixedLengthSource(long j) {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(j);
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("state: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.state);
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
    }

    private final kx0 newKnownLengthSink() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        if (z) {
            this.state = 2;
            return new KnownLengthSink();
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("state: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.state);
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
    }

    private final mx0 newUnknownLengthSource() {
        if (!(this.state == 4)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("state: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.state);
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
        }
        this.state = 5;
        RealConnection realConnection = this.realConnection;
        if (realConnection != null) {
            realConnection.noNewExchanges();
            return new UnknownLengthSource();
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    private final String readHeaderLine() {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.source.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.headerLimit);
        this.headerLimit -= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length();
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Headers readHeaders() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readHeaderLine = readHeaderLine();
            if (readHeaderLine.length() > 0) {
                builder.addLenient$okhttp(readHeaderLine);
            } else {
                return builder.build();
            }
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        RealConnection realConnection = this.realConnection;
        if (realConnection != null) {
            realConnection.cancel();
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection connection() {
        return this.realConnection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public kx0 createRequestBody(Request request, long j) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        if (request.body() == null || !request.body().isDuplex()) {
            if (isChunked(request)) {
                return newChunkedSink();
            }
            if (j == -1) {
                throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
            }
            return newKnownLengthSink();
        }
        throw new ProtocolException("Duplex connections are not supported for HTTP/1");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.sink.flush();
    }

    public final boolean isClosed() {
        return this.state == 6;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public mx0 openResponseBodySource(Response response) {
        long headersContentLength;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            headersContentLength = 0;
        } else if (isChunked(response)) {
            return newChunkedSource(response.request().url());
        } else {
            headersContentLength = Util.headersContentLength(response);
            if (headersContentLength == -1) {
                return newUnknownLengthSource();
            }
        }
        return newFixedLengthSource(headersContentLength);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Response.Builder readResponseHeaders(boolean z) {
        String str;
        Route route;
        Address address;
        HttpUrl url;
        int i = this.state;
        boolean z2 = true;
        if (i != 1 && i != 3) {
            z2 = false;
        }
        if (!z2) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("state: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.state);
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
        }
        try {
            StatusLine parse = StatusLine.Companion.parse(readHeaderLine());
            Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
            if (z && parse.code == 100) {
                return null;
            }
            if (parse.code == 100) {
                this.state = 3;
                return headers;
            }
            this.state = 4;
            return headers;
        } catch (EOFException e) {
            RealConnection realConnection = this.realConnection;
            if (realConnection == null || (route = realConnection.route()) == null || (address = route.address()) == null || (url = address.url()) == null || (str = url.redact()) == null) {
                str = "unknown";
            }
            throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unexpected end of stream on ", str), e);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(Response response) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return 0L;
        }
        if (!isChunked(response)) {
            return Util.headersContentLength(response);
        }
        return -1L;
    }

    public final void skipConnectBody(Response response) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
        long headersContentLength = Util.headersContentLength(response);
        if (headersContentLength == -1) {
            return;
        }
        mx0 newFixedLengthSource = newFixedLengthSource(headersContentLength);
        Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        newFixedLengthSource.close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Headers trailers() {
        if (this.state == 6) {
            Headers headers = this.trailers;
            return headers != null ? headers : Util.EMPTY_HEADERS;
        }
        throw new IllegalStateException("too early; can't read the trailers yet".toString());
    }

    public final void writeRequest(Headers headers, String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers, IOptionConstant.headers);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "requestLine");
        if (!(this.state == 0)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("state: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.state);
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
        }
        this.sink.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str).mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.sink.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers.name(i)).mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(": ").mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers.value(i)).mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\r\n");
        }
        this.sink.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\r\n");
        this.state = 1;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(Request request) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        RequestLine requestLine = RequestLine.INSTANCE;
        RealConnection realConnection = this.realConnection;
        if (realConnection == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        Proxy.Type type = realConnection.route().proxy().type();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) type, "realConnection!!.route().proxy.type()");
        writeRequest(request.headers(), requestLine.get(request, type));
    }
}
