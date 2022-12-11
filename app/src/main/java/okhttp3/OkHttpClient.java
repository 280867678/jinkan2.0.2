package okhttp3;

import com.umeng.analytics.pro.C1543ak;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.outline;
import me.tvspark.r40;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.WebSocket;
import okhttp3.internal.Util;
import okhttp3.internal.p054ws.RealWebSocket;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;

@ef0
/* loaded from: classes4.dex */
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    public final Authenticator authenticator;
    public final Cache cache;
    public final int callTimeoutMillis;
    public final CertificateChainCleaner certificateChainCleaner;
    public final CertificatePinner certificatePinner;
    public final int connectTimeoutMillis;
    public final ConnectionPool connectionPool;
    public final List<ConnectionSpec> connectionSpecs;
    public final CookieJar cookieJar;
    public final Dispatcher dispatcher;
    public final Dns dns;
    public final EventListener.Factory eventListenerFactory;
    public final boolean followRedirects;
    public final boolean followSslRedirects;
    public final HostnameVerifier hostnameVerifier;
    public final List<Interceptor> interceptors;
    public final List<Interceptor> networkInterceptors;
    public final int pingIntervalMillis;
    public final List<Protocol> protocols;
    public final Proxy proxy;
    public final Authenticator proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final int readTimeoutMillis;
    public final boolean retryOnConnectionFailure;
    public final SocketFactory socketFactory;
    public final SSLSocketFactory sslSocketFactoryOrNull;
    public final int writeTimeoutMillis;
    public final X509TrustManager x509TrustManager;
    public static final Companion Companion = new Companion(null);
    public static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableListOf(Protocol.HTTP_2, Protocol.HTTP_1_1);
    public static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = Util.immutableListOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    @ef0
    /* loaded from: classes4.dex */
    public static final class Builder {
        public Authenticator authenticator;
        public Cache cache;
        public int callTimeout;
        public CertificateChainCleaner certificateChainCleaner;
        public CertificatePinner certificatePinner;
        public int connectTimeout;
        public ConnectionPool connectionPool;
        public List<ConnectionSpec> connectionSpecs;
        public CookieJar cookieJar;
        public Dispatcher dispatcher;
        public Dns dns;
        public EventListener.Factory eventListenerFactory;
        public boolean followRedirects;
        public boolean followSslRedirects;
        public HostnameVerifier hostnameVerifier;
        public final List<Interceptor> interceptors;
        public final List<Interceptor> networkInterceptors;
        public int pingInterval;
        public List<? extends Protocol> protocols;
        public Proxy proxy;
        public Authenticator proxyAuthenticator;
        public ProxySelector proxySelector;
        public int readTimeout;
        public boolean retryOnConnectionFailure;
        public SocketFactory socketFactory;
        public SSLSocketFactory sslSocketFactoryOrNull;
        public int writeTimeout;
        public X509TrustManager x509TrustManagerOrNull;

        public Builder() {
            this.dispatcher = new Dispatcher();
            this.connectionPool = new ConnectionPool();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = Util.asFactory(EventListener.NONE);
            this.retryOnConnectionFailure = true;
            this.authenticator = Authenticator.NONE;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = Authenticator.NONE;
            SocketFactory socketFactory = SocketFactory.getDefault();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) socketFactory, "SocketFactory.getDefault()");
            this.socketFactory = socketFactory;
            this.connectionSpecs = OkHttpClient.Companion.getDEFAULT_CONNECTION_SPECS$okhttp();
            this.protocols = OkHttpClient.Companion.getDEFAULT_PROTOCOLS$okhttp();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(OkHttpClient okHttpClient) {
            this();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(okHttpClient, "okHttpClient");
            this.dispatcher = okHttpClient.dispatcher();
            this.connectionPool = okHttpClient.connectionPool();
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) this.interceptors, (Iterable) okHttpClient.interceptors());
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) this.networkInterceptors, (Iterable) okHttpClient.networkInterceptors());
            this.eventListenerFactory = okHttpClient.eventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure();
            this.authenticator = okHttpClient.authenticator();
            this.followRedirects = okHttpClient.followRedirects();
            this.followSslRedirects = okHttpClient.followSslRedirects();
            this.cookieJar = okHttpClient.cookieJar();
            this.cache = okHttpClient.cache();
            this.dns = okHttpClient.dns();
            this.proxy = okHttpClient.proxy();
            this.proxySelector = okHttpClient.proxySelector();
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator();
            this.socketFactory = okHttpClient.socketFactory();
            this.sslSocketFactoryOrNull = okHttpClient.sslSocketFactoryOrNull;
            this.x509TrustManagerOrNull = okHttpClient.x509TrustManager();
            this.connectionSpecs = okHttpClient.connectionSpecs();
            this.protocols = okHttpClient.protocols();
            this.hostnameVerifier = okHttpClient.hostnameVerifier();
            this.certificatePinner = okHttpClient.certificatePinner();
            this.certificateChainCleaner = okHttpClient.certificateChainCleaner();
            this.callTimeout = okHttpClient.callTimeoutMillis();
            this.connectTimeout = okHttpClient.connectTimeoutMillis();
            this.readTimeout = okHttpClient.readTimeoutMillis();
            this.writeTimeout = okHttpClient.writeTimeoutMillis();
            this.pingInterval = okHttpClient.pingIntervalMillis();
        }

        /* renamed from: -addInterceptor  reason: not valid java name */
        public final Builder m5086addInterceptor(final ih0<? super Interceptor.Chain, Response> ih0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ih0Var, "block");
            Interceptor.Companion companion = Interceptor.Companion;
            return addInterceptor(new Interceptor() { // from class: okhttp3.OkHttpClient$Builder$addInterceptor$$inlined$invoke$1
                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chain, "chain");
                    return (Response) ih0.this.mo4916invoke(chain);
                }
            });
        }

        /* renamed from: -addNetworkInterceptor  reason: not valid java name */
        public final Builder m5087addNetworkInterceptor(final ih0<? super Interceptor.Chain, Response> ih0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ih0Var, "block");
            Interceptor.Companion companion = Interceptor.Companion;
            return addNetworkInterceptor(new Interceptor() { // from class: okhttp3.OkHttpClient$Builder$addNetworkInterceptor$$inlined$invoke$1
                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chain, "chain");
                    return (Response) ih0.this.mo4916invoke(chain);
                }
            });
        }

        public final Builder addInterceptor(Interceptor interceptor) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(interceptor, "interceptor");
            this.interceptors.add(interceptor);
            return this;
        }

        public final Builder addNetworkInterceptor(Interceptor interceptor) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(interceptor, "interceptor");
            this.networkInterceptors.add(interceptor);
            return this;
        }

        public final Builder authenticator(Authenticator authenticator) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(authenticator, "authenticator");
            this.authenticator = authenticator;
            return this;
        }

        public final OkHttpClient build() {
            return new OkHttpClient(this);
        }

        public final Builder cache(Cache cache) {
            this.cache = cache;
            return this;
        }

        public final Builder callTimeout(long j, TimeUnit timeUnit) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit");
            this.callTimeout = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public final Builder callTimeout(Duration duration) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(duration, "duration");
            this.callTimeout = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder certificatePinner(CertificatePinner certificatePinner) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(certificatePinner, "certificatePinner");
            this.certificatePinner = certificatePinner;
            return this;
        }

        public final Builder connectTimeout(long j, TimeUnit timeUnit) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit");
            this.connectTimeout = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public final Builder connectTimeout(Duration duration) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(duration, "duration");
            this.connectTimeout = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder connectionPool(ConnectionPool connectionPool) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(connectionPool, "connectionPool");
            this.connectionPool = connectionPool;
            return this;
        }

        public final Builder connectionSpecs(List<ConnectionSpec> list) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "connectionSpecs");
            this.connectionSpecs = Util.toImmutableList(list);
            return this;
        }

        public final Builder cookieJar(CookieJar cookieJar) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cookieJar, "cookieJar");
            this.cookieJar = cookieJar;
            return this;
        }

        public final Builder dispatcher(Dispatcher dispatcher) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dispatcher, "dispatcher");
            this.dispatcher = dispatcher;
            return this;
        }

        public final Builder dns(Dns dns) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dns, "dns");
            this.dns = dns;
            return this;
        }

        public final Builder eventListener(EventListener eventListener) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(eventListener, "eventListener");
            this.eventListenerFactory = Util.asFactory(eventListener);
            return this;
        }

        public final Builder eventListenerFactory(EventListener.Factory factory) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(factory, "eventListenerFactory");
            this.eventListenerFactory = factory;
            return this;
        }

        public final Builder followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public final Builder followSslRedirects(boolean z) {
            this.followSslRedirects = z;
            return this;
        }

        public final Authenticator getAuthenticator$okhttp() {
            return this.authenticator;
        }

        public final Cache getCache$okhttp() {
            return this.cache;
        }

        public final int getCallTimeout$okhttp() {
            return this.callTimeout;
        }

        public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
            return this.certificateChainCleaner;
        }

        public final CertificatePinner getCertificatePinner$okhttp() {
            return this.certificatePinner;
        }

        public final int getConnectTimeout$okhttp() {
            return this.connectTimeout;
        }

        public final ConnectionPool getConnectionPool$okhttp() {
            return this.connectionPool;
        }

        public final List<ConnectionSpec> getConnectionSpecs$okhttp() {
            return this.connectionSpecs;
        }

        public final CookieJar getCookieJar$okhttp() {
            return this.cookieJar;
        }

        public final Dispatcher getDispatcher$okhttp() {
            return this.dispatcher;
        }

        public final Dns getDns$okhttp() {
            return this.dns;
        }

        public final EventListener.Factory getEventListenerFactory$okhttp() {
            return this.eventListenerFactory;
        }

        public final boolean getFollowRedirects$okhttp() {
            return this.followRedirects;
        }

        public final boolean getFollowSslRedirects$okhttp() {
            return this.followSslRedirects;
        }

        public final HostnameVerifier getHostnameVerifier$okhttp() {
            return this.hostnameVerifier;
        }

        public final List<Interceptor> getInterceptors$okhttp() {
            return this.interceptors;
        }

        public final List<Interceptor> getNetworkInterceptors$okhttp() {
            return this.networkInterceptors;
        }

        public final int getPingInterval$okhttp() {
            return this.pingInterval;
        }

        public final List<Protocol> getProtocols$okhttp() {
            return this.protocols;
        }

        public final Proxy getProxy$okhttp() {
            return this.proxy;
        }

        public final Authenticator getProxyAuthenticator$okhttp() {
            return this.proxyAuthenticator;
        }

        public final ProxySelector getProxySelector$okhttp() {
            return this.proxySelector;
        }

        public final int getReadTimeout$okhttp() {
            return this.readTimeout;
        }

        public final boolean getRetryOnConnectionFailure$okhttp() {
            return this.retryOnConnectionFailure;
        }

        public final SocketFactory getSocketFactory$okhttp() {
            return this.socketFactory;
        }

        public final SSLSocketFactory getSslSocketFactoryOrNull$okhttp() {
            return this.sslSocketFactoryOrNull;
        }

        public final int getWriteTimeout$okhttp() {
            return this.writeTimeout;
        }

        public final X509TrustManager getX509TrustManagerOrNull$okhttp() {
            return this.x509TrustManagerOrNull;
        }

        public final Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hostnameVerifier, "hostnameVerifier");
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public final List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public final List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public final Builder pingInterval(long j, TimeUnit timeUnit) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit");
            this.pingInterval = Util.checkDuration(C1543ak.f2983aT, j, timeUnit);
            return this;
        }

        public final Builder pingInterval(Duration duration) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(duration, "duration");
            this.pingInterval = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder protocols(List<? extends Protocol> list) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "protocols");
            List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) list);
            ArrayList arrayList = (ArrayList) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean z = false;
            if (!(arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) || arrayList.contains(Protocol.HTTP_1_1))) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).toString());
            }
            if (!arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) || arrayList.size() <= 1) {
                z = true;
            }
            if (!z) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).toString());
            } else if (!(!arrayList.contains(Protocol.HTTP_1_0))) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).toString());
            } else if (!(!arrayList.contains(null))) {
                throw new IllegalArgumentException("protocols must not contain null".toString());
            } else {
                arrayList.remove(Protocol.SPDY_3);
                List<? extends Protocol> unmodifiableList = Collections.unmodifiableList(list);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) unmodifiableList, "Collections.unmodifiableList(protocols)");
                this.protocols = unmodifiableList;
                return this;
            }
        }

        public final Builder proxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public final Builder proxyAuthenticator(Authenticator authenticator) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(authenticator, "proxyAuthenticator");
            this.proxyAuthenticator = authenticator;
            return this;
        }

        public final Builder proxySelector(ProxySelector proxySelector) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(proxySelector, "proxySelector");
            this.proxySelector = proxySelector;
            return this;
        }

        public final Builder readTimeout(long j, TimeUnit timeUnit) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit");
            this.readTimeout = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public final Builder readTimeout(Duration duration) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(duration, "duration");
            this.readTimeout = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder retryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public final void setAuthenticator$okhttp(Authenticator authenticator) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(authenticator, "<set-?>");
            this.authenticator = authenticator;
        }

        public final void setCache$okhttp(Cache cache) {
            this.cache = cache;
        }

        public final void setCallTimeout$okhttp(int i) {
            this.callTimeout = i;
        }

        public final void setCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
            this.certificateChainCleaner = certificateChainCleaner;
        }

        public final void setCertificatePinner$okhttp(CertificatePinner certificatePinner) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(certificatePinner, "<set-?>");
            this.certificatePinner = certificatePinner;
        }

        public final void setConnectTimeout$okhttp(int i) {
            this.connectTimeout = i;
        }

        public final void setConnectionPool$okhttp(ConnectionPool connectionPool) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(connectionPool, "<set-?>");
            this.connectionPool = connectionPool;
        }

        public final void setConnectionSpecs$okhttp(List<ConnectionSpec> list) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "<set-?>");
            this.connectionSpecs = list;
        }

        public final void setCookieJar$okhttp(CookieJar cookieJar) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cookieJar, "<set-?>");
            this.cookieJar = cookieJar;
        }

        public final void setDispatcher$okhttp(Dispatcher dispatcher) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dispatcher, "<set-?>");
            this.dispatcher = dispatcher;
        }

        public final void setDns$okhttp(Dns dns) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dns, "<set-?>");
            this.dns = dns;
        }

        public final void setEventListenerFactory$okhttp(EventListener.Factory factory) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(factory, "<set-?>");
            this.eventListenerFactory = factory;
        }

        public final void setFollowRedirects$okhttp(boolean z) {
            this.followRedirects = z;
        }

        public final void setFollowSslRedirects$okhttp(boolean z) {
            this.followSslRedirects = z;
        }

        public final void setHostnameVerifier$okhttp(HostnameVerifier hostnameVerifier) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hostnameVerifier, "<set-?>");
            this.hostnameVerifier = hostnameVerifier;
        }

        public final void setPingInterval$okhttp(int i) {
            this.pingInterval = i;
        }

        public final void setProtocols$okhttp(List<? extends Protocol> list) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "<set-?>");
            this.protocols = list;
        }

        public final void setProxy$okhttp(Proxy proxy) {
            this.proxy = proxy;
        }

        public final void setProxyAuthenticator$okhttp(Authenticator authenticator) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(authenticator, "<set-?>");
            this.proxyAuthenticator = authenticator;
        }

        public final void setProxySelector$okhttp(ProxySelector proxySelector) {
            this.proxySelector = proxySelector;
        }

        public final void setReadTimeout$okhttp(int i) {
            this.readTimeout = i;
        }

        public final void setRetryOnConnectionFailure$okhttp(boolean z) {
            this.retryOnConnectionFailure = z;
        }

        public final void setSocketFactory$okhttp(SocketFactory socketFactory) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socketFactory, "<set-?>");
            this.socketFactory = socketFactory;
        }

        public final void setSslSocketFactoryOrNull$okhttp(SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactoryOrNull = sSLSocketFactory;
        }

        public final void setWriteTimeout$okhttp(int i) {
            this.writeTimeout = i;
        }

        public final void setX509TrustManagerOrNull$okhttp(X509TrustManager x509TrustManager) {
            this.x509TrustManagerOrNull = x509TrustManager;
        }

        public final Builder socketFactory(SocketFactory socketFactory) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socketFactory, "socketFactory");
            if (!(socketFactory instanceof SSLSocketFactory)) {
                this.socketFactory = socketFactory;
                return this;
            }
            throw new IllegalArgumentException("socketFactory instanceof SSLSocketFactory".toString());
        }

        public final Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocketFactory, "sslSocketFactory");
            this.sslSocketFactoryOrNull = sSLSocketFactory;
            this.certificateChainCleaner = Platform.Companion.get().buildCertificateChainCleaner(sSLSocketFactory);
            return this;
        }

        public final Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocketFactory, "sslSocketFactory");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x509TrustManager, "trustManager");
            this.sslSocketFactoryOrNull = sSLSocketFactory;
            this.certificateChainCleaner = CertificateChainCleaner.Companion.get(x509TrustManager);
            this.x509TrustManagerOrNull = x509TrustManager;
            return this;
        }

        public final Builder writeTimeout(long j, TimeUnit timeUnit) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit");
            this.writeTimeout = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public final Builder writeTimeout(Duration duration) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(duration, "duration");
            this.writeTimeout = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
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

        /* JADX INFO: Access modifiers changed from: private */
        public final SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
            try {
                SSLContext newSSLContext = Platform.Companion.get().newSSLContext();
                newSSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
                SSLSocketFactory socketFactory = newSSLContext.getSocketFactory();
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) socketFactory, "sslContext.socketFactory");
                return socketFactory;
            } catch (GeneralSecurityException e) {
                throw new AssertionError("No System TLS", e);
            }
        }

        public final List<ConnectionSpec> getDEFAULT_CONNECTION_SPECS$okhttp() {
            return OkHttpClient.DEFAULT_CONNECTION_SPECS;
        }

        public final List<Protocol> getDEFAULT_PROTOCOLS$okhttp() {
            return OkHttpClient.DEFAULT_PROTOCOLS;
        }
    }

    public OkHttpClient() {
        this(new Builder());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OkHttpClient(Builder builder) {
        ProxySelector proxySelector$okhttp;
        List<Interceptor> list;
        boolean z;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(builder, "builder");
        this.dispatcher = builder.getDispatcher$okhttp();
        this.connectionPool = builder.getConnectionPool$okhttp();
        this.interceptors = Util.toImmutableList(builder.getInterceptors$okhttp());
        this.networkInterceptors = Util.toImmutableList(builder.getNetworkInterceptors$okhttp());
        this.eventListenerFactory = builder.getEventListenerFactory$okhttp();
        this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure$okhttp();
        this.authenticator = builder.getAuthenticator$okhttp();
        this.followRedirects = builder.getFollowRedirects$okhttp();
        this.followSslRedirects = builder.getFollowSslRedirects$okhttp();
        this.cookieJar = builder.getCookieJar$okhttp();
        this.cache = builder.getCache$okhttp();
        this.dns = builder.getDns$okhttp();
        this.proxy = builder.getProxy$okhttp();
        if (builder.getProxy$okhttp() != null) {
            proxySelector$okhttp = new NullProxySelector();
        } else {
            proxySelector$okhttp = builder.getProxySelector$okhttp();
            proxySelector$okhttp = proxySelector$okhttp == null ? ProxySelector.getDefault() : proxySelector$okhttp;
            if (proxySelector$okhttp == null) {
                proxySelector$okhttp = new NullProxySelector();
            }
        }
        this.proxySelector = proxySelector$okhttp;
        this.proxyAuthenticator = builder.getProxyAuthenticator$okhttp();
        this.socketFactory = builder.getSocketFactory$okhttp();
        this.connectionSpecs = builder.getConnectionSpecs$okhttp();
        this.protocols = builder.getProtocols$okhttp();
        this.hostnameVerifier = builder.getHostnameVerifier$okhttp();
        this.callTimeoutMillis = builder.getCallTimeout$okhttp();
        this.connectTimeoutMillis = builder.getConnectTimeout$okhttp();
        this.readTimeoutMillis = builder.getReadTimeout$okhttp();
        this.writeTimeoutMillis = builder.getWriteTimeout$okhttp();
        this.pingIntervalMillis = builder.getPingInterval$okhttp();
        if (builder.getSslSocketFactoryOrNull$okhttp() == null) {
            List<ConnectionSpec> list2 = this.connectionSpecs;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                for (ConnectionSpec connectionSpec : list2) {
                    if (connectionSpec.isTls()) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                this.x509TrustManager = Platform.Companion.get().platformTrustManager();
                Platform.Companion.get().configureTrustManager(this.x509TrustManager);
                Companion companion = Companion;
                X509TrustManager x509TrustManager = this.x509TrustManager;
                if (x509TrustManager == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                this.sslSocketFactoryOrNull = companion.newSslSocketFactory(x509TrustManager);
                CertificateChainCleaner.Companion companion2 = CertificateChainCleaner.Companion;
                X509TrustManager x509TrustManager2 = this.x509TrustManager;
                if (x509TrustManager2 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                this.certificateChainCleaner = companion2.get(x509TrustManager2);
                if (this.sslSocketFactoryOrNull != null) {
                    Platform.Companion.get().configureSslSocketFactory(this.sslSocketFactoryOrNull);
                }
                this.certificatePinner = builder.getCertificatePinner$okhttp().withCertificateChainCleaner$okhttp(this.certificateChainCleaner);
                list = this.interceptors;
                if (list != null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
                }
                if (!(!list.contains(null))) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Null interceptor: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.interceptors);
                    throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
                }
                List<Interceptor> list3 = this.networkInterceptors;
                if (list3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
                }
                if (!list3.contains(null)) {
                    return;
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Null network interceptor: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.networkInterceptors);
                throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString().toString());
            }
        }
        this.sslSocketFactoryOrNull = builder.getSslSocketFactoryOrNull$okhttp();
        this.certificateChainCleaner = builder.getCertificateChainCleaner$okhttp();
        this.x509TrustManager = builder.getX509TrustManagerOrNull$okhttp();
        if (this.sslSocketFactoryOrNull != null) {
        }
        this.certificatePinner = builder.getCertificatePinner$okhttp().withCertificateChainCleaner$okhttp(this.certificateChainCleaner);
        list = this.interceptors;
        if (list != null) {
        }
    }

    /* renamed from: -deprecated_authenticator  reason: not valid java name */
    public final Authenticator m5060deprecated_authenticator() {
        return this.authenticator;
    }

    /* renamed from: -deprecated_cache  reason: not valid java name */
    public final Cache m5061deprecated_cache() {
        return this.cache;
    }

    /* renamed from: -deprecated_callTimeoutMillis  reason: not valid java name */
    public final int m5062deprecated_callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    /* renamed from: -deprecated_certificatePinner  reason: not valid java name */
    public final CertificatePinner m5063deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    /* renamed from: -deprecated_connectTimeoutMillis  reason: not valid java name */
    public final int m5064deprecated_connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    /* renamed from: -deprecated_connectionPool  reason: not valid java name */
    public final ConnectionPool m5065deprecated_connectionPool() {
        return this.connectionPool;
    }

    /* renamed from: -deprecated_connectionSpecs  reason: not valid java name */
    public final List<ConnectionSpec> m5066deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    /* renamed from: -deprecated_cookieJar  reason: not valid java name */
    public final CookieJar m5067deprecated_cookieJar() {
        return this.cookieJar;
    }

    /* renamed from: -deprecated_dispatcher  reason: not valid java name */
    public final Dispatcher m5068deprecated_dispatcher() {
        return this.dispatcher;
    }

    /* renamed from: -deprecated_dns  reason: not valid java name */
    public final Dns m5069deprecated_dns() {
        return this.dns;
    }

    /* renamed from: -deprecated_eventListenerFactory  reason: not valid java name */
    public final EventListener.Factory m5070deprecated_eventListenerFactory() {
        return this.eventListenerFactory;
    }

    /* renamed from: -deprecated_followRedirects  reason: not valid java name */
    public final boolean m5071deprecated_followRedirects() {
        return this.followRedirects;
    }

    /* renamed from: -deprecated_followSslRedirects  reason: not valid java name */
    public final boolean m5072deprecated_followSslRedirects() {
        return this.followSslRedirects;
    }

    /* renamed from: -deprecated_hostnameVerifier  reason: not valid java name */
    public final HostnameVerifier m5073deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    /* renamed from: -deprecated_interceptors  reason: not valid java name */
    public final List<Interceptor> m5074deprecated_interceptors() {
        return this.interceptors;
    }

    /* renamed from: -deprecated_networkInterceptors  reason: not valid java name */
    public final List<Interceptor> m5075deprecated_networkInterceptors() {
        return this.networkInterceptors;
    }

    /* renamed from: -deprecated_pingIntervalMillis  reason: not valid java name */
    public final int m5076deprecated_pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    /* renamed from: -deprecated_protocols  reason: not valid java name */
    public final List<Protocol> m5077deprecated_protocols() {
        return this.protocols;
    }

    /* renamed from: -deprecated_proxy  reason: not valid java name */
    public final Proxy m5078deprecated_proxy() {
        return this.proxy;
    }

    /* renamed from: -deprecated_proxyAuthenticator  reason: not valid java name */
    public final Authenticator m5079deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    /* renamed from: -deprecated_proxySelector  reason: not valid java name */
    public final ProxySelector m5080deprecated_proxySelector() {
        return this.proxySelector;
    }

    /* renamed from: -deprecated_readTimeoutMillis  reason: not valid java name */
    public final int m5081deprecated_readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    /* renamed from: -deprecated_retryOnConnectionFailure  reason: not valid java name */
    public final boolean m5082deprecated_retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    /* renamed from: -deprecated_socketFactory  reason: not valid java name */
    public final SocketFactory m5083deprecated_socketFactory() {
        return this.socketFactory;
    }

    /* renamed from: -deprecated_sslSocketFactory  reason: not valid java name */
    public final SSLSocketFactory m5084deprecated_sslSocketFactory() {
        return sslSocketFactory();
    }

    /* renamed from: -deprecated_writeTimeoutMillis  reason: not valid java name */
    public final int m5085deprecated_writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    public final Authenticator authenticator() {
        return this.authenticator;
    }

    public final Cache cache() {
        return this.cache;
    }

    public final int callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    public final CertificateChainCleaner certificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public Object clone() {
        return super.clone();
    }

    public final int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public final ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public final CookieJar cookieJar() {
        return this.cookieJar;
    }

    public final Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public final Dns dns() {
        return this.dns;
    }

    public final EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public final boolean followRedirects() {
        return this.followRedirects;
    }

    public final boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public final List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override // okhttp3.Call.Factory
    public Call newCall(Request request) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        return RealCall.Companion.newRealCall(this, request, false);
    }

    @Override // okhttp3.WebSocket.Factory
    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSocketListener, "listener");
        RealWebSocket realWebSocket = new RealWebSocket(request, webSocketListener, new Random(), this.pingIntervalMillis);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public final int pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    public final List<Protocol> protocols() {
        return this.protocols;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public final int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public final boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    public final X509TrustManager x509TrustManager() {
        return this.x509TrustManager;
    }
}
