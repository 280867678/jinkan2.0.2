package org.apache.commons.lang3.concurrent;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class TimedSemaphore {
    public static final int NO_LIMIT = 0;
    public static final int THREAD_POOL_SIZE = 1;
    public int acquireCount;
    public final ScheduledExecutorService executorService;
    public int lastCallsPerPeriod;
    public int limit;
    public final boolean ownExecutor;
    public final long period;
    public long periodCount;
    public boolean shutdown;
    public ScheduledFuture<?> task;
    public long totalAcquireCount;
    public final TimeUnit unit;

    public TimedSemaphore(long j, TimeUnit timeUnit, int i) {
        this(null, j, timeUnit, i);
    }

    public TimedSemaphore(ScheduledExecutorService scheduledExecutorService, long j, TimeUnit timeUnit, int i) {
        if (j > 0) {
            this.period = j;
            this.unit = timeUnit;
            if (scheduledExecutorService != null) {
                this.executorService = scheduledExecutorService;
                this.ownExecutor = false;
            } else {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
                scheduledThreadPoolExecutor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
                scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
                this.executorService = scheduledThreadPoolExecutor;
                this.ownExecutor = true;
            }
            setLimit(i);
            return;
        }
        throw new IllegalArgumentException("Time period must be greater 0!");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0026 A[Catch: all -> 0x003b, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000b, B:9:0x0011, B:11:0x0018, B:16:0x0026, B:23:0x002a, B:26:0x0033, B:27:0x003a), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x002a A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000b, B:9:0x0011, B:11:0x0018, B:16:0x0026, B:23:0x002a, B:26:0x0033, B:27:0x003a), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void acquire() throws InterruptedException {
        boolean z;
        if (isShutdown()) {
            throw new IllegalStateException("TimedSemaphore is shut down!");
        }
        if (this.task == null) {
            this.task = startTimer();
        }
        do {
            if (getLimit() > 0 && this.acquireCount >= getLimit()) {
                z = false;
                if (z) {
                    wait();
                    continue;
                } else {
                    this.acquireCount++;
                    continue;
                }
            }
            z = true;
            if (z) {
            }
        } while (!z);
    }

    public synchronized void endOfPeriod() {
        this.lastCallsPerPeriod = this.acquireCount;
        this.totalAcquireCount += this.acquireCount;
        this.periodCount++;
        this.acquireCount = 0;
        notifyAll();
    }

    public synchronized int getAcquireCount() {
        return this.acquireCount;
    }

    public synchronized int getAvailablePermits() {
        return getLimit() - getAcquireCount();
    }

    public synchronized double getAverageCallsPerPeriod() {
        double d;
        if (this.periodCount == 0) {
            d = RoundRectDrawableWithShadow.COS_45;
        } else {
            d = this.totalAcquireCount / this.periodCount;
        }
        return d;
    }

    public ScheduledExecutorService getExecutorService() {
        return this.executorService;
    }

    public synchronized int getLastAcquiresPerPeriod() {
        return this.lastCallsPerPeriod;
    }

    public final synchronized int getLimit() {
        return this.limit;
    }

    public long getPeriod() {
        return this.period;
    }

    public TimeUnit getUnit() {
        return this.unit;
    }

    public synchronized boolean isShutdown() {
        return this.shutdown;
    }

    public final synchronized void setLimit(int i) {
        this.limit = i;
    }

    public synchronized void shutdown() {
        if (!this.shutdown) {
            if (this.ownExecutor) {
                getExecutorService().shutdownNow();
            }
            if (this.task != null) {
                this.task.cancel(false);
            }
            this.shutdown = true;
        }
    }

    public ScheduledFuture<?> startTimer() {
        return getExecutorService().scheduleAtFixedRate(new Runnable() { // from class: org.apache.commons.lang3.concurrent.TimedSemaphore.1
            @Override // java.lang.Runnable
            public void run() {
                TimedSemaphore.this.endOfPeriod();
            }
        }, getPeriod(), getPeriod(), getUnit());
    }
}
