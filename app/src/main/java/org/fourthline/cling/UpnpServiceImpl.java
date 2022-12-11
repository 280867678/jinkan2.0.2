package org.fourthline.cling;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.inject.Alternative;
import me.tvspark.outline;
import org.fourthline.cling.controlpoint.ControlPoint;
import org.fourthline.cling.controlpoint.ControlPointImpl;
import org.fourthline.cling.protocol.ProtocolFactory;
import org.fourthline.cling.protocol.ProtocolFactoryImpl;
import org.fourthline.cling.registry.Registry;
import org.fourthline.cling.registry.RegistryImpl;
import org.fourthline.cling.registry.RegistryListener;
import org.fourthline.cling.transport.Router;
import org.fourthline.cling.transport.RouterException;
import org.fourthline.cling.transport.RouterImpl;
import org.seamless.util.Exceptions;

@Alternative
/* loaded from: classes5.dex */
public class UpnpServiceImpl implements UpnpService {
    public static Logger log = Logger.getLogger(UpnpServiceImpl.class.getName());
    public final UpnpServiceConfiguration configuration;
    public final ControlPoint controlPoint;
    public final ProtocolFactory protocolFactory;
    public final Registry registry;
    public final Router router;

    public UpnpServiceImpl() {
        this(new DefaultUpnpServiceConfiguration(), new RegistryListener[0]);
    }

    public UpnpServiceImpl(UpnpServiceConfiguration upnpServiceConfiguration, RegistryListener... registryListenerArr) {
        this.configuration = upnpServiceConfiguration;
        log.info(">>> Starting UPnP service...");
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Using configuration: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getConfiguration().getClass().getName());
        logger.info(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        ProtocolFactory createProtocolFactory = createProtocolFactory();
        this.protocolFactory = createProtocolFactory;
        this.registry = createRegistry(createProtocolFactory);
        for (RegistryListener registryListener : registryListenerArr) {
            this.registry.addListener(registryListener);
        }
        Router createRouter = createRouter(this.protocolFactory, this.registry);
        this.router = createRouter;
        try {
            createRouter.enable();
            this.controlPoint = createControlPoint(this.protocolFactory, this.registry);
            log.info("<<< UPnP service started successfully");
        } catch (RouterException e) {
            throw new RuntimeException("Enabling network router failed: " + e, e);
        }
    }

    public UpnpServiceImpl(RegistryListener... registryListenerArr) {
        this(new DefaultUpnpServiceConfiguration(), registryListenerArr);
    }

    public ControlPoint createControlPoint(ProtocolFactory protocolFactory, Registry registry) {
        return new ControlPointImpl(getConfiguration(), protocolFactory, registry);
    }

    public ProtocolFactory createProtocolFactory() {
        return new ProtocolFactoryImpl(this);
    }

    public Registry createRegistry(ProtocolFactory protocolFactory) {
        return new RegistryImpl(this);
    }

    public Router createRouter(ProtocolFactory protocolFactory, Registry registry) {
        return new RouterImpl(getConfiguration(), protocolFactory);
    }

    @Override // org.fourthline.cling.UpnpService
    public UpnpServiceConfiguration getConfiguration() {
        return this.configuration;
    }

    @Override // org.fourthline.cling.UpnpService
    public ControlPoint getControlPoint() {
        return this.controlPoint;
    }

    @Override // org.fourthline.cling.UpnpService
    public ProtocolFactory getProtocolFactory() {
        return this.protocolFactory;
    }

    @Override // org.fourthline.cling.UpnpService
    public Registry getRegistry() {
        return this.registry;
    }

    @Override // org.fourthline.cling.UpnpService
    /* renamed from: getRouter */
    public Router mo5192getRouter() {
        return this.router;
    }

    @Override // org.fourthline.cling.UpnpService
    public synchronized void shutdown() {
        shutdown(false);
    }

    public void shutdown(boolean z) {
        Runnable runnable = new Runnable() { // from class: org.fourthline.cling.UpnpServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                UpnpServiceImpl.log.info(">>> Shutting down UPnP service...");
                UpnpServiceImpl.this.shutdownRegistry();
                UpnpServiceImpl.this.shutdownRouter();
                UpnpServiceImpl.this.shutdownConfiguration();
                UpnpServiceImpl.log.info("<<< UPnP service shutdown completed");
            }
        };
        if (z) {
            new Thread(runnable).start();
        } else {
            runnable.run();
        }
    }

    public void shutdownConfiguration() {
        getConfiguration().shutdown();
    }

    public void shutdownRegistry() {
        getRegistry().shutdown();
    }

    public void shutdownRouter() {
        Logger logger;
        Level level;
        StringBuilder sb;
        String str;
        try {
            mo5192getRouter().shutdown();
        } catch (RouterException e) {
            Throwable unwrap = Exceptions.unwrap(e);
            if (unwrap instanceof InterruptedException) {
                logger = log;
                level = Level.INFO;
                sb = new StringBuilder();
                str = "Router shutdown was interrupted: ";
            } else {
                logger = log;
                level = Level.SEVERE;
                sb = new StringBuilder();
                str = "Router error on shutdown: ";
            }
            sb.append(str);
            sb.append(e);
            logger.log(level, sb.toString(), unwrap);
        }
    }
}
