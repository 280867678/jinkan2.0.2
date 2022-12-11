package okhttp3.internal.http;

import java.net.Proxy;
import me.tvspark.ef0;
import me.tvspark.ii0;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.apache.http.message.TokenParser;

@ef0
/* loaded from: classes4.dex */
public final class RequestLine {
    public static final RequestLine INSTANCE = new RequestLine();

    private final boolean includeAuthorityInRequestLine(Request request, Proxy.Type type) {
        return !request.isHttps() && type == Proxy.Type.HTTP;
    }

    public final String get(Request request, Proxy.Type type) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.method());
        sb.append(TokenParser.f4579SP);
        if (INSTANCE.includeAuthorityInRequestLine(request, type)) {
            sb.append(request.url());
        } else {
            sb.append(INSTANCE.requestPath(request.url()));
        }
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String requestPath(HttpUrl httpUrl) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "url");
        String encodedPath = httpUrl.encodedPath();
        String encodedQuery = httpUrl.encodedQuery();
        if (encodedQuery != null) {
            return encodedPath + '?' + encodedQuery;
        }
        return encodedPath;
    }
}
