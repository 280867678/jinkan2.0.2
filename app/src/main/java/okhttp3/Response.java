package okhttp3;

import com.arialyy.aria.core.inf.IOptionConstant;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import kotlin.collections.EmptyList;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.outline;
import me.tvspark.uw0;
import me.tvspark.ww0;
import okhttp3.Headers;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;

@ef0
/* loaded from: classes4.dex */
public final class Response implements Closeable {
    public final ResponseBody body;
    public final Response cacheResponse;
    public final int code;
    public final Exchange exchange;
    public final Handshake handshake;
    public final Headers headers;
    public CacheControl lazyCacheControl;
    public final String message;
    public final Response networkResponse;
    public final Response priorResponse;
    public final Protocol protocol;
    public final long receivedResponseAtMillis;
    public final Request request;
    public final long sentRequestAtMillis;

    @ef0
    /* loaded from: classes4.dex */
    public static class Builder {
        public ResponseBody body;
        public Response cacheResponse;
        public int code;
        public Exchange exchange;
        public Handshake handshake;
        public Headers.Builder headers;
        public String message;
        public Response networkResponse;
        public Response priorResponse;
        public Protocol protocol;
        public long receivedResponseAtMillis;
        public Request request;
        public long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        public Builder(Response response) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
            this.code = -1;
            this.request = response.request();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.handshake = response.handshake();
            this.headers = response.headers().newBuilder();
            this.body = response.body();
            this.networkResponse = response.networkResponse();
            this.cacheResponse = response.cacheResponse();
            this.priorResponse = response.priorResponse();
            this.sentRequestAtMillis = response.sentRequestAtMillis();
            this.receivedResponseAtMillis = response.receivedResponseAtMillis();
            this.exchange = response.exchange();
        }

        private final void checkPriorResponse(Response response) {
            if (response != null) {
                if (!(response.body() == null)) {
                    throw new IllegalArgumentException("priorResponse.body != null".toString());
                }
            }
        }

