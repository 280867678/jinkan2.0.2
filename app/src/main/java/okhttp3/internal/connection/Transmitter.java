package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Ref$ObjectRef;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.nx0;
import me.tvspark.pf0;
import me.tvspark.sw0;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.Util;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.platform.Platform;

@ef0
/* loaded from: classes4.dex */
public final class Transmitter {
    public final Call call;
    public Object callStackTrace;
    public boolean canceled;
    public final OkHttpClient client;
    public RealConnection connection;
    public final RealConnectionPool connectionPool;
    public final EventListener eventListener;
    public Exchange exchange;
    public ExchangeFinder exchangeFinder;
    public boolean exchangeRequestDone;
    public boolean exchangeResponseDone;
    public boolean noMoreExchanges;
    public Request request;
    public final Transmitter$timeout$1 timeout;
    public boolean timeoutEarlyExit;

    @ef0
    /* loaded from: classes4.dex */
    public static final class TransmitterReference extends WeakReference<Transmitter> {
        public final Object callStackTrace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransmitterReference(Transmitter transmitter, Object obj) {
            super(transmitter);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(transmitter, "referent");
            this.callStackTrace = obj;
        }

        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [me.tvspark.nx0, okhttp3.internal.connection.Transmitter$timeout$1] */
    public Transmitter(OkHttpClient okHttpClient, Call call) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(okHttpClient, "client");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        this.client = okHttpClient;
        this.call = call;
        this.connectionPool = okHttpClient.connectionPool().getDelegate$okhttp();
        this.eventListener = this.client.eventListenerFactory().create(this.call);
        ?? r3 = new sw0() { // from class: okhttp3.internal.connection.Transmitter$timeout$1
            @Override // me.tvspark.sw0
            public void timedOut() {
                Transmitter.this.cancel();
            }
        };
        r3.timeout(this.client.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = r3;
    }

    private final Address createAddress(HttpUrl httpUrl) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x007d A[Catch: all -> 0x0013, TRY_ENTER, TryCatch #0 {all -> 0x0013, blocks: (B:50:0x000c, B:7:0x0019, B:9:0x0022, B:12:0x0028, B:14:0x002c, B:15:0x0032, B:17:0x0036, B:18:0x0038, B:20:0x003c, B:47:0x007d, B:48:0x0088), top: B:49:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:50:0x000c, B:7:0x0019, B:9:0x0022, B:12:0x0028, B:14:0x002c, B:15:0x0032, B:17:0x0036, B:18:0x0038, B:20:0x003c, B:47:0x007d, B:48:0x0088), top: B:49:0x000c }] */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, okhttp3.internal.connection.RealConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <E extends IOException> E maybeReleaseConnection(E e, boolean z) {
        boolean z2;
        boolean z3;
        Socket releaseConnectionNoEvents;
        boolean z4;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (this.connectionPool) {
            z2 = false;
            if (z) {
                try {
                    if (this.exchange != null) {
                        z3 = false;
                        if (z3) {
                            throw new IllegalStateException("cannot release connection while it is in use".toString());
                        }
                        ref$ObjectRef.element = this.connection;
                        releaseConnectionNoEvents = (this.connection == null || this.exchange != null || (!z && !this.noMoreExchanges)) ? null : releaseConnectionNoEvents();
                        if (this.connection != null) {
                            ref$ObjectRef.element = null;
                        }
                        z4 = this.noMoreExchanges && this.exchange == null;
                    }
                } finally {
                }
            }
            z3 = true;
            if (z3) {
            }
        }
        if (releaseConnectionNoEvents != null) {
            Util.closeQuietly(releaseConnectionNoEvents);
        }
        T t = ref$ObjectRef.element;
        if (((Connection) t) != null) {
            EventListener eventListener = this.eventListener;
            Call call = this.call;
            Connection connection = (Connection) t;
            if (connection == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            eventListener.connectionReleased(call, connection);
        }
        if (z4) {
            if (e != null) {
                z2 = true;
            }
            e = (E) timeoutExit(e);
            EventListener eventListener2 = this.eventListener;
            Call call2 = this.call;
            if (!z2) {
                eventListener2.callEnd(call2);
            } else if (e == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            } else {
                eventListener2.callFailed(call2, e);
            }
        }
        return e;
    }

    private final <E extends IOException> E timeoutExit(E e) {
        if (!this.timeoutEarlyExit && exit()) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
            if (e != null) {
                interruptedIOException.initCause(e);
            }
            return interruptedIOException;
        }
        return e;
    }

