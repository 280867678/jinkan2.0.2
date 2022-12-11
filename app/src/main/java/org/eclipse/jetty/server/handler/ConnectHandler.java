package org.eclipse.jetty.server.handler;

import com.tencent.bugly.BuglyStrategy;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.http.HttpMethods;
import org.eclipse.jetty.http.HttpParser;
import org.eclipse.jetty.p059io.AsyncEndPoint;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.ConnectedEndPoint;
import org.eclipse.jetty.p059io.Connection;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.p059io.nio.AsyncConnection;
import org.eclipse.jetty.p059io.nio.IndirectNIOBuffer;
import org.eclipse.jetty.p059io.nio.SelectChannelEndPoint;
import org.eclipse.jetty.p059io.nio.SelectorManager;
import org.eclipse.jetty.server.AbstractHttpConnection;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.HostMap;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.component.AggregateLifeCycle;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.slf4j.Marker;

/* loaded from: classes4.dex */
public class ConnectHandler extends HandlerWrapper {
    public static final Logger LOG = Log.getLogger(ConnectHandler.class);
    public HostMap<String> _black;
    public volatile int _connectTimeout;
    public volatile boolean _privateThreadPool;
    public final SelectorManager _selectorManager;
    public volatile ThreadPool _threadPool;
    public HostMap<String> _white;
    public volatile int _writeTimeout;

    /* loaded from: classes4.dex */
    public class ClientToProxyConnection implements AsyncConnection {
        public final SocketChannel _channel;
        public final ConcurrentMap<String, Object> _context;
        public final EndPoint _endPoint;
        public final long _timestamp;
        public volatile ProxyToServerConnection _toServer;
        public final Buffer _buffer = new IndirectNIOBuffer(4096);
        public boolean _firstTime = true;

        public ClientToProxyConnection(ConcurrentMap<String, Object> concurrentMap, SocketChannel socketChannel, EndPoint endPoint, long j) {
            this._context = concurrentMap;
            this._channel = socketChannel;
            this._endPoint = endPoint;
            this._timestamp = j;
        }

        public void close() {
            try {
                closeClient();
            } catch (IOException e) {
                Logger logger = ConnectHandler.LOG;
                logger.debug(this + ": unexpected exception closing the client", e);
            }
            try {
                closeServer();
            } catch (IOException e2) {
                Logger logger2 = ConnectHandler.LOG;
                logger2.debug(this + ": unexpected exception closing the server", e2);
            }
        }

        public void closeClient() throws IOException {
            this._endPoint.close();
        }

        public void closeServer() throws IOException {
            this._toServer.closeServer();
        }

        @Override // org.eclipse.jetty.p059io.Connection
        public long getTimeStamp() {
            return this._timestamp;
        }

        @Override // org.eclipse.jetty.p059io.Connection
        public Connection handle() throws IOException {
            ConnectHandler.LOG.debug("{}: begin reading from client", this);
            try {
                try {
                    try {
                        try {
                            if (this._firstTime) {
                                this._firstTime = false;
                                ConnectHandler.this.register(this._channel, this._toServer);
                                ConnectHandler.LOG.debug("{}: registered channel {} with connection {}", this, this._channel, this._toServer);
                            }
                            while (true) {
                                int read = ConnectHandler.this.read(this._endPoint, this._buffer, this._context);
                                if (read == -1) {
                                    ConnectHandler.LOG.debug("{}: client closed connection {}", this, this._endPoint);
                                    if (!this._endPoint.isOutputShutdown() && this._endPoint.isOpen()) {
                                        this._toServer.shutdownOutput();
                                    }
                                    closeServer();
                                } else if (read == 0) {
                                    break;
                                } else {
                                    ConnectHandler.LOG.debug("{}: read from client {} bytes {}", this, Integer.valueOf(read), this._endPoint);
                                    ConnectHandler.LOG.debug("{}: written to {} {} bytes", this, this._toServer, Integer.valueOf(ConnectHandler.this.write(this._toServer._endPoint, this._buffer, this._context)));
                                }
                            }
                            ConnectHandler.LOG.debug("{}: end reading from client", this);
                            return this;
                        } catch (ClosedChannelException e) {
                            ConnectHandler.LOG.debug(e);
                            closeServer();
                            throw e;
                        }
                    } catch (RuntimeException e2) {
                        Logger logger = ConnectHandler.LOG;
                        logger.warn(this + ": unexpected exception", e2);
                        close();
                        throw e2;
                    }
                } catch (IOException e3) {
                    Logger logger2 = ConnectHandler.LOG;
                    logger2.warn(this + ": unexpected exception", e3);
                    close();
                    throw e3;
                }
            } catch (Throwable th) {
                ConnectHandler.LOG.debug("{}: end reading from client", this);
                throw th;
            }
        }

