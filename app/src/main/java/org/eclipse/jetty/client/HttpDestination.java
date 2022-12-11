package org.eclipse.jetty.client;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import me.tvspark.outline;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.SelectConnector;
import org.eclipse.jetty.client.security.Authentication;
import org.eclipse.jetty.client.security.SecurityListener;
import org.eclipse.jetty.http.HttpCookie;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.http.HttpMethods;
import org.eclipse.jetty.http.PathMap;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.ByteArrayBuffer;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.util.MultiPartWriter;
import org.eclipse.jetty.util.component.AggregateLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.ssl.SslContextFactory;

/* loaded from: classes4.dex */
public class HttpDestination implements Dumpable {
    public static final Logger LOG = Log.getLogger(HttpDestination.class);
    public final Address _address;
    public PathMap _authorizations;
    public final HttpClient _client;
    public List<HttpCookie> _cookies;
    public final ByteArrayBuffer _hostHeader;
    public volatile int _maxConnections;
    public volatile int _maxQueueSize;
    public volatile Address _proxy;
    public Authentication _proxyAuthentication;
    public final boolean _ssl;
    public final SslContextFactory _sslContextFactory;
    public final List<HttpExchange> _exchanges = new LinkedList();
    public final List<AbstractHttpConnection> _connections = new LinkedList();
    public final BlockingQueue<Object> _reservedConnections = new ArrayBlockingQueue(10, true);
    public final List<AbstractHttpConnection> _idleConnections = new ArrayList();
    public int _pendingConnections = 0;
    public int _pendingReservedConnections = 0;

    /* loaded from: classes4.dex */
    public class ConnectExchange extends ContentExchange {
        public final SelectConnector.UpgradableEndPoint proxyEndPoint;

        public ConnectExchange(Address address, SelectConnector.UpgradableEndPoint upgradableEndPoint) {
            this.proxyEndPoint = upgradableEndPoint;
            setMethod(HttpMethods.CONNECT);
            String address2 = address.toString();
            setRequestURI(address2);
            addRequestHeader("Host", address2);
            addRequestHeader(HttpHeaders.PROXY_CONNECTION, "keep-alive");
            addRequestHeader("User-Agent", "Jetty-Client");
        }

        @Override // org.eclipse.jetty.client.HttpExchange
        public void onConnectionFailed(Throwable th) {
            HttpDestination.this.onConnectionFailed(th);
        }

        @Override // org.eclipse.jetty.client.HttpExchange
        public void onException(Throwable th) {
            HttpExchange httpExchange;
            synchronized (HttpDestination.this) {
                httpExchange = !HttpDestination.this._exchanges.isEmpty() ? (HttpExchange) HttpDestination.this._exchanges.remove(0) : null;
            }
            if (httpExchange == null || !httpExchange.setStatus(9)) {
                return;
            }
            httpExchange.getEventListener().onException(th);
        }

        @Override // org.eclipse.jetty.client.HttpExchange
        public void onExpire() {
            HttpExchange httpExchange;
            synchronized (HttpDestination.this) {
                httpExchange = !HttpDestination.this._exchanges.isEmpty() ? (HttpExchange) HttpDestination.this._exchanges.remove(0) : null;
            }
            if (httpExchange == null || !httpExchange.setStatus(8)) {
                return;
            }
            httpExchange.getEventListener().onExpire();
        }

