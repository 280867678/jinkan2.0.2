package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.sc0;

/* loaded from: classes4.dex */
public final class BlockingObservableIterable<T> implements Iterable<T> {
    public final int Wwwwwwwwwwwwwwwwwwwwwww;
    public final h60<? extends T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class BlockingObservableIterator<T> extends AtomicReference<p60> implements j60<T>, Iterator<T>, p60 {
        public static final long serialVersionUID = 6695226475494099826L;
        public final Condition condition;
        public volatile boolean done;
        public Throwable error;
        public final Lock lock;
        public final sc0<T> queue;

        public BlockingObservableIterator(int i) {
            this.queue = new sc0<>(i);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.lock = reentrantLock;
            this.condition = reentrantLock.newCondition();
        }

        @Override // me.tvspark.p60
        public void dispose() {
            DisposableHelper.dispose(this);
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
                    try {
                        this.lock.lock();
                        while (!this.done && this.queue.isEmpty()) {
                            this.condition.await();
                        }
                        this.lock.unlock();
                    } catch (InterruptedException e) {
                        DisposableHelper.dispose(this);
                        signalConsumer();
                        throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
                    }
                } else {
                    return true;
                }
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                return this.queue.mo4868poll();
            }
            throw new NoSuchElementException();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            signalConsumer();
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.queue.offer(t);
            signalConsumer();
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this, p60Var);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
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

    public BlockingObservableIterable(h60<? extends T> h60Var, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.Wwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(blockingObservableIterator);
        return blockingObservableIterator;
    }
}
