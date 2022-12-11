package org.eclipse.jetty.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.http.HttpBuffers;
import org.eclipse.jetty.http.HttpBuffersImpl;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.p059io.Buffers;
import org.eclipse.jetty.p059io.Connection;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.p059io.EofException;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.component.AggregateLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.statistic.CounterStatistic;
import org.eclipse.jetty.util.statistic.SampleStatistic;
import org.eclipse.jetty.util.thread.ThreadPool;

/* loaded from: classes4.dex */
public abstract class AbstractConnector extends AggregateLifeCycle implements HttpBuffers, Connector, Dumpable {
    public static final Logger LOG = Log.getLogger(AbstractConnector.class);
    public transient Thread[] _acceptorThreads;
    public final HttpBuffersImpl _buffers;
    public boolean _forwarded;
    public String _forwardedCipherSuiteHeader;
    public String _forwardedSslSessionIdHeader;
    public String _host;
    public String _hostHeader;
    public String _name;
    public Server _server;
    public ThreadPool _threadPool;
    public boolean _useDNS;
    public int _port = 0;
    public String _integralScheme = "https";
    public int _integralPort = 0;
    public String _confidentialScheme = "https";
    public int _confidentialPort = 0;
    public int _acceptQueueSize = 0;
    public int _acceptors = 1;
    public int _acceptorPriorityOffset = 0;
    public String _forwardedHostHeader = HttpHeaders.X_FORWARDED_HOST;
    public String _forwardedServerHeader = HttpHeaders.X_FORWARDED_SERVER;
    public String _forwardedForHeader = HttpHeaders.X_FORWARDED_FOR;
    public String _forwardedProtoHeader = HttpHeaders.X_FORWARDED_PROTO;
    public boolean _reuseAddress = true;
    public int _maxIdleTime = 200000;
    public int _lowResourceMaxIdleTime = -1;
    public int _soLingerTime = -1;
    public final AtomicLong _statsStartedAt = new AtomicLong(-1);
    public final CounterStatistic _connectionStats = new CounterStatistic();
    public final SampleStatistic _requestStats = new SampleStatistic();
    public final SampleStatistic _connectionDurationStats = new SampleStatistic();

    /* loaded from: classes4.dex */
    public class Acceptor implements Runnable {
        public int _acceptor;

        public Acceptor(int i) {
            this._acceptor = 0;
            this._acceptor = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger logger;
            Thread currentThread = Thread.currentThread();
            synchronized (AbstractConnector.this) {
                if (AbstractConnector.this._acceptorThreads == null) {
                    return;
                }
                AbstractConnector.this._acceptorThreads[this._acceptor] = currentThread;
                String name = AbstractConnector.this._acceptorThreads[this._acceptor].getName();
                currentThread.setName(name + " Acceptor" + this._acceptor + StringUtils.SPACE + AbstractConnector.this);
                int priority = currentThread.getPriority();
                try {
                    currentThread.setPriority(priority - AbstractConnector.this._acceptorPriorityOffset);
                    while (AbstractConnector.this.isRunning() && AbstractConnector.this.getConnection() != null) {
                        try {
                            try {
                                AbstractConnector.this.accept(this._acceptor);
                            } catch (InterruptedException e) {
                                e = e;
                                logger = AbstractConnector.LOG;
                                logger.ignore(e);
                            }
                        } catch (EofException e2) {
                            e = e2;
                            logger = AbstractConnector.LOG;
                            logger.ignore(e);
                        } catch (IOException e3) {
                            e = e3;
                            logger = AbstractConnector.LOG;
                            logger.ignore(e);
                        }
                    }
                    currentThread.setPriority(priority);
                    currentThread.setName(name);
                    synchronized (AbstractConnector.this) {
                        if (AbstractConnector.this._acceptorThreads != null) {
                            AbstractConnector.this._acceptorThreads[this._acceptor] = null;
                        }
                    }
                } catch (Throwable th) {
                    currentThread.setPriority(priority);
                    currentThread.setName(name);
                    synchronized (AbstractConnector.this) {
                        if (AbstractConnector.this._acceptorThreads != null) {
                            AbstractConnector.this._acceptorThreads[this._acceptor] = null;
                        }
                        throw th;
                    }
                }
            }
        }
    }

