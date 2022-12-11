package org.fourthline.cling.transport.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.fourthline.cling.model.message.Connection;
import org.fourthline.cling.transport.Router;
import org.fourthline.cling.transport.spi.InitializationException;
import org.fourthline.cling.transport.spi.StreamServer;

/* loaded from: classes5.dex */
public class AsyncServletStreamServerImpl implements StreamServer<AsyncServletStreamServerConfigurationImpl> {
    public static final Logger log = Logger.getLogger(StreamServer.class.getName());
    public final AsyncServletStreamServerConfigurationImpl configuration;
    public String hostAddress;
    public int localPort;
    public int mCounter = 0;

    /* loaded from: classes5.dex */
    public class AsyncServletConnection implements Connection {
        public ae0 request;

        public AsyncServletConnection(ae0 ae0Var) {
            this.request = ae0Var;
        }

        @Override // org.fourthline.cling.model.message.Connection
        public InetAddress getLocalAddress() {
            try {
                return InetAddress.getByName(getRequest().getLocalAddr());
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // org.fourthline.cling.model.message.Connection
        public InetAddress getRemoteAddress() {
            try {
                return InetAddress.getByName(getRequest().getRemoteAddr());
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }

        public ae0 getRequest() {
            return this.request;
        }

        @Override // org.fourthline.cling.model.message.Connection
        public boolean isOpen() {
            return AsyncServletStreamServerImpl.this.isConnectionOpen(getRequest());
        }
    }

    public AsyncServletStreamServerImpl(AsyncServletStreamServerConfigurationImpl asyncServletStreamServerConfigurationImpl) {
        this.configuration = asyncServletStreamServerConfigurationImpl;
    }

    public static /* synthetic */ int access$008(AsyncServletStreamServerImpl asyncServletStreamServerImpl) {
        int i = asyncServletStreamServerImpl.mCounter;
        asyncServletStreamServerImpl.mCounter = i + 1;
        return i;
    }

    public Servlet createServlet(final Router router) {
        return new HttpServlet() { // from class: org.fourthline.cling.transport.impl.AsyncServletStreamServerImpl.1
            @Override // javax.servlet.http.HttpServlet
            public void service(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
                final long currentTimeMillis = System.currentTimeMillis();
                final int access$008 = AsyncServletStreamServerImpl.access$008(AsyncServletStreamServerImpl.this);
                if (AsyncServletStreamServerImpl.log.isLoggable(Level.FINE)) {
                    AsyncServletStreamServerImpl.log.fine(String.format("HttpServlet.service(): id: %3d, request URI: %s", Integer.valueOf(access$008), ae0Var.getRequestURI()));
                }
                AsyncContext startAsync = ae0Var.startAsync();
                startAsync.setTimeout(AsyncServletStreamServerImpl.this.mo5229getConfiguration().getAsyncTimeoutSeconds() * 1000);
                startAsync.addListener(new AsyncListener() { // from class: org.fourthline.cling.transport.impl.AsyncServletStreamServerImpl.1.1
                    @Override // javax.servlet.AsyncListener
                    public void onComplete(AsyncEvent asyncEvent) throws IOException {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (AsyncServletStreamServerImpl.log.isLoggable(Level.FINE)) {
                            AsyncServletStreamServerImpl.log.fine(String.format("AsyncListener.onComplete(): id: %3d, duration: %,4d, response: %s", Integer.valueOf(access$008), Long.valueOf(currentTimeMillis2), asyncEvent.getSuppliedResponse()));
                        }
                    }

                    @Override // javax.servlet.AsyncListener
                    public void onError(AsyncEvent asyncEvent) throws IOException {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (AsyncServletStreamServerImpl.log.isLoggable(Level.FINE)) {
                            AsyncServletStreamServerImpl.log.fine(String.format("AsyncListener.onError(): id: %3d, duration: %,4d, response: %s", Integer.valueOf(access$008), Long.valueOf(currentTimeMillis2), asyncEvent.getSuppliedResponse()));
                        }
                    }

                    @Override // javax.servlet.AsyncListener
                    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                        if (AsyncServletStreamServerImpl.log.isLoggable(Level.FINE)) {
                            AsyncServletStreamServerImpl.log.fine(String.format("AsyncListener.onStartAsync(): id: %3d, request: %s", Integer.valueOf(access$008), asyncEvent.getSuppliedRequest()));
                        }
                    }

                    @Override // javax.servlet.AsyncListener
                    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (AsyncServletStreamServerImpl.log.isLoggable(Level.FINE)) {
                            AsyncServletStreamServerImpl.log.fine(String.format("AsyncListener.onTimeout(): id: %3d, duration: %,4d, request: %s", Integer.valueOf(access$008), Long.valueOf(currentTimeMillis2), asyncEvent.getSuppliedRequest()));
                        }
                    }
                });
                router.received(new AsyncServletUpnpStream(router.getProtocolFactory(), startAsync, ae0Var) { // from class: org.fourthline.cling.transport.impl.AsyncServletStreamServerImpl.1.2
                    @Override // org.fourthline.cling.transport.impl.AsyncServletUpnpStream
                    public Connection createConnection() {
                        return new AsyncServletConnection(getRequest());
                    }
                });
            }
        };
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.fourthline.cling.transport.spi.StreamServer
    /* renamed from: getConfiguration */
    public AsyncServletStreamServerConfigurationImpl mo5229getConfiguration() {
        return this.configuration;
    }

    @Override // org.fourthline.cling.transport.spi.StreamServer
    public synchronized int getPort() {
        return this.localPort;
    }

    @Override // org.fourthline.cling.transport.spi.StreamServer
    public synchronized void init(InetAddress inetAddress, Router router) throws InitializationException {
        try {
            if (log.isLoggable(Level.FINE)) {
                log.fine("Setting executor service on servlet container adapter");
            }
            mo5229getConfiguration().getServletContainerAdapter().setExecutorService(router.getConfiguration().getStreamServerExecutorService());
            if (log.isLoggable(Level.FINE)) {
                Logger logger = log;
                logger.fine("Adding connector: " + inetAddress + ":" + mo5229getConfiguration().getListenPort());
            }
            this.hostAddress = inetAddress.getHostAddress();
            this.localPort = mo5229getConfiguration().getServletContainerAdapter().addConnector(this.hostAddress, mo5229getConfiguration().getListenPort());
            mo5229getConfiguration().getServletContainerAdapter().registerServlet(router.getConfiguration().getNamespace().getBasePath().getPath(), createServlet(router));
        } catch (Exception e) {
            throw new InitializationException("Could not initialize " + getClass().getSimpleName() + ": " + e.toString(), e);
        }
    }

    public boolean isConnectionOpen(ae0 ae0Var) {
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        mo5229getConfiguration().getServletContainerAdapter().startIfNotRunning();
    }

    @Override // org.fourthline.cling.transport.spi.StreamServer
    public synchronized void stop() {
        mo5229getConfiguration().getServletContainerAdapter().removeConnector(this.hostAddress, this.localPort);
    }
}
