package org.fourthline.cling.protocol;

import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.message.UpnpMessage;
import org.fourthline.cling.model.message.header.UpnpHeader;
import org.fourthline.cling.transport.RouterException;
import org.seamless.util.Exceptions;

/* loaded from: classes5.dex */
public abstract class ReceivingAsync<M extends UpnpMessage> implements Runnable {
    public static final Logger log = Logger.getLogger(UpnpService.class.getName());
    public M inputMessage;
    public final UpnpService upnpService;

    public ReceivingAsync(UpnpService upnpService, M m) {
        this.upnpService = upnpService;
        this.inputMessage = m;
    }

    public abstract void execute() throws RouterException;

    public <H extends UpnpHeader> H getFirstHeader(UpnpHeader.Type type, Class<H> cls) {
        return (H) getInputMessage().getHeaders().getFirstHeader(type, cls);
    }

    public M getInputMessage() {
        return this.inputMessage;
    }

    public UpnpService getUpnpService() {
        return this.upnpService;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        try {
            z = waitBeforeExecution();
        } catch (InterruptedException unused) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Protocol wait before execution interrupted (on shutdown?): ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
            logger.info(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            z = false;
        }
        if (z) {
            try {
                execute();
            } catch (Exception e) {
                Throwable unwrap = Exceptions.unwrap(e);
                if (!(unwrap instanceof InterruptedException)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Fatal error while executing protocol '");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getClass().getSimpleName());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("': ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e);
                    throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), e);
                }
                Logger logger2 = log;
                Level level = Level.INFO;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Interrupted protocol '");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(getClass().getSimpleName());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("': ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(e);
                logger2.log(level, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), unwrap);
            }
        }
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public boolean waitBeforeExecution() throws InterruptedException {
        return true;
    }
}