        @Override // org.eclipse.jetty.p059io.Connection
        public boolean isIdle() {
            return false;
        }

        @Override // org.eclipse.jetty.p059io.Connection
        public boolean isSuspended() {
            return false;
        }

        @Override // org.eclipse.jetty.p059io.Connection
        public void onClose() {
        }

        @Override // org.eclipse.jetty.p059io.Connection
        public void onIdleExpired(long j) {
            try {
                ConnectHandler.LOG.debug("{} idle expired", this);
                if (this._endPoint.isOutputShutdown()) {
                    close();
                } else {
                    shutdownOutput();
                }
            } catch (Exception e) {
                ConnectHandler.LOG.debug(e);
                close();
            }
        }

        @Override // org.eclipse.jetty.p059io.nio.AsyncConnection
        public void onInputShutdown() throws IOException {
        }

        public void setConnection(ProxyToServerConnection proxyToServerConnection) {
            this._toServer = proxyToServerConnection;
        }

        public void shutdownOutput() throws IOException {
            this._endPoint.shutdownOutput();
        }

        public String toString() {
            return "ClientToProxy(:" + this._endPoint.getLocalPort() + "<=>:" + this._endPoint.getRemotePort() + ")";
        }
    }

    /* loaded from: classes4.dex */
    public class Manager extends SelectorManager {
        public Manager() {
        }

        @Override // org.eclipse.jetty.p059io.nio.SelectorManager
        public boolean dispatch(Runnable runnable) {
            return ConnectHandler.this._threadPool.dispatch(runnable);
        }

        @Override // org.eclipse.jetty.p059io.nio.SelectorManager
        public void endPointClosed(SelectChannelEndPoint selectChannelEndPoint) {
        }

        @Override // org.eclipse.jetty.p059io.nio.SelectorManager
        public void endPointOpened(SelectChannelEndPoint selectChannelEndPoint) {
            ((ProxyToServerConnection) selectChannelEndPoint.getSelectionKey().attachment()).ready();
        }

        @Override // org.eclipse.jetty.p059io.nio.SelectorManager
        public void endPointUpgraded(ConnectedEndPoint connectedEndPoint, Connection connection) {
        }

        @Override // org.eclipse.jetty.p059io.nio.SelectorManager
        public AsyncConnection newConnection(SocketChannel socketChannel, AsyncEndPoint asyncEndPoint, Object obj) {
            ProxyToServerConnection proxyToServerConnection = (ProxyToServerConnection) obj;
            proxyToServerConnection.setTimeStamp(System.currentTimeMillis());
            proxyToServerConnection.setEndPoint(asyncEndPoint);
            return proxyToServerConnection;
        }

        @Override // org.eclipse.jetty.p059io.nio.SelectorManager
        public SelectChannelEndPoint newEndPoint(SocketChannel socketChannel, SelectorManager.SelectSet selectSet, SelectionKey selectionKey) throws IOException {
            SelectChannelEndPoint selectChannelEndPoint = new SelectChannelEndPoint(socketChannel, selectSet, selectionKey, socketChannel.socket().getSoTimeout());
            selectChannelEndPoint.setConnection(selectSet.getManager().newConnection(socketChannel, selectChannelEndPoint, selectionKey.attachment()));
            selectChannelEndPoint.setMaxIdleTime(ConnectHandler.this._writeTimeout);
            return selectChannelEndPoint;
        }
    }

