package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.q70;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.t70;

/* loaded from: classes4.dex */
public final class FlowableZip$ZipSubscriber<T, R> extends AtomicReference<t51> implements s51<T>, t51 {
    public static final long serialVersionUID = -4627193790118206028L;
    public volatile boolean done;
    public final int index;
    public final int limit;
    public final FlowableZip$ZipCoordinator<T, R> parent;
    public final int prefetch;
    public long produced;
    public t70<T> queue;
    public int sourceMode;

    public FlowableZip$ZipSubscriber(FlowableZip$ZipCoordinator<T, R> flowableZip$ZipCoordinator, int i, int i2) {
        this.parent = flowableZip$ZipCoordinator;
        this.prefetch = i;
        this.index = i2;
        this.limit = i - (i >> 2);
    }

    @Override // me.tvspark.t51
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.parent.error(this, th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.sourceMode != 2) {
            this.queue.offer(t);
        }
        this.parent.drain();
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

    @Override // me.tvspark.t51
    public void request(long j) {
        if (this.sourceMode != 1) {
            long j2 = this.produced + j;
            if (j2 < this.limit) {
                this.produced = j2;
                return;
            }
            this.produced = 0L;
            get().request(j2);
        }
    }
}
