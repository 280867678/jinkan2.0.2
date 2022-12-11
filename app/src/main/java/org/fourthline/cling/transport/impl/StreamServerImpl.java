package org.fourthline.cling.transport.impl;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.fourthline.cling.model.message.Connection;
import org.fourthline.cling.transport.Router;
import org.fourthline.cling.transport.spi.InitializationException;
import org.fourthline.cling.transport.spi.StreamServer;

/* loaded from: classes5.dex */
public class StreamServerImpl implements StreamServer<StreamServerConfigurationImpl> {
    public static Logger log = Logger.getLogger(StreamServer.class.getName());
    public final StreamServerConfigurationImpl configuration;
    public HttpServer server;

    /* loaded from: classes5.dex */
    public class HttpServerConnection implements Connection {
        public HttpExchange exchange;

        public HttpServerConnection(HttpExchange httpExchange) {
            this.exchange = httpExchange;
        }

        @Override // org.fourthline.cling.model.message.Connection
        public InetAddress getLocalAddress() {
            if (this.exchange.getLocalAddress() != null) {
                return this.exchange.getLocalAddress().getAddress();
            }
            return null;
        }

        @Override // org.fourthline.cling.model.message.Connection
        public InetAddress getRemoteAddress() {
            if (this.exchange.getRemoteAddress() != null) {
                return this.exchange.getRemoteAddress().getAddress();
            }
            return null;
        }

        @Override // org.fourthline.cling.model.message.Connection
        public boolean isOpen() {
            return StreamServerImpl.this.isConnectionOpen(this.exchange);
        }
    }

    /* loaded from: classes5.dex */
    public class RequestHttpHandler implements HttpHandler {
        public final Router router;

        public RequestHttpHandler(Router router) {
            this.router = router;
        }

        public void handle(final HttpExchange httpExchange) throws IOException {
            Logger logger = StreamServerImpl.log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Received HTTP exchange: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(httpExchange.getRequestMethod());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(httpExchange.getRequestURI());
            logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            this.router.received(new HttpExchangeUpnpStream(this.router.getProtocolFactory(), httpExchange) { // from class: org.fourthline.cling.transport.impl.StreamServerImpl.RequestHttpHandler.1
                @Override // org.fourthline.cling.transport.impl.HttpExchangeUpnpStream
                public Connection createConnection() {
                    return new HttpServerConnection(httpExchange);
                }
            });
        }
    }

    public StreamServerImpl(StreamServerConfigurationImpl streamServerConfigurationImpl) {
        this.configuration = streamServerConfigurationImpl;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.fourthline.cling.transport.spi.StreamServer
    /* renamed from: getConfiguration */
    public StreamServerConfigurationImpl mo5229getConfiguration() {
        return this.configuration;
    }

    @Override // org.fourthline.cling.transport.spi.StreamServer
    public synchronized int getPort() {
        return this.server.getAddress().getPort();
    }

    @Override // org.fourthline.cling.transport.spi.StreamServer
    public synchronized void init(InetAddress inetAddress, Router router) throws InitializationException {
        try {
            HttpServer create = HttpServer.create(new InetSocketAddress(inetAddress, this.configuration.getListenPort()), this.configuration.getTcpConnectionBacklog());
            this.server = create;
            create.createContext("/", new RequestHttpHandler(router));
            Logger logger = log;
            logger.info("Created server (for receiving TCP streams) on: " + this.server.getAddress());
        } catch (Exception e) {
            throw new InitializationException("Could not initialize " + getClass().getSimpleName() + ": " + e.toString(), e);
        }
    }

    public boolean isConnectionOpen(HttpExchange httpExchange) {
        log.warning("Can't check client connection, socket access impossible on JDK webserver!");
        return true;
    }

    @Override // java.lang.Runnable
    public synchronized void run() {
        log.fine("Starting StreamServer...");
        this.server.start();
    }

    @Override // org.fourthline.cling.transport.spi.StreamServer
    public synchronized void stop() {
        log.fine("Stopping StreamServer...");
        if (this.server != null) {
            this.server.stop(1);
        }
    }
}
