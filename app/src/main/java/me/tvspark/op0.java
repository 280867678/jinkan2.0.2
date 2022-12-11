package me.tvspark;

import java.util.logging.Logger;
import me.tvspark.utils.cast.service.upnp.AudioResourceServlet;
import me.tvspark.utils.cast.service.upnp.ImageResourceServlet;
import me.tvspark.utils.cast.service.upnp.VideoResourceServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/* loaded from: classes4.dex */
public class op0 implements Runnable {
    public static final Logger Wwwwwwwwwwwwwwwwwwwwwww = Logger.getLogger(op0.class.getName());
    public Server Wwwwwwwwwwwwwwwwwwwwwwww;

    public op0() {
        Server server = new Server(8289);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = server;
        server.setGracefulShutdown(1000);
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwww.isStopped() && !this.Wwwwwwwwwwwwwwwwwwwwwwww.isStopping()) {
            Wwwwwwwwwwwwwwwwwwwwwww.info("Stopping JettyResourceServer");
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.stop();
            } catch (Exception e) {
                Logger logger = Wwwwwwwwwwwwwwwwwwwwwww;
                logger.severe("Couldn't stop Jetty server: " + e);
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwww.isStarted() && !this.Wwwwwwwwwwwwwwwwwwwwwwww.isStarting()) {
            Wwwwwwwwwwwwwwwwwwwwwww.info("Starting JettyResourceServer");
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.start();
            } catch (Exception e) {
                Logger logger = Wwwwwwwwwwwwwwwwwwwwwww;
                logger.severe("Couldn't start Jetty server: " + e);
                throw new RuntimeException(e);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.setContextPath("/");
        servletContextHandler.setInitParameter("org.eclipse.jetty.servlet.Default.gzip", "false");
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setHandler(servletContextHandler);
        servletContextHandler.addServlet(AudioResourceServlet.class, "/audio/*");
        servletContextHandler.addServlet(ImageResourceServlet.class, "/image/*");
        servletContextHandler.addServlet(VideoResourceServlet.class, "/video/*");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
