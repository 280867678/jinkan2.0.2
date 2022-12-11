package org.fourthline.cling.protocol;

import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.transport.RouterException;
import org.seamless.util.Exceptions;

/* loaded from: classes5.dex */
public abstract class SendingAsync implements Runnable {
    public static final Logger log = Logger.getLogger(UpnpService.class.getName());
    public final UpnpService upnpService;

    public SendingAsync(UpnpService upnpService) {
        this.upnpService = upnpService;
    }

    public abstract void execute() throws RouterException;

    public UpnpService getUpnpService() {
        return this.upnpService;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            execute();
        } catch (Exception e) {
            Throwable unwrap = Exceptions.unwrap(e);
            if (!(unwrap instanceof InterruptedException)) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Fatal error while executing protocol '");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("': ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e);
                throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
            }
            Logger logger = log;
            Level level = Level.INFO;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Interrupted protocol '");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getClass().getSimpleName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("': ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e);
            logger.log(level, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), unwrap);
        }
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
