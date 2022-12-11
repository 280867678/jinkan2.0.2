package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public class CallableBackgroundInitializer<T> extends BackgroundInitializer<T> {
    public final Callable<T> callable;

    public CallableBackgroundInitializer(Callable<T> callable) {
        checkCallable(callable);
        this.callable = callable;
    }

    public CallableBackgroundInitializer(Callable<T> callable, ExecutorService executorService) {
        super(executorService);
        checkCallable(callable);
        this.callable = callable;
    }

    private void checkCallable(Callable<T> callable) {
        if (callable != null) {
            return;
        }
        throw new IllegalArgumentException("Callable must not be null!");
    }

    @Override // org.apache.commons.lang3.concurrent.BackgroundInitializer
    public T initialize() throws Exception {
        return this.callable.call();
    }
}
