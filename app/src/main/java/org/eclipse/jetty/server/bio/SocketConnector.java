package org.eclipse.jetty.server.bio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.eclipse.jetty.http.HttpException;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.ConnectedEndPoint;
import org.eclipse.jetty.p059io.Connection;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.p059io.EofException;
import org.eclipse.jetty.p059io.bio.SocketEndPoint;
import org.eclipse.jetty.server.AbstractConnector;
import org.eclipse.jetty.server.AbstractHttpConnection;
import org.eclipse.jetty.server.BlockingHttpConnection;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.util.component.AggregateLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class SocketConnector extends AbstractConnector {
    public static final Logger LOG = Log.getLogger(SocketConnector.class);
    public ServerSocket _serverSocket;
    public volatile int _localPort = -1;
    public final Set<EndPoint> _connections = new HashSet();

    /* loaded from: classes4.dex */
    public class ConnectorEndPoint extends SocketEndPoint implements Runnable, ConnectedEndPoint {
        public volatile Connection _connection;
        public final Socket _socket;

        public ConnectorEndPoint(Socket socket) throws IOException {
            super(socket, SocketConnector.this._maxIdleTime);
            this._connection = SocketConnector.this.newConnection(this);
            this._socket = socket;
        }

        @Override // org.eclipse.jetty.p059io.bio.SocketEndPoint, org.eclipse.jetty.p059io.bio.StreamEndPoint, org.eclipse.jetty.p059io.EndPoint
        public void close() throws IOException {
            if (this._connection instanceof AbstractHttpConnection) {
                ((AbstractHttpConnection) this._connection).getRequest().getAsyncContinuation().cancel();
            }
            super.close();
        }

        public void dispatch() throws IOException {
            if (SocketConnector.this.getThreadPool() == null || !SocketConnector.this.getThreadPool().dispatch(this)) {
                SocketConnector.LOG.warn("dispatch failed for {}", this._connection);
                close();
            }
        }

        @Override // org.eclipse.jetty.p059io.bio.StreamEndPoint, org.eclipse.jetty.p059io.EndPoint
        public int fill(Buffer buffer) throws IOException {
            int fill = super.fill(buffer);
            if (fill < 0) {
                if (!isInputShutdown()) {
                    shutdownInput();
                }
                if (isOutputShutdown()) {
                    close();
                }
            }
            return fill;
        }

        @Override // org.eclipse.jetty.p059io.ConnectedEndPoint
        public Connection getConnection() {
            return this._connection;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    try {
                        try {
                            SocketConnector.this.connectionOpened(this._connection);
                            synchronized (SocketConnector.this._connections) {
                                SocketConnector.this._connections.add(this);
                            }
                            while (SocketConnector.this.isStarted() && !isClosed()) {
                                if (this._connection.isIdle() && SocketConnector.this.isLowResources()) {
                                    setMaxIdleTime(SocketConnector.this.getLowResourcesMaxIdleTime());
                                }
                                this._connection = this._connection.handle();
                            }
                            SocketConnector.this.connectionClosed(this._connection);
                            synchronized (SocketConnector.this._connections) {
                                SocketConnector.this._connections.remove(this);
                            }
                            if (this._socket.isClosed()) {
                                return;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            int maxIdleTime = getMaxIdleTime();
                            this._socket.setSoTimeout(getMaxIdleTime());
                            while (this._socket.getInputStream().read() >= 0 && System.currentTimeMillis() - currentTimeMillis < maxIdleTime) {
                            }
                            if (this._socket.isClosed()) {
                                return;
                            }
                            this._socket.close();
                        } catch (IOException e) {
                            SocketConnector.LOG.ignore(e);
                        }
                    } catch (SocketException e2) {
                        SocketConnector.LOG.debug("EOF", e2);
                        try {
                            close();
                        } catch (IOException e3) {
                            SocketConnector.LOG.ignore(e3);
                        }
                        SocketConnector.this.connectionClosed(this._connection);
                        synchronized (SocketConnector.this._connections) {
                            SocketConnector.this._connections.remove(this);
                            if (this._socket.isClosed()) {
                                return;
                            }
                            long currentTimeMillis2 = System.currentTimeMillis();
                            int maxIdleTime2 = getMaxIdleTime();
                            this._socket.setSoTimeout(getMaxIdleTime());
                            while (this._socket.getInputStream().read() >= 0 && System.currentTimeMillis() - currentTimeMillis2 < maxIdleTime2) {
                            }
                            if (this._socket.isClosed()) {
                                return;
                            }
                            this._socket.close();
                        }
                    } catch (HttpException e4) {
                        SocketConnector.LOG.debug("BAD", e4);
                        try {
                            close();
                        } catch (IOException e5) {
                            SocketConnector.LOG.ignore(e5);
                        }
                        SocketConnector.this.connectionClosed(this._connection);
                        synchronized (SocketConnector.this._connections) {
                            SocketConnector.this._connections.remove(this);
                            if (this._socket.isClosed()) {
                                return;
                            }
                            long currentTimeMillis3 = System.currentTimeMillis();
                            int maxIdleTime3 = getMaxIdleTime();
                            this._socket.setSoTimeout(getMaxIdleTime());
                            while (this._socket.getInputStream().read() >= 0 && System.currentTimeMillis() - currentTimeMillis3 < maxIdleTime3) {
                            }
                            if (this._socket.isClosed()) {
                                return;
                            }
                            this._socket.close();
                        }
                    }
                } catch (EofException e6) {
                    SocketConnector.LOG.debug("EOF", e6);
                    try {
                        close();
                    } catch (IOException e7) {
                        SocketConnector.LOG.ignore(e7);
                    }
                    SocketConnector.this.connectionClosed(this._connection);
                    synchronized (SocketConnector.this._connections) {
                        SocketConnector.this._connections.remove(this);
                        if (this._socket.isClosed()) {
                            return;
                        }
                        long currentTimeMillis4 = System.currentTimeMillis();
                        int maxIdleTime4 = getMaxIdleTime();
                        this._socket.setSoTimeout(getMaxIdleTime());
                        while (this._socket.getInputStream().read() >= 0 && System.currentTimeMillis() - currentTimeMillis4 < maxIdleTime4) {
                        }
                        if (this._socket.isClosed()) {
                            return;
                        }
                        this._socket.close();
                    }
                } catch (Exception e8) {
                    SocketConnector.LOG.warn("handle failed?", e8);
                    try {
                        close();
                    } catch (IOException e9) {
                        SocketConnector.LOG.ignore(e9);
                    }
                    SocketConnector.this.connectionClosed(this._connection);
                    synchronized (SocketConnector.this._connections) {
                        SocketConnector.this._connections.remove(this);
                        if (this._socket.isClosed()) {
                            return;
                        }
                        long currentTimeMillis5 = System.currentTimeMillis();
                        int maxIdleTime5 = getMaxIdleTime();
                        this._socket.setSoTimeout(getMaxIdleTime());
                        while (this._socket.getInputStream().read() >= 0 && System.currentTimeMillis() - currentTimeMillis5 < maxIdleTime5) {
                        }
                        if (this._socket.isClosed()) {
                            return;
                        }
                        this._socket.close();
                    }
                }
            } catch (Throwable th) {
                SocketConnector.this.connectionClosed(this._connection);
                synchronized (SocketConnector.this._connections) {
                    SocketConnector.this._connections.remove(this);
                    try {
                        if (!this._socket.isClosed()) {
                            long currentTimeMillis6 = System.currentTimeMillis();
                            int maxIdleTime6 = getMaxIdleTime();
                            this._socket.setSoTimeout(getMaxIdleTime());
                            while (this._socket.getInputStream().read() >= 0 && System.currentTimeMillis() - currentTimeMillis6 < maxIdleTime6) {
                            }
                            if (!this._socket.isClosed()) {
                                this._socket.close();
                            }
                        }
                    } catch (IOException e10) {
                        SocketConnector.LOG.ignore(e10);
                    }
                    throw th;
                }
            }
        }

        @Override // org.eclipse.jetty.p059io.ConnectedEndPoint
        public void setConnection(Connection connection) {
            if (this._connection != connection && this._connection != null) {
                SocketConnector.this.connectionUpgraded(this._connection, connection);
            }
            this._connection = connection;
        }
    }

    @Override // org.eclipse.jetty.server.AbstractConnector
    public void accept(int i) throws IOException, InterruptedException {
        Socket accept = this._serverSocket.accept();
        configure(accept);
        new ConnectorEndPoint(accept).dispatch();
    }

    @Override // org.eclipse.jetty.server.Connector
    public void close() throws IOException {
        ServerSocket serverSocket = this._serverSocket;
        if (serverSocket != null) {
            serverSocket.close();
        }
        this._serverSocket = null;
        this._localPort = -2;
    }

    @Override // org.eclipse.jetty.server.AbstractConnector, org.eclipse.jetty.server.Connector
    public void customize(EndPoint endPoint, Request request) throws IOException {
        ((ConnectorEndPoint) endPoint).setMaxIdleTime(isLowResources() ? this._lowResourceMaxIdleTime : this._maxIdleTime);
        super.customize(endPoint, request);
    }

    @Override // org.eclipse.jetty.server.AbstractConnector, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        this._connections.clear();
        super.doStart();
    }

    @Override // org.eclipse.jetty.server.AbstractConnector, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        super.doStop();
        HashSet hashSet = new HashSet();
        synchronized (this._connections) {
            hashSet.addAll(this._connections);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((ConnectorEndPoint) ((EndPoint) it.next())).close();
        }
    }

    @Override // org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable appendable, String str) throws IOException {
        super.dump(appendable, str);
        HashSet hashSet = new HashSet();
        synchronized (this._connections) {
            hashSet.addAll(this._connections);
        }
        AggregateLifeCycle.dump(appendable, str, hashSet);
    }

    @Override // org.eclipse.jetty.server.Connector
    public Object getConnection() {
        return this._serverSocket;
    }

    @Override // org.eclipse.jetty.server.Connector
    public int getLocalPort() {
        return this._localPort;
    }

    public Connection newConnection(EndPoint endPoint) {
        return new BlockingHttpConnection(this, endPoint, getServer());
    }

    public ServerSocket newServerSocket(String str, int i, int i2) throws IOException {
        return str == null ? new ServerSocket(i, i2) : new ServerSocket(i, i2, InetAddress.getByName(str));
    }

    @Override // org.eclipse.jetty.server.Connector
    public void open() throws IOException {
        ServerSocket serverSocket = this._serverSocket;
        if (serverSocket == null || serverSocket.isClosed()) {
            this._serverSocket = newServerSocket(getHost(), getPort(), getAcceptQueueSize());
        }
        this._serverSocket.setReuseAddress(getReuseAddress());
        this._localPort = this._serverSocket.getLocalPort();
        if (this._localPort > 0) {
            return;
        }
        throw new IllegalStateException("port not allocated for " + this);
    }
}
