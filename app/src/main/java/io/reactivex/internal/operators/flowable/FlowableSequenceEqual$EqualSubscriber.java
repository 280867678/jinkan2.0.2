package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.q70;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.t70;
import me.tvspark.t80;

/* loaded from: classes4.dex */
public final class FlowableSequenceEqual$EqualSubscriber<T> extends AtomicReference<t51> implements s51<T> {
    public static final long serialVersionUID = 4804128302091633067L;
    public volatile boolean done;
    public final int limit;
    public final t80 parent;
    public final int prefetch;
    public long produced;
    public volatile t70<T> queue;
    public int sourceMode;

    public FlowableSequenceEqual$EqualSubscriber(t80 t80Var, int i) {
        this.parent = t80Var;
        this.limit = i - (i >> 2);
        this.prefetch = i;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void clear() {
        t70<T> t70Var = this.queue;
        if (t70Var != null) {
            t70Var.clear();
        }
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.parent.innerError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.sourceMode != 0 || this.queue.offer(t)) {
            this.parent.drain();
        } else {
            onError(new MissingBackpressureException());
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this, t51Var)) {
            if (t51Var instanceof q70) {
                q70 q70Var = (q70) t51Var;
                int requestFusion = q70Var.requestFusion(3);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = q70Var;
                    this.done = true;
                    this.parent.drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = q70Var;
                    t51Var.request(this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            t51Var.request(this.prefetch);
        }
    }

    public void request() {
        if (this.sourceMode != 1) {
            long j = this.produced + 1;
            if (j < this.limit) {
                this.produced = j;
                return;
            }
            this.produced = 0L;
            get().request(j);
        }
    }
}