    /* loaded from: classes4.dex */
    public class ProxyToServerConnection implements AsyncConnection {
        public final ConcurrentMap<String, Object> _context;
        public volatile Buffer _data;
        public volatile AsyncEndPoint _endPoint;
        public volatile long _timestamp;
        public volatile ClientToProxyConnection _toClient;
        public final CountDownLatch _ready = new CountDownLatch(1);
        public final Buffer _buffer = new IndirectNIOBuffer(4096);

        public ProxyToServerConnection(ConcurrentMap<String, Object> concurrentMap, Buffer buffer) {
            this._context = concurrentMap;
            this._data = buffer;
        }

        private void writeData() throws IOException {
            synchronized (this) {
                if (this._data != null) {
                    ConnectHandler.LOG.debug("{}: written to server {} bytes", this, Integer.valueOf(ConnectHandler.this.write(this._endPoint, this._data, this._context)));
                    this._data = null;
                }
            }
        }

        public void close() {
            try {
                closeClient();
            } catch (IOException e) {
                Logger logger = ConnectHandler.LOG;
                logger.debug(this + ": unexpected exception closing the client", e);
            }
            try {
                closeServer();
            } catch (IOException e2) {
                Logger logger2 = ConnectHandler.LOG;
                logger2.debug(this + ": unexpected exception closing the server", e2);
            }
        }

        public void closeClient() throws IOException {
            this._toClient.closeClient();
        }

        public void closeServer() throws IOException {
            this._endPoint.close();
        }

        @Override // org.eclipse.jetty.p059io.Connection
        public long getTimeStamp() {
            return this._timestamp;
        }

        @Override // org.eclipse.jetty.p059io.Connection
        public Connection handle() throws IOException {
            ConnectHandler.LOG.debug("{}: begin reading from server", this);
            try {
                try {
                    try {
                        try {
                            writeData();
                            while (true) {
                                int read = ConnectHandler.this.read(this._endPoint, this._buffer, this._context);
                                if (read == -1) {
                                    ConnectHandler.LOG.debug("{}: server closed connection {}", this, this._endPoint);
                                    if (!this._endPoint.isOutputShutdown() && this._endPoint.isOpen()) {
                                        this._toClient.shutdownOutput();
                                    }
                                    closeClient();
                                } else if (read == 0) {
                                    break;
                                } else {
                                    ConnectHandler.LOG.debug("{}: read from server {} bytes {}", this, Integer.valueOf(read), this._endPoint);
                                    ConnectHandler.LOG.debug("{}: written to {} {} bytes", this, this._toClient, Integer.valueOf(ConnectHandler.this.write(this._toClient._endPoint, this._buffer, this._context)));
                                }
                            }
                            ConnectHandler.LOG.debug("{}: end reading from server", this);
                            return this;
                        } catch (ClosedChannelException e) {
                            ConnectHandler.LOG.debug(e);
                            throw e;
                        }
                    } catch (RuntimeException e2) {
                        Logger logger = ConnectHandler.LOG;
                        logger.warn(this + ": unexpected exception", e2);
                        close();
                        throw e2;
                    }
                } catch (IOException e3) {
                    Logger logger2 = ConnectHandler.LOG;
                    logger2.warn(this + ": unexpected exception", e3);
                    close();
                    throw e3;
                }
            } catch (Throwable th) {
                ConnectHandler.LOG.debug("{}: end reading from server", this);
                throw th;
            }
        }

        @Override // org.eclipse.jetty.p059io.Connection
        public boolean isIdle() {
            return false;
        }

        @Override // org.eclipse.jetty.p059io.Connection
        public boolean isSuspended() {
            return false;
        }

        @Override // org.eclipse.jetty.p059io.Connection
        public void onClose() {
        }

        @Override // org.eclipse.jetty.p059io.Connection
        public void onIdleExpired(long j) {
            try {
                ConnectHandler.LOG.debug("{} idle expired", this);
                if (this._endPoint.isOutputShutdown()) {
                    close();
                } else {
                    shutdownOutput();
                }
            } catch (Exception e) {
                ConnectHandler.LOG.debug(e);
                close();
            }
        }

        @Override // org.eclipse.jetty.p059io.nio.AsyncConnection
        public void onInputShutdown() throws IOException {
        }

