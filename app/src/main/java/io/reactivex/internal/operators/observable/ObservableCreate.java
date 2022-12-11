package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.d60;
import me.tvspark.e60;
import me.tvspark.f60;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.sc0;
import me.tvspark.w60;

/* loaded from: classes4.dex */
public final class ObservableCreate<T> extends d60<T> {
    public final f60<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class CreateEmitter<T> extends AtomicReference<p60> implements e60<T>, p60 {
        public static final long serialVersionUID = -3434801548987643227L;
        public final j60<? super T> observer;

        public CreateEmitter(j60<? super T> j60Var) {
            this.observer = j60Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // me.tvspark.e60, me.tvspark.p60
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // me.tvspark.w50
        public void onComplete() {
            if (!isDisposed()) {
                try {
                    this.observer.onComplete();
                } finally {
                    dispose();
                }
            }
        }

        @Override // me.tvspark.w50
        public void onError(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            try {
                this.observer.onError(th);
            } finally {
                dispose();
            }
        }

        @Override // me.tvspark.w50
        public void onNext(T t) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (isDisposed()) {
            } else {
                this.observer.onNext(t);
            }
        }

        public e60<T> serialize() {
            return new SerializedEmitter(this);
        }

        @Override // me.tvspark.e60
        public void setCancellable(w60 w60Var) {
            setDisposable(new CancellableDisposable(w60Var));
        }

        @Override // me.tvspark.e60
        public void setDisposable(p60 p60Var) {
            DisposableHelper.set(this, p60Var);
        }
    }

    /* loaded from: classes4.dex */
    public static final class SerializedEmitter<T> extends AtomicInteger implements e60<T> {
        public static final long serialVersionUID = 4883307006032401862L;
        public volatile boolean done;
        public final e60<T> emitter;
        public final AtomicThrowable error = new AtomicThrowable();
        public final sc0<T> queue = new sc0<>(16);

        public SerializedEmitter(e60<T> e60Var) {
            this.emitter = e60Var;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        public void drainLoop() {
            e60<T> e60Var = this.emitter;
            sc0<T> sc0Var = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            int i = 1;
            while (!e60Var.isDisposed()) {
                if (atomicThrowable.get() != null) {
                    sc0Var.clear();
                    e60Var.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.done;
                T mo4868poll = sc0Var.mo4868poll();
                boolean z2 = mo4868poll == null;
                if (z && z2) {
                    e60Var.onComplete();
                    return;
                } else if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    e60Var.onNext(mo4868poll);
                }
            }
            sc0Var.clear();
        }

        @Override // me.tvspark.e60, me.tvspark.p60
        public boolean isDisposed() {
            return this.emitter.isDisposed();
        }

        @Override // me.tvspark.w50
        public void onComplete() {
            if (this.emitter.isDisposed() || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // me.tvspark.w50
        public void onError(Throwable th) {
            if (this.emitter.isDisposed() || this.done) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (!this.error.addThrowable(th)) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.done = true;
            drain();
        }

        @Override // me.tvspark.w50
        public void onNext(T t) {
            if (this.emitter.isDisposed() || this.done) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (get() != 0 || !compareAndSet(0, 1)) {
                sc0<T> sc0Var = this.queue;
                synchronized (sc0Var) {
                    sc0Var.offer(t);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.emitter.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            drainLoop();
        }

        public e60<T> serialize() {
            return this;
        }

        @Override // me.tvspark.e60
        public void setCancellable(w60 w60Var) {
            this.emitter.setCancellable(w60Var);
        }

        @Override // me.tvspark.e60
        public void setDisposable(p60 p60Var) {
            this.emitter.setDisposable(p60Var);
        }
    }

    public ObservableCreate(f60<T> f60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = f60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        CreateEmitter createEmitter = new CreateEmitter(j60Var);
        j60Var.onSubscribe(createEmitter);
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(createEmitter);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            createEmitter.onError(th);
        }
    }
}
