package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.kx0;
import me.tvspark.mx0;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;

@ef0
/* loaded from: classes4.dex */
public final class Http2ExchangeCodec implements ExchangeCodec {
    public static final String CONNECTION = "connection";
    public static final String KEEP_ALIVE = "keep-alive";
    public static final String UPGRADE = "upgrade";
    public volatile boolean canceled;
    public final Interceptor.Chain chain;
    public final Http2Connection connection;
    public final Protocol protocol;
    public final RealConnection realConnection;
    public volatile Http2Stream stream;
    public static final Companion Companion = new Companion(null);
    public static final String HOST = "host";
    public static final String PROXY_CONNECTION = "proxy-connection";

    /* renamed from: TE */
    public static final String f4540TE = "te";
    public static final String TRANSFER_ENCODING = "transfer-encoding";
    public static final String ENCODING = "encoding";
    public static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableListOf("connection", HOST, "keep-alive", PROXY_CONNECTION, f4540TE, TRANSFER_ENCODING, ENCODING, "upgrade", Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8);
    public static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableListOf("connection", HOST, "keep-alive", PROXY_CONNECTION, f4540TE, TRANSFER_ENCODING, ENCODING, "upgrade");

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final List<Header> http2HeadersList(Request request) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
            Headers headers = request.headers();
            ArrayList arrayList = new ArrayList(headers.size() + 4);
            arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
            arrayList.add(new Header(Header.TARGET_PATH, RequestLine.INSTANCE.requestPath(request.url())));
            String header = request.header("Host");
            if (header != null) {
                arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
            }
            arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                Locale locale = Locale.US;
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) locale, "Locale.US");
                if (name == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = name.toLowerCase(locale);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!Http2ExchangeCodec.HTTP_2_SKIPPED_REQUEST_HEADERS.contains(lowerCase) || (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) lowerCase, (Object) Http2ExchangeCodec.f4540TE) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) headers.value(i), (Object) "trailers"))) {
                    arrayList.add(new Header(lowerCase, headers.value(i)));
                }
            }
            return arrayList;
        }

        public final Response.Builder readHttp2HeadersList(Headers headers, Protocol protocol) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers, "headerBlock");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(protocol, "protocol");
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            StatusLine statusLine = null;
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                String value = headers.value(i);
                if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) name, (Object) Header.RESPONSE_STATUS_UTF8)) {
                    StatusLine.Companion companion = StatusLine.Companion;
                    statusLine = companion.parse("HTTP/1.1 " + value);
                } else if (!Http2ExchangeCodec.HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(name)) {
                    builder.addLenient$okhttp(name, value);
                }
            }
            if (statusLine != null) {
                return new Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
    }

    public Http2ExchangeCodec(OkHttpClient okHttpClient, RealConnection realConnection, Interceptor.Chain chain, Http2Connection http2Connection) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(okHttpClient, "client");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(realConnection, "realConnection");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chain, "chain");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(http2Connection, "connection");
        this.realConnection = realConnection;
        this.chain = chain;
        this.connection = http2Connection;
        this.protocol = okHttpClient.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE) ? Protocol.H2_PRIOR_KNOWLEDGE : Protocol.HTTP_2;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        this.canceled = true;
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection connection() {
        return this.realConnection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public kx0 createRequestBody(Request request, long j) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            return http2Stream.getSink();
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.getSink().close();
        } else {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.connection.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public mx0 openResponseBodySource(Response response) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            return http2Stream.getSource$okhttp();
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Response.Builder readResponseHeaders(boolean z) {
        Http2Stream http2Stream = this.stream;
        if (http2Stream == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        Response.Builder readHttp2HeadersList = Companion.readHttp2HeadersList(http2Stream.takeHeaders(), this.protocol);
        if (z && readHttp2HeadersList.getCode$okhttp() == 100) {
            return null;
        }
        return readHttp2HeadersList;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(Response response) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
        return Util.headersContentLength(response);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Headers trailers() {
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            return http2Stream.trailers();
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(Request request) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        if (this.stream != null) {
            return;
        }
        this.stream = this.connection.newStream(Companion.http2HeadersList(request), request.body() != null);
        if (this.canceled) {
            Http2Stream http2Stream = this.stream;
            if (http2Stream == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            } else {
                http2Stream.closeLater(ErrorCode.CANCEL);
                throw new IOException("Canceled");
            }
        }
        Http2Stream http2Stream2 = this.stream;
        if (http2Stream2 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        http2Stream2.readTimeout().timeout(this.chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        Http2Stream http2Stream3 = this.stream;
        if (http2Stream3 != null) {
            http2Stream3.writeTimeout().timeout(this.chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        } else {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
    }
}
