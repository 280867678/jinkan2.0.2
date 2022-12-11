package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import me.tvspark.p60;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class BlockingFlowableIterable$BlockingFlowableIterator<T> extends AtomicReference<t51> implements s51<T>, Iterator<T>, Runnable, p60 {
    public static final long serialVersionUID = 6695226475494099826L;
    public final long batchSize;
    public final Condition condition;
    public volatile boolean done;
    public Throwable error;
    public final long limit;
    public final Lock lock;
    public long produced;
    public final SpscArrayQueue<T> queue;

    public BlockingFlowableIterable$BlockingFlowableIterator(int i) {
        this.queue = new SpscArrayQueue<>(i);
        this.batchSize = i;
        this.limit = i - (i >> 2);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    @Override // me.tvspark.p60
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            boolean z = this.done;
            boolean isEmpty = this.queue.isEmpty();
            if (z) {
                Throwable th = this.error;
                if (th != null) {
                    throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                }
                if (isEmpty) {
                    return false;
                }
            }
            if (isEmpty) {
                this.lock.lock();
                while (!this.done && this.queue.isEmpty()) {
                    try {
                        try {
                            this.condition.await();
                        } catch (InterruptedException e) {
                            run();
                            throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
                        }
                    } finally {
                        this.lock.unlock();
                    }
                }
            } else {
                return true;
            }
        }
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return SubscriptionHelper.isCancelled(get());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            T mo4868poll = this.queue.mo4868poll();
            long j = this.produced + 1;
            if (j == this.limit) {
                this.produced = 0L;
                get().request(j);
            } else {
                this.produced = j;
            }
            return mo4868poll;
        }
        throw new NoSuchElementException();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.done = true;
        signalConsumer();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        signalConsumer();
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.queue.offer(t)) {
            signalConsumer();
            return;
        }
        SubscriptionHelper.cancel(this);
        onError(new MissingBackpressureException("Queue full?!"));
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this, t51Var)) {
            t51Var.request(this.batchSize);
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    @Override // java.lang.Runnable
    public void run() {
        SubscriptionHelper.cancel(this);
        signalConsumer();
    }

    public void signalConsumer() {
        this.lock.lock();
        try {
            this.condition.signalAll();
        } finally {
            this.lock.unlock();
        }
    }
}
