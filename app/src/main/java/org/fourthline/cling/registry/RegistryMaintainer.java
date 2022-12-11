package org.fourthline.cling.registry;

import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class RegistryMaintainer implements Runnable {
    public static Logger log = Logger.getLogger(RegistryMaintainer.class.getName());
    public final RegistryImpl registry;
    public final int sleepIntervalMillis;
    public volatile boolean stopped = false;

    public RegistryMaintainer(RegistryImpl registryImpl, int i) {
        this.registry = registryImpl;
        this.sleepIntervalMillis = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.stopped = false;
        if (log.isLoggable(Level.FINE)) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Running registry maintenance loop every milliseconds: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.sleepIntervalMillis);
            logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        while (!this.stopped) {
            try {
                this.registry.maintain();
                Thread.sleep(this.sleepIntervalMillis);
            } catch (InterruptedException unused) {
                this.stopped = true;
            }
        }
        log.fine("Stopped status on thread received, ending maintenance loop");
    }

    public void stop() {
        if (log.isLoggable(Level.FINE)) {
            log.fine("Setting stopped status on thread");
        }
        this.stopped = true;
    }
}
