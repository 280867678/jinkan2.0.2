package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.pf0;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;

@ef0
/* loaded from: classes4.dex */
public final class ExchangeFinder {
    public final Address address;
    public final Call call;
    public RealConnection connectingConnection;
    public final RealConnectionPool connectionPool;
    public final EventListener eventListener;
    public boolean hasStreamFailure;
    public Route nextRouteToTry;
    public RouteSelector.Selection routeSelection;
    public final RouteSelector routeSelector;
    public final Transmitter transmitter;

    public ExchangeFinder(Transmitter transmitter, RealConnectionPool realConnectionPool, Address address, Call call, EventListener eventListener) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(transmitter, "transmitter");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(realConnectionPool, "connectionPool");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(address, "address");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(eventListener, "eventListener");
        this.transmitter = transmitter;
        this.connectionPool = realConnectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
        this.routeSelector = new RouteSelector(this.address, this.connectionPool.getRouteDatabase(), this.call, this.eventListener);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c8, code lost:
        if (r0.hasNext() == false) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048 A[Catch: all -> 0x01c6, TryCatch #0 {, blocks: (B:4:0x000a, B:6:0x0012, B:8:0x0026, B:10:0x002e, B:12:0x0034, B:13:0x0040, B:15:0x0048, B:18:0x0055, B:20:0x0061, B:116:0x006a, B:118:0x006e, B:120:0x0073, B:122:0x0079, B:124:0x0081, B:125:0x0086, B:129:0x003b, B:132:0x01be, B:133:0x01c5), top: B:3:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055 A[Catch: all -> 0x01c6, TryCatch #0 {, blocks: (B:4:0x000a, B:6:0x0012, B:8:0x0026, B:10:0x002e, B:12:0x0034, B:13:0x0040, B:15:0x0048, B:18:0x0055, B:20:0x0061, B:116:0x006a, B:118:0x006e, B:120:0x0073, B:122:0x0079, B:124:0x0081, B:125:0x0086, B:129:0x003b, B:132:0x01be, B:133:0x01c5), top: B:3:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, okhttp3.internal.connection.RealConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final RealConnection findConnection(int i, int i2, int i3, int i4, boolean z) throws IOException {
        Socket socket;
        RealConnection realConnection;
        Route route;
        boolean z2;
        boolean z3;
        List<Route> list;
        Socket socket2;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (this.connectionPool) {
            if (this.transmitter.isCanceled()) {
                throw new IOException("Canceled");
            }
            this.hasStreamFailure = false;
            ref$ObjectRef.element = this.transmitter.getConnection();
            if (this.transmitter.getConnection() != null) {
                RealConnection connection = this.transmitter.getConnection();
                if (connection == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else if (connection.getNoNewExchanges()) {
                    socket = this.transmitter.releaseConnectionNoEvents();
                    if (this.transmitter.getConnection() == null) {
                        realConnection = this.transmitter.getConnection();
                        ref$ObjectRef.element = null;
                    } else {
                        realConnection = null;
                    }
                    if (realConnection == null) {
                        if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, null, false)) {
                            realConnection = this.transmitter.getConnection();
                            route = null;
                            z2 = true;
                        } else {
                            if (this.nextRouteToTry != null) {
                                route = this.nextRouteToTry;
                                this.nextRouteToTry = null;
                            } else if (retryCurrentRoute()) {
                                RealConnection connection2 = this.transmitter.getConnection();
                                if (connection2 == null) {
                                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    throw null;
                                }
                                route = connection2.route();
                            }
                            z2 = false;
                        }
                    }
                    route = null;
                    z2 = false;
                }
            }
            socket = null;
            if (this.transmitter.getConnection() == null) {
            }
            if (realConnection == null) {
            }
            route = null;
            z2 = false;
        }
        if (socket != null) {
            Util.closeQuietly(socket);
        }
        T t = ref$ObjectRef.element;
        if (((RealConnection) t) != null) {
            EventListener eventListener = this.eventListener;
            Call call = this.call;
            RealConnection realConnection2 = (RealConnection) t;
            if (realConnection2 == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            eventListener.connectionReleased(call, realConnection2);
        }
        if (z2) {
            EventListener eventListener2 = this.eventListener;
            Call call2 = this.call;
            if (realConnection == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            eventListener2.connectionAcquired(call2, realConnection);
        }
        if (realConnection != null) {
            return realConnection;
        }
        if (route == null) {
            RouteSelector.Selection selection = this.routeSelection;
            if (selection != null) {
                if (selection == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
            }
            this.routeSelection = this.routeSelector.next();
            z3 = true;
            synchronized (this.connectionPool) {
                if (this.transmitter.isCanceled()) {
                    throw new IOException("Canceled");
                }
                if (z3) {
                    RouteSelector.Selection selection2 = this.routeSelection;
                    if (selection2 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    list = selection2.getRoutes();
                    if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, list, false)) {
                        realConnection = this.transmitter.getConnection();
                        z2 = true;
                    }
                } else {
                    list = null;
                }
                if (!z2) {
                    if (route == null) {
                        RouteSelector.Selection selection3 = this.routeSelection;
                        if (selection3 == null) {
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            throw null;
                        }
                        route = selection3.next();
                    }
                    RealConnectionPool realConnectionPool = this.connectionPool;
                    if (route == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    realConnection = new RealConnection(realConnectionPool, route);
                    this.connectingConnection = realConnection;
                }
            }
            if (z2) {
                EventListener eventListener3 = this.eventListener;
                Call call3 = this.call;
                if (realConnection == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                eventListener3.connectionAcquired(call3, realConnection);
                if (realConnection != null) {
                    return realConnection;
                }
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            } else if (realConnection == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            } else {
                realConnection.connect(i, i2, i3, i4, z, this.call, this.eventListener);
                this.connectionPool.getRouteDatabase().connected(realConnection.route());
                synchronized (this.connectionPool) {
                    this.connectingConnection = null;
                    if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, list, true)) {
                        realConnection.setNoNewExchanges(true);
                        socket2 = realConnection.socket();
                        realConnection = this.transmitter.getConnection();
                        this.nextRouteToTry = route;
                    } else {
                        this.connectionPool.put(realConnection);
                        this.transmitter.acquireConnectionNoEvents(realConnection);
                        socket2 = null;
                    }
                }
                if (socket2 != null) {
                    Util.closeQuietly(socket2);
                }
                EventListener eventListener4 = this.eventListener;
                Call call4 = this.call;
                if (realConnection == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                eventListener4.connectionAcquired(call4, realConnection);
                if (realConnection != null) {
                    return realConnection;
                }
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
        }
        z3 = false;
        synchronized (this.connectionPool) {
        }
    }

    private final RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        int successCount$okhttp;
        while (true) {
            RealConnection findConnection = findConnection(i, i2, i3, i4, z);
            synchronized (this.connectionPool) {
                successCount$okhttp = findConnection.getSuccessCount$okhttp();
            }
            if (successCount$okhttp != 0 && !findConnection.isHealthy(z2)) {
                findConnection.noNewExchanges();
            } else {
                return findConnection;
            }
        }
    }

    private final boolean retryCurrentRoute() {
        if (this.transmitter.getConnection() != null) {
            RealConnection connection = this.transmitter.getConnection();
            if (connection == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            } else if (connection.getRouteFailureCount$okhttp() == 0) {
                RealConnection connection2 = this.transmitter.getConnection();
                if (connection2 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else if (Util.canReuseConnectionFor(connection2.route().address().url(), this.address.url())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final RealConnection connectingConnection() {
        boolean holdsLock = Thread.holdsLock(this.connectionPool);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || holdsLock) {
            return this.connectingConnection;
        }
        throw new AssertionError("Assertion failed");
    }

    public final ExchangeCodec find(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(okHttpClient, "client");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chain, "chain");
        try {
            return findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).newCodec$okhttp(okHttpClient, chain);
        } catch (IOException e) {
            trackFailure();
            throw new RouteException(e);
        } catch (RouteException e2) {
            trackFailure();
            throw e2;
        }
    }

    public final boolean hasRouteToTry() {
        synchronized (this.connectionPool) {
            boolean z = true;
            if (this.nextRouteToTry != null) {
                return true;
            }
            if (!retryCurrentRoute()) {
                RouteSelector.Selection selection = this.routeSelection;
                if (!(selection != null ? selection.hasNext() : false) && !this.routeSelector.hasNext()) {
                    z = false;
                }
                return z;
            }
            RealConnection connection = this.transmitter.getConnection();
            if (connection != null) {
                this.nextRouteToTry = connection.route();
                return true;
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
    }

    public final boolean hasStreamFailure() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.hasStreamFailure;
        }
        return z;
    }

    public final void trackFailure() {
        boolean z = !Thread.holdsLock(this.connectionPool);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z) {
            synchronized (this.connectionPool) {
                this.hasStreamFailure = true;
            }
            return;
        }
        throw new AssertionError("Assertion failed");
    }
}
