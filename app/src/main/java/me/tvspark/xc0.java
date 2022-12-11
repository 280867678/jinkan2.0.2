package me.tvspark;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes4.dex */
public final class xc0 implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            Iterator it = new ArrayList(yc0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    yc0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }
}
