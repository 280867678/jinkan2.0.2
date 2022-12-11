package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.s70;
import me.tvspark.sc0;
import me.tvspark.w60;
import me.tvspark.y50;

/* loaded from: classes4.dex */
public final class FlowableCreate$SerializedEmitter<T> extends AtomicInteger implements y50<T> {
    public static final long serialVersionUID = 4883307006032401862L;
    public volatile boolean done;
    public final FlowableCreate$BaseEmitter<T> emitter;
    public final AtomicThrowable error = new AtomicThrowable();
    public final s70<T> queue = new sc0(16);

    public FlowableCreate$SerializedEmitter(FlowableCreate$BaseEmitter<T> flowableCreate$BaseEmitter) {
        this.emitter = flowableCreate$BaseEmitter;
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        FlowableCreate$BaseEmitter<T> flowableCreate$BaseEmitter = this.emitter;
        s70<T> s70Var = this.queue;
        AtomicThrowable atomicThrowable = this.error;
        int i = 1;
        while (!flowableCreate$BaseEmitter.isCancelled()) {
            if (atomicThrowable.get() != null) {
                s70Var.clear();
                flowableCreate$BaseEmitter.onError(atomicThrowable.terminate());
                return;
            }
            boolean z = this.done;
            T mo4868poll = s70Var.mo4868poll();
            boolean z2 = mo4868poll == null;
            if (z && z2) {
                flowableCreate$BaseEmitter.onComplete();
                return;
            } else if (z2) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                flowableCreate$BaseEmitter.onNext(mo4868poll);
            }
        }
        s70Var.clear();
    }

    public boolean isCancelled() {
        return this.emitter.isCancelled();
    }

    @Override // me.tvspark.w50
    public void onComplete() {
        if (this.emitter.isCancelled() || this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // me.tvspark.w50
    public void onError(Throwable th) {
        if (this.emitter.isCancelled() || this.done) {
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
        if (this.emitter.isCancelled() || this.done) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            s70<T> s70Var = this.queue;
            synchronized (s70Var) {
                s70Var.offer(t);
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

    public long requested() {
        return this.emitter.requested();
    }

    public y50<T> serialize() {
        return this;
    }

    public void setCancellable(w60 w60Var) {
        this.emitter.setCancellable(w60Var);
    }

    public void setDisposable(p60 p60Var) {
        this.emitter.setDisposable(p60Var);
    }
}
