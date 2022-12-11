package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import me.tvspark.ax0;
import me.tvspark.ef0;
import me.tvspark.hx0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.r40;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import org.eclipse.jetty.util.B64Code;

@ef0
/* loaded from: classes4.dex */
public final class BridgeInterceptor implements Interceptor {
    public final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cookieJar, "cookieJar");
        this.cookieJar = cookieJar;
    }

    private final String cookieHeader(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            Cookie cookie = (Cookie) obj;
            if (i > 0) {
                sb.append("; ");
            }
            sb.append(cookie.name());
            sb.append(B64Code.__pad);
            sb.append(cookie.value());
            i = i2;
        }
        String sb2 = sb.toString();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        ResponseBody body;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chain, "chain");
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body2 = request.body();
        if (body2 != null) {
            MediaType contentType = body2.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                newBuilder.header("Content-Length", String.valueOf(contentLength));
                newBuilder.removeHeader("Transfer-Encoding");
            } else {
                newBuilder.header("Transfer-Encoding", "chunked");
                newBuilder.removeHeader("Content-Length");
            }
        }
        boolean z = false;
        if (request.header("Host") == null) {
            newBuilder.header("Host", Util.toHostHeader$default(request.url(), false, 1, null));
        }
        if (request.header("Connection") == null) {
            newBuilder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null && request.header("Range") == null) {
            newBuilder.header("Accept-Encoding", "gzip");
            z = true;
        }
        List<Cookie> loadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header(org.eclipse.jetty.http.HttpHeaders.COOKIE, cookieHeader(loadForRequest));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", Version.userAgent);
        }
        Response proceed = chain.proceed(newBuilder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(request);
        if (z && nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("gzip", Response.header$default(proceed, "Content-Encoding", null, 2, null), true) && HttpHeaders.promisesBody(proceed) && (body = proceed.body()) != null) {
            ax0 ax0Var = new ax0(body.source());
            request2.headers(proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
            String header$default = Response.header$default(proceed, "Content-Type", null, 2, null);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ax0Var, "$receiver");
            request2.body(new RealResponseBody(header$default, -1L, new hx0(ax0Var)));
        }
        return request2.build();
    }
}
