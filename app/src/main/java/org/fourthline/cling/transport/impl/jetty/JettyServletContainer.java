package org.fourthline.cling.transport.impl.jetty;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Servlet;
import me.tvspark.ae0;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.ExecutorThreadPool;
import org.fourthline.cling.transport.spi.ServletContainerAdapter;

/* loaded from: classes5.dex */
public class JettyServletContainer implements ServletContainerAdapter {
    public Server server;
    public static final Logger log = Logger.getLogger(JettyServletContainer.class.getName());
    public static final JettyServletContainer INSTANCE = new JettyServletContainer();

    public JettyServletContainer() {
        resetServer();
    }

    public static boolean isConnectionOpen(ae0 ae0Var) {
        return isConnectionOpen(ae0Var, StringUtils.SPACE.getBytes());
    }

    public static boolean isConnectionOpen(ae0 ae0Var, byte[] bArr) {
        Socket socket = (Socket) ((Request) ae0Var).getConnection().getEndPoint().getTransport();
        if (log.isLoggable(Level.FINE)) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Checking if client connection is still open: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(socket.getRemoteSocketAddress());
            logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        try {
            socket.getOutputStream().write(bArr);
            socket.getOutputStream().flush();
            return true;
        } catch (IOException unused) {
            if (!log.isLoggable(Level.FINE)) {
                return false;
            }
            Logger logger2 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Client connection has been closed: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(socket.getRemoteSocketAddress());
            logger2.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            return false;
        }
    }

    @Override // org.fourthline.cling.transport.spi.ServletContainerAdapter
    public synchronized int addConnector(String str, int i) throws IOException {
        SocketConnector socketConnector;
        socketConnector = new SocketConnector();
        socketConnector.setHost(str);
        socketConnector.setPort(i);
        socketConnector.open();
        this.server.addConnector(socketConnector);
        if (this.server.isStarted()) {
            try {
                socketConnector.start();
            } catch (Exception e) {
                Logger logger = log;
                logger.severe("Couldn't start connector: " + socketConnector + StringUtils.SPACE + e);
                throw new RuntimeException(e);
            }
        }
        return socketConnector.getLocalPort();
    }

    @Override // org.fourthline.cling.transport.spi.ServletContainerAdapter
    public synchronized void registerServlet(String str, Servlet servlet) {
        if (this.server.getHandler() != null) {
            return;
        }
        Logger logger = log;
        logger.info("Registering UPnP servlet under context path: " + str);
        ServletContextHandler servletContextHandler = new ServletContextHandler(0);
        if (str != null && str.length() > 0) {
            servletContextHandler.setContextPath(str);
        }
        servletContextHandler.addServlet(new ServletHolder(servlet), "/*");
        this.server.setHandler(servletContextHandler);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r3.isStarted() != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r3.isStarting() == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        r5.server.removeConnector(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (r0.length != 1) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
        org.fourthline.cling.transport.impl.jetty.JettyServletContainer.log.info("No more connectors, stopping Jetty server");
        stopIfRunning();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0029, code lost:
        r3.stop();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
        r7 = org.fourthline.cling.transport.impl.jetty.JettyServletContainer.log;
        r7.severe("Couldn't stop connector: " + r3 + org.apache.commons.lang3.StringUtils.SPACE + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
        throw new java.lang.RuntimeException(r6);
     */
    @Override // org.fourthline.cling.transport.spi.ServletContainerAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void removeConnector(String str, int i) {
        Connector[] connectors = this.server.getConnectors();
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

    public void resetServer() {
        Server server = new Server();
        this.server = server;
        server.setGracefulShutdown(1000);
    }

    @Override // org.fourthline.cling.transport.spi.ServletContainerAdapter
    public synchronized void setExecutorService(ExecutorService executorService) {
        if (INSTANCE.server.getThreadPool() == null) {
            INSTANCE.server.setThreadPool(new ExecutorThreadPool(executorService) { // from class: org.fourthline.cling.transport.impl.jetty.JettyServletContainer.1
                @Override // org.eclipse.jetty.util.thread.ExecutorThreadPool, org.eclipse.jetty.util.component.AbstractLifeCycle
                public void doStop() throws Exception {
                }
            });
        }
    }

    @Override // org.fourthline.cling.transport.spi.ServletContainerAdapter
    public synchronized void startIfNotRunning() {
        if (!this.server.isStarted() && !this.server.isStarting()) {
            log.info("Starting Jetty server... ");
            try {
                this.server.start();
            } catch (Exception e) {
                Logger logger = log;
                logger.severe("Couldn't start Jetty server: " + e);
                throw new RuntimeException(e);
            }
        }
    }

    @Override // org.fourthline.cling.transport.spi.ServletContainerAdapter
    public synchronized void stopIfRunning() {
        if (!this.server.isStopped() && !this.server.isStopping()) {
            log.info("Stopping Jetty server...");
            try {
                this.server.stop();
                resetServer();
            } catch (Exception e) {
                Logger logger = log;
                logger.severe("Couldn't stop Jetty server: " + e);
                throw new RuntimeException(e);
            }
        }
    }
}
