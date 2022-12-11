package okhttp3.internal;

import javax.net.ssl.SSLSocket;
import me.tvspark.ef0;
import me.tvspark.ii0;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

@ef0
/* loaded from: classes4.dex */
public final class Internal {
    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(builder, "builder");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "line");
        return builder.addLenient$okhttp(str);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str, String str2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(builder, "builder");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "value");
        return builder.addLenient$okhttp(str, str2);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(connectionSpec, "connectionSpec");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocket, "sslSocket");
        connectionSpec.apply$okhttp(sSLSocket, z);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cache, "cache");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        return cache.get$okhttp(request);
    }

    public static final String cookieToString(Cookie cookie, boolean z) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cookie, "cookie");
        return cookie.toString$okhttp(z);
    }

    public static final Cookie parseCookie(long j, HttpUrl httpUrl, String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "url");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "setCookie");
        return Cookie.Companion.parse$okhttp(j, httpUrl, str);
    }
}
