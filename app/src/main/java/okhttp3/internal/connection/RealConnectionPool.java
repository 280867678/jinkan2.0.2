package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.outline;
import me.tvspark.pf0;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.platform.Platform;

@ef0
/* loaded from: classes4.dex */
public final class RealConnectionPool {
    public static final Companion Companion = new Companion(null);
    public static final ThreadPoolExecutor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    public boolean cleanupRunning;
    public final long keepAliveDurationNs;
    public final int maxIdleConnections;
    public final RealConnectionPool$cleanupRunnable$1 cleanupRunnable = new Runnable() { // from class: okhttp3.internal.connection.RealConnectionPool$cleanupRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long cleanup = RealConnectionPool.this.cleanup(System.nanoTime());
                if (cleanup == -1) {
                    return;
                }
                try {
                    Util.lockAndWaitNanos(RealConnectionPool.this, cleanup);
                } catch (InterruptedException unused) {
                    RealConnectionPool.this.evictAll();
                }
            }
        }
    };
    public final ArrayDeque<RealConnection> connections = new ArrayDeque<>();
    public final RouteDatabase routeDatabase = new RouteDatabase();

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final RealConnectionPool get(ConnectionPool connectionPool) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [okhttp3.internal.connection.RealConnectionPool$cleanupRunnable$1] */
    public RealConnectionPool(int i, long j, TimeUnit timeUnit) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "timeUnit");
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("keepAliveDuration <= 0: ", j).toString());
    }

    private final int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        List<Reference<Transmitter>> transmitters = realConnection.getTransmitters();
        int i = 0;
        while (i < transmitters.size()) {
            Reference<Transmitter> reference = transmitters.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("A connection to ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(realConnection.route().address().url());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" was leaked. ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Did you forget to close a response body?");
                Platform.Companion.get().logCloseableLeak(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), ((Transmitter.TransmitterReference) reference).getCallStackTrace());
                transmitters.remove(i);
                realConnection.setNoNewExchanges(true);
                if (transmitters.isEmpty()) {
                    realConnection.setIdleAtNanos$okhttp(j - this.keepAliveDurationNs);
                    return 0;
                }
            }
        }
        return transmitters.size();
    }

    public final long cleanup(long j) {
        synchronized (this) {
            Iterator<RealConnection> it = this.connections.iterator();
            long j2 = Long.MIN_VALUE;
            RealConnection realConnection = null;
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                RealConnection next = it.next();
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) next, "connection");
                if (pruneAndGetAllocationCount(next, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long idleAtNanos$okhttp = j - next.getIdleAtNanos$okhttp();
                    if (idleAtNanos$okhttp > j2) {
                        realConnection = next;
                        j2 = idleAtNanos$okhttp;
                    }
                }
            }
            if (j2 < this.keepAliveDurationNs && i <= this.maxIdleConnections) {
                if (i > 0) {
                    return this.keepAliveDurationNs - j2;
                } else if (i2 > 0) {
                    return this.keepAliveDurationNs;
                } else {
                    this.cleanupRunning = false;
                    return -1L;
                }
            }
            this.connections.remove(realConnection);
            if (realConnection != null) {
                Util.closeQuietly(realConnection.socket());
                return 0L;
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
    }

    public final void connectFailed(Route route, IOException iOException) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(route, "failedRoute");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iOException, "failure");
        if (route.proxy().type() != Proxy.Type.DIRECT) {
            Address address = route.address();
            address.proxySelector().connectFailed(address.url().uri(), route.proxy().address(), iOException);
        }
        this.routeDatabase.failed(route);
    }

    public final boolean connectionBecameIdle(RealConnection realConnection) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(realConnection, "connection");
        boolean holdsLock = Thread.holdsLock(this);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || holdsLock) {
            if (realConnection.getNoNewExchanges() || this.maxIdleConnections == 0) {
                this.connections.remove(realConnection);
                return true;
            }
            notifyAll();
            return false;
        }
        throw new AssertionError("Assertion failed");
    }

    public final synchronized int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        ArrayList<RealConnection> arrayList = new ArrayList();
        synchronized (this) {
            Iterator<RealConnection> it = this.connections.iterator();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) it, "connections.iterator()");
            while (it.hasNext()) {
                RealConnection next = it.next();
                if (next.getTransmitters().isEmpty()) {
                    next.setNoNewExchanges(true);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) next, "connection");
                    arrayList.add(next);
                    it.remove();
                }
            }
        }
        for (RealConnection realConnection : arrayList) {
            Util.closeQuietly(realConnection.socket());
        }
    }

    public final boolean getCleanupRunning() {
        return this.cleanupRunning;
    }

    public final RouteDatabase getRouteDatabase() {
        return this.routeDatabase;
    }

    public final synchronized int idleConnectionCount() {
        int i;
        ArrayDeque<RealConnection> arrayDeque = this.connections;
        i = 0;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            for (RealConnection realConnection : arrayDeque) {
                if (realConnection.getTransmitters().isEmpty() && (i = i + 1) < 0) {
                    throw new ArithmeticException("Count overflow has happened.");
                }
            }
        }
        return i;
    }

    public final void put(RealConnection realConnection) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(realConnection, "connection");
        boolean holdsLock = Thread.holdsLock(this);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || holdsLock) {
            if (!this.cleanupRunning) {
                this.cleanupRunning = true;
                executor.execute(this.cleanupRunnable);
            }
            this.connections.add(realConnection);
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    public final void setCleanupRunning(boolean z) {
        this.cleanupRunning = z;
    }

    public final boolean transmitterAcquirePooledConnection(Address address, Transmitter transmitter, List<Route> list, boolean z) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(address, "address");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(transmitter, "transmitter");
        boolean holdsLock = Thread.holdsLock(this);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || holdsLock) {
            Iterator<RealConnection> it = this.connections.iterator();
            while (it.hasNext()) {
                RealConnection next = it.next();
                if (!z || next.isMultiplexed()) {
                    if (next.isEligible$okhttp(address, list)) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) next, "connection");
                        transmitter.acquireConnectionNoEvents(next);
                        return true;
                    }
                }
            }
            return false;
        }
        throw new AssertionError("Assertion failed");
    }
}
