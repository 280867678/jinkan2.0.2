package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.s70;
import me.tvspark.sc0;
import me.tvspark.t51;
import me.tvspark.t70;

/* loaded from: classes4.dex */
public final class FlowableFlatMap$MergeSubscriber<T, U> extends AtomicInteger implements t51, s51<T> {
    public static final long serialVersionUID = -2117620485640801370L;
    public final s51<? super U> actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public long lastId;
    public int lastIndex;
    public final f70<? super T, ? extends r51<? extends U>> mapper;
    public final int maxConcurrency;
    public volatile s70<U> queue;

    /* renamed from: s */
    public t51 f4369s;
    public int scalarEmitted;
    public final int scalarLimit;
    public long uniqueId;
    public static final FlowableFlatMap$InnerSubscriber<?, ?>[] EMPTY = new FlowableFlatMap$InnerSubscriber[0];
    public static final FlowableFlatMap$InnerSubscriber<?, ?>[] CANCELLED = new FlowableFlatMap$InnerSubscriber[0];
    public final AtomicThrowable errs = new AtomicThrowable();
    public final AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> subscribers = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();

    public FlowableFlatMap$MergeSubscriber(s51<? super U> s51Var, f70<? super T, ? extends r51<? extends U>> f70Var, boolean z, int i, int i2) {
        this.actual = s51Var;
        this.mapper = f70Var;
        this.delayErrors = z;
        this.maxConcurrency = i;
        this.bufferSize = i2;
        this.scalarLimit = Math.max(1, i >> 1);
        this.subscribers.lazySet(EMPTY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addInner(FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber) {
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr;
        FlowableFlatMap$InnerSubscriber[] flowableFlatMap$InnerSubscriberArr2;
        do {
            flowableFlatMap$InnerSubscriberArr = this.subscribers.get();
            if (flowableFlatMap$InnerSubscriberArr == CANCELLED) {
                flowableFlatMap$InnerSubscriber.dispose();
                return;
            }
            int length = flowableFlatMap$InnerSubscriberArr.length;
            flowableFlatMap$InnerSubscriberArr2 = new FlowableFlatMap$InnerSubscriber[length + 1];
            System.arraycopy(flowableFlatMap$InnerSubscriberArr, 0, flowableFlatMap$InnerSubscriberArr2, 0, length);
            flowableFlatMap$InnerSubscriberArr2[length] = flowableFlatMap$InnerSubscriber;
        } while (!this.subscribers.compareAndSet(flowableFlatMap$InnerSubscriberArr, flowableFlatMap$InnerSubscriberArr2));
    }

    @Override // me.tvspark.t51
    public void cancel() {
        s70<U> s70Var;
        if (!this.cancelled) {
            this.cancelled = true;
            this.f4369s.cancel();
            disposeAll();
            if (getAndIncrement() != 0 || (s70Var = this.queue) == null) {
                return;
            }
            s70Var.clear();
        }
    }

    public boolean checkTerminate() {
        if (this.cancelled) {
            s70<U> s70Var = this.queue;
            if (s70Var != null) {
                s70Var.clear();
            }
            return true;
        } else if (this.delayErrors || this.errs.get() == null) {
            return false;
        } else {
            this.actual.onError(this.errs.terminate());
            return true;
        }
    }

    public void disposeAll() {
        FlowableFlatMap$InnerSubscriber<?, ?>[] andSet;
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr = this.subscribers.get();
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr2 = CANCELLED;
        if (flowableFlatMap$InnerSubscriberArr == flowableFlatMap$InnerSubscriberArr2 || (andSet = this.subscribers.getAndSet(flowableFlatMap$InnerSubscriberArr2)) == CANCELLED) {
            return;
        }
        for (FlowableFlatMap$InnerSubscriber<?, ?> flowableFlatMap$InnerSubscriber : andSet) {
            flowableFlatMap$InnerSubscriber.dispose();
        }
        Throwable terminate = this.errs.terminate();
        if (terminate == null || terminate == ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(terminate);
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x017f, code lost:
        r24.lastIndex = r3;
        r24.lastId = r13[r3].f4368id;
        r3 = r16;
        r5 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drainLoop() {
        long j;
        long j2;
        boolean z;
        FlowableFlatMap$InnerSubscriber<T, U>[] flowableFlatMap$InnerSubscriberArr;
        long j3;
        s51<? super U> s51Var = this.actual;
        int i = 1;
        while (!checkTerminate()) {
            s70<U> s70Var = this.queue;
            long j4 = this.requested.get();
            boolean z2 = j4 == Long.MAX_VALUE;
            long j5 = 0;
            long j6 = 0;
            if (s70Var != null) {
                while (true) {
                    long j7 = 0;
                    Object obj = null;
                    while (true) {
                        if (j4 == 0) {
                            break;
                        }
                        U mo4868poll = s70Var.mo4868poll();
                        if (checkTerminate()) {
                            return;
                        }
                        if (mo4868poll == null) {
                            obj = mo4868poll;
                            break;
                        }
                        s51Var.onNext(mo4868poll);
                        j6++;
                        j7++;
                        j4--;
                        obj = mo4868poll;
                    }
                    if (j7 != 0) {
                        j4 = z2 ? Long.MAX_VALUE : this.requested.addAndGet(-j7);
                    }
                    if (j4 == 0 || obj == null) {
                        break;
                    }
                }
            }
            boolean z3 = this.done;
            s70<U> s70Var2 = this.queue;
            FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr2 = this.subscribers.get();
            int length = flowableFlatMap$InnerSubscriberArr2.length;
            if (z3 && ((s70Var2 == null || s70Var2.isEmpty()) && length == 0)) {
                Throwable terminate = this.errs.terminate();
                if (terminate == null) {
                    s51Var.onComplete();
                    return;
                } else {
                    s51Var.onError(terminate);
                    return;
                }
            }
            int i2 = i;
            if (length != 0) {
                long j8 = this.lastId;
                int i3 = this.lastIndex;
                if (length <= i3 || flowableFlatMap$InnerSubscriberArr2[i3].f4368id != j8) {
                    if (length <= i3) {
                        i3 = 0;
                    }
                    for (int i4 = 0; i4 < length && flowableFlatMap$InnerSubscriberArr2[i3].f4368id != j8; i4++) {
                        i3++;
                        if (i3 == length) {
                            i3 = 0;
                        }
                    }
                    this.lastIndex = i3;
                    this.lastId = flowableFlatMap$InnerSubscriberArr2[i3].f4368id;
                }
                int i5 = i3;
                boolean z4 = false;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        flowableFlatMap$InnerSubscriberArr = flowableFlatMap$InnerSubscriberArr2;
                        z = z4;
                        break;
                    } else if (checkTerminate()) {
                        return;
                    } else {
                        FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber = flowableFlatMap$InnerSubscriberArr2[i5];
                        U u = null;
                        while (!checkTerminate()) {
                            t70<U> t70Var = flowableFlatMap$InnerSubscriber.queue;
                            flowableFlatMap$InnerSubscriberArr = flowableFlatMap$InnerSubscriberArr2;
                            int i7 = length;
                            if (t70Var != null) {
                                long j9 = j5;
                                while (j4 != j5) {
                                    try {
                                        u = t70Var.mo4868poll();
                                        if (u == null) {
                                            break;
                                        }
                                        s51Var.onNext(u);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        j4--;
                                        j9++;
                                    } catch (Throwable th) {
                                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                                        flowableFlatMap$InnerSubscriber.dispose();
                                        this.errs.addThrowable(th);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        removeInner(flowableFlatMap$InnerSubscriber);
                                        i6++;
                                        length = i7;
                                        z4 = true;
                                    }
                                }
                                if (j9 != j5) {
                                    j4 = !z2 ? this.requested.addAndGet(-j9) : Long.MAX_VALUE;
                                    flowableFlatMap$InnerSubscriber.requestMore(j9);
                                    j3 = 0;
                                } else {
                                    j3 = j5;
                                }
                                if (j4 != j3 && u != null) {
                                    flowableFlatMap$InnerSubscriberArr2 = flowableFlatMap$InnerSubscriberArr;
                                    length = i7;
                                    j5 = 0;
                                }
                            }
                            boolean z5 = flowableFlatMap$InnerSubscriber.done;
                            t70<U> t70Var2 = flowableFlatMap$InnerSubscriber.queue;
                            if (z5 && (t70Var2 == null || t70Var2.isEmpty())) {
                                removeInner(flowableFlatMap$InnerSubscriber);
                                if (checkTerminate()) {
                                    return;
                                }
                                j6++;
                                z4 = true;
                            }
                            if (j4 == 0) {
                                z = z4;
                                break;
                            }
                            i5++;
                            length = i7;
                            if (i5 == length) {
                                i5 = 0;
                            }
                            i6++;
                            flowableFlatMap$InnerSubscriberArr2 = flowableFlatMap$InnerSubscriberArr;
                            j5 = 0;
                        }
                        return;
                    }
                }
            }
            j = 0;
            j2 = j6;
            z = false;
            if (j2 != j && !this.cancelled) {
                this.f4369s.request(j2);
            }
            if (z) {
                i = i2;
            } else {
                i = addAndGet(-i2);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    public t70<U> getInnerQueue(FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber) {
        t70<U> t70Var = flowableFlatMap$InnerSubscriber.queue;
        if (t70Var == null) {
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.bufferSize);
            flowableFlatMap$InnerSubscriber.queue = spscArrayQueue;
            return spscArrayQueue;
        }
        return t70Var;
    }

    public t70<U> getMainQueue() {
        s70<U> s70Var = this.queue;
        if (s70Var == null) {
            s70Var = this.maxConcurrency == Integer.MAX_VALUE ? new sc0<>(this.bufferSize) : new SpscArrayQueue<>(this.maxConcurrency);
            this.queue = s70Var;
        }
        return s70Var;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.done) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        } else if (!this.errs.addThrowable(th)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        } else {
            this.done = true;
            drain();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            r51<? extends U> apply = this.mapper.apply(t);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper returned a null Publisher");
            r51<? extends U> r51Var = apply;
            if (!(r51Var instanceof Callable)) {
                long j = this.uniqueId;
                this.uniqueId = 1 + j;
                FlowableFlatMap$InnerSubscriber flowableFlatMap$InnerSubscriber = new FlowableFlatMap$InnerSubscriber(this, j);
                addInner(flowableFlatMap$InnerSubscriber);
                r51Var.subscribe(flowableFlatMap$InnerSubscriber);
                return;
            }
            try {
                Object call = ((Callable) r51Var).call();
                if (call != null) {
                    tryEmitScalar(call);
                } else if (this.maxConcurrency == Integer.MAX_VALUE || this.cancelled) {
                } else {
                    int i = this.scalarEmitted + 1;
                    this.scalarEmitted = i;
                    int i2 = this.scalarLimit;
                    if (i != i2) {
                        return;
                    }
                    this.scalarEmitted = 0;
                    this.f4369s.request(i2);
                }
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.errs.addThrowable(th);
                drain();
            }
        } catch (Throwable th2) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            this.f4369s.cancel();
            onError(th2);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4369s, t51Var)) {
            this.f4369s = t51Var;
            this.actual.onSubscribe(this);
            if (this.cancelled) {
                return;
            }
            int i = this.maxConcurrency;
            t51Var.request(i == Integer.MAX_VALUE ? Long.MAX_VALUE : i);
        }
    }

