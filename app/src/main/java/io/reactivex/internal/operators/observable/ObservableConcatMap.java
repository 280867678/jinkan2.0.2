package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.f70;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.md0;
import me.tvspark.o70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.sc0;
import me.tvspark.t70;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableConcatMap<T, U> extends x80<T, U> {
    public final ErrorMode Wwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwww;
    public final f70<? super T, ? extends h60<? extends U>> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements j60<T>, p60 {
        public static final long serialVersionUID = -6951100001833242599L;
        public volatile boolean active;
        public final j60<? super R> actual;
        public final int bufferSize;
        public volatile boolean cancelled;

        /* renamed from: d */
        public p60 f4423d;
        public volatile boolean done;
        public final f70<? super T, ? extends h60<? extends R>> mapper;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R> observer;
        public t70<T> queue;
        public int sourceMode;
        public final boolean tillTheEnd;
        public final AtomicThrowable error = new AtomicThrowable();
        public final SequentialDisposable arbiter = new SequentialDisposable();

        /* loaded from: classes4.dex */
        public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R> implements j60<R> {
            public final ConcatMapDelayErrorObserver<?, R> Wwwwwwwwwwwwwwwwwwwwwww;
            public final j60<? super R> Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super R> j60Var, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwww = concatMapDelayErrorObserver;
            }

            @Override // me.tvspark.j60
            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.Wwwwwwwwwwwwwwwwwwwwwww;
                concatMapDelayErrorObserver.active = false;
                concatMapDelayErrorObserver.drain();
            }

            @Override // me.tvspark.j60
            public void onError(Throwable th) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (!concatMapDelayErrorObserver.error.addThrowable(th)) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    return;
                }
                if (!concatMapDelayErrorObserver.tillTheEnd) {
                    concatMapDelayErrorObserver.f4423d.dispose();
                }
                concatMapDelayErrorObserver.active = false;
                concatMapDelayErrorObserver.drain();
            }

            @Override // me.tvspark.j60
            public void onNext(R r) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(r);
            }

            @Override // me.tvspark.j60
            public void onSubscribe(p60 p60Var) {
                this.Wwwwwwwwwwwwwwwwwwwwwww.arbiter.replace(p60Var);
            }
        }

        public ConcatMapDelayErrorObserver(j60<? super R> j60Var, f70<? super T, ? extends h60<? extends R>> f70Var, int i, boolean z) {
            this.actual = j60Var;
            this.mapper = f70Var;
            this.bufferSize = i;
            this.tillTheEnd = z;
            this.observer = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(j60Var, this);
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.cancelled = true;
            this.f4423d.dispose();
            this.arbiter.dispose();
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            j60<? super R> j60Var = this.actual;
            t70<T> t70Var = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            while (true) {
                if (!this.active) {
                    if (!this.cancelled) {
                        if (!this.tillTheEnd && atomicThrowable.get() != null) {
                            t70Var.clear();
                            break;
                        }
                        boolean z = this.done;
                        try {
                            T mo4868poll = t70Var.mo4868poll();
                            boolean z2 = mo4868poll == null;
                            if (z && z2) {
                                Throwable terminate = atomicThrowable.terminate();
                                if (terminate != null) {
                                    j60Var.onError(terminate);
                                    return;
                                } else {
                                    j60Var.onComplete();
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    h60<? extends R> apply = this.mapper.apply(mo4868poll);
                                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper returned a null ObservableSource");
                                    h60<? extends R> h60Var = apply;
                                    if (h60Var instanceof Callable) {
                                        try {
                                            Object obj = (Object) ((Callable) h60Var).call();
                                            if (obj != 0 && !this.cancelled) {
                                                j60Var.onNext(obj);
                                            }
                                        } catch (Throwable th) {
                                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                                            atomicThrowable.addThrowable(th);
                                        }
                                    } else {
                                        this.active = true;
                                        h60Var.subscribe(this.observer);
                                    }
                                } catch (Throwable th2) {
                                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                                    this.f4423d.dispose();
                                    t70Var.clear();
                                    atomicThrowable.addThrowable(th2);
                                    j60Var.onError(atomicThrowable.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th3);
                            this.f4423d.dispose();
                            atomicThrowable.addThrowable(th3);
                        }
                    } else {
                        t70Var.clear();
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.f4423d.isDisposed();
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
            if (DisposableHelper.validate(this.f4423d, p60Var)) {
                this.f4423d = p60Var;
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
                this.queue = new sc0(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class SourceObserver<T, U> extends AtomicInteger implements j60<T>, p60 {
        public static final long serialVersionUID = 8828587559905699186L;
        public volatile boolean active;
        public final j60<? super U> actual;
        public final int bufferSize;
        public volatile boolean disposed;
        public volatile boolean done;
        public int fusionMode;
        public final j60<U> inner;
        public final f70<? super T, ? extends h60<? extends U>> mapper;
        public t70<T> queue;

        /* renamed from: s */
        public p60 f4424s;

        /* renamed from: sa */
        public final SequentialDisposable f4425sa = new SequentialDisposable();

        /* loaded from: classes4.dex */
        public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<U> implements j60<U> {
            public final SourceObserver<?, ?> Wwwwwwwwwwwwwwwwwwwwwww;
            public final j60<? super U> Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super U> j60Var, SourceObserver<?, ?> sourceObserver) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwww = sourceObserver;
            }

            @Override // me.tvspark.j60
            public void onComplete() {
                this.Wwwwwwwwwwwwwwwwwwwwwww.innerComplete();
            }

            @Override // me.tvspark.j60
            public void onError(Throwable th) {
                this.Wwwwwwwwwwwwwwwwwwwwwww.dispose();
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
            }

            @Override // me.tvspark.j60
            public void onNext(U u) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(u);
            }

            @Override // me.tvspark.j60
            public void onSubscribe(p60 p60Var) {
                this.Wwwwwwwwwwwwwwwwwwwwwww.innerSubscribe(p60Var);
            }
        }

        public SourceObserver(j60<? super U> j60Var, f70<? super T, ? extends h60<? extends U>> f70Var, int i) {
            this.actual = j60Var;
            this.mapper = f70Var;
            this.bufferSize = i;
            this.inner = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, this);
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.disposed = true;
            this.f4425sa.dispose();
            this.f4424s.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.disposed) {
                if (!this.active) {
                    boolean z = this.done;
                    try {
                        T mo4868poll = this.queue.mo4868poll();
                        boolean z2 = mo4868poll == null;
                        if (z && z2) {
                            this.actual.onComplete();
                            return;
                        } else if (!z2) {
                            try {
                                h60<? extends U> apply = this.mapper.apply(mo4868poll);
                                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper returned a null ObservableSource");
                                h60<? extends U> h60Var = apply;
                                this.active = true;
                                h60Var.subscribe(this.inner);
                            } catch (Throwable th) {
                                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                                dispose();
                                this.queue.clear();
                                this.actual.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                        dispose();
                        this.queue.clear();
                        this.actual.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        public void innerComplete() {
            this.active = false;
            drain();
        }

        public void innerSubscribe(p60 p60Var) {
            this.f4425sa.update(p60Var);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.done) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.done = true;
            dispose();
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.fusionMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4424s, p60Var)) {
                this.f4424s = p60Var;
                if (p60Var instanceof o70) {
                    o70 o70Var = (o70) p60Var;
                    int requestFusion = o70Var.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = o70Var;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = o70Var;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new sc0(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMap(h60<T> h60Var, f70<? super T, ? extends h60<? extends U>> f70Var, int i, ErrorMode errorMode) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwww = errorMode;
        this.Wwwwwwwwwwwwwwwwwwwwww = Math.max(8, i);
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super U> j60Var) {
        if (r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww)) {
            return;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwww == ErrorMode.IMMEDIATE) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new SourceObserver(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww));
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new ConcatMapDelayErrorObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww == ErrorMode.END));
        }
    }
}
