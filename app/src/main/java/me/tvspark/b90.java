package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class b90<T> implements Iterable<T> {
    public final h60<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> extends kd0<c60<T>> {
        public final BlockingQueue<c60<T>> Wwwwwwwwwwwwwwwwwwwwwww = new ArrayBlockingQueue(1);
        public final AtomicInteger Wwwwwwwwwwwwwwwwwwwwww = new AtomicInteger();

        @Override // me.tvspark.j60
        public void onComplete() {
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }

        @Override // me.tvspark.j60
        public void onNext(Object obj) {
            c60<T> c60Var = (c60) obj;
            if (this.Wwwwwwwwwwwwwwwwwwwwww.getAndSet(0) == 1 || !c60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                while (!this.Wwwwwwwwwwwwwwwwwwwwwww.offer(c60Var)) {
                    c60<T> poll = this.Wwwwwwwwwwwwwwwwwwwwwww.poll();
                    if (poll != null && !poll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        c60Var = poll;
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements Iterator<T> {
        public boolean Wwwwwwwwwwwwwwwwww;
        public Throwable Wwwwwwwwwwwwwwwwwww;
        public T Wwwwwwwwwwwwwwwwwwwwww;
        public final h60<T> Wwwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> Wwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwww = true;
        public boolean Wwwwwwwwwwwwwwwwwwww = true;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60<T> h60Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = h60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            boolean z;
            Throwable th = this.Wwwwwwwwwwwwwwwwwww;
            if (th == null) {
                if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                    return false;
                }
                if (this.Wwwwwwwwwwwwwwwwwwww) {
                    if (!this.Wwwwwwwwwwwwwwwwww) {
                        this.Wwwwwwwwwwwwwwwwww = true;
                        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.set(1);
                        new mb0(this.Wwwwwwwwwwwwwwwwwwwwwww).subscribe(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    try {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.set(1);
                        c60<T> take = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.take();
                        if (take.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            this.Wwwwwwwwwwwwwwwwwwww = false;
                            this.Wwwwwwwwwwwwwwwwwwwwww = take.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            z = true;
                        } else {
                            this.Wwwwwwwwwwwwwwwwwwwww = false;
                            if (!(take.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null)) {
                                Throwable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = take.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                this.Wwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            }
                            z = false;
                        }
                        if (!z) {
                            return false;
                        }
                    } catch (InterruptedException e) {
                        DisposableHelper.dispose(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
                        this.Wwwwwwwwwwwwwwwwwww = e;
                        throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
                    }
                }
                return true;
            }
            throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.Wwwwwwwwwwwwwwwwwww;
            if (th == null) {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                }
                this.Wwwwwwwwwwwwwwwwwwww = true;
                return this.Wwwwwwwwwwwwwwwwwwwwww;
            }
            throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    public b90(h60<T> h60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }
}
