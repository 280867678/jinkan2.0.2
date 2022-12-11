package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.efs.sdk.base.Constants;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.outline;
import me.tvspark.pf0;
import me.tvspark.r40;
import me.tvspark.vw0;
import me.tvspark.ww0;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.p054ws.RealWebSocket;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import org.eclipse.jetty.http.HttpHeaderValues;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.http.HttpMethods;

@ef0
/* loaded from: classes4.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_TUNNEL_ATTEMPTS = 21;
    public static final String NPE_THROW_WITH_NULL = "throw with null exception";
    public final RealConnectionPool connectionPool;
    public Handshake handshake;
    public Http2Connection http2Connection;
    public boolean noNewExchanges;
    public Protocol protocol;
    public Socket rawSocket;
    public int refusedStreamCount;
    public final Route route;
    public int routeFailureCount;
    public vw0 sink;
    public Socket socket;
    public ww0 source;
    public int successCount;
    public int allocationLimit = 1;
    public final List<Reference<Transmitter>> transmitters = new ArrayList();
    public long idleAtNanos = Long.MAX_VALUE;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final RealConnection newTestConnection(RealConnectionPool realConnectionPool, Route route, Socket socket, long j) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(realConnectionPool, "connectionPool");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(route, "route");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socket, "socket");
            RealConnection realConnection = new RealConnection(realConnectionPool, route);
            realConnection.socket = socket;
            realConnection.setIdleAtNanos$okhttp(j);
            return realConnection;
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            $EnumSwitchMapping$0[Proxy.Type.HTTP.ordinal()] = 2;
            int[] iArr2 = new int[ErrorCode.values().length];
            $EnumSwitchMapping$1 = iArr2;
            ErrorCode errorCode = ErrorCode.REFUSED_STREAM;
            iArr2[4] = 1;
            int[] iArr3 = $EnumSwitchMapping$1;
            ErrorCode errorCode2 = ErrorCode.CANCEL;
            iArr3[5] = 2;
        }
    }

    public RealConnection(RealConnectionPool realConnectionPool, Route route) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(realConnectionPool, "connectionPool");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(route, "route");
        this.connectionPool = realConnectionPool;
        this.route = route;
    }

    private final void connectSocket(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Socket socket;
        int i3;
        Proxy proxy = this.route.proxy();
        Address address = this.route.address();
        Proxy.Type type = proxy.type();
        if (type != null && ((i3 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) == 1 || i3 == 2)) {
            socket = address.socketFactory().createSocket();
            if (socket == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
        } else {
            socket = new Socket(proxy);
        }
        this.rawSocket = socket;
        eventListener.connectStart(call, this.route.socketAddress(), proxy);
        socket.setSoTimeout(i2);
        try {
            Platform.Companion.get().connectSocket(socket, this.route.socketAddress(), i);
            try {
                this.source = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socket));
                this.sink = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socket));
            } catch (NullPointerException e) {
                if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) e.getMessage(), (Object) NPE_THROW_WITH_NULL)) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to connect to ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.route.socketAddress());
            ConnectException connectException = new ConnectException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private final void connectTls(ConnectionSpecSelector connectionSpecSelector) throws IOException {
        Address address = this.route.address();
        SSLSocketFactory sslSocketFactory = address.sslSocketFactory();
        SSLSocket sSLSocket = null;
        String str = null;
        try {
            if (sslSocketFactory == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            Socket createSocket = sslSocketFactory.createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
            if (createSocket == null) {
                throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            }
            SSLSocket sSLSocket2 = (SSLSocket) createSocket;
            try {
                ConnectionSpec configureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket2);
                if (configureSecureSocket.supportsTlsExtensions()) {
                    Platform.Companion.get().configureTlsExtensions(sSLSocket2, address.url().host(), address.protocols());
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                Handshake.Companion companion = Handshake.Companion;
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) session, "sslSocketSession");
                Handshake handshake = companion.get(session);
                HostnameVerifier hostnameVerifier = address.hostnameVerifier();
                if (hostnameVerifier == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else if (hostnameVerifier.verify(address.url().host(), session)) {
                    CertificatePinner certificatePinner = address.certificatePinner();
                    if (certificatePinner == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    certificatePinner.check(address.url().host(), handshake.peerCertificates());
                    if (configureSecureSocket.supportsTlsExtensions()) {
                        str = Platform.Companion.get().getSelectedProtocol(sSLSocket2);
                    }
                    this.socket = sSLSocket2;
                    this.source = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Socket) sSLSocket2));
                    this.sink = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Socket) sSLSocket2));
                    this.handshake = handshake;
                    this.protocol = str != null ? Protocol.Companion.get(str) : Protocol.HTTP_1_1;
                    Platform.Companion.get().afterHandshake(sSLSocket2);
                } else {
                    List<Certificate> peerCertificates = handshake.peerCertificates();
                    if (!(!peerCertificates.isEmpty())) {
                        throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified (no certificates)");
                    }
                    Certificate certificate = peerCertificates.get(0);
                    if (certificate == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    X509Certificate x509Certificate = (X509Certificate) certificate;
                    StringBuilder sb = new StringBuilder();
                    sb.append("\n              |Hostname ");
                    sb.append(address.url().host());
                    sb.append(" not verified:\n              |    certificate: ");
                    sb.append(CertificatePinner.Companion.pin(x509Certificate));
                    sb.append("\n              |    DN: ");
                    Principal subjectDN = x509Certificate.getSubjectDN();
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) subjectDN, "cert.subjectDN");
                    sb.append(subjectDN.getName());
                    sb.append("\n              |    subjectAltNames: ");
                    sb.append(OkHostnameVerifier.INSTANCE.allSubjectAltNames(x509Certificate));
                    sb.append("\n              ");
                    throw new SSLPeerUnverifiedException(nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb.toString(), (String) null, 1));
                }
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    Platform.Companion.get().afterHandshake(sSLSocket);
                }
                if (sSLSocket != null) {
                    Util.closeQuietly((Socket) sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final void connectTunnel(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Request createTunnelRequest = createTunnelRequest();
        HttpUrl url = createTunnelRequest.url();
        for (int i4 = 0; i4 < 21; i4++) {
            connectSocket(i, i2, call, eventListener);
            createTunnelRequest = createTunnel(i2, i3, createTunnelRequest, url);
            if (createTunnelRequest == null) {
                return;
            }
            Socket socket = this.rawSocket;
            if (socket != null) {
                Util.closeQuietly(socket);
            }
            this.rawSocket = null;
            this.sink = null;
            this.source = null;
            eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), null);
        }
    }

    private final Request createTunnel(int i, int i2, Request request, HttpUrl httpUrl) throws IOException {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("CONNECT ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Util.toHostHeader(httpUrl, true));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" HTTP/1.1");
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        while (true) {
            ww0 ww0Var = this.source;
            if (ww0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            vw0 vw0Var = this.sink;
            if (vw0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, null, ww0Var, vw0Var);
            ww0Var.timeout().timeout(i, TimeUnit.MILLISECONDS);
            vw0Var.timeout().timeout(i2, TimeUnit.MILLISECONDS);
            http1ExchangeCodec.writeRequest(request.headers(), sb);
            http1ExchangeCodec.finishRequest();
            Response.Builder readResponseHeaders = http1ExchangeCodec.readResponseHeaders(false);
            if (readResponseHeaders == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            Response build = readResponseHeaders.request(request).build();
            http1ExchangeCodec.skipConnectBody(build);
            int code = build.code();
            if (code == 200) {
                if (ww0Var.getBuffer().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && vw0Var.getBuffer().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (code != 407) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected response code for CONNECT: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(build.code());
                throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            } else {
                Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                if (authenticate == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HttpHeaderValues.CLOSE, Response.header$default(build, "Connection", null, 2, null), true)) {
                    return authenticate;
                }
                request = authenticate;
            }
        }
    }

    private final Request createTunnelRequest() throws IOException {
        Request build = new Request.Builder().url(this.route.address().url()).method(HttpMethods.CONNECT, null).header("Host", Util.toHostHeader(this.route.address().url(), true)).header(HttpHeaders.PROXY_CONNECTION, "Keep-Alive").header("User-Agent", Version.userAgent).build();
        Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        return authenticate != null ? authenticate : build;
    }

    private final void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int i, Call call, EventListener eventListener) throws IOException {
        if (this.route.address().sslSocketFactory() != null) {
            eventListener.secureConnectStart(call);
            connectTls(connectionSpecSelector);
            eventListener.secureConnectEnd(call, this.handshake);
            if (this.protocol != Protocol.HTTP_2) {
                return;
            }
            startHttp2(i);
        } else if (!this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            this.socket = this.rawSocket;
            this.protocol = Protocol.HTTP_1_1;
        } else {
            this.socket = this.rawSocket;
            this.protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            startHttp2(i);
        }
    }

    private final boolean routeMatchesAny(List<Route> list) {
        boolean z;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (Route route : list) {
                if (route.proxy().type() == Proxy.Type.DIRECT && this.route.proxy().type() == Proxy.Type.DIRECT && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.route.socketAddress(), route.socketAddress())) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void startHttp2(int i) throws IOException {
        Socket socket = this.socket;
        if (socket == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        ww0 ww0Var = this.source;
        if (ww0Var == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        vw0 vw0Var = this.sink;
        if (vw0Var == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        socket.setSoTimeout(0);
        Http2Connection build = new Http2Connection.Builder(true).socket(socket, this.route.address().url().host(), ww0Var, vw0Var).listener(this).pingIntervalMillis(i).build();
        this.http2Connection = build;
        Http2Connection.start$default(build, false, 1, null);
    }

    public final void cancel() {
        Socket socket = this.rawSocket;
        if (socket != null) {
            Util.closeQuietly(socket);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0093 A[Catch: IOException -> 0x00fc, TRY_LEAVE, TryCatch #3 {IOException -> 0x00fc, blocks: (B:16:0x008b, B:18:0x0093), top: B:15:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f5 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0148 A[EDGE_INSN: B:59:0x0148->B:58:0x0148 ?: BREAK  ] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void connect(int i, int i2, int i3, int i4, boolean z, Call call, EventListener eventListener) {
        Socket socket;
        Socket socket2;
        Http2Connection http2Connection;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(eventListener, "eventListener");
        if (this.protocol == null) {
            List<ConnectionSpec> connectionSpecs = this.route.address().connectionSpecs();
            ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(connectionSpecs);
            if (this.route.address().sslSocketFactory() == null) {
                if (!connectionSpecs.contains(ConnectionSpec.CLEARTEXT)) {
                    throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                }
                String host = this.route.address().url().host();
                if (!Platform.Companion.get().isCleartextTrafficPermitted(host)) {
                    throw new RouteException(new UnknownServiceException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("CLEARTEXT communication to ", host, " not permitted by network security policy")));
                }
            } else if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
            }
            RouteException routeException = null;
            do {
                try {
                    try {
                        if (this.route.requiresTunnel()) {
                            connectTunnel(i, i2, i3, call, eventListener);
                            if (this.rawSocket == null) {
                                if (!this.route.requiresTunnel() && this.rawSocket == null) {
                                    throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                                }
                                http2Connection = this.http2Connection;
                                if (http2Connection != null) {
                                    return;
                                }
                                synchronized (this.connectionPool) {
                                    this.allocationLimit = http2Connection.maxConcurrentStreams();
                                }
                                return;
                            }
                        } else {
                            try {
                                connectSocket(i, i2, call, eventListener);
                            } catch (IOException e) {
                                e = e;
                                socket = this.socket;
                                if (socket != null) {
                                    Util.closeQuietly(socket);
                                }
                                socket2 = this.rawSocket;
                                if (socket2 != null) {
                                    Util.closeQuietly(socket2);
                                }
                                this.socket = null;
                                this.rawSocket = null;
                                this.source = null;
                                this.sink = null;
                                this.handshake = null;
                                this.protocol = null;
                                this.http2Connection = null;
                                eventListener.connectFailed(call, this.route.socketAddress(), this.route.proxy(), null, e);
                                if (routeException != null) {
                                    routeException = new RouteException(e);
                                } else {
                                    routeException.addConnectException(e);
                                }
                                if (!z || connectionSpecSelector.connectionFailed(e)) {
                                    throw routeException;
                                }
                                do {
                                    if (this.route.requiresTunnel()) {
                                    }
                                    establishProtocol(connectionSpecSelector, i4, call, eventListener);
                                    eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), this.protocol);
                                    if (!this.route.requiresTunnel()) {
                                    }
                                    http2Connection = this.http2Connection;
                                    if (http2Connection != null) {
                                    }
                                } while (connectionSpecSelector.connectionFailed(e));
                                throw routeException;
                            }
                        }
                        establishProtocol(connectionSpecSelector, i4, call, eventListener);
                        eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), this.protocol);
                        if (!this.route.requiresTunnel()) {
                        }
                        http2Connection = this.http2Connection;
                        if (http2Connection != null) {
                        }
                    } catch (IOException e2) {
                        e = e2;
                        socket = this.socket;
                        if (socket != null) {
                        }
                        socket2 = this.rawSocket;
                        if (socket2 != null) {
                        }
                        this.socket = null;
                        this.rawSocket = null;
                        this.source = null;
                        this.sink = null;
                        this.handshake = null;
                        this.protocol = null;
                        this.http2Connection = null;
                        eventListener.connectFailed(call, this.route.socketAddress(), this.route.proxy(), null, e);
                        if (routeException != null) {
                        }
                        if (!z || connectionSpecSelector.connectionFailed(e)) {
                        }
                        do {
                            if (this.route.requiresTunnel()) {
                            }
                            establishProtocol(connectionSpecSelector, i4, call, eventListener);
                            eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), this.protocol);
                            if (!this.route.requiresTunnel()) {
                            }
                            http2Connection = this.http2Connection;
                            if (http2Connection != null) {
                            }
                        } while (connectionSpecSelector.connectionFailed(e));
                        throw routeException;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } while (connectionSpecSelector.connectionFailed(e));
            throw routeException;
        }
        throw new IllegalStateException("already connected".toString());
    }

    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public final long getIdleAtNanos$okhttp() {
        return this.idleAtNanos;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    public final int getSuccessCount$okhttp() {
        return this.successCount;
    }

    public final List<Reference<Transmitter>> getTransmitters() {
        return this.transmitters;
    }

    @Override // okhttp3.Connection
    public Handshake handshake() {
        return this.handshake;
    }

    public final boolean isEligible$okhttp(Address address, List<Route> list) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(address, "address");
        if (this.transmitters.size() >= this.allocationLimit || this.noNewExchanges || !this.route.address().equalsNonHost$okhttp(address)) {
            return false;
        }
        if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) address.url().host(), (Object) route().address().url().host())) {
            return true;
        }
        if (this.http2Connection == null || list == null || !routeMatchesAny(list) || address.hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
            return false;
        }
        try {
            CertificatePinner certificatePinner = address.certificatePinner();
            if (certificatePinner == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            String host = address.url().host();
            Handshake handshake = handshake();
            if (handshake != null) {
                certificatePinner.check(host, handshake.peerCertificates());
                return true;
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean isHealthy(boolean z) {
        Socket socket = this.socket;
        if (socket == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        ww0 ww0Var = this.source;
        if (ww0Var == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        } else if (socket.isClosed() || socket.isInputShutdown() || socket.isOutputShutdown()) {
            return false;
        } else {
            Http2Connection http2Connection = this.http2Connection;
            if (http2Connection != null) {
                return !http2Connection.isShutdown();
            }
            if (z) {
                try {
                    int soTimeout = socket.getSoTimeout();
                    try {
                        socket.setSoTimeout(1);
                        return !ww0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    } finally {
                        socket.setSoTimeout(soTimeout);
                    }
                } catch (SocketTimeoutException unused) {
                } catch (IOException unused2) {
                    return false;
                }
            }
            return true;
        }
    }

    public final boolean isMultiplexed() {
        return this.http2Connection != null;
    }

    public final ExchangeCodec newCodec$okhttp(OkHttpClient okHttpClient, Interceptor.Chain chain) throws SocketException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(okHttpClient, "client");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chain, "chain");
        Socket socket = this.socket;
        if (socket == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        ww0 ww0Var = this.source;
        if (ww0Var == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        vw0 vw0Var = this.sink;
        if (vw0Var == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(okHttpClient, this, chain, http2Connection);
        }
        socket.setSoTimeout(chain.readTimeoutMillis());
        ww0Var.timeout().timeout(chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        vw0Var.timeout().timeout(chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        return new Http1ExchangeCodec(okHttpClient, this, ww0Var, vw0Var);
    }

    public final RealWebSocket.Streams newWebSocketStreams$okhttp(final Exchange exchange) throws SocketException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exchange, "exchange");
        Socket socket = this.socket;
        if (socket == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        final ww0 ww0Var = this.source;
        if (ww0Var == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        final vw0 vw0Var = this.sink;
        if (vw0Var == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        socket.setSoTimeout(0);
        noNewExchanges();
        return new RealWebSocket.Streams(true, ww0Var, vw0Var) { // from class: okhttp3.internal.connection.RealConnection$newWebSocketStreams$1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Exchange.this.bodyComplete(-1L, true, true, null);
            }
        };
    }

    public final void noNewExchanges() {
        boolean z = !Thread.holdsLock(this.connectionPool);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z) {
            synchronized (this.connectionPool) {
                this.noNewExchanges = true;
            }
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onSettings(Http2Connection http2Connection) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(http2Connection, "connection");
        synchronized (this.connectionPool) {
            this.allocationLimit = http2Connection.maxConcurrentStreams();
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(Http2Stream http2Stream) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(http2Stream, "stream");
        http2Stream.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override // okhttp3.Connection
    public Protocol protocol() {
        Protocol protocol = this.protocol;
        if (protocol != null) {
            return protocol;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    @Override // okhttp3.Connection
    public Route route() {
        return this.route;
    }

    public final void setIdleAtNanos$okhttp(long j) {
        this.idleAtNanos = j;
    }

    public final void setNoNewExchanges(boolean z) {
        this.noNewExchanges = z;
    }

    public final void setRouteFailureCount$okhttp(int i) {
        this.routeFailureCount = i;
    }

    public final void setSuccessCount$okhttp(int i) {
        this.successCount = i;
    }

    @Override // okhttp3.Connection
    public Socket socket() {
        Socket socket = this.socket;
        if (socket != null) {
            return socket;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    public final boolean supportsUrl(HttpUrl httpUrl) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "url");
        HttpUrl url = this.route.address().url();
        if (httpUrl.port() != url.port()) {
            return false;
        }
        if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) httpUrl.host(), (Object) url.host())) {
            return true;
        }
        if (this.handshake == null) {
            return false;
        }
        OkHostnameVerifier okHostnameVerifier = OkHostnameVerifier.INSTANCE;
        String host = httpUrl.host();
        Handshake handshake = this.handshake;
        if (handshake == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        Certificate certificate = handshake.peerCertificates().get(0);
        if (certificate == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        }
        return okHostnameVerifier.verify(host, (X509Certificate) certificate);
    }

    public String toString() {
        Object obj;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Connection{");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.route.address().url().host());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(':');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.route.address().url().port());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(',');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" proxy=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.route.proxy());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" hostAddress=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.route.socketAddress());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" cipherSuite=");
        Handshake handshake = this.handshake;
        if (handshake == null || (obj = handshake.cipherSuite()) == null) {
            obj = Constants.CP_NONE;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" protocol=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.protocol);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public final void trackFailure$okhttp(IOException iOException) {
        int i;
        boolean z = !Thread.holdsLock(this.connectionPool);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z) {
            synchronized (this.connectionPool) {
                if (iOException instanceof StreamResetException) {
                    int ordinal = ((StreamResetException) iOException).errorCode.ordinal();
                    if (ordinal == 4) {
                        int i2 = this.refusedStreamCount + 1;
                        this.refusedStreamCount = i2;
                        if (i2 > 1) {
                            this.noNewExchanges = true;
                            i = this.routeFailureCount;
                            this.routeFailureCount = i + 1;
                        }
                    } else if (ordinal != 5) {
                        this.noNewExchanges = true;
                        i = this.routeFailureCount;
                        this.routeFailureCount = i + 1;
                    }
                } else if (!isMultiplexed() || (iOException instanceof ConnectionShutdownException)) {
                    this.noNewExchanges = true;
                    if (this.successCount == 0) {
                        if (iOException != null) {
                            this.connectionPool.connectFailed(this.route, iOException);
                        }
                        i = this.routeFailureCount;
                        this.routeFailureCount = i + 1;
                    }
                }
            }
            return;
        }
        throw new AssertionError("Assertion failed");
    }
}