    public final void acquireConnectionNoEvents(RealConnection realConnection) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(realConnection, "connection");
        boolean holdsLock = Thread.holdsLock(this.connectionPool);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || holdsLock) {
            if (!(this.connection == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            this.connection = realConnection;
            realConnection.getTransmitters().add(new TransmitterReference(this, this.callStackTrace));
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    public final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this.call);
    }

    public final boolean canRetry() {
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        if (exchangeFinder == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        if (exchangeFinder.hasStreamFailure()) {
            ExchangeFinder exchangeFinder2 = this.exchangeFinder;
            if (exchangeFinder2 == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            } else if (exchangeFinder2.hasRouteToTry()) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
        Exchange exchange;
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            exchange = this.exchange;
            ExchangeFinder exchangeFinder = this.exchangeFinder;
            if (exchangeFinder == null || (realConnection = exchangeFinder.connectingConnection()) == null) {
                realConnection = this.connection;
            }
        }
        if (exchange != null) {
            exchange.cancel();
        } else if (realConnection == null) {
        } else {
            realConnection.cancel();
        }
    }

    public final void exchangeDoneDueToException() {
        synchronized (this.connectionPool) {
            if (!(!this.noMoreExchanges)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            this.exchange = null;
        }
    }

    public final <E extends IOException> E exchangeMessageDone$okhttp(Exchange exchange, boolean z, boolean z2, E e) {
        boolean z3;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exchange, "exchange");
        synchronized (this.connectionPool) {
            boolean z4 = true;
            if (!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exchange, this.exchange)) {
                return e;
            }
            if (z) {
                z3 = !this.exchangeRequestDone;
                this.exchangeRequestDone = true;
            } else {
                z3 = false;
            }
            if (z2) {
                if (!this.exchangeResponseDone) {
                    z3 = true;
                }
                this.exchangeResponseDone = true;
            }
            if (!this.exchangeRequestDone || !this.exchangeResponseDone || !z3) {
                z4 = false;
            } else {
                Exchange exchange2 = this.exchange;
                if (exchange2 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                RealConnection connection = exchange2.connection();
                if (connection == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                connection.setSuccessCount$okhttp(connection.getSuccessCount$okhttp() + 1);
                this.exchange = null;
            }
            return z4 ? (E) maybeReleaseConnection(e, false) : e;
        }
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    public final boolean hasExchange() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.exchange != null;
        }
        return z;
    }

    public final boolean isCanceled() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.canceled;
        }
        return z;
    }

    public final Exchange newExchange$okhttp(Interceptor.Chain chain, boolean z) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chain, "chain");
        synchronized (this.connectionPool) {
            boolean z2 = true;
            if (!(!this.noMoreExchanges)) {
                throw new IllegalStateException("released".toString());
            }
            if (this.exchange != null) {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
        }
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        if (exchangeFinder == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        ExchangeCodec find = exchangeFinder.find(this.client, chain, z);
        Call call = this.call;
        EventListener eventListener = this.eventListener;
        ExchangeFinder exchangeFinder2 = this.exchangeFinder;
        if (exchangeFinder2 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        Exchange exchange = new Exchange(this, call, eventListener, exchangeFinder2, find);
        synchronized (this.connectionPool) {
            this.exchange = exchange;
            this.exchangeRequestDone = false;
            this.exchangeResponseDone = false;
        }
        return exchange;
    }

    public final IOException noMoreExchanges(IOException iOException) {
        synchronized (this.connectionPool) {
            this.noMoreExchanges = true;
        }
        return maybeReleaseConnection(iOException, false);
    }

    public final void prepareToConnect(Request request) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        Request request2 = this.request;
        if (request2 != null) {
            if (request2 == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            if (Util.canReuseConnectionFor(request2.url(), request.url())) {
                ExchangeFinder exchangeFinder = this.exchangeFinder;
                if (exchangeFinder == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else if (exchangeFinder.hasRouteToTry()) {
                    return;
                }
            }
            if (!(this.exchange == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (this.exchangeFinder != null) {
                maybeReleaseConnection(null, true);
                this.exchangeFinder = null;
            }
        }
        this.request = request;
        this.exchangeFinder = new ExchangeFinder(this, this.connectionPool, createAddress(request.url()), this.call, this.eventListener);
    }

    public final Socket releaseConnectionNoEvents() {
        boolean holdsLock = Thread.holdsLock(this.connectionPool);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || holdsLock) {
            RealConnection realConnection = this.connection;
            if (realConnection == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            Iterator<Reference<Transmitter>> it = realConnection.getTransmitters().iterator();
            boolean z = false;
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it.next().get(), this)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                z = true;
            }
            if (!z) {
                throw new IllegalStateException("Check failed.".toString());
            }
            RealConnection realConnection2 = this.connection;
            if (realConnection2 == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            realConnection2.getTransmitters().remove(i);
            this.connection = null;
            if (realConnection2.getTransmitters().isEmpty()) {
                realConnection2.setIdleAtNanos$okhttp(System.nanoTime());
                if (this.connectionPool.connectionBecameIdle(realConnection2)) {
                    return realConnection2.socket();
                }
            }
            return null;
        }
        throw new AssertionError("Assertion failed");
    }

    public final void setConnection(RealConnection realConnection) {
        this.connection = realConnection;
    }

    public final nx0 timeout() {
        return this.timeout;
    }

    public final void timeoutEarlyExit() {
        if (!this.timeoutEarlyExit) {
            this.timeoutEarlyExit = true;
            exit();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void timeoutEnter() {
        enter();
    }
}
