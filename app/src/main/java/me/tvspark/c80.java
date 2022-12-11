package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class c80<T> extends CountDownLatch implements j60<T>, Future<T>, p60 {
    public final AtomicReference<p60> Wwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();
    public Throwable Wwwwwwwwwwwwwwwwwwwwwww;
    public T Wwwwwwwwwwwwwwwwwwwwwwww;

    public c80() {
        super(1);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        p60 p60Var;
        DisposableHelper disposableHelper;
        do {
            p60Var = this.Wwwwwwwwwwwwwwwwwwwwww.get();
            if (p60Var == this || p60Var == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!this.Wwwwwwwwwwwwwwwwwwwwww.compareAndSet(p60Var, disposableHelper));
        if (p60Var != null) {
            p60Var.dispose();
        }
        countDown();
        return true;
    }

    @Override // me.tvspark.p60
    public void dispose() {
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (th != null) {
                throw new ExecutionException(th);
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() == 0 || await(j, timeUnit)) {
            if (isCancelled()) {
                throw new CancellationException();
            }
            Throwable th = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (th != null) {
                throw new ExecutionException(th);
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new TimeoutException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.Wwwwwwwwwwwwwwwwwwwwww.get());
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        p60 p60Var;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            p60Var = this.Wwwwwwwwwwwwwwwwwwwwww.get();
            if (p60Var == this || p60Var == DisposableHelper.DISPOSED) {
                return;
            }
        } while (!this.Wwwwwwwwwwwwwwwwwwwwww.compareAndSet(p60Var, this));
        countDown();
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        p60 p60Var;
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = th;
        do {
            p60Var = this.Wwwwwwwwwwwwwwwwwwwwww.get();
            if (p60Var == this || p60Var == DisposableHelper.DISPOSED) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
        } while (!this.Wwwwwwwwwwwwwwwwwwwwww.compareAndSet(p60Var, this));
        countDown();
    }

    @Override // me.tvspark.j60
    public void onNext(T t) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = t;
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww.get().dispose();
        onError(new IndexOutOfBoundsException("More than one element received"));
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this.Wwwwwwwwwwwwwwwwwwwwww, p60Var);
    }
}