        @Override // org.eclipse.jetty.client.HttpExchange
        public void onResponseComplete() throws IOException {
            int responseStatus = getResponseStatus();
            if (responseStatus == 200) {
                this.proxyEndPoint.upgrade();
            } else if (responseStatus == 504) {
                onExpire();
            } else {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Proxy: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.proxyEndPoint.getRemoteAddr());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.proxyEndPoint.getRemotePort());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" didn't return http return code 200, but ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(responseStatus);
                onException(new ProtocolException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString()));
            }
        }
    }

    public HttpDestination(HttpClient httpClient, Address address, boolean z, SslContextFactory sslContextFactory) {
        this._client = httpClient;
        this._address = address;
        this._ssl = z;
        this._sslContextFactory = sslContextFactory;
        this._maxConnections = httpClient.getMaxConnectionsPerAddress();
        this._maxQueueSize = this._client.getMaxQueueSizePerAddress();
        String host = address.getHost();
        if (address.getPort() != (this._ssl ? 443 : 80)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(host, ":");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(address.getPort());
            host = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        this._hostHeader = new ByteArrayBuffer(host);
    }

    private AbstractHttpConnection getConnection(long j) throws IOException {
        AbstractHttpConnection abstractHttpConnection = null;
        while (abstractHttpConnection == null) {
            abstractHttpConnection = getIdleConnection();
            if (abstractHttpConnection != null || j <= 0) {
                break;
            }
            boolean z = false;
            synchronized (this) {
                if (this._connections.size() + this._pendingConnections < this._maxConnections) {
                    this._pendingReservedConnections++;
                    z = true;
                }
            }
            if (z) {
                startNewConnection();
                try {
                    Object take = this._reservedConnections.take();
                    if (!(take instanceof AbstractHttpConnection)) {
                        throw ((IOException) take);
                        break;
                    }
                    abstractHttpConnection = (AbstractHttpConnection) take;
                } catch (InterruptedException e) {
                    LOG.ignore(e);
                }
            } else {
                Thread.currentThread();
                Thread.sleep(200L);
                j -= 200;
            }
        }
        return abstractHttpConnection;
    }

    public void addAuthorization(String str, Authentication authentication) {
        synchronized (this) {
            if (this._authorizations == null) {
                this._authorizations = new PathMap();
            }
            this._authorizations.put(str, authentication);
        }
    }

    public void addCookie(HttpCookie httpCookie) {
        synchronized (this) {
            if (this._cookies == null) {
                this._cookies = new ArrayList();
            }
            this._cookies.add(httpCookie);
        }
    }

    public void clearCookies() {
        synchronized (this) {
            this._cookies.clear();
        }
    }

    public void close() throws IOException {
        synchronized (this) {
            for (AbstractHttpConnection abstractHttpConnection : this._connections) {
                abstractHttpConnection.close();
            }
        }
    }

    public void doSend(HttpExchange httpExchange) throws IOException {
        Authentication authentication;
        synchronized (this) {
            if (this._cookies != null) {
                StringBuilder sb = null;
                for (HttpCookie httpCookie : this._cookies) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    } else {
                        sb.append("; ");
                    }
                    sb.append(httpCookie.getName());
                    sb.append("=");
                    sb.append(httpCookie.getValue());
                }
                if (sb != null) {
                    httpExchange.addRequestHeader(HttpHeaders.COOKIE, sb.toString());
                }
            }
        }
        PathMap pathMap = this._authorizations;
        if (pathMap != null && (authentication = (Authentication) pathMap.match(httpExchange.getRequestURI())) != null) {
            authentication.setCredentials(httpExchange);
        }
        httpExchange.scheduleTimeout(this);
        AbstractHttpConnection idleConnection = getIdleConnection();
        if (idleConnection != null) {
            send(idleConnection, httpExchange);
            return;
        }
        boolean z = false;
        synchronized (this) {
            if (this._exchanges.size() == this._maxQueueSize) {
                throw new RejectedExecutionException("Queue full for address " + this._address);
            }
            this._exchanges.add(httpExchange);
            if (this._connections.size() + this._pendingConnections < this._maxConnections) {
                z = true;
            }
        }
        if (!z) {
            return;
        }
        startNewConnection();
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return AggregateLifeCycle.dump(this);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable appendable, String str) throws IOException {
        synchronized (this) {
            appendable.append(String.valueOf(this));
            appendable.append("idle=");
            appendable.append(String.valueOf(this._idleConnections.size()));
            appendable.append(" pending=");
            appendable.append(String.valueOf(this._pendingConnections));
            appendable.append("\n");
            AggregateLifeCycle.dump(appendable, str, this._connections);
        }
    }

    public void exchangeExpired(HttpExchange httpExchange) {
        synchronized (this) {
            this._exchanges.remove(httpExchange);
        }
    }

    public Address getAddress() {
        return this._address;
    }

    public int getConnections() {
        int size;
        synchronized (this) {
            size = this._connections.size();
        }
        return size;
    }

    public Buffer getHostHeader() {
        return this._hostHeader;
    }

    public HttpClient getHttpClient() {
        return this._client;
    }

    public AbstractHttpConnection getIdleConnection() throws IOException {
        AbstractHttpConnection abstractHttpConnection = null;
        do {
            synchronized (this) {
                if (abstractHttpConnection != null) {
                    this._connections.remove(abstractHttpConnection);
                    abstractHttpConnection.close();
                    abstractHttpConnection = null;
                }
                if (this._idleConnections.size() > 0) {
                    abstractHttpConnection = this._idleConnections.remove(this._idleConnections.size() - 1);
                }
            }
            if (abstractHttpConnection == null) {
                return null;
            }
        } while (!abstractHttpConnection.cancelIdleTimeout());
        return abstractHttpConnection;
    }

    public int getIdleConnections() {
        int size;
        synchronized (this) {
            size = this._idleConnections.size();
        }
        return size;
    }

    public int getMaxConnections() {
        return this._maxConnections;
    }

    public int getMaxQueueSize() {
        return this._maxQueueSize;
    }

    public Address getProxy() {
        return this._proxy;
    }

    public Authentication getProxyAuthentication() {
        return this._proxyAuthentication;
    }

    public SslContextFactory getSslContextFactory() {
        return this._sslContextFactory;
    }

    public boolean isProxied() {
        return this._proxy != null;
    }

    public boolean isSecure() {
        return this._ssl;
    }

    public void onConnectionFailed(Throwable th) {
        boolean z;
        synchronized (this) {
            z = true;
            this._pendingConnections--;
            if (this._pendingReservedConnections > 0) {
                this._pendingReservedConnections--;
            } else {
                if (this._exchanges.size() > 0) {
                    HttpExchange remove = this._exchanges.remove(0);
                    if (remove.setStatus(9)) {
                        remove.getEventListener().onConnectionFailed(th);
                    }
                    if (!this._exchanges.isEmpty() && this._client.isStarted()) {
                        th = null;
                    }
                }
                th = null;
            }
            z = false;
        }
        if (z) {
            startNewConnection();
        }
        if (th != null) {
            try {
                this._reservedConnections.put(th);
            } catch (InterruptedException e) {
                LOG.ignore(e);
            }
        }
    }

    public void onException(Throwable th) {
        synchronized (this) {
            this._pendingConnections--;
            if (this._exchanges.size() > 0) {
                HttpExchange remove = this._exchanges.remove(0);
                if (remove.setStatus(9)) {
                    remove.getEventListener().onException(th);
                }
            }
        }
    }

    public void onNewConnection(AbstractHttpConnection abstractHttpConnection) throws IOException {
        synchronized (this) {
            this._pendingConnections--;
            this._connections.add(abstractHttpConnection);
            if (this._pendingReservedConnections > 0) {
                this._pendingReservedConnections--;
            } else {
                EndPoint endPoint = abstractHttpConnection.getEndPoint();
                if (isProxied() && (endPoint instanceof SelectConnector.UpgradableEndPoint)) {
                    ConnectExchange connectExchange = new ConnectExchange(getAddress(), (SelectConnector.UpgradableEndPoint) endPoint);
                    connectExchange.setAddress(getProxy());
                    LOG.debug("Establishing tunnel to {} via {}", getAddress(), getProxy());
                    send(abstractHttpConnection, connectExchange);
                } else if (this._exchanges.size() == 0) {
                    LOG.debug("No exchanges for new connection {}", abstractHttpConnection);
                    abstractHttpConnection.setIdleTimeout();
                    this._idleConnections.add(abstractHttpConnection);
                } else {
                    send(abstractHttpConnection, this._exchanges.remove(0));
                }
                abstractHttpConnection = null;
            }
        }
        if (abstractHttpConnection != null) {
            try {
                this._reservedConnections.put(abstractHttpConnection);
            } catch (InterruptedException e) {
                LOG.ignore(e);
            }
        }
    }

    public void resend(HttpExchange httpExchange) throws IOException {
        httpExchange.getEventListener().onRetry();
        httpExchange.reset();
        doSend(httpExchange);
    }

    public AbstractHttpConnection reserveConnection(long j) throws IOException {
        AbstractHttpConnection connection = getConnection(j);
        if (connection != null) {
            connection.setReserved(true);
        }
        return connection;
    }

    public void returnConnection(AbstractHttpConnection abstractHttpConnection, boolean z) throws IOException {
        boolean z2;
        boolean z3 = false;
        if (abstractHttpConnection.isReserved()) {
            abstractHttpConnection.setReserved(false);
        }
        if (z) {
            try {
                abstractHttpConnection.close();
            } catch (IOException e) {
                LOG.ignore(e);
            }
        }
        if (!this._client.isStarted()) {
            return;
        }
        if (!z && abstractHttpConnection.getEndPoint().isOpen()) {
            synchronized (this) {
                if (this._exchanges.size() == 0) {
                    abstractHttpConnection.setIdleTimeout();
                    this._idleConnections.add(abstractHttpConnection);
                } else {
                    send(abstractHttpConnection, this._exchanges.remove(0));
                }
                notifyAll();
            }
            return;
        }
        synchronized (this) {
            this._connections.remove(abstractHttpConnection);
            z2 = true;
            if (this._exchanges.isEmpty()) {
                if (this._client.isRemoveIdleDestinations() && ((this._cookies == null || this._cookies.isEmpty()) && this._connections.isEmpty() && this._idleConnections.isEmpty())) {
                }
                z2 = false;
            } else {
                if (this._client.isStarted()) {
                    z2 = false;
                    z3 = true;
                }
                z2 = false;
            }
        }
        if (z3) {
            startNewConnection();
        }
        if (!z2) {
            return;
        }
        this._client.removeDestination(this);
    }

    public void returnIdleConnection(AbstractHttpConnection abstractHttpConnection) {
        boolean z;
        boolean z2;
        abstractHttpConnection.onIdleExpired(abstractHttpConnection.getEndPoint() != null ? abstractHttpConnection.getEndPoint().getMaxIdleTime() : -1L);
        synchronized (this) {
            this._idleConnections.remove(abstractHttpConnection);
            this._connections.remove(abstractHttpConnection);
            z = true;
            z2 = false;
            if (this._exchanges.isEmpty()) {
                if (!this._client.isRemoveIdleDestinations() || ((this._cookies != null && !this._cookies.isEmpty()) || !this._connections.isEmpty() || !this._idleConnections.isEmpty())) {
                    z = false;
                }
                z2 = z;
            } else if (this._client.isStarted()) {
            }
            z = false;
        }
        if (z) {
            startNewConnection();
        }
        if (z2) {
            this._client.removeDestination(this);
        }
    }

    public void send(AbstractHttpConnection abstractHttpConnection, HttpExchange httpExchange) throws IOException {
        synchronized (this) {
            if (!abstractHttpConnection.send(httpExchange)) {
                if (httpExchange.getStatus() <= 1) {
                    this._exchanges.add(0, httpExchange);
                }
                returnIdleConnection(abstractHttpConnection);
            }
        }
    }

    public void send(HttpExchange httpExchange) throws IOException {
        httpExchange.setStatus(1);
        LinkedList<String> registeredListeners = this._client.getRegisteredListeners();
        if (registeredListeners != null) {
            for (int size = registeredListeners.size(); size > 0; size--) {
                String str = registeredListeners.get(size - 1);
                try {
                    httpExchange.setEventListener((HttpEventListener) Class.forName(str).getDeclaredConstructor(HttpDestination.class, HttpExchange.class).newInstance(this, httpExchange));
                } catch (Exception e) {
                    throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to instantiate registered listener for destination: ", str)) { // from class: org.eclipse.jetty.client.HttpDestination.1
                        {
                            initCause(e);
                        }
                    };
                }
            }
        }
        if (this._client.hasRealms()) {
            httpExchange.setEventListener(new SecurityListener(this, httpExchange));
        }
        doSend(httpExchange);
    }

    public void setMaxConnections(int i) {
        this._maxConnections = i;
    }

    public void setMaxQueueSize(int i) {
        this._maxQueueSize = i;
    }

    public void setProxy(Address address) {
        this._proxy = address;
    }

    public void setProxyAuthentication(Authentication authentication) {
        this._proxyAuthentication = authentication;
    }

    public void startNewConnection() {
        try {
            synchronized (this) {
                this._pendingConnections++;
            }
            HttpClient.Connector connector = this._client._connector;
            if (connector == null) {
                return;
            }
            connector.startConnection(this);
        } catch (Exception e) {
            LOG.debug(e);
            onConnectionFailed(e);
        }
    }

    public synchronized String toDetailString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(toString());
        sb.append('\n');
        synchronized (this) {
            for (AbstractHttpConnection abstractHttpConnection : this._connections) {
                sb.append(abstractHttpConnection.toDetailString());
                if (this._idleConnections.contains(abstractHttpConnection)) {
                    sb.append(" IDLE");
                }
                sb.append('\n');
            }
        }
        return sb.toString();
        sb.append(MultiPartWriter.__DASHDASH);
        sb.append('\n');
        return sb.toString();
    }

    public synchronized String toString() {
        return String.format("HttpDestination@%x//%s:%d(%d/%d,%d,%d/%d)%n", Integer.valueOf(hashCode()), this._address.getHost(), Integer.valueOf(this._address.getPort()), Integer.valueOf(this._connections.size()), Integer.valueOf(this._maxConnections), Integer.valueOf(this._idleConnections.size()), Integer.valueOf(this._exchanges.size()), Integer.valueOf(this._maxQueueSize));
    }
}