        public void ready() {
            this._ready.countDown();
        }

        public void setConnection(ClientToProxyConnection clientToProxyConnection) {
            this._toClient = clientToProxyConnection;
        }

        public void setEndPoint(AsyncEndPoint asyncEndPoint) {
            this._endPoint = asyncEndPoint;
        }

        public void setTimeStamp(long j) {
            this._timestamp = j;
        }

        public void shutdownOutput() throws IOException {
            writeData();
            this._endPoint.shutdownOutput();
        }

        public String toString() {
            return "ProxyToServer(:" + this._endPoint.getLocalPort() + "<=>:" + this._endPoint.getRemotePort() + ")";
        }

        public void waitReady(long j) throws IOException {
            try {
                this._ready.await(j, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new IOException() { // from class: org.eclipse.jetty.server.handler.ConnectHandler.ProxyToServerConnection.1
                    {
                        initCause(e);
                    }
                };
            }
        }
    }

    public ConnectHandler() {
        this(null);
    }

    public ConnectHandler(Handler handler) {
        this._selectorManager = new Manager();
        this._connectTimeout = 5000;
        this._writeTimeout = BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH;
        this._white = new HostMap<>();
        this._black = new HostMap<>();
        setHandler(handler);
    }

    public ConnectHandler(Handler handler, String[] strArr, String[] strArr2) {
        this._selectorManager = new Manager();
        this._connectTimeout = 5000;
        this._writeTimeout = BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH;
        this._white = new HostMap<>();
        this._black = new HostMap<>();
        setHandler(handler);
        set(strArr, this._white);
        set(strArr2, this._black);
    }

    public ConnectHandler(String[] strArr, String[] strArr2) {
        this(null, strArr, strArr2);
    }

    private void add(String str, HostMap<String> hostMap) {
        if (str == null || str.length() <= 0) {
            return;
        }
        String trim = str.trim();
        if (hostMap.get(trim) != null) {
            return;
        }
        hostMap.put(trim, trim);
    }

    private SocketChannel connectToServer(ae0 ae0Var, String str, int i) throws IOException {
        SocketChannel connect = connect(ae0Var, str, i);
        connect.configureBlocking(false);
        return connect;
    }

