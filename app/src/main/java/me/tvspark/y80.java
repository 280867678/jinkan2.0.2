package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class y80<T> implements Iterable<T> {
    public final h60<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> extends kd0<c60<T>> implements Iterator<T> {
        public c60<T> Wwwwwwwwwwwwwwwwwwwwwww;
        public final Semaphore Wwwwwwwwwwwwwwwwwwwwww = new Semaphore(0);
        public final AtomicReference<c60<T>> Wwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();

        @Override // java.util.Iterator
        public boolean hasNext() {
            c60<T> c60Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (c60Var == null || !c60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwww == null) {
                    try {
                        this.Wwwwwwwwwwwwwwwwwwwwww.acquire();
                        c60<T> andSet = this.Wwwwwwwwwwwwwwwwwwwww.getAndSet(null);
                        this.Wwwwwwwwwwwwwwwwwwwwwww = andSet;
                        if (andSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(andSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        }
                    } catch (InterruptedException e) {
                        DisposableHelper.dispose(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                        this.Wwwwwwwwwwwwwwwwwwwwwww = c60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) e);
                        throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
                    }
                }
                return this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwwwwwwwwwww = null;
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            throw new NoSuchElementException();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }

        @Override // me.tvspark.j60
        public void onNext(Object obj) {
            if (this.Wwwwwwwwwwwwwwwwwwwww.getAndSet((c60) obj) == null) {
                this.Wwwwwwwwwwwwwwwwwwwwww.release();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public y80(h60<T> h60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        d60.wrap(this.Wwwwwwwwwwwwwwwwwwwwwwww).materialize().subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