    public void removeInner(FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber) {
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr;
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr2;
        do {
            flowableFlatMap$InnerSubscriberArr = this.subscribers.get();
            if (flowableFlatMap$InnerSubscriberArr == CANCELLED || flowableFlatMap$InnerSubscriberArr == EMPTY) {
                return;
            }
            int length = flowableFlatMap$InnerSubscriberArr.length;
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (flowableFlatMap$InnerSubscriberArr[i2] == flowableFlatMap$InnerSubscriber) {
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
                flowableFlatMap$InnerSubscriberArr2 = EMPTY;
            } else {
                FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr3 = new FlowableFlatMap$InnerSubscriber[length - 1];
                System.arraycopy(flowableFlatMap$InnerSubscriberArr, 0, flowableFlatMap$InnerSubscriberArr3, 0, i);
                System.arraycopy(flowableFlatMap$InnerSubscriberArr, i + 1, flowableFlatMap$InnerSubscriberArr3, i, (length - i) - 1);
                flowableFlatMap$InnerSubscriberArr2 = flowableFlatMap$InnerSubscriberArr3;
            }
        } while (!this.subscribers.compareAndSet(flowableFlatMap$InnerSubscriberArr, flowableFlatMap$InnerSubscriberArr2));
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
            drain();
        }
    }

    public void tryEmit(U u, FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber) {
        MissingBackpressureException missingBackpressureException;
        if (get() != 0 || !compareAndSet(0, 1)) {
            t70 t70Var = flowableFlatMap$InnerSubscriber.queue;
            if (t70Var == null) {
                t70Var = new SpscArrayQueue(this.bufferSize);
                flowableFlatMap$InnerSubscriber.queue = t70Var;
            }
            if (!t70Var.offer(u)) {
                missingBackpressureException = new MissingBackpressureException("Inner queue full?!");
                onError(missingBackpressureException);
                return;
            }
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }
        long j = this.requested.get();
        t70<U> t70Var2 = flowableFlatMap$InnerSubscriber.queue;
        if (j == 0 || (t70Var2 != null && !t70Var2.isEmpty())) {
            if (t70Var2 == null) {
                t70Var2 = getInnerQueue(flowableFlatMap$InnerSubscriber);
            }
            if (!t70Var2.offer(u)) {
                missingBackpressureException = new MissingBackpressureException("Inner queue full?!");
                onError(missingBackpressureException);
                return;
            }
        } else {
            this.actual.onNext(u);
            if (j != Long.MAX_VALUE) {
                this.requested.decrementAndGet();
            }
            flowableFlatMap$InnerSubscriber.requestMore(1L);
        }
        if (decrementAndGet() == 0) {
            return;
        }
        drainLoop();
    }

    public void tryEmitScalar(U u) {
        IllegalStateException illegalStateException;
        if (get() != 0 || !compareAndSet(0, 1)) {
            if (!getMainQueue().offer(u)) {
                illegalStateException = new IllegalStateException("Scalar queue full?!");
                onError(illegalStateException);
                return;
            }
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }
        long j = this.requested.get();
        t70<U> t70Var = this.queue;
        if (j == 0 || (t70Var != null && !t70Var.isEmpty())) {
            if (t70Var == null) {
                t70Var = getMainQueue();
            }
            if (!t70Var.offer(u)) {
                illegalStateException = new IllegalStateException("Scalar queue full?!");
                onError(illegalStateException);
                return;
            }
        } else {
            this.actual.onNext(u);
            if (j != Long.MAX_VALUE) {
                this.requested.decrementAndGet();
            }
            if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                int i = this.scalarEmitted + 1;
                this.scalarEmitted = i;
                int i2 = this.scalarLimit;
                if (i == i2) {
                    this.scalarEmitted = 0;
                    this.f4369s.request(i2);
                }
            }
        }
        if (decrementAndGet() == 0) {
            return;
        }
        drainLoop();
    }
}
