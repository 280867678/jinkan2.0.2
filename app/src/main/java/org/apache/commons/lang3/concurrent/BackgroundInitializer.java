package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes4.dex */
public abstract class BackgroundInitializer<T> implements ConcurrentInitializer<T> {
    public ExecutorService executor;
    public ExecutorService externalExecutor;
    public Future<T> future;

    /* loaded from: classes4.dex */
    public class InitializationTask implements Callable<T> {
        public final ExecutorService execFinally;

        public InitializationTask(ExecutorService executorService) {
            this.execFinally = executorService;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            try {
                return (T) BackgroundInitializer.this.initialize();
            } finally {
                ExecutorService executorService = this.execFinally;
                if (executorService != null) {
                    executorService.shutdown();
                }
            }
        }
    }

    public BackgroundInitializer() {
        this(null);
    }

    public BackgroundInitializer(ExecutorService executorService) {
        setExternalExecutor(executorService);
    }

    private ExecutorService createExecutor() {
        return Executors.newFixedThreadPool(getTaskCount());
    }

    private Callable<T> createTask(ExecutorService executorService) {
        return new InitializationTask(executorService);
    }

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        try {
            return getFuture().get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ConcurrentException(e);
        } catch (ExecutionException e2) {
            ConcurrentUtils.handleCause(e2);
            return null;
        }
    }

    public final synchronized ExecutorService getActiveExecutor() {
        return this.executor;
    }

    public final synchronized ExecutorService getExternalExecutor() {
        return this.externalExecutor;
    }

    public synchronized Future<T> getFuture() {
        if (this.future == null) {
            throw new IllegalStateException("start() must be called first!");
        }
        return this.future;
    }

    public int getTaskCount() {
        return 1;
    }

    public abstract T initialize() throws Exception;

    public synchronized boolean isStarted() {
        return this.future != null;
    }

    public final synchronized void setExternalExecutor(ExecutorService executorService) {
        if (isStarted()) {
            throw new IllegalStateException("Cannot set ExecutorService after start()!");
        }
        this.externalExecutor = executorService;
    }

    public synchronized boolean start() {
        boolean z;
        ExecutorService executorService;
        if (!isStarted()) {
            ExecutorService externalExecutor = getExternalExecutor();
            this.executor = externalExecutor;
            if (externalExecutor == null) {
                executorService = createExecutor();
                this.executor = executorService;
            } else {
                executorService = null;
            }
            this.future = this.executor.submit(createTask(executorService));
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
