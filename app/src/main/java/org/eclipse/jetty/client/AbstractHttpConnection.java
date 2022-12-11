package org.eclipse.jetty.client;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import me.tvspark.outline;
import org.eclipse.jetty.client.security.Authentication;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpGenerator;
import org.eclipse.jetty.http.HttpHeaderValues;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.http.HttpMethods;
import org.eclipse.jetty.http.HttpParser;
import org.eclipse.jetty.http.HttpVersions;
import org.eclipse.jetty.p059io.AbstractConnection;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.Buffers;
import org.eclipse.jetty.p059io.Connection;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.p059io.EofException;
import org.eclipse.jetty.p059io.View;
import org.eclipse.jetty.util.component.AggregateLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Timeout;

/* loaded from: classes4.dex */
public abstract class AbstractHttpConnection extends AbstractConnection implements Dumpable {
    public static final Logger LOG = Log.getLogger(AbstractHttpConnection.class);
    public Buffer _connectionHeader;
    public HttpDestination _destination;
    public volatile HttpExchange _exchange;
    public HttpGenerator _generator;
    public HttpParser _parser;
    public HttpExchange _pipeline;
    public boolean _reserved;
    public int _status;
    public boolean _http11 = true;
    public final Timeout.Task _idleTimeout = new ConnectionIdleTask();
    public AtomicBoolean _idle = new AtomicBoolean(false);

    /* loaded from: classes4.dex */
    public class ConnectionIdleTask extends Timeout.Task {
        public ConnectionIdleTask() {
        }

