package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.d60;
import me.tvspark.f70;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.m60;
import me.tvspark.n60;
import me.tvspark.o60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.sc0;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableFlatMapSingle<T, R> extends x80<T, R> {
    public final boolean Wwwwwwwwwwwwwwwwwwwwww;
    public final f70<? super T, ? extends n60<? extends R>> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class FlatMapSingleObserver<T, R> extends AtomicInteger implements j60<T>, p60 {
        public static final long serialVersionUID = 8600231336733376951L;
        public final j60<? super R> actual;
        public volatile boolean cancelled;

        /* renamed from: d */
        public p60 f4432d;
        public final boolean delayErrors;
        public final f70<? super T, ? extends n60<? extends R>> mapper;
        public final o60 set = new o60();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicInteger active = new AtomicInteger(1);
        public final AtomicReference<sc0<R>> queue = new AtomicReference<>();

        /* loaded from: classes4.dex */
        public final class InnerObserver extends AtomicReference<p60> implements m60<R>, p60 {
            public static final long serialVersionUID = -502562646270949838L;

            public InnerObserver() {
            }

            @Override // me.tvspark.p60
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // me.tvspark.p60
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // me.tvspark.m60
            public void onError(Throwable th) {
                FlatMapSingleObserver.this.innerError(this, th);
            }

            @Override // me.tvspark.m60
            public void onSubscribe(p60 p60Var) {
                DisposableHelper.setOnce(this, p60Var);
            }

            @Override // me.tvspark.m60
            public void onSuccess(R r) {
                FlatMapSingleObserver.this.innerSuccess(this, r);
            }
        }

        public FlatMapSingleObserver(j60<? super R> j60Var, f70<? super T, ? extends n60<? extends R>> f70Var, boolean z) {
            this.actual = j60Var;
            this.mapper = f70Var;
            this.delayErrors = z;
        }

        public void clear() {
            sc0<R> sc0Var = this.queue.get();
            if (sc0Var != null) {
                sc0Var.clear();
            }
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.cancelled = true;
            this.f4432d.dispose();
            this.set.dispose();
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        public void drainLoop() {
            j60<? super R> j60Var = this.actual;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<sc0<R>> atomicReference = this.queue;
            int i = 1;
            while (!this.cancelled) {
                if (!this.delayErrors && this.errors.get() != null) {
                    Throwable terminate = this.errors.terminate();
                    clear();
                    j60Var.onError(terminate);
                    return;
                }
                boolean z = false;
                boolean z2 = atomicInteger.get() == 0;
                sc0<R> sc0Var = atomicReference.get();
                R mo4868poll = sc0Var != null ? sc0Var.mo4868poll() : (Object) null;
                if (mo4868poll == null) {
                    z = true;
                }
                if (z2 && z) {
                    Throwable terminate2 = this.errors.terminate();
                    if (terminate2 != null) {
                        j60Var.onError(terminate2);
                        return;
                    } else {
                        j60Var.onComplete();
                        return;
                    }
                } else if (z) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    j60Var.onNext(mo4868poll);
                }
            }
            clear();
        }

        public sc0<R> getOrCreateQueue() {
            sc0<R> sc0Var;
            do {
                sc0<R> sc0Var2 = this.queue.get();
                if (sc0Var2 != null) {
                    return sc0Var2;
                }
                sc0Var = new sc0<>(d60.bufferSize());
            } while (!this.queue.compareAndSet(null, sc0Var));
            return sc0Var;
        }

        public void innerError(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, Throwable th) {
            this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerObserver);
            if (!this.errors.addThrowable(th)) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            if (!this.delayErrors) {
                this.f4432d.dispose();
                this.set.dispose();
            }
            this.active.decrementAndGet();
            drain();
        }

        public void innerSuccess(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, R r) {
            this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerObserver);
            if (get() == 0) {
                boolean z = true;
                if (compareAndSet(0, 1)) {
                    this.actual.onNext(r);
                    if (this.active.decrementAndGet() != 0) {
                        z = false;
                    }
                    sc0<R> sc0Var = this.queue.get();
                    if (!z || (sc0Var != null && !sc0Var.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        drainLoop();
                    }
                    Throwable terminate = this.errors.terminate();
                    if (terminate != null) {
                        this.actual.onError(terminate);
                        return;
                    } else {
                        this.actual.onComplete();
                        return;
                    }
                }
            }
            sc0<R> orCreateQueue = getOrCreateQueue();
            synchronized (orCreateQueue) {
                orCreateQueue.offer(r);
            }
            this.active.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.active.decrementAndGet();
            if (!this.errors.addThrowable(th)) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            if (!this.delayErrors) {
                this.set.dispose();
            }
            drain();
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            try {
                n60<? extends R> apply = this.mapper.apply(t);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper returned a null SingleSource");
                n60<? extends R> n60Var = apply;
                this.active.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerObserver);
                n60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerObserver);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.f4432d.dispose();
                onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4432d, p60Var)) {
                this.f4432d = p60Var;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapSingle(h60<T> h60Var, f70<? super T, ? extends n60<? extends R>> f70Var, boolean z) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super R> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new FlatMapSingleObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww));
    }
}
