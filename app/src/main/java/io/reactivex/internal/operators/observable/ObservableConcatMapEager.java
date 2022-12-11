package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.ArrayDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.d80;
import me.tvspark.f70;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.o70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.t70;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableConcatMapEager<T, R> extends x80<T, R> {
    public final int Wwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public final ErrorMode Wwwwwwwwwwwwwwwwwwwwww;
    public final f70<? super T, ? extends h60<? extends R>> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements j60<T>, p60, d80<R> {
        public static final long serialVersionUID = 8080567949447303262L;
        public int activeCount;
        public final j60<? super R> actual;
        public volatile boolean cancelled;
        public InnerQueuedObserver<R> current;

        /* renamed from: d */
        public p60 f4426d;
        public volatile boolean done;
        public final ErrorMode errorMode;
        public final f70<? super T, ? extends h60<? extends R>> mapper;
        public final int maxConcurrency;
        public final int prefetch;
        public t70<T> queue;
        public int sourceMode;
        public final AtomicThrowable error = new AtomicThrowable();
        public final ArrayDeque<InnerQueuedObserver<R>> observers = new ArrayDeque<>();

        public ConcatMapEagerMainObserver(j60<? super R> j60Var, f70<? super T, ? extends h60<? extends R>> f70Var, int i, int i2, ErrorMode errorMode) {
            this.actual = j60Var;
            this.mapper = f70Var;
            this.maxConcurrency = i;
            this.prefetch = i2;
            this.errorMode = errorMode;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.cancelled = true;
            if (getAndIncrement() == 0) {
                this.queue.clear();
                disposeAll();
            }
        }

        public void disposeAll() {
            InnerQueuedObserver<R> innerQueuedObserver = this.current;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver<R> poll = this.observers.poll();
                if (poll == null) {
                    return;
                }
                poll.dispose();
            }
        }

        @Override // me.tvspark.d80
        public void drain() {
            R mo4868poll;
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            t70<T> t70Var = this.queue;
            ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.observers;
            j60<? super R> j60Var = this.actual;
            ErrorMode errorMode = this.errorMode;
            int i = 1;
            while (true) {
                int i2 = this.activeCount;
                while (i2 != this.maxConcurrency) {
                    if (this.cancelled) {
                        t70Var.clear();
                        disposeAll();
                        return;
                    } else if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                        t70Var.clear();
                        disposeAll();
                        j60Var.onError(this.error.terminate());
                        return;
                    } else {
                        try {
                            T mo4868poll2 = t70Var.mo4868poll();
                            if (mo4868poll2 == null) {
                                break;
                            }
                            h60<? extends R> apply = this.mapper.apply(mo4868poll2);
                            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper returned a null ObservableSource");
                            h60<? extends R> h60Var = apply;
                            if (h60Var instanceof Callable) {
                                try {
                                    Object obj = (Object) ((Callable) h60Var).call();
                                    if (obj != 0) {
                                        j60Var.onNext(obj);
                                    }
                                } catch (Throwable th) {
                                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                                    this.error.addThrowable(th);
                                }
                            } else {
                                InnerQueuedObserver<R> innerQueuedObserver = new InnerQueuedObserver<>(this, this.prefetch);
                                arrayDeque.offer(innerQueuedObserver);
                                h60Var.subscribe(innerQueuedObserver);
                                i2++;
                            }
                        } catch (Throwable th2) {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                            this.f4426d.dispose();
                            t70Var.clear();
                            disposeAll();
                            this.error.addThrowable(th2);
                            j60Var.onError(this.error.terminate());
                            return;
                        }
                    }
                }
                this.activeCount = i2;
                if (this.cancelled) {
                    t70Var.clear();
                    disposeAll();
                    return;
                } else if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                    t70Var.clear();
                    disposeAll();
                    j60Var.onError(this.error.terminate());
                    return;
                } else {
                    InnerQueuedObserver<R> innerQueuedObserver2 = this.current;
                    if (innerQueuedObserver2 == null) {
                        if (errorMode == ErrorMode.BOUNDARY && this.error.get() != null) {
                            t70Var.clear();
                            disposeAll();
                            j60Var.onError(this.error.terminate());
                            return;
                        }
                        boolean z2 = this.done;
                        InnerQueuedObserver<R> poll = arrayDeque.poll();
                        boolean z3 = poll == null;
                        if (z2 && z3) {
                            if (this.error.get() == null) {
                                j60Var.onComplete();
                                return;
                            }
                            t70Var.clear();
                            disposeAll();
                            j60Var.onError(this.error.terminate());
                            return;
                        }
                        if (!z3) {
                            this.current = poll;
                        }
                        innerQueuedObserver2 = poll;
                    }
                    if (innerQueuedObserver2 != null) {
                        t70<R> queue = innerQueuedObserver2.queue();
                        while (!this.cancelled) {
                            boolean isDone = innerQueuedObserver2.isDone();
                            if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                                t70Var.clear();
                                disposeAll();
                                j60Var.onError(this.error.terminate());
                                return;
                            }
                            try {
                                mo4868poll = queue.mo4868poll();
                                z = mo4868poll == null;
                            } catch (Throwable th3) {
                                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th3);
                                this.error.addThrowable(th3);
                            }
                            if (isDone && z) {
                                this.current = null;
                                this.activeCount--;
                            } else if (!z) {
                                j60Var.onNext(mo4868poll);
                            }
                        }
                        t70Var.clear();
                        disposeAll();
                        return;
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // me.tvspark.d80
        public void innerComplete(InnerQueuedObserver<R> innerQueuedObserver) {
            innerQueuedObserver.setDone();
            drain();
        }

        @Override // me.tvspark.d80
        public void innerError(InnerQueuedObserver<R> innerQueuedObserver, Throwable th) {
            if (!this.error.addThrowable(th)) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.f4426d.dispose();
            }
            innerQueuedObserver.setDone();
            drain();
        }

        @Override // me.tvspark.d80
        public void innerNext(InnerQueuedObserver<R> innerQueuedObserver, R r) {
            innerQueuedObserver.queue().offer(r);
            drain();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (!this.error.addThrowable(th)) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.done = true;
            drain();
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4426d, p60Var)) {
                this.f4426d = p60Var;
                if (p60Var instanceof o70) {
                    o70 o70Var = (o70) p60Var;
                    int requestFusion = o70Var.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = o70Var;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = o70Var;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.prefetch);
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapEager(h60<T> h60Var, f70<? super T, ? extends h60<? extends R>> f70Var, ErrorMode errorMode, int i, int i2) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = errorMode;
        this.Wwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwww = i2;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super R> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new ConcatMapEagerMainObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww));
    }
}