    public AbstractConnector() {
        HttpBuffersImpl httpBuffersImpl = new HttpBuffersImpl();
        this._buffers = httpBuffersImpl;
        addBean(httpBuffersImpl);
    }

    private void updateNotEqual(AtomicLong atomicLong, long j, long j2) {
        long j3;
        do {
            j3 = atomicLong.get();
            if (j == j3) {
                return;
            }
        } while (!atomicLong.compareAndSet(j3, j2));
    }

    public abstract void accept(int i) throws IOException, InterruptedException;

    /* JADX WARN: Removed duplicated region for block: B:16:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkForwardedHeaders(EndPoint endPoint, Request request) throws IOException {
        String stringField;
        String stringField2;
        HttpFields requestFields = request.getConnection().getRequestFields();
        if (getForwardedCipherSuiteHeader() != null && (stringField2 = requestFields.getStringField(getForwardedCipherSuiteHeader())) != null) {
            request.setAttribute("javax.servlet.request.cipher_suite", stringField2);
        }
        if (getForwardedSslSessionIdHeader() != null && (stringField = requestFields.getStringField(getForwardedSslSessionIdHeader())) != null) {
            request.setAttribute("javax.servlet.request.ssl_session_id", stringField);
            request.setScheme("https");
        }
        String leftMostFieldValue = getLeftMostFieldValue(requestFields, getForwardedHostHeader());
        String leftMostFieldValue2 = getLeftMostFieldValue(requestFields, getForwardedServerHeader());
        String leftMostFieldValue3 = getLeftMostFieldValue(requestFields, getForwardedForHeader());
        String leftMostFieldValue4 = getLeftMostFieldValue(requestFields, getForwardedProtoHeader());
        String str = this._hostHeader;
        InetAddress inetAddress = null;
        if (str != null) {
            requestFields.put(HttpHeaders.HOST_BUFFER, str);
        } else if (leftMostFieldValue == null) {
            if (leftMostFieldValue2 != null) {
                request.setServerName(leftMostFieldValue2);
            }
            if (leftMostFieldValue3 != null) {
                request.setRemoteAddr(leftMostFieldValue3);
                if (this._useDNS) {
                    try {
                        inetAddress = InetAddress.getByName(leftMostFieldValue3);
                    } catch (UnknownHostException e) {
                        LOG.ignore(e);
                    }
                }
                if (inetAddress != null) {
                    leftMostFieldValue3 = inetAddress.getHostName();
                }
                request.setRemoteHost(leftMostFieldValue3);
            }
            if (leftMostFieldValue4 != null) {
                return;
            }
            request.setScheme(leftMostFieldValue4);
            return;
        } else {
            requestFields.put(HttpHeaders.HOST_BUFFER, leftMostFieldValue);
        }
        request.setServerName(null);
        request.setServerPort(-1);
        request.getServerName();
        if (leftMostFieldValue3 != null) {
        }
        if (leftMostFieldValue4 != null) {
        }
    }

    public void configure(Socket socket) throws IOException {
        try {
            socket.setTcpNoDelay(true);
            if (this._soLingerTime >= 0) {
                socket.setSoLinger(true, this._soLingerTime / 1000);
            } else {
                socket.setSoLinger(false, 0);
            }
        } catch (Exception e) {
            LOG.ignore(e);
        }
    }

    public void connectionClosed(Connection connection) {
        connection.onClose();
        if (this._statsStartedAt.get() == -1) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - connection.getTimeStamp();
        this._requestStats.set(connection instanceof AbstractHttpConnection ? ((AbstractHttpConnection) connection).getRequests() : 0);
        this._connectionStats.decrement();
        this._connectionDurationStats.set(currentTimeMillis);
    }

    public void connectionOpened(Connection connection) {
        if (this._statsStartedAt.get() == -1) {
            return;
        }
        this._connectionStats.increment();
    }

    public void connectionUpgraded(Connection connection, Connection connection2) {
        this._requestStats.set(connection instanceof AbstractHttpConnection ? ((AbstractHttpConnection) connection).getRequests() : 0L);
    }

    @Override // org.eclipse.jetty.server.Connector
    public void customize(EndPoint endPoint, Request request) throws IOException {
        if (isForwarded()) {
            checkForwardedHeaders(endPoint, request);
        }
    }

    @Override // org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (this._server != null) {
            open();
            if (this._threadPool == null) {
                ThreadPool threadPool = this._server.getThreadPool();
                this._threadPool = threadPool;
                addBean(threadPool, false);
            }
            super.doStart();
            synchronized (this) {
                this._acceptorThreads = new Thread[getAcceptors()];
                for (int i = 0; i < this._acceptorThreads.length; i++) {
                    if (!this._threadPool.dispatch(new Acceptor(i))) {
                        throw new IllegalStateException("!accepting");
                    }
                }
                if (this._threadPool.isLowOnThreads()) {
                    LOG.warn("insufficient threads configured for {}", this);
                }
            }
            LOG.info("Started {}", this);
            return;
        }
        throw new IllegalStateException("No server");
    }

    @Override // org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        Thread[] threadArr;
        try {
            close();
        } catch (IOException e) {
            LOG.warn(e);
        }
        super.doStop();
        synchronized (this) {
            threadArr = this._acceptorThreads;
            this._acceptorThreads = null;
        }
        if (threadArr != null) {
            for (Thread thread : threadArr) {
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
    }

    public int getAcceptQueueSize() {
        return this._acceptQueueSize;
    }

    public int getAcceptorPriorityOffset() {
        return this._acceptorPriorityOffset;
    }

    public int getAcceptors() {
        return this._acceptors;
    }

    @Override // org.eclipse.jetty.server.Connector
    public int getConfidentialPort() {
        return this._confidentialPort;
    }

    @Override // org.eclipse.jetty.server.Connector
    public String getConfidentialScheme() {
        return this._confidentialScheme;
    }

    @Override // org.eclipse.jetty.server.Connector
    public int getConnections() {
        return (int) this._connectionStats.getTotal();
    }

    @Override // org.eclipse.jetty.server.Connector
    public long getConnectionsDurationMax() {
        return this._connectionDurationStats.getMax();
    }

    @Override // org.eclipse.jetty.server.Connector
    public double getConnectionsDurationMean() {
        return this._connectionDurationStats.getMean();
    }

    @Override // org.eclipse.jetty.server.Connector
    public double getConnectionsDurationStdDev() {
        return this._connectionDurationStats.getStdDev();
    }

    @Override // org.eclipse.jetty.server.Connector
    public long getConnectionsDurationTotal() {
        return this._connectionDurationStats.getTotal();
    }

    @Override // org.eclipse.jetty.server.Connector
    public int getConnectionsOpen() {
        return (int) this._connectionStats.getCurrent();
    }

    @Override // org.eclipse.jetty.server.Connector
    public int getConnectionsOpenMax() {
        return (int) this._connectionStats.getMax();
    }

    @Override // org.eclipse.jetty.server.Connector
    public int getConnectionsRequestsMax() {
        return (int) this._requestStats.getMax();
    }

    @Override // org.eclipse.jetty.server.Connector
    public double getConnectionsRequestsMean() {
        return this._requestStats.getMean();
    }

    @Override // org.eclipse.jetty.server.Connector
    public double getConnectionsRequestsStdDev() {
        return this._requestStats.getStdDev();
    }

    public String getForwardedCipherSuiteHeader() {
        return this._forwardedCipherSuiteHeader;
    }

    public String getForwardedForHeader() {
        return this._forwardedForHeader;
    }

    public String getForwardedHostHeader() {
        return this._forwardedHostHeader;
    }

    public String getForwardedProtoHeader() {
        return this._forwardedProtoHeader;
    }

    public String getForwardedServerHeader() {
        return this._forwardedServerHeader;
    }

    public String getForwardedSslSessionIdHeader() {
        return this._forwardedSslSessionIdHeader;
    }

    @Override // org.eclipse.jetty.server.Connector
    public String getHost() {
        return this._host;
    }

    public String getHostHeader() {
        return this._hostHeader;
    }

    @Override // org.eclipse.jetty.server.Connector
    public int getIntegralPort() {
        return this._integralPort;
    }

    @Override // org.eclipse.jetty.server.Connector
    public String getIntegralScheme() {
        return this._integralScheme;
    }

    public String getLeftMostFieldValue(HttpFields httpFields, String str) {
        String stringField;
        if (str == null || (stringField = httpFields.getStringField(str)) == null) {
            return null;
        }
        int indexOf = stringField.indexOf(44);
        return indexOf == -1 ? stringField : stringField.substring(0, indexOf);
    }

    @Override // org.eclipse.jetty.server.Connector
    @Deprecated
    public final int getLowResourceMaxIdleTime() {
        return getLowResourcesMaxIdleTime();
    }

    public int getLowResourcesMaxIdleTime() {
        return this._lowResourceMaxIdleTime;
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public int getMaxBuffers() {
        return this._buffers.getMaxBuffers();
    }

    @Override // org.eclipse.jetty.server.Connector
    public int getMaxIdleTime() {
        return this._maxIdleTime;
    }

    @Override // org.eclipse.jetty.server.Connector
    public String getName() {
        if (this._name == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getHost() == null ? StringUtil.ALL_INTERFACES : getHost());
            sb.append(":");
            sb.append(getLocalPort() <= 0 ? getPort() : getLocalPort());
            this._name = sb.toString();
        }
        return this._name;
    }

    @Override // org.eclipse.jetty.server.Connector
    public int getPort() {
        return this._port;
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public int getRequestBufferSize() {
        return this._buffers.getRequestBufferSize();
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public Buffers.Type getRequestBufferType() {
        return this._buffers.getRequestBufferType();
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public Buffers getRequestBuffers() {
        return this._buffers.getRequestBuffers();
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public int getRequestHeaderSize() {
        return this._buffers.getRequestHeaderSize();
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public Buffers.Type getRequestHeaderType() {
        return this._buffers.getRequestHeaderType();
    }

    @Override // org.eclipse.jetty.server.Connector
    public int getRequests() {
        return (int) this._requestStats.getTotal();
    }

    @Override // org.eclipse.jetty.server.Connector
    public boolean getResolveNames() {
        return this._useDNS;
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public int getResponseBufferSize() {
        return this._buffers.getResponseBufferSize();
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public Buffers.Type getResponseBufferType() {
        return this._buffers.getResponseBufferType();
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public Buffers getResponseBuffers() {
        return this._buffers.getResponseBuffers();
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public int getResponseHeaderSize() {
        return this._buffers.getResponseHeaderSize();
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public Buffers.Type getResponseHeaderType() {
        return this._buffers.getResponseHeaderType();
    }

    public boolean getReuseAddress() {
        return this._reuseAddress;
    }

    @Override // org.eclipse.jetty.server.Connector
    public Server getServer() {
        return this._server;
    }

    public int getSoLingerTime() {
        return this._soLingerTime;
    }

    @Override // org.eclipse.jetty.server.Connector
    public boolean getStatsOn() {
        return this._statsStartedAt.get() != -1;
    }

    @Override // org.eclipse.jetty.server.Connector
    public long getStatsOnMs() {
        long j = this._statsStartedAt.get();
        if (j != -1) {
            return System.currentTimeMillis() - j;
        }
        return 0L;
    }

    public ThreadPool getThreadPool() {
        return this._threadPool;
    }

    @Override // org.eclipse.jetty.server.Connector
    public boolean isConfidential(Request request) {
        return this._forwarded && request.getScheme().equalsIgnoreCase("https");
    }

    public boolean isForwarded() {
        return this._forwarded;
    }

    @Override // org.eclipse.jetty.server.Connector
    public boolean isIntegral(Request request) {
        return false;
    }

    @Override // org.eclipse.jetty.server.Connector
    public boolean isLowResources() {
        ThreadPool threadPool = this._threadPool;
        return threadPool != null ? threadPool.isLowOnThreads() : this._server.getThreadPool().isLowOnThreads();
    }

    public void join() throws InterruptedException {
        Thread[] threadArr;
        synchronized (this) {
            threadArr = this._acceptorThreads;
        }
        if (threadArr != null) {
            for (Thread thread : threadArr) {
                if (thread != null) {
                    thread.join();
                }
            }
        }
    }

    @Override // org.eclipse.jetty.server.Connector
    public void persist(EndPoint endPoint) throws IOException {
    }

    public void setAcceptQueueSize(int i) {
        this._acceptQueueSize = i;
    }

    public void setAcceptorPriorityOffset(int i) {
        this._acceptorPriorityOffset = i;
    }

    public void setAcceptors(int i) {
        if (i > Runtime.getRuntime().availableProcessors() * 2) {
            Logger logger = LOG;
            logger.warn("Acceptors should be <=2*availableProcessors: " + this, new Object[0]);
        }
        this._acceptors = i;
    }

    public void setConfidentialPort(int i) {
        this._confidentialPort = i;
    }

    public void setConfidentialScheme(String str) {
        this._confidentialScheme = str;
    }

    public void setForwarded(boolean z) {
        if (z) {
            LOG.debug("{} is forwarded", this);
        }
        this._forwarded = z;
    }

    public void setForwardedCipherSuiteHeader(String str) {
        this._forwardedCipherSuiteHeader = str;
    }

    public void setForwardedForHeader(String str) {
        this._forwardedForHeader = str;
    }

    public void setForwardedHostHeader(String str) {
        this._forwardedHostHeader = str;
    }

    public void setForwardedProtoHeader(String str) {
        this._forwardedProtoHeader = str;
    }

    public void setForwardedServerHeader(String str) {
        this._forwardedServerHeader = str;
    }

    public void setForwardedSslSessionIdHeader(String str) {
        this._forwardedSslSessionIdHeader = str;
    }

    @Override // org.eclipse.jetty.server.Connector
    public void setHost(String str) {
        this._host = str;
    }

    public void setHostHeader(String str) {
        this._hostHeader = str;
    }

    public void setIntegralPort(int i) {
        this._integralPort = i;
    }

    public void setIntegralScheme(String str) {
        this._integralScheme = str;
    }

    @Override // org.eclipse.jetty.server.Connector
    @Deprecated
    public final void setLowResourceMaxIdleTime(int i) {
        setLowResourcesMaxIdleTime(i);
    }

    public void setLowResourcesMaxIdleTime(int i) {
        this._lowResourceMaxIdleTime = i;
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public void setMaxBuffers(int i) {
        this._buffers.setMaxBuffers(i);
    }

    @Override // org.eclipse.jetty.server.Connector
    public void setMaxIdleTime(int i) {
        this._maxIdleTime = i;
    }

    public void setName(String str) {
        this._name = str;
    }

    @Override // org.eclipse.jetty.server.Connector
    public void setPort(int i) {
        this._port = i;
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public void setRequestBufferSize(int i) {
        this._buffers.setRequestBufferSize(i);
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public void setRequestBuffers(Buffers buffers) {
        this._buffers.setRequestBuffers(buffers);
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public void setRequestHeaderSize(int i) {
        this._buffers.setRequestHeaderSize(i);
    }

    public void setResolveNames(boolean z) {
        this._useDNS = z;
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public void setResponseBufferSize(int i) {
        this._buffers.setResponseBufferSize(i);
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public void setResponseBuffers(Buffers buffers) {
        this._buffers.setResponseBuffers(buffers);
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public void setResponseHeaderSize(int i) {
        this._buffers.setResponseHeaderSize(i);
    }

    public void setReuseAddress(boolean z) {
        this._reuseAddress = z;
    }

    @Override // org.eclipse.jetty.server.Connector
    public void setServer(Server server) {
        this._server = server;
    }

    public void setSoLingerTime(int i) {
        this._soLingerTime = i;
    }

    @Override // org.eclipse.jetty.server.Connector
    public void setStatsOn(boolean z) {
        long j = -1;
        if (!z || this._statsStartedAt.get() == -1) {
            if (LOG.isDebugEnabled()) {
                Logger logger = LOG;
                logger.debug("Statistics on = " + z + " for " + this, new Object[0]);
            }
            statsReset();
            AtomicLong atomicLong = this._statsStartedAt;
            if (z) {
                j = System.currentTimeMillis();
            }
            atomicLong.set(j);
        }
    }

    public void setThreadPool(ThreadPool threadPool) {
        removeBean(this._threadPool);
        this._threadPool = threadPool;
        addBean(threadPool);
    }

    @Override // org.eclipse.jetty.server.Connector
    public void statsReset() {
        updateNotEqual(this._statsStartedAt, -1L, System.currentTimeMillis());
        this._requestStats.reset();
        this._connectionStats.reset();
        this._connectionDurationStats.reset();
    }

    public void stopAccept(int i) throws Exception {
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = getClass().getSimpleName();
        objArr[1] = getHost() == null ? StringUtil.ALL_INTERFACES : getHost();
        objArr[2] = Integer.valueOf(getLocalPort() <= 0 ? getPort() : getLocalPort());
        return String.format("%s@%s:%d", objArr);
    }
}
