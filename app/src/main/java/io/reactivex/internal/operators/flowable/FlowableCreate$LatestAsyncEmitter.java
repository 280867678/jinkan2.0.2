package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.r40;
import me.tvspark.s51;

/* loaded from: classes4.dex */
public final class FlowableCreate$LatestAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    public static final long serialVersionUID = 4023437720691792495L;
    public volatile boolean done;
    public Throwable error;
    public final AtomicReference<T> queue = new AtomicReference<>();
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableCreate$LatestAsyncEmitter(s51<? super T> s51Var) {
        super(s51Var);
    }

    public void drain() {
        boolean z;
        int i;
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        s51<? super T> s51Var = this.actual;
        AtomicReference<T> atomicReference = this.queue;
        int i2 = 1;
        do {
            long j = get();
            long j2 = 0;
            while (true) {
                z = false;
                i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i == 0) {
                    break;
                } else if (isCancelled()) {
                    atomicReference.lazySet(null);
                    return;
                } else {
                    boolean z2 = this.done;
                    Object obj = (T) atomicReference.getAndSet(null);
                    boolean z3 = obj == null;
                    if (z2 && z3) {
                        Throwable th = this.error;
                        if (th != null) {
                            super.onError(th);
                            return;
                        } else {
                            super.onComplete();
                            return;
                        }
                    } else if (z3) {
                        break;
                    } else {
                        s51Var.onNext(obj);
                        j2++;
                    }
                }
            }
            if (i == 0) {
                if (isCancelled()) {
                    atomicReference.lazySet(null);
                    return;
                }
                boolean z4 = this.done;
                if (atomicReference.get() == null) {
                    z = true;
                }
                if (z4 && z) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        super.onError(th2);
                        return;
                    } else {
                        super.onComplete();
                        return;
                    }
                }
            }
            if (j2 != 0) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j2);
            }
            i2 = this.wip.addAndGet(-i2);
        } while (i2 != 0);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter, me.tvspark.w50
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter, me.tvspark.w50
    public void onError(Throwable th) {
        if (this.done || isCancelled()) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        if (th == null) {
            onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
        }
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // me.tvspark.w50
    public void onNext(T t) {
        if (this.done || isCancelled()) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        this.queue.set(t);
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public void onRequested() {
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public void onUnsubscribed() {
        if (this.wip.getAndIncrement() == 0) {
            this.queue.lazySet(null);
        }
    }
}
