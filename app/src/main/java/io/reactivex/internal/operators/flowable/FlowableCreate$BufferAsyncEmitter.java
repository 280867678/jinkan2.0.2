package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.sc0;

/* loaded from: classes4.dex */
public final class FlowableCreate$BufferAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    public static final long serialVersionUID = 2427151001689639875L;
    public volatile boolean done;
    public Throwable error;
    public final sc0<T> queue;
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableCreate$BufferAsyncEmitter(s51<? super T> s51Var, int i) {
        super(s51Var);
        this.queue = new sc0<>(i);
    }

    public void drain() {
        int i;
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        s51<? super T> s51Var = this.actual;
        sc0<T> sc0Var = this.queue;
        int i2 = 1;
        do {
            long j = get();
            long j2 = 0;
            while (true) {
                i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i == 0) {
                    break;
                } else if (isCancelled()) {
                    sc0Var.clear();
                    return;
                } else {
                    boolean z = this.done;
                    Object obj = (T) sc0Var.mo4868poll();
                    boolean z2 = obj == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            super.onError(th);
                            return;
                        } else {
                            super.onComplete();
                            return;
                        }
                    } else if (z2) {
                        break;
                    } else {
                        s51Var.onNext(obj);
                        j2++;
                    }
                }
            }
            if (i == 0) {
                if (isCancelled()) {
                    sc0Var.clear();
                    return;
                }
                boolean z3 = this.done;
                boolean isEmpty = sc0Var.isEmpty();
                if (z3 && isEmpty) {
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
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
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
        this.queue.offer(t);
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public void onRequested() {
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public void onUnsubscribed() {
        if (this.wip.getAndIncrement() == 0) {
            this.queue.clear();
        }
    }
}
