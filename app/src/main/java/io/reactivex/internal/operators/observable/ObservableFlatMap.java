package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.f70;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.o70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.s70;
import me.tvspark.sc0;
import me.tvspark.t70;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableFlatMap<T, U> extends x80<T, U> {
    public final int Wwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwww;
    public final f70<? super T, ? extends h60<? extends U>> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class InnerObserver<T, U> extends AtomicReference<p60> implements j60<U> {
        public static final long serialVersionUID = -4606175640614850599L;
        public volatile boolean done;
        public int fusionMode;

        /* renamed from: id */
        public final long f4427id;
        public final MergeObserver<T, U> parent;
        public volatile t70<U> queue;

        public InnerObserver(MergeObserver<T, U> mergeObserver, long j) {
            this.f4427id = j;
            this.parent = mergeObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (!this.parent.errors.addThrowable(th)) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            MergeObserver<T, U> mergeObserver = this.parent;
            if (!mergeObserver.delayErrors) {
                mergeObserver.disposeAll();
            }
            this.done = true;
            this.parent.drain();
        }

        @Override // me.tvspark.j60
        public void onNext(U u) {
            if (this.fusionMode == 0) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (!DisposableHelper.setOnce(this, p60Var) || !(p60Var instanceof o70)) {
                return;
            }
            o70 o70Var = (o70) p60Var;
            int requestFusion = o70Var.requestFusion(3);
            if (requestFusion == 1) {
                this.fusionMode = requestFusion;
                this.queue = o70Var;
                this.done = true;
                this.parent.drain();
            } else if (requestFusion != 2) {
            } else {
                this.fusionMode = requestFusion;
                this.queue = o70Var;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class MergeObserver<T, U> extends AtomicInteger implements p60, j60<T> {
        public static final long serialVersionUID = -2117620485640801370L;
        public final j60<? super U> actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final AtomicThrowable errors = new AtomicThrowable();
        public long lastId;
        public int lastIndex;
        public final f70<? super T, ? extends h60<? extends U>> mapper;
        public final int maxConcurrency;
        public final AtomicReference<InnerObserver<?, ?>[]> observers;
        public volatile s70<U> queue;

        /* renamed from: s */
        public p60 f4428s;
        public Queue<h60<? extends U>> sources;
        public long uniqueId;
        public int wip;
        public static final InnerObserver<?, ?>[] EMPTY = new InnerObserver[0];
        public static final InnerObserver<?, ?>[] CANCELLED = new InnerObserver[0];

        public MergeObserver(j60<? super U> j60Var, f70<? super T, ? extends h60<? extends U>> f70Var, boolean z, int i, int i2) {
            this.actual = j60Var;
            this.mapper = f70Var;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            if (i != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i);
            }
            this.observers = new AtomicReference<>(EMPTY);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void addInner(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                if (innerObserverArr == CANCELLED) {
                    innerObserver.dispose();
                    return;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[length + 1];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!this.observers.compareAndSet(innerObserverArr, innerObserverArr2));
        }

        public boolean checkTerminate() {
            if (this.cancelled) {
                return true;
            }
            Throwable th = this.errors.get();
            if (this.delayErrors || th == null) {
                return false;
            }
            disposeAll();
            this.actual.onError(this.errors.terminate());
            return true;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            Throwable terminate;
            if (!this.cancelled) {
                this.cancelled = true;
                if (!disposeAll() || (terminate = this.errors.terminate()) == null || terminate == ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    return;
                }
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(terminate);
            }
        }

        public boolean disposeAll() {
            InnerObserver<?, ?>[] andSet;
            this.f4428s.dispose();
            InnerObserver<?, ?>[] innerObserverArr = this.observers.get();
            InnerObserver<?, ?>[] innerObserverArr2 = CANCELLED;
            if (innerObserverArr == innerObserverArr2 || (andSet = this.observers.getAndSet(innerObserverArr2)) == CANCELLED) {
                return false;
            }
            for (InnerObserver<?, ?> innerObserver : andSet) {
                innerObserver.dispose();
            }
            return true;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:57:0x00a3, code lost:
            if (r11 != null) goto L45;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drainLoop() {
            j60<? super U> j60Var = this.actual;
            int i = 1;
            while (!checkTerminate()) {
                s70<U> s70Var = this.queue;
                if (s70Var != null) {
                    while (!checkTerminate()) {
                        Object obj = (U) s70Var.mo4868poll();
                        if (obj != null) {
                            j60Var.onNext(obj);
                        } else if (obj == null) {
                        }
                    }
                    return;
                }
                boolean z = this.done;
                s70<U> s70Var2 = this.queue;
                InnerObserver<?, ?>[] innerObserverArr = this.observers.get();
                int length = innerObserverArr.length;
                if (z && ((s70Var2 == null || s70Var2.isEmpty()) && length == 0)) {
                    if (this.errors.get() == null) {
                        j60Var.onComplete();
                        return;
                    } else {
                        j60Var.onError(this.errors.terminate());
                        return;
                    }
                }
                boolean z2 = false;
                if (length != 0) {
                    long j = this.lastId;
                    int i2 = this.lastIndex;
                    if (length <= i2 || innerObserverArr[i2].f4427id != j) {
                        if (length <= i2) {
                            i2 = 0;
                        }
                        for (int i3 = 0; i3 < length && innerObserverArr[i2].f4427id != j; i3++) {
                            i2++;
                            if (i2 == length) {
                                i2 = 0;
                            }
                        }
                        this.lastIndex = i2;
                        this.lastId = innerObserverArr[i2].f4427id;
                    }
                    int i4 = 0;
                    boolean z3 = false;
                    while (i4 < length) {
                        if (checkTerminate()) {
                            return;
                        }
                        InnerObserver<T, U> innerObserver = innerObserverArr[i2];
                        while (!checkTerminate()) {
                            t70<U> t70Var = innerObserver.queue;
                            if (t70Var != null) {
                                while (true) {
                                    try {
                                        Object obj2 = (U) t70Var.mo4868poll();
                                        if (obj2 == null) {
                                            break;
                                        }
                                        j60Var.onNext(obj2);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                                        innerObserver.dispose();
                                        this.errors.addThrowable(th);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        removeInner(innerObserver);
                                        i4++;
                                        z3 = true;
                                    }
                                }
                            }
                            boolean z4 = innerObserver.done;
                            t70<U> t70Var2 = innerObserver.queue;
                            if (z4 && (t70Var2 == null || t70Var2.isEmpty())) {
                                removeInner(innerObserver);
                                if (checkTerminate()) {
                                    return;
                                }
                                z3 = true;
                            }
                            i2++;
                            if (i2 == length) {
                                i2 = 0;
                            }
                            i4++;
                        }
                        return;
                    }
                    this.lastIndex = i2;
                    this.lastId = innerObserverArr[i2].f4427id;
                    z2 = z3;
                }
                if (!z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        h60<? extends U> poll = this.sources.poll();
                        if (poll == null) {
                            this.wip--;
                        } else {
                            subscribeInner(poll);
                        }
                    }
                } else {
                    continue;
                }
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled;
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
            } else if (!this.errors.addThrowable(th)) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                h60<? extends U> apply = this.mapper.apply(t);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper returned a null ObservableSource");
                h60<? extends U> h60Var = apply;
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        if (this.wip == this.maxConcurrency) {
                            this.sources.offer(h60Var);
                            return;
                        }
                        this.wip++;
                    }
                }
                subscribeInner(h60Var);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.f4428s.dispose();
                onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4428s, p60Var)) {
                this.f4428s = p60Var;
                this.actual.onSubscribe(this);
            }
        }

        public void removeInner(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                int length = innerObserverArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (innerObserverArr[i2] == innerObserver) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerObserverArr2 = EMPTY;
                } else {
                    InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[length - 1];
                    System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i);
                    System.arraycopy(innerObserverArr, i + 1, innerObserverArr3, i, (length - i) - 1);
                    innerObserverArr2 = innerObserverArr3;
                }
            } while (!this.observers.compareAndSet(innerObserverArr, innerObserverArr2));
        }

        public void subscribeInner(h60<? extends U> h60Var) {
            while (h60Var instanceof Callable) {
                tryEmitScalar((Callable) h60Var);
                if (this.maxConcurrency == Integer.MAX_VALUE) {
                    return;
                }
                synchronized (this) {
                    h60Var = this.sources.poll();
                    if (h60Var == null) {
                        this.wip--;
                        return;
                    }
                }
            }
            long j = this.uniqueId;
            this.uniqueId = 1 + j;
            InnerObserver<T, U> innerObserver = new InnerObserver<>(this, j);
            addInner(innerObserver);
            h60Var.subscribe(innerObserver);
        }

        public void tryEmit(U u, InnerObserver<T, U> innerObserver) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                t70 t70Var = innerObserver.queue;
                if (t70Var == null) {
                    t70Var = new sc0(this.bufferSize);
                    innerObserver.queue = t70Var;
                }
                t70Var.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.actual.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            drainLoop();
        }

        public void tryEmitScalar(Callable<? extends U> callable) {
            try {
                U call = callable.call();
                if (call == null) {
                    return;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    s70<U> s70Var = this.queue;
                    if (s70Var == null) {
                        s70Var = this.maxConcurrency == Integer.MAX_VALUE ? new sc0<>(this.bufferSize) : new SpscArrayQueue<>(this.maxConcurrency);
                        this.queue = s70Var;
                    }
                    if (!s70Var.offer(call)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    } else if (getAndIncrement() != 0) {
                        return;
                    }
                } else {
                    this.actual.onNext(call);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                drainLoop();
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.errors.addThrowable(th);
                drain();
            }
        }
    }

    public ObservableFlatMap(h60<T> h60Var, f70<? super T, ? extends h60<? extends U>> f70Var, boolean z, int i, int i2) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwww = i2;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super U> j60Var) {
        if (r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww)) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new MergeObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww));
    }
}
