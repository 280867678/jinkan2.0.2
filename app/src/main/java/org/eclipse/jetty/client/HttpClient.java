package org.eclipse.jetty.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.net.ssl.SSLContext;
import org.eclipse.jetty.client.security.Authentication;
import org.eclipse.jetty.client.security.RealmResolver;
import org.eclipse.jetty.http.HttpBuffers;
import org.eclipse.jetty.http.HttpBuffersImpl;
import org.eclipse.jetty.http.HttpSchemes;
import org.eclipse.jetty.p059io.Buffers;
import org.eclipse.jetty.util.Attributes;
import org.eclipse.jetty.util.AttributesMap;
import org.eclipse.jetty.util.component.AggregateLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.eclipse.jetty.util.thread.Timeout;

/* loaded from: classes4.dex */
public class HttpClient extends AggregateLifeCycle implements HttpBuffers, Attributes, Dumpable {
    public static final int CONNECTOR_SELECT_CHANNEL = 2;
    public static final int CONNECTOR_SOCKET = 0;
    public AttributesMap _attributes;
    public final HttpBuffersImpl _buffers;
    public boolean _connectBlocking;
    public int _connectTimeout;
    public Connector _connector;
    public int _connectorType;
    public ConcurrentMap<Address, HttpDestination> _destinations;
    public long _idleTimeout;
    public Timeout _idleTimeoutQ;
    public int _maxConnectionsPerAddress;
    public int _maxQueueSizePerAddress;
    public int _maxRedirects;
    public int _maxRetries;
    public Set<String> _noProxy;
    public Address _proxy;
    public Authentication _proxyAuthentication;
    public RealmResolver _realmResolver;
    public LinkedList<String> _registeredListeners;
    public boolean _removeIdleDestinations;
    public final SslContextFactory _sslContextFactory;
    public ThreadPool _threadPool;
    public long _timeout;
    public Timeout _timeoutQ;
    public boolean _useDirectBuffers;

    /* loaded from: classes4.dex */
    public interface Connector extends LifeCycle {
        void startConnection(HttpDestination httpDestination) throws IOException;
    }

    /* loaded from: classes4.dex */
    public static class LocalQueuedThreadPool extends QueuedThreadPool {
        public LocalQueuedThreadPool() {
        }
    }

    public HttpClient() {
        this(new SslContextFactory());
    }

    public HttpClient(SslContextFactory sslContextFactory) {
        this._connectorType = 2;
        this._useDirectBuffers = true;
        this._connectBlocking = true;
        this._removeIdleDestinations = false;
        this._maxConnectionsPerAddress = Integer.MAX_VALUE;
        this._maxQueueSizePerAddress = Integer.MAX_VALUE;
        this._destinations = new ConcurrentHashMap();
        this._idleTimeout = 20000L;
        this._timeout = 320000L;
        this._connectTimeout = 75000;
        this._timeoutQ = new Timeout();
        this._idleTimeoutQ = new Timeout();
        this._maxRetries = 3;
        this._maxRedirects = 20;
        this._attributes = new AttributesMap();
        this._buffers = new HttpBuffersImpl();
        this._sslContextFactory = sslContextFactory;
        addBean(sslContextFactory);
        addBean(this._buffers);
    }

    private void setBufferTypes() {
        HttpBuffersImpl httpBuffersImpl;
        Buffers.Type type;
        if (this._connectorType == 0) {
            this._buffers.setRequestBufferType(Buffers.Type.BYTE_ARRAY);
            this._buffers.setRequestHeaderType(Buffers.Type.BYTE_ARRAY);
            this._buffers.setResponseBufferType(Buffers.Type.BYTE_ARRAY);
            httpBuffersImpl = this._buffers;
            type = Buffers.Type.BYTE_ARRAY;
        } else {
            this._buffers.setRequestBufferType(Buffers.Type.DIRECT);
            this._buffers.setRequestHeaderType(this._useDirectBuffers ? Buffers.Type.DIRECT : Buffers.Type.INDIRECT);
            this._buffers.setResponseBufferType(Buffers.Type.DIRECT);
            httpBuffersImpl = this._buffers;
            type = this._useDirectBuffers ? Buffers.Type.DIRECT : Buffers.Type.INDIRECT;
        }
        httpBuffersImpl.setResponseHeaderType(type);
    }