        private final void checkSupportResponse(String str, Response response) {
            if (response != null) {
                boolean z = true;
                if (!(response.body() == null)) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ".body != null").toString());
                }
                if (!(response.networkResponse() == null)) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ".networkResponse != null").toString());
                }
                if (!(response.cacheResponse() == null)) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ".cacheResponse != null").toString());
                }
                if (response.priorResponse() != null) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ".priorResponse != null").toString());
                }
            }
        }

        public Builder addHeader(String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "value");
            this.headers.add(str, str2);
            return this;
        }

        public Builder body(ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Response build() {
            if (!(this.code >= 0)) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("code < 0: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.code);
                throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
            }
            Request request = this.request;
            if (request == null) {
                throw new IllegalStateException("request == null".toString());
            }
            Protocol protocol = this.protocol;
            if (protocol == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.message;
            if (str == null) {
                throw new IllegalStateException("message == null".toString());
            }
            return new Response(request, protocol, str, this.code, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
        }

        public Builder cacheResponse(Response response) {
            checkSupportResponse("cacheResponse", response);
            this.cacheResponse = response;
            return this;
        }

        public Builder code(int i) {
            this.code = i;
            return this;
        }

        public final ResponseBody getBody$okhttp() {
            return this.body;
        }

        public final Response getCacheResponse$okhttp() {
            return this.cacheResponse;
        }

        public final int getCode$okhttp() {
            return this.code;
        }

        public final Exchange getExchange$okhttp() {
            return this.exchange;
        }

        public final Handshake getHandshake$okhttp() {
            return this.handshake;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMessage$okhttp() {
            return this.message;
        }

        public final Response getNetworkResponse$okhttp() {
            return this.networkResponse;
        }

        public final Response getPriorResponse$okhttp() {
            return this.priorResponse;
        }

        public final Protocol getProtocol$okhttp() {
            return this.protocol;
        }

        public final long getReceivedResponseAtMillis$okhttp() {
            return this.receivedResponseAtMillis;
        }

        public final Request getRequest$okhttp() {
            return this.request;
        }

        public final long getSentRequestAtMillis$okhttp() {
            return this.sentRequestAtMillis;
        }

        public Builder handshake(Handshake handshake) {
            this.handshake = handshake;
            return this;
        }

        public Builder header(String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "value");
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers, IOptionConstant.headers);
            this.headers = headers.newBuilder();
            return this;
        }

        public final void initExchange$okhttp(Exchange exchange) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exchange, "deferredTrailers");
            this.exchange = exchange;
        }

        public Builder message(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "message");
            this.message = str;
            return this;
        }

        public Builder networkResponse(Response response) {
            checkSupportResponse("networkResponse", response);
            this.networkResponse = response;
            return this;
        }

        public Builder priorResponse(Response response) {
            checkPriorResponse(response);
            this.priorResponse = response;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(protocol, "protocol");
            this.protocol = protocol;
            return this;
        }

        public Builder receivedResponseAtMillis(long j) {
            this.receivedResponseAtMillis = j;
            return this;
        }

        public Builder removeHeader(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            this.headers.removeAll(str);
            return this;
        }

        public Builder request(Request request) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
            this.request = request;
            return this;
        }

        public Builder sentRequestAtMillis(long j) {
            this.sentRequestAtMillis = j;
            return this;
        }

        public final void setBody$okhttp(ResponseBody responseBody) {
            this.body = responseBody;
        }

        public final void setCacheResponse$okhttp(Response response) {
            this.cacheResponse = response;
        }

        public final void setCode$okhttp(int i) {
            this.code = i;
        }

        public final void setExchange$okhttp(Exchange exchange) {
            this.exchange = exchange;
        }

        public final void setHandshake$okhttp(Handshake handshake) {
            this.handshake = handshake;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMessage$okhttp(String str) {
            this.message = str;
        }

        public final void setNetworkResponse$okhttp(Response response) {
            this.networkResponse = response;
        }

        public final void setPriorResponse$okhttp(Response response) {
            this.priorResponse = response;
        }

        public final void setProtocol$okhttp(Protocol protocol) {
            this.protocol = protocol;
        }

        public final void setReceivedResponseAtMillis$okhttp(long j) {
            this.receivedResponseAtMillis = j;
        }

        public final void setRequest$okhttp(Request request) {
            this.request = request;
        }

        public final void setSentRequestAtMillis$okhttp(long j) {
            this.sentRequestAtMillis = j;
        }
    }

    public Response(Request request, Protocol protocol, String str, int i, Handshake handshake, Headers headers, ResponseBody responseBody, Response response, Response response2, Response response3, long j, long j2, Exchange exchange) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(protocol, "protocol");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "message");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers, IOptionConstant.headers);
        this.request = request;
        this.protocol = protocol;
        this.message = str;
        this.code = i;
        this.handshake = handshake;
        this.headers = headers;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j2;
        this.exchange = exchange;
    }

    public static /* synthetic */ String header$default(Response response, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return response.header(str, str2);
    }

    /* renamed from: -deprecated_body  reason: not valid java name */
    public final ResponseBody m5094deprecated_body() {
        return this.body;
    }

    /* renamed from: -deprecated_cacheControl  reason: not valid java name */
    public final CacheControl m5095deprecated_cacheControl() {
        return cacheControl();
    }

    /* renamed from: -deprecated_cacheResponse  reason: not valid java name */
    public final Response m5096deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    /* renamed from: -deprecated_code  reason: not valid java name */
    public final int m5097deprecated_code() {
        return this.code;
    }

    /* renamed from: -deprecated_handshake  reason: not valid java name */
    public final Handshake m5098deprecated_handshake() {
        return this.handshake;
    }

    /* renamed from: -deprecated_headers  reason: not valid java name */
    public final Headers m5099deprecated_headers() {
        return this.headers;
    }

    /* renamed from: -deprecated_message  reason: not valid java name */
    public final String m5100deprecated_message() {
        return this.message;
    }

    /* renamed from: -deprecated_networkResponse  reason: not valid java name */
    public final Response m5101deprecated_networkResponse() {
        return this.networkResponse;
    }

    /* renamed from: -deprecated_priorResponse  reason: not valid java name */
    public final Response m5102deprecated_priorResponse() {
        return this.priorResponse;
    }

    /* renamed from: -deprecated_protocol  reason: not valid java name */
    public final Protocol m5103deprecated_protocol() {
        return this.protocol;
    }

    /* renamed from: -deprecated_receivedResponseAtMillis  reason: not valid java name */
    public final long m5104deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    /* renamed from: -deprecated_request  reason: not valid java name */
    public final Request m5105deprecated_request() {
        return this.request;
    }

    /* renamed from: -deprecated_sentRequestAtMillis  reason: not valid java name */
    public final long m5106deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public final ResponseBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl == null) {
            CacheControl parse = CacheControl.Companion.parse(this.headers);
            this.lazyCacheControl = parse;
            return parse;
        }
        return cacheControl;
    }

    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    public final List<Challenge> challenges() {
        String str;
        Headers headers = this.headers;
        int i = this.code;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else if (i != 407) {
            return EmptyList.INSTANCE;
        } else {
            str = "Proxy-Authenticate";
        }
        return HttpHeaders.parseChallenges(headers, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody != null) {
            responseBody.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
    }

    public final int code() {
        return this.code;
    }

    public final Exchange exchange() {
        return this.exchange;
    }

    public final Handshake handshake() {
        return this.handshake;
    }

    public final String header(String str) {
        return header$default(this, str, null, 2, null);
    }

    public final String header(String str, String str2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        String str3 = this.headers.get(str);
        return str3 != null ? str3 : str2;
    }

    public final List<String> headers(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        return this.headers.values(str);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isRedirect() {
        int i = this.code;
        if (i != 307 && i != 308) {
            switch (i) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public final boolean isSuccessful() {
        int i = this.code;
        return 200 <= i && 299 >= i;
    }

    public final String message() {
        return this.message;
    }

    public final Response networkResponse() {
        return this.networkResponse;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final ResponseBody peekBody(long j) throws IOException {
        ResponseBody responseBody = this.body;
        if (responseBody == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        ww0 peek = responseBody.source().peek();
        uw0 uw0Var = new uw0();
        peek.request(j);
        long min = Math.min(j, peek.getBuffer().Wwwwwwwwwwwwwwwwwwwwwww);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(peek, "source");
        while (min > 0) {
            long read = peek.read(uw0Var, min);
            if (read == -1) {
                throw new EOFException();
            }
            min -= read;
        }
        return ResponseBody.Companion.create(uw0Var, this.body.contentType(), uw0Var.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    public final Response priorResponse() {
        return this.priorResponse;
    }

    public final Protocol protocol() {
        return this.protocol;
    }

    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public final Request request() {
        return this.request;
    }

    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Response{protocol=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.protocol);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", code=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.code);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", message=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.message);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", url=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.request.url());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public final Headers trailers() throws IOException {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange.trailers();
        }
        throw new IllegalStateException("trailers not available".toString());
    }
}
