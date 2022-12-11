package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.hx0;
import me.tvspark.ii0;
import me.tvspark.kx0;
import me.tvspark.mx0;
import me.tvspark.outline;
import me.tvspark.uw0;
import me.tvspark.xw0;
import me.tvspark.yw0;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.p054ws.RealWebSocket;

@ef0
/* loaded from: classes4.dex */
public final class Exchange {
    public static final Companion Companion = new Companion(null);
    public final Call call;
    public final ExchangeCodec codec;
    public final EventListener eventListener;
    public final ExchangeFinder finder;
    public boolean isDuplex;
    public final Transmitter transmitter;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final Exchange get(Response response) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
            return response.exchange();
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public final class RequestBodySink extends xw0 {
        public long bytesReceived;
        public boolean closed;
        public boolean completed;
        public final long contentLength;
        public final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestBodySink(Exchange exchange, kx0 kx0Var, long j) {
            super(kx0Var);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kx0Var, "delegate");
            this.this$0 = exchange;
            this.contentLength = j;
        }

        private final <E extends IOException> E complete(E e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            return (E) this.this$0.bodyComplete(this.bytesReceived, false, true, e);
        }

        @Override // me.tvspark.xw0, me.tvspark.kx0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j = this.contentLength;
            if (j != -1 && this.bytesReceived != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                throw complete(e);
            }
        }

        @Override // me.tvspark.xw0, me.tvspark.kx0, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw complete(e);
            }
        }

        @Override // me.tvspark.xw0, me.tvspark.kx0
        public void write(uw0 uw0Var, long j) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "source");
            if (!this.closed) {
                long j2 = this.contentLength;
                if (j2 == -1 || this.bytesReceived + j <= j2) {
                    try {
                        super.write(uw0Var, j);
                        this.bytesReceived += j;
                        return;
                    } catch (IOException e) {
                        throw complete(e);
                    }
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("expected ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.contentLength);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" bytes but received ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.bytesReceived + j);
                throw new ProtocolException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            throw new IllegalStateException("closed".toString());
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public final class ResponseBodySource extends yw0 {
        public long bytesReceived;
        public boolean closed;
        public boolean completed;
        public final long contentLength;
        public final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(Exchange exchange, mx0 mx0Var, long j) {
            super(mx0Var);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var, "delegate");
            this.this$0 = exchange;
            this.contentLength = j;
            if (j == 0) {
                complete(null);
            }
        }

        @Override // me.tvspark.yw0, me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                throw complete(e);
            }
        }

        public final <E extends IOException> E complete(E e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            return (E) this.this$0.bodyComplete(this.bytesReceived, true, false, e);
        }

        @Override // me.tvspark.yw0, me.tvspark.mx0
        public long read(uw0 uw0Var, long j) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
            if (!this.closed) {
                try {
                    long read = delegate().read(uw0Var, j);
                    if (read == -1) {
                        complete(null);
                        return -1L;
                    }
                    long j2 = this.bytesReceived + read;
                    if (this.contentLength != -1 && j2 > this.contentLength) {
                        throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j2);
                    }
                    this.bytesReceived = j2;
                    if (j2 == this.contentLength) {
                        complete(null);
                    }
                    return read;
                } catch (IOException e) {
                    throw complete(e);
                }
            }
            throw new IllegalStateException("closed".toString());
        }
    }

    public Exchange(Transmitter transmitter, Call call, EventListener eventListener, ExchangeFinder exchangeFinder, ExchangeCodec exchangeCodec) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(transmitter, "transmitter");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(eventListener, "eventListener");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exchangeFinder, "finder");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exchangeCodec, "codec");
        this.transmitter = transmitter;
        this.call = call;
        this.eventListener = eventListener;
        this.finder = exchangeFinder;
        this.codec = exchangeCodec;
    }

    private final void trackFailure(IOException iOException) {
        this.finder.trackFailure();
        RealConnection connection = this.codec.connection();
        if (connection != null) {
            connection.trackFailure$okhttp(iOException);
        } else {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
    }

    public final <E extends IOException> E bodyComplete(long j, boolean z, boolean z2, E e) {
        if (e != null) {
            trackFailure(e);
        }
        if (z2) {
            EventListener eventListener = this.eventListener;
            Call call = this.call;
            if (e != null) {
                eventListener.requestFailed(call, e);
            } else {
                eventListener.requestBodyEnd(call, j);
            }
        }
        if (z) {
            if (e != null) {
                this.eventListener.responseFailed(this.call, e);
            } else {
                this.eventListener.responseBodyEnd(this.call, j);
            }
        }
        return (E) this.transmitter.exchangeMessageDone$okhttp(this, z2, z, e);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final RealConnection connection() {
        return this.codec.connection();
    }

    public final kx0 createRequestBody(Request request, boolean z) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        this.isDuplex = z;
        RequestBody body = request.body();
        if (body == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        long contentLength = body.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this, this.codec.createRequestBody(request, contentLength), contentLength);
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.transmitter.exchangeMessageDone$okhttp(this, true, true, null);
    }

    public final void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final Call getCall$okhttp() {
        return this.call;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final Transmitter getTransmitter$okhttp() {
        return this.transmitter;
    }

    public final boolean isDuplex() {
        return this.isDuplex;
    }

    public final RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.transmitter.timeoutEarlyExit();
        RealConnection connection = this.codec.connection();
        if (connection != null) {
            return connection.newWebSocketStreams$okhttp(this);
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    public final void noNewExchangesOnConnection() {
        RealConnection connection = this.codec.connection();
        if (connection != null) {
            connection.noNewExchanges();
        } else {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
    }

    public final void noRequestBody() {
        this.transmitter.exchangeMessageDone$okhttp(this, true, false, null);
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
        try {
            this.eventListener.responseBodyStart(this.call);
            String header$default = Response.header$default(response, "Content-Type", null, 2, null);
            long reportedContentLength = this.codec.reportedContentLength(response);
            ResponseBodySource responseBodySource = new ResponseBodySource(this, this.codec.openResponseBodySource(response), reportedContentLength);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(responseBodySource, "$receiver");
            return new RealResponseBody(header$default, reportedContentLength, new hx0(responseBodySource));
        } catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final Response.Builder readResponseHeaders(boolean z) throws IOException {
        try {
            Response.Builder readResponseHeaders = this.codec.readResponseHeaders(z);
            if (readResponseHeaders != null) {
                readResponseHeaders.initExchange$okhttp(this);
            }
            return readResponseHeaders;
        } catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final void responseHeadersEnd(Response response) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    public final void timeoutEarlyExit() {
        this.transmitter.timeoutEarlyExit();
    }

    public final Headers trailers() throws IOException {
        return this.codec.trailers();
    }

    public final void webSocketUpgradeFailed() {
        bodyComplete(-1L, true, true, null);
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd(this.call, request);
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }
}
