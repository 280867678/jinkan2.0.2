package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.bd0;
import me.tvspark.q70;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.t70;

/* loaded from: classes4.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<t51> implements s51<T>, t51 {
    public static final long serialVersionUID = 22876611072430776L;
    public volatile boolean done;
    public int fusionMode;
    public final int limit;
    public final bd0<T> parent;
    public final int prefetch;
    public long produced;
    public volatile t70<T> queue;

    public InnerQueuedSubscriber(bd0<T> bd0Var, int i) {
        this.parent = bd0Var;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    @Override // me.tvspark.t51
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.parent.innerError(this, th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t);
        } else {
            this.parent.drain();
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this, t51Var)) {
            long j = Long.MAX_VALUE;
            if (t51Var instanceof q70) {
                q70 q70Var = (q70) t51Var;
                int requestFusion = q70Var.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = q70Var;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = q70Var;
                    int i = this.prefetch;
                    if (i >= 0) {
                        j = i;
                    }
                    t51Var.request(j);
                    return;
                }
            }
            this.queue = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.prefetch);
            int i2 = this.prefetch;
            if (i2 >= 0) {
                j = i2;
            }
            t51Var.request(j);
        }
    }

    public t70<T> queue() {
        return this.queue;
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (this.fusionMode != 1) {
            long j2 = this.produced + j;
            if (j2 < this.limit) {
                this.produced = j2;
                return;
            }
            this.produced = 0L;
            get().request(j2);
        }
    }

    public void requestOne() {
        if (this.fusionMode != 1) {
            long j = this.produced + 1;
            if (j != this.limit) {
                this.produced = j;
                return;
            }
            this.produced = 0L;
            get().request(j);
        }
    }

    public void setDone() {
        this.done = true;
    }
}
