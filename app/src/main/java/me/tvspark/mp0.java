package me.tvspark;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;
import javax.servlet.Servlet;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.ExecutorThreadPool;
import org.fourthline.cling.transport.spi.ServletContainerAdapter;

/* loaded from: classes4.dex */
public class mp0 implements ServletContainerAdapter {
    public Server Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Logger Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Logger.getLogger(mp0.class.getName());
    public static final mp0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new mp0();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends ExecutorThreadPool {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mp0 mp0Var, ExecutorService executorService) {
            super(executorService);
        }

        @Override // org.eclipse.jetty.util.thread.ExecutorThreadPool, org.eclipse.jetty.util.component.AbstractLifeCycle
        public void doStop() throws Exception {
        }
    }

    public mp0() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Server server = new Server();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = server;
        server.setGracefulShutdown(1000);
    }

    @Override // org.fourthline.cling.transport.spi.ServletContainerAdapter
    public synchronized int addConnector(String str, int i) throws IOException {
        SocketConnector socketConnector;
        socketConnector = new SocketConnector();
        socketConnector.setHost(str);
        socketConnector.setPort(i);
        socketConnector.open();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addConnector(socketConnector);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isStarted()) {
            try {
                socketConnector.start();
            } catch (Exception e) {
                Logger logger = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                logger.severe("Couldn't start connector: " + socketConnector + StringUtils.SPACE + e);
                throw new RuntimeException(e);
            }
        }
        return socketConnector.getLocalPort();
    }

    @Override // org.fourthline.cling.transport.spi.ServletContainerAdapter
    public synchronized void registerServlet(String str, Servlet servlet) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getHandler() != null) {
            return;
        }
        Logger logger = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        logger.info("Registering UPnP servlet under context path: " + str);
        ServletContextHandler servletContextHandler = new ServletContextHandler(0);
        if (str != null && str.length() > 0) {
            servletContextHandler.setContextPath(str);
        }
        servletContextHandler.addServlet(new ServletHolder(servlet), "/*");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setHandler(servletContextHandler);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
        if (r3.isStarted() != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
        if (r3.isStarting() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
        r5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeConnector(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
        if (r0.length != 1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
        me.tvspark.mp0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.info("No more connectors, stopping Jetty server");
        stopIfRunning();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x002d, code lost:
        r3.stop();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0045, code lost:
        r7 = me.tvspark.mp0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        r7.severe("Couldn't stop connector: " + r3 + org.apache.commons.lang3.StringUtils.SPACE + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0068, code lost:
        throw new java.lang.RuntimeException(r6);
     */
    @Override // org.fourthline.cling.transport.spi.ServletContainerAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void removeConnector(String str, int i) {
        Connector[] connectors = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getConnectors();
        if (connectors == null) {
            return;
        }
        int length = connectors.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            Connector connector = connectors[i2];
            if (connector.getHost().equals(str) && connector.getLocalPort() == i) {
                break;
            }
            i2++;
        }
    }

    @Override // org.fourthline.cling.transport.spi.ServletContainerAdapter
    public synchronized void setExecutorService(ExecutorService executorService) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getThreadPool() == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setThreadPool(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, executorService));
        }
    }

    @Override // org.fourthline.cling.transport.spi.ServletContainerAdapter
    public synchronized void startIfNotRunning() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isStarted() && !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isStarting()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.info("Starting Jetty server... ");
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.start();
            } catch (Exception e) {
                Logger logger = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                logger.severe("Couldn't start Jetty server: " + e);
                throw new RuntimeException(e);
            }
        }
    }

    @Override // org.fourthline.cling.transport.spi.ServletContainerAdapter
    public synchronized void stopIfRunning() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isStopped() && !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isStopping()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.info("Stopping Jetty server...");
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.stop();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } catch (Exception e) {
                Logger logger = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                logger.severe("Couldn't stop Jetty server: " + e);
                throw new RuntimeException(e);
            }
        }
    }
}
