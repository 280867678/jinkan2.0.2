package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.vw0;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnection;
import org.eclipse.jetty.http.HttpHeaderValues;

@ef0
/* loaded from: classes4.dex */
public final class CallServerInterceptor implements Interceptor {
    public final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        Response.Builder builder;
        Response.Builder newBuilder;
        ResponseBody openResponseBody;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange = realInterceptorChain.exchange();
        Request request = realInterceptorChain.request();
        RequestBody body = request.body();
        long currentTimeMillis = System.currentTimeMillis();
        exchange.writeRequestHeaders(request);
        Long l = null;
        if (!HttpMethod.permitsRequestBody(request.method()) || body == null) {
            exchange.noRequestBody();
            z = false;
            builder = null;
        } else {
            if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("100-continue", request.header("Expect"), true)) {
                exchange.flushRequest();
                exchange.responseHeadersStart();
                builder = exchange.readResponseHeaders(true);
                z = true;
            } else {
                z = false;
                builder = null;
            }
            if (builder != null) {
                exchange.noRequestBody();
                RealConnection connection = exchange.connection();
                if (connection == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else if (!connection.isMultiplexed()) {
                    exchange.noNewExchangesOnConnection();
                }
            } else if (body.isDuplex()) {
                exchange.flushRequest();
                body.writeTo(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exchange.createRequestBody(request, true)));
            } else {
                vw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exchange.createRequestBody(request, false));
                body.writeTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.close();
            }
        }
        if (body == null || !body.isDuplex()) {
            exchange.finishRequest();
        }
        if (!z) {
            exchange.responseHeadersStart();
        }
        if (builder == null && (builder = exchange.readResponseHeaders(false)) == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        Response.Builder request2 = builder.request(request);
        RealConnection connection2 = exchange.connection();
        if (connection2 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        Response build = request2.handshake(connection2.handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int code = build.code();
        if (code == 100) {
            Response.Builder readResponseHeaders = exchange.readResponseHeaders(false);
            if (readResponseHeaders == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            Response.Builder request3 = readResponseHeaders.request(request);
            RealConnection connection3 = exchange.connection();
            if (connection3 == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            build = request3.handshake(connection3.handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            code = build.code();
        }
        exchange.responseHeadersEnd(build);
        if (!this.forWebSocket || code != 101) {
            newBuilder = build.newBuilder();
            openResponseBody = exchange.openResponseBody(build);
        } else {
            newBuilder = build.newBuilder();
            openResponseBody = Util.EMPTY_RESPONSE;
        }
        Response build2 = newBuilder.body(openResponseBody).build();
        if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HttpHeaderValues.CLOSE, build2.request().header("Connection"), true) || nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HttpHeaderValues.CLOSE, Response.header$default(build2, "Connection", null, 2, null), true)) {
            exchange.noNewExchangesOnConnection();
        }
        if (code == 204 || code == 205) {
            ResponseBody body2 = build2.body();
            if ((body2 != null ? body2.contentLength() : -1L) > 0) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("HTTP ", code, " had non-zero Content-Length: ");
                ResponseBody body3 = build2.body();
                if (body3 != null) {
                    l = Long.valueOf(body3.contentLength());
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(l);
                throw new ProtocolException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }
        return build2;
    }
}
