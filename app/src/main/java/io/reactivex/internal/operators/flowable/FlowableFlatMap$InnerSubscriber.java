package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.q70;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.t70;

/* loaded from: classes4.dex */
public final class FlowableFlatMap$InnerSubscriber<T, U> extends AtomicReference<t51> implements s51<U>, p60 {
    public static final long serialVersionUID = -4606175640614850599L;
    public final int bufferSize;
    public volatile boolean done;
    public int fusionMode;

    /* renamed from: id */
    public final long f4368id;
    public final int limit;
    public final FlowableFlatMap$MergeSubscriber<T, U> parent;
    public long produced;
    public volatile t70<U> queue;

    public FlowableFlatMap$InnerSubscriber(FlowableFlatMap$MergeSubscriber<T, U> flowableFlatMap$MergeSubscriber, long j) {
        this.f4368id = j;
        this.parent = flowableFlatMap$MergeSubscriber;
        int i = flowableFlatMap$MergeSubscriber.bufferSize;
        this.bufferSize = i;
        this.limit = i >> 2;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (!this.parent.errs.addThrowable(th)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.done = true;
        this.parent.drain();
    }

    @Override // me.tvspark.s51
    public void onNext(U u) {
        if (this.fusionMode != 2) {
            this.parent.tryEmit(u, this);
        } else {
            this.parent.drain();
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this, t51Var)) {
            if (t51Var instanceof q70) {
                q70 q70Var = (q70) t51Var;
                int requestFusion = q70Var.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = q70Var;
                    this.done = true;
                    this.parent.drain();
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = q70Var;
                }
            }
            t51Var.request(this.bufferSize);
        }
    }

    public void requestMore(long j) {
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
}