    private ClientToProxyConnection prepareConnections(ConcurrentMap<String, Object> concurrentMap, SocketChannel socketChannel, Buffer buffer) {
        AbstractHttpConnection currentConnection = AbstractHttpConnection.getCurrentConnection();
        ProxyToServerConnection newProxyToServerConnection = newProxyToServerConnection(concurrentMap, buffer);
        ClientToProxyConnection newClientToProxyConnection = newClientToProxyConnection(concurrentMap, socketChannel, currentConnection.getEndPoint(), currentConnection.getTimeStamp());
        newClientToProxyConnection.setConnection(newProxyToServerConnection);
        newProxyToServerConnection.setConnection(newClientToProxyConnection);
        return newClientToProxyConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void register(SocketChannel socketChannel, ProxyToServerConnection proxyToServerConnection) throws IOException {
        this._selectorManager.register(socketChannel, proxyToServerConnection);
        proxyToServerConnection.waitReady(this._connectTimeout);
    }

    private void upgradeConnection(ae0 ae0Var, ce0 ce0Var, Connection connection) throws IOException {
        ae0Var.setAttribute("org.eclipse.jetty.io.Connection", connection);
        ce0Var.setStatus(101);
        LOG.debug("Upgraded connection to {}", connection);
    }

    public void addBlack(String str) {
        add(str, this._black);
    }

    public void addWhite(String str) {
        add(str, this._white);
    }

    public SocketChannel connect(ae0 ae0Var, String str, int i) throws IOException {
        SocketChannel open = SocketChannel.open();
        if (open == null) {
            throw new IOException("unable to connect to " + str + ":" + i);
        }
        try {
            LOG.debug("Establishing connection to {}:{}", str, Integer.valueOf(i));
            open.socket().setTcpNoDelay(true);
            open.socket().connect(new InetSocketAddress(str, i), getConnectTimeout());
            LOG.debug("Established connection to {}:{}", str, Integer.valueOf(i));
            return open;
        } catch (IOException e) {
            Logger logger = LOG;
            logger.debug("Failed to establish connection to " + str + ":" + i, e);
            try {
                open.close();
            } catch (IOException e2) {
                LOG.ignore(e2);
            }
            throw e;
        }
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        super.doStart();
        if (this._threadPool == null) {
            this._threadPool = getServer().getThreadPool();
            this._privateThreadPool = false;
        }
        if ((this._threadPool instanceof LifeCycle) && !((LifeCycle) this._threadPool).isRunning()) {
            ((LifeCycle) this._threadPool).start();
        }
        this._selectorManager.start();
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this._selectorManager.stop();
        ThreadPool threadPool = this._threadPool;
        if (this._privateThreadPool && this._threadPool != null && (threadPool instanceof LifeCycle)) {
            ((LifeCycle) threadPool).stop();
        }
        super.doStop();
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandlerContainer, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable appendable, String str) throws IOException {
        dumpThis(appendable);
        if (this._privateThreadPool) {
            AggregateLifeCycle.dump(appendable, str, Arrays.asList(this._threadPool, this._selectorManager), TypeUtil.asList(getHandlers()), getBeans());
        } else {
            AggregateLifeCycle.dump(appendable, str, Arrays.asList(this._selectorManager), TypeUtil.asList(getHandlers()), getBeans());
        }
    }

    public int getConnectTimeout() {
        return this._connectTimeout;
    }

    public ThreadPool getThreadPool() {
        return this._threadPool;
    }

    public int getWriteTimeout() {
        return this._writeTimeout;
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.Handler
    public void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        if (!HttpMethods.CONNECT.equalsIgnoreCase(ae0Var.getMethod())) {
            super.handle(str, request, ae0Var, ce0Var);
            return;
        }
        LOG.debug("CONNECT request for {}", ae0Var.getRequestURI());
        try {
            handleConnect(request, ae0Var, ce0Var, ae0Var.getRequestURI());
        } catch (Exception e) {
            Logger logger = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ConnectHandler ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(request.getUri());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e);
            logger.warn(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
            LOG.debug(e);
        }
    }

    public boolean handleAuthentication(ae0 ae0Var, ce0 ce0Var, String str) throws ServletException, IOException {
        return true;
    }

    public void handleConnect(Request request, ae0 ae0Var, ce0 ce0Var, String str) throws ServletException, IOException {
        if (!handleAuthentication(ae0Var, ce0Var, str)) {
            return;
        }
        int i = 80;
        int indexOf = str.indexOf(58);
        int i2 = 0;
        if (indexOf > 0) {
            String substring = str.substring(0, indexOf);
            i = Integer.parseInt(str.substring(indexOf + 1));
            str = substring;
        }
        if (!validateDestination(str)) {
            LOG.info(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ProxyHandler: Forbidden destination ", str), new Object[0]);
            ce0Var.setStatus(403);
            request.setHandled(true);
            return;
        }
        try {
            SocketChannel connectToServer = connectToServer(ae0Var, str, i);
            AbstractHttpConnection currentConnection = AbstractHttpConnection.getCurrentConnection();
            Buffer headerBuffer = ((HttpParser) currentConnection.getParser()).getHeaderBuffer();
            Buffer bodyBuffer = ((HttpParser) currentConnection.getParser()).getBodyBuffer();
            int length = headerBuffer == null ? 0 : headerBuffer.length();
            if (bodyBuffer != null) {
                i2 = bodyBuffer.length();
            }
            int i3 = length + i2;
            IndirectNIOBuffer indirectNIOBuffer = null;
            if (i3 > 0) {
                indirectNIOBuffer = new IndirectNIOBuffer(i3);
                if (headerBuffer != null) {
                    indirectNIOBuffer.put(headerBuffer);
                    headerBuffer.clear();
                }
                if (bodyBuffer != null) {
                    indirectNIOBuffer.put(bodyBuffer);
                    bodyBuffer.clear();
                }
            }
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            prepareContext(ae0Var, concurrentHashMap);
            ClientToProxyConnection prepareConnections = prepareConnections(concurrentHashMap, connectToServer, indirectNIOBuffer);
            ce0Var.setStatus(200);
            request.getConnection().getGenerator().setPersistent(true);
            ce0Var.getOutputStream().close();
            upgradeConnection(ae0Var, ce0Var, prepareConnections);
        } catch (SocketException e) {
            Logger logger = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ConnectHandler: SocketException ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            logger.info(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
            ce0Var.setStatus(500);
            request.setHandled(true);
        } catch (SocketTimeoutException e2) {
            Logger logger2 = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ConnectHandler: SocketTimeoutException");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e2.getMessage());
            logger2.info(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), new Object[0]);
            ce0Var.setStatus(504);
            request.setHandled(true);
        } catch (IOException e3) {
            Logger logger3 = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ConnectHandler: IOException");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(e3.getMessage());
            logger3.info(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), new Object[0]);
            ce0Var.setStatus(500);
            request.setHandled(true);
        }
    }

    public ClientToProxyConnection newClientToProxyConnection(ConcurrentMap<String, Object> concurrentMap, SocketChannel socketChannel, EndPoint endPoint, long j) {
        return new ClientToProxyConnection(concurrentMap, socketChannel, endPoint, j);
    }

    public ProxyToServerConnection newProxyToServerConnection(ConcurrentMap<String, Object> concurrentMap, Buffer buffer) {
        return new ProxyToServerConnection(concurrentMap, buffer);
    }

    public void prepareContext(ae0 ae0Var, ConcurrentMap<String, Object> concurrentMap) {
    }

    public int read(EndPoint endPoint, Buffer buffer, ConcurrentMap<String, Object> concurrentMap) throws IOException {
        return endPoint.fill(buffer);
    }

    public void set(String[] strArr, HostMap<String> hostMap) {
        hostMap.clear();
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        for (String str : strArr) {
            add(str, hostMap);
        }
    }

    public void setBlack(String[] strArr) {
        set(strArr, this._black);
    }

    public void setConnectTimeout(int i) {
        this._connectTimeout = i;
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void setServer(Server server) {
        super.setServer(server);
        server.getContainer().update(this, (Object) null, this._selectorManager, "selectManager");
        if (this._privateThreadPool) {
            server.getContainer().update((Object) this, (Object) null, (Object) Boolean.valueOf(this._privateThreadPool), "threadpool", true);
        } else {
            this._threadPool = server.getThreadPool();
        }
    }

    public void setThreadPool(ThreadPool threadPool) {
        if (getServer() != null) {
            getServer().getContainer().update((Object) this, (Object) (this._privateThreadPool ? this._threadPool : null), (Object) threadPool, "threadpool", true);
        }
        this._privateThreadPool = threadPool != null;
        this._threadPool = threadPool;
    }

    public void setWhite(String[] strArr) {
        set(strArr, this._white);
    }

    public void setWriteTimeout(int i) {
        this._writeTimeout = i;
    }

    public boolean validateDestination(String str) {
        if (this._white.size() <= 0 || this._white.getLazyMatches(str) != null) {
            return this._black.size() <= 0 || this._black.getLazyMatches(str) == null;
        }
        return false;
    }

    public int write(EndPoint endPoint, Buffer buffer, ConcurrentMap<String, Object> concurrentMap) throws IOException {
        if (buffer == null) {
            return 0;
        }
        int length = buffer.length();
        StringBuilder sb = LOG.isDebugEnabled() ? new StringBuilder() : null;
        int flush = endPoint.flush(buffer);
        if (sb != null) {
            sb.append(flush);
        }
        while (buffer.length() > 0 && !endPoint.isOutputShutdown()) {
            if (!endPoint.isBlocking() && !endPoint.blockWritable(getWriteTimeout())) {
                throw new IOException("Write timeout");
            }
            int flush2 = endPoint.flush(buffer);
            if (sb != null) {
                sb.append(Marker.ANY_NON_NULL_MARKER);
                sb.append(flush2);
            }
        }
        LOG.debug("Written {}/{} bytes {}", sb, Integer.valueOf(length), endPoint);
        buffer.compact();
        return length;
    }
}