    public void cancel(Timeout.Task task) {
        task.cancel();
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void clearAttributes() {
        this._attributes.clearAttributes();
    }

    @Override // org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        setBufferTypes();
        this._timeoutQ.setDuration(this._timeout);
        this._timeoutQ.setNow();
        this._idleTimeoutQ.setDuration(this._idleTimeout);
        this._idleTimeoutQ.setNow();
        if (this._threadPool == null) {
            LocalQueuedThreadPool localQueuedThreadPool = new LocalQueuedThreadPool();
            localQueuedThreadPool.setMaxThreads(16);
            localQueuedThreadPool.setDaemon(true);
            localQueuedThreadPool.setName("HttpClient");
            this._threadPool = localQueuedThreadPool;
            addBean(localQueuedThreadPool, true);
        }
        Connector selectConnector = this._connectorType == 2 ? new SelectConnector(this) : new SocketConnector(this);
        this._connector = selectConnector;
        addBean(selectConnector, true);
        super.doStart();
        this._threadPool.dispatch(new Runnable() { // from class: org.eclipse.jetty.client.HttpClient.1
            @Override // java.lang.Runnable
            public void run() {
                while (HttpClient.this.isRunning()) {
                    HttpClient.this._timeoutQ.tick(System.currentTimeMillis());
                    HttpClient.this._idleTimeoutQ.tick(HttpClient.this._timeoutQ.getNow());
                    try {
                        Thread.sleep(200L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        });
    }

    @Override // org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        for (HttpDestination httpDestination : this._destinations.values()) {
            httpDestination.close();
        }
        this._timeoutQ.cancelAll();
        this._idleTimeoutQ.cancelAll();
        super.doStop();
        ThreadPool threadPool = this._threadPool;
        if (threadPool instanceof LocalQueuedThreadPool) {
            removeBean(threadPool);
            this._threadPool = null;
        }
        removeBean(this._connector);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public Object getAttribute(String str) {
        return this._attributes.getAttribute(str);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public Enumeration getAttributeNames() {
        return this._attributes.getAttributeNames();
    }

    public int getConnectTimeout() {
        return this._connectTimeout;
    }

    public int getConnectorType() {
        return this._connectorType;
    }

    public HttpDestination getDestination(Address address, boolean z) throws IOException {
        return getDestination(address, z, getSslContextFactory());
    }

    public HttpDestination getDestination(Address address, boolean z, SslContextFactory sslContextFactory) throws IOException {
        Set<String> set;
        if (address != null) {
            HttpDestination httpDestination = this._destinations.get(address);
            if (httpDestination != null) {
                return httpDestination;
            }
            HttpDestination httpDestination2 = new HttpDestination(this, address, z, sslContextFactory);
            if (this._proxy != null && ((set = this._noProxy) == null || !set.contains(address.getHost()))) {
                httpDestination2.setProxy(this._proxy);
                Authentication authentication = this._proxyAuthentication;
                if (authentication != null) {
                    httpDestination2.setProxyAuthentication(authentication);
                }
            }
            HttpDestination putIfAbsent = this._destinations.putIfAbsent(address, httpDestination2);
            return putIfAbsent != null ? putIfAbsent : httpDestination2;
        }
        throw new UnknownHostException("Remote socket address cannot be null.");
    }

    public Collection<Address> getDestinations() {
        return Collections.unmodifiableCollection(this._destinations.keySet());
    }

    public long getIdleTimeout() {
        return this._idleTimeout;
    }

    @Deprecated
    public String getKeyManagerAlgorithm() {
        return this._sslContextFactory.getSslKeyManagerFactoryAlgorithm();
    }

    @Deprecated
    public InputStream getKeyStoreInputStream() {
        return this._sslContextFactory.getKeyStoreInputStream();
    }

    @Deprecated
    public String getKeyStoreLocation() {
        return this._sslContextFactory.getKeyStorePath();
    }

    @Deprecated
    public String getKeyStoreType() {
        return this._sslContextFactory.getKeyStoreType();
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public int getMaxBuffers() {
        return this._buffers.getMaxBuffers();
    }

    public int getMaxConnectionsPerAddress() {
        return this._maxConnectionsPerAddress;
    }

    public int getMaxQueueSizePerAddress() {
        return this._maxQueueSizePerAddress;
    }

    public Set<String> getNoProxy() {
        return this._noProxy;
    }

    @Deprecated
    public String getProtocol() {
        return this._sslContextFactory.getProtocol();
    }

    @Deprecated
    public String getProvider() {
        return this._sslContextFactory.getProvider();
    }

    public Address getProxy() {
        return this._proxy;
    }

    public Authentication getProxyAuthentication() {
        return this._proxyAuthentication;
    }

    public RealmResolver getRealmResolver() {
        return this._realmResolver;
    }

    public LinkedList<String> getRegisteredListeners() {
        return this._registeredListeners;
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

    public SSLContext getSSLContext() {
        return this._sslContextFactory.getSslContext();
    }

    @Deprecated
    public String getSecureRandomAlgorithm() {
        return this._sslContextFactory.getSecureRandomAlgorithm();
    }

    @Deprecated
    public int getSoTimeout() {
        return Long.valueOf(getTimeout()).intValue();
    }

    public SslContextFactory getSslContextFactory() {
        return this._sslContextFactory;
    }

    public ThreadPool getThreadPool() {
        return this._threadPool;
    }

    public long getTimeout() {
        return this._timeout;
    }

    @Deprecated
    public String getTrustManagerAlgorithm() {
        return this._sslContextFactory.getTrustManagerFactoryAlgorithm();
    }

    @Deprecated
    public InputStream getTrustStoreInputStream() {
        return this._sslContextFactory.getTrustStoreInputStream();
    }

    @Deprecated
    public String getTrustStoreLocation() {
        return this._sslContextFactory.getTrustStore();
    }

    @Deprecated
    public String getTrustStoreType() {
        return this._sslContextFactory.getTrustStoreType();
    }

    public boolean getUseDirectBuffers() {
        return this._useDirectBuffers;
    }

    public boolean hasRealms() {
        return this._realmResolver != null;
    }

    public boolean isConnectBlocking() {
        return this._connectBlocking;
    }

    public boolean isProxied() {
        return this._proxy != null;
    }

    public boolean isRemoveIdleDestinations() {
        return this._removeIdleDestinations;
    }

    public int maxRedirects() {
        return this._maxRedirects;
    }

    public int maxRetries() {
        return this._maxRetries;
    }

    public void registerListener(String str) {
        if (this._registeredListeners == null) {
            this._registeredListeners = new LinkedList<>();
        }
        this._registeredListeners.add(str);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void removeAttribute(String str) {
        this._attributes.removeAttribute(str);
    }

    public void removeDestination(HttpDestination httpDestination) {
        this._destinations.remove(httpDestination.getAddress(), httpDestination);
    }

    public void schedule(Timeout.Task task) {
        this._timeoutQ.schedule(task);
    }

    public void schedule(Timeout.Task task, long j) {
        Timeout timeout = this._timeoutQ;
        timeout.schedule(task, j - timeout.getDuration());
    }

    public void scheduleIdle(Timeout.Task task) {
        this._idleTimeoutQ.schedule(task);
    }

    public void send(HttpExchange httpExchange) throws IOException {
        getDestination(httpExchange.getAddress(), HttpSchemes.HTTPS_BUFFER.equalsIgnoreCase(httpExchange.getScheme())).send(httpExchange);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void setAttribute(String str, Object obj) {
        this._attributes.setAttribute(str, obj);
    }

    public void setConnectBlocking(boolean z) {
        this._connectBlocking = z;
    }

    public void setConnectTimeout(int i) {
        this._connectTimeout = i;
    }

    public void setConnectorType(int i) {
        this._connectorType = i;
        setBufferTypes();
    }

    public void setIdleTimeout(long j) {
        this._idleTimeout = j;
    }

    @Deprecated
    public void setKeyManagerAlgorithm(String str) {
        this._sslContextFactory.setSslKeyManagerFactoryAlgorithm(str);
    }

    @Deprecated
    public void setKeyManagerPassword(String str) {
        this._sslContextFactory.setKeyManagerPassword(str);
    }

    @Deprecated
    public void setKeyStoreInputStream(InputStream inputStream) {
        this._sslContextFactory.setKeyStoreInputStream(inputStream);
    }

    @Deprecated
    public void setKeyStoreLocation(String str) {
        this._sslContextFactory.setKeyStorePath(str);
    }

    @Deprecated
    public void setKeyStorePassword(String str) {
        this._sslContextFactory.setKeyStorePassword(str);
    }

    @Deprecated
    public void setKeyStoreType(String str) {
        this._sslContextFactory.setKeyStoreType(str);
    }

    @Override // org.eclipse.jetty.http.HttpBuffers
    public void setMaxBuffers(int i) {
        this._buffers.setMaxBuffers(i);
    }

    public void setMaxConnectionsPerAddress(int i) {
        this._maxConnectionsPerAddress = i;
    }

    public void setMaxQueueSizePerAddress(int i) {
        this._maxQueueSizePerAddress = i;
    }

    public void setMaxRedirects(int i) {
        this._maxRedirects = i;
    }

    public void setMaxRetries(int i) {
        this._maxRetries = i;
    }

    public void setNoProxy(Set<String> set) {
        this._noProxy = set;
    }

    @Deprecated
    public void setProtocol(String str) {
        this._sslContextFactory.setProtocol(str);
    }

    @Deprecated
    public void setProvider(String str) {
        this._sslContextFactory.setProvider(str);
    }

    public void setProxy(Address address) {
        this._proxy = address;
    }

    public void setProxyAuthentication(Authentication authentication) {
        this._proxyAuthentication = authentication;
    }

    public void setRealmResolver(RealmResolver realmResolver) {
        this._realmResolver = realmResolver;
    }

    public void setRemoveIdleDestinations(boolean z) {
        this._removeIdleDestinations = z;
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

    @Deprecated
    public void setSecureRandomAlgorithm(String str) {
        this._sslContextFactory.setSecureRandomAlgorithm(str);
    }

    @Deprecated
    public void setSoTimeout(int i) {
        setTimeout(i);
    }

    public void setThreadPool(ThreadPool threadPool) {
        removeBean(this._threadPool);
        this._threadPool = threadPool;
        addBean(threadPool);
    }

    public void setTimeout(long j) {
        this._timeout = j;
    }

    @Deprecated
    public void setTrustManagerAlgorithm(String str) {
        this._sslContextFactory.setTrustManagerFactoryAlgorithm(str);
    }

    @Deprecated
    public void setTrustStoreInputStream(InputStream inputStream) {
        this._sslContextFactory.setTrustStoreInputStream(inputStream);
    }

    @Deprecated
    public void setTrustStoreLocation(String str) {
        this._sslContextFactory.setTrustStore(str);
    }

    @Deprecated
    public void setTrustStorePassword(String str) {
        this._sslContextFactory.setTrustStorePassword(str);
    }

    @Deprecated
    public void setTrustStoreType(String str) {
        this._sslContextFactory.setTrustStoreType(str);
    }

    public void setUseDirectBuffers(boolean z) {
        this._useDirectBuffers = z;
        setBufferTypes();
    }
}