        @Override // org.eclipse.jetty.util.thread.Timeout.Task
        public void expired() {
            if (AbstractHttpConnection.this._idle.compareAndSet(true, false)) {
                AbstractHttpConnection abstractHttpConnection = AbstractHttpConnection.this;
                abstractHttpConnection._destination.returnIdleConnection(abstractHttpConnection);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Handler extends HttpParser.EventHandler {
        public Handler() {
        }

        @Override // org.eclipse.jetty.http.HttpParser.EventHandler
        public void content(Buffer buffer) throws IOException {
            HttpExchange httpExchange = AbstractHttpConnection.this._exchange;
            if (httpExchange != null) {
                httpExchange.getEventListener().onResponseContent(buffer);
            }
        }

        @Override // org.eclipse.jetty.http.HttpParser.EventHandler
        public void earlyEOF() {
            HttpExchange httpExchange = AbstractHttpConnection.this._exchange;
            if (httpExchange == null || httpExchange.isDone() || !httpExchange.setStatus(9)) {
                return;
            }
            httpExchange.getEventListener().onException(new EofException("early EOF"));
        }

        @Override // org.eclipse.jetty.http.HttpParser.EventHandler
        public void headerComplete() throws IOException {
            HttpExchange httpExchange = AbstractHttpConnection.this._exchange;
            if (httpExchange != null) {
                httpExchange.setStatus(6);
                if (!HttpMethods.CONNECT.equalsIgnoreCase(httpExchange.getMethod())) {
                    return;
                }
                AbstractHttpConnection.this._parser.setPersistent(true);
            }
        }

        @Override // org.eclipse.jetty.http.HttpParser.EventHandler
        public void messageComplete(long j) throws IOException {
            HttpExchange httpExchange = AbstractHttpConnection.this._exchange;
            if (httpExchange != null) {
                httpExchange.setStatus(7);
            }
        }

        @Override // org.eclipse.jetty.http.HttpParser.EventHandler
        public void parsedHeader(Buffer buffer, Buffer buffer2) throws IOException {
            HttpExchange httpExchange = AbstractHttpConnection.this._exchange;
            if (httpExchange != null) {
                if (HttpHeaders.CACHE.getOrdinal(buffer) == 1) {
                    AbstractHttpConnection.this._connectionHeader = HttpHeaderValues.CACHE.lookup(buffer2);
                }
                httpExchange.getEventListener().onResponseHeader(buffer, buffer2);
            }
        }

        @Override // org.eclipse.jetty.http.HttpParser.EventHandler
        public void startRequest(Buffer buffer, Buffer buffer2, Buffer buffer3) throws IOException {
        }

        @Override // org.eclipse.jetty.http.HttpParser.EventHandler
        public void startResponse(Buffer buffer, int i, Buffer buffer2) throws IOException {
            HttpExchange httpExchange = AbstractHttpConnection.this._exchange;
            if (httpExchange == null) {
                AbstractHttpConnection.LOG.warn("No exchange for response", new Object[0]);
                AbstractHttpConnection.this._endp.close();
                return;
            }
            if (i == 100 || i == 102) {
                httpExchange.setEventListener(new NonFinalResponseListener(httpExchange));
            } else if (i == 200 && HttpMethods.CONNECT.equalsIgnoreCase(httpExchange.getMethod())) {
                AbstractHttpConnection.this._parser.setHeadResponse(true);
            }
            AbstractHttpConnection.this._http11 = HttpVersions.HTTP_1_1_BUFFER.equals(buffer);
            AbstractHttpConnection.this._status = i;
            httpExchange.getEventListener().onResponseStatus(buffer, i, buffer2);
            httpExchange.setStatus(5);
        }
    }

    /* loaded from: classes4.dex */
    public class NonFinalResponseListener implements HttpEventListener {
        public final HttpExchange _exchange;
        public final HttpEventListener _next;

        public NonFinalResponseListener(HttpExchange httpExchange) {
            this._exchange = httpExchange;
            this._next = httpExchange.getEventListener();
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onConnectionFailed(Throwable th) {
            this._exchange.setEventListener(this._next);
            this._next.onConnectionFailed(th);
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onException(Throwable th) {
            this._exchange.setEventListener(this._next);
            this._next.onException(th);
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onExpire() {
            this._exchange.setEventListener(this._next);
            this._next.onExpire();
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onRequestCommitted() throws IOException {
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onRequestComplete() throws IOException {
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onResponseComplete() throws IOException {
            this._exchange.setEventListener(this._next);
            this._exchange.setStatus(4);
            AbstractHttpConnection.this._parser.reset();
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onResponseContent(Buffer buffer) throws IOException {
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onResponseHeader(Buffer buffer, Buffer buffer2) throws IOException {
            this._next.onResponseHeader(buffer, buffer2);
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onResponseHeaderComplete() throws IOException {
            this._next.onResponseHeaderComplete();
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onResponseStatus(Buffer buffer, int i, Buffer buffer2) throws IOException {
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onRetry() {
            this._exchange.setEventListener(this._next);
            this._next.onRetry();
        }
    }

    public AbstractHttpConnection(Buffers buffers, Buffers buffers2, EndPoint endPoint) {
        super(endPoint);
        this._generator = new HttpGenerator(buffers, endPoint);
        this._parser = new HttpParser(buffers2, endPoint, new Handler());
    }

    private void adjustIdleTimeout() throws IOException {
        long timeout = this._exchange.getTimeout();
        if (timeout <= 0) {
            timeout = this._destination.getHttpClient().getTimeout();
        }
        long maxIdleTime = this._endp.getMaxIdleTime();
        if (timeout <= 0 || timeout <= maxIdleTime) {
            return;
        }
        this._endp.setMaxIdleTime(((int) timeout) * 2);
    }

    public boolean cancelIdleTimeout() {
        synchronized (this) {
            if (this._idle.compareAndSet(true, false)) {
                this._destination.getHttpClient().cancel(this._idleTimeout);
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        if (r5._parser.isState(1) != false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws IOException {
        HttpExchange httpExchange = this._exchange;
        if (httpExchange != null && !httpExchange.isDone()) {
            switch (httpExchange.getStatus()) {
                case 6:
                    if (this._endp.isInputShutdown()) {
                        break;
                    }
                    String httpExchange2 = httpExchange.toString();
                    String str = !this._endp.isOpen() ? this._endp.isInputShutdown() ? "half closed: " : "local close: " : "closed: ";
                    if (httpExchange.setStatus(9)) {
                        httpExchange.getEventListener().onException(new EofException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, httpExchange2)));
                        break;
                    }
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    break;
                default:
                    String httpExchange22 = httpExchange.toString();
                    if (!this._endp.isOpen()) {
                    }
                    if (httpExchange.setStatus(9)) {
                    }
                    break;
            }
        }
        if (this._endp.isOpen()) {
            this._endp.close();
            this._destination.returnConnection(this, true);
        }
    }

    public void commitRequest() throws IOException {
        HttpExchange httpExchange;
        synchronized (this) {
            this._status = 0;
            if (this._exchange.getStatus() != 2) {
                throw new IllegalStateException();
            }
            this._exchange.setStatus(3);
            this._generator.setVersion(this._exchange.getVersion());
            String method = this._exchange.getMethod();
            String requestURI = this._exchange.getRequestURI();
            if (this._destination.isProxied()) {
                if (!HttpMethods.CONNECT.equals(method) && requestURI.startsWith("/")) {
                    boolean isSecure = this._destination.isSecure();
                    String host = this._destination.getAddress().getHost();
                    int port = this._destination.getAddress().getPort();
                    StringBuilder sb = new StringBuilder();
                    sb.append(isSecure ? "https" : "http");
                    sb.append("://");
                    sb.append(host);
                    if ((!isSecure || port != 443) && (isSecure || port != 80)) {
                        sb.append(":");
                        sb.append(port);
                    }
                    sb.append(requestURI);
                    requestURI = sb.toString();
                }
                Authentication proxyAuthentication = this._destination.getProxyAuthentication();
                if (proxyAuthentication != null) {
                    proxyAuthentication.setCredentials(this._exchange);
                }
            }
            this._generator.setRequest(method, requestURI);
            this._parser.setHeadResponse("HEAD".equalsIgnoreCase(method));
            HttpFields requestFields = this._exchange.getRequestFields();
            if (this._exchange.getVersion() >= 11 && !requestFields.containsKey(HttpHeaders.HOST_BUFFER)) {
                requestFields.add(HttpHeaders.HOST_BUFFER, this._destination.getHostHeader());
            }
            Buffer requestContent = this._exchange.getRequestContent();
            if (requestContent != null) {
                requestFields.putLongField("Content-Length", requestContent.length());
                this._generator.completeHeader(requestFields, false);
                this._generator.addContent(new View(requestContent), true);
                httpExchange = this._exchange;
            } else if (this._exchange.getRequestContentSource() != null) {
                this._generator.completeHeader(requestFields, false);
            } else {
                requestFields.remove("Content-Length");
                this._generator.completeHeader(requestFields, true);
                httpExchange = this._exchange;
            }
            httpExchange.setStatus(4);
        }
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return AggregateLifeCycle.dump(this);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable appendable, String str) throws IOException {
        synchronized (this) {
            appendable.append(String.valueOf(this)).append("\n");
            AggregateLifeCycle.dump(appendable, str, Collections.singletonList(this._endp));
        }
    }

    public void exchangeExpired(HttpExchange httpExchange) {
        synchronized (this) {
            if (this._exchange == httpExchange) {
                try {
                    this._destination.returnConnection(this, true);
                } catch (IOException e) {
                    LOG.ignore(e);
                }
            }
        }
    }

    public HttpDestination getDestination() {
        return this._destination;
    }

    @Override // org.eclipse.jetty.p059io.Connection
    public abstract Connection handle() throws IOException;

    @Override // org.eclipse.jetty.p059io.Connection
    public boolean isIdle() {
        boolean z;
        synchronized (this) {
            z = this._exchange == null;
        }
        return z;
    }

    public boolean isReserved() {
        return this._reserved;
    }

    @Override // org.eclipse.jetty.p059io.Connection
    public boolean isSuspended() {
        return false;
    }

    @Override // org.eclipse.jetty.p059io.Connection
    public void onClose() {
    }

    public void reset() throws IOException {
        this._connectionHeader = null;
        this._parser.reset();
        this._generator.reset();
        this._http11 = true;
    }

    public boolean send(HttpExchange httpExchange) throws IOException {
        LOG.debug("Send {} on {}", httpExchange, this);
        synchronized (this) {
            if (this._exchange != null) {
                if (this._pipeline == null) {
                    this._pipeline = httpExchange;
                    return true;
                }
                throw new IllegalStateException(this + " PIPELINED!!!  _exchange=" + this._exchange);
            }
            this._exchange = httpExchange;
            this._exchange.associate(this);
            if (!this._endp.isOpen()) {
                this._exchange.disassociate();
                this._exchange = null;
                return false;
            }
            this._exchange.setStatus(2);
            adjustIdleTimeout();
            return true;
        }
    }

    public void setDestination(HttpDestination httpDestination) {
        this._destination = httpDestination;
    }

    public void setIdleTimeout() {
        synchronized (this) {
            if (!this._idle.compareAndSet(false, true)) {
                throw new IllegalStateException();
            }
            this._destination.getHttpClient().scheduleIdle(this._idleTimeout);
        }
    }

    public void setReserved(boolean z) {
        this._reserved = z;
    }

    public String toDetailString() {
        return toString() + " ex=" + this._exchange + " idle for " + this._idleTimeout.getAge();
    }

    @Override // org.eclipse.jetty.p059io.AbstractConnection
    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = super.toString();
        HttpDestination httpDestination = this._destination;
        objArr[1] = httpDestination == null ? "?.?.?.?:??" : httpDestination.getAddress();
        objArr[2] = this._generator;
        objArr[3] = this._parser;
        return String.format("%s %s g=%s p=%s", objArr);
    }
}
