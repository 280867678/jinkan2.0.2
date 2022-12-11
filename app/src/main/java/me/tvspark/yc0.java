package me.tvspark;

import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class yc0 {
    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final AtomicReference<ScheduledExecutorService> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();
    public static final Map<ScheduledThreadPoolExecutor, Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ConcurrentHashMap();

    static {
        Properties properties = System.getProperties();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (!properties.containsKey("rx2.purge-enabled") || !Boolean.getBoolean("rx2.purge-enabled") || !properties.containsKey("rx2.purge-period-seconds")) ? 1 : Integer.getInteger("rx2.purge-period-seconds", 1).intValue();
        while (true) {
            ScheduledExecutorService scheduledExecutorService = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get();
            if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                    xc0 xc0Var = new xc0();
                    long j = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    newScheduledThreadPool.scheduleAtFixedRate(xc0Var, j, j, TimeUnit.SECONDS);
                    return;
                }
                newScheduledThreadPool.shutdownNow();
            } else {
                return;
            }
        }
    }

    public static ScheduledExecutorService Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        return newScheduledThreadPool;
    }
}
