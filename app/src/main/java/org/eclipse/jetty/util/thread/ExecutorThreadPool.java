package org.eclipse.jetty.util.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class ExecutorThreadPool extends AbstractLifeCycle implements ThreadPool, LifeCycle {
    public static final Logger LOG = Log.getLogger(ExecutorThreadPool.class);
    public final ExecutorService _executor;

    public ExecutorThreadPool() {
        this(new ThreadPoolExecutor(256, 256, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue()));
    }

    public ExecutorThreadPool(int i) {
        this(i < 0 ? new ThreadPoolExecutor(256, 256, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue()) : i == 0 ? new ThreadPoolExecutor(32, 256, 60L, TimeUnit.SECONDS, new SynchronousQueue()) : new ThreadPoolExecutor(32, 256, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue(i)));
    }

    public ExecutorThreadPool(int i, int i2, long j) {
        this(i, i2, j, TimeUnit.MILLISECONDS);
    }

    public ExecutorThreadPool(int i, int i2, long j, TimeUnit timeUnit) {
        this(i, i2, j, timeUnit, new LinkedBlockingQueue());
    }

    public ExecutorThreadPool(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        this(new ThreadPoolExecutor(i, i2, j, timeUnit, blockingQueue));
    }

    public ExecutorThreadPool(ExecutorService executorService) {
        this._executor = executorService;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    public boolean dispatch(Runnable runnable) {
        try {
            this._executor.execute(runnable);
            return true;
        } catch (RejectedExecutionException e) {
            LOG.warn(e);
            return false;
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        super.doStop();
        this._executor.shutdownNow();
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    public int getIdleThreads() {
        ExecutorService executorService = this._executor;
        if (executorService instanceof ThreadPoolExecutor) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
            return threadPoolExecutor.getPoolSize() - threadPoolExecutor.getActiveCount();
        }
        return -1;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    public int getThreads() {
        ExecutorService executorService = this._executor;
        if (executorService instanceof ThreadPoolExecutor) {
            return ((ThreadPoolExecutor) executorService).getPoolSize();
        }
        return -1;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    public boolean isLowOnThreads() {
        ExecutorService executorService = this._executor;
        if (executorService instanceof ThreadPoolExecutor) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
            return threadPoolExecutor.getPoolSize() == threadPoolExecutor.getMaximumPoolSize() && threadPoolExecutor.getQueue().size() >= threadPoolExecutor.getPoolSize() - threadPoolExecutor.getActiveCount();
        }
        return false;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    public void join() throws InterruptedException {
        this._executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }
}
