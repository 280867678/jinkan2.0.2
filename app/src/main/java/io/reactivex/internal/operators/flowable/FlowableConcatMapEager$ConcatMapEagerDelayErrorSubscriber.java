package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.bd0;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.sc0;
import me.tvspark.t51;
import me.tvspark.t70;

/* loaded from: classes4.dex */
public final class FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements s51<T>, t51, bd0<R> {
    public static final long serialVersionUID = -4255299542215038287L;
    public final s51<? super R> actual;
    public volatile boolean cancelled;
    public volatile InnerQueuedSubscriber<R> current;
    public volatile boolean done;
    public final ErrorMode errorMode;
    public final f70<? super T, ? extends r51<? extends R>> mapper;
    public final int maxConcurrency;
    public final int prefetch;

    /* renamed from: s */
    public t51 f4363s;
    public final sc0<InnerQueuedSubscriber<R>> subscribers;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final AtomicLong requested = new AtomicLong();

    public FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber(s51<? super R> s51Var, f70<? super T, ? extends r51<? extends R>> f70Var, int i, int i2, ErrorMode errorMode) {
        this.actual = s51Var;
        this.mapper = f70Var;
        this.maxConcurrency = i;
        this.prefetch = i2;
        this.errorMode = errorMode;
        this.subscribers = new sc0<>(Math.min(i2, i));
    }

    @Override // me.tvspark.t51
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.f4363s.cancel();
        drainAndCancel();
    }

    public void cancelAll() {
        while (true) {
            InnerQueuedSubscriber<R> mo4868poll = this.subscribers.mo4868poll();
            if (mo4868poll != null) {
                mo4868poll.cancel();
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00cd, code lost:
        if (r17 != 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d1, code lost:
        if (r19.cancelled == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d9, code lost:
        if (r3 != io.reactivex.internal.util.ErrorMode.IMMEDIATE) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e3, code lost:
        if (r19.errors.get() == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e5, code lost:
        r19.current = null;
        r8.cancel();
        cancelAll();
        r2.onError(r19.errors.terminate());
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f6, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f7, code lost:
        r15 = r8.isDone();
        r12 = r12.isEmpty();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ff, code lost:
        if (r15 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0101, code lost:
        if (r12 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0103, code lost:
        r19.current = null;
        r19.f4363s.request(1);
        r8 = null;
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d3, code lost:
        cancelAll();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d6, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00cc, code lost:
        r0 = false;
     */
    @Override // me.tvspark.bd0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        InnerQueuedSubscriber<R> innerQueuedSubscriber;
        int i;
        long j;
        boolean z;
        t70<R> queue;
        if (getAndIncrement() != 0) {
            return;
        }
        InnerQueuedSubscriber<R> innerQueuedSubscriber2 = this.current;
        s51<? super R> s51Var = this.actual;
        ErrorMode errorMode = this.errorMode;
        int i2 = 1;
        while (true) {
            long j2 = this.requested.get();
            if (innerQueuedSubscriber2 != null) {
                innerQueuedSubscriber = innerQueuedSubscriber2;
            } else if (errorMode != ErrorMode.END && this.errors.get() != null) {
                cancelAll();
                s51Var.onError(this.errors.terminate());
                return;
            } else {
                boolean z2 = this.done;
                innerQueuedSubscriber = this.subscribers.mo4868poll();
                if (z2 && innerQueuedSubscriber == null) {
                    Throwable terminate = this.errors.terminate();
                    if (terminate != null) {
                        s51Var.onError(terminate);
                        return;
                    } else {
                        s51Var.onComplete();
                        return;
                    }
                } else if (innerQueuedSubscriber != null) {
                    this.current = innerQueuedSubscriber;
                }
            }
            if (innerQueuedSubscriber == null || (queue = innerQueuedSubscriber.queue()) == null) {
                i = i2;
                j = 0;
                z = false;
            } else {
                i = i2;
                j = 0;
                while (true) {
                    int i3 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i3 == 0) {
                        break;
                    } else if (this.cancelled) {
                        cancelAll();
                        return;
                    } else if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                        this.current = null;
                        innerQueuedSubscriber.cancel();
                        cancelAll();
                        s51Var.onError(this.errors.terminate());
                        return;
                    } else {
                        boolean isDone = innerQueuedSubscriber.isDone();
                        try {
                            R mo4868poll = queue.mo4868poll();
                            boolean z3 = mo4868poll == null;
                            if (isDone && z3) {
                                this.current = null;
                                this.f4363s.request(1L);
                                innerQueuedSubscriber = null;
                                z = true;
                                break;
                            } else if (z3) {
                                break;
                            } else {
                                s51Var.onNext(mo4868poll);
                                j++;
                                innerQueuedSubscriber.requestOne();
                            }
                        } catch (Throwable th) {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                            this.current = null;
                            innerQueuedSubscriber.cancel();
                            cancelAll();
                            s51Var.onError(th);
                            return;
                        }
                    }
                }
            }
            if (j != 0 && j2 != Long.MAX_VALUE) {
                this.requested.addAndGet(-j);
            }
            if (z) {
                innerQueuedSubscriber2 = innerQueuedSubscriber;
                i2 = i;
            } else {
                i2 = addAndGet(-i);
                if (i2 == 0) {
                    return;
                }
                innerQueuedSubscriber2 = innerQueuedSubscriber;
            }
        }
    }

    public void drainAndCancel() {
        if (getAndIncrement() == 0) {
            do {
                cancelAll();
            } while (decrementAndGet() != 0);
        }
    }

    @Override // me.tvspark.bd0
    public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
        innerQueuedSubscriber.setDone();
        drain();
    }

    @Override // me.tvspark.bd0
    public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
        if (!this.errors.addThrowable(th)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        innerQueuedSubscriber.setDone();
        if (this.errorMode != ErrorMode.END) {
            this.f4363s.cancel();
        }
        drain();
    }

    @Override // me.tvspark.bd0
    public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r) {
        if (innerQueuedSubscriber.queue().offer(r)) {
            drain();
            return;
        }
        innerQueuedSubscriber.cancel();
        innerError(innerQueuedSubscriber, new MissingBackpressureException());
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (!this.errors.addThrowable(th)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        try {
            r51<? extends R> apply = this.mapper.apply(t);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper returned a null Publisher");
            r51<? extends R> r51Var = apply;
            InnerQueuedSubscriber<R> innerQueuedSubscriber = new InnerQueuedSubscriber<>(this, this.prefetch);
            if (this.cancelled) {
                return;
            }
            this.subscribers.offer(innerQueuedSubscriber);
            if (this.cancelled) {
                return;
            }
            r51Var.subscribe(innerQueuedSubscriber);
            if (!this.cancelled) {
                return;
            }
            innerQueuedSubscriber.cancel();
            drainAndCancel();
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            this.f4363s.cancel();
            onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4363s, t51Var)) {
            this.f4363s = t51Var;
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
