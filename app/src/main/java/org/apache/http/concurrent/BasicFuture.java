package org.apache.http.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.util.Args;

/* loaded from: classes4.dex */
public class BasicFuture<T> implements Future<T>, Cancellable {
    public final FutureCallback<T> callback;
    public volatile boolean cancelled;
    public volatile boolean completed;

    /* renamed from: ex */
    public volatile Exception f4571ex;
    public volatile T result;

    public BasicFuture(FutureCallback<T> futureCallback) {
        this.callback = futureCallback;
    }

    private T getResult() throws ExecutionException {
        if (this.f4571ex == null) {
            if (this.cancelled) {
                throw new CancellationException();
            }
            return this.result;
        }
        throw new ExecutionException(this.f4571ex);
    }

    @Override // org.apache.http.concurrent.Cancellable
    public boolean cancel() {
        return cancel(true);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        synchronized (this) {
            if (this.completed) {
                return false;
            }
            this.completed = true;
            this.cancelled = true;
            notifyAll();
            FutureCallback<T> futureCallback = this.callback;
            if (futureCallback != null) {
                futureCallback.cancelled();
            }
            return true;
        }
    }

    public boolean completed(T t) {
        synchronized (this) {
            if (this.completed) {
                return false;
            }
            this.completed = true;
            this.result = t;
            notifyAll();
            FutureCallback<T> futureCallback = this.callback;
            if (futureCallback != null) {
                futureCallback.completed(t);
            }
            return true;
        }
    }

    public boolean failed(Exception exc) {
        synchronized (this) {
            if (this.completed) {
                return false;
            }
            this.completed = true;
            this.f4571ex = exc;
            notifyAll();
            FutureCallback<T> futureCallback = this.callback;
            if (futureCallback != null) {
                futureCallback.failed(exc);
            }
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public synchronized T get() throws InterruptedException, ExecutionException {
        while (!this.completed) {
            wait();
        }
        return getResult();
    }

    @Override // java.util.concurrent.Future
    public synchronized T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        Args.notNull(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j);
        int i = (millis > 0L ? 1 : (millis == 0L ? 0 : -1));
        long currentTimeMillis = i <= 0 ? 0L : System.currentTimeMillis();
        if (this.completed) {
            return getResult();
        } else if (i <= 0) {
            throw new TimeoutException();
        } else {
            long j2 = millis;
            while (true) {
                wait(j2);
                if (this.completed) {
                    return getResult();
                }
                j2 = millis - (System.currentTimeMillis() - currentTimeMillis);
                if (j2 <= 0) {
                    throw new TimeoutException();
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.completed;
    }
}
