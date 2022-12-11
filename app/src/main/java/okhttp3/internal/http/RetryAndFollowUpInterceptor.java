package okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.text.Regex;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.outline;
import okhttp3.Authenticator;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.http2.ConnectionShutdownException;

@ef0
/* loaded from: classes4.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_FOLLOW_UPS = 20;
    public final OkHttpClient client;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }
    }

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(okHttpClient, "client");
        this.client = okHttpClient;
    }

    private final Request buildRedirectRequest(Response response, String str) {
        String header$default;
        HttpUrl resolve;
        RequestBody requestBody = null;
        if (!this.client.followRedirects() || (header$default = Response.header$default(response, "Location", null, 2, null)) == null || (resolve = response.request().url().resolve(header$default)) == null) {
            return null;
        }
        if (!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) resolve.scheme(), (Object) response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder newBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(str)) {
            boolean redirectsWithBody = HttpMethod.INSTANCE.redirectsWithBody(str);
            if (HttpMethod.INSTANCE.redirectsToGet(str)) {
                str = "GET";
            } else if (redirectsWithBody) {
                requestBody = response.request().body();
            }
            newBuilder.method(str, requestBody);
            if (!redirectsWithBody) {
                newBuilder.removeHeader("Transfer-Encoding");
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
        }
        if (!Util.canReuseConnectionFor(response.request().url(), resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        return newBuilder.url(resolve).build();
    }

    private final Request followUpRequest(Response response, Route route) throws IOException {
        Authenticator authenticator;
        int code = response.code();
        String method = response.request().method();
        if (code == 307 || code == 308) {
            if ((!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) method, (Object) "GET")) && (!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) method, (Object) "HEAD"))) {
                return null;
            }
            return buildRedirectRequest(response, method);
        }
        if (code == 401) {
            authenticator = this.client.authenticator();
        } else if (code == 503) {
            Response priorResponse = response.priorResponse();
            if ((priorResponse != null && priorResponse.code() == 503) || retryAfter(response, Integer.MAX_VALUE) != 0) {
                return null;
            }
            return response.request();
        } else if (code != 407) {
            if (code != 408) {
                switch (code) {
                    case 300:
                    case 301:
                    case 302:
                    case 303:
                        return buildRedirectRequest(response, method);
                    default:
                        return null;
                }
            } else if (!this.client.retryOnConnectionFailure()) {
                return null;
            } else {
                RequestBody body = response.request().body();
                if (body != null && body.isOneShot()) {
                    return null;
                }
                Response priorResponse2 = response.priorResponse();
                if ((priorResponse2 != null && priorResponse2.code() == 408) || retryAfter(response, 0) > 0) {
                    return null;
                }
                return response.request();
            }
        } else if (route == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        } else if (route.proxy().type() != Proxy.Type.HTTP) {
            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
        } else {
            authenticator = this.client.proxyAuthenticator();
        }
        return authenticator.authenticate(route, response);
    }

    private final boolean isRecoverable(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException);
    }

    private final boolean recover(IOException iOException, Transmitter transmitter, boolean z, Request request) {
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        return (!z || !requestIsOneShot(iOException, request)) && isRecoverable(iOException, z) && transmitter.canRetry();
    }

    private final boolean requestIsOneShot(IOException iOException, Request request) {
        RequestBody body = request.body();
        return (body != null && body.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private final int retryAfter(Response response, int i) {
        String header$default = Response.header$default(response, "Retry-After", null, 2, null);
        if (header$default != null) {
            if (!new Regex("\\d+").matches(header$default)) {
                return Integer.MAX_VALUE;
            }
            Integer valueOf = Integer.valueOf(header$default);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) valueOf, "Integer.valueOf(header)");
            return valueOf.intValue();
        }
        return i;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Exchange exchange;
        Request followUpRequest;
        RealConnection connection;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chain, "chain");
        Request request = chain.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Transmitter transmitter = realInterceptorChain.transmitter();
        int i = 0;
        Response response = null;
        while (true) {
            transmitter.prepareToConnect(request);
            if (!transmitter.isCanceled()) {
                try {
                    try {
                        try {
                            Response proceed = realInterceptorChain.proceed(request, transmitter, null);
                            if (response != null) {
                                proceed = proceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                            }
                            response = proceed;
                            exchange = response.exchange();
                            followUpRequest = followUpRequest(response, (exchange == null || (connection = exchange.connection()) == null) ? null : connection.route());
                        } catch (IOException e) {
                            if (!recover(e, transmitter, !(e instanceof ConnectionShutdownException), request)) {
                                throw e;
                            }
                        }
                    } catch (RouteException e2) {
                        if (!recover(e2.getLastConnectException(), transmitter, false, request)) {
                            throw e2.getFirstConnectException();
                        }
                    }
                    if (followUpRequest == null) {
                        if (exchange != null && exchange.isDuplex()) {
                            transmitter.timeoutEarlyExit();
                        }
                        return response;
                    }
                    RequestBody body = followUpRequest.body();
                    if (body != null && body.isOneShot()) {
                        return response;
                    }
                    ResponseBody body2 = response.body();
                    if (body2 != null) {
                        Util.closeQuietly(body2);
                    }
                    if (transmitter.hasExchange() && exchange != null) {
                        exchange.detachWithViolence();
                    }
                    i++;
                    if (i > 20) {
                        throw new ProtocolException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Too many follow-up requests: ", i));
                    }
                    request = followUpRequest;
                } finally {
                    transmitter.exchangeDoneDueToException();
                }
            } else {
                throw new IOException("Canceled");
            }
        }
    }
}
