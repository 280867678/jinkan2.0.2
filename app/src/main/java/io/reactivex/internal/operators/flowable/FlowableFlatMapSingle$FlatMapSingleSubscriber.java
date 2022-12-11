package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.m60;
import me.tvspark.n60;
import me.tvspark.o60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.sc0;
import me.tvspark.t51;
import me.tvspark.x50;

/* loaded from: classes4.dex */
public final class FlowableFlatMapSingle$FlatMapSingleSubscriber<T, R> extends AtomicInteger implements s51<T>, t51 {
    public static final long serialVersionUID = 8600231336733376951L;
    public final s51<? super R> actual;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public final f70<? super T, ? extends n60<? extends R>> mapper;
    public final int maxConcurrency;

    /* renamed from: s */
    public t51 f4373s;
    public final AtomicLong requested = new AtomicLong();
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
            FlowableFlatMapSingle$FlatMapSingleSubscriber.this.innerError(this, th);
        }

        @Override // me.tvspark.m60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this, p60Var);
        }

        @Override // me.tvspark.m60
        public void onSuccess(R r) {
            FlowableFlatMapSingle$FlatMapSingleSubscriber.this.innerSuccess(this, r);
        }
    }

    public FlowableFlatMapSingle$FlatMapSingleSubscriber(s51<? super R> s51Var, f70<? super T, ? extends n60<? extends R>> f70Var, boolean z, int i) {
        this.actual = s51Var;
        this.mapper = f70Var;
        this.delayErrors = z;
        this.maxConcurrency = i;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        this.cancelled = true;
        this.f4373s.cancel();
        this.set.dispose();
    }

    public void clear() {
        sc0<R> sc0Var = this.queue.get();
        if (sc0Var != null) {
            sc0Var.clear();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
        r2 = r17.errors.terminate();
        clear();
        r1.onError(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
        if (r13 != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007b, code lost:
        if (r17.cancelled == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0083, code lost:
        if (r17.delayErrors != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008d, code lost:
        if (r17.errors.get() == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0094, code lost:
        if (r2.get() != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0096, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
        r7 = r3.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009f, code lost:
        if (r7 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a5, code lost:
        if (r7.isEmpty() == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a8, code lost:
        if (r6 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00aa, code lost:
        if (r12 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ac, code lost:
        r2 = r17.errors.terminate();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b2, code lost:
        if (r2 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b4, code lost:
        r1.onError(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b8, code lost:
        r1.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00bb, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a7, code lost:
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0098, code lost:
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x007d, code lost:
        clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0080, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00be, code lost:
        if (r10 == 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c0, code lost:
        me.tvspark.r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r17.requested, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ca, code lost:
        if (r17.maxConcurrency == Integer.MAX_VALUE) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00cc, code lost:
        r17.f4373s.request(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00d1, code lost:
        r5 = addAndGet(-r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drainLoop() {
        s51<? super R> s51Var = this.actual;
        AtomicInteger atomicInteger = this.active;
        AtomicReference<sc0<R>> atomicReference = this.queue;
        int i = 1;
        loop0: do {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                boolean z = false;
                int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i2 != 0) {
                    if (!this.cancelled) {
                        if (!this.delayErrors && this.errors.get() != null) {
                            break loop0;
                        }
                        boolean z2 = atomicInteger.get() == 0;
                        sc0<R> sc0Var = atomicReference.get();
                        R mo4868poll = sc0Var != null ? sc0Var.mo4868poll() : (Object) null;
                        boolean z3 = mo4868poll == null;
                        if (z2 && z3) {
                            Throwable terminate = this.errors.terminate();
                            if (terminate != null) {
                                s51Var.onError(terminate);
                                return;
                            } else {
                                s51Var.onComplete();
                                return;
                            }
                        } else if (z3) {
                            break;
                        } else {
                            s51Var.onNext(mo4868poll);
                            j2++;
                        }
                    } else {
                        clear();
                        return;
                    }
                } else {
                    break;
                }
            }
        } while (i != 0);
    }

    public sc0<R> getOrCreateQueue() {
        sc0<R> sc0Var;
        do {
            sc0<R> sc0Var2 = this.queue.get();
            if (sc0Var2 != null) {
                return sc0Var2;
            }
            sc0Var = new sc0<>(x50.Wwwwwwwwwwwwwwwwwwwwwwww);
        } while (!this.queue.compareAndSet(null, sc0Var));
        return sc0Var;
    }

    public void innerError(FlowableFlatMapSingle$FlatMapSingleSubscriber<T, R>.InnerObserver innerObserver, Throwable th) {
        this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerObserver);
        if (!this.errors.addThrowable(th)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        if (!this.delayErrors) {
            this.f4373s.cancel();
            this.set.dispose();
        }
        this.active.decrementAndGet();
        drain();
    }

    public void innerSuccess(FlowableFlatMapSingle$FlatMapSingleSubscriber<T, R>.InnerObserver innerObserver, R r) {
        this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerObserver);
        if (get() == 0) {
            boolean z = true;
            if (compareAndSet(0, 1)) {
                if (this.active.decrementAndGet() != 0) {
                    z = false;
                }
                if (this.requested.get() != 0) {
                    this.actual.onNext(r);
                    sc0<R> sc0Var = this.queue.get();
                    if (z && (sc0Var == null || sc0Var.isEmpty())) {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            this.actual.onError(terminate);
                            return;
                        } else {
                            this.actual.onComplete();
                            return;
                        }
                    }
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, 1L);
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.f4373s.request(1L);
                    }
                } else {
                    sc0<R> orCreateQueue = getOrCreateQueue();
                    synchronized (orCreateQueue) {
                        orCreateQueue.offer(r);
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
                drainLoop();
            }
        }
        sc0<R> orCreateQueue2 = getOrCreateQueue();
        synchronized (orCreateQueue2) {
            orCreateQueue2.offer(r);
        }
        this.active.decrementAndGet();
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.active.decrementAndGet();
        drain();
    }

    @Override // me.tvspark.s51
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

    @Override // me.tvspark.s51
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
            this.f4373s.cancel();
            onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4373s, t51Var)) {
            this.f4373s = t51Var;
            this.actual.onSubscribe(this);
            int i = this.maxConcurrency;
            t51Var.request(i == Integer.MAX_VALUE ? Long.MAX_VALUE : i);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
            drain();
        }
    }
}
